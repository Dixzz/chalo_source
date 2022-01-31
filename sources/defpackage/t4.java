package defpackage;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.Arrays;

/* renamed from: t4  reason: default package */
/* compiled from: ActivityCompat */
public class t4 extends q5 {
    public static final /* synthetic */ int c = 0;

    /* renamed from: t4$a */
    /* compiled from: ActivityCompat */
    public class a implements Runnable {
        public final /* synthetic */ String[] f;
        public final /* synthetic */ Activity g;
        public final /* synthetic */ int h;

        public a(String[] strArr, Activity activity, int i) {
            this.f = strArr;
            this.g = activity;
            this.h = i;
        }

        public void run() {
            int[] iArr = new int[this.f.length];
            PackageManager packageManager = this.g.getPackageManager();
            String packageName = this.g.getPackageName();
            int length = this.f.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f[i], packageName);
            }
            ((b) this.g).onRequestPermissionsResult(this.h, this.f, iArr);
        }
    }

    /* renamed from: t4$b */
    /* compiled from: ActivityCompat */
    public interface b {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: t4$c */
    /* compiled from: ActivityCompat */
    public interface c {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void c(Activity activity, String[] strArr, int i) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException(hj1.a0(hj1.i0("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof c) {
                ((c) activity).validateRequestPermissionsRequestCode(i);
            }
            activity.requestPermissions(strArr, i);
        } else if (activity instanceof b) {
            new Handler(Looper.getMainLooper()).post(new a(strArr, activity, i));
        }
    }

    public static boolean d(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }
}
