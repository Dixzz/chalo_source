package defpackage;

import android.content.Context;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;

/* renamed from: ow5  reason: default package */
/* compiled from: WearableNotificationExtender */
public class ow5 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2738a;
    public final ew5 b;

    public ow5(Context context, ew5 ew5) {
        this.f2738a = context.getApplicationContext();
        this.b = ew5;
    }

    public f5 a(f5 f5Var) {
        dw5 k;
        String str = this.b.d.g.get("com.urbanairship.wearable");
        if (str == null) {
            return f5Var;
        }
        try {
            zt5 n = JsonValue.p(str).n();
            i5 i5Var = new i5();
            String i = n.u("interactive_type").i();
            String jsonValue = n.u("interactive_actions").toString();
            if (hd3.G1(jsonValue)) {
                jsonValue = this.b.d.g.get("com.urbanairship.interactive_actions");
            }
            if (!hd3.G1(i) && (k = UAirship.l().i.k(i)) != null) {
                i5Var.f1477a.addAll(k.a(this.f2738a, this.b, jsonValue));
            }
            i5Var.a(f5Var);
            return f5Var;
        } catch (xt5 e) {
            yj5.e(e, "Failed to parse wearable payload.", new Object[0]);
            return f5Var;
        }
    }
}
