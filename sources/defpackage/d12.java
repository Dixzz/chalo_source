package defpackage;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* renamed from: d12  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class d12 implements Parcelable.Creator<GoogleSignInOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInOptions createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        Account account = null;
        String str = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 2:
                    arrayList2 = gj1.B(parcel, readInt, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) gj1.w(parcel, readInt, Account.CREATOR);
                    break;
                case 4:
                    z = gj1.Z(parcel, readInt);
                    break;
                case 5:
                    z2 = gj1.Z(parcel, readInt);
                    break;
                case 6:
                    z3 = gj1.Z(parcel, readInt);
                    break;
                case 7:
                    str = gj1.x(parcel, readInt);
                    break;
                case '\b':
                    str2 = gj1.x(parcel, readInt);
                    break;
                case '\t':
                    arrayList = gj1.B(parcel, readInt, GoogleSignInOptionsExtensionParcelable.CREATOR);
                    break;
                case '\n':
                    str3 = gj1.x(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new GoogleSignInOptions(i, arrayList2, account, z, z2, z3, str, str2, GoogleSignInOptions.n1(arrayList), str3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
