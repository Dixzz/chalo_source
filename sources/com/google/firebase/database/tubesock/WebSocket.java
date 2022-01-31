package com.google.firebase.database.tubesock;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.logging.LogWrapper;
import com.rabbitmq.client.StringRpcServer;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;

public class WebSocket {
    public static final byte OPCODE_BINARY = 2;
    public static final byte OPCODE_CLOSE = 8;
    public static final byte OPCODE_NONE = 0;
    public static final byte OPCODE_PING = 9;
    public static final byte OPCODE_PONG = 10;
    public static final byte OPCODE_TEXT = 1;
    private static final int SSL_HANDSHAKE_TIMEOUT_MS = 60000;
    private static final String THREAD_BASE_NAME = "TubeSock";
    private static final Charset UTF8 = Charset.forName(StringRpcServer.STRING_ENCODING);
    private static final AtomicInteger clientCount = new AtomicInteger(0);
    private static ThreadInitializer intializer = new ThreadInitializer() {
        /* class com.google.firebase.database.tubesock.WebSocket.AnonymousClass1 */

        @Override // com.google.firebase.database.tubesock.ThreadInitializer
        public void setName(Thread thread, String str) {
            thread.setName(str);
        }
    };
    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();
    private final int clientId;
    private WebSocketEventHandler eventHandler;
    private final WebSocketHandshake handshake;
    private final Thread innerThread;
    private final LogWrapper logger;
    private final WebSocketReceiver receiver;
    private volatile Socket socket;
    private final String sslCacheDirectory;
    private volatile State state;
    private final URI url;
    private final WebSocketWriter writer;

    /* renamed from: com.google.firebase.database.tubesock.WebSocket$3  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$firebase$database$tubesock$WebSocket$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0023 */
        static {
            /*
                com.google.firebase.database.tubesock.WebSocket.State.values()
                r0 = 5
                int[] r1 = new int[r0]
                com.google.firebase.database.tubesock.WebSocket.AnonymousClass3.$SwitchMap$com$google$firebase$database$tubesock$WebSocket$State = r1
                r2 = 1
                com.google.firebase.database.tubesock.WebSocket$State r3 = com.google.firebase.database.tubesock.WebSocket.State.NONE     // Catch:{ NoSuchFieldError -> 0x000e }
                r3 = 0
                r1[r3] = r2     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r1 = 2
                int[] r3 = com.google.firebase.database.tubesock.WebSocket.AnonymousClass3.$SwitchMap$com$google$firebase$database$tubesock$WebSocket$State     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.google.firebase.database.tubesock.WebSocket$State r4 = com.google.firebase.database.tubesock.WebSocket.State.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0015 }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                r2 = 3
                int[] r3 = com.google.firebase.database.tubesock.WebSocket.AnonymousClass3.$SwitchMap$com$google$firebase$database$tubesock$WebSocket$State     // Catch:{ NoSuchFieldError -> 0x001c }
                com.google.firebase.database.tubesock.WebSocket$State r4 = com.google.firebase.database.tubesock.WebSocket.State.CONNECTED     // Catch:{ NoSuchFieldError -> 0x001c }
                r3[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                r1 = 4
                int[] r3 = com.google.firebase.database.tubesock.WebSocket.AnonymousClass3.$SwitchMap$com$google$firebase$database$tubesock$WebSocket$State     // Catch:{ NoSuchFieldError -> 0x0023 }
                com.google.firebase.database.tubesock.WebSocket$State r4 = com.google.firebase.database.tubesock.WebSocket.State.DISCONNECTING     // Catch:{ NoSuchFieldError -> 0x0023 }
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0023 }
            L_0x0023:
                int[] r2 = com.google.firebase.database.tubesock.WebSocket.AnonymousClass3.$SwitchMap$com$google$firebase$database$tubesock$WebSocket$State     // Catch:{ NoSuchFieldError -> 0x0029 }
                com.google.firebase.database.tubesock.WebSocket$State r3 = com.google.firebase.database.tubesock.WebSocket.State.DISCONNECTED     // Catch:{ NoSuchFieldError -> 0x0029 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0029 }
            L_0x0029:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.tubesock.WebSocket.AnonymousClass3.<clinit>():void");
        }
    }

    public enum State {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    public WebSocket(ConnectionContext connectionContext, URI uri) {
        this(connectionContext, uri, null);
    }

    private synchronized void closeSocket() {
        State state2 = this.state;
        State state3 = State.DISCONNECTED;
        if (state2 != state3) {
            this.receiver.stopit();
            this.writer.stopIt();
            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            this.state = state3;
            this.eventHandler.onClose();
        }
    }

    private Socket createSocket() {
        String scheme = this.url.getScheme();
        String host = this.url.getHost();
        int port = this.url.getPort();
        if (scheme != null && scheme.equals("ws")) {
            if (port == -1) {
                port = 80;
            }
            try {
                return new Socket(host, port);
            } catch (UnknownHostException e) {
                throw new WebSocketException(hj1.S("unknown host: ", host), e);
            } catch (IOException e2) {
                StringBuilder i0 = hj1.i0("error while creating socket to ");
                i0.append(this.url);
                throw new WebSocketException(i0.toString(), e2);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            throw new WebSocketException(hj1.S("unsupported protocol: ", scheme));
        } else {
            if (port == -1) {
                port = 443;
            }
            SSLSessionCache sSLSessionCache = null;
            try {
                if (this.sslCacheDirectory != null) {
                    sSLSessionCache = new SSLSessionCache(new File(this.sslCacheDirectory));
                }
            } catch (IOException e3) {
                this.logger.debug("Failed to initialize SSL session cache", e3, new Object[0]);
            }
            try {
                SSLSocket sSLSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(60000, sSLSessionCache).createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                throw new WebSocketException("Error while verifying secure socket to " + this.url);
            } catch (UnknownHostException e4) {
                throw new WebSocketException(hj1.S("unknown host: ", host), e4);
            } catch (IOException e5) {
                StringBuilder i02 = hj1.i0("error while creating secure socket to ");
                i02.append(this.url);
                throw new WebSocketException(i02.toString(), e5);
            }
        }
    }

    public static ThreadInitializer getIntializer() {
        return intializer;
    }

    public static ThreadFactory getThreadFactory() {
        return threadFactory;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        r1 = new java.io.DataInputStream(r0.getInputStream());
        r0 = r0.getOutputStream();
        r0.write(r11.handshake.getHandshake());
        r3 = new byte[com.google.firebase.appindexing.Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL];
        r4 = new java.util.ArrayList();
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        if (r6 != false) goto L_0x00ab;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        r9 = r1.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004c, code lost:
        if (r9 == -1) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        r3[r7] = (byte) r9;
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        if (r3[r7 - 1] != 10) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0061, code lost:
        if (r3[r7 - 2] != 13) goto L_0x0082;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        r7 = new java.lang.String(r3, com.google.firebase.database.tubesock.WebSocket.UTF8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
        if (r7.trim().equals("") == false) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0076, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0078, code lost:
        r4.add(r7.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        r3 = new byte[com.google.firebase.appindexing.Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0082, code lost:
        if (r7 == 1000) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0085, code lost:
        r0 = new java.lang.String(r3, com.google.firebase.database.tubesock.WebSocket.UTF8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a2, code lost:
        throw new com.google.firebase.database.tubesock.WebSocketException("Unexpected long line in handshake: " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00aa, code lost:
        throw new com.google.firebase.database.tubesock.WebSocketException("Connection closed before handshake was complete");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ab, code lost:
        r11.handshake.verifyServerStatusLine((java.lang.String) r4.get(0));
        r4.remove(0);
        r2 = new java.util.HashMap<>();
        r3 = r4.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00c6, code lost:
        if (r3.hasNext() == false) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c8, code lost:
        r4 = ((java.lang.String) r3.next()).split(": ", 2);
        r6 = r4[0];
        r7 = java.util.Locale.US;
        r2.put(r6.toLowerCase(r7), r4[1].toLowerCase(r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e7, code lost:
        r11.handshake.verifyServerHandshakeHeaders(r2);
        r11.writer.setOutput(r0);
        r11.receiver.setInput(r1);
        r11.state = com.google.firebase.database.tubesock.WebSocket.State.CONNECTED;
        r11.writer.getInnerThread().start();
        r11.eventHandler.onOpen();
        r11.receiver.run();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void runReader() {
        /*
        // Method dump skipped, instructions count: 321
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.tubesock.WebSocket.runReader():void");
    }

    private void sendCloseHandshake() {
        try {
            this.state = State.DISCONNECTING;
            this.writer.stopIt();
            this.writer.send((byte) 8, true, new byte[0]);
        } catch (IOException e) {
            this.eventHandler.onError(new WebSocketException("Failed to send close frame", e));
        }
    }

    public static void setThreadFactory(ThreadFactory threadFactory2, ThreadInitializer threadInitializer) {
        threadFactory = threadFactory2;
        intializer = threadInitializer;
    }

    public void blockClose() throws InterruptedException {
        if (this.writer.getInnerThread().getState() != Thread.State.NEW) {
            this.writer.getInnerThread().join();
        }
        getInnerThread().join();
    }

    public synchronized void close() {
        int ordinal = this.state.ordinal();
        if (ordinal == 0) {
            this.state = State.DISCONNECTED;
        } else if (ordinal == 1) {
            closeSocket();
        } else if (ordinal == 2) {
            sendCloseHandshake();
        } else if (ordinal == 3) {
        } else {
            if (ordinal == 4) {
            }
        }
    }

    public synchronized void connect() {
        if (this.state != State.NONE) {
            this.eventHandler.onError(new WebSocketException("connect() already called"));
            close();
            return;
        }
        ThreadInitializer intializer2 = getIntializer();
        Thread innerThread2 = getInnerThread();
        intializer2.setName(innerThread2, "TubeSockReader-" + this.clientId);
        this.state = State.CONNECTING;
        getInnerThread().start();
    }

    public WebSocketEventHandler getEventHandler() {
        return this.eventHandler;
    }

    public Thread getInnerThread() {
        return this.innerThread;
    }

    public void handleReceiverError(WebSocketException webSocketException) {
        this.eventHandler.onError(webSocketException);
        if (this.state == State.CONNECTED) {
            close();
        }
        closeSocket();
    }

    public void onCloseOpReceived() {
        closeSocket();
    }

    public synchronized void pong(byte[] bArr) {
        send((byte) 10, bArr);
    }

    public synchronized void send(String str) {
        send((byte) 1, str.getBytes(UTF8));
    }

    public void setEventHandler(WebSocketEventHandler webSocketEventHandler) {
        this.eventHandler = webSocketEventHandler;
    }

    public WebSocket(ConnectionContext connectionContext, URI uri, String str) {
        this(connectionContext, uri, str, null);
    }

    public WebSocket(ConnectionContext connectionContext, URI uri, String str, Map<String, String> map) {
        this.state = State.NONE;
        this.socket = null;
        this.eventHandler = null;
        int incrementAndGet = clientCount.incrementAndGet();
        this.clientId = incrementAndGet;
        this.innerThread = getThreadFactory().newThread(new Runnable() {
            /* class com.google.firebase.database.tubesock.WebSocket.AnonymousClass2 */

            public void run() {
                WebSocket.this.runReader();
            }
        });
        this.url = uri;
        this.sslCacheDirectory = connectionContext.getSslCacheDirectory();
        this.logger = new LogWrapper(connectionContext.getLogger(), "WebSocket", hj1.I("sk_", incrementAndGet));
        this.handshake = new WebSocketHandshake(uri, str, map);
        this.receiver = new WebSocketReceiver(this);
        this.writer = new WebSocketWriter(this, THREAD_BASE_NAME, incrementAndGet);
    }

    public synchronized void send(byte[] bArr) {
        send((byte) 2, bArr);
    }

    private synchronized void send(byte b, byte[] bArr) {
        if (this.state != State.CONNECTED) {
            this.eventHandler.onError(new WebSocketException("error while sending data: not connected"));
        } else {
            try {
                this.writer.send(b, true, bArr);
            } catch (IOException e) {
                this.eventHandler.onError(new WebSocketException("Failed to send frame", e));
                close();
            }
        }
    }
}
