package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.razorpay.AnalyticsConstants;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

/* renamed from: j06  reason: default package */
/* compiled from: CommonUtils */
public class j06 {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f1860a;
    public static final char[] b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static long c = -1;
    public static final Comparator<File> d = new a();

    /* renamed from: j06$a */
    /* compiled from: CommonUtils */
    public static class a implements Comparator<File>, j$.util.Comparator {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // j$.util.Comparator, java.util.Comparator
        public int compare(File file, File file2) {
            return (int) (file.lastModified() - file2.lastModified());
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator<File> reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        /* Return type fixed from 'java.util.Comparator' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Comparator] */
        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator<File> thenComparing(java.util.Comparator<? super File> comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    public static boolean a(Context context) {
        if (!(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0)) {
            return true;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static long b(String str, String str2, int i) {
        return Long.parseLong(str.split(str2)[0].trim()) * ((long) i);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:18|19|(1:21)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0 = "Error parsing " + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r0 != null) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004d, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        r5 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0052, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x003b */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0055 A[SYNTHETIC, Splitter:B:25:0x0055] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String c(java.io.File r5, java.lang.String r6) {
        /*
            boolean r0 = r5.exists()
            r1 = 0
            if (r0 == 0) goto L_0x0059
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            java.io.FileReader r2 = new java.io.FileReader     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r2.<init>(r5)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r3 = 1024(0x400, float:1.435E-42)
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
        L_0x0013:
            java.lang.String r2 = r0.readLine()     // Catch:{ Exception -> 0x003b }
            if (r2 == 0) goto L_0x0034
            java.lang.String r3 = "\\s*:\\s*"
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3)     // Catch:{ Exception -> 0x003b }
            r4 = 2
            java.lang.String[] r2 = r3.split(r2, r4)     // Catch:{ Exception -> 0x003b }
            int r3 = r2.length     // Catch:{ Exception -> 0x003b }
            r4 = 1
            if (r3 <= r4) goto L_0x0013
            r3 = 0
            r3 = r2[r3]     // Catch:{ Exception -> 0x003b }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x003b }
            if (r3 == 0) goto L_0x0013
            r5 = r2[r4]     // Catch:{ Exception -> 0x003b }
            r1 = r5
        L_0x0034:
            r0.close()     // Catch:{ IOException -> 0x0059 }
            goto L_0x0059
        L_0x0038:
            r5 = move-exception
            goto L_0x0053
        L_0x003a:
            r0 = r1
        L_0x003b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r6.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "Error parsing "
            r6.append(r2)     // Catch:{ all -> 0x0051 }
            r6.append(r5)     // Catch:{ all -> 0x0051 }
            r6.toString()     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0059
            r0.close()
            goto L_0x0059
        L_0x0051:
            r5 = move-exception
            r1 = r0
        L_0x0053:
            if (r1 == 0) goto L_0x0058
            r1.close()     // Catch:{ IOException -> 0x0058 }
        L_0x0058:
            throw r5
        L_0x0059:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.j06.c(java.io.File, java.lang.String):java.lang.String");
    }

    public static Float d(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return null;
        }
        return Float.valueOf(((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
    }

    public static boolean e(Context context, String str, boolean z) {
        Resources resources;
        if (!(context == null || (resources = context.getResources()) == null)) {
            int f = f(context, str, "bool");
            if (f > 0) {
                return resources.getBoolean(f);
            }
            int f2 = f(context, str, "string");
            if (f2 > 0) {
                return Boolean.parseBoolean(context.getString(f2));
            }
        }
        return z;
    }

    public static int f(Context context, String str, String str2) {
        String str3;
        Resources resources = context.getResources();
        int i = context.getApplicationContext().getApplicationInfo().icon;
        if (i > 0) {
            str3 = context.getResources().getResourcePackageName(i);
        } else {
            str3 = context.getPackageName();
        }
        return resources.getIdentifier(str, str2, str3);
    }

    public static String g(Context context, String str) {
        int f = f(context, str, "string");
        return f > 0 ? context.getString(f) : "";
    }

    public static synchronized long h() {
        long j;
        synchronized (j06.class) {
            if (c == -1) {
                long j2 = 0;
                String c2 = c(new File("/proc/meminfo"), "MemTotal");
                if (!TextUtils.isEmpty(c2)) {
                    String upperCase = c2.toUpperCase(Locale.US);
                    try {
                        if (upperCase.endsWith("KB")) {
                            j2 = b(upperCase, "KB", 1024);
                        } else if (upperCase.endsWith("MB")) {
                            j2 = b(upperCase, "MB", CommonUtils.BYTES_IN_A_MEGABYTE);
                        } else if (upperCase.endsWith("GB")) {
                            j2 = b(upperCase, "GB", CommonUtils.BYTES_IN_A_GIGABYTE);
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
                c = j2;
            }
            j = c;
        }
        return j;
    }

    public static boolean i(Context context) {
        if (f1860a == null) {
            f1860a = Boolean.valueOf(e(context, "com.crashlytics.Trace", false));
        }
        return f1860a.booleanValue();
    }

    public static boolean j(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), AnalyticsConstants.ANDROID_ID);
        String str = Build.PRODUCT;
        return AnalyticsConstants.SDK.equals(str) || "google_sdk".equals(str) || string == null;
    }

    public static boolean k(Context context) {
        boolean j = j(context);
        String str = Build.TAGS;
        if ((!j && str != null && str.contains("test-keys")) || new File("/system/app/Superuser.apk").exists()) {
            return true;
        }
        File file = new File("/system/xbin/su");
        if (j || !file.exists()) {
            return false;
        }
        return true;
    }

    public static String l(int i) {
        if (i >= 0) {
            return String.format(Locale.US, "%1$10s", Integer.valueOf(i)).replace(' ', '0');
        }
        throw new IllegalArgumentException("value must be zero or greater");
    }

    public static String m(Context context) {
        int f = f(context, "io.fabric.android.build_id", "string");
        if (f == 0) {
            f = f(context, CommonUtils.LEGACY_MAPPING_FILE_ID_RESOURCE_NAME, "string");
        }
        if (f != 0) {
            return context.getResources().getString(f);
        }
        return null;
    }

    public static String n(InputStream inputStream) throws IOException {
        Scanner useDelimiter = new Scanner(inputStream).useDelimiter("\\A");
        return useDelimiter.hasNext() ? useDelimiter.next() : "";
    }
}
