package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.icing.zzh;
import com.google.android.gms.internal.icing.zzk;

/* renamed from: nl3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class nl3 implements Parcelable.Creator<zzh> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzh createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzk[] zzkArr = null;
        String str = null;
        Account account = null;
        boolean z = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                zzkArr = (zzk[]) gj1.A(parcel, readInt, zzk.CREATOR);
            } else if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                z = gj1.Z(parcel, readInt);
            } else if (c != 4) {
                gj1.p0(parcel, readInt);
            } else {
                account = (Account) gj1.w(parcel, readInt, Account.CREATOR);
            }
        }
        gj1.F(parcel, r0);
        return new zzh(zzkArr, str, z, account);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzh[] newArray(int i) {
        return new zzh[i];
    }
}
