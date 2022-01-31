package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.phenotype.ExperimentTokens;

/* renamed from: lh4  reason: default package */
public final class lh4 implements Parcelable.Creator<ExperimentTokens> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final ExperimentTokens createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        byte[] bArr = null;
        byte[][] bArr2 = null;
        byte[][] bArr3 = null;
        byte[][] bArr4 = null;
        byte[][] bArr5 = null;
        int[] iArr = null;
        byte[][] bArr6 = null;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    str = gj1.x(parcel, readInt);
                    break;
                case 3:
                    bArr = gj1.t(parcel, readInt);
                    break;
                case 4:
                    bArr2 = gj1.u(parcel, readInt);
                    break;
                case 5:
                    bArr3 = gj1.u(parcel, readInt);
                    break;
                case 6:
                    bArr4 = gj1.u(parcel, readInt);
                    break;
                case 7:
                    bArr5 = gj1.u(parcel, readInt);
                    break;
                case '\b':
                    iArr = gj1.v(parcel, readInt);
                    break;
                case '\t':
                    bArr6 = gj1.u(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new ExperimentTokens(str, bArr, bArr2, bArr3, bArr4, bArr5, iArr, bArr6);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ExperimentTokens[] newArray(int i) {
        return new ExperimentTokens[i];
    }
}
