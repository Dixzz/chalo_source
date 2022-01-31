package defpackage;

import android.content.Context;
import android.net.Uri;
import app.zophop.models.City;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.CardRechargeTransactionsFetchedEvent;
import app.zophop.pubsub.eventbus.events.CardValidityCheckEvent;
import app.zophop.pubsub.eventbus.events.OnlineCardRechargeOrderCreationEvent;
import com.google.firebase.appindexing.Indexable;
import com.razorpay.AnalyticsConstants;
import defpackage.n00;
import defpackage.ut;
import defpackage.xt;
import org.json.JSONObject;

/* renamed from: v60  reason: default package */
/* compiled from: OnlineCardRechargeApiHelper.kt */
public final class v60 {

    /* renamed from: v60$a */
    /* compiled from: OnlineCardRechargeApiHelper.kt */
    public static final class a implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3606a;
        public final /* synthetic */ CardRechargeConfiguration b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;

        public a(String str, CardRechargeConfiguration cardRechargeConfiguration, String str2, Context context) {
            this.f3606a = str;
            this.b = cardRechargeConfiguration;
            this.c = str2;
            this.d = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            jz5.b().i(new CardValidityCheckEvent(this.c, CardValidityCheckEvent.VALIDITY_CHECK_ERROR, str, 0, 8, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            v60.a(this.f3606a, this.b, this.c, this.d);
        }
    }

    /* renamed from: v60$b */
    /* compiled from: OnlineCardRechargeApiHelper.kt */
    public static final class b implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3607a;
        public final /* synthetic */ long b;
        public final /* synthetic */ CardRechargeConfiguration c;
        public final /* synthetic */ Context d;

        public b(String str, long j, CardRechargeConfiguration cardRechargeConfiguration, Context context) {
            this.f3607a = str;
            this.b = j;
            this.c = cardRechargeConfiguration;
            this.d = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            jz5.b().i(new OnlineCardRechargeOrderCreationEvent(ad1.FAILED, str, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            v60.b(this.f3607a, this.b, this.c, this.d);
        }
    }

    /* renamed from: v60$c */
    /* compiled from: OnlineCardRechargeApiHelper.kt */
    public static final class c implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3608a;
        public final /* synthetic */ Context b;

        public c(String str, Context context) {
            this.f3608a = str;
            this.b = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            jz5.b().i(new CardRechargeTransactionsFetchedEvent(this.f3608a, ad1.FAILED, str, null, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            v60.c(this.f3608a, this.b);
        }
    }

    public static final void a(String str, CardRechargeConfiguration cardRechargeConfiguration, String str2, Context context) {
        n86.e(str, "lCardNo");
        n86.e(cardRechargeConfiguration, "lCardRechargeConfiguration");
        n86.e(str2, "lRequestId");
        n86.e(context, "lContext");
        Uri.Builder encodedPath = new Uri.Builder().encodedPath(ut.i + "v1" + "/card/eligibility");
        ut.a aVar = ut.f3552a;
        String builder = encodedPath.appendQueryParameter("appVer", String.valueOf(764)).toString();
        n86.d(builder, "lUri.toString()");
        String city = cardRechargeConfiguration.getCity();
        String agency = cardRechargeConfiguration.getAgency();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("city", city);
        jSONObject.put("appVer", 764);
        xt.t1 t1Var = xt.f3961a;
        jSONObject.put("deviceId", t1Var.n().a());
        jSONObject.put("agency", agency);
        jSONObject.put(CardRechargeJsonKeys.CARD_NO, str);
        String jSONObject2 = jSONObject.toString();
        n86.d(jSONObject2, "lJsonObject.toString()");
        xj1 S = t1Var.S();
        e70 e70 = new e70(context, false, 1, builder, new l60(str2), new a(str, cardRechargeConfiguration, str2, context), jSONObject2);
        e70.q = new nj1(12000, 0, 1.0f);
        e70.n = false;
        S.a(e70);
    }

    public static final void b(String str, long j, CardRechargeConfiguration cardRechargeConfiguration, Context context) {
        n86.e(str, "lCardNo");
        n86.e(cardRechargeConfiguration, "lCardRechargeConfiguration");
        n86.e(context, "lContext");
        Uri.Builder encodedPath = new Uri.Builder().encodedPath(ut.i + "v1" + "/card/recharge");
        ut.a aVar = ut.f3552a;
        String builder = encodedPath.appendQueryParameter("appVer", String.valueOf(764)).toString();
        n86.d(builder, "lUri.toString()");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appVer", 764);
        xt.t1 t1Var = xt.f3961a;
        jSONObject.put("deviceId", t1Var.n().a());
        jSONObject.put(CardRechargeJsonKeys.CARD_NO, str);
        jSONObject.put("userId", t1Var.m0());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lpVer", "v1");
        jSONObject2.put("paymentType", "online");
        jSONObject.put("paymentProps", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put(SuperPassJsonKeys.CONFIGURATION_ID, cardRechargeConfiguration.getConfigId());
        jSONObject3.put(CardRechargeJsonKeys.CARD_NO, str);
        jSONObject3.put(AnalyticsConstants.AMOUNT, j);
        jSONObject.put("cardProps", jSONObject3);
        String jSONObject4 = jSONObject.toString();
        n86.d(jSONObject4, "lJsonObject.toString()");
        xj1 S = t1Var.S();
        e70 e70 = new e70(context, false, 1, builder, m60.f2330a, new b(str, j, cardRechargeConfiguration, context), jSONObject4);
        e70.q = new nj1(Indexable.MAX_STRING_LENGTH, 0, 1.0f);
        e70.n = false;
        S.a(e70);
    }

    public static final void c(String str, Context context) {
        n86.e(str, "lRequestId");
        n86.e(context, "lContext");
        StringBuilder sb = new StringBuilder(ut.i);
        sb.append("v1");
        sb.append("/cities/");
        xt.t1 t1Var = xt.f3961a;
        City d = t1Var.k().d();
        n86.c(d);
        String name = d.getName();
        n86.d(name, "DependencyFactory.cityProvider.currentCity!!.name");
        String lowerCase = name.toLowerCase();
        n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
        sb.append(lowerCase);
        sb.append("/card/transactions");
        Uri.Builder encodedPath = new Uri.Builder().encodedPath(sb.toString());
        ut.a aVar = ut.f3552a;
        String builder = encodedPath.appendQueryParameter("appVer", String.valueOf(764)).toString();
        n86.d(builder, "lUri.toString()");
        xj1 S = t1Var.S();
        e70 e70 = new e70(context, false, 0, builder, new k60(str), new c(str, context), "");
        e70.q = new nj1(12000, 5, 1.0f);
        e70.n = false;
        S.a(e70);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0113 A[Catch:{ JSONException -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0118 A[Catch:{ JSONException -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0151 A[Catch:{ JSONException -> 0x01d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x017b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void d(org.json.JSONObject r29) {
        /*
        // Method dump skipped, instructions count: 509
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v60.d(org.json.JSONObject):void");
    }
}
