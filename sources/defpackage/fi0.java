package defpackage;

import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentProperties;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import app.zophop.ui.activities.cardRecharge.OnlineCardRechargeSummaryActivity;

/* renamed from: fi0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fi0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OnlineCardRechargeSummaryActivity f1126a;

    public /* synthetic */ fi0(OnlineCardRechargeSummaryActivity onlineCardRechargeSummaryActivity) {
        this.f1126a = onlineCardRechargeSummaryActivity;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        OnlineCardRechargeSummaryActivity onlineCardRechargeSummaryActivity = this.f1126a;
        OnlineCardRecharge onlineCardRecharge = (OnlineCardRecharge) obj;
        int i = OnlineCardRechargeSummaryActivity.l;
        n86.e(onlineCardRechargeSummaryActivity, "this$0");
        n86.d(onlineCardRecharge, "lOnlineCardRecharge");
        int ordinal = onlineCardRecharge.getCardRechargePaymentProperties().getCardRechargeInfo().getPaymentStatus().ordinal();
        if (ordinal == 0) {
            ew ewVar = (ew) onlineCardRechargeSummaryActivity.f0();
            hj1.G0(onlineCardRechargeSummaryActivity, R.drawable.card_recharge_pending, ewVar.k);
            hj1.H0(onlineCardRechargeSummaryActivity, R.string.processing, ewVar.l);
            TextView textView = ewVar.j;
            n86.d(textView, CardRechargeJsonKeys.RECHARGE_INFO);
            textView.setVisibility(8);
        } else if (ordinal == 1) {
            int ordinal2 = onlineCardRecharge.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeStatus().ordinal();
            if (ordinal2 == 0) {
                ew ewVar2 = (ew) onlineCardRechargeSummaryActivity.f0();
                hj1.G0(onlineCardRechargeSummaryActivity, R.drawable.card_recharge_pending, ewVar2.k);
                hj1.H0(onlineCardRechargeSummaryActivity, R.string.recharge_pending_title, ewVar2.l);
                TextView textView2 = ewVar2.j;
                n86.d(textView2, CardRechargeJsonKeys.RECHARGE_INFO);
                textView2.setVisibility(0);
                hj1.H0(onlineCardRechargeSummaryActivity, R.string.recharge_pending_copy, ewVar2.j);
            } else if (ordinal2 == 1) {
                ew ewVar3 = (ew) onlineCardRechargeSummaryActivity.f0();
                hj1.G0(onlineCardRechargeSummaryActivity, R.drawable.card_recharge_success, ewVar3.k);
                hj1.H0(onlineCardRechargeSummaryActivity, R.string.recharge_success_title, ewVar3.l);
                TextView textView3 = ewVar3.j;
                n86.d(textView3, CardRechargeJsonKeys.RECHARGE_INFO);
                textView3.setVisibility(0);
                hj1.H0(onlineCardRechargeSummaryActivity, R.string.recharge_success_copy, ewVar3.j);
            } else if (ordinal2 == 2) {
                ew ewVar4 = (ew) onlineCardRechargeSummaryActivity.f0();
                hj1.G0(onlineCardRechargeSummaryActivity, R.drawable.card_payment_failed, ewVar4.k);
                hj1.H0(onlineCardRechargeSummaryActivity, R.string.recharge_failed_title, ewVar4.l);
                TextView textView4 = ewVar4.j;
                n86.d(textView4, CardRechargeJsonKeys.RECHARGE_INFO);
                textView4.setVisibility(8);
            }
        } else if (ordinal == 2) {
            ew ewVar5 = (ew) onlineCardRechargeSummaryActivity.f0();
            hj1.G0(onlineCardRechargeSummaryActivity, R.drawable.card_payment_failed, ewVar5.k);
            hj1.H0(onlineCardRechargeSummaryActivity, R.string.failed, ewVar5.l);
            TextView textView5 = ewVar5.j;
            n86.d(textView5, CardRechargeJsonKeys.RECHARGE_INFO);
            textView5.setVisibility(8);
        }
        ((ew) onlineCardRechargeSummaryActivity.f0()).e.setText(f71.b(f71.f1097a, onlineCardRecharge.getCardProperties().getCardNo(), 0, 2));
        String string = onlineCardRechargeSummaryActivity.getString(R.string.card_recharge_confirmation_subtitle);
        n86.d(string, "getString(R.string.card_…ge_confirmation_subtitle)");
        wh1 wh1 = wh1.f3781a;
        ((ew) onlineCardRechargeSummaryActivity.f0()).i.setText(hj1.e0(new Object[]{wh1.a(wh1, onlineCardRecharge.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeAmount(), 0, 2)}, 1, string, "java.lang.String.format(format, *args)"));
        long rechargeAmount = onlineCardRecharge.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeAmount();
        ((ew) onlineCardRechargeSummaryActivity.f0()).n.setText(wh1.a(wh1, rechargeAmount, 0, 2));
        bx b = bx.b(onlineCardRechargeSummaryActivity.getLayoutInflater());
        n86.d(b, "inflate(layoutInflater)");
        b.c.setText(onlineCardRechargeSummaryActivity.getString(R.string.top_up_amount));
        b.b.setText(wh1.a(wh1, rechargeAmount, 0, 2));
        ((ew) onlineCardRechargeSummaryActivity.f0()).f.addView(b.f485a);
        ((ew) onlineCardRechargeSummaryActivity.f0()).g.setOnClickListener(new di0(onlineCardRechargeSummaryActivity));
        CardRechargePaymentProperties cardRechargePaymentProperties = onlineCardRecharge.getCardRechargePaymentProperties();
        ((ew) onlineCardRechargeSummaryActivity.f0()).b.setText(jh1.d(cardRechargePaymentProperties.getPaymentTime()));
        ((ew) onlineCardRechargeSummaryActivity.f0()).c.setText(cardRechargePaymentProperties.getTransactionId());
        ((ew) onlineCardRechargeSummaryActivity.f0()).h.setText(cardRechargePaymentProperties.getPaymentMode());
        ed1 ed1 = new ed1("ocr payment summary activity open", Long.MIN_VALUE);
        q91 q91 = onlineCardRechargeSummaryActivity.k;
        if (q91 != null) {
            ed1.a("source", q91.f);
            gi1.f1265a.a(ed1, onlineCardRecharge);
            ui1.m0(ed1);
            return;
        }
        n86.l("viewModel");
        throw null;
    }
}
