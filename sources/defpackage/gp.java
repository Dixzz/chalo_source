package defpackage;

import androidx.viewpager2.widget.ViewPager2;

/* renamed from: gp  reason: default package */
/* compiled from: ViewPager2 */
public class gp extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f1292a;

    public gp(ViewPager2 viewPager2) {
        this.f1292a = viewPager2;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i) {
        if (i == 0) {
            this.f1292a.e();
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void c(int i) {
        ViewPager2 viewPager2 = this.f1292a;
        if (viewPager2.i != i) {
            viewPager2.i = i;
            viewPager2.y.b();
        }
    }
}
