package defpackage;

import java.util.Collection;
import java.util.List;

/* renamed from: oo5  reason: default package */
/* compiled from: AutomationDao */
public abstract class oo5 {
    public abstract void a(wo5 wo5);

    public void b(Collection<so5> collection) {
        for (so5 so5 : collection) {
            if (so5 != null) {
                a(so5.f3238a);
            }
        }
    }

    public abstract List<so5> c();

    public abstract List<xo5> d(int i);

    public abstract List<xo5> e(int i, String str);

    public abstract so5 f(String str);

    public abstract int g();

    public abstract List<so5> h();

    public abstract List<so5> i(Collection<String> collection);

    public abstract List<so5> j(String str);

    public abstract List<so5> k(String str);

    public abstract List<so5> l(int... iArr);

    public void m(so5 so5) {
        n(so5.f3238a, so5.b);
    }

    public abstract void n(wo5 wo5, List<xo5> list);

    public void o(Collection<so5> collection) {
        for (so5 so5 : collection) {
            if (so5 != null) {
                m(so5);
            }
        }
    }

    public void p(so5 so5) {
        q(so5.f3238a, so5.b);
    }

    public abstract void q(wo5 wo5, List<xo5> list);

    public void r(Collection<so5> collection) {
        for (so5 so5 : collection) {
            if (so5 != null) {
                p(so5);
            }
        }
    }

    public abstract void s(List<xo5> list);
}
