package defpackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/* renamed from: bj  reason: default package */
/* compiled from: NavControllerViewModel */
public class bj extends zh {
    public static final ci d = new a();
    public final HashMap<UUID, gi> c = new HashMap<>();

    /* renamed from: bj$a */
    /* compiled from: NavControllerViewModel */
    public class a implements ci {
        @Override // defpackage.ci
        public <T extends zh> T a(Class<T> cls) {
            return new bj();
        }
    }

    public static bj d(gi giVar) {
        zh zhVar;
        ci ciVar = d;
        String canonicalName = bj.class.getCanonicalName();
        if (canonicalName != null) {
            String S = hj1.S("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
            zh zhVar2 = giVar.f1264a.get(S);
            if (!bj.class.isInstance(zhVar2)) {
                if (ciVar instanceof di) {
                    zhVar = ((di) ciVar).c(S, bj.class);
                } else {
                    zhVar = ciVar.a(bj.class);
                }
                zhVar2 = zhVar;
                zh put = giVar.f1264a.put(S, zhVar2);
                if (put != null) {
                    put.b();
                }
            } else if (ciVar instanceof fi) {
                ((fi) ciVar).b(zhVar2);
            }
            return (bj) zhVar2;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // defpackage.zh
    public void b() {
        for (gi giVar : this.c.values()) {
            giVar.a();
        }
        this.c.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} ViewModelStores (");
        Iterator<UUID> it = this.c.keySet().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
