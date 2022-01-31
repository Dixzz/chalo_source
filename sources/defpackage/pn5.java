package defpackage;

import com.urbanairship.automation.Trigger;
import com.urbanairship.json.JsonValue;

/* renamed from: pn5  reason: default package */
/* compiled from: TriggerContext */
public class pn5 implements cu5 {
    public Trigger f;
    public JsonValue g;

    public pn5(Trigger trigger, JsonValue jsonValue) {
        this.f = trigger;
        this.g = jsonValue;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        return JsonValue.x(zt5.s().e("trigger", this.f).e("event", this.g).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pn5.class != obj.getClass()) {
            return false;
        }
        pn5 pn5 = (pn5) obj;
        if (!this.f.equals(pn5.f)) {
            return false;
        }
        return this.g.equals(pn5.g);
    }

    public int hashCode() {
        return this.g.hashCode() + (this.f.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("TriggerContext{trigger=");
        i0.append(this.f);
        i0.append(", event=");
        i0.append(this.g);
        i0.append('}');
        return i0.toString();
    }
}
