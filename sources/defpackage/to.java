package defpackage;

import android.view.View;
import android.widget.FrameLayout;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/* renamed from: to  reason: default package */
/* compiled from: FragmentStateAdapter */
public class to implements View.OnLayoutChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameLayout f3382a;
    public final /* synthetic */ yo b;
    public final /* synthetic */ FragmentStateAdapter c;

    public to(FragmentStateAdapter fragmentStateAdapter, FrameLayout frameLayout, yo yoVar) {
        this.c = fragmentStateAdapter;
        this.f3382a = frameLayout;
        this.b = yoVar;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.f3382a.getParent() != null) {
            this.f3382a.removeOnLayoutChangeListener(this);
            this.c.i(this.b);
        }
    }
}
