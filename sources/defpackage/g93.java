package defpackage;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;
import java.util.Spliterator;

/* renamed from: g93  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public abstract class g93 implements Iterable<Byte>, Serializable, Iterable {
    public static final g93 g = new e93(ka3.b);
    public static final d93 h = (u83.a() ? new f93() : new b93());
    public int f = 0;

    public static g93 A(byte[] bArr, int i, int i2) {
        E(i, i + i2, bArr.length);
        return new e93(h.a(bArr, i, i2));
    }

    public static g93 B(byte[] bArr) {
        return A(bArr, 0, bArr.length);
    }

    public static int E(int i, int i2, int i3) {
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

    public final byte[] C() {
        int e = e();
        if (e == 0) {
            return ka3.b;
        }
        byte[] bArr = new byte[e];
        k(bArr, 0, 0, e);
        return bArr;
    }

    public abstract byte b(int i);

    public abstract byte d(int i);

    public abstract int e();

    public abstract boolean equals(Object obj);

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public final int hashCode() {
        int i = this.f;
        if (i == 0) {
            int e = e();
            i = y(e, 0, e);
            if (i == 0) {
                i = 1;
            }
            this.f = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public final /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return new z83(this);
    }

    public abstract void k(byte[] bArr, int i, int i2, int i3);

    public abstract g93 n(int i, int i2);

    public abstract void s(y83 y83) throws IOException;

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Byte> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(e());
        objArr[2] = e() <= 50 ? gj1.T0(this) : String.valueOf(gj1.T0(n(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract String u(Charset charset);

    public abstract boolean v();

    public abstract int y(int i, int i2, int i3);

    public abstract h93 z();
}
