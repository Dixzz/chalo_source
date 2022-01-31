package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import java.io.File;

/* renamed from: q5  reason: default package */
/* compiled from: ContextCompat */
public class q5 {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f2896a = new Object();
    public static final Object b = new Object();

    /* renamed from: q5$a */
    /* compiled from: ContextCompat */
    public static class a {
        public static void a(Context context, Intent[] intentArr, Bundle bundle) {
            context.startActivities(intentArr, bundle);
        }

        public static void b(Context context, Intent intent, Bundle bundle) {
            context.startActivity(intent, bundle);
        }
    }

    /* renamed from: q5$b */
    /* compiled from: ContextCompat */
    public static class b {
        public static File[] a(Context context) {
            return context.getExternalCacheDirs();
        }

        public static File[] b(Context context, String str) {
            return context.getExternalFilesDirs(str);
        }

        public static File[] c(Context context) {
            return context.getObbDirs();
        }
    }

    /* renamed from: q5$c */
    /* compiled from: ContextCompat */
    public static class c {
        public static File a(Context context) {
            return context.getCodeCacheDir();
        }

        public static Drawable b(Context context, int i) {
            return context.getDrawable(i);
        }

        public static File c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* renamed from: q5$d */
    /* compiled from: ContextCompat */
    public static class d {
        public static int a(Context context, int i) {
            return context.getColor(i);
        }

        public static ColorStateList b(Context context, int i) {
            return context.getColorStateList(i);
        }

        public static <T> T c(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        public static String d(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    /* renamed from: q5$e */
    /* compiled from: ContextCompat */
    public static class e {
        public static Context a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        public static File b(Context context) {
            return context.getDataDir();
        }

        public static boolean c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    /* renamed from: q5$f */
    /* compiled from: ContextCompat */
    public static class f {
        public static ComponentName a(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    public static int a(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static int b(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            return d.a(context, i);
        }
        return context.getResources().getColor(i);
    }
}
