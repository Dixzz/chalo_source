package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.telephony.TelephonyManager;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.RecentlyNonNull;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.TintTypedArray;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.amazon.device.messaging.ADM;
import com.crashlytics.android.core.CrashlyticsPinningInfoProvider;
import com.google.android.gms.common.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.RemoteMessage;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.StringRpcServer;
import com.razorpay.AnalyticsConstants;
import com.theartofdev.edmodo.cropper.CropImage$ActivityResult;
import com.truecaller.android.sdk.TrueException;
import com.urbanairship.Autopilot;
import com.urbanairship.UAirship;
import com.urbanairship.automation.ScheduleDelay;
import com.urbanairship.automation.Trigger;
import com.urbanairship.json.JsonValue;
import com.urbanairship.push.PushMessage;
import com.urbanairship.push.fcm.FcmPushProvider;
import defpackage.ci6;
import defpackage.cw5;
import defpackage.dw5;
import defpackage.ei6;
import defpackage.hi6;
import defpackage.ho4;
import defpackage.il3;
import defpackage.jl3;
import defpackage.kl3;
import defpackage.l66;
import defpackage.m36;
import defpackage.m66;
import defpackage.n56;
import defpackage.pl4;
import defpackage.q05;
import defpackage.qk5;
import defpackage.rc6;
import defpackage.rt5;
import defpackage.s05;
import defpackage.zt5;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.security.KeyManagementException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* renamed from: hd3  reason: default package */
public final class hd3 {

    /* renamed from: a  reason: collision with root package name */
    public static k44 f1360a;
    public static hh4 b;
    public static hr4 c;
    public static WeakReference<ViewGroup> d;
    public static Boolean e;
    public static jx5 f;
    public static int[] g;
    public static int h;
    public static int i;

    @Deprecated
    public static <TResult> yi4<TResult> A(@RecentlyNonNull Executor executor, @RecentlyNonNull Callable<TResult> callable) {
        gj1.l(executor, "Executor must not be null");
        gj1.l(callable, "Callback must not be null");
        wj4 wj4 = new wj4();
        executor.execute(new xj4(wj4, callable));
        return wj4;
    }

    public static int A0(int i2, byte[] bArr, int i3, int i4, s05.j<?> jVar, vz4 vz4) {
        r05 r05 = (r05) jVar;
        int z0 = z0(bArr, i3, vz4);
        r05.d(vz4.f3697a);
        while (z0 < i4) {
            int z02 = z0(bArr, z0, vz4);
            if (i2 != vz4.f3697a) {
                break;
            }
            z0 = z0(bArr, z02, vz4);
            r05.d(vz4.f3697a);
        }
        return z0;
    }

    public static boolean A1(int i2) {
        return i2 / 100 == 2;
    }

    public static int A2() throws e56 {
        int i2 = i;
        if (i2 < h) {
            int i3 = g[i2] & Constants.MAX_HOST_LENGTH;
            i = i2 + 1;
            if ((i3 & 192) == 128) {
                return i3 & 63;
            }
            throw new e56("Invalid continuation byte");
        }
        throw new e56("Invalid byte index");
    }

    public static <V> V A3(rf3<V> rf3) {
        long clearCallingIdentity;
        try {
            return rf3.e();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V e2 = rf3.e();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return e2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    public static final String B(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static int B0(byte[] bArr, int i2, vz4 vz4) {
        int i3 = i2 + 1;
        long j = (long) bArr[i2];
        if (j >= 0) {
            vz4.b = j;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            i5 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i5;
            b2 = b3;
            i4 = i6;
        }
        vz4.b = j2;
        return i4;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: k66<? super T> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> k66<T> B1(k66<? super T> k66) {
        k66<T> k662;
        n86.e(k66, "$this$intercepted");
        w66 w66 = !(k66 instanceof w66) ? null : k66;
        return (w66 == null || (k662 = (k66<T>) w66.intercepted()) == null) ? k66 : k662;
    }

    public static final <T> Object B2(Object obj, k66<? super T> k66) {
        return obj instanceof eb6 ? Z(((eb6) obj).f955a) : obj;
    }

    public static <V> V B3(as3<V> as3) {
        long clearCallingIdentity;
        try {
            return as3.zza();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zza = as3.zza();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zza;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    public static void C(mb6 mb6, CancellationException cancellationException, int i2) {
        int i3 = i2 & 1;
        m66 m66 = ((LifecycleCoroutineScopeImpl) mb6).g;
        int i4 = rc6.e;
        rc6 rc6 = (rc6) m66.get(rc6.a.f);
        if (rc6 != null) {
            rc6.c(null);
            return;
        }
        throw new IllegalStateException(n86.j("Scope cannot be cancelled because it does not have a job: ", mb6).toString());
    }

    public static final Object C0(long j, k66<? super s56> k66) {
        s56 s56 = s56.f3190a;
        if (j <= 0) {
            return s56;
        }
        sa6 sa6 = new sa6(B1(k66), 1);
        sa6.v();
        if (j < Long.MAX_VALUE) {
            m66 m66 = sa6.j;
            int i2 = l66.c;
            m66.a aVar = m66.get(l66.a.f);
            tb6 tb6 = aVar instanceof tb6 ? (tb6) aVar : null;
            if (tb6 == null) {
                tb6 = qb6.f2926a;
            }
            tb6.g(j, sa6);
        }
        Object u = sa6.u();
        p66 p66 = p66.COROUTINE_SUSPENDED;
        if (u == p66) {
            n86.e(k66, "frame");
        }
        return u == p66 ? u : s56;
    }

    public static final boolean C1(mb6 mb6) {
        m66 n = mb6.n();
        int i2 = rc6.e;
        rc6 rc6 = (rc6) n.get(rc6.a.f);
        if (rc6 == null) {
            return true;
        }
        return rc6.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01cd, code lost:
        if (((java.lang.Integer) r4).intValue() == 0) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01de, code lost:
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L_0x0224;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01f0, code lost:
        if (((java.lang.Double) r4).doubleValue() == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) goto L_0x0224;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void C2(defpackage.j15 r13, java.lang.StringBuilder r14, int r15) {
        /*
        // Method dump skipped, instructions count: 662
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hd3.C2(j15, java.lang.StringBuilder, int):void");
    }

    public static <TResult> TResult C3(yi4<TResult> yi4) throws ExecutionException {
        if (yi4.q()) {
            return yi4.m();
        }
        if (yi4.o()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(yi4.l());
    }

    public static void D(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean D0(File file) {
        if (!file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            return file.delete();
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (!D0(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static final boolean D1(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static String D2(String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (i3 < i2) {
            sb.append(str);
            i3++;
            if (i3 != i2) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static String D3(Context context, String str) {
        try {
            Objects.requireNonNull(context, "null reference");
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier(str, "string", resources.getResourcePackageName(R.string.common_google_play_services_unknown_issue));
            if (identifier == 0) {
                return null;
            }
            return resources.getString(identifier);
        } catch (Resources.NotFoundException unused) {
        }
    }

    public static void E(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    public static final void E0(Activity activity) {
        WeakReference<ViewGroup> weakReference;
        ViewGroup viewGroup;
        n86.e(activity, "activity");
        View findViewById = activity.findViewById(com.truecaller.android.sdk.R.id.textDisclaimerContainer);
        if (findViewById != null && (weakReference = d) != null && (viewGroup = weakReference.get()) != null) {
            viewGroup.removeView(findViewById);
        }
    }

    public static boolean E1() {
        ConnectivityManager connectivityManager = (ConnectivityManager) UAirship.d().getSystemService("connectivity");
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        }
        yj5.c("Error fetching network info.", new Object[0]);
        return false;
    }

    public static TypedValue E2(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static String E3(qt3 qt3) {
        bx3 bx3 = new bx3(qt3);
        StringBuilder sb = new StringBuilder(qt3.d());
        for (int i2 = 0; i2 < bx3.f487a.d(); i2++) {
            byte b2 = bx3.f487a.b(i2);
            if (b2 == 34) {
                sb.append("\\\"");
            } else if (b2 == 39) {
                sb.append("\\'");
            } else if (b2 != 92) {
                switch (b2) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (b2 < 32 || b2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((b2 >>> 6) & 3) + 48));
                            sb.append((char) (((b2 >>> 3) & 7) + 48));
                            sb.append((char) ((b2 & 7) + 48));
                            break;
                        } else {
                            sb.append((char) b2);
                            continue;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static final int F(int i2) {
        if (2 <= i2 && 36 >= i2) {
            return i2;
        }
        StringBuilder j0 = hj1.j0("radix ", i2, " was not in valid range ");
        j0.append(new k96(2, 36));
        throw new IllegalArgumentException(j0.toString());
    }

    public static float F0(float f2, float f3, float f4, float f5) {
        return (float) Math.hypot((double) (f4 - f2), (double) (f5 - f3));
    }

    public static boolean F1(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean F2(Context context, int i2, boolean z) {
        TypedValue E2 = E2(context, i2);
        if (E2 == null || E2.type != 18) {
            return z;
        }
        return E2.data != 0;
    }

    public static final String F3(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static boolean G(int i2, boolean z) throws e56 {
        if (i2 < 55296 || i2 > 57343) {
            return true;
        }
        if (!z) {
            return false;
        }
        StringBuilder i0 = hj1.i0("Lone surrogate U+");
        i0.append(Integer.toHexString(i2).toUpperCase());
        i0.append(" is not a scalar value");
        throw new e56(i0.toString());
    }

    public static float G0(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return (float) Math.sqrt((double) ((f7 * f7) + (f6 * f6)));
    }

    public static boolean G1(String str) {
        return str == null || str.length() == 0;
    }

    public static int G2(Context context, int i2, String str) {
        TypedValue E2 = E2(context, i2);
        if (E2 != null) {
            return E2.data;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    public static String G3(String str, String[] strArr, String[] strArr2) {
        int min = Math.min(strArr.length, strArr2.length);
        for (int i2 = 0; i2 < min; i2++) {
            String str2 = strArr[i2];
            if ((str == null && str2 == null) ? true : str == null ? false : str.equals(str2)) {
                return strArr2[i2];
            }
        }
        return null;
    }

    public static final void H(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                l(th, th2);
            }
        }
    }

    public static float H0(int i2, int i3, int i4, int i5) {
        int i6 = i2 - i4;
        int i7 = i3 - i5;
        return (float) Math.sqrt((double) ((i7 * i7) + (i6 * i6)));
    }

    public static boolean H1(Context context) {
        boolean z;
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        try {
            String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
            if (strArr != null && strArr.length > 0) {
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (strArr[i2].equalsIgnoreCase("android.permission.CAMERA")) {
                        z = true;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (!z && context.checkSelfPermission("android.permission.CAMERA") != 0) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        z = false;
        return !z ? false : false;
    }

    public static final <T> void H2(vb6<? super T> vb6, k66<? super T> k66, boolean z) {
        Object i2 = vb6.i();
        Throwable c2 = vb6.c(i2);
        Object Z = c2 != null ? Z(c2) : vb6.e(i2);
        if (z) {
            qf6 qf6 = (qf6) k66;
            k66<T> k662 = qf6.j;
            Object obj = qf6.l;
            m66 context = k662.getContext();
            Object b2 = fg6.b(context, obj);
            od6<?> b3 = b2 != fg6.f1122a ? ib6.b(k662, context, b2) : null;
            try {
                qf6.j.resumeWith(Z);
            } finally {
                if (b3 == null || b3.f0()) {
                    fg6.a(context, b2);
                }
            }
        } else {
            k66.resumeWith(Z);
        }
    }

    public static Set<String> H3(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(hj1.y(hj1.g0(str, 22), "SELECT * FROM ", str, " LIMIT 0"), null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    public static final <T> int I(Iterable<? extends T> iterable, int i2) {
        n86.e(iterable, "$this$collectionSizeOrDefault");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i2;
    }

    public static my5 I0(URL url, File file) throws IOException {
        URLConnection uRLConnection;
        Throwable th;
        FileOutputStream fileOutputStream;
        Throwable th2;
        URLConnection uRLConnection2;
        InputStream inputStream;
        IOException e2;
        IOException e3;
        int i2;
        yj5.h("Downloading file from: %s to: %s", url, file.getAbsolutePath());
        InputStream inputStream2 = null;
        try {
            uRLConnection2 = jy5.a(UAirship.d(), url);
            try {
                uRLConnection2.setConnectTimeout(Constants.MAX_URL_LENGTH);
                uRLConnection2.setUseCaches(true);
                if (uRLConnection2 instanceof HttpURLConnection) {
                    i2 = ((HttpURLConnection) uRLConnection2).getResponseCode();
                    if (!A1(i2)) {
                        my5 my5 = new my5(false, i2);
                        O0(uRLConnection2, null, null);
                        return my5;
                    }
                } else {
                    i2 = 0;
                }
                inputStream = uRLConnection2.getInputStream();
                if (inputStream != null) {
                    try {
                        fileOutputStream = new FileOutputStream(file);
                    } catch (IOException e4) {
                        e3 = e4;
                        fileOutputStream = null;
                        e2 = e3;
                        try {
                            file.delete();
                            throw e2;
                        } catch (Throwable th3) {
                            th2 = th3;
                            th = th2;
                            uRLConnection = uRLConnection2;
                            inputStream2 = inputStream;
                            O0(uRLConnection, inputStream2, fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th2 = th4;
                        fileOutputStream = null;
                        th = th2;
                        uRLConnection = uRLConnection2;
                        inputStream2 = inputStream;
                        O0(uRLConnection, inputStream2, fileOutputStream);
                        throw th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileOutputStream.close();
                                inputStream.close();
                                my5 my52 = new my5(true, i2);
                                O0(uRLConnection2, inputStream, fileOutputStream);
                                return my52;
                            }
                        }
                    } catch (IOException e5) {
                        e2 = e5;
                        file.delete();
                        throw e2;
                    }
                } else {
                    my5 my53 = new my5(false, i2);
                    O0(uRLConnection2, inputStream, null);
                    return my53;
                }
            } catch (IOException e6) {
                e3 = e6;
                inputStream = null;
                fileOutputStream = null;
                e2 = e3;
                file.delete();
                throw e2;
            } catch (Throwable th5) {
                th2 = th5;
                inputStream = null;
                fileOutputStream = null;
                th = th2;
                uRLConnection = uRLConnection2;
                inputStream2 = inputStream;
                O0(uRLConnection, inputStream2, fileOutputStream);
                throw th;
            }
        } catch (IOException e7) {
            inputStream = null;
            fileOutputStream = null;
            e2 = e7;
            uRLConnection2 = null;
            file.delete();
            throw e2;
        } catch (Throwable th6) {
            th = th6;
            uRLConnection = null;
            fileOutputStream = null;
            O0(uRLConnection, inputStream2, fileOutputStream);
            throw th;
        }
    }

    public static boolean I1(char c2) {
        return c2 >= 128 && c2 <= 255;
    }

    public static int I2(float f2) {
        return (int) (f2 + (f2 < 0.0f ? -0.5f : 0.5f));
    }

    public static void I3(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws cv3 {
        if (!d4(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !d4(b4) && !d4(b5)) {
                int i3 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i2] = (char) ((i3 >>> 10) + 55232);
                cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
                return;
            }
        }
        throw cv3.e();
    }

    public static int J(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 <= i3) {
            i4 = i3;
            i3 = i4;
        }
        int i5 = 1;
        int i6 = 1;
        while (i2 > i4) {
            i5 *= i2;
            if (i6 <= i3) {
                i5 /= i6;
                i6++;
            }
            i2--;
        }
        while (i6 <= i3) {
            i5 /= i6;
            i6++;
        }
        return i5;
    }

    public static float J0(float f2, Context context) {
        return (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f) * f2;
    }

    public static boolean J1(Context context) {
        return context.getResources().getConfiguration().fontScale >= 1.3f;
    }

    public static void J2(xq5 xq5) {
        if (xq5 != null) {
            K2(xq5.l, null);
        }
    }

    public static void J3(byte b2, byte b3, byte b4, char[] cArr, int i2) throws cv3 {
        if (d4(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || d4(b4)))) {
            throw cv3.e();
        }
        cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static final <T extends Comparable<?>> int K(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return t.compareTo(t2);
    }

    public static float K0(Context context, int i2) {
        return TypedValue.applyDimension(1, (float) i2, context.getResources().getDisplayMetrics());
    }

    public static boolean K1(Context context) {
        return context.getResources().getConfiguration().fontScale >= 2.0f;
    }

    public static void K2(Map<String, JsonValue> map, vk5 vk5) {
        tk5 tk5;
        if (map != null) {
            for (Map.Entry<String, JsonValue> entry : map.entrySet()) {
                String key = entry.getKey();
                if (vk5 == null) {
                    tk5 = tk5.a(key);
                } else {
                    tk5 = tk5.a(key);
                }
                tk5.d(entry.getValue());
                tk5.c(null, null);
            }
        }
    }

    public static void K3(byte b2, byte b3, char[] cArr, int i2) throws cv3 {
        if (b2 < -62 || d4(b3)) {
            throw cv3.e();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static byte[] L(byte[][] bArr) {
        int i2 = 0;
        for (byte[] bArr2 : bArr) {
            i2 += bArr2.length;
        }
        if (bArr.length == 0) {
            return new byte[0];
        }
        if (bArr.length == 1) {
            return bArr[0];
        }
        ByteBuffer allocate = ByteBuffer.allocate(i2);
        for (byte[] bArr3 : bArr) {
            allocate.put(bArr3);
        }
        return allocate.array();
    }

    public static String L0(String str, String str2) {
        return hj1.b0(new StringBuilder(str.length() + 1 + String.valueOf(str2).length()), str, ProductDiscountsObject.KEY_DELIMITER, str2);
    }

    public static int L1(Context context) {
        Object obj = q22.c;
        return q22.d.c(context, r22.f3028a);
    }

    public static void L2(View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof ho4) {
            ho4 ho4 = (ho4) background;
            ho4.b bVar = ho4.f;
            if (bVar.o != f2) {
                bVar.o = f2;
                ho4.y();
            }
        }
    }

    public static void L3(Bundle bundle, Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble(FirebaseAnalytics.Param.VALUE, ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong(FirebaseAnalytics.Param.VALUE, ((Long) obj).longValue());
        } else {
            bundle.putString(FirebaseAnalytics.Param.VALUE, obj.toString());
        }
    }

    public static int M(int i2, int i3, int i4) {
        return i2 > i4 ? i4 : Math.max(i2, i3);
    }

    public static String M0(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(N0(entry.getKey()));
            sb.append("=");
            sb.append(N0(entry.getValue()));
        }
        return sb.toString();
    }

    public static boolean M1(View view) {
        AtomicInteger atomicInteger = r8.f3055a;
        return view.getLayoutDirection() == 1;
    }

    public static final <T> Set<T> M2(T t) {
        Set<T> singleton = Collections.singleton(t);
        n86.d(singleton, "java.util.Collections.singleton(element)");
        return singleton;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e5, code lost:
        if (((java.lang.Boolean) r4).booleanValue() == false) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01f3, code lost:
        if (((java.lang.Integer) r4).intValue() == 0) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0204, code lost:
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0216, code lost:
        if (((java.lang.Double) r4).doubleValue() == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) goto L_0x024a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0250  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void M3(defpackage.gj3 r13, java.lang.StringBuilder r14, int r15) {
        /*
        // Method dump skipped, instructions count: 685
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hd3.M3(gj3, java.lang.StringBuilder, int):void");
    }

    public static final <T> boolean N(T[] tArr, T t) {
        int i2;
        n86.e(tArr, "$this$contains");
        n86.e(tArr, "$this$indexOf");
        if (t != null) {
            int length = tArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                } else if (n86.a(t, tArr[i3])) {
                    i2 = i3;
                    break;
                } else {
                    i3++;
                }
            }
        } else {
            int length2 = tArr.length;
            i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                } else if (tArr[i2] == null) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        i2 = -1;
        if (i2 >= 0) {
            return true;
        }
        return false;
    }

    public static String N0(String str) {
        try {
            return URLEncoder.encode(str, StringRpcServer.STRING_ENCODING).replace("+", "%20").replace("%21", "!").replace("%27", "'").replace("%28", "(").replace("%29", ")").replace("%7E", "~");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean N1(char c2) {
        if (U1(c2) || c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    public static void N2(View view, ho4 ho4) {
        tm4 tm4 = ho4.f.b;
        if (tm4 != null && tm4.f3378a) {
            float f2 = 0.0f;
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                AtomicInteger atomicInteger = r8.f3055a;
                f2 += ((View) parent).getElevation();
            }
            ho4.b bVar = ho4.f;
            if (bVar.n != f2) {
                bVar.n = f2;
                ho4.y();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01e5, code lost:
        if (((java.lang.Boolean) r4).booleanValue() == false) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01f3, code lost:
        if (((java.lang.Integer) r4).intValue() == 0) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0204, code lost:
        if (((java.lang.Float) r4).floatValue() == 0.0f) goto L_0x024a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0216, code lost:
        if (((java.lang.Double) r4).doubleValue() == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) goto L_0x024a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0250  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void N3(defpackage.cw3 r13, java.lang.StringBuilder r14, int r15) {
        /*
        // Method dump skipped, instructions count: 685
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hd3.N3(cw3, java.lang.StringBuilder, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T extends defpackage.mn5> defpackage.ln5<T> O(defpackage.so5 r7) throws defpackage.xt5, java.lang.IllegalArgumentException, java.lang.ClassCastException {
        /*
        // Method dump skipped, instructions count: 266
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hd3.O(so5):ln5");
    }

    public static void O0(URLConnection uRLConnection, Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Exception e2) {
                    yj5.d(e2);
                }
            }
        }
        if (uRLConnection instanceof HttpURLConnection) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnection;
            if (httpURLConnection.getErrorStream() != null) {
                try {
                    httpURLConnection.getErrorStream().close();
                } catch (Exception e3) {
                    yj5.d(e3);
                }
            }
            httpURLConnection.disconnect();
        }
    }

    public static boolean O1(byte b2) {
        return b2 > -65;
    }

    public static final void O2(Field field, Object obj, Object obj2) {
        n86.f(field, "receiver$0");
        n86.f(obj, "obj");
        n86.f(obj2, FirebaseAnalytics.Param.VALUE);
        try {
            field.set(obj, obj2);
        } catch (IllegalAccessException unused) {
        }
    }

    public static void O3(ra4 ra4, SQLiteDatabase sQLiteDatabase) {
        if (ra4 != null) {
            File file = new File(sQLiteDatabase.getPath());
            if (!file.setReadable(false, false)) {
                ra4.i.a("Failed to turn off database read permission");
            }
            if (!file.setWritable(false, false)) {
                ra4.i.a("Failed to turn off database write permission");
            }
            if (!file.setReadable(true, true)) {
                ra4.i.a("Failed to turn on database read permission for owner");
            }
            if (!file.setWritable(true, true)) {
                ra4.i.a("Failed to turn on database write permission for owner");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Monitor must not be null");
    }

    public static so5 P(ln5<?> ln5) {
        wo5 wo5 = new wo5();
        ArrayList arrayList = new ArrayList();
        wo5.b = ln5.f2243a;
        wo5.c = ln5.k;
        wo5.d = ln5.b;
        wo5.h = ln5.e;
        wo5.g = ln5.d;
        wo5.e = ln5.c;
        wo5.f = ln5.h;
        wo5.j = ln5.j;
        wo5.i = ln5.i;
        wo5.u = ln5.l;
        wo5.k = ln5.o;
        wo5.l = ln5.p.b();
        wo5.v = ln5.m;
        wo5.w = ln5.n;
        for (Trigger trigger : ln5.f) {
            arrayList.add(Q(trigger, false, ln5.f2243a));
        }
        ScheduleDelay scheduleDelay = ln5.g;
        if (scheduleDelay != null) {
            wo5.r = scheduleDelay.g;
            wo5.t = scheduleDelay.i;
            wo5.q = scheduleDelay.h;
            wo5.s = scheduleDelay.f;
            for (Trigger trigger2 : scheduleDelay.j) {
                arrayList.add(Q(trigger2, true, ln5.f2243a));
            }
        }
        return new so5(wo5, arrayList);
    }

    public static final boolean P0(char c2, char c3, boolean z) {
        if (c2 == c3) {
            return true;
        }
        if (!z) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c3);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static boolean P1(Context context, Uri uri) {
        boolean z;
        if (Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            return false;
        }
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                openInputStream.close();
            }
            z = false;
        } catch (Exception unused) {
            z = true;
        }
        if (z) {
            return true;
        }
        return false;
    }

    public static boolean P2() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            applicationInfo = UAirship.f().getApplicationInfo(UAirship.g(), 128);
        } catch (Exception unused) {
            applicationInfo = null;
        }
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null || !bundle.getBoolean("com.urbanairship.webview.ENABLE_LOCAL_STORAGE", false)) {
            return false;
        }
        return true;
    }

    public static void P3(ra4 ra4, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        boolean z;
        if (ra4 != null) {
            Cursor cursor = null;
            try {
                cursor = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                z = cursor.moveToFirst();
                cursor.close();
            } catch (SQLiteException e2) {
                ra4.i.c("Error querying for table", str, e2);
                if (cursor != null) {
                    cursor.close();
                }
                z = false;
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
            if (!z) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                Set<String> H3 = H3(sQLiteDatabase, str);
                String[] split = str3.split(",");
                for (String str4 : split) {
                    if (!((HashSet) H3).remove(str4)) {
                        StringBuilder sb = new StringBuilder(str.length() + 35 + String.valueOf(str4).length());
                        sb.append("Table ");
                        sb.append(str);
                        sb.append(" is missing required column: ");
                        sb.append(str4);
                        throw new SQLiteException(sb.toString());
                    }
                }
                if (strArr != null) {
                    for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                        if (!((HashSet) H3).remove(strArr[i2])) {
                            sQLiteDatabase.execSQL(strArr[i2 + 1]);
                        }
                    }
                }
                if (!((HashSet) H3).isEmpty()) {
                    ra4.i.c("Table has extra columns. table, columns", str, TextUtils.join(", ", H3));
                }
            } catch (SQLiteException e3) {
                ra4.f.b("Failed to verify columns on table that was just created", str);
                throw e3;
            }
        } else {
            throw new IllegalArgumentException("Monitor must not be null");
        }
    }

    public static xo5 Q(Trigger trigger, boolean z, String str) {
        xo5 xo5 = new xo5();
        xo5.c = trigger.g;
        xo5.e = z;
        xo5.b = trigger.f;
        xo5.d = trigger.h;
        xo5.g = str;
        return xo5;
    }

    public static boolean Q0(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static boolean Q1() {
        try {
            return new ADM(UAirship.d()).isSupported();
        } catch (RuntimeException unused) {
            yj5.i("Failed to call ADM. Make sure ADM jar is not bundled with the APK.", new Object[0]);
            return false;
        }
    }

    @SuppressLint({"InflateParams"})
    public static final void Q2(Activity activity) {
        Window window;
        ViewGroup viewGroup;
        if (activity != null && (window = activity.getWindow()) != null) {
            WeakReference<ViewGroup> weakReference = new WeakReference<>(window.getDecorView().findViewById(16908290));
            d = weakReference;
            ViewGroup viewGroup2 = weakReference.get();
            if ((viewGroup2 != null ? viewGroup2.findViewById(com.truecaller.android.sdk.R.id.textDisclaimerContainer) : null) == null) {
                LayoutInflater layoutInflater = activity.getLayoutInflater();
                n86.d(layoutInflater, "activity.layoutInflater");
                View inflate = layoutInflater.inflate(com.truecaller.android.sdk.R.layout.truesdk_privacy_policy_dialog, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(com.truecaller.android.sdk.R.id.textDisclaimer);
                String string = activity.getString(com.truecaller.android.sdk.R.string.sdk_disclaimer_text);
                n86.d(string, "activity.getString(R.string.sdk_disclaimer_text)");
                int n = ea6.n(string, "*", 0, false, 6);
                int r = ea6.r(string, "*", 0, false, 6);
                SpannableString spannableString = new SpannableString(ea6.x(string, "*", "", false, 4));
                spannableString.setSpan(new StyleSpan(1), n, r - 1, 0);
                n86.d(textView, "text");
                textView.setText(spannableString);
                ((ImageView) inflate.findViewById(com.truecaller.android.sdk.R.id.buttonDismiss)).setOnClickListener(new e(0, activity));
                textView.setOnClickListener(new e(1, activity));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 80;
                n86.d(inflate, "view");
                inflate.setLayoutParams(layoutParams);
                WeakReference<ViewGroup> weakReference2 = d;
                if (weakReference2 != null && (viewGroup = weakReference2.get()) != null) {
                    viewGroup.addView(inflate);
                }
            }
        }
    }

    public static final void Q3(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                Q3(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Q3(sb, i2, str, entry);
            }
        } else {
            sb.append('\n');
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                xg3 xg3 = xg3.g;
                sb.append(b4(new eh3(((String) obj).getBytes(zh3.f4175a))));
                sb.append('\"');
            } else if (obj instanceof xg3) {
                sb.append(": \"");
                sb.append(b4((xg3) obj));
                sb.append('\"');
            } else if (obj instanceof uh3) {
                sb.append(" {");
                M3((uh3) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i5 = i2 + 2;
                Q3(sb, i5, AnalyticsConstants.KEY, entry2.getKey());
                Q3(sb, i5, FirebaseAnalytics.Param.VALUE, entry2.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    public static rt5 R(np npVar) throws xt5 {
        rt5.b a2 = rt5.a();
        a2.f3130a = npVar.b("action");
        a2.e = JsonValue.p(npVar.b("extras")).n();
        Object obj = npVar.f2585a.get("initial_delay");
        a2.d = TimeUnit.MILLISECONDS.toMillis(obj instanceof Long ? ((Long) obj).longValue() : 0);
        Object obj2 = npVar.f2585a.get("network_required");
        int i2 = 0;
        a2.c = obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false;
        a2.b = npVar.b("component");
        Object obj3 = npVar.f2585a.get("conflict_strategy");
        if (obj3 instanceof Integer) {
            i2 = ((Integer) obj3).intValue();
        }
        a2.f = i2;
        return a2.a();
    }

    public static boolean R0(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    public static boolean R1(byte[] bArr, int i2, int i3) {
        int min = Math.min(i3, bArr.length);
        for (int max = Math.max(i2, 0); max < min; max++) {
            if (bArr[max] == 1) {
                return false;
            }
        }
        return true;
    }

    public static final char R2(char[] cArr) {
        n86.e(cArr, "$this$single");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        } else if (length == 1) {
            return cArr[0];
        } else {
            throw new IllegalArgumentException("Array has more than one element.");
        }
    }

    public static boolean R3(byte b2) {
        return b2 >= 0;
    }

    public static String S(int i2) {
        StringBuilder sb = new StringBuilder("#");
        sb.append(Integer.toHexString(i2));
        while (sb.length() < 9) {
            sb.append("0");
        }
        return sb.toString();
    }

    public static String S0(a05 a05) {
        StringBuilder sb = new StringBuilder(a05.size());
        for (int i2 = 0; i2 < a05.size(); i2++) {
            byte b2 = a05.b(i2);
            if (b2 == 34) {
                sb.append("\\\"");
            } else if (b2 == 39) {
                sb.append("\\'");
            } else if (b2 != 92) {
                switch (b2) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (b2 < 32 || b2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((b2 >>> 6) & 3) + 48));
                            sb.append((char) (((b2 >>> 3) & 7) + 48));
                            sb.append((char) ((b2 & 7) + 48));
                            break;
                        } else {
                            sb.append((char) b2);
                            continue;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static boolean S1(byte[][] bArr, int i2, int i3, int i4) {
        int min = Math.min(i4, bArr.length);
        for (int max = Math.max(i3, 0); max < min; max++) {
            if (bArr[max][i2] == 1) {
                return false;
            }
        }
        return true;
    }

    public static int S2(int i2, byte[] bArr, int i3, int i4, vz4 vz4) throws t05 {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return B0(bArr, i3, vz4);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return z0(bArr, i3, vz4) + vz4.f3697a;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = z0(bArr, i3, vz4);
                    i7 = vz4.f3697a;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = S2(i7, bArr, i3, i4, vz4);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw t05.g();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw t05.b();
            }
        } else {
            throw t05.b();
        }
    }

    public static boolean S3(@NullableDecl Object obj, @NullableDecl Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static Map<String, Set<String>> T(JsonValue jsonValue) {
        if (jsonValue.l()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        if (jsonValue.f instanceof zt5) {
            Iterator<Map.Entry<String, JsonValue>> it = jsonValue.n().iterator();
            while (it.hasNext()) {
                Map.Entry<String, JsonValue> next = it.next();
                HashSet hashSet = new HashSet();
                Iterator<JsonValue> it2 = next.getValue().m().iterator();
                while (it2.hasNext()) {
                    JsonValue next2 = it2.next();
                    if (next2.f instanceof String) {
                        hashSet.add(next2.i());
                    }
                }
                hashMap.put(next.getKey(), hashSet);
            }
        }
        if (hashMap.isEmpty()) {
            return null;
        }
        return hashMap;
    }

    public static String T0(String str, String str2, String str3) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 2 + String.valueOf(str2).length() + String.valueOf(str3).length());
        hj1.V0(sb, str, ProductDiscountsObject.KEY_DELIMITER, str2, ProductDiscountsObject.KEY_DELIMITER);
        sb.append(str3);
        return sb.toString();
    }

    public static final boolean T1(char c2) {
        return Character.isWhitespace(c2) || Character.isSpaceChar(c2);
    }

    public static final <T extends Comparable<? super T>> void T2(List<T> list) {
        n86.e(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final void T3(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                T3(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                T3(sb, i2, str, entry);
            }
        } else {
            sb.append('\n');
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                qt3 qt3 = qt3.g;
                sb.append(E3(new wt3(((String) obj).getBytes(tu3.f3407a))));
                sb.append('\"');
            } else if (obj instanceof qt3) {
                sb.append(": \"");
                sb.append(E3((qt3) obj));
                sb.append('\"');
            } else if (obj instanceof ru3) {
                sb.append(" {");
                N3((ru3) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i5 = i2 + 2;
                T3(sb, i5, AnalyticsConstants.KEY, entry2.getKey());
                T3(sb, i5, FirebaseAnalytics.Param.VALUE, entry2.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    public static char[] U(int i2, int i3) {
        return Character.toChars(((i2 >> i3) & 63) | 128);
    }

    public static int U0(float[] fArr, int[] iArr, int i2, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i3 = 0; i3 < 6; i3++) {
            iArr[i3] = (int) Math.ceil((double) fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        return i2;
    }

    public static boolean U1(char c2) {
        return c2 == '\r' || c2 == '*' || c2 == '>';
    }

    public static final <T> void U2(List<T> list, Comparator<? super T> comparator) {
        n86.e(list, "$this$sortWith");
        n86.e(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    public static int U3(byte[] bArr, int i2, pt3 pt3) {
        int i3 = i2 + 1;
        long j = (long) bArr[i2];
        if (j >= 0) {
            pt3.b = j;
            return i3;
        }
        int i4 = i3 + 1;
        byte b2 = bArr[i3];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            byte b3 = bArr[i4];
            i5 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i5;
            b2 = b3;
            i4 = i6;
        }
        pt3.b = j2;
        return i4;
    }

    public static Animator V(pl4 pl4, float f2, float f3, float f4) {
        ObjectAnimator ofObject = ObjectAnimator.ofObject(pl4, pl4.c.f2824a, pl4.b.b, new pl4.e(f2, f3, f4));
        pl4.e revealInfo = pl4.getRevealInfo();
        if (revealInfo != null) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal((View) pl4, (int) f2, (int) f3, revealInfo.c, f4);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofObject, createCircularReveal);
            return animatorSet;
        }
        throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }

    public static <TResult> yi4<TResult> V0(@RecentlyNonNull Exception exc) {
        wj4 wj4 = new wj4();
        wj4.u(exc);
        return wj4;
    }

    public static String V1(Collection<String> collection, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static void V2(Activity activity) {
        Intent intent;
        String string = activity.getString(com.theartofdev.edmodo.cropper.R.string.pick_image_intent_chooser_title);
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = activity.getPackageManager();
        if (!H1(activity)) {
            ArrayList arrayList2 = new ArrayList();
            Uri c1 = c1(activity);
            Intent intent2 = new Intent("android.media.action.IMAGE_CAPTURE");
            for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent2, 0)) {
                Intent intent3 = new Intent(intent2);
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                intent3.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                intent3.setPackage(resolveInfo.activityInfo.packageName);
                if (c1 != null) {
                    intent3.putExtra("output", c1);
                }
                arrayList2.add(intent3);
            }
            arrayList.addAll(arrayList2);
        }
        List<Intent> k1 = k1(packageManager, "android.intent.action.GET_CONTENT", false);
        if (((ArrayList) k1).size() == 0) {
            k1 = k1(packageManager, "android.intent.action.PICK", false);
        }
        arrayList.addAll(k1);
        if (arrayList.isEmpty()) {
            intent = new Intent();
        } else {
            intent = (Intent) arrayList.get(arrayList.size() - 1);
            arrayList.remove(arrayList.size() - 1);
        }
        Intent createChooser = Intent.createChooser(intent, string);
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) arrayList.toArray(new Parcelable[arrayList.size()]));
        activity.startActivityForResult(createChooser, AMQP.REPLY_SUCCESS);
    }

    public static long V3(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public static eo4 W(int i2) {
        if (i2 == 0) {
            return new jo4();
        }
        if (i2 != 1) {
            return new jo4();
        }
        return new fo4();
    }

    public static <TResult> yi4<TResult> W0(@RecentlyNonNull TResult tresult) {
        wj4 wj4 = new wj4();
        wj4.t(tresult);
        return wj4;
    }

    public static void W1(bw4 bw4, InputStream inputStream, OutputStream outputStream, long j) throws IOException {
        byte[] bArr = new byte[16384];
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(inputStream, 4096));
        int readInt = dataInputStream.readInt();
        if (readInt != -771763713) {
            String valueOf = String.valueOf(String.format("%x", Integer.valueOf(readInt)));
            throw new aw4(valueOf.length() != 0 ? "Unexpected magic=".concat(valueOf) : new String("Unexpected magic="));
        }
        int read = dataInputStream.read();
        if (read == 4) {
            long j2 = 0;
            while (true) {
                long j3 = j - j2;
                try {
                    int read2 = dataInputStream.read();
                    if (read2 == -1) {
                        throw new IOException("Patch file overrun");
                    } else if (read2 != 0) {
                        switch (read2) {
                            case 247:
                                read2 = dataInputStream.readUnsignedShort();
                                o2(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                            case 248:
                                read2 = dataInputStream.readInt();
                                o2(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                            case 249:
                                long readUnsignedShort = (long) dataInputStream.readUnsignedShort();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    z2(bArr, bw4, outputStream, readUnsignedShort, read2, j3);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case ListPopupWindow.EXPAND_LIST_TIMEOUT /*{ENCODED_INT: 250}*/:
                                read2 = dataInputStream.readUnsignedShort();
                                z2(bArr, bw4, outputStream, (long) dataInputStream.readUnsignedShort(), read2, j3);
                                break;
                            case 251:
                                read2 = dataInputStream.readInt();
                                z2(bArr, bw4, outputStream, (long) dataInputStream.readUnsignedShort(), read2, j3);
                                break;
                            case 252:
                                long readInt2 = (long) dataInputStream.readInt();
                                read2 = dataInputStream.read();
                                if (read2 != -1) {
                                    z2(bArr, bw4, outputStream, readInt2, read2, j3);
                                    break;
                                } else {
                                    throw new IOException("Unexpected end of patch");
                                }
                            case 253:
                                read2 = dataInputStream.readUnsignedShort();
                                z2(bArr, bw4, outputStream, (long) dataInputStream.readInt(), read2, j3);
                                break;
                            case 254:
                                read2 = dataInputStream.readInt();
                                z2(bArr, bw4, outputStream, (long) dataInputStream.readInt(), read2, j3);
                                break;
                            case Constants.MAX_HOST_LENGTH /*{ENCODED_INT: 255}*/:
                                long readLong = dataInputStream.readLong();
                                read2 = dataInputStream.readInt();
                                z2(bArr, bw4, outputStream, readLong, read2, j3);
                                break;
                            default:
                                o2(bArr, dataInputStream, outputStream, read2, j3);
                                break;
                        }
                        j2 += (long) read2;
                    } else {
                        return;
                    }
                } finally {
                    outputStream.flush();
                }
            }
        } else {
            throw new aw4(hj1.v(30, "Unexpected version=", read));
        }
    }

    public static void W2(Context context) {
        new ADM(context).startRegister();
    }

    public static <T> void W3(yi4<T> yi4, cj4<? super T> cj4) {
        Executor executor = aj4.b;
        yi4.g(executor, cj4);
        yi4.e(executor, cj4);
        yi4.a(executor, cj4);
    }

    public static final <T> k66<s56> X(s76<? super k66<? super T>, ? extends Object> s76, k66<? super T> k66) {
        n86.e(s76, "$this$createCoroutineUnintercepted");
        n86.e(k66, "completion");
        n86.e(k66, "completion");
        if (s76 instanceof u66) {
            return ((u66) s76).create(k66);
        }
        m66 context = k66.getContext();
        if (context == o66.f) {
            return new q66(k66, k66, s76);
        }
        return new r66(k66, context, k66, context, s76);
    }

    public static Map<String, dw5> X0(Context context, int i2) {
        try {
            return s2(context, context.getResources().getXml(i2));
        } catch (Resources.NotFoundException | IOException | NullPointerException | XmlPullParserException e2) {
            yj5.e(e2, "Failed to parse NotificationActionButtonGroups.", new Object[0]);
            return new HashMap();
        }
    }

    public static ni6 X1(String str, String str2, ei6.a aVar) throws IOException {
        Map map;
        Map map2;
        ji6 request = aVar.request();
        n86.f(request, "request");
        new LinkedHashMap();
        di6 di6 = request.b;
        String str3 = request.c;
        mi6 mi6 = request.e;
        if (request.f.isEmpty()) {
            map = new LinkedHashMap();
        } else {
            map = y56.C(request.f);
        }
        ci6.a e2 = request.d.e();
        n86.f(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "name");
        n86.f("2.6.0", FirebaseAnalytics.Param.VALUE);
        e2.a(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, "2.6.0");
        n86.f("sdkVariant", "name");
        n86.f(str, FirebaseAnalytics.Param.VALUE);
        e2.a("sdkVariant", str);
        n86.f("sdkVariantVersion", "name");
        n86.f(str2, FirebaseAnalytics.Param.VALUE);
        e2.a("sdkVariantVersion", str2);
        if (di6 != null) {
            ci6 d2 = e2.d();
            byte[] bArr = vi6.f3652a;
            n86.f(map, "$this$toImmutableMap");
            if (map.isEmpty()) {
                map2 = c66.f;
            } else {
                map2 = Collections.unmodifiableMap(new LinkedHashMap(map));
                n86.b(map2, "Collections.unmodifiableMap(LinkedHashMap(this))");
            }
            return aVar.a(new ji6(di6, str3, d2, mi6, map2));
        }
        throw new IllegalStateException("url == null".toString());
    }

    public static int X2(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        return i2;
    }

    public static void X3(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static final <R, T> k66<s56> Y(w76<? super R, ? super k66<? super T>, ? extends Object> w76, R r, k66<? super T> k66) {
        n86.e(w76, "$this$createCoroutineUnintercepted");
        n86.e(k66, "completion");
        n86.e(k66, "completion");
        if (w76 instanceof u66) {
            return ((u66) w76).create(r, k66);
        }
        m66 context = k66.getContext();
        if (context == o66.f) {
            return new s66(k66, k66, w76, r);
        }
        return new t66(k66, context, k66, context, w76, r);
    }

    public static PendingIntent Y0(Context context, int i2, Intent intent, int i3) {
        if (Build.VERSION.SDK_INT >= 23 && (33554432 & i3) == 0) {
            i3 |= 67108864;
        }
        return PendingIntent.getActivity(context, i2, intent, i3);
    }

    public static rc6 Y1(mb6 mb6, m66 m66, nb6 nb6, w76 w76, int i2, Object obj) {
        rc6 rc6;
        if ((i2 & 1) != 0) {
            m66 = o66.f;
        }
        nb6 nb62 = (i2 & 2) != 0 ? nb6.DEFAULT : null;
        m66 a2 = ib6.a(mb6, m66);
        if (nb62.isLazy()) {
            rc6 = new zc6(a2, w76);
        } else {
            rc6 = new id6(a2, true);
        }
        nb62.invoke(w76, rc6, rc6);
        return rc6;
    }

    public static final void Y2(Object obj) {
        if (obj instanceof n56.a) {
            throw ((n56.a) obj).f;
        }
    }

    public static int Y3(byte[] bArr, int i2, pt3 pt3) throws cv3 {
        int t3 = t3(bArr, i2, pt3);
        int i3 = pt3.f2847a;
        if (i3 < 0) {
            throw cv3.b();
        } else if (i3 == 0) {
            pt3.c = "";
            return t3;
        } else {
            pt3.c = new String(bArr, t3, i3, tu3.f3407a);
            return t3 + i3;
        }
    }

    public static final Object Z(Throwable th) {
        n86.e(th, "exception");
        return new n56.a(th);
    }

    public static ActivityInfo Z0(Class cls) {
        if (cls.getCanonicalName() == null) {
            return null;
        }
        try {
            return UAirship.f().getActivityInfo(new ComponentName(UAirship.g(), cls.getCanonicalName()), 128);
        } catch (Exception unused) {
            return null;
        }
    }

    public static int Z1(int i2, int i3, float f2) {
        return a6.a(a6.c(i3, Math.round(((float) Color.alpha(i3)) * f2)), i2);
    }

    public static final <T, C extends Collection<? super T>> C Z2(T[] tArr, C c2) {
        n86.e(tArr, "$this$toCollection");
        n86.e(c2, FirebaseAnalytics.Param.DESTINATION);
        for (T t : tArr) {
            c2.add(t);
        }
        return c2;
    }

    public static k44 Z3() {
        k44 k44 = f1360a;
        gj1.l(k44, "CameraUpdateFactory is not initialized");
        return k44;
    }

    public static final mb6 a(m66 m66) {
        int i2 = rc6.e;
        if (m66.get(rc6.a.f) == null) {
            m66 = m66.plus(new uc6(null));
        }
        return new pf6(m66);
    }

    public static <T> T a0(String str, Class<T> cls, String str2, String str3) {
        Retrofit.Builder addConverterFactory = new Retrofit.Builder().baseUrl(str).addConverterFactory(GsonConverterFactory.create());
        hi6.a aVar = new hi6.a();
        th5 th5 = new th5(str2, str3);
        n86.f(th5, "interceptor");
        aVar.c.add(th5);
        addConverterFactory.client(new hi6(aVar));
        return (T) addConverterFactory.build().create(cls);
    }

    public static CropImage$ActivityResult a1(Intent intent) {
        if (intent != null) {
            return (CropImage$ActivityResult) intent.getParcelableExtra("CROP_IMAGE_EXTRA_RESULT");
        }
        return null;
    }

    public static final <T> j56<T> a2(h76<? extends T> h76) {
        n86.e(h76, "initializer");
        return new o56(h76, null, 2);
    }

    public static final String a3(k66<?> k66) {
        Object obj;
        if (k66 instanceof qf6) {
            return k66.toString();
        }
        try {
            obj = k66 + '@' + l1(k66);
        } catch (Throwable th) {
            obj = Z(th);
        }
        if (n56.a(obj) != null) {
            obj = ((Object) k66.getClass().getName()) + '@' + l1(k66);
        }
        return (String) obj;
    }

    public static int a4(byte[] bArr, int i2, pt3 pt3) throws cv3 {
        int t3 = t3(bArr, i2, pt3);
        int i3 = pt3.f2847a;
        if (i3 < 0) {
            throw cv3.b();
        } else if (i3 == 0) {
            pt3.c = "";
            return t3;
        } else {
            pt3.c = lx3.f2290a.c(bArr, t3, i3);
            return t3 + i3;
        }
    }

    public static void b(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws t05 {
        if (!O1(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !O1(b4) && !O1(b5)) {
                int i3 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i2] = (char) ((i3 >>> 10) + 55232);
                cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
                return;
            }
        }
        throw t05.c();
    }

    public static cu5 b0(long j) {
        String str = UAirship.l().h() == 1 ? "amazon" : "android";
        zt5.b s = zt5.s();
        s.e(str, zt5.s().d("version", j).a());
        return JsonValue.x(s.a());
    }

    public static PendingIntent b1(Context context, int i2, Intent intent, int i3) {
        if (Build.VERSION.SDK_INT >= 23 && (33554432 & i3) == 0) {
            i3 |= 67108864;
        }
        return PendingIntent.getBroadcast(context, i2, intent, i3);
    }

    public static float b2(float f2, float f3, float f4) {
        return (f4 * f3) + ((1.0f - f4) * f2);
    }

    public static final <T> List<T> b3(w96<? extends T> w96) {
        n86.e(w96, "$this$toList");
        n86.e(w96, "$this$toMutableList");
        ArrayList arrayList = new ArrayList();
        n86.e(w96, "$this$toCollection");
        n86.e(arrayList, FirebaseAnalytics.Param.DESTINATION);
        Iterator<? extends T> it = w96.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return y56.q(arrayList);
    }

    public static String b4(xg3 xg3) {
        fk3 fk3 = new fk3(xg3);
        StringBuilder sb = new StringBuilder(xg3.size());
        for (int i2 = 0; i2 < fk3.f1134a.size(); i2++) {
            byte u = fk3.f1134a.u(i2);
            if (u == 34) {
                sb.append("\\\"");
            } else if (u == 39) {
                sb.append("\\'");
            } else if (u != 92) {
                switch (u) {
                    case 7:
                        sb.append("\\a");
                        continue;
                    case 8:
                        sb.append("\\b");
                        continue;
                    case 9:
                        sb.append("\\t");
                        continue;
                    case 10:
                        sb.append("\\n");
                        continue;
                    case 11:
                        sb.append("\\v");
                        continue;
                    case 12:
                        sb.append("\\f");
                        continue;
                    case 13:
                        sb.append("\\r");
                        continue;
                    default:
                        if (u < 32 || u > 126) {
                            sb.append('\\');
                            sb.append((char) (((u >>> 6) & 3) + 48));
                            sb.append((char) (((u >>> 3) & 7) + 48));
                            sb.append((char) ((u & 7) + 48));
                            break;
                        } else {
                            sb.append((char) u);
                            continue;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static boolean c(byte b2) {
        return b2 >= 0;
    }

    public static <T> void c0(T t, Object obj) {
        Objects.requireNonNull(t, (String) obj);
    }

    public static Uri c1(Context context) {
        File externalCacheDir = context.getExternalCacheDir();
        if (externalCacheDir != null) {
            return Uri.fromFile(new File(externalCacheDir.getPath(), "pickImageResult.jpeg"));
        }
        return null;
    }

    public static final <T> List<T> c2(T t) {
        List<T> singletonList = Collections.singletonList(t);
        n86.d(singletonList, "java.util.Collections.singletonList(element)");
        return singletonList;
    }

    public static final <K, V> Map<K, V> c3(Map<? extends K, ? extends V> map) {
        n86.e(map, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        n86.d(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    public static int c4(byte[] bArr, int i2, pt3 pt3) throws cv3 {
        int t3 = t3(bArr, i2, pt3);
        int i3 = pt3.f2847a;
        if (i3 < 0) {
            throw cv3.b();
        } else if (i3 > bArr.length - t3) {
            throw cv3.a();
        } else if (i3 == 0) {
            pt3.c = qt3.g;
            return t3;
        } else {
            pt3.c = qt3.n(bArr, t3, i3);
            return t3 + i3;
        }
    }

    public static boolean d(byte b2) {
        return b2 < -32;
    }

    public static String d0(String str, d56 d56) throws e56 {
        int i2;
        boolean z = d56.f791a;
        int[] e3 = e3(str);
        g = e3;
        h = e3.length;
        i = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            int i3 = i;
            int i4 = h;
            if (i3 <= i4) {
                if (i3 != i4) {
                    i2 = g[i3] & Constants.MAX_HOST_LENGTH;
                    i = i3 + 1;
                    if ((i2 & 128) != 0) {
                        if ((i2 & 224) == 192) {
                            i2 = ((i2 & 31) << 6) | A2();
                            if (i2 < 128) {
                                throw new e56("Invalid continuation byte");
                            }
                        } else if ((i2 & 240) != 224) {
                            if ((i2 & 248) != 240) {
                                break;
                            }
                            int A2 = A2();
                            int i5 = A2 << 12;
                            i2 = i5 | ((i2 & 15) << 18) | (A2() << 6) | A2();
                            if (i2 >= 65536) {
                                if (i2 > 1114111) {
                                    break;
                                }
                            } else {
                                break;
                            }
                        } else {
                            i2 = (A2() << 6) | ((i2 & 15) << 12) | A2();
                            if (i2 < 2048) {
                                throw new e56("Invalid continuation byte");
                            } else if (!G(i2, z)) {
                                i2 = 65533;
                            }
                        }
                    }
                } else {
                    i2 = -1;
                }
                if (i2 != -1) {
                    arrayList.add(Integer.valueOf(i2));
                } else {
                    int size = arrayList.size();
                    int[] iArr = new int[size];
                    for (int i6 = 0; i6 < size; i6++) {
                        iArr[i6] = ((Integer) arrayList.get(i6)).intValue();
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i7 = 0; i7 < size; i7++) {
                        sb.appendCodePoint(iArr[i7]);
                    }
                    return sb.toString();
                }
            } else {
                throw new e56("Invalid byte index");
            }
        }
        throw new e56("Invalid continuation byte");
    }

    public static String d1() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) UAirship.d().getSystemService("phone");
            if (telephonyManager == null) {
                return null;
            }
            return telephonyManager.getNetworkOperatorName();
        } catch (Exception e2) {
            yj5.i("Unable to get network operator name", e2);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d2(com.urbanairship.iam.view.MediaView r9, defpackage.vr5 r10, com.urbanairship.iam.assets.Assets r11) {
        /*
        // Method dump skipped, instructions count: 500
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hd3.d2(com.urbanairship.iam.view.MediaView, vr5, com.urbanairship.iam.assets.Assets):void");
    }

    public static final <T> Object d3(Object obj, s76<? super Throwable, s56> s76) {
        Throwable a2 = n56.a(obj);
        if (a2 != null) {
            return new eb6(a2, false, 2);
        }
        if (s76 != null) {
            return new fb6(obj, s76);
        }
        return obj;
    }

    public static boolean d4(byte b2) {
        return b2 > -65;
    }

    public static void e(byte b2, byte b3, char[] cArr, int i2) throws t05 {
        if (b2 < -62 || O1(b3)) {
            throw t05.c();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static List<LatLng> e0(String str) {
        int i2;
        int i3;
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int i7 = 1;
            int i8 = 0;
            while (true) {
                i2 = i4 + 1;
                int charAt = (str.charAt(i4) - '?') - 1;
                i7 += charAt << i8;
                i8 += 5;
                if (charAt < 31) {
                    break;
                }
                i4 = i2;
            }
            int i9 = ((i7 & 1) != 0 ? ~(i7 >> 1) : i7 >> 1) + i5;
            int i10 = 1;
            int i11 = 0;
            while (true) {
                i3 = i2 + 1;
                int charAt2 = (str.charAt(i2) - '?') - 1;
                i10 += charAt2 << i11;
                i11 += 5;
                if (charAt2 < 31) {
                    break;
                }
                i2 = i3;
            }
            int i12 = i10 & 1;
            int i13 = i10 >> 1;
            if (i12 != 0) {
                i13 = ~i13;
            }
            i6 += i13;
            arrayList.add(new LatLng(((double) i9) * 1.0E-5d, ((double) i6) * 1.0E-5d));
            i5 = i9;
            i4 = i3;
        }
        return arrayList;
    }

    public static final String e1(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static int e2(CharSequence charSequence, int i2, int i3) {
        float[] fArr;
        if (i2 >= charSequence.length()) {
            return i3;
        }
        if (i3 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i3] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int U0 = U0(fArr, iArr, Integer.MAX_VALUE, bArr);
                int i6 = 0;
                for (int i7 = 0; i7 < 6; i7++) {
                    i6 += bArr[i7];
                }
                if (iArr[0] == U0) {
                    return 0;
                }
                if (i6 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (i6 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (i6 != 1 || bArr[2] <= 0) {
                    return (i6 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char charAt = charSequence.charAt(i5);
            i4++;
            if (F1(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (I1(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (charAt == ' ' || (charAt >= '0' && charAt <= '9') || (charAt >= 'A' && charAt <= 'Z')) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (I1(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (charAt == ' ' || (charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z')) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (I1(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (N1(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (I1(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (charAt >= ' ' && charAt <= '^') {
                fArr[4] = fArr[4] + 0.75f;
            } else if (I1(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            fArr[5] = fArr[5] + 1.0f;
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                U0(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int i8 = 0;
                for (int i9 = 0; i9 < 6; i9++) {
                    i8 += bArr2[i9];
                }
                if (iArr2[0] < iArr2[5] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (i8 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (i8 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (i8 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i10 = i2 + i4 + 1; i10 < charSequence.length(); i10++) {
                            char charAt2 = charSequence.charAt(i10);
                            if (U1(charAt2)) {
                                return 3;
                            }
                            if (!N1(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    public static int[] e3(String str) {
        int length = str.length();
        int i2 = 0;
        int[] iArr = new int[str.codePointCount(0, length)];
        int i3 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            iArr[i3] = codePointAt;
            i2 += Character.charCount(codePointAt);
            i3++;
        }
        return iArr;
    }

    public static final String e4(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static boolean f(byte b2) {
        return b2 < -16;
    }

    public static int f0(byte[] bArr, int i2, vz4 vz4) throws t05 {
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a;
        if (i3 < 0) {
            throw t05.f();
        } else if (i3 > bArr.length - z0) {
            throw t05.h();
        } else if (i3 == 0) {
            vz4.c = a05.g;
            return z0;
        } else {
            vz4.c = a05.e(bArr, z0, i3);
            return z0 + i3;
        }
    }

    public static int f1(Context context, int i2, int i3) {
        TypedValue E2 = E2(context, i2);
        return E2 != null ? E2.data : i3;
    }

    public static final int f2(int i2) {
        if (i2 < 0) {
            return i2;
        }
        if (i2 < 3) {
            return i2 + 1;
        }
        if (i2 < 1073741824) {
            return (int) ((((float) i2) / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static PorterDuffColorFilter f3(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static void g(byte b2, byte b3, byte b4, char[] cArr, int i2) throws t05 {
        if (O1(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || O1(b4)))) {
            throw t05.c();
        }
        cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: e25<f25, f25> */
    /* JADX WARN: Multi-variable type inference failed */
    public static int g0(int i2, byte[] bArr, int i3, int i4, q05.c<?, ?> cVar, q05.e<?, ?> eVar, e25<f25, f25> e25, vz4 vz4) throws IOException {
        Object g2;
        Object obj;
        Object obj2;
        Object obj3 = f25.f;
        m05<q05.d> m05 = cVar.extensions;
        int i5 = i2 >>> 3;
        q05.d dVar = eVar.d;
        Object obj4 = null;
        if (!dVar.i || !dVar.j) {
            l25 l25 = dVar.h;
            if (l25 != l25.ENUM) {
                switch (l25.ordinal()) {
                    case 0:
                        obj = Double.valueOf(Double.longBitsToDouble(i0(bArr, i3)));
                        obj4 = obj;
                        i3 += 8;
                        break;
                    case 1:
                        obj2 = Float.valueOf(Float.intBitsToFloat(h0(bArr, i3)));
                        obj4 = obj2;
                        i3 += 4;
                        break;
                    case 2:
                    case 3:
                        i3 = B0(bArr, i3, vz4);
                        obj4 = Long.valueOf(vz4.b);
                        break;
                    case 4:
                    case 12:
                        i3 = z0(bArr, i3, vz4);
                        obj4 = Integer.valueOf(vz4.f3697a);
                        break;
                    case 5:
                    case 15:
                        obj = Long.valueOf(i0(bArr, i3));
                        obj4 = obj;
                        i3 += 8;
                        break;
                    case 6:
                    case 14:
                        obj2 = Integer.valueOf(h0(bArr, i3));
                        obj4 = obj2;
                        i3 += 4;
                        break;
                    case 7:
                        i3 = B0(bArr, i3, vz4);
                        obj4 = Boolean.valueOf(vz4.b != 0);
                        break;
                    case 8:
                        i3 = v0(bArr, i3, vz4);
                        obj4 = vz4.c;
                        break;
                    case 9:
                        i3 = j0(t15.c.a(eVar.c.getClass()), bArr, i3, i4, (i5 << 3) | 4, vz4);
                        obj4 = vz4.c;
                        break;
                    case 10:
                        i3 = k0(t15.c.a(eVar.c.getClass()), bArr, i3, i4, vz4);
                        obj4 = vz4.c;
                        break;
                    case 11:
                        i3 = f0(bArr, i3, vz4);
                        obj4 = vz4.c;
                        break;
                    case 13:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 16:
                        i3 = z0(bArr, i3, vz4);
                        obj4 = Integer.valueOf(b05.b(vz4.f3697a));
                        break;
                    case 17:
                        i3 = B0(bArr, i3, vz4);
                        obj4 = Long.valueOf(b05.c(vz4.b));
                        break;
                }
            } else {
                i3 = z0(bArr, i3, vz4);
                if (eVar.d.f.findValueByNumber(vz4.f3697a) == null) {
                    Object obj5 = cVar.unknownFields;
                    Object obj6 = obj5;
                    if (obj5 == obj3) {
                        f25 e2 = f25.e();
                        cVar.unknownFields = e2;
                        obj6 = e2;
                    }
                    int i6 = vz4.f3697a;
                    Class<?> cls = z15.f4109a;
                    Object obj7 = obj6;
                    if (obj6 == null) {
                        obj7 = e25.m();
                    }
                    e25.e(obj7 == 1 ? 1 : 0, i5, (long) i6);
                    return i3;
                }
                obj4 = Integer.valueOf(vz4.f3697a);
            }
            q05.d dVar2 = eVar.d;
            if (dVar2.i) {
                m05.a(dVar2, obj4);
            } else {
                int ordinal = dVar2.h.ordinal();
                if ((ordinal == 9 || ordinal == 10) && (g2 = m05.g(eVar.d)) != null) {
                    obj4 = s05.c(g2, obj4);
                }
                m05.o(eVar.d, obj4);
            }
            return i3;
        }
        switch (dVar.h.ordinal()) {
            case 0:
                f05 f05 = new f05();
                int n0 = n0(bArr, i3, f05, vz4);
                m05.o(eVar.d, f05);
                return n0;
            case 1:
                o05 o05 = new o05();
                int q0 = q0(bArr, i3, o05, vz4);
                m05.o(eVar.d, o05);
                return q0;
            case 2:
            case 3:
                a15 a15 = new a15();
                int u0 = u0(bArr, i3, a15, vz4);
                m05.o(eVar.d, a15);
                return u0;
            case 4:
            case 12:
                r05 r05 = new r05();
                int t0 = t0(bArr, i3, r05, vz4);
                m05.o(eVar.d, r05);
                return t0;
            case 5:
            case 15:
                a15 a152 = new a15();
                int p0 = p0(bArr, i3, a152, vz4);
                m05.o(eVar.d, a152);
                return p0;
            case 6:
            case 14:
                r05 r052 = new r05();
                int o0 = o0(bArr, i3, r052, vz4);
                m05.o(eVar.d, r052);
                return o0;
            case 7:
                xz4 xz4 = new xz4();
                int m0 = m0(bArr, i3, xz4, vz4);
                m05.o(eVar.d, xz4);
                return m0;
            case 8:
            case 9:
            case 10:
            case 11:
            default:
                StringBuilder i0 = hj1.i0("Type cannot be packed: ");
                i0.append(eVar.d.h);
                throw new IllegalStateException(i0.toString());
            case 13:
                r05 r053 = new r05();
                int t02 = t0(bArr, i3, r053, vz4);
                Object obj8 = cVar.unknownFields;
                if (obj8 != obj3) {
                    obj4 = obj8;
                }
                f25 f25 = (f25) z15.y(i5, r053, eVar.d.f, obj4, e25);
                if (f25 != null) {
                    cVar.unknownFields = f25;
                }
                m05.o(eVar.d, r053);
                return t02;
            case 16:
                r05 r054 = new r05();
                int r0 = r0(bArr, i3, r054, vz4);
                m05.o(eVar.d, r054);
                return r0;
            case 17:
                a15 a153 = new a15();
                int s0 = s0(bArr, i3, a153, vz4);
                m05.o(eVar.d, a153);
                return s0;
        }
    }

    public static int g1(View view, int i2) {
        return G2(view.getContext(), i2, view.getClass().getCanonicalName());
    }

    public static final <K, V> Map<K, V> g2(m56<? extends K, ? extends V> m56) {
        n86.e(m56, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(m56.f, m56.g);
        n86.d(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    public static void g3() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }

    public static wf5 h(Uri uri) {
        return new wf5(uri, null);
    }

    public static int h0(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static ColorStateList h1(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        ColorStateList a2;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (a2 = u0.a(context, resourceId)) == null) {
            return typedArray.getColorStateList(i2);
        }
        return a2;
    }

    public static final int h2(int i2, int i3) {
        int i4 = i2 % i3;
        return i4 >= 0 ? i4 : i4 + i3;
    }

    public static yi4<Void> h3(Collection<? extends yi4<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return W0(null);
        }
        Iterator<? extends yi4<?>> it = collection.iterator();
        while (it.hasNext()) {
            Objects.requireNonNull((yi4) it.next(), "null tasks are not accepted");
        }
        wj4 wj4 = new wj4();
        dj4 dj4 = new dj4(collection.size(), wj4);
        Iterator<? extends yi4<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            W3((yi4) it2.next(), dj4);
        }
        return wj4;
    }

    public static void i(Map<String, Set<String>> map, Map<String, Set<String>> map2) {
        for (Map.Entry<String, Set<String>> entry : map2.entrySet()) {
            Set<String> set = map.get(entry.getKey());
            if (set == null) {
                set = new HashSet<>();
                map.put(entry.getKey(), set);
            }
            set.addAll(entry.getValue());
        }
    }

    public static long i0(byte[] bArr, int i2) {
        return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
    }

    public static ColorStateList i1(Context context, TintTypedArray tintTypedArray, int i2) {
        int resourceId;
        ColorStateList a2;
        if (!tintTypedArray.hasValue(i2) || (resourceId = tintTypedArray.getResourceId(i2, 0)) == 0 || (a2 = u0.a(context, resourceId)) == null) {
            return tintTypedArray.getColorStateList(i2);
        }
        return a2;
    }

    public static d44 i2(LatLng latLng) {
        try {
            return new d44(Z3().G0(latLng));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static yi4<List<yi4<?>>> i3(yi4<?>... yi4Arr) {
        if (yi4Arr.length == 0) {
            return W0(Collections.emptyList());
        }
        List asList = Arrays.asList(yi4Arr);
        if (asList == null || asList.isEmpty()) {
            return W0(Collections.emptyList());
        }
        return h3(asList).k(aj4.f170a, new yj4(asList));
    }

    public static final <T> boolean j(Collection<? super T> collection, Iterable<? extends T> iterable) {
        n86.e(collection, "$this$addAll");
        n86.e(iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z = false;
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            if (collection.add((Object) it.next())) {
                z = true;
            }
        }
        return z;
    }

    public static int j0(x15 x15, byte[] bArr, int i2, int i3, int i4, vz4 vz4) throws IOException {
        l15 l15 = (l15) x15;
        Object d2 = l15.d();
        int L = l15.L(d2, bArr, i2, i3, i4, vz4);
        l15.e(d2);
        vz4.c = d2;
        return L;
    }

    public static Drawable j1(Context context, TypedArray typedArray, int i2) {
        int resourceId;
        Drawable b2;
        if (!typedArray.hasValue(i2) || (resourceId = typedArray.getResourceId(i2, 0)) == 0 || (b2 = u0.b(context, resourceId)) == null) {
            return typedArray.getDrawable(i2);
        }
        return b2;
    }

    public static d44 j2(LatLngBounds latLngBounds, int i2) {
        try {
            return new d44(Z3().Q(latLngBounds, i2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    /* JADX INFO: finally extract failed */
    public static final <T> Object j3(m66 m66, w76<? super mb6, ? super k66<? super T>, ? extends Object> w76, k66<? super T> k66) {
        Object obj;
        m66 context = k66.getContext();
        m66 plus = context.plus(m66);
        ec6.n(plus);
        if (plus == context) {
            bg6 bg6 = new bg6(plus, k66);
            obj = ec6.C(bg6, bg6, w76);
        } else {
            int i2 = l66.c;
            l66.a aVar = l66.a.f;
            if (n86.a(plus.get(aVar), context.get(aVar))) {
                od6 od6 = new od6(plus, k66);
                Object b2 = fg6.b(plus, null);
                try {
                    Object C = ec6.C(od6, od6, w76);
                    fg6.a(plus, b2);
                    obj = C;
                } catch (Throwable th) {
                    fg6.a(plus, b2);
                    throw th;
                }
            } else {
                ub6 ub6 = new ub6(plus, k66);
                ec6.B(w76, ub6, ub6, null, 4);
                obj = ub6.f0();
            }
        }
        if (obj == p66.COROUTINE_SUSPENDED) {
            n86.e(k66, "frame");
        }
        return obj;
    }

    public static final void k(String str, ExecutorService executorService) {
        Runtime.getRuntime().addShutdownHook(new Thread(new n06(str, executorService, 2, TimeUnit.SECONDS), hj1.S("Crashlytics Shutdown Hook for ", str)));
    }

    public static int k0(x15 x15, byte[] bArr, int i2, int i3, vz4 vz4) throws IOException {
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        byte b3 = b2;
        if (b2 < 0) {
            i4 = y0(b2, bArr, i4, vz4);
            b3 = vz4.f3697a;
        }
        if (b3 < 0 || b3 > i3 - i4) {
            throw t05.h();
        }
        Object d2 = x15.d();
        int i5 = (b3 == 1 ? 1 : 0) + i4;
        x15.j(d2, bArr, i4, i5, vz4);
        x15.e(d2);
        vz4.c = d2;
        return i5;
    }

    public static List<Intent> k1(PackageManager packageManager, String str, boolean z) {
        ArrayList arrayList = new ArrayList();
        Intent intent = str == "android.intent.action.GET_CONTENT" ? new Intent(str) : new Intent(str, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 0)) {
            Intent intent2 = new Intent(intent);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
            intent2.setPackage(resolveInfo.activityInfo.packageName);
            arrayList.add(intent2);
        }
        if (!z) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Intent intent3 = (Intent) it.next();
                if (intent3.getComponent().getClassName().equals("com.android.documentsui.DocumentsActivity")) {
                    arrayList.remove(intent3);
                    break;
                }
            }
        }
        return arrayList;
    }

    public static d44 k2(LatLng latLng, float f2) {
        try {
            return new d44(Z3().h3(latLng, f2));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public static byte k3(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue() ? (byte) 1 : 0;
        }
        return -1;
    }

    public static final void l(Throwable th, Throwable th2) {
        n86.e(th, "$this$addSuppressed");
        n86.e(th2, "exception");
        if (th != th2) {
            d76.f805a.a(th, th2);
        }
    }

    public static int l0(x15<?> x15, int i2, byte[] bArr, int i3, int i4, s05.j<?> jVar, vz4 vz4) throws IOException {
        int k0 = k0(x15, bArr, i3, i4, vz4);
        jVar.add(vz4.c);
        while (k0 < i4) {
            int z0 = z0(bArr, k0, vz4);
            if (i2 != vz4.f3697a) {
                break;
            }
            k0 = k0(x15, bArr, z0, i4, vz4);
            jVar.add(vz4.c);
        }
        return k0;
    }

    public static final String l1(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static Set<String> l2(Set<String> set) {
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if (str == null) {
                yj5.a("Null tag was removed from set.", new Object[0]);
            } else {
                String trim = str.trim();
                if (trim.length() <= 0 || trim.length() > 127) {
                    yj5.c("Tag with zero or greater than max length was removed from set: %s", trim);
                } else {
                    hashSet.add(trim);
                }
            }
        }
        return hashSet;
    }

    public static int l3(int i2, byte[] bArr, int i3, int i4, pt3 pt3) throws cv3 {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                return U3(bArr, i3, pt3);
            }
            if (i5 == 1) {
                return i3 + 8;
            }
            if (i5 == 2) {
                return t3(bArr, i3, pt3) + pt3.f2847a;
            }
            if (i5 == 3) {
                int i6 = (i2 & -8) | 4;
                int i7 = 0;
                while (i3 < i4) {
                    i3 = t3(bArr, i3, pt3);
                    i7 = pt3.f2847a;
                    if (i7 == i6) {
                        break;
                    }
                    i3 = l3(i7, bArr, i3, i4, pt3);
                }
                if (i3 <= i4 && i7 == i6) {
                    return i3;
                }
                throw cv3.d();
            } else if (i5 == 5) {
                return i3 + 4;
            } else {
                throw cv3.c();
            }
        } else {
            throw cv3.c();
        }
    }

    public static final <T> void m(Appendable appendable, T t, s76<? super T, ? extends CharSequence> s76) {
        n86.e(appendable, "$this$appendElement");
        if (s76 != null) {
            appendable.append((CharSequence) s76.invoke(t));
            return;
        }
        if (t != null ? t instanceof CharSequence : true) {
            appendable.append(t);
        } else if (t instanceof Character) {
            appendable.append(t.charValue());
        } else {
            appendable.append(String.valueOf(t));
        }
    }

    public static int m0(byte[] bArr, int i2, s05.j<?> jVar, vz4 vz4) throws IOException {
        xz4 xz4 = (xz4) jVar;
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a + z0;
        while (z0 < i3) {
            z0 = B0(bArr, z0, vz4);
            xz4.d(vz4.b != 0);
        }
        if (z0 == i3) {
            return z0;
        }
        throw t05.h();
    }

    public static int m1(Activity activity) {
        View rootView = activity.findViewById(16908290).getRootView();
        Bitmap bitmap = null;
        if (rootView.getWidth() > 0 && rootView.getHeight() > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Drawable background = rootView.getBackground();
            if (background != null) {
                background.draw(canvas);
            } else {
                canvas.drawColor(-1);
            }
            rootView.draw(canvas);
            if (createBitmap != null && createBitmap.getWidth() > 0 && createBitmap.getHeight() > 0) {
                try {
                    bitmap = Bitmap.createScaledBitmap(createBitmap, 1, 1, false);
                } catch (OutOfMemoryError unused) {
                }
            }
        }
        float[] fArr = new float[3];
        Color.colorToHSV(bitmap != null ? bitmap.getPixel(0, 0) : -16777216, fArr);
        fArr[2] = 0.3f;
        return Color.HSVToColor(242, fArr);
    }

    public static d36 m2(m36 m36, String str, m36.a aVar) {
        m36.d(str, aVar);
        return new c36(m36, str, aVar);
    }

    public static int m3(int i2, byte[] bArr, int i3, int i4, zu3<?> zu3, pt3 pt3) {
        uu3 uu3 = (uu3) zu3;
        int t3 = t3(bArr, i3, pt3);
        uu3.k(pt3.f2847a);
        while (t3 < i4) {
            int t32 = t3(bArr, t3, pt3);
            if (i2 != pt3.f2847a) {
                break;
            }
            t3 = t3(bArr, t32, pt3);
            uu3.k(pt3.f2847a);
        }
        return t3;
    }

    public static void n(View view, float f2, int i2) {
        int i3;
        int i4;
        int i5;
        if (view.getWidth() == 0) {
            view.getViewTreeObserver().addOnPreDrawListener(new ys5(new WeakReference(view), f2, i2));
        }
        float min = Math.min(TypedValue.applyDimension(1, f2, view.getResources().getDisplayMetrics()), (float) Math.min(view.getHeight() / 2, view.getWidth() / 2));
        int round = Math.round(min - (((float) Math.sin(Math.toRadians(45.0d))) * min));
        int round2 = Math.round(min - (((float) Math.sin(Math.toRadians(45.0d))) * min));
        int i6 = 0;
        if ((i2 & 1) == 1) {
            i3 = round2;
            i4 = round;
        } else {
            i4 = 0;
            i3 = 0;
        }
        if ((i2 & 2) == 2) {
            i3 = round2;
            i5 = round;
        } else {
            i5 = 0;
        }
        if ((i2 & 4) == 4) {
            i6 = round2;
            i5 = round;
        }
        if ((i2 & 8) != 8) {
            round = i4;
            round2 = i6;
        }
        view.setPadding(view.getPaddingLeft() + round, view.getPaddingTop() + i3, view.getPaddingRight() + i5, view.getPaddingBottom() + round2);
    }

    public static int n0(byte[] bArr, int i2, s05.j<?> jVar, vz4 vz4) throws IOException {
        f05 f05 = (f05) jVar;
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a + z0;
        while (z0 < i3) {
            f05.d(Double.longBitsToDouble(i0(bArr, z0)));
            z0 += 8;
        }
        if (z0 == i3) {
            return z0;
        }
        throw t05.h();
    }

    public static final <T> Class<T> n1(n96<T> n96) {
        n86.e(n96, "$this$javaObjectType");
        Class<T> cls = (Class<T>) ((g86) n96).a();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return name.equals("double") ? Double.class : cls;
            case 104431:
                if (name.equals("int")) {
                    return Integer.class;
                }
                return cls;
            case 3039496:
                if (name.equals("byte")) {
                    return Byte.class;
                }
                return cls;
            case 3052374:
                if (name.equals("char")) {
                    return Character.class;
                }
                return cls;
            case 3327612:
                if (name.equals("long")) {
                    return Long.class;
                }
                return cls;
            case 3625364:
                if (name.equals("void")) {
                    return Void.class;
                }
                return cls;
            case 64711720:
                if (name.equals("boolean")) {
                    return Boolean.class;
                }
                return cls;
            case 97526364:
                if (name.equals("float")) {
                    return Float.class;
                }
                return cls;
            case 109413500:
                if (name.equals("short")) {
                    return Short.class;
                }
                return cls;
            default:
                return cls;
        }
    }

    public static String n2(JSONObject jSONObject, String str) throws JSONException {
        if (!jSONObject.has(str) || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    public static int n3(int i2, byte[] bArr, int i3, int i4, dx3 dx3, pt3 pt3) throws cv3 {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int U3 = U3(bArr, i3, pt3);
                dx3.a(i2, Long.valueOf(pt3.b));
                return U3;
            } else if (i5 == 1) {
                dx3.a(i2, Long.valueOf(V3(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int t3 = t3(bArr, i3, pt3);
                int i6 = pt3.f2847a;
                if (i6 < 0) {
                    throw cv3.b();
                } else if (i6 <= bArr.length - t3) {
                    if (i6 == 0) {
                        dx3.a(i2, qt3.g);
                    } else {
                        dx3.a(i2, qt3.n(bArr, t3, i6));
                    }
                    return t3 + i6;
                } else {
                    throw cv3.a();
                }
            } else if (i5 == 3) {
                dx3 c2 = dx3.c();
                int i7 = (i2 & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int t32 = t3(bArr, i3, pt3);
                    int i9 = pt3.f2847a;
                    if (i9 == i7) {
                        i8 = i9;
                        i3 = t32;
                        break;
                    }
                    i8 = i9;
                    i3 = n3(i9, bArr, t32, i4, c2, pt3);
                }
                if (i3 > i4 || i8 != i7) {
                    throw cv3.d();
                }
                dx3.a(i2, c2);
                return i3;
            } else if (i5 == 5) {
                dx3.a(i2, Integer.valueOf(s3(bArr, i3)));
                return i3 + 4;
            } else {
                throw cv3.c();
            }
        } else {
            throw cv3.c();
        }
    }

    public static void o(Button button, xq5 xq5, int i2) {
        int i3;
        int i4;
        float f2;
        q(button, xq5.f);
        Integer num = xq5.f.g;
        int currentTextColor = num == null ? button.getCurrentTextColor() : num.intValue();
        Integer num2 = xq5.j;
        if (num2 == null) {
            i3 = 0;
        } else {
            i3 = num2.intValue();
        }
        int c2 = a6.c(currentTextColor, Math.round(((float) Color.alpha(currentTextColor)) * 0.2f));
        Integer num3 = xq5.k;
        if (num3 == null) {
            i4 = i3;
        } else {
            i4 = num3.intValue();
        }
        Float f3 = xq5.i;
        if (f3 == null) {
            f2 = 0.0f;
        } else {
            f2 = f3.floatValue();
        }
        xs5 xs5 = new xs5(button.getContext());
        xs5.f3960a = i3;
        xs5.f = i2;
        xs5.e = f2;
        xs5.c = Integer.valueOf(c2);
        xs5.b = Integer.valueOf(i4);
        xs5.d = 2;
        Drawable a2 = xs5.a();
        AtomicInteger atomicInteger = r8.f3055a;
        button.setBackground(a2);
    }

    public static int o0(byte[] bArr, int i2, s05.j<?> jVar, vz4 vz4) throws IOException {
        r05 r05 = (r05) jVar;
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a + z0;
        while (z0 < i3) {
            r05.d(h0(bArr, z0));
            z0 += 4;
        }
        if (z0 == i3) {
            return z0;
        }
        throw t05.h();
    }

    public static final <T> sa6<T> o1(k66<? super T> k66) {
        if (!(k66 instanceof qf6)) {
            return new sa6<>(k66, 1);
        }
        sa6<T> j = ((qf6) k66).j();
        if (j == null || !j.B()) {
            j = null;
        }
        return j == null ? new sa6<>(k66, 2) : j;
    }

    public static void o2(byte[] bArr, DataInputStream dataInputStream, OutputStream outputStream, int i2, long j) throws IOException {
        if (i2 < 0) {
            throw new IOException("copyLength negative");
        } else if (((long) i2) <= j) {
            while (i2 > 0) {
                try {
                    int min = Math.min(i2, 16384);
                    dataInputStream.readFully(bArr, 0, min);
                    outputStream.write(bArr, 0, min);
                    i2 -= min;
                } catch (EOFException unused) {
                    throw new IOException("patch underrun");
                }
            }
        } else {
            throw new IOException("Output length overrun");
        }
    }

    public static int o3(int i2, byte[] bArr, int i3, pt3 pt3) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            pt3.f2847a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            pt3.f2847a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            pt3.f2847a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            pt3.f2847a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                pt3.f2847a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int p(o95 o95, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = o95.c;
        } else {
            i2 = o95.b;
        }
        if (z) {
            i3 = o95.b;
        } else {
            i3 = o95.c;
        }
        byte[][] bArr = o95.f2668a;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            byte b2 = -1;
            int i6 = 0;
            for (int i7 = 0; i7 < i3; i7++) {
                byte b3 = z ? bArr[i5][i7] : bArr[i7][i5];
                if (b3 == b2) {
                    i6++;
                } else {
                    if (i6 >= 5) {
                        i4 += (i6 - 5) + 3;
                    }
                    b2 = b3;
                    i6 = 1;
                }
            }
            if (i6 >= 5) {
                i4 = (i6 - 5) + 3 + i4;
            }
        }
        return i4;
    }

    public static int p0(byte[] bArr, int i2, s05.j<?> jVar, vz4 vz4) throws IOException {
        a15 a15 = (a15) jVar;
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a + z0;
        while (z0 < i3) {
            a15.d(i0(bArr, z0));
            z0 += 8;
        }
        if (z0 == i3) {
            return z0;
        }
        throw t05.h();
    }

    public static String p1(ApplicationInfo applicationInfo) {
        Bundle bundle;
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return null;
        }
        Object obj = bundle.get("com.truecaller.android.sdk.PartnerKey");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public static int p2(int i2) {
        if (i2 >= 200 && i2 <= 299) {
            return 0;
        }
        if (i2 >= 300 && i2 <= 399) {
            return 1;
        }
        if (i2 >= 400 && i2 <= 499) {
            return 0;
        }
        if (i2 >= 500) {
        }
        return 1;
    }

    public static int p3(qw3<?> qw3, int i2, byte[] bArr, int i3, int i4, zu3<?> zu3, pt3 pt3) throws IOException {
        int r3 = r3(qw3, bArr, i3, i4, pt3);
        zu3.add(pt3.c);
        while (r3 < i4) {
            int t3 = t3(bArr, r3, pt3);
            if (i2 != pt3.f2847a) {
                break;
            }
            r3 = r3(qw3, bArr, t3, i4, pt3);
            zu3.add(pt3.c);
        }
        return r3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:115:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x020d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0047 A[SYNTHETIC, Splitter:B:15:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void q(android.widget.TextView r11, defpackage.yr5 r12) {
        /*
        // Method dump skipped, instructions count: 586
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hd3.q(android.widget.TextView, yr5):void");
    }

    public static int q0(byte[] bArr, int i2, s05.j<?> jVar, vz4 vz4) throws IOException {
        o05 o05 = (o05) jVar;
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a + z0;
        while (z0 < i3) {
            o05.d(Float.intBitsToFloat(h0(bArr, z0)));
            z0 += 4;
        }
        if (z0 == i3) {
            return z0;
        }
        throw t05.h();
    }

    public static final int q1(int i2, int i3, int i4) {
        if (i4 > 0) {
            if (i2 >= i3) {
                return i3;
            }
            return i3 - h2(h2(i3, i4) - h2(i2, i4), i4);
        } else if (i4 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (i2 <= i3) {
            return i3;
        } else {
            int i5 = -i4;
            return i3 + h2(h2(i2, i5) - h2(i3, i5), i5);
        }
    }

    public static List<qk5.a> q2(XmlResourceParser xmlResourceParser) throws IOException, XmlPullParserException {
        String str;
        ArrayList arrayList = new ArrayList();
        while (xmlResourceParser.next() != 1) {
            int eventType = xmlResourceParser.getEventType();
            String name = xmlResourceParser.getName();
            if (eventType == 2 && "ActionEntry".equals(name)) {
                qk5.a aVar = null;
                String attributeValue = xmlResourceParser.getAttributeValue(null, "class");
                String attributeValue2 = xmlResourceParser.getAttributeValue(null, "predicate");
                ArrayList arrayList2 = new ArrayList();
                while (xmlResourceParser.next() != 1) {
                    int eventType2 = xmlResourceParser.getEventType();
                    String name2 = xmlResourceParser.getName();
                    if (eventType2 == 2 && "name".equals(name2)) {
                        while (true) {
                            if (xmlResourceParser.next() == 1) {
                                break;
                            }
                            int eventType3 = xmlResourceParser.getEventType();
                            String name3 = xmlResourceParser.getName();
                            if (eventType3 != 4) {
                                if (eventType3 == 3 && "name".equals(name3)) {
                                    break;
                                }
                            } else {
                                str = xmlResourceParser.getText();
                                break;
                            }
                        }
                        str = null;
                        if (str != null) {
                            arrayList2.add(str);
                        }
                    }
                    if (eventType2 == 3 && "ActionEntry".equals(name2)) {
                        break;
                    }
                }
                if (arrayList2.isEmpty()) {
                    yj5.c("Action names not found.", new Object[0]);
                } else {
                    try {
                        aVar = new qk5.a(Class.forName(attributeValue).asSubclass(nk5.class), arrayList2);
                        if (!G1(attributeValue2)) {
                            try {
                                aVar.d = (qk5.b) Class.forName(attributeValue2).asSubclass(qk5.b.class).newInstance();
                            } catch (Exception unused) {
                                yj5.c("Predicate class %s not found. Skipping predicate.", attributeValue2);
                            }
                        }
                    } catch (ClassNotFoundException unused2) {
                        yj5.c("Action class %s not found.", attributeValue);
                    }
                }
                if (aVar != null) {
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    public static int q3(qw3 qw3, byte[] bArr, int i2, int i3, int i4, pt3 pt3) throws IOException {
        ew3 ew3 = (ew3) qw3;
        Object d2 = ew3.k.d(ew3.e);
        int l = ew3.l(d2, bArr, i2, i3, i4, pt3);
        ew3.a(d2);
        pt3.c = d2;
        return l;
    }

    public static void r(Context context, TextView textView, int i2) {
        if (i2 == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(context, i2);
        }
    }

    public static int r0(byte[] bArr, int i2, s05.j<?> jVar, vz4 vz4) throws IOException {
        r05 r05 = (r05) jVar;
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a + z0;
        while (z0 < i3) {
            z0 = z0(bArr, z0, vz4);
            r05.d(b05.b(vz4.f3697a));
        }
        if (z0 == i3) {
            return z0;
        }
        throw t05.h();
    }

    public static int r1(int[] iArr, int i2, boolean z) {
        int[] iArr2 = iArr;
        int i3 = 0;
        for (int i4 : iArr2) {
            i3 += i4;
        }
        int length = iArr2.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int i8 = length - 1;
            if (i5 >= i8) {
                return i6;
            }
            int i9 = 1 << i5;
            i7 |= i9;
            int i10 = 1;
            while (i10 < iArr2[i5]) {
                int i11 = i3 - i10;
                int i12 = length - i5;
                int i13 = i12 - 2;
                int J = J(i11 - 1, i13);
                if (z && i7 == 0) {
                    int i14 = i12 - 1;
                    if (i11 - i14 >= i14) {
                        J -= J(i11 - i12, i13);
                    }
                }
                if (i12 - 1 > 1) {
                    int i15 = 0;
                    for (int i16 = i11 - i13; i16 > i2; i16--) {
                        i15 += J((i11 - i16) - 1, i12 - 3);
                    }
                    J -= (i8 - i5) * i15;
                } else if (i11 > i2) {
                    J--;
                }
                i6 += J;
                i10++;
                i7 &= ~i9;
                iArr2 = iArr;
            }
            i3 -= i10;
            i5++;
            iArr2 = iArr;
        }
    }

    public static String r2(oi6 oi6) {
        String str;
        try {
            Map map = (Map) new Gson().fromJson(oi6.charStream(), Map.class);
            if (map == null) {
                return TrueException.TYPE_UNKNOWN_MESSAGE;
            }
            if (map.containsKey("message")) {
                Object obj = map.get("message");
                if (!(obj instanceof String)) {
                    return TrueException.TYPE_UNKNOWN_MESSAGE;
                }
                str = (String) obj;
            } else if (!map.containsKey("errors")) {
                return TrueException.TYPE_UNKNOWN_MESSAGE;
            } else {
                Object obj2 = map.get("errors");
                if (!(obj2 instanceof List) || ((List) obj2).isEmpty()) {
                    return TrueException.TYPE_UNKNOWN_MESSAGE;
                }
                Object obj3 = ((List) obj2).get(0);
                if (!(obj3 instanceof String)) {
                    return TrueException.TYPE_UNKNOWN_MESSAGE;
                }
                str = (String) obj3;
            }
            return str;
        } catch (JsonIOException | JsonSyntaxException unused) {
            return TrueException.TYPE_UNKNOWN_MESSAGE;
        }
    }

    public static int r3(qw3 qw3, byte[] bArr, int i2, int i3, pt3 pt3) throws IOException {
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        byte b3 = b2;
        if (b2 < 0) {
            i4 = o3(b2, bArr, i4, pt3);
            b3 = pt3.f2847a;
        }
        if (b3 < 0 || b3 > i3 - i4) {
            throw cv3.a();
        }
        Object zza = qw3.zza();
        int i5 = (b3 == 1 ? 1 : 0) + i4;
        qw3.f(zza, bArr, i4, i5, pt3);
        qw3.a(zza);
        pt3.c = zza;
        return i5;
    }

    public static final <T> w96<T> s(Iterator<? extends T> it) {
        n86.e(it, "$this$asSequence");
        x96 x96 = new x96(it);
        n86.e(x96, "$this$constrainOnce");
        return x96 instanceof t96 ? x96 : new t96(x96);
    }

    public static int s0(byte[] bArr, int i2, s05.j<?> jVar, vz4 vz4) throws IOException {
        a15 a15 = (a15) jVar;
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a + z0;
        while (z0 < i3) {
            z0 = B0(bArr, z0, vz4);
            a15.d(b05.c(vz4.b));
        }
        if (z0 == i3) {
            return z0;
        }
        throw t05.h();
    }

    public static String s1(Context context) {
        return new ADM(context).getRegistrationId();
    }

    public static Map<String, dw5> s2(Context context, XmlResourceParser xmlResourceParser) throws IOException, XmlPullParserException {
        HashMap hashMap = new HashMap();
        String str = null;
        dw5.b bVar = null;
        while (xmlResourceParser.next() != 1) {
            int eventType = xmlResourceParser.getEventType();
            String name = xmlResourceParser.getName();
            if (eventType == 2 && "UrbanAirshipActionButtonGroup".equals(name)) {
                String attributeValue = xmlResourceParser.getAttributeValue(null, "id");
                if (G1(attributeValue)) {
                    yj5.c("%s missing id.", "UrbanAirshipActionButtonGroup");
                } else {
                    bVar = new dw5.b();
                    str = attributeValue;
                }
            } else if (!G1(str)) {
                if (eventType == 2 && "UrbanAirshipActionButton".equals(name)) {
                    String attributeValue2 = xmlResourceParser.getAttributeValue(null, "id");
                    if (G1(attributeValue2)) {
                        yj5.c("%s missing id.", "UrbanAirshipActionButton");
                    } else {
                        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), com.urbanairship.R.styleable.UrbanAirshipActionButton);
                        cw5.b bVar2 = new cw5.b(attributeValue2);
                        bVar2.d = xmlResourceParser.getAttributeBooleanValue(null, "foreground", true);
                        bVar2.c = obtainStyledAttributes.getResourceId(com.urbanairship.R.styleable.UrbanAirshipActionButton_android_icon, 0);
                        bVar2.e = xmlResourceParser.getAttributeValue(null, "description");
                        int i2 = com.urbanairship.R.styleable.UrbanAirshipActionButton_android_label;
                        int resourceId = obtainStyledAttributes.getResourceId(i2, 0);
                        if (resourceId != 0) {
                            bVar2.b = resourceId;
                            bVar2.f = null;
                        } else {
                            String string = obtainStyledAttributes.getString(i2);
                            bVar2.b = 0;
                            bVar2.f = string;
                        }
                        bVar.f897a.add(new cw5(bVar2, new Bundle(), null));
                        obtainStyledAttributes.recycle();
                    }
                } else if (eventType == 3 && "UrbanAirshipActionButtonGroup".equals(name)) {
                    dw5 dw5 = new dw5(bVar.f897a, null);
                    if (((ArrayList) dw5.b()).isEmpty()) {
                        yj5.c("%s %s missing action buttons.", "UrbanAirshipActionButtonGroup", str);
                    } else {
                        hashMap.put(str, dw5);
                    }
                }
            }
        }
        return hashMap;
    }

    public static int s3(byte[] bArr, int i2) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static rb6 t(mb6 mb6, m66 m66, nb6 nb6, w76 w76, int i2, Object obj) {
        rb6 rb6;
        if ((i2 & 1) != 0) {
            m66 = o66.f;
        }
        nb6 nb62 = (i2 & 2) != 0 ? nb6.DEFAULT : null;
        m66 a2 = ib6.a(mb6, m66);
        if (nb62.isLazy()) {
            rb6 = new yc6(a2, w76);
        } else {
            rb6 = new sb6(a2, true);
        }
        nb62.invoke(w76, rb6, rb6);
        return rb6;
    }

    public static int t0(byte[] bArr, int i2, s05.j<?> jVar, vz4 vz4) throws IOException {
        r05 r05 = (r05) jVar;
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a + z0;
        while (z0 < i3) {
            z0 = z0(bArr, z0, vz4);
            r05.d(vz4.f3697a);
        }
        if (z0 == i3) {
            return z0;
        }
        throw t05.h();
    }

    public static final SSLSocketFactory t1(CrashlyticsPinningInfoProvider crashlyticsPinningInfoProvider) throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext instance = SSLContext.getInstance("TLS");
        instance.init(null, new TrustManager[]{new s16(new t16(crashlyticsPinningInfoProvider.getKeyStoreStream(), crashlyticsPinningInfoProvider.getKeyStorePassword()), crashlyticsPinningInfoProvider)}, null);
        return instance.getSocketFactory();
    }

    public static Map<String, Set<String>> t2(JsonValue jsonValue) {
        HashMap hashMap = new HashMap();
        if (jsonValue == null) {
            return hashMap;
        }
        Iterator<Map.Entry<String, JsonValue>> it = jsonValue.n().iterator();
        while (it.hasNext()) {
            Map.Entry<String, JsonValue> next = it.next();
            Set set = (Set) hashMap.get(next.getKey());
            if (set == null) {
                set = new HashSet();
                hashMap.put(next.getKey(), set);
            }
            Iterator<JsonValue> it2 = next.getValue().m().iterator();
            while (it2.hasNext()) {
                JsonValue next2 = it2.next();
                if (next2.f instanceof String) {
                    set.add(next2.i());
                }
            }
        }
        return hashMap;
    }

    public static int t3(byte[] bArr, int i2, pt3 pt3) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return o3(b2, bArr, i3, pt3);
        }
        pt3.f2847a = b2;
        return i3;
    }

    @RecentlyNonNull
    public static <TResult> TResult u(@RecentlyNonNull yi4<TResult> yi4) throws ExecutionException, InterruptedException {
        gj1.k("Must not be called on the main application thread");
        gj1.l(yi4, "Task must not be null");
        if (yi4.p()) {
            return (TResult) C3(yi4);
        }
        bj4 bj4 = new bj4(null);
        W3(yi4, bj4);
        bj4.f442a.await();
        return (TResult) C3(yi4);
    }

    public static int u0(byte[] bArr, int i2, s05.j<?> jVar, vz4 vz4) throws IOException {
        a15 a15 = (a15) jVar;
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a + z0;
        while (z0 < i3) {
            z0 = B0(bArr, z0, vz4);
            a15.d(vz4.b);
        }
        if (z0 == i3) {
            return z0;
        }
        throw t05.h();
    }

    public static String u1(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                sb.append(Integer.toHexString((b2 >> 4) & 15));
                sb.append(Integer.toHexString(b2 & 15));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    public static PorterDuff.Mode u2(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static int u3(byte[] bArr, int i2, zu3<?> zu3, pt3 pt3) throws IOException {
        uu3 uu3 = (uu3) zu3;
        int t3 = t3(bArr, i2, pt3);
        int i3 = pt3.f2847a + t3;
        while (t3 < i3) {
            t3 = t3(bArr, t3, pt3);
            uu3.k(pt3.f2847a);
        }
        if (t3 == i3) {
            return t3;
        }
        throw cv3.a();
    }

    @RecentlyNonNull
    public static <TResult> TResult v(@RecentlyNonNull yi4<TResult> yi4, long j, @RecentlyNonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        gj1.k("Must not be called on the main application thread");
        gj1.l(yi4, "Task must not be null");
        gj1.l(timeUnit, "TimeUnit must not be null");
        if (yi4.p()) {
            return (TResult) C3(yi4);
        }
        bj4 bj4 = new bj4(null);
        W3(yi4, bj4);
        if (bj4.f442a.await(j, timeUnit)) {
            return (TResult) C3(yi4);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static int v0(byte[] bArr, int i2, vz4 vz4) throws t05 {
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a;
        if (i3 < 0) {
            throw t05.f();
        } else if (i3 == 0) {
            vz4.c = "";
            return z0;
        } else {
            vz4.c = new String(bArr, z0, i3, s05.f3160a);
            return z0 + i3;
        }
    }

    public static String v1(long j) {
        Locale locale = Locale.getDefault();
        if (Build.VERSION.SDK_INT >= 24) {
            return pm4.c("yMMMd", locale).format(new Date(j));
        }
        AtomicReference<om4> atomicReference = pm4.f2830a;
        DateFormat dateInstance = DateFormat.getDateInstance(2, locale);
        dateInstance.setTimeZone(pm4.e());
        return dateInstance.format(new Date(j));
    }

    public static void v2(AnimatorSet animatorSet, List<Animator> list) {
        int size = list.size();
        long j = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Animator animator = list.get(i2);
            j = Math.max(j, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, 0);
        ofInt.setDuration(j);
        list.add(0, ofInt);
        animatorSet.playTogether(list);
    }

    public static <T> gg3<T> v3(gg3<T> gg3) {
        if ((gg3 instanceof hg3) || (gg3 instanceof ig3)) {
            return gg3;
        }
        if (gg3 instanceof Serializable) {
            return new ig3(gg3);
        }
        return new hg3(gg3);
    }

    public static <ResultT> ResultT w(ey4<ResultT> ey4) throws ExecutionException, InterruptedException {
        boolean z;
        c0(ey4, "Task must not be null");
        synchronized (ey4.f1045a) {
            z = ey4.c;
        }
        if (z) {
            return (ResultT) z(ey4);
        }
        fy4 fy4 = new fy4(null);
        Executor executor = rx4.b;
        ey4.b(executor, fy4);
        ey4.b.a(new vx4(executor, fy4));
        ey4.d();
        fy4.f1187a.await();
        return (ResultT) z(ey4);
    }

    public static int w0(byte[] bArr, int i2, vz4 vz4) throws t05 {
        int z0 = z0(bArr, i2, vz4);
        int i3 = vz4.f3697a;
        if (i3 < 0) {
            throw t05.f();
        } else if (i3 == 0) {
            vz4.c = "";
            return z0;
        } else {
            vz4.c = j25.b(bArr, z0, i3);
            return z0 + i3;
        }
    }

    public static void w1(PackageManager packageManager, ComponentName componentName, int i2) {
        ComponentInfo componentInfo;
        int componentEnabledSetting = packageManager.getComponentEnabledSetting(componentName);
        if (componentEnabledSetting != 1) {
            if (componentEnabledSetting != 2) {
                String packageName = componentName.getPackageName();
                String className = componentName.getClassName();
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(packageName, i2 | 512);
                    ComponentInfo[][] componentInfoArr = {packageInfo.activities, packageInfo.services, packageInfo.providers};
                    int i3 = 0;
                    loop0:
                    while (true) {
                        if (i3 >= 3) {
                            componentInfo = null;
                            break;
                        }
                        ComponentInfo[] componentInfoArr2 = componentInfoArr[i3];
                        if (componentInfoArr2 != null) {
                            int length = componentInfoArr2.length;
                            for (int i4 = 0; i4 < length; i4++) {
                                componentInfo = componentInfoArr2[i4];
                                if (componentInfo.name.equals(className)) {
                                    break loop0;
                                }
                            }
                            continue;
                        }
                        i3++;
                    }
                    if (componentInfo != null) {
                        if (componentInfo.isEnabled()) {
                            return;
                        }
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        }
    }

    public static final void w2(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                w2(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                w2(sb, i2, str, entry);
            }
        } else {
            sb.append('\n');
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(S0(a05.k((String) obj)));
                sb.append('\"');
            } else if (obj instanceof a05) {
                sb.append(": \"");
                sb.append(S0((a05) obj));
                sb.append('\"');
            } else if (obj instanceof q05) {
                sb.append(" {");
                C2((q05) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i5 = i2 + 2;
                w2(sb, i5, AnalyticsConstants.KEY, entry2.getKey());
                w2(sb, i5, FirebaseAnalytics.Param.VALUE, entry2.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    public static jl3 w3(Bundle bundle) {
        jl3.a l = jl3.l();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof String) {
                kl3.a m = kl3.m();
                String str2 = (String) obj;
                if (m.h) {
                    m.d();
                    m.h = false;
                }
                kl3.k((kl3) m.g, str2);
                il3.a l2 = il3.l();
                l2.h(str);
                l2.g((kl3) ((uh3) m.f()));
                l.g((il3) ((uh3) l2.f()));
            } else if (obj instanceof Bundle) {
                kl3.a m2 = kl3.m();
                jl3 w3 = w3((Bundle) obj);
                if (m2.h) {
                    m2.d();
                    m2.h = false;
                }
                kl3.j((kl3) m2.g, w3);
                il3.a l3 = il3.l();
                l3.h(str);
                l3.g((kl3) ((uh3) m2.f()));
                l.g((il3) ((uh3) l3.f()));
            } else if (obj instanceof String[]) {
                String[] strArr = (String[]) obj;
                for (String str3 : strArr) {
                    if (str3 != null) {
                        kl3.a m3 = kl3.m();
                        if (m3.h) {
                            m3.d();
                            m3.h = false;
                        }
                        kl3.k((kl3) m3.g, str3);
                        il3.a l4 = il3.l();
                        l4.h(str);
                        l4.g((kl3) ((uh3) m3.f()));
                        l.g((il3) ((uh3) l4.f()));
                    }
                }
            } else if (obj instanceof Bundle[]) {
                Bundle[] bundleArr = (Bundle[]) obj;
                for (Bundle bundle2 : bundleArr) {
                    if (bundle2 != null) {
                        kl3.a m4 = kl3.m();
                        jl3 w32 = w3(bundle2);
                        if (m4.h) {
                            m4.d();
                            m4.h = false;
                        }
                        kl3.j((kl3) m4.g, w32);
                        il3.a l5 = il3.l();
                        l5.h(str);
                        l5.g((kl3) ((uh3) m4.f()));
                        l.g((il3) ((uh3) l5.f()));
                    }
                }
            } else if (obj instanceof Boolean) {
                kl3.a m5 = kl3.m();
                boolean booleanValue = ((Boolean) obj).booleanValue();
                if (m5.h) {
                    m5.d();
                    m5.h = false;
                }
                kl3.l((kl3) m5.g, booleanValue);
                il3.a l6 = il3.l();
                l6.h(str);
                l6.g((kl3) ((uh3) m5.f()));
                l.g((il3) ((uh3) l6.f()));
            } else {
                String.valueOf(obj).length();
            }
        }
        if (bundle.containsKey("type")) {
            String string = bundle.getString("type");
            if (l.h) {
                l.d();
                l.h = false;
            }
            jl3.k((jl3) l.g, string);
        }
        return (jl3) ((uh3) l.f());
    }

    public static String x(File file) {
        if (file.getName().endsWith(".apk")) {
            String str = "";
            String replaceFirst = file.getName().replaceFirst("(_\\d+)?\\.apk", str);
            if (replaceFirst.equals("base-master")) {
                return str;
            }
            String str2 = "base-";
            if (replaceFirst.startsWith(str2)) {
                str = "config.";
            } else {
                replaceFirst = replaceFirst.replace("-", ".config.");
                str2 = ".config.master";
            }
            return replaceFirst.replace(str2, str);
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    public static int x0(int i2, byte[] bArr, int i3, int i4, f25 f25, vz4 vz4) throws t05 {
        if ((i2 >>> 3) != 0) {
            int i5 = i2 & 7;
            if (i5 == 0) {
                int B0 = B0(bArr, i3, vz4);
                f25.f(i2, Long.valueOf(vz4.b));
                return B0;
            } else if (i5 == 1) {
                f25.f(i2, Long.valueOf(i0(bArr, i3)));
                return i3 + 8;
            } else if (i5 == 2) {
                int z0 = z0(bArr, i3, vz4);
                int i6 = vz4.f3697a;
                if (i6 < 0) {
                    throw t05.f();
                } else if (i6 <= bArr.length - z0) {
                    if (i6 == 0) {
                        f25.f(i2, a05.g);
                    } else {
                        f25.f(i2, a05.e(bArr, z0, i6));
                    }
                    return z0 + i6;
                } else {
                    throw t05.h();
                }
            } else if (i5 == 3) {
                f25 e2 = f25.e();
                int i7 = (i2 & -8) | 4;
                int i8 = 0;
                while (true) {
                    if (i3 >= i4) {
                        break;
                    }
                    int z02 = z0(bArr, i3, vz4);
                    int i9 = vz4.f3697a;
                    if (i9 == i7) {
                        i8 = i9;
                        i3 = z02;
                        break;
                    }
                    i8 = i9;
                    i3 = x0(i9, bArr, z02, i4, e2, vz4);
                }
                if (i3 > i4 || i8 != i7) {
                    throw t05.g();
                }
                f25.f(i2, e2);
                return i3;
            } else if (i5 == 5) {
                f25.f(i2, Integer.valueOf(h0(bArr, i3)));
                return i3 + 4;
            } else {
                throw t05.b();
            }
        } else {
            throw t05.b();
        }
    }

    public static final void x1(m66 m66, Throwable th) {
        try {
            int i2 = CoroutineExceptionHandler.d;
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) m66.get(CoroutineExceptionHandler.a.f);
            if (coroutineExceptionHandler == null) {
                lb6.a(m66, th);
            } else {
                coroutineExceptionHandler.handleException(m66, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                l(runtimeException, th);
                th = runtimeException;
            }
            lb6.a(m66, th);
        }
    }

    public static void x2(Context context, RemoteMessage remoteMessage) {
        yv5 yv5 = new yv5(FcmPushProvider.class, new PushMessage(remoteMessage.getData()), null);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        yv5.a(context, new xv5(yv5, countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException e2) {
            yj5.e(e2, "Failed to wait for push.", new Object[0]);
            Thread.currentThread().interrupt();
        }
    }

    public static <T> ws3<T> x3(ws3<T> ws3) {
        if ((ws3 instanceof zs3) || (ws3 instanceof xs3)) {
            return ws3;
        }
        if (ws3 instanceof Serializable) {
            return new xs3(ws3);
        }
        return new zs3(ws3);
    }

    public static String y(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(String.format("%02x", Byte.valueOf(bArr[i2])));
        }
        return sb.toString();
    }

    public static int y0(int i2, byte[] bArr, int i3, vz4 vz4) {
        int i4 = i2 & 127;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            vz4.f3697a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i5 + 1;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            vz4.f3697a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i7 + 1;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            vz4.f3697a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i9 + 1;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            vz4.f3697a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] < 0) {
                i11 = i13;
            } else {
                vz4.f3697a = i12;
                return i13;
            }
        }
    }

    public static <T> void y1(T t, Class<T> cls) {
        if (t == null) {
            throw new IllegalStateException(String.valueOf(cls.getCanonicalName()).concat(" must be set"));
        }
    }

    public static void y2(Context context, String str) {
        Autopilot.d((Application) context.getApplicationContext(), false);
        if (UAirship.u || UAirship.v) {
            lk5 lk5 = new lk5(null, new wv5(FcmPushProvider.class, str));
            List<uj5> list = UAirship.y;
            synchronized (list) {
                if (UAirship.z) {
                    list.add(lk5);
                } else {
                    lk5.run();
                }
            }
        }
    }

    public static Boolean y3(byte b2) {
        if (b2 == 0) {
            return Boolean.FALSE;
        }
        if (b2 != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public static <ResultT> ResultT z(ey4<ResultT> ey4) throws ExecutionException {
        Exception exc;
        if (ey4.f()) {
            return ey4.e();
        }
        synchronized (ey4.f1045a) {
            exc = ey4.e;
        }
        throw new ExecutionException(exc);
    }

    public static int z0(byte[] bArr, int i2, vz4 vz4) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return y0(b2, bArr, i3, vz4);
        }
        vz4.f3697a = b2;
        return i3;
    }

    public static void z1(char c2) {
        String hexString = Integer.toHexString(c2);
        throw new IllegalArgumentException("Illegal character: " + c2 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static void z2(byte[] bArr, bw4 bw4, OutputStream outputStream, long j, int i2, long j2) throws IOException {
        InputStream c2;
        int i3 = i2;
        if (i3 < 0) {
            throw new IOException("copyLength negative");
        } else if (j >= 0) {
            long j3 = (long) i3;
            if (j3 <= j2) {
                try {
                    cw4 cw4 = new cw4(bw4, j, j3);
                    synchronized (cw4) {
                        c2 = cw4.c(0, cw4.a());
                    }
                    while (i3 > 0) {
                        try {
                            int min = Math.min(i3, 16384);
                            int i4 = 0;
                            while (i4 < min) {
                                int read = c2.read(bArr, i4, min - i4);
                                if (read != -1) {
                                    i4 += read;
                                } else {
                                    throw new IOException("truncated input stream");
                                }
                            }
                            outputStream.write(bArr, 0, min);
                            i3 -= min;
                        } catch (Throwable th) {
                            jw4.f1988a.a(th, th);
                        }
                    }
                    c2.close();
                    return;
                } catch (EOFException e2) {
                    throw new IOException("patch underrun", e2);
                }
            } else {
                throw new IOException("Output length overrun");
            }
        } else {
            throw new IOException("inputOffset negative");
        }
        throw th;
    }

    public static <T> T z3(Bundle bundle, String str, Class<T> cls, T t) {
        T t2 = (T) bundle.get(str);
        if (t2 == null) {
            return t;
        }
        if (cls.isAssignableFrom(t2.getClass())) {
            return t2;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", str, cls.getCanonicalName(), t2.getClass().getCanonicalName()));
    }
}
