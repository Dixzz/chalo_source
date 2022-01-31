package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.icing.zzo;
import defpackage.gf3;

/* renamed from: ye3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public class ye3 extends Binder implements IInterface {
    public ye3(String str) {
        attachInterface(this, str);
    }

    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z;
        if (i > 16777215) {
            z = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            return true;
        }
        df3 df3 = (df3) this;
        if (i == 1) {
            ((gf3.b) df3).f.setResult((Status) ch3.a(parcel, Status.CREATOR));
        } else if (i == 2) {
            Status status = (Status) ch3.a(parcel, Status.CREATOR);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ch3.a(parcel, ParcelFileDescriptor.CREATOR);
        } else if (i != 4) {
            return false;
        } else {
            zzo zzo = (zzo) ch3.a(parcel, zzo.CREATOR);
        }
        return true;
    }
}
