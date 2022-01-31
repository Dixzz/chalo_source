package defpackage;

import android.graphics.Rect;
import defpackage.aa;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.Comparator;

/* renamed from: da  reason: default package */
/* compiled from: FocusStrategy */
public class da<T> implements Comparator<T>, j$.util.Comparator {
    public final Rect f = new Rect();
    public final Rect g = new Rect();
    public final boolean h;
    public final ba<T> i;

    public da(boolean z, ba<T> baVar) {
        this.h = z;
        this.i = baVar;
    }

    @Override // j$.util.Comparator, java.util.Comparator
    public int compare(T t, T t2) {
        Rect rect = this.f;
        Rect rect2 = this.g;
        ((aa.a) this.i).a(t, rect);
        ((aa.a) this.i).a(t2, rect2);
        int i2 = rect.top;
        int i3 = rect2.top;
        if (i2 < i3) {
            return -1;
        }
        if (i2 > i3) {
            return 1;
        }
        int i4 = rect.left;
        int i5 = rect2.left;
        if (i4 < i5) {
            if (this.h) {
                return 1;
            }
            return -1;
        } else if (i4 <= i5) {
            int i6 = rect.bottom;
            int i7 = rect2.bottom;
            if (i6 < i7) {
                return -1;
            }
            if (i6 > i7) {
                return 1;
            }
            int i8 = rect.right;
            int i9 = rect2.right;
            if (i8 < i9) {
                if (this.h) {
                    return 1;
                }
                return -1;
            } else if (i8 <= i9) {
                return 0;
            } else {
                if (this.h) {
                    return -1;
                }
                return 1;
            }
        } else if (this.h) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ Comparator reversed() {
        return Comparator.CC.$default$reversed(this);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator.CC.$default$thenComparing(this, function);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, function, comparator);
    }

    @Override // j$.util.Comparator, java.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
        return Comparator.CC.$default$thenComparing(this, comparator);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
    }

    @Override // j$.util.Comparator
    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
    }
}
