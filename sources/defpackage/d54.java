package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.Objects;

/* renamed from: d54  reason: default package */
public class d54 {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    public static Context f790a;
    public static g54 b;

    public static g54 a(Context context) throws s22 {
        g54 g54;
        Objects.requireNonNull(context, "null reference");
        g54 g542 = b;
        if (g542 != null) {
            return g542;
        }
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context, 13400000);
        if (isGooglePlayServicesAvailable == 0) {
            ClassLoader classLoader = c(context).getClassLoader();
            try {
                Objects.requireNonNull(classLoader, "null reference");
                IBinder iBinder = (IBinder) b(classLoader.loadClass("com.google.android.gms.maps.internal.CreatorImpl"));
                if (iBinder == null) {
                    g54 = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.ICreator");
                    if (queryLocalInterface instanceof g54) {
                        g54 = (g54) queryLocalInterface;
                    } else {
                        g54 = new h54(iBinder);
                    }
                }
                b = g54;
                try {
                    g54.R2(new kc2(c(context).getResources()), GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                    return b;
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            } catch (ClassNotFoundException unused) {
                throw new IllegalStateException("com.google.android.gms.maps.internal.CreatorImpl".length() != 0 ? "Unable to find dynamic class ".concat("com.google.android.gms.maps.internal.CreatorImpl") : new String("Unable to find dynamic class "));
            }
        } else {
            throw new s22(isGooglePlayServicesAvailable);
        }
    }

    public static <T> T b(Class<?> cls) {
        try {
            return (T) cls.newInstance();
        } catch (InstantiationException unused) {
            String name = cls.getName();
            throw new IllegalStateException(name.length() != 0 ? "Unable to instantiate the dynamic class ".concat(name) : new String("Unable to instantiate the dynamic class "));
        } catch (IllegalAccessException unused2) {
            String name2 = cls.getName();
            throw new IllegalStateException(name2.length() != 0 ? "Unable to call the default constructor of ".concat(name2) : new String("Unable to call the default constructor of "));
        }
    }

    public static Context c(Context context) {
        Context context2;
        Context context3 = f790a;
        if (context3 != null) {
            return context3;
        }
        try {
            context2 = DynamiteModule.c(context, DynamiteModule.b, "com.google.android.gms.maps_dynamite").f604a;
        } catch (Exception unused) {
            context2 = GooglePlayServicesUtil.getRemoteContext(context);
        }
        f790a = context2;
        return context2;
    }
}
