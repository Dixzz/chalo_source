package defpackage;

import com.razorpay.AnalyticsConstants;
import java.math.BigDecimal;

/* renamed from: ih4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class ih4 extends fh4 {
    public gq3 g;
    public final /* synthetic */ ch4 h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ih4(ch4 ch4, String str, int i, gq3 gq3) {
        super(str, i);
        this.h = ch4;
        this.g = gq3;
    }

    @Override // defpackage.fh4
    public final int a() {
        return this.g.v();
    }

    @Override // defpackage.fh4
    public final boolean g() {
        return true;
    }

    @Override // defpackage.fh4
    public final boolean h() {
        return false;
    }

    public final boolean i(Long l, Long l2, cr3 cr3, boolean z) {
        boolean z2 = gz3.a() && this.h.f3331a.g.t(this.f1123a, q64.a0);
        boolean y = this.g.y();
        boolean z3 = this.g.z();
        boolean B = this.g.B();
        boolean z4 = y || z3 || B;
        Boolean bool = null;
        Boolean bool2 = null;
        Integer num = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (!z || z4) {
            eq3 x = this.g.x();
            boolean z5 = x.z();
            if (cr3.G()) {
                if (!x.w()) {
                    this.h.g().i.b("No number filter for long property. property", this.h.d().x(cr3.C()));
                } else {
                    bool = fh4.c(fh4.b(cr3.H(), x.x()), z5);
                }
            } else if (cr3.I()) {
                if (!x.w()) {
                    this.h.g().i.b("No number filter for double property. property", this.h.d().x(cr3.C()));
                } else {
                    double J = cr3.J();
                    try {
                        bool2 = fh4.f(new BigDecimal(J), x.x(), Math.ulp(J));
                    } catch (NumberFormatException unused) {
                    }
                    bool = fh4.c(bool2, z5);
                }
            } else if (!cr3.E()) {
                this.h.g().i.b("User property has no value, property", this.h.d().x(cr3.C()));
            } else if (x.u()) {
                bool = fh4.c(fh4.e(cr3.F(), x.v(), this.h.g()), z5);
            } else if (!x.w()) {
                this.h.g().i.b("No string or number filter defined. property", this.h.d().x(cr3.C()));
            } else if (rg4.O(cr3.F())) {
                bool = fh4.c(fh4.d(cr3.F(), x.x()), z5);
            } else {
                this.h.g().i.c("Invalid user property value for Numeric number filter. property, value", this.h.d().x(cr3.C()), cr3.F());
            }
            this.h.g().n.b("Property filter result", bool == null ? AnalyticsConstants.NULL : bool);
            if (bool == null) {
                return false;
            }
            this.c = Boolean.TRUE;
            if (B && !bool.booleanValue()) {
                return true;
            }
            if (!z || this.g.y()) {
                this.d = bool;
            }
            if (bool.booleanValue() && z4 && cr3.x()) {
                long y2 = cr3.y();
                if (l != null) {
                    y2 = l.longValue();
                }
                if (z2 && this.g.y() && !this.g.z() && l2 != null) {
                    y2 = l2.longValue();
                }
                if (this.g.z()) {
                    this.f = Long.valueOf(y2);
                } else {
                    this.e = Long.valueOf(y2);
                }
            }
            return true;
        }
        ta4 ta4 = this.h.g().n;
        Integer valueOf = Integer.valueOf(this.b);
        if (this.g.u()) {
            num = Integer.valueOf(this.g.v());
        }
        ta4.c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", valueOf, num);
        return true;
    }
}
