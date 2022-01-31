package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: rw4  reason: default package */
public final class rw4 extends ow4 implements tw4 {
    public rw4(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: vw4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.tw4
    public final void b0(String str, Bundle bundle, vw4 vw4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeStrongBinder(vw4);
        F(3, C);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: vw4 */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.tw4
    public final void y0(String str, Bundle bundle, vw4 vw4) throws RemoteException {
        Parcel C = C();
        C.writeString(str);
        int i = qw4.f2999a;
        C.writeInt(1);
        bundle.writeToParcel(C, 0);
        C.writeStrongBinder(vw4);
        F(2, C);
    }
}
