package defpackage;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;

/* renamed from: b12  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class b12 implements Parcelable.Creator<GoogleSignInAccount> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GoogleSignInAccount createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 2:
                    str = gj1.x(parcel, readInt);
                    break;
                case 3:
                    str2 = gj1.x(parcel, readInt);
                    break;
                case 4:
                    str3 = gj1.x(parcel, readInt);
                    break;
                case 5:
                    str4 = gj1.x(parcel, readInt);
                    break;
                case 6:
                    uri = (Uri) gj1.w(parcel, readInt, Uri.CREATOR);
                    break;
                case 7:
                    str5 = gj1.x(parcel, readInt);
                    break;
                case '\b':
                    j = gj1.h0(parcel, readInt);
                    break;
                case '\t':
                    str6 = gj1.x(parcel, readInt);
                    break;
                case '\n':
                    arrayList = gj1.B(parcel, readInt, Scope.CREATOR);
                    break;
                case 11:
                    str7 = gj1.x(parcel, readInt);
                    break;
                case '\f':
                    str8 = gj1.x(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
