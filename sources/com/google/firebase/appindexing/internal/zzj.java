package com.google.firebase.appindexing.internal;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class zzj {
    private final zzy zzfc;
    private final zi4<Void> zzfd = new zi4<>();
    public final /* synthetic */ zzk zzfe;

    public zzj(zzk zzk, zzy zzy) {
        this.zzfe = zzk;
        this.zzfc = zzy;
    }

    public final void execute() {
        synchronized (this.zzfe.zzff) {
            gj1.n(this.zzfe.zzfg == 0);
            this.zzfe.zzfg = 1;
        }
        this.zzfe.zzfa.doWrite(new zzl(this)).e(this.zzfe, new zzm(this));
    }

    public final yi4<Void> getTask() {
        return this.zzfd.f4178a;
    }

    public final /* synthetic */ void zza(Exception exc) {
        zzj zzj;
        synchronized (this.zzfe.zzff) {
            if (this.zzfe.zzff.peek() == this) {
                this.zzfe.zzff.remove();
                this.zzfe.zzfg = 0;
                zzj = (zzj) this.zzfe.zzff.peek();
            } else {
                zzj = null;
            }
        }
        this.zzfd.a(exc);
        if (zzj != null) {
            zzj.execute();
        }
    }
}
