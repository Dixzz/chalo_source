package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import defpackage.cl;
import defpackage.fl;
import defpackage.qk;
import defpackage.yj;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* renamed from: zj  reason: default package */
/* compiled from: ConcatAdapterController */
public class zj implements qk.b {

    /* renamed from: a  reason: collision with root package name */
    public final yj f4179a;
    public final fl b;
    public List<WeakReference<RecyclerView>> c = new ArrayList();
    public final IdentityHashMap<RecyclerView.a0, qk> d = new IdentityHashMap<>();
    public List<qk> e = new ArrayList();
    public a f = new a();
    public final yj.a.EnumC0068a g;
    public final cl h;

    /* renamed from: zj$a */
    /* compiled from: ConcatAdapterController */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public qk f4180a;
        public int b;
        public boolean c;
    }

    public zj(yj yjVar, yj.a aVar) {
        this.f4179a = yjVar;
        Objects.requireNonNull(aVar);
        this.b = new fl.a();
        yj.a.EnumC0068a aVar2 = aVar.f4054a;
        this.g = aVar2;
        if (aVar2 == yj.a.EnumC0068a.NO_STABLE_IDS) {
            this.h = new cl.b();
        } else if (aVar2 == yj.a.EnumC0068a.ISOLATED_STABLE_IDS) {
            this.h = new cl.a();
        } else if (aVar2 == yj.a.EnumC0068a.SHARED_STABLE_IDS) {
            this.h = new cl.c();
        } else {
            throw new IllegalArgumentException("unknown stable id mode");
        }
    }

    public final void a() {
        RecyclerView.e.a aVar;
        Iterator<qk> it = this.e.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = RecyclerView.e.a.ALLOW;
                break;
            }
            qk next = it.next();
            RecyclerView.e.a stateRestorationPolicy = next.c.getStateRestorationPolicy();
            aVar = RecyclerView.e.a.PREVENT;
            if (stateRestorationPolicy == aVar || (stateRestorationPolicy == RecyclerView.e.a.PREVENT_WHEN_EMPTY && next.e == 0)) {
                break;
            }
        }
        if (aVar != this.f4179a.getStateRestorationPolicy()) {
            this.f4179a.c(aVar);
        }
    }

    public final int b(qk qkVar) {
        qk next;
        Iterator<qk> it = this.e.iterator();
        int i = 0;
        while (it.hasNext() && (next = it.next()) != qkVar) {
            i += next.e;
        }
        return i;
    }

    public final a c(int i) {
        a aVar = this.f;
        if (aVar.c) {
            aVar = new a();
        } else {
            aVar.c = true;
        }
        Iterator<qk> it = this.e.iterator();
        int i2 = i;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            qk next = it.next();
            int i3 = next.e;
            if (i3 > i2) {
                aVar.f4180a = next;
                aVar.b = i2;
                break;
            }
            i2 -= i3;
        }
        if (aVar.f4180a != null) {
            return aVar;
        }
        throw new IllegalArgumentException(hj1.I("Cannot find wrapper for ", i));
    }

    public final qk d(RecyclerView.a0 a0Var) {
        qk qkVar = this.d.get(a0Var);
        if (qkVar != null) {
            return qkVar;
        }
        throw new IllegalStateException("Cannot find wrapper for " + a0Var + ", seems like it is not bound by this adapter: " + this);
    }

    public final void e(a aVar) {
        aVar.c = false;
        aVar.f4180a = null;
        aVar.b = -1;
        this.f = aVar;
    }
}
