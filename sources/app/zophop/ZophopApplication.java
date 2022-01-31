package app.zophop;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.CursorWindow;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import app.zophop.models.City;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.pubsub.eventbus.events.ApplicationReady;
import app.zophop.pubsub.eventbus.events.StopsLoaded;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatConfig;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.UAirship;
import defpackage.m66;
import defpackage.ut;
import defpackage.xt;
import java.io.File;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import kotlinx.coroutines.CoroutineExceptionHandler;
import server.zophop.CS;
import server.zophop.Constants;

/* compiled from: ZophopApplication.kt */
public final class ZophopApplication extends Application implements mb6 {
    public static final /* synthetic */ int g = 0;
    public boolean f;

    public void attachBaseContext(Context context) {
        ApplicationInfo applicationInfo;
        n86.e(context, AnalyticsConstants.CONTEXT);
        super.attachBaseContext(context);
        if (!oi.b) {
            try {
                applicationInfo = getApplicationInfo();
            } catch (RuntimeException unused) {
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                try {
                    oi.c(this, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
                } catch (Exception e) {
                    StringBuilder i0 = hj1.i0("MultiDex installation failed (");
                    i0.append(e.getMessage());
                    i0.append(").");
                    throw new RuntimeException(i0.toString());
                }
            }
        }
    }

    @Override // defpackage.mb6
    public m66 n() {
        m66 d = m66.a.C0044a.d(new uc6(null), xb6.c);
        int i = CoroutineExceptionHandler.d;
        return d.plus(new lh1(CoroutineExceptionHandler.a.f));
    }

    public void onCreate() {
        UserProfile e;
        City d;
        String name;
        String optString;
        ni1 B = ui1.B();
        Objects.requireNonNull(B);
        long currentTimeMillis = System.currentTimeMillis();
        B.f2559a = currentTimeMillis;
        B.b = currentTimeMillis;
        super.onCreate();
        ui1.h0("");
        this.f = false;
        jz5 b = jz5.b();
        b.k(this, b.e, false, 0);
        xt.t1 t1Var = xt.f3961a;
        n86.e(this, "_context");
        n86.e(this, "<set-?>");
        xt.b = this;
        Context m = t1Var.m();
        if (ut.f3552a.equals(ut.a.PRODUCTION)) {
            ut.b = "https://production.zophop.com/scheduler_v4/v7/metadataprops/";
            ut.c = "https://production.zophop.com/scheduler_v4/v4/";
            ut.d = "https://production.zophop.com/scheduler_v4/v4/";
            ut.n = "https://production.zophop.com/scheduler_v4/v4/liveFeed/";
            ut.e = "b1925cf6c0b3db7d5f3904a66abf8ec7";
            ut.g = CS.ENVIRONMENT.production;
            ut.h = "production/cityData";
            ut.i = "https://production.zophop.com/mticketing/";
            ut.j = "https://production.zophop.com/payments/wallet/yb/";
            ut.A = false;
            ut.o = "http://api.zophop.com";
            ut.B = Constants.PRODUCTION_EXCHANGE;
            ut.D = "https://cash.zophop.com/";
            ut.u = "https://production.zophop.com/chaukidar/v1/login";
            ut.v = "https://production.zophop.com/chaukidar/v1/logout";
            ut.w = "https://production.zophop.com/chaukidar/v1/generate/uid";
            ut.x = "https://production.zophop.com/chaukidar/v1/refreshTokens";
            ut.l = "https://production.zophop.com/configuration/";
            ut.m = "https://production.zophop.com/";
            ut.k = "https://production.zophop.com/files/v1/upload/";
            ut.F = "reportProblemDataProd";
            ut.G = "https://production.zophop.com/seat/availability";
            ut.y = "https://geoquery.zophop.com/";
            ut.z = "https://production.zophop.com/mticketing/v1/paylater/initiate";
            ut.q = "https://production.zophop.com/vasudha/";
            ut.H = "https://production.zophop.com/configuration/crts/live/v1/cities/";
            ut.I = "https://production.zophop.com/configuration/citydata/v2/cities/";
        } else if (ut.f3552a.equals(ut.a.DEVELOPMENT)) {
            ut.b = "https://dev.zophop.com/scheduler_v4/v7/metadataprops/";
            ut.c = "https://dev.zophop.com/scheduler_v4/v4/";
            ut.d = "https://dev.zophop.com/scheduler_v4/v4/";
            ut.e = "f0848e2e93b9a21ab8c6a8c9ae1b5698";
            ut.n = "https://dev.zophop.com:8080/scheduler_v4/v4/liveFeed/";
            ut.g = CS.ENVIRONMENT.development;
            ut.h = "development/cityData";
            ut.i = "https://dev.zophop.com/mticketing/";
            ut.j = "https://dev.zophop.com/payments/wallet/yb/";
            ut.B = Constants.DEVELOPMENT_EXCHANGE;
            ut.A = true;
            ut.o = "http://api.zophop.com";
            ut.D = "https://devcash.zophop.com/";
            ut.u = "https://dev.zophop.com/chaukidar/v2/login";
            ut.v = "https://dev.zophop.com/chaukidar/v1/logout";
            ut.w = "https://dev.zophop.com/chaukidar/v1/generate/uid";
            ut.x = "https://dev.zophop.com/chaukidar/v1/refreshTokens";
            ut.l = "https://dev.zophop.com/configuration/";
            ut.m = "https://dev.zophop.com/";
            ut.k = "https://dev.zophop.com/files/v1/upload";
            ut.F = "reportProblemDataDebug";
            ut.G = "https://dev.zophop.com/seat/availability";
            ut.y = "https://devgeoquery.zophop.com/";
            ut.z = "https://dev.zophop.com/mticketing/v1/paylater/initiate";
            ut.q = "https://production.zophop.com/vasudha/";
            ut.H = "https://dev.zophop.com/configuration/crts/live/v1/cities/";
            ut.I = "https://dev.zophop.com/configuration/citydata/v2/cities/";
        } else if (ut.f3552a.equals(ut.a.STAGING)) {
            ut.b = "https://dev.zophop.com/scheduler_v4/v7/metadataprops/";
            ut.c = "https://dev.zophop.com/scheduler_v4/v4/";
            ut.d = "https://dev.zophop.com/scheduler_v4/v4/";
            ut.e = "81ad84c4db1758af07e8566963c53c89";
            ut.n = "https://dev.zophop.com:8080/scheduler_v4/v4/liveFeed/";
            ut.g = CS.ENVIRONMENT.development;
            ut.h = "development/cityData";
            ut.i = "https://dev.zophop.com/mticketing/";
            ut.j = "https://dev.zophop.com/payments/wallet/yb/";
            ut.B = Constants.DEVELOPMENT_EXCHANGE;
            ut.A = true;
            ut.o = "http://api.zophop.com";
            ut.D = "https://devcash.zophop.com/";
            ut.u = "https://dev.zophop.com/chaukidar/v2/login";
            ut.v = "https://dev.zophop.com/chaukidar/v1/logout";
            ut.w = "https://dev.zophop.com/chaukidar/v1/generate/uid";
            ut.x = "https://dev.zophop.com/chaukidar/v1/refreshTokens";
            ut.l = "https://staging.zophop.com/configuration/";
            ut.k = "https://dev.zophop.com/files/v1/upload";
            ut.F = "reportProblemDataDebug";
            ut.G = "https://dev.zophop.com/seat/availability";
            ut.y = "https://devgeoquery.zophop.com/";
            ut.z = "https://dev.zophop.com/mticketing/v1/paylater/initiate";
            ut.q = "https://production.zophop.com/vasudha/";
            ut.H = "https://staging.zophop.com/configuration/crts/live/v1/cities/";
            ut.I = "https://staging.zophop.com/configuration/citydata/v2/cities/";
        }
        ut.p = "https://dazzling-fire-3689.firebaseio.com/";
        ut.r = "1:245794476053:android:23337f42794bb303";
        ut.s = "https://v2-dot-zophop2013.appspot.com/";
        ut.f = "631286963633";
        ut.t = "https://uberbooking-dot-zophop2013.appspot.com/cabs/";
        ut.C = "AIzaSyBds33QV3snALM4ew9Gg-CLhJu2Be_0_oE";
        ut.E = "https://production.zophop2013.appspot.com";
        if (v50.b == null) {
            v50.b = new v50(m);
        }
        v50 v50 = v50.b;
        if (v50.f3600a.b.getBoolean("url_avl_key", false)) {
            ut.p = v50.f3600a.b.getString("firebase", ut.p);
            ut.r = v50.f3600a.b.getString("firebase_app_id", ut.r);
            ut.s = v50.f3600a.b.getString("cab_base", ut.s);
            ut.f = v50.f3600a.b.getString("gcm_id", ut.f);
            ut.i = v50.f3600a.b.getString("mobileticketing", ut.i);
            ut.B = v50.f3600a.b.getString("exchangeName", ut.B);
            ut.t = v50.f3600a.b.getString("uber_booking", ut.t);
            ut.C = v50.f3600a.b.getString("map_api_key", ut.C);
            ut.E = v50.f3600a.b.getString("live_count_api", ut.E);
        }
        FirebaseCrashlytics.getInstance().setUserId(t1Var.n().a());
        FirebaseAnalytics.getInstance(t1Var.m()).setUserId(t1Var.m0());
        FreshchatConfig freshchatConfig = new FreshchatConfig("18ae4e04-269d-4dc0-85e3-d14022ccdc08", "de78c85f-3a31-4de4-ba6a-f2a2a5d758b9");
        freshchatConfig.setCameraCaptureEnabled(true);
        freshchatConfig.setGallerySelectionEnabled(true);
        freshchatConfig.setTeamMemberInfoVisible(true);
        Freshchat.getInstance(t1Var.m()).init(freshchatConfig);
        FirebaseApp.initializeApp(this);
        List<FirebaseApp> apps = FirebaseApp.getApps(this);
        n86.d(apps, "getApps(_context)");
        if (!apps.isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
        FirebaseDatabase.getInstance().goOffline();
        DatabaseReference.goOffline();
        hd3.Y1((ZophopApplication) t1Var.m(), null, null, new yt(null), 3, null);
        t1Var.t().a((!t1Var.l().h.has("cacheExpiry") || (optString = t1Var.l().h.optString("cacheExpiry", null)) == null) ? 0 : Long.parseLong(optString));
        if (t1Var.k().d() != null) {
            City d2 = t1Var.k().d();
            t1Var.p0(d2 == null ? null : d2.getName());
        } else {
            xt.p = true;
        }
        i30 i30 = new i30(t1Var.m().getApplicationContext(), t1Var.S());
        n86.e(i30, "<set-?>");
        xt.u0 = i30;
        t1Var.q0();
        if (!(!UAirship.u || (d = t1Var.k().d()) == null || (name = d.getName()) == null)) {
            String lowerCase = name.toLowerCase();
            n86.d(lowerCase, "(this as java.lang.String).toLowerCase()");
            op5 k = UAirship.l().j.k();
            k.d("selectedCityName", lowerCase);
            k.d("selectedLanguage", t1Var.z().a());
            k.d(RemoteConfigConstants.RequestFieldKey.APP_VERSION, "764");
            k.a();
        }
        if (UAirship.u && (e = t1Var.L().e()) != null) {
            op5 k2 = UAirship.l().j.k();
            k2.d(SuperPassJsonKeys.FIRST_NAME, e.getFirstName());
            k2.d(SuperPassJsonKeys.LAST_NAME, e.getLastName());
            k2.d("email", e.getEmailId());
            k2.d("phoneNo", e.getPhone());
            k2.a();
        }
        UAirship.l().s.e(255);
        this.f = true;
        ui1.h0("zophop application init time");
        if (ut.f3552a == ut.a.DEVELOPMENT) {
            Toast.makeText(this, ut.f3552a.name(), 1).show();
        }
        try {
            Field declaredField = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            declaredField.setAccessible(true);
            declaredField.set(null, 104857600);
        } catch (Exception unused) {
        }
    }

    public final void onEvent(StopsLoaded stopsLoaded) {
        n86.e(stopsLoaded, "stopsLoaded");
        n86.j("event received in application ", Boolean.valueOf(stopsLoaded.isSuccess()));
        this.f = stopsLoaded.isSuccess();
        jz5.b().g(new ApplicationReady(this.f));
    }

    public final void onEventMainThread(pz5 pz5) {
        n86.e(pz5, "exceptionEvent");
        new Handler(Looper.getMainLooper()).post(new tt(pz5));
    }
}
