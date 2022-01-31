package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: gf  reason: default package */
/* compiled from: FragmentLifecycleCallbacksDispatcher */
public class gf {

    /* renamed from: a  reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f1251a = new CopyOnWriteArrayList<>();
    public final FragmentManager b;

    /* renamed from: gf$a */
    /* compiled from: FragmentLifecycleCallbacksDispatcher */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final FragmentManager.k f1252a;
        public final boolean b;

        public a(FragmentManager.k kVar, boolean z) {
            this.f1252a = kVar;
            this.b = z;
        }
    }

    public gf(FragmentManager fragmentManager) {
        this.b = fragmentManager;
    }

    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.a(fragment, bundle, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void b(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.b;
        Context context = fragmentManager.q.g;
        Fragment fragment2 = fragmentManager.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.b(fragment, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.c(fragment, bundle, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void d(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.d(fragment, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void e(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.e(fragment, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void f(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.f(fragment, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void g(Fragment fragment, boolean z) {
        FragmentManager fragmentManager = this.b;
        Context context = fragmentManager.q.g;
        Fragment fragment2 = fragmentManager.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.g(fragment, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.h(fragment, bundle, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void i(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.i(fragment, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.j(fragment, bundle, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void k(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.k(fragment, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void l(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.l(fragment, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }

    public void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.m(fragment, view, bundle, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                FragmentManager.k kVar = next.f1252a;
                FragmentManager fragmentManager = this.b;
                uo uoVar = (uo) kVar;
                if (fragment == uoVar.f3530a) {
                    gf gfVar = fragmentManager.n;
                    synchronized (gfVar.f1251a) {
                        int i = 0;
                        int size = gfVar.f1251a.size();
                        while (true) {
                            if (i >= size) {
                                break;
                            } else if (gfVar.f1251a.get(i).f1252a == uoVar) {
                                gfVar.f1251a.remove(i);
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                    uoVar.c.c(view, uoVar.b);
                } else {
                    continue;
                }
            }
        }
    }

    public void n(Fragment fragment, boolean z) {
        Fragment fragment2 = this.b.s;
        if (fragment2 != null) {
            fragment2.getParentFragmentManager().n.n(fragment, true);
        }
        Iterator<a> it = this.f1251a.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!z || next.b) {
                Objects.requireNonNull(next.f1252a);
            }
        }
    }
}
