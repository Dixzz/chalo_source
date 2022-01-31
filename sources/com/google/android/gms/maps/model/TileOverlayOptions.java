package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzu();
    private float zzcs;
    private boolean zzct = true;
    private float zzda = 0.0f;
    private on3 zzei;
    private TileProvider zzej;
    private boolean zzek = true;

    public TileOverlayOptions() {
    }

    public final TileOverlayOptions fadeIn(boolean z) {
        this.zzek = z;
        return this;
    }

    public final boolean getFadeIn() {
        return this.zzek;
    }

    public final TileProvider getTileProvider() {
        return this.zzej;
    }

    public final float getTransparency() {
        return this.zzda;
    }

    public final float getZIndex() {
        return this.zzcs;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        zzt zzt;
        this.zzej = tileProvider;
        if (tileProvider == null) {
            zzt = null;
        } else {
            zzt = new zzt(this, tileProvider);
        }
        this.zzei = zzt;
        return this;
    }

    public final TileOverlayOptions transparency(float f) {
        gj1.c(f >= 0.0f && f <= 1.0f, "Transparency must be in the range [0..1]");
        this.zzda = f;
        return this;
    }

    public final TileOverlayOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int o1 = gj1.o1(parcel, 20293);
        gj1.x0(parcel, 2, this.zzei.asBinder(), false);
        boolean isVisible = isVisible();
        parcel.writeInt(262147);
        parcel.writeInt(isVisible ? 1 : 0);
        float zIndex = getZIndex();
        parcel.writeInt(262148);
        parcel.writeFloat(zIndex);
        boolean fadeIn = getFadeIn();
        parcel.writeInt(262149);
        parcel.writeInt(fadeIn ? 1 : 0);
        float transparency = getTransparency();
        parcel.writeInt(262150);
        parcel.writeFloat(transparency);
        gj1.H1(parcel, o1);
    }

    public final TileOverlayOptions zIndex(float f) {
        this.zzcs = f;
        return this;
    }

    public TileOverlayOptions(IBinder iBinder, boolean z, float f, boolean z2, float f2) {
        zzs zzs;
        on3 zzk = pn3.zzk(iBinder);
        this.zzei = zzk;
        if (zzk == null) {
            zzs = null;
        } else {
            zzs = new zzs(this);
        }
        this.zzej = zzs;
        this.zzct = z;
        this.zzcs = f;
        this.zzek = z2;
        this.zzda = f2;
    }
}
