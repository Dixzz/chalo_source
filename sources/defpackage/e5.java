package defpackage;

import android.app.Notification;
import android.os.Bundle;

/* renamed from: e5  reason: default package */
/* compiled from: NotificationCompat */
public class e5 extends h5 {
    public CharSequence e;

    @Override // defpackage.h5
    public void a(Bundle bundle) {
        super.a(bundle);
    }

    @Override // defpackage.h5
    public void b(b5 b5Var) {
        Notification.BigTextStyle bigText = new Notification.BigTextStyle(((j5) b5Var).b).setBigContentTitle(this.b).bigText(this.e);
        if (this.d) {
            bigText.setSummaryText(this.c);
        }
    }

    @Override // defpackage.h5
    public String c() {
        return "androidx.core.app.NotificationCompat$BigTextStyle";
    }

    public e5 d(CharSequence charSequence) {
        this.e = f5.d(charSequence);
        return this;
    }
}
