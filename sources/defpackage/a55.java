package defpackage;

/* renamed from: a55  reason: default package */
/* compiled from: Version */
public final class a55 {
    public static final a55[] h = {new a55(1, 10, 10, 8, 8, new c(5, new b(1, 3, null), null)), new a55(2, 12, 12, 10, 10, new c(7, new b(1, 5, null), null)), new a55(3, 14, 14, 12, 12, new c(10, new b(1, 8, null), null)), new a55(4, 16, 16, 14, 14, new c(12, new b(1, 12, null), null)), new a55(5, 18, 18, 16, 16, new c(14, new b(1, 18, null), null)), new a55(6, 20, 20, 18, 18, new c(18, new b(1, 22, null), null)), new a55(7, 22, 22, 20, 20, new c(20, new b(1, 30, null), null)), new a55(8, 24, 24, 22, 22, new c(24, new b(1, 36, null), null)), new a55(9, 26, 26, 24, 24, new c(28, new b(1, 44, null), null)), new a55(10, 32, 32, 14, 14, new c(36, new b(1, 62, null), null)), new a55(11, 36, 36, 16, 16, new c(42, new b(1, 86, null), null)), new a55(12, 40, 40, 18, 18, new c(48, new b(1, 114, null), null)), new a55(13, 44, 44, 20, 20, new c(56, new b(1, 144, null), null)), new a55(14, 48, 48, 22, 22, new c(68, new b(1, 174, null), null)), new a55(15, 52, 52, 24, 24, new c(42, new b(2, 102, null), null)), new a55(16, 64, 64, 14, 14, new c(56, new b(2, 140, null), null)), new a55(17, 72, 72, 16, 16, new c(36, new b(4, 92, null), null)), new a55(18, 80, 80, 18, 18, new c(48, new b(4, 114, null), null)), new a55(19, 88, 88, 20, 20, new c(56, new b(4, 144, null), null)), new a55(20, 96, 96, 22, 22, new c(68, new b(4, 174, null), null)), new a55(21, 104, 104, 24, 24, new c(56, new b(6, 136, null), null)), new a55(22, 120, 120, 18, 18, new c(68, new b(6, 175, null), null)), new a55(23, 132, 132, 20, 20, new c(62, new b(8, 163, null), null)), new a55(24, 144, 144, 22, 22, new c(62, new b(8, 156, null), new b(2, 155, null), null)), new a55(25, 8, 18, 6, 16, new c(7, new b(1, 5, null), null)), new a55(26, 8, 32, 6, 14, new c(11, new b(1, 10, null), null)), new a55(27, 12, 26, 10, 24, new c(14, new b(1, 16, null), null)), new a55(28, 12, 36, 10, 16, new c(18, new b(1, 22, null), null)), new a55(29, 16, 36, 14, 16, new c(24, new b(1, 32, null), null)), new a55(30, 16, 48, 14, 22, new c(28, new b(1, 49, null), null))};

    /* renamed from: a  reason: collision with root package name */
    public final int f120a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final c f;
    public final int g;

    /* renamed from: a55$b */
    /* compiled from: Version */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f121a;
        public final int b;

        public b(int i, int i2, a aVar) {
            this.f121a = i;
            this.b = i2;
        }
    }

    public a55(int i, int i2, int i3, int i4, int i5, c cVar) {
        this.f120a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = cVar;
        int i6 = cVar.f122a;
        b[] bVarArr = cVar.b;
        int i7 = 0;
        for (b bVar : bVarArr) {
            i7 = hj1.b(bVar.b, i6, bVar.f121a, i7);
        }
        this.g = i7;
    }

    public String toString() {
        return String.valueOf(this.f120a);
    }

    /* renamed from: a55$c */
    /* compiled from: Version */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final int f122a;
        public final b[] b;

        public c(int i, b bVar, a aVar) {
            this.f122a = i;
            this.b = new b[]{bVar};
        }

        public c(int i, b bVar, b bVar2, a aVar) {
            this.f122a = i;
            this.b = new b[]{bVar, bVar2};
        }
    }
}
