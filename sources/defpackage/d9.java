package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* renamed from: d9  reason: default package */
/* compiled from: AccessibilityClickableSpanCompat */
public final class d9 extends ClickableSpan {
    public final int f;
    public final e9 g;
    public final int h;

    public d9(int i, e9 e9Var, int i2) {
        this.f = i;
        this.g = e9Var;
        this.h = i2;
    }

    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f);
        e9 e9Var = this.g;
        e9Var.f942a.performAction(this.h, bundle);
    }
}
