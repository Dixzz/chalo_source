package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

/* renamed from: mm3  reason: default package */
public abstract class mm3 extends tm3 implements lm3 {
    public mm3() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    @Override // defpackage.tm3
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        wm3 wm3 = (wm3) this;
        wm3.f.setResult((LocationSettingsResult) cn3.a(parcel, LocationSettingsResult.CREATOR));
        wm3.f = null;
        return true;
    }
}
