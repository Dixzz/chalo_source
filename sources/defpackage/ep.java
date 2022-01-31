package defpackage;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Locale;

/* renamed from: ep  reason: default package */
/* compiled from: PageTransformerAdapter */
public final class ep extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayoutManager f1015a;
    public ViewPager2.g b;

    public ep(LinearLayoutManager linearLayoutManager) {
        this.f1015a = linearLayoutManager;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i) {
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int i, float f, int i2) {
        if (this.b != null) {
            float f2 = -f;
            for (int i3 = 0; i3 < this.f1015a.K(); i3++) {
                View J = this.f1015a.J(i3);
                if (J != null) {
                    this.b.a(J, ((float) (this.f1015a.a0(J) - i)) + f2);
                } else {
                    throw new IllegalStateException(String.format(Locale.US, "LayoutManager returned a null child at pos %d/%d while transforming pages", Integer.valueOf(i3), Integer.valueOf(this.f1015a.K())));
                }
            }
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void c(int i) {
    }
}
