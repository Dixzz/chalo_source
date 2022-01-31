package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;

/* renamed from: pc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class pc2 implements View.OnClickListener {
    public final /* synthetic */ Context f;
    public final /* synthetic */ Intent g;

    public pc2(Context context, Intent intent) {
        this.f = context;
        this.g = intent;
    }

    public final void onClick(View view) {
        try {
            this.f.startActivity(this.g);
        } catch (ActivityNotFoundException unused) {
        }
    }
}
