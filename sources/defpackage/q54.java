package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* renamed from: q54  reason: default package */
public final class q54 implements Parcelable.Creator<GoogleMapOptions> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final GoogleMapOptions createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        CameraPosition cameraPosition = null;
        Float f = null;
        Float f2 = null;
        LatLngBounds latLngBounds = null;
        byte b = -1;
        byte b2 = -1;
        int i = 0;
        byte b3 = -1;
        byte b4 = -1;
        byte b5 = -1;
        byte b6 = -1;
        byte b7 = -1;
        byte b8 = -1;
        byte b9 = -1;
        byte b10 = -1;
        byte b11 = -1;
        byte b12 = -1;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 2:
                    b = gj1.b0(parcel, readInt);
                    break;
                case 3:
                    b2 = gj1.b0(parcel, readInt);
                    break;
                case 4:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) gj1.w(parcel, readInt, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = gj1.b0(parcel, readInt);
                    break;
                case 7:
                    b4 = gj1.b0(parcel, readInt);
                    break;
                case '\b':
                    b5 = gj1.b0(parcel, readInt);
                    break;
                case '\t':
                    b6 = gj1.b0(parcel, readInt);
                    break;
                case '\n':
                    b7 = gj1.b0(parcel, readInt);
                    break;
                case 11:
                    b8 = gj1.b0(parcel, readInt);
                    break;
                case '\f':
                    b9 = gj1.b0(parcel, readInt);
                    break;
                case '\r':
                default:
                    gj1.p0(parcel, readInt);
                    break;
                case 14:
                    b10 = gj1.b0(parcel, readInt);
                    break;
                case 15:
                    b11 = gj1.b0(parcel, readInt);
                    break;
                case 16:
                    f = gj1.e0(parcel, readInt);
                    break;
                case 17:
                    f2 = gj1.e0(parcel, readInt);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) gj1.w(parcel, readInt, LatLngBounds.CREATOR);
                    break;
                case 19:
                    b12 = gj1.b0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new GoogleMapOptions(b, b2, i, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10, b11, f, f2, latLngBounds, b12);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleMapOptions[] newArray(int i) {
        return new GoogleMapOptions[i];
    }
}
