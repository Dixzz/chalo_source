package defpackage;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

/* renamed from: kz  reason: default package */
/* compiled from: TutorialBaseScreenBinding */
public final class kz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f2140a;
    public final Button b;
    public final ImageView c;
    public final TabLayout d;
    public final ViewPager2 e;

    public kz(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Button button, ImageView imageView, TabLayout tabLayout, ConstraintLayout constraintLayout3, ViewPager2 viewPager2) {
        this.f2140a = constraintLayout;
        this.b = button;
        this.c = imageView;
        this.d = tabLayout;
        this.e = viewPager2;
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2140a;
    }
}
