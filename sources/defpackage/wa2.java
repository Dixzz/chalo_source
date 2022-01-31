package defpackage;

import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import java.util.Locale;

/* renamed from: wa2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class wa2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3751a;
    public final String b;
    public final int c;

    public wa2(@RecentlyNonNull String str, @RecentlyNonNull String... strArr) {
        String str2;
        int length = strArr.length;
        if (length == 0) {
            str2 = "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (String str3 : strArr) {
                if (sb.length() > 1) {
                    sb.append(",");
                }
                sb.append(str3);
            }
            sb.append("] ");
            str2 = sb.toString();
        }
        this.b = str2;
        this.f3751a = str;
        new b82(str, null);
        int i = 2;
        while (i <= 7 && !Log.isLoggable(this.f3751a, i)) {
            i++;
        }
        this.c = i;
    }

    public void a(@RecentlyNonNull String str, Object... objArr) {
        if (this.c <= 3) {
            b(str, objArr);
        }
    }

    @RecentlyNonNull
    public String b(@RecentlyNonNull String str, Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.b.concat(str);
    }

    public void c(@RecentlyNonNull String str, Object... objArr) {
        if (this.c <= 2) {
            b(str, objArr);
        }
    }
}
