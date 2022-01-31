package defpackage;

import androidx.viewpager2.widget.ViewPager2;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.ui.fragments.HomeScreenMainFragment;
import java.util.List;
import java.util.TimerTask;

/* renamed from: nu0  reason: default package */
/* compiled from: HomeScreenMainFragment.kt */
public final class nu0 extends TimerTask {
    public final /* synthetic */ HomeScreenMainFragment f;
    public final /* synthetic */ List<ProductPromotionsObject> g;

    /* renamed from: nu0$a */
    /* compiled from: HomeScreenMainFragment.kt */
    public static final class a implements Runnable {
        public final /* synthetic */ ViewPager2 f;
        public final /* synthetic */ List<ProductPromotionsObject> g;

        public a(ViewPager2 viewPager2, List<ProductPromotionsObject> list) {
            this.f = viewPager2;
            this.g = list;
        }

        public final void run() {
            ViewPager2 viewPager2 = this.f;
            viewPager2.setCurrentItem((viewPager2.getCurrentItem() + 1) % this.g.size());
        }
    }

    public nu0(HomeScreenMainFragment homeScreenMainFragment, List<ProductPromotionsObject> list) {
        this.f = homeScreenMainFragment;
        this.g = list;
    }

    public void run() {
        ViewPager2 viewPager2 = HomeScreenMainFragment.g(this.f).B;
        viewPager2.post(new a(viewPager2, this.g));
    }
}
