package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;

/* renamed from: r22  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class r22 {

    /* renamed from: a  reason: collision with root package name */
    public static final int f3028a = u22.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final r22 b = new r22();

    @RecentlyNullable
    public Intent a(Context context, int i, String str) {
        if (i == 1 || i == 2) {
            if (context == null || !gj1.R(context)) {
                StringBuilder i0 = hj1.i0("gcore_");
                i0.append(f3028a);
                i0.append("-");
                if (!TextUtils.isEmpty(str)) {
                    i0.append(str);
                }
                i0.append("-");
                if (context != null) {
                    i0.append(context.getPackageName());
                }
                i0.append("-");
                if (context != null) {
                    try {
                        i0.append(ob2.a(context).b(context.getPackageName(), 0).versionCode);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                String sb = i0.toString();
                Uri uri = qa2.f2917a;
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
                if (!TextUtils.isEmpty(sb)) {
                    appendQueryParameter.appendQueryParameter("pcampaignid", sb);
                }
                intent.setData(appendQueryParameter.build());
                intent.setPackage("com.android.vending");
                intent.addFlags(524288);
                return intent;
            }
            Uri uri2 = qa2.f2917a;
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        } else if (i != 3) {
            return null;
        } else {
            Uri uri3 = qa2.f2917a;
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(fromParts);
            return intent3;
        }
    }

    @RecentlyNullable
    public PendingIntent b(@RecentlyNonNull Context context, int i, int i2) {
        Intent a2 = a(context, i, null);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, a2, 134217728);
    }

    public int c(@RecentlyNonNull Context context, int i) {
        int isGooglePlayServicesAvailable = u22.isGooglePlayServicesAvailable(context, i);
        if (u22.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }
}
