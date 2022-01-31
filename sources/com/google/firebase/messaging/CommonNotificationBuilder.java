package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.iid.ServiceStarter;
import com.google.firebase.messaging.Constants;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class CommonNotificationBuilder {
    public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL = "fcm_fallback_notification_channel";
    public static final String FCM_FALLBACK_NOTIFICATION_CHANNEL_LABEL = "fcm_fallback_notification_channel_label";
    public static final String METADATA_DEFAULT_CHANNEL_ID = "com.google.firebase.messaging.default_notification_channel_id";
    public static final String METADATA_DEFAULT_COLOR = "com.google.firebase.messaging.default_notification_color";
    public static final String METADATA_DEFAULT_ICON = "com.google.firebase.messaging.default_notification_icon";
    private static final AtomicInteger requestCodeProvider = new AtomicInteger((int) SystemClock.elapsedRealtime());

    /* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
    public static class DisplayNotificationInfo {
        public final int id = 0;
        public final f5 notificationBuilder;
        public final String tag;

        public DisplayNotificationInfo(f5 f5Var, String str, int i) {
            this.notificationBuilder = f5Var;
            this.tag = str;
        }
    }

    private CommonNotificationBuilder() {
    }

    private static PendingIntent createContentIntent(Context context, NotificationParams notificationParams, String str, PackageManager packageManager) {
        Intent createTargetIntent = createTargetIntent(str, notificationParams, packageManager);
        if (createTargetIntent == null) {
            return null;
        }
        createTargetIntent.addFlags(67108864);
        createTargetIntent.putExtras(notificationParams.paramsWithReservedKeysRemoved());
        if (shouldUploadMetrics(notificationParams)) {
            createTargetIntent.putExtra(Constants.MessageNotificationKeys.ANALYTICS_DATA, notificationParams.paramsForAnalyticsIntent());
        }
        return PendingIntent.getActivity(context, generatePendingIntentRequestCode(), createTargetIntent, getPendingIntentFlags(CommonUtils.BYTES_IN_A_GIGABYTE));
    }

    private static PendingIntent createDeleteIntent(Context context, NotificationParams notificationParams) {
        if (!shouldUploadMetrics(notificationParams)) {
            return null;
        }
        return createMessagingPendingIntent(context, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(notificationParams.paramsForAnalyticsIntent()));
    }

    private static PendingIntent createMessagingPendingIntent(Context context, Intent intent) {
        return PendingIntent.getBroadcast(context, generatePendingIntentRequestCode(), new Intent(ServiceStarter.ACTION_MESSAGING_EVENT).setComponent(new ComponentName(context, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", intent), getPendingIntentFlags(CommonUtils.BYTES_IN_A_GIGABYTE));
    }

    public static DisplayNotificationInfo createNotificationInfo(Context context, NotificationParams notificationParams) {
        Bundle manifestMetadata = getManifestMetadata(context.getPackageManager(), context.getPackageName());
        return createNotificationInfo(context, context.getPackageName(), notificationParams, getOrCreateChannel(context, notificationParams.getNotificationChannelId(), manifestMetadata), context.getResources(), context.getPackageManager(), manifestMetadata);
    }

    private static Intent createTargetIntent(String str, NotificationParams notificationParams, PackageManager packageManager) {
        String string = notificationParams.getString(Constants.MessageNotificationKeys.CLICK_ACTION);
        if (!TextUtils.isEmpty(string)) {
            Intent intent = new Intent(string);
            intent.setPackage(str);
            intent.setFlags(268435456);
            return intent;
        }
        Uri link = notificationParams.getLink();
        if (link == null) {
            return packageManager.getLaunchIntentForPackage(str);
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setPackage(str);
        intent2.setData(link);
        return intent2;
    }

    private static int generatePendingIntentRequestCode() {
        return requestCodeProvider.incrementAndGet();
    }

    private static Integer getColor(Context context, String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                String.valueOf(str).length();
            }
        }
        int i = bundle.getInt(METADATA_DEFAULT_COLOR, 0);
        if (i == 0) {
            return null;
        }
        try {
            return Integer.valueOf(q5.b(context, i));
        } catch (Resources.NotFoundException unused2) {
            return null;
        }
    }

    private static int getConsolidatedDefaults(NotificationParams notificationParams) {
        boolean z = notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_SOUND);
        if (notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_VIBRATE_TIMINGS)) {
            z = (z ? 1 : 0) | true;
        }
        if (!notificationParams.getBoolean(Constants.MessageNotificationKeys.DEFAULT_LIGHT_SETTINGS)) {
            int i = z ? 1 : 0;
            int i2 = z ? 1 : 0;
            int i3 = z ? 1 : 0;
            return i;
        }
        int i4 = z ? 1 : 0;
        char c = z ? 1 : 0;
        return i4 | 4;
    }

    private static Bundle getManifestMetadata(PackageManager packageManager, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (!(applicationInfo == null || (bundle = applicationInfo.metaData) == null)) {
                return bundle;
            }
        } catch (PackageManager.NameNotFoundException e) {
            String.valueOf(e).length();
        }
        return Bundle.EMPTY;
    }

    @TargetApi(26)
    public static String getOrCreateChannel(Context context, String str, Bundle bundle) {
        String str2;
        if (Build.VERSION.SDK_INT < 26) {
            return null;
        }
        try {
            if (context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion >= 26) {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService(NotificationManager.class);
                if (!TextUtils.isEmpty(str)) {
                    if (notificationManager.getNotificationChannel(str) != null) {
                        return str;
                    }
                    String.valueOf(str).length();
                }
                String string = bundle.getString(METADATA_DEFAULT_CHANNEL_ID);
                if (!TextUtils.isEmpty(string) && notificationManager.getNotificationChannel(string) != null) {
                    return string;
                }
                if (notificationManager.getNotificationChannel(FCM_FALLBACK_NOTIFICATION_CHANNEL) == null) {
                    int identifier = context.getResources().getIdentifier(FCM_FALLBACK_NOTIFICATION_CHANNEL_LABEL, "string", context.getPackageName());
                    if (identifier == 0) {
                        str2 = "Misc";
                    } else {
                        str2 = context.getString(identifier);
                    }
                    notificationManager.createNotificationChannel(new NotificationChannel(FCM_FALLBACK_NOTIFICATION_CHANNEL, str2, 3));
                }
                return FCM_FALLBACK_NOTIFICATION_CHANNEL;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static int getPendingIntentFlags(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return 1140850688;
        }
        return CommonUtils.BYTES_IN_A_GIGABYTE;
    }

    private static int getSmallIcon(PackageManager packageManager, Resources resources, String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str2)) {
            int identifier = resources.getIdentifier(str2, "drawable", str);
            if (identifier != 0 && isValidIcon(resources, identifier)) {
                return identifier;
            }
            int identifier2 = resources.getIdentifier(str2, "mipmap", str);
            if (identifier2 != 0 && isValidIcon(resources, identifier2)) {
                return identifier2;
            }
            String.valueOf(str2).length();
        }
        int i = bundle.getInt(METADATA_DEFAULT_ICON, 0);
        if (i == 0 || !isValidIcon(resources, i)) {
            try {
                i = packageManager.getApplicationInfo(str, 0).icon;
            } catch (PackageManager.NameNotFoundException e) {
                String.valueOf(e).length();
            }
        }
        if (i == 0 || !isValidIcon(resources, i)) {
            return 17301651;
        }
        return i;
    }

    private static Uri getSound(String str, NotificationParams notificationParams, Resources resources) {
        String soundResourceName = notificationParams.getSoundResourceName();
        if (TextUtils.isEmpty(soundResourceName)) {
            return null;
        }
        if (ProductDiscountsObject.KEY_PRODUCT_TYPE_DEFAULT.equals(soundResourceName) || resources.getIdentifier(soundResourceName, "raw", str) == 0) {
            return RingtoneManager.getDefaultUri(2);
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 24 + String.valueOf(soundResourceName).length());
        sb.append("android.resource://");
        sb.append(str);
        sb.append("/raw/");
        sb.append(soundResourceName);
        return Uri.parse(sb.toString());
    }

    private static String getTag(NotificationParams notificationParams) {
        String string = notificationParams.getString(Constants.MessageNotificationKeys.TAG);
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        StringBuilder sb = new StringBuilder(37);
        sb.append("FCM-Notification:");
        sb.append(uptimeMillis);
        return sb.toString();
    }

    @TargetApi(26)
    private static boolean isValidIcon(Resources resources, int i) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            return !(resources.getDrawable(i, null) instanceof AdaptiveIconDrawable);
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    public static boolean shouldUploadMetrics(NotificationParams notificationParams) {
        return notificationParams.getBoolean(Constants.AnalyticsKeys.ENABLED);
    }

    public static DisplayNotificationInfo createNotificationInfo(Context context, String str, NotificationParams notificationParams, String str2, Resources resources, PackageManager packageManager, Bundle bundle) {
        f5 f5Var = new f5(context, str2);
        String possiblyLocalizedString = notificationParams.getPossiblyLocalizedString(resources, str, Constants.MessageNotificationKeys.TITLE);
        if (!TextUtils.isEmpty(possiblyLocalizedString)) {
            f5Var.g(possiblyLocalizedString);
        }
        String possiblyLocalizedString2 = notificationParams.getPossiblyLocalizedString(resources, str, Constants.MessageNotificationKeys.BODY);
        if (!TextUtils.isEmpty(possiblyLocalizedString2)) {
            f5Var.f(possiblyLocalizedString2);
            e5 e5Var = new e5();
            e5Var.d(possiblyLocalizedString2);
            f5Var.l(e5Var);
        }
        f5Var.v.icon = getSmallIcon(packageManager, resources, str, notificationParams.getString(Constants.MessageNotificationKeys.ICON), bundle);
        Uri sound = getSound(str, notificationParams, resources);
        if (sound != null) {
            f5Var.k(sound);
        }
        f5Var.g = createContentIntent(context, notificationParams, str, packageManager);
        PendingIntent createDeleteIntent = createDeleteIntent(context, notificationParams);
        if (createDeleteIntent != null) {
            f5Var.v.deleteIntent = createDeleteIntent;
        }
        Integer color = getColor(context, notificationParams.getString(Constants.MessageNotificationKeys.COLOR), bundle);
        if (color != null) {
            f5Var.q = color.intValue();
        }
        int i = 1;
        f5Var.i(16, !notificationParams.getBoolean(Constants.MessageNotificationKeys.STICKY));
        f5Var.n = notificationParams.getBoolean(Constants.MessageNotificationKeys.LOCAL_ONLY);
        String string = notificationParams.getString(Constants.MessageNotificationKeys.TICKER);
        if (string != null) {
            f5Var.v.tickerText = f5.d(string);
        }
        Integer notificationPriority = notificationParams.getNotificationPriority();
        if (notificationPriority != null) {
            f5Var.j = notificationPriority.intValue();
        }
        Integer visibility = notificationParams.getVisibility();
        if (visibility != null) {
            f5Var.r = visibility.intValue();
        }
        Integer notificationCount = notificationParams.getNotificationCount();
        if (notificationCount != null) {
            f5Var.i = notificationCount.intValue();
        }
        Long l = notificationParams.getLong(Constants.MessageNotificationKeys.EVENT_TIME);
        if (l != null) {
            f5Var.k = true;
            f5Var.v.when = l.longValue();
        }
        long[] vibrateTimings = notificationParams.getVibrateTimings();
        if (vibrateTimings != null) {
            f5Var.v.vibrate = vibrateTimings;
        }
        int[] lightSettings = notificationParams.getLightSettings();
        if (lightSettings != null) {
            int i2 = lightSettings[0];
            int i3 = lightSettings[1];
            int i4 = lightSettings[2];
            Notification notification = f5Var.v;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            if (i3 == 0 || i4 == 0) {
                i = 0;
            }
            notification.flags = (notification.flags & -2) | i;
        }
        f5Var.h(getConsolidatedDefaults(notificationParams));
        return new DisplayNotificationInfo(f5Var, getTag(notificationParams), 0);
    }
}
