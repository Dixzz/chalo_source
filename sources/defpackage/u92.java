package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* renamed from: u92  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public abstract class u92 extends ea2<Boolean> {
    public final int d;
    public final Bundle e;
    public final /* synthetic */ w72 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u92(w72 w72, int i, Bundle bundle) {
        super(w72, Boolean.TRUE);
        this.f = w72;
        this.d = i;
        this.e = bundle;
    }

    @Override // defpackage.ea2
    public final void a() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ea2
    public final /* bridge */ /* synthetic */ void b(Boolean bool) {
        ConnectionResult connectionResult;
        PendingIntent pendingIntent = null;
        if (this.d != 0) {
            this.f.zzp(1, null);
            Bundle bundle = this.e;
            if (bundle != null) {
                pendingIntent = (PendingIntent) bundle.getParcelable(w72.KEY_PENDING_INTENT);
            }
            connectionResult = new ConnectionResult(this.d, pendingIntent);
        } else if (!d()) {
            this.f.zzp(1, null);
            connectionResult = new ConnectionResult(8, null);
        } else {
            return;
        }
        e(connectionResult);
    }

    public abstract boolean d();

    public abstract void e(ConnectionResult connectionResult);
}
