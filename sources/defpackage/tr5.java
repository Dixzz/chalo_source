package defpackage;

import android.content.Context;
import android.content.res.Resources;
import com.urbanairship.UAirship;
import com.urbanairship.automation.Trigger;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import defpackage.hs5;
import defpackage.ln5;
import defpackage.xq5;
import defpackage.yr5;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* renamed from: tr5  reason: default package */
/* compiled from: LegacyInAppMessageManager */
public class tr5 extends oj5 {
    public final dn5 e;
    public final hk5 f;
    public final fl5 g;
    public final vv5 h;
    public boolean i = true;

    /* renamed from: tr5$a */
    /* compiled from: LegacyInAppMessageManager */
    public class a implements uv5 {

        /* renamed from: tr5$a$a  reason: collision with other inner class name */
        /* compiled from: LegacyInAppMessageManager */
        public class C0055a implements kk5<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f3401a;
            public final /* synthetic */ String b;

            public C0055a(String str, String str2) {
                this.f3401a = str;
                this.b = str2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // defpackage.kk5
            public void a(Boolean bool) {
                Boolean bool2 = bool;
                if (bool2 != null && bool2.booleanValue()) {
                    yj5.a("Pending in-app message replaced.", new Object[0]);
                    String str = this.f3401a;
                    String str2 = this.b;
                    zt5.b s = zt5.s();
                    s.f("type", "replaced");
                    s.f("replacement_id", str2);
                    tr5.this.g.i(new wr5(str, "legacy-push", null, s.a()));
                }
            }
        }

        public a() {
        }

        @Override // defpackage.uv5
        public void a(PushMessage pushMessage, boolean z) {
            sr5 sr5;
            ln5<InAppMessage> ln5;
            Trigger trigger;
            try {
                sr5 = sr5.a(pushMessage);
            } catch (IllegalArgumentException | xt5 e) {
                yj5.e(e, "LegacyInAppMessageManager - Unable to create in-app message from push payload", new Object[0]);
                sr5 = null;
            }
            if (sr5 != null) {
                tr5 tr5 = tr5.this;
                Context d = UAirship.d();
                Objects.requireNonNull(tr5);
                try {
                    if (tr5.i) {
                        trigger = new Trigger(9, 1.0d, null);
                    } else {
                        trigger = new Trigger(1, 1.0d, null);
                    }
                    ln5.b<InAppMessage> c = ln5.c(tr5.i(d, sr5));
                    c.d.add(trigger);
                    c.c = sr5.f3248a;
                    c.m = sr5.g;
                    ln5 = c.a();
                } catch (Exception e2) {
                    yj5.e(e2, "Error during factory method to convert legacy in-app message.", new Object[0]);
                    ln5 = null;
                }
                if (ln5 != null) {
                    String str = ln5.f2243a;
                    yj5.a("Received a Push with an in-app message.", new Object[0]);
                    String g = tr5.this.f.g("com.urbanairship.push.iam.PENDING_MESSAGE_ID", null);
                    if (g != null) {
                        tr5.this.e.i(g).b(new C0055a(g, str));
                    }
                    tr5.this.e.o(ln5);
                    hk5 hk5 = tr5.this.f;
                    if (str == null) {
                        hk5.l("com.urbanairship.push.iam.PENDING_MESSAGE_ID");
                    } else {
                        hk5.f("com.urbanairship.push.iam.PENDING_MESSAGE_ID").b(str);
                    }
                }
            }
        }
    }

    /* renamed from: tr5$b */
    /* compiled from: LegacyInAppMessageManager */
    public class b implements ov5 {

        /* renamed from: tr5$b$a */
        /* compiled from: LegacyInAppMessageManager */
        public class a implements kk5<Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PushMessage f3403a;

            public a(PushMessage pushMessage) {
                this.f3403a = pushMessage;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // defpackage.kk5
            public void a(Boolean bool) {
                Boolean bool2 = bool;
                if (bool2 != null && bool2.booleanValue()) {
                    yj5.a("Clearing pending in-app message due to directly interacting with the message's push notification.", new Object[0]);
                    String i = this.f3403a.i();
                    zt5.b s = zt5.s();
                    s.f("type", "direct_open");
                    tr5.this.g.i(new wr5(i, "legacy-push", null, s.a()));
                }
            }
        }

        public b() {
        }

        @Override // defpackage.ov5
        public void a(qv5 qv5, pv5 pv5) {
            PushMessage pushMessage = qv5.f2995a;
            if (pushMessage.i() != null && pushMessage.g.containsKey("com.urbanairship.in_app")) {
                tr5.this.e.i(pushMessage.i()).b(new a(pushMessage));
            }
        }
    }

    public tr5(Context context, hk5 hk5, dn5 dn5, fl5 fl5, vv5 vv5) {
        super(context, hk5);
        this.f = hk5;
        this.e = dn5;
        this.g = fl5;
        this.h = vv5;
    }

    @Override // defpackage.oj5
    public int a() {
        return 3;
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        vv5 vv5 = this.h;
        vv5.s.add(new a());
        vv5 vv52 = this.h;
        vv52.t.add(new b());
    }

    public final InAppMessage i(Context context, sr5 sr5) {
        int i2;
        int i3;
        dw5 k;
        Integer num = sr5.d;
        if (num == null) {
            i2 = -1;
        } else {
            i2 = num.intValue();
        }
        Integer num2 = sr5.e;
        if (num2 == null) {
            i3 = -16777216;
        } else {
            i3 = num2.intValue();
        }
        hs5.b bVar = new hs5.b(null);
        bVar.i = i2;
        bVar.j = i3;
        bVar.k = 2.0f;
        bVar.e = "separate";
        bVar.f = sr5.h;
        Map<? extends String, ? extends JsonValue> unmodifiableMap = Collections.unmodifiableMap(sr5.i);
        bVar.l.clear();
        if (unmodifiableMap != null) {
            bVar.l.putAll(unmodifiableMap);
        }
        yr5.b c = yr5.c();
        c.f4082a = sr5.b;
        c.b(i3);
        bVar.b = c.a();
        Long l = sr5.c;
        if (l != null) {
            bVar.h = TimeUnit.MILLISECONDS.toMillis(l.longValue());
        }
        String str = sr5.f;
        if (!(str == null || (k = this.h.k(str)) == null)) {
            int i4 = 0;
            while (i4 < ((ArrayList) k.b()).size() && i4 < 2) {
                cw5 cw5 = (cw5) ((ArrayList) k.b()).get(i4);
                yr5.b c2 = yr5.c();
                int i5 = cw5.f;
                try {
                    c2.d = context.getResources().getResourceName(i5);
                } catch (Resources.NotFoundException unused) {
                    yj5.a(hj1.J("Drawable ", i5, " no longer exists or has a new identifier."), new Object[0]);
                }
                c2.b(i2);
                c2.e = "center";
                String str2 = cw5.d;
                if (str2 == null) {
                    int i6 = cw5.c;
                    str2 = i6 != 0 ? context.getString(i6) : null;
                }
                c2.f4082a = str2;
                xq5.b bVar2 = new xq5.b(null);
                Map<String, JsonValue> map = sr5.k.get(cw5.b);
                Map<? extends String, ? extends JsonValue> unmodifiableMap2 = map != null ? Collections.unmodifiableMap(map) : null;
                bVar2.g.clear();
                if (unmodifiableMap2 != null) {
                    bVar2.g.putAll(unmodifiableMap2);
                }
                bVar2.b = cw5.b;
                bVar2.e = Integer.valueOf(i3);
                bVar2.d = 2.0f;
                bVar2.f3956a = c2.a();
                bVar.d.add(bVar2.a());
                i4++;
            }
        }
        InAppMessage.b d = InAppMessage.d();
        hs5 a2 = bVar.a();
        d.f729a = "banner";
        d.d = a2;
        d.b = sr5.j;
        d.f = "legacy-push";
        return d.a();
    }
}
