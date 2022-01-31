package defpackage;

/* renamed from: x2  reason: default package */
/* compiled from: CallbackToFutureAdapter */
public final class x2<T> {

    /* renamed from: a  reason: collision with root package name */
    public Object f3872a;
    public z2<T> b;
    public a3<Void> c = new a3<>();
    public boolean d;

    public boolean a(T t) {
        boolean z = true;
        this.d = true;
        z2<T> z2Var = this.b;
        if (z2Var == null || !z2Var.g.i(t)) {
            z = false;
        }
        if (z) {
            this.f3872a = null;
            this.b = null;
            this.c = null;
        }
        return z;
    }

    public void finalize() {
        a3<Void> a3Var;
        z2<T> z2Var = this.b;
        if (z2Var != null && !z2Var.isDone()) {
            StringBuilder i0 = hj1.i0("The completer object was garbage collected - this future would otherwise never complete. The tag was: ");
            i0.append(this.f3872a);
            z2Var.g.j(new y2(i0.toString()));
        }
        if (!this.d && (a3Var = this.c) != null) {
            a3Var.i(null);
        }
    }
}
