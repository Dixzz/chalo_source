package defpackage;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/* renamed from: ha5  reason: default package */
/* compiled from: AutoFocusManager */
public final class ha5 {
    public static final Collection<String> h;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1353a;
    public boolean b;
    public final boolean c;
    public final Camera d;
    public Handler e;
    public final Handler.Callback f;
    public final Camera.AutoFocusCallback g = new b();

    /* renamed from: ha5$a */
    /* compiled from: AutoFocusManager */
    public class a implements Handler.Callback {
        public a() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            Objects.requireNonNull(ha5.this);
            if (i != 1) {
                return false;
            }
            ha5.this.b();
            return true;
        }
    }

    /* renamed from: ha5$b */
    /* compiled from: AutoFocusManager */
    public class b implements Camera.AutoFocusCallback {

        /* renamed from: ha5$b$a */
        /* compiled from: AutoFocusManager */
        public class a implements Runnable {
            public a() {
            }

            public void run() {
                ha5 ha5 = ha5.this;
                ha5.b = false;
                ha5.a();
            }
        }

        public b() {
        }

        public void onAutoFocus(boolean z, Camera camera) {
            ha5.this.e.post(new a());
        }
    }

    static {
        ArrayList arrayList = new ArrayList(2);
        h = arrayList;
        arrayList.add("auto");
        arrayList.add("macro");
    }

    public ha5(Camera camera, ma5 ma5) {
        a aVar = new a();
        this.f = aVar;
        this.e = new Handler(aVar);
        this.d = camera;
        String focusMode = camera.getParameters().getFocusMode();
        Objects.requireNonNull(ma5);
        this.c = h.contains(focusMode);
        this.f1353a = false;
        b();
    }

    public final synchronized void a() {
        if (!this.f1353a && !this.e.hasMessages(1)) {
            Handler handler = this.e;
            handler.sendMessageDelayed(handler.obtainMessage(1), 2000);
        }
    }

    public final void b() {
        if (this.c && !this.f1353a && !this.b) {
            try {
                this.d.autoFocus(this.g);
                this.b = true;
            } catch (RuntimeException unused) {
                a();
            }
        }
    }

    public void c() {
        this.f1353a = true;
        this.b = false;
        this.e.removeMessages(1);
        if (this.c) {
            try {
                this.d.cancelAutoFocus();
            } catch (RuntimeException unused) {
            }
        }
    }
}
