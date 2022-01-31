package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R;
import com.google.android.gms.common.api.Status;
import javax.annotation.concurrent.GuardedBy;

@Deprecated
/* renamed from: p32  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class p32 {
    public static final Object d = new Object();
    @GuardedBy("sLock")
    public static p32 e;

    /* renamed from: a  reason: collision with root package name */
    public final String f2764a;
    public final Status b;
    public final boolean c;

    public p32(Context context) {
        Resources resources = context.getResources();
        int i = R.string.common_google_play_services_unknown_issue;
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(i));
        boolean z = false;
        if (identifier != 0) {
            this.c = resources.getInteger(identifier) == 0 ? true : z;
        } else {
            this.c = false;
        }
        aa2.a(context);
        String str = aa2.c;
        if (str == null) {
            Resources resources2 = context.getResources();
            int identifier2 = resources2.getIdentifier("google_app_id", "string", resources2.getResourcePackageName(i));
            if (identifier2 == 0) {
                str = null;
            } else {
                str = resources2.getString(identifier2);
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f2764a = null;
            return;
        }
        this.f2764a = str;
        this.b = Status.k;
    }

    public static p32 a(String str) {
        p32 p32;
        synchronized (d) {
            p32 = e;
            if (p32 == null) {
                StringBuilder sb = new StringBuilder(str.length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
        }
        return p32;
    }
}
