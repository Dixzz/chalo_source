package defpackage;

import android.content.Intent;
import android.net.Uri;

/* renamed from: dj  reason: default package */
/* compiled from: NavDeepLinkRequest */
public class dj {

    /* renamed from: a  reason: collision with root package name */
    public final Uri f844a;
    public final String b;
    public final String c;

    public dj(Intent intent) {
        Uri data = intent.getData();
        String action = intent.getAction();
        String type = intent.getType();
        this.f844a = data;
        this.b = action;
        this.c = type;
    }

    public String toString() {
        StringBuilder k0 = hj1.k0("NavDeepLinkRequest", "{");
        if (this.f844a != null) {
            k0.append(" uri=");
            k0.append(this.f844a.toString());
        }
        if (this.b != null) {
            k0.append(" action=");
            k0.append(this.b);
        }
        if (this.c != null) {
            k0.append(" mimetype=");
            k0.append(this.c);
        }
        k0.append(" }");
        return k0.toString();
    }
}
