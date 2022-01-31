package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.os.ResultReceiver;
import java.util.Objects;

/* renamed from: j  reason: default package */
/* compiled from: IResultReceiver */
public interface j extends IInterface {

    /* renamed from: j$a */
    /* compiled from: IResultReceiver */
    public static abstract class a extends Binder implements j {
        public static final /* synthetic */ int f = 0;

        /* renamed from: j$a$a  reason: collision with other inner class name */
        /* compiled from: IResultReceiver */
        public static class C0038a implements j {
            public IBinder f;

            public C0038a(IBinder iBinder) {
                this.f = iBinder;
            }

            public IBinder asBinder() {
                return this.f;
            }
        }

        public a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("android.support.v4.os.IResultReceiver");
                int readInt = parcel.readInt();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                ResultReceiver.b bVar = (ResultReceiver.b) this;
                Objects.requireNonNull(ResultReceiver.this);
                ResultReceiver.this.a(readInt, bundle);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
        }
    }
}
