package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* renamed from: u02  reason: default package */
public abstract class u02 extends zd2 implements t02 {
    public u02() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // defpackage.zd2
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 101:
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) ae2.a(parcel, GoogleSignInAccount.CREATOR);
                Status status = (Status) ae2.a(parcel, Status.CREATOR);
                throw new UnsupportedOperationException();
            case 102:
                Status status2 = (Status) ae2.a(parcel, Status.CREATOR);
                throw new UnsupportedOperationException();
            case 103:
                ((p02) this).f.setResult((Status) ae2.a(parcel, Status.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
