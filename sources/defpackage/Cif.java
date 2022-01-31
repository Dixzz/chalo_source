package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: if  reason: invalid class name and default package */
/* compiled from: FragmentManagerViewModel */
public final class Cif extends zh {
    public static final ci i = new a();
    public final HashMap<String, Fragment> c = new HashMap<>();
    public final HashMap<String, Cif> d = new HashMap<>();
    public final HashMap<String, gi> e = new HashMap<>();
    public final boolean f;
    public boolean g = false;
    public boolean h = false;

    /* renamed from: if$a */
    /* compiled from: FragmentManagerViewModel */
    public class a implements ci {
        @Override // defpackage.ci
        public <T extends zh> T a(Class<T> cls) {
            return new Cif(true);
        }
    }

    public Cif(boolean z) {
        this.f = z;
    }

    @Override // defpackage.zh
    public void b() {
        if (FragmentManager.O(3)) {
            String str = "onCleared called for " + this;
        }
        this.g = true;
    }

    public void d(Fragment fragment) {
        if (this.h) {
            FragmentManager.O(2);
        } else if (!this.c.containsKey(fragment.mWho)) {
            this.c.put(fragment.mWho, fragment);
            if (FragmentManager.O(2)) {
                String str = "Updating retained Fragments: Added " + fragment;
            }
        }
    }

    public void e(Fragment fragment) {
        if (this.h) {
            FragmentManager.O(2);
            return;
        }
        if ((this.c.remove(fragment.mWho) != null) && FragmentManager.O(2)) {
            String str = "Updating retained Fragments: Removed " + fragment;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Cif.class != obj.getClass()) {
            return false;
        }
        Cif ifVar = (Cif) obj;
        if (!this.c.equals(ifVar.c) || !this.d.equals(ifVar.d) || !this.e.equals(ifVar.e)) {
            return false;
        }
        return true;
    }

    public boolean f(Fragment fragment) {
        if (this.c.containsKey(fragment.mWho) && this.f) {
            return this.g;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.d.hashCode();
        return this.e.hashCode() + ((hashCode + (this.c.hashCode() * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator<Fragment> it = this.c.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator<String> it2 = this.d.keySet().iterator();
        while (it2.hasNext()) {
            sb.append(it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator<String> it3 = this.e.keySet().iterator();
        while (it3.hasNext()) {
            sb.append(it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
