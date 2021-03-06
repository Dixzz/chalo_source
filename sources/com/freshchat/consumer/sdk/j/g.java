package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.graphics.drawable.Drawable;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.b;
import com.freshchat.consumer.sdk.b.c;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.b.i;

public class g {
    public static int P(Context context) {
        if (context != null) {
            return context.getApplicationInfo().icon;
        }
        throw new IllegalArgumentException("getApplicationIconResId() requires a valid context");
    }

    public static Drawable Q(Context context) {
        if (context != null) {
            try {
                return ac(context).getApplicationIcon(context.getPackageName());
            } catch (PackageManager.NameNotFoundException e) {
                q.a(e);
                return null;
            }
        } else {
            throw new IllegalArgumentException("getApplicationIcon() requires a valid context");
        }
    }

    public static String ab(Context context) {
        if (context != null) {
            return context.getApplicationInfo().packageName;
        }
        throw new IllegalArgumentException("getPackageName() requires a valid context");
    }

    private static PackageManager ac(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager();
            } catch (Exception e) {
                q.a(e);
                return null;
            }
        } else {
            throw new IllegalArgumentException("getPackageManager() requires a valid context");
        }
    }

    private static PackageInfo ad(Context context) {
        return c(context, 0);
    }

    public static String ae(Context context) {
        if (context != null) {
            try {
                PackageInfo ad = ad(context);
                return ad != null ? ad.versionName : "unknown";
            } catch (Exception e) {
                q.a(e);
                return "unknown";
            }
        } else {
            throw new IllegalArgumentException("getAppVersionName() requires a valid context");
        }
    }

    public static int af(Context context) {
        if (context != null) {
            try {
                PackageInfo ad = ad(context);
                if (ad != null) {
                    return ad.versionCode;
                }
                return -1;
            } catch (Exception e) {
                q.a(e);
                return -1;
            }
        } else {
            throw new IllegalArgumentException("getAppVersionCode() requires a valid context");
        }
    }

    public static boolean ag(Context context) {
        try {
            String bm = e.i(context).bm();
            return as.isEmpty(bm) || af(context) > Integer.valueOf(bm).intValue();
        } catch (Exception e) {
            q.a(e);
            return false;
        }
    }

    public static int ah(Context context) {
        ApplicationInfo applicationInfo;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null || as.isEmpty(ab(context)) || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null) {
                    return -1;
                }
                return applicationInfo.targetSdkVersion;
            } catch (Exception e) {
                q.a(e);
                return -1;
            }
        } else {
            throw new IllegalArgumentException("getTargetSdkVersion() requires a valid context");
        }
    }

    public static String aj(Context context) {
        return context.getString(R.string.freshchat_file_provider_authority);
    }

    public static void ak(Context context) {
        if (am(context) && !al(context)) {
            i.a(context.getApplicationContext(), c.PICTURE_ATTACHMENT_MISSING_FILE_PROVIDER);
        }
    }

    public static boolean al(Context context) {
        String aj = aj(context);
        return m(context, aj) && i(context, aj);
    }

    public static boolean am(Context context) {
        return ah(context) > 23;
    }

    public static boolean an(Context context) {
        return ah(context) >= 26;
    }

    public static boolean ao(Context context) {
        return ah(context) <= 25;
    }

    private static PackageInfo c(Context context, int i) {
        if (context != null) {
            try {
                PackageManager ac = ac(context);
                if (ac == null) {
                    return null;
                }
                String ab = ab(context);
                if (as.isEmpty(ab)) {
                    return null;
                }
                return ac.getPackageInfo(ab, i);
            } catch (PackageManager.NameNotFoundException e) {
                q.a(e);
                return null;
            }
        } else {
            throw new IllegalArgumentException("getPackageInfo() requires a valid context");
        }
    }

    public static String getAppName(Context context) {
        try {
            return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean i(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (!as.isEmpty(str)) {
                if (packageManager != null) {
                    ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 128);
                    return resolveContentProvider != null && resolveContentProvider.enabled && resolveContentProvider.grantUriPermissions;
                }
            }
            return false;
        } catch (Exception e) {
            q.a(e);
            return false;
        }
    }

    public static boolean m(Context context, String str) {
        boolean a2 = as.a(str);
        try {
            String ab = ab(context);
            String[] strArr = b.dc;
            for (String str2 : strArr) {
                if (str.startsWith(str2) && !ab.startsWith(str2)) {
                    return false;
                }
            }
        } catch (Exception e) {
            q.a(e);
        }
        return a2;
    }
}
