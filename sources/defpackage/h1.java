package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: h1  reason: default package */
/* compiled from: ViewPropertyAnimatorCompatSet */
public class h1 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<y8> f1327a = new ArrayList<>();
    public long b = -1;
    public Interpolator c;
    public z8 d;
    public boolean e;
    public final a9 f = new a();

    /* renamed from: h1$a */
    /* compiled from: ViewPropertyAnimatorCompatSet */
    public class a extends a9 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1328a = false;
        public int b = 0;

        public a() {
        }

        @Override // defpackage.a9, defpackage.z8
        public void onAnimationEnd(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == h1.this.f1327a.size()) {
                z8 z8Var = h1.this.d;
                if (z8Var != null) {
                    z8Var.onAnimationEnd(null);
                }
                this.b = 0;
                this.f1328a = false;
                h1.this.e = false;
            }
        }

        @Override // defpackage.a9, defpackage.z8
        public void onAnimationStart(View view) {
            if (!this.f1328a) {
                this.f1328a = true;
                z8 z8Var = h1.this.d;
                if (z8Var != null) {
                    z8Var.onAnimationStart(null);
                }
            }
        }
    }

    public void a() {
        if (this.e) {
            Iterator<y8> it = this.f1327a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.e = false;
        }
    }

    public void b() {
        View view;
        if (!this.e) {
            Iterator<y8> it = this.f1327a.iterator();
            while (it.hasNext()) {
                y8 next = it.next();
                long j = this.b;
                if (j >= 0) {
                    next.c(j);
                }
                Interpolator interpolator = this.c;
                if (!(interpolator == null || (view = next.f4016a.get()) == null)) {
                    view.animate().setInterpolator(interpolator);
                }
                if (this.d != null) {
                    next.d(this.f);
                }
                next.g();
            }
            this.e = true;
        }
    }
}
