package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.urbanairship.UAirship;
import com.urbanairship.actions.ActionValue;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* renamed from: rv5  reason: default package */
/* compiled from: NotificationIntentProcessor */
public class rv5 {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f3138a;
    public final pv5 b;
    public final qv5 c;
    public final Intent d;
    public final Context e;
    public final UAirship f;

    /* renamed from: rv5$a */
    /* compiled from: NotificationIntentProcessor */
    public class a implements Runnable {
        public final /* synthetic */ ck5 f;

        public a(rv5 rv5, ck5 ck5) {
            this.f = ck5;
        }

        public void run() {
            this.f.d(Boolean.TRUE);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rv5(android.content.Context r5, android.content.Intent r6) {
        /*
        // Method dump skipped, instructions count: 102
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rv5.<init>(android.content.Context, android.content.Intent):void");
    }

    public final void a() {
        PendingIntent pendingIntent;
        if (this.d.getExtras() != null && (pendingIntent = (PendingIntent) this.d.getExtras().get("com.urbanairship.push.EXTRA_NOTIFICATION_CONTENT_INTENT")) != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException unused) {
                yj5.a("Failed to send notification's contentIntent, already canceled.", new Object[0]);
            }
        } else if (this.f.e.s) {
            Intent launchIntentForPackage = this.e.getPackageManager().getLaunchIntentForPackage(UAirship.g());
            if (launchIntentForPackage != null) {
                launchIntentForPackage.setFlags(805306368);
                launchIntentForPackage.putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE", this.c.f2995a.g());
                launchIntentForPackage.setPackage(null);
                yj5.f("Starting application's launch intent.", new Object[0]);
                this.e.startActivity(launchIntentForPackage);
                return;
            }
            yj5.f("Unable to launch application. Launch intent is unavailable.", new Object[0]);
        }
    }

    public ck5<Boolean> b() {
        PendingIntent pendingIntent;
        int i;
        HashMap hashMap;
        HashMap hashMap2;
        Boolean bool = Boolean.FALSE;
        ck5<Boolean> ck5 = new ck5<>();
        int i2 = 0;
        if (this.d.getAction() == null || this.c == null) {
            yj5.c("NotificationIntentProcessor - invalid intent %s", this.d);
            ck5.d(bool);
            return ck5;
        }
        yj5.h("Processing intent: %s", this.d.getAction());
        String action = this.d.getAction();
        action.hashCode();
        if (action.equals("com.urbanairship.push.ACTION_NOTIFICATION_DISMISSED")) {
            yj5.f("Notification dismissed: %s", this.c);
            if (!(this.d.getExtras() == null || (pendingIntent = (PendingIntent) this.d.getExtras().get("com.urbanairship.push.EXTRA_NOTIFICATION_DELETE_INTENT")) == null)) {
                try {
                    pendingIntent.send();
                } catch (PendingIntent.CanceledException unused) {
                    yj5.a("Failed to send notification's deleteIntent, already canceled.", new Object[0]);
                }
            }
            tv5 tv5 = this.f.i.p;
            if (tv5 != null) {
                tv5.d(this.c);
            }
            ck5.d(Boolean.TRUE);
        } else if (!action.equals("com.urbanairship.push.ACTION_NOTIFICATION_RESPONSE")) {
            yj5.c("NotificationIntentProcessor - Invalid intent action: %s", this.d.getAction());
            ck5.d(bool);
        } else {
            a aVar = new a(this, ck5);
            yj5.f("Notification response: %s, %s", this.c, this.b);
            pv5 pv5 = this.b;
            if (pv5 == null || pv5.b) {
                fl5 fl5 = this.f.f;
                String i3 = this.c.f2995a.i();
                Objects.requireNonNull(fl5);
                yj5.a("Setting conversion send ID: %s", i3);
                fl5.r = i3;
                fl5 fl52 = this.f.f;
                String f2 = this.c.f2995a.f();
                Objects.requireNonNull(fl52);
                yj5.a("Setting conversion metadata: %s", f2);
                fl52.s = f2;
            }
            tv5 tv52 = this.f.i.p;
            pv5 pv52 = this.b;
            if (pv52 != null) {
                this.f.f.i(new ml5(this.c, pv52));
                l5 l5Var = new l5(this.e);
                qv5 qv5 = this.c;
                l5Var.b.cancel(qv5.c, qv5.b);
                pv5 pv53 = this.b;
                if (pv53.b) {
                    if (tv52 == null || !tv52.e(this.c, pv53)) {
                        a();
                    }
                } else if (tv52 != null) {
                    tv52.b(this.c, pv53);
                }
            } else if (tv52 == null || !tv52.c(this.c)) {
                a();
            }
            for (ov5 ov5 : this.f.i.t) {
                ov5.a(this.c, this.b);
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.urbanairship.PUSH_MESSAGE", this.c.f2995a);
            if (this.b != null) {
                String stringExtra = this.d.getStringExtra("com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD");
                if (!hd3.G1(stringExtra)) {
                    hashMap2 = new HashMap();
                    try {
                        zt5 h = JsonValue.p(stringExtra).h();
                        if (h != null) {
                            Iterator<Map.Entry<String, JsonValue>> it = h.iterator();
                            while (it.hasNext()) {
                                Map.Entry<String, JsonValue> next = it.next();
                                hashMap2.put(next.getKey(), new ActionValue(next.getValue()));
                            }
                        }
                    } catch (xt5 e2) {
                        yj5.e(e2, "Failed to parse actions for push.", new Object[0]);
                    }
                    Bundle bundle2 = this.b.c;
                    if (bundle2 != null) {
                        bundle.putBundle("com.urbanairship.REMOTE_INPUT", bundle2);
                    }
                    i2 = this.b.b ? 4 : 5;
                } else {
                    hashMap2 = null;
                }
                hashMap = hashMap2;
                i = i2;
            } else {
                hashMap = this.c.f2995a.a();
                i = 2;
            }
            if (hashMap == null || hashMap.isEmpty()) {
                aVar.run();
            } else {
                this.f3138a.execute(new sv5(this, hashMap, bundle, i, aVar));
            }
        }
        return ck5;
    }
}
