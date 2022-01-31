package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: gd2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class gd2 extends gl2 implements IInterface {
    public gd2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final ic2 C1(ic2 ic2, String str, int i, ic2 ic22) throws RemoteException {
        Parcel F = F();
        il2.c(F, ic2);
        F.writeString(str);
        F.writeInt(i);
        il2.c(F, ic22);
        return hj1.n(C(3, F));
    }

    public final ic2 L(ic2 ic2, String str, int i, ic2 ic22) throws RemoteException {
        Parcel F = F();
        il2.c(F, ic2);
        F.writeString(str);
        F.writeInt(i);
        il2.c(F, ic22);
        return hj1.n(C(2, F));
    }
}
