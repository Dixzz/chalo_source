package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.fragment.app.Fragment;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class GooglePlayServicesUtil extends u22 {
    @RecentlyNonNull
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @RecentlyNonNull
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = u22.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    @RecentlyNonNull
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @RecentlyNullable
    @Deprecated
    public static Dialog getErrorDialog(int i, @RecentlyNonNull Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, null);
    }

    @RecentlyNonNull
    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, @RecentlyNonNull Context context, int i2) {
        return u22.getErrorPendingIntent(i, context, i2);
    }

    @RecentlyNonNull
    @Deprecated
    public static String getErrorString(int i) {
        return u22.getErrorString(i);
    }

    @RecentlyNonNull
    public static Context getRemoteContext(@RecentlyNonNull Context context) {
        return u22.getRemoteContext(context);
    }

    @RecentlyNonNull
    public static Resources getRemoteResource(@RecentlyNonNull Context context) {
        return u22.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(@RecentlyNonNull Context context) {
        return u22.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return u22.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, @RecentlyNonNull Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, null);
    }

    @Deprecated
    public static void showErrorNotification(int i, @RecentlyNonNull Context context) {
        Object obj = q22.c;
        q22 q22 = q22.d;
        if (u22.isPlayServicesPossiblyUpdating(context, i) || u22.isPlayStorePossiblyUpdating(context, i)) {
            new pb2(q22, context).sendEmptyMessageDelayed(1, 120000);
        } else {
            q22.f(context, i);
        }
    }

    @RecentlyNullable
    @Deprecated
    public static Dialog getErrorDialog(int i, @RecentlyNonNull Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (true == u22.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        Object obj = q22.c;
        return q22.d.d(activity, i, i2, onCancelListener);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(@RecentlyNonNull Context context, int i) {
        return u22.isGooglePlayServicesAvailable(context, i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, @RecentlyNonNull Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, @RecentlyNonNull Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        if (true == u22.isPlayServicesPossiblyUpdating(activity, i)) {
            i = 18;
        }
        Object obj = q22.c;
        q22 q22 = q22.d;
        if (fragment == null) {
            Dialog d = q22.d(activity, i, i2, onCancelListener);
            if (d == null) {
                return false;
            }
            q22.k(activity, d, GMS_ERROR_DIALOG, onCancelListener);
            return true;
        }
        Dialog j = q22.j(activity, i, new f92(q22.a(activity, i, "d"), fragment, i2), onCancelListener);
        if (j == null) {
            return false;
        }
        q22.k(activity, j, GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }
}
