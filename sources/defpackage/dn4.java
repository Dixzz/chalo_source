package defpackage;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.material.internal.CheckableImageButton;

/* renamed from: dn4  reason: default package */
/* compiled from: CheckableImageButton */
public class dn4 extends z7 {
    public final /* synthetic */ CheckableImageButton d;

    public dn4(CheckableImageButton checkableImageButton) {
        this.d = checkableImageButton;
    }

    @Override // defpackage.z7
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f4141a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setChecked(this.d.isChecked());
    }

    @Override // defpackage.z7
    public void d(View view, e9 e9Var) {
        this.f4141a.onInitializeAccessibilityNodeInfo(view, e9Var.f942a);
        e9Var.f942a.setCheckable(this.d.g);
        e9Var.f942a.setChecked(this.d.isChecked());
    }
}
