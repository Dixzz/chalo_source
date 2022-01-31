package defpackage;

import com.rabbitmq.client.StringRpcServer;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.Spliterator;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.RandomAccess;

/* renamed from: s05  reason: default package */
/* compiled from: Internal */
public final class s05 {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f3160a = Charset.forName(StringRpcServer.STRING_ENCODING);
    public static final byte[] b;

    /* renamed from: s05$a */
    /* compiled from: Internal */
    public interface a extends j<Boolean> {
    }

    /* renamed from: s05$b */
    /* compiled from: Internal */
    public interface b extends j<Double> {
    }

    /* renamed from: s05$c */
    /* compiled from: Internal */
    public interface c {
        int getNumber();
    }

    /* renamed from: s05$d */
    /* compiled from: Internal */
    public interface d<T extends c> {
        T findValueByNumber(int i);
    }

    /* renamed from: s05$e */
    /* compiled from: Internal */
    public interface e {
        boolean isInRange(int i);
    }

    /* renamed from: s05$f */
    /* compiled from: Internal */
    public interface f extends j<Float> {
    }

    /* renamed from: s05$g */
    /* compiled from: Internal */
    public interface g extends j<Integer> {
    }

    /* renamed from: s05$h */
    /* compiled from: Internal */
    public static class h<F, T> extends AbstractList<T> implements List {
        public final java.util.List<F> f;
        public final a<F, T> g;

        /* renamed from: s05$h$a */
        /* compiled from: Internal */
        public interface a<F, T> {
            T convert(F f);
        }

        public h(java.util.List<F> list, a<F, T> aVar) {
            this.f = list;
            this.g = aVar;
        }

        @Override // j$.util.Collection, j$.lang.Iterable
        public /* synthetic */ void forEach(Consumer consumer) {
            Iterable.CC.$default$forEach(this, consumer);
        }

        @Override // java.util.List, java.util.AbstractList, j$.util.List
        public T get(int i) {
            return this.g.convert(this.f.get(i));
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream parallelStream() {
            return Collection.CC.$default$parallelStream(this);
        }

        @Override // j$.util.Collection
        public /* synthetic */ boolean removeIf(Predicate predicate) {
            return Collection.CC.$default$removeIf(this, predicate);
        }

        @Override // j$.util.List
        public /* synthetic */ void replaceAll(UnaryOperator unaryOperator) {
            List.CC.$default$replaceAll(this, unaryOperator);
        }

        @Override // j$.util.Collection, j$.util.List
        public int size() {
            return this.f.size();
        }

        @Override // java.util.List, j$.util.List
        public /* synthetic */ void sort(Comparator comparator) {
            List.CC.$default$sort(this, comparator);
        }

        @Override // j$.util.Collection, java.util.List, java.util.Collection, j$.util.List, j$.lang.Iterable, java.lang.Iterable
        public /* synthetic */ Spliterator spliterator() {
            return List.CC.$default$spliterator(this);
        }

        @Override // j$.util.Collection, java.util.Collection
        public /* synthetic */ Stream stream() {
            return Collection.CC.$default$stream(this);
        }
    }

    /* renamed from: s05$i */
    /* compiled from: Internal */
    public interface i extends j<Long> {
    }

    /* renamed from: s05$j */
    /* compiled from: Internal */
    public interface j<E> extends java.util.List<E>, RandomAccess, List {
        void c();

        j<E> f(int i);

        boolean t();
    }

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        b = bArr;
        ByteBuffer.wrap(bArr);
        b05.h(bArr, 0, 0, false);
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int b(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public static Object c(Object obj, Object obj2) {
        return ((j15) obj).toBuilder().mergeFrom((j15) obj2).buildPartial();
    }
}
