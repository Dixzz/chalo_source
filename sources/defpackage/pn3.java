package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* renamed from: pn3  reason: default package */
public abstract class pn3 extends rn3 implements on3 {
    public pn3() {
        super("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    public static on3 zzk(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
        if (queryLocalInterface instanceof on3) {
            return (on3) queryLocalInterface;
        }
        return new qn3(iBinder);
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Tile tile = getTile(parcel.readInt(), parcel.readInt(), parcel.readInt());
        parcel2.writeNoException();
        int i3 = sn3.f3230a;
        if (tile == null) {
            parcel2.writeInt(0);
        } else {
            parcel2.writeInt(1);
            tile.writeToParcel(parcel2, 1);
        }
        return true;
    }
}
