package defpackage;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

/* renamed from: ry  reason: default package */
/* compiled from: ProductHistoryFragmentBinding */
public final class ry implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f3148a;
    public final TabLayout b;
    public final MaterialToolbar c;
    public final ViewPager2 d;

    public ry(ConstraintLayout constraintLayout, MaterialCardView materialCardView, TabLayout tabLayout, MaterialToolbar materialToolbar, ViewPager2 viewPager2) {
        this.f3148a = constraintLayout;
        this.b = tabLayout;
        this.c = materialToolbar;
        this.d = viewPager2;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3148a;
    }
}
