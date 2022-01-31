package defpackage;

import android.app.Activity;
import android.content.Intent;

/* renamed from: e92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class e92 extends h92 {
    public final /* synthetic */ Intent f;
    public final /* synthetic */ Activity g;
    public final /* synthetic */ int h;

    public e92(Intent intent, Activity activity, int i) {
        this.f = intent;
        this.g = activity;
        this.h = i;
    }

    @Override // defpackage.h92
    public final void a() {
        Intent intent = this.f;
        if (intent != null) {
            this.g.startActivityForResult(intent, this.h);
        }
    }
}
