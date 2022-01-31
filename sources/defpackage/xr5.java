package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: xr5  reason: default package */
/* compiled from: ResolutionInfo */
public final class xr5 implements cu5 {
    public final String f;
    public final xq5 g;

    public xr5(String str) {
        this.f = str;
        this.g = null;
    }

    public static xr5 a(xq5 xq5) {
        return new xr5("button_click", xq5);
    }

    public static xr5 c() {
        return new xr5("user_dismissed");
    }

    public static xr5 d(JsonValue jsonValue) throws xt5 {
        zt5 n = jsonValue.n();
        String i = n.u("type").i();
        if (i != null) {
            xq5 xq5 = null;
            if (n.u("button_info").f instanceof zt5) {
                xq5 = xq5.a(n.u("button_info"));
            }
            return new xr5(i, xq5);
        }
        throw new xt5("ResolutionInfo must contain a type");
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.f("type", this.f);
        s.i("button_info", this.g);
        return JsonValue.x(s.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xr5.class != obj.getClass()) {
            return false;
        }
        xr5 xr5 = (xr5) obj;
        if (!this.f.equals(xr5.f)) {
            return false;
        }
        xq5 xq5 = this.g;
        xq5 xq52 = xr5.g;
        if (xq5 != null) {
            return xq5.equals(xq52);
        }
        if (xq52 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f.hashCode() * 31;
        xq5 xq5 = this.g;
        return hashCode + (xq5 != null ? xq5.hashCode() : 0);
    }

    public xr5(String str, xq5 xq5) {
        this.f = str;
        this.g = xq5;
    }
}
