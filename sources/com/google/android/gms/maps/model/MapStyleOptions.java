package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class MapStyleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MapStyleOptions> CREATOR = new zzg();
    private static final String TAG = MapStyleOptions.class.getSimpleName();
    private String zzdl;

    public MapStyleOptions(String str) {
        this.zzdl = str;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:8|9|10|11|12|14) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0020 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.maps.model.MapStyleOptions loadRawResourceStyle(android.content.Context r6, int r7) throws android.content.res.Resources.NotFoundException {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.model.MapStyleOptions.loadRawResourceStyle(android.content.Context, int):com.google.android.gms.maps.model.MapStyleOptions");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.B0(parcel, 2, this.zzdl, false);
        gj1.H1(parcel, o1);
    }
}
