package defpackage;

import android.content.Context;
import android.os.Build;
import com.urbanairship.R;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.PushProvider;
import defpackage.fl5;
import defpackage.ik5;
import defpackage.kp5;
import defpackage.nv5;
import defpackage.rt5;
import defpackage.tp5;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* renamed from: vv5  reason: default package */
/* compiled from: PushManager */
public class vv5 extends oj5 {
    public static final ExecutorService y = pj5.f2814a;
    public final Context e;
    public final fl5 f;
    public final kq5 g;
    public final jp5<jk5> h;
    public jw5 i;
    public final Map<String, dw5> j;
    public final hk5 k;
    public final l5 l;
    public final qt5 m;
    public final hw5 n;
    public final ik5 o;
    public tv5 p;
    public final List<zv5> q = new CopyOnWriteArrayList();
    public final List<uv5> r = new CopyOnWriteArrayList();
    public final List<uv5> s = new CopyOnWriteArrayList();
    public final List<ov5> t = new CopyOnWriteArrayList();
    public final Object u = new Object();
    public final kp5 v;
    public PushProvider w;
    public volatile boolean x = true;

    /* renamed from: vv5$a */
    /* compiled from: PushManager */
    public class a implements kp5.d {
        public a() {
        }

        @Override // defpackage.kp5.d
        public tp5.b a(tp5.b bVar) {
            vv5 vv5 = vv5.this;
            if (vv5.c()) {
                if (vv5.o.d(4)) {
                    if (vv5.l() == null) {
                        vv5.r(false);
                    }
                    String l = vv5.l();
                    bVar.d = l;
                    PushProvider pushProvider = vv5.w;
                    if (!(l == null || pushProvider == null || pushProvider.getPlatform() != 2)) {
                        bVar.s = pushProvider.getDeliveryType();
                    }
                    bVar.f3391a = vv5.n();
                    bVar.b = vv5.o();
                }
            }
            return bVar;
        }
    }

    /* renamed from: vv5$b */
    /* compiled from: PushManager */
    public class b implements fl5.d {
        public b() {
        }

        @Override // defpackage.fl5.d
        public Map<String, String> a() {
            vv5 vv5 = vv5.this;
            if (vv5.c()) {
                if (vv5.o.d(4)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("X-UA-Channel-Opted-In", Boolean.toString(vv5.n()));
                    hashMap.put("X-UA-Channel-Background-Enabled", Boolean.toString(vv5.o()));
                    return hashMap;
                }
            }
            return Collections.emptyMap();
        }
    }

    /* renamed from: vv5$c */
    /* compiled from: PushManager */
    public class c implements ik5.a {
        public c() {
        }

        @Override // defpackage.ik5.a
        public void a() {
            vv5.this.s();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public vv5(Context context, hk5 hk5, kq5 kq5, ik5 ik5, jp5<jk5> jp5, kp5 kp5, fl5 fl5) {
        super(context, hk5);
        qt5 c2 = qt5.c(context);
        HashMap hashMap = new HashMap();
        this.j = hashMap;
        this.e = context;
        this.k = hk5;
        this.g = kq5;
        this.o = ik5;
        this.h = jp5;
        this.v = kp5;
        this.f = fl5;
        this.m = c2;
        this.i = new bw5(context, kq5.b);
        this.l = new l5(context);
        this.n = new hw5(context, kq5.b);
        hashMap.putAll(hd3.X0(context, R.xml.ua_notification_buttons));
        if (Build.VERSION.SDK_INT >= 23) {
            hashMap.putAll(hd3.X0(context, R.xml.ua_notification_button_overrides));
        }
    }

    @Override // defpackage.oj5
    public int a() {
        return 0;
    }

    @Override // defpackage.oj5
    public void b() {
        super.b();
        kp5 kp5 = this.v;
        kp5.k.add(new a());
        fl5 fl5 = this.f;
        fl5.o.add(new b());
        ik5 ik5 = this.o;
        ik5.b.add(new c());
        s();
    }

    @Override // defpackage.oj5
    public void e(boolean z) {
        s();
    }

    @Override // defpackage.oj5
    public int g(UAirship uAirship, rt5 rt5) {
        if (!this.o.d(4)) {
            return 0;
        }
        String str = rt5.b;
        str.hashCode();
        if (str.equals("ACTION_UPDATE_PUSH_REGISTRATION")) {
            return r(true);
        }
        if (!str.equals("ACTION_DISPLAY_NOTIFICATION")) {
            return 0;
        }
        JsonValue u2 = rt5.f3129a.u("EXTRA_PUSH");
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JsonValue> entry : u2.n().e()) {
            if (entry.getValue().f instanceof String) {
                hashMap.put(entry.getKey(), entry.getValue().o());
            } else {
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        PushMessage pushMessage = new PushMessage(hashMap);
        String i2 = rt5.f3129a.u("EXTRA_PROVIDER_CLASS").i();
        if (i2 == null) {
            return 0;
        }
        nv5.b bVar = new nv5.b(this.c);
        bVar.d = true;
        bVar.e = true;
        bVar.b = pushMessage;
        bVar.c = i2;
        hd3.E(i2, "Provider class missing");
        hd3.E(bVar.b, "Push Message missing");
        new nv5(bVar, null).run();
        return 0;
    }

    public boolean i() {
        if (!this.k.b("com.urbanairship.push.USER_NOTIFICATIONS_ENABLED", false) || !this.l.a()) {
            return false;
        }
        return true;
    }

    public final void j() {
        rt5.b a2 = rt5.a();
        a2.f3130a = "ACTION_UPDATE_PUSH_REGISTRATION";
        a2.b(vv5.class);
        this.m.a(a2.a());
    }

    public dw5 k(String str) {
        if (str == null) {
            return null;
        }
        return this.j.get(str);
    }

    public String l() {
        return this.k.g("com.urbanairship.push.REGISTRATION_TOKEN_KEY", null);
    }

    @Deprecated
    public boolean m() {
        if (!this.k.b("com.urbanairship.push.QUIET_TIME_ENABLED", false)) {
            return false;
        }
        try {
            aw5 a2 = aw5.a(this.k.d("com.urbanairship.push.QUIET_TIME_INTERVAL"));
            Calendar instance = Calendar.getInstance();
            Calendar instance2 = Calendar.getInstance();
            instance2.set(11, a2.f);
            instance2.set(12, a2.g);
            instance2.set(13, 0);
            instance2.set(14, 0);
            Calendar instance3 = Calendar.getInstance();
            instance3.set(11, a2.h);
            instance3.set(12, a2.i);
            instance3.set(13, 0);
            instance3.set(14, 0);
            Calendar calendar = (Calendar) instance.clone();
            calendar.set(13, 0);
            calendar.set(14, 0);
            if (!(calendar.compareTo(instance2) == 0 || calendar.compareTo(instance3) == 0)) {
                if (instance3.compareTo(instance2) == 0) {
                    return false;
                }
                if (instance3.after(instance2)) {
                    if (!calendar.after(instance2) || !calendar.before(instance3)) {
                        return false;
                    }
                } else if (calendar.before(instance3) || calendar.after(instance2)) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } catch (xt5 unused) {
            yj5.c("Failed to parse quiet time interval", new Object[0]);
            return false;
        }
    }

    public boolean n() {
        return o() && i();
    }

    public boolean o() {
        return this.o.d(new int[]{4}) && !hd3.G1(l());
    }

    @Deprecated
    public boolean p() {
        return this.o.d(4);
    }

    public void q(PushMessage pushMessage, boolean z) {
        if (c()) {
            boolean z2 = true;
            if (this.o.d(4)) {
                for (uv5 uv5 : this.s) {
                    uv5.a(pushMessage, z);
                }
                if (!pushMessage.m() && !pushMessage.g.containsKey("com.urbanairship.push.PING")) {
                    z2 = false;
                }
                if (!z2) {
                    for (uv5 uv52 : this.r) {
                        uv52.a(pushMessage, z);
                    }
                }
            }
        }
    }

    public int r(boolean z) {
        this.x = false;
        String l2 = l();
        PushProvider pushProvider = this.w;
        if (pushProvider == null) {
            yj5.f("PushManager - Push registration failed. Missing push provider.", new Object[0]);
            return 0;
        }
        synchronized (pushProvider) {
            if (!this.w.isAvailable(this.e)) {
                yj5.i("PushManager - Push registration failed. Push provider unavailable: %s", this.w);
                return 1;
            }
            try {
                String registrationToken = this.w.getRegistrationToken(this.e);
                if (registrationToken != null && !hd3.R0(registrationToken, l2)) {
                    yj5.f("PushManager - Push registration updated.", new Object[0]);
                    hk5 hk5 = this.k;
                    String deliveryType = this.w.getDeliveryType();
                    if (deliveryType == null) {
                        hk5.l("com.urbanairship.push.PUSH_DELIVERY_TYPE");
                    } else {
                        hk5.f("com.urbanairship.push.PUSH_DELIVERY_TYPE").b(deliveryType);
                    }
                    this.k.f("com.urbanairship.push.REGISTRATION_TOKEN_KEY").b(registrationToken);
                    for (zv5 zv5 : this.q) {
                        zv5.a(registrationToken);
                    }
                    if (z) {
                        this.v.s();
                    }
                }
                return 0;
            } catch (PushProvider.a e2) {
                if (e2.f) {
                    yj5.a("Push registration failed with error: %s. Will retry.", e2.getMessage());
                    yj5.f4059a.a(2, e2, null, null);
                    return 1;
                }
                yj5.e(e2, "PushManager - Push registration failed.", new Object[0]);
                return 0;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0062, code lost:
        if (r8 != null) goto L_0x00b9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void s() {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.vv5.s():void");
    }
}
