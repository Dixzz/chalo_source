package defpackage;

import android.location.Location;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: b44  reason: default package */
public abstract class b44 extends tm3 implements a44 {
    public static final /* synthetic */ int f = 0;

    public b44() {
        super("com.google.android.gms.location.ILocationListener");
    }

    @Override // defpackage.tm3
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Location location = (Location) cn3.a(parcel, Location.CREATOR);
        qm3 qm3 = (qm3) this;
        synchronized (qm3) {
            qm3.g.a(new rm3(location));
        }
        return true;
    }
}
