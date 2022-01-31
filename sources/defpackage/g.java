package defpackage;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: g  reason: default package */
/* compiled from: INotificationSideChannel */
public interface g extends IInterface {

    /* renamed from: g$a */
    /* compiled from: INotificationSideChannel */
    public static abstract class a extends Binder implements g {
        public static final /* synthetic */ int f = 0;

        /* renamed from: g$a$a  reason: collision with other inner class name */
        /* compiled from: INotificationSideChannel */
        public static class C0023a implements g {
            public IBinder f;

            public C0023a(IBinder iBinder) {
                this.f = iBinder;
            }

            public IBinder asBinder() {
                return this.f;
            }

            @Override // defpackage.g
            public void s3(String str, int i, String str2, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.f.transact(1, obtain, null, 1)) {
                        int i2 = a.f;
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }
    }

    void s3(String str, int i, String str2, Notification notification) throws RemoteException;
}
