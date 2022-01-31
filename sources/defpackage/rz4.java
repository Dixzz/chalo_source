package defpackage;

import defpackage.a05;
import defpackage.d05;
import defpackage.j15;
import defpackage.rz4;
import defpackage.rz4.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: rz4  reason: default package */
/* compiled from: AbstractMessageLite */
public abstract class rz4<MessageType extends rz4<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements j15 {
    public int memoizedHashCode = 0;

    @Deprecated
    public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
        a.addAll((Iterable) iterable, (List) collection);
    }

    public static void checkByteStringIsUtf8(a05 a05) throws IllegalArgumentException {
        if (!a05.u()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String getSerializingExceptionMessage(String str) {
        StringBuilder i0 = hj1.i0("Serializing ");
        i0.append(getClass().getName());
        i0.append(" to a ");
        i0.append(str);
        i0.append(" threw an IOException (should never happen).");
        return i0.toString();
    }

    public int getMemoizedSerializedSize() {
        throw new UnsupportedOperationException();
    }

    public int getSerializedSize(x15 x15) {
        int memoizedSerializedSize = getMemoizedSerializedSize();
        if (memoizedSerializedSize != -1) {
            return memoizedSerializedSize;
        }
        int g = x15.g(this);
        setMemoizedSerializedSize(g);
        return g;
    }

    public d25 newUninitializedMessageException() {
        return new d25();
    }

    public void setMemoizedSerializedSize(int i) {
        throw new UnsupportedOperationException();
    }

    public byte[] toByteArray() {
        try {
            int serializedSize = getSerializedSize();
            byte[] bArr = new byte[serializedSize];
            Logger logger = d05.b;
            d05.c cVar = new d05.c(bArr, 0, serializedSize);
            writeTo(cVar);
            if (cVar.b0() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(getSerializingExceptionMessage("byte array"), e);
        }
    }

    @Override // defpackage.j15
    public a05 toByteString() {
        try {
            int serializedSize = getSerializedSize();
            a05 a05 = a05.g;
            byte[] bArr = new byte[serializedSize];
            Logger logger = d05.b;
            d05.c cVar = new d05.c(bArr, 0, serializedSize);
            writeTo(cVar);
            if (cVar.b0() == 0) {
                return new a05.f(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            throw new RuntimeException(getSerializingExceptionMessage("ByteString"), e);
        }
    }

    public void writeDelimitedTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        int z = d05.z(serializedSize) + serializedSize;
        if (z > 4096) {
            z = 4096;
        }
        d05.e eVar = new d05.e(outputStream, z);
        eVar.Y(serializedSize);
        writeTo(eVar);
        if (eVar.f > 0) {
            eVar.f0();
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        int serializedSize = getSerializedSize();
        Logger logger = d05.b;
        if (serializedSize > 4096) {
            serializedSize = 4096;
        }
        d05.e eVar = new d05.e(outputStream, serializedSize);
        writeTo(eVar);
        if (eVar.f > 0) {
            eVar.f0();
        }
    }

    /* renamed from: rz4$a */
    /* compiled from: AbstractMessageLite */
    public static abstract class a<MessageType extends rz4<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> implements j15.a {
        public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
            Charset charset = s05.f3160a;
            Objects.requireNonNull(iterable);
            if (iterable instanceof y05) {
                List<?> m = ((y05) iterable).m();
                y05 y05 = (y05) list;
                int size = list.size();
                for (Object obj : m) {
                    if (obj == null) {
                        StringBuilder i0 = hj1.i0("Element at index ");
                        i0.append(y05.size() - size);
                        i0.append(" is null.");
                        String sb = i0.toString();
                        int size2 = y05.size();
                        while (true) {
                            size2--;
                            if (size2 >= size) {
                                y05.remove(size2);
                            } else {
                                throw new NullPointerException(sb);
                            }
                        }
                    } else if (obj instanceof a05) {
                        y05.K((a05) obj);
                    } else {
                        y05.add((String) obj);
                    }
                }
            } else if (iterable instanceof r15) {
                list.addAll((Collection) iterable);
            } else {
                addAllCheckingNulls(iterable, list);
            }
        }

        private static <T> void addAllCheckingNulls(Iterable<T> iterable, List<? super T> list) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
            }
            int size = list.size();
            for (T t : iterable) {
                if (t == null) {
                    StringBuilder i0 = hj1.i0("Element at index ");
                    i0.append(list.size() - size);
                    i0.append(" is null.");
                    String sb = i0.toString();
                    int size2 = list.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            list.remove(size2);
                        } else {
                            throw new NullPointerException(sb);
                        }
                    }
                } else {
                    list.add(t);
                }
            }
        }

        private String getReadingExceptionMessage(String str) {
            StringBuilder i0 = hj1.i0("Reading ");
            i0.append(getClass().getName());
            i0.append(" from a ");
            i0.append(str);
            i0.append(" threw an IOException (should never happen).");
            return i0.toString();
        }

        public static d25 newUninitializedMessageException(j15 j15) {
            return new d25();
        }

        @Override // java.lang.Object
        public abstract /* bridge */ /* synthetic */ j15.a clone();

        @Override // java.lang.Object
        public abstract /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException;

        @Override // java.lang.Object
        public abstract BuilderType clone();

        public abstract BuilderType internalMergeFrom(MessageType messagetype);

        public boolean mergeDelimitedFrom(InputStream inputStream, i05 i05) throws IOException {
            int read = inputStream.read();
            if (read == -1) {
                return false;
            }
            mergeFrom((InputStream) new C0051a(inputStream, b05.t(read, inputStream)), i05);
            return true;
        }

        public abstract /* bridge */ /* synthetic */ j15.a mergeFrom(b05 b05, i05 i05) throws IOException;

        public abstract /* bridge */ /* synthetic */ j15.a mergeFrom(byte[] bArr, int i, int i2) throws t05;

        public abstract /* bridge */ /* synthetic */ j15.a mergeFrom(byte[] bArr, int i, int i2, i05 i05) throws t05;

        public abstract BuilderType mergeFrom(b05 b05, i05 i05) throws IOException;

        public abstract BuilderType mergeFrom(byte[] bArr, int i, int i2) throws t05;

        public abstract BuilderType mergeFrom(byte[] bArr, int i, int i2, i05 i05) throws t05;

        /* renamed from: rz4$a$a  reason: collision with other inner class name */
        /* compiled from: AbstractMessageLite */
        public static final class C0051a extends FilterInputStream {
            public int f;

            public C0051a(InputStream inputStream, int i) {
                super(inputStream);
                this.f = i;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() throws IOException {
                return Math.min(super.available(), this.f);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() throws IOException {
                if (this.f <= 0) {
                    return -1;
                }
                int read = super.read();
                if (read >= 0) {
                    this.f--;
                }
                return read;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long j) throws IOException {
                long skip = super.skip(Math.min(j, (long) this.f));
                if (skip >= 0) {
                    this.f = (int) (((long) this.f) - skip);
                }
                return skip;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                int i3 = this.f;
                if (i3 <= 0) {
                    return -1;
                }
                int read = super.read(bArr, i, Math.min(i2, i3));
                if (read >= 0) {
                    this.f -= read;
                }
                return read;
            }
        }

        public boolean mergeDelimitedFrom(InputStream inputStream) throws IOException {
            return mergeDelimitedFrom(inputStream, i05.a());
        }

        public BuilderType mergeFrom(b05 b05) throws IOException {
            return mergeFrom(b05, i05.a());
        }

        public BuilderType mergeFrom(a05 a05) throws t05 {
            try {
                b05 v = a05.v();
                mergeFrom(v);
                v.a(0);
                return this;
            } catch (t05 e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e2);
            }
        }

        public BuilderType mergeFrom(a05 a05, i05 i05) throws t05 {
            try {
                b05 v = a05.v();
                mergeFrom(v, i05);
                v.a(0);
                return this;
            } catch (t05 e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException(getReadingExceptionMessage("ByteString"), e2);
            }
        }

        @Deprecated
        public static <T> void addAll(Iterable<T> iterable, Collection<? super T> collection) {
            addAll((Iterable) iterable, (List) collection);
        }

        public BuilderType mergeFrom(byte[] bArr) throws t05 {
            return mergeFrom(bArr, 0, bArr.length);
        }

        public BuilderType mergeFrom(byte[] bArr, i05 i05) throws t05 {
            return mergeFrom(bArr, 0, bArr.length, i05);
        }

        public BuilderType mergeFrom(InputStream inputStream) throws IOException {
            b05 f = b05.f(inputStream);
            mergeFrom(f);
            f.a(0);
            return this;
        }

        public BuilderType mergeFrom(InputStream inputStream, i05 i05) throws IOException {
            b05 f = b05.f(inputStream);
            mergeFrom(f, i05);
            f.a(0);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: rz4$a<MessageType extends rz4<MessageType, BuilderType>, BuilderType extends rz4$a<MessageType, BuilderType>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.j15.a
        public BuilderType mergeFrom(j15 j15) {
            if (getDefaultInstanceForType().getClass().isInstance(j15)) {
                return (BuilderType) internalMergeFrom((rz4) j15);
            }
            throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
        }
    }

    public static <T> void addAll(Iterable<T> iterable, List<? super T> list) {
        a.addAll((Iterable) iterable, (List) list);
    }
}
