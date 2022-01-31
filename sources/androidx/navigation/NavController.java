package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Parcelable;
import defpackage.zg;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

public class NavController {

    /* renamed from: a  reason: collision with root package name */
    public final Context f226a;
    public Activity b;
    public jj c;
    public gj d;
    public Bundle e;
    public Parcelable[] f;
    public boolean g;
    public final Deque<aj> h = new ArrayDeque();
    public fh i;
    public bj j;
    public nj k = new nj();
    public final CopyOnWriteArrayList<b> l = new CopyOnWriteArrayList<>();
    public final eh m = new dh() {
        /* class androidx.navigation.NavController.AnonymousClass1 */

        @Override // defpackage.dh
        public void c(fh fhVar, zg.a aVar) {
            zg.b bVar;
            NavController navController = NavController.this;
            if (navController.d != null) {
                for (aj ajVar : navController.h) {
                    Objects.requireNonNull(ajVar);
                    int ordinal = aVar.ordinal();
                    if (ordinal != 0) {
                        if (ordinal != 1) {
                            if (ordinal == 2) {
                                bVar = zg.b.RESUMED;
                            } else if (ordinal != 3) {
                                if (ordinal != 4) {
                                    if (ordinal == 5) {
                                        bVar = zg.b.DESTROYED;
                                    } else {
                                        throw new IllegalArgumentException("Unexpected event value " + aVar);
                                    }
                                }
                            }
                            ajVar.k = bVar;
                            ajVar.a();
                        }
                        bVar = zg.b.STARTED;
                        ajVar.k = bVar;
                        ajVar.a();
                    }
                    bVar = zg.b.CREATED;
                    ajVar.k = bVar;
                    ajVar.a();
                }
            }
        }
    };
    public final l n = new a(false);
    public boolean o = true;

    public class a extends l {
        public a(boolean z) {
            super(z);
        }

        @Override // defpackage.l
        public void a() {
            NavController.this.g();
        }
    }

    public interface b {
        void a(NavController navController, ej ejVar, Bundle bundle);
    }

    public NavController(Context context) {
        this.f226a = context;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            } else if (context instanceof Activity) {
                this.b = (Activity) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        nj njVar = this.k;
        njVar.a(new hj(njVar));
        this.k.a(new ti(this.f226a));
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0009  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
        // Method dump skipped, instructions count: 250
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.a():boolean");
    }

    public ej b(int i2) {
        ej ejVar;
        gj gjVar;
        gj gjVar2 = this.d;
        if (gjVar2 == null) {
            return null;
        }
        if (gjVar2.h == i2) {
            return gjVar2;
        }
        if (this.h.isEmpty()) {
            ejVar = this.d;
        } else {
            ejVar = this.h.getLast().f;
        }
        if (ejVar instanceof gj) {
            gjVar = (gj) ejVar;
        } else {
            gjVar = ejVar.g;
        }
        return gjVar.z(i2, true);
    }

    public ej c() {
        aj ajVar;
        if (this.h.isEmpty()) {
            ajVar = null;
        } else {
            ajVar = this.h.getLast();
        }
        if (ajVar != null) {
            return ajVar.f;
        }
        return null;
    }

    public final int d() {
        int i2 = 0;
        for (aj ajVar : this.h) {
            if (!(ajVar.f instanceof gj)) {
                i2++;
            }
        }
        return i2;
    }

    public jj e() {
        if (this.c == null) {
            this.c = new jj(this.f226a, this.k);
        }
        return this.c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027 A[LOOP:0: B:10:0x0027->B:15:0x004d, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(defpackage.ej r12, android.os.Bundle r13, defpackage.kj r14, defpackage.mj.a r15) {
        /*
        // Method dump skipped, instructions count: 370
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.f(ej, android.os.Bundle, kj, mj$a):void");
    }

    public boolean g() {
        if (!this.h.isEmpty() && h(c().h, true) && a()) {
            return true;
        }
        return false;
    }

    public boolean h(int i2, boolean z) {
        boolean z2;
        gi remove;
        boolean z3 = false;
        if (this.h.isEmpty()) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<aj> descendingIterator = this.h.descendingIterator();
        while (true) {
            if (!descendingIterator.hasNext()) {
                z2 = false;
                break;
            }
            ej ejVar = descendingIterator.next().f;
            mj c2 = this.k.c(ejVar.f);
            if (z || ejVar.h != i2) {
                arrayList.add(c2);
            }
            if (ejVar.h == i2) {
                z2 = true;
                break;
            }
        }
        if (!z2) {
            ej.k(this.f226a, i2);
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext() && ((mj) it.next()).e()) {
            aj removeLast = this.h.removeLast();
            if (removeLast.h.c.isAtLeast(zg.b.CREATED)) {
                removeLast.l = zg.b.DESTROYED;
                removeLast.a();
            }
            bj bjVar = this.j;
            if (!(bjVar == null || (remove = bjVar.c.remove(removeLast.j)) == null)) {
                remove.a();
            }
            z3 = true;
        }
        j();
        return z3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0263, code lost:
        if (r1 == false) goto L_0x0266;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i(defpackage.gj r19, android.os.Bundle r20) {
        /*
        // Method dump skipped, instructions count: 629
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavController.i(gj, android.os.Bundle):void");
    }

    public final void j() {
        l lVar = this.n;
        boolean z = true;
        if (!this.o || d() <= 1) {
            z = false;
        }
        lVar.f2142a = z;
    }
}
