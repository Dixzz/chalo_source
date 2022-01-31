package defpackage;

import android.content.Context;
import android.net.Uri;
import app.zophop.models.AutoCabInfo;
import app.zophop.models.AutoCabResponse;
import app.zophop.models.LocationTripRequest;
import app.zophop.models.TripRequest;
import app.zophop.models.autoCabBooking.BookingCode;
import app.zophop.models.autoCabBooking.BookingDetails;
import app.zophop.models.autoCabBooking.BookingResponseConverters;
import app.zophop.pubsub.eventbus.events.AutoCabBookingEvent;
import app.zophop.pubsub.eventbus.events.CabDestinationUpdatedEvent;
import app.zophop.pubsub.eventbus.events.CabRideCancelled;
import app.zophop.pubsub.eventbus.events.NearByCabTripEvent;
import app.zophop.pubsub.eventbus.events.TripPlannerCabTripEvent;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import defpackage.n00;
import defpackage.p20;
import defpackage.xt;
import defpackage.yj1;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: u00  reason: default package */
/* compiled from: CabsFeature */
public class u00 {
    public static String g;

    /* renamed from: a  reason: collision with root package name */
    public final xj1 f3426a;
    public long b;
    public l c;
    public final BookingResponseConverters d = new BookingResponseConverters();
    public String e;
    public final Context f;

    /* renamed from: u00$a */
    /* compiled from: CabsFeature */
    public class a implements yj1.b<JSONObject> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            hj1.S0("response success ", jSONObject2);
            try {
                if (u00.this.d.getResponseType(jSONObject2).equals(ad1.SUCCESS)) {
                    xt.f3961a.f().e(jSONObject2.getString("_href"));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: u00$b */
    /* compiled from: CabsFeature */
    public class b implements n00.z0 {
        public b(u00 u00) {
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
        }
    }

    /* renamed from: u00$c */
    /* compiled from: CabsFeature */
    public class c implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3428a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;

        public c(String str, long j, String str2) {
            this.f3428a = str;
            this.b = j;
            this.c = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            TripPlannerCabTripEvent tripPlannerCabTripEvent;
            JSONObject jSONObject2 = jSONObject;
            Context context = u00.this.f;
            hj1.S0("reponse succes ", jSONObject2);
            u00 u00 = u00.this;
            String str = this.c;
            Objects.requireNonNull(u00);
            try {
                tripPlannerCabTripEvent = new TripPlannerCabTripEvent(new iv().a(jSONObject2), ad1.SUCCESS, str);
            } catch (Exception unused) {
                tripPlannerCabTripEvent = null;
            }
            jz5.b().i(tripPlannerCabTripEvent);
        }
    }

    /* renamed from: u00$d */
    /* compiled from: CabsFeature */
    public class d implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f3429a;
        public final /* synthetic */ String b;

        public d(long j, String str) {
            this.f3429a = j;
            this.b = str;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            Context context = u00.this.f;
            dk1.toString();
            jz5.b().i(new TripPlannerCabTripEvent(null, ad1.FAILED, this.b));
        }
    }

    /* renamed from: u00$e */
    /* compiled from: CabsFeature */
    public class e implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3430a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ LatLng d;
        public final /* synthetic */ boolean e;

        public e(String str, long j, String str2, LatLng latLng, boolean z) {
            this.f3430a = str;
            this.b = j;
            this.c = str2;
            this.d = latLng;
            this.e = z;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            NearByCabTripEvent nearByCabTripEvent;
            JSONObject jSONObject2 = jSONObject;
            Context context = u00.this.f;
            hj1.S0("reponse success ", jSONObject2);
            u00 u00 = u00.this;
            String str = this.c;
            LatLng latLng = this.d;
            Objects.requireNonNull(u00);
            try {
                nearByCabTripEvent = new NearByCabTripEvent(new iv().a(jSONObject2), ad1.SUCCESS, str, latLng);
            } catch (Exception unused) {
                nearByCabTripEvent = null;
            }
            if (this.e) {
                u00 u002 = u00.this;
                LatLng latLng2 = this.d;
                l lVar = u002.c;
                boolean z = true;
                if (lVar != null && ui1.m(latLng2, lVar.b) <= 100.0d && System.currentTimeMillis() - lVar.c <= 120000) {
                    z = false;
                }
                if (z) {
                    u00 u003 = u00.this;
                    u003.c = new l(u003, nearByCabTripEvent.getResponse(), this.d, u00.this.b);
                }
            }
            jz5.b().g(nearByCabTripEvent);
        }
    }

    /* renamed from: u00$f */
    /* compiled from: CabsFeature */
    public class f implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f3431a;
        public final /* synthetic */ String b;
        public final /* synthetic */ LatLng c;

        public f(long j, String str, LatLng latLng) {
            this.f3431a = j;
            this.b = str;
            this.c = latLng;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            Context context = u00.this.f;
            dk1.toString();
            jz5.b().g(new NearByCabTripEvent(null, ad1.FAILED, this.b, this.c));
        }
    }

    /* renamed from: u00$g */
    /* compiled from: CabsFeature */
    public class g implements ji1<JSONObject, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3432a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public g(String str, String str2, String str3) {
            this.f3432a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void a(String str) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.ji1
        public void onSuccess(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            hj1.S0("response success ", jSONObject2);
            xt.t1 t1Var = xt.f3961a;
            BookingDetails b2 = t1Var.f().b();
            if (b2 != null) {
                try {
                    BookingCode bookingCode = u00.this.d.getBookingCode(jSONObject2);
                    if (bookingCode.equals(BookingCode.INVALID_TOKEN)) {
                        u00.this.q(this.f3432a, this.b, this.c);
                        t1Var.H().a(this.f3432a, new x00(this));
                        return;
                    }
                    u00.this.l(this.f3432a, jSONObject2, null, null, null, null, b2);
                    if (!t00.d(bookingCode)) {
                        u00.this.q(this.f3432a, this.b, this.c);
                    }
                } catch (JSONException e) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e);
                }
            }
        }
    }

    /* renamed from: u00$h */
    /* compiled from: CabsFeature */
    public class h implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3433a;
        public final /* synthetic */ String b;
        public final /* synthetic */ mf1 c;
        public final /* synthetic */ mf1 d;
        public final /* synthetic */ AutoCabInfo e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public h(String str, String str2, mf1 mf1, mf1 mf12, AutoCabInfo autoCabInfo, String str3, String str4) {
            this.f3433a = str;
            this.b = str2;
            this.c = mf1;
            this.d = mf12;
            this.e = autoCabInfo;
            this.f = str3;
            this.g = str4;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            hj1.S0("response success ", jSONObject2);
            try {
                BookingCode bookingCode = u00.this.d.getBookingCode(jSONObject2);
                xt.t1 t1Var = xt.f3961a;
                if (t1Var.f().c()) {
                    return;
                }
                if (BookingCode.INVALID_TOKEN.equals(bookingCode)) {
                    u00.a(u00.this, AnalyticsConstants.FAIL, "invalid token", this.f3433a, "", this.b);
                    t1Var.H().a(this.f3433a, new y00(this));
                } else if (t00.d(bookingCode)) {
                    u00 u00 = u00.this;
                    String str = this.f3433a;
                    mf1 mf1 = this.c;
                    mf1 mf12 = this.d;
                    AutoCabInfo autoCabInfo = this.e;
                    Objects.requireNonNull(u00);
                    BookingDetails l = u00.l(str, jSONObject2, mf1, mf12, autoCabInfo.getId(), autoCabInfo.getName(), null);
                    u00.this.p(this.f3433a, this.g, l.getRequestId());
                    u00.a(u00.this, "success", "", this.f3433a, l.getRequestId(), this.b);
                    ui1.t0("cabBooked");
                } else {
                    if (!bookingCode.equals(BookingCode.SURGE)) {
                        if (!bookingCode.equals(BookingCode.NO_DRIVERS_AVAILABLE)) {
                            if (!bookingCode.equals(BookingCode.USER_ACCOUNT_ISSUE) && !bookingCode.equals(BookingCode.USER_BLOCKED_ISSUE)) {
                                if (!bookingCode.equals(BookingCode.PAYMENT_ISSUE)) {
                                    u00.b(u00.this, this.f3433a, bookingCode);
                                    u00.a(u00.this, "success", "other error", this.f3433a, "", this.b);
                                    return;
                                }
                            }
                            BookingDetails bookingDetails = new BookingDetails(this.f3433a, this.c, this.d, this.e);
                            bookingDetails.setHref(jSONObject2.optString("_href"));
                            bookingDetails.setCode(bookingCode);
                            u00.this.j(bookingDetails);
                            u00.a(u00.this, AnalyticsConstants.FAIL, bookingCode.name(), this.f3433a, "", this.b);
                            return;
                        }
                    }
                    u00.this.j(u00.this.d.getBookingDetails(jSONObject2, new BookingDetails(this.f3433a, this.c, this.d, this.e)));
                    u00.a(u00.this, AnalyticsConstants.FAIL, bookingCode.name(), this.f3433a, "", this.b);
                }
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                b00.a().b(e2);
                u00.b(u00.this, this.f3433a, BookingCode.OTHER_ERRORS);
            }
        }
    }

    /* renamed from: u00$i */
    /* compiled from: CabsFeature */
    public class i implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3434a;

        public i(String str) {
            this.f3434a = str;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            u00.b(u00.this, this.f3434a, BookingCode.NETWORK_ERROR);
        }
    }

    /* renamed from: u00$j */
    /* compiled from: CabsFeature */
    public class j implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3435a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public j(String str, String str2, String str3) {
            this.f3435a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            try {
                String str = "response success " + jSONObject2;
                ad1 responseType = u00.this.d.getResponseType(jSONObject2);
                ad1 ad1 = ad1.SUCCESS;
                if (responseType.equals(ad1)) {
                    t00 f = xt.f3961a.f();
                    BookingCode bookingCode = BookingCode.RIDER_CANCELED;
                    BookingDetails b2 = f.b();
                    if (b2 != null) {
                        b2.setCode(bookingCode);
                        f.f(b2);
                    }
                    jz5.b().g(new CabRideCancelled(ad1));
                    u00.c(u00.this, "success", this.f3435a, this.b, "");
                    return;
                }
                u00.this.p(this.f3435a, this.c, this.b);
                jz5.b().g(new CabRideCancelled(ad1.FAILED));
                u00.c(u00.this, AnalyticsConstants.FAILURE, this.f3435a, this.b, "server failed");
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
                u00.this.p(this.f3435a, this.c, this.b);
                jz5.b().g(new CabRideCancelled(ad1.FAILED));
            }
        }
    }

    /* renamed from: u00$k */
    /* compiled from: CabsFeature */
    public class k implements n00.z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f3436a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public k(String str, String str2, String str3) {
            this.f3436a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            u00.this.p(this.f3436a, this.b, this.c);
            jz5.b().g(new CabRideCancelled(ad1.FAILED));
        }
    }

    /* renamed from: u00$l */
    /* compiled from: CabsFeature */
    public class l {

        /* renamed from: a  reason: collision with root package name */
        public final AutoCabResponse f3437a;
        public final LatLng b;
        public final long c;

        public l(u00 u00, AutoCabResponse autoCabResponse, LatLng latLng, long j) {
            this.f3437a = autoCabResponse;
            this.b = latLng;
            this.c = j;
        }
    }

    /* renamed from: u00$m */
    /* compiled from: CabsFeature */
    public abstract class m implements p20.a {
        public m(c cVar) {
        }
    }

    public u00(Context context, xj1 xj1) {
        this.f = context;
        this.f3426a = xj1;
        g = ut.s;
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public static void a(u00 u00, String str, String str2, String str3, String str4, String str5) {
        Objects.requireNonNull(u00);
        ed1 ed1 = new ed1("cab booked", Long.MIN_VALUE);
        ed1.a("aggregatorName", str3);
        ed1.a("requestId", str4);
        ed1.a("cabType", str5);
        hj1.p(ed1, "status", str, "reason", str2).g(ed1);
    }

    public static void b(u00 u00, String str, BookingCode bookingCode) {
        Objects.requireNonNull(u00);
        BookingDetails bookingDetails = new BookingDetails(str, null, null, null, null);
        bookingDetails.setCode(bookingCode);
        u00.j(bookingDetails);
    }

    public static void c(u00 u00, String str, String str2, String str3, String str4) {
        Objects.requireNonNull(u00);
        ed1 ed1 = new ed1("cab ride ended", Long.MIN_VALUE);
        ed1.a("aggregatorName", str2);
        ed1.a("requestId", str3);
        ed1.a("cabType", "");
        hj1.p(ed1, "status", str, "reason", str4).g(ed1);
    }

    public static void d(u00 u00, String str, String str2, BookingDetails bookingDetails, String str3) {
        Objects.requireNonNull(u00);
        ed1 ed1 = new ed1("cab destination updated", Long.MIN_VALUE);
        if (bookingDetails != null) {
            ed1.a("aggregatorName", bookingDetails.getProvider());
            ed1.a("requestId", bookingDetails.getRequestId());
            ed1.a("cabType", bookingDetails.getProductName());
        }
        ed1.a(FirebaseAnalytics.Param.DESTINATION, str3);
        hj1.p(ed1, "status", str, "reason", str2).g(ed1);
    }

    public final void e(mf1 mf1) {
        xt.t1 t1Var = xt.f3961a;
        BookingDetails b2 = t1Var.f().b();
        if (b2 != null) {
            String requestId = b2.getRequestId();
            String provider = b2.getProvider();
            String f2 = t1Var.H().f(provider);
            String str = ut.t;
            LatLng latLng = mf1.f2368a;
            Uri.Builder builder = new Uri.Builder();
            builder.encodedPath(str).appendPath(provider.toLowerCase()).appendPath("updateDestination");
            builder.appendQueryParameter("oauthToken", f2);
            builder.appendQueryParameter("requestId", requestId);
            builder.appendQueryParameter("to_lat", hj1.U(new StringBuilder(), latLng.latitude, ""));
            builder.appendQueryParameter("to_lon", hj1.U(new StringBuilder(), latLng.longitude, ""));
            if (ut.A) {
                builder.appendQueryParameter("environment", "sandbox");
            }
            String builder2 = builder.toString();
            BookingDetails b3 = t1Var.f().b();
            CabDestinationUpdatedEvent.CabDestinationStatus cabDestinationStatus = CabDestinationUpdatedEvent.CabDestinationStatus.CAB_RESULT;
            d70 d70 = new d70(builder2, null, new v00(this, b3, mf1, cabDestinationStatus), new w00(this, b3, mf1, cabDestinationStatus));
            d70.n = false;
            this.f3426a.a(d70);
            return;
        }
        o(ad1.FAILED, mf1, CabDestinationUpdatedEvent.CabDestinationStatus.CAB_RESULT);
    }

    public void f(String str, String str2, String str3) {
        String str4 = ut.t;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(str4).appendPath(str.toLowerCase()).appendPath("cancelRide");
        builder.appendQueryParameter("oauthToken", str3);
        builder.appendQueryParameter("requestId", str2);
        if (ut.A) {
            builder.appendQueryParameter("environment", "sandbox");
        }
        String builder2 = builder.toString();
        q(str, str3, str2);
        d70 d70 = new d70(builder2, null, new j(str, str2, str3), new k(str, str3, str2));
        d70.n = false;
        this.f3426a.a(d70);
    }

    public final boolean g(mf1 mf1, mf1 mf12) {
        if (mf12 == null) {
            return false;
        }
        if (mf1 != null && vn.p(mf12.f2368a, mf1.f2368a) <= 100.0d) {
            return false;
        }
        return true;
    }

    public String h(TripRequest tripRequest) {
        long currentTimeMillis = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        LocationTripRequest locationTripRequest = (LocationTripRequest) tripRequest;
        LatLng latLng = ((mf1) locationTripRequest.getFrom()).f2368a;
        LatLng latLng2 = ((mf1) locationTripRequest.getTo()).f2368a;
        int time = locationTripRequest.getTime();
        HashMap hashMap = new HashMap();
        hashMap.put("from_lat", String.valueOf(latLng.latitude));
        hashMap.put("from_lon", String.valueOf(latLng.longitude));
        hashMap.put("to_lat", String.valueOf(latLng2.latitude));
        hashMap.put("to_lon", String.valueOf(latLng2.longitude));
        hashMap.put("time", String.valueOf(time));
        String i0 = ui1.i0(g + "cabs/trip", hashMap);
        this.f3426a.a(new d70(i0, null, new c(i0, currentTimeMillis, uuid), new d(currentTimeMillis, uuid)));
        return uuid;
    }

    public String i(LatLng latLng, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        String uuid = UUID.randomUUID().toString();
        HashMap hashMap = new HashMap();
        hashMap.put("from_lat", String.valueOf(latLng.latitude));
        hashMap.put("from_lon", String.valueOf(latLng.longitude));
        String i0 = ui1.i0(g + "cabs/", hashMap);
        this.b = System.currentTimeMillis();
        this.f3426a.a(new d70(i0, null, new e(i0, currentTimeMillis, uuid, latLng, z), new f(currentTimeMillis, uuid, latLng)));
        return uuid;
    }

    public final void j(BookingDetails bookingDetails) {
        jz5.b().g(new AutoCabBookingEvent(bookingDetails.getCode(), bookingDetails));
    }

    public void k(String str, String str2, String str3) {
        String str4 = ut.t;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(str4).appendPath(str.toLowerCase()).appendPath("rideRequestMap");
        builder.appendQueryParameter("oauthToken", str3);
        builder.appendQueryParameter("requestId", str2);
        if (ut.A) {
            builder.appendQueryParameter("environment", "sandbox");
        }
        d70 d70 = new d70(builder.toString(), null, new a(), new b(this));
        d70.q = new nj1(2500, 5, 1.0f);
        this.f3426a.a(d70);
    }

    public final BookingDetails l(String str, JSONObject jSONObject, mf1 mf1, mf1 mf12, String str2, String str3, BookingDetails bookingDetails) throws JSONException {
        BookingDetails bookingDetails2 = this.d.getBookingDetails(jSONObject, new BookingDetails(str, mf1, mf12, str2, str3));
        if (bookingDetails == null) {
            xt.f3961a.f().f(bookingDetails2);
            bookingDetails = bookingDetails2;
        } else {
            if (bookingDetails2.getVehicleInfo() != null) {
                bookingDetails.setVehicleInfo(bookingDetails2.getVehicleInfo());
            }
            if (g(bookingDetails.getToLocation(), bookingDetails2.getToLocation())) {
                bookingDetails.setToLocation(bookingDetails2.getToLocation());
            }
            bookingDetails.setCode(bookingDetails2.getCode());
            if (bookingDetails2.getCurrentLocation() != null) {
                bookingDetails.setCurrentLocation(bookingDetails2.getCurrentLocation());
            }
            bookingDetails.setLastUpdatedTime(bookingDetails2.getLastUpdatedTime());
            if (bookingDetails2.getEta() > 0) {
                bookingDetails.setEta(bookingDetails2.getEta());
            }
            if (bookingDetails2.getSurgeMultiple() > 1.0d) {
                bookingDetails.setSurgeMultiple(bookingDetails2.getSurgeMultiple());
            }
            bookingDetails.setBearing(bookingDetails2.getBearing());
            bookingDetails.setCode(bookingDetails2.getCode());
            bookingDetails.setLastUpdatedTime(bookingDetails2.getLastUpdatedTime());
            bookingDetails.setBearing(bookingDetails2.getBearing());
            bookingDetails.setEta(bookingDetails2.getEta());
            if (bookingDetails2.getVehicleInfo() != null) {
                bookingDetails.setVehicleInfo(bookingDetails2.getVehicleInfo());
            }
            if (g(bookingDetails.getToLocation(), bookingDetails2.getToLocation())) {
                bookingDetails.setToLocation(bookingDetails2.getToLocation());
            }
            if (bookingDetails2.getCurrentLocation() != null) {
                bookingDetails.setCurrentLocation(bookingDetails2.getCurrentLocation());
            }
            if (bookingDetails2.getSurgeMultiple() > 1.0d) {
                bookingDetails.setSurgeMultiple(bookingDetails2.getSurgeMultiple());
            }
            xt.f3961a.f().f(bookingDetails);
        }
        j(bookingDetails);
        return bookingDetails;
    }

    public final void m(String str) {
        String str2;
        xt.t1 t1Var = xt.f3961a;
        BookingDetails b2 = t1Var.f().b();
        if (b2 != null && b2.getToLocation() != null && (str2 = b2.getToLocation().b) != null && str2.equals(str)) {
            b2.setToLocation(null);
            t1Var.f().f(b2);
        }
    }

    public void n(String str, String str2, mf1 mf1, mf1 mf12, AutoCabInfo autoCabInfo, String str3) {
        String str4 = ut.t;
        LatLng latLng = mf1.f2368a;
        String id = autoCabInfo.getId();
        LatLng latLng2 = mf12 != null ? mf12.f2368a : null;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(str4).appendPath(str.toLowerCase()).appendPath("requestRide");
        builder.appendQueryParameter("from_lat", hj1.U(new StringBuilder(), latLng.latitude, ""));
        builder.appendQueryParameter("from_lon", hj1.U(new StringBuilder(), latLng.longitude, ""));
        if (latLng2 != null) {
            builder.appendQueryParameter("to_lat", hj1.U(new StringBuilder(), latLng2.latitude, ""));
            builder.appendQueryParameter("to_lon", hj1.U(new StringBuilder(), latLng2.longitude, ""));
        }
        if (id != null) {
            builder.appendQueryParameter("product_id", id + "");
        }
        if (str3 != null) {
            builder.appendQueryParameter("surgeConfirmationId", str3 + "");
        }
        if (ut.A) {
            builder.appendQueryParameter("environment", "sandbox");
        }
        builder.appendQueryParameter("oauthToken", str2);
        String builder2 = builder.toString();
        this.b = System.currentTimeMillis();
        d70 d70 = new d70(builder2, null, new h(str, id, mf1, mf12, autoCabInfo, str3, str2), new i(str));
        d70.n = false;
        this.f3426a.a(d70);
    }

    public final void o(ad1 ad1, mf1 mf1, CabDestinationUpdatedEvent.CabDestinationStatus cabDestinationStatus) {
        jz5.b().i(new CabDestinationUpdatedEvent(ad1, mf1, cabDestinationStatus));
    }

    public void onEvent(ie1 ie1) {
        ad1 ad1 = ie1.c;
        String str = ie1.d;
        String str2 = this.e;
        if (str2 != null && str2.equals(str)) {
            if (ad1.equals(ad1.SUCCESS)) {
                mf1 mf1 = new mf1(ie1.f1509a, ie1.b);
                xt.t1 t1Var = xt.f3961a;
                if (t1Var.k().d().containsLocation(ie1.b)) {
                    e(mf1);
                } else {
                    t1Var.f().c = false;
                    m(ie1.f1509a);
                    o(ad1.FAILED, null, CabDestinationUpdatedEvent.CabDestinationStatus.GEOCODE_OUT_OF_BOUNDS);
                }
            } else {
                xt.f3961a.f().c = false;
                m(ie1.f1509a);
                o(ad1.FAILED, null, CabDestinationUpdatedEvent.CabDestinationStatus.GEOCODE_FAILURE);
            }
            jz5.b().m(ie1);
        }
    }

    public void p(String str, String str2, String str3) {
        String str4 = ut.t;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(str4).appendPath(str.toLowerCase()).appendPath("rideDetails");
        builder.appendQueryParameter("oauthToken", str2);
        builder.appendQueryParameter("requestId", str3);
        if (ut.A) {
            builder.appendQueryParameter("environment", "sandbox");
        }
        String builder2 = builder.toString();
        this.b = System.currentTimeMillis();
        xt.f3961a.l0().a(builder2, 5000, new g(str, str2, str3));
    }

    public void q(String str, String str2, String str3) {
        String str4 = ut.t;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(str4).appendPath(str.toLowerCase()).appendPath("rideDetails");
        builder.appendQueryParameter("oauthToken", str2);
        builder.appendQueryParameter("requestId", str3);
        if (ut.A) {
            builder.appendQueryParameter("environment", "sandbox");
        }
        xt.f3961a.l0().b(builder.toString());
    }
}
