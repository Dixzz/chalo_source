package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zak;

/* renamed from: di4  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public abstract class di4 extends qe2 implements ei4 {
    public di4() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // defpackage.qe2
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 3:
                ConnectionResult connectionResult = (ConnectionResult) re2.a(parcel, ConnectionResult.CREATOR);
                zaa zaa = (zaa) re2.a(parcel, zaa.CREATOR);
                break;
            case 4:
                Status status = (Status) re2.a(parcel, Status.CREATOR);
                break;
            case 5:
            default:
                return false;
            case 6:
                Status status2 = (Status) re2.a(parcel, Status.CREATOR);
                break;
            case 7:
                Status status3 = (Status) re2.a(parcel, Status.CREATOR);
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) re2.a(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                x0((zak) re2.a(parcel, zak.CREATOR));
                break;
            case 9:
                zag zag = (zag) re2.a(parcel, zag.CREATOR);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
