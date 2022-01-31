package defpackage;

import android.os.Handler;
import android.os.Looper;
import com.urbanairship.iam.InAppMessage;
import defpackage.ar5;

/* renamed from: yq5  reason: default package */
/* compiled from: DefaultDisplayCoordinator */
public class yq5 extends ar5 {
    public InAppMessage b = null;
    public boolean c = false;
    public final Handler d = new Handler(Looper.getMainLooper());
    public long e;
    public final Runnable f = new a();

    /* renamed from: yq5$a */
    /* compiled from: DefaultDisplayCoordinator */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            yq5 yq5 = yq5.this;
            if (yq5.b == null) {
                yq5.c = false;
                ar5.a aVar = yq5.f324a;
                if (aVar != null) {
                    mm5 mm5 = dn5.this.h;
                    if (mm5.h) {
                        mm5.m();
                    }
                }
            }
        }
    }

    public yq5(long j) {
        this.e = j;
    }

    @Override // defpackage.ar5
    public boolean a() {
        if (this.b != null) {
            return false;
        }
        return !this.c;
    }

    @Override // defpackage.ar5
    public void b(InAppMessage inAppMessage) {
        this.b = null;
        this.d.postDelayed(this.f, this.e);
    }

    @Override // defpackage.ar5
    public void c(InAppMessage inAppMessage) {
        this.b = inAppMessage;
        this.c = true;
        this.d.removeCallbacks(this.f);
    }
}
