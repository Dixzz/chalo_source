package defpackage;

import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;
import app.zophop.ui.views.ZophopFormInput;

/* renamed from: sx0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class sx0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardDetailsFragment f3274a;

    public /* synthetic */ sx0(CardDetailsFragment cardDetailsFragment) {
        this.f3274a = cardDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CardDetailsFragment cardDetailsFragment = this.f3274a;
        Boolean bool = (Boolean) obj;
        int i = CardDetailsFragment.l;
        n86.e(cardDetailsFragment, "this$0");
        T t = cardDetailsFragment.f;
        n86.c(t);
        ZophopFormInput zophopFormInput = ((hx) t).h;
        n86.d(bool, "lIsEnteredCardNoOk");
        zophopFormInput.setEditable(bool.booleanValue());
        T t2 = cardDetailsFragment.f;
        n86.c(t2);
        ((hx) t2).h.setClickable(bool.booleanValue());
        T t3 = cardDetailsFragment.f;
        n86.c(t3);
        ((hx) t3).b.setAlpha(0.4f);
        T t4 = cardDetailsFragment.f;
        n86.c(t4);
        ((hx) t4).b.setEnabled(false);
        if (bool.booleanValue()) {
            T t5 = cardDetailsFragment.f;
            n86.c(t5);
            ((hx) t5).h.callOnClick();
        }
    }
}
