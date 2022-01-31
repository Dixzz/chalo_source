package defpackage;

import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;
import app.zophop.ui.viewmodels.cardRecharge.CardRechargeActivitySharedViewModel;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* renamed from: hy0  reason: default package */
/* compiled from: CardDetailsFragment.kt */
public final class hy0 extends o86 implements s76<OnlineCardRecharge, s56> {
    public final /* synthetic */ CardDetailsFragment f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hy0(CardDetailsFragment cardDetailsFragment) {
        super(1);
        this.f = cardDetailsFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.s76
    public s56 invoke(OnlineCardRecharge onlineCardRecharge) {
        OnlineCardRecharge onlineCardRecharge2 = onlineCardRecharge;
        n86.e(onlineCardRecharge2, "lOnlineCardRecharge");
        CardDetailsFragment cardDetailsFragment = this.f;
        String cardNo = onlineCardRecharge2.getCardProperties().getCardNo();
        String transactionId = onlineCardRecharge2.getCardRechargePaymentProperties().getTransactionId();
        int i = CardDetailsFragment.l;
        Objects.requireNonNull(cardDetailsFragment);
        ed1 ed1 = new ed1("ocr cardDetails recent payment clicked", Long.MIN_VALUE);
        ed1.a(CardRechargeJsonKeys.CARD_NO, cardNo);
        ed1.a("transaction id", transactionId);
        ed1.a("source", "sourceCardDetailsScreen");
        ui1.m0(ed1);
        CardDetailsFragment cardDetailsFragment2 = this.f;
        if (cardDetailsFragment2.c() != null) {
            CardRechargeActivitySharedViewModel i2 = cardDetailsFragment2.i();
            String cardNo2 = onlineCardRecharge2.getCardProperties().getCardNo();
            Objects.requireNonNull(i2);
            n86.e(cardNo2, FirebaseAnalytics.Param.VALUE);
            i2.h = cardNo2;
            i2.d.b("keyCardNumber", cardNo2);
            CardRechargeActivitySharedViewModel i3 = cardDetailsFragment2.i();
            long rechargeAmount = onlineCardRecharge2.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeAmount();
            i3.j = rechargeAmount;
            i3.d.b("keyRechargeAmount", Long.valueOf(rechargeAmount));
            ny0 ny0 = new ny0(cardDetailsFragment2.j().f, onlineCardRecharge2.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeAmount(), onlineCardRecharge2.getCardProperties().getCardNo(), null);
            n86.d(ny0, "actionCardDetailsFragmen…operties.cardNo\n        )");
            vh1 vh1 = vh1.f3649a;
            n86.f(cardDetailsFragment2, "$this$findNavController");
            NavController d = NavHostFragment.d(cardDetailsFragment2);
            n86.b(d, "NavHostFragment.findNavController(this)");
            vh1.a(d, ny0);
        }
        return s56.f3190a;
    }
}
