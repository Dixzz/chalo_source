package defpackage;

import defpackage.i10;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: j10  reason: default package */
/* compiled from: EtaTuple */
public class j10 {

    /* renamed from: a  reason: collision with root package name */
    public final List<i10> f1862a;
    public List<i10> b;
    public List<i10> c;
    public Integer d;

    /* renamed from: j10$a */
    /* compiled from: EtaTuple */
    public class a implements Comparator<i10>, j$.util.Comparator {
        public a(j10 j10) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(i10 i10, i10 i102) {
            return i10.f1460a - i102.f1460a;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<i10> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<i10> thenComparing(java.util.Comparator<? super i10> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: j10$b */
    /* compiled from: EtaTuple */
    public class b implements java.util.Comparator<i10>, j$.util.Comparator {
        public b(j10 j10) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(i10 i10, i10 i102) {
            return i10.e - i102.e;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<i10> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<i10> thenComparing(java.util.Comparator<? super i10> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public j10(List<i10> list) {
        this.f1862a = list;
    }

    public int a() {
        Integer num = this.d;
        if (num != null) {
            return num.intValue();
        }
        List<i10> c2 = c();
        this.d = Integer.MAX_VALUE;
        for (i10 i10 : c2) {
            if (Integer.compare(i10.f1460a, this.d.intValue()) < 0) {
                this.d = Integer.valueOf(i10.f1460a);
            }
        }
        return this.d.intValue();
    }

    public List<i10> b() {
        List<i10> list = this.c;
        if (list != null) {
            return list;
        }
        this.c = new ArrayList();
        for (i10 i10 : this.f1862a) {
            if (i10.d.equals(i10.a.ESTIMATED)) {
                this.c.add(i10);
            }
        }
        Collections.sort(this.c, new b(this));
        return this.c;
    }

    public List<i10> c() {
        List<i10> list = this.b;
        if (list != null) {
            return list;
        }
        this.b = new ArrayList();
        for (i10 i10 : this.f1862a) {
            if (i10.d.equals(i10.a.FIXED)) {
                this.b.add(i10);
            }
        }
        Collections.sort(this.b, new a(this));
        return this.b;
    }
}
