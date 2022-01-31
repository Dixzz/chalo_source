package com.freshchat.consumer.sdk.j;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.exception.PermissionNotGrantedException;
import java.util.ArrayList;

public class am {
    public static String[] iE = {"android.permission.RECORD_AUDIO", "android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final String[] iF = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"};
    private static final String[] iG = new String[0];

    public static boolean a(Context context, String[] strArr) {
        for (String str : strArr) {
            if (!n(context, str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void aT(Context context) {
        if (context != null) {
            String[] strArr = iF;
            for (String str : strArr) {
                if (!n(context, str)) {
                    throw new PermissionNotGrantedException(str);
                }
            }
            if (!aw.fa()) {
                String[] strArr2 = iG;
                for (String str2 : strArr2) {
                    if (!n(context, str2) && (!"android.permission.RECORD_AUDIO".equals(str2) || e.i(context).bn())) {
                        throw new PermissionNotGrantedException(str2);
                    }
                }
            }
        }
    }

    public static boolean aU(Context context) {
        return n(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean aV(Context context) {
        return true;
    }

    public static final boolean aW(Context context) {
        String[] strArr;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(g.ab(context), 4096);
            if (!(packageInfo == null || (strArr = packageInfo.requestedPermissions) == null)) {
                for (String str : strArr) {
                    if ("android.permission.CAMERA".equalsIgnoreCase(str)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static final boolean aX(Context context) {
        if (aW(context)) {
            return n(context, "android.permission.CAMERA");
        }
        return true;
    }

    public static String[] b(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!n(context, str)) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @TargetApi(23)
    public static boolean n(Context context, String str) {
        if (context == null) {
            return false;
        }
        return aw.fa() ? context.checkSelfPermission(str) == 0 : context.checkCallingOrSelfPermission(str) == 0;
    }
}
