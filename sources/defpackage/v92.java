package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzi;
import java.util.Objects;

/* renamed from: v92  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class v92 extends hl2 implements d82 {
    public v92() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // defpackage.hl2
    public final boolean C(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            ((fa2) this).J1(parcel.readInt(), parcel.readStrongBinder(), (Bundle) il2.a(parcel, Bundle.CREATOR));
        } else if (i == 2) {
            parcel.readInt();
            Bundle bundle = (Bundle) il2.a(parcel, Bundle.CREATOR);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else if (i != 3) {
            return false;
        } else {
            int readInt = parcel.readInt();
            IBinder readStrongBinder = parcel.readStrongBinder();
            zzi zzi = (zzi) il2.a(parcel, zzi.CREATOR);
            fa2 fa2 = (fa2) this;
            w72 w72 = fa2.f;
            gj1.l(w72, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Objects.requireNonNull(zzi, "null reference");
            w72.zzo(w72, zzi);
            fa2.J1(readInt, readStrongBinder, zzi.f);
        }
        parcel2.writeNoException();
        return true;
    }
}
