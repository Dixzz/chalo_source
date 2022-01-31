package defpackage;

import android.content.Intent;
import androidx.fragment.app.Fragment;

/* renamed from: f92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class f92 extends h92 {
    public final /* synthetic */ Intent f;
    public final /* synthetic */ Fragment g;
    public final /* synthetic */ int h;

    public f92(Intent intent, Fragment fragment, int i) {
        this.f = intent;
        this.g = fragment;
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
