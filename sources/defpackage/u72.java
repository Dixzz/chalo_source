package defpackage;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;

/* renamed from: u72  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class u72 implements Parcelable.Creator<DataHolder> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final DataHolder createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        int i = 0;
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            char c = (char) readInt;
            if (c == 1) {
                strArr = gj1.y(parcel, readInt);
            } else if (c == 2) {
                cursorWindowArr = (CursorWindow[]) gj1.A(parcel, readInt, CursorWindow.CREATOR);
            } else if (c == 3) {
                i3 = gj1.g0(parcel, readInt);
            } else if (c == 4) {
                bundle = gj1.s(parcel, readInt);
            } else if (c != 1000) {
                gj1.p0(parcel, readInt);
            } else {
                i2 = gj1.g0(parcel, readInt);
            }
        }
        gj1.F(parcel, r0);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.h = new Bundle();
        int i4 = 0;
        while (true) {
            String[] strArr2 = dataHolder.g;
            if (i4 >= strArr2.length) {
                break;
            }
            dataHolder.h.putInt(strArr2[i4], i4);
            i4++;
        }
        dataHolder.l = new int[dataHolder.i.length];
        int i5 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = dataHolder.i;
            if (i >= cursorWindowArr2.length) {
                return dataHolder;
            }
            dataHolder.l[i] = i5;
            i5 += dataHolder.i[i].getNumRows() - (i5 - cursorWindowArr2[i].getStartPosition());
            i++;
        }
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
