package app.zophop.utilities.mixpanel.mpmetrics;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.utilities.R;
import com.freshchat.consumer.sdk.Freshchat;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.RemoteMessage;
import org.json.JSONException;
import org.json.JSONObject;

public class GCMReceiver extends sc5 {

    public class a implements ti4<InstanceIdResult> {
        public a() {
        }

        @Override // defpackage.ti4
        public void onComplete(yi4<InstanceIdResult> yi4) {
            String token = yi4.m().getToken();
            sc5.a(token);
            Freshchat.getInstance(GCMReceiver.this.getApplication()).setPushRegistrationToken(token);
            jz5.b().i(new we1(token));
        }
    }

    public final void b(Intent intent) {
        Bundle extras = intent.getExtras();
        String string = extras.getString("gcm.notification.title", null);
        String string2 = extras.getString("gcm.notification.body", null);
        String string3 = extras.getString("gcm.notification.alertId", "alert12345");
        long j = extras.getLong(Constants.MessagePayloadKeys.SENT_TIME);
        if (string != null && string2 != null && string3 != null) {
            jz5.b().i(new te1(new re1(string3, j, null, string2, string, false, null)));
        }
    }

    @Override // defpackage.sc5, com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        boolean z;
        long j;
        Intent intent = remoteMessage.toIntent();
        String action = intent.getAction();
        jz5.b().i(new ve1(remoteMessage));
        String stringExtra = intent.getStringExtra("notification_type");
        lf1 lf1 = lf1.IN_APP_CARD;
        if (!lf1.name().equalsIgnoreCase(stringExtra) && !lf1.ALERT.name().equalsIgnoreCase(stringExtra) && !lf1.PROFILE_UPDATE.name().equalsIgnoreCase(stringExtra) && !lf1.SP_APPLICATION_UPDATE.name().equalsIgnoreCase(stringExtra) && !lf1.PASS_UPDATE.name().equalsIgnoreCase(stringExtra) && !lf1.REFERRAL.name().equalsIgnoreCase(stringExtra) && !lf1.APP_UPDATE.name().equalsIgnoreCase(stringExtra) && !lf1.PAYMENT_DONE.name().equalsIgnoreCase(stringExtra) && !lf1.TICKET_PUNCH.name().equalsIgnoreCase(stringExtra) && !lf1.SP_PUNCH.name().equalsIgnoreCase(stringExtra) && !lf1.MTICKET_PUNCH.name().equalsIgnoreCase(stringExtra) && !lf1.UPDATE_TRANSACTION.name().equalsIgnoreCase(stringExtra)) {
            z = lf1.IMAGE_NOTIFICATION.name().equalsIgnoreCase(stringExtra);
        } else {
            z = true;
        }
        if (z) {
            Application application = getApplication();
            String stringExtra2 = intent.getStringExtra("notification_type");
            jz5.b().g(hj1.l("custom notification", Long.MIN_VALUE, "notification type", stringExtra2));
            if (lf1.name().equalsIgnoreCase(stringExtra2)) {
                long currentTimeMillis = System.currentTimeMillis();
                String stringExtra3 = intent.getStringExtra("image_url");
                String stringExtra4 = intent.getStringExtra("notification_id");
                String stringExtra5 = intent.getStringExtra("negative_button_copy");
                String str = TextUtils.isEmpty(stringExtra5) ? null : stringExtra5;
                String stringExtra6 = intent.getStringExtra("negative_button_cta");
                String str2 = TextUtils.isEmpty(stringExtra6) ? null : stringExtra6;
                String stringExtra7 = intent.getStringExtra("positive_button_copy");
                String str3 = TextUtils.isEmpty(stringExtra7) ? null : stringExtra7;
                String stringExtra8 = intent.getStringExtra("positive_button_cta");
                String str4 = TextUtils.isEmpty(stringExtra8) ? null : stringExtra8;
                String stringExtra9 = intent.getStringExtra(ProductPromotionsObject.KEY_TITLE);
                String str5 = TextUtils.isEmpty(stringExtra9) ? null : stringExtra9;
                String stringExtra10 = intent.getStringExtra("title_bg_color");
                String str6 = TextUtils.isEmpty(stringExtra10) ? null : stringExtra10;
                long currentTimeMillis2 = System.currentTimeMillis();
                boolean U0 = vn.U0(intent, "dismiss_on_positive_button", false);
                try {
                    JSONObject jSONObject = new JSONObject(intent.getStringExtra("expiry_details"));
                    String string = jSONObject.getString("expiry_type");
                    if (kf1.RELATIVE.name().equalsIgnoreCase(string)) {
                        j = jSONObject.getLong("expiry_time") + currentTimeMillis;
                    } else {
                        if (kf1.ABSOLUTE.name().equalsIgnoreCase(string)) {
                            j = jSONObject.getLong("expiry_time");
                        }
                        j = -1;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jz5.b().i(new ye1(new ze1(stringExtra3, str, str2, str3, str4, str5, stringExtra4, currentTimeMillis2, str6, U0, j)));
            } else if (lf1.ALERT.name().equalsIgnoreCase(stringExtra2)) {
                jz5.b().i(new te1(vn.z(intent)));
            } else if (lf1.PROFILE_UPDATE.name().equalsIgnoreCase(stringExtra2)) {
                String stringExtra11 = intent.getStringExtra("gcm.notification.title");
                String stringExtra12 = intent.getStringExtra("gcm.notification.message");
                intent.getStringExtra("gcm.notification.body");
                String stringExtra13 = intent.getStringExtra(SuperPassJsonKeys.USER_PROFILE);
                String stringExtra14 = intent.getStringExtra("info");
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    for (String str7 : extras.keySet()) {
                        Object obj = extras.get(str7);
                        String.format("%s %s (%s)", str7, obj.toString(), obj.getClass().getName());
                    }
                }
                jz5.b().i(new jf1(stringExtra11, stringExtra12, stringExtra13, stringExtra14));
            } else if (lf1.SP_APPLICATION_UPDATE.name().equalsIgnoreCase(stringExtra2)) {
                jz5.b().i(new gf1(intent.getStringExtra("gcm.notification.title"), intent.getStringExtra("gcm.notification.message"), intent.getStringExtra("info")));
            } else if (lf1.UPDATE_TRANSACTION.name().equalsIgnoreCase(stringExtra2)) {
                jz5.b().i(new cf1(intent.getStringExtra("gcm.notification.title"), intent.getStringExtra("gcm.notification.message")));
            } else if (lf1.TICKET_PUNCH.name().equalsIgnoreCase(stringExtra2)) {
                jz5.b().i(new if1(intent.getStringExtra("gcm.notification.title"), intent.getStringExtra("gcm.notification.message"), intent.getStringExtra("ticketId")));
            } else if (lf1.SP_PUNCH.name().equalsIgnoreCase(stringExtra2)) {
                jz5.b().i(new hf1(intent.getStringExtra("gcm.notification.title"), intent.getStringExtra("gcm.notification.message"), intent.getStringExtra("lastRideInfo")));
            } else if (lf1.MTICKET_PUNCH.name().equalsIgnoreCase(stringExtra2)) {
                jz5.b().i(new bf1(intent.getStringExtra("gcm.notification.title"), intent.getStringExtra("gcm.notification.message"), intent.getStringExtra("lastRideInfo")));
            } else if (lf1.PASS_UPDATE.name().equalsIgnoreCase(stringExtra2)) {
                String stringExtra15 = intent.getStringExtra("mp_message");
                String stringExtra16 = intent.getStringExtra("mp_title");
                if (stringExtra16 == null) {
                    stringExtra16 = application.getString(R.string.app_name);
                }
                jz5.b().i(new ef1(stringExtra16.toString(), stringExtra15));
            } else if (lf1.REFERRAL.name().equalsIgnoreCase(stringExtra2)) {
                jz5.b().i(new ff1(vn.z(intent)));
            } else if (lf1.IMAGE_NOTIFICATION.name().equalsIgnoreCase(stringExtra2)) {
                String stringExtra17 = intent.getStringExtra(ProductPromotionsObject.KEY_TITLE);
                String stringExtra18 = intent.getStringExtra("description");
                String stringExtra19 = intent.getStringExtra("imageTitle");
                String stringExtra20 = intent.getStringExtra("imageDescription");
                String stringExtra21 = intent.getStringExtra("notificationId");
                String stringExtra22 = intent.getStringExtra("imageUrl");
                String stringExtra23 = intent.getStringExtra("action");
                if (stringExtra17 == null) {
                    stringExtra17 = application.getString(R.string.app_name);
                }
                jz5.b().i(new ue1(stringExtra21, stringExtra17, stringExtra18, stringExtra19 == null ? application.getString(R.string.app_name) : stringExtra19, stringExtra20, stringExtra22, stringExtra23));
            } else if (lf1.APP_UPDATE.name().equalsIgnoreCase(stringExtra2)) {
                jz5.b().i(new af1(intent.getExtras(), application, intent.getStringExtra(Constants.MessagePayloadKeys.MSGID)));
            } else if (lf1.PAYMENT_DONE.name().equalsIgnoreCase(stringExtra2)) {
                jz5.b().i(new df1(intent.getStringExtra("gcm.notification.title"), intent.getStringExtra("gcm.notification.message"), intent.getStringExtra(SuperPassJsonKeys.USER_PROFILE), intent.getStringExtra("passInfo")));
            }
        } else if (Freshchat.isFreshchatNotification(intent)) {
            Freshchat.handleFcmMessage(getApplication(), remoteMessage);
        } else if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            intent.getAction();
            super.onMessageReceived(remoteMessage);
        } else if ("com.google.android.c2dm.intent.RECEIVE".equals(action)) {
            intent.getAction();
            if (Boolean.parseBoolean(intent.getExtras().getString("gcm.notification.isFCMNotification", String.valueOf(false)))) {
                getApplication().getApplicationContext();
                b(intent);
                return;
            }
            super.onMessageReceived(remoteMessage);
        } else {
            super.onMessageReceived(remoteMessage);
        }
    }

    @Override // defpackage.sc5, com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        super.onNewToken(str);
        jz5.b().i(new xe1(str, "gcm receiver"));
        FirebaseInstanceId.getInstance().getInstanceId().b(new a());
    }
}
