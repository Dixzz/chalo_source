package defpackage;

import android.annotation.SuppressLint;
import androidx.lifecycle.CompositeGeneratedAdaptersObserver;
import androidx.lifecycle.FullLifecycleObserverAdapter;
import androidx.lifecycle.ReflectiveGenericLifecycleObserver;
import androidx.lifecycle.SingleGeneratedAdapterObserver;
import defpackage.g2;
import defpackage.zg;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: gh  reason: default package */
/* compiled from: LifecycleRegistry */
public class gh extends zg {
    public f2<eh, a> b = new f2<>();
    public zg.b c;
    public final WeakReference<fh> d;
    public int e = 0;
    public boolean f = false;
    public boolean g = false;
    public ArrayList<zg.b> h = new ArrayList<>();
    public final boolean i;

    /* renamed from: gh$a */
    /* compiled from: LifecycleRegistry */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public zg.b f1259a;
        public dh b;

        public a(eh ehVar, zg.b bVar) {
            dh dhVar;
            Map<Class<?>, Integer> map = jh.f1924a;
            boolean z = ehVar instanceof dh;
            boolean z2 = ehVar instanceof xg;
            if (z && z2) {
                dhVar = new FullLifecycleObserverAdapter((xg) ehVar, (dh) ehVar);
            } else if (z2) {
                dhVar = new FullLifecycleObserverAdapter((xg) ehVar, null);
            } else if (z) {
                dhVar = (dh) ehVar;
            } else {
                Class<?> cls = ehVar.getClass();
                if (jh.c(cls) == 2) {
                    List<Constructor<? extends yg>> list = jh.b.get(cls);
                    if (list.size() == 1) {
                        dhVar = new SingleGeneratedAdapterObserver(jh.a(list.get(0), ehVar));
                    } else {
                        yg[] ygVarArr = new yg[list.size()];
                        for (int i = 0; i < list.size(); i++) {
                            ygVarArr[i] = jh.a(list.get(i), ehVar);
                        }
                        dhVar = new CompositeGeneratedAdaptersObserver(ygVarArr);
                    }
                } else {
                    dhVar = new ReflectiveGenericLifecycleObserver(ehVar);
                }
            }
            this.b = dhVar;
            this.f1259a = bVar;
        }

        public void a(fh fhVar, zg.a aVar) {
            zg.b targetState = aVar.getTargetState();
            this.f1259a = gh.f(this.f1259a, targetState);
            this.b.c(fhVar, aVar);
            this.f1259a = targetState;
        }
    }

    public gh(fh fhVar) {
        this.d = new WeakReference<>(fhVar);
        this.c = zg.b.INITIALIZED;
        this.i = true;
    }

    public static zg.b f(zg.b bVar, zg.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    @Override // defpackage.zg
    public void a(eh ehVar) {
        fh fhVar;
        d("addObserver");
        zg.b bVar = this.c;
        zg.b bVar2 = zg.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = zg.b.INITIALIZED;
        }
        a aVar = new a(ehVar, bVar2);
        if (this.b.k(ehVar, aVar) == null && (fhVar = this.d.get()) != null) {
            boolean z = this.e != 0 || this.f;
            zg.b c2 = c(ehVar);
            this.e++;
            while (aVar.f1259a.compareTo((Enum) c2) < 0 && this.b.j.containsKey(ehVar)) {
                this.h.add(aVar.f1259a);
                zg.a upFrom = zg.a.upFrom(aVar.f1259a);
                if (upFrom != null) {
                    aVar.a(fhVar, upFrom);
                    h();
                    c2 = c(ehVar);
                } else {
                    StringBuilder i0 = hj1.i0("no event up from ");
                    i0.append(aVar.f1259a);
                    throw new IllegalStateException(i0.toString());
                }
            }
            if (!z) {
                j();
            }
            this.e--;
        }
    }

    @Override // defpackage.zg
    public void b(eh ehVar) {
        d("removeObserver");
        this.b.n(ehVar);
    }

    public final zg.b c(eh ehVar) {
        f2<eh, a> f2Var = this.b;
        zg.b bVar = null;
        g2.c<K, V> cVar = f2Var.j.containsKey(ehVar) ? f2Var.j.get(ehVar).i : null;
        zg.b bVar2 = cVar != null ? cVar.g.f1259a : null;
        if (!this.h.isEmpty()) {
            ArrayList<zg.b> arrayList = this.h;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return f(f(this.c, bVar2), bVar);
    }

    @SuppressLint({"RestrictedApi"})
    public final void d(String str) {
        if (this.i && !c2.d().b()) {
            throw new IllegalStateException(hj1.T("Method ", str, " must be called on the main thread"));
        }
    }

    public void e(zg.a aVar) {
        d("handleLifecycleEvent");
        g(aVar.getTargetState());
    }

    public final void g(zg.b bVar) {
        if (this.c != bVar) {
            this.c = bVar;
            if (this.f || this.e != 0) {
                this.g = true;
                return;
            }
            this.f = true;
            j();
            this.f = false;
        }
    }

    public final void h() {
        ArrayList<zg.b> arrayList = this.h;
        arrayList.remove(arrayList.size() - 1);
    }

    public void i(zg.b bVar) {
        d("setCurrentState");
        g(bVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: f2<eh, gh$a> */
    /* JADX DEBUG: Multi-variable search result rejected for r4v13, resolved type: f2<eh, gh$a> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void j() {
        zg.b bVar;
        fh fhVar = this.d.get();
        if (fhVar != null) {
            while (true) {
                f2<eh, a> f2Var = this.b;
                boolean z = true;
                if (!(f2Var.i == 0 || (f2Var.f.g.f1259a == (bVar = f2Var.g.g.f1259a) && this.c == bVar))) {
                    z = false;
                }
                if (!z) {
                    this.g = false;
                    if (this.c.compareTo((Enum) f2Var.f.g.f1259a) < 0) {
                        f2<eh, a> f2Var2 = this.b;
                        g2.b bVar2 = new g2.b(f2Var2.g, f2Var2.f);
                        f2Var2.h.put(bVar2, Boolean.FALSE);
                        while (bVar2.hasNext() && !this.g) {
                            Map.Entry entry = (Map.Entry) bVar2.next();
                            a aVar = (a) entry.getValue();
                            while (aVar.f1259a.compareTo((Enum) this.c) > 0 && !this.g && this.b.contains(entry.getKey())) {
                                zg.a downFrom = zg.a.downFrom(aVar.f1259a);
                                if (downFrom != null) {
                                    this.h.add(downFrom.getTargetState());
                                    aVar.a(fhVar, downFrom);
                                    h();
                                } else {
                                    StringBuilder i0 = hj1.i0("no event down from ");
                                    i0.append(aVar.f1259a);
                                    throw new IllegalStateException(i0.toString());
                                }
                            }
                        }
                    }
                    g2.c<K, V> cVar = this.b.g;
                    if (!this.g && cVar != null && this.c.compareTo((Enum) cVar.g.f1259a) > 0) {
                        g2<K, V>.d d2 = this.b.d();
                        while (d2.hasNext() && !this.g) {
                            Map.Entry entry2 = (Map.Entry) d2.next();
                            a aVar2 = (a) entry2.getValue();
                            while (aVar2.f1259a.compareTo((Enum) this.c) < 0 && !this.g && this.b.contains(entry2.getKey())) {
                                this.h.add(aVar2.f1259a);
                                zg.a upFrom = zg.a.upFrom(aVar2.f1259a);
                                if (upFrom != null) {
                                    aVar2.a(fhVar, upFrom);
                                    h();
                                } else {
                                    StringBuilder i02 = hj1.i0("no event up from ");
                                    i02.append(aVar2.f1259a);
                                    throw new IllegalStateException(i02.toString());
                                }
                            }
                        }
                    }
                } else {
                    this.g = false;
                    return;
                }
            }
        } else {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
    }
}
