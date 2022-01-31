package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: bs1  reason: default package */
/* compiled from: TargetTracker */
public final class bs1 implements ur1 {
    public final Set<ct1<?>> f = Collections.newSetFromMap(new WeakHashMap());

    @Override // defpackage.ur1
    public void l() {
        Iterator it = ((ArrayList) rt1.e(this.f)).iterator();
        while (it.hasNext()) {
            ((ct1) it.next()).l();
        }
    }

    @Override // defpackage.ur1
    public void m() {
        Iterator it = ((ArrayList) rt1.e(this.f)).iterator();
        while (it.hasNext()) {
            ((ct1) it.next()).m();
        }
    }

    @Override // defpackage.ur1
    public void n() {
        Iterator it = ((ArrayList) rt1.e(this.f)).iterator();
        while (it.hasNext()) {
            ((ct1) it.next()).n();
        }
    }
}
