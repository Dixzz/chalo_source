package defpackage;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import server.zophop.logging.LoggingConstants;

/* renamed from: u22  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class u22 {
    public static final int GMS_AVAILABILITY_NOTIFICATION_ID = 10436;
    public static final int GMS_GENERAL_ERROR_NOTIFICATION_ID = 39789;
    @RecentlyNonNull
    public static final String GOOGLE_PLAY_GAMES_PACKAGE = "com.google.android.play.games";
    @RecentlyNonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = 12451000;
    @RecentlyNonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    public static final AtomicBoolean sCanceledAvailabilityNotification = new AtomicBoolean();
    public static boolean zza = false;
    private static boolean zzb = false;
    private static final AtomicBoolean zzc = new AtomicBoolean();

    @Deprecated
    public static void cancelAvailabilityErrorNotifications(@RecentlyNonNull Context context) {
        if (!sCanceledAvailabilityNotification.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(GMS_AVAILABILITY_NOTIFICATION_ID);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    public static void enableUsingApkIndependentContext() {
        zzc.set(true);
    }

    @Deprecated
    public static void ensurePlayServicesAvailable(@RecentlyNonNull Context context, int i) throws t22, s22 {
        r22 r22 = r22.b;
        int c = r22.c(context, i);
        if (c != 0) {
            Intent a2 = r22.a(context, c, "e");
            if (a2 == null) {
                throw new s22(c);
            }
            throw new t22(c, "Google Play Services not available", a2);
        }
    }

    @Deprecated
    public static int getApkVersion(@RecentlyNonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }

    @Deprecated
    public static int getClientVersion(@RecentlyNonNull Context context) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        gj1.n(true);
        try {
            packageInfo = ob2.a(context).f2531a.getPackageManager().getPackageInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (bundle = applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @RecentlyNullable
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, @RecentlyNonNull Context context, int i2) {
        return r22.b.b(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.n1(i);
    }

    @RecentlyNullable
    @Deprecated
    public static Intent getGooglePlayServicesAvailabilityRecoveryIntent(int i) {
        return r22.b.a(null, i, null);
    }

    @RecentlyNullable
    public static Context getRemoteContext(@RecentlyNonNull Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @RecentlyNullable
    public static Resources getRemoteResource(@RecentlyNonNull Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean honorsDebugCertificates(@RecentlyNonNull Context context) {
        if (!zza) {
            try {
                PackageInfo packageInfo = ob2.a(context).f2531a.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                v22.a(context);
                if (packageInfo == null || v22.d(packageInfo, false) || !v22.d(packageInfo, true)) {
                    zzb = false;
                } else {
                    zzb = true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            } finally {
                zza = true;
            }
        }
        return zzb || !LoggingConstants.USER.equals(Build.TYPE);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(@RecentlyNonNull Context context) {
        return isGooglePlayServicesAvailable(context, GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    @Deprecated
    public static boolean isGooglePlayServicesUid(@RecentlyNonNull Context context, int i) {
        return gj1.O(context, i);
    }

    @Deprecated
    public static boolean isPlayServicesPossiblyUpdating(@RecentlyNonNull Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zza(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean isPlayStorePossiblyUpdating(@RecentlyNonNull Context context, int i) {
        if (i == 9) {
            return zza(context, "com.android.vending");
        }
        return false;
    }

    @TargetApi(18)
    public static boolean isRestrictedUserProfile(@RecentlyNonNull Context context) {
        Object systemService = context.getSystemService(LoggingConstants.USER);
        Objects.requireNonNull(systemService, "null reference");
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @Deprecated
    public static boolean isSidewinderDevice(@RecentlyNonNull Context context) {
        return gj1.g1(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return i == 1 || i == 2 || i == 3 || i == 9;
    }

    @TargetApi(19)
    @Deprecated
    public static boolean uidHasPackageName(@RecentlyNonNull Context context, int i, @RecentlyNonNull String str) {
        return gj1.q0(context, i, str);
    }

    @TargetApi(21)
    public static boolean zza(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        try {
            for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(sessionInfo.getAppPackageName())) {
                    return true;
                }
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (!applicationInfo.enabled || isRestrictedUserProfile(context)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b0  */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int isGooglePlayServicesAvailable(@androidx.annotation.RecentlyNonNull android.content.Context r8, int r9) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u22.isGooglePlayServicesAvailable(android.content.Context, int):int");
    }
}
