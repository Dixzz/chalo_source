package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* renamed from: w02  reason: default package */
public final class w02 extends yd2 implements v02 {
    public w02(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // defpackage.v02
    public final void F1(t02 t02, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        int i = ae2.f155a;
        obtain.writeStrongBinder((zd2) t02);
        if (googleSignInOptions == null) {
            obtain.writeInt(0);
        } else {
            obtain.writeInt(1);
            googleSignInOptions.writeToParcel(obtain, 0);
        }
        C(103, obtain);
    }
}
