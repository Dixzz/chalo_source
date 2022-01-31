package defpackage;

import android.util.Log;
import androidx.annotation.RecentlyNonNull;

/* renamed from: b82  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class b82 {

    /* renamed from: a  reason: collision with root package name */
    public final String f395a;
    public final String b;

    public b82(@RecentlyNonNull String str, String str2) {
        gj1.l(str, "log tag cannot be null");
        gj1.e(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f395a = str;
        if (str2 == null || str2.length() <= 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
    }

    public boolean a(int i) {
        return Log.isLoggable(this.f395a, i);
    }
}
