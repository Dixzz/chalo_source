package defpackage;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.Spliterator;

/* renamed from: i96  reason: default package */
/* compiled from: Progressions.kt */
public class i96 implements Iterable<Integer>, c96, Iterable {
    public final int f;
    public final int g;
    public final int h;

    public i96(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        } else if (i3 != Integer.MIN_VALUE) {
            this.f = i;
            this.g = hd3.q1(i, i2, i3);
            this.h = i3;
        } else {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof i96) {
            if (!isEmpty() || !((i96) obj).isEmpty()) {
                i96 i96 = (i96) obj;
                if (!(this.f == i96.f && this.g == i96.g && this.h == i96.h)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f * 31) + this.g) * 31) + this.h;
    }

    public boolean isEmpty() {
        if (this.h > 0) {
            if (this.f > this.g) {
                return true;
            }
        } else if (this.f < this.g) {
            return true;
        }
        return false;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public Iterator<Integer> iterator() {
        return new j96(this.f, this.g, this.h);
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Integer> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public String toString() {
        int i;
        StringBuilder sb;
        if (this.h > 0) {
            sb = new StringBuilder();
            sb.append(this.f);
            sb.append("..");
            sb.append(this.g);
            sb.append(" step ");
            i = this.h;
        } else {
            sb = new StringBuilder();
            sb.append(this.f);
            sb.append(" downTo ");
            sb.append(this.g);
            sb.append(" step ");
            i = -this.h;
        }
        sb.append(i);
        return sb.toString();
    }
}
