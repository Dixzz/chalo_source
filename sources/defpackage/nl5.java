package defpackage;

import android.app.NotificationChannelGroup;
import android.os.Build;
import com.crashlytics.android.beta.CheckForUpdatesResponseTransform;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;
import defpackage.zt5;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: nl5  reason: default package */
/* compiled from: PushArrivedEvent */
public class nl5 extends ll5 {
    public final PushMessage h;
    public final fw5 i;

    public nl5(PushMessage pushMessage) {
        this.h = pushMessage;
        this.i = null;
    }

    @Override // defpackage.ll5
    public final zt5 d() {
        List<NotificationChannelGroup> list;
        zt5.b s = zt5.s();
        s.f("push_id", !hd3.G1(this.h.i()) ? this.h.i() : "MISSING_SEND_ID");
        s.f("metadata", this.h.f());
        s.f("connection_type", c());
        s.f("connection_subtype", a());
        s.f(AnalyticsConstants.CARRIER, hd3.d1());
        fw5 fw5 = this.i;
        if (fw5 != null) {
            int i2 = fw5.o;
            boolean z = true;
            String str = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? "UNKNOWN" : "MAX" : "HIGH" : "DEFAULT" : "LOW" : "MIN" : "NONE";
            String str2 = fw5.k;
            int i3 = Build.VERSION.SDK_INT;
            zt5 zt5 = null;
            r7 = null;
            NotificationChannelGroup notificationChannelGroup = null;
            zt5 = null;
            if (i3 >= 28 && str2 != null) {
                l5 l5Var = new l5(UAirship.d());
                if (i3 >= 28) {
                    notificationChannelGroup = l5Var.b.getNotificationChannelGroup(str2);
                } else if (i3 >= 26) {
                    if (i3 >= 26) {
                        list = l5Var.b.getNotificationChannelGroups();
                    } else {
                        list = Collections.emptyList();
                    }
                    Iterator<NotificationChannelGroup> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        NotificationChannelGroup next = it.next();
                        if (next.getId().equals(str2)) {
                            notificationChannelGroup = next;
                            break;
                        }
                    }
                }
                if (notificationChannelGroup == null || !notificationChannelGroup.isBlocked()) {
                    z = false;
                }
                zt5.b s2 = zt5.s();
                zt5.b s3 = zt5.s();
                s3.i("blocked", String.valueOf(z));
                s2.e("group", s3.a());
                zt5 = s2.a();
            }
            zt5.b s4 = zt5.s();
            s4.f(CheckForUpdatesResponseTransform.IDENTIFIER, this.i.l);
            s4.f("importance", str);
            s4.i("group", zt5);
            s.e("notification_channel", s4.a());
        }
        return s.a();
    }

    @Override // defpackage.ll5
    public final String f() {
        return "push_arrived";
    }

    public nl5(PushMessage pushMessage, fw5 fw5) {
        this.h = pushMessage;
        this.i = fw5;
    }
}
