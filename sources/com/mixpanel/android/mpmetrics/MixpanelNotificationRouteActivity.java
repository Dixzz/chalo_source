package com.mixpanel.android.mpmetrics;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import defpackage.tc5;
import org.json.JSONException;
import org.json.JSONObject;

public class MixpanelNotificationRouteActivity extends Activity {
    public void onCreate(Bundle bundle) {
        String str;
        tc5.c cVar;
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            String stringExtra = intent.getStringExtra("mp_tap_target");
            String stringExtra2 = intent.getStringExtra("mp_tap_action_type");
            String stringExtra3 = intent.getStringExtra("mp_tap_action_uri");
            boolean z = false;
            Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra("mp_is_sticky", false));
            String str2 = null;
            if (stringExtra == null || !stringExtra.equals("button")) {
                str = null;
            } else {
                str2 = intent.getStringExtra("mp_button_id");
                str = intent.getStringExtra("mp_button_label");
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("$tap_target", stringExtra);
                jSONObject.putOpt("$tap_action_type", stringExtra2);
                jSONObject.putOpt("$tap_action_uri", stringExtra3);
                jSONObject.putOpt("$is_sticky", valueOf);
                jSONObject.putOpt("$button_id", str2);
                jSONObject.putOpt("$button_label", str);
            } catch (JSONException unused) {
            }
            nc5.u(getApplicationContext(), intent, "$push_notification_tap", jSONObject);
            CharSequence charSequence = intent.getExtras().getCharSequence("mp_tap_action_type");
            if (charSequence == null) {
                cVar = tc5.c.HOMESCREEN;
            } else {
                cVar = tc5.c.fromString(charSequence.toString());
            }
            CharSequence charSequence2 = intent.getExtras().getCharSequence("mp_tap_action_uri");
            Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getPackageName());
            int ordinal = cVar.ordinal();
            if (ordinal != 1) {
                if (ordinal == 2) {
                    launchIntentForPackage = new Intent("android.intent.action.VIEW", Uri.parse(charSequence2.toString()));
                }
            } else if (URLUtil.isValidUrl(charSequence2.toString())) {
                launchIntentForPackage = new Intent("android.intent.action.VIEW", Uri.parse(charSequence2.toString())).addCategory("android.intent.category.BROWSABLE");
            } else {
                charSequence2.toString();
            }
            if (!extras.getBoolean("mp_is_sticky")) {
                new sc5();
                Context applicationContext = getApplicationContext();
                getApplicationContext();
                NotificationManager notificationManager = (NotificationManager) applicationContext.getSystemService("notification");
                int i = extras.getInt("mp_notification_id");
                String string = extras.getString("mp_tag");
                if (string != null) {
                    z = true;
                }
                if (z) {
                    notificationManager.cancel(string, 1);
                } else {
                    notificationManager.cancel(i);
                }
            }
            finish();
            startActivity(launchIntentForPackage);
        }
    }
}
