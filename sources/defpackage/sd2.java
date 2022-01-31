package defpackage;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.Feature;
import defpackage.d42;

/* renamed from: sd2  reason: default package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
public final class sd2 extends e02 {
    public sd2(Context context) {
        super(context);
    }

    public final yi4<Void> a() {
        d42.a builder = d42.builder();
        builder.f784a = new vd2(this);
        builder.c = new Feature[]{md2.b};
        return doWrite(builder.a());
    }

    public sd2(Activity activity) {
        super(activity);
    }
}
