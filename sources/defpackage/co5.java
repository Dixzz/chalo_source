package defpackage;

import android.net.Uri;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: co5  reason: default package */
/* compiled from: Deferred */
public class co5 implements mn5 {
    public final Uri f;
    public final boolean g;
    public final String h;

    public co5(Uri uri, boolean z, String str) {
        this.f = uri;
        this.g = z;
        this.h = str;
    }

    public static co5 a(JsonValue jsonValue) throws xt5 {
        String i = jsonValue.n().u("url").i();
        if (i != null) {
            return new co5(Uri.parse(i), jsonValue.n().u("retry_on_timeout").a(true), jsonValue.n().u("type").i());
        }
        throw new xt5("Missing URL");
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.f("url", this.f.toString());
        zt5.b g2 = s.g("retry_on_timeout", this.g);
        g2.f("type", this.h);
        return JsonValue.x(g2.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || co5.class != obj.getClass()) {
            return false;
        }
        co5 co5 = (co5) obj;
        if (this.g != co5.g || !this.f.equals(co5.f)) {
            return false;
        }
        String str = this.h;
        String str2 = co5.h;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.f.hashCode() * 31) + (this.g ? 1 : 0)) * 31;
        String str = this.h;
        return hashCode + (str != null ? str.hashCode() : 0);
    }
}
