package defpackage;

import android.view.View;
import java.util.Objects;

/* renamed from: lw0  reason: default package */
/* compiled from: SoundFragment */
public class lw0 implements View.OnClickListener {
    public final /* synthetic */ lm0 f;
    public final /* synthetic */ hw0 g;

    public lw0(hw0 hw0, lm0 lm0) {
        this.g = hw0;
        this.f = lm0;
    }

    public void onClick(View view) {
        Objects.requireNonNull(this.g);
        n86.e("sound qr show barcode cancel clicked", "lName");
        n86.e("sound fragment", "lSource");
        ed1 ed1 = new ed1("sound qr show barcode cancel clicked", Long.MIN_VALUE);
        ed1.a("source", "sound fragment");
        ui1.m0(ed1);
        this.f.dismiss();
    }
}
