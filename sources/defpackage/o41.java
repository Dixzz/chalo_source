package defpackage;

import android.widget.TextView;
import app.zophop.R;
import app.zophop.ui.fragments.superpassPurchase.ConfirmSuperPassPurchaseFragment;

/* renamed from: o41  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class o41 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ConfirmSuperPassPurchaseFragment f2650a;

    public /* synthetic */ o41(ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment) {
        this.f2650a = confirmSuperPassPurchaseFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ConfirmSuperPassPurchaseFragment confirmSuperPassPurchaseFragment = this.f2650a;
        Long l = (Long) obj;
        int i = ConfirmSuperPassPurchaseFragment.k;
        n86.e(confirmSuperPassPurchaseFragment, "this$0");
        T t = confirmSuperPassPurchaseFragment.f;
        n86.c(t);
        TextView textView = ((lx) t).i;
        StringBuilder sb = new StringBuilder();
        sb.append(confirmSuperPassPurchaseFragment.getString(R.string.start_date));
        sb.append(' ');
        n86.d(l, "lPassStartTime");
        sb.append((Object) jh1.d(l.longValue()));
        textView.setText(sb.toString());
    }
}
