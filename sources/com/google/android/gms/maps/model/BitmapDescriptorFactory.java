package com.google.android.gms.maps.model;

import android.graphics.Bitmap;
import android.os.RemoteException;
import java.util.Objects;

public final class BitmapDescriptorFactory {
    public static final float HUE_AZURE = 210.0f;
    public static final float HUE_BLUE = 240.0f;
    public static final float HUE_CYAN = 180.0f;
    public static final float HUE_GREEN = 120.0f;
    public static final float HUE_MAGENTA = 300.0f;
    public static final float HUE_ORANGE = 30.0f;
    public static final float HUE_RED = 0.0f;
    public static final float HUE_ROSE = 330.0f;
    public static final float HUE_VIOLET = 270.0f;
    public static final float HUE_YELLOW = 60.0f;
    private static un3 zzcm;

    private BitmapDescriptorFactory() {
    }

    public static BitmapDescriptor defaultMarker() {
        try {
            return new BitmapDescriptor(zzg().h());
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            return new BitmapDescriptor(zzg().zza(str));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        try {
            return new BitmapDescriptor(zzg().r1(bitmap));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            return new BitmapDescriptor(zzg().zzb(str));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return new BitmapDescriptor(zzg().zzc(str));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static BitmapDescriptor fromResource(int i) {
        try {
            return new BitmapDescriptor(zzg().j(i));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public static void zza(un3 un3) {
        if (zzcm == null) {
            Objects.requireNonNull(un3, "null reference");
            zzcm = un3;
        }
    }

    private static un3 zzg() {
        un3 un3 = zzcm;
        gj1.l(un3, "IBitmapDescriptorFactory is not initialized");
        return un3;
    }

    public static BitmapDescriptor defaultMarker(float f) {
        try {
            return new BitmapDescriptor(zzg().p2(f));
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
