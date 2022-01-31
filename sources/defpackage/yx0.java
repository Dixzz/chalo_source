package defpackage;

import android.widget.TextView;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;

/* renamed from: yx0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class yx0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardDetailsFragment f4095a;

    public /* synthetic */ yx0(CardDetailsFragment cardDetailsFragment) {
        this.f4095a = cardDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CardDetailsFragment cardDetailsFragment = this.f4095a;
        String str = (String) obj;
        int i = CardDetailsFragment.l;
        n86.e(cardDetailsFragment, "this$0");
        n86.d(str, "lErrorMessage");
        if (str.length() > 0) {
            T t = cardDetailsFragment.f;
            n86.c(t);
            TextView textView = ((hx) t).g;
            n86.d(textView, "viewBinding.errorText");
            textView.setVisibility(0);
            T t2 = cardDetailsFragment.f;
            n86.c(t2);
            ((hx) t2).g.setText(str);
            T t3 = cardDetailsFragment.f;
            n86.c(t3);
            ((hx) t3).h.setText("");
        }
    }
}
