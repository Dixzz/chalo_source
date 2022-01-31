package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import defpackage.gf3;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzq extends zzs {
    private final /* synthetic */ zza[] zzfm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzq(zzn zzn, zza[] zzaArr) {
        super(null);
        this.zzfm = zzaArr;
    }

    @Override // com.google.firebase.appindexing.internal.zzs
    public final void zza(ze3 ze3) throws RemoteException {
        ze3.M1(new gf3.b(this), this.zzfm);
    }
}
