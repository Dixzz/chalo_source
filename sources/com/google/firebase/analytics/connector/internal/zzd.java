package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonConstants;
import com.google.firebase.messaging.Constants;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
public final class zzd {
    private static final Set<String> zza = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", FirebaseAnalytics.Event.CAMPAIGN_DETAILS, "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));
    private static final List<String> zzb = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    private static final List<String> zzc = Arrays.asList("auto", SettingsJsonConstants.APP_KEY, "am");
    private static final List<String> zzd = Arrays.asList("_r", "_dbg");
    private static final List<String> zze;
    private static final List<String> zzf = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    static {
        String[][] strArr = {yc4.f4031a, yc4.b};
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            i += strArr[i2].length;
        }
        Object[] copyOf = Arrays.copyOf(strArr[0], i);
        int length = strArr[0].length;
        for (int i3 = 1; i3 < 2; i3++) {
            String[] strArr2 = strArr[i3];
            int length2 = strArr2.length;
            System.arraycopy(strArr2, 0, copyOf, length, length2);
            length += length2;
        }
        zze = Arrays.asList((String[]) copyOf);
    }

    public static AnalyticsConnector.ConditionalUserProperty zza(Bundle bundle) {
        Objects.requireNonNull(bundle, "null reference");
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.origin = (String) hd3.z3(bundle, FirebaseAnalytics.Param.ORIGIN, String.class, null);
        conditionalUserProperty.name = (String) hd3.z3(bundle, "name", String.class, null);
        conditionalUserProperty.value = hd3.z3(bundle, FirebaseAnalytics.Param.VALUE, Object.class, null);
        conditionalUserProperty.triggerEventName = (String) hd3.z3(bundle, "trigger_event_name", String.class, null);
        conditionalUserProperty.triggerTimeout = ((Long) hd3.z3(bundle, "trigger_timeout", Long.class, 0L)).longValue();
        conditionalUserProperty.timedOutEventName = (String) hd3.z3(bundle, "timed_out_event_name", String.class, null);
        conditionalUserProperty.timedOutEventParams = (Bundle) hd3.z3(bundle, "timed_out_event_params", Bundle.class, null);
        conditionalUserProperty.triggeredEventName = (String) hd3.z3(bundle, "triggered_event_name", String.class, null);
        conditionalUserProperty.triggeredEventParams = (Bundle) hd3.z3(bundle, "triggered_event_params", Bundle.class, null);
        conditionalUserProperty.timeToLive = ((Long) hd3.z3(bundle, "time_to_live", Long.class, 0L)).longValue();
        conditionalUserProperty.expiredEventName = (String) hd3.z3(bundle, "expired_event_name", String.class, null);
        conditionalUserProperty.expiredEventParams = (Bundle) hd3.z3(bundle, "expired_event_params", Bundle.class, null);
        conditionalUserProperty.active = ((Boolean) hd3.z3(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
        conditionalUserProperty.creationTimestamp = ((Long) hd3.z3(bundle, "creation_timestamp", Long.class, 0L)).longValue();
        conditionalUserProperty.triggeredTimestamp = ((Long) hd3.z3(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        return conditionalUserProperty;
    }

    public static boolean zzb(String str) {
        return !zza.contains(str);
    }

    public static boolean zzc(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int codePointAt = str.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            return false;
        }
        int length = str.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public static boolean zzd(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int codePointAt = str.codePointAt(0);
        if (!Character.isLetter(codePointAt) && codePointAt != 95) {
            return false;
        }
        int length = str.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public static String zze(String str) {
        String G3 = hd3.G3(str, wc4.c, wc4.f3761a);
        return G3 != null ? G3 : str;
    }

    public static String zzf(String str) {
        String b = wc4.b(str);
        return b != null ? b : str;
    }

    public static Bundle zzb(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.origin;
        if (str != null) {
            bundle.putString(FirebaseAnalytics.Param.ORIGIN, str);
        }
        String str2 = conditionalUserProperty.name;
        if (str2 != null) {
            bundle.putString("name", str2);
        }
        Object obj = conditionalUserProperty.value;
        if (obj != null) {
            hd3.L3(bundle, obj);
        }
        String str3 = conditionalUserProperty.triggerEventName;
        if (str3 != null) {
            bundle.putString("trigger_event_name", str3);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.triggerTimeout);
        String str4 = conditionalUserProperty.timedOutEventName;
        if (str4 != null) {
            bundle.putString("timed_out_event_name", str4);
        }
        Bundle bundle2 = conditionalUserProperty.timedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str5 = conditionalUserProperty.triggeredEventName;
        if (str5 != null) {
            bundle.putString("triggered_event_name", str5);
        }
        Bundle bundle3 = conditionalUserProperty.triggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.timeToLive);
        String str6 = conditionalUserProperty.expiredEventName;
        if (str6 != null) {
            bundle.putString("expired_event_name", str6);
        }
        Bundle bundle4 = conditionalUserProperty.expiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.creationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.active);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.triggeredTimestamp);
        return bundle;
    }

    public static void zzb(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1);
        }
    }

    public static boolean zza(String str) {
        return !zzc.contains(str);
    }

    public static boolean zza(String str, Bundle bundle) {
        if (zzb.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        for (String str2 : zzd) {
            if (bundle.containsKey(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean zza(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals(Constants.ScionAnalytics.ORIGIN_FCM) || str.equals(FirebaseABTesting.OriginService.REMOTE_CONFIG);
        }
        if (Constants.ScionAnalytics.USER_PROPERTY_FIREBASE_LAST_NOTIFICATION.equals(str2)) {
            return str.equals(Constants.ScionAnalytics.ORIGIN_FCM) || str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING);
        }
        if (zze.contains(str2)) {
            return false;
        }
        for (String str3 : zzf) {
            if (str2.matches(str3)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004e A[Catch:{ IOException | ClassNotFoundException -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0053 A[Catch:{ IOException | ClassNotFoundException -> 0x0057 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(com.google.firebase.analytics.connector.AnalyticsConnector.ConditionalUserProperty r7) {
        /*
        // Method dump skipped, instructions count: 181
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.analytics.connector.internal.zzd.zza(com.google.firebase.analytics.connector.AnalyticsConnector$ConditionalUserProperty):boolean");
    }

    public static boolean zza(String str, String str2, Bundle bundle) {
        if (!Constants.ScionAnalytics.EVENT_FIREBASE_CAMPAIGN.equals(str2)) {
            return true;
        }
        if (!zza(str) || bundle == null) {
            return false;
        }
        for (String str3 : zzd) {
            if (bundle.containsKey(str3)) {
                return false;
            }
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 101200:
                if (str.equals(Constants.ScionAnalytics.ORIGIN_FCM)) {
                    c = 0;
                    break;
                }
                break;
            case 101230:
                if (str.equals("fdl")) {
                    c = 1;
                    break;
                }
                break;
            case 3142703:
                if (str.equals(FirebaseABTesting.OriginService.INAPP_MESSAGING)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                bundle.putString("_cis", "fcm_integration");
                return true;
            case 1:
                bundle.putString("_cis", "fdl_integration");
                return true;
            case 2:
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }
}
