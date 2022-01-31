package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: hu5  reason: default package */
/* compiled from: PresenceMatcher */
public class hu5 extends du5 {
    public final boolean f;

    public hu5(boolean z) {
        this.f = z;
    }

    @Override // defpackage.du5
    public boolean a(JsonValue jsonValue, boolean z) {
        if (this.f) {
            return !jsonValue.l();
        }
        return jsonValue.l();
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("is_present", Boolean.valueOf(this.f));
        return JsonValue.x(s.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && hu5.class == obj.getClass() && this.f == ((hu5) obj).f) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.f ? 1 : 0;
    }
}
