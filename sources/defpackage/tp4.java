package defpackage;

import android.widget.AutoCompleteTextView;

/* renamed from: tp4  reason: default package */
/* compiled from: DropdownMenuEndIconDelegate */
public class tp4 implements AutoCompleteTextView.OnDismissListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ qp4 f3390a;

    public tp4(qp4 qp4) {
        this.f3390a = qp4;
    }

    public void onDismiss() {
        qp4 qp4 = this.f3390a;
        qp4.i = true;
        qp4.k = System.currentTimeMillis();
        qp4.g(this.f3390a, false);
    }
}
