package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.zza;
import com.google.android.gms.safetynet.zzd;
import com.google.android.gms.safetynet.zzf;
import com.google.android.gms.safetynet.zzh;

/* renamed from: n24  reason: default package */
public class n24 extends Binder implements IInterface {
    public n24(String str) {
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
        s24 s24 = (s24) this;
        if (i == 1) {
            ((y24) s24).f.setResult(new v24((Status) o24.a(parcel, Status.CREATOR), (zza) o24.a(parcel, zza.CREATOR)));
            return true;
        } else if (i == 2) {
            parcel.readString();
            throw new UnsupportedOperationException();
        } else if (i == 3) {
            Status status = (Status) o24.a(parcel, Status.CREATOR);
            SafeBrowsingData safeBrowsingData = (SafeBrowsingData) o24.a(parcel, SafeBrowsingData.CREATOR);
            throw new UnsupportedOperationException();
        } else if (i == 4) {
            Status status2 = (Status) o24.a(parcel, Status.CREATOR);
            parcel.readInt();
            throw new UnsupportedOperationException();
        } else if (i == 6) {
            Status status3 = (Status) o24.a(parcel, Status.CREATOR);
            zzf zzf = (zzf) o24.a(parcel, zzf.CREATOR);
            throw new UnsupportedOperationException();
        } else if (i == 8) {
            Status status4 = (Status) o24.a(parcel, Status.CREATOR);
            zzd zzd = (zzd) o24.a(parcel, zzd.CREATOR);
            throw new UnsupportedOperationException();
        } else if (i == 15) {
            Status status5 = (Status) o24.a(parcel, Status.CREATOR);
            zzh zzh = (zzh) o24.a(parcel, zzh.CREATOR);
            throw new UnsupportedOperationException();
        } else if (i == 10) {
            Status status6 = (Status) o24.a(parcel, Status.CREATOR);
            parcel.readInt();
            throw new UnsupportedOperationException();
        } else if (i != 11) {
            return false;
        } else {
            Status status7 = (Status) o24.a(parcel, Status.CREATOR);
            throw new UnsupportedOperationException();
        }
    }
}
