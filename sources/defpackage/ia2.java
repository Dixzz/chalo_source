package defpackage;

import com.google.android.gms.common.ConnectionResult;

/* renamed from: ia2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class ia2 extends u92 {
    public final /* synthetic */ w72 g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ia2(w72 w72, int i) {
        super(w72, i, null);
        this.g = w72;
    }

    @Override // defpackage.u92
    public final boolean d() {
        this.g.zzc.a(ConnectionResult.j);
        return true;
    }

    @Override // defpackage.u92
    public final void e(ConnectionResult connectionResult) {
        if (!this.g.enableLocalFallback() || !w72.zzg(this.g)) {
            this.g.zzc.a(connectionResult);
            this.g.onConnectionFailed(connectionResult);
            return;
        }
        w72.zzc(this.g, 16);
    }
}
