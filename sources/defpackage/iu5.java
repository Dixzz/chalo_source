package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: iu5  reason: default package */
/* compiled from: VersionMatcher */
public class iu5 extends du5 {
    public final vy5 f;

    public iu5(vy5 vy5) {
        this.f = vy5;
    }

    @Override // defpackage.du5
    public boolean a(JsonValue jsonValue, boolean z) {
        return (jsonValue.f instanceof String) && this.f.apply(jsonValue.i());
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("version_matches", this.f);
        return JsonValue.x(s.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || iu5.class != obj.getClass()) {
            return false;
        }
        return this.f.equals(((iu5) obj).f);
    }

    public int hashCode() {
        return this.f.hashCode();
    }
}
