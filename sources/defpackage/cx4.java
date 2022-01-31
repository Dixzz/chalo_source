package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: cx4  reason: default package */
public final class cx4 extends ow4 implements dx4 {
    public cx4(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    @Override // defpackage.dx4
    public final void A2(Bundle bundle) throws RemoteException {
        Parcel C = C();
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        F(3, C);
    }

    @Override // defpackage.dx4
    public final void V1(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel C = C();
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeInt(1);
        bundle2.writeToParcel(C, 0);
        F(2, C);
    }

    @Override // defpackage.dx4
    public final void Z1(Bundle bundle) throws RemoteException {
        Parcel C = C();
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        F(4, C);
    }
}
