package defpackage;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ik5  reason: default package */
/* compiled from: PrivacyManager */
public class ik5 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f1529a = new Object();
    public final List<a> b = new CopyOnWriteArrayList();
    public final hk5 c;
    public volatile int d;

    /* renamed from: ik5$a */
    /* compiled from: PrivacyManager */
    public interface a {
        void a();
    }

    public ik5(hk5 hk5, int i) {
        this.c = hk5;
        this.d = hk5.c("com.urbanairship.PrivacyManager.enabledFeatures", i);
    }

    public static int a(int... iArr) {
        if (iArr == null) {
            return 0;
        }
        int i = 0;
        for (int i2 : iArr) {
            i |= i2;
        }
        return i;
    }

    public boolean b(int... iArr) {
        int i = this.d;
        for (int i2 : iArr) {
            if ((i2 == 0 && i == 0) || (i & i2) == i2) {
                return true;
            }
        }
        return false;
    }

    public boolean c() {
        return this.d != 0;
    }

    public boolean d(int... iArr) {
        int i = this.d;
        int a2 = a(iArr);
        return a2 == 0 ? i == 0 : (i & a2) == a2;
    }

    public void e(int... iArr) {
        f(a(iArr));
    }

    public final void f(int i) {
        synchronized (this.f1529a) {
            if (this.d != i) {
                this.d = i;
                this.c.f("com.urbanairship.PrivacyManager.enabledFeatures").b(String.valueOf(i));
                for (a aVar : this.b) {
                    aVar.a();
                }
            }
        }
    }
}
