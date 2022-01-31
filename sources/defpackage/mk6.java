package defpackage;

import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.zm6;

/* renamed from: mk6  reason: default package */
/* compiled from: Header.kt */
public final class mk6 {
    public static final zm6 d;
    public static final zm6 e;
    public static final zm6 f;
    public static final zm6 g;
    public static final zm6 h;
    public static final zm6 i;

    /* renamed from: a  reason: collision with root package name */
    public final int f2393a;
    public final zm6 b;
    public final zm6 c;

    static {
        zm6.a aVar = zm6.j;
        d = aVar.c(ProductDiscountsObject.KEY_DELIMITER);
        e = aVar.c(":status");
        f = aVar.c(":method");
        g = aVar.c(":path");
        h = aVar.c(":scheme");
        i = aVar.c(":authority");
    }

    public mk6(zm6 zm6, zm6 zm62) {
        n86.f(zm6, "name");
        n86.f(zm62, FirebaseAnalytics.Param.VALUE);
        this.b = zm6;
        this.c = zm62;
        this.f2393a = zm6.g() + 32 + zm62.g();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mk6)) {
            return false;
        }
        mk6 mk6 = (mk6) obj;
        return n86.a(this.b, mk6.b) && n86.a(this.c, mk6.c);
    }

    public int hashCode() {
        zm6 zm6 = this.b;
        int i2 = 0;
        int hashCode = (zm6 != null ? zm6.hashCode() : 0) * 31;
        zm6 zm62 = this.c;
        if (zm62 != null) {
            i2 = zm62.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return this.b.p() + ": " + this.c.p();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public mk6(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            defpackage.n86.f(r2, r0)
            java.lang.String r0 = "value"
            defpackage.n86.f(r3, r0)
            zm6$a r0 = defpackage.zm6.j
            zm6 r2 = r0.c(r2)
            zm6 r3 = r0.c(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.mk6.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public mk6(zm6 zm6, String str) {
        this(zm6, zm6.j.c(str));
        n86.f(zm6, "name");
        n86.f(str, FirebaseAnalytics.Param.VALUE);
    }
}
