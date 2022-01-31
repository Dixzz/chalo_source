package defpackage;

import com.urbanairship.json.JsonValue;

/* renamed from: ks5  reason: default package */
/* compiled from: CustomDisplayContent */
public class ks5 implements zq5 {
    public final JsonValue f;

    public ks5(JsonValue jsonValue) {
        this.f = jsonValue;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return JsonValue.x(zt5.s().e("custom", this.f).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ks5.class != obj.getClass()) {
            return false;
        }
        return this.f.equals(((ks5) obj).f);
    }

    public int hashCode() {
        return this.f.hashCode();
    }
}
