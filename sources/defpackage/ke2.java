package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* renamed from: ke2  reason: default package */
public final class ke2 extends yd2 implements je2 {
    public ke2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
    }

    @Override // defpackage.je2
    public final void I0(he2 he2, CredentialRequest credentialRequest) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        int i = ae2.f155a;
        obtain.writeStrongBinder((zd2) he2);
        if (credentialRequest == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            credentialRequest.writeToParcel(obtain, 0);
        }
        C(1, obtain);
    }
}
