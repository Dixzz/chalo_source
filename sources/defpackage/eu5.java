package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.Iterator;

/* renamed from: eu5  reason: default package */
/* compiled from: ArrayContainsMatcher */
public class eu5 extends du5 {
    public final Integer f;
    public final bu5 g;

    public eu5(bu5 bu5, Integer num) {
        this.g = bu5;
        this.f = num;
    }

    @Override // defpackage.du5
    public boolean a(JsonValue jsonValue, boolean z) {
        if (!(jsonValue.f instanceof yt5)) {
            return false;
        }
        yt5 m = jsonValue.m();
        Integer num = this.f;
        if (num == null) {
            Iterator<JsonValue> it = m.iterator();
            while (it.hasNext()) {
                if (this.g.apply(it.next())) {
                    return true;
                }
            }
            return false;
        } else if (num.intValue() < 0 || this.f.intValue() >= m.size()) {
            return false;
        } else {
            return this.g.apply(m.d(this.f.intValue()));
        }
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("array_contains", this.g);
        s.i(FirebaseAnalytics.Param.INDEX, this.f);
        return JsonValue.x(s.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || eu5.class != obj.getClass()) {
            return false;
        }
        eu5 eu5 = (eu5) obj;
        Integer num = this.f;
        if (num == null ? eu5.f == null : num.equals(eu5.f)) {
            return this.g.equals(eu5.g);
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f;
        return this.g.hashCode() + ((num != null ? num.hashCode() : 0) * 31);
    }
}
