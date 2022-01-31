package defpackage;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* renamed from: ie2  reason: default package */
public abstract class ie2 extends zd2 implements he2 {
    public ie2() {
        super("com.google.android.gms.auth.api.credentials.internal.ICredentialsCallbacks");
    }

    @Override // defpackage.zd2
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ((ee2) this).f.setResult(new be2((Status) ae2.a(parcel, Status.CREATOR), (Credential) ae2.a(parcel, Credential.CREATOR)));
        } else if (i == 2) {
            ((ee2) this).f.setResult(new be2((Status) ae2.a(parcel, Status.CREATOR), null));
        } else if (i != 3) {
            return false;
        } else {
            Status status = (Status) ae2.a(parcel, Status.CREATOR);
            parcel.readString();
            throw new UnsupportedOperationException();
        }
        parcel2.writeNoException();
        return true;
    }
}
