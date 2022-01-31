package defpackage;

import app.zophop.pubsub.eventbus.events.CardRechargeTransactionsFetchedEvent;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;

@y66(c = "app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel$processTransactionsFetch$1", f = "CardRechargeActivitySharedViewModel.kt", l = {103, 104}, m = "invokeSuspend")
/* renamed from: l91  reason: default package */
/* compiled from: CardRechargeActivitySharedViewModel.kt */
public final class l91 extends b76 implements w76<mb6, k66<? super s56>, Object> {
    public Object f;
    public int g;
    public final /* synthetic */ CardRechargeActivitySharedViewModel h;
    public final /* synthetic */ CardRechargeTransactionsFetchedEvent i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l91(CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel, CardRechargeTransactionsFetchedEvent cardRechargeTransactionsFetchedEvent, k66<? super l91> k66) {
        super(2, k66);
        this.h = cardRechargeActivitySharedViewModel;
        this.i = cardRechargeTransactionsFetchedEvent;
    }

    @Override // defpackage.u66
    public final k66<s56> create(Object obj, k66<?> k66) {
        return new l91(this.h, this.i, k66);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // defpackage.w76
    public Object invoke(mb6 mb6, k66<? super s56> k66) {
        return new l91(this.h, this.i, k66).invokeSuspend(s56.f3190a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x008e  */
    @Override // defpackage.u66
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.l91.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
