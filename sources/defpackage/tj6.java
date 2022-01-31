package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.nj6;
import defpackage.ol6;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: tj6  reason: default package */
/* compiled from: RealConnectionPool.kt */
public final class tj6 {

    /* renamed from: a  reason: collision with root package name */
    public final long f3368a;
    public final hj6 b;
    public final a c = new a(this, hj1.a0(new StringBuilder(), vi6.g, " ConnectionPool"));
    public final ConcurrentLinkedQueue<sj6> d = new ConcurrentLinkedQueue<>();
    public final int e;

    /* renamed from: tj6$a */
    /* compiled from: RealConnectionPool.kt */
    public static final class a extends fj6 {
        public final /* synthetic */ tj6 e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(tj6 tj6, String str) {
            super(str, true);
            this.e = tj6;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:37:0x0075, code lost:
            defpackage.vi6.d(r9.m());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0082, code lost:
            if (r0.d.isEmpty() == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0084, code lost:
            r0.b.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
            return 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
            return 0;
         */
        @Override // defpackage.fj6
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long a() {
            /*
            // Method dump skipped, instructions count: 145
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.tj6.a.a():long");
        }
    }

    public tj6(ij6 ij6, int i, long j, TimeUnit timeUnit) {
        n86.f(ij6, "taskRunner");
        n86.f(timeUnit, "timeUnit");
        this.e = i;
        this.f3368a = timeUnit.toNanos(j);
        this.b = ij6.f();
        if (!(j > 0)) {
            throw new IllegalArgumentException(hj1.M("keepAliveDuration <= 0: ", j).toString());
        }
    }

    public final boolean a(dh6 dh6, nj6 nj6, List<pi6> list, boolean z) {
        n86.f(dh6, "address");
        n86.f(nj6, AnalyticsConstants.CALL);
        Iterator<sj6> it = this.d.iterator();
        while (it.hasNext()) {
            sj6 next = it.next();
            n86.b(next, "connection");
            synchronized (next) {
                if (z) {
                    if (!next.j()) {
                    }
                }
                if (next.h(dh6, list)) {
                    nj6.b(next);
                    return true;
                }
            }
        }
        return false;
    }

    public final int b(sj6 sj6, long j) {
        byte[] bArr = vi6.f3652a;
        List<Reference<nj6>> list = sj6.o;
        int i = 0;
        while (i < list.size()) {
            Reference<nj6> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                StringBuilder i0 = hj1.i0("A connection to ");
                i0.append(sj6.q.f2809a.f839a);
                i0.append(" was leaked. ");
                i0.append("Did you forget to close a response body?");
                String sb = i0.toString();
                ol6.a aVar = ol6.c;
                ol6.f2709a.k(sb, ((nj6.b) reference).f2567a);
                list.remove(i);
                sj6.i = true;
                if (list.isEmpty()) {
                    sj6.p = j - this.f3368a;
                    return 0;
                }
            }
        }
        return list.size();
    }
}
