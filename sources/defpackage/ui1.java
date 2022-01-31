package defpackage;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Agency;
import app.zophop.models.City;
import app.zophop.models.Route;
import app.zophop.models.RouteWithoutTimings;
import app.zophop.models.Stop;
import app.zophop.models.StreamInfo;
import app.zophop.models.TimeInterval;
import app.zophop.models.TransitMode;
import app.zophop.models.Trip;
import app.zophop.models.TripLeg;
import app.zophop.models.http_response.TripSummary;
import app.zophop.models.mTicketing.MPassVerificationTimingDetails;
import app.zophop.models.mTicketing.UserAgencyInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.CheckedinEvent;
import app.zophop.pubsub.eventbus.events.LocationTrackingEvent;
import app.zophop.service.LocationTrackingService;
import app.zophop.ui.activities.HomeActivity;
import com.crashlytics.android.answers.SessionEventTransform;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.gms.maps.model.LatLng;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.razorpay.AnalyticsConstants;
import defpackage.q5;
import defpackage.ut;
import defpackage.xt;
import j$.util.Comparator;
import j$.util.DesugarTimeZone;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.models.Point;
import zophop.models.Fare;
import zophop.models.FareTuple;
import zophop.models.SPECIAL_FEATURE;

/* renamed from: ui1  reason: default package */
/* compiled from: Utils */
public class ui1 {

    /* renamed from: a  reason: collision with root package name */
    public static Set<String> f3507a;
    public static Set<String> b;
    public static ni1 c;
    public static Set<String> d;
    public static final Comparator<FareTuple> e = new a();

    /* renamed from: ui1$a */
    /* compiled from: Utils */
    public class a implements Comparator<FareTuple>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(FareTuple fareTuple, FareTuple fareTuple2) {
            return Double.valueOf(fareTuple.amount).compareTo(Double.valueOf(fareTuple2.amount));
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<FareTuple> reversed() {
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
        public /* synthetic */ java.util.Comparator<FareTuple> thenComparing(java.util.Comparator<? super FareTuple> comparator) {
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

    public static String A(long j, Context context) {
        if (j == 0) {
            return "";
        }
        String h = jh1.h(j / 1000);
        return String.format(context.getString(R.string.live_updated_at), h);
    }

    public static void A0(String str, TransitMode transitMode) {
        ed1 l = hj1.l("checked in route share", Long.MIN_VALUE, "routeName", str);
        l.a("mode", transitMode.toString());
        jz5.b().g(l);
    }

    public static ni1 B() {
        if (c == null) {
            c = new ni1();
        }
        return c;
    }

    public static boolean B0() {
        ut.a aVar = ut.f3552a;
        xt.t1 t1Var = xt.f3961a;
        String f = t1Var.t().f("cityListWithSoundEnabled");
        String B = hj1.B(t1Var);
        if (f != null) {
            try {
                JSONArray jSONArray = new JSONArray(f);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    if (string != null && string.equalsIgnoreCase(B)) {
                        return true;
                    }
                }
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                hj1.X0(e2, b00.a());
            }
        }
        return false;
    }

    public static MPassVerificationTimingDetails C() {
        xt.t1 t1Var = xt.f3961a;
        String f = t1Var.t().f("passApplicationVerificationTimings");
        if (f == null) {
            return new MPassVerificationTimingDetails();
        }
        String C = hj1.C(t1Var);
        try {
            JSONObject jSONObject = new JSONObject(f);
            if (jSONObject.has(C)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(C);
                return new MPassVerificationTimingDetails(jSONObject2.optString("timeReq", ""), jSONObject2.optString("officeTimings", ""));
            }
            if (jSONObject.has("all")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("all");
                return new MPassVerificationTimingDetails(jSONObject3.optString("timeReq", ""), jSONObject3.optString("officeTimings", ""));
            }
            return new MPassVerificationTimingDetails();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean C0() {
        xt.t1 t1Var = xt.f3961a;
        City d2 = t1Var.k().d();
        String name = d2 != null ? d2.getName() : null;
        if (name == null) {
            return true;
        }
        String lowerCase = name.toLowerCase();
        Set<String> set = f3507a;
        if (set == null) {
            f3507a = new HashSet();
            ut.a aVar = ut.f3552a;
            String f = t1Var.t().f("cityListForRouteAgencyTagVisibleProd");
            if (TextUtils.isEmpty(f)) {
                return true;
            }
            try {
                JSONArray jSONArray = new JSONArray(f);
                for (int i = 0; i < jSONArray.length(); i++) {
                    f3507a.add(jSONArray.getString(i));
                }
            } catch (Exception e2) {
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
            if (f3507a.contains(lowerCase)) {
                return false;
            }
            return true;
        } else if (set.contains(lowerCase)) {
            return false;
        } else {
            return true;
        }
    }

    public static int D(List<Fare> list) {
        double d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        double d3 = 0.0d;
        for (Fare fare : list) {
            d2 += fare.default_fare;
            d3 += ((FareTuple) Collections.max(fare.fare_tuples, e)).amount;
        }
        return ((Integer) new Pair(Integer.valueOf((int) Math.round(d2)), Integer.valueOf((int) Math.round(d3))).first).intValue();
    }

    public static boolean D0(Context context) {
        int i;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            i = 0;
        }
        xt.t1 t1Var = xt.f3961a;
        String[] split = t1Var.k0().a().split(",");
        if (i < t1Var.k0().b()) {
            return true;
        }
        for (String str : split) {
            if (Integer.parseInt(str) == i) {
                return true;
            }
        }
        return false;
    }

    public static Stop E(LatLng latLng, List<Stop> list) {
        Stop stop = null;
        if (latLng != null) {
            double d2 = Double.MAX_VALUE;
            for (Stop stop2 : list) {
                if (stop2 != null) {
                    double m = m(latLng, stop2.getLatLong());
                    if (m < d2) {
                        stop = stop2;
                        d2 = m;
                    }
                }
            }
        }
        return stop;
    }

    public static boolean E0() {
        xt.t1 t1Var = xt.f3961a;
        String[] split = t1Var.t().f("routeInfoBannerCityList").split(",");
        String B = hj1.B(t1Var);
        for (String str : split) {
            if (str.equalsIgnoreCase(B)) {
                return true;
            }
        }
        return false;
    }

    public static CharSequence F(Context context, CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) context.getString(R.string.platform)).append((CharSequence) String.valueOf(charSequence));
        spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_REGULAR), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.black)), 0, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static void F0(p5 p5Var) {
        if (p5Var.f.size() > 0) {
            p5Var.e();
        }
    }

    public static Route G(Trip trip, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Stop stop = null;
        for (TripLeg tripLeg : trip.getTripLegs()) {
            arrayList.add(tripLeg.getStop());
            stop = tripLeg.getStop();
        }
        return new Route(trip.get_routeId(), str, trip.getTransitMode(), arrayList, stop, new ArrayList(), str2, false, false, false, false, "", null, null);
    }

    public static void G0(TextView textView, i10 i10, Context context) {
        String R = R(i10.e, i10.f);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) "In ").append((CharSequence) R);
        spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableStringBuilder.length(), 17);
        textView.setText(spannableStringBuilder);
    }

    public static String H() {
        return String.valueOf((char) 8377);
    }

    public static void H0(TextView textView, CharSequence charSequence, Context context, int i) {
        SpannableStringBuilder f = hj1.f("  ");
        f.setSpan(new wa1(context, textView, R.drawable.real_time_indicator, (float) i), 0, 1, 17);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(charSequence);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.eta_blue)), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(18, true), 0, spannableStringBuilder.length(), 17);
        f.append((CharSequence) spannableStringBuilder);
        textView.setText(f);
        textView.setAlpha(1.0f);
    }

    public static SpannableStringBuilder I(Context context, int i) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(jh1.l(jh1.g((long) i), context));
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(16, true), 0, spannableStringBuilder.length(), 17);
        spannableStringBuilder.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, spannableStringBuilder.length(), 17);
        return spannableStringBuilder;
    }

    public static void I0(TextView textView, CharSequence charSequence, Context context) {
        SpannableStringBuilder f = hj1.f("Scheduled for ");
        int length = f.length();
        f.append(charSequence);
        f.setSpan(new AbsoluteSizeSpan(14, true), 0, f.length(), 17);
        f.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.black_60)), 0, length, 17);
        f.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.black_87)), length, f.length(), 17);
        f.setSpan(vn.N(context, wg1.NOTOSANS_REGULAR), 0, f.length(), 17);
        f.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), length, f.length(), 17);
        textView.setText(f);
    }

    public static SpannableStringBuilder J(Context context, List<String> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("");
        if (list != null) {
            if (list.contains("AC")) {
                d71.b(context, spannableStringBuilder, "AC", true, R.color.real_time_fetching_string_color, 0, R.color.white);
            } else if (list.contains("FAST")) {
                d71.b(context, spannableStringBuilder, "FAST", true, R.color.real_time_fetching_string_color, 0, R.color.white);
            }
        }
        return spannableStringBuilder;
    }

    public static void J0(TextView textView, String str, Context context) {
        SpannableStringBuilder f = hj1.f(str);
        f.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.black_60)), 0, f.length(), 17);
        f.setSpan(vn.N(context, wg1.NOTOSANS_REGULAR), 0, f.length(), 17);
        textView.setText(f);
    }

    public static List<Stop> K(List<TripLeg> list) {
        ArrayList arrayList = new ArrayList();
        for (TripLeg tripLeg : list) {
            arrayList.add(tripLeg.getStop());
        }
        return arrayList;
    }

    public static JSONObject K0() {
        JSONObject jSONObject = new JSONObject();
        try {
            xt.t1 t1Var = xt.f3961a;
            jSONObject.put("userId", t1Var.m0());
            if (t1Var.k().d() != null) {
                jSONObject.put("city", t1Var.k().d().getName());
            }
            jSONObject.put("androidModel", Build.MODEL);
            jSONObject.put("androidVersionCode", 764);
            jSONObject.put(SessionEventTransform.OS_VERSION_KEY, Build.VERSION.SDK_INT);
            if (t1Var.z() != null) {
                jSONObject.put("language", t1Var.z().a());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<StreamInfo> L(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<String> keys = jSONObject.keys();
            jSONObject.toString();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.get(next) instanceof String) {
                    String str = (String) jSONObject.get(next);
                    JSONObject jSONObject2 = new JSONObject(str);
                    String string = jSONObject2.getString("vNo");
                    Long valueOf = Long.valueOf(jSONObject2.getLong("tS"));
                    Integer valueOf2 = Integer.valueOf(jSONObject2.getInt("eta"));
                    String string2 = jSONObject2.getString("sId");
                    boolean optBoolean = jSONObject2.optBoolean("_isHalted");
                    StreamInfo streamInfo = new StreamInfo(next, valueOf2.intValue(), string2, (Point) new Gson().fromJson(str, Point.class), valueOf.longValue());
                    streamInfo.setHaltedStatus(optBoolean);
                    ut.a aVar = ut.f3552a;
                    if (Y() || X()) {
                        streamInfo.setVehicleNumber(string);
                    }
                    arrayList.add(streamInfo);
                }
            }
        } catch (JSONException unused) {
        }
        return arrayList;
    }

    public static List<StreamInfo> M(DataSnapshot dataSnapshot) {
        HashMap hashMap = new HashMap();
        for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
            b(hashMap, dataSnapshot2);
        }
        return new ArrayList(hashMap.values());
    }

    public static int N() {
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
        int i = instance.get(11);
        return (((i * 60) + instance.get(12)) * 60) + instance.get(13);
    }

    public static CharSequence O(Context context, String str) {
        if (str == null) {
            return null;
        }
        SpannableStringBuilder f = hj1.f(str.toUpperCase());
        f.setSpan(new AbsoluteSizeSpan(16, true), 0, f.length() - 1, 17);
        f.setSpan(new AbsoluteSizeSpan(14, true), f.length() - 2, f.length(), 17);
        f.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.card_item_enable_color)), 0, f.length(), 17);
        f.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, f.length(), 17);
        return f;
    }

    public static String P(int i, int i2) {
        String str = "";
        try {
            ut.a aVar = ut.f3552a;
            JSONObject jSONObject = new JSONObject(xt.f3961a.t().f("timeTableStatusProd"));
            if (jSONObject.has(String.valueOf(i))) {
                str = jSONObject.getJSONObject(String.valueOf(i)).optString(String.valueOf(i2), str);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        if (i == 1) {
            return "Timings not available";
        }
        return i == 2 ? "Timings may be incorrect." : str;
    }

    public static long Q() {
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.j() == null) {
            return System.currentTimeMillis();
        }
        return t1Var.j().c();
    }

    public static String R(int i, int i2) {
        if (i >= 3600) {
            return jh1.k((long) (i * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)) + "-" + jh1.k((long) (i2 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
        } else if (i < 3600 && i2 >= 3600) {
            return jh1.k((long) (i * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)) + "-" + jh1.k((long) (i2 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
        } else if (i >= 60 && i2 < 3600) {
            return (i / 60) + "-" + jh1.k((long) (i2 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
        } else if (i >= 60) {
            return null;
        } else {
            StringBuilder i0 = hj1.i0("1-");
            i0.append(jh1.k((long) (i2 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)));
            return i0.toString();
        }
    }

    public static boolean S(TripSummary tripSummary) {
        return tripSummary.isFrequencyTrip() && z(N(), tripSummary.getFrequencyList()) == null;
    }

    public static boolean T(Context context, String... strArr) {
        if (context == null || strArr == null) {
            return true;
        }
        for (String str : strArr) {
            if (q5.a(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void U(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        if (inputMethodManager.isActive() && activity.getCurrentFocus() != null) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static boolean V(Context context) {
        if (vn.K0(context) && vn.J0(context)) {
            return true;
        }
        return false;
    }

    public static boolean W() {
        xt.t1 t1Var = xt.f3961a;
        City d2 = t1Var.k().d();
        if (d2 == null) {
            return true;
        }
        if (d == null) {
            d = new HashSet();
            String f = t1Var.t().f("cityDataDisabledCities");
            if (f != null) {
                try {
                    JSONArray jSONArray = new JSONArray(f);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (string != null) {
                            d.add(string.toLowerCase());
                        }
                    }
                } catch (JSONException e2) {
                    b00 b00 = b00.f358a;
                    hj1.X0(e2, b00.a());
                }
            }
        }
        if (d.contains(d2.getName().toLowerCase())) {
            return false;
        }
        return true;
    }

    public static boolean X() {
        xt.t1 t1Var = xt.f3961a;
        String f = t1Var.t().f("cityListRouteDisabled");
        String B = hj1.B(t1Var);
        if (f != null) {
            try {
                JSONArray jSONArray = new JSONArray(f);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    if (string != null && string.equalsIgnoreCase(B)) {
                        return true;
                    }
                }
            } catch (JSONException e2) {
                e2.getMessage();
            }
        }
        return false;
    }

    public static boolean Y() {
        return xt.f3961a.k().d().getName().equalsIgnoreCase("KOCHI");
    }

    public static boolean Z(LatLng latLng) {
        if (latLng == null) {
            latLng = xt.f3961a.B().h();
        }
        return latLng != null && !xt.f3961a.k().d().containsLocation(latLng);
    }

    public static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("accessToken", 0);
            sharedPreferences.edit();
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.L() != null) {
                jSONObject.put("userId", t1Var.L().getUserId());
            }
            jSONObject.put("authType", "ACCESS_TOKEN");
            jSONObject.put("deviceId", t1Var.n().a());
            jSONObject.put("accessToken", sharedPreferences.getString("accessToken", null));
            jSONObject.put("x-type", "pass");
            jSONObject.put("source", 0);
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            b00.a().b(e2);
        }
        return jSONObject;
    }

    public static boolean a0(City city) {
        Map<TransitMode, List<Agency>> modeAgencyMap = city.getModeAgencyMap();
        if (modeAgencyMap == null) {
            return false;
        }
        for (Agency agency : modeAgencyMap.get(TransitMode.bus)) {
            if (agency.isOnlineCardRechargeAvailable()) {
                return true;
            }
        }
        return false;
    }

    public static void b(Map<String, StreamInfo> map, DataSnapshot dataSnapshot) {
        if (dataSnapshot != null) {
            try {
                if (dataSnapshot.getValue() != null) {
                    JSONObject jSONObject = new JSONObject(dataSnapshot.getValue().toString());
                    String string = jSONObject.getString("_vehicleNumber");
                    Long valueOf = Long.valueOf(jSONObject.getLong("_time"));
                    String str = "timestamp = " + valueOf;
                    boolean optBoolean = jSONObject.optBoolean("_isHalted");
                    if (!map.containsKey(string) || valueOf.compareTo(Long.valueOf(map.get(string).getTimeStamp())) > 0) {
                        Integer valueOf2 = Integer.valueOf(jSONObject.getInt("_eta"));
                        StreamInfo streamInfo = new StreamInfo(dataSnapshot.getKey(), valueOf2.intValue(), jSONObject.getString("_stopId"), (Point) new Gson().fromJson(dataSnapshot.getValue().toString(), Point.class), valueOf.longValue());
                        ut.a aVar = ut.f3552a;
                        if (Y() || X()) {
                            streamInfo.setVehicleNumber(string);
                        }
                        streamInfo.setHaltedStatus(optBoolean);
                        map.put(string, streamInfo);
                    }
                }
            } catch (JSONException e2) {
                e2.getLocalizedMessage();
            }
        }
    }

    public static boolean b0(TransitMode transitMode, City city) {
        Map<TransitMode, List<Agency>> modeAgencyMap = city.getModeAgencyMap();
        if (modeAgencyMap == null) {
            return false;
        }
        for (Agency agency : modeAgencyMap.get(transitMode)) {
            if (agency.isProductAvailable()) {
                return true;
            }
        }
        return false;
    }

    public static void c(Context context, e80 e80, LatLng latLng, Class cls, boolean z, String str) {
        if (!e80.d().containsLocation(latLng)) {
            City city = null;
            for (City city2 : e80.e()) {
                if (city2.containsLocation(latLng)) {
                    city = city2;
                }
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            if (city == null) {
                if (z) {
                    builder.setCancelable(false).setMessage(context.getString(R.string.city_not_yet_added));
                    builder.setPositiveButton(context.getString(R.string.ok), new aj1());
                    builder.create().show();
                    ed1 ed1 = new ed1("city not supported prompt open", Long.MIN_VALUE);
                    hj1.K0(ed1, "source", str, ed1);
                    xt.f3961a.k().b();
                }
            } else if (!e80.a()) {
                String g = vn.g(city.getName());
                builder.setCancelable(false).setMessage(String.format(context.getString(R.string.change_city_dialog_title), g));
                builder.setPositiveButton(context.getString(R.string.change), new pi1(e80, city, context, cls));
                builder.setNegativeButton(context.getString(R.string.dont_change), new qi1());
                builder.create().show();
                n0(g, str);
                xt.f3961a.k().b();
            }
        }
    }

    public static boolean c0(City city) {
        Map<TransitMode, List<Agency>> modeAgencyMap = city.getModeAgencyMap();
        if (modeAgencyMap == null) {
            return false;
        }
        for (Agency agency : modeAgencyMap.get(TransitMode.bus)) {
            if (agency.isScanPayAvailable()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean d(app.zophop.models.mTicketing.UserProfile r3, app.zophop.models.Agency r4, java.lang.String r5) {
        /*
            java.util.Map r0 = r4.getPassengerTypeFields()
            boolean r0 = r0.containsKey(r5)
            r1 = 1
            if (r0 == 0) goto L_0x005b
            java.util.Map r0 = r4.getPassengerTypeFields()
            java.lang.Object r5 = r0.get(r5)
            java.util.List r5 = (java.util.List) r5
            java.util.HashMap r0 = r3.getAgencyInfo()
            java.lang.String r2 = r4.getAgencyName()
            boolean r0 = r0.containsKey(r2)
            r2 = 0
            if (r0 == 0) goto L_0x005a
            java.util.HashMap r3 = r3.getAgencyInfo()
            java.lang.String r4 = r4.getAgencyName()
            java.lang.Object r3 = r3.get(r4)
            app.zophop.models.mTicketing.UserAgencyInfo r3 = (app.zophop.models.mTicketing.UserAgencyInfo) r3
            java.util.Map r3 = r3.getAgencyFields()
            java.util.Iterator r4 = r5.iterator()
        L_0x003a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0059
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r0 = r3.containsKey(r5)
            if (r0 == 0) goto L_0x0058
            java.lang.Object r5 = r3.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x003a
        L_0x0058:
            return r2
        L_0x0059:
            return r1
        L_0x005a:
            return r2
        L_0x005b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ui1.d(app.zophop.models.mTicketing.UserProfile, app.zophop.models.Agency, java.lang.String):boolean");
    }

    public static boolean d0(List<SPECIAL_FEATURE> list) {
        return list != null && list.contains(SPECIAL_FEATURE.AC);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(app.zophop.models.mTicketing.UserProfile r3, app.zophop.models.Agency r4, java.lang.String r5) {
        /*
            java.util.Map r0 = r4.getPassengerTypeProofs()
            boolean r0 = r0.containsKey(r5)
            r1 = 1
            if (r0 == 0) goto L_0x005b
            java.util.Map r0 = r4.getPassengerTypeProofs()
            java.lang.Object r5 = r0.get(r5)
            java.util.List r5 = (java.util.List) r5
            java.util.HashMap r0 = r3.getAgencyInfo()
            java.lang.String r2 = r4.getAgencyName()
            boolean r0 = r0.containsKey(r2)
            r2 = 0
            if (r0 == 0) goto L_0x005a
            java.util.HashMap r3 = r3.getAgencyInfo()
            java.lang.String r4 = r4.getAgencyName()
            java.lang.Object r3 = r3.get(r4)
            app.zophop.models.mTicketing.UserAgencyInfo r3 = (app.zophop.models.mTicketing.UserAgencyInfo) r3
            java.util.Map r3 = r3.getProofs()
            java.util.Iterator r4 = r5.iterator()
        L_0x003a:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0059
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            boolean r0 = r3.containsKey(r5)
            if (r0 == 0) goto L_0x0058
            java.lang.Object r5 = r3.get(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x003a
        L_0x0058:
            return r2
        L_0x0059:
            return r1
        L_0x005a:
            return r2
        L_0x005b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ui1.e(app.zophop.models.mTicketing.UserProfile, app.zophop.models.Agency, java.lang.String):boolean");
    }

    public static boolean e0() {
        xt.t1 t1Var = xt.f3961a;
        City d2 = t1Var.k().d();
        String name = d2 != null ? d2.getName() : null;
        if (name == null) {
            return false;
        }
        String lowerCase = name.toLowerCase();
        Set<String> set = b;
        if (set == null) {
            b = new HashSet();
            ut.a aVar = ut.f3552a;
            String f = t1Var.t().f("cityListForStopBasedTripPlannerProd");
            if (TextUtils.isEmpty(f)) {
                return false;
            }
            try {
                JSONArray jSONArray = new JSONArray(f);
                for (int i = 0; i < jSONArray.length(); i++) {
                    b.add(jSONArray.getString(i));
                }
            } catch (Exception e2) {
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
            if (b.contains(lowerCase)) {
                return true;
            }
            return false;
        } else if (set.contains(lowerCase)) {
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean f(java.util.List<app.zophop.models.mTicketing.ProofViewInfo> r2) {
        /*
            java.util.Iterator r2 = r2.iterator()
        L_0x0004:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x001e
            java.lang.Object r0 = r2.next()
            app.zophop.models.mTicketing.ProofViewInfo r0 = (app.zophop.models.mTicketing.ProofViewInfo) r0
            java.lang.String r1 = r0.getUrl()
            if (r1 == 0) goto L_0x001c
            android.graphics.Bitmap r0 = r0.getImage()
            if (r0 != 0) goto L_0x0004
        L_0x001c:
            r2 = 0
            return r2
        L_0x001e:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ui1.f(java.util.List):boolean");
    }

    public static boolean f0(Route route) {
        return (route == null || route.getTtStatus() == 1) ? false : true;
    }

    public static void g(Context context, String str) {
        Locale locale = new Locale(str);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Configuration configuration = context.getResources().getConfiguration();
        configuration.locale = locale;
        context.getResources().updateConfiguration(configuration, displayMetrics);
    }

    public static boolean g0(TripSummary tripSummary) {
        return (tripSummary == null || tripSummary.getTtStatus() == 1) ? false : true;
    }

    public static int h(TripSummary tripSummary, TripSummary tripSummary2) {
        int v;
        int v2;
        if (g0(tripSummary) && !g0(tripSummary2)) {
            return -1;
        }
        if (!g0(tripSummary) && g0(tripSummary2)) {
            return 1;
        }
        if (S(tripSummary) && !S(tripSummary2)) {
            return 1;
        }
        if (!S(tripSummary) && S(tripSummary2)) {
            return -1;
        }
        if (!tripSummary.isFrequencyTrip() && !tripSummary2.isFrequencyTrip()) {
            v = tripSummary.getArrivalTime();
            v2 = tripSummary2.getArrivalTime();
        } else if (tripSummary.isFrequencyTrip() && tripSummary2.isFrequencyTrip()) {
            v = v(tripSummary);
            v2 = v(tripSummary2);
        } else if (tripSummary.isFrequencyTrip()) {
            return -1;
        } else {
            return 1;
        }
        return v - v2;
    }

    public static void h0(String str) {
        ni1 B = B();
        Objects.requireNonNull(B);
        n86.e(str, AnalyticsConstants.KEY);
        if (!TextUtils.isEmpty(str)) {
            B.c.put(str, String.valueOf(B.a(B.b)));
        }
        B.b = System.currentTimeMillis();
    }

    public static long i(int i) {
        return ((long) i) * 24 * 60 * 60 * 1000;
    }

    public static String i0(String str, Map<String, String> map) {
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(str);
        for (String str2 : map.keySet()) {
            builder.appendQueryParameter(str2, map.get(str2));
        }
        return builder.build().toString();
    }

    public static String j(String str) {
        int parseInt = Integer.parseInt(str);
        if (str.equalsIgnoreCase("1")) {
            return "1 Day";
        }
        return parseInt + " Days";
    }

    public static String j0() {
        xt.t1 t1Var = xt.f3961a;
        String f = t1Var.t().f("showPassExtensionDialog");
        if (f == null) {
            return null;
        }
        String C = hj1.C(t1Var);
        try {
            JSONObject jSONObject = new JSONObject(f);
            if (jSONObject.has("cityNamesForPassExtension")) {
                return jSONObject.getJSONObject("cityNamesForPassExtension").optString(C + AnalyticsConstants.CARD, null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    public static void k(Context context, String str) throws Exception {
        String[] split = str.split("\\.");
        new String(Base64.decode(split[1], 8), StandardCharsets.UTF_8);
        JSONObject jSONObject = new JSONObject(new String(Base64.decode(split[1], 8), StandardCharsets.UTF_8));
        String string = jSONObject.getString("exp");
        String string2 = jSONObject.getString("iat");
        Long valueOf = Long.valueOf(System.currentTimeMillis() / 1000);
        SharedPreferences.Editor edit = context.getSharedPreferences("accessToken", 0).edit();
        edit.putLong(SuperPassJsonKeys.EXPIRY_TIME, Long.valueOf(string).longValue());
        edit.commit();
        edit.putLong("delta", Long.valueOf(string2).longValue() - valueOf.longValue());
        edit.commit();
    }

    public static void k0(Context context, RouteWithoutTimings routeWithoutTimings, Stop stop, Stop stop2) {
        Intent intent = new Intent(context, LocationTrackingService.class);
        Object obj = q5.f2896a;
        if (Build.VERSION.SDK_INT >= 26) {
            q5.f.a(context, intent);
        } else {
            context.startService(intent);
        }
        Intent intent2 = new Intent(context, HomeActivity.class);
        intent2.addFlags(67108864);
        context.startActivity(intent2);
        CheckedinEvent checkedinEvent = new CheckedinEvent();
        checkedinEvent.state = CheckedinEvent.STATE.WAITING;
        jz5.b().i(checkedinEvent);
        jz5.b().i(new LocationTrackingEvent(LocationTrackingEvent.ACTION.START, routeWithoutTimings, stop, stop2));
        ed1 ed1 = new ed1("checkin done clicked", Long.MIN_VALUE);
        ed1.a(FirebaseAnalytics.Param.ORIGIN, stop.getName());
        ed1.a(FirebaseAnalytics.Param.DESTINATION, stop2.getName());
        ed1.a("route", routeWithoutTimings.getRouteName());
        ed1.a("mode", routeWithoutTimings.getMode().name());
        jz5.b().g(ed1);
        t0("checkInCompleted");
    }

    public static String l(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt % 100 == 0) {
            StringBuilder i0 = hj1.i0("Pay ");
            i0.append(H());
            i0.append(parseInt / 100);
            return i0.toString();
        }
        StringBuilder i02 = hj1.i0("Pay ");
        i02.append(H());
        i02.append(((double) parseInt) / 100.0d);
        return i02.toString();
    }

    public static void l0(zz zzVar) {
        jz5.b().g(zzVar);
    }

    public static double m(LatLng latLng, LatLng latLng2) {
        Location location = new Location("");
        location.setLatitude(latLng.latitude);
        location.setLongitude(latLng.longitude);
        Location location2 = new Location("");
        location2.setLatitude(latLng2.latitude);
        location2.setLongitude(latLng2.longitude);
        return (double) location.distanceTo(location2);
    }

    public static void m0(ed1 ed1) {
        ed1.a("chaloTimestamp", Long.valueOf(Q()));
        jz5.b().g(ed1);
    }

    public static float n(float f, Context context) {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f;
    }

    public static void n0(String str, String str2) {
        ed1 l = hj1.l("city change prompt open", Long.MIN_VALUE, "inCity", str);
        hj1.K0(l, "source", str2, l);
    }

    public static String o(String str) {
        int indexOf = str.toLowerCase().indexOf(" via ");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    public static void o0(String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, boolean z2) {
        ed1 l = hj1.l("route details checked", Long.MIN_VALUE, "mode", str4);
        l.a("liveAvailable", String.valueOf(z));
        l.a("routeName", str);
        l.a("source", str5);
        l.a(DigitalTripReceiptJsonKeys.KEY_START_STOP, str2);
        l.a(DigitalTripReceiptJsonKeys.KEY_END_STOP, str3);
        l.a("isTimetableAvailable", String.valueOf(z2));
        if (str6 != null) {
            l.a("triggerStop", str6);
        }
        hj1.K0(l, "agency", str7, l);
    }

    public static String p(String str) {
        int indexOf;
        if (str != null && (indexOf = str.toLowerCase().indexOf(" via ") + 1) > 0) {
            return str.substring(indexOf);
        }
        return null;
    }

    public static void p0(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, String str8) {
        ed1 l = hj1.l("stop eta seen", Long.MIN_VALUE, "mode", str2);
        l.a("stop", str3);
        l.a("routeName", str);
        l.a("liveFeed", String.valueOf(z));
        l.a("screenName", str4);
        if (str5 != null) {
            l.a("status", str5);
        }
        if (str8 != null) {
            l.a("vehicle number - stop eta", str8);
        }
        if (str6 != null) {
            long currentTimeMillis = System.currentTimeMillis();
            l.a("vehicle number - last seen", str7);
            l.a("gps time", str6);
            l.a("current time", String.valueOf(currentTimeMillis));
            l.a("delay", Long.valueOf((currentTimeMillis - Long.valueOf(str6).longValue()) / 1000));
        }
        StringBuilder i0 = hj1.i0("");
        i0.append(jh1.j(System.currentTimeMillis()));
        l.a("hourOfEvent", i0.toString());
        jz5.b().g(l);
    }

    public static String q(double d2) {
        if (d2 <= 1.0d) {
            return hj1.X(new StringBuilder(), (int) (d2 * 1000.0d), " mts");
        }
        return new DecimalFormat("##.0").format(d2) + " km";
    }

    public static void q0(String str, String str2, String str3, int i) {
        ed1 l = hj1.l("Eta Seen", Long.MIN_VALUE, "source", str);
        l.a("stopId", str3);
        l.a("stopName", str2);
        l.a("etaCount", Integer.valueOf(i));
        jz5.b().g(l);
    }

    public static boolean r(mf1 mf1) {
        if (mf1.f2368a != null) {
            return true;
        }
        xt.f3961a.B().e(new md1(mf1.c, mf1.d));
        return false;
    }

    public static void r0(String str, String str2, String str3) {
        if (str.length() > 20) {
            str = str.substring(0, 20);
        }
        ed1 ed1 = new ed1(hj1.S(str, " screen displayed"), Long.MAX_VALUE);
        hj1.p(ed1, "mode", str3, "source", str2).g(ed1);
    }

    public static String s(City city) {
        Map<TransitMode, List<Agency>> modeAgencyMap = city.getModeAgencyMap();
        HashMap hashMap = new HashMap();
        if (modeAgencyMap == null) {
            return null;
        }
        for (Agency agency : modeAgencyMap.get(TransitMode.bus)) {
            if (agency.isProductAvailable() || agency.isScanPayAvailable()) {
                hashMap.put(Integer.valueOf(agency.getPriority()), agency);
            }
        }
        if (hashMap.size() > 0) {
            return ((Agency) hashMap.get(0)).getAgencyName();
        }
        return null;
    }

    public static void s0(String str, String str2, String str3) {
        ed1 l = hj1.l("stop eta seen - multiple routes", 3600000, "stopName", str);
        l.a("source", str2);
        l.a("routeName", str3);
        l.a("hourOfEvent", "" + jh1.j(System.currentTimeMillis()));
        jz5.b().g(l);
    }

    public static List<String> t(City city) {
        Map<TransitMode, List<Agency>> modeAgencyMap = city.getModeAgencyMap();
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        if (modeAgencyMap != null) {
            for (Agency agency : modeAgencyMap.get(TransitMode.bus)) {
                if (agency.isProductAvailable()) {
                    hashMap.put(Integer.valueOf(agency.getPriority()), agency);
                    arrayList.add(agency.getAgencyName());
                }
            }
        }
        return arrayList;
    }

    public static void t0(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, String.valueOf(true));
        xt.t1 t1Var = xt.f3961a;
        t1Var.a().a(hashMap);
        t1Var.a().b(hashMap);
    }

    public static int u(String str) {
        if (str.equalsIgnoreCase("OLA")) {
            return R.drawable.ic_ola;
        }
        if (!str.equalsIgnoreCase("UBER") && str.equalsIgnoreCase("JUGNOO")) {
            return R.drawable.ic_jugnoo;
        }
        return R.drawable.ic_uber;
    }

    public static void u0(String str, int i, Context context, TextView textView) {
        SpannableStringBuilder f = hj1.f(str);
        f.setSpan(vn.N(context, wg1.NOTOSANS_MEDIUM), 0, f.length(), 17);
        f.setSpan(new AbsoluteSizeSpan(16, true), 0, f.length(), 17);
        f.setSpan(new ForegroundColorSpan(context.getResources().getColor(i)), 0, f.length(), 17);
        textView.setText(f);
    }

    public static int v(TripSummary tripSummary) {
        int N = N();
        for (Pair<TimeInterval, Integer> pair : tripSummary.getFrequencyList()) {
            if (((TimeInterval) pair.first).containsTime(N)) {
                return ((Integer) pair.second).intValue();
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void v0(UserProfile userProfile, Agency agency, String str, Context context, TextView textView) {
        UserAgencyInfo userAgencyInfo = userProfile.getAgencyInfo().get(agency.getAgencyName());
        if (userAgencyInfo == null || userAgencyInfo.getStatus() == null) {
            u0(context.getString(R.string.student_detials_not_entered), R.color.profile_unverified, context, textView);
        } else if (!d(userProfile, agency, str) || !e(userProfile, agency, str)) {
            u0(context.getString(R.string.student_detials_not_entered), R.color.profile_unverified, context, textView);
        } else {
            int ordinal = userProfile.getAgencyInfo().get(agency.getAgencyName()).getStatus().ordinal();
            if (ordinal == 0) {
                u0(context.getString(R.string.student_pass_verified), R.color.profile_verified, context, textView);
            } else if (ordinal == 1) {
                u0(context.getString(R.string.student_pass_unverified), R.color.profile_unverified, context, textView);
            } else if (ordinal == 2) {
                u0(context.getString(R.string.student_pass_rejected), R.color.profile_rejected, context, textView);
            }
        }
    }

    public static String w(String str) {
        String str2;
        if (str == null) {
            return "";
        }
        try {
            String substring = str.substring(0, 2);
            switch (Integer.parseInt(str.substring(3, 5))) {
                case 1:
                    str2 = "Jan";
                    break;
                case 2:
                    str2 = "Feb";
                    break;
                case 3:
                    str2 = "Mar";
                    break;
                case 4:
                    str2 = "Apr";
                    break;
                case 5:
                    str2 = "May";
                    break;
                case 6:
                    str2 = "Jun";
                    break;
                case 7:
                    str2 = "Jul";
                    break;
                case 8:
                    str2 = "Aug";
                    break;
                case 9:
                    str2 = "Sep";
                    break;
                case 10:
                    str2 = "Oct";
                    break;
                case 11:
                    str2 = "Nov";
                    break;
                case 12:
                    str2 = "Dec";
                    break;
                default:
                    str2 = null;
                    break;
            }
            String substring2 = str.substring(6);
            return substring + " " + str2 + " " + substring2;
        } catch (Exception e2) {
            b00 b00 = b00.f358a;
            b00.a().b(e2);
            return "";
        }
    }

    public static void w0(Context context, TextView textView, String str, int i) {
        textView.setTextColor(context.getResources().getColor(i));
        textView.setText(str);
        textView.setVisibility(8);
    }

    public static int x(String str) {
        try {
            JSONObject jSONObject = new JSONObject(xt.f3961a.t().f("delayThreshold"));
            if (jSONObject.has("threshold")) {
                return jSONObject.getJSONObject("threshold").optInt(str.toLowerCase(), 2);
            }
            return 2;
        } catch (Exception unused) {
            return 2;
        }
    }

    public static void x0(Context context, TextView textView, String str, List<SPECIAL_FEATURE> list, List<String> list2) {
        if (textView != null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) new SpannableString(str));
            if (list != null) {
                if (list.contains(SPECIAL_FEATURE.AC)) {
                    d71.b(context, spannableStringBuilder, "AC", true, R.color.real_time_fetching_string_color, str.length(), R.color.white);
                } else if (list.contains(SPECIAL_FEATURE.FAST)) {
                    d71.b(context, spannableStringBuilder, "FAST", true, R.color.real_time_fetching_string_color, str.length(), R.color.white);
                }
            }
            int i = 0;
            while (list2 != null && i < list2.size()) {
                d71.b(context, spannableStringBuilder, list2.get(i), true, R.color.spf, str.length(), R.color.black_87);
                i++;
            }
            textView.setText(spannableStringBuilder);
        }
    }

    public static Pair<String, String> y(String str) {
        if (str == null) {
            return new Pair<>("", "");
        }
        String[] split = str.split(" ");
        StringBuilder sb = new StringBuilder();
        if (split == null || split.length == 0) {
            return new Pair<>("", "");
        }
        if (split.length == 1) {
            return new Pair<>(split[0], "");
        }
        for (int i = 0; i < split.length - 1; i++) {
            sb.append(split[i]);
            if (i == split.length - 2) {
                break;
            }
            sb.append(" ");
        }
        return new Pair<>(sb.toString(), split[split.length - 1]);
    }

    public static void y0(TextView textView, double d2, int i) {
        String str;
        double d3 = (d2 * 1000.0d) / 1.1111111111111112d;
        textView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (d3 < 60.0d) {
            str = jh1.k(DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
        } else if (d3 < 900.0d) {
            str = jh1.k((long) (d3 * 1000.0d));
        } else {
            str = q(d2);
            textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        textView.setText(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<app.zophop.models.TimeInterval, java.lang.Integer> z(int r3, java.util.List<android.util.Pair<app.zophop.models.TimeInterval, java.lang.Integer>> r4) {
        /*
            java.util.Iterator r4 = r4.iterator()
        L_0x0004:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0026
            java.lang.Object r0 = r4.next()
            android.util.Pair r0 = (android.util.Pair) r0
            java.lang.Object r1 = r0.first
            app.zophop.models.TimeInterval r1 = (app.zophop.models.TimeInterval) r1
            boolean r2 = r1.containsTime(r3)
            if (r2 == 0) goto L_0x001b
            return r0
        L_0x001b:
            java.lang.Object r1 = r1.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r1 <= r3) goto L_0x0004
            return r0
        L_0x0026:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ui1.z(int, java.util.List):android.util.Pair");
    }

    public static void z0(Context context, String str) {
        sf1 sf1 = new sf1(context.getSharedPreferences(str, 0), AnalyticsConstants.PREFERENCES);
        sf1.put("pref_ac", String.valueOf(true));
        sf1.put("pref_non_ac", String.valueOf(true));
        String str2 = "1000";
        sf1.put("pref_walk_dist", Y() ? "400" : str2);
        if (!Y()) {
            str2 = "3000";
        }
        sf1.put("pre_auto_dist", str2);
    }
}
