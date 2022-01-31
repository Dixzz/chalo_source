package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;

/* renamed from: a02  reason: default package */
public final class a02 implements Parcelable.Creator<CredentialPickerConfig> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final CredentialPickerConfig createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                z = gj1.Z(parcel, readInt);
            } else if (c == 2) {
                z2 = gj1.Z(parcel, readInt);
            } else if (c == 3) {
                z3 = gj1.Z(parcel, readInt);
            } else if (c == 4) {
                i2 = gj1.g0(parcel, readInt);
            } else if (c != 1000) {
                gj1.p0(parcel, readInt);
            } else {
                i = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new CredentialPickerConfig(i, z, z2, z3, i2);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ CredentialPickerConfig[] newArray(int i) {
        return new CredentialPickerConfig[i];
    }
}
