package defpackage;

/* renamed from: cl  reason: default package */
/* compiled from: StableIdStorage */
public interface cl {

    /* renamed from: cl$a */
    /* compiled from: StableIdStorage */
    public static class a implements cl {

        /* renamed from: a  reason: collision with root package name */
        public long f576a = 0;

        /* renamed from: cl$a$a  reason: collision with other inner class name */
        /* compiled from: StableIdStorage */
        public class C0006a implements d {

            /* renamed from: a  reason: collision with root package name */
            public final r2<Long> f577a = new r2<>();

            public C0006a() {
            }

            @Override // defpackage.cl.d
            public long a(long j) {
                Long g = this.f577a.g(j, null);
                if (g == null) {
                    a aVar = a.this;
                    long j2 = aVar.f576a;
                    aVar.f576a = 1 + j2;
                    g = Long.valueOf(j2);
                    this.f577a.j(j, g);
                }
                return g.longValue();
            }
        }

        @Override // defpackage.cl
        public d a() {
            return new C0006a();
        }
    }

    /* renamed from: cl$b */
    /* compiled from: StableIdStorage */
    public static class b implements cl {

        /* renamed from: a  reason: collision with root package name */
        public final d f578a = new a(this);

        /* renamed from: cl$b$a */
        /* compiled from: StableIdStorage */
        public class a implements d {
            public a(b bVar) {
            }

            @Override // defpackage.cl.d
            public long a(long j) {
                return -1;
            }
        }

        @Override // defpackage.cl
        public d a() {
            return this.f578a;
        }
    }

    /* renamed from: cl$c */
    /* compiled from: StableIdStorage */
    public static class c implements cl {

        /* renamed from: a  reason: collision with root package name */
        public final d f579a = new a(this);

        /* renamed from: cl$c$a */
        /* compiled from: StableIdStorage */
        public class a implements d {
            public a(c cVar) {
            }

            @Override // defpackage.cl.d
            public long a(long j) {
                return j;
            }
        }

        @Override // defpackage.cl
        public d a() {
            return this.f579a;
        }
    }

    /* renamed from: cl$d */
    /* compiled from: StableIdStorage */
    public interface d {
        long a(long j);
    }

    d a();
}
