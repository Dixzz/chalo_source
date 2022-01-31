package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: wr5  reason: default package */
/* compiled from: ResolutionEvent */
public class wr5 extends hr5 {
    public final zt5 k;

    public wr5(String str, String str2, JsonValue jsonValue, zt5 zt5) {
        super(str, str2, jsonValue);
        this.k = zt5;
    }

    public static wr5 j(String str, String str2, xr5 xr5, long j, JsonValue jsonValue) {
        xq5 xq5;
        if (j <= 0) {
            j = 0;
        }
        zt5.b s = zt5.s();
        s.f("type", xr5.f);
        s.f("display_time", ll5.h(j));
        if ("button_click".equals(xr5.f) && (xq5 = xr5.g) != null) {
            String str3 = xq5.f.f;
            if (str3 != null && str3.length() > 30) {
                str3 = str3.substring(0, 30);
            }
            s.f("button_id", xr5.g.g);
            s.f("button_description", str3);
        }
        return new wr5(str, str2, jsonValue, s.a());
    }

    @Override // defpackage.ll5
    public String f() {
        return "in_app_resolution";
    }

    @Override // defpackage.hr5
    public zt5.b i(zt5.b bVar) {
        bVar.e("resolution", this.k);
        return bVar;
    }
}
