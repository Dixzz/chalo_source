package defpackage;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.location.zzbd;
import com.google.android.gms.internal.location.zzbf;

/* renamed from: ym3  reason: default package */
public final class ym3 implements Parcelable.Creator<zzbf> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final zzbf createFromParcel(Parcel parcel) {
        int r0 = gj1.r0(parcel);
        zzbd zzbd = null;
        IBinder iBinder = null;
        PendingIntent pendingIntent = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        int i = 1;
        while (parcel.dataPosition() < r0) {
            int readInt = parcel.readInt();
            switch ((char) readInt) {
                case 1:
                    i = gj1.g0(parcel, readInt);
                    break;
                case 2:
                    zzbd = (zzbd) gj1.w(parcel, readInt, zzbd.CREATOR);
                    break;
                case 3:
                    iBinder = gj1.f0(parcel, readInt);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) gj1.w(parcel, readInt, PendingIntent.CREATOR);
                    break;
                case 5:
                    iBinder2 = gj1.f0(parcel, readInt);
                    break;
                case 6:
                    iBinder3 = gj1.f0(parcel, readInt);
                    break;
                default:
                    gj1.p0(parcel, readInt);
                    break;
            }
        }
        gj1.F(parcel, r0);
        return new zzbf(i, zzbd, iBinder, pendingIntent, iBinder2, iBinder3);
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzbf[] newArray(int i) {
        return new zzbf[i];
    }
}
