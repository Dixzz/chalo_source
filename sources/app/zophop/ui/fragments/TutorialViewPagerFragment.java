package app.zophop.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import app.zophop.R;
import app.zophop.models.TransitMode;
import com.google.android.material.tabs.TabLayout;
import defpackage.xt;

/* compiled from: TutorialViewPagerFragment.kt */
public final class TutorialViewPagerFragment extends rl0<kz> {
    public static final /* synthetic */ int h = 0;
    public final ViewPager2.e g = new b(this);

    /* compiled from: TutorialViewPagerFragment.kt */
    public final class a extends FragmentStateAdapter {
        public final /* synthetic */ TutorialViewPagerFragment n;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(TutorialViewPagerFragment tutorialViewPagerFragment, ve veVar) {
            super(veVar);
            n86.e(tutorialViewPagerFragment, "this$0");
            n86.e(veVar, "fm");
            this.n = tutorialViewPagerFragment;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment e(int i) {
            yw0 yw0 = new yw0();
            yw0.setArguments(h.j(new m56("screenPosition", Integer.valueOf(i))));
            return yw0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.e
        public int getItemCount() {
            TutorialViewPagerFragment tutorialViewPagerFragment = this.n;
            int i = TutorialViewPagerFragment.h;
            return tutorialViewPagerFragment.f();
        }
    }

    /* compiled from: TutorialViewPagerFragment.kt */
    public static final class b extends ViewPager2.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TutorialViewPagerFragment f314a;

        public b(TutorialViewPagerFragment tutorialViewPagerFragment) {
            this.f314a = tutorialViewPagerFragment;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.e
        public void c(int i) {
            TutorialViewPagerFragment tutorialViewPagerFragment = this.f314a;
            int i2 = TutorialViewPagerFragment.h;
            if (i == tutorialViewPagerFragment.f() - 1) {
                T t = this.f314a.f;
                n86.c(t);
                kz kzVar = (kz) t;
                if (this.f314a.f() == 1) {
                    kzVar.d.setVisibility(4);
                }
                kzVar.c.setVisibility(4);
                kzVar.b.setVisibility(0);
                return;
            }
            T t2 = this.f314a.f;
            n86.c(t2);
            kz kzVar2 = (kz) t2;
            kzVar2.c.setVisibility(0);
            kzVar2.d.setVisibility(0);
            kzVar2.b.setVisibility(4);
        }
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public kz e() {
        View inflate = getLayoutInflater().inflate(R.layout.tutorial_base_screen, (ViewGroup) null, false);
        int i = R.id.bottom_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.bottom_container);
        if (constraintLayout != null) {
            i = R.id.get_started_btn;
            Button button = (Button) inflate.findViewById(R.id.get_started_btn);
            if (button != null) {
                i = R.id.next_page_arrow;
                ImageView imageView = (ImageView) inflate.findViewById(R.id.next_page_arrow);
                if (imageView != null) {
                    i = R.id.tab_layout;
                    TabLayout tabLayout = (TabLayout) inflate.findViewById(R.id.tab_layout);
                    if (tabLayout != null) {
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate;
                        i = R.id.tutorial_view_pager;
                        ViewPager2 viewPager2 = (ViewPager2) inflate.findViewById(R.id.tutorial_view_pager);
                        if (viewPager2 != null) {
                            kz kzVar = new kz(constraintLayout2, constraintLayout, button, imageView, tabLayout, constraintLayout2, viewPager2);
                            n86.d(kzVar, "inflate(layoutInflater)");
                            return kzVar;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    public final int f() {
        TransitMode transitMode = TransitMode.bus;
        xt.t1 t1Var = xt.f3961a;
        return (ui1.b0(transitMode, t1Var.k().d()) || ui1.c0(t1Var.k().d())) ? 2 : 1;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        T t = this.f;
        n86.c(t);
        ViewPager2 viewPager2 = ((kz) t).e;
        ve activity = c();
        viewPager2.setAdapter(activity == null ? null : new a(this, activity));
        viewPager2.b(this.g);
        T t2 = this.f;
        n86.c(t2);
        TabLayout tabLayout = ((kz) t2).d;
        T t3 = this.f;
        n86.c(t3);
        new ip4(tabLayout, ((kz) t3).e, ks0.f2113a).a();
        T t4 = this.f;
        n86.c(t4);
        ((kz) t4).b.setOnClickListener(new js0(this));
        T t5 = this.f;
        n86.c(t5);
        ((kz) t5).c.setOnClickListener(new ls0(this));
        ui1.m0(new ed1("tutorial screen displayed", Long.MAX_VALUE));
    }
}
