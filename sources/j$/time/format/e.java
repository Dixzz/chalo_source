package j$.time.format;

import j$.com.android.tools.r8.a;
import j$.time.b;
import j$.time.temporal.k;
import j$.time.temporal.l;
import j$.time.temporal.n;
import java.util.Locale;

/* access modifiers changed from: package-private */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private k f1613a;
    private b b;
    private int c;

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    e(j$.time.temporal.k r10, j$.time.format.b r11) {
        /*
        // Method dump skipped, instructions count: 321
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.format.e.<init>(j$.time.temporal.k, j$.time.format.b):void");
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.c--;
    }

    /* access modifiers changed from: package-private */
    public g b() {
        return this.b.c();
    }

    /* access modifiers changed from: package-private */
    public Locale c() {
        return this.b.d();
    }

    /* access modifiers changed from: package-private */
    public k d() {
        return this.f1613a;
    }

    /* access modifiers changed from: package-private */
    public Long e(l lVar) {
        try {
            return Long.valueOf(this.f1613a.l(lVar));
        } catch (b e) {
            if (this.c > 0) {
                return null;
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public Object f(n nVar) {
        Object n = this.f1613a.n(nVar);
        if (n != null || this.c != 0) {
            return n;
        }
        StringBuilder a2 = a.a("Unable to extract value: ");
        a2.append(this.f1613a.getClass());
        throw new b(a2.toString());
    }

    /* access modifiers changed from: package-private */
    public void g() {
        this.c++;
    }

    public String toString() {
        return this.f1613a.toString();
    }
}
