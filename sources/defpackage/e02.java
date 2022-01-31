package defpackage;

import android.app.Activity;
import android.content.Context;
import defpackage.x22;
import defpackage.z22;

/* renamed from: e02  reason: default package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
public abstract class e02 extends z22<x22.d.c> {

    /* renamed from: a  reason: collision with root package name */
    public static final x22.g<td2> f910a;
    public static final x22.a<td2, x22.d.c> b;
    public static final x22<x22.d.c> c;

    static {
        x22.g<td2> gVar = new x22.g<>();
        f910a = gVar;
        f02 f02 = new f02();
        b = f02;
        c = new x22<>("SmsRetriever.API", f02, gVar);
    }

    public e02(Context context) {
        super(context, c, (x22.d) null, z22.a.c);
    }

    public e02(Activity activity) {
        super(activity, (x22) c, (x22.d) null, z22.a.c);
    }
}
