package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import defpackage.kn;

/* renamed from: eo  reason: default package */
/* compiled from: Visibility */
public abstract class eo extends kn {
    public static final String[] D = {"android:visibility:visibility", "android:visibility:parent"};
    public int C = 3;

    /* renamed from: eo$a */
    /* compiled from: Visibility */
    public static class a extends AnimatorListenerAdapter implements kn.d {

        /* renamed from: a  reason: collision with root package name */
        public final View f1009a;
        public final int b;
        public final ViewGroup c;
        public final boolean d;
        public boolean e;
        public boolean f = false;

        public a(View view, int i, boolean z) {
            this.f1009a = view;
            this.b = i;
            this.c = (ViewGroup) view.getParent();
            this.d = z;
            g(true);
        }

        @Override // defpackage.kn.d
        public void a(kn knVar) {
        }

        @Override // defpackage.kn.d
        public void b(kn knVar) {
            g(false);
        }

        @Override // defpackage.kn.d
        public void c(kn knVar) {
            f();
            knVar.w(this);
        }

        @Override // defpackage.kn.d
        public void d(kn knVar) {
        }

        @Override // defpackage.kn.d
        public void e(kn knVar) {
            g(true);
        }

        public final void f() {
            if (!this.f) {
                wn.f3805a.f(this.f1009a, this.b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z) {
            ViewGroup viewGroup;
            if (this.d && this.e != z && (viewGroup = this.c) != null) {
                this.e = z;
                un.a(viewGroup, z);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        public void onAnimationEnd(Animator animator) {
            f();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f) {
                wn.f3805a.f(this.f1009a, this.b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f) {
                wn.f3805a.f(this.f1009a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: eo$b */
    /* compiled from: Visibility */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1010a;
        public boolean b;
        public int c;
        public int d;
        public ViewGroup e;
        public ViewGroup f;
    }

    public final void I(sn snVar) {
        snVar.f3229a.put("android:visibility:visibility", Integer.valueOf(snVar.b.getVisibility()));
        snVar.f3229a.put("android:visibility:parent", snVar.b.getParent());
        int[] iArr = new int[2];
        snVar.b.getLocationOnScreen(iArr);
        snVar.f3229a.put("android:visibility:screenLocation", iArr);
    }

    public final b J(sn snVar, sn snVar2) {
        b bVar = new b();
        bVar.f1010a = false;
        bVar.b = false;
        if (snVar == null || !snVar.f3229a.containsKey("android:visibility:visibility")) {
            bVar.c = -1;
            bVar.e = null;
        } else {
            bVar.c = ((Integer) snVar.f3229a.get("android:visibility:visibility")).intValue();
            bVar.e = (ViewGroup) snVar.f3229a.get("android:visibility:parent");
        }
        if (snVar2 == null || !snVar2.f3229a.containsKey("android:visibility:visibility")) {
            bVar.d = -1;
            bVar.f = null;
        } else {
            bVar.d = ((Integer) snVar2.f3229a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) snVar2.f3229a.get("android:visibility:parent");
        }
        if (snVar != null && snVar2 != null) {
            int i = bVar.c;
            int i2 = bVar.d;
            if (i == i2 && bVar.e == bVar.f) {
                return bVar;
            }
            if (i != i2) {
                if (i == 0) {
                    bVar.b = false;
                    bVar.f1010a = true;
                } else if (i2 == 0) {
                    bVar.b = true;
                    bVar.f1010a = true;
                }
            } else if (bVar.f == null) {
                bVar.b = false;
                bVar.f1010a = true;
            } else if (bVar.e == null) {
                bVar.b = true;
                bVar.f1010a = true;
            }
        } else if (snVar == null && bVar.d == 0) {
            bVar.b = true;
            bVar.f1010a = true;
        } else if (snVar2 == null && bVar.c == 0) {
            bVar.b = false;
            bVar.f1010a = true;
        }
        return bVar;
    }

    public abstract Animator K(ViewGroup viewGroup, View view, sn snVar, sn snVar2);

    @Override // defpackage.kn
    public void d(sn snVar) {
        I(snVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        if (J(o(r1, false), r(r1, false)).f1010a != false) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01f9  */
    @Override // defpackage.kn
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator k(android.view.ViewGroup r24, defpackage.sn r25, defpackage.sn r26) {
        /*
        // Method dump skipped, instructions count: 703
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.eo.k(android.view.ViewGroup, sn, sn):android.animation.Animator");
    }

    @Override // defpackage.kn
    public String[] q() {
        return D;
    }

    @Override // defpackage.kn
    public boolean s(sn snVar, sn snVar2) {
        if (snVar == null && snVar2 == null) {
            return false;
        }
        if (snVar != null && snVar2 != null && snVar2.f3229a.containsKey("android:visibility:visibility") != snVar.f3229a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b J = J(snVar, snVar2);
        if (!J.f1010a) {
            return false;
        }
        if (J.c == 0 || J.d == 0) {
            return true;
        }
        return false;
    }
}
