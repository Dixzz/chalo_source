package defpackage;

import android.app.PendingIntent;
import android.content.IntentSender;
import com.google.android.gms.common.ConnectionResult;
import defpackage.a32;
import java.util.Objects;

/* renamed from: xg1  reason: default package */
/* compiled from: LocationEnableHelper */
public class xg1 implements a32.c {
    public final /* synthetic */ ah1 f;

    public xg1(ah1 ah1) {
        this.f = ah1;
    }

    @Override // defpackage.w32
    public void F(ConnectionResult connectionResult) {
        if (this.f.d) {
            return;
        }
        if (connectionResult.l1()) {
            try {
                ah1 ah1 = this.f;
                ah1.d = true;
                ve veVar = ah1.f164a;
                if (connectionResult.l1()) {
                    PendingIntent pendingIntent = connectionResult.h;
                    Objects.requireNonNull(pendingIntent, "null reference");
                    veVar.startIntentSenderForResult(pendingIntent.getIntentSender(), 100, null, 0, 0, 0);
                }
            } catch (IntentSender.SendIntentException unused) {
                this.f.d = false;
            }
        } else {
            int i = connectionResult.g;
            ah1 ah12 = this.f;
            Objects.requireNonNull(ah12);
            Object obj = q22.c;
            q22.d.d(ah12.f164a, i, 99, null).show();
        }
    }
}
