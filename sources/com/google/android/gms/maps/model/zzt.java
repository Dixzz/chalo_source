package com.google.android.gms.maps.model;

public final class zzt extends pn3 {
    private final /* synthetic */ TileProvider zzen;

    public zzt(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.zzen = tileProvider;
    }

    @Override // defpackage.on3
    public final Tile getTile(int i, int i2, int i3) {
        return this.zzen.getTile(i, i2, i3);
    }
}
