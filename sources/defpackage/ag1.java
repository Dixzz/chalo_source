package defpackage;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import app.zophop.models.mTicketing.ProductDiscountsObject;

/* renamed from: ag1  reason: default package */
/* compiled from: SlidingTabFragmentAdapter */
public abstract class ag1 extends ro implements xf1 {
    public final FragmentManager c;
    public FragmentTransaction d = null;
    public Fragment e = null;

    public ag1(FragmentManager fragmentManager) {
        this.c = fragmentManager;
    }

    public static String m(int i, long j) {
        return "android:switcher:" + i + ProductDiscountsObject.KEY_DELIMITER + j;
    }

    @Override // defpackage.ro
    public void b(ViewGroup viewGroup, int i, Object obj) {
        if (this.d == null) {
            this.d = this.c.beginTransaction();
        }
        this.d.detach((Fragment) obj);
    }

    @Override // defpackage.ro
    public void c(ViewGroup viewGroup) {
        FragmentTransaction fragmentTransaction = this.d;
        if (fragmentTransaction != null) {
            fragmentTransaction.commitAllowingStateLoss();
            this.d = null;
            this.c.executePendingTransactions();
        }
    }

    @Override // defpackage.ro
    public Object f(ViewGroup viewGroup, int i) {
        if (this.d == null) {
            this.d = this.c.beginTransaction();
        }
        long j = (long) i;
        Fragment findFragmentByTag = this.c.findFragmentByTag(m(viewGroup.getId(), j));
        if (findFragmentByTag != null) {
            this.d.attach(findFragmentByTag);
        } else {
            findFragmentByTag = l(i);
            this.d.add(viewGroup.getId(), findFragmentByTag, m(viewGroup.getId(), j));
        }
        if (findFragmentByTag != this.e) {
            findFragmentByTag.setMenuVisibility(false);
            ig.f1516a.a(findFragmentByTag, false);
        }
        return findFragmentByTag;
    }

    @Override // defpackage.ro
    public boolean g(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // defpackage.ro
    public void h(Parcelable parcelable, ClassLoader classLoader) {
    }

    @Override // defpackage.ro
    public /* bridge */ /* synthetic */ Parcelable i() {
        return null;
    }

    @Override // defpackage.ro
    public void j(ViewGroup viewGroup, int i, Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                ig.f1516a.a(this.e, false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                ig.f1516a.a(fragment, true);
            }
            this.e = fragment;
        }
    }

    @Override // defpackage.ro
    public void k(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }

    @Deprecated
    public abstract Fragment l(int i);
}
