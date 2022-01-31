package defpackage;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
import java.util.Spliterator;

/* renamed from: qt3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class qt3 implements Serializable, Iterable<Byte>, Iterable {
    public static final qt3 g = new wt3(tu3.b);
    public static final ut3 h = (nt3.a() ? new yt3(null) : new tt3(null));
    public int f = 0;

    public static qt3 n(byte[] bArr, int i, int i2) {
        y(i, i + i2, bArr.length);
        return new wt3(h.a(bArr, i, i2));
    }

    public static int y(int i, int i2, int i3) {
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

    public abstract byte b(int i);

    public abstract int d();

    public abstract int e(int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public final int hashCode() {
        int i = this.f;
        if (i == 0) {
            int d = d();
            i = e(d, 0, d);
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
        return new st3(this);
    }

    public abstract qt3 k(int i, int i2);

    public abstract String s(Charset charset);

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Byte> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(d());
        objArr[2] = d() <= 50 ? hd3.E3(this) : String.valueOf(hd3.E3(k(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract void u(rt3 rt3) throws IOException;

    public abstract byte v(int i);

    public abstract boolean z();
}
