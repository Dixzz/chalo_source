package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import defpackage.q32;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzo extends q32.a {
    private final /* synthetic */ zi4 zzfk;
    private final /* synthetic */ zzl zzfl;

    public zzo(zzl zzl, zi4 zi4) {
        this.zzfl = zzl;
        this.zzfk = zi4;
    }

    @Override // defpackage.q32
    public final void onResult(Status status) throws RemoteException {
        if (!this.zzfk.b(null)) {
            return;
        }
        if (status.m1()) {
            this.zzfl.zzfh.zzfd.f4178a.t(null);
            return;
        }
        zi4 zi4 = this.zzfl.zzfh.zzfd;
        zi4.f4178a.u(zzaf.zza(status, "Indexing error, please try again."));
    }
}
