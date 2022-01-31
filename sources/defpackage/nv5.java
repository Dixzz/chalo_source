package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.urbanairship.UAirship;
import com.urbanairship.push.NotificationProxyActivity;
import com.urbanairship.push.NotificationProxyReceiver;
import com.urbanairship.push.PushMessage;
import defpackage.l5;
import defpackage.rt5;
import defpackage.zt5;
import java.util.Objects;
import java.util.UUID;

/* renamed from: nv5  reason: default package */
/* compiled from: IncomingPushRunnable */
public class nv5 implements Runnable {
    public final Context f;
    public final PushMessage g;
    public final String h;
    public final l5 i;
    public final boolean j;
    public final boolean k;
    public final qt5 l;
    public final wl5 m;

    /* renamed from: nv5$b */
    /* compiled from: IncomingPushRunnable */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2610a;
        public PushMessage b;
        public String c;
        public boolean d;
        public boolean e;

        public b(Context context) {
            this.f2610a = context.getApplicationContext();
        }
    }

    public nv5(b bVar, a aVar) {
        Context context = bVar.f2610a;
        this.f = context;
        this.g = bVar.b;
        this.h = bVar.c;
        this.j = bVar.d;
        this.k = bVar.e;
        this.i = new l5(context);
        this.l = qt5.c(context);
        this.m = bm5.f(context);
    }

    public final void a(UAirship uAirship) {
        jw5 jw5;
        kw5 kw5;
        String str;
        boolean z;
        tv5 tv5;
        if (!uAirship.i.n()) {
            yj5.f("User notifications opted out. Unable to display notification for message: %s", this.g);
            uAirship.i.q(this.g, false);
            uAirship.f.i(new nl5(this.g));
            return;
        }
        String str2 = this.g.g.get("com.urbanairship.foreground_display");
        if ((str2 != null ? Boolean.parseBoolean(str2) : true) || !this.m.d()) {
            if (this.g.g.containsKey("a4scontent")) {
                jw5 = null;
            } else {
                jw5 = uAirship.i.i;
            }
            if (jw5 == null) {
                yj5.c("NotificationProvider is null. Unable to display notification for message: %s", this.g);
                uAirship.i.q(this.g, false);
                uAirship.f.i(new nl5(this.g));
                return;
            }
            try {
                bw5 bw5 = (bw5) jw5;
                ew5 b2 = bw5.b(this.f, this.g);
                try {
                    kw5 = bw5.a(this.f, b2);
                } catch (Exception e) {
                    yj5.e(e, "Cancelling notification display to create and display notification.", new Object[0]);
                    kw5 = new kw5(null, 2);
                }
                yj5.a("Received result status %s for push message: %s", Integer.valueOf(kw5.b), this.g);
                int i2 = kw5.b;
                if (i2 == 0) {
                    Notification notification = kw5.f2129a;
                    hd3.E(notification, "Invalid notification result. Missing notification.");
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 26) {
                        str = i3 >= 26 ? notification.getChannelId() : null;
                    } else {
                        str = b2.b;
                    }
                    fw5 b3 = str != null ? uAirship.i.n.b(str) : null;
                    if (i3 < 26) {
                        if (b3 != null) {
                            int i4 = b3.o;
                            notification.priority = i4 != 1 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? -1 : 2 : 1 : 0 : -2;
                            if (i4 < 3) {
                                notification.vibrate = null;
                                notification.sound = null;
                                notification.ledARGB = 0;
                                notification.flags &= -2;
                                notification.defaults = 0;
                            } else {
                                Uri uri = b3.n;
                                if (uri != null) {
                                    notification.sound = uri;
                                    notification.defaults &= -2;
                                }
                                if (b3.h) {
                                    notification.flags |= 1;
                                    int i5 = b3.p;
                                    if (i5 != 0) {
                                        notification.ledARGB = i5;
                                        notification.defaults &= -5;
                                    } else {
                                        notification.defaults |= 4;
                                    }
                                }
                                if (b3.i) {
                                    long[] jArr = b3.r;
                                    if (jArr != null) {
                                        notification.vibrate = jArr;
                                        notification.defaults &= -3;
                                    } else {
                                        notification.defaults |= 2;
                                    }
                                }
                            }
                        } else {
                            if (!uAirship.i.k.b("com.urbanairship.push.VIBRATE_ENABLED", true) || uAirship.i.m()) {
                                notification.vibrate = null;
                                notification.defaults &= -3;
                            }
                            if (!uAirship.i.k.b("com.urbanairship.push.SOUND_ENABLED", true) || uAirship.i.m()) {
                                notification.sound = null;
                                notification.defaults &= -2;
                            }
                        }
                    } else if (b3 == null) {
                        yj5.c("Missing required notification channel. Notification will most likely not display.", new Object[0]);
                    }
                    String str3 = b2.c;
                    int i6 = b2.f1037a;
                    Intent putExtra = new Intent(this.f, NotificationProxyActivity.class).setAction("com.urbanairship.push.ACTION_NOTIFICATION_RESPONSE").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE", b2.d.g()).addFlags(268435456).putExtra("com.urbanairship.push.NOTIFICATION_ID", b2.f1037a).putExtra("com.urbanairship.push.NOTIFICATION_TAG", b2.c);
                    PendingIntent pendingIntent = notification.contentIntent;
                    if (pendingIntent != null) {
                        putExtra.putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_CONTENT_INTENT", pendingIntent);
                    }
                    Intent putExtra2 = new Intent(this.f, NotificationProxyReceiver.class).setAction("com.urbanairship.push.ACTION_NOTIFICATION_DISMISSED").addCategory(UUID.randomUUID().toString()).putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE", b2.d.g()).putExtra("com.urbanairship.push.NOTIFICATION_ID", b2.f1037a).putExtra("com.urbanairship.push.NOTIFICATION_TAG", b2.c);
                    PendingIntent pendingIntent2 = notification.deleteIntent;
                    if (pendingIntent2 != null) {
                        putExtra2.putExtra("com.urbanairship.push.EXTRA_NOTIFICATION_DELETE_INTENT", pendingIntent2);
                    }
                    notification.contentIntent = hd3.Y0(this.f, 0, putExtra, 0);
                    notification.deleteIntent = hd3.b1(this.f, 0, putExtra2, 0);
                    yj5.f("Posting notification: %s id: %s tag: %s", notification, Integer.valueOf(i6), str3);
                    try {
                        l5 l5Var = this.i;
                        Objects.requireNonNull(l5Var);
                        Bundle bundle = notification.extras;
                        if (bundle != null && bundle.getBoolean("android.support.useSideChannel")) {
                            l5Var.b(new l5.a(l5Var.f2170a.getPackageName(), i6, str3, notification));
                            l5Var.b.cancel(str3, i6);
                        } else {
                            l5Var.b.notify(str3, i6, notification);
                        }
                        z = true;
                    } catch (Exception e2) {
                        yj5.e(e2, "Failed to post notification.", new Object[0]);
                        z = false;
                    }
                    uAirship.f.i(new nl5(this.g, b3));
                    uAirship.i.q(this.g, z);
                    if (z) {
                        vv5 vv5 = uAirship.i;
                        PushMessage pushMessage = this.g;
                        int i7 = b2.f1037a;
                        String str4 = b2.c;
                        if (!vv5.c()) {
                            return;
                        }
                        if (vv5.o.d(4) && (tv5 = vv5.p) != null) {
                            tv5.a(new qv5(pushMessage, i7, str4));
                        }
                    }
                } else if (i2 == 1) {
                    yj5.a("Scheduling notification to be retried for a later time: %s", this.g);
                    b(this.g);
                } else if (i2 == 2) {
                    uAirship.f.i(new nl5(this.g));
                    uAirship.i.q(this.g, false);
                }
            } catch (Exception e3) {
                yj5.e(e3, "Failed to generate notification arguments for message. Skipping.", new Object[0]);
                uAirship.i.q(this.g, false);
                uAirship.f.i(new nl5(this.g));
            }
        } else {
            yj5.f("Notification unable to be displayed in the foreground: %s", this.g);
            uAirship.i.q(this.g, false);
            uAirship.f.i(new nl5(this.g));
        }
    }

    public final void b(PushMessage pushMessage) {
        rt5.b a2 = rt5.a();
        a2.f3130a = "ACTION_DISPLAY_NOTIFICATION";
        a2.f = 1;
        a2.b(vv5.class);
        zt5.b s = zt5.s();
        s.i("EXTRA_PUSH", pushMessage);
        s.f("EXTRA_PROVIDER_CLASS", this.h);
        a2.e = s.a();
        this.l.a(a2.a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0160  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        // Method dump skipped, instructions count: 563
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nv5.run():void");
    }
}
