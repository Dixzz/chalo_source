package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.BasicProfileFields;
import app.zophop.models.mTicketing.BasicUserProfile;
import app.zophop.models.mTicketing.BookingPassType;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProfileRequestAgencyInfo;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.models.mTicketing.UserAgencyInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassPaymentConstants;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.exception.MethodNotAllowedException;
import com.google.firebase.auth.FirebaseAuth;
import com.rabbitmq.client.ConnectionFactory;
import com.razorpay.AnalyticsConstants;
import defpackage.n00;
import defpackage.ut;
import defpackage.xt;
import defpackage.yj1;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import server.zophop.Constants;

/* renamed from: v30  reason: default package */
/* compiled from: ProfileFeature */
public class v30 implements t20 {
    public static final String f = hj1.a0(new StringBuilder(), ut.i, "/v2/user/");

    /* renamed from: a  reason: collision with root package name */
    public final rf1 f3587a;
    public final ov b = new ov();
    public final xj1 c;
    public final Context d;
    public final rf1 e;

    /* renamed from: v30$a */
    /* compiled from: ProfileFeature */
    public class a implements yj1.b<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f3588a;
        public final /* synthetic */ UserProfileEvent.TYPE b;
        public final /* synthetic */ boolean c;

        public a(boolean z, UserProfileEvent.TYPE type, boolean z2) {
            this.f3588a = z;
            this.b = type;
            this.c = z2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(String str) {
            String str2 = str;
            xt.t1 t1Var = xt.f3961a;
            xt.z0 = 0;
            try {
                JSONObject jSONObject = new JSONObject(str2);
                if (jSONObject.getString("status").equals("true")) {
                    v30 v30 = v30.this;
                    String str3 = v30.f;
                    Objects.requireNonNull(v30);
                    try {
                        jSONObject.getLong(SuperPassJsonKeys.VERIFICATION_EXPIRY_TIME);
                        jSONObject.getInt(SuperPassJsonKeys.NUM_OF_DAYS);
                        jSONObject.getLong(SuperPassJsonKeys.PASS_START_DATE);
                        jSONObject.getString("passengerType");
                        jSONObject.getString("agency");
                        jSONObject.getInt(SuperPassJsonKeys.FARE);
                    } catch (JSONException unused) {
                    }
                    if (jSONObject.has(SuperPassJsonKeys.USER_PROFILE)) {
                        Objects.requireNonNull(v30.this);
                        xt.t1 t1Var2 = xt.f3961a;
                        t1Var2.l().remove("first_name");
                        t1Var2.l().remove("last_name");
                        t1Var2.l().remove("email_id");
                        ov ovVar = v30.this.b;
                        UserProfile H = ov.H(jSONObject.getString(SuperPassJsonKeys.USER_PROFILE));
                        if (H != null && !TextUtils.isEmpty(H.getUserId())) {
                            t1Var2.l().put("user_id", H.getUserId());
                        }
                        v30.this.n(H);
                        if (!this.f3588a) {
                            v30 v302 = v30.this;
                            UserProfileEvent.TYPE type = this.b;
                            Objects.requireNonNull(v302);
                            if (type.equals(UserProfileEvent.TYPE.REGISTRATION)) {
                                v302.x("user registered", H);
                            } else if (type.equals(UserProfileEvent.TYPE.PROFILE_FETCH)) {
                                v302.x("user logged in", H);
                            } else if (type.equals(UserProfileEvent.TYPE.PROFILE_UPDATE)) {
                                v302.x("user updated profile", H);
                            }
                        }
                        v30.this.s(H);
                        v30.this.d(this.b);
                        if (this.f3588a) {
                            jz5.b().g(new UserProfileEvent(ad1.SUCCESS, this.b));
                        } else {
                            jz5.b().i(new UserProfileEvent(ad1.SUCCESS, this.b));
                        }
                    } else {
                        v30.this.A("no userProfile in response");
                        jz5.b().i(new UserProfileEvent(ad1.FAILED, this.b, UserProfileEvent.RESPONSE_CODE.USER_NOT_FOUND));
                    }
                } else {
                    t1Var.l().h.optString("user_id", null);
                    String optString = t1Var.l().h.optString("first_name", null);
                    String optString2 = t1Var.l().h.optString("last_name", null);
                    String optString3 = t1Var.l().h.optString("email_id", null);
                    String optString4 = t1Var.l().h.optString("phone_no", null);
                    String optString5 = jSONObject.optString("message");
                    if ("AUTHENTICATION_ERROR".equals(optString5)) {
                        v30 v303 = v30.this;
                        String str4 = v30.f;
                        v303.A("authentication error");
                        v30.u(v30.this, optString3, optString, optString2, optString4);
                    }
                    if (!this.c) {
                        v30 v304 = v30.this;
                        String str5 = v30.f;
                        v304.A("not product call");
                        jz5.b().i(new UserProfileEvent(ad1.FAILED, this.b, optString5, UserProfileEvent.RESPONSE_CODE.USER_NOT_FOUND));
                    }
                }
                v30 v305 = v30.this;
                String str6 = v30.f;
                Objects.requireNonNull(v305);
                xt.f3961a.l().put("profile_call_suceeded", String.valueOf(true));
            } catch (JSONException e) {
                String str7 = v30.f;
                v30.this.A("jsonException = " + e);
                e.printStackTrace();
                v30.this.w();
                jz5.b().i(new UserProfileEvent(ad1.FAILED, this.b, UserProfileEvent.RESPONSE_CODE.JSON_EXCEPTION));
            }
        }
    }

    /* renamed from: v30$b */
    /* compiled from: ProfileFeature */
    public class b implements n00.y0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ProfileRequestInfo f3589a;
        public final /* synthetic */ UserProfileEvent.TYPE b;

        public b(ProfileRequestInfo profileRequestInfo, UserProfileEvent.TYPE type) {
            this.f3589a = profileRequestInfo;
            this.b = type;
        }

        @Override // defpackage.n00.y0
        public void a(String str) {
            v30 v30 = v30.this;
            String S = hj1.S(str, " in error handler");
            String str2 = v30.f;
            v30.A(S);
            v30.this.w();
            jz5.b().i(new UserProfileEvent(ad1.FAILED, this.b, str, UserProfileEvent.RESPONSE_CODE.VOLLEY_ERROR));
        }

        @Override // defpackage.n00.y0
        public void execute() {
            v30 v30 = v30.this;
            String str = v30.f;
            v30.A("execute");
            xt.f3961a.L().g(this.f3589a);
        }
    }

    static {
        String str = ut.i;
    }

    public v30(Context context, xj1 xj1) {
        this.f3587a = new rf1(context, "user_info_store");
        this.c = xj1;
        this.d = context;
        this.e = new rf1(context, "accessToken");
        if (m()) {
            xt.f3961a.l().put("profile_call_suceeded", String.valueOf(true));
        } else {
            w();
        }
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public static void u(v30 v30, String str, String str2, String str3, String str4) {
        Objects.requireNonNull(v30);
        ProfileRequestInfo profileRequestInfo = new ProfileRequestInfo(new BasicUserProfile(new BasicProfileFields.Builder().withEmailId(str).withFirstName(str2).withLastName(str3).withPhone(str4).build()));
        xt.t1 t1Var = xt.f3961a;
        t1Var.l().put("user_id", str4);
        t1Var.L().k(profileRequestInfo);
    }

    public final void A(String str) {
        ed1 l = hj1.l("login log event", Long.MIN_VALUE, "remarks", str);
        l.a("source", "profileFeature");
        ui1.m0(l);
    }

    public final void B(jf1 jf1, String str) {
        Notification notification;
        Notification notification2;
        int i = Build.VERSION.SDK_INT;
        Notification notification3 = null;
        if (str.equals("VERIFIED")) {
            if (jf1.d != null) {
                try {
                    if ("superSaver".equals(new JSONObject(jf1.d).optString("productType", null))) {
                        notification2 = vn.x0(this.d, jf1.f1916a, jf1.b, null, "myChannel");
                    } else {
                        notification2 = vn.c0(this.d, jf1, false, "myChannel");
                    }
                    notification3 = notification2;
                } catch (JSONException e2) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e2);
                }
            }
            NotificationManager notificationManager = (NotificationManager) this.d.getSystemService("notification");
            if (i >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("myChannel", "NewGroup", 4);
                int i2 = jc5.b(this.d).w;
                if (i2 == 2 || i2 == -1) {
                    notificationChannel.enableVibration(true);
                }
                if (i2 == 4 || i2 == -1) {
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(-1);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            if (notification3 != null) {
                notificationManager.notify(1, notification3);
            }
        } else if (str.equals("REJECTED")) {
            if (jf1.d != null) {
                try {
                    if ("superSaver".equals(new JSONObject(jf1.d).optString("productType", null))) {
                        notification = vn.x0(this.d, jf1.f1916a, jf1.b, null, "myChannel");
                    } else {
                        notification = vn.c0(this.d, jf1, true, "myChannel");
                    }
                    notification3 = notification;
                } catch (JSONException e3) {
                    b00 b002 = b00.f358a;
                    b00.a().b(e3);
                }
            }
            NotificationManager notificationManager2 = (NotificationManager) this.d.getSystemService("notification");
            if (i >= 26) {
                int i3 = jc5.b(this.d).A;
                NotificationChannel notificationChannel2 = new NotificationChannel("myChannel", "NewGroup", 4);
                int i4 = jc5.b(this.d).w;
                if (i4 == 2 || i4 == -1) {
                    notificationChannel2.enableVibration(true);
                }
                if (i4 == 4 || i4 == -1) {
                    notificationChannel2.enableLights(true);
                    notificationChannel2.setLightColor(-1);
                }
                notificationManager2.createNotificationChannel(notificationChannel2);
            }
            if (notification3 != null) {
                notificationManager2.notify(2, notification3);
            }
        }
    }

    @Override // defpackage.t20
    public String a() {
        SharedPreferences sharedPreferences = this.d.getSharedPreferences("accessToken", 0);
        sharedPreferences.edit();
        return sharedPreferences.getString("refreshToken", null);
    }

    @Override // defpackage.t20
    public void b(ProfileRequestInfo profileRequestInfo) {
        String str;
        String a0 = hj1.a0(new StringBuilder(), f, "updateUserProfile");
        if (profileRequestInfo != null) {
            try {
                JSONObject y = y(profileRequestInfo.getProfile().getFields());
                if (profileRequestInfo.getProfile().hasProfilePicUrl()) {
                    y.put(SuperPassJsonKeys.PROFILE_PHOTO, profileRequestInfo.getProfile().getProfileUrl(this.d));
                }
                y.put("userId", getUserId());
                y.put(AnalyticsConstants.TOKEN, j());
                y.put("userId", getUserId());
                ut.a aVar = ut.f3552a;
                y.put("appVer", 764);
                if (profileRequestInfo.getMagicPass() != null) {
                    y.put(SuperPassJsonKeys.PASS_FARE, profileRequestInfo.getMagicPass().getFare());
                    y.put(SuperPassJsonKeys.PASS_START_DATE, profileRequestInfo.getMagicPass().getStartingTime());
                    y.put("passType", BookingPassType.MAGIC);
                    y.put(SuperPassJsonKeys.NUM_OF_DAYS, profileRequestInfo.getMagicPass().getNoOfDays());
                    y.put("passengerType", profileRequestInfo.getMagicPass().getPassengerType());
                    if ("superSaver".equals(profileRequestInfo.getMagicPass().get_productType())) {
                        y.put("category", profileRequestInfo.getMagicPass().getPassengerType());
                    }
                    y.put(SuperPassJsonKeys.CONFIGURATION_ID, profileRequestInfo.getMagicPass().getConfigId());
                    new JSONArray();
                    new JSONArray();
                    JSONArray jSONArray = new JSONArray();
                    MPass magicPass = profileRequestInfo.getMagicPass();
                    magicPass.getRouteStopsInfo();
                    List<String> specialFeatures = magicPass.getSpecialFeatures();
                    if (specialFeatures != null) {
                        for (int i = 0; i < specialFeatures.size(); i++) {
                            jSONArray.put(specialFeatures.get(i));
                        }
                    }
                    y.put("specialFeatures", jSONArray);
                }
                if (profileRequestInfo.hasAgencyInfo()) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    ProfileRequestAgencyInfo agencyInfo = profileRequestInfo.getAgencyInfo();
                    jSONObject.put("city", agencyInfo.getCity());
                    jSONObject.put("agency", agencyInfo.getAgency());
                    jSONObject.put("passengerType", agencyInfo.getPassengerType());
                    if (profileRequestInfo.getMagicPass() != null && "superSaver".equals(profileRequestInfo.getMagicPass().get_productType())) {
                        jSONObject.put("category", agencyInfo.getPassengerType());
                    }
                    jSONObject.put(SuperPassJsonKeys.PROOFS, new JSONObject(ov.g(profileRequestInfo.getAgencyInfo().getOriginalProofs())));
                    if (profileRequestInfo.getAgencyInfo().getAgencyFields() != null) {
                        jSONObject.put("addFields", new JSONObject(ov.g(profileRequestInfo.getAgencyInfo().getAgencyFields())));
                    } else {
                        jSONObject.put("addFields", (Object) null);
                    }
                    jSONArray2.put(jSONObject);
                    y.put("agencies", jSONArray2);
                }
                y.toString();
                str = y.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            z(a0, str, UserProfileEvent.TYPE.PROFILE_UPDATE, false, profileRequestInfo, false);
        }
        str = null;
        z(a0, str, UserProfileEvent.TYPE.PROFILE_UPDATE, false, profileRequestInfo, false);
    }

    @Override // defpackage.t20
    public String c(MPass mPass, String str, String str2, String str3, ProfileRequestInfo profileRequestInfo, String str4) {
        try {
            JSONObject y = y(profileRequestInfo.getProfile().getFields());
            y.put("lpVer", "v1");
            ut.a aVar = ut.f3552a;
            y.put("appVer", 764);
            if (profileRequestInfo.getProfile().hasProfilePicUrl()) {
                y.put(SuperPassJsonKeys.PROFILE_PHOTO, profileRequestInfo.getProfile().getProfileUrl(this.d));
            }
            y.put("userId", getUserId());
            y.put(AnalyticsConstants.TOKEN, j());
            y.put("userId", getUserId());
            y.put("id", mPass.getConfigId());
            if (profileRequestInfo.getMagicPass() != null) {
                y.put(SuperPassJsonKeys.PASS_FARE, profileRequestInfo.getMagicPass().getFare());
                y.put(SuperPassJsonKeys.PASS_START_DATE, profileRequestInfo.getMagicPass().getStartingTime());
                y.put("passType", BookingPassType.MAGIC);
                y.put(SuperPassJsonKeys.NUM_OF_DAYS, profileRequestInfo.getMagicPass().getNoOfDays());
                y.put("passengerType", profileRequestInfo.getMagicPass().getPassengerType());
            }
            if (profileRequestInfo.hasAgencyInfo()) {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                ProfileRequestAgencyInfo agencyInfo = profileRequestInfo.getAgencyInfo();
                jSONObject.put("city", agencyInfo.getCity());
                jSONObject.put("agency", agencyInfo.getAgency());
                jSONObject.put("passengerType", agencyInfo.getPassengerType());
                jSONObject.put(SuperPassJsonKeys.PROOFS, new JSONObject(ov.g(profileRequestInfo.getAgencyInfo().getOriginalProofs())));
                if (profileRequestInfo.getAgencyInfo().getAgencyFields() != null) {
                    jSONObject.put("addFields", new JSONObject(ov.g(profileRequestInfo.getAgencyInfo().getAgencyFields())));
                } else {
                    jSONObject.put("addFields", (Object) null);
                }
                jSONArray.put(jSONObject);
                y.put("agencies", jSONArray);
            }
            y.put("transactionType", "MOBILE_PASS");
            y.put(AnalyticsConstants.TOKEN, str2);
            y.put("city", xt.f3961a.k().d().getName());
            y.put("paymentType", str3);
            y.put("isSubMerchant", true);
            y.put(SuperPassJsonKeys.CONFIGURATION_ID, mPass.getConfigId());
            y.put("passType", mPass.getPassBookingType().name());
            y.put(SuperPassJsonKeys.NUM_OF_DAYS, mPass.getNoOfDays());
            y.put(Constants.START_STOP_NAME, "");
            y.put("startStopId", "");
            y.put(Constants.END_STOP_STOP_NAME, "");
            y.put("endStopId", "");
            y.put("agency", mPass.getAgency());
            y.put("userId", mPass.getUserProfile().getUserId());
            y.put(SuperPassJsonKeys.START_TIME, str);
            y.put("deviceId", mPass.getDeviceId());
            if (mPass.getBookingPassId() != null) {
                y.put("passId", mPass.getBookingPassId());
            }
            JSONArray jSONArray2 = new JSONArray();
            JSONArray jSONArray3 = new JSONArray();
            JSONArray jSONArray4 = new JSONArray();
            RouteStopsInfo routeStopsInfo = mPass.getRouteStopsInfo();
            List<String> specialFeatures = mPass.getSpecialFeatures();
            if (specialFeatures != null) {
                for (int i = 0; i < specialFeatures.size(); i++) {
                    jSONArray4.put(specialFeatures.get(i));
                }
            }
            if (!(str4 == null || routeStopsInfo == null)) {
                jSONArray2.put(str4);
                jSONArray3.put(routeStopsInfo.getRouteName());
                JSONArray jSONArray5 = new JSONArray();
                jSONArray5.put(routeStopsInfo.getStartStopId());
                y.put("startStopIds", jSONArray5);
                JSONArray jSONArray6 = new JSONArray();
                jSONArray6.put(routeStopsInfo.getStartStopName());
                y.put("startStopNames", jSONArray6);
                JSONArray jSONArray7 = new JSONArray();
                jSONArray7.put(routeStopsInfo.getEndStopId());
                y.put("endStopIds", jSONArray7);
                JSONArray jSONArray8 = new JSONArray();
                jSONArray8.put(routeStopsInfo.getEndStopName());
                y.put("endStopNames", jSONArray8);
            }
            y.put("category", mPass.get_grouping().getCategoryId());
            y.put("passengerType", "GENERAL");
            y.put("routeIds", jSONArray2);
            y.put("routeNames", jSONArray3);
            y.put("specialFeatures", jSONArray4);
            y.put("displayProps", new JSONObject().toString());
            return y.toString();
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            hj1.W0(e2);
            return null;
        }
    }

    @Override // defpackage.t20
    public void d(UserProfileEvent.TYPE type) {
        try {
            Freshchat.getInstance(this.d).setUser(Freshchat.getInstance(this.d).identifyUser(xt.f3961a.m0(), null).getUser());
        } catch (MethodNotAllowedException e2) {
            e2.printStackTrace();
        }
    }

    @Override // defpackage.t20
    public UserProfile e() {
        if (this.f3587a.b.contains("user_info")) {
            return ov.H(this.f3587a.b.getString("user_info", null));
        }
        return null;
    }

    @Override // defpackage.t20
    public boolean f() {
        return p() != null;
    }

    @Override // defpackage.t20
    public void g(ProfileRequestInfo profileRequestInfo) {
        String str;
        String a0 = hj1.a0(new StringBuilder(), f, "updateUserProfile");
        if (profileRequestInfo != null) {
            try {
                JSONObject y = y(profileRequestInfo.getProfile().getFields());
                if (profileRequestInfo.getProfile().hasProfilePic()) {
                    y.put(SuperPassJsonKeys.PROFILE_PHOTO, profileRequestInfo.getProfile().getProfileUrl(this.d));
                }
                y.put("userId", getUserId());
                y.put(AnalyticsConstants.TOKEN, j());
                y.put("userId", getUserId());
                ut.a aVar = ut.f3552a;
                y.put("appVer", 764);
                if (profileRequestInfo.getMagicPass() != null) {
                    y.put(SuperPassJsonKeys.PASS_FARE, profileRequestInfo.getMagicPass().getFare());
                    y.put(SuperPassJsonKeys.PASS_START_DATE, profileRequestInfo.getMagicPass().getStartingTime());
                    y.put("passType", BookingPassType.MAGIC);
                    y.put(SuperPassJsonKeys.NUM_OF_DAYS, profileRequestInfo.getMagicPass().getNoOfDays());
                    y.put("passengerType", profileRequestInfo.getMagicPass().getPassengerType());
                    if ("superSaver".equals(profileRequestInfo.getMagicPass().get_productType())) {
                        y.put("category", profileRequestInfo.getMagicPass().getPassengerType());
                    }
                    y.put(SuperPassJsonKeys.CONFIGURATION_ID, profileRequestInfo.getMagicPass().getConfigId());
                    new JSONArray();
                    new JSONArray();
                    JSONArray jSONArray = new JSONArray();
                    MPass magicPass = profileRequestInfo.getMagicPass();
                    magicPass.getRouteStopsInfo();
                    List<String> specialFeatures = magicPass.getSpecialFeatures();
                    if (specialFeatures != null) {
                        for (int i = 0; i < specialFeatures.size(); i++) {
                            jSONArray.put(specialFeatures.get(i));
                        }
                    }
                    y.put("specialFeatures", jSONArray);
                }
                if (profileRequestInfo.hasAgencyInfo()) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    ProfileRequestAgencyInfo agencyInfo = profileRequestInfo.getAgencyInfo();
                    jSONObject.put("city", agencyInfo.getCity());
                    jSONObject.put("agency", agencyInfo.getAgency());
                    jSONObject.put("passengerType", agencyInfo.getPassengerType());
                    if (profileRequestInfo.getMagicPass() != null && "superSaver".equals(profileRequestInfo.getMagicPass().get_productType())) {
                        jSONObject.put("category", agencyInfo.getPassengerType());
                    }
                    jSONObject.put(SuperPassJsonKeys.PROOFS, new JSONObject(ov.g(profileRequestInfo.getAgencyInfo().getOriginalProofs())));
                    if (profileRequestInfo.getAgencyInfo().getAgencyFields() != null) {
                        jSONObject.put("addFields", new JSONObject(ov.g(profileRequestInfo.getAgencyInfo().getAgencyFields())));
                    } else {
                        jSONObject.put("addFields", (Object) null);
                    }
                    jSONArray2.put(jSONObject);
                    y.put("agencies", jSONArray2);
                }
                y.toString();
                str = y.toString();
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            z(a0, str, UserProfileEvent.TYPE.PROFILE_UPDATE, false, profileRequestInfo, false);
        }
        str = null;
        z(a0, str, UserProfileEvent.TYPE.PROFILE_UPDATE, false, profileRequestInfo, false);
    }

    @Override // defpackage.t20
    public String getUserId() {
        return xt.f3961a.l().h.optString("user_id", null);
    }

    @Override // defpackage.t20
    public void h(String str) {
        rf1 rf1 = this.f3587a;
        rf1.f3075a.putString("registration_detail", str);
        rf1.f3075a.commit();
    }

    @Override // defpackage.t20
    public void i(boolean z, String str) {
        FirebaseAuth instance = FirebaseAuth.getInstance();
        if (instance != null) {
            instance.signOut();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("accessToken", this.e.b.getString("accessToken", null));
            jSONObject.put("refreshToken", this.e.b.getString("refreshToken", null));
            xt.t1 t1Var = xt.f3961a;
            jSONObject.put("userId", t1Var.m0());
            jSONObject.put("deviceId", t1Var.n().a());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        e70 e70 = new e70(1, ut.v, new w30(this), new x30(this), jSONObject.toString());
        e70.n = false;
        this.c.a(e70);
        String userId = getUserId();
        jz5 b2 = jz5.b();
        ad1 ad1 = ad1.SUCCESS;
        UserProfileEvent.TYPE type = UserProfileEvent.TYPE.LOGOUT;
        b2.g(new UserProfileEvent(ad1, type));
        ed1 ed1 = new ed1("user logged out", Long.MIN_VALUE);
        ed1.a("userId", userId);
        ed1.a("sessionLogout", String.valueOf(z));
        if (!TextUtils.isEmpty(str)) {
            ed1.a("url", str);
        }
        jz5.b().g(ed1);
        v();
        xt.t1 t1Var2 = xt.f3961a;
        t1Var2.c().k();
        t1Var2.c().m();
        t1Var2.c().M();
        t1Var2.c().g0();
        d(type);
    }

    @Override // defpackage.t20
    public String j() {
        return xt.f3961a.l().h.optString("access_token", null);
    }

    @Override // defpackage.t20
    public void k(ProfileRequestInfo profileRequestInfo) {
        String str;
        String a0 = hj1.a0(new StringBuilder(), f, "registerNewUser");
        try {
            JSONObject y = y(profileRequestInfo.getProfile().getFields());
            if (profileRequestInfo.getProfile().hasProfilePic()) {
                y.put(SuperPassJsonKeys.PROFILE_PHOTO, profileRequestInfo.getProfile().getProfileUrl(this.d));
            }
            y.put(AnalyticsConstants.TOKEN, j());
            y.put("userId", getUserId());
            if (profileRequestInfo.hasAgencyInfo()) {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                ProfileRequestAgencyInfo agencyInfo = profileRequestInfo.getAgencyInfo();
                jSONObject.put("city", agencyInfo.getCity());
                jSONObject.put("agency", agencyInfo.getAgency());
                jSONObject.put("passengerType", agencyInfo.getPassengerType());
                JSONObject jSONObject2 = new JSONObject(ov.g(agencyInfo.getProofs()));
                JSONObject jSONObject3 = new JSONObject(ov.g(agencyInfo.getAgencyFields()));
                jSONObject.put(SuperPassJsonKeys.PROOFS, jSONObject2);
                jSONObject.put("addFields", jSONObject3);
                jSONArray.put(jSONObject);
                y.put("agencies", jSONArray);
            }
            y.put("deviceId", xt.f3961a.n().a());
            str = y.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            str = null;
        }
        z(a0, str, UserProfileEvent.TYPE.REGISTRATION, false, profileRequestInfo, false);
    }

    @Override // defpackage.t20
    public void l(boolean z) {
        String str;
        String a0 = hj1.a0(new StringBuilder(), f, "getUserProfile");
        String userId = getUserId();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("userId", userId);
            str = jSONObject.toString();
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            hj1.W0(e2);
            str = null;
        }
        z(a0, str, UserProfileEvent.TYPE.PROFILE_FETCH, false, null, z);
    }

    @Override // defpackage.t20
    public boolean m() {
        return e() != null;
    }

    @Override // defpackage.t20
    public void n(UserProfile userProfile) {
        String l = ov.l(userProfile);
        rf1 rf1 = this.f3587a;
        rf1.f3075a.putString("user_info", l);
        rf1.f3075a.commit();
        gl1.f(this.d).p(userProfile.getProfilePhoto()).d(500, 500);
        for (UserAgencyInfo userAgencyInfo : userProfile.getAgencyInfo().values()) {
            for (Map.Entry<String, String> entry : userAgencyInfo.getProofs().entrySet()) {
                gl1.f(this.d).p(entry.getValue()).d(500, 500);
            }
        }
    }

    @Override // defpackage.t20
    public void o() {
        UserProfile e2;
        if (m() && (e2 = e()) != null) {
            try {
                s(e2);
                d(UserProfileEvent.TYPE.PROFILE_FETCH);
            } catch (Exception e3) {
                e3.toString();
                b00 b00 = b00.f358a;
                b00.a().b(e3);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0099  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEvent(defpackage.jf1 r13) {
        /*
        // Method dump skipped, instructions count: 236
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v30.onEvent(jf1):void");
    }

    @Override // defpackage.t20
    public String p() {
        if (this.f3587a.b.contains("registration_detail")) {
            return this.f3587a.b.getString("registration_detail", null);
        }
        return null;
    }

    @Override // defpackage.t20
    public String q() {
        if (this.f3587a.b.contains("first_name")) {
            return this.f3587a.b.getString("first_name", "");
        }
        return "";
    }

    @Override // defpackage.t20
    public void r(String str, String str2, String str3, String str4, String str5) {
        xt.t1 t1Var = xt.f3961a;
        t1Var.l().put("user_id", str);
        t1Var.l().put("first_name", str2);
        t1Var.l().put("last_name", str3);
        t1Var.l().put("email_id", str4);
        t1Var.l().put("phone_no", str5);
    }

    @Override // defpackage.t20
    public void s(UserProfile userProfile) {
        HashMap hashMap = new HashMap();
        hashMap.put("emailid", userProfile.getEmailId());
        hashMap.put("phone", userProfile.getPhone());
        hashMap.put("dob", userProfile.getDateOfBirth());
        hashMap.put(SuperPassJsonKeys.GENDER, userProfile.getGender().name());
        hashMap.put(SuperPassJsonKeys.FIRST_NAME, userProfile.getFirstName());
        hashMap.put(SuperPassJsonKeys.LAST_NAME, userProfile.getLastName());
        xt.t1 t1Var = xt.f3961a;
        t1Var.a().a(hashMap);
        t1Var.a().b(hashMap);
        gv a2 = t1Var.a();
        String emailId = userProfile.getEmailId();
        for (hd1 hd1 : a2.b) {
            hd1.a(emailId);
        }
        String str = userProfile.getFirstName() + " " + userProfile.getLastName();
        for (hd1 hd12 : xt.f3961a.a().b) {
            hd12.b(str);
        }
    }

    @Override // defpackage.t20
    public String t() {
        if (this.f3587a.b.contains("last_name")) {
            return this.f3587a.b.getString("last_name", "");
        }
        return "";
    }

    public final void v() {
        rf1 rf1 = this.f3587a;
        rf1.f3075a.remove("registration_detail");
        rf1.f3075a.commit();
        xt.t1 t1Var = xt.f3961a;
        t1Var.l().remove("access_token");
        t1Var.l().remove("user_id");
        t1Var.l().remove("profile_call_suceeded");
        rf1 rf12 = this.f3587a;
        rf12.f3075a.remove("user_info");
        rf12.f3075a.commit();
    }

    public final void w() {
        if (f()) {
            xt.t1 t1Var = xt.f3961a;
            if (!(t1Var.l().h.has("profile_call_suceeded") && Boolean.valueOf(t1Var.l().h.optString("profile_call_suceeded", null)).booleanValue())) {
                v();
            }
        }
    }

    public final void x(String str, UserProfile userProfile) {
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        ed1.a("userid", userProfile.getUserId());
        ed1.a("dob", userProfile.getDateOfBirth());
        ed1.a("phoneNumber", userProfile.getPhone());
        ed1.a(SuperPassJsonKeys.GENDER, userProfile.getGender().name());
        ed1.a("email", userProfile.getEmailId());
        ed1.a("profilePic", userProfile.getProfilePhoto());
        jz5.b().g(ed1);
    }

    public JSONObject y(BasicProfileFields basicProfileFields) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String emailId = basicProfileFields.getEmailId();
        String str = "";
        if (emailId == null) {
            emailId = str;
        }
        jSONObject.put(SuperPassJsonKeys.MAIL_ID, emailId);
        String phone = basicProfileFields.getPhone();
        if (phone == null) {
            phone = str;
        }
        jSONObject.put(SuperPassJsonKeys.MOBILE_NUMBER, phone);
        String firstName = basicProfileFields.getFirstName();
        if (firstName == null) {
            firstName = str;
        }
        jSONObject.put(SuperPassJsonKeys.FIRST_NAME, firstName);
        String lastName = basicProfileFields.getLastName();
        if (lastName == null) {
            lastName = str;
        }
        jSONObject.put(SuperPassJsonKeys.LAST_NAME, lastName);
        if (basicProfileFields.getGender() != null) {
            jSONObject.put(SuperPassJsonKeys.GENDER, basicProfileFields.getGender().name());
        } else {
            jSONObject.put(SuperPassJsonKeys.GENDER, str);
        }
        String dateOfBirth = basicProfileFields.getDateOfBirth();
        if (!(dateOfBirth == null || dateOfBirth.length() != 10 || dateOfBirth.charAt(2) == '/')) {
            StringBuilder sb = new StringBuilder();
            hj1.M0(dateOfBirth, 8, 10, sb, ConnectionFactory.DEFAULT_VHOST);
            hj1.M0(dateOfBirth, 5, 7, sb, ConnectionFactory.DEFAULT_VHOST);
            sb.append(dateOfBirth.substring(0, 4));
            dateOfBirth = sb.toString();
        }
        if (dateOfBirth != null) {
            str = dateOfBirth;
        }
        jSONObject.put(SuperPassJsonKeys.DATE_OF_BIRTH, str);
        jSONObject.toString();
        return jSONObject;
    }

    public final void z(String str, String str2, UserProfileEvent.TYPE type, boolean z, ProfileRequestInfo profileRequestInfo, boolean z2) {
        if (type.equals(UserProfileEvent.TYPE.PROFILE_UPDATE)) {
            ui1.a(this.d);
        }
        e70 e70 = new e70(this.d, true, 1, str, new a(z, type, z2), new b(profileRequestInfo, type), str2);
        if (UserProfileEvent.TYPE.PROFILE_FETCH.equals(type)) {
            A("profile fetch");
            e70.q = new nj1(120000, 5, 1.0f);
        } else {
            e70.q = new nj1(120000, 0, 1.0f);
        }
        e70.n = false;
        this.c.a(e70);
    }

    public void onEvent(df1 df1) {
        if (m()) {
            UserProfile H = ov.H(df1.c);
            if (!(H == null || H.getUserId() == null)) {
                TransitMode transitMode = TransitMode.bus;
                xt.t1 t1Var = xt.f3961a;
                if (ui1.b0(transitMode, t1Var.k().d())) {
                    t1Var.c().d(H.getUserId(), null);
                }
            }
            MPass r = ov.r(df1.d);
            ed1 ed1 = new ed1("pass booked", Long.MIN_VALUE);
            ed1.a("passengerType", r.getPassengerType());
            ed1.a("numDays", "" + r.getNoOfDays());
            ed1.a("bookingId", r.getBookingPassId());
            StringBuilder f0 = hj1.f0(ed1, SuperPassJsonKeys.REFERENCE_ID, r.getReferenceId());
            f0.append(r.getFare());
            f0.append("");
            ed1.a("productCost", f0.toString());
            ed1.a("productType", r.getNoOfDays() + "");
            ed1.a("bookingDate", jh1.c(r.getBookingTime()));
            ed1.a("startDate", jh1.c(r.getStartingTime()));
            StringBuilder f02 = hj1.f0(ed1, "expiryDate", jh1.c(r.getExpiryTime()));
            f02.append(jh1.j(System.currentTimeMillis()));
            f02.append("");
            ed1.a("hourOfEvent", f02.toString());
            List<MPass> l = xt.f3961a.c().l();
            if (!(l == null || l.size() == 0)) {
                boolean z = false;
                for (MPass mPass : l) {
                    if (mPass.getPassengerType().equals(r.getPassengerType()) && !r.getBookingPassId().equals(mPass.getBookingPassId())) {
                        z = true;
                    }
                }
                ed1.a("isRenewedPass", String.valueOf(z));
            }
            ed1.a("source", "notification");
            ed1.a("paymentMode", r.getPaymentMode());
            if (r.getPaymentMode() != null && r.getPaymentMode().equalsIgnoreCase(SuperPassPaymentConstants.PAYMENT_MODE_CASH)) {
                jz5.b().g(ed1);
            }
            Notification x0 = vn.x0(this.d, df1.f828a, df1.b, "chalo://book/showPass?source=notification", "myChannel");
            NotificationManager notificationManager = (NotificationManager) this.d.getSystemService("notification");
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel("myChannel", "NewGroup", 4);
                int i = jc5.b(this.d).w;
                if (i == 2 || i == -1) {
                    notificationChannel.enableVibration(true);
                }
                if (i == 4 || i == -1) {
                    notificationChannel.enableLights(true);
                    notificationChannel.setLightColor(-1);
                }
                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.cancel(1);
            notificationManager.cancel(2);
            notificationManager.notify(3, x0);
        }
    }
}
