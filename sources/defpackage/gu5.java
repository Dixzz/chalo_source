package defpackage;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: gu5  reason: default package */
/* compiled from: NumberRangeMatcher */
public class gu5 extends du5 {
    public final Double f;
    public final Double g;

    public gu5(Double d, Double d2) {
        this.f = d;
        this.g = d2;
    }

    @Override // defpackage.du5
    public boolean a(JsonValue jsonValue, boolean z) {
        if (this.f != null && (!(jsonValue.f instanceof Number) || jsonValue.c(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) < this.f.doubleValue())) {
            return false;
        }
        if (this.g == null || ((jsonValue.f instanceof Number) && jsonValue.c(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) <= this.g.doubleValue())) {
            return true;
        }
        return false;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("at_least", this.f);
        s.i("at_most", this.g);
        return JsonValue.x(s.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || gu5.class != obj.getClass()) {
            return false;
        }
        gu5 gu5 = (gu5) obj;
        Double d = this.f;
        if (d == null ? gu5.f != null : !d.equals(gu5.f)) {
            return false;
        }
        Double d2 = this.g;
        Double d3 = gu5.g;
        if (d2 != null) {
            return d2.equals(d3);
        }
        if (d3 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Double d = this.f;
        int i = 0;
        int hashCode = (d != null ? d.hashCode() : 0) * 31;
        Double d2 = this.g;
        if (d2 != null) {
            i = d2.hashCode();
        }
        return hashCode + i;
    }
}
