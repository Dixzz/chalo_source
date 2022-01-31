package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: ul5  reason: default package */
/* compiled from: RegionEvent */
public class ul5 extends ll5 implements cu5 {
    @Override // defpackage.cu5
    public JsonValue b() {
        return JsonValue.x(d());
    }

    @Override // defpackage.ll5
    public final zt5 d() {
        zt5.b s = zt5.s();
        s.f("region_id", null);
        s.f("source", null);
        s.f("action", "exit");
        return s.a();
    }

    @Override // defpackage.ll5
    public int e() {
        return 2;
    }

    @Override // defpackage.ll5
    public final String f() {
        return "region_event";
    }

    @Override // defpackage.ll5
    public boolean g() {
        yj5.c("The region ID and source must not be null.", new Object[0]);
        return false;
    }
}
