package defpackage;

import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.ui.fragments.cardRecharge.CardRechargeAmountFragment;
import defpackage.zu;
import java.util.Objects;

/* renamed from: oy0  reason: default package */
/* compiled from: CardRechargeAmountFragment.kt */
public final class oy0 implements zu.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardRechargeAmountFragment f2742a;

    public oy0(CardRechargeAmountFragment cardRechargeAmountFragment) {
        this.f2742a = cardRechargeAmountFragment;
    }

    @Override // defpackage.zu.a
    public void a(long j) {
        CardRechargeAmountFragment cardRechargeAmountFragment = this.f2742a;
        int i = CardRechargeAmountFragment.j;
        Objects.requireNonNull(cardRechargeAmountFragment);
        ed1 ed1 = new ed1("ocr suggested amount clicked", Long.MIN_VALUE);
        ed1.a("rechargeAmount", Long.valueOf(j));
        ed1.a(CardRechargeJsonKeys.CARD_NO, cardRechargeAmountFragment.j().g);
        ui1.m0(ed1);
        String a2 = wh1.a(wh1.f3781a, j, 0, 2);
        T t = this.f2742a.f;
        n86.c(t);
        ((ix) t).d.setText(a2);
        this.f2742a.j().e(a2);
    }
}
