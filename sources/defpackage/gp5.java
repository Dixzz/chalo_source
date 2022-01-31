package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.Map;
import java.util.Set;

/* renamed from: gp5  reason: default package */
/* compiled from: TagGroupResponse */
public class gp5 implements cu5 {
    public final Map<String, Set<String>> f;
    public final String g;
    public final int h;

    public gp5(int i, Map<String, Set<String>> map, String str) {
        this.f = map;
        this.g = str;
        this.h = i;
    }

    public static gp5 a(tq5 tq5) throws xt5 {
        int i = tq5.c;
        if (i != 200) {
            return new gp5(i, null, null);
        }
        zt5 n = JsonValue.p(tq5.f3395a).n();
        return new gp5(tq5.c, hd3.t2(n.u("tag_groups")), n.u("last_modified").i());
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("tag_groups", this.f);
        s.f("last_modified", this.g);
        return JsonValue.x(s.c("status", this.h).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || gp5.class != obj.getClass()) {
            return false;
        }
        gp5 gp5 = (gp5) obj;
        if (this.h != gp5.h) {
            return false;
        }
        Map<String, Set<String>> map = this.f;
        if (map == null ? gp5.f != null : !map.equals(gp5.f)) {
            return false;
        }
        String str = this.g;
        String str2 = gp5.g;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Map<String, Set<String>> map = this.f;
        int i = 0;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        String str = this.g;
        if (str != null) {
            i = str.hashCode();
        }
        return ((hashCode + i) * 31) + this.h;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("TagGroupResponse{tags=");
        i0.append(this.f);
        i0.append(", lastModifiedTime='");
        hj1.U0(i0, this.g, '\'', ", status=");
        return hj1.W(i0, this.h, '}');
    }
}
