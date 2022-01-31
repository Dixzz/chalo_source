package defpackage;

import android.os.Process;
import defpackage.nc5;
import java.lang.Thread;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: fc5  reason: default package */
/* compiled from: ExceptionHandler */
public class fc5 implements Thread.UncaughtExceptionHandler {
    public static fc5 b;

    /* renamed from: a  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f1112a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: fc5$a */
    /* compiled from: ExceptionHandler */
    public class a implements nc5.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Throwable f1113a;

        public a(fc5 fc5, Throwable th) {
            this.f1113a = th;
        }

        @Override // defpackage.nc5.b
        public void a(nc5 nc5) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("$ae_crashed_reason", this.f1113a.toString());
                nc5.s("$ae_crashed", jSONObject, true);
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: fc5$b */
    /* compiled from: ExceptionHandler */
    public class b implements nc5.b {
        public b(fc5 fc5) {
        }

        @Override // defpackage.nc5.b
        public void a(nc5 nc5) {
            nc5.g();
        }
    }

    public fc5() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static void a() {
        if (b == null) {
            synchronized (fc5.class) {
                if (b == null) {
                    b = new fc5();
                }
            }
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        nc5.c(new a(this, th));
        nc5.c(new b(this));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f1112a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}
