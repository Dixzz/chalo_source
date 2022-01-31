package defpackage;

import defpackage.u00;
import java.util.Objects;

/* renamed from: x00  reason: default package */
/* compiled from: CabsFeature */
public class x00 extends u00.m {
    public final /* synthetic */ u00.g b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x00(u00.g gVar) {
        super(null);
        this.b = gVar;
    }

    @Override // defpackage.p20.a
    public void a(String str, String str2, String str3) {
        u00.g gVar = this.b;
        u00.this.p(str, str2, gVar.c);
        u00.g gVar2 = this.b;
        u00 u00 = u00.this;
        String str4 = gVar2.c;
        Objects.requireNonNull(u00);
        if (xt.f3961a.f().f3289a.b.getString("live_booking_url", null) == null) {
            u00.k(str, str4, str2);
        }
    }
}
