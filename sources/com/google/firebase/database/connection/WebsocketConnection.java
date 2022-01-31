package com.google.firebase.database.connection;

import com.google.firebase.database.connection.util.StringListReader;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.tubesock.WebSocket;
import com.google.firebase.database.tubesock.WebSocketEventHandler;
import com.google.firebase.database.tubesock.WebSocketException;
import com.google.firebase.database.tubesock.WebSocketMessage;
import com.google.firebase.database.util.JsonMapper;
import java.io.EOFException;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class WebsocketConnection {
    private static final long CONNECT_TIMEOUT_MS = 30000;
    private static final long KEEP_ALIVE_TIMEOUT_MS = 45000;
    private static final int MAX_FRAME_SIZE = 16384;
    private static long connectionId;
    private WSClient conn;
    private ScheduledFuture<?> connectTimeout;
    private final ConnectionContext connectionContext;
    private Delegate delegate;
    private boolean everConnected = false;
    private final ScheduledExecutorService executorService;
    private StringListReader frameReader;
    private boolean isClosed = false;
    private ScheduledFuture<?> keepAlive;
    private final LogWrapper logger;
    private long totalFrames = 0;

    public interface Delegate {
        void onDisconnect(boolean z);

        void onMessage(Map<String, Object> map);
    }

    public interface WSClient {
        void close();

        void connect();

        void send(String str);
    }

    public class WSClientTubesock implements WSClient, WebSocketEventHandler {
        private WebSocket ws;

        private void shutdown() {
            this.ws.close();
            try {
                this.ws.blockClose();
            } catch (InterruptedException e) {
                WebsocketConnection.this.logger.error("Interrupted while shutting down websocket threads", e);
            }
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection.WSClient
        public void close() {
            this.ws.close();
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection.WSClient
        public void connect() {
            try {
                this.ws.connect();
            } catch (WebSocketException e) {
                if (WebsocketConnection.this.logger.logsDebug()) {
                    WebsocketConnection.this.logger.debug("Error connecting", e, new Object[0]);
                }
                shutdown();
            }
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onClose() {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                /* class com.google.firebase.database.connection.WebsocketConnection.WSClientTubesock.AnonymousClass3 */

                public void run() {
                    if (WebsocketConnection.this.logger.logsDebug()) {
                        WebsocketConnection.this.logger.debug("closed", new Object[0]);
                    }
                    WebsocketConnection.this.onClosed();
                }
            });
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onError(final WebSocketException webSocketException) {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                /* class com.google.firebase.database.connection.WebsocketConnection.WSClientTubesock.AnonymousClass4 */

                public void run() {
                    if (webSocketException.getCause() == null || !(webSocketException.getCause() instanceof EOFException)) {
                        WebsocketConnection.this.logger.debug("WebSocket error.", webSocketException, new Object[0]);
                    } else {
                        WebsocketConnection.this.logger.debug("WebSocket reached EOF.", new Object[0]);
                    }
                    WebsocketConnection.this.onClosed();
                }
            });
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onLogMessage(String str) {
            if (WebsocketConnection.this.logger.logsDebug()) {
                WebsocketConnection.this.logger.debug(hj1.S("Tubesock: ", str), new Object[0]);
            }
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onMessage(WebSocketMessage webSocketMessage) {
            final String text = webSocketMessage.getText();
            if (WebsocketConnection.this.logger.logsDebug()) {
                WebsocketConnection.this.logger.debug(hj1.S("ws message: ", text), new Object[0]);
            }
            WebsocketConnection.this.executorService.execute(new Runnable() {
                /* class com.google.firebase.database.connection.WebsocketConnection.WSClientTubesock.AnonymousClass2 */

                public void run() {
                    WebsocketConnection.this.handleIncomingFrame(text);
                }
            });
        }

        @Override // com.google.firebase.database.tubesock.WebSocketEventHandler
        public void onOpen() {
            WebsocketConnection.this.executorService.execute(new Runnable() {
                /* class com.google.firebase.database.connection.WebsocketConnection.WSClientTubesock.AnonymousClass1 */

                public void run() {
                    WebsocketConnection.this.connectTimeout.cancel(false);
                    WebsocketConnection.this.everConnected = true;
                    if (WebsocketConnection.this.logger.logsDebug()) {
                        WebsocketConnection.this.logger.debug("websocket opened", new Object[0]);
                    }
                    WebsocketConnection.this.resetKeepAlive();
                }
            });
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection.WSClient
        public void send(String str) {
            this.ws.send(str);
        }

        private WSClientTubesock(WebSocket webSocket) {
            this.ws = webSocket;
            webSocket.setEventHandler(this);
        }
    }

    public WebsocketConnection(ConnectionContext connectionContext2, HostInfo hostInfo, String str, Delegate delegate2, String str2) {
        this.connectionContext = connectionContext2;
        this.executorService = connectionContext2.getExecutorService();
        this.delegate = delegate2;
        long j = connectionId;
        connectionId = 1 + j;
        this.logger = new LogWrapper(connectionContext2.getLogger(), "WebSocket", hj1.M("ws_", j));
        this.conn = createConnection(hostInfo, str, str2);
    }

    private void appendFrame(String str) {
        this.frameReader.addString(str);
        long j = this.totalFrames - 1;
        this.totalFrames = j;
        if (j == 0) {
            try {
                this.frameReader.freeze();
                Map<String, Object> parseJson = JsonMapper.parseJson(this.frameReader.toString());
                this.frameReader = null;
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    logWrapper.debug("handleIncomingFrame complete frame: " + parseJson, new Object[0]);
                }
                this.delegate.onMessage(parseJson);
            } catch (IOException e) {
                LogWrapper logWrapper2 = this.logger;
                StringBuilder i0 = hj1.i0("Error parsing frame: ");
                i0.append(this.frameReader.toString());
                logWrapper2.error(i0.toString(), e);
                close();
                shutdown();
            } catch (ClassCastException e2) {
                LogWrapper logWrapper3 = this.logger;
                StringBuilder i02 = hj1.i0("Error parsing frame (cast error): ");
                i02.append(this.frameReader.toString());
                logWrapper3.error(i02.toString(), e2);
                close();
                shutdown();
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void closeIfNeverConnected() {
        if (!this.everConnected && !this.isClosed) {
            if (this.logger.logsDebug()) {
                this.logger.debug("timed out on connect", new Object[0]);
            }
            this.conn.close();
        }
    }

    private WSClient createConnection(HostInfo hostInfo, String str, String str2) {
        if (str == null) {
            str = hostInfo.getHost();
        }
        URI connectionUrl = HostInfo.getConnectionUrl(str, hostInfo.isSecure(), hostInfo.getNamespace(), str2);
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.connectionContext.getUserAgent());
        hashMap.put("X-Firebase-GMPID", this.connectionContext.getApplicationId());
        return new WSClientTubesock(new WebSocket(this.connectionContext, connectionUrl, null, hashMap));
    }

    private String extractFrameCount(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt <= 0) {
                    return null;
                }
                handleNewFrameCount(parseInt);
                return null;
            } catch (NumberFormatException unused) {
            }
        }
        handleNewFrameCount(1);
        return str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void handleIncomingFrame(String str) {
        if (!this.isClosed) {
            resetKeepAlive();
            if (isBuffering()) {
                appendFrame(str);
                return;
            }
            String extractFrameCount = extractFrameCount(str);
            if (extractFrameCount != null) {
                appendFrame(extractFrameCount);
            }
        }
    }

    private void handleNewFrameCount(int i) {
        this.totalFrames = (long) i;
        this.frameReader = new StringListReader();
        if (this.logger.logsDebug()) {
            LogWrapper logWrapper = this.logger;
            StringBuilder i0 = hj1.i0("HandleNewFrameCount: ");
            i0.append(this.totalFrames);
            logWrapper.debug(i0.toString(), new Object[0]);
        }
    }

    private boolean isBuffering() {
        return this.frameReader != null;
    }

    private Runnable nop() {
        return new Runnable() {
            /* class com.google.firebase.database.connection.WebsocketConnection.AnonymousClass2 */

            public void run() {
                if (WebsocketConnection.this.conn != null) {
                    WebsocketConnection.this.conn.send("0");
                    WebsocketConnection.this.resetKeepAlive();
                }
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void onClosed() {
        if (!this.isClosed) {
            if (this.logger.logsDebug()) {
                this.logger.debug("closing itself", new Object[0]);
            }
            shutdown();
        }
        this.conn = null;
        ScheduledFuture<?> scheduledFuture = this.keepAlive;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void resetKeepAlive() {
        if (!this.isClosed) {
            ScheduledFuture<?> scheduledFuture = this.keepAlive;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                if (this.logger.logsDebug()) {
                    LogWrapper logWrapper = this.logger;
                    StringBuilder i0 = hj1.i0("Reset keepAlive. Remaining: ");
                    i0.append(this.keepAlive.getDelay(TimeUnit.MILLISECONDS));
                    logWrapper.debug(i0.toString(), new Object[0]);
                }
            } else if (this.logger.logsDebug()) {
                this.logger.debug("Reset keepAlive", new Object[0]);
            }
            this.keepAlive = this.executorService.schedule(nop(), KEEP_ALIVE_TIMEOUT_MS, TimeUnit.MILLISECONDS);
        }
    }

    private void shutdown() {
        this.isClosed = true;
        this.delegate.onDisconnect(this.everConnected);
    }

    private static String[] splitIntoFrames(String str, int i) {
        int i2 = 0;
        if (str.length() <= i) {
            return new String[]{str};
        }
        ArrayList arrayList = new ArrayList();
        while (i2 < str.length()) {
            int i3 = i2 + i;
            arrayList.add(str.substring(i2, Math.min(i3, str.length())));
            i2 = i3;
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public void close() {
        if (this.logger.logsDebug()) {
            this.logger.debug("websocket is being closed", new Object[0]);
        }
        this.isClosed = true;
        this.conn.close();
        ScheduledFuture<?> scheduledFuture = this.connectTimeout;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        ScheduledFuture<?> scheduledFuture2 = this.keepAlive;
        if (scheduledFuture2 != null) {
            scheduledFuture2.cancel(true);
        }
    }

    public void open() {
        this.conn.connect();
        this.connectTimeout = this.executorService.schedule(new Runnable() {
            /* class com.google.firebase.database.connection.WebsocketConnection.AnonymousClass1 */

            public void run() {
                WebsocketConnection.this.closeIfNeverConnected();
            }
        }, CONNECT_TIMEOUT_MS, TimeUnit.MILLISECONDS);
    }

    public void send(Map<String, Object> map) {
        resetKeepAlive();
        try {
            String[] splitIntoFrames = splitIntoFrames(JsonMapper.serializeJson(map), MAX_FRAME_SIZE);
            if (splitIntoFrames.length > 1) {
                this.conn.send("" + splitIntoFrames.length);
            }
            for (String str : splitIntoFrames) {
                this.conn.send(str);
            }
        } catch (IOException e) {
            LogWrapper logWrapper = this.logger;
            StringBuilder i0 = hj1.i0("Failed to serialize message: ");
            i0.append(map.toString());
            logWrapper.error(i0.toString(), e);
            shutdown();
        }
    }

    public void start() {
    }
}
