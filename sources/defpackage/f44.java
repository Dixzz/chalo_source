package defpackage;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.Objects;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: f44  reason: default package */
public final class f44 {
    @GuardedBy("MapsInitializer.class")

    /* renamed from: a  reason: collision with root package name */
    public static boolean f1089a = false;

    public static synchronized int a(Context context) {
        synchronized (f44.class) {
            gj1.l(context, "Context is null");
            if (f1089a) {
                return 0;
            }
            try {
                g54 a2 = d54.a(context);
                try {
                    k44 zze = a2.zze();
                    Objects.requireNonNull(zze, "null reference");
                    hd3.f1360a = zze;
                    BitmapDescriptorFactory.zza(a2.zzf());
                    f1089a = true;
                    return 0;
                } catch (RemoteException e) {
                    throw new RuntimeRemoteException(e);
                }
            } catch (s22 e2) {
                return e2.f;
            }
        }
    }
}
