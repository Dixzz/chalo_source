package defpackage;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* renamed from: lf  reason: default package */
/* compiled from: FragmentStore */
public class lf {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Fragment> f2206a = new ArrayList<>();
    public final HashMap<String, kf> b = new HashMap<>();
    public Cif c;

    public void a(Fragment fragment) {
        if (!this.f2206a.contains(fragment)) {
            synchronized (this.f2206a) {
                this.f2206a.add(fragment);
            }
            fragment.mAdded = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    public void b() {
        this.b.values().removeAll(Collections.singleton(null));
    }

    public boolean c(String str) {
        return this.b.get(str) != null;
    }

    public Fragment d(String str) {
        kf kfVar = this.b.get(str);
        if (kfVar != null) {
            return kfVar.c;
        }
        return null;
    }

    public Fragment e(String str) {
        Fragment findFragmentByWho;
        for (kf kfVar : this.b.values()) {
            if (!(kfVar == null || (findFragmentByWho = kfVar.c.findFragmentByWho(str)) == null)) {
                return findFragmentByWho;
            }
        }
        return null;
    }

    public List<kf> f() {
        ArrayList arrayList = new ArrayList();
        for (kf kfVar : this.b.values()) {
            if (kfVar != null) {
                arrayList.add(kfVar);
            }
        }
        return arrayList;
    }

    public List<Fragment> g() {
        ArrayList arrayList = new ArrayList();
        for (kf kfVar : this.b.values()) {
            if (kfVar != null) {
                arrayList.add(kfVar.c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public kf h(String str) {
        return this.b.get(str);
    }

    public List<Fragment> i() {
        ArrayList arrayList;
        if (this.f2206a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f2206a) {
            arrayList = new ArrayList(this.f2206a);
        }
        return arrayList;
    }

    public void j(kf kfVar) {
        Fragment fragment = kfVar.c;
        if (!c(fragment.mWho)) {
            this.b.put(fragment.mWho, kfVar);
            if (fragment.mRetainInstanceChangedWhileDetached) {
                if (fragment.mRetainInstance) {
                    this.c.d(fragment);
                } else {
                    this.c.e(fragment);
                }
                fragment.mRetainInstanceChangedWhileDetached = false;
            }
            if (FragmentManager.O(2)) {
                String str = "Added fragment to active set " + fragment;
            }
        }
    }

    public void k(kf kfVar) {
        Fragment fragment = kfVar.c;
        if (fragment.mRetainInstance) {
            this.c.e(fragment);
        }
        if (this.b.put(fragment.mWho, null) != null && FragmentManager.O(2)) {
            String str = "Removed fragment from active set " + fragment;
        }
    }

    public void l(Fragment fragment) {
        synchronized (this.f2206a) {
            this.f2206a.remove(fragment);
        }
        fragment.mAdded = false;
    }
}
