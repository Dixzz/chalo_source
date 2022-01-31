package defpackage;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;
import java.util.Objects;

/* renamed from: yh4  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class yh4 {

    /* renamed from: a  reason: collision with root package name */
    public static final r22 f4047a = r22.b;
    public static final Object b = new Object();
    public static Method c;
    public static Method d;

    public static void a(@RecentlyNonNull Context context) throws t22, s22 {
        Context context2;
        gj1.l(context, "Context must not be null");
        Objects.requireNonNull(f4047a);
        u22.ensurePlayServicesAvailable(context, 11925000);
        synchronized (b) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                context2 = DynamiteModule.c(context, DynamiteModule.d, "com.google.android.gms.providerinstaller.dynamite").f604a;
            } catch (DynamiteModule.a e) {
                String valueOf = String.valueOf(e.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to load providerinstaller module: ".concat(valueOf);
                } else {
                    new String("Failed to load providerinstaller module: ");
                }
                context2 = null;
            }
            if (context2 == null) {
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                Context remoteContext = u22.getRemoteContext(context);
                if (remoteContext != null) {
                    try {
                        if (d == null) {
                            Class<?> cls = Long.TYPE;
                            d = remoteContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("reportRequestStats", Context.class, cls, cls);
                        }
                        d.invoke(null, context, Long.valueOf(elapsedRealtime), Long.valueOf(elapsedRealtime2));
                    } catch (Exception e2) {
                        String valueOf2 = String.valueOf(e2.getMessage());
                        if (valueOf2.length() != 0) {
                            "Failed to report request stats: ".concat(valueOf2);
                        } else {
                            new String("Failed to report request stats: ");
                        }
                    }
                }
                if (remoteContext != null) {
                    b(remoteContext, context, "com.google.android.gms.common.security.ProviderInstallerImpl");
                    return;
                }
                throw new s22(8);
            }
            b(context2, context, "com.google.android.gms.providerinstaller.ProviderInstallerImpl");
        }
    }

    public static void b(Context context, Context context2, String str) throws s22 {
        try {
            if (c == null) {
                c = context.getClassLoader().loadClass(str).getMethod("insertProvider", Context.class);
            }
            c.invoke(null, context);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (Log.isLoggable("ProviderInstaller", 6)) {
                String valueOf = String.valueOf(cause == null ? e.getMessage() : cause.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to install provider: ".concat(valueOf);
                } else {
                    new String("Failed to install provider: ");
                }
            }
            throw new s22(8);
        }
    }
}
