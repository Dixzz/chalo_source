package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;

/* renamed from: d92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class d92 {
    @GuardedBy("sCache")

    /* renamed from: a  reason: collision with root package name */
    public static final u2<String, String> f810a = new u2<>();
    @GuardedBy("sCache")
    public static Locale b;

    public static String a(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_title);
        }
        if (i == 2) {
            return resources.getString(R.string.common_google_play_services_update_title);
        }
        if (i == 3) {
            return resources.getString(R.string.common_google_play_services_enable_title);
        }
        if (i == 5) {
            return f(context, "common_google_play_services_invalid_account_title");
        }
        if (i == 7) {
            return f(context, "common_google_play_services_network_error_title");
        }
        if (i == 17) {
            return f(context, "common_google_play_services_sign_in_failed_title");
        }
        if (i != 20) {
            return null;
        }
        return f(context, "common_google_play_services_restricted_profile_title");
    }

    public static String b(Context context, int i) {
        Resources resources = context.getResources();
        String d = d(context);
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, d);
        } else if (i != 2) {
            if (i == 3) {
                return resources.getString(R.string.common_google_play_services_enable_text, d);
            } else if (i == 5) {
                return e(context, "common_google_play_services_invalid_account_text", d);
            } else {
                if (i == 7) {
                    return e(context, "common_google_play_services_network_error_text", d);
                }
                if (i == 9) {
                    return resources.getString(R.string.common_google_play_services_unsupported_text, d);
                } else if (i == 20) {
                    return e(context, "common_google_play_services_restricted_profile_text", d);
                } else {
                    switch (i) {
                        case 16:
                            return e(context, "common_google_play_services_api_unavailable_text", d);
                        case 17:
                            return e(context, "common_google_play_services_sign_in_failed_text", d);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, d);
                        default:
                            return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, d);
                    }
                }
            }
        } else if (gj1.R(context)) {
            return resources.getString(R.string.common_google_play_services_wear_update_text);
        } else {
            return resources.getString(R.string.common_google_play_services_update_text, d);
        }
    }

    public static String c(Context context, int i) {
        Resources resources = context.getResources();
        if (i == 1) {
            return resources.getString(R.string.common_google_play_services_install_button);
        }
        if (i == 2) {
            return resources.getString(R.string.common_google_play_services_update_button);
        }
        if (i != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(R.string.common_google_play_services_enable_button);
    }

    public static String d(Context context) {
        String packageName = context.getPackageName();
        try {
            nb2 a2 = ob2.a(context);
            return a2.f2531a.getPackageManager().getApplicationLabel(a2.f2531a.getPackageManager().getApplicationInfo(packageName, 0)).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String e(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String f = f(context, str);
        if (f == null) {
            f = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, f, str2);
    }

    public static String f(Context context, String str) {
        u2<String, String> u2Var = f810a;
        synchronized (u2Var) {
            Locale c = h.N(context.getResources().getConfiguration()).c(0);
            if (!c.equals(b)) {
                u2Var.clear();
                b = c;
            }
            String orDefault = u2Var.getOrDefault(str, null);
            if (orDefault != null) {
                return orDefault;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                if (str.length() != 0) {
                    "Missing resource: ".concat(str);
                } else {
                    new String("Missing resource: ");
                }
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                if (str.length() != 0) {
                    "Got empty resource: ".concat(str);
                } else {
                    new String("Got empty resource: ");
                }
                return null;
            }
            u2Var.put(str, string);
            return string;
        }
    }
}
