package defpackage;

import android.view.MotionEvent;
import android.view.View;
import android.widget.AutoCompleteTextView;

/* renamed from: sp4  reason: default package */
/* compiled from: DropdownMenuEndIconDelegate */
public class sp4 implements View.OnTouchListener {
    public final /* synthetic */ AutoCompleteTextView f;
    public final /* synthetic */ qp4 g;

    public sp4(qp4 qp4, AutoCompleteTextView autoCompleteTextView) {
        this.g = qp4;
        this.f = autoCompleteTextView;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.g.j()) {
                this.g.i = false;
            }
            qp4.h(this.g, this.f);
        }
        return false;
    }
}
