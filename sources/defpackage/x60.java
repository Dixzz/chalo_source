package defpackage;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.activities.HomeActivity;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* renamed from: x60  reason: default package */
/* compiled from: SuperPassNotificationHelper.kt */
public final class x60 {
    public static final void a(String str, String str2, Intent intent, int i, Context context) {
        intent.setFlags(268468224);
        Notification T0 = vn.T0(context, PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 268435456), R.drawable.logo_notification, str, str2, "myChannel");
        Object systemService = context.getSystemService("notification");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).notify(i, T0);
    }

    public static final BookableSuperPassConfiguration b(JSONObject jSONObject) {
        n86.e(jSONObject, "lPayload");
        String string = jSONObject.getString("city");
        City d = xt.f3961a.k().d();
        boolean z = true;
        if (!ea6.f(string, d == null ? null : d.getName(), true)) {
            return null;
        }
        String string2 = jSONObject.getString("configId");
        String string3 = jSONObject.getString(SuperPassJsonKeys.CATEGORY_ID);
        int i = jSONObject.getInt(SuperPassJsonKeys.FARE_MAPPING_ID);
        ProductConfiguration m0 = vn.m0(string2);
        if (m0 == null) {
            return null;
        }
        Map<Integer, BookableSuperPassConfiguration> map = t60.b(null, t60.c(m0)).get(string3);
        if (map != null && !map.isEmpty()) {
            z = false;
        }
        if (z) {
            return null;
        }
        return map.get(Integer.valueOf(i));
    }

    public static final Intent c(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        intent.setFlags(268468224);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0190 A[EDGE_INSN: B:101:0x0190->B:89:0x0190 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00db A[LOOP:0: B:5:0x003e->B:45:0x00db, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0183 A[LOOP:2: B:51:0x00fd->B:87:0x0183, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x00f4 A[EDGE_INSN: B:99:0x00f4->B:47:0x00f4 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final app.zophop.models.mTicketing.PassApplicationRejectionReasons d(org.json.JSONObject r21) {
        /*
        // Method dump skipped, instructions count: 444
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.x60.d(org.json.JSONObject):app.zophop.models.mTicketing.PassApplicationRejectionReasons");
    }

    public static final long e(JSONObject jSONObject) {
        n86.e(jSONObject, "lPayload");
        return jSONObject.getLong(SuperPassJsonKeys.PASS_START_DATE);
    }

    public static final SuperPassUserDetails f(JSONObject jSONObject) {
        n86.e(jSONObject, "lPayloadJson");
        JSONObject jSONObject2 = jSONObject.getJSONObject("userDetails");
        String string = jSONObject2.getString(SuperPassJsonKeys.GENDER);
        n86.d(string, "lUserDetailsObject.getString(KEY_GENDER)");
        String upperCase = string.toUpperCase();
        n86.d(upperCase, "(this as java.lang.String).toUpperCase()");
        Gender valueOf = Gender.valueOf(upperCase);
        String string2 = jSONObject2.getString("userId");
        n86.d(string2, "lUserDetailsObject.getString(KEY_USER_ID)");
        String string3 = jSONObject2.getString("mobileNo");
        n86.d(string3, "lUserDetailsObject.getString(KEY_MOBILE_NO)");
        String string4 = jSONObject2.getString("userName");
        n86.d(string4, "lUserDetailsObject.getString(KEY_USER_NAME)");
        String string5 = jSONObject2.getString("dob");
        n86.d(string5, "lUserDetailsObject.getString(KEY_DATE_OF_BIRTH)");
        String string6 = jSONObject2.getString(SuperPassJsonKeys.MAIL_ID);
        n86.d(string6, "lUserDetailsObject.getString(KEY_MAIL_ID)");
        String string7 = jSONObject2.getString(SuperPassJsonKeys.PROFILE_PHOTO);
        n86.d(string7, "lUserDetailsObject.getString(KEY_PROFILE_PHOTO)");
        return new SuperPassUserDetails(string2, string3, string4, valueOf, string5, string6, string7);
    }
}
