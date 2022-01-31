package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.firebase.appindexing.FirebaseAppIndexingException;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzl extends d42<zze, Void> {
    public final /* synthetic */ zzj zzfh;

    public zzl(zzj zzj) {
        this.zzfh = zzj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b, zi4] */
    @Override // defpackage.d42
    public final void doExecute(zze zze, zi4<Void> zi4) throws RemoteException {
        int i;
        zzg zza = ((zzr) zze.getService()).zza(new zzo(this, zi4), zzj.zzb(this.zzfh));
        if (zza == null) {
            i = 2;
        } else {
            i = zza.status;
        }
        boolean z = false;
        boolean z2 = true;
        zzj zzj = null;
        if (i == 3) {
            zzt.isLoggable(4);
            if (zi4.b(null)) {
                synchronized (this.zzfh.zzfe.zzff) {
                    if (this.zzfh.zzfe.zzfg == 0) {
                        zzj = (zzj) this.zzfh.zzfe.zzff.peek();
                        if (zzj == this.zzfh) {
                            z = true;
                        }
                        gj1.n(z);
                    } else {
                        this.zzfh.zzfe.zzfg = 2;
                    }
                }
            }
        } else {
            if (i != 1) {
                zzt.isLoggable(6);
                if (zi4.b(null)) {
                    zi4 zza2 = zzj.zza(this.zzfh);
                    zza2.f4178a.u(new FirebaseAppIndexingException("Indexing error."));
                }
            }
            synchronized (this.zzfh.zzfe.zzff) {
                if (((zzj) this.zzfh.zzfe.zzff.poll()) != this.zzfh) {
                    z2 = false;
                }
                gj1.n(z2);
                zzj = (zzj) this.zzfh.zzfe.zzff.peek();
                this.zzfh.zzfe.zzfg = 0;
            }
        }
        if (zzj != null) {
            zzj.execute();
        }
    }
}
