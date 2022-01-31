package defpackage;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: sa2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class sa2 extends gl2 implements c82 {
    public sa2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // defpackage.c82
    public final Account zzb() throws RemoteException {
        Parcel C = C(2, F());
        Account account = (Account) il2.a(C, Account.CREATOR);
        C.recycle();
        return account;
    }
}
