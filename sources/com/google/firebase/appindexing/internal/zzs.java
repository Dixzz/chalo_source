package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public abstract class zzs extends d42<ef3, Void> implements m32<Status> {
    private zi4<Void> zzfn;

    private zzs() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b, zi4] */
    @Override // defpackage.d42
    public /* synthetic */ void doExecute(ef3 ef3, zi4<Void> zi4) throws RemoteException {
        this.zzfn = zi4;
        zza((ze3) ef3.getService());
    }

    public void setFailedResult(Status status) {
        gj1.c(!status.m1(), "Failed result must not be success.");
        zi4<Void> zi4 = this.zzfn;
        zi4.f4178a.u(zzaf.zza(status, status.h));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.m32
    public void setResult(Status status) {
        Status status2 = status;
        if (status2.m1()) {
            this.zzfn.f4178a.t(null);
            return;
        }
        zi4<Void> zi4 = this.zzfn;
        zi4.f4178a.u(zzaf.zza(status2, "User Action indexing error, please try again."));
    }

    public abstract void zza(ze3 ze3) throws RemoteException;

    public /* synthetic */ zzs(zzq zzq) {
        this();
    }
}
