package defpackage;

import java.io.IOException;

/* renamed from: wc  reason: default package */
/* compiled from: MapEntryLite */
public class wc<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final a<K, V> f3758a;
    public final K b;
    public final V c;

    /* renamed from: wc$a */
    /* compiled from: MapEntryLite */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final fe f3759a;
        public final K b;
        public final fe c;
        public final V d;

        public a(fe feVar, K k, fe feVar2, V v) {
            this.f3759a = feVar;
            this.b = k;
            this.c = feVar2;
            this.d = v;
        }
    }

    public wc(fe feVar, K k, fe feVar2, V v) {
        this.f3758a = new a<>(feVar, k, feVar2, v);
        this.b = k;
        this.c = v;
    }

    public static <K, V> int a(a<K, V> aVar, K k, V v) {
        return gc.c(aVar.c, 2, v) + gc.c(aVar.f3759a, 1, k);
    }

    public static <K, V> void b(xb xbVar, a<K, V> aVar, K k, V v) throws IOException {
        gc.p(xbVar, aVar.f3759a, 1, k);
        gc.p(xbVar, aVar.c, 2, v);
    }
}
