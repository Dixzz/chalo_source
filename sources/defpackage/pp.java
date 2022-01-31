package defpackage;

import android.app.Notification;

/* renamed from: pp  reason: default package */
/* compiled from: ForegroundInfo */
public final class pp {

    /* renamed from: a  reason: collision with root package name */
    public final int f2835a;
    public final int b;
    public final Notification c;

    public pp(int i, Notification notification, int i2) {
        this.f2835a = i;
        this.c = notification;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pp.class != obj.getClass()) {
            return false;
        }
        pp ppVar = (pp) obj;
        if (this.f2835a == ppVar.f2835a && this.b == ppVar.b) {
            return this.c.equals(ppVar.c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode() + (((this.f2835a * 31) + this.b) * 31);
    }

    public String toString() {
        return "ForegroundInfo{" + "mNotificationId=" + this.f2835a + ", mForegroundServiceType=" + this.b + ", mNotification=" + this.c + '}';
    }
}
