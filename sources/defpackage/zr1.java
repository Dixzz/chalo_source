package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: zr1  reason: default package */
/* compiled from: RequestTracker */
public class zr1 {

    /* renamed from: a  reason: collision with root package name */
    public final Set<os1> f4203a = Collections.newSetFromMap(new WeakHashMap());
    public final List<os1> b = new ArrayList();
    public boolean c;

    public boolean a(os1 os1) {
        boolean z = false;
        if (os1 == null) {
            return false;
        }
        boolean remove = this.f4203a.remove(os1);
        if (this.b.remove(os1) || remove) {
            z = true;
        }
        if (z) {
            os1.clear();
            os1.a();
        }
        return z;
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f4203a.size() + ", isPaused=" + this.c + "}";
    }
}
