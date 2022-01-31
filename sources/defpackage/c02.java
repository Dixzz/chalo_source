package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.HintRequest;

/* renamed from: c02  reason: default package */
public final class c02 implements Parcelable.Creator<HintRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final HintRequest createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        CredentialPickerConfig credentialPickerConfig = null;
        String[] strArr = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c != 1000) {
                switch (c) {
                    case 1:
                        credentialPickerConfig = (CredentialPickerConfig) gj1.w(parcel, readInt, CredentialPickerConfig.CREATOR);
                        continue;
                    case 2:
                        z = gj1.Z(parcel, readInt);
                        continue;
                    case 3:
                        z2 = gj1.Z(parcel, readInt);
                        continue;
                    case 4:
                        strArr = gj1.y(parcel, readInt);
                        continue;
                    case 5:
                        z3 = gj1.Z(parcel, readInt);
                        continue;
                    case 6:
                        str = gj1.x(parcel, readInt);
                        continue;
                    case 7:
                        str2 = gj1.x(parcel, readInt);
                        continue;
                    default:
                        gj1.p0(parcel, readInt);
                        continue;
                }
            } else {
                i = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new HintRequest(i, credentialPickerConfig, z, z2, strArr, z3, str, str2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ HintRequest[] newArray(int i) {
        return new HintRequest[i];
    }
}
