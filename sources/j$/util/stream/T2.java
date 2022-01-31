package j$.util.stream;

import j$.util.Map;
import j$.util.Spliterator;
import java.util.EnumMap;
import java.util.Map;

/* JADX WARN: Init of enum DISTINCT can be incorrect */
/* JADX WARN: Init of enum SORTED can be incorrect */
/* JADX WARN: Init of enum ORDERED can be incorrect */
/* JADX WARN: Init of enum SIZED can be incorrect */
/* JADX WARN: Init of enum SHORT_CIRCUIT can be incorrect */
/* access modifiers changed from: package-private */
public enum T2 {
    DISTINCT(0, r2),
    SORTED(1, r5),
    ORDERED(2, r7),
    SIZED(3, r11),
    SHORT_CIRCUIT(12, r13);
    
    static final int f;
    static final int g;
    static final int h;
    private static final int i;
    private static final int j;
    private static final int k;
    static final int l;
    static final int m;
    static final int n;
    static final int o;
    static final int p;
    static final int q;
    static final int r;
    static final int s;
    static final int t;
    static final int u;

    /* renamed from: a  reason: collision with root package name */
    private final Map f1745a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    /* access modifiers changed from: private */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Map f1746a;

        a(Map map) {
            this.f1746a = map;
        }

        /* access modifiers changed from: package-private */
        public a a(b bVar) {
            this.f1746a.put(bVar, 2);
            return this;
        }

        /* access modifiers changed from: package-private */
        public a b(b bVar) {
            this.f1746a.put(bVar, 1);
            return this;
        }

        /* access modifiers changed from: package-private */
        public a c(b bVar) {
            this.f1746a.put(bVar, 3);
            return this;
        }
    }

    /* access modifiers changed from: package-private */
    public enum b {
        SPLITERATOR,
        STREAM,
        OP,
        TERMINAL_OP,
        UPSTREAM_TERMINAL_OP
    }

    static {
        T2 t2;
        T2 t22;
        T2 t23;
        T2 t24;
        T2 t25;
        b bVar = b.SPLITERATOR;
        a v2 = v(bVar);
        b bVar2 = b.STREAM;
        v2.b(bVar2);
        b bVar3 = b.OP;
        v2.c(bVar3);
        a v3 = v(bVar);
        v3.b(bVar2);
        v3.c(bVar3);
        a v4 = v(bVar);
        v4.b(bVar2);
        v4.c(bVar3);
        b bVar4 = b.TERMINAL_OP;
        v4.a(bVar4);
        b bVar5 = b.UPSTREAM_TERMINAL_OP;
        v4.a(bVar5);
        a v5 = v(bVar);
        v5.b(bVar2);
        v5.a(bVar3);
        v(bVar3).b(bVar4);
        f = j(bVar);
        int j2 = j(bVar2);
        g = j2;
        h = j(bVar3);
        j(bVar4);
        j(bVar5);
        T2[] values = values();
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            i2 |= values[i3].e;
        }
        i = i2;
        j = j2;
        int i4 = j2 << 1;
        k = i4;
        l = j2 | i4;
        m = t2.c;
        n = t2.d;
        o = t22.c;
        p = t22.d;
        q = t23.c;
        r = t23.d;
        s = t24.c;
        t = t24.d;
        u = t25.c;
    }

    private T2(int i2, a aVar) {
        b[] values = b.values();
        for (int i3 = 0; i3 < 5; i3++) {
            b bVar = values[i3];
            Map map = aVar.f1746a;
            if (map instanceof j$.util.Map) {
                ((j$.util.Map) map).putIfAbsent(bVar, 0);
            } else {
                Map.CC.$default$putIfAbsent(map, bVar, 0);
            }
        }
        this.f1745a = aVar.f1746a;
        int i4 = i2 * 2;
        this.b = i4;
        this.c = 1 << i4;
        this.d = 2 << i4;
        this.e = 3 << i4;
    }

    static int h(int i2, int i3) {
        return i2 | (i3 & (i2 == 0 ? i : ~(((j & i2) << 1) | i2 | ((k & i2) >> 1))));
    }

    private static int j(b bVar) {
        T2[] values = values();
        int i2 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            T2 t2 = values[i3];
            i2 |= ((Integer) t2.f1745a.get(bVar)).intValue() << t2.b;
        }
        return i2;
    }

    static int l(Spliterator spliterator) {
        int characteristics = spliterator.characteristics();
        return ((characteristics & 4) == 0 || spliterator.getComparator() == null) ? f & characteristics : f & characteristics & -5;
    }

    private static a v(b bVar) {
        a aVar = new a(new EnumMap(b.class));
        aVar.f1746a.put(bVar, 1);
        return aVar;
    }

    static int w(int i2) {
        return i2 & ((~i2) >> 1) & j;
    }

    /* access modifiers changed from: package-private */
    public boolean n(int i2) {
        return (i2 & this.e) == this.c;
    }

    /* access modifiers changed from: package-private */
    public boolean t(int i2) {
        int i3 = this.e;
        return (i2 & i3) == i3;
    }
}
