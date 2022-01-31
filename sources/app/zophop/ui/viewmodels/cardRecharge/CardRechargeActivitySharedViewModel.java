package app.zophop.ui.viewmodels.cardRecharge;

import android.app.Application;
import android.content.Context;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.models.mTicketing.cardRecharge.CardProperties;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeInfo;
import app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentProperties;
import app.zophop.models.mTicketing.cardRecharge.CardRechargePaymentStatus;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeStatus;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeUIProperties;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRechargeOrderDetails;
import java.util.UUID;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* compiled from: CardRechargeActivitySharedViewModel.kt */
public final class CardRechargeActivitySharedViewModel extends lg {
    public final wh d;
    public final m66 e;
    public boolean f = true;
    public final String g;
    public String h;
    public boolean i;
    public long j;
    public final j56 k;
    public OnlineCardRechargeOrderDetails l;
    public String m;

    /* compiled from: CardRechargeActivitySharedViewModel.kt */
    public static final class a extends o86 implements h76<oh<CardRechargeConfiguration>> {
        public final /* synthetic */ CardRechargeActivitySharedViewModel f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(CardRechargeActivitySharedViewModel cardRechargeActivitySharedViewModel) {
            super(0);
            this.f = cardRechargeActivitySharedViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<CardRechargeConfiguration> invoke() {
            return this.f.d.a("keyCardRechargeConfiguration", null);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardRechargeActivitySharedViewModel(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        kb6 kb6 = xb6.b;
        int i2 = CoroutineExceptionHandler.d;
        this.e = kb6.plus(new lh1(CoroutineExceptionHandler.a.f));
        Object obj = whVar.f3779a.get("keySource");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<String>(KEY_SOURCE)!!");
        this.g = (String) obj;
        Long l2 = (Long) whVar.f3779a.get("keyRechargeLimit");
        if (l2 != null) {
            l2.longValue();
        }
        String str = (String) whVar.f3779a.get("keyCardNumber");
        this.h = str == null ? "" : str;
        Boolean bool = (Boolean) whVar.f3779a.get("keyIsCardRechargeHistoryFetched");
        this.i = bool == null ? false : bool.booleanValue();
        Long l3 = (Long) whVar.f3779a.get("keyRechargeAmount");
        this.j = l3 == null ? 0 : l3.longValue();
        this.k = hd3.a2(new a(this));
        this.l = (OnlineCardRechargeOrderDetails) whVar.f3779a.get("keyOnlineCardRechargeOrderDetails");
        this.m = new String();
    }

    public final void d(Context context) {
        n86.e(context, "lContext");
        this.d.b("keyIsUserLoggedIn", Boolean.TRUE);
        String uuid = UUID.randomUUID().toString();
        n86.d(uuid, "randomUUID().toString()");
        this.m = uuid;
        v60.c(uuid, context);
    }

    public final void e(Context context) {
        n86.e(context, "lContext");
        String uuid = UUID.randomUUID().toString();
        n86.d(uuid, "randomUUID().toString()");
        this.m = uuid;
        v60.c(uuid, context);
    }

    public final void onPaymentBtnClicked(CardRechargeConfiguration cardRechargeConfiguration, Context context) {
        n86.e(cardRechargeConfiguration, "lCardRechargeConfiguration");
        n86.e(context, "lContext");
        v60.b(this.h, this.j, cardRechargeConfiguration, context);
    }

    public final void onPaymentCompleted(CardRechargeConfiguration cardRechargeConfiguration, String str) {
        n86.e(cardRechargeConfiguration, "lCardRechargeConfiguration");
        n86.e(str, "lPaymentMode");
        OnlineCardRechargeOrderDetails onlineCardRechargeOrderDetails = this.l;
        n86.c(onlineCardRechargeOrderDetails);
        xt.f3961a.K().insertOnlineCardRecharge(new OnlineCardRecharge(new CardRechargePaymentProperties(onlineCardRechargeOrderDetails.getTransactionId(), str, ui1.Q(), new CardRechargeInfo(CardRechargePaymentStatus.SUCCESS, CardRechargeStatus.PENDING, this.j)), new CardRechargeUIProperties(cardRechargeConfiguration.getName(), cardRechargeConfiguration.getBranding(), cardRechargeConfiguration.getRechargeDelayCopy()), new CardProperties(this.h, cardRechargeConfiguration.getCity(), cardRechargeConfiguration.getAgency())));
    }
}
