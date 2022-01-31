package com.google.firebase.database.connection;

import com.google.firebase.database.connection.Connection;
import com.google.firebase.database.connection.ConnectionAuthTokenProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.util.GAuthToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class PersistentConnectionImpl implements Connection.Delegate, PersistentConnection {
    private static final String IDLE_INTERRUPT_REASON = "connection_idle";
    private static final long IDLE_TIMEOUT = 60000;
    private static final long INVALID_AUTH_TOKEN_THRESHOLD = 3;
    private static final String REQUEST_ACTION = "a";
    private static final String REQUEST_ACTION_AUTH = "auth";
    private static final String REQUEST_ACTION_GAUTH = "gauth";
    private static final String REQUEST_ACTION_MERGE = "m";
    private static final String REQUEST_ACTION_ONDISCONNECT_CANCEL = "oc";
    private static final String REQUEST_ACTION_ONDISCONNECT_MERGE = "om";
    private static final String REQUEST_ACTION_ONDISCONNECT_PUT = "o";
    private static final String REQUEST_ACTION_PUT = "p";
    private static final String REQUEST_ACTION_QUERY = "q";
    private static final String REQUEST_ACTION_QUERY_UNLISTEN = "n";
    private static final String REQUEST_ACTION_STATS = "s";
    private static final String REQUEST_ACTION_UNAUTH = "unauth";
    private static final String REQUEST_AUTHVAR = "authvar";
    private static final String REQUEST_COMPOUND_HASH = "ch";
    private static final String REQUEST_COMPOUND_HASH_HASHES = "hs";
    private static final String REQUEST_COMPOUND_HASH_PATHS = "ps";
    private static final String REQUEST_COUNTERS = "c";
    private static final String REQUEST_CREDENTIAL = "cred";
    private static final String REQUEST_DATA_HASH = "h";
    private static final String REQUEST_DATA_PAYLOAD = "d";
    private static final String REQUEST_ERROR = "error";
    private static final String REQUEST_NUMBER = "r";
    private static final String REQUEST_PATH = "p";
    private static final String REQUEST_PAYLOAD = "b";
    private static final String REQUEST_QUERIES = "q";
    private static final String REQUEST_STATUS = "s";
    private static final String REQUEST_TAG = "t";
    private static final String RESPONSE_FOR_REQUEST = "b";
    private static final String SERVER_ASYNC_ACTION = "a";
    private static final String SERVER_ASYNC_AUTH_REVOKED = "ac";
    private static final String SERVER_ASYNC_DATA_MERGE = "m";
    private static final String SERVER_ASYNC_DATA_RANGE_MERGE = "rm";
    private static final String SERVER_ASYNC_DATA_UPDATE = "d";
    private static final String SERVER_ASYNC_LISTEN_CANCELLED = "c";
    private static final String SERVER_ASYNC_PAYLOAD = "b";
    private static final String SERVER_ASYNC_SECURITY_DEBUG = "sd";
    private static final String SERVER_DATA_END_PATH = "e";
    private static final String SERVER_DATA_RANGE_MERGE = "m";
    private static final String SERVER_DATA_START_PATH = "s";
    private static final String SERVER_DATA_TAG = "t";
    private static final String SERVER_DATA_UPDATE_BODY = "d";
    private static final String SERVER_DATA_UPDATE_PATH = "p";
    private static final String SERVER_DATA_WARNINGS = "w";
    private static final String SERVER_KILL_INTERRUPT_REASON = "server_kill";
    private static final String SERVER_RESPONSE_DATA = "d";
    private static final long SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY = 30000;
    private static final String TOKEN_REFRESH_INTERRUPT_REASON = "token_refresh";
    private static long connectionIds;
    private String authToken;
    private final ConnectionAuthTokenProvider authTokenProvider;
    private String cachedHost;
    private ConnectionState connectionState = ConnectionState.Disconnected;
    private final ConnectionContext context;
    private long currentGetTokenAttempt = 0;
    private final PersistentConnection.Delegate delegate;
    private final ScheduledExecutorService executorService;
    private boolean firstConnection = true;
    private boolean forceAuthTokenRefresh;
    private boolean hasOnDisconnects;
    private final HostInfo hostInfo;
    private ScheduledFuture<?> inactivityTimer = null;
    private HashSet<String> interruptReasons = new HashSet<>();
    private int invalidAuthTokenCount = 0;
    private long lastConnectionEstablishedTime;
    private String lastSessionId;
    private long lastWriteTimestamp;
    private Map<ListenQuerySpec, OutstandingListen> listens;
    private final LogWrapper logger;
    private List<OutstandingDisconnect> onDisconnectRequestQueue;
    private Map<Long, OutstandingPut> outstandingPuts;
    private Connection realtime;
    private Map<Long, ConnectionRequestCallback> requestCBHash;
    private long requestCounter = 0;
    private final RetryHelper retryHelper;
    private long writeCounter = 0;

    public interface ConnectionRequestCallback {
        void onResponse(Map<String, Object> map);
    }

    public enum ConnectionState {
        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected
    }

    public static class ListenQuerySpec {
        private final List<String> path;
        private final Map<String, Object> queryParams;

        public ListenQuerySpec(List<String> list, Map<String, Object> map) {
            this.path = list;
            this.queryParams = map;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenQuerySpec)) {
                return false;
            }
            ListenQuerySpec listenQuerySpec = (ListenQuerySpec) obj;
            if (!this.path.equals(listenQuerySpec.path)) {
                return false;
            }
            return this.queryParams.equals(listenQuerySpec.queryParams);
        }

        public int hashCode() {
            return this.queryParams.hashCode() + (this.path.hashCode() * 31);
        }

        public String toString() {
            return ConnectionUtils.pathToString(this.path) + " (params: " + this.queryParams + ")";
        }
    }

    public static class OutstandingDisconnect {
        private final String action;
        private final Object data;
        private final RequestResultCallback onComplete;
        private final List<String> path;

        public String getAction() {
            return this.action;
        }

        public Object getData() {
            return this.data;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public List<String> getPath() {
            return this.path;
        }

        private OutstandingDisconnect(String str, List<String> list, Object obj, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.path = list;
            this.data = obj;
            this.onComplete = requestResultCallback;
        }
    }

    public static class OutstandingListen {
        private final ListenHashProvider hashFunction;
        private final ListenQuerySpec query;
        private final RequestResultCallback resultCallback;
        private final Long tag;

        public ListenHashProvider getHashFunction() {
            return this.hashFunction;
        }

        public ListenQuerySpec getQuery() {
            return this.query;
        }

        public Long getTag() {
            return this.tag;
        }

        public String toString() {
            return this.query.toString() + " (Tag: " + this.tag + ")";
        }

        private OutstandingListen(RequestResultCallback requestResultCallback, ListenQuerySpec listenQuerySpec, Long l, ListenHashProvider listenHashProvider) {
            this.resultCallback = requestResultCallback;
            this.query = listenQuerySpec;
            this.hashFunction = listenHashProvider;
            this.tag = l;
        }
    }

    public static class OutstandingPut {
        private String action;
        private RequestResultCallback onComplete;
        private Map<String, Object> request;
        private boolean sent;

        public String getAction() {
            return this.action;
        }

        public RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public Map<String, Object> getRequest() {
            return this.request;
        }

        public void markSent() {
            this.sent = true;
        }

        public boolean wasSent() {
            return this.sent;
        }

        private OutstandingPut(String str, Map<String, Object> map, RequestResultCallback requestResultCallback) {
            this.action = str;
            this.request = map;
            this.onComplete = requestResultCallback;
        }
    }

    public PersistentConnectionImpl(ConnectionContext connectionContext, HostInfo hostInfo2, PersistentConnection.Delegate delegate2) {
        this.delegate = delegate2;
        this.context = connectionContext;
        ScheduledExecutorService executorService2 = connectionContext.getExecutorService();
        this.executorService = executorService2;
        this.authTokenProvider = connectionContext.getAuthTokenProvider();
        this.hostInfo = hostInfo2;
        this.listens = new HashMap();
        this.requestCBHash = new HashMap();
        this.outstandingPuts = new HashMap();
        this.onDisconnectRequestQueue = new ArrayList();
        this.retryHelper = new RetryHelper.Builder(executorService2, connectionContext.getLogger(), "ConnectionRetryHelper").withMinDelayAfterFailure(1000).withRetryExponent(1.3d).withMaxDelay(SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY).withJitterFactor(0.7d).build();
        long j = connectionIds;
        connectionIds = 1 + j;
        this.logger = new LogWrapper(connectionContext.getLogger(), "PersistentConnection", hj1.M("pc_", j));
        this.lastSessionId = null;
        doIdleCheck();
    }

    public static /* synthetic */ int access$1308(PersistentConnectionImpl persistentConnectionImpl) {
        int i = persistentConnectionImpl.invalidAuthTokenCount;
        persistentConnectionImpl.invalidAuthTokenCount = i + 1;
        return i;
    }

    public static /* synthetic */ long access$608(PersistentConnectionImpl persistentConnectionImpl) {
        long j = persistentConnectionImpl.currentGetTokenAttempt;
        persistentConnectionImpl.currentGetTokenAttempt = 1 + j;
        return j;
    }

    private boolean canSendWrites() {
        return this.connectionState == ConnectionState.Connected;
    }

    private void cancelSentTransactions() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, OutstandingPut>> it = this.outstandingPuts.entrySet().iterator();
        while (it.hasNext()) {
            OutstandingPut value = it.next().getValue();
            if (value.getRequest().containsKey(REQUEST_DATA_HASH) && value.wasSent()) {
                arrayList.add(value);
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((OutstandingPut) it2.next()).getOnComplete().onRequestResult("disconnected", null);
        }
    }

    private boolean connected() {
        ConnectionState connectionState2 = this.connectionState;
        return connectionState2 == ConnectionState.Authenticating || connectionState2 == ConnectionState.Connected;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void doIdleCheck() {
        if (isIdle()) {
            ScheduledFuture<?> scheduledFuture = this.inactivityTimer;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.inactivityTimer = this.executorService.schedule(new Runnable() {
                /* class com.google.firebase.database.connection.PersistentConnectionImpl.AnonymousClass7 */

                public void run() {
                    PersistentConnectionImpl.this.inactivityTimer = null;
                    if (PersistentConnectionImpl.this.idleHasTimedOut()) {
                        PersistentConnectionImpl.this.interrupt(PersistentConnectionImpl.IDLE_INTERRUPT_REASON);
                    } else {
                        PersistentConnectionImpl.this.doIdleCheck();
                    }
                }
            }, 60000, TimeUnit.MILLISECONDS);
        } else if (isInterrupted(IDLE_INTERRUPT_REASON)) {
            ConnectionUtils.hardAssert(!isIdle());
            resume(IDLE_INTERRUPT_REASON);
        }
    }

    private Map<String, Object> getPutObject(List<String> list, Object obj, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(list));
        hashMap.put("d", obj);
        if (str != null) {
            hashMap.put(REQUEST_DATA_HASH, str);
        }
        return hashMap;
    }

    private void handleTimestamp(long j) {
        if (this.logger.logsDebug()) {
            this.logger.debug("handling timestamp", new Object[0]);
        }
        long currentTimeMillis = j - System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put(Constants.DOT_INFO_SERVERTIME_OFFSET, Long.valueOf(currentTimeMillis));
        this.delegate.onServerInfoUpdate(hashMap);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private boolean idleHasTimedOut() {
        return isIdle() && System.currentTimeMillis() > this.lastWriteTimestamp + 60000;
    }

    private boolean isIdle() {
        return this.listens.isEmpty() && this.requestCBHash.isEmpty() && !this.hasOnDisconnects && this.outstandingPuts.isEmpty();
    }

    private long nextRequestNumber() {
        long j = this.requestCounter;
        this.requestCounter = 1 + j;
        return j;
    }

    private void onAuthRevoked(String str, String str2) {
        LogWrapper logWrapper = this.logger;
        logWrapper.debug("Auth token revoked: " + str + " (" + str2 + ")", new Object[0]);
        this.authToken = null;
        this.forceAuthTokenRefresh = true;
        this.delegate.onAuthStatus(false);
        this.realtime.close();
    }

    private void onDataPush(String str, Map<String, Object> map) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("handleServerMessage: " + str + " " + map, new Object[0]);
        }
        if (str.equals("d") || str.equals("m")) {
            boolean equals = str.equals("m");
            String str2 = (String) map.get("p");
            Object obj = map.get("d");
            Long longFromObject = ConnectionUtils.longFromObject(map.get("t"));
            if (!equals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                this.delegate.onDataUpdate(ConnectionUtils.stringToPath(str2), obj, equals, longFromObject);
            } else if (this.logger.logsDebug()) {
                this.logger.debug(hj1.S("ignoring empty merge for path ", str2), new Object[0]);
            }
        } else if (str.equals(SERVER_ASYNC_DATA_RANGE_MERGE)) {
            String str3 = (String) map.get("p");
            List<String> stringToPath = ConnectionUtils.stringToPath(str3);
            Object obj2 = map.get("d");
            Long longFromObject2 = ConnectionUtils.longFromObject(map.get("t"));
            ArrayList arrayList = new ArrayList();
            for (Map map2 : (List) obj2) {
                String str4 = (String) map2.get("s");
                String str5 = (String) map2.get(SERVER_DATA_END_PATH);
                List<String> list = null;
                List<String> stringToPath2 = str4 != null ? ConnectionUtils.stringToPath(str4) : null;
                if (str5 != null) {
                    list = ConnectionUtils.stringToPath(str5);
                }
                arrayList.add(new RangeMerge(stringToPath2, list, map2.get("m")));
            }
            if (!arrayList.isEmpty()) {
                this.delegate.onRangeMergeUpdate(stringToPath, arrayList, longFromObject2);
            } else if (this.logger.logsDebug()) {
                this.logger.debug(hj1.S("Ignoring empty range merge for path ", str3), new Object[0]);
            }
        } else if (str.equals("c")) {
            onListenRevoked(ConnectionUtils.stringToPath((String) map.get("p")));
        } else if (str.equals(SERVER_ASYNC_AUTH_REVOKED)) {
            onAuthRevoked((String) map.get("s"), (String) map.get("d"));
        } else if (str.equals(SERVER_ASYNC_SECURITY_DEBUG)) {
            onSecurityDebugPacket(map);
        } else if (this.logger.logsDebug()) {
            this.logger.debug(hj1.S("Unrecognized action from server: ", str), new Object[0]);
        }
    }

    private void onListenRevoked(List<String> list) {
        Collection<OutstandingListen> removeListens = removeListens(list);
        if (removeListens != null) {
            for (OutstandingListen outstandingListen : removeListens) {
                outstandingListen.resultCallback.onRequestResult("permission_denied", null);
            }
        }
    }

    private void onSecurityDebugPacket(Map<String, Object> map) {
        this.logger.info((String) map.get("msg"));
    }

    private void putInternal(String str, List<String> list, Object obj, String str2, RequestResultCallback requestResultCallback) {
        Map<String, Object> putObject = getPutObject(list, obj, str2);
        long j = this.writeCounter;
        this.writeCounter = 1 + j;
        this.outstandingPuts.put(Long.valueOf(j), new OutstandingPut(str, putObject, requestResultCallback));
        if (canSendWrites()) {
            sendPut(j);
        }
        this.lastWriteTimestamp = System.currentTimeMillis();
        doIdleCheck();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private OutstandingListen removeListen(ListenQuerySpec listenQuerySpec) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("removing query " + listenQuerySpec, new Object[0]);
        }
        if (this.listens.containsKey(listenQuerySpec)) {
            OutstandingListen outstandingListen = this.listens.get(listenQuerySpec);
            this.listens.remove(listenQuerySpec);
            doIdleCheck();
            return outstandingListen;
        } else if (!this.logger.logsDebug()) {
            return null;
        } else {
            LogWrapper logWrapper2 = this.logger;
            logWrapper2.debug("Trying to remove listener for QuerySpec " + listenQuerySpec + " but no listener exists.", new Object[0]);
            return null;
        }
    }

    private Collection<OutstandingListen> removeListens(List<String> list) {
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("removing all listens at path " + list, new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<ListenQuerySpec, OutstandingListen> entry : this.listens.entrySet()) {
            OutstandingListen value = entry.getValue();
            if (entry.getKey().path.equals(list)) {
                arrayList.add(value);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.listens.remove(((OutstandingListen) it.next()).getQuery());
        }
        doIdleCheck();
        return arrayList;
    }

    private void restoreAuth() {
        if (this.logger.logsDebug()) {
            this.logger.debug("calling restore state", new Object[0]);
        }
        ConnectionState connectionState2 = this.connectionState;
        ConnectionUtils.hardAssert(connectionState2 == ConnectionState.Connecting, "Wanted to restore auth, but was in wrong state: %s", connectionState2);
        if (this.authToken == null) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Not restoring auth because token is null.", new Object[0]);
            }
            this.connectionState = ConnectionState.Connected;
            restoreState();
            return;
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring auth.", new Object[0]);
        }
        this.connectionState = ConnectionState.Authenticating;
        sendAuthAndRestoreState();
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void restoreState() {
        ConnectionState connectionState2 = this.connectionState;
        ConnectionUtils.hardAssert(connectionState2 == ConnectionState.Connected, "Should be connected if we're restoring state, but we are: %s", connectionState2);
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring outstanding listens", new Object[0]);
        }
        for (OutstandingListen outstandingListen : this.listens.values()) {
            if (this.logger.logsDebug()) {
                LogWrapper logWrapper = this.logger;
                StringBuilder i0 = hj1.i0("Restoring listen ");
                i0.append(outstandingListen.getQuery());
                logWrapper.debug(i0.toString(), new Object[0]);
            }
            sendListen(outstandingListen);
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring writes.", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.outstandingPuts.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sendPut(((Long) it.next()).longValue());
        }
        for (OutstandingDisconnect outstandingDisconnect : this.onDisconnectRequestQueue) {
            sendOnDisconnect(outstandingDisconnect.getAction(), outstandingDisconnect.getPath(), outstandingDisconnect.getData(), outstandingDisconnect.getOnComplete());
        }
        this.onDisconnectRequestQueue.clear();
    }

    private void sendAction(String str, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        sendSensitive(str, false, map, connectionRequestCallback);
    }

    private void sendAuthAndRestoreState() {
        sendAuthHelper(true);
    }

    private void sendAuthHelper(final boolean z) {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", this.connectionState);
        ConnectionUtils.hardAssert(this.authToken != null, "Auth token must be set to authenticate!", new Object[0]);
        ConnectionRequestCallback r0 = new ConnectionRequestCallback() {
            /* class com.google.firebase.database.connection.PersistentConnectionImpl.AnonymousClass3 */

            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                PersistentConnectionImpl.this.connectionState = ConnectionState.Connected;
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    PersistentConnectionImpl.this.invalidAuthTokenCount = 0;
                    PersistentConnectionImpl.this.delegate.onAuthStatus(true);
                    if (z) {
                        PersistentConnectionImpl.this.restoreState();
                        return;
                    }
                    return;
                }
                PersistentConnectionImpl.this.authToken = null;
                PersistentConnectionImpl.this.forceAuthTokenRefresh = true;
                PersistentConnectionImpl.this.delegate.onAuthStatus(false);
                LogWrapper logWrapper = PersistentConnectionImpl.this.logger;
                logWrapper.debug("Authentication failed: " + str + " (" + ((String) map.get("d")) + ")", new Object[0]);
                PersistentConnectionImpl.this.realtime.close();
                if (str.equals("invalid_token")) {
                    PersistentConnectionImpl.access$1308(PersistentConnectionImpl.this);
                    if (((long) PersistentConnectionImpl.this.invalidAuthTokenCount) >= PersistentConnectionImpl.INVALID_AUTH_TOKEN_THRESHOLD) {
                        PersistentConnectionImpl.this.retryHelper.setMaxDelay();
                        PersistentConnectionImpl.this.logger.warn("Provided authentication credentials are invalid. This usually indicates your FirebaseApp instance was not initialized correctly. Make sure your google-services.json file has the correct firebase_url and api_key. You can re-download google-services.json from https://console.firebase.google.com/.");
                    }
                }
            }
        };
        HashMap hashMap = new HashMap();
        GAuthToken tryParseFromString = GAuthToken.tryParseFromString(this.authToken);
        if (tryParseFromString != null) {
            hashMap.put(REQUEST_CREDENTIAL, tryParseFromString.getToken());
            if (tryParseFromString.getAuth() != null) {
                hashMap.put(REQUEST_AUTHVAR, tryParseFromString.getAuth());
            }
            sendSensitive(REQUEST_ACTION_GAUTH, true, hashMap, r0);
            return;
        }
        hashMap.put(REQUEST_CREDENTIAL, this.authToken);
        sendSensitive(REQUEST_ACTION_AUTH, true, hashMap, r0);
    }

    private void sendConnectStats() {
        HashMap hashMap = new HashMap();
        if (this.context.isPersistenceEnabled()) {
            hashMap.put("persistence.android.enabled", 1);
        }
        StringBuilder i0 = hj1.i0("sdk.android.");
        i0.append(this.context.getClientSdkVersion().replace('.', '-'));
        hashMap.put(i0.toString(), 1);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending first connection stats", new Object[0]);
        }
        sendStats(hashMap);
    }

    private void sendListen(final OutstandingListen outstandingListen) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(outstandingListen.getQuery().path));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            hashMap.put("q", outstandingListen.query.queryParams);
            hashMap.put("t", tag);
        }
        ListenHashProvider hashFunction = outstandingListen.getHashFunction();
        hashMap.put(REQUEST_DATA_HASH, hashFunction.getSimpleHash());
        if (hashFunction.shouldIncludeCompoundHash()) {
            CompoundHash compoundHash = hashFunction.getCompoundHash();
            ArrayList arrayList = new ArrayList();
            for (List<String> list : compoundHash.getPosts()) {
                arrayList.add(ConnectionUtils.pathToString(list));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put(REQUEST_COMPOUND_HASH_HASHES, compoundHash.getHashes());
            hashMap2.put(REQUEST_COMPOUND_HASH_PATHS, arrayList);
            hashMap.put(REQUEST_COMPOUND_HASH, hashMap2);
        }
        sendAction("q", hashMap, new ConnectionRequestCallback() {
            /* class com.google.firebase.database.connection.PersistentConnectionImpl.AnonymousClass5 */

            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                if (str.equals("ok")) {
                    Map map2 = (Map) map.get("d");
                    if (map2.containsKey(PersistentConnectionImpl.SERVER_DATA_WARNINGS)) {
                        PersistentConnectionImpl.this.warnOnListenerWarnings((List) map2.get(PersistentConnectionImpl.SERVER_DATA_WARNINGS), outstandingListen.query);
                    }
                }
                if (((OutstandingListen) PersistentConnectionImpl.this.listens.get(outstandingListen.getQuery())) != outstandingListen) {
                    return;
                }
                if (!str.equals("ok")) {
                    PersistentConnectionImpl.this.removeListen(outstandingListen.getQuery());
                    outstandingListen.resultCallback.onRequestResult(str, (String) map.get("d"));
                    return;
                }
                outstandingListen.resultCallback.onRequestResult(null, null);
            }
        });
    }

    private void sendOnDisconnect(String str, List<String> list, Object obj, final RequestResultCallback requestResultCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(list));
        hashMap.put("d", obj);
        sendAction(str, hashMap, new ConnectionRequestCallback() {
            /* class com.google.firebase.database.connection.PersistentConnectionImpl.AnonymousClass2 */

            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                String str = (String) map.get("s");
                String str2 = null;
                if (!str.equals("ok")) {
                    str2 = (String) map.get("d");
                } else {
                    str = null;
                }
                RequestResultCallback requestResultCallback = requestResultCallback;
                if (requestResultCallback != null) {
                    requestResultCallback.onRequestResult(str, str2);
                }
            }
        });
    }

    private void sendPut(final long j) {
        ConnectionUtils.hardAssert(canSendWrites(), "sendPut called when we can't send writes (we're disconnected or writes are paused).", new Object[0]);
        final OutstandingPut outstandingPut = this.outstandingPuts.get(Long.valueOf(j));
        final RequestResultCallback onComplete = outstandingPut.getOnComplete();
        final String action = outstandingPut.getAction();
        outstandingPut.markSent();
        sendAction(action, outstandingPut.getRequest(), new ConnectionRequestCallback() {
            /* class com.google.firebase.database.connection.PersistentConnectionImpl.AnonymousClass4 */

            @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
            public void onResponse(Map<String, Object> map) {
                if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    LogWrapper logWrapper = PersistentConnectionImpl.this.logger;
                    logWrapper.debug(action + " response: " + map, new Object[0]);
                }
                if (((OutstandingPut) PersistentConnectionImpl.this.outstandingPuts.get(Long.valueOf(j))) == outstandingPut) {
                    PersistentConnectionImpl.this.outstandingPuts.remove(Long.valueOf(j));
                    if (onComplete != null) {
                        String str = (String) map.get("s");
                        if (str.equals("ok")) {
                            onComplete.onRequestResult(null, null);
                        } else {
                            onComplete.onRequestResult(str, (String) map.get("d"));
                        }
                    }
                } else if (PersistentConnectionImpl.this.logger.logsDebug()) {
                    LogWrapper logWrapper2 = PersistentConnectionImpl.this.logger;
                    StringBuilder i0 = hj1.i0("Ignoring on complete for put ");
                    i0.append(j);
                    i0.append(" because it was removed already.");
                    logWrapper2.debug(i0.toString(), new Object[0]);
                }
                PersistentConnectionImpl.this.doIdleCheck();
            }
        });
    }

    private void sendSensitive(String str, boolean z, Map<String, Object> map, ConnectionRequestCallback connectionRequestCallback) {
        long nextRequestNumber = nextRequestNumber();
        HashMap hashMap = new HashMap();
        hashMap.put(REQUEST_NUMBER, Long.valueOf(nextRequestNumber));
        hashMap.put("a", str);
        hashMap.put("b", map);
        this.realtime.sendRequest(hashMap, z);
        this.requestCBHash.put(Long.valueOf(nextRequestNumber), connectionRequestCallback);
    }

    private void sendStats(Map<String, Integer> map) {
        if (!map.isEmpty()) {
            HashMap hashMap = new HashMap();
            hashMap.put("c", map);
            sendAction("s", hashMap, new ConnectionRequestCallback() {
                /* class com.google.firebase.database.connection.PersistentConnectionImpl.AnonymousClass6 */

                @Override // com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback
                public void onResponse(Map<String, Object> map) {
                    String str = (String) map.get("s");
                    if (!str.equals("ok")) {
                        String str2 = (String) map.get("d");
                        if (PersistentConnectionImpl.this.logger.logsDebug()) {
                            LogWrapper logWrapper = PersistentConnectionImpl.this.logger;
                            logWrapper.debug("Failed to send stats: " + str + " (message: " + str2 + ")", new Object[0]);
                        }
                    }
                }
            });
        } else if (this.logger.logsDebug()) {
            this.logger.debug("Not sending stats because stats are empty", new Object[0]);
        }
    }

    private void sendUnauth() {
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[0]);
        ConnectionUtils.hardAssert(this.authToken == null, "Auth token must not be set.", new Object[0]);
        sendAction(REQUEST_ACTION_UNAUTH, Collections.emptyMap(), null);
    }

    private void sendUnlisten(OutstandingListen outstandingListen) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(outstandingListen.query.path));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            hashMap.put("q", outstandingListen.getQuery().queryParams);
            hashMap.put("t", tag);
        }
        sendAction(REQUEST_ACTION_QUERY_UNLISTEN, hashMap, null);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void tryScheduleReconnect() {
        if (shouldReconnect()) {
            ConnectionState connectionState2 = this.connectionState;
            ConnectionUtils.hardAssert(connectionState2 == ConnectionState.Disconnected, "Not in disconnected state: %s", connectionState2);
            final boolean z = this.forceAuthTokenRefresh;
            this.logger.debug("Scheduling connection attempt", new Object[0]);
            this.forceAuthTokenRefresh = false;
            this.retryHelper.retry(new Runnable() {
                /* class com.google.firebase.database.connection.PersistentConnectionImpl.AnonymousClass1 */

                public void run() {
                    PersistentConnectionImpl.this.logger.debug("Trying to fetch auth token", new Object[0]);
                    ConnectionUtils.hardAssert(PersistentConnectionImpl.this.connectionState == ConnectionState.Disconnected, "Not in disconnected state: %s", PersistentConnectionImpl.this.connectionState);
                    PersistentConnectionImpl.this.connectionState = ConnectionState.GettingToken;
                    PersistentConnectionImpl.access$608(PersistentConnectionImpl.this);
                    final long j = PersistentConnectionImpl.this.currentGetTokenAttempt;
                    PersistentConnectionImpl.this.authTokenProvider.getToken(z, new ConnectionAuthTokenProvider.GetTokenCallback() {
                        /* class com.google.firebase.database.connection.PersistentConnectionImpl.AnonymousClass1.AnonymousClass1 */

                        @Override // com.google.firebase.database.connection.ConnectionAuthTokenProvider.GetTokenCallback
                        public void onError(String str) {
                            if (j == PersistentConnectionImpl.this.currentGetTokenAttempt) {
                                PersistentConnectionImpl.this.connectionState = ConnectionState.Disconnected;
                                PersistentConnectionImpl.this.logger.debug(hj1.S("Error fetching token: ", str), new Object[0]);
                                PersistentConnectionImpl.this.tryScheduleReconnect();
                                return;
                            }
                            PersistentConnectionImpl.this.logger.debug("Ignoring getToken error, because this was not the latest attempt.", new Object[0]);
                        }

                        @Override // com.google.firebase.database.connection.ConnectionAuthTokenProvider.GetTokenCallback
                        public void onSuccess(String str) {
                            if (j != PersistentConnectionImpl.this.currentGetTokenAttempt) {
                                PersistentConnectionImpl.this.logger.debug("Ignoring getToken result, because this was not the latest attempt.", new Object[0]);
                            } else if (PersistentConnectionImpl.this.connectionState == ConnectionState.GettingToken) {
                                PersistentConnectionImpl.this.logger.debug("Successfully fetched token, opening connection", new Object[0]);
                                PersistentConnectionImpl.this.openNetworkConnection(str);
                            } else {
                                ConnectionUtils.hardAssert(PersistentConnectionImpl.this.connectionState == ConnectionState.Disconnected, "Expected connection state disconnected, but was %s", PersistentConnectionImpl.this.connectionState);
                                PersistentConnectionImpl.this.logger.debug("Not opening connection after token refresh, because connection was set to disconnected", new Object[0]);
                            }
                        }
                    });
                }
            });
        }
    }

    private void upgradeAuth() {
        sendAuthHelper(false);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void warnOnListenerWarnings(List<String> list, ListenQuerySpec listenQuerySpec) {
        if (list.contains("no_index")) {
            StringBuilder i0 = hj1.i0("\".indexOn\": \"");
            i0.append(listenQuerySpec.queryParams.get("i"));
            i0.append('\"');
            String sb = i0.toString();
            LogWrapper logWrapper = this.logger;
            StringBuilder l0 = hj1.l0("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '", sb, "' at ");
            l0.append(ConnectionUtils.pathToString(listenQuerySpec.path));
            l0.append(" to your security and Firebase Database rules for better performance");
            logWrapper.warn(l0.toString());
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void compareAndPut(List<String> list, Object obj, String str, RequestResultCallback requestResultCallback) {
        putInternal("p", list, obj, str, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void initialize() {
        tryScheduleReconnect();
    }

    public void injectConnectionFailure() {
        Connection connection = this.realtime;
        if (connection != null) {
            connection.injectConnectionFailure();
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void interrupt(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug(hj1.S("Connection interrupted for: ", str), new Object[0]);
        }
        this.interruptReasons.add(str);
        Connection connection = this.realtime;
        if (connection != null) {
            connection.close();
            this.realtime = null;
        } else {
            this.retryHelper.cancel();
            this.connectionState = ConnectionState.Disconnected;
        }
        this.retryHelper.signalSuccess();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public boolean isInterrupted(String str) {
        return this.interruptReasons.contains(str);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void listen(List<String> list, Map<String, Object> map, ListenHashProvider listenHashProvider, Long l, RequestResultCallback requestResultCallback) {
        ListenQuerySpec listenQuerySpec = new ListenQuerySpec(list, map);
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("Listening on " + listenQuerySpec, new Object[0]);
        }
        ConnectionUtils.hardAssert(!this.listens.containsKey(listenQuerySpec), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper2 = this.logger;
            logWrapper2.debug("Adding listen query: " + listenQuerySpec, new Object[0]);
        }
        OutstandingListen outstandingListen = new OutstandingListen(requestResultCallback, listenQuerySpec, l, listenHashProvider);
        this.listens.put(listenQuerySpec, outstandingListen);
        if (connected()) {
            sendListen(outstandingListen);
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void merge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        putInternal("m", list, map, null, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onCacheHost(String str) {
        this.cachedHost = str;
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onDataMessage(Map<String, Object> map) {
        if (map.containsKey(REQUEST_NUMBER)) {
            ConnectionRequestCallback remove = this.requestCBHash.remove(Long.valueOf((long) ((Integer) map.get(REQUEST_NUMBER)).intValue()));
            if (remove != null) {
                remove.onResponse((Map) map.get("b"));
            }
        } else if (!map.containsKey("error")) {
            if (map.containsKey("a")) {
                onDataPush((String) map.get("a"), (Map) map.get("b"));
            } else if (this.logger.logsDebug()) {
                LogWrapper logWrapper = this.logger;
                logWrapper.debug("Ignoring unknown message: " + map, new Object[0]);
            }
        }
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onDisconnect(Connection.DisconnectReason disconnectReason) {
        boolean z = false;
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            StringBuilder i0 = hj1.i0("Got on disconnect due to ");
            i0.append(disconnectReason.name());
            logWrapper.debug(i0.toString(), new Object[0]);
        }
        this.connectionState = ConnectionState.Disconnected;
        this.realtime = null;
        this.hasOnDisconnects = false;
        this.requestCBHash.clear();
        cancelSentTransactions();
        if (shouldReconnect()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.lastConnectionEstablishedTime;
            long j2 = currentTimeMillis - j;
            if (j > 0 && j2 > SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY) {
                z = true;
            }
            if (disconnectReason == Connection.DisconnectReason.SERVER_RESET || z) {
                this.retryHelper.signalSuccess();
            }
            tryScheduleReconnect();
        }
        this.lastConnectionEstablishedTime = 0;
        this.delegate.onDisconnect();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void onDisconnectCancel(List<String> list, RequestResultCallback requestResultCallback) {
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, null, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_CANCEL, list, null, requestResultCallback));
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void onDisconnectMerge(List<String> list, Map<String, Object> map, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_MERGE, list, map, requestResultCallback));
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void onDisconnectPut(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect(REQUEST_ACTION_ONDISCONNECT_PUT, list, obj, requestResultCallback);
        } else {
            this.onDisconnectRequestQueue.add(new OutstandingDisconnect(REQUEST_ACTION_ONDISCONNECT_PUT, list, obj, requestResultCallback));
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onKill(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug(hj1.S("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: ", str), new Object[0]);
        }
        interrupt(SERVER_KILL_INTERRUPT_REASON);
    }

    @Override // com.google.firebase.database.connection.Connection.Delegate
    public void onReady(long j, String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug("onReady", new Object[0]);
        }
        this.lastConnectionEstablishedTime = System.currentTimeMillis();
        handleTimestamp(j);
        if (this.firstConnection) {
            sendConnectStats();
        }
        restoreAuth();
        this.firstConnection = false;
        this.lastSessionId = str;
        this.delegate.onConnect();
    }

    public void openNetworkConnection(String str) {
        ConnectionState connectionState2 = this.connectionState;
        ConnectionUtils.hardAssert(connectionState2 == ConnectionState.GettingToken, "Trying to open network connection while in the wrong state: %s", connectionState2);
        if (str == null) {
            this.delegate.onAuthStatus(false);
        }
        this.authToken = str;
        this.connectionState = ConnectionState.Connecting;
        Connection connection = new Connection(this.context, this.hostInfo, this.cachedHost, this, this.lastSessionId);
        this.realtime = connection;
        connection.open();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void purgeOutstandingWrites() {
        for (OutstandingPut outstandingPut : this.outstandingPuts.values()) {
            if (outstandingPut.onComplete != null) {
                outstandingPut.onComplete.onRequestResult("write_canceled", null);
            }
        }
        for (OutstandingDisconnect outstandingDisconnect : this.onDisconnectRequestQueue) {
            if (outstandingDisconnect.onComplete != null) {
                outstandingDisconnect.onComplete.onRequestResult("write_canceled", null);
            }
        }
        this.outstandingPuts.clear();
        this.onDisconnectRequestQueue.clear();
        if (!connected()) {
            this.hasOnDisconnects = false;
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void put(List<String> list, Object obj, RequestResultCallback requestResultCallback) {
        putInternal("p", list, obj, null, requestResultCallback);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAuthToken() {
        this.logger.debug("Auth token refresh requested", new Object[0]);
        interrupt(TOKEN_REFRESH_INTERRUPT_REASON);
        resume(TOKEN_REFRESH_INTERRUPT_REASON);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void resume(String str) {
        if (this.logger.logsDebug()) {
            this.logger.debug(hj1.S("Connection no longer interrupted for: ", str), new Object[0]);
        }
        this.interruptReasons.remove(str);
        if (shouldReconnect() && this.connectionState == ConnectionState.Disconnected) {
            tryScheduleReconnect();
        }
    }

    public boolean shouldReconnect() {
        return this.interruptReasons.size() == 0;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void shutdown() {
        interrupt("shutdown");
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void unlisten(List<String> list, Map<String, Object> map) {
        ListenQuerySpec listenQuerySpec = new ListenQuerySpec(list, map);
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            logWrapper.debug("unlistening on " + listenQuerySpec, new Object[0]);
        }
        OutstandingListen removeListen = removeListen(listenQuerySpec);
        if (removeListen != null && connected()) {
            sendUnlisten(removeListen);
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection
    public void refreshAuthToken(String str) {
        this.logger.debug("Auth token refreshed.", new Object[0]);
        this.authToken = str;
        if (!connected()) {
            return;
        }
        if (str != null) {
            upgradeAuth();
        } else {
            sendUnauth();
        }
    }
}
