package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: fu5  reason: default package */
/* compiled from: ExactValueMatcher */
public class fu5 extends du5 {
    public final JsonValue f;

    public fu5(JsonValue jsonValue) {
        this.f = jsonValue;
    }

    @Override // defpackage.du5
    public boolean a(JsonValue jsonValue, boolean z) {
        return c(this.f, jsonValue, z);
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("equals", this.f);
        return JsonValue.x(s.a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c(com.urbanairship.json.JsonValue r6, com.urbanairship.json.JsonValue r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 187
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fu5.c(com.urbanairship.json.JsonValue, com.urbanairship.json.JsonValue, boolean):boolean");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fu5.class != obj.getClass()) {
            return false;
        }
        return this.f.equals(((fu5) obj).f);
    }

    public int hashCode() {
        return this.f.hashCode();
    }
}
