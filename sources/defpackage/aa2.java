package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: aa2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class aa2 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f138a = new Object();
    @GuardedBy("sLock")
    public static boolean b;
    public static String c;
    public static int d;

    public static void a(Context context) {
        synchronized (f138a) {
            if (!b) {
                b = true;
                try {
                    Bundle bundle = ob2.a(context).a(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        c = bundle.getString("com.google.app.id");
                        d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
            }
        }
    }
}
