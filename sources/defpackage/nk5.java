package defpackage;

/* renamed from: nk5  reason: default package */
/* compiled from: Action */
public abstract class nk5 {
    public boolean a(ok5 ok5) {
        return true;
    }

    public void b() {
    }

    public void c() {
    }

    public abstract rk5 d(ok5 ok5);

    public final rk5 e(ok5 ok5) {
        try {
            if (!a(ok5)) {
                yj5.a("Action %s is unable to accept arguments: %s", this, ok5);
                return rk5.b(2);
            }
            yj5.f("Running action: %s arguments: %s", this, ok5);
            c();
            rk5 d = d(ok5);
            if (d == null) {
                d = rk5.a();
            }
            b();
            return d;
        } catch (Exception e) {
            yj5.e(e, "Failed to run action %s", this);
            return rk5.c(e);
        }
    }

    public boolean f() {
        return false;
    }
}
