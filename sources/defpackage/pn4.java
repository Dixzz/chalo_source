package defpackage;

import android.view.View;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: pn4  reason: default package */
/* compiled from: ViewUtils */
public final class pn4 implements View.OnAttachStateChangeListener {
    public void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        AtomicInteger atomicInteger = r8.f3055a;
        view.requestApplyInsets();
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
