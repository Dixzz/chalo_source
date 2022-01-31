package defpackage;

import android.graphics.Color;
import com.google.firebase.messaging.Constants;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/* renamed from: sr5  reason: default package */
/* compiled from: LegacyInAppMessage */
public class sr5 {

    /* renamed from: a  reason: collision with root package name */
    public final long f3248a;
    public final String b;
    public final Long c;
    public final Integer d;
    public final Integer e;
    public final String f;
    public final String g;
    public final String h;
    public final Map<String, JsonValue> i;
    public final zt5 j;
    public final Map<String, Map<String, JsonValue>> k;

    /* renamed from: sr5$b */
    /* compiled from: LegacyInAppMessage */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, JsonValue> f3249a = new HashMap();
        public String b;
        public zt5 c;
        public final Map<String, Map<String, JsonValue>> d = new HashMap();
        public String e;
        public String f;
        public Long g;
        public Long h;
        public Integer i;
        public Integer j;
        public String k = "bottom";

        public b(a aVar) {
        }
    }

    public sr5(b bVar, a aVar) {
        Long l = bVar.g;
        this.f3248a = l == null ? System.currentTimeMillis() + 2592000000L : l.longValue();
        zt5 zt5 = bVar.c;
        this.j = zt5 == null ? zt5.g : zt5;
        this.b = bVar.f;
        this.c = bVar.h;
        this.f = bVar.e;
        this.k = bVar.d;
        this.i = bVar.f3249a;
        this.h = bVar.k;
        this.d = bVar.i;
        this.e = bVar.j;
        String str = bVar.b;
        this.g = str == null ? UUID.randomUUID().toString() : str;
    }

    public static sr5 a(PushMessage pushMessage) throws xt5 {
        boolean z;
        if (!pushMessage.g.containsKey("com.urbanairship.in_app")) {
            return null;
        }
        JsonValue p = JsonValue.p(pushMessage.d("com.urbanairship.in_app", ""));
        zt5 n = p.n().u(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION).n();
        zt5 n2 = p.n().u("actions").n();
        if ("banner".equals(n.u("type").i())) {
            b bVar = new b(null);
            bVar.c = p.n().u("extra").n();
            bVar.f = n.u("alert").i();
            if (n.f.containsKey("primary_color")) {
                try {
                    bVar.i = Integer.valueOf(Color.parseColor(n.u("primary_color").o()));
                } catch (IllegalArgumentException e2) {
                    throw new xt5(hj1.F(n, "primary_color", hj1.i0("Invalid primary color: ")), e2);
                }
            }
            if (n.f.containsKey("secondary_color")) {
                try {
                    bVar.j = Integer.valueOf(Color.parseColor(n.u("secondary_color").o()));
                } catch (IllegalArgumentException e3) {
                    throw new xt5(hj1.F(n, "secondary_color", hj1.i0("Invalid secondary color: ")), e3);
                }
            }
            if (n.f.containsKey("duration")) {
                bVar.h = Long.valueOf(TimeUnit.SECONDS.toMillis(n.u("duration").g(0)));
            }
            long currentTimeMillis = System.currentTimeMillis() + 2592000000L;
            if (p.n().f.containsKey("expiry")) {
                bVar.g = Long.valueOf(ly5.c(p.n().u("expiry").o(), currentTimeMillis));
            } else {
                bVar.g = Long.valueOf(currentTimeMillis);
            }
            if ("top".equalsIgnoreCase(n.u("position").i())) {
                bVar.k = "top";
            } else {
                bVar.k = "bottom";
            }
            Map<String, JsonValue> n3 = n2.u("on_click").n().n();
            if (!hd3.G1(pushMessage.h())) {
                ((HashMap) n3).put("^mc", JsonValue.x(pushMessage.h()));
            }
            bVar.f3249a.clear();
            bVar.f3249a.putAll(n3);
            bVar.e = n2.u("button_group").i();
            zt5 n4 = n2.u("button_actions").n();
            for (Map.Entry<String, JsonValue> entry : n4.e()) {
                String key = entry.getKey();
                bVar.d.put(key, new HashMap(n4.u(key).n().n()));
            }
            bVar.b = pushMessage.i();
            try {
                Long l = bVar.h;
                if (l != null) {
                    if (l.longValue() <= 0) {
                        z = false;
                        hd3.D(z, "Duration must be greater than 0");
                        return new sr5(bVar, null);
                    }
                }
                z = true;
                hd3.D(z, "Duration must be greater than 0");
                return new sr5(bVar, null);
            } catch (IllegalArgumentException e4) {
                throw new xt5(hj1.R("Invalid legacy in-app message", p), e4);
            }
        } else {
            throw new xt5("Only banner types are supported.");
        }
    }
}
