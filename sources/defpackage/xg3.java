package defpackage;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
import java.util.Spliterator;

/* renamed from: xg3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public abstract class xg3 implements Serializable, Iterable<Byte>, Iterable {
    public static final xg3 g = new eh3(zh3.b);
    public static final bh3 h = (wg3.a() ? new fh3(null) : new ah3(null));
    public int f = 0;

    public static int s(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(hj1.w(66, "Beginning index larger than ending index: ", i, ", ", i2));
        } else {
            throw new IndexOutOfBoundsException(hj1.w(37, "End index: ", i2, " >= ", i3));
        }
    }

    public abstract int b(int i, int i2, int i3);

    public abstract xg3 d(int i, int i2);

    public abstract String e(Charset charset);

    public abstract boolean equals(Object obj);

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public final int hashCode() {
        int i = this.f;
        if (i == 0) {
            int size = size();
            i = b(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Iterator<Byte> iterator() {
        return new zg3(this);
    }

    public abstract void k(yg3 yg3) throws IOException;

    public abstract boolean n();

    public abstract int size();

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Byte> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? hd3.b4(this) : String.valueOf(hd3.b4(d(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract byte u(int i);

    public abstract byte v(int i);
}
