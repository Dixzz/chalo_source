package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

/* renamed from: ip4  reason: default package */
/* compiled from: TabLayoutMediator */
public final class ip4 {

    /* renamed from: a  reason: collision with root package name */
    public final TabLayout f1551a;
    public final ViewPager2 b;
    public final b c;
    public RecyclerView.e<?> d;
    public boolean e;
    public c f;
    public TabLayout.d g;
    public RecyclerView.g h;

    /* renamed from: ip4$a */
    /* compiled from: TabLayoutMediator */
    public class a extends RecyclerView.g {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void a() {
            ip4.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void b(int i, int i2) {
            ip4.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void c(int i, int i2, Object obj) {
            ip4.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void d(int i, int i2) {
            ip4.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void e(int i, int i2, int i3) {
            ip4.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void f(int i, int i2) {
            ip4.this.b();
        }
    }

    /* renamed from: ip4$b */
    /* compiled from: TabLayoutMediator */
    public interface b {
        void a(TabLayout.g gVar, int i);
    }

    /* renamed from: ip4$c */
    /* compiled from: TabLayoutMediator */
    public static class c extends ViewPager2.e {

        /* renamed from: a  reason: collision with root package name */
        public final WeakReference<TabLayout> f1553a;
        public int b = 0;
        public int c = 0;

        public c(TabLayout tabLayout) {
            this.f1553a = new WeakReference<>(tabLayout);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void a(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void b(int i, float f, int i2) {
            TabLayout tabLayout = this.f1553a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                boolean z = false;
                boolean z2 = i3 != 2 || this.b == 1;
                if (!(i3 == 2 && this.b == 0)) {
                    z = true;
                }
                tabLayout.m(i, f, z2, z);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void c(int i) {
            TabLayout tabLayout = this.f1553a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i && i < tabLayout.getTabCount()) {
                int i2 = this.c;
                tabLayout.k(tabLayout.g(i), i2 == 0 || (i2 == 2 && this.b == 0));
            }
        }
    }

    /* renamed from: ip4$d */
    /* compiled from: TabLayoutMediator */
    public static class d implements TabLayout.d {

        /* renamed from: a  reason: collision with root package name */
        public final ViewPager2 f1554a;
        public final boolean b;

        public d(ViewPager2 viewPager2, boolean z) {
            this.f1554a = viewPager2;
            this.b = z;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            ViewPager2 viewPager2 = this.f1554a;
            int i = gVar.d;
            boolean z = this.b;
            if (!viewPager2.s.f873a.m) {
                viewPager2.d(i, z);
                return;
            }
            throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    public ip4(TabLayout tabLayout, ViewPager2 viewPager2, b bVar) {
        this.f1551a = tabLayout;
        this.b = viewPager2;
        this.c = bVar;
    }

    public void a() {
        if (!this.e) {
            RecyclerView.e<?> adapter = this.b.getAdapter();
            this.d = adapter;
            if (adapter != null) {
                this.e = true;
                c cVar = new c(this.f1551a);
                this.f = cVar;
                this.b.h.f740a.add(cVar);
                d dVar = new d(this.b, true);
                this.g = dVar;
                TabLayout tabLayout = this.f1551a;
                if (!tabLayout.L.contains(dVar)) {
                    tabLayout.L.add(dVar);
                }
                a aVar = new a();
                this.h = aVar;
                this.d.registerAdapterDataObserver(aVar);
                b();
                this.f1551a.m(this.b.getCurrentItem(), 0.0f, true, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void b() {
        int min;
        this.f1551a.j();
        RecyclerView.e<?> eVar = this.d;
        if (eVar != null) {
            int itemCount = eVar.getItemCount();
            for (int i = 0; i < itemCount; i++) {
                TabLayout.g h2 = this.f1551a.h();
                this.c.a(h2, i);
                this.f1551a.a(h2, false);
            }
            if (itemCount > 0 && (min = Math.min(this.b.getCurrentItem(), this.f1551a.getTabCount() - 1)) != this.f1551a.getSelectedTabPosition()) {
                TabLayout tabLayout = this.f1551a;
                tabLayout.k(tabLayout.g(min), true);
            }
        }
    }
}
