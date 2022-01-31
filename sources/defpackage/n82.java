package defpackage;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* renamed from: n82  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class n82 extends qe2 implements IInterface {
    public n82() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    /* access modifiers changed from: private */
    /* renamed from: M3 */
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        ((q82) this).f.setResult(new Status(parcel.readInt(), null));
        parcel2.writeNoException();
        return true;
    }
}
