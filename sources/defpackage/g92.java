package defpackage;

import android.content.Intent;

/* renamed from: g92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class g92 extends h92 {
    public final /* synthetic */ Intent f;
    public final /* synthetic */ s32 g;

    public g92(Intent intent, s32 s32) {
        this.f = intent;
        this.g = s32;
    }

    @Override // defpackage.h92
    public final void a() {
        Intent intent = this.f;
        if (intent != null) {
            this.g.startActivityForResult(intent, 2);
        }
    }
}
