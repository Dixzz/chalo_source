package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: rl  reason: default package */
/* compiled from: IMultiInstanceInvalidationCallback */
public interface rl extends IInterface {

    /* renamed from: rl$a */
    /* compiled from: IMultiInstanceInvalidationCallback */
    public static abstract class a extends Binder implements rl {
        public static final /* synthetic */ int f = 0;

        /* renamed from: rl$a$a  reason: collision with other inner class name */
        /* compiled from: IMultiInstanceInvalidationCallback */
        public static class C0050a implements rl {
            public IBinder f;

            public C0050a(IBinder iBinder) {
                this.f = iBinder;
            }

            public IBinder asBinder() {
                return this.f;
            }

            @Override // defpackage.rl
            public void r0(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(strArr);
                    if (!this.f.transact(1, obtain, null, 1)) {
                        int i = a.f;
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static rl C(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof rl)) {
                return new C0050a(iBinder);
            }
            return (rl) queryLocalInterface;
        }
    }

    void r0(String[] strArr) throws RemoteException;
}
