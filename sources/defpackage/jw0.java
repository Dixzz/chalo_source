package defpackage;

import android.view.View;

/* renamed from: jw0  reason: default package */
/* compiled from: SoundFragment */
public class jw0 implements View.OnClickListener {
    public final /* synthetic */ lm0 f;
    public final /* synthetic */ hw0 g;

    public jw0(hw0 hw0, lm0 lm0) {
        this.g = hw0;
        this.f = lm0;
    }

    public void onClick(View view) {
        this.f.dismiss();
        hw0 hw0 = this.g;
        hw0.w = false;
        hw0.f();
    }
}
