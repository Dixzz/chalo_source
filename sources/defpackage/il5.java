package defpackage;

import com.urbanairship.UAirship;
import defpackage.zt5;

/* renamed from: il5  reason: default package */
/* compiled from: AppBackgroundEvent */
public class il5 extends ll5 {
    public il5(long j) {
        super(j);
    }

    @Override // defpackage.ll5
    public final zt5 d() {
        zt5.b s = zt5.s();
        s.f("connection_type", c());
        s.f("connection_subtype", a());
        s.f("push_id", UAirship.l().f.r);
        s.f("metadata", UAirship.l().f.s);
        return s.a();
    }

    @Override // defpackage.ll5
    public final String f() {
        return "app_background";
    }
}
