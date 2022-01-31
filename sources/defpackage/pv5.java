package defpackage;

import android.os.Bundle;

/* renamed from: pv5  reason: default package */
/* compiled from: NotificationActionButtonInfo */
public class pv5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2860a;
    public final boolean b;
    public final Bundle c;
    public final String d;

    public pv5(String str, boolean z, Bundle bundle, String str2) {
        this.f2860a = str;
        this.b = z;
        this.c = bundle;
        this.d = str2;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("NotificationActionButtonInfo{buttonId='");
        hj1.U0(i0, this.f2860a, '\'', ", isForeground=");
        i0.append(this.b);
        i0.append(", remoteInput=");
        i0.append(this.c);
        i0.append(", description='");
        i0.append(this.d);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
