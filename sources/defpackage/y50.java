package defpackage;

import android.content.Context;
import app.zophop.ZophopApplication;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.VisualValidationActivationDetails;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassProperties;
import app.zophop.room.VisualValidationRepository;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.razorpay.AnalyticsConstants;
import defpackage.ut;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: y50  reason: default package */
/* compiled from: VisualValidationFeature.kt */
public final class y50 implements e30 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4002a;
    public final VisualValidationRepository b;
    public final ZophopApplication c;

    @y66(c = "app.zophop.features.VisualValidationFeature$sendMTicketActivationTimeStampToBackend$1", f = "VisualValidationFeature.kt", l = {73}, m = "invokeSuspend")
    /* renamed from: y50$a */
    /* compiled from: VisualValidationFeature.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ y50 g;
        public final /* synthetic */ MTicket h;
        public final /* synthetic */ long i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(y50 y50, MTicket mTicket, long j, k66<? super a> k66) {
            super(2, k66);
            this.g = y50;
            this.h = mTicket;
            this.i = j;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new a(this.g, this.h, this.i, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new a(this.g, this.h, this.i, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i2 = this.f;
            if (i2 == 0) {
                hd3.Y2(obj);
                y50 y50 = this.g;
                MTicket mTicket = this.h;
                long j = this.i;
                Objects.requireNonNull(y50);
                long activationDuration = mTicket.getActivationDuration() + j;
                String mTicketId = mTicket.getMTicketId();
                n86.d(mTicketId, "lMTicket.mTicketId");
                long expirationTime = mTicket.getExpirationTime();
                String cityName = mTicket.getCityName();
                n86.d(cityName, "lMTicket.cityName");
                String agency = mTicket.getAgency();
                n86.d(agency, "lMTicket.agency");
                VisualValidationActivationDetails visualValidationActivationDetails = new VisualValidationActivationDetails(activationDuration, mTicketId, expirationTime, "mTicket", cityName, agency);
                VisualValidationRepository visualValidationRepository = this.g.b;
                this.f = 1;
                if (visualValidationRepository.insertVisualValidationActivationDetails(visualValidationActivationDetails, this) == p66) {
                    return p66;
                }
            } else if (i2 == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.g.a();
            return s56.f3190a;
        }
    }

    @y66(c = "app.zophop.features.VisualValidationFeature$sendSuperPassActivationTimeStampToBackend$1", f = "VisualValidationFeature.kt", l = {61}, m = "invokeSuspend")
    /* renamed from: y50$b */
    /* compiled from: VisualValidationFeature.kt */
    public static final class b extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ y50 g;
        public final /* synthetic */ SuperPass h;
        public final /* synthetic */ long i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(y50 y50, SuperPass superPass, long j, k66<? super b> k66) {
            super(2, k66);
            this.g = y50;
            this.h = superPass;
            this.i = j;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new b(this.g, this.h, this.i, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new b(this.g, this.h, this.i, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i2 = this.f;
            if (i2 == 0) {
                hd3.Y2(obj);
                y50 y50 = this.g;
                SuperPass superPass = this.h;
                long j = this.i;
                Objects.requireNonNull(y50);
                SuperPassProperties superPassProperties = superPass.getSuperPassProperties();
                VisualValidationActivationDetails visualValidationActivationDetails = new VisualValidationActivationDetails(j, superPassProperties.getPassId(), superPass.getSuperPassValidationProperties().getExpiryTime(), "rideBasedSuperPass", superPassProperties.getCityName(), superPassProperties.getAgencyName());
                VisualValidationRepository visualValidationRepository = this.g.b;
                this.f = 1;
                if (visualValidationRepository.insertVisualValidationActivationDetails(visualValidationActivationDetails, this) == p66) {
                    return p66;
                }
            } else if (i2 == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.g.a();
            return s56.f3190a;
        }
    }

    @y66(c = "app.zophop.features.VisualValidationFeature$sendUnSyncedActivationTimeStampsToBackend$1", f = "VisualValidationFeature.kt", l = {}, m = "invokeSuspend")
    /* renamed from: y50$c */
    /* compiled from: VisualValidationFeature.kt */
    public static final class c extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public final /* synthetic */ y50 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(y50 y50, k66<? super c> k66) {
            super(2, k66);
            this.f = y50;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new c(this.f, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            c cVar = new c(this.f, k66);
            s56 s56 = s56.f3190a;
            cVar.invokeSuspend(s56);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            List<VisualValidationActivationDetails> visualValidationActivationDetailsListMap = this.f.b.getVisualValidationActivationDetailsListMap();
            ArrayList arrayList2 = null;
            if (visualValidationActivationDetailsListMap == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (T t : visualValidationActivationDetailsListMap) {
                    if (n86.a(t.getProductType(), "rideBasedSuperPass")) {
                        arrayList.add(t);
                    }
                }
            }
            if (visualValidationActivationDetailsListMap != null) {
                arrayList2 = new ArrayList();
                for (T t2 : visualValidationActivationDetailsListMap) {
                    if (n86.a(t2.getProductType(), "mTicket")) {
                        arrayList2.add(t2);
                    }
                }
            }
            y50.d(this.f, arrayList, arrayList2);
            return s56.f3190a;
        }
    }

    public y50(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        this.f4002a = context;
        this.b = new VisualValidationRepository(context);
        this.c = (ZophopApplication) context;
    }

    public static final void d(y50 y50, List list, List list2) {
        JSONObject f;
        Objects.requireNonNull(y50);
        boolean z = true;
        if (list == null || list.isEmpty()) {
            if (list2 != null && !list2.isEmpty()) {
                z = false;
            }
            if (z) {
                return;
            }
        }
        Map<String, List<VisualValidationActivationDetails>> e = y50.e(list);
        Map<String, List<VisualValidationActivationDetails>> e2 = y50.e(list2);
        String str = ut.i + "v2/" + "appPunch";
        n86.d(str, "lBaseUrl.toString()");
        JSONObject jSONObject = new JSONObject();
        ut.a aVar = ut.f3552a;
        jSONObject.put("appVer", 764);
        xt.t1 t1Var = xt.f3961a;
        jSONObject.put("deviceId", t1Var.n().a());
        jSONObject.put("userId", t1Var.L().getUserId());
        jSONObject.put("source", SettingsJsonConstants.APP_KEY);
        HashMap hashMap = (HashMap) e;
        if (!hashMap.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            for (Map.Entry entry : hashMap.entrySet()) {
                List<VisualValidationActivationDetails> list3 = (List) entry.getValue();
                VisualValidationActivationDetails visualValidationActivationDetails = list3 == null ? null : (VisualValidationActivationDetails) y56.i(list3);
                if (visualValidationActivationDetails != null) {
                    jSONArray.put(y50.f(visualValidationActivationDetails, list3));
                }
            }
            if (jSONArray.length() != 0) {
                jSONObject.put("passPunch", jSONArray);
            }
        }
        HashMap hashMap2 = (HashMap) e2;
        if (!hashMap2.isEmpty()) {
            JSONArray jSONArray2 = new JSONArray();
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                List<VisualValidationActivationDetails> list4 = (List) entry2.getValue();
                VisualValidationActivationDetails visualValidationActivationDetails2 = list4 == null ? null : (VisualValidationActivationDetails) y56.i(list4);
                if (!(visualValidationActivationDetails2 == null || (f = y50.f(visualValidationActivationDetails2, list4)) == null)) {
                    jSONArray2.put(f);
                }
            }
            if (jSONArray2.length() != 0) {
                jSONObject.put("ticketPunch", jSONArray2);
            }
        }
        String jSONObject2 = jSONObject.toString();
        n86.d(jSONObject2, "lJSONObject.toString()");
        xj1 S = xt.f3961a.S();
        e70 e70 = new e70(y50.f4002a, false, 1, str, new g00(y50, list, list2), new z50(y50, list, list2), jSONObject2);
        e70.q = new nj1(12000, 5, 1.0f);
        e70.n = false;
        S.a(e70);
    }

    @Override // defpackage.e30
    public void a() {
        if (xt.f3961a.L().m()) {
            hd3.Y1(this.c, null, null, new c(this, null), 3, null);
        }
    }

    @Override // defpackage.e30
    public void b(MTicket mTicket, long j) {
        n86.e(mTicket, "lMTicket");
        ed1 ed1 = new ed1("send mTicket activation timeStamp to backend for visual validation", Long.MIN_VALUE);
        ed1.a("type", "mTicket");
        gi1.f1265a.b(ed1, mTicket);
        ui1.m0(ed1);
        hd3.Y1(this.c, null, null, new a(this, mTicket, j, null), 3, null);
    }

    @Override // defpackage.e30
    public void c(SuperPass superPass, long j) {
        n86.e(superPass, "lSuperPass");
        ed1 ed1 = new ed1("send superPass activation timeStamp to backend for visual validation", Long.MIN_VALUE);
        ed1.a("type", SuperPassConstants.PRODUCT_TYPE_SUPER_PASS);
        gi1.f1265a.f(ed1, superPass);
        ui1.m0(ed1);
        hd3.Y1(this.c, null, null, new b(this, superPass, j, null), 3, null);
    }

    public final Map<String, List<VisualValidationActivationDetails>> e(List<VisualValidationActivationDetails> list) {
        HashMap hashMap = new HashMap();
        if (list == null || list.isEmpty()) {
            return hashMap;
        }
        for (VisualValidationActivationDetails visualValidationActivationDetails : list) {
            Object obj = (List) hashMap.get(visualValidationActivationDetails.getBookingId());
            if (obj == null) {
                obj = new ArrayList();
            }
            List a2 = b96.a(obj);
            a2.add(visualValidationActivationDetails);
            hashMap.put(visualValidationActivationDetails.getBookingId(), a2);
        }
        return hashMap;
    }

    public final JSONObject f(VisualValidationActivationDetails visualValidationActivationDetails, List<VisualValidationActivationDetails> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (VisualValidationActivationDetails visualValidationActivationDetails2 : list) {
            jSONArray.put(visualValidationActivationDetails2.getActivationTimeStamp());
        }
        jSONObject.put("city", visualValidationActivationDetails.getCity());
        jSONObject.put("agency", visualValidationActivationDetails.getAgencyName());
        jSONObject.put("bookingId", visualValidationActivationDetails.getBookingId());
        jSONObject.put(SuperPassJsonKeys.EXPIRY_TIME, visualValidationActivationDetails.getExpiryTime());
        jSONObject.put(DigitalTripReceiptJsonKeys.KEY_PUNCH_TIME, jSONArray);
        return jSONObject;
    }
}
