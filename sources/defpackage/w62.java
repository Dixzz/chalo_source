package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.ProgressBar;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import java.util.Objects;

/* renamed from: w62  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class w62 implements Runnable {
    public final u62 f;
    public final /* synthetic */ x62 g;

    public w62(x62 x62, u62 u62) {
        this.g = x62;
        this.f = u62;
    }

    public final void run() {
        if (this.g.g) {
            ConnectionResult connectionResult = this.f.b;
            if (connectionResult.l1()) {
                x62 x62 = this.g;
                s32 s32 = x62.f;
                Activity b = x62.b();
                PendingIntent pendingIntent = connectionResult.h;
                Objects.requireNonNull(pendingIntent, "null reference");
                int i = this.f.f3461a;
                int i2 = GoogleApiActivity.g;
                Intent intent = new Intent(b, GoogleApiActivity.class);
                intent.putExtra("pending_intent", pendingIntent);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", false);
                s32.startActivityForResult(intent, 1);
                return;
            }
            x62 x622 = this.g;
            if (x622.j.a(x622.b(), connectionResult.g, null) != null) {
                x62 x623 = this.g;
                q22 q22 = x623.j;
                Activity b2 = x623.b();
                x62 x624 = this.g;
                q22.g(b2, x624.f, connectionResult.g, x624);
            } else if (connectionResult.g == 18) {
                x62 x625 = this.g;
                q22 q222 = x625.j;
                Activity b3 = x625.b();
                x62 x626 = this.g;
                Objects.requireNonNull(q222);
                ProgressBar progressBar = new ProgressBar(b3, null, 16842874);
                progressBar.setIndeterminate(true);
                progressBar.setVisibility(0);
                AlertDialog.Builder builder = new AlertDialog.Builder(b3);
                builder.setView(progressBar);
                builder.setMessage(d92.b(b3, 18));
                builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
                AlertDialog create = builder.create();
                q222.k(b3, create, "GooglePlayServicesUpdatingDialog", x626);
                x62 x627 = this.g;
                x627.j.i(x627.b().getApplicationContext(), new v62(this, create));
            } else {
                x62 x628 = this.g;
                int i3 = this.f.f3461a;
                x628.h.set(null);
                x628.l(connectionResult, i3);
            }
        }
    }
}
