package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.room.MultiInstanceInvalidationService;
import defpackage.rl;

/* renamed from: sl  reason: default package */
/* compiled from: IMultiInstanceInvalidationService */
public interface sl extends IInterface {

    /* renamed from: sl$a */
    /* compiled from: IMultiInstanceInvalidationService */
    public static abstract class a extends Binder implements sl {
        public a() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                int F = ((MultiInstanceInvalidationService.b) this).F(rl.a.C(parcel.readStrongBinder()), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(F);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                ((MultiInstanceInvalidationService.b) this).B3(rl.a.C(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else if (i == 3) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
                ((MultiInstanceInvalidationService.b) this).C(parcel.readInt(), parcel.createStringArray());
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
                return true;
            }
        }
    }

    void B3(rl rlVar, int i) throws RemoteException;
}
