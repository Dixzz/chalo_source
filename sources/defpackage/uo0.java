package defpackage;

import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.fragments.ConfirmMPassPurchaseFragment;

/* renamed from: uo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class uo0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmMPassPurchaseFragment f3531a;

    public /* synthetic */ uo0(ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment) {
        this.f3531a = confirmMPassPurchaseFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ConfirmMPassPurchaseFragment confirmMPassPurchaseFragment = this.f3531a;
        Long l = (Long) obj;
        int i = ConfirmMPassPurchaseFragment.k;
        n86.e(confirmMPassPurchaseFragment, "this$0");
        T t = confirmMPassPurchaseFragment.f;
        n86.c(t);
        TextView textView = ((kx) t).n;
        StringBuilder sb = new StringBuilder();
        sb.append(confirmMPassPurchaseFragment.getString(R.string.start_date));
        sb.append(' ');
        n86.d(l, "lPassStartTime");
        sb.append((Object) jh1.d(l.longValue()));
        textView.setText(sb.toString());
    }
}
