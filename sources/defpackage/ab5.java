package defpackage;

import android.annotation.SuppressLint;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.rabbitmq.client.ConnectionFactory;
import defpackage.pb5;
import defpackage.wa5;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;

@SuppressLint({"Assert"})
/* renamed from: ab5  reason: default package */
/* compiled from: WebSocketClient */
public abstract class ab5 extends xa5 implements Runnable, wa5 {
    public URI f = null;
    public ya5 g = null;
    public Socket h = null;
    public InputStream i;
    public OutputStream j;
    public Proxy k = Proxy.NO_PROXY;
    public Thread l;
    public Map<String, String> m;
    public CountDownLatch n = new CountDownLatch(1);
    public CountDownLatch o = new CountDownLatch(1);
    public int p = 0;

    /* renamed from: ab5$b */
    /* compiled from: WebSocketClient */
    public class b implements Runnable {
        public b(a aVar) {
        }

        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer take = ab5.this.g.f.take();
                    ab5.this.j.write(take.array(), 0, take.limit());
                    ab5.this.j.flush();
                } catch (IOException unused) {
                    ab5.this.g.e();
                    return;
                } catch (InterruptedException unused2) {
                    return;
                }
            }
        }
    }

    public ab5(URI uri, bb5 bb5, Map<String, String> map, int i2) {
        if (uri != null) {
            this.f = uri;
            this.m = null;
            this.p = i2;
            this.g = new ya5(this, bb5);
            return;
        }
        throw new IllegalArgumentException();
    }

    public final int b() {
        int port = this.f.getPort();
        if (port != -1) {
            return port;
        }
        String scheme = this.f.getScheme();
        if (scheme.equals("wss")) {
            return 443;
        }
        if (scheme.equals("ws")) {
            return 80;
        }
        throw new RuntimeException(hj1.S("unkonow scheme", scheme));
    }

    public abstract void c(int i2, String str, boolean z);

    public abstract void d(Exception exc);

    public abstract void e(String str);

    public abstract void f(xb5 xb5);

    public final void g(wa5 wa5, int i2, String str, boolean z) {
        this.n.countDown();
        this.o.countDown();
        Thread thread = this.l;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            Socket socket = this.h;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            d(e);
        }
        c(i2, str, z);
    }

    public void h(pb5.a aVar, ByteBuffer byteBuffer, boolean z) {
        pb5.a aVar2;
        ya5 ya5 = this.g;
        bb5 bb5 = ya5.j;
        Objects.requireNonNull(bb5);
        if (aVar == pb5.a.BINARY || aVar == (aVar2 = pb5.a.TEXT) || aVar == aVar2) {
            if (bb5.b != null) {
                bb5.b = pb5.a.CONTINUOUS;
            } else {
                bb5.b = aVar;
            }
            qb5 qb5 = new qb5(bb5.b);
            try {
                qb5.c = byteBuffer;
                qb5.f2925a = z;
                if (z) {
                    bb5.b = null;
                } else {
                    bb5.b = aVar;
                }
                List<pb5> singletonList = Collections.singletonList(qb5);
                if (ya5.i()) {
                    for (pb5 pb5 : singletonList) {
                        ya5.k(pb5);
                    }
                    return;
                }
                throw new lb5();
            } catch (hb5 e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
    }

    public final void i() throws jb5 {
        String path = this.f.getPath();
        String query = this.f.getQuery();
        if (path == null || path.length() == 0) {
            path = ConnectionFactory.DEFAULT_VHOST;
        }
        if (query != null) {
            path = hj1.T(path, "?", query);
        }
        int b2 = b();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f.getHost());
        sb.append(b2 != 80 ? hj1.I(ProductDiscountsObject.KEY_DELIMITER, b2) : "");
        String sb2 = sb.toString();
        tb5 tb5 = new tb5();
        if (path != null) {
            tb5.c = path;
            tb5.b.put("Host", sb2);
            Map<String, String> map = this.m;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    tb5.b.put(entry.getKey(), entry.getValue());
                }
            }
            ya5 ya5 = this.g;
            ya5.n = ya5.j.i(tb5);
            ya5.r = tb5.c;
            try {
                Objects.requireNonNull((xa5) ya5.i);
                ya5.m(ya5.j.g(ya5.n, ya5.k));
            } catch (hb5 unused) {
                throw new jb5("Handshake data rejected by client.");
            } catch (RuntimeException e) {
                ((ab5) ya5.i).d(e);
                throw new jb5("rejected because of" + e);
            }
        } else {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
    }

    public void run() {
        int read;
        try {
            Socket socket = this.h;
            if (socket == null) {
                this.h = new Socket(this.k);
            } else if (socket.isClosed()) {
                throw new IOException();
            }
            if (!this.h.isBound()) {
                this.h.connect(new InetSocketAddress(this.f.getHost(), b()), this.p);
            }
            this.i = this.h.getInputStream();
            this.j = this.h.getOutputStream();
            i();
            Thread thread = new Thread(new b(null));
            this.l = thread;
            thread.start();
            List<bb5> list = ya5.s;
            byte[] bArr = new byte[16384];
            while (true) {
                try {
                    if ((this.g.h == wa5.a.CLOSED) || (read = this.i.read(bArr)) == -1) {
                        this.g.e();
                    } else {
                        this.g.c(ByteBuffer.wrap(bArr, 0, read));
                    }
                } catch (IOException unused) {
                    this.g.e();
                    return;
                } catch (RuntimeException e) {
                    d(e);
                    this.g.b(1006, e.getMessage(), false);
                    return;
                }
            }
            this.g.e();
        } catch (Exception e2) {
            d(e2);
            this.g.b(-1, e2.getMessage(), false);
        }
    }
}
