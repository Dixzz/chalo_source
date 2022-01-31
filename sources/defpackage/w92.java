package defpackage;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.GetServiceRequest;

/* renamed from: w92  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class w92 implements e82 {
    public final IBinder f;

    public w92(IBinder iBinder) {
        this.f = iBinder;
    }

    public final IBinder asBinder() {
        return this.f;
    }

    @Override // defpackage.e82
    public final void getService(d82 d82, GetServiceRequest getServiceRequest) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            obtain.writeStrongBinder((hl2) d82);
            obtain.writeInt(1);
            la2.a(getServiceRequest, obtain, 0);
            this.f.transact(46, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
    }
}
