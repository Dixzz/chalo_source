package defpackage;

import android.content.SharedPreferences;
import com.urbanairship.UAirship;

/* renamed from: yy5  reason: default package */
/* compiled from: NotificationIdGenerator */
public class yy5 {
    public static void a(String str, int i) {
        SharedPreferences.Editor edit = UAirship.d().getSharedPreferences("com.urbanairship.notificationidgenerator", 0).edit();
        edit.putInt(str, i);
        edit.apply();
    }
}
