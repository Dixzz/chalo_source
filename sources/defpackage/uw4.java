package defpackage;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: uw4  reason: default package */
public abstract class uw4 extends pw4 implements vw4 {
    public uw4() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // defpackage.pw4
    public final boolean C(int i, Parcel parcel) throws RemoteException {
        if (i == 2) {
            w1((Bundle) qw4.a(parcel, Bundle.CREATOR));
            return true;
        } else if (i != 3) {
            return false;
        } else {
            V0((Bundle) qw4.a(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
