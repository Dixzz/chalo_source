package defpackage;

import android.text.TextUtils;
import androidx.annotation.RecentlyNullable;
import java.util.regex.Pattern;

/* renamed from: hb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class hb2 {
    static {
        Pattern.compile("\\$\\{(.*?)\\}");
    }

    @RecentlyNullable
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public static boolean b(String str) {
        return str == null || str.trim().isEmpty();
    }
}
