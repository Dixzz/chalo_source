package app.zophop.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import app.zophop.R;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

/* compiled from: ProductHistoryFragment.kt */
public final class ProductHistoryFragment extends rl0<ry> {
    public static final /* synthetic */ int g = 0;

    /* compiled from: ProductHistoryFragment.kt */
    public final class a extends FragmentStateAdapter {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ProductHistoryFragment productHistoryFragment, ve veVar) {
            super(veVar);
            n86.e(productHistoryFragment, "this$0");
            n86.e(veVar, "fm");
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment e(int i) {
            kv0 kv0 = new kv0();
            kv0.setArguments(h.j(new m56("screenPosition", Integer.valueOf(i))));
            return kv0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.e
        public int getItemCount() {
            return 2;
        }
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public ry e() {
        View inflate = getLayoutInflater().inflate(R.layout.product_history_fragment, (ViewGroup) null, false);
        int i = R.id.action_bar;
        MaterialCardView materialCardView = (MaterialCardView) inflate.findViewById(R.id.action_bar);
        if (materialCardView != null) {
            i = R.id.tab_layout;
            TabLayout tabLayout = (TabLayout) inflate.findViewById(R.id.tab_layout);
            if (tabLayout != null) {
                i = R.id.toolbar;
                MaterialToolbar materialToolbar = (MaterialToolbar) inflate.findViewById(R.id.toolbar);
                if (materialToolbar != null) {
                    i = R.id.your_plans_view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) inflate.findViewById(R.id.your_plans_view_pager);
                    if (viewPager2 != null) {
                        ry ryVar = new ry((ConstraintLayout) inflate, materialCardView, tabLayout, materialToolbar, viewPager2);
                        n86.d(ryVar, "inflate(layoutInflater)");
                        return ryVar;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        T t = this.f;
        n86.c(t);
        ViewPager2 viewPager2 = ((ry) t).d;
        ve requireActivity = requireActivity();
        n86.d(requireActivity, "requireActivity()");
        viewPager2.setAdapter(new a(this, requireActivity));
        T t2 = this.f;
        n86.c(t2);
        TabLayout tabLayout = ((ry) t2).b;
        T t3 = this.f;
        n86.c(t3);
        new ip4(tabLayout, ((ry) t3).d, new qr0(this)).a();
        T t4 = this.f;
        n86.c(t4);
        ((ry) t4).c.setNavigationOnClickListener(new pr0(this));
        T t5 = this.f;
        n86.c(t5);
        ((ry) t5).c.setOnMenuItemClickListener(new rr0(this));
        ed1 ed1 = new ed1("history screen opened", Long.MIN_VALUE);
        ed1.a("source", "History screen");
        ui1.m0(ed1);
    }
}
