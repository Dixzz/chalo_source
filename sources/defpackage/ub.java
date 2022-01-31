package defpackage;

import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;

/* renamed from: ub  reason: default package */
/* compiled from: ByteString */
public abstract class ub implements Iterable<Byte>, Serializable, Iterable {
    public static final ub g = new e(mc.b);
    public static final c h = (qb.a() ? new f(null) : new b(null));
    public int f = 0;

    /* renamed from: ub$a */
    /* compiled from: ByteString */
    public static abstract class a implements Iterator, j$.util.Iterator {
        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            return Byte.valueOf(((tb) this).a());
        }

        @Override // j$.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: ub$b */
    /* compiled from: ByteString */
    public static final class b implements c {
        public b(tb tbVar) {
        }

        @Override // defpackage.ub.c
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    /* renamed from: ub$c */
    /* compiled from: ByteString */
    public interface c {
        byte[] a(byte[] bArr, int i, int i2);
    }

    /* renamed from: ub$d */
    /* compiled from: ByteString */
    public static abstract class d extends ub {
        /* Return type fixed from 'java.util.Iterator' to match base method */
        @Override // j$.lang.Iterable, defpackage.ub, java.lang.Iterable
        public java.util.Iterator<Byte> iterator() {
            return new tb(this);
        }
    }

    /* renamed from: ub$e */
    /* compiled from: ByteString */
    public static class e extends d {
        public final byte[] i;

        public e(byte[] bArr) {
            Objects.requireNonNull(bArr);
            this.i = bArr;
        }

        @Override // defpackage.ub
        public byte b(int i2) {
            return this.i[i2];
        }

        @Override // defpackage.ub
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ub) || size() != ((ub) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof e)) {
                return obj.equals(this);
            }
            e eVar = (e) obj;
            int i2 = this.f;
            int i3 = eVar.f;
            if (i2 != 0 && i3 != 0 && i2 != i3) {
                return false;
            }
            int size = size();
            if (size > eVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (0 + size <= eVar.size()) {
                byte[] bArr = this.i;
                byte[] bArr2 = eVar.i;
                int y = y() + size;
                int y2 = y();
                int y3 = eVar.y() + 0;
                while (y2 < y) {
                    if (bArr[y2] != bArr2[y3]) {
                        return false;
                    }
                    y2++;
                    y3++;
                }
                return true;
            } else {
                throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + size + ", " + eVar.size());
            }
        }

        @Override // defpackage.ub
        public byte k(int i2) {
            return this.i[i2];
        }

        @Override // defpackage.ub
        public final boolean n() {
            int y = y();
            if (de.f823a.c(0, this.i, y, size() + y) == 0) {
                return true;
            }
            return false;
        }

        @Override // defpackage.ub
        public final int s(int i2, int i3, int i4) {
            byte[] bArr = this.i;
            int y = y() + i3;
            Charset charset = mc.f2352a;
            for (int i5 = y; i5 < y + i4; i5++) {
                i2 = (i2 * 31) + bArr[i5];
            }
            return i2;
        }

        @Override // defpackage.ub
        public int size() {
            return this.i.length;
        }

        @Override // defpackage.ub
        public final String u(Charset charset) {
            return new String(this.i, y(), size(), charset);
        }

        @Override // defpackage.ub
        public final void v(sb sbVar) throws IOException {
            sbVar.a(this.i, y(), size());
        }

        public int y() {
            return 0;
        }
    }

    /* renamed from: ub$f */
    /* compiled from: ByteString */
    public static final class f implements c {
        public f(tb tbVar) {
        }

        @Override // defpackage.ub.c
        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }
    }

    public static int d(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(hj1.J("Beginning index: ", i, " < 0"));
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(hj1.L("Beginning index larger than ending index: ", i, ", ", i2));
        } else {
            throw new IndexOutOfBoundsException(hj1.L("End index: ", i2, " >= ", i3));
        }
    }

    public static ub e(byte[] bArr, int i, int i2) {
        d(i, i + i2, bArr.length);
        return new e(h.a(bArr, i, i2));
    }

    public abstract byte b(int i);

    public abstract boolean equals(Object obj);

    @Override // j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
    }

    public final int hashCode() {
        int i = this.f;
        if (i == 0) {
            int size = size();
            i = s(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.f = i;
        }
        return i;
    }

    /* Return type fixed from 'java.util.Iterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public java.util.Iterator<Byte> iterator() {
        return new tb(this);
    }

    public abstract byte k(int i);

    public abstract boolean n();

    public abstract int s(int i, int i2, int i3);

    public abstract int size();

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Byte> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract String u(Charset charset);

    public abstract void v(sb sbVar) throws IOException;
}
