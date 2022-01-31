package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: mr1  reason: default package */
/* compiled from: ActivityFragmentLifecycle */
public class mr1 implements tr1 {

    /* renamed from: a  reason: collision with root package name */
    public final Set<ur1> f2430a = Collections.newSetFromMap(new WeakHashMap());
    public boolean b;
    public boolean c;

    @Override // defpackage.tr1
    public void a(ur1 ur1) {
        this.f2430a.add(ur1);
        if (this.c) {
            ur1.l();
        } else if (this.b) {
            ur1.n();
        } else {
            ur1.m();
        }
    }

    @Override // defpackage.tr1
    public void b(ur1 ur1) {
        this.f2430a.remove(ur1);
    }

    public void c() {
        this.c = true;
        Iterator it = ((ArrayList) rt1.e(this.f2430a)).iterator();
        while (it.hasNext()) {
            ((ur1) it.next()).l();
        }
    }

    public void d() {
        this.b = true;
        Iterator it = ((ArrayList) rt1.e(this.f2430a)).iterator();
        while (it.hasNext()) {
            ((ur1) it.next()).n();
        }
    }

    public void e() {
        this.b = false;
        Iterator it = ((ArrayList) rt1.e(this.f2430a)).iterator();
        while (it.hasNext()) {
            ((ur1) it.next()).m();
        }
    }
}
