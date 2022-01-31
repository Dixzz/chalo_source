package defpackage;

import androidx.lifecycle.LiveData;
import defpackage.g2;
import java.util.Iterator;
import java.util.Map;

/* renamed from: mh  reason: default package */
/* compiled from: MediatorLiveData */
public class mh<T> extends oh<T> {
    public g2<LiveData<?>, a<?>> l = new g2<>();

    /* renamed from: mh$a */
    /* compiled from: MediatorLiveData */
    public static class a<V> implements ph<V> {

        /* renamed from: a  reason: collision with root package name */
        public final LiveData<V> f2375a;
        public final ph<? super V> b;
        public int c = -1;

        public a(LiveData<V> liveData, ph<? super V> phVar) {
            this.f2375a = liveData;
            this.b = phVar;
        }

        @Override // defpackage.ph
        public void a(V v) {
            int i = this.c;
            int i2 = this.f2375a.g;
            if (i != i2) {
                this.c = i2;
                this.b.a(v);
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void h() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.l.iterator();
        while (true) {
            g2.e eVar = (g2.e) it;
            if (eVar.hasNext()) {
                a aVar = (a) ((Map.Entry) eVar.next()).getValue();
                aVar.f2375a.g(aVar);
            } else {
                return;
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void i() {
        Iterator<Map.Entry<LiveData<?>, a<?>>> it = this.l.iterator();
        while (true) {
            g2.e eVar = (g2.e) it;
            if (eVar.hasNext()) {
                a aVar = (a) ((Map.Entry) eVar.next()).getValue();
                aVar.f2375a.k(aVar);
            } else {
                return;
            }
        }
    }

    public <S> void m(LiveData<S> liveData, ph<? super S> phVar) {
        a<?> aVar = new a<>(liveData, phVar);
        a<?> k = this.l.k(liveData, aVar);
        if (k != null && k.b != phVar) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        } else if (k == null && e()) {
            aVar.f2375a.g(aVar);
        }
    }
}
