package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.TypedValue;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Objects;

/* renamed from: q22  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public class q22 extends r22 {
    public static final Object c = new Object();
    public static final q22 d = new q22();

    @Override // defpackage.r22
    @RecentlyNullable
    public Intent a(Context context, int i, String str) {
        return super.a(context, i, str);
    }

    @Override // defpackage.r22
    @RecentlyNullable
    public PendingIntent b(@RecentlyNonNull Context context, int i, int i2) {
        Intent a2 = a(context, i, null);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, a2, 134217728);
    }

    @Override // defpackage.r22
    public int c(@RecentlyNonNull Context context, int i) {
        return super.c(context, i);
    }

    @RecentlyNullable
    public Dialog d(@RecentlyNonNull Activity activity, int i, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return j(activity, i, new e92(super.a(activity, i, "d"), activity, i2), onCancelListener);
    }

    public int e(@RecentlyNonNull Context context) {
        return c(context, r22.f3028a);
    }

    public void f(@RecentlyNonNull Context context, int i) {
        PendingIntent pendingIntent;
        Intent a2 = super.a(context, i, "n");
        if (a2 == null) {
            pendingIntent = null;
        } else {
            pendingIntent = PendingIntent.getActivity(context, 0, a2, 134217728);
        }
        h(context, i, null, pendingIntent);
    }

    public final boolean g(@RecentlyNonNull Activity activity, @RecentlyNonNull s32 s32, int i, DialogInterface.OnCancelListener onCancelListener) {
        Dialog j = j(activity, i, new g92(super.a(activity, i, "d"), s32), onCancelListener);
        if (j == null) {
            return false;
        }
        k(activity, j, GooglePlayServicesUtil.GMS_ERROR_DIALOG, onCancelListener);
        return true;
    }

    @TargetApi(20)
    public final void h(Context context, int i, String str, PendingIntent pendingIntent) {
        String str2;
        String str3;
        int i2;
        String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", Integer.valueOf(i), null);
        new IllegalArgumentException();
        if (i == 18) {
            new pb2(this, context).sendEmptyMessageDelayed(1, 120000);
        } else if (pendingIntent != null) {
            if (i == 6) {
                str2 = d92.f(context, "common_google_play_services_resolution_required_title");
            } else {
                str2 = d92.a(context, i);
            }
            if (str2 == null) {
                str2 = context.getResources().getString(R.string.common_google_play_services_notification_ticker);
            }
            if (i == 6 || i == 19) {
                str3 = d92.e(context, "common_google_play_services_resolution_required_text", d92.d(context));
            } else {
                str3 = d92.b(context, i);
            }
            Resources resources = context.getResources();
            Object systemService = context.getSystemService("notification");
            Objects.requireNonNull(systemService, "null reference");
            NotificationManager notificationManager = (NotificationManager) systemService;
            f5 f5Var = new f5(context, null);
            f5Var.n = true;
            f5Var.i(16, true);
            f5Var.g(str2);
            e5 e5Var = new e5();
            e5Var.d(str3);
            f5Var.l(e5Var);
            if (gj1.Q(context)) {
                gj1.n(true);
                f5Var.v.icon = context.getApplicationInfo().icon;
                f5Var.j = 2;
                if (gj1.R(context)) {
                    f5Var.a(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), pendingIntent);
                } else {
                    f5Var.g = pendingIntent;
                }
            } else {
                f5Var.v.icon = 17301642;
                f5Var.n(resources.getString(R.string.common_google_play_services_notification_ticker));
                f5Var.v.when = System.currentTimeMillis();
                f5Var.g = pendingIntent;
                f5Var.f(str3);
            }
            if (gj1.N()) {
                gj1.n(gj1.N());
                synchronized (c) {
                }
                NotificationChannel notificationChannel = notificationManager.getNotificationChannel("com.google.android.gms.availability");
                u2<String, String> u2Var = d92.f810a;
                String string = context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
                if (notificationChannel == null) {
                    notificationManager.createNotificationChannel(new NotificationChannel("com.google.android.gms.availability", string, 4));
                } else if (!string.contentEquals(notificationChannel.getName())) {
                    notificationChannel.setName(string);
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                f5Var.t = "com.google.android.gms.availability";
            }
            Notification b = f5Var.b();
            if (i == 1 || i == 2 || i == 3) {
                u22.sCanceledAvailabilityNotification.set(false);
                i2 = u22.GMS_AVAILABILITY_NOTIFICATION_ID;
            } else {
                i2 = u22.GMS_GENERAL_ERROR_NOTIFICATION_ID;
            }
            notificationManager.notify(i2, b);
        }
    }

    public final v52 i(Context context, u52 u52) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        v52 v52 = new v52(u52);
        context.registerReceiver(v52, intentFilter);
        v52.f3602a = context;
        if (u22.zza(context, "com.google.android.gms")) {
            return v52;
        }
        u52.a();
        v52.a();
        return null;
    }

    public final Dialog j(Context context, int i, h92 h92, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(d92.b(context, i));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String c2 = d92.c(context, i);
        if (c2 != null) {
            builder.setPositiveButton(c2, h92);
        }
        String a2 = d92.a(context, i);
        if (a2 != null) {
            builder.setTitle(a2);
        }
        String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", Integer.valueOf(i));
        new IllegalArgumentException();
        return builder.create();
    }

    public final void k(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof ve) {
                FragmentManager supportFragmentManager = ((ve) activity).getSupportFragmentManager();
                w22 w22 = new w22();
                gj1.l(dialog, "Cannot display null dialog");
                dialog.setOnCancelListener(null);
                dialog.setOnDismissListener(null);
                w22.f = dialog;
                if (onCancelListener != null) {
                    w22.g = onCancelListener;
                }
                w22.show(supportFragmentManager, str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        android.app.FragmentManager fragmentManager = activity.getFragmentManager();
        p22 p22 = new p22();
        gj1.l(dialog, "Cannot display null dialog");
        dialog.setOnCancelListener(null);
        dialog.setOnDismissListener(null);
        p22.f = dialog;
        if (onCancelListener != null) {
            p22.g = onCancelListener;
        }
        p22.show(fragmentManager, str);
    }
}
