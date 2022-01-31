package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.models.CardDetails;
import app.zophop.models.City;
import app.zophop.models.Guideline;
import app.zophop.models.Guidelines;
import app.zophop.models.RecentPaymentMethod;
import app.zophop.models.RouteDialogInfo;
import app.zophop.models.RouteInfo;
import app.zophop.models.RouteLevelAvailability;
import app.zophop.models.SavedCardDetails;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.SeatInfo;
import app.zophop.models.SuperSaver.RideInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.VehicleInfo;
import app.zophop.models.mTicketing.BasicProfileFields;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.BookingItemType;
import app.zophop.models.mTicketing.BookingPass;
import app.zophop.models.mTicketing.BookingTransaction;
import app.zophop.models.mTicketing.GroupTicket;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MTicketPassengerInfo;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import app.zophop.models.mTicketing.MagicPassesProperties;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.PayuUser;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductConfigurationMap;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.ProductDisplayProps;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.models.mTicketing.ProofUploadDocumentPropsIdentifier;
import app.zophop.models.mTicketing.RideDetails;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassApplicationStatus;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassPaymentConstants;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.pubsub.AutoLinkDeviceEvent;
import app.zophop.pubsub.eventbus.events.BookingTransactionEvent;
import app.zophop.pubsub.eventbus.events.CardValidityCheckEvent;
import app.zophop.pubsub.eventbus.events.CashPaymentEvent;
import app.zophop.pubsub.eventbus.events.ClearLoaderEvent;
import app.zophop.pubsub.eventbus.events.FareFetchRoutePassEvent;
import app.zophop.pubsub.eventbus.events.FaresFetchedEvent;
import app.zophop.pubsub.eventbus.events.FetchRoutePassEvent;
import app.zophop.pubsub.eventbus.events.FetchRoutesEvent;
import app.zophop.pubsub.eventbus.events.FreeRidesCountEvent;
import app.zophop.pubsub.eventbus.events.ImageUploadUrlEvent;
import app.zophop.pubsub.eventbus.events.LpInitiatePayResponseEvent;
import app.zophop.pubsub.eventbus.events.PassPunchEvent;
import app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent;
import app.zophop.pubsub.eventbus.events.RazorPayOrderData;
import app.zophop.pubsub.eventbus.events.RazorPayVerificationStatus;
import app.zophop.pubsub.eventbus.events.RazorpayPaymentFetchEvent;
import app.zophop.pubsub.eventbus.events.SeatAvailabilityStatusEvent;
import app.zophop.pubsub.eventbus.events.TransactionsFetchedOnlineEvent;
import app.zophop.pubsub.eventbus.events.UpdateTimeoutEvent;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import app.zophop.room.Pass;
import app.zophop.room.PassApplications;
import app.zophop.room.ProductRepository;
import app.zophop.room.ScanPay;
import app.zophop.room.Ticket;
import app.zophop.ui.activities.SuperPassPurchaseActivity;
import app.zophop.ui.activities.UserProfileActivity;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.razorpay.AnalyticsConstants;
import com.razorpay.BaseConstants;
import defpackage.d60;
import defpackage.kh1;
import defpackage.ut;
import defpackage.xj1;
import defpackage.xt;
import defpackage.yj1;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.Constants;
import server.zophop.logging.LoggingConstants;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: n00  reason: default package */
/* compiled from: BookingFeature */
public class n00 implements d20 {
    public Map<String, Map<String, String>> A;
    public Map<ProofUploadDocumentPropsIdentifier, ProofDocumentProps> B;
    public boolean C;
    public rf1 D;

    /* renamed from: a  reason: collision with root package name */
    public final rf1 f2466a;
    public final rf1 b;
    public final rf1 c;
    public final rf1 d;
    public final rf1 e;
    public final rf1 f;
    public final rf1 g;
    public final rf1 h;
    public final rf1 i;
    public final rf1 j;
    public final rf1 k;
    public final rf1 l;
    public final rf1 m;
    public final rf1 n;
    public final rf1 o;
    public final ov p = new ov();
    public final xj1 q;
    public final Context r;
    public final String s = ut.i;
    public final String t;
    public final yd1 u;
    public ProductConfigurationMap v;
    public List<ProductDisplayProps> w;
    public final rf1 x;
    public final rf1 y;
    public final rf1 z;

    /* renamed from: n00$a */
    /* compiled from: BookingFeature */
    public class a implements Runnable {
        public final /* synthetic */ MPass f;
        public final /* synthetic */ String g;

        public a(MPass mPass, String str) {
            this.f = mPass;
            this.g = str;
        }

        public void run() {
            HashMap m0 = hj1.m0("passId", this.f.getBookingPassId());
            m0.put("userId", this.f.getUserProfile().getUserId());
            m0.put(AnalyticsConstants.TOKEN, this.g);
            m0.put(SuperPassJsonKeys.PUNCHING_TIME, Long.valueOf(System.currentTimeMillis()));
            m0.put("city", this.f.getCity());
            ((ce1) n00.this.u).c(new zd1(f50.PUNCH_PASS.name(), m0));
            n00.this.S(this.f, true);
            jz5.b().g(new PassPunchEvent(ad1.SUCCESS, null, this.f));
        }
    }

    /* renamed from: n00$a0 */
    /* compiled from: BookingFeature */
    public class a0 implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f2467a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ long e;

        public a0(Bitmap bitmap, String str, String str2, String str3, long j) {
            this.f2467a = bitmap;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = j;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            tj1 tj1 = dk1.f;
            if (tj1 == null || tj1.f3365a != 401) {
                xt.t1 t1Var = xt.f3961a;
                xt.z0 = 0;
                long currentTimeMillis = System.currentTimeMillis() - this.e;
                ImageUploadUrlEvent imageUploadUrlEvent = new ImageUploadUrlEvent("", this.b, this.c, this.d);
                imageUploadUrlEvent.setResponseTime(currentTimeMillis);
                imageUploadUrlEvent.setResponseType(ad1.FAILED);
                imageUploadUrlEvent.setFailureReason(dk1.getMessage());
                jz5.b().i(imageUploadUrlEvent);
                return;
            }
            xt.t1 t1Var2 = xt.f3961a;
            if (xt.z0 < 4) {
                t1Var2.c().H(this.f2467a, this.b, this.c, this.d);
                t1Var2.o0();
                return;
            }
            xt.z0 = 0;
            n00.this.v(ut.k);
            long currentTimeMillis2 = System.currentTimeMillis() - this.e;
            ImageUploadUrlEvent imageUploadUrlEvent2 = new ImageUploadUrlEvent("", this.b, this.c, this.d);
            imageUploadUrlEvent2.setResponseTime(currentTimeMillis2);
            imageUploadUrlEvent2.setResponseType(ad1.FAILED);
            imageUploadUrlEvent2.setFailureReason(dk1.getMessage());
            jz5.b().i(imageUploadUrlEvent2);
        }
    }

    /* renamed from: n00$a1 */
    /* compiled from: BookingFeature */
    public interface a1 {
    }

    /* renamed from: n00$b */
    /* compiled from: BookingFeature */
    public class b implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BookingTransaction f2468a;

        public b(n00 n00, BookingTransaction bookingTransaction) {
            this.f2468a = bookingTransaction;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                CashPaymentEvent cashPaymentEvent = new CashPaymentEvent(jSONObject.getString("userId"), jSONObject.getString(SuperPassJsonKeys.REFERENCE_ID), jSONObject.getDouble(AnalyticsConstants.AMOUNT), this.f2468a);
                cashPaymentEvent.setResponse(ad1.SUCCESS);
                jz5.b().g(cashPaymentEvent);
            } catch (JSONException e) {
                CashPaymentEvent cashPaymentEvent2 = new CashPaymentEvent();
                cashPaymentEvent2.setResponse(ad1.FAILED);
                jz5.b().g(cashPaymentEvent2);
                e.printStackTrace();
            }
        }
    }

    /* renamed from: n00$b0 */
    /* compiled from: BookingFeature */
    public class b0 extends kh1 {
        public final /* synthetic */ Bitmap x;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b0(int i, String str, yj1.b bVar, yj1.a aVar, Bitmap bitmap) {
            super(i, str, bVar, aVar);
            this.x = bitmap;
        }

        @Override // defpackage.kh1
        public Map<String, kh1.a> J() {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            hashMap.put("file", new kh1.a(this, currentTimeMillis + ".png", n00.this.v0(this.x)));
            return hashMap;
        }

        @Override // defpackage.wj1
        public Map<String, String> m() {
            HashMap hashMap = new HashMap();
            SharedPreferences sharedPreferences = n00.this.r.getSharedPreferences("accessToken", 0);
            sharedPreferences.edit();
            xt.t1 t1Var = xt.f3961a;
            hashMap.put("userId", t1Var.L().getUserId());
            hashMap.put("authType", "ACCESS_TOKEN");
            hashMap.put("deviceId", t1Var.n().a());
            hashMap.put("accessToken", sharedPreferences.getString("accessToken", null));
            return hashMap;
        }

        @Override // defpackage.wj1
        public Map<String, String> o() {
            HashMap hashMap = new HashMap();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("fileType", "Image");
            hashMap.put("info", jsonObject.toString());
            return hashMap;
        }
    }

    /* renamed from: n00$c */
    /* compiled from: BookingFeature */
    public class c implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MPass f2469a;
        public final /* synthetic */ String b;

        public c(n00 n00, MPass mPass, String str) {
            this.f2469a = mPass;
            this.b = str;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            CashPaymentEvent cashPaymentEvent = new CashPaymentEvent();
            cashPaymentEvent.setResponse(ad1.FAILED);
            cashPaymentEvent.setFailureReason(str);
            jz5.b().g(cashPaymentEvent);
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.f3961a.c().c0(this.f2469a, this.b);
        }
    }

    /* renamed from: n00$c0 */
    /* compiled from: BookingFeature */
    public class c0 implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2470a;

        public c0(n00 n00, String str) {
            this.f2470a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            c0 c0Var;
            JSONException e;
            RouteStopsInfo routeStopsInfo;
            Iterator<String> it;
            double d;
            LinkedHashMap linkedHashMap;
            LinkedHashMap linkedHashMap2;
            JSONObject jSONObject2 = jSONObject;
            try {
                xt.t1 t1Var = xt.f3961a;
                xt.z0 = 0;
                jSONObject2.toString();
                JSONObject optJSONObject = jSONObject2.optJSONObject("fares");
                if (optJSONObject != null) {
                    double optDouble = optJSONObject.optDouble("discountPercentage", FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    int optInt = optJSONObject.optInt("roundingLogic", 0);
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("passengerDetails");
                    HashMap hashMap = new HashMap();
                    if (optJSONObject2 != null) {
                        try {
                            Iterator<String> keys = optJSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                JSONObject jSONObject3 = optJSONObject2.getJSONObject(next);
                                double d2 = jSONObject3.getDouble("f");
                                double optDouble2 = jSONObject3.optDouble("ff");
                                double optDouble3 = jSONObject3.optDouble("d", optDouble);
                                JSONObject optJSONObject3 = jSONObject3.optJSONObject("f_br");
                                if (optJSONObject3 != null) {
                                    linkedHashMap = new LinkedHashMap();
                                    d = optDouble;
                                    linkedHashMap2 = new LinkedHashMap();
                                    JSONObject optJSONObject4 = optJSONObject3.optJSONObject("a");
                                    it = keys;
                                    JSONObject optJSONObject5 = optJSONObject3.optJSONObject("s");
                                    if (optJSONObject4 != null) {
                                        for (Iterator<String> keys2 = optJSONObject4.keys(); keys2.hasNext(); keys2 = keys2) {
                                            String next2 = keys2.next();
                                            linkedHashMap.put(next2, Double.valueOf(optJSONObject4.getDouble(next2)));
                                            optJSONObject4 = optJSONObject4;
                                        }
                                    }
                                    if (optJSONObject5 != null) {
                                        Iterator<String> keys3 = optJSONObject5.keys();
                                        while (keys3.hasNext()) {
                                            String next3 = keys3.next();
                                            linkedHashMap2.put(next3, Double.valueOf(optJSONObject5.getDouble(next3)));
                                            optJSONObject5 = optJSONObject5;
                                        }
                                    }
                                } else {
                                    d = optDouble;
                                    it = keys;
                                    linkedHashMap = null;
                                    linkedHashMap2 = null;
                                }
                                MTicketPassengerInfo mTicketPassengerInfo = new MTicketPassengerInfo(d2, optDouble3, 0, optInt);
                                mTicketPassengerInfo.set_totalFare(optDouble2);
                                mTicketPassengerInfo.set_addMap(linkedHashMap);
                                mTicketPassengerInfo.set_subMap(linkedHashMap2);
                                hashMap.put(next, mTicketPassengerInfo);
                                optJSONObject2 = optJSONObject2;
                                optDouble = d;
                                keys = it;
                                jSONObject2 = jSONObject2;
                            }
                            JSONObject optJSONObject6 = jSONObject2.optJSONObject("routeDetails");
                            if (optJSONObject6 != null) {
                                routeStopsInfo = new RouteStopsInfo(null, null, optJSONObject6.getString("startStageId"), optJSONObject6.getString("startStageName"), optJSONObject6.getString("endStageId"), optJSONObject6.getString("endStageName"));
                                c0Var = this;
                                jz5.b().i(new FaresFetchedEvent(c0Var.f2470a, ad1.SUCCESS, null, hashMap, routeStopsInfo));
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            c0Var = this;
                            b00 b00 = b00.f358a;
                            b00.a().b(e);
                            e.printStackTrace();
                            jz5.b().i(new FaresFetchedEvent(c0Var.f2470a, ad1.FAILED, e.getLocalizedMessage(), null, null));
                        }
                    }
                    routeStopsInfo = null;
                    c0Var = this;
                    try {
                        jz5.b().i(new FaresFetchedEvent(c0Var.f2470a, ad1.SUCCESS, null, hashMap, routeStopsInfo));
                    } catch (JSONException e3) {
                        e = e3;
                        b00 b002 = b00.f358a;
                        b00.a().b(e);
                        e.printStackTrace();
                        jz5.b().i(new FaresFetchedEvent(c0Var.f2470a, ad1.FAILED, e.getLocalizedMessage(), null, null));
                    }
                } else {
                    jz5.b().i(new FaresFetchedEvent(this.f2470a, ad1.FAILED, "Something went wrong", null, null));
                }
            } catch (JSONException e4) {
                e = e4;
                c0Var = this;
                b00 b0022 = b00.f358a;
                b00.a().b(e);
                e.printStackTrace();
                jz5.b().i(new FaresFetchedEvent(c0Var.f2470a, ad1.FAILED, e.getLocalizedMessage(), null, null));
            }
        }
    }

    /* renamed from: n00$d */
    /* compiled from: BookingFeature */
    public class d implements yj1.b<String> {
        public d(n00 n00) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            RazorpayPaymentFetchEvent razorpayPaymentFetchEvent = new RazorpayPaymentFetchEvent();
            razorpayPaymentFetchEvent.setResponse(ad1.SUCCESS);
            razorpayPaymentFetchEvent.setPaymentMethods(str);
            jz5.b().g(razorpayPaymentFetchEvent);
        }
    }

    /* renamed from: n00$d0 */
    /* compiled from: BookingFeature */
    public class d0 implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2471a;
        public final /* synthetic */ String b;
        public final /* synthetic */ RouteStopsInfo c;
        public final /* synthetic */ String d;

        public d0(n00 n00, String str, String str2, RouteStopsInfo routeStopsInfo, String str3) {
            this.f2471a = str;
            this.b = str2;
            this.c = routeStopsInfo;
            this.d = str3;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            jz5.b().i(new FaresFetchedEvent(this.d, ad1.FAILED, str, null, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.f3961a.c().P(this.f2471a, this.b, this.c, this.d);
        }
    }

    /* renamed from: n00$e */
    /* compiled from: BookingFeature */
    public class e implements yj1.a {
        public e(n00 n00) {
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            RazorpayPaymentFetchEvent razorpayPaymentFetchEvent = new RazorpayPaymentFetchEvent();
            razorpayPaymentFetchEvent.setResponse(ad1.FAILED);
            razorpayPaymentFetchEvent.setPaymentMethods(dk1.getMessage());
            jz5.b().g(razorpayPaymentFetchEvent);
        }
    }

    /* renamed from: n00$e0 */
    /* compiled from: BookingFeature */
    public class e0 implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanPayTicket f2472a;
        public final /* synthetic */ String b;
        public final /* synthetic */ BookingTransaction c;

        public e0(ScanPayTicket scanPayTicket, String str, BookingTransaction bookingTransaction) {
            this.f2472a = scanPayTicket;
            this.b = str;
            this.c = bookingTransaction;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n00.this.u0(str, this.c);
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.f3961a.c().p0(this.f2472a, this.b);
        }
    }

    /* renamed from: n00$f */
    /* compiled from: BookingFeature */
    public class f implements yj1.b<String> {
        public f(n00 n00) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONObject(str2).getJSONArray("vehicle");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new SeatInfo(jSONObject.getString("number"), jSONObject.getInt("status")));
                }
            } catch (JSONException unused) {
            }
            SeatAvailabilityStatusEvent seatAvailabilityStatusEvent = new SeatAvailabilityStatusEvent();
            seatAvailabilityStatusEvent.setSeatInfoList(arrayList);
            seatAvailabilityStatusEvent.setResponseType(ad1.SUCCESS);
            jz5.b().g(seatAvailabilityStatusEvent);
        }
    }

    /* renamed from: n00$f0 */
    /* compiled from: BookingFeature */
    public class f0 implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2473a;

        public f0(n00 n00, String str) {
            this.f2473a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            try {
                jz5.b().i(new AutoLinkDeviceEvent(this.f2473a, new JSONObject(str).optBoolean("isDeviceUpdated", false)));
            } catch (Exception e) {
                e.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e);
                jz5.b().i(new AutoLinkDeviceEvent(this.f2473a, e.getMessage()));
            }
        }
    }

    /* renamed from: n00$g */
    /* compiled from: BookingFeature */
    public class g implements yj1.a {
        public g(n00 n00) {
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            tj1 tj1 = dk1.f;
            if (!(tj1 == null || tj1.b == null)) {
                dk1 = new dk1(new String(dk1.f.b));
            }
            SeatAvailabilityStatusEvent seatAvailabilityStatusEvent = new SeatAvailabilityStatusEvent();
            seatAvailabilityStatusEvent.setResponseType(ad1.FAILED);
            seatAvailabilityStatusEvent.setError(dk1.getMessage());
            jz5.b().g(seatAvailabilityStatusEvent);
        }
    }

    /* renamed from: n00$g0 */
    /* compiled from: BookingFeature */
    public class g0 implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2474a;

        public g0(n00 n00, String str) {
            this.f2474a = str;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            b00 b00 = b00.f358a;
            b00.a().b(dk1);
            jz5.b().i(new AutoLinkDeviceEvent(this.f2474a, dk1.getLocalizedMessage()));
        }
    }

    /* renamed from: n00$h */
    /* compiled from: BookingFeature */
    public class h implements yj1.b<String> {
        public h(n00 n00) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = new JSONObject(str2).getJSONArray("vehicle");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    arrayList.add(new SeatInfo(jSONObject.getString("number"), jSONObject.getInt("status")));
                }
            } catch (JSONException unused) {
            }
            SeatAvailabilityStatusEvent seatAvailabilityStatusEvent = new SeatAvailabilityStatusEvent();
            seatAvailabilityStatusEvent.setSeatInfoList(arrayList);
            seatAvailabilityStatusEvent.setResponseType(ad1.SUCCESS);
            jz5.b().g(seatAvailabilityStatusEvent);
        }
    }

    /* renamed from: n00$h0 */
    /* compiled from: BookingFeature */
    public class h0 implements Comparator<ProductDiscountsObject>, j$.util.Comparator {
        public h0(n00 n00) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(ProductDiscountsObject productDiscountsObject, ProductDiscountsObject productDiscountsObject2) {
            return productDiscountsObject.getOrder() - productDiscountsObject2.getOrder();
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<ProductDiscountsObject> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<ProductDiscountsObject> thenComparing(java.util.Comparator<? super ProductDiscountsObject> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: n00$i */
    /* compiled from: BookingFeature */
    public class i implements xj1.b {
        public i(n00 n00) {
        }

        @Override // defpackage.xj1.b
        public boolean a(wj1<?> wj1) {
            return true;
        }
    }

    /* renamed from: n00$i0 */
    /* compiled from: BookingFeature */
    public class i0 implements yj1.b<JSONArray> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2475a;

        public i0(n00 n00, String str) {
            this.f2475a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONArray jSONArray) {
            jz5.b().i(new FetchRoutePassEvent(ad1.SUCCESS, null, new rv().d(jSONArray), this.f2475a));
        }
    }

    /* renamed from: n00$j */
    /* compiled from: BookingFeature */
    public class j implements yj1.a {
        public j(n00 n00) {
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            tj1 tj1 = dk1.f;
            if (!(tj1 == null || tj1.b == null)) {
                dk1 = new dk1(new String(dk1.f.b));
            }
            SeatAvailabilityStatusEvent seatAvailabilityStatusEvent = new SeatAvailabilityStatusEvent();
            seatAvailabilityStatusEvent.setResponseType(ad1.FAILED);
            seatAvailabilityStatusEvent.setError(dk1.getMessage());
            jz5.b().g(seatAvailabilityStatusEvent);
        }
    }

    /* renamed from: n00$j0 */
    /* compiled from: BookingFeature */
    public class j0 implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2476a;

        public j0(n00 n00, String str) {
            this.f2476a = str;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            dk1.getMessage();
            jz5.b().i(new FetchRoutePassEvent(ad1.FAILED, dk1.getLocalizedMessage(), null, this.f2476a));
        }
    }

    /* renamed from: n00$k */
    /* compiled from: BookingFeature */
    public class k implements yj1.b<String> {
        public k(n00 n00) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                LpInitiatePayResponseEvent lpInitiatePayResponseEvent = new LpInitiatePayResponseEvent(jSONObject.getString("checkoutPageUrl"), jSONObject.optString("lpTxnId"));
                lpInitiatePayResponseEvent.set_responseType(ad1.SUCCESS);
                jz5.b().i(lpInitiatePayResponseEvent);
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
                e.printStackTrace();
                LpInitiatePayResponseEvent lpInitiatePayResponseEvent2 = new LpInitiatePayResponseEvent();
                lpInitiatePayResponseEvent2.set_responseType(ad1.FAILED);
                jz5.b().i(lpInitiatePayResponseEvent2);
            }
        }
    }

    /* renamed from: n00$k0 */
    /* compiled from: BookingFeature */
    public class k0 implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2477a;
        public final /* synthetic */ String b;

        public k0(String str, String str2) {
            this.f2477a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            k0 k0Var;
            JSONException e;
            try {
                JSONObject jSONObject = new JSONObject(str).getJSONObject("fareMapping");
                n00.this.J0(jSONObject, this.f2477a);
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        ArrayList arrayList = new ArrayList();
                        JSONArray jSONArray = jSONObject.getJSONArray(next);
                        int i = 0;
                        while (i < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            long j = jSONObject2.getLong("durationId");
                            int i2 = jSONObject2.getInt(SuperPassJsonKeys.FARE);
                            int i3 = jSONObject2.getInt("discountedFare");
                            int optInt = jSONObject2.optInt("discountPercentage");
                            boolean optBoolean = jSONObject2.optBoolean("isActive", true);
                            String optString = jSONObject2.optString("inactiveReason", null);
                            String optString2 = jSONObject2.optString("dInfo");
                            String optString3 = jSONObject2.optString("info");
                            String optString4 = jSONObject2.optString(SuperPassJsonKeys.FARE_MAPPING_DESCRIPTION);
                            int optInt2 = jSONObject2.optInt(SuperPassJsonKeys.NUM_OF_TRIPS, -1);
                            int optInt3 = jSONObject2.optInt(SuperPassJsonKeys.MAX_TRIPS_PER_DAY, -1);
                            boolean optBoolean2 = jSONObject2.optBoolean("isVisible", true);
                            int optInt4 = jSONObject2.optInt(SuperPassJsonKeys.FARE_MAPPING_ID, 0);
                            String optString5 = jSONObject2.optString("subCatId", null);
                            double optDouble = jSONObject2.optDouble(SuperPassJsonKeys.MAX_PRICE_PER_TRIP, -1.0d);
                            String optString6 = jSONObject2.optString(SuperPassJsonKeys.FARE_MAPPING_DISPLAY_NAME);
                            JSONArray optJSONArray = jSONObject2.optJSONArray("specialFeatures");
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(SuperPassJsonKeys.PROOFS);
                            boolean optBoolean3 = jSONObject2.optBoolean(SuperPassJsonKeys.IS_RENEWABLE, false);
                            boolean optBoolean4 = jSONObject2.optBoolean("verification");
                            ArrayList arrayList2 = new ArrayList();
                            if (optJSONArray2 != null) {
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    arrayList2.add(optJSONArray2.getString(i4));
                                }
                            }
                            ArrayList arrayList3 = new ArrayList();
                            if (optJSONArray != null) {
                                for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                                    arrayList3.add(optJSONArray.getString(i5));
                                }
                            }
                            ProductFareMapping productFareMapping = new ProductFareMapping();
                            productFareMapping.setFareMappingId(optInt4);
                            productFareMapping.setSubCategoryId(optString5);
                            productFareMapping.setCategoryId(next);
                            productFareMapping.setIsVisible(optBoolean2);
                            productFareMapping.setDurationId(j);
                            productFareMapping.setMaxRides(optInt2);
                            productFareMapping.setMaxRidesPerDay(optInt3);
                            productFareMapping.setMaxPricePerRide(optDouble);
                            productFareMapping.setFare(i2);
                            productFareMapping.setDiscountFare(i3);
                            productFareMapping.setSpecialFeatures(arrayList3);
                            productFareMapping.setDiscountPercentage(optInt);
                            productFareMapping.setDesc(optString4);
                            productFareMapping.setProductDisplayName(optString6);
                            productFareMapping.setAdditionalInfo(optString2);
                            productFareMapping.setDurationInfo(optString3);
                            productFareMapping.setIsActive(Boolean.valueOf(optBoolean));
                            productFareMapping.setInactiveReason(optString);
                            productFareMapping.setProofsRequiredList(arrayList2);
                            productFareMapping.setIsRenewable(Boolean.valueOf(optBoolean3));
                            productFareMapping.setIsVerificationRequired(Boolean.valueOf(optBoolean4));
                            i++;
                            keys = keys;
                            jSONObject = jSONObject;
                            jSONArray = jSONArray;
                            hashMap = hashMap;
                            arrayList = arrayList;
                        }
                        hashMap.put(next, arrayList);
                        hashMap = hashMap;
                        keys = keys;
                        jSONObject = jSONObject;
                    } catch (JSONException e2) {
                        e = e2;
                        k0Var = this;
                        jz5.b().g(new FareFetchRoutePassEvent(k0Var.b, ad1.FAILED, e.getMessage(), null));
                        e.printStackTrace();
                    }
                }
                k0Var = this;
                try {
                    jz5.b().g(new FareFetchRoutePassEvent(k0Var.b, ad1.SUCCESS, null, hashMap));
                } catch (JSONException e3) {
                    e = e3;
                }
            } catch (JSONException e4) {
                e = e4;
                k0Var = this;
                jz5.b().g(new FareFetchRoutePassEvent(k0Var.b, ad1.FAILED, e.getMessage(), null));
                e.printStackTrace();
            }
        }
    }

    /* renamed from: n00$l */
    /* compiled from: BookingFeature */
    public class l implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2478a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        public l(n00 n00, String str, String str2, String str3) {
            this.f2478a = str;
            this.b = str2;
            this.c = str3;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            LpInitiatePayResponseEvent lpInitiatePayResponseEvent = new LpInitiatePayResponseEvent();
            lpInitiatePayResponseEvent.set_responseType(ad1.FAILED);
            jz5.b().i(lpInitiatePayResponseEvent);
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.f3961a.c().V(this.f2478a, this.b, this.c);
        }
    }

    /* renamed from: n00$l0 */
    /* compiled from: BookingFeature */
    public class l0 implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2479a;

        public l0(n00 n00, String str) {
            this.f2479a = str;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            jz5.b().g(new FareFetchRoutePassEvent(this.f2479a, ad1.FAILED, dk1.getLocalizedMessage(), null));
        }
    }

    /* renamed from: n00$m */
    /* compiled from: BookingFeature */
    public class m implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a1 f2480a;

        public m(a1 a1Var) {
            this.f2480a = a1Var;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("status");
                String string2 = jSONObject.getString("accessToken");
                String string3 = jSONObject.getString("refreshToken");
                SharedPreferences.Editor edit = n00.this.r.getSharedPreferences("accessToken", 0).edit();
                n00.s0(n00.this, xt.f3961a.L().getUserId(), string);
                if (Integer.parseInt(string) == 1) {
                    edit.putString("status", string);
                    edit.commit();
                    edit.putString("accessToken", string2);
                    edit.commit();
                    edit.putString("refreshToken", string3);
                    edit.commit();
                    ui1.k(n00.this.r, string2);
                    d60.a aVar = (d60.a) this.f2480a;
                    Objects.requireNonNull(aVar);
                    try {
                        d60.this.invoke(aVar.f795a, aVar.b, aVar.c);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: n00$m0 */
    /* compiled from: BookingFeature */
    public class m0 implements yj1.b<JSONArray> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2481a;

        public m0(n00 n00, String str) {
            this.f2481a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONArray jSONArray) {
            jz5.b().i(new FetchRoutesEvent(ad1.SUCCESS, null, new rv().d(jSONArray), this.f2481a));
        }
    }

    /* renamed from: n00$n */
    /* compiled from: BookingFeature */
    public class n implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2482a;
        public final /* synthetic */ a1 b;

        public n(String str, a1 a1Var) {
            this.f2482a = str;
            this.b = a1Var;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (dk1.f != null) {
                n00.s0(n00.this, xt.f3961a.L().getUserId(), String.valueOf(dk1.f));
            }
            tj1 tj1 = dk1.f;
            if (tj1 == null || tj1.f3365a != 401) {
                SharedPreferences sharedPreferences = n00.this.r.getSharedPreferences("accessToken", 0);
                sharedPreferences.edit();
                if (Long.valueOf((Long.valueOf(sharedPreferences.getLong(SuperPassJsonKeys.EXPIRY_TIME, -1)).longValue() - Long.valueOf(System.currentTimeMillis() / 1000).longValue()) - Long.valueOf(sharedPreferences.getLong("delta", -1)).longValue()).longValue() > 120) {
                    d60.a aVar = (d60.a) this.b;
                    Objects.requireNonNull(aVar);
                    try {
                        aVar.b.invoke(d60.this.b, aVar.c);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    jz5.b().i(new ClearLoaderEvent());
                    Toast.makeText(n00.this.r, (int) R.string.refresh_call_failure, 0).show();
                }
            } else {
                n00.this.v(this.f2482a);
            }
        }
    }

    /* renamed from: n00$n0 */
    /* compiled from: BookingFeature */
    public class n0 implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BookingTransaction f2483a;

        public n0(BookingTransaction bookingTransaction) {
            this.f2483a = bookingTransaction;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.getBoolean("status")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("responseData");
                    boolean optBoolean = jSONObject2.optBoolean("lpEligible", false);
                    this.f2483a.setLpId(jSONObject2.optString("eligibilityResponseId"));
                    this.f2483a.setIsLpEligible(optBoolean);
                    n00.q0(n00.this, this.f2483a, jSONObject2);
                    return;
                }
                n00.this.u0(jSONObject.getString("message"), this.f2483a);
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                hj1.W0(e);
                n00.this.u0(e.getMessage(), this.f2483a);
            }
        }
    }

    /* renamed from: n00$o */
    /* compiled from: BookingFeature */
    public class o implements yj1.b<String> {
        public o(n00 n00) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String string = jSONObject.getString("status");
                String optString = jSONObject.optString(SuperPassJsonKeys.QR_CODE);
                String optString2 = jSONObject.optString(SuperPassJsonKeys.TONE);
                if (string.equals("SUCCESS")) {
                    jz5.b().i(new RazorPayVerificationStatus(ad1.SUCCESS, optString, null, optString2));
                } else if (string.equals("PENDING")) {
                    jz5.b().i(new RazorPayVerificationStatus(ad1.PENDING, optString, null, optString2));
                } else if (string.equals("FAILED")) {
                    jz5.b().i(new RazorPayVerificationStatus(ad1.FAILED, optString, null, optString2));
                }
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
                e.printStackTrace();
                jz5.b().i(new RazorPayVerificationStatus(ad1.UNKNOWN, null, "jsonException", null));
            }
        }
    }

    /* renamed from: n00$o0 */
    /* compiled from: BookingFeature */
    public class o0 implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2484a;

        public o0(n00 n00, String str) {
            this.f2484a = str;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            dk1.getMessage();
            jz5.b().i(new FetchRoutesEvent(ad1.FAILED, dk1.getLocalizedMessage(), null, this.f2484a));
        }
    }

    /* renamed from: n00$p */
    /* compiled from: BookingFeature */
    public class p implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2485a;
        public final /* synthetic */ String b;

        public p(n00 n00, String str, String str2) {
            this.f2485a = str;
            this.b = str2;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            jz5.b().i(new RazorPayVerificationStatus(ad1.UNKNOWN, null, str, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.f3961a.c().a(this.f2485a, this.b);
        }
    }

    /* renamed from: n00$p0 */
    /* compiled from: BookingFeature */
    public class p0 implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserProfile f2486a;
        public final /* synthetic */ BookingTransaction b;

        public p0(UserProfile userProfile, BookingTransaction bookingTransaction) {
            this.f2486a = userProfile;
            this.b = bookingTransaction;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.getBoolean("status")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("responseData");
                    t1Var.L().n(this.f2486a);
                    t1Var.L().s(this.f2486a);
                    t1Var.L().d(UserProfileEvent.TYPE.PROFILE_UPDATE);
                    boolean optBoolean = jSONObject2.optBoolean("lpEligible", false);
                    this.b.setLpId(jSONObject2.optString("eligibilityResponseId"));
                    this.b.setIsLpEligible(optBoolean);
                    n00.q0(n00.this, this.b, jSONObject2);
                    return;
                }
                n00.this.u0(jSONObject.getString("message"), this.b);
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                hj1.W0(e);
                n00.this.u0(e.getMessage(), this.b);
            }
        }
    }

    /* renamed from: n00$q */
    /* compiled from: BookingFeature */
    public class q implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2487a;
        public final /* synthetic */ String b;

        public q(String str, String str2) {
            this.f2487a = str;
            this.b = str2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            if (xt.f3961a.L().m()) {
                xt.z0 = 0;
                jSONObject2.toString();
                try {
                    if (jSONObject2.getBoolean("status")) {
                        JSONObject jSONObject3 = jSONObject2.getJSONObject("responseData");
                        n00.this.w0(jSONObject3.getString("scanPay"), jSONObject3.getString("recentTransactions"), jSONObject3.getString("passes"), this.f2487a, jSONObject3.optString("passApplications", null), jSONObject3.optString(AnalyticsConstants.PROPERTIES, null), jSONObject3.optString("ticket", null), jSONObject3.optJSONObject("configuration"), this.b);
                        return;
                    }
                    String string = jSONObject2.getString("message");
                    n00 n00 = n00.this;
                    ad1 ad1 = ad1.FAILED;
                    n00.K0(ad1);
                    jz5.b().i(new TransactionsFetchedOnlineEvent(ad1, string, this.f2487a));
                } catch (JSONException e) {
                    b00 b00 = b00.f358a;
                    hj1.W0(e);
                    n00 n002 = n00.this;
                    ad1 ad12 = ad1.FAILED;
                    n002.K0(ad12);
                    jz5.b().i(new TransactionsFetchedOnlineEvent(ad12, e.getLocalizedMessage(), this.f2487a));
                }
            }
        }
    }

    /* renamed from: n00$q0 */
    /* compiled from: BookingFeature */
    public class q0 implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MPass f2488a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ ProfileRequestInfo f;
        public final /* synthetic */ BookingTransaction g;

        public q0(MPass mPass, String str, String str2, String str3, String str4, ProfileRequestInfo profileRequestInfo, BookingTransaction bookingTransaction) {
            this.f2488a = mPass;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = profileRequestInfo;
            this.g = bookingTransaction;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n00.this.u0(str, this.g);
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.f3961a.c().A(this.f2488a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    /* renamed from: n00$r */
    /* compiled from: BookingFeature */
    public class r implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2489a;
        public final /* synthetic */ String b;

        public r(String str, String str2) {
            this.f2489a = str;
            this.b = str2;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n00 n00 = n00.this;
            ad1 ad1 = ad1.FAILED;
            n00.K0(ad1);
            jz5.b().i(new TransactionsFetchedOnlineEvent(ad1, str, this.f2489a));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.f3961a.c().d(this.f2489a, this.b);
        }
    }

    /* renamed from: n00$r0 */
    /* compiled from: BookingFeature */
    public class r0 implements yj1.b<String> {
        public r0(n00 n00) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            try {
                JSONObject jSONObject = (JSONObject) new JSONArray(str2).get(0);
                String string = jSONObject.getString("status");
                String optString = jSONObject.optString(SuperPassJsonKeys.QR_CODE);
                String optString2 = jSONObject.optString(SuperPassJsonKeys.TONE);
                if (string.equals("SUCCESS")) {
                    UpdateTimeoutEvent updateTimeoutEvent = new UpdateTimeoutEvent(ad1.SUCCESS);
                    updateTimeoutEvent.set_qrCode(optString);
                    updateTimeoutEvent.set_tone(optString2);
                    jz5.b().i(updateTimeoutEvent);
                } else if (string.equals("PENDING")) {
                    jz5.b().i(new UpdateTimeoutEvent(ad1.PENDING));
                } else if (string.equals("FAILED")) {
                    jz5.b().i(new UpdateTimeoutEvent(ad1.FAILED));
                } else {
                    jz5.b().i(new UpdateTimeoutEvent(ad1.UNKNOWN));
                }
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
                e.printStackTrace();
                jz5.b().i(new RazorPayVerificationStatus(ad1.UNKNOWN, null, "jsonException", null));
            }
        }
    }

    /* renamed from: n00$s */
    /* compiled from: BookingFeature */
    public class s implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2490a;

        public s(String str) {
            this.f2490a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            jSONObject2.toString();
            n00 n00 = n00.this;
            ov ovVar = n00.p;
            Objects.requireNonNull(ovVar);
            ProductConfigurationMap productConfigurationMap = null;
            ProductConfigurationMap productConfigurationMap2 = new ProductConfigurationMap();
            try {
                JSONArray jSONArray = jSONObject2.getJSONArray("products");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                    productConfigurationMap2.addConfiguration(jSONObject3.getString("agency"), ovVar.w(jSONObject3));
                }
                productConfigurationMap = productConfigurationMap2;
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                hj1.W0(e);
            }
            n00.v = productConfigurationMap;
            n00 n002 = n00.this;
            n002.w = n002.p.z(jSONObject2);
            n00 n003 = n00.this;
            n003.A = n003.p.A(jSONObject2);
            n00 n004 = n00.this;
            n004.B = n004.p.C(jSONObject2);
            n00 n005 = n00.this;
            n005.L0(n005.B);
            Map<String, Map<String, String>> map = n00.this.A;
            if (map != null) {
                for (Map.Entry<String, Map<String, String>> entry : map.entrySet()) {
                    String key = entry.getKey();
                    for (Map.Entry<String, String> entry2 : entry.getValue().entrySet()) {
                        n00.this.m.j(entry2.getKey(), key);
                        n00.this.y.j(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            List<ProductDisplayProps> list = n00.this.w;
            if (list != null && list.size() > 0) {
                n00 n006 = n00.this;
                Collections.sort(n006.w, new v(n006));
                for (int i2 = 0; i2 < n00.this.w.size(); i2++) {
                    n00 n007 = n00.this;
                    n007.x.j(n007.w.get(i2).getProductCategoryId(), n00.this.w.get(i2).getProductCategoryName());
                }
            }
            n00 n008 = n00.this;
            if (n008.v == null || n008.w.size() <= 0) {
                jz5.b().i(new ProductConfigurationFetchedEvent(ad1.FAILED, "Something went wrong", null, null, this.f2490a));
                return;
            }
            Map<String, String> y = n00.this.p.y(jSONObject2);
            if (y != null) {
                for (String str : y.keySet()) {
                    n00.this.l.j(str, y.get(str));
                }
            }
            jz5 b2 = jz5.b();
            ad1 ad1 = ad1.SUCCESS;
            n00 n009 = n00.this;
            b2.i(new ProductConfigurationFetchedEvent(ad1, null, n009.v, n009.w, this.f2490a));
        }
    }

    /* renamed from: n00$s0 */
    /* compiled from: BookingFeature */
    public class s0 implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f2491a;

        public s0(n00 n00, List list) {
            this.f2491a = list;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            jz5.b().i(new RazorPayVerificationStatus(ad1.UNKNOWN, null, str, null));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.f3961a.c().r(this.f2491a);
        }
    }

    /* renamed from: n00$t */
    /* compiled from: BookingFeature */
    public class t implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BookingTransaction f2492a;

        public t(BookingTransaction bookingTransaction) {
            this.f2492a = bookingTransaction;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.getBoolean("status")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("responseData");
                    boolean optBoolean = jSONObject2.optBoolean("lpEligible", false);
                    this.f2492a.setLpId(jSONObject2.optString("eligibilityResponseId"));
                    this.f2492a.setIsLpEligible(optBoolean);
                    n00.q0(n00.this, this.f2492a, jSONObject2);
                    return;
                }
                n00.this.u0(jSONObject.getString("message"), this.f2492a);
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                hj1.W0(e);
                n00.this.u0(e.getMessage(), this.f2492a);
            }
        }
    }

    /* renamed from: n00$t0 */
    /* compiled from: BookingFeature */
    public class t0 implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MPass f2493a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ BookingTransaction e;

        public t0(MPass mPass, String str, String str2, String str3, BookingTransaction bookingTransaction) {
            this.f2493a = mPass;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = bookingTransaction;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n00.this.u0(str, this.e);
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.f3961a.c().w(this.f2493a, this.b, this.c, this.d);
        }
    }

    /* renamed from: n00$u */
    /* compiled from: BookingFeature */
    public class u implements z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f2494a;

        public u(n00 n00, String str) {
            this.f2494a = str;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            jz5.b().g(new ProductConfigurationFetchedEvent(ad1.FAILED, dk1.getLocalizedMessage(), null, null, this.f2494a));
        }
    }

    /* renamed from: n00$u0 */
    /* compiled from: BookingFeature */
    public class u0 implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BookingTransaction f2495a;

        public u0(BookingTransaction bookingTransaction) {
            this.f2495a = bookingTransaction;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.getBoolean("status")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("responseData");
                    boolean optBoolean = jSONObject2.optBoolean("lpEligible", false);
                    this.f2495a.setLpId(jSONObject2.optString("eligibilityResponseId"));
                    this.f2495a.setIsLpEligible(optBoolean);
                    n00.q0(n00.this, this.f2495a, jSONObject2);
                    return;
                }
                BookingTransactionEvent bookingTransactionEvent = new BookingTransactionEvent(ad1.FAILED, jSONObject.getString("message"), this.f2495a, null, null, null, null, null, null);
                if (jSONObject.has("statusCode")) {
                    bookingTransactionEvent.setStatusCode(jSONObject.getString("statusCode"));
                }
                jz5.b().g(bookingTransactionEvent);
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                hj1.W0(e);
                n00.this.u0(e.getMessage(), this.f2495a);
            }
        }
    }

    /* renamed from: n00$v */
    /* compiled from: BookingFeature */
    public class v implements java.util.Comparator<ProductDisplayProps>, j$.util.Comparator {
        public v(n00 n00) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(ProductDisplayProps productDisplayProps, ProductDisplayProps productDisplayProps2) {
            return productDisplayProps.getDisplayOrder() - productDisplayProps2.getDisplayOrder();
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<ProductDisplayProps> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<ProductDisplayProps> thenComparing(java.util.Comparator<? super ProductDisplayProps> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: n00$v0 */
    /* compiled from: BookingFeature */
    public class v0 implements y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MTicket f2496a;
        public final /* synthetic */ String b;
        public final /* synthetic */ ProfileRequestInfo c;
        public final /* synthetic */ BookingTransaction d;

        public v0(MTicket mTicket, String str, ProfileRequestInfo profileRequestInfo, BookingTransaction bookingTransaction) {
            this.f2496a = mTicket;
            this.b = str;
            this.c = profileRequestInfo;
            this.d = bookingTransaction;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            n00.this.u0(str, this.d);
        }

        @Override // defpackage.n00.y0
        public void execute() {
            xt.t1 t1Var = xt.f3961a;
            t1Var.c().B(this.f2496a, t1Var.L().j(), this.b, this.c);
        }
    }

    /* renamed from: n00$w */
    /* compiled from: BookingFeature */
    public class w implements yj1.b<tj1> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f2497a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;

        public w(long j, String str, int i) {
            this.f2497a = j;
            this.b = str;
            this.c = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(tj1 tj1) {
            tj1 tj12 = tj1;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            long currentTimeMillis = System.currentTimeMillis() - this.f2497a;
            ((ik1) n00.this.q.e).a();
            try {
                JSONObject jSONObject = new JSONObject(new String(tj12.b));
                jSONObject.toString().replace("\\\\", "");
                ImageUploadUrlEvent imageUploadUrlEvent = new ImageUploadUrlEvent(jSONObject.getString("url"), this.b, this.c);
                imageUploadUrlEvent.setResponseTime(currentTimeMillis);
                imageUploadUrlEvent.setResponseType(ad1.SUCCESS);
                jz5.b().i(imageUploadUrlEvent);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: n00$w0 */
    /* compiled from: BookingFeature */
    public class w0 implements yj1.b<JSONObject> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RouteInfo f2498a;

        public w0(n00 n00, RouteInfo routeInfo) {
            this.f2498a = routeInfo;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            JSONObject jSONObject2 = jSONObject;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            jSONObject2.toString();
            try {
                if (jSONObject2.getBoolean("status")) {
                    jz5.b().i(new FreeRidesCountEvent(ad1.SUCCESS, jSONObject2.getJSONObject("responseData").getInt("freeRides"), this.f2498a));
                    return;
                }
                jz5.b().i(new FreeRidesCountEvent(ad1.FAILED, jSONObject2.getString("message"), this.f2498a));
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
                e.printStackTrace();
                jz5.b().i(new FreeRidesCountEvent(ad1.FAILED, e.getLocalizedMessage(), this.f2498a));
            }
        }
    }

    /* renamed from: n00$x */
    /* compiled from: BookingFeature */
    public class x implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Bitmap f2499a;
        public final /* synthetic */ String b;
        public final /* synthetic */ int c;
        public final /* synthetic */ long d;

        public x(Bitmap bitmap, String str, int i, long j) {
            this.f2499a = bitmap;
            this.b = str;
            this.c = i;
            this.d = j;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            tj1 tj1 = dk1.f;
            if (tj1 == null || tj1.f3365a != 401) {
                xt.t1 t1Var = xt.f3961a;
                xt.z0 = 0;
                long currentTimeMillis = System.currentTimeMillis() - this.d;
                ImageUploadUrlEvent imageUploadUrlEvent = new ImageUploadUrlEvent("", this.b, this.c);
                imageUploadUrlEvent.setResponseTime(currentTimeMillis);
                imageUploadUrlEvent.setResponseType(ad1.FAILED);
                imageUploadUrlEvent.setFailureReason(dk1.getMessage());
                jz5.b().i(imageUploadUrlEvent);
                return;
            }
            xt.t1 t1Var2 = xt.f3961a;
            if (xt.z0 < 4) {
                t1Var2.c().i(this.f2499a, this.b, this.c);
                t1Var2.o0();
                return;
            }
            xt.z0 = 0;
            n00.this.v(ut.k);
            long currentTimeMillis2 = System.currentTimeMillis() - this.d;
            ImageUploadUrlEvent imageUploadUrlEvent2 = new ImageUploadUrlEvent("", this.b, this.c);
            imageUploadUrlEvent2.setResponseTime(currentTimeMillis2);
            imageUploadUrlEvent2.setResponseType(ad1.FAILED);
            imageUploadUrlEvent2.setFailureReason(dk1.getMessage());
            jz5.b().i(imageUploadUrlEvent2);
        }
    }

    /* renamed from: n00$x0 */
    /* compiled from: BookingFeature */
    public class x0 implements z0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RouteInfo f2500a;

        public x0(n00 n00, RouteInfo routeInfo) {
            this.f2500a = routeInfo;
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            jz5.b().i(new FreeRidesCountEvent(ad1.FAILED, dk1.getMessage(), this.f2500a));
        }
    }

    /* renamed from: n00$y */
    /* compiled from: BookingFeature */
    public class y extends kh1 {
        public final /* synthetic */ Bitmap x;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public y(int i, String str, yj1.b bVar, yj1.a aVar, Bitmap bitmap) {
            super(i, str, bVar, aVar);
            this.x = bitmap;
        }

        @Override // defpackage.kh1
        public Map<String, kh1.a> J() {
            HashMap hashMap = new HashMap();
            long currentTimeMillis = System.currentTimeMillis();
            hashMap.put("file", new kh1.a(this, currentTimeMillis + ".png", n00.this.v0(this.x)));
            return hashMap;
        }

        @Override // defpackage.wj1
        public Map<String, String> m() {
            HashMap hashMap = new HashMap();
            SharedPreferences sharedPreferences = n00.this.r.getSharedPreferences("accessToken", 0);
            sharedPreferences.edit();
            xt.t1 t1Var = xt.f3961a;
            hashMap.put("userId", t1Var.L().getUserId());
            hashMap.put("authType", "ACCESS_TOKEN");
            hashMap.put("deviceId", t1Var.n().a());
            hashMap.put("accessToken", sharedPreferences.getString("accessToken", null));
            return hashMap;
        }

        @Override // defpackage.wj1
        public Map<String, String> o() {
            HashMap hashMap = new HashMap();
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("fileType", "Image");
            hashMap.put("info", jsonObject.toString());
            return hashMap;
        }
    }

    /* renamed from: n00$y0 */
    /* compiled from: BookingFeature */
    public interface y0 {
        void a(String str);

        void execute();
    }

    /* renamed from: n00$z */
    /* compiled from: BookingFeature */
    public class z implements yj1.b<tj1> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f2501a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public z(long j, String str, String str2, String str3) {
            this.f2501a = j;
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(tj1 tj1) {
            tj1 tj12 = tj1;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            long currentTimeMillis = System.currentTimeMillis() - this.f2501a;
            ((ik1) n00.this.q.e).a();
            try {
                JSONObject jSONObject = new JSONObject(new String(tj12.b));
                jSONObject.toString().replace("\\\\", "");
                ImageUploadUrlEvent imageUploadUrlEvent = new ImageUploadUrlEvent(jSONObject.getString("url"), this.b, this.c, this.d);
                imageUploadUrlEvent.setResponseTime(currentTimeMillis);
                imageUploadUrlEvent.setResponseType(ad1.SUCCESS);
                jz5.b().i(imageUploadUrlEvent);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: n00$z0 */
    /* compiled from: BookingFeature */
    public interface z0 {
        void a(dk1 dk1);
    }

    public n00(Context context, xj1 xj1, String str) {
        this.e = new rf1(context, "magic_pass_store");
        this.d = new rf1(context, "booking_pass_store");
        context.getSharedPreferences("booking_ticket_store", 0).edit();
        this.f2466a = new rf1(context, "pending_pass");
        this.b = new rf1(context, "transaction_data");
        this.c = new rf1(context, "scan_pay_data");
        this.f = new rf1(context, "pending_pass_store");
        this.g = new rf1(context, "payment_mode");
        this.h = new rf1(context, "punch_time_store");
        this.i = new rf1(context, "magic_passes_properties_store");
        this.j = new rf1(context, "magic_pass_guidelines_store");
        this.k = new rf1(context, "mticket_store");
        context.getSharedPreferences("reclaim_bookings_status_store", 0).edit();
        this.l = new rf1(context, "product_config_store");
        this.m = new rf1(context, "docConfigStore");
        this.x = new rf1(context, "proof_config_store");
        this.y = new rf1(context, "document_config_store");
        this.z = new rf1(context, "proof_document_props_store");
        this.n = new rf1(context, "home_screen_promotion_store");
        this.o = new rf1(context, "route_screen_promotion_store");
        this.D = new rf1(context, "processingStore");
        this.q = xj1;
        this.r = context;
        String str2 = ut.j;
        this.t = ut.l;
        ut.a aVar = ut.f3552a;
        this.u = new ce1(context, str, "amqp://appuser:MDI2ZTBmYTUxNzVmMjM0ZjM2ZjEyNDYx@rmq.chalo.com/chaloApp", ut.B);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public static void q0(n00 n00, BookingTransaction bookingTransaction, JSONObject jSONObject) {
        BookingTransaction bookingTransaction2;
        JSONException e2;
        String str;
        String str2;
        PayuUser payuUser;
        RazorPayOrderData razorPayOrderData;
        String str3;
        int i2;
        String str4;
        String str5;
        ArrayList arrayList;
        Objects.requireNonNull(n00);
        String str6 = "Order";
        String str7 = "payuUserParams";
        String str8 = "entity";
        String str9 = SuperPassJsonKeys.REFERENCE_ID;
        try {
            ArrayList arrayList2 = new ArrayList();
            if (jSONObject.has("razorToken")) {
                try {
                    JSONArray jSONArray = jSONObject.getJSONArray("razorToken");
                    if (jSONArray.length() > 0) {
                        int i3 = 0;
                        while (i3 < jSONArray.length()) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                            String string = jSONObject2.getString(AnalyticsConstants.TOKEN);
                            String string2 = jSONObject2.getString("id");
                            String string3 = jSONObject2.getString(str8);
                            String string4 = jSONObject2.getString("method");
                            long j2 = jSONObject2.getLong("used_at");
                            long j3 = jSONObject2.getLong("created_at");
                            JSONObject optJSONObject = jSONObject2.optJSONObject(AnalyticsConstants.CARD);
                            if (optJSONObject != null) {
                                CardDetails cardDetails = new CardDetails();
                                int i4 = optJSONObject.getInt("expiry_month");
                                str5 = str7;
                                int i5 = optJSONObject.getInt("expiry_year");
                                str4 = str9;
                                String string5 = optJSONObject.getString("last4");
                                i2 = i3;
                                String string6 = optJSONObject.getString("name");
                                optJSONObject.getString("type");
                                String string7 = optJSONObject.getString(str8);
                                str3 = str8;
                                String string8 = optJSONObject.getString("issuer");
                                String string9 = optJSONObject.getString(AnalyticsConstants.NETWORK);
                                SavedCardDetails savedCardDetails = new SavedCardDetails();
                                savedCardDetails.setEntity(string7);
                                savedCardDetails.setExpiryMonth(i4);
                                savedCardDetails.setExpiryYear(i5);
                                savedCardDetails.setLastFourDigits(string5);
                                savedCardDetails.setName(string6);
                                savedCardDetails.setIssuer(string8);
                                savedCardDetails.setNetwork(string9);
                                cardDetails.setEntity(string3);
                                cardDetails.setToken(string);
                                cardDetails.setTokenId(string2);
                                cardDetails.setMethod(string4);
                                cardDetails.setUsedAt(j2);
                                cardDetails.setCreatedAt(j3);
                                cardDetails.setSavedCard(savedCardDetails);
                                arrayList = arrayList2;
                                arrayList.add(cardDetails);
                            } else {
                                str5 = str7;
                                str3 = str8;
                                str4 = str9;
                                arrayList = arrayList2;
                                i2 = i3;
                            }
                            i3 = i2 + 1;
                            arrayList2 = arrayList;
                            jSONArray = jSONArray;
                            str6 = str6;
                            str7 = str5;
                            str9 = str4;
                            str8 = str3;
                        }
                    }
                } catch (JSONException e3) {
                    e2 = e3;
                    bookingTransaction2 = bookingTransaction;
                    b00 b00 = b00.f358a;
                    b00.a().b(e2);
                    e2.printStackTrace();
                    n00.u0(e2.getMessage(), bookingTransaction2);
                }
            }
            String string10 = jSONObject.has(str9) ? jSONObject.getString(str9) : null;
            String string11 = jSONObject.getString("transactionId");
            String optString = jSONObject.optString("paymentHash", null);
            String optString2 = jSONObject.optString("webServiceHash", null);
            String optString3 = jSONObject.optString("productInfo", null);
            String optString4 = jSONObject.optString("udf1", "");
            long parseLong = Long.parseLong(jSONObject.getString("bookingTime"));
            String optString5 = jSONObject.optString(SuperPassJsonKeys.EXPIRY_TIME);
            long j4 = 0;
            if (!TextUtils.isEmpty(optString5)) {
                j4 = Long.parseLong(optString5);
            }
            String optString6 = jSONObject.optString("razorCustomerId");
            JSONArray optJSONArray = jSONObject.optJSONArray("paymentMethods");
            ArrayList arrayList3 = new ArrayList();
            if (optJSONArray != null) {
                int i6 = 0;
                str2 = optString3;
                while (i6 < optJSONArray.length()) {
                    JSONObject jSONObject3 = (JSONObject) optJSONArray.get(i6);
                    String string12 = jSONObject3.getString("paymentMethod");
                    String string13 = jSONObject3.getString("methodDetails");
                    String string14 = jSONObject3.getString("paymentApp");
                    RecentPaymentMethod recentPaymentMethod = new RecentPaymentMethod();
                    recentPaymentMethod.setPaymentMethod(string12);
                    recentPaymentMethod.setPaymentDetails(string13);
                    recentPaymentMethod.setPaymentAppName(string14);
                    arrayList3.add(recentPaymentMethod);
                    i6++;
                    optJSONArray = optJSONArray;
                    optString4 = optString4;
                    optString2 = optString2;
                }
                str = optString2;
            } else {
                str = optString2;
                str2 = optString3;
            }
            if (jSONObject.has(str7)) {
                try {
                    JSONObject jSONObject4 = new JSONObject(jSONObject.getString(str7));
                    payuUser = new PayuUser(jSONObject4.getString("email"), jSONObject4.getString(SuperPassJsonKeys.FIRST_NAME), jSONObject4.getString("phone"));
                } catch (JSONException e4) {
                    b00 b002 = b00.f358a;
                    b00.a().b(e4);
                    e4.printStackTrace();
                    payuUser = null;
                }
                razorPayOrderData = null;
                bookingTransaction2 = bookingTransaction;
            } else if (jSONObject.has(str6)) {
                JSONObject jSONObject5 = jSONObject.getJSONObject(str6);
                razorPayOrderData = new RazorPayOrderData((double) jSONObject5.getInt(AnalyticsConstants.AMOUNT), jSONObject5.getString(SuperPassJsonKeys.ORDER_ID), jSONObject5.getString("receiptId"), jSONObject5.getLong("timestamp"), jSONObject5.optString("merchantKey", null));
                bookingTransaction2 = bookingTransaction;
                payuUser = null;
            } else {
                bookingTransaction2 = bookingTransaction;
                payuUser = null;
                razorPayOrderData = null;
            }
            try {
                bookingTransaction2.setTransactionId(string11);
                if (bookingTransaction.getGroupTicket() != null) {
                    GroupTicket groupTicket = bookingTransaction.getGroupTicket();
                    groupTicket.setBookingTime(parseLong);
                    groupTicket.setExpiryTime(j4);
                    groupTicket.setTransactionId(string11);
                    groupTicket.setGroupId(string11);
                } else if (bookingTransaction.getMagicPass() != null) {
                    jSONObject.getString("QrCode");
                    MPass magicPass = bookingTransaction.getMagicPass();
                    magicPass.setBookingTime(parseLong);
                    magicPass.setExpiryTime(j4);
                    magicPass.setBookingPassId(string11);
                    magicPass.setRecentPaymentMethod(arrayList3);
                    magicPass.setCardDetails(arrayList2);
                    magicPass.setCustomerId(optString6);
                    magicPass.setReferenceId(string10);
                    magicPass.setPaymentRequired(jSONObject.optBoolean("paymentRequired", true));
                    bookingTransaction2.setMagicPass(magicPass);
                } else if (bookingTransaction.getMTicket() != null) {
                    String string15 = jSONObject.getString(SuperPassJsonKeys.QR_CODE);
                    MTicket mTicket = bookingTransaction.getMTicket();
                    mTicket.setBookingTime(parseLong);
                    mTicket.setExpirationTime(j4);
                    mTicket.setRecentPaymentMethod(arrayList3);
                    mTicket.setQrCode(string15);
                    mTicket.setRecentPaymentMethod(arrayList3);
                    mTicket.setCardDetails(arrayList2);
                    mTicket.setCustomerId(optString6);
                    mTicket.setMTicketId(string11);
                    mTicket.setPaymentRequired(jSONObject.getBoolean("paymentRequired"));
                    bookingTransaction2.setMTicket(mTicket);
                } else if (bookingTransaction.get_scanPayTicket() != null) {
                    ScanPayTicket scanPayTicket = bookingTransaction.get_scanPayTicket();
                    scanPayTicket.set_bookingTime(parseLong);
                    scanPayTicket.set_cityName(xt.f3961a.k().d().getName());
                    scanPayTicket.set_expirationTime(j4);
                    scanPayTicket.set_recentPaymentMethod(arrayList3);
                    scanPayTicket.set_cardDetails(arrayList2);
                    scanPayTicket.set_customerId(optString6);
                    scanPayTicket.set_transactionId(string11);
                    bookingTransaction2.setScanPayTicket(scanPayTicket);
                } else {
                    long parseLong2 = Long.parseLong(jSONObject.getString(SuperPassJsonKeys.START_TIME));
                    BookingPass bookingPass = bookingTransaction.getBookingPass();
                    bookingPass.setStartingTime(parseLong2);
                    bookingPass.setBookingTime(parseLong);
                    bookingPass.setExpiryTime(j4);
                    bookingPass.setPassId(string11);
                }
                jz5.b().i(new BookingTransactionEvent(ad1.SUCCESS, null, bookingTransaction, optString, str, optString4, str2, payuUser, razorPayOrderData));
            } catch (JSONException e5) {
                e2 = e5;
                b00 b003 = b00.f358a;
                b00.a().b(e2);
                e2.printStackTrace();
                n00.u0(e2.getMessage(), bookingTransaction2);
            }
        } catch (JSONException e6) {
            e2 = e6;
            bookingTransaction2 = bookingTransaction;
            b00 b0032 = b00.f358a;
            b00.a().b(e2);
            e2.printStackTrace();
            n00.u0(e2.getMessage(), bookingTransaction2);
        }
    }

    public static boolean r0(n00 n00, MPass mPass) {
        Objects.requireNonNull(n00);
        return mPass.isPassExpired() || mPass.getExpiryTime() < System.currentTimeMillis();
    }

    public static void s0(n00 n00, String str, String str2) {
        Objects.requireNonNull(n00);
        ed1 ed1 = new ed1("Refresh Token Called", Long.MIN_VALUE);
        ed1.a("userId", str);
        hj1.K0(ed1, "responseCode", str2, ed1);
    }

    @Override // defpackage.d20
    public void A(MPass mPass, String str, String str2, String str3, String str4, ProfileRequestInfo profileRequestInfo) {
        String c2 = xt.f3961a.L().c(mPass, str2, str3, str4, profileRequestInfo, str);
        BasicProfileFields fields = profileRequestInfo.getProfile().getFields();
        UserProfile userProfile = new UserProfile(fields.getFirstName(), fields.getLastName(), fields.getGender(), fields.getDateOfBirth(), fields.getEmailId(), fields.getPhone(), profileRequestInfo.getProfile().fetchProfilePicUrl(), mPass.getUserProfile().getAgencyInfo());
        userProfile.setUserId(mPass.getUserProfile().getUserId());
        BookingTransaction bookingTransaction = new BookingTransaction();
        bookingTransaction.setRequestInfo(profileRequestInfo);
        mPass.setUserProfile(userProfile);
        bookingTransaction.setMagicPass(mPass);
        bookingTransaction.setTotalFare(mPass.getFare());
        Context context = this.r;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(this.s).appendEncodedPath("v2").appendEncodedPath(LoggingConstants.USER).appendEncodedPath("generatePass");
        e70 e70 = new e70(context, true, 1, builder.toString(), new p0(userProfile, bookingTransaction), new q0(mPass, str, str2, str3, str4, profileRequestInfo, bookingTransaction), c2);
        e70.q = new nj1(Indexable.MAX_STRING_LENGTH, 0, 1.0f);
        e70.n = false;
        this.q.a(e70);
    }

    public final String A0(String str) {
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.i);
        builder.appendEncodedPath("product");
        builder.appendEncodedPath("fares");
        builder.appendQueryParameter("productid", str);
        return builder.toString();
    }

    @Override // defpackage.d20
    public void B(MTicket mTicket, String str, String str2, ProfileRequestInfo profileRequestInfo) {
        JSONException e2;
        long j2;
        mTicket.setDeviceId(xt.f3961a.n().a());
        ov ovVar = this.p;
        Objects.requireNonNull(ovVar);
        String str3 = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", mTicket.getUserId());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("lpVer", "v1");
            ut.a aVar = ut.f3552a;
            jSONObject.put("appVer", 764);
            jSONObject2.put(LoggingConstants.ROUTE_ID, mTicket.getUpTripRouteStopsInfo().getRouteId());
            jSONObject2.put("routeName", mTicket.getUpTripRouteStopsInfo().getRouteName());
            jSONObject2.put("startStopId", mTicket.getUpTripRouteStopsInfo().getStartStopId());
            jSONObject2.put(Constants.START_STOP_NAME, mTicket.getUpTripRouteStopsInfo().getStartStopName());
            jSONObject2.put("endStopId", mTicket.getUpTripRouteStopsInfo().getEndStopId());
            jSONObject2.put(Constants.END_STOP_STOP_NAME, mTicket.getUpTripRouteStopsInfo().getEndStopName());
            if (profileRequestInfo != null) {
                mTicket.get_userProfile();
                jSONObject2.put("userDetails", ovVar.k(profileRequestInfo));
            }
            if (mTicket.getUpTripRouteStopsInfo().getSpecialFeatures() != null) {
                JSONArray jSONArray = new JSONArray();
                for (SPECIAL_FEATURE special_feature : mTicket.getUpTripRouteStopsInfo().getSpecialFeatures()) {
                    jSONArray.put(special_feature.toString());
                }
                for (String str4 : mTicket.getUpTripRouteStopsInfo().get_spf()) {
                    jSONArray.put(str4);
                }
                jSONObject2.put("specialFeatures", jSONArray);
            }
            ProductConfiguration h02 = xt.f3961a.c().h0(mTicket.getMTicketConfiguration().getId());
            if (h02 == null) {
                j2 = 86400000;
            } else {
                j2 = h02.getProductValidity();
            }
            jSONObject2.put("validDuration", j2);
            jSONObject2.put("deviceId", mTicket.getDeviceId());
            if (mTicket.getUpTripRouteStopsStageInfo() != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("startStageId", mTicket.getUpTripRouteStopsStageInfo().getStartStopId());
                jSONObject3.put("startStageName", mTicket.getUpTripRouteStopsStageInfo().getStartStopName());
                jSONObject3.put("endStageId", mTicket.getUpTripRouteStopsStageInfo().getEndStopId());
                jSONObject3.put("endStageName", mTicket.getUpTripRouteStopsStageInfo().getEndStopName());
                jSONObject2.put("routeDetails", jSONObject3);
            }
            if (mTicket.getPassengerDetails() != null) {
                JSONObject jSONObject4 = new JSONObject();
                for (String str5 : mTicket.getPassengerDetails().keySet()) {
                    JSONObject jSONObject5 = new JSONObject();
                    JSONObject jSONObject6 = new JSONObject();
                    MTicketPassengerInfo mTicketPassengerInfo = mTicket.getPassengerDetails().get(str5);
                    if (mTicketPassengerInfo.get_addMap() != null) {
                        JSONObject jSONObject7 = new JSONObject();
                        for (Map.Entry<String, Double> entry : mTicketPassengerInfo.get_addMap().entrySet()) {
                            jSONObject7.put(entry.getKey(), entry.getValue());
                        }
                        jSONObject6.put("a", jSONObject7);
                    }
                    if (mTicketPassengerInfo.get_subMap() != null) {
                        JSONObject jSONObject8 = new JSONObject();
                        for (Map.Entry<String, Double> entry2 : mTicketPassengerInfo.get_subMap().entrySet()) {
                            jSONObject8.put(entry2.getKey(), entry2.getValue());
                        }
                        jSONObject6.put("s", jSONObject8);
                    }
                    if (mTicketPassengerInfo.get_subMap() != null || mTicketPassengerInfo.get_addMap() != null) {
                        jSONObject5.put("f_br", jSONObject6);
                    }
                    jSONObject5.put("c", mTicket.getPassengerDetails().get(str5).getPassengerCount());
                    jSONObject5.put("f", String.valueOf(mTicket.getPassengerDetails().get(str5).getFare()));
                    jSONObject5.put("ff", String.valueOf(mTicket.getPassengerDetails().get(str5).get_totalFare()));
                    jSONObject5.put("d", String.valueOf(mTicket.getPassengerDetails().get(str5).getDiscountPercentage()));
                    jSONObject4.put(str5, jSONObject5);
                }
                jSONObject2.put("passengerDetails", jSONObject4);
            }
            jSONObject.put("bookingData", jSONObject2);
            jSONObject.put(SuperPassJsonKeys.CONFIGURATION_ID, mTicket.getMTicketConfiguration().getId());
            jSONObject.put("isFreeRide", mTicket.isFreeRide());
            try {
                jSONObject.put("clientTransactionId", str2);
                str3 = jSONObject.toString();
            } catch (JSONException e3) {
                e2 = e3;
                b00 b00 = b00.f358a;
                hj1.W0(e2);
                BookingTransaction bookingTransaction = new BookingTransaction();
                bookingTransaction.setMTicket(mTicket);
                bookingTransaction.setTotalFare(mTicket.getTotalFare());
                Context context = this.r;
                String cityName = mTicket.getCityName();
                String agency = mTicket.getAgency();
                Uri.Builder builder = new Uri.Builder();
                builder.encodedPath(this.s).appendEncodedPath("v2").appendEncodedPath(ProductPromotionsObject.KEY_CITIES).appendEncodedPath(cityName.toLowerCase()).appendEncodedPath("agencies").appendEncodedPath(agency.toLowerCase()).appendEncodedPath("bookings");
                e70 e70 = new e70(context, false, 1, builder.build().toString(), new u0(bookingTransaction), new v0(mTicket, str2, profileRequestInfo, bookingTransaction), str3);
                e70.n = false;
                e70.q = new nj1(15000, 0, 1.0f);
                this.q.a(e70);
            }
        } catch (JSONException e4) {
            e2 = e4;
            b00 b002 = b00.f358a;
            hj1.W0(e2);
            BookingTransaction bookingTransaction2 = new BookingTransaction();
            bookingTransaction2.setMTicket(mTicket);
            bookingTransaction2.setTotalFare(mTicket.getTotalFare());
            Context context2 = this.r;
            String cityName2 = mTicket.getCityName();
            String agency2 = mTicket.getAgency();
            Uri.Builder builder2 = new Uri.Builder();
            builder2.encodedPath(this.s).appendEncodedPath("v2").appendEncodedPath(ProductPromotionsObject.KEY_CITIES).appendEncodedPath(cityName2.toLowerCase()).appendEncodedPath("agencies").appendEncodedPath(agency2.toLowerCase()).appendEncodedPath("bookings");
            e70 e702 = new e70(context2, false, 1, builder2.build().toString(), new u0(bookingTransaction2), new v0(mTicket, str2, profileRequestInfo, bookingTransaction2), str3);
            e702.n = false;
            e702.q = new nj1(15000, 0, 1.0f);
            this.q.a(e702);
        }
        BookingTransaction bookingTransaction22 = new BookingTransaction();
        bookingTransaction22.setMTicket(mTicket);
        bookingTransaction22.setTotalFare(mTicket.getTotalFare());
        Context context22 = this.r;
        String cityName22 = mTicket.getCityName();
        String agency22 = mTicket.getAgency();
        Uri.Builder builder22 = new Uri.Builder();
        builder22.encodedPath(this.s).appendEncodedPath("v2").appendEncodedPath(ProductPromotionsObject.KEY_CITIES).appendEncodedPath(cityName22.toLowerCase()).appendEncodedPath("agencies").appendEncodedPath(agency22.toLowerCase()).appendEncodedPath("bookings");
        e70 e7022 = new e70(context22, false, 1, builder22.build().toString(), new u0(bookingTransaction22), new v0(mTicket, str2, profileRequestInfo, bookingTransaction22), str3);
        e7022.n = false;
        e7022.q = new nj1(15000, 0, 1.0f);
        this.q.a(e7022);
    }

    public final boolean B0(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("productType") || !SuperPassConstants.PRODUCT_TYPE_SUPER_PASS.equals(jSONObject.getString("productType"))) {
                return true;
            }
            return false;
        } catch (JSONException unused) {
        }
    }

    @Override // defpackage.d20
    public void C(String str, int i2, boolean z2) {
        if (z2) {
            if (!this.C) {
                this.n.h(String.valueOf(i2), this.n.d(String.valueOf(i2), 0) + 1);
            }
            this.C = true;
            this.n.d(String.valueOf(i2), Integer.MAX_VALUE);
            return;
        }
        this.o.h(z0(str, i2), this.o.d(z0(str, i2), 0) + 1);
    }

    public final boolean C0(String str) {
        ProductConfiguration m02 = vn.m0(str);
        if (m02 == null) {
            return false;
        }
        String productType = m02.getProductType();
        if (productType.equals("pass") || productType.equals("magicPass") || productType.equals("routePass") || productType.equals("rpPass") || productType.equals("singleJourneyTicket") || productType.equals("sjPass") || productType.equals("scanPay") || productType.equals("superSaver")) {
            return true;
        }
        return false;
    }

    @Override // defpackage.d20
    public String D(BookingItemType bookingItemType) {
        String name;
        String f2;
        xt.t1 t1Var = xt.f3961a;
        City d2 = t1Var.k().d();
        if (!(bookingItemType == null || d2 == null || (name = d2.getName()) == null || (f2 = t1Var.t().f("applicationSubmissionStatus")) == null)) {
            try {
                JSONObject jSONObject = new JSONObject(f2);
                if (jSONObject.has(bookingItemType.toString().toLowerCase())) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(bookingItemType.toString().toLowerCase());
                    boolean has = jSONObject2.has(name.toLowerCase());
                    String str = ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT;
                    if (has) {
                        str = name.toLowerCase();
                    } else if (!jSONObject2.has(str)) {
                        str = null;
                    }
                    if (str != null) {
                        return jSONObject2.getString(str);
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
        }
        return null;
    }

    public final void D0(Set<String> set) {
        Map<String, ?> b2 = this.k.b();
        if (!(b2 == null || b2.size() == 0)) {
            for (String str : b2.keySet()) {
                if (!set.contains(str)) {
                    rf1 rf1 = this.k;
                    rf1.f3075a.remove(str);
                    rf1.f3075a.commit();
                }
            }
        }
    }

    @Override // defpackage.d20
    public boolean E(long j2) {
        return ui1.Q() >= j2;
    }

    public final void E0(Set<String> set) {
        Map<String, ?> b2 = this.e.b();
        if (!(b2 == null || b2.size() == 0)) {
            for (String str : b2.keySet()) {
                if (!set.contains(str) && ov.r(this.e.f(str, null)).getCity().equalsIgnoreCase(xt.f3961a.k().d().getName())) {
                    rf1 rf1 = this.e;
                    rf1.f3075a.remove(str);
                    rf1.f3075a.commit();
                }
            }
        }
    }

    @Override // defpackage.d20
    public String F(String str) {
        return this.x.b.getString(str, str);
    }

    public final void F0(Set<String> set) {
        Map<String, ?> b2 = this.b.b();
        if (!(b2 == null || b2.size() == 0)) {
            for (String str : b2.keySet()) {
                if (!set.contains(str) && ov.r(this.b.f(str, null)).getCity().equalsIgnoreCase(xt.f3961a.k().d().getName())) {
                    rf1 rf1 = this.b;
                    rf1.f3075a.remove(str);
                    rf1.f3075a.commit();
                }
            }
        }
    }

    @Override // defpackage.d20
    public Map<String, RouteLevelAvailability> G() {
        String str;
        String str2;
        String name;
        xt.t1 t1Var = xt.f3961a;
        City d2 = t1Var.k().d();
        if (d2 == null || (name = d2.getName()) == null) {
            str = null;
        } else {
            str = name.toLowerCase();
            n86.d(str, "(this as java.lang.String).toLowerCase()");
        }
        if (str == null) {
            str2 = new String();
        } else {
            String W = t1Var.W(str);
            if (t1Var.V().containsKey(W)) {
                str2 = (String) t1Var.V().get(W);
                if (str2 == null) {
                    str2 = new String();
                }
            } else {
                str2 = new String();
            }
        }
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                String string = jSONObject2.getString(ProductPromotionsObject.KEY_TITLE);
                String optString = jSONObject2.optString(ProductPromotionsObject.KEY_CTA);
                String optString2 = jSONObject2.optString("ctaAction");
                boolean optBoolean = jSONObject2.optBoolean("ctaVisibility", false);
                String optString3 = jSONObject2.optString("imageUrl");
                int optInt = jSONObject2.optInt("style", 0);
                boolean optBoolean2 = jSONObject2.optBoolean("isVisible", false);
                boolean optBoolean3 = jSONObject2.optBoolean("isSticky", true);
                boolean optBoolean4 = jSONObject2.optBoolean("isImageVisible", false);
                boolean optBoolean5 = jSONObject2.optBoolean("dialogVisibility", false);
                int optInt2 = jSONObject2.optInt("isDisruption", 0);
                try {
                    RouteLevelAvailability routeLevelAvailability = new RouteLevelAvailability(optBoolean2, optBoolean3, optBoolean4, string, optString, optBoolean, optString3, optInt, optString2, new RouteDialogInfo(optBoolean5, jSONObject2.optString("dialogTitle"), jSONObject2.optString("dialogSubtitle"), jSONObject2.optString("dialogCtaTitle"), jSONObject2.optString("dialogCta", ""), jSONObject2.optString("dialogImage")));
                    routeLevelAvailability.setIsDisruption(optInt2);
                    hashMap.put(next, routeLevelAvailability);
                } catch (JSONException unused) {
                    return null;
                }
            }
            return hashMap;
        } catch (JSONException unused2) {
            return null;
        }
    }

    public final void G0(HashSet<String> hashSet) {
        Map<String, ?> b2 = this.f2466a.b();
        if (!(b2 == null || b2.size() == 0)) {
            for (String str : b2.keySet()) {
                if (!hashSet.contains(str)) {
                    MPass mPass = null;
                    String f2 = this.f2466a.f(str, null);
                    Objects.requireNonNull(this.p);
                    try {
                        mPass = ov.r(new JSONObject(f2).getString("magicPass"));
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (mPass == null) {
                        b00 b00 = b00.f358a;
                        b00.a().b(new Throwable(hj1.S("Purging Exception", str)));
                    } else if (mPass.getCity().equalsIgnoreCase(xt.f3961a.k().d().getName())) {
                        rf1 rf1 = this.f2466a;
                        rf1.f3075a.remove(str);
                        rf1.f3075a.commit();
                    }
                }
            }
        }
    }

    @Override // defpackage.d20
    public void H(Bitmap bitmap, String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        b0 b0Var = new b0(1, ut.k, new z(currentTimeMillis, str, str2, str3), new a0(bitmap, str, str2, str3, currentTimeMillis), bitmap);
        b0Var.q = new nj1(0, 1, 1.0f);
        this.q.a(b0Var);
    }

    public final void H0(Set<String> set) {
        Map<String, ?> b2 = this.c.b();
        if (!(b2 == null || b2.size() == 0)) {
            for (String str : b2.keySet()) {
                if (!set.contains(str)) {
                    if (this.p.E(this.c.f(str, null)).get_cityName().equalsIgnoreCase(xt.f3961a.k().d().getName())) {
                        rf1 rf1 = this.c;
                        rf1.f3075a.remove(str);
                        rf1.f3075a.commit();
                    }
                }
            }
        }
    }

    @Override // defpackage.d20
    public List<ProductConfiguration> I() {
        ProductConfiguration x2;
        Map<String, ?> b2 = this.l.b();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : b2.entrySet()) {
            String f2 = this.l.f(entry.getKey(), null);
            if (!(f2 == null || (x2 = this.p.x(f2)) == null)) {
                arrayList.add(x2);
            }
        }
        return arrayList;
    }

    public final void I0(MTicket mTicket) {
        if (mTicket != null && mTicket.getMTicketId() != null && mTicket.getCityName() != null) {
            Context context = this.r;
            SharedPreferences sharedPreferences = context.getSharedPreferences(((Object) "mticket_activation_store:") + mTicket.getCityName().toLowerCase(), 0);
            sharedPreferences.edit();
            if (sharedPreferences.contains(mTicket.getMTicketId())) {
                ov ovVar = this.p;
                String string = sharedPreferences.getString(mTicket.getMTicketId(), null);
                Objects.requireNonNull(ovVar);
                if (string != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        long j2 = jSONObject.getLong("activatedAt");
                        mTicket.setIsUpTripActivated(jSONObject.getBoolean("isActivated"));
                        mTicket.setUpTripActivationTime(j2);
                    } catch (JSONException e2) {
                        b00 b00 = b00.f358a;
                        hj1.W0(e2);
                    }
                }
            }
        }
    }

    @Override // defpackage.d20
    public ProofDocumentProps J(String str, String str2, String str3) {
        String f2;
        if (str == null || str2 == null || str3 == null || (f2 = this.z.f(ProofUploadDocumentPropsIdentifier.convertToStringToStore(new ProofUploadDocumentPropsIdentifier(str, str2.toLowerCase(), str3)), null)) == null) {
            return null;
        }
        return ProofDocumentProps.convertToObjectFromStoreString(f2);
    }

    public void J0(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            String string = this.l.b.getString(str, null);
            if (string == null) {
                rf1 rf1 = this.l;
                rf1.f3075a.putString(str, jSONObject.toString());
                rf1.f3075a.commit();
                return;
            }
            try {
                JSONObject jSONObject2 = new JSONObject(string);
                jSONObject2.put("fareMapping", jSONObject);
                rf1 rf12 = this.l;
                rf12.f3075a.putString(str, jSONObject2.toString());
                rf12.f3075a.commit();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // defpackage.d20
    public boolean K() {
        String name;
        xt.t1 t1Var = xt.f3961a;
        City d2 = t1Var.k().d();
        if (d2 == null || (name = d2.getName()) == null) {
            return false;
        }
        ut.a aVar = ut.f3552a;
        String f2 = t1Var.t().f("cityListForFreeRides");
        if (f2 != null) {
            try {
                JSONArray jSONArray = new JSONArray(f2);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string = jSONArray.getString(i2);
                    if (string != null && string.equalsIgnoreCase(name)) {
                        return true;
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
        }
        return false;
    }

    public final void K0(ad1 ad1) {
        if (ad1.SUCCESS.equals(ad1)) {
            xt.f3961a.l().put("keyTransactionsFetched", String.valueOf(true));
        } else {
            xt.f3961a.l().put("keyTransactionsFetched", String.valueOf(false));
        }
    }

    @Override // defpackage.d20
    public void L(MPass mPass) {
        rf1 rf1 = this.f;
        rf1.f3075a.putString("pending_pass_key", ov.f(mPass));
        rf1.f3075a.commit();
    }

    public final void L0(Map<ProofUploadDocumentPropsIdentifier, ProofDocumentProps> map) {
        if (map != null) {
            for (Map.Entry<ProofUploadDocumentPropsIdentifier, ProofDocumentProps> entry : map.entrySet()) {
                this.z.j(ProofUploadDocumentPropsIdentifier.convertToStringToStore(entry.getKey()), ProofDocumentProps.convertToStringToStore(entry.getValue()));
            }
        }
    }

    @Override // defpackage.d20
    public void M() {
        this.k.l();
        this.l.l();
        this.v = null;
        this.w = null;
        this.A = null;
        this.x.l();
        this.y.l();
        this.z.l();
        this.m.l();
        this.e.l();
        this.f2466a.l();
        this.b.l();
        this.c.l();
        this.f.l();
        this.k.l();
        xt.f3961a.l().remove("keyTransactionsFetched");
        ProductRepository productRepository = new ProductRepository(this.r);
        productRepository.deleteAllTicketData();
        productRepository.deleteAllPassData();
    }

    public final void M0(String str, String str2) {
        if (str2 != null) {
            rf1 rf1 = this.i;
            rf1.j("properties:" + str2, str);
        }
    }

    @Override // defpackage.d20
    public void N(String str, String str2, String str3) {
        String A0 = A0(str2);
        k0 k0Var = new k0(str2, str3);
        l0 l0Var = new l0(this, str3);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(LoggingConstants.ROUTE_ID, str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        this.q.a(new e70(1, A0, k0Var, l0Var, jSONObject.toString()));
    }

    @Override // defpackage.d20
    public MPass O() {
        String string = this.f.b.getString("pending_pass_key", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return ov.r(string);
    }

    @Override // defpackage.d20
    public void P(String str, String str2, RouteStopsInfo routeStopsInfo, String str3) {
        Context context = this.r;
        Uri.Builder builder = new Uri.Builder();
        JSONArray jSONArray = new JSONArray();
        if (routeStopsInfo.get_spf() != null) {
            for (int i2 = 0; i2 < routeStopsInfo.get_spf().size(); i2++) {
                jSONArray.put(routeStopsInfo.get_spf().get(i2));
            }
        }
        if (routeStopsInfo.getSpecialFeatures() != null) {
            for (SPECIAL_FEATURE special_feature : routeStopsInfo.getSpecialFeatures()) {
                jSONArray.put(special_feature.toString());
            }
        }
        builder.encodedPath(this.s).appendEncodedPath("v1").appendEncodedPath(ProductPromotionsObject.KEY_CITIES).appendEncodedPath(str).appendEncodedPath("agencies").appendEncodedPath(str2).appendEncodedPath("ticket/details").appendQueryParameter(LoggingConstants.ROUTE_ID, routeStopsInfo.getRouteId()).appendQueryParameter("routeName", routeStopsInfo.getRouteName()).appendQueryParameter("startStopId", routeStopsInfo.getStartStopId()).appendQueryParameter(Constants.START_STOP_NAME, routeStopsInfo.getStartStopName()).appendQueryParameter("endStopId", routeStopsInfo.getEndStopId()).appendQueryParameter("specialFeatures", jSONArray.toString()).appendQueryParameter(Constants.END_STOP_STOP_NAME, routeStopsInfo.getEndStopName());
        d70 d70 = new d70(context, builder.build().toString(), (String) null, new c0(this, str3), new d0(this, str, str2, routeStopsInfo, str3));
        d70.n = false;
        this.q.a(d70);
    }

    @Override // defpackage.d20
    public void Q() {
    }

    @Override // defpackage.d20
    public void R(MPass mPass, String str) {
        this.h.i(mPass.getBookingPassId(), ui1.Q());
        new Handler().post(new a(mPass, str));
    }

    @Override // defpackage.d20
    public MPass S(MPass mPass, boolean z2) {
        MPass pass;
        mPass.setCity(mPass.get_cityName().toLowerCase());
        ProductRepository productRepository = new ProductRepository(this.r);
        Pass passFromBookingId = productRepository.getPassFromBookingId(mPass.getBookingPassId());
        if (!(passFromBookingId == null || (pass = passFromBookingId.getPass()) == null)) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(mPass.getPunches());
            hashSet.addAll(pass.getPunches());
            Pass pass2 = new Pass();
            pass2.setPass(mPass);
            pass2.setPassId(mPass.getBookingPassId());
            productRepository.insertAndReplacePass(pass2);
            if (z2) {
                RideDetails fetchRidedetails = productRepository.fetchRidedetails(pass2.getPassId());
                if (fetchRidedetails == null) {
                    fetchRidedetails = new RideDetails(mPass.getBookingPassId(), new ArrayList());
                }
                List<RideInfo> list = fetchRidedetails.get_rideInfoList();
                list.add(new RideInfo(UUID.randomUUID().toString(), ui1.Q()));
                fetchRidedetails.set_rideInfoList(list);
                productRepository.insertRideDetails(fetchRidedetails);
                productRepository.getAllRideDetails();
            }
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(mPass.getPunches());
            hashSet2.addAll(pass.getPunches());
        }
        this.e.j(mPass.getBookingPassId(), ov.f(mPass));
        return mPass;
    }

    @Override // defpackage.d20
    public void T(String str, String str2, String str3) {
        if (str != null && str2 != null && str3 != null) {
            rf1 rf1 = this.j;
            rf1.g((str + ProductDiscountsObject.KEY_DELIMITER + str2 + ProductDiscountsObject.KEY_DELIMITER + str3).toLowerCase(), true);
        }
    }

    @Override // defpackage.d20
    public void U(MTicket mTicket) {
        if (mTicket != null && mTicket.getMTicketId() != null) {
            this.k.j(mTicket.getMTicketId(), this.p.e(mTicket));
        }
    }

    @Override // defpackage.d20
    public void V(String str, String str2, String str3) {
        String str4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("eligibilityResponseId", str);
            jSONObject.put(SuperPassJsonKeys.ORDER_ID, str3);
            jSONObject.put("userId", str2);
            str4 = jSONObject.toString();
        } catch (JSONException unused) {
            str4 = null;
        }
        e70 e70 = new e70(this.r, false, 1, ut.z, new k(this), new l(this, str, str2, str3), str4);
        e70.q = new nj1(Indexable.MAX_STRING_LENGTH, 1, 1.0f);
        e70.n = false;
        this.q.a(e70);
    }

    @Override // defpackage.d20
    public boolean W(long j2, String str) {
        return !(ui1.Q() - this.h.b.getLong(str, 0) < j2);
    }

    @Override // defpackage.d20
    public void X(List<VehicleInfo> list) {
        if (!(list == null || list.size() == 0)) {
            xt.t1 t1Var = xt.f3961a;
            String B2 = hj1.B(t1Var);
            StringBuilder i02 = hj1.i0("seatAvailabilityApiMode");
            i02.append(B2.toLowerCase());
            String sb = i02.toString();
            StringBuilder i03 = hj1.i0("seatAvailabilityOccupancyFactor");
            i03.append(B2.toLowerCase());
            String sb2 = i03.toString();
            String a2 = t1Var.l().a(sb);
            String a3 = t1Var.l().a(sb2);
            String optString = t1Var.l().h.optString("seatAvailabilityDelayThreshold", null);
            if (!(a2 == null || a3 == null || optString == null)) {
                int parseInt = Integer.parseInt(a2);
                int parseInt2 = Integer.parseInt(a3);
                int parseInt3 = Integer.parseInt(optString);
                if (parseInt2 == 0) {
                    parseInt2 = 100;
                }
                if (parseInt != 0) {
                    String str = ut.G;
                    JSONObject jSONObject = new JSONObject();
                    try {
                        JSONArray jSONArray = new JSONArray();
                        jSONObject.put("cityId", B2);
                        jSONObject.put("mode", parseInt);
                        jSONObject.put("maxDelay", parseInt3);
                        jSONObject.put("occupancyFactor", parseInt2);
                        for (int i2 = 0; i2 < list.size(); i2++) {
                            if (list.get(i2).getVehicleNo() != null) {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("number", list.get(i2).getVehicleNo());
                                jSONObject2.put("timeStamp", list.get(i2).getTimeStamp());
                                jSONObject2.put(LoggingConstants.ROUTE_ID, list.get(i2).getRouteId());
                                jSONObject2.put("stopId", list.get(i2).getStopId());
                                jSONArray.put(jSONObject2);
                            }
                        }
                        jSONObject.put("vehicle", jSONArray);
                    } catch (Exception unused) {
                    }
                    e70 e70 = new e70(1, str, new h(this), new j(this), jSONObject.toString(), parseInt);
                    e70.q = new nj1(5000, 1, 1.0f);
                    e70.n = true;
                    this.q.a(e70);
                }
            }
        }
    }

    @Override // defpackage.d20
    public boolean Y() {
        return String.valueOf(true).equals(xt.f3961a.l().h.optString("keyTransactionsFetched", null));
    }

    @Override // defpackage.d20
    public boolean Z(String str) {
        SharedPreferences sharedPreferences = this.r.getSharedPreferences("OTP_STORAGE", 0);
        sharedPreferences.edit();
        if (!sharedPreferences.contains(str + "_isExpired")) {
            return false;
        }
        return sharedPreferences.getBoolean(str + "_isExpired", false);
    }

    @Override // defpackage.d20
    public void a(String str, String str2) {
        String str3 = null;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(SuperPassJsonKeys.ORDER_ID, str);
            jSONObject.put("paymentId", str2);
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.l().h.has("paymentApp")) {
                jSONObject.put("paymentApp", t1Var.l().h.optString("paymentApp", null));
            }
            str3 = jSONObject.toString();
        } catch (JSONException unused) {
        }
        Context context = this.r;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(this.s).appendEncodedPath("v1").appendEncodedPath(BaseConstants.DEFAULT_SENDER).appendEncodedPath(AnalyticsConstants.PAYMENT).appendEncodedPath("status");
        e70 e70 = new e70(context, false, 1, builder.toString(), new o(this), new p(this, str, str2), str3);
        e70.q = new nj1(Indexable.MAX_STRING_LENGTH, 1, 1.0f);
        e70.n = false;
        this.q.a(e70);
    }

    @Override // defpackage.d20
    public MagicPassesProperties a0(String str) {
        JSONException e2;
        MagicPassesProperties magicPassesProperties = null;
        if (str == null) {
            return null;
        }
        rf1 rf1 = this.i;
        String f2 = rf1.f("properties:" + str, null);
        Objects.requireNonNull(this.p);
        if (f2 == null) {
            return null;
        }
        try {
            boolean optBoolean = new JSONObject(f2).optBoolean("passesOnMultipleDevices", false);
            MagicPassesProperties magicPassesProperties2 = new MagicPassesProperties();
            try {
                magicPassesProperties2.setPassesOnMultipleDevices(optBoolean);
                return magicPassesProperties2;
            } catch (JSONException e3) {
                e2 = e3;
                magicPassesProperties = magicPassesProperties2;
                b00 b00 = b00.f358a;
                hj1.W0(e2);
                return magicPassesProperties;
            }
        } catch (JSONException e4) {
            e2 = e4;
            b00 b002 = b00.f358a;
            hj1.W0(e2);
            return magicPassesProperties;
        }
    }

    @Override // defpackage.d20
    public void b(String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder appendEncodedPath = builder.encodedPath(this.t).appendEncodedPath("v3").appendEncodedPath(ProductPromotionsObject.KEY_CITIES).appendEncodedPath(str.toLowerCase()).appendEncodedPath("products");
        ut.a aVar = ut.f3552a;
        appendEncodedPath.appendQueryParameter("appVer", String.valueOf(764));
        d70 d70 = new d70(builder.build().toString(), null, new s(str2), new u(this, str2));
        d70.n = false;
        this.q.a(d70);
    }

    @Override // defpackage.d20
    public void b0(String str, String str2, RouteInfo routeInfo) {
        String m02 = xt.f3961a.m0();
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(this.s).appendEncodedPath("v1").appendEncodedPath(ProductPromotionsObject.KEY_CITIES).appendEncodedPath(str.toLowerCase()).appendEncodedPath("agencies").appendEncodedPath(str2).appendEncodedPath(LoggingConstants.USER).appendEncodedPath(m02).appendEncodedPath("available-freeride");
        d70 d70 = new d70(builder.build().toString(), null, new w0(this, routeInfo), new x0(this, routeInfo));
        d70.n = false;
        this.q.a(d70);
    }

    @Override // defpackage.d20
    public void c() {
        HashMap hashMap = new HashMap();
        hashMap.put("routepass_enabled", String.valueOf(true));
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.d).appendPath(xt.f3961a.k().d().getName()).appendPath("autocomplete").appendPath("route");
        builder.appendQueryParameter("day", vn.I());
        builder.appendQueryParameter("meta", ui1.K0().toString());
        for (String str : hashMap.keySet()) {
            builder.appendQueryParameter(str, (String) hashMap.get(str));
        }
        String uri = builder.build().toString();
        xt.t1 t1Var = xt.f3961a;
        t1Var.S();
        String lowerCase = t1Var.k().d().getName().toLowerCase();
        fe1 fe1 = new fe1(uri, new i0(this, lowerCase), new j0(this, lowerCase));
        fe1.n = false;
        this.q.a(fe1);
    }

    @Override // defpackage.d20
    public void c0(MPass mPass, String str) {
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(this.s);
        builder.appendEncodedPath("v2");
        builder.appendEncodedPath("pass");
        builder.appendEncodedPath(AnalyticsConstants.PAYMENT);
        builder.appendEncodedPath(SuperPassPaymentConstants.PAYMENT_MODE_CASH);
        String builder2 = builder.toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userId", mPass.getUserProfile().getUserId());
            jSONObject.put("passId", mPass.getBookingPassId());
            jSONObject.put("failCashRoutePass", false);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        BookingTransaction bookingTransaction = new BookingTransaction();
        bookingTransaction.setMagicPass(mPass);
        bookingTransaction.setTotalFare(mPass.getFare());
        e70 e70 = new e70(this.r, true, 1, builder2, new b(this, bookingTransaction), new c(this, mPass, str), jSONObject.toString());
        e70.q = new nj1(2500, 5, 1.0f);
        this.q.a(e70);
    }

    @Override // defpackage.d20
    public void d(String str, String str2) {
        xt.t1 t1Var = xt.f3961a;
        String B2 = hj1.B(t1Var);
        Context context = this.r;
        String a2 = t1Var.n().a();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder appendQueryParameter = builder.encodedPath(this.s).appendEncodedPath("v2").appendEncodedPath(ProductPromotionsObject.KEY_CITIES).appendEncodedPath(B2).appendEncodedPath("bookings").appendQueryParameter("userId", str).appendQueryParameter("deviceId", a2);
        ut.a aVar = ut.f3552a;
        appendQueryParameter.appendQueryParameter("appVer", String.valueOf(764));
        d70 d70 = new d70(context, builder.build().toString(), (String) null, new q(str, B2), new r(str, str2));
        d70.q = new nj1(5000, 6, 1.0f);
        d70.n = false;
        this.q.a(d70);
    }

    @Override // defpackage.d20
    public void d0(String str, String str2) {
        rf1 rf1 = this.g;
        rf1.f3075a.putString(str, str2);
        rf1.f3075a.commit();
    }

    @Override // defpackage.d20
    public List<BookingTransaction> e() {
        if (this.f2466a.b().size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ?> entry : this.f2466a.b().entrySet()) {
            ov ovVar = new ov();
            String str = (String) entry.getValue();
            BookingTransaction bookingTransaction = new BookingTransaction();
            try {
                JSONObject jSONObject = new JSONObject(str);
                bookingTransaction.setTransactionId(jSONObject.optString("transactionId"));
                if (jSONObject.has("groupTicket")) {
                    bookingTransaction.setGroupTicket(ovVar.o(jSONObject.getString("groupTicket")));
                } else if (jSONObject.has("bookingPass")) {
                    bookingTransaction.setBookingPass(ovVar.m(jSONObject.getString("bookingPass")));
                } else if (jSONObject.has("magicPass")) {
                    bookingTransaction.setMagicPass(ov.r(jSONObject.getString("magicPass")));
                }
                bookingTransaction.setTotalFare(jSONObject.getDouble(SuperPassJsonKeys.FARE));
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                hj1.W0(e2);
            }
            if (bookingTransaction.getMagicPass() != null) {
                arrayList.add(bookingTransaction);
            } else {
                arrayList.add((BookingTransaction) new Gson().fromJson((String) entry.getValue(), BookingTransaction.class));
            }
        }
        return arrayList;
    }

    @Override // defpackage.d20
    public MPass e0(String str) {
        String string = this.e.b.getString(str, null);
        if (string != null) {
            return ov.r(string);
        }
        return null;
    }

    @Override // defpackage.d20
    public List<BookingItem> f() {
        ProductRepository productRepository = new ProductRepository(this.r);
        List<MPass> allPassesSync = productRepository.getAllPassesSync();
        List<MTicket> allTicketsSync = productRepository.getAllTicketsSync();
        List<ScanPayTicket> allScanPaySync = productRepository.getAllScanPaySync();
        ArrayList arrayList = new ArrayList();
        if (allPassesSync != null) {
            for (MPass mPass : allPassesSync) {
                if (mPass != null) {
                    BookingItem bookingItem = new BookingItem();
                    bookingItem.setMagicPass(mPass);
                    arrayList.add(bookingItem);
                }
            }
        }
        if (allTicketsSync != null) {
            for (MTicket mTicket : allTicketsSync) {
                if (mTicket != null) {
                    BookingItem bookingItem2 = new BookingItem();
                    bookingItem2.setMTicket(mTicket);
                    arrayList.add(bookingItem2);
                }
            }
        }
        if (allScanPaySync != null) {
            for (ScanPayTicket scanPayTicket : allScanPaySync) {
                if (scanPayTicket != null) {
                    BookingItem bookingItem3 = new BookingItem();
                    bookingItem3.setScanPayTicket(scanPayTicket);
                    arrayList.add(bookingItem3);
                }
            }
        }
        return arrayList;
    }

    @Override // defpackage.d20
    public void f0(String str, String str2, String str3) {
        if (str2 == null || str3 == null) {
            jz5.b().i(new AutoLinkDeviceEvent(str, "Bad input"));
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("deviceId", str3);
            jSONObject.put("userId", str2);
        } catch (JSONException e2) {
            e2.getMessage();
            b00 b00 = b00.f358a;
            b00.a().b(e2);
        }
        String jSONObject2 = jSONObject.toString();
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(this.s).appendEncodedPath("users").appendEncodedPath(str2).appendEncodedPath(AnalyticsConstants.DEVICE);
        e70 e70 = new e70(1, builder.build().toString(), new f0(this, str), new g0(this, str), jSONObject2);
        e70.n = false;
        this.q.a(e70);
    }

    @Override // defpackage.d20
    public List<MPass> g() {
        List<BookingTransaction> e2 = e();
        ArrayList arrayList = new ArrayList();
        if (e2 != null) {
            for (int i2 = 0; i2 < e2.size(); i2++) {
                if (e2.get(i2).getMagicPass().getStatus() != null && !e2.get(i2).getMagicPass().getStatus().equals("UNVERIFIED")) {
                    arrayList.add(e2.get(i2).getMagicPass());
                }
            }
        }
        return arrayList;
    }

    @Override // defpackage.d20
    public void g0() {
        Context context = this.r;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.notificationId), 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : sharedPreferences.getAll().keySet()) {
            edit.remove(str);
            edit.commit();
        }
    }

    @Override // defpackage.d20
    public int h(String str, int i2, boolean z2) {
        if (!z2) {
            return this.o.d(z0(str, i2), 0);
        }
        if (this.C) {
            return this.n.d(String.valueOf(i2), 0) - 1;
        }
        return this.n.d(String.valueOf(i2), 0);
    }

    @Override // defpackage.d20
    public ProductConfiguration h0(String str) {
        String string = this.l.b.getString(str, null);
        if (string == null) {
            return null;
        }
        ProductConfiguration x2 = this.p.x(string);
        if (x2 != null) {
            x2.setProductId(str);
        }
        return x2;
    }

    @Override // defpackage.d20
    public void i(Bitmap bitmap, String str, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        y yVar = new y(1, ut.k, new w(currentTimeMillis, str, i2), new x(bitmap, str, i2, currentTimeMillis), bitmap);
        yVar.q = new nj1(0, 1, 1.0f);
        this.q.a(yVar);
    }

    @Override // defpackage.d20
    public String i0() {
        StringBuilder sb = new StringBuilder();
        xt.t1 t1Var = xt.f3961a;
        sb.append(t1Var.t().f("freeBusRideHelpBaseUri"));
        sb.append(t1Var.k().d().getName().toLowerCase());
        return sb.toString();
    }

    @Override // defpackage.d20
    public void j(boolean z2) {
        xt.t1 t1Var = xt.f3961a;
        String B2 = t1Var.k().d() != null ? hj1.B(t1Var) : null;
        if (B2 != null) {
            Uri.Builder builder = new Uri.Builder();
            builder.encodedPath(ut.d).appendPath(B2).appendPath("autocomplete").appendPath("route");
            builder.appendQueryParameter("station_type", "bus");
            builder.appendQueryParameter("day", vn.I());
            builder.appendQueryParameter("mticket_enabled", String.valueOf(true));
            if (z2) {
                builder.appendQueryParameter("freeride_enabled", String.valueOf(true));
            }
            fe1 fe1 = new fe1(builder.build().toString(), new m0(this, B2), new o0(this, B2));
            fe1.n = false;
            this.q.a(fe1);
        }
    }

    @Override // defpackage.d20
    public List<ProductConfiguration> j0(String str) {
        Map<String, ?> b2 = this.l.b();
        ArrayList arrayList = new ArrayList();
        for (String str2 : b2.keySet()) {
            ProductConfiguration h02 = h0(str2);
            if (h02.getProductAgency().equalsIgnoreCase(str)) {
                arrayList.add(h02);
            }
        }
        return arrayList;
    }

    @Override // defpackage.d20
    public void k() {
        this.f.l();
        this.f2466a.l();
        this.b.l();
        this.c.l();
        this.e.l();
        this.d.l();
        this.g.l();
        this.h.l();
        this.i.l();
        this.j.l();
        xt.t1 t1Var = xt.f3961a;
        t1Var.l().remove("keyTransactionsFetched");
        ProductRepository productRepository = new ProductRepository(this.r);
        productRepository.deleteAllPassApplications();
        productRepository.deleteAllPassData();
        productRepository.deleteAllScanPayData();
        t1Var.e0().deleteSuperPassProductData();
        t1Var.K().deleteAllOnlineCardRechargeData();
    }

    @Override // defpackage.d20
    public String k0(String str) {
        return this.y.b.getString(str, null);
    }

    @Override // defpackage.d20
    public List<MPass> l() {
        String string;
        String string2;
        ArrayList arrayList = new ArrayList();
        rf1 rf1 = this.b;
        if (!(rf1 == null || rf1.b() == null)) {
            for (String str : this.b.b().keySet()) {
                if (!(str == null || (string2 = this.b.b.getString(str, null)) == null)) {
                    MPass r2 = ov.r(string2);
                    if (r2.getStatus().equals("PENDING")) {
                        this.D.g(r2.getOrderId(), true);
                    }
                    if (r2.getCity().toLowerCase().equals(xt.f3961a.k().d().getName().toLowerCase())) {
                        arrayList.add(r2);
                    }
                }
            }
        }
        rf1 rf12 = this.e;
        if (!(rf12 == null || rf12.b() == null)) {
            for (String str2 : this.e.b().keySet()) {
                if (!(str2 == null || (string = this.e.b.getString(str2, null)) == null)) {
                    MPass r3 = ov.r(string);
                    if (r3.getCity().toLowerCase().equals(xt.f3961a.k().d().getName().toLowerCase())) {
                        arrayList.add(r3);
                    }
                }
            }
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new o00(this));
        }
        return arrayList;
    }

    @Override // defpackage.d20
    public void l0(MTicket mTicket, long j2) {
        if (mTicket != null && mTicket.getCityName() != null) {
            Context context = this.r;
            SharedPreferences.Editor edit = context.getSharedPreferences(((Object) "mticket_activation_store:") + mTicket.getCityName().toLowerCase(), 0).edit();
            String mTicketId = mTicket.getMTicketId();
            Objects.requireNonNull(this.p);
            String str = null;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("activatedAt", j2);
                jSONObject.put("isActivated", true);
                str = jSONObject.toString();
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                hj1.W0(e2);
            }
            edit.putString(mTicketId, str);
            edit.commit();
        }
    }

    @Override // defpackage.d20
    public void m() {
        xt.f3961a.K().deleteAllOnlineCardRechargeData();
    }

    @Override // defpackage.d20
    public List<ProductDiscountsObject> m0(String str) {
        String f2;
        JSONObject jSONObject;
        if (!(str == null || (f2 = xt.f3961a.t().f("productDiscounts")) == null)) {
            try {
                JSONObject jSONObject2 = new JSONObject(f2);
                if (jSONObject2.has(str.toLowerCase()) && (jSONObject = jSONObject2.getJSONObject(str.toLowerCase())) != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONObject jSONObject3 = jSONObject.getJSONObject(next);
                        if (jSONObject3.has("text")) {
                            ProductDiscountsObject productDiscountsObject = new ProductDiscountsObject();
                            productDiscountsObject.setIsEnabled(jSONObject3.optBoolean("enabled", true));
                            if (productDiscountsObject.isIsEnabled()) {
                                productDiscountsObject.setOrder(jSONObject3.optInt(ProductDiscountsObject.KEY_ORDER, Integer.MAX_VALUE));
                                productDiscountsObject.setVersion(jSONObject3.getInt("version"));
                                productDiscountsObject.setText(jSONObject3.getString("text"));
                                productDiscountsObject.setHighlight(jSONObject3.optString(ProductDiscountsObject.KEY_HIGHLIGHT, null));
                                productDiscountsObject.setAction(jSONObject3.optString("action", null));
                                productDiscountsObject.setImageUrl(jSONObject3.optString(ProductDiscountsObject.KEY_IMG_URL, null));
                                productDiscountsObject.setImpressionThreshold(jSONObject3.optInt(ProductDiscountsObject.KEY_IMPRESSION_THRESHOLD, Integer.MAX_VALUE));
                                productDiscountsObject.setShowDiscountImage(jSONObject3.optBoolean(ProductDiscountsObject.KEY_SHOW_IMAGE, true));
                                productDiscountsObject.setBookingType(next);
                                if (jSONObject3.has(ProductDiscountsObject.KEY_ROUTES)) {
                                    ArrayList arrayList2 = new ArrayList();
                                    JSONArray jSONArray = jSONObject3.getJSONArray(ProductDiscountsObject.KEY_ROUTES);
                                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                                        arrayList2.add(jSONArray.getString(i2));
                                    }
                                    productDiscountsObject.setRoutes(arrayList2);
                                }
                                arrayList.add(productDiscountsObject);
                            }
                        }
                    }
                    Collections.sort(arrayList, new h0(this));
                    return arrayList;
                }
            } catch (Exception e2) {
                e2.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
        }
        return null;
    }

    @Override // defpackage.d20
    public void n(String str) {
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(this.t);
        builder.appendEncodedPath("v1");
        builder.appendEncodedPath(ProductPromotionsObject.KEY_CITIES);
        builder.appendEncodedPath(xt.f3961a.k().d().getName().toLowerCase());
        builder.appendEncodedPath("agencies");
        builder.appendEncodedPath(str);
        builder.appendEncodedPath(BaseConstants.DEFAULT_SENDER);
        ut.a aVar = ut.f3552a;
        builder.appendQueryParameter("ver", String.valueOf(764));
        e70 e70 = new e70(0, builder.toString(), new d(this), new e(this), null);
        e70.q = new nj1(2500, 5, 1.0f);
        this.q.a(e70);
    }

    @Override // defpackage.d20
    public void n0(String str) {
        ProductRepository productRepository = new ProductRepository(this.r);
        ArrayList arrayList = new ArrayList();
        RideDetails rideDetails = new RideDetails(str, arrayList);
        UUID.randomUUID().toString();
        rideDetails.set_rideInfoList(arrayList);
        productRepository.insertRideDetails(rideDetails);
        productRepository.getAllRideDetails();
    }

    @Override // defpackage.d20
    public String o(String str) {
        return this.g.b.getString(str, "online");
    }

    @Override // defpackage.d20
    public Map<String, String> o0(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<ProductDisplayProps> list = this.w;
        if (list == null) {
            b00 b00 = b00.f358a;
            b00.a().a("Configuration call failure=>", str);
            return null;
        }
        for (ProductDisplayProps productDisplayProps : list) {
            linkedHashMap.put(productDisplayProps.getProductCategoryId(), productDisplayProps.getProductCategoryName());
        }
        return linkedHashMap;
    }

    public void onEvent(if1 if1) {
        vn.r(if1.f1514a, this.r);
    }

    @Override // defpackage.d20
    public Map<String, String> p() {
        Map<String, ?> b2 = this.m.b();
        HashMap hashMap = new HashMap();
        for (String str : b2.keySet()) {
            hashMap.put(str, this.m.f(str, null));
        }
        return hashMap;
    }

    @Override // defpackage.d20
    public void p0(ScanPayTicket scanPayTicket, String str) {
        String p2 = this.p.p(scanPayTicket, str);
        BookingTransaction bookingTransaction = new BookingTransaction();
        bookingTransaction.setScanPayTicket(scanPayTicket);
        bookingTransaction.setTotalFare(scanPayTicket.get_fare());
        Context context = this.r;
        String str2 = scanPayTicket.get_agencyName();
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(this.s).appendEncodedPath("v1").appendEncodedPath(ProductPromotionsObject.KEY_CITIES).appendEncodedPath(xt.f3961a.k().d().getDisplayName().toLowerCase()).appendEncodedPath("agencies").appendEncodedPath(str2).appendEncodedPath("scanpay");
        e70 e70 = new e70(context, false, 1, builder.build().toString(), new t(bookingTransaction), new e0(scanPayTicket, str, bookingTransaction), p2);
        e70.n = false;
        this.q.a(e70);
    }

    @Override // defpackage.d20
    public void q(String str, String str2, String str3, List<VehicleInfo> list, int i2, int i3) {
        if (i3 != 0) {
            StringBuilder i02 = hj1.i0("seatAvailabilityOccupancyFactor");
            i02.append(str.toLowerCase());
            String sb = i02.toString();
            xt.t1 t1Var = xt.f3961a;
            String a2 = t1Var.l().a(sb);
            String optString = t1Var.l().h.optString("seatAvailabilityDelayThreshold", null);
            if (!(a2 == null || optString == null)) {
                int parseInt = Integer.parseInt(a2);
                int parseInt2 = Integer.parseInt(optString);
                if (parseInt == 0) {
                    parseInt = 100;
                }
                String str4 = ut.G;
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    jSONObject.put("cityId", str);
                    jSONObject.put("mode", i3);
                    jSONObject.put("maxDelay", parseInt2);
                    jSONObject.put("occupancyFactor", parseInt);
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("number", list.get(i4).getVehicleNo());
                        jSONObject2.put("timeStamp", list.get(i4).getTimeStamp());
                        jSONObject2.put(LoggingConstants.ROUTE_ID, str2);
                        jSONObject2.put("stopId", str3);
                        jSONArray.put(jSONObject2);
                    }
                    jSONObject.put("vehicle", jSONArray);
                } catch (Exception unused) {
                }
                e70 e70 = new e70(1, str4, new f(this), new g(this), jSONObject.toString(), i3);
                e70.q = new nj1(5000, 1, 1.0f);
                e70.n = true;
                this.q.a(e70);
            }
        }
    }

    @Override // defpackage.d20
    public void r(List<String> list) {
        JSONArray jSONArray = new JSONArray();
        String str = null;
        if (list.size() > 0) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(SuperPassJsonKeys.ORDER_ID, list.get(0));
                jSONArray.put(jSONObject);
                str = jSONArray.toString();
            } catch (JSONException unused) {
            }
        }
        Context context = this.r;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(this.s).appendEncodedPath("v1").appendEncodedPath("orders").appendEncodedPath("status");
        e70 e70 = new e70(context, false, 1, builder.toString(), new r0(this), new s0(this, list), str);
        e70.q = new nj1(Indexable.MAX_STRING_LENGTH, 1, 1.0f);
        e70.n = false;
        this.q.a(e70);
    }

    @Override // defpackage.d20
    public void s() {
        rf1 rf1 = this.f;
        rf1.f3075a.remove("pending_pass_key");
        rf1.f3075a.commit();
    }

    @Override // defpackage.d20
    public ProductPromotionsObject t(String str, String str2, boolean z2) {
        if (str2 != null) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.has(str)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str);
                    if (z2) {
                        ProductPromotionsObject productPromotionsObject = new ProductPromotionsObject();
                        if (jSONObject2.has(ProductPromotionsObject.KEY_BACKGROUND)) {
                            productPromotionsObject.setBgVisibility(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_BACKGROUND).optBoolean(ProductPromotionsObject.KEY_VISIBILITY, true));
                            productPromotionsObject.setBgUrl(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_BACKGROUND).optString("url", null));
                            productPromotionsObject.setAction(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_BACKGROUND).optString("action", null));
                        }
                        if (jSONObject2.has(ProductPromotionsObject.KEY_TITLE)) {
                            productPromotionsObject.setTitleVisibility(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_TITLE).optBoolean(ProductPromotionsObject.KEY_VISIBILITY, true));
                            productPromotionsObject.setTitleText(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_TITLE).optString("text", null));
                        }
                        if (jSONObject2.has(ProductPromotionsObject.KEY_BODY)) {
                            productPromotionsObject.setBodyVisibility(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_BODY).optBoolean(ProductPromotionsObject.KEY_VISIBILITY, true));
                            productPromotionsObject.setBodyText(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_BODY).optString("text", null));
                        }
                        if (jSONObject2.has(ProductPromotionsObject.KEY_IMAGE)) {
                            productPromotionsObject.setImgVisibility(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_IMAGE).optBoolean(ProductPromotionsObject.KEY_VISIBILITY, true));
                            productPromotionsObject.setImgUrl(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_IMAGE).optString("url", null));
                        }
                        if (jSONObject2.has(ProductPromotionsObject.KEY_POSITIVE_BTN)) {
                            productPromotionsObject.setPositiveBtnVisibility(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_POSITIVE_BTN).optBoolean(ProductPromotionsObject.KEY_VISIBILITY, true));
                            productPromotionsObject.setPositiveBtnText(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_POSITIVE_BTN).optString("text", null));
                            productPromotionsObject.setPositiveBtnCta(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_POSITIVE_BTN).optString(ProductPromotionsObject.KEY_CTA, null));
                        }
                        if (jSONObject2.has(ProductPromotionsObject.KEY_NEGATIVE_BTN)) {
                            productPromotionsObject.setNegativeBtnVisibility(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_NEGATIVE_BTN).optBoolean(ProductPromotionsObject.KEY_VISIBILITY, true));
                            productPromotionsObject.setNegativeBtnText(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_NEGATIVE_BTN).optString("text", null));
                            productPromotionsObject.setNegativeBtnCta(jSONObject2.getJSONObject(ProductPromotionsObject.KEY_NEGATIVE_BTN).optString(ProductPromotionsObject.KEY_CTA, null));
                        }
                        return productPromotionsObject;
                    }
                }
            } catch (Exception e2) {
                e2.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
        }
        return null;
    }

    public final String t0(String str, String str2, String str3) {
        return str.toLowerCase() + ProductDiscountsObject.KEY_DELIMITER + str2 + ProductDiscountsObject.KEY_DELIMITER + str3;
    }

    @Override // defpackage.d20
    public Guidelines u(String str, String str2, String str3) {
        String[] strArr;
        if (!(str == null || str2 == null || str3 == null)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = str2.toLowerCase();
            String lowerCase3 = str3.toLowerCase();
            String f2 = xt.f3961a.t().f("guidelinesMap");
            if (f2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(f2);
                    if (jSONObject.has(lowerCase) && jSONObject.getJSONObject(lowerCase).has(lowerCase2) && jSONObject.getJSONObject(lowerCase).getJSONObject(lowerCase2).has(lowerCase3)) {
                        JSONObject jSONObject2 = jSONObject.getJSONObject(lowerCase).getJSONObject(lowerCase2).getJSONObject(lowerCase3);
                        Guidelines guidelines = new Guidelines();
                        JSONArray jSONArray = jSONObject2.getJSONArray("instructions");
                        Guideline[] guidelineArr = new Guideline[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                            JSONArray optJSONArray = jSONObject3.optJSONArray("subItems");
                            if (optJSONArray != null) {
                                strArr = new String[optJSONArray.length()];
                                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                                    strArr[i3] = optJSONArray.getString(i3);
                                }
                            } else {
                                strArr = null;
                            }
                            guidelineArr[i2] = new Guideline(jSONObject3.getString("item"), strArr);
                        }
                        String string = jSONObject2.getString(ProductPromotionsObject.KEY_TITLE);
                        guidelines.setUrl(jSONObject2.optString("url"));
                        guidelines.setGuidelineList(guidelineArr);
                        guidelines.setTitle(string);
                        return guidelines;
                    }
                } catch (JSONException e2) {
                    e2.getMessage();
                }
            }
        }
        return null;
    }

    public final void u0(String str, BookingTransaction bookingTransaction) {
        jz5.b().g(new BookingTransactionEvent(ad1.FAILED, str, bookingTransaction, null, null, null, null, null, null));
    }

    @Override // defpackage.d20
    public void v(String str) {
        Toast.makeText(this.r, "Session Expired, please login again", 0).show();
        xt.t1 t1Var = xt.f3961a;
        t1Var.S().b(new i(this));
        t1Var.L().i(true, str);
        Intent intent = new Intent(this.r, UserProfileActivity.class);
        intent.putExtra("src", "auth");
        intent.addFlags(268468224);
        this.r.startActivity(intent);
    }

    public byte[] v0(Bitmap bitmap) {
        int i2;
        int i3;
        int i4;
        Bitmap bitmap2;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inBitmap = bitmap;
        options.outHeight = bitmap.getHeight();
        int width = bitmap.getWidth();
        options.outWidth = width;
        int i5 = options.outHeight;
        float f2 = (float) (width / i5);
        float f3 = (float) i5;
        if (f3 <= 816.0f && ((float) width) <= 612.0f) {
            i3 = width;
            i2 = i5;
        } else if (f2 < 0.75f) {
            i3 = (int) ((816.0f / f3) * ((float) width));
            i2 = (int) 816.0f;
        } else {
            i2 = f2 > 0.75f ? (int) ((612.0f / ((float) width)) * f3) : (int) 816.0f;
            i3 = (int) 612.0f;
        }
        if (i5 > i2 || width > i3) {
            i4 = Math.round(((float) i5) / ((float) i2));
            int round = Math.round(((float) width) / ((float) i3));
            if (i4 >= round) {
                i4 = round;
            }
        } else {
            i4 = 1;
        }
        while (((float) (width * i5)) / ((float) (i4 * i4)) > ((float) (i3 * i2 * 2))) {
            i4++;
        }
        options.inSampleSize = i4;
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inTempStorage = new byte[16384];
        try {
            bitmap2 = Bitmap.createBitmap(i3, i2, Bitmap.Config.ARGB_8888);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            bitmap2 = null;
        }
        float f4 = (float) i3;
        float f5 = f4 / ((float) options.outWidth);
        float f6 = (float) i2;
        float f7 = f6 / ((float) options.outHeight);
        float f8 = f4 / 2.0f;
        float f9 = f6 / 2.0f;
        Matrix matrix = new Matrix();
        matrix.setScale(f5, f7, f8, f9);
        Canvas canvas = new Canvas(bitmap2);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, f8 - ((float) (bitmap.getWidth() / 2)), f9 - ((float) (bitmap.getHeight() / 2)), new Paint(2));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // defpackage.d20
    public void w(MPass mPass, String str, String str2, String str3) {
        String str4;
        JSONException e2;
        String str5;
        Objects.requireNonNull(this.p);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("transactionType", "MOBILE_PASS");
            jSONObject.put("lpVer", "v1");
            ut.a aVar = ut.f3552a;
            jSONObject.put("appVer", 764);
            try {
                jSONObject.put(AnalyticsConstants.TOKEN, str2);
                jSONObject.put("city", xt.f3961a.k().d().getName());
                try {
                    jSONObject.put("paymentType", str3);
                    jSONObject.put("isSubMerchant", true);
                    jSONObject.put("passType", mPass.getPassBookingType().name());
                    jSONObject.put(SuperPassJsonKeys.NUM_OF_DAYS, mPass.getNoOfDays());
                    jSONObject.put(SuperPassJsonKeys.PASS_FARE, mPass.getFare());
                    jSONObject.put(SuperPassJsonKeys.CONFIGURATION_ID, mPass.getConfigId());
                    jSONObject.put(Constants.START_STOP_NAME, "");
                    jSONObject.put("startStopId", "");
                    jSONObject.put(Constants.END_STOP_STOP_NAME, "");
                    jSONObject.put("endStopId", "");
                    jSONObject.put("agency", mPass.getAgency());
                    jSONObject.put("userId", mPass.getUserProfile().getUserId());
                } catch (JSONException e3) {
                    e2 = e3;
                    b00 b00 = b00.f358a;
                    hj1.W0(e2);
                    str4 = null;
                    BookingTransaction bookingTransaction = new BookingTransaction();
                    bookingTransaction.setMagicPass(mPass);
                    bookingTransaction.setTotalFare(mPass.getFare());
                    ui1.a(this.r);
                    e70 e70 = new e70(this.r, true, 1, hj1.a0(new StringBuilder(), this.s, "v2/passTransaction"), new n0(bookingTransaction), new t0(mPass, str, str2, str3, bookingTransaction), str4);
                    e70.n = false;
                    this.q.a(e70);
                }
                try {
                    jSONObject.put(SuperPassJsonKeys.START_TIME, str);
                    jSONObject.put("passengerType", mPass.getPassengerType().toUpperCase());
                    if ("superSaver".equals(mPass.get_productType()) && mPass.get_grouping() != null) {
                        jSONObject.put("category", mPass.get_grouping().getCategoryId());
                    }
                    if (mPass.getBookingPassId() != null) {
                        jSONObject.put("passId", mPass.getBookingPassId());
                    }
                    RouteStopsInfo routeStopsInfo = mPass.getRouteStopsInfo();
                    JSONArray jSONArray = new JSONArray();
                    JSONArray jSONArray2 = new JSONArray();
                    JSONArray jSONArray3 = new JSONArray();
                    JSONArray jSONArray4 = new JSONArray();
                    JSONArray jSONArray5 = new JSONArray();
                    JSONArray jSONArray6 = new JSONArray();
                    JSONArray jSONArray7 = new JSONArray();
                    List<String> specialFeatures = mPass.getSpecialFeatures();
                    if (specialFeatures != null) {
                        str5 = "";
                        for (int i2 = 0; i2 < specialFeatures.size(); i2++) {
                            jSONArray.put(specialFeatures.get(i2));
                        }
                    } else {
                        str5 = "";
                    }
                    if (routeStopsInfo != null) {
                        String routeId = routeStopsInfo.getRouteId();
                        if (routeId == null) {
                            routeId = str5;
                        }
                        jSONArray2.put(0, routeId);
                        String routeName = routeStopsInfo.getRouteName();
                        if (routeName == null) {
                            routeName = str5;
                        }
                        jSONArray3.put(0, routeName);
                        String startStopId = routeStopsInfo.getStartStopId();
                        if (startStopId == null) {
                            startStopId = str5;
                        }
                        jSONArray4.put(0, startStopId);
                        String startStopName = routeStopsInfo.getStartStopName();
                        if (startStopName == null) {
                            startStopName = str5;
                        }
                        jSONArray5.put(0, startStopName);
                        String endStopId = routeStopsInfo.getEndStopId();
                        if (endStopId == null) {
                            endStopId = str5;
                        }
                        jSONArray6.put(0, endStopId);
                        String endStopName = routeStopsInfo.getEndStopName();
                        if (endStopName == null) {
                            endStopName = str5;
                        }
                        jSONArray7.put(0, endStopName);
                    }
                    jSONObject.put("routeIds", jSONArray2);
                    jSONObject.put("routeNames", jSONArray3);
                    jSONObject.put("startStopIds", jSONArray4);
                    jSONObject.put("startStopNames", jSONArray5);
                    jSONObject.put("endStopIds", jSONArray6);
                    jSONObject.put("endStopNames", jSONArray7);
                    jSONObject.put("specialFeatures", jSONArray);
                    jSONObject.put("displayProps", new JSONObject(mPass.getDisplayProps()).toString());
                    jSONObject.put("deviceId", mPass.getDeviceId());
                    str4 = jSONObject.toString();
                } catch (JSONException e4) {
                    e2 = e4;
                    b00 b002 = b00.f358a;
                    hj1.W0(e2);
                    str4 = null;
                    BookingTransaction bookingTransaction2 = new BookingTransaction();
                    bookingTransaction2.setMagicPass(mPass);
                    bookingTransaction2.setTotalFare(mPass.getFare());
                    ui1.a(this.r);
                    e70 e702 = new e70(this.r, true, 1, hj1.a0(new StringBuilder(), this.s, "v2/passTransaction"), new n0(bookingTransaction2), new t0(mPass, str, str2, str3, bookingTransaction2), str4);
                    e702.n = false;
                    this.q.a(e702);
                }
            } catch (JSONException e5) {
                e2 = e5;
                b00 b0022 = b00.f358a;
                hj1.W0(e2);
                str4 = null;
                BookingTransaction bookingTransaction22 = new BookingTransaction();
                bookingTransaction22.setMagicPass(mPass);
                bookingTransaction22.setTotalFare(mPass.getFare());
                ui1.a(this.r);
                e70 e7022 = new e70(this.r, true, 1, hj1.a0(new StringBuilder(), this.s, "v2/passTransaction"), new n0(bookingTransaction22), new t0(mPass, str, str2, str3, bookingTransaction22), str4);
                e7022.n = false;
                this.q.a(e7022);
            }
        } catch (JSONException e6) {
            e2 = e6;
            b00 b00222 = b00.f358a;
            hj1.W0(e2);
            str4 = null;
            BookingTransaction bookingTransaction222 = new BookingTransaction();
            bookingTransaction222.setMagicPass(mPass);
            bookingTransaction222.setTotalFare(mPass.getFare());
            ui1.a(this.r);
            e70 e70222 = new e70(this.r, true, 1, hj1.a0(new StringBuilder(), this.s, "v2/passTransaction"), new n0(bookingTransaction222), new t0(mPass, str, str2, str3, bookingTransaction222), str4);
            e70222.n = false;
            this.q.a(e70222);
        }
        BookingTransaction bookingTransaction2222 = new BookingTransaction();
        bookingTransaction2222.setMagicPass(mPass);
        bookingTransaction2222.setTotalFare(mPass.getFare());
        ui1.a(this.r);
        e70 e702222 = new e70(this.r, true, 1, hj1.a0(new StringBuilder(), this.s, "v2/passTransaction"), new n0(bookingTransaction2222), new t0(mPass, str, str2, str3, bookingTransaction2222), str4);
        e702222.n = false;
        this.q.a(e702222);
    }

    public final void w0(String str, String str2, String str3, String str4, String str5, String str6, String str7, JSONObject jSONObject, String str8) {
        n00 n00;
        String str9;
        JSONException jSONException;
        n00 n002;
        JSONException e2;
        String str10;
        String str11;
        ArrayList arrayList;
        HashSet hashSet;
        n00 n003;
        ProductRepository productRepository;
        JSONArray jSONArray;
        HashSet hashSet2;
        String str12;
        String str13;
        Set<String> set;
        String str14;
        String str15;
        String str16;
        String str17;
        HashSet hashSet3;
        ArrayList arrayList2;
        MPass r2;
        n00 n004;
        JSONException e3;
        int i2;
        JSONArray jSONArray2;
        String str18;
        String str19;
        ArrayList arrayList3;
        HashSet hashSet4;
        HashSet<String> hashSet5;
        n00 n005;
        ProductRepository productRepository2;
        String str20;
        String optString;
        String string;
        Map<String, String> map;
        ProductConfiguration productConfiguration;
        JSONObject jSONObject2;
        double d2;
        ProductFareMapping productFareMapping;
        BookingTransaction bookingTransaction;
        n00 n006 = this;
        String str21 = SuperPassJsonKeys.VERIFICATION_FLAG;
        ArrayList arrayList4 = new ArrayList();
        ProductRepository productRepository3 = new ProductRepository(n006.r);
        productRepository3.deleteAllData();
        try {
            Map<String, String> y2 = n006.p.y(jSONObject);
            if (y2 != null) {
                for (String str22 : y2.keySet()) {
                    n006.l.j(str22, y2.get(str22));
                }
            }
            n006.w = n006.p.z(jSONObject);
            n006.A = n006.p.A(jSONObject);
            Map<ProofUploadDocumentPropsIdentifier, ProofDocumentProps> C2 = n006.p.C(jSONObject);
            n006.B = C2;
            n006.L0(C2);
            Collections.sort(n006.w, y0());
            Map<String, Map<String, String>> map2 = n006.A;
            if (map2 != null) {
                for (Map.Entry<String, Map<String, String>> entry : map2.entrySet()) {
                    String key = entry.getKey();
                    for (Map.Entry<String, String> entry2 : entry.getValue().entrySet()) {
                        n006.m.j(entry2.getKey(), key);
                        n006.y.j(entry2.getKey(), entry2.getValue());
                    }
                }
            }
            List<ProductDisplayProps> list = n006.w;
            if (list != null && list.size() > 0) {
                for (int i3 = 0; i3 < n006.w.size(); i3++) {
                    n006.x.j(n006.w.get(i3).getProductCategoryId(), n006.w.get(i3).getProductCategoryName());
                }
            }
            HashSet hashSet6 = new HashSet();
            if (str != null) {
                JSONArray jSONArray3 = new JSONArray(str);
                for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                    String string2 = jSONArray3.getString(i4);
                    ScanPayTicket E = n006.p.E(string2);
                    E.set_userId(str4);
                    E.set_cityName(E.get_cityName().toLowerCase());
                    ScanPay scanPay = new ScanPay();
                    scanPay.setBookingId(E.get_transactionId());
                    scanPay.setScanPayTicket(E);
                    productRepository3.insertScanPayTicket(scanPay);
                    n006.c.j(E.get_transactionId(), string2);
                    hashSet6.add(E.get_transactionId());
                }
                n006.H0(hashSet6);
            }
            String str23 = SuperPassJsonKeys.USER_PROFILE;
            String str24 = SuperPassJsonKeys.PROOFS;
            if (str5 != null) {
                try {
                    productRepository3.deleteAllPassApplications();
                    JSONArray jSONArray4 = new JSONArray(str5);
                    xt.f3961a.e0().updateSuperPassApplicationTable(jSONArray4);
                    HashSet<String> hashSet7 = new HashSet<>();
                    n00 = n006;
                    int i5 = 0;
                    while (i5 < jSONArray4.length()) {
                        try {
                            JSONObject jSONObject3 = jSONArray4.getJSONObject(i5);
                            if (n00.B0(jSONObject3)) {
                                jSONArray2 = jSONArray4;
                                hashSet4 = hashSet6;
                                long j2 = jSONObject3.getLong(SuperPassJsonKeys.PASS_START_DATE);
                                double d3 = jSONObject3.getDouble(SuperPassJsonKeys.PASS_FARE);
                                arrayList3 = arrayList4;
                                i2 = i5;
                                long optLong = jSONObject3.optLong("bookingTime", 0);
                                String optString2 = jSONObject3.optString("agency", "AICTSL");
                                String string3 = jSONObject3.getString("passengerType");
                                int optInt = jSONObject3.optInt(SuperPassJsonKeys.NUM_OF_DAYS, 30);
                                try {
                                    String optString3 = jSONObject3.optString(SuperPassJsonKeys.REFERENCE_ID, null);
                                    JSONArray optJSONArray = jSONObject3.optJSONArray("specialFeatures");
                                    ArrayList arrayList5 = new ArrayList();
                                    if (optJSONArray != null) {
                                        for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                                            arrayList5.add(optJSONArray.getString(i6));
                                        }
                                    }
                                    JSONArray optJSONArray2 = jSONObject3.optJSONArray("routeIds");
                                    ArrayList arrayList6 = new ArrayList();
                                    if (optJSONArray2 != null) {
                                        for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                                            arrayList6.add(optJSONArray2.getString(i7));
                                        }
                                    }
                                    JSONArray optJSONArray3 = jSONObject3.optJSONArray("routeNames");
                                    ArrayList arrayList7 = new ArrayList();
                                    if (optJSONArray3 != null) {
                                        for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                                            arrayList7.add(optJSONArray3.getString(i8));
                                        }
                                    }
                                    JSONArray optJSONArray4 = jSONObject3.optJSONArray("startStopIds");
                                    ArrayList arrayList8 = new ArrayList();
                                    if (optJSONArray4 != null) {
                                        for (int i9 = 0; i9 < optJSONArray4.length(); i9++) {
                                            arrayList8.add(optJSONArray4.getString(i9));
                                        }
                                    }
                                    JSONArray optJSONArray5 = jSONObject3.optJSONArray("startStopNames");
                                    ArrayList arrayList9 = new ArrayList();
                                    if (optJSONArray5 != null) {
                                        for (int i10 = 0; i10 < optJSONArray5.length(); i10++) {
                                            arrayList9.add(optJSONArray5.getString(i10));
                                        }
                                    }
                                    JSONArray optJSONArray6 = jSONObject3.optJSONArray("endStopIds");
                                    ArrayList arrayList10 = new ArrayList();
                                    if (optJSONArray6 != null) {
                                        for (int i11 = 0; i11 < optJSONArray6.length(); i11++) {
                                            arrayList10.add(optJSONArray6.getString(i11));
                                        }
                                    }
                                    JSONArray optJSONArray7 = jSONObject3.optJSONArray("endStopNames");
                                    ArrayList arrayList11 = new ArrayList();
                                    if (optJSONArray7 != null) {
                                        for (int i12 = 0; i12 < optJSONArray7.length(); i12++) {
                                            arrayList11.add(optJSONArray7.getString(i12));
                                        }
                                    }
                                    optString = jSONObject3.optString("city", xt.f3961a.k().d().getName());
                                    if (!TextUtils.isEmpty(optString)) {
                                        optString = optString.toLowerCase();
                                    }
                                    String optString4 = jSONObject3.optString("reason", null);
                                    PassApplicationRejectionReasons u2 = ov.u(jSONObject3.optJSONObject(SuperPassJsonKeys.REJECTION_REASONS));
                                    PassApplicationActionRequired valueOf = PassApplicationActionRequired.valueOf(jSONObject3.optString(SuperPassJsonKeys.ACTION_REQUIRED, CardValidityCheckEvent.VALIDITY_STATUS_INVALID).toUpperCase());
                                    long optLong2 = jSONObject3.optLong(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME, -1);
                                    String optString5 = jSONObject3.optString(SuperPassJsonKeys.CONFIGURATION_ID, null);
                                    string = jSONObject3.getString("status");
                                    UserProfile H = ov.H(jSONObject3.getString(str23));
                                    HashMap hashMap = new HashMap();
                                    JSONObject jSONObject4 = jSONObject3.getJSONObject(str23);
                                    if (jSONObject4.has(str24)) {
                                        map = n00.x0(jSONObject4.getString(str24));
                                        str19 = str24;
                                    } else {
                                        str19 = str24;
                                        map = hashMap;
                                    }
                                    str18 = str23;
                                    String optString6 = jSONObject3.optString("paymentMode", null);
                                    MPass mPass = new MPass(H, string3, optString2, d3, optInt);
                                    ProductConfiguration m02 = vn.m0(optString5);
                                    if (m02 != null) {
                                        d2 = d3;
                                        try {
                                            String productType = m02.getProductType();
                                            List<ProductFareMapping> list2 = m02.getProductFareMapping().get(string3);
                                            if (list2 == null || list2.size() <= 0) {
                                                productConfiguration = m02;
                                                jSONObject2 = jSONObject3;
                                                productFareMapping = null;
                                            } else {
                                                productConfiguration = m02;
                                                jSONObject2 = jSONObject3;
                                                productFareMapping = vn.o0(arrayList5, list2, ui1.i(optInt));
                                            }
                                            mPass.set_productType(productType);
                                        } catch (JSONException e4) {
                                            jSONException = e4;
                                            str9 = str4;
                                            n002 = this;
                                            n00 = n002;
                                            ad1 ad1 = ad1.FAILED;
                                            n00.K0(ad1);
                                            jz5.b().i(new TransactionsFetchedOnlineEvent(ad1, str9, null));
                                            jSONException.printStackTrace();
                                        }
                                    } else {
                                        d2 = d3;
                                        productConfiguration = m02;
                                        jSONObject2 = jSONObject3;
                                        productFareMapping = null;
                                    }
                                    if (arrayList6.size() > 0) {
                                        mPass.setRouteStopsInfo(new RouteStopsInfo((String) arrayList6.get(0), (String) arrayList7.get(0), null, (String) arrayList9.get(0), null, (String) arrayList11.get(0)));
                                    }
                                    mPass.setStartingTime(j2);
                                    mPass.setDisplayProps(map);
                                    mPass.setStatus(string);
                                    mPass.setPaymentMode(optString6);
                                    mPass.setReferenceId(optString3);
                                    mPass.setPassRejectionReason(optString4);
                                    mPass.set_passApplicationRejectionReasons(u2);
                                    mPass.set_passApplicationActionRequired(valueOf);
                                    mPass.setCity(optString.toLowerCase());
                                    mPass.setBookingTime(optLong);
                                    if (productFareMapping != null) {
                                        mPass.set_productName(productFareMapping.getProductDisplayName());
                                    }
                                    mPass.setVerificationExpiryTime(optLong2);
                                    mPass.setConfigId(optString5);
                                    mPass.setSpecialFeatures(arrayList5);
                                    if (productConfiguration != null && "superSaver".equals(productConfiguration.getProductType())) {
                                        ProductCategory l02 = vn.l0(optString5, string3);
                                        mPass.set_grouping(l02);
                                        long j3 = ((long) (optInt * 24 * 60 * 60)) * 1000;
                                        int maxRides = vn.n0(optString5, string3, j3).getMaxRides();
                                        int maxRidesPerDay = vn.n0(optString5, string3, j3).getMaxRidesPerDay();
                                        if (maxRidesPerDay == 0 || maxRidesPerDay == -1) {
                                            maxRidesPerDay = l02.get_maxRidesPerDay();
                                        }
                                        mPass.set_maxTripsPerDay(maxRidesPerDay);
                                        mPass.set_maxTrips(maxRides);
                                    }
                                    str20 = str21;
                                    if (jSONObject2.has(str20)) {
                                        mPass.set_isVerificationRequired(jSONObject2.getBoolean(str20));
                                    } else {
                                        mPass.set_isVerificationRequired(true);
                                    }
                                    bookingTransaction = new BookingTransaction();
                                    bookingTransaction.setMagicPass(mPass);
                                    PassApplications passApplications = new PassApplications();
                                    passApplications.setAgencyName(mPass.getAgency());
                                    passApplications.setCityName(mPass.get_cityName().toLowerCase());
                                    passApplications.setPassengerType(mPass.getPassengerType());
                                    passApplications.setPass(mPass);
                                    productRepository2 = productRepository3;
                                    productRepository2.insertPendingPass(passApplications);
                                    bookingTransaction.setTotalFare(d2);
                                    n005 = this;
                                } catch (JSONException e5) {
                                    e3 = e5;
                                    n004 = this;
                                    jSONException = e3;
                                    str9 = str4;
                                    ad1 ad12 = ad1.FAILED;
                                    n00.K0(ad12);
                                    jz5.b().i(new TransactionsFetchedOnlineEvent(ad12, str9, null));
                                    jSONException.printStackTrace();
                                }
                                try {
                                    hashSet5 = hashSet7;
                                    hashSet5.add(n005.t0(optString, string3, string));
                                    n005.f2466a.j(n005.t0(optString, string3, string), new ov().c(bookingTransaction));
                                    n00 = n005;
                                } catch (JSONException e6) {
                                    str9 = str4;
                                    jSONException = e6;
                                    n00 = n005;
                                    ad1 ad122 = ad1.FAILED;
                                    n00.K0(ad122);
                                    jz5.b().i(new TransactionsFetchedOnlineEvent(ad122, str9, null));
                                    jSONException.printStackTrace();
                                }
                            } else {
                                n005 = n006;
                                str18 = str23;
                                hashSet4 = hashSet6;
                                str20 = str21;
                                arrayList3 = arrayList4;
                                productRepository2 = productRepository3;
                                str19 = str24;
                                jSONArray2 = jSONArray4;
                                i2 = i5;
                                hashSet5 = hashSet7;
                            }
                            i5 = i2 + 1;
                            jSONArray4 = jSONArray2;
                            productRepository3 = productRepository2;
                            hashSet7 = hashSet5;
                            hashSet6 = hashSet4;
                            arrayList4 = arrayList3;
                            str24 = str19;
                            str23 = str18;
                            str21 = str20;
                            n006 = n005;
                        } catch (JSONException e7) {
                            e3 = e7;
                            n004 = n006;
                            jSONException = e3;
                            str9 = str4;
                            ad1 ad1222 = ad1.FAILED;
                            n00.K0(ad1222);
                            jz5.b().i(new TransactionsFetchedOnlineEvent(ad1222, str9, null));
                            jSONException.printStackTrace();
                        }
                    }
                    n003 = n006;
                    str10 = str23;
                    hashSet = hashSet6;
                    arrayList = arrayList4;
                    productRepository = productRepository3;
                    str11 = str24;
                    try {
                        n00.G0(hashSet7);
                    } catch (JSONException e8) {
                        e2 = e8;
                        str9 = str4;
                    }
                } catch (JSONException e9) {
                    n004 = n006;
                    jSONException = e9;
                    n00 = n004;
                    str9 = str4;
                    ad1 ad12222 = ad1.FAILED;
                    n00.K0(ad12222);
                    jz5.b().i(new TransactionsFetchedOnlineEvent(ad12222, str9, null));
                    jSONException.printStackTrace();
                }
            } else {
                n003 = n006;
                str10 = str23;
                hashSet = hashSet6;
                arrayList = arrayList4;
                productRepository = productRepository3;
                str11 = str24;
                n00 = n003;
            }
            try {
                jSONArray = new JSONArray(str2);
                xt.f3961a.e0().updatePendingSuperPassTable(jSONArray);
                hashSet2 = new HashSet();
                int i13 = 0;
                while (i13 < jSONArray.length()) {
                    JSONObject jSONObject5 = jSONArray.getJSONObject(i13);
                    String optString7 = jSONObject5.optString("productType");
                    if (optString7.equals("scanPay")) {
                        String string4 = jSONArray.getString(i13);
                        ScanPayTicket E2 = n00.p.E(string4);
                        str9 = str4;
                        try {
                            E2.set_userId(str9);
                            ScanPay scanPay2 = new ScanPay();
                            scanPay2.setBookingId(E2.get_transactionId());
                            scanPay2.setScanPayTicket(E2);
                            productRepository.insertScanPayTicket(scanPay2);
                            n00.c.j(E2.get_transactionId(), string4);
                            hashSet3 = hashSet;
                            hashSet3.add(E2.get_transactionId());
                        } catch (JSONException e10) {
                            e2 = e10;
                            jSONException = e2;
                            ad1 ad122222 = ad1.FAILED;
                            n00.K0(ad122222);
                            jz5.b().i(new TransactionsFetchedOnlineEvent(ad122222, str9, null));
                            jSONException.printStackTrace();
                        }
                    } else {
                        hashSet3 = hashSet;
                        if (!SuperPassConstants.PRODUCT_TYPE_SUPER_PASS.equals(optString7) && (r2 = ov.r(jSONArray.getString(i13))) != null) {
                            Map<String, String> hashMap2 = new HashMap<>();
                            str17 = str10;
                            JSONObject jSONObject6 = jSONObject5.getJSONObject(str17);
                            str16 = str11;
                            if (jSONObject6.has(str16)) {
                                hashMap2 = n00.x0(jSONObject6.getString(str16));
                            }
                            r2.getUserProfile().setUserId(str4);
                            r2.setDisplayProps(hashMap2);
                            r2.setCity(r2.get_cityName().toLowerCase());
                            Pass pass = new Pass();
                            pass.setPass(r2);
                            pass.setPassId(r2.getBookingPassId());
                            productRepository.insertPass(pass);
                            n00.b.j(r2.getOrderId(), ov.f(r2));
                            BookingTransaction bookingTransaction2 = new BookingTransaction();
                            bookingTransaction2.setMagicPass(r2);
                            bookingTransaction2.setTransactionId(r2.getBookingPassId());
                            bookingTransaction2.setTotalFare(r2.getFare());
                            arrayList2 = arrayList;
                            arrayList2.add(bookingTransaction2);
                            hashSet2.add(r2.getOrderId());
                            i13++;
                            arrayList = arrayList2;
                            hashSet = hashSet3;
                            str10 = str17;
                            str11 = str16;
                        }
                    }
                    arrayList2 = arrayList;
                    str16 = str11;
                    str17 = str10;
                    i13++;
                    arrayList = arrayList2;
                    hashSet = hashSet3;
                    str10 = str17;
                    str11 = str16;
                }
                str9 = str4;
                str12 = str11;
                str13 = str10;
            } catch (JSONException e11) {
                e = e11;
                str9 = str4;
                jSONException = e;
                ad1 ad1222222 = ad1.FAILED;
                n00.K0(ad1222222);
                jz5.b().i(new TransactionsFetchedOnlineEvent(ad1222222, str9, null));
                jSONException.printStackTrace();
            }
            try {
                n00.H0(hashSet);
                n00.F0(hashSet2);
                HashSet hashSet8 = new HashSet();
                JSONArray jSONArray5 = new JSONArray(str3);
                xt.f3961a.e0().updateSuperPassTable(jSONArray5);
                int i14 = 0;
                while (i14 < jSONArray5.length()) {
                    JSONObject jSONObject7 = jSONArray5.getJSONObject(i14);
                    if (n00.B0(jSONObject7)) {
                        MPass r3 = ov.r(jSONArray5.getString(i14));
                        if (n00.C0(r3.getConfigId())) {
                            Map<String, String> hashMap3 = new HashMap<>();
                            JSONObject jSONObject8 = jSONObject7.getJSONObject(str13);
                            if (jSONObject8.has(str12)) {
                                hashMap3 = n00.x0(jSONObject8.getString(str12));
                            }
                            r3.getUserProfile().setUserId(str9);
                            r3.setDisplayProps(hashMap3);
                            MPass S = n00.S(r3, false);
                            if (S.getLastPunch() != null) {
                                long punchingTime = S.getLastPunch().getPunchingTime();
                                str14 = str13;
                                str15 = str12;
                                if (punchingTime > n00.h.e(S.getBookingPassId(), 0)) {
                                    n00.h.i(S.getBookingPassId(), punchingTime);
                                }
                            } else {
                                str14 = str13;
                                str15 = str12;
                            }
                            S.setCity(S.get_cityName().toLowerCase());
                            BookingTransaction bookingTransaction3 = new BookingTransaction();
                            bookingTransaction3.setMagicPass(S);
                            Pass pass2 = new Pass();
                            pass2.setPassId(S.getBookingPassId());
                            pass2.setPass(S);
                            productRepository.insertPass(pass2);
                            bookingTransaction3.setTransactionId(S.getBookingPassId());
                            bookingTransaction3.setTotalFare(S.getFare());
                            arrayList.add(bookingTransaction3);
                            hashSet8.add(S.getBookingPassId());
                            i14++;
                            str12 = str15;
                            str13 = str14;
                        }
                    }
                    str14 = str13;
                    str15 = str12;
                    i14++;
                    str12 = str15;
                    str13 = str14;
                }
                n00.E0(hashSet8);
                n00.M0(str6, str8);
                HashSet hashSet9 = new HashSet();
                int i15 = R.string.FROM;
                int i16 = R.string.FROM_KEY;
                if (str7 != null) {
                    try {
                        Context context = n00.r;
                        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getString(R.string.mTicketBookTime), 0);
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        Set<String> keySet = sharedPreferences.getAll().keySet();
                        JSONArray jSONArray6 = new JSONArray(str7);
                        int i17 = 0;
                        while (i17 < jSONArray6.length()) {
                            MTicket q2 = n00.p.q(jSONArray6.getString(i17));
                            n00.I0(q2);
                            ProductConfiguration h02 = n00.h0(q2.getMTicketConfiguration().getId());
                            if (keySet.contains(q2.getMTicketId()) || q2.isMTicketExpired() || q2.isMTicketActive() || h02 == null) {
                                set = keySet;
                            } else {
                                Context context2 = n00.r;
                                SharedPreferences.Editor edit2 = context2.getSharedPreferences(context2.getString(i16), 0).edit();
                                edit2.putString(n00.r.getString(R.string.FROM), n00.r.getString(R.string.booking));
                                edit2.commit();
                                String mTicketId = q2.getMTicketId();
                                StringBuilder sb = new StringBuilder();
                                sb.append("mticket=>");
                                set = keySet;
                                sb.append(ui1.Q());
                                edit.putString(mTicketId, sb.toString());
                                edit.commit();
                            }
                            q2.setUserId(str9);
                            Ticket currentTicket = productRepository.getCurrentTicket(q2.getMTicketId());
                            if (currentTicket != null) {
                                MTicket mTicket = currentTicket.getmTicket();
                                q2.setUpTripActivationTime(mTicket.getUpTripActivationTime());
                                q2.setIsUpTripActivated(mTicket.isUpTripActivated());
                            }
                            q2.setCityName(q2.getCityName().toLowerCase());
                            Ticket ticket = new Ticket();
                            ticket.setmTicket(q2);
                            ticket.setTicketId(q2.getMTicketId());
                            productRepository.insertOrUpdate(ticket);
                            hashSet9.add(q2.getMTicketId());
                            i17++;
                            n00 = this;
                            keySet = set;
                            i16 = R.string.FROM_KEY;
                        }
                    } catch (JSONException e12) {
                        jSONException = e12;
                        n002 = this;
                        n00 = n002;
                        ad1 ad12222222 = ad1.FAILED;
                        n00.K0(ad12222222);
                        jz5.b().i(new TransactionsFetchedOnlineEvent(ad12222222, str9, null));
                        jSONException.printStackTrace();
                    }
                }
                if (str2 != null) {
                    n002 = this;
                    try {
                        Context context3 = n002.r;
                        SharedPreferences sharedPreferences2 = context3.getSharedPreferences(context3.getString(R.string.mTicketBookTime), 0);
                        SharedPreferences.Editor edit3 = sharedPreferences2.edit();
                        Set<String> keySet2 = sharedPreferences2.getAll().keySet();
                        int i18 = 0;
                        while (i18 < jSONArray.length()) {
                            MTicket q3 = n002.p.q(jSONArray.getString(i18));
                            if (q3 != null) {
                                ProductConfiguration h03 = n002.h0(q3.getMTicketConfiguration().getId());
                                if (!keySet2.contains(q3.getMTicketId()) && !q3.isMTicketExpired() && !q3.isMTicketActive() && h03 != null) {
                                    Context context4 = n002.r;
                                    SharedPreferences.Editor edit4 = context4.getSharedPreferences(context4.getString(R.string.FROM_KEY), 0).edit();
                                    edit4.putString(n002.r.getString(i15), n002.r.getString(R.string.booking));
                                    edit4.commit();
                                    String mTicketId2 = q3.getMTicketId();
                                    edit3.putString(mTicketId2, "mticket=>" + ui1.Q());
                                    edit3.commit();
                                }
                                q3.setUserId(str9);
                                n002.I0(q3);
                                q3.setCityName(q3.getCityName().toLowerCase());
                                Ticket ticket2 = new Ticket();
                                ticket2.setmTicket(q3);
                                ticket2.setTicketId(q3.getMTicketId());
                                productRepository.insertOrUpdate(ticket2);
                                hashSet9.add(q3.getMTicketId());
                            }
                            i18++;
                            i15 = R.string.FROM;
                        }
                    } catch (JSONException e13) {
                        e = e13;
                        jSONException = e;
                        n00 = n002;
                        ad1 ad122222222 = ad1.FAILED;
                        n00.K0(ad122222222);
                        jz5.b().i(new TransactionsFetchedOnlineEvent(ad122222222, str9, null));
                        jSONException.printStackTrace();
                    }
                } else {
                    n002 = this;
                }
                n002.D0(hashSet9);
                ad1 ad13 = ad1.SUCCESS;
                n002.K0(ad13);
                jz5.b().i(new TransactionsFetchedOnlineEvent(ad13, str9, null));
            } catch (JSONException e14) {
                e = e14;
                jSONException = e;
                ad1 ad1222222222 = ad1.FAILED;
                n00.K0(ad1222222222);
                jz5.b().i(new TransactionsFetchedOnlineEvent(ad1222222222, str9, null));
                jSONException.printStackTrace();
            }
        } catch (JSONException e15) {
            e = e15;
            n002 = n006;
            str9 = str4;
            jSONException = e;
            n00 = n002;
            ad1 ad12222222222 = ad1.FAILED;
            n00.K0(ad12222222222);
            jz5.b().i(new TransactionsFetchedOnlineEvent(ad12222222222, str9, null));
            jSONException.printStackTrace();
        }
    }

    @Override // defpackage.d20
    public long x(long j2, String str) {
        return this.h.b.getLong(str, 0) + j2;
    }

    public Map<String, String> x0(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            hj1.W0(e2);
            return hashMap;
        }
    }

    @Override // defpackage.d20
    public void y(String str, String str2, BookingTransaction bookingTransaction, String str3) {
        this.f2466a.j(t0(str, str2, str3), new ov().c(bookingTransaction));
    }

    public final java.util.Comparator<ProductDisplayProps> y0() {
        return new v(this);
    }

    @Override // defpackage.d20
    public void z(String str, a1 a1Var) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("refreshToken", str);
            xt.t1 t1Var = xt.f3961a;
            jSONObject.put("userId", t1Var.m0());
            jSONObject.put("deviceId", t1Var.n().a());
            String jSONObject2 = jSONObject.toString();
            String str2 = ut.x;
            e70 e70 = new e70(1, str2, new m(a1Var), new n(str2, a1Var), jSONObject2);
            e70.n = false;
            this.q.a(e70);
        } catch (JSONException unused) {
        }
    }

    public final String z0(String str, int i2) {
        return str + ProductDiscountsObject.KEY_DELIMITER + i2;
    }

    public void onEvent(bf1 bf1) {
        try {
            JSONObject jSONObject = new JSONObject(bf1.c);
            String optString = jSONObject.optString("ticketId", "");
            MTicketTripReceipt t2 = ov.t(jSONObject);
            vn.r(optString, this.r);
            Context context = this.r;
            xt.t1 t1Var = xt.f3961a;
            if (ui1.b0(TransitMode.bus, t1Var.k().d()) && t1Var.L().m()) {
                ProductRepository productRepository = new ProductRepository(context);
                productRepository.updateExpiryState(optString);
                productRepository.addTripReceiptToMTicket(optString, t2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void onEvent(cf1 cf1) {
        jz5.b().m(cf1);
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.L().m()) {
            d(t1Var.L().getUserId(), null);
            Notification x02 = vn.x0(this.r, cf1.f560a, cf1.b, null, "myChannel");
            NotificationManager notificationManager = (NotificationManager) this.r.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("myChannel", "NewGroup", 4);
                int i2 = jc5.b(this.r).w;
                if (i2 == 2 || i2 == -1) {
                    notificationChannel.enableVibration(true);
                }
                if (i2 == 4 || i2 == -1) {
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(-1);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.cancel(5);
            notificationManager.notify(5, x02);
        }
    }

    public void onEvent(ef1 ef1) {
        Notification x02 = vn.x0(this.r, ef1.f967a, ef1.b, "zophop://book/pass?source=notification", "myChannel");
        NotificationManager notificationManager = (NotificationManager) this.r.getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("myChannel", "NewGroup", 4);
            int i2 = jc5.b(this.r).w;
            if (i2 == 2 || i2 == -1) {
                notificationChannel.enableVibration(true);
            }
            if (i2 == 4 || i2 == -1) {
                notificationChannel.enableLights(true);
                notificationChannel.setLightColor(-1);
            }
            notificationManager.createNotificationChannel(notificationChannel);
        }
        notificationManager.notify(0, x02);
        jz5.b().m(ef1);
    }

    public void onEvent(gf1 gf1) {
        String str;
        int i2;
        String str2;
        Intent intent;
        jz5.b().m(gf1);
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.L().m()) {
            d(t1Var.L().getUserId(), t1Var.L().j());
            Context context = this.r;
            n86.e(gf1, "lSuperPassApplicationUpdatedEvent");
            n86.e(context, "lContext");
            JSONObject jSONObject = new JSONObject(gf1.c);
            String str3 = gf1.f1253a;
            String str4 = gf1.b;
            BookableSuperPassConfiguration b2 = x60.b(jSONObject);
            if (b2 == null) {
                x60.a(str3, str4, x60.c(context), 1, context);
                return;
            }
            SuperPassUserDetails f2 = x60.f(jSONObject);
            String string = jSONObject.getString("status");
            n86.d(string, "lPayloadJson.getString(KEY_APPLICATION_STATUS)");
            String upperCase = string.toUpperCase();
            n86.d(upperCase, "(this as java.lang.String).toUpperCase()");
            int ordinal = SuperPassApplicationStatus.valueOf(upperCase).ordinal();
            if (ordinal == 1) {
                n86.e(jSONObject, "lPayload");
                long optLong = jSONObject.optLong(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME, -1);
                str = str4;
                long e2 = x60.e(jSONObject);
                n86.e(context, "lContext");
                n86.e("sourceNotification", "lSource");
                n86.e(b2, "lBookableSuperPassConfiguration");
                n86.e(f2, "lSuperPassUserDetails");
                Intent r02 = SuperPassPurchaseActivity.r0(context, "sourceNotification", "flowPaymentPostVerification", b2);
                r02.putExtra("arg_superPassUserDetails", SuperPassUserDetails.Companion.convertSuperPassUserDetailsToString(f2));
                r02.putExtra("arg_verificationExpiryTime", optLong);
                r02.putExtra("arg_passStartTime", e2);
                intent = r02;
                str2 = str3;
                i2 = 2;
            } else if (ordinal != 2) {
                intent = x60.c(context);
                i2 = 1;
                str = str4;
                str2 = str3;
            } else {
                n86.e(jSONObject, "lPayloadJson");
                String string2 = jSONObject.getString(SuperPassJsonKeys.ACTION_REQUIRED);
                n86.d(string2, "lPayloadJson.getString(KEY_ACTION_REQUIRED)");
                PassApplicationActionRequired valueOf = PassApplicationActionRequired.valueOf(string2);
                PassApplicationRejectionReasons d2 = x60.d(jSONObject);
                long e3 = x60.e(jSONObject);
                if (d2 == null) {
                    intent = x60.c(context);
                } else {
                    n86.e(context, "lContext");
                    n86.e("sourceNotification", "lSource");
                    n86.e(b2, "lBookableSuperPassConfiguration");
                    n86.e(f2, "lSuperPassUserDetails");
                    n86.e(valueOf, "lSuperPassApplicationActionRequired");
                    n86.e(d2, "lPassApplicationRejectionReasons");
                    Intent r03 = SuperPassPurchaseActivity.r0(context, "sourceNotification", "flowReapplication", b2);
                    String convertSuperPassUserDetailsToString = SuperPassUserDetails.Companion.convertSuperPassUserDetailsToString(f2);
                    String convertPassApplicationActionRequiredToString = PassApplicationActionRequired.Companion.convertPassApplicationActionRequiredToString(valueOf);
                    String convertPassApplicationRejectionReasonsToString = PassApplicationRejectionReasons.Companion.convertPassApplicationRejectionReasonsToString(d2);
                    r03.putExtra("arg_superPassUserDetails", convertSuperPassUserDetailsToString);
                    r03.putExtra("arg_passApplicationActionRequired", convertPassApplicationActionRequiredToString);
                    r03.putExtra("arg_passApplicationRejectionReasons", convertPassApplicationRejectionReasonsToString);
                    r03.putExtra("arg_passStartTime", e3);
                    intent = r03;
                }
                i2 = 3;
                str = str4;
                str2 = str3;
            }
            x60.a(str2, str, intent, i2, context);
        }
    }
}
