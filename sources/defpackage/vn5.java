package defpackage;

import com.urbanairship.json.JsonValue;
import java.util.Objects;

/* renamed from: vn5  reason: default package */
/* compiled from: Actions */
public class vn5 implements mn5 {
    public final zt5 f;

    public vn5(zt5 zt5) {
        this.f = zt5;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5 zt5 = this.f;
        Objects.requireNonNull(zt5);
        return JsonValue.x(zt5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || vn5.class != obj.getClass()) {
            return false;
        }
        return this.f.equals(((vn5) obj).f);
    }

    public int hashCode() {
        return this.f.hashCode();
    }
}
