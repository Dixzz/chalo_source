package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zzad;

/* renamed from: fm3  reason: default package */
public abstract class fm3 extends tm3 implements em3 {
    public fm3() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // defpackage.tm3
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((yl3) this).f.setResult(((zzad) cn3.a(parcel, zzad.CREATOR)).f);
        return true;
    }
}
