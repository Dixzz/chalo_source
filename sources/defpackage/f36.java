package defpackage;

import defpackage.m36;
import j$.lang.Iterable;
import j$.util.Collection;
import j$.util.List;
import j$.util.function.Consumer;
import j$.util.function.Predicate;
import j$.util.function.UnaryOperator;
import j$.util.stream.Stream;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.logging.Logger;

/* renamed from: f36  reason: default package */
/* compiled from: Socket */
public class f36 extends LinkedList<d36> implements Collection, List {
    public final /* synthetic */ t26 f;
    public final /* synthetic */ e36 g;

    /* renamed from: f36$a */
    /* compiled from: Socket */
    public class a implements m36.a {
        public a() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            e36.e(f36.this.g);
        }
    }

    /* renamed from: f36$b */
    /* compiled from: Socket */
    public class b implements m36.a {
        public b() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            e36.f(f36.this.g, (a56) objArr[0]);
        }
    }

    /* renamed from: f36$c */
    /* compiled from: Socket */
    public class c implements m36.a {
        public c() {
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            e36 e36 = f36.this.g;
            String str = objArr.length > 0 ? (String) objArr[0] : null;
            Logger logger = e36.k;
            e36.k(str);
        }
    }

    public f36(e36 e36, t26 t26) {
        this.g = e36;
        this.f = t26;
        a aVar = new a();
        t26.d("open", aVar);
        add(new c36(t26, "open", aVar));
        b bVar = new b();
        t26.d("packet", bVar);
        add(new c36(t26, "packet", bVar));
        c cVar = new c();
        t26.d("close", cVar);
        add(new c36(t26, "close", cVar));
    }

    @Override // j$.util.Collection, j$.lang.Iterable
    public /* synthetic */ void forEach(Consumer consumer) {
        Iterable.CC.$default$forEach(this, consumer);
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

    @Override // j$.util.List, java.util.List
    public /* synthetic */ void sort(Comparator comparator) {
        List.CC.$default$sort(this, comparator);
    }

    /* Return type fixed from 'j$.util.Spliterator' to match base method */
    @Override // j$.util.Collection, java.util.Collection, j$.util.List, java.lang.Iterable, java.util.List, j$.lang.Iterable, java.util.LinkedList
    public /* synthetic */ Spliterator<d36> spliterator() {
        return List.CC.$default$spliterator(this);
    }

    @Override // j$.util.Collection, java.util.Collection
    public /* synthetic */ Stream stream() {
        return Collection.CC.$default$stream(this);
    }
}
