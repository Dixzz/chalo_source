package defpackage;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: eo3  reason: default package */
public abstract class eo3 extends rn3 implements do3 {
    public static do3 C(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IMarkerDelegate");
        if (queryLocalInterface instanceof do3) {
            return (do3) queryLocalInterface;
        }
        return new fo3(iBinder);
    }
}
