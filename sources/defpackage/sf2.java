package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.zzc;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: sf2  reason: default package */
public class sf2 extends Binder implements IInterface {
    public sf2(String str) {
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
        xk2 xk2 = (xk2) this;
        switch (i) {
            case 1:
                ((uk2) xk2).f.setResult((Status) ng2.a(parcel, Status.CREATOR));
                return true;
            case 2:
                Status status = (Status) ng2.a(parcel, Status.CREATOR);
                throw new UnsupportedOperationException();
            case 3:
                Status status2 = (Status) ng2.a(parcel, Status.CREATOR);
                parcel.readLong();
                throw new UnsupportedOperationException();
            case 4:
                Status status3 = (Status) ng2.a(parcel, Status.CREATOR);
                throw new UnsupportedOperationException();
            case 5:
                Status status4 = (Status) ng2.a(parcel, Status.CREATOR);
                parcel.readLong();
                throw new UnsupportedOperationException();
            case 6:
                Status status5 = (Status) ng2.a(parcel, Status.CREATOR);
                zze[] zzeArr = (zze[]) parcel.createTypedArray(zze.CREATOR);
                throw new UnsupportedOperationException();
            case 7:
                DataHolder dataHolder = (DataHolder) ng2.a(parcel, DataHolder.CREATOR);
                throw new UnsupportedOperationException();
            case 8:
                Status status6 = (Status) ng2.a(parcel, Status.CREATOR);
                zzc zzc = (zzc) ng2.a(parcel, zzc.CREATOR);
                throw new UnsupportedOperationException();
            case 9:
                Status status7 = (Status) ng2.a(parcel, Status.CREATOR);
                zzc zzc2 = (zzc) ng2.a(parcel, zzc.CREATOR);
                throw new UnsupportedOperationException();
            default:
                return false;
        }
    }
}
