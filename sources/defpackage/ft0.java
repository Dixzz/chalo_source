package defpackage;

import android.os.Handler;

/* renamed from: ft0  reason: default package */
/* compiled from: AutoHideLoaderFragment */
public class ft0 extends fv0 {
    public int g = 0;
    public final b h;

    /* renamed from: ft0$a */
    /* compiled from: AutoHideLoaderFragment */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (ft0.this.isVisible() && ft0.this.isAdded()) {
                ft0.this.dismiss();
                ft0.this.h.a();
            }
        }
    }

    /* renamed from: ft0$b */
    /* compiled from: AutoHideLoaderFragment */
    public interface b {
        void a();
    }

    public ft0(int i, b bVar) {
        this.g = i;
        this.h = bVar;
    }

    @Override // defpackage.fv0
    public void onStart() {
        super.onStart();
        new Handler().postDelayed(new a(), (long) this.g);
    }
}
