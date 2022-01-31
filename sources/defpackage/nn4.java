package defpackage;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* renamed from: nn4  reason: default package */
/* compiled from: ViewUtils */
public final class nn4 implements Runnable {
    public final /* synthetic */ View f;

    public nn4(View view) {
        this.f = view;
    }

    public void run() {
        ((InputMethodManager) this.f.getContext().getSystemService("input_method")).showSoftInput(this.f, 1);
    }
}
