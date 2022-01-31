package defpackage;

/* renamed from: jq1  reason: default package */
/* compiled from: DownsampleStrategy */
public abstract class jq1 {

    /* renamed from: a  reason: collision with root package name */
    public static final jq1 f1969a = new d();
    public static final jq1 b = new c();
    public static final jq1 c = new a();
    public static final jq1 d = new b();

    /* renamed from: jq1$a */
    /* compiled from: DownsampleStrategy */
    public static class a extends jq1 {
        @Override // defpackage.jq1
        public e a(int i, int i2, int i3, int i4) {
            return e.QUALITY;
        }

        @Override // defpackage.jq1
        public float b(int i, int i2, int i3, int i4) {
            int min = Math.min(i2 / i4, i / i3);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }
    }

    /* renamed from: jq1$b */
    /* compiled from: DownsampleStrategy */
    public static class b extends jq1 {
        @Override // defpackage.jq1
        public e a(int i, int i2, int i3, int i4) {
            return e.QUALITY;
        }

        @Override // defpackage.jq1
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, jq1.f1969a.b(i, i2, i3, i4));
        }
    }

    /* renamed from: jq1$c */
    /* compiled from: DownsampleStrategy */
    public static class c extends jq1 {
        @Override // defpackage.jq1
        public e a(int i, int i2, int i3, int i4) {
            return e.QUALITY;
        }

        @Override // defpackage.jq1
        public float b(int i, int i2, int i3, int i4) {
            return Math.max(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }
    }

    /* renamed from: jq1$d */
    /* compiled from: DownsampleStrategy */
    public static class d extends jq1 {
        @Override // defpackage.jq1
        public e a(int i, int i2, int i3, int i4) {
            return e.QUALITY;
        }

        @Override // defpackage.jq1
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(((float) i3) / ((float) i), ((float) i4) / ((float) i2));
        }
    }

    /* renamed from: jq1$e */
    /* compiled from: DownsampleStrategy */
    public enum e {
        MEMORY,
        QUALITY
    }

    public abstract e a(int i, int i2, int i3, int i4);

    public abstract float b(int i, int i2, int i3, int i4);
}
