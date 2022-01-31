package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import defpackage.gf;
import defpackage.zg;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import server.zophop.Constants;

public abstract class FragmentStateAdapter extends RecyclerView.e<yo> implements zo {
    public final zg f;
    public final FragmentManager g;
    public final r2<Fragment> h = new r2<>();
    public final r2<Fragment.SavedState> i = new r2<>();
    public final r2<Integer> j = new r2<>();
    public b k;
    public boolean l = false;
    public boolean m = false;

    public static abstract class a extends RecyclerView.g {
        public a(to toVar) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void b(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void c(int i, int i2, Object obj) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void d(int i, int i2) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void e(int i, int i2, int i3) {
            a();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public final void f(int i, int i2) {
            a();
        }
    }

    public class b {

        /* renamed from: a  reason: collision with root package name */
        public ViewPager2.e f253a;
        public RecyclerView.g b;
        public dh c;
        public ViewPager2 d;
        public long e = -1;

        public b() {
        }

        public final ViewPager2 a(RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void b(boolean z) {
            int currentItem;
            Fragment f2;
            if (!FragmentStateAdapter.this.k() && this.d.getScrollState() == 0 && !FragmentStateAdapter.this.h.h() && FragmentStateAdapter.this.getItemCount() != 0 && (currentItem = this.d.getCurrentItem()) < FragmentStateAdapter.this.getItemCount()) {
                Objects.requireNonNull(FragmentStateAdapter.this);
                long j = (long) currentItem;
                if ((j != this.e || z) && (f2 = FragmentStateAdapter.this.h.f(j)) != null && f2.isAdded()) {
                    this.e = j;
                    ke keVar = new ke(FragmentStateAdapter.this.g);
                    Fragment fragment = null;
                    for (int i = 0; i < FragmentStateAdapter.this.h.l(); i++) {
                        long i2 = FragmentStateAdapter.this.h.i(i);
                        Fragment m = FragmentStateAdapter.this.h.m(i);
                        if (m.isAdded()) {
                            if (i2 != this.e) {
                                keVar.q(m, zg.b.STARTED);
                            } else {
                                fragment = m;
                            }
                            m.setMenuVisibility(i2 == this.e);
                        }
                    }
                    if (fragment != null) {
                        keVar.q(fragment, zg.b.RESUMED);
                    }
                    if (!keVar.f2365a.isEmpty()) {
                        keVar.e();
                    }
                }
            }
        }
    }

    public FragmentStateAdapter(ve veVar) {
        FragmentManager supportFragmentManager = veVar.getSupportFragmentManager();
        zg lifecycle = veVar.getLifecycle();
        this.g = supportFragmentManager;
        this.f = lifecycle;
        super.setHasStableIds(true);
    }

    public static boolean g(String str, String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    @Override // defpackage.zo
    public final Parcelable a() {
        Bundle bundle = new Bundle(this.i.l() + this.h.l());
        for (int i2 = 0; i2 < this.h.l(); i2++) {
            long i3 = this.h.i(i2);
            Fragment f2 = this.h.f(i3);
            if (f2 != null && f2.isAdded()) {
                String M = hj1.M("f#", i3);
                FragmentManager fragmentManager = this.g;
                Objects.requireNonNull(fragmentManager);
                if (f2.mFragmentManager == fragmentManager) {
                    bundle.putString(M, f2.mWho);
                } else {
                    fragmentManager.k0(new IllegalStateException(hj1.O("Fragment ", f2, " is not currently in the FragmentManager")));
                    throw null;
                }
            }
        }
        for (int i4 = 0; i4 < this.i.l(); i4++) {
            long i5 = this.i.i(i4);
            if (d(i5)) {
                bundle.putParcelable(hj1.M("s#", i5), this.i.f(i5));
            }
        }
        return bundle;
    }

    @Override // defpackage.zo
    public final void b(Parcelable parcelable) {
        if (!this.i.h() || !this.h.h()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String str : bundle.keySet()) {
            if (g(str, "f#")) {
                long parseLong = Long.parseLong(str.substring(2));
                FragmentManager fragmentManager = this.g;
                Objects.requireNonNull(fragmentManager);
                String string = bundle.getString(str);
                Fragment fragment = null;
                if (string != null) {
                    Fragment d = fragmentManager.c.d(string);
                    if (d != null) {
                        fragment = d;
                    } else {
                        fragmentManager.k0(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
                        throw null;
                    }
                }
                this.h.j(parseLong, fragment);
            } else if (g(str, "s#")) {
                long parseLong2 = Long.parseLong(str.substring(2));
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(str);
                if (d(parseLong2)) {
                    this.i.j(parseLong2, savedState);
                }
            } else {
                throw new IllegalArgumentException(hj1.S("Unexpected key in savedState: ", str));
            }
        }
        if (!this.h.h()) {
            this.m = true;
            this.l = true;
            f();
            final Handler handler = new Handler(Looper.getMainLooper());
            final vo voVar = new vo(this);
            this.f.a(new dh(this) {
                /* class androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass5 */

                @Override // defpackage.dh
                public void c(fh fhVar, zg.a aVar) {
                    if (aVar == zg.a.ON_DESTROY) {
                        handler.removeCallbacks(voVar);
                        gh ghVar = (gh) fhVar.getLifecycle();
                        ghVar.d("removeObserver");
                        ghVar.b.n(this);
                    }
                }
            });
            handler.postDelayed(voVar, Constants.THRESHOLD_TIMESTAMP);
        }
    }

    public void c(View view, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean d(long j2) {
        return j2 >= 0 && j2 < ((long) getItemCount());
    }

    public abstract Fragment e(int i2);

    public void f() {
        Fragment g2;
        View view;
        if (this.m && !k()) {
            p2 p2Var = new p2(0);
            for (int i2 = 0; i2 < this.h.l(); i2++) {
                long i3 = this.h.i(i2);
                if (!d(i3)) {
                    p2Var.add(Long.valueOf(i3));
                    this.j.k(i3);
                }
            }
            if (!this.l) {
                this.m = false;
                for (int i4 = 0; i4 < this.h.l(); i4++) {
                    long i5 = this.h.i(i4);
                    boolean z = true;
                    if (!this.j.d(i5) && ((g2 = this.h.g(i5, null)) == null || (view = g2.getView()) == null || view.getParent() == null)) {
                        z = false;
                    }
                    if (!z) {
                        p2Var.add(Long.valueOf(i5));
                    }
                }
            }
            Iterator it = p2Var.iterator();
            while (it.hasNext()) {
                j(((Long) it.next()).longValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public long getItemId(int i2) {
        return (long) i2;
    }

    public final Long h(int i2) {
        Long l2 = null;
        for (int i3 = 0; i3 < this.j.l(); i3++) {
            if (this.j.m(i3).intValue() == i2) {
                if (l2 == null) {
                    l2 = Long.valueOf(this.j.i(i3));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l2;
    }

    public void i(final yo yoVar) {
        Fragment f2 = this.h.f(yoVar.getItemId());
        if (f2 != null) {
            FrameLayout frameLayout = (FrameLayout) yoVar.itemView;
            View view = f2.getView();
            if (!f2.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (f2.isAdded() && view == null) {
                this.g.n.f1251a.add(new gf.a(new uo(this, f2, frameLayout), false));
            } else if (!f2.isAdded() || view.getParent() == null) {
                if (f2.isAdded()) {
                    c(view, frameLayout);
                } else if (!k()) {
                    this.g.n.f1251a.add(new gf.a(new uo(this, f2, frameLayout), false));
                    ke keVar = new ke(this.g);
                    StringBuilder i0 = hj1.i0("f");
                    i0.append(yoVar.getItemId());
                    keVar.f(0, f2, i0.toString(), 1);
                    keVar.q(f2, zg.b.STARTED);
                    keVar.e();
                    this.k.b(false);
                } else if (!this.g.D) {
                    this.f.a(new dh() {
                        /* class androidx.viewpager2.adapter.FragmentStateAdapter.AnonymousClass2 */

                        @Override // defpackage.dh
                        public void c(fh fhVar, zg.a aVar) {
                            if (!FragmentStateAdapter.this.k()) {
                                gh ghVar = (gh) fhVar.getLifecycle();
                                ghVar.d("removeObserver");
                                ghVar.b.n(this);
                                AtomicInteger atomicInteger = r8.f3055a;
                                if (((FrameLayout) yoVar.itemView).isAttachedToWindow()) {
                                    FragmentStateAdapter.this.i(yoVar);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != frameLayout) {
                c(view, frameLayout);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public final void j(long j2) {
        Bundle o;
        ViewParent parent;
        Fragment.SavedState savedState = null;
        Fragment g2 = this.h.g(j2, null);
        if (g2 != null) {
            if (!(g2.getView() == null || (parent = g2.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!d(j2)) {
                this.i.k(j2);
            }
            if (!g2.isAdded()) {
                this.h.k(j2);
            } else if (k()) {
                this.m = true;
            } else {
                if (g2.isAdded() && d(j2)) {
                    r2<Fragment.SavedState> r2Var = this.i;
                    FragmentManager fragmentManager = this.g;
                    kf h2 = fragmentManager.c.h(g2.mWho);
                    if (h2 == null || !h2.c.equals(g2)) {
                        fragmentManager.k0(new IllegalStateException(hj1.O("Fragment ", g2, " is not currently in the FragmentManager")));
                        throw null;
                    }
                    if (h2.c.mState > -1 && (o = h2.o()) != null) {
                        savedState = new Fragment.SavedState(o);
                    }
                    r2Var.j(j2, savedState);
                }
                ke keVar = new ke(this.g);
                keVar.p(g2);
                keVar.e();
                this.h.k(j2);
            }
        }
    }

    public boolean k() {
        return this.g.S();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        if (this.k == null) {
            b bVar = new b();
            this.k = bVar;
            ViewPager2 a2 = bVar.a(recyclerView);
            bVar.d = a2;
            wo woVar = new wo(bVar);
            bVar.f253a = woVar;
            a2.b(woVar);
            xo xoVar = new xo(bVar);
            bVar.b = xoVar;
            FragmentStateAdapter.this.registerAdapterDataObserver(xoVar);
            FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3 = new FragmentStateAdapter$FragmentMaxLifecycleEnforcer$3(bVar);
            bVar.c = fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3;
            FragmentStateAdapter.this.f.a(fragmentStateAdapter$FragmentMaxLifecycleEnforcer$3);
            return;
        }
        throw new IllegalArgumentException();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0, int] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(yo yoVar, int i2) {
        yo yoVar2 = yoVar;
        long itemId = yoVar2.getItemId();
        int id = ((FrameLayout) yoVar2.itemView).getId();
        Long h2 = h(id);
        if (!(h2 == null || h2.longValue() == itemId)) {
            j(h2.longValue());
            this.j.k(h2.longValue());
        }
        this.j.j(itemId, Integer.valueOf(id));
        long j2 = (long) i2;
        if (!this.h.d(j2)) {
            Fragment e = e(i2);
            e.setInitialSavedState(this.i.f(j2));
            this.h.j(j2, e);
        }
        FrameLayout frameLayout = (FrameLayout) yoVar2.itemView;
        AtomicInteger atomicInteger = r8.f3055a;
        if (frameLayout.isAttachedToWindow()) {
            if (frameLayout.getParent() == null) {
                frameLayout.addOnLayoutChangeListener(new to(this, frameLayout, yoVar2));
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        f();
    }

    /* Return type fixed from 'androidx.recyclerview.widget.RecyclerView$a0' to match base method */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public yo onCreateViewHolder(ViewGroup viewGroup, int i2) {
        int i3 = yo.f4075a;
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        AtomicInteger atomicInteger = r8.f3055a;
        frameLayout.setId(View.generateViewId());
        frameLayout.setSaveEnabled(false);
        return new yo(frameLayout);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        b bVar = this.k;
        ViewPager2 a2 = bVar.a(recyclerView);
        a2.h.f740a.remove(bVar.f253a);
        FragmentStateAdapter.this.unregisterAdapterDataObserver(bVar.b);
        FragmentStateAdapter.this.f.b(bVar.c);
        bVar.d = null;
        this.k = null;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public /* bridge */ /* synthetic */ boolean onFailedToRecycleView(yo yoVar) {
        return true;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onViewAttachedToWindow(yo yoVar) {
        i(yoVar);
        f();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [androidx.recyclerview.widget.RecyclerView$a0] */
    @Override // androidx.recyclerview.widget.RecyclerView.e
    public void onViewRecycled(yo yoVar) {
        Long h2 = h(((FrameLayout) yoVar.itemView).getId());
        if (h2 != null) {
            j(h2.longValue());
            this.j.k(h2.longValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public final void setHasStableIds(boolean z) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }
}
