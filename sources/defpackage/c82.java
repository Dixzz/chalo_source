package defpackage;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;

/* renamed from: c82  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public interface c82 extends IInterface {

    /* renamed from: c82$a */
    /* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
    public static abstract class a extends hl2 implements c82 {
        @RecentlyNonNull
        public static c82 F(@RecentlyNonNull IBinder iBinder) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            if (queryLocalInterface instanceof c82) {
                return (c82) queryLocalInterface;
            }
            return new sa2(iBinder);
        }
    }

    @RecentlyNonNull
    Account zzb() throws RemoteException;
}
