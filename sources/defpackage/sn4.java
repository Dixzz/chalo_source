package defpackage;

import android.annotation.SuppressLint;
import android.widget.ImageButton;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: sn4  reason: default package */
/* compiled from: VisibilityAwareImageButton */
public class sn4 extends ImageButton {
    public int f;

    public final void b(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f = i;
        }
    }

    public final int getUserSetVisibility() {
        return this.f;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f = i;
    }
}
