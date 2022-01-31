package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzbk;
import java.util.List;
import java.util.Map;

/* renamed from: pd3  reason: default package */
public final class pd3 implements od3, IInterface {
    public final IBinder f;
    public final String g = "com.google.android.gms.analytics.internal.IAnalyticsService";

    public pd3(IBinder iBinder) {
        this.f = iBinder;
    }

    public IBinder asBinder() {
        return this.f;
    }

    @Override // defpackage.od3
    public final void x2(Map map, long j, String str, List<zzbk> list) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.g);
        obtain.writeMap(map);
        obtain.writeLong(j);
        obtain.writeString(str);
        obtain.writeTypedList(list);
        Parcel obtain2 = Parcel.obtain();
        try {
            this.f.transact(1, obtain, obtain2, 0);
            obtain2.readException();
        } finally {
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
