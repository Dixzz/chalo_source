package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;

/* renamed from: m12  reason: default package */
public final class m12 implements Parcelable.Creator<zze> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zze createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzr zzr = null;
        byte[] bArr = null;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[][] bArr2 = null;
        ExperimentTokens[] experimentTokensArr = null;
        boolean z = true;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    zzr = (zzr) gj1.w(parcel, readInt, zzr.CREATOR);
                    break;
                case 3:
                    bArr = gj1.t(parcel, readInt);
                    break;
                case 4:
                    iArr = gj1.v(parcel, readInt);
                    break;
                case 5:
                    strArr = gj1.y(parcel, readInt);
                    break;
                case 6:
                    iArr2 = gj1.v(parcel, readInt);
                    break;
                case 7:
                    bArr2 = gj1.u(parcel, readInt);
                    break;
                case '\b':
                    z = gj1.Z(parcel, readInt);
                    break;
                case '\t':
                    experimentTokensArr = (ExperimentTokens[]) gj1.A(parcel, readInt, ExperimentTokens.CREATOR);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zze(zzr, bArr, iArr, strArr, iArr2, bArr2, z, experimentTokensArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zze[] newArray(int i) {
        return new zze[i];
    }
}
