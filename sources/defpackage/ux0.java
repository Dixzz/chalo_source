package defpackage;

import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;

/* renamed from: ux0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ux0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardDetailsFragment f3565a;

    public /* synthetic */ ux0(CardDetailsFragment cardDetailsFragment) {
        this.f3565a = cardDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CardDetailsFragment cardDetailsFragment = this.f3565a;
        Boolean bool = (Boolean) obj;
        int i = CardDetailsFragment.l;
        n86.e(cardDetailsFragment, "this$0");
        n86.d(bool, "lIsReEnteredCardNoOk");
        if (bool.booleanValue()) {
            T t = cardDetailsFragment.f;
            n86.c(t);
            ((hx) t).b.setAlpha(1.0f);
            T t2 = cardDetailsFragment.f;
            n86.c(t2);
            ((hx) t2).b.setEnabled(true);
            return;
        }
        T t3 = cardDetailsFragment.f;
        n86.c(t3);
        ((hx) t3).b.setAlpha(0.4f);
        T t4 = cardDetailsFragment.f;
        n86.c(t4);
        ((hx) t4).b.setEnabled(false);
    }
}
