package defpackage;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;

/* renamed from: ob2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class ob2 {
    public static ob2 b = new ob2();

    /* renamed from: a  reason: collision with root package name */
    public nb2 f2673a = null;

    @RecentlyNonNull
    public static nb2 a(@RecentlyNonNull Context context) {
        nb2 nb2;
        ob2 ob2 = b;
        synchronized (ob2) {
            if (ob2.f2673a == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                ob2.f2673a = new nb2(context);
            }
            nb2 = ob2.f2673a;
        }
        return nb2;
    }
}
