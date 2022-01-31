package defpackage;

import j$.lang.Iterable;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Spliterator;

/* renamed from: a05  reason: default package */
/* compiled from: ByteString */
public abstract class a05 implements Iterable<Byte>, Serializable, Iterable {
    public static final a05 g = new f(s05.b);
    public static final d h = (uz4.a() ? new g(null) : new b(null));
    public int f = 0;

    /* renamed from: a05$a */
    /* compiled from: ByteString */
    public static abstract class a implements Iterator, j$.util.Iterator {
        @Override // j$.util.Iterator
        public /* synthetic */ void forEachRemaining(Consumer consumer) {
            Iterator.CC.$default$forEachRemaining(this, consumer);
        }

        @Override // j$.util.Iterator, java.util.Iterator
        public Object next() {
            return Byte.valueOf(((zz4) this).a());
        }

        @Override // j$.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: a05$b */
    /* compiled from: ByteString */
    public static final class b implements d {
        public b(zz4 zz4) {
        }

        @Override // defpackage.a05.d
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }
    }

    /* renamed from: a05$c */
    /* compiled from: ByteString */
    public static final class c extends f {
        public final int j;
        public final int k;

        public c(byte[] bArr, int i, int i2) {
            super(bArr);
            a05.d(i, i + i2, bArr.length);
            this.j = i;
            this.k = i2;
        }

        @Override // defpackage.a05.f
        public int E() {
            return this.j;
        }

        @Override // defpackage.a05.f, defpackage.a05
        public byte b(int i) {
            int i2 = this.k;
            if (((i2 - (i + 1)) | i) >= 0) {
                return this.i[this.j + i];
            }
            if (i < 0) {
                throw new ArrayIndexOutOfBoundsException(hj1.I("Index < 0: ", i));
            }
            throw new ArrayIndexOutOfBoundsException(hj1.L("Index > length: ", i, ", ", i2));
        }

        @Override // defpackage.a05.f, defpackage.a05
        public void n(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.i, this.j + i, bArr, i2, i3);
        }

        @Override // defpackage.a05.f, defpackage.a05
        public byte s(int i) {
            return this.i[this.j + i];
        }

        @Override // defpackage.a05.f, defpackage.a05
        public int size() {
            return this.k;
        }
    }

    /* renamed from: a05$d */
    /* compiled from: ByteString */
    public interface d {
        byte[] a(byte[] bArr, int i, int i2);
    }

    /* renamed from: a05$e */
    /* compiled from: ByteString */
    public static abstract class e extends a05 {
        /* Return type fixed from 'java.util.Iterator' to match base method */
        @Override // defpackage.a05, j$.lang.Iterable, java.lang.Iterable
        public java.util.Iterator<Byte> iterator() {
            return new zz4(this);
        }
    }

    /* renamed from: a05$f */
    /* compiled from: ByteString */
    public static class f extends e {
        public final byte[] i;

        public f(byte[] bArr) {
            Objects.requireNonNull(bArr);
            this.i = bArr;
        }

        @Override // defpackage.a05
        public final String A(Charset charset) {
            return new String(this.i, E(), size(), charset);
        }

        @Override // defpackage.a05
        public final void C(yz4 yz4) throws IOException {
            yz4.a(this.i, E(), size());
        }

        public int E() {
            return 0;
        }

        @Override // defpackage.a05
        public byte b(int i2) {
            return this.i[i2];
        }

        @Override // defpackage.a05
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a05) || size() != ((a05) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof f)) {
                return obj.equals(this);
            }
            f fVar = (f) obj;
            int i2 = this.f;
            int i3 = fVar.f;
            if (i2 != 0 && i3 != 0 && i2 != i3) {
                return false;
            }
            int size = size();
            if (size > fVar.size()) {
                throw new IllegalArgumentException("Length too large: " + size + size());
            } else if (0 + size <= fVar.size()) {
                byte[] bArr = this.i;
                byte[] bArr2 = fVar.i;
                int E = E() + size;
                int E2 = E();
                int E3 = fVar.E() + 0;
                while (E2 < E) {
                    if (bArr[E2] != bArr2[E3]) {
                        return false;
                    }
                    E2++;
                    E3++;
                }
                return true;
            } else {
                throw new IllegalArgumentException("Ran off end of other: " + 0 + ", " + size + ", " + fVar.size());
            }
        }

        @Override // defpackage.a05
        public void n(byte[] bArr, int i2, int i3, int i4) {
            System.arraycopy(this.i, i2, bArr, i3, i4);
        }

        @Override // defpackage.a05
        public byte s(int i2) {
            return this.i[i2];
        }

        @Override // defpackage.a05
        public int size() {
            return this.i.length;
        }

        @Override // defpackage.a05
        public final boolean u() {
            int E = E();
            return j25.h(this.i, E, size() + E);
        }

        @Override // defpackage.a05
        public final b05 v() {
            return b05.h(this.i, E(), size(), true);
        }

        @Override // defpackage.a05
        public final int y(int i2, int i3, int i4) {
            byte[] bArr = this.i;
            int E = E() + i3;
            Charset charset = s05.f3160a;
            for (int i5 = E; i5 < E + i4; i5++) {
                i2 = (i2 * 31) + bArr[i5];
            }
            return i2;
        }

        @Override // defpackage.a05
        public final a05 z(int i2, int i3) {
            int d = a05.d(i2, i3, size());
            if (d == 0) {
                return a05.g;
            }
            return new c(this.i, E() + i2, d);
        }
    }

    /* renamed from: a05$g */
    /* compiled from: ByteString */
    public static final class g implements d {
        public g(zz4 zz4) {
        }

        @Override // defpackage.a05.d
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

    public static a05 e(byte[] bArr, int i, int i2) {
        d(i, i + i2, bArr.length);
        return new f(h.a(bArr, i, i2));
    }

    public static a05 k(String str) {
        return new f(str.getBytes(s05.f3160a));
    }

    public abstract String A(Charset charset);

    public final String B() {
        return size() == 0 ? "" : A(s05.f3160a);
    }

    public abstract void C(yz4 yz4) throws IOException;

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
            i = y(size, 0, size);
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
        return new zz4(this);
    }

    public abstract void n(byte[] bArr, int i, int i2, int i3);

    public abstract byte s(int i);

    public abstract int size();

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Byte> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public final String toString() {
        String str;
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        if (size() <= 50) {
            str = hd3.S0(this);
        } else {
            str = hd3.S0(z(0, 47)) + "...";
        }
        objArr[2] = str;
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public abstract boolean u();

    public abstract b05 v();

    public abstract int y(int i, int i2, int i3);

    public abstract a05 z(int i, int i2);
}
