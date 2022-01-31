package defpackage;

import android.widget.TextView;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;

/* renamed from: vx0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class vx0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardDetailsFragment f3689a;

    public /* synthetic */ vx0(CardDetailsFragment cardDetailsFragment) {
        this.f3689a = cardDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CardDetailsFragment cardDetailsFragment = this.f3689a;
        Boolean bool = (Boolean) obj;
        int i = CardDetailsFragment.l;
        n86.e(cardDetailsFragment, "this$0");
        T t = cardDetailsFragment.f;
        n86.c(t);
        TextView textView = ((hx) t).d;
        n86.d(textView, "viewBinding.cardNoCheckErrorText");
        n86.d(bool, "lShouldShow");
        textView.setVisibility(bool.booleanValue() ? 0 : 8);
    }
}
