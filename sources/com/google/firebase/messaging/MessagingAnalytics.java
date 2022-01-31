package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.reporting.MessagingClientEvent;
import com.google.firebase.messaging.reporting.MessagingClientEventExtension;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public class MessagingAnalytics {
    public static boolean deliveryMetricsExportToBigQueryEnabled() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            FirebaseApp.getInstance();
            Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            PackageManager packageManager = applicationContext.getPackageManager();
            if (!(packageManager == null || (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("delivery_metrics_exported_to_big_query_enabled"))) {
                return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
            }
            return false;
        } catch (IllegalStateException unused) {
        }
    }

    public static MessagingClientEvent eventToProto(MessagingClientEvent.Event event, Intent intent) {
        if (intent == null) {
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            extras = Bundle.EMPTY;
        }
        MessagingClientEvent.Builder newBuilder = MessagingClientEvent.newBuilder();
        newBuilder.setTtl(getTtl(extras));
        newBuilder.setEvent(event);
        newBuilder.setInstanceId(getInstanceId(extras));
        newBuilder.setPackageName(getPackageName());
        newBuilder.setSdkPlatform(MessagingClientEvent.SDKPlatform.ANDROID);
        newBuilder.setMessageType(getMessageTypeForFirelog(extras));
        String messageId = getMessageId(extras);
        if (messageId != null) {
            newBuilder.setMessageId(messageId);
        }
        String topic = getTopic(extras);
        if (topic != null) {
            newBuilder.setTopic(topic);
        }
        String collapseKey = getCollapseKey(extras);
        if (collapseKey != null) {
            newBuilder.setCollapseKey(collapseKey);
        }
        String messageLabel = getMessageLabel(extras);
        if (messageLabel != null) {
            newBuilder.setAnalyticsLabel(messageLabel);
        }
        String composerLabel = getComposerLabel(extras);
        if (composerLabel != null) {
            newBuilder.setComposerLabel(composerLabel);
        }
        long projectNumber = getProjectNumber(extras);
        if (projectNumber > 0) {
            newBuilder.setProjectNumber(projectNumber);
        }
        return newBuilder.build();
    }

    public static String getCollapseKey(Bundle bundle) {
        return bundle.getString(Constants.MessagePayloadKeys.COLLAPSE_KEY);
    }

    public static String getComposerId(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.COMPOSER_ID);
    }

    public static String getComposerLabel(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.COMPOSER_LABEL);
    }

    public static String getInstanceId(Bundle bundle) {
        String string = bundle.getString(Constants.MessagePayloadKeys.TO);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return (String) hd3.u(FirebaseInstallations.getInstance(FirebaseApp.getInstance()).getId());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getMessageChannel(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.MESSAGE_CHANNEL);
    }

    public static String getMessageId(Bundle bundle) {
        String string = bundle.getString(Constants.MessagePayloadKeys.MSGID);
        return string == null ? bundle.getString(Constants.MessagePayloadKeys.MSGID_SERVER) : string;
    }

    public static String getMessageLabel(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.MESSAGE_LABEL);
    }

    public static String getMessageTime(Bundle bundle) {
        return bundle.getString(Constants.AnalyticsKeys.MESSAGE_TIMESTAMP);
    }

    public static MessagingClientEvent.MessageType getMessageTypeForFirelog(Bundle bundle) {
        if (bundle == null || !NotificationParams.isNotification(bundle)) {
            return MessagingClientEvent.MessageType.DATA_MESSAGE;
        }
        return MessagingClientEvent.MessageType.DISPLAY_NOTIFICATION;
    }

    public static String getMessageTypeForScion(Bundle bundle) {
        return true != NotificationParams.isNotification(bundle) ? "data" : Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION;
    }

    public static String getPackageName() {
        return FirebaseApp.getInstance().getApplicationContext().getPackageName();
    }

    public static long getProjectNumber(Bundle bundle) {
        if (bundle.containsKey(Constants.MessagePayloadKeys.SENDER_ID)) {
            try {
                return Long.parseLong(bundle.getString(Constants.MessagePayloadKeys.SENDER_ID));
            } catch (NumberFormatException unused) {
            }
        }
        FirebaseApp instance = FirebaseApp.getInstance();
        String gcmSenderId = instance.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            try {
                return Long.parseLong(gcmSenderId);
            } catch (NumberFormatException unused2) {
            }
        }
        String applicationId = instance.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            try {
                return Long.parseLong(applicationId);
            } catch (NumberFormatException unused3) {
                return 0;
            }
        } else {
            String[] split = applicationId.split(ProductDiscountsObject.KEY_DELIMITER);
            if (split.length < 2) {
                return 0;
            }
            String str = split[1];
            if (str.isEmpty()) {
                return 0;
            }
            return Long.parseLong(str);
        }
    }

    public static String getTopic(Bundle bundle) {
        String string = bundle.getString(Constants.MessagePayloadKeys.FROM);
        if (string == null || !string.startsWith("/topics/")) {
            return null;
        }
        return string;
    }

    public static int getTtl(Bundle bundle) {
        Object obj = bundle.get(Constants.MessagePayloadKeys.TTL);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String.valueOf(obj).length();
            return 0;
        }
    }

    public static String getUseDeviceTime(Bundle bundle) {
        if (bundle.containsKey(Constants.AnalyticsKeys.MESSAGE_USE_DEVICE_TIME)) {
            return bundle.getString(Constants.AnalyticsKeys.MESSAGE_USE_DEVICE_TIME);
        }
        return null;
    }

    private static boolean isDirectBootMessage(Intent intent) {
        return FirebaseMessagingService.ACTION_DIRECT_BOOT_REMOTE_INTENT.equals(intent.getAction());
    }

    public static void logNotificationDismiss(Intent intent) {
        logToScion(Constants.ScionAnalytics.EVENT_NOTIFICATION_DISMISS, intent.getExtras());
    }

    public static void logNotificationForeground(Intent intent) {
        logToScion(Constants.ScionAnalytics.EVENT_NOTIFICATION_FOREGROUND, intent.getExtras());
    }

    public static void logNotificationOpen(Bundle bundle) {
        setUserPropertyIfRequired(bundle);
        logToScion(Constants.ScionAnalytics.EVENT_NOTIFICATION_OPEN, bundle);
    }

    public static void logNotificationReceived(Intent intent) {
        if (shouldUploadScionMetrics(intent)) {
            logToScion(Constants.ScionAnalytics.EVENT_NOTIFICATION_RECEIVE, intent.getExtras());
        }
        if (shouldUploadFirelogAnalytics(intent)) {
            logToFirelog(MessagingClientEvent.Event.MESSAGE_DELIVERED, intent, FirebaseMessaging.getTransportFactory());
        }
    }

    private static void logToFirelog(MessagingClientEvent.Event event, Intent intent, eu1 eu1) {
        MessagingClientEvent eventToProto;
        if (eu1 != null && (eventToProto = eventToProto(event, intent)) != null) {
            try {
                du1 a2 = eu1.a(Constants.FirelogAnalytics.FCM_LOG_SOURCE, MessagingClientEventExtension.class, new zt1("proto"), MessagingAnalytics$$Lambda$0.$instance);
                MessagingClientEventExtension.Builder newBuilder = MessagingClientEventExtension.newBuilder();
                newBuilder.setMessagingClientEvent(eventToProto);
                ((lv1) a2).a(new yt1(null, newBuilder.build(), bu1.VERY_LOW), av1.f335a);
            } catch (RuntimeException unused) {
            }
        }
    }

    public static void logToScion(String str, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        Bundle bundle2 = new Bundle();
        String composerId = getComposerId(bundle);
        if (composerId != null) {
            bundle2.putString("_nmid", composerId);
        }
        String composerLabel = getComposerLabel(bundle);
        if (composerLabel != null) {
            bundle2.putString(Constants.ScionAnalytics.PARAM_MESSAGE_NAME, composerLabel);
        }
        String messageLabel = getMessageLabel(bundle);
        if (!TextUtils.isEmpty(messageLabel)) {
            bundle2.putString(Constants.ScionAnalytics.PARAM_LABEL, messageLabel);
        }
        String messageChannel = getMessageChannel(bundle);
        if (!TextUtils.isEmpty(messageChannel)) {
            bundle2.putString(Constants.ScionAnalytics.PARAM_MESSAGE_CHANNEL, messageChannel);
        }
        String topic = getTopic(bundle);
        if (topic != null) {
            bundle2.putString(Constants.ScionAnalytics.PARAM_TOPIC, topic);
        }
        String messageTime = getMessageTime(bundle);
        if (messageTime != null) {
            try {
                bundle2.putInt(Constants.ScionAnalytics.PARAM_MESSAGE_TIME, Integer.parseInt(messageTime));
            } catch (NumberFormatException unused) {
            }
        }
        String useDeviceTime = getUseDeviceTime(bundle);
        if (useDeviceTime != null) {
            try {
                bundle2.putInt(Constants.ScionAnalytics.PARAM_MESSAGE_DEVICE_TIME, Integer.parseInt(useDeviceTime));
            } catch (NumberFormatException unused2) {
            }
        }
        String messageTypeForScion = getMessageTypeForScion(bundle);
        if (Constants.ScionAnalytics.EVENT_NOTIFICATION_RECEIVE.equals(str) || Constants.ScionAnalytics.EVENT_NOTIFICATION_FOREGROUND.equals(str)) {
            bundle2.putString(Constants.ScionAnalytics.PARAM_MESSAGE_TYPE, messageTypeForScion);
        }
        if (Log.isLoggable(Constants.TAG, 3)) {
            String valueOf = String.valueOf(bundle2);
            str.length();
            valueOf.length();
        }
        AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.getInstance().get(AnalyticsConnector.class);
        if (analyticsConnector != null) {
            analyticsConnector.logEvent(Constants.ScionAnalytics.ORIGIN_FCM, str, bundle2);
        }
    }

    public static void setDeliveryMetricsExportToBigQuery(boolean z) {
        FirebaseApp.getInstance().getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit().putBoolean("export_to_big_query", z).apply();
    }

    private static void setUserPropertyIfRequired(Bundle bundle) {
        if (bundle != null) {
            if ("1".equals(bundle.getString(Constants.AnalyticsKeys.TRACK_CONVERSIONS))) {
                AnalyticsConnector analyticsConnector = (AnalyticsConnector) FirebaseApp.getInstance().get(AnalyticsConnector.class);
                Log.isLoggable(Constants.TAG, 3);
                if (analyticsConnector != null) {
                    String string = bundle.getString(Constants.AnalyticsKeys.COMPOSER_ID);
                    analyticsConnector.setUserProperty(Constants.ScionAnalytics.ORIGIN_FCM, Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION, string);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("source", "Firebase");
                    bundle2.putString("medium", "notification");
                    bundle2.putString("campaign", string);
                    analyticsConnector.logEvent(Constants.ScionAnalytics.ORIGIN_FCM, Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN, bundle2);
                    return;
                }
                return;
            }
            if (Log.isLoggable(Constants.TAG, 3)) {
            }
        }
    }

    public static boolean shouldUploadFirelogAnalytics(Intent intent) {
        if (intent == null || isDirectBootMessage(intent)) {
            return false;
        }
        return deliveryMetricsExportToBigQueryEnabled();
    }

    public static boolean shouldUploadScionMetrics(Intent intent) {
        if (intent == null || isDirectBootMessage(intent)) {
            return false;
        }
        return shouldUploadScionMetrics(intent.getExtras());
    }

    public static boolean shouldUploadScionMetrics(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return "1".equals(bundle.getString(Constants.AnalyticsKeys.ENABLED));
    }
}
