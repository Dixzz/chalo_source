package defpackage;

import com.rabbitmq.client.ConnectionFactory;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/* renamed from: b55  reason: default package */
/* compiled from: Detector */
public final class b55 {

    /* renamed from: a  reason: collision with root package name */
    public final f45 f383a;
    public final o45 b;

    /* renamed from: b55$b */
    /* compiled from: Detector */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final g35 f384a;
        public final g35 b;
        public final int c;

        public b(g35 g35, g35 g352, int i, a aVar) {
            this.f384a = g35;
            this.b = g352;
            this.c = i;
        }

        public String toString() {
            return this.f384a + ConnectionFactory.DEFAULT_VHOST + this.b + '/' + this.c;
        }
    }

    /* renamed from: b55$c */
    /* compiled from: Detector */
    public static final class c implements Serializable, Comparator<b>, j$.util.Comparator {
        public c(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(b bVar, b bVar2) {
            return bVar.c - bVar2.c;
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<b> reversed() {
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
        public /* synthetic */ java.util.Comparator<b> thenComparing(java.util.Comparator<? super b> comparator) {
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

    public b55(f45 f45) throws a35 {
        this.f383a = f45;
        this.b = new o45(f45, 10, f45.f / 2, f45.g / 2);
    }

    public static int a(g35 g35, g35 g352) {
        return hd3.I2(hd3.G0(g35.f1210a, g35.b, g352.f1210a, g352.b));
    }

    public static void b(Map<g35, Integer> map, g35 g35) {
        Integer num = map.get(g35);
        int i = 1;
        if (num != null) {
            i = 1 + num.intValue();
        }
        map.put(g35, Integer.valueOf(i));
    }

    public static f45 d(f45 f45, g35 g35, g35 g352, g35 g353, g35 g354, int i, int i2) throws a35 {
        float f = ((float) i) - 0.5f;
        float f2 = ((float) i2) - 0.5f;
        return j45.f1875a.a(f45, i, i2, m45.a(0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, g35.f1210a, g35.b, g354.f1210a, g354.b, g353.f1210a, g353.b, g352.f1210a, g352.b));
    }

    public final boolean c(g35 g35) {
        float f = g35.f1210a;
        if (f < 0.0f) {
            return false;
        }
        f45 f45 = this.f383a;
        if (f >= ((float) f45.f)) {
            return false;
        }
        float f2 = g35.b;
        return f2 > 0.0f && f2 < ((float) f45.g);
    }

    public final b e(g35 g35, g35 g352) {
        b55 b55 = this;
        int i = (int) g35.f1210a;
        int i2 = (int) g35.b;
        int i3 = (int) g352.f1210a;
        int i4 = (int) g352.b;
        int i5 = 1;
        boolean z = Math.abs(i4 - i2) > Math.abs(i3 - i);
        if (z) {
            i2 = i;
            i = i2;
            i4 = i3;
            i3 = i4;
        }
        int abs = Math.abs(i3 - i);
        int abs2 = Math.abs(i4 - i2);
        int i6 = (-abs) / 2;
        int i7 = i2 < i4 ? 1 : -1;
        if (i >= i3) {
            i5 = -1;
        }
        boolean b2 = b55.f383a.b(z ? i2 : i, z ? i : i2);
        int i8 = 0;
        while (i != i3) {
            boolean b3 = b55.f383a.b(z ? i2 : i, z ? i : i2);
            if (b3 != b2) {
                i8++;
                b2 = b3;
            }
            i6 += abs2;
            if (i6 > 0) {
                if (i2 == i4) {
                    break;
                }
                i2 += i7;
                i6 -= abs;
            }
            i += i5;
            b55 = this;
        }
        return new b(g35, g352, i8, null);
    }
}
