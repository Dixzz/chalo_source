package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: po5  reason: default package */
/* compiled from: AutomationDaoWrapper */
public class po5 extends oo5 {

    /* renamed from: a  reason: collision with root package name */
    public final oo5 f2834a;

    public po5(oo5 oo5) {
        this.f2834a = oo5;
    }

    @Override // defpackage.oo5
    public void a(wo5 wo5) {
        try {
            this.f2834a.a(wo5);
        } catch (Exception e) {
            yj5.e(e, "Failed to delete schedule %s", wo5);
        }
    }

    @Override // defpackage.oo5
    public List<so5> c() {
        try {
            return this.f2834a.c();
        } catch (Exception e) {
            yj5.e(e, "Failed to get active expired schedules", new Object[0]);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.oo5
    public List<xo5> d(int i) {
        try {
            return this.f2834a.d(i);
        } catch (Exception e) {
            yj5.e(e, "Failed to get active triggers %s", Integer.valueOf(i));
            return Collections.emptyList();
        }
    }

    @Override // defpackage.oo5
    public List<xo5> e(int i, String str) {
        try {
            return this.f2834a.e(i, str);
        } catch (Exception e) {
            yj5.e(e, "Failed to get active triggers %s %s", Integer.valueOf(i), str);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.oo5
    public so5 f(String str) {
        try {
            return this.f2834a.f(str);
        } catch (Exception e) {
            yj5.e(e, "Failed to get schedule with id %s", str);
            return null;
        }
    }

    @Override // defpackage.oo5
    public int g() {
        try {
            return this.f2834a.g();
        } catch (Exception e) {
            yj5.e(e, "Failed to get schedule count", new Object[0]);
            return -1;
        }
    }

    @Override // defpackage.oo5
    public List<so5> h() {
        try {
            return this.f2834a.h();
        } catch (Exception e) {
            yj5.e(e, "Failed to get schedules", new Object[0]);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.oo5
    public List<so5> i(Collection<String> collection) {
        try {
            return this.f2834a.i(collection);
        } catch (Exception e) {
            yj5.e(e, "Failed to get schedules with ids %s", collection);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.oo5
    public List<so5> j(String str) {
        try {
            return this.f2834a.j(str);
        } catch (Exception e) {
            yj5.e(e, "Failed to get schedules by type %s", str);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.oo5
    public List<so5> k(String str) {
        try {
            return this.f2834a.k(str);
        } catch (Exception e) {
            yj5.e(e, "Failed to get schedules with group %s", str);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.oo5
    public List<so5> l(int... iArr) {
        try {
            return this.f2834a.l(iArr);
        } catch (Exception e) {
            yj5.e(e, "Failed to get schedules with state %s", iArr);
            return Collections.emptyList();
        }
    }

    @Override // defpackage.oo5
    public void n(wo5 wo5, List<xo5> list) {
        try {
            this.f2834a.n(wo5, list);
        } catch (Exception e) {
            yj5.e(e, "Failed to insert schedule %s triggers %s", wo5, list);
        }
    }

    @Override // defpackage.oo5
    public void q(wo5 wo5, List<xo5> list) {
        try {
            this.f2834a.q(wo5, list);
        } catch (Exception e) {
            yj5.e(e, "Failed to update schedule %s triggers %s", wo5, list);
        }
    }

    @Override // defpackage.oo5
    public void s(List<xo5> list) {
        try {
            this.f2834a.s(list);
        } catch (Exception e) {
            yj5.e(e, "Failed to update triggers %s", list);
        }
    }
}
