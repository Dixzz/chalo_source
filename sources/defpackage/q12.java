package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cloudmessaging.zza;

/* renamed from: q12  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public final class q12 implements Parcelable.Creator<zza> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza createFromParcel(Parcel parcel) {
        return new zza(parcel.readStrongBinder());
    }

    /* Return type fixed from 'java.lang.Object[]' to match base method */
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zza[] newArray(int i) {
        return new zza[i];
    }
}
