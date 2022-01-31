package defpackage;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.mixpanel.android.mpmetrics.MixpanelNotificationRouteActivity;
import defpackage.tc5;
import defpackage.zc5;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: uc5  reason: default package */
/* compiled from: MixpanelPushNotification */
public class uc5 {

    /* renamed from: a  reason: collision with root package name */
    public final int f3485a;
    public Context b;
    public yc5 c;
    public Notification.Builder d;
    public long e;
    public tc5 f;
    public int g;
    public boolean h = false;

    public uc5(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        long currentTimeMillis = System.currentTimeMillis();
        this.b = context;
        this.d = builder;
        String str = jc5.b(context).s;
        this.c = new zc5.a(str == null ? context.getPackageName() : str, context);
        this.e = currentTimeMillis;
        int i = (int) currentTimeMillis;
        this.f3485a = i;
        this.g = i;
    }

    public Bundle a(tc5.b bVar) {
        Bundle bundle = new Bundle();
        bundle.putCharSequence("mp_tap_target", "notification");
        bundle.putCharSequence("mp_tap_action_type", bVar.f3334a.toString());
        bundle.putCharSequence("mp_tap_action_uri", bVar.b);
        bundle.putCharSequence("mp_message_id", this.f.s);
        bundle.putCharSequence("mp_campaign_id", this.f.r);
        bundle.putInt("mp_notification_id", this.g);
        bundle.putBoolean("mp_is_sticky", this.f.l);
        bundle.putCharSequence("mp_tag", this.f.j);
        bundle.putCharSequence("mp_canonical_notification_id", e());
        bundle.putCharSequence("mp", this.f.t);
        return bundle;
    }

    public tc5.b b(String str) {
        tc5.b bVar;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                tc5.c cVar = tc5.c.HOMESCREEN;
                if (!string.equals(cVar.toString())) {
                    bVar = new tc5.b(tc5.c.fromString(string), jSONObject.getString("uri"));
                } else {
                    bVar = new tc5.b(tc5.c.fromString(string));
                }
                if (!bVar.f3334a.toString().equals(tc5.c.ERROR.toString())) {
                    return bVar;
                }
                this.h = true;
                return new tc5.b(cVar);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @TargetApi(20)
    public Notification.Action c(CharSequence charSequence, tc5.b bVar, String str, int i) {
        Bundle a2 = a(bVar);
        a2.putCharSequence("mp_tap_target", "button");
        a2.putCharSequence("mp_button_id", str);
        a2.putCharSequence("mp_button_label", charSequence);
        return new Notification.Action.Builder(0, charSequence, PendingIntent.getActivity(this.b, this.f3485a + i, new Intent().setClass(this.b, MixpanelNotificationRouteActivity.class).putExtras(a2).setFlags(CommonUtils.BYTES_IN_A_GIGABYTE), 268435456)).build();
    }

    public ApplicationInfo d() {
        try {
            return this.b.getPackageManager().getApplicationInfo(this.b.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public String e() {
        String str = this.f.j;
        if (str != null) {
            return str;
        }
        return Integer.toString(this.g);
    }

    public final Date f(String str, String str2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
            if (str.equals("yyyy-MM-dd'T'HH:mm:ss'Z'")) {
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
            }
            return simpleDateFormat.parse(str2);
        } catch (ParseException unused) {
            return null;
        }
    }

    public void g(String str) {
        this.d.setStyle(new Notification.BigTextStyle().bigText(str));
    }
}
