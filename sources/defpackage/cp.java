package defpackage;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/* renamed from: cp  reason: default package */
/* compiled from: CompositeOnPageChangeCallback */
public final class cp extends ViewPager2.e {

    /* renamed from: a  reason: collision with root package name */
    public final List<ViewPager2.e> f740a;

    public cp(int i) {
        this.f740a = new ArrayList(i);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i) {
        try {
            for (ViewPager2.e eVar : this.f740a) {
                eVar.a(i);
            }
        } catch (ConcurrentModificationException e) {
            d(e);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int i, float f, int i2) {
        try {
            for (ViewPager2.e eVar : this.f740a) {
                eVar.b(i, f, i2);
            }
        } catch (ConcurrentModificationException e) {
            d(e);
            throw null;
        }
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void c(int i) {
        try {
            for (ViewPager2.e eVar : this.f740a) {
                eVar.c(i);
            }
        } catch (ConcurrentModificationException e) {
            d(e);
            throw null;
        }
    }

    public final void d(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
