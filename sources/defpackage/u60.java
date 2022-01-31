package defpackage;

import android.content.Context;
import android.net.Uri;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.pubsub.eventbus.events.DigitalTripReceiptHistoryFetchedEvent;
import defpackage.n00;
import defpackage.ut;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: u60  reason: default package */
/* compiled from: DigitalTripReceiptApiHelper.kt */
public final class u60 {

    /* renamed from: a  reason: collision with root package name */
    public static final u60 f3458a = new u60();

    /* renamed from: u60$a */
    /* compiled from: DigitalTripReceiptApiHelper.kt */
    public static final class a implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List<ProductActivationDetails> f3459a;
        public final /* synthetic */ List<ProductActivationDetails> b;
        public final /* synthetic */ Context c;

        public a(List<ProductActivationDetails> list, List<ProductActivationDetails> list2, Context context) {
            this.f3459a = list;
            this.b = list2;
            this.c = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.e(str, "errorReason");
            n86.j("syncActivationsAndFetchSuperPassTripReceipts 1: response error = ", str);
            ed1 ed1 = new ed1("product activation pass punch sync failed", Long.MIN_VALUE);
            ed1.a("error message", str);
            ui1.m0(ed1);
        }

        @Override // defpackage.n00.y0
        public void execute() {
            u60.f3458a.e(this.f3459a, this.b, this.c);
        }
    }

    /* renamed from: u60$b */
    /* compiled from: DigitalTripReceiptApiHelper.kt */
    public static final class b implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ SuperPass f3460a;
        public final /* synthetic */ List<ProductActivationDetails> b;
        public final /* synthetic */ List<ProductActivationDetails> c;
        public final /* synthetic */ Context d;

        public b(SuperPass superPass, List<ProductActivationDetails> list, List<ProductActivationDetails> list2, Context context) {
            this.f3460a = superPass;
            this.b = list;
            this.c = list2;
            this.d = context;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n86.j("syncActivationsAndFetchSuperPassTripReceipts: responseErrorReason 2 = ", str);
            String str2 = "";
            jz5.b().i(new DigitalTripReceiptHistoryFetchedEvent(ad1.FAILED, str == null ? str2 : str));
            ed1 ed1 = new ed1("product activation pass punch sync failed", Long.MIN_VALUE);
            if (str != null) {
                str2 = str;
            }
            ed1.a("error message", str2);
            ui1.m0(ed1);
            SuperPass superPass = this.f3460a;
            ed1 ed12 = new ed1("superPass trip receipt history fetch failed", Long.MIN_VALUE);
            if (str == null) {
                str = new String();
            }
            ed12.a("error message", str);
            gi1.f1265a.f(ed12, superPass);
            ui1.m0(ed12);
        }

        @Override // defpackage.n00.y0
        public void execute() {
            u60.f3458a.f(this.f3460a, this.b, this.c, this.d);
        }
    }

    public final void a(JSONObject jSONObject, Map<String, ? extends List<ProductActivationDetails>> map, Map<String, ? extends List<ProductActivationDetails>> map2) {
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        if (map == null || map.isEmpty()) {
            if (map2 == null || map2.isEmpty()) {
                return;
            }
        }
        if (!(map == null || map.isEmpty())) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry<String, ? extends List<ProductActivationDetails>> entry : map.entrySet()) {
                List<ProductActivationDetails> list = (List) entry.getValue();
                ProductActivationDetails productActivationDetails = list == null ? null : (ProductActivationDetails) y56.i(list);
                if (productActivationDetails != null) {
                    if (list == null || list.isEmpty()) {
                        jSONObject3 = null;
                    } else {
                        jSONObject3 = new JSONObject();
                        JSONArray c = c(list);
                        jSONObject3.put("city", productActivationDetails.getCity());
                        jSONObject3.put("agency", productActivationDetails.getAgencyName());
                        jSONObject3.put("passId", productActivationDetails.getBookingId());
                        jSONObject3.put(DigitalTripReceiptJsonKeys.KEY_ACTIVATION_TIME, c);
                    }
                    jSONArray.put(jSONObject3);
                }
            }
            if (jSONArray.length() != 0) {
                jSONObject.put("passActivations", jSONArray);
            } else {
                return;
            }
        }
        if (!(map2 == null || map2.isEmpty())) {
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry<String, ? extends List<ProductActivationDetails>> entry2 : map2.entrySet()) {
                List<ProductActivationDetails> list2 = (List) entry2.getValue();
                ProductActivationDetails productActivationDetails2 = list2 == null ? null : (ProductActivationDetails) y56.i(list2);
                if (productActivationDetails2 != null) {
                    if (list2 == null || list2.isEmpty()) {
                        jSONObject2 = null;
                    } else {
                        jSONObject2 = new JSONObject();
                        JSONArray c2 = c(list2);
                        jSONObject2.put("city", productActivationDetails2.getCity());
                        jSONObject2.put("agency", productActivationDetails2.getAgencyName());
                        jSONObject2.put("ticketId", productActivationDetails2.getBookingId());
                        jSONObject2.put(DigitalTripReceiptJsonKeys.KEY_ACTIVATION_TIME, c2);
                    }
                    jSONArray2.put(jSONObject2);
                }
            }
            if (jSONArray2.length() != 0) {
                jSONObject.put("ticketActivations", jSONArray2);
            }
        }
    }

    public final Map<String, List<ProductActivationDetails>> b(List<ProductActivationDetails> list) {
        HashMap hashMap = new HashMap();
        if (list == null || list.isEmpty()) {
            return hashMap;
        }
        for (ProductActivationDetails productActivationDetails : list) {
            Object obj = (List) hashMap.get(productActivationDetails.getBookingId());
            if (obj == null) {
                obj = new ArrayList();
            }
            List a2 = b96.a(obj);
            a2.add(productActivationDetails);
            hashMap.put(productActivationDetails.getBookingId(), a2);
        }
        return hashMap;
    }

    public final JSONArray c(List<ProductActivationDetails> list) {
        JSONArray jSONArray = new JSONArray();
        for (ProductActivationDetails productActivationDetails : list) {
            jSONArray.put(productActivationDetails.getActivationTimeStamp());
        }
        return jSONArray;
    }

    public final String d() {
        Uri.Builder appendEncodedPath = new Uri.Builder().encodedPath(ut.i.toString()).appendEncodedPath("v2").appendEncodedPath("punch").appendEncodedPath("syncHistory");
        ut.a aVar = ut.f3552a;
        String builder = appendEncodedPath.appendQueryParameter("appVer", String.valueOf(764)).toString();
        n86.d(builder, "lUri.toString()");
        return builder;
    }

    public final void e(List<ProductActivationDetails> list, List<ProductActivationDetails> list2, Context context) {
        n86.e(context, "lContext");
        boolean z = true;
        if (list == null || list.isEmpty()) {
            if (list2 != null && !list2.isEmpty()) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        Map<String, List<ProductActivationDetails>> b2 = b(list);
        Map<String, List<ProductActivationDetails>> b3 = b(list2);
        String d = d();
        JSONObject jSONObject = new JSONObject();
        ut.a aVar = ut.f3552a;
        jSONObject.put("appVer", 764);
        a(jSONObject, b2, b3);
        String jSONObject2 = jSONObject.toString();
        n86.d(jSONObject2, "lJSONObject.toString()");
        xj1 S = xt.f3961a.S();
        n86.j("syncActivationsAndFetchSuperPassTripReceipts 1: req body = ", jSONObject2);
        e70 e70 = new e70(context, true, 1, d, new j60(list, list2), new a(list, list2, context), jSONObject2);
        e70.q = new nj1(12000, 5, 1.0f);
        e70.n = false;
        S.a(e70);
    }

    public final void f(SuperPass superPass, List<ProductActivationDetails> list, List<ProductActivationDetails> list2, Context context) {
        n86.e(superPass, "lSuperPass");
        n86.e(context, "lContext");
        Map<String, List<ProductActivationDetails>> b2 = b(list);
        Map<String, List<ProductActivationDetails>> b3 = b(list);
        String d = d();
        JSONObject jSONObject = new JSONObject();
        ut.a aVar = ut.f3552a;
        jSONObject.put("appVer", 764);
        a(jSONObject, b2, b3);
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("passId", superPass.getSuperPassProperties().getPassId());
        jSONObject.put("passInfo", jSONObject2);
        String jSONObject3 = jSONObject.toString();
        n86.d(jSONObject3, "lJSONObject.toString()");
        xj1 S = xt.f3961a.S();
        n86.j("syncActivationsAndFetchSuperPassTripReceipts: req body 2 = ", jSONObject3);
        e70 e70 = new e70(context, true, 1, d, new i60(list, superPass, list2), new b(superPass, list, list2, context), jSONObject3);
        e70.q = new nj1(12000, 5, 1.0f);
        e70.n = false;
        S.a(e70);
    }
}
