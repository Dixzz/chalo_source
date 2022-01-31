package defpackage;

import android.os.Message;
import defpackage.ge5;
import defpackage.pb5;
import defpackage.wa5;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: zd5  reason: default package */
/* compiled from: EditorConnection */
public class zd5 {
    public static final ByteBuffer d = ByteBuffer.allocate(0);

    /* renamed from: a  reason: collision with root package name */
    public final b f4161a;
    public final c b;
    public final URI c;

    /* renamed from: zd5$b */
    /* compiled from: EditorConnection */
    public interface b {
    }

    /* renamed from: zd5$c */
    /* compiled from: EditorConnection */
    public class c extends ab5 {
        public c(URI uri, int i, Socket socket) throws InterruptedException {
            super(uri, new db5(), null, i);
            if (this.h == null) {
                this.h = socket;
                return;
            }
            throw new IllegalStateException("socket has already been set");
        }

        @Override // defpackage.ab5
        public void c(int i, String str, boolean z) {
            String str2 = "WebSocket closed. Code: " + i + ", reason: " + str + "\nURI: " + zd5.this.c;
            ge5.b bVar = (ge5.b) zd5.this.f4161a;
            ge5.this.h.sendMessage(ge5.this.h.obtainMessage(8));
        }

        @Override // defpackage.ab5
        public void d(Exception exc) {
            if (exc != null && exc.getMessage() != null) {
                exc.getMessage();
            }
        }

        @Override // defpackage.ab5
        public void e(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                if (string.equals("device_info_request")) {
                    ge5.b bVar = (ge5.b) zd5.this.f4161a;
                    ge5.this.h.sendMessage(ge5.this.h.obtainMessage(4));
                } else if (string.equals("snapshot_request")) {
                    ge5.b bVar2 = (ge5.b) zd5.this.f4161a;
                    Message obtainMessage = ge5.this.h.obtainMessage(2);
                    obtainMessage.obj = jSONObject;
                    ge5.this.h.sendMessage(obtainMessage);
                } else if (string.equals("change_request")) {
                    ge5.b bVar3 = (ge5.b) zd5.this.f4161a;
                    Message obtainMessage2 = ge5.this.h.obtainMessage(3);
                    obtainMessage2.obj = jSONObject;
                    ge5.this.h.sendMessage(obtainMessage2);
                } else if (string.equals("event_binding_request")) {
                    ge5.b bVar4 = (ge5.b) zd5.this.f4161a;
                    Message obtainMessage3 = ge5.this.h.obtainMessage(6);
                    obtainMessage3.obj = jSONObject;
                    ge5.this.h.sendMessage(obtainMessage3);
                } else if (string.equals("clear_request")) {
                    ge5.b bVar5 = (ge5.b) zd5.this.f4161a;
                    Message obtainMessage4 = ge5.this.h.obtainMessage(10);
                    obtainMessage4.obj = jSONObject;
                    ge5.this.h.sendMessage(obtainMessage4);
                } else if (string.equals("tweak_request")) {
                    ge5.b bVar6 = (ge5.b) zd5.this.f4161a;
                    Message obtainMessage5 = ge5.this.h.obtainMessage(11);
                    obtainMessage5.obj = jSONObject;
                    ge5.this.h.sendMessage(obtainMessage5);
                }
            } catch (JSONException unused) {
            }
        }

        @Override // defpackage.ab5
        public void f(xb5 xb5) {
        }
    }

    /* renamed from: zd5$d */
    /* compiled from: EditorConnection */
    public class d extends IOException {
        public d(zd5 zd5, Throwable th) {
            super(th.getMessage());
        }
    }

    /* renamed from: zd5$e */
    /* compiled from: EditorConnection */
    public class e extends OutputStream {
        public e(a aVar) {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws d {
            try {
                zd5.this.b.h(pb5.a.TEXT, zd5.d, true);
            } catch (lb5 e) {
                throw new d(zd5.this, e);
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws d {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws d {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws d {
            try {
                zd5.this.b.h(pb5.a.TEXT, ByteBuffer.wrap(bArr, i, i2), false);
            } catch (lb5 e) {
                throw new d(zd5.this, e);
            }
        }
    }

    public zd5(URI uri, b bVar, Socket socket) throws d {
        this.f4161a = bVar;
        this.c = uri;
        try {
            c cVar = new c(uri, 5000, socket);
            this.b = cVar;
            if (cVar.l == null) {
                Thread thread = new Thread(cVar);
                cVar.l = thread;
                thread.start();
                cVar.n.await();
                cVar.g.i();
                return;
            }
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        } catch (InterruptedException e2) {
            throw new d(this, e2);
        }
    }

    public BufferedOutputStream a() {
        return new BufferedOutputStream(new e(null));
    }

    public boolean b() {
        return this.b.g.i();
    }

    public boolean c() {
        ya5 ya5 = this.b.g;
        wa5.a aVar = ya5.h;
        if (aVar == wa5.a.CLOSED) {
            return false;
        }
        if ((aVar == wa5.a.CLOSING) || ya5.g) {
            return false;
        }
        return true;
    }
}
