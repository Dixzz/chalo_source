package defpackage;

import j$.lang.Iterable;
import j$.util.function.Consumer;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Spliterator;

/* renamed from: uf2  reason: default package */
public abstract class uf2 implements Serializable, Iterable<Byte>, Iterable {
    public static final uf2 g = new yf2(wg2.b);
    public static final xf2 h = (pf2.a() ? new zf2(null) : new wf2(null));
    public int f = 0;

    public static uf2 n(byte[] bArr, int i, int i2) {
        return new yf2(h.a(bArr, i, i2));
    }

    public abstract int b(int i, int i2, int i3);

    public abstract String d(Charset charset);

    public abstract void e(tf2 tf2) throws IOException;

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
        return new vf2(this);
    }

    public abstract boolean k();

    public abstract byte s(int i);

    public abstract int size();

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.lang.Iterable, java.lang.Iterable
    public /* synthetic */ Spliterator<Byte> spliterator() {
        return Iterable.CC.$default$spliterator(this);
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
