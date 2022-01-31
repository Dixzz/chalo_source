package defpackage;

/* renamed from: c15  reason: default package */
/* compiled from: MapEntryLite */
public class c15<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public final a<K, V> f503a;
    public final K b;
    public final V c;

    /* renamed from: c15$a */
    /* compiled from: MapEntryLite */
    public static class a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        public final l25 f504a;
        public final K b;
        public final l25 c;
        public final V d;

        public a(l25 l25, K k, l25 l252, V v) {
            this.f504a = l25;
            this.b = k;
            this.c = l252;
            this.d = v;
        }
    }

    public c15(l25 l25, K k, l25 l252, V v) {
        this.f503a = new a<>(l25, k, l252, v);
        this.b = k;
        this.c = v;
    }

    public static <K, V> int a(a<K, V> aVar, K k, V v) {
        return m05.d(aVar.c, 2, v) + m05.d(aVar.f504a, 1, k);
    }
}
