package defpackage;

import androidx.viewpager2.widget.ViewPager2;

/* renamed from: hp  reason: default package */
/* compiled from: ViewPager2 */
public class hp extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f1405a;

    public hp(ViewPager2 viewPager2) {
        this.f1405a = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void c(int i) {
        this.f1405a.clearFocus();
        if (this.f1405a.hasFocus()) {
            this.f1405a.o.requestFocus(2);
        }
    }
}
