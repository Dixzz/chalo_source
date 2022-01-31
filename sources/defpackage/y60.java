package defpackage;

import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.pubsub.eventbus.events.CashPaymentInfoFetchedEvent;
import app.zophop.pubsub.eventbus.events.SuperPassApplicationSubmissionEvent;
import app.zophop.pubsub.eventbus.events.SuperPassOrderCreationEvent;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import defpackage.n00;
import defpackage.ut;
import defpackage.xt;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: y60  reason: default package */
/* compiled from: SuperPassPurchaseApiHelper.kt */
public final class y60 {

    /* renamed from: y60$a */
    /* compiled from: SuperPassPurchaseApiHelper.kt */
    public static final class a implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SuperPassUserDetails f4006a;
        public final /* synthetic */ BookableSuperPassConfiguration b;
        public final /* synthetic */ String c;
        public final /* synthetic */ long d;
        public final /* synthetic */ Context e;

        public a(SuperPassUserDetails superPassUserDetails, BookableSuperPassConfiguration bookableSuperPassConfiguration, String str, long j, Context context) {
            this.f4006a = superPassUserDetails;
            this.b = bookableSuperPassConfiguration;
            this.c = str;
            this.d = j;
            this.e = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            jz5.b().i(new SuperPassOrderCreationEvent(ad1.FAILED, str, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            y60.e(this.f4006a, this.b, this.c, this.d, this.e);
        }
    }

    /* renamed from: y60$b */
    /* compiled from: SuperPassPurchaseApiHelper.kt */
    public static final class b implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SuperPassUserDetails f4007a;
        public final /* synthetic */ BookableSuperPassConfiguration b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Context d;

        public b(SuperPassUserDetails superPassUserDetails, BookableSuperPassConfiguration bookableSuperPassConfiguration, long j, Context context) {
            this.f4007a = superPassUserDetails;
            this.b = bookableSuperPassConfiguration;
            this.c = j;
            this.d = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            jz5.b().i(new SuperPassOrderCreationEvent(ad1.FAILED, str, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            y60.f(this.f4007a, this.b, this.c, this.d);
        }
    }

    /* renamed from: y60$c */
    /* compiled from: SuperPassPurchaseApiHelper.kt */
    public static final class c implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SuperPassUserDetails f4008a;
        public final /* synthetic */ BookableSuperPassConfiguration b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Map<String, String> d;
        public final /* synthetic */ Context e;

        public c(SuperPassUserDetails superPassUserDetails, BookableSuperPassConfiguration bookableSuperPassConfiguration, long j, Map<String, String> map, Context context) {
            this.f4008a = superPassUserDetails;
            this.b = bookableSuperPassConfiguration;
            this.c = j;
            this.d = map;
            this.e = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            jz5.b().i(new SuperPassOrderCreationEvent(ad1.FAILED, str, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            y60.g(this.f4008a, this.b, this.c, this.d, this.e);
        }
    }

    /* renamed from: y60$d */
    /* compiled from: SuperPassPurchaseApiHelper.kt */
    public static final class d implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4009a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Context c;

        public d(String str, String str2, Context context) {
            this.f4009a = str;
            this.b = str2;
            this.c = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            jz5.b().i(new CashPaymentInfoFetchedEvent(null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, ad1.FAILED, str, 7, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            y60.h(this.f4009a, this.b, this.c);
        }
    }

    /* renamed from: y60$e */
    /* compiled from: SuperPassPurchaseApiHelper.kt */
    public static final class e implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SuperPassUserDetails f4010a;
        public final /* synthetic */ BookableSuperPassConfiguration b;
        public final /* synthetic */ long c;
        public final /* synthetic */ Map<String, String> d;
        public final /* synthetic */ Context e;

        public e(SuperPassUserDetails superPassUserDetails, BookableSuperPassConfiguration bookableSuperPassConfiguration, long j, Map<String, String> map, Context context) {
            this.f4010a = superPassUserDetails;
            this.b = bookableSuperPassConfiguration;
            this.c = j;
            this.d = map;
            this.e = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            jz5.b().g(new SuperPassApplicationSubmissionEvent(ad1.FAILED, str));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            y60.l(this.f4010a, this.b, this.c, this.d, this.e);
        }
    }

    public static final void a(JSONObject jSONObject, long j, BookableSuperPassConfiguration bookableSuperPassConfiguration) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(SuperPassJsonKeys.PASS_START_DATE, j);
        jSONObject2.put(SuperPassJsonKeys.CATEGORY_ID, bookableSuperPassConfiguration.getSelectedProductCategory().getCategoryId());
        jSONObject2.put(SuperPassJsonKeys.FARE_MAPPING_ID, bookableSuperPassConfiguration.getSelectedProductFareMapping().getFareMappingId());
        jSONObject2.put(SuperPassJsonKeys.CONFIGURATION_ID, bookableSuperPassConfiguration.getConfigId());
        jSONObject2.put(SuperPassJsonKeys.PASS_FARE, bookableSuperPassConfiguration.getSelectedProductFareMapping().getFareInfo().getPayableAmount());
        jSONObject.put("passProps", jSONObject2);
    }

    public static final void b(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lpVer", "v1");
        jSONObject2.put("paymentType", "online");
        jSONObject.put("paymentProps", jSONObject2);
    }

    public static final void c(JSONObject jSONObject, Map<String, String> map) {
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject2.put(entry.getKey(), entry.getValue());
        }
        jSONObject.put(SuperPassJsonKeys.PROOFS, jSONObject2);
    }

    public static final void d(JSONObject jSONObject, SuperPassUserDetails superPassUserDetails) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(SuperPassJsonKeys.MAIL_ID, superPassUserDetails.getEmailId());
        jSONObject2.put(SuperPassJsonKeys.MOBILE_NUMBER, superPassUserDetails.getMobileNumber());
        jSONObject2.put("userName", superPassUserDetails.getFullName());
        jSONObject2.put(SuperPassJsonKeys.GENDER, superPassUserDetails.getGender().toString());
        jSONObject2.put(SuperPassJsonKeys.DATE_OF_BIRTH, superPassUserDetails.getDateOfBirth());
        jSONObject2.put("userId", superPassUserDetails.getUserId());
        jSONObject.put("userDetails", jSONObject2);
    }

    public static final void e(SuperPassUserDetails superPassUserDetails, BookableSuperPassConfiguration bookableSuperPassConfiguration, String str, long j, Context context) {
        n86.e(superPassUserDetails, "lSuperPassUserDetails");
        n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
        n86.e(str, "lPassId");
        n86.e(context, "lContext");
        String j2 = j();
        JSONObject i = i();
        b(i);
        d(i, superPassUserDetails);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(SuperPassJsonKeys.PASS_START_DATE, j);
        jSONObject.put(SuperPassJsonKeys.CATEGORY_ID, bookableSuperPassConfiguration.getSelectedProductCategory().getCategoryId());
        jSONObject.put(SuperPassJsonKeys.FARE_MAPPING_ID, bookableSuperPassConfiguration.getSelectedProductFareMapping().getFareMappingId());
        jSONObject.put(SuperPassJsonKeys.CONFIGURATION_ID, bookableSuperPassConfiguration.getConfigId());
        jSONObject.put(SuperPassJsonKeys.PASS_FARE, bookableSuperPassConfiguration.getSelectedProductFareMapping().getFareInfo().getPayableAmount());
        jSONObject.put("isRenew", true);
        jSONObject.put("passId", str);
        i.put("passProps", jSONObject);
        String jSONObject2 = i.toString();
        n86.d(jSONObject2, "lJSONObject.toString()");
        xj1 S = xt.f3961a.S();
        e70 e70 = new e70(context, true, 1, j2, r60.f3047a, new a(superPassUserDetails, bookableSuperPassConfiguration, str, j, context), jSONObject2);
        e70.q = new nj1(Indexable.MAX_STRING_LENGTH, 0, 1.0f);
        e70.n = false;
        S.a(e70);
    }

    public static final void f(SuperPassUserDetails superPassUserDetails, BookableSuperPassConfiguration bookableSuperPassConfiguration, long j, Context context) {
        n86.e(superPassUserDetails, "lSuperPassUserDetails");
        n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
        n86.e(context, "lContext");
        String j2 = j();
        JSONObject i = i();
        b(i);
        d(i, superPassUserDetails);
        a(i, j, bookableSuperPassConfiguration);
        String jSONObject = i.toString();
        n86.d(jSONObject, "lJSONObject.toString()");
        xj1 S = xt.f3961a.S();
        e70 e70 = new e70(context, true, 1, j2, n60.f2516a, new b(superPassUserDetails, bookableSuperPassConfiguration, j, context), jSONObject);
        e70.q = new nj1(Indexable.MAX_STRING_LENGTH, 0, 1.0f);
        e70.n = false;
        S.a(e70);
    }

    public static final void g(SuperPassUserDetails superPassUserDetails, BookableSuperPassConfiguration bookableSuperPassConfiguration, long j, Map<String, String> map, Context context) {
        n86.e(superPassUserDetails, "lSuperPassUserDetails");
        n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
        n86.e(map, "lUploadedProofsMap");
        n86.e(context, "lContext");
        String j2 = j();
        JSONObject i = i();
        b(i);
        d(i, superPassUserDetails);
        a(i, j, bookableSuperPassConfiguration);
        c(i, map);
        String jSONObject = i.toString();
        n86.d(jSONObject, "lJSONObject.toString()");
        xj1 S = xt.f3961a.S();
        e70 e70 = new e70(context, true, 1, j2, p60.f2771a, new c(superPassUserDetails, bookableSuperPassConfiguration, j, map, context), jSONObject);
        e70.q = new nj1(Indexable.MAX_STRING_LENGTH, 0, 1.0f);
        e70.n = false;
        S.a(e70);
    }

    public static final void h(String str, String str2, Context context) {
        n86.e(str, "lUserId");
        n86.e(str2, "lPassId");
        n86.e(context, "lContext");
        String str3 = ut.i + "v2/" + "/pass/payment/cash";
        n86.d(str3, "lBaseUrl.toString()");
        JSONObject i = i();
        i.put("userId", str);
        i.put("passId", str2);
        i.put("failCashRoutePass", false);
        String jSONObject = i.toString();
        n86.d(jSONObject, "lJSONObject.toString()");
        xj1 S = xt.f3961a.S();
        e70 e70 = new e70(context, true, 1, str3, q60.f2902a, new d(str, str2, context), jSONObject);
        e70.q = new nj1(2500, 5, 1.0f);
        e70.n = false;
        S.a(e70);
    }

    public static final JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        xt.t1 t1Var = xt.f3961a;
        City d2 = t1Var.k().d();
        n86.c(d2);
        jSONObject.put("city", d2.getName());
        ut.a aVar = ut.f3552a;
        jSONObject.put("appVer", 764);
        jSONObject.put("deviceId", t1Var.n().a());
        return jSONObject;
    }

    public static final String j() {
        StringBuilder sb = new StringBuilder(ut.i);
        sb.append("v2/");
        sb.append("city/");
        City d2 = xt.f3961a.k().d();
        sb.append(d2 == null ? null : d2.getName());
        sb.append("/createPassOrder");
        String sb2 = sb.toString();
        n86.d(sb2, "lBaseUrl.toString()");
        return sb2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0113 A[Catch:{ JSONException -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0118 A[Catch:{ JSONException -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x013d A[Catch:{ JSONException -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0149 A[Catch:{ JSONException -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x016d A[Catch:{ JSONException -> 0x01f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0197 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void k(org.json.JSONObject r35) {
        /*
        // Method dump skipped, instructions count: 541
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y60.k(org.json.JSONObject):void");
    }

    public static final void l(SuperPassUserDetails superPassUserDetails, BookableSuperPassConfiguration bookableSuperPassConfiguration, long j, Map<String, String> map, Context context) {
        n86.e(superPassUserDetails, "lSuperPassUserDetails");
        n86.e(bookableSuperPassConfiguration, "lBookableSuperPassConfiguration");
        n86.e(map, "lUploadedProofsMap");
        n86.e(context, "lContext");
        StringBuilder sb = new StringBuilder(ut.i);
        sb.append("v2/");
        sb.append("city/");
        xt.t1 t1Var = xt.f3961a;
        City d2 = t1Var.k().d();
        sb.append(d2 == null ? null : d2.getName());
        sb.append("/passApplication");
        String sb2 = sb.toString();
        n86.d(sb2, "lBaseUrl.toString()");
        JSONObject i = i();
        d(i, superPassUserDetails);
        a(i, j, bookableSuperPassConfiguration);
        c(i, map);
        String jSONObject = i.toString();
        n86.d(jSONObject, "lJSONObject.toString()");
        xj1 S = t1Var.S();
        e70 e70 = new e70(context, true, 1, sb2, o60.f2653a, new e(superPassUserDetails, bookableSuperPassConfiguration, j, map, context), jSONObject);
        e70.q = new nj1(12000, 0, 1.0f);
        e70.n = false;
        S.a(e70);
    }
}
