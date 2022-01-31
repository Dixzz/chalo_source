package defpackage;

import android.app.Notification;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: g5  reason: default package */
/* compiled from: NotificationCompat */
public class g5 extends h5 {
    public ArrayList<CharSequence> e = new ArrayList<>();

    @Override // defpackage.h5
    public void b(b5 b5Var) {
        Notification.InboxStyle bigContentTitle = new Notification.InboxStyle(((j5) b5Var).b).setBigContentTitle(this.b);
        if (this.d) {
            bigContentTitle.setSummaryText(this.c);
        }
        Iterator<CharSequence> it = this.e.iterator();
        while (it.hasNext()) {
            bigContentTitle.addLine(it.next());
        }
    }

    @Override // defpackage.h5
    public String c() {
        return "androidx.core.app.NotificationCompat$InboxStyle";
    }

    public g5 d(CharSequence charSequence) {
        if (charSequence != null) {
            this.e.add(f5.d(charSequence));
        }
        return this;
    }
}
