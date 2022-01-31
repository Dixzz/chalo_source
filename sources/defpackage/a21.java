package defpackage;

import android.view.View;
import app.zophop.ui.fragments.superPassValidation.SoundFragmentSuperPass;

/* renamed from: a21  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class a21 implements View.OnClickListener {
    public final /* synthetic */ hm0 f;

    public /* synthetic */ a21(hm0 hm0) {
        this.f = hm0;
    }

    public final void onClick(View view) {
        hm0 hm0 = this.f;
        SoundFragmentSuperPass.a aVar = SoundFragmentSuperPass.j;
        hj1.R0("sound qr show barcode cancel clicked", "lName", "sound fragment", "lSource", "sound qr show barcode cancel clicked", Long.MIN_VALUE, "source", "sound fragment");
        hm0.dismiss();
    }
}
