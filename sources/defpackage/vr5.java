package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: vr5  reason: default package */
/* compiled from: MediaInfo */
public class vr5 implements cu5 {
    public final String f;
    public final String g;
    public final String h;

    /* renamed from: vr5$b */
    /* compiled from: MediaInfo */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f3678a;
        public String b;
        public String c;

        public b(a aVar) {
        }
    }

    public vr5(b bVar, a aVar) {
        this.f = bVar.f3678a;
        this.g = bVar.c;
        this.h = bVar.b;
    }

    public static vr5 a(JsonValue jsonValue) throws xt5 {
        try {
            b bVar = new b(null);
            bVar.f3678a = jsonValue.n().u("url").o();
            bVar.b = jsonValue.n().u("type").o();
            bVar.c = jsonValue.n().u("description").o();
            hd3.D(!hd3.G1(bVar.f3678a), "Missing URL");
            hd3.D(!hd3.G1(bVar.b), "Missing type");
            hd3.D(!hd3.G1(bVar.c), "Missing description");
            return new vr5(bVar, null);
        } catch (IllegalArgumentException e) {
            throw new xt5(hj1.R("Invalid media object json: ", jsonValue), e);
        }
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.f("url", this.f);
        s.f("description", this.g);
        s.f("type", this.h);
        return JsonValue.x(s.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || vr5.class != obj.getClass()) {
            return false;
        }
        vr5 vr5 = (vr5) obj;
        String str = this.f;
        if (str == null ? vr5.f != null : !str.equals(vr5.f)) {
            return false;
        }
        String str2 = this.g;
        if (str2 == null ? vr5.g != null : !str2.equals(vr5.g)) {
            return false;
        }
        String str3 = this.h;
        String str4 = vr5.h;
        if (str3 != null) {
            return str3.equals(str4);
        }
        if (str4 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.g;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.h;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return b().toString();
    }
}
