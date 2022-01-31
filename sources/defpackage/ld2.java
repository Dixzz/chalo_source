package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: ld2  reason: default package */
/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
public class ld2 extends Binder implements IInterface {
    public ld2(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z;
        Status status;
        if (i > 16777215) {
            z = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            return true;
        }
        qd2 qd2 = (qd2) this;
        if (i != 1) {
            return false;
        }
        Parcelable.Creator<Status> creator = Status.CREATOR;
        int i3 = nd2.f2541a;
        if (parcel.readInt() == 0) {
            status = null;
        } else {
            status = creator.createFromParcel(parcel);
        }
        qd2.r2(status);
        return true;
    }
}
