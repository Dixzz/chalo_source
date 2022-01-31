package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import app.zophop.ui.fragments.HomeScreenMapFragment;

/* renamed from: p54  reason: default package */
public abstract class p54 extends rn3 implements o54 {
    public p54() {
        super("com.google.android.gms.maps.internal.IOnCameraMoveListener");
    }

    @Override // defpackage.rn3
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        HomeScreenMapFragment homeScreenMapFragment = ((hr0) ((z54) this).f).f1415a;
        int i3 = HomeScreenMapFragment.U;
        n86.e(homeScreenMapFragment, "this$0");
        homeScreenMapFragment.h();
        parcel2.writeNoException();
        return true;
    }
}
