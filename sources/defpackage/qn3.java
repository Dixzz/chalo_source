package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* renamed from: qn3  reason: default package */
public final class qn3 extends kn3 implements on3 {
    public qn3(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileProviderDelegate");
    }

    @Override // defpackage.on3
    public final Tile getTile(int i, int i2, int i3) throws RemoteException {
        Parcel C = C();
        C.writeInt(i);
        C.writeInt(i2);
        C.writeInt(i3);
        Parcel F = F(1, C);
        Tile tile = (Tile) sn3.a(F, Tile.CREATOR);
        F.recycle();
        return tile;
    }
}
