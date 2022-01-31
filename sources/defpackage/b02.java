package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.CredentialRequest;

/* renamed from: b02  reason: default package */
public final class b02 implements Parcelable.Creator<CredentialRequest> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final CredentialRequest createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String[] strArr = null;
        CredentialPickerConfig credentialPickerConfig = null;
        CredentialPickerConfig credentialPickerConfig2 = null;
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
                        z = gj1.Z(parcel, readInt);
                        continue;
                    case 2:
                        strArr = gj1.y(parcel, readInt);
                        continue;
                    case 3:
                        credentialPickerConfig = (CredentialPickerConfig) gj1.w(parcel, readInt, CredentialPickerConfig.CREATOR);
                        continue;
                    case 4:
                        credentialPickerConfig2 = (CredentialPickerConfig) gj1.w(parcel, readInt, CredentialPickerConfig.CREATOR);
                        continue;
                    case 5:
                        z2 = gj1.Z(parcel, readInt);
                        continue;
                    case 6:
                        str = gj1.x(parcel, readInt);
                        continue;
                    case 7:
                        str2 = gj1.x(parcel, readInt);
                        continue;
                    case '\b':
                        z3 = gj1.Z(parcel, readInt);
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
        return new CredentialRequest(i, z, strArr, credentialPickerConfig, credentialPickerConfig2, z2, str, str2, z3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialRequest[] newArray(int i) {
        return new CredentialRequest[i];
    }
}
