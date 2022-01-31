package defpackage;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: im3  reason: default package */
public abstract class im3 extends tm3 implements hm3 {
    public im3() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override // defpackage.tm3
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            S2(parcel.readInt(), parcel.createStringArray());
        } else if (i == 2) {
            L3(parcel.readInt(), parcel.createStringArray());
        } else if (i != 3) {
            return false;
        } else {
            v1(parcel.readInt(), (PendingIntent) cn3.a(parcel, PendingIntent.CREATOR));
        }
        return true;
    }
}
