package defpackage;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.safetynet.SafeBrowsingData;

/* renamed from: wh4  reason: default package */
public final class wh4 implements Parcelable.Creator<SafeBrowsingData> {
    public static void a(SafeBrowsingData safeBrowsingData, Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, safeBrowsingData.f, false);
        gj1.A0(parcel, 3, safeBrowsingData.g, i, false);
        gj1.A0(parcel, 4, safeBrowsingData.h, i, false);
        long j = safeBrowsingData.i;
        parcel.writeInt(524293);
        parcel.writeLong(j);
        gj1.u0(parcel, 6, safeBrowsingData.j, false);
        gj1.H1(parcel, o1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final SafeBrowsingData createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        String str = null;
        DataHolder dataHolder = null;
        ParcelFileDescriptor parcelFileDescriptor = null;
        byte[] bArr = null;
        long j = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 2) {
                str = gj1.x(parcel, readInt);
            } else if (c == 3) {
                dataHolder = (DataHolder) gj1.w(parcel, readInt, DataHolder.CREATOR);
            } else if (c == 4) {
                parcelFileDescriptor = (ParcelFileDescriptor) gj1.w(parcel, readInt, ParcelFileDescriptor.CREATOR);
            } else if (c == 5) {
                j = gj1.h0(parcel, readInt);
            } else if (c != 6) {
                gj1.p0(parcel, readInt);
            } else {
                bArr = gj1.t(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        return new SafeBrowsingData(str, dataHolder, parcelFileDescriptor, j, bArr);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeBrowsingData[] newArray(int i) {
        return new SafeBrowsingData[i];
    }
}
