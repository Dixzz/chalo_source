package defpackage;

import com.urbanairship.push.PushMessage;

/* renamed from: qv5  reason: default package */
/* compiled from: NotificationInfo */
public class qv5 {

    /* renamed from: a  reason: collision with root package name */
    public final PushMessage f2995a;
    public final int b;
    public final String c;

    public qv5(PushMessage pushMessage, int i, String str) {
        this.f2995a = pushMessage;
        this.c = str;
        this.b = i;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("NotificationInfo{alert=");
        i0.append(this.f2995a.c());
        i0.append(", notificationId=");
        i0.append(this.b);
        i0.append(", notificationTag='");
        i0.append(this.c);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
