package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.api.Status;

/* renamed from: q32  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public interface q32 extends IInterface {

    /* renamed from: q32$a */
    /* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
    public static abstract class a extends qe2 implements q32 {
        public a() {
            super("com.google.android.gms.common.api.internal.IStatusCallback");
        }

        @RecentlyNonNull
        public static q32 asInterface(@RecentlyNonNull IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.api.internal.IStatusCallback");
            if (queryLocalInterface instanceof q32) {
                return (q32) queryLocalInterface;
            }
            return new w52(iBinder);
        }

        @Override // defpackage.qe2
        public final boolean zaa(int i, @RecentlyNonNull Parcel parcel, @RecentlyNonNull Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            onResult((Status) re2.a(parcel, Status.CREATOR));
            return true;
        }
    }

    void onResult(@RecentlyNonNull Status status) throws RemoteException;
}
