package com.google.android.gms.maps.model;

import android.os.RemoteException;

public final class zzs implements TileProvider {
    private final on3 zzel;
    private final /* synthetic */ TileOverlayOptions zzem;

    public zzs(TileOverlayOptions tileOverlayOptions) {
        this.zzem = tileOverlayOptions;
        this.zzel = TileOverlayOptions.zza(tileOverlayOptions);
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile getTile(int i, int i2, int i3) {
        try {
            return this.zzel.getTile(i, i2, i3);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
