package defpackage;

import defpackage.i46;
import defpackage.m36;
import defpackage.t46;
import java.util.ArrayList;
import java.util.Objects;
import java.util.logging.Logger;

/* renamed from: k46  reason: default package */
/* compiled from: Polling */
public abstract class k46 extends i46 {
    public static final Logger o = Logger.getLogger(k46.class.getName());
    public boolean n;

    /* renamed from: k46$a */
    /* compiled from: Polling */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k46 f2020a;

        public a(k46 k46, k46 k462) {
            this.f2020a = k462;
        }

        public boolean a(s46 s46, int i, int i2) {
            k46 k46 = this.f2020a;
            if (k46.k == i46.d.OPENING) {
                Objects.requireNonNull(k46);
                k46.k = i46.d.OPEN;
                k46.b = true;
                k46.a("open", new Object[0]);
            }
            if ("close".equals(s46.f3185a)) {
                this.f2020a.h();
                return false;
            }
            this.f2020a.j(s46);
            return true;
        }
    }

    /* renamed from: k46$b */
    /* compiled from: Polling */
    public class b implements m36.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k46 f2021a;

        public b(k46 k46, k46 k462) {
            this.f2021a = k462;
        }

        @Override // defpackage.m36.a
        public void a(Object... objArr) {
            k46.o.fine("writing close packet");
            try {
                this.f2021a.l(new s46[]{new s46("close")});
            } catch (e56 e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: k46$c */
    /* compiled from: Polling */
    public class c implements Runnable {
        public final /* synthetic */ k46 f;

        public c(k46 k46, k46 k462) {
            this.f = k462;
        }

        public void run() {
            k46 k46 = this.f;
            k46.b = true;
            k46.a("drain", new Object[0]);
        }
    }

    /* renamed from: k46$d */
    /* compiled from: Polling */
    public class d implements t46.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k46 f2022a;
        public final /* synthetic */ Runnable b;

        public d(k46 k46, k46 k462, Runnable runnable) {
            this.f2022a = k462;
            this.b = runnable;
        }

        @Override // defpackage.t46.b
        public void a(Object obj) {
            if (obj instanceof byte[]) {
                this.f2022a.p((byte[]) obj, this.b);
            } else if (obj instanceof String) {
                this.f2022a.o((String) obj, this.b);
            } else {
                Logger logger = k46.o;
                logger.warning("Unexpected data: " + obj);
            }
        }
    }

    public k46(i46.c cVar) {
        super(cVar);
        this.c = "polling";
    }

    @Override // defpackage.i46
    public void f() {
        b bVar = new b(this, this);
        if (this.k == i46.d.OPEN) {
            o.fine("transport open - closing");
            bVar.a(new Object[0]);
            return;
        }
        o.fine("transport not open - deferring close");
        d("open", new m36.b("open", bVar));
    }

    @Override // defpackage.i46
    public void g() {
        q();
    }

    @Override // defpackage.i46
    public void l(s46[] s46Arr) throws e56 {
        this.b = false;
        d dVar = new d(this, this, new c(this, this));
        int i = t46.f3308a;
        for (s46 s46 : s46Arr) {
            if (s46.b instanceof byte[]) {
                if (s46Arr.length == 0) {
                    dVar.a(new byte[0]);
                    return;
                } else {
                    ArrayList arrayList = new ArrayList(s46Arr.length);
                    for (s46 s462 : s46Arr) {
                        t46.c(s462, true, new w46(new v46(arrayList)));
                    }
                    dVar.a(hd3.L((byte[][]) arrayList.toArray(new byte[arrayList.size()][])));
                    return;
                }
            }
        }
        if (s46Arr.length == 0) {
            dVar.a("0:");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (s46 s463 : s46Arr) {
            t46.c(s463, false, new u46(sb));
        }
        dVar.a(sb.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e7, code lost:
        r12.position(r4.length() + 1);
        r12 = r12.slice();
        r4 = java.lang.Integer.parseInt(r4.toString());
        r12.position(1);
        r4 = r4 + 1;
        r12.limit(r4);
        r7 = r12.remaining();
        r8 = new byte[r7];
        r12.get(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x010b, code lost:
        if (r5 == false) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010d, code lost:
        r5 = new java.lang.StringBuilder();
        r9 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0113, code lost:
        if (r9 >= r7) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0115, code lost:
        r5.appendCodePoint(r8[r9] & 255);
        r9 = r9 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011e, code lost:
        r1.add(r5.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0126, code lost:
        r1.add(r8);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m(java.lang.Object r12) {
        /*
        // Method dump skipped, instructions count: 420
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k46.m(java.lang.Object):void");
    }

    public abstract void n();

    public abstract void o(String str, Runnable runnable);

    public abstract void p(byte[] bArr, Runnable runnable);

    public final void q() {
        o.fine("polling");
        this.n = true;
        n();
        a("poll", new Object[0]);
    }
}
