package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.icu.text.DecimalFormatSymbols;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.Process;
import android.os.Trace;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.LongSparseArray;
import android.util.Property;
import android.util.Size;
import android.util.SizeF;
import android.util.TypedValue;
import android.util.Xml;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CompoundButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.R;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.rabbitmq.client.LongString;
import com.razorpay.AnalyticsConstants;
import defpackage.ej;
import defpackage.gj;
import defpackage.m66;
import defpackage.p7;
import defpackage.rj;
import defpackage.ub;
import defpackage.wl;
import defpackage.zg;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.zip.ZipException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: h  reason: default package */
/* compiled from: MediaDescriptionCompatApi21 */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static Field f1322a;
    public static boolean b;
    public static Class<?> c;
    public static boolean d;
    public static Field e;
    public static boolean f;
    public static Field g;
    public static boolean h;
    public static Method i;
    public static boolean j;
    public static Method k;
    public static boolean l;
    public static Field m;
    public static boolean n;
    public static Method o;
    public static boolean p;
    public static Field q;
    public static boolean r;
    public static long s;
    public static Method t;

    public static Path A(String str) {
        Path path = new Path();
        c6[] z = z(str);
        if (z == null) {
            return null;
        }
        try {
            c6.b(z, path);
            return path;
        } catch (RuntimeException e2) {
            throw new RuntimeException(hj1.S("Error in parsing ", str), e2);
        }
    }

    public static void A0(PopupWindow popupWindow, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setWindowLayoutType(i2);
            return;
        }
        if (!p) {
            try {
                Method declaredMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", Integer.TYPE);
                o = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Exception unused) {
            }
            p = true;
        }
        Method method = o;
        if (method != null) {
            try {
                method.invoke(popupWindow, Integer.valueOf(i2));
            } catch (Exception unused2) {
            }
        }
    }

    public static final <VM extends zh> j56<VM> B(Fragment fragment, n96<VM> n96, h76<? extends gi> h76, h76<? extends ci> h762) {
        n86.e(fragment, "$this$createViewModelLazy");
        n86.e(n96, "viewModelClass");
        n86.e(h76, "storeProducer");
        if (h762 == null) {
            h762 = new zf(fragment);
        }
        return new ai(n96, h76, h762);
    }

    public static final void B0(f0 f0Var, NavController navController, rj rjVar) {
        n86.f(f0Var, "$this$setupActionBarWithNavController");
        n86.f(navController, "navController");
        n86.f(rjVar, "configuration");
        qj qjVar = new qj(f0Var, rjVar);
        if (!navController.h.isEmpty()) {
            aj peekLast = navController.h.peekLast();
            qjVar.a(navController, peekLast.f, peekLast.g);
        }
        navController.l.add(qjVar);
    }

    public static <T extends wl> wl.a<T> C(Context context, Class<T> cls, String str) {
        if (str != null && str.trim().length() != 0) {
            return new wl.a<>(context, cls, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    public static void C0(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int i2 = 1;
        while (i2 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i2++;
            } else if (next == 3) {
                i2--;
            }
        }
    }

    public static c6[] D(c6[] c6VarArr) {
        if (c6VarArr == null) {
            return null;
        }
        c6[] c6VarArr2 = new c6[c6VarArr.length];
        for (int i2 = 0; i2 < c6VarArr.length; i2++) {
            c6VarArr2[i2] = new c6(c6VarArr[i2]);
        }
        return c6VarArr2;
    }

    public static List<byte[]> D0(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    public static String E(ub ubVar) {
        StringBuilder sb = new StringBuilder(ubVar.size());
        for (int i2 = 0; i2 < ubVar.size(); i2++) {
            byte b2 = ubVar.b(i2);
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

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: android.graphics.drawable.Drawable */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T E0(Drawable drawable) {
        return drawable instanceof m6 ? (T) ((m6) drawable).b() : drawable;
    }

    public static ri F(RandomAccessFile randomAccessFile) throws IOException, ZipException {
        long length = randomAccessFile.length() - 22;
        long j2 = 0;
        if (length >= 0) {
            long j3 = length - 65536;
            if (j3 >= 0) {
                j2 = j3;
            }
            int reverseBytes = Integer.reverseBytes(101010256);
            do {
                randomAccessFile.seek(length);
                if (randomAccessFile.readInt() == reverseBytes) {
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    randomAccessFile.skipBytes(2);
                    ri riVar = new ri();
                    riVar.b = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & LongString.MAX_LENGTH;
                    riVar.f3083a = ((long) Integer.reverseBytes(randomAccessFile.readInt())) & LongString.MAX_LENGTH;
                    return riVar;
                }
                length--;
            } while (length >= j2);
            throw new ZipException("End Of Central Directory signature not found");
        }
        StringBuilder i0 = hj1.i0("File too short to be a zip file: ");
        i0.append(randomAccessFile.length());
        throw new ZipException(i0.toString());
    }

    public static final <T> Object F0(zg zgVar, w76<? super mb6, ? super k66<? super T>, ? extends Object> w76, k66<? super T> k66) {
        zg.b bVar = zg.b.STARTED;
        xb6 xb6 = xb6.f3911a;
        return hd3.j3(xf6.c.A(), new sh(zgVar, bVar, w76, null), k66);
    }

    public static NavController G(View view) {
        NavController navController;
        NavController navController2;
        View view2 = view;
        while (true) {
            navController = null;
            if (view2 == null) {
                break;
            }
            Object tag = view2.getTag(R.id.nav_controller_view_tag);
            if (tag instanceof WeakReference) {
                navController2 = (NavController) ((WeakReference) tag).get();
            } else {
                navController2 = tag instanceof NavController ? (NavController) tag : null;
            }
            if (navController2 != null) {
                navController = navController2;
                break;
            }
            ViewParent parent = view2.getParent();
            view2 = parent instanceof View ? (View) parent : null;
        }
        if (navController != null) {
            return navController;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    public static final <T> Object G0(fh fhVar, w76<? super mb6, ? super k66<? super T>, ? extends Object> w76, k66<? super T> k66) {
        zg lifecycle = fhVar.getLifecycle();
        n86.d(lifecycle, "lifecycle");
        return F0(lifecycle, w76, k66);
    }

    public static final NavController H(Fragment fragment) {
        n86.f(fragment, "$this$findNavController");
        NavController d2 = NavHostFragment.d(fragment);
        n86.b(d2, "NavHostFragment.findNavController(this)");
        return d2;
    }

    public static Drawable H0(Drawable drawable) {
        return (Build.VERSION.SDK_INT < 23 && !(drawable instanceof l6)) ? new o6(drawable) : drawable;
    }

    public static void I(Object obj) {
        if (!d) {
            try {
                c = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException unused) {
            }
            d = true;
        }
        Class<?> cls = c;
        if (cls != null) {
            if (!f) {
                try {
                    Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                    e = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException unused2) {
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                LongSparseArray longSparseArray = null;
                try {
                    longSparseArray = (LongSparseArray) field.get(obj);
                } catch (IllegalAccessException unused3) {
                }
                if (longSparseArray != null) {
                    longSparseArray.clear();
                }
            }
        }
    }

    public static ActionMode.Callback I0(TextView textView, ActionMode.Callback callback) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 < 26 || i2 > 27 || (callback instanceof u9) || callback == null) ? callback : new u9(callback, textView);
    }

    public static Drawable J(CompoundButton compoundButton) {
        if (Build.VERSION.SDK_INT >= 23) {
            return compoundButton.getButtonDrawable();
        }
        if (!n) {
            try {
                Field declaredField = CompoundButton.class.getDeclaredField("mButtonDrawable");
                m = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            n = true;
        }
        Field field = m;
        if (field != null) {
            try {
                return (Drawable) field.get(compoundButton);
            } catch (IllegalAccessException unused2) {
                m = null;
            }
        }
        return null;
    }

    public static int K(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + "`");
        if (columnIndex2 >= 0) {
            return columnIndex2;
        }
        if (Build.VERSION.SDK_INT > 25 || str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        String S = hj1.S(".", str);
        String T = hj1.T(".", str, "`");
        for (int i2 = 0; i2 < columnNames.length; i2++) {
            String str2 = columnNames[i2];
            if (str2.length() >= str.length() + 2 && (str2.endsWith(S) || (str2.charAt(0) == '`' && str2.endsWith(T)))) {
                return i2;
            }
        }
        return -1;
    }

    public static int L(Cursor cursor, String str) {
        String str2;
        int K = K(cursor, str);
        if (K >= 0) {
            return K;
        }
        try {
            str2 = Arrays.toString(cursor.getColumnNames());
        } catch (Exception unused) {
            str2 = "";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }

    public static int M(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (!l) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                k = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            l = true;
        }
        Method method = k;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception unused2) {
                k = null;
            }
        }
        return 0;
    }

    public static u6 N(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new u6(new x6(configuration.getLocales()));
        }
        return u6.a(configuration.locale);
    }

    public static long O(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return packageInfo.getLongVersionCode();
        }
        return (long) packageInfo.versionCode;
    }

    public static s5 P(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i2, int i3) {
        s5 s5Var;
        if (a0(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i2, typedValue);
            int i4 = typedValue.type;
            if (i4 >= 28 && i4 <= 31) {
                return new s5(null, null, typedValue.data);
            }
            try {
                s5Var = s5.a(typedArray.getResources(), typedArray.getResourceId(i2, 0), theme);
            } catch (Exception unused) {
                s5Var = null;
            }
            if (s5Var != null) {
                return s5Var;
            }
        }
        return new s5(null, null, i3);
    }

    public static String Q(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i2) {
        if (!a0(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i2);
    }

    public static Intent R(Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        String T = T(activity);
        if (T == null) {
            return null;
        }
        ComponentName componentName = new ComponentName(activity, T);
        try {
            if (U(activity, componentName) == null) {
                return Intent.makeMainActivity(componentName);
            }
            return new Intent().setComponent(componentName);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Intent S(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String U = U(context, componentName);
        if (U == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), U);
        if (U(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static String T(Activity activity) {
        try {
            return U(activity, activity.getComponentName());
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static String U(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i2 = Build.VERSION.SDK_INT;
        int i3 = 640;
        if (i2 >= 29) {
            i3 = 269222528;
        } else if (i2 >= 24) {
            i3 = 787072;
        }
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i3);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static final kb6 V(wl wlVar) {
        n86.e(wlVar, "<this>");
        Map<String, Object> backingFieldMap = wlVar.getBackingFieldMap();
        n86.d(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("QueryDispatcher");
        if (obj == null) {
            Executor queryExecutor = wlVar.getQueryExecutor();
            n86.d(queryExecutor, "queryExecutor");
            if (queryExecutor instanceof wb6) {
                wb6 wb6 = (wb6) queryExecutor;
            }
            obj = new jc6(queryExecutor);
            backingFieldMap.put("QueryDispatcher", obj);
        }
        return (kb6) obj;
    }

    public static File W(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        StringBuilder i0 = hj1.i0(".font");
        i0.append(Process.myPid());
        i0.append("-");
        i0.append(Process.myTid());
        i0.append("-");
        String sb = i0.toString();
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(cacheDir, hj1.I(sb, i2));
            try {
                if (file.createNewFile()) {
                    return file;
                }
            } catch (IOException unused) {
            }
        }
        return null;
    }

    public static p7.a X(TextView textView) {
        int i2;
        int i3;
        TextDirectionHeuristic textDirectionHeuristic;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            return new p7.a(textView.getTextMetricsParams());
        }
        TextPaint textPaint = new TextPaint(textView.getPaint());
        boolean z = false;
        if (i4 >= 23) {
            i3 = 1;
            i2 = 1;
        } else {
            i3 = 0;
            i2 = 0;
        }
        TextDirectionHeuristic textDirectionHeuristic2 = TextDirectionHeuristics.FIRSTSTRONG_LTR;
        if (i4 >= 23) {
            i3 = textView.getBreakStrategy();
            i2 = textView.getHyphenationFrequency();
        }
        if (textView.getTransformationMethod() instanceof PasswordTransformationMethod) {
            textDirectionHeuristic = TextDirectionHeuristics.LTR;
        } else if (i4 < 28 || (textView.getInputType() & 15) != 3) {
            if (textView.getLayoutDirection() == 1) {
                z = true;
            }
            switch (textView.getTextDirection()) {
                case 2:
                    textDirectionHeuristic = TextDirectionHeuristics.ANYRTL_LTR;
                    break;
                case 3:
                    textDirectionHeuristic = TextDirectionHeuristics.LTR;
                    break;
                case 4:
                    textDirectionHeuristic = TextDirectionHeuristics.RTL;
                    break;
                case 5:
                    textDirectionHeuristic = TextDirectionHeuristics.LOCALE;
                    break;
                case 6:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    break;
                case 7:
                    textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                    break;
                default:
                    if (!z) {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                        break;
                    } else {
                        textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_RTL;
                        break;
                    }
            }
        } else {
            byte directionality = Character.getDirectionality(DecimalFormatSymbols.getInstance(textView.getTextLocale()).getDigitStrings()[0].codePointAt(0));
            if (directionality == 1 || directionality == 2) {
                textDirectionHeuristic = TextDirectionHeuristics.RTL;
            } else {
                textDirectionHeuristic = TextDirectionHeuristics.LTR;
            }
        }
        return new p7.a(textPaint, textDirectionHeuristic, i3, i2);
    }

    public static final kb6 Y(wl wlVar) {
        n86.e(wlVar, "<this>");
        Map<String, Object> backingFieldMap = wlVar.getBackingFieldMap();
        n86.d(backingFieldMap, "backingFieldMap");
        Object obj = backingFieldMap.get("TransactionDispatcher");
        if (obj == null) {
            Executor transactionExecutor = wlVar.getTransactionExecutor();
            n86.d(transactionExecutor, "transactionExecutor");
            if (transactionExecutor instanceof wb6) {
                wb6 wb6 = (wb6) transactionExecutor;
            }
            obj = new jc6(transactionExecutor);
            backingFieldMap.put("TransactionDispatcher", obj);
        }
        return (kb6) obj;
    }

    public static final mb6 Z(zh zhVar) {
        n86.e(zhVar, "$this$viewModelScope");
        mb6 mb6 = (mb6) zhVar.a("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (mb6 != null) {
            return mb6;
        }
        cb6 b2 = ec6.b(null, 1);
        xb6 xb6 = xb6.f3911a;
        Object c2 = zhVar.c("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new qg(m66.a.C0044a.d((wc6) b2, xf6.c.A())));
        n86.d(c2, "setTagIfAbsent(\n        …Main.immediate)\n        )");
        return (mb6) c2;
    }

    public static void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) throws nc {
        if (!d0(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !d0(b4) && !d0(b5)) {
                int i3 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i2] = (char) ((i3 >>> 10) + 55232);
                cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
                return;
            }
        }
        throw nc.b();
    }

    public static boolean a0(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static boolean b(byte b2) {
        return b2 >= 0;
    }

    public static boolean b0(Rect rect, Rect rect2, int i2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            if ((i3 > i4 || rect.left >= i4) && rect.left > rect2.left) {
                return true;
            }
            return false;
        } else if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            if ((i5 > i6 || rect.top >= i6) && rect.top > rect2.top) {
                return true;
            }
            return false;
        } else if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            if ((i7 < i8 || rect.right <= i8) && rect.right < rect2.right) {
                return true;
            }
            return false;
        } else if (i2 == 130) {
            int i9 = rect.top;
            int i10 = rect2.top;
            return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static void c(byte b2, byte b3, char[] cArr, int i2) throws nc {
        if (b2 < -62 || d0(b3)) {
            throw nc.b();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    @SuppressLint({"NewApi"})
    public static boolean c0() {
        try {
            if (t == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (t == null) {
                s = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                t = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) t.invoke(null, Long.valueOf(s))).booleanValue();
        } catch (Exception e2) {
            if (!(e2 instanceof InvocationTargetException)) {
                return false;
            }
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static void d(byte b2, byte b3, byte b4, char[] cArr, int i2) throws nc {
        if (d0(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || d0(b4)))) {
            throw nc.b();
        }
        cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static boolean d0(byte b2) {
        return b2 > -65;
    }

    public static l e(OnBackPressedDispatcher onBackPressedDispatcher, fh fhVar, boolean z, s76 s76, int i2) {
        if ((i2 & 1) != 0) {
            fhVar = null;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        n86.e(onBackPressedDispatcher, "$this$addCallback");
        n86.e(s76, "onBackPressed");
        m mVar = new m(s76, z, z);
        if (fhVar != null) {
            onBackPressedDispatcher.a(fhVar, mVar);
        } else {
            onBackPressedDispatcher.b.add(mVar);
            mVar.b.add(new OnBackPressedDispatcher.a(mVar));
        }
        return mVar;
    }

    public static ze e0(Context context, Fragment fragment, boolean z, boolean z2) {
        int i2;
        int i3;
        int nextTransition = fragment.getNextTransition();
        if (z2) {
            if (z) {
                i2 = fragment.getPopEnterAnim();
            } else {
                i2 = fragment.getPopExitAnim();
            }
        } else if (z) {
            i2 = fragment.getEnterAnim();
        } else {
            i2 = fragment.getExitAnim();
        }
        boolean z3 = false;
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i4 = androidx.fragment.R.id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i4) != null) {
                fragment.mContainer.setTag(i4, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, i2);
        if (onCreateAnimation != null) {
            return new ze(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, i2);
        if (onCreateAnimator != null) {
            return new ze(onCreateAnimator);
        }
        if (i2 == 0 && nextTransition != 0) {
            if (nextTransition == 4097) {
                i3 = z ? androidx.fragment.R.animator.fragment_open_enter : androidx.fragment.R.animator.fragment_open_exit;
            } else if (nextTransition == 4099) {
                i3 = z ? androidx.fragment.R.animator.fragment_fade_enter : androidx.fragment.R.animator.fragment_fade_exit;
            } else if (nextTransition != 8194) {
                i2 = -1;
            } else {
                i3 = z ? androidx.fragment.R.animator.fragment_close_enter : androidx.fragment.R.animator.fragment_close_exit;
            }
            i2 = i3;
        }
        if (i2 != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(i2));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, i2);
                    if (loadAnimation != null) {
                        return new ze(loadAnimation);
                    }
                    z3 = true;
                } catch (Resources.NotFoundException e2) {
                    throw e2;
                } catch (RuntimeException unused) {
                }
            }
            if (!z3) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
                    if (loadAnimator != null) {
                        return new ze(loadAnimator);
                    }
                } catch (RuntimeException e3) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i2);
                        if (loadAnimation2 != null) {
                            return new ze(loadAnimation2);
                        }
                    } else {
                        throw e3;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01db, code lost:
        if (r5 == r6) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x01ee, code lost:
        if (r5 == 2) goto L_0x01f0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01f6, code lost:
        r22 = r17;
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02c1, code lost:
        if (r3[r15].d.b == r6) goto L_0x02c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x014b, code lost:
        if (r4[r2].d.b == r5) goto L_0x014f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x0346  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x036e  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x037e  */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x0470  */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x04db  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x04e3 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:324:0x05c9  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x05dc  */
    /* JADX WARNING: Removed duplicated region for block: B:337:0x05e9  */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x06b1  */
    /* JADX WARNING: Removed duplicated region for block: B:385:0x06ee  */
    /* JADX WARNING: Removed duplicated region for block: B:399:0x0721  */
    /* JADX WARNING: Removed duplicated region for block: B:400:0x0724  */
    /* JADX WARNING: Removed duplicated region for block: B:403:0x072a  */
    /* JADX WARNING: Removed duplicated region for block: B:404:0x072d  */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x0733  */
    /* JADX WARNING: Removed duplicated region for block: B:412:0x0743  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0155 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:436:0x05cb A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0152  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(defpackage.o3 r35, defpackage.f3 r36, int r37) {
        /*
        // Method dump skipped, instructions count: 1910
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h.f(o3, f3, int):void");
    }

    public static int f0(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i4 = rect.left;
            i3 = rect2.right;
        } else if (i2 == 33) {
            i4 = rect.top;
            i3 = rect2.bottom;
        } else if (i2 == 66) {
            i4 = rect2.left;
            i3 = rect.right;
        } else if (i2 == 130) {
            i4 = rect2.top;
            i3 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return Math.max(0, i4 - i3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r10.right <= r12.left) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if (r10.top >= r12.bottom) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        if (r10.left >= r12.right) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        r7 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        if (r10.bottom <= r12.top) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean g(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
        // Method dump skipped, instructions count: 126
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h.g(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean g0(ej ejVar, Set<Integer> set) {
        while (!set.contains(Integer.valueOf(ejVar.h))) {
            ejVar = ejVar.g;
            if (ejVar == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean h(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    public static int h0(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static void i(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append(AnalyticsConstants.NULL);
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static ByteBuffer i0(Context context, CancellationSignal cancellationSignal, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                    fileInputStream.close();
                    openFileDescriptor.close();
                    return map;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
            throw th;
        } catch (IOException unused) {
            return null;
        }
    }

    public static final Bundle j(m56<String, ? extends Object>... m56Arr) {
        n86.e(m56Arr, "pairs");
        Bundle bundle = new Bundle(m56Arr.length);
        int length = m56Arr.length;
        int i2 = 0;
        while (i2 < length) {
            m56<String, ? extends Object> m56 = m56Arr[i2];
            i2++;
            A a2 = m56.f;
            B b2 = m56.g;
            if (b2 == null) {
                bundle.putString(a2, null);
            } else if (b2 instanceof Boolean) {
                bundle.putBoolean(a2, b2.booleanValue());
            } else if (b2 instanceof Byte) {
                bundle.putByte(a2, b2.byteValue());
            } else if (b2 instanceof Character) {
                bundle.putChar(a2, b2.charValue());
            } else if (b2 instanceof Double) {
                bundle.putDouble(a2, b2.doubleValue());
            } else if (b2 instanceof Float) {
                bundle.putFloat(a2, b2.floatValue());
            } else if (b2 instanceof Integer) {
                bundle.putInt(a2, b2.intValue());
            } else if (b2 instanceof Long) {
                bundle.putLong(a2, b2.longValue());
            } else if (b2 instanceof Short) {
                bundle.putShort(a2, b2.shortValue());
            } else if (b2 instanceof Bundle) {
                bundle.putBundle(a2, b2);
            } else if (b2 instanceof CharSequence) {
                bundle.putCharSequence(a2, b2);
            } else if (b2 instanceof Parcelable) {
                bundle.putParcelable(a2, b2);
            } else if (b2 instanceof boolean[]) {
                bundle.putBooleanArray(a2, (boolean[]) b2);
            } else if (b2 instanceof byte[]) {
                bundle.putByteArray(a2, (byte[]) b2);
            } else if (b2 instanceof char[]) {
                bundle.putCharArray(a2, (char[]) b2);
            } else if (b2 instanceof double[]) {
                bundle.putDoubleArray(a2, (double[]) b2);
            } else if (b2 instanceof float[]) {
                bundle.putFloatArray(a2, (float[]) b2);
            } else if (b2 instanceof int[]) {
                bundle.putIntArray(a2, (int[]) b2);
            } else if (b2 instanceof long[]) {
                bundle.putLongArray(a2, (long[]) b2);
            } else if (b2 instanceof short[]) {
                bundle.putShortArray(a2, (short[]) b2);
            } else if (b2 instanceof Object[]) {
                Class<?> componentType = b2.getClass().getComponentType();
                n86.c(componentType);
                if (Parcelable.class.isAssignableFrom(componentType)) {
                    bundle.putParcelableArray(a2, (Parcelable[]) b2);
                } else if (String.class.isAssignableFrom(componentType)) {
                    bundle.putStringArray(a2, (String[]) b2);
                } else if (CharSequence.class.isAssignableFrom(componentType)) {
                    bundle.putCharSequenceArray(a2, (CharSequence[]) b2);
                } else if (Serializable.class.isAssignableFrom(componentType)) {
                    bundle.putSerializable(a2, b2);
                } else {
                    String canonicalName = componentType.getCanonicalName();
                    throw new IllegalArgumentException("Illegal value array type " + ((Object) canonicalName) + " for key \"" + ((String) a2) + '\"');
                }
            } else if (b2 instanceof Serializable) {
                bundle.putSerializable(a2, b2);
            } else if (b2 instanceof IBinder) {
                bundle.putBinder(a2, b2);
            } else if (b2 instanceof Size) {
                bundle.putSize(a2, b2);
            } else if (b2 instanceof SizeF) {
                bundle.putSizeF(a2, b2);
            } else {
                String canonicalName2 = b2.getClass().getCanonicalName();
                throw new IllegalArgumentException("Illegal value type " + ((Object) canonicalName2) + " for key \"" + ((String) a2) + '\"');
            }
        }
        return bundle;
    }

    public static final boolean j0(NavController navController, rj rjVar) {
        boolean z;
        Intent intent;
        n86.f(navController, "$this$navigateUp");
        n86.f(rjVar, "appBarConfiguration");
        ea eaVar = rjVar.b;
        ej c2 = navController.c();
        Set<Integer> set = rjVar.f3086a;
        if (eaVar == null || c2 == null || !g0(c2, set)) {
            if (navController.d() == 1) {
                ej c3 = navController.c();
                int i2 = c3.h;
                gj gjVar = c3.g;
                while (true) {
                    if (gjVar == null) {
                        z = false;
                        break;
                    } else if (gjVar.o != i2) {
                        Bundle bundle = new Bundle();
                        Activity activity = navController.b;
                        if (!(activity == null || activity.getIntent() == null || navController.b.getIntent().getData() == null)) {
                            bundle.putParcelable("android-support-nav:controller:deepLinkIntent", navController.b.getIntent());
                            ej.a n2 = navController.d.n(new dj(navController.b.getIntent()));
                            if (n2 != null) {
                                bundle.putAll(n2.f.b(n2.g));
                            }
                        }
                        Context context = navController.f226a;
                        if (context instanceof Activity) {
                            intent = new Intent(context, context.getClass());
                        } else {
                            intent = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
                            if (intent == null) {
                                intent = new Intent();
                            }
                        }
                        intent.addFlags(268468224);
                        gj gjVar2 = navController.d;
                        if (gjVar2 != null) {
                            int i3 = gjVar.h;
                            ArrayDeque arrayDeque = new ArrayDeque();
                            arrayDeque.add(gjVar2);
                            ej ejVar = null;
                            while (!arrayDeque.isEmpty() && ejVar == null) {
                                ej ejVar2 = (ej) arrayDeque.poll();
                                if (ejVar2.h == i3) {
                                    ejVar = ejVar2;
                                } else if (ejVar2 instanceof gj) {
                                    gj.a aVar = new gj.a();
                                    while (aVar.hasNext()) {
                                        arrayDeque.add((ej) aVar.next());
                                    }
                                }
                            }
                            if (ejVar != null) {
                                intent.putExtra("android-support-nav:controller:deepLinkIds", ejVar.d());
                                intent.putExtra("android-support-nav:controller:deepLinkExtras", bundle);
                                if (intent.getIntArrayExtra("android-support-nav:controller:deepLinkIds") != null) {
                                    p5 p5Var = new p5(context);
                                    p5Var.b(new Intent(intent));
                                    for (int i4 = 0; i4 < p5Var.f.size(); i4++) {
                                        p5Var.f.get(i4).putExtra("android-support-nav:controller:deepLinkIntent", intent);
                                    }
                                    p5Var.e();
                                    Activity activity2 = navController.b;
                                    if (activity2 != null) {
                                        activity2.finish();
                                    }
                                    z = true;
                                } else {
                                    throw new IllegalStateException("You must call setDestination() before constructing the deep link");
                                }
                            } else {
                                String k2 = ej.k(context, i3);
                                throw new IllegalArgumentException("Navigation destination " + k2 + " cannot be found in the navigation graph " + gjVar2);
                            }
                        } else {
                            throw new IllegalStateException("You must call setGraph() before calling getGraph()");
                        }
                    } else {
                        i2 = gjVar.h;
                        gjVar = gjVar.g;
                    }
                }
            } else {
                z = navController.g();
            }
            if (!z) {
                rj.b bVar = rjVar.c;
                if (bVar != null) {
                    return bVar.a();
                }
                return false;
            }
        } else {
            eaVar.a();
        }
        return true;
    }

    public static final String k(String str) {
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

    public static TypedArray k0(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static boolean l(c6[] c6VarArr, c6[] c6VarArr2) {
        if (c6VarArr == null || c6VarArr2 == null || c6VarArr.length != c6VarArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < c6VarArr.length; i2++) {
            if (!(c6VarArr[i2].f524a == c6VarArr2[i2].f524a && c6VarArr[i2].b.length == c6VarArr2[i2].b.length)) {
                return false;
            }
        }
        return true;
    }

    public static <T> ObjectAnimator l0(T t2, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t2, property, (TypeConverter) null, path);
    }

    public static void m(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static t5 m0(XmlPullParser xmlPullParser, Resources resources) throws XmlPullParserException, IOException {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlPullParser.require(2, null, "font-family");
            if (xmlPullParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), androidx.core.R.styleable.FontFamily);
                String string = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderAuthority);
                String string2 = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderPackage);
                String string3 = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderQuery);
                int resourceId = obtainAttributes.getResourceId(androidx.core.R.styleable.FontFamily_fontProviderCerts, 0);
                int integer = obtainAttributes.getInteger(androidx.core.R.styleable.FontFamily_fontProviderFetchStrategy, 1);
                int integer2 = obtainAttributes.getInteger(androidx.core.R.styleable.FontFamily_fontProviderFetchTimeout, 500);
                String string4 = obtainAttributes.getString(androidx.core.R.styleable.FontFamily_fontProviderSystemFontFamily);
                obtainAttributes.recycle();
                if (string == null || string2 == null || string3 == null) {
                    ArrayList arrayList = new ArrayList();
                    while (xmlPullParser.next() != 3) {
                        if (xmlPullParser.getEventType() == 2) {
                            if (xmlPullParser.getName().equals("font")) {
                                TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), androidx.core.R.styleable.FontFamilyFont);
                                int i2 = androidx.core.R.styleable.FontFamilyFont_fontWeight;
                                if (!obtainAttributes2.hasValue(i2)) {
                                    i2 = androidx.core.R.styleable.FontFamilyFont_android_fontWeight;
                                }
                                int i3 = obtainAttributes2.getInt(i2, 400);
                                int i4 = androidx.core.R.styleable.FontFamilyFont_fontStyle;
                                if (!obtainAttributes2.hasValue(i4)) {
                                    i4 = androidx.core.R.styleable.FontFamilyFont_android_fontStyle;
                                }
                                boolean z = 1 == obtainAttributes2.getInt(i4, 0);
                                int i5 = androidx.core.R.styleable.FontFamilyFont_ttcIndex;
                                if (!obtainAttributes2.hasValue(i5)) {
                                    i5 = androidx.core.R.styleable.FontFamilyFont_android_ttcIndex;
                                }
                                int i6 = androidx.core.R.styleable.FontFamilyFont_fontVariationSettings;
                                if (!obtainAttributes2.hasValue(i6)) {
                                    i6 = androidx.core.R.styleable.FontFamilyFont_android_fontVariationSettings;
                                }
                                String string5 = obtainAttributes2.getString(i6);
                                int i7 = obtainAttributes2.getInt(i5, 0);
                                int i8 = androidx.core.R.styleable.FontFamilyFont_font;
                                if (!obtainAttributes2.hasValue(i8)) {
                                    i8 = androidx.core.R.styleable.FontFamilyFont_android_font;
                                }
                                int resourceId2 = obtainAttributes2.getResourceId(i8, 0);
                                String string6 = obtainAttributes2.getString(i8);
                                obtainAttributes2.recycle();
                                while (xmlPullParser.next() != 3) {
                                    C0(xmlPullParser);
                                }
                                arrayList.add(new v5(string6, i3, z, string5, i7, resourceId2));
                            } else {
                                C0(xmlPullParser);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        return null;
                    }
                    return new u5((v5[]) arrayList.toArray(new v5[arrayList.size()]));
                }
                while (xmlPullParser.next() != 3) {
                    C0(xmlPullParser);
                }
                return new w5(new d7(string, string2, string3, o0(resources, resourceId)), integer, integer2, string4);
            }
            C0(xmlPullParser);
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static int n(int i2) {
        if (i2 >= 0) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public static final void n0(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                n0(sb, i2, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                n0(sb, i2, str, entry);
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
                ub ubVar = ub.g;
                sb.append(E(new ub.e(((String) obj).getBytes(mc.f2352a))));
                sb.append('\"');
            } else if (obj instanceof ub) {
                sb.append(": \"");
                sb.append(E((ub) obj));
                sb.append('\"');
            } else if (obj instanceof kc) {
                sb.append(" {");
                p0((kc) obj, sb, i2 + 2);
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
                n0(sb, i5, AnalyticsConstants.KEY, entry2.getKey());
                n0(sb, i5, FirebaseAnalytics.Param.VALUE, entry2.getValue());
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

    public static <T> T o(T t2, Object obj) {
        if (t2 != null) {
            return t2;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static List<List<byte[]>> o0(Resources resources, int i2) {
        if (i2 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i2);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (obtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(D0(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(D0(resources.getStringArray(i2)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static int p(Context context, String str, int i2, int i3, String str2) {
        if (context.checkPermission(str, i2, i3) == -1) {
            return -1;
        }
        int i4 = Build.VERSION.SDK_INT;
        String permissionToOp = i4 >= 23 ? AppOpsManager.permissionToOp(str) : null;
        if (permissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        if ((i4 >= 23 ? ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, str2) : 1) != 0) {
            return -2;
        }
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01cd, code lost:
        if (((java.lang.Integer) r11).intValue() == 0) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01de, code lost:
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01f0, code lost:
        if (((java.lang.Double) r11).doubleValue() == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) goto L_0x0222;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void p0(defpackage.dd r18, java.lang.StringBuilder r19, int r20) {
        /*
        // Method dump skipped, instructions count: 652
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h.p0(dd, java.lang.StringBuilder, int):void");
    }

    public static int q(Context context, String str) {
        return p(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static void q0(TextView textView, int i2) {
        int i3;
        n(i2);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setFirstBaselineToTopHeight(i2);
            return;
        }
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.top;
        } else {
            i3 = fontMetricsInt.ascent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), i2 + i3, textView.getPaddingRight(), textView.getPaddingBottom());
        }
    }

    public static int r(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static void r0(TextView textView, int i2) {
        int i3;
        n(i2);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        if (textView.getIncludeFontPadding()) {
            i3 = fontMetricsInt.bottom;
        } else {
            i3 = fontMetricsInt.descent;
        }
        if (i2 > Math.abs(i3)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i2 - i3);
        }
    }

    public static void s(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            s(((InsetDrawable) drawable).getDrawable());
        } else if (drawable instanceof m6) {
            s(((m6) drawable).b());
        } else if ((drawable instanceof DrawableContainer) && (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) != null) {
            int childCount = drawableContainerState.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                Drawable child = drawableContainerState.getChild(i2);
                if (child != null) {
                    s(child);
                }
            }
        }
    }

    public static boolean s0(Drawable drawable, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i2);
        }
        if (!j) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", Integer.TYPE);
                i = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            j = true;
        }
        Method method = i;
        if (method != null) {
            try {
                method.invoke(drawable, Integer.valueOf(i2));
                return true;
            } catch (Exception unused2) {
                i = null;
            }
        }
        return false;
    }

    public static int t(RecyclerView.x xVar, uk ukVar, View view, View view2, RecyclerView.m mVar, boolean z) {
        if (mVar.K() == 0 || xVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(mVar.a0(view) - mVar.a0(view2)) + 1;
        }
        return Math.min(ukVar.l(), ukVar.b(view2) - ukVar.e(view));
    }

    public static void t0(TextView textView, int i2) {
        n(i2);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i2 != fontMetricsInt) {
            textView.setLineSpacing((float) (i2 - fontMetricsInt), 1.0f);
        }
    }

    public static int u(RecyclerView.x xVar, uk ukVar, View view, View view2, RecyclerView.m mVar, boolean z, boolean z2) {
        int i2;
        if (mVar.K() == 0 || xVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(mVar.a0(view), mVar.a0(view2));
        int max = Math.max(mVar.a0(view), mVar.a0(view2));
        if (z2) {
            i2 = Math.max(0, (xVar.b() - max) - 1);
        } else {
            i2 = Math.max(0, min);
        }
        if (!z) {
            return i2;
        }
        return Math.round((((float) i2) * (((float) Math.abs(ukVar.b(view2) - ukVar.e(view))) / ((float) (Math.abs(mVar.a0(view) - mVar.a0(view2)) + 1)))) + ((float) (ukVar.k() - ukVar.e(view))));
    }

    public static void u0(PopupWindow popupWindow, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            popupWindow.setOverlapAnchor(z);
            return;
        }
        if (!r) {
            try {
                Field declaredField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
                q = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            r = true;
        }
        Field field = q;
        if (field != null) {
            try {
                field.set(popupWindow, Boolean.valueOf(z));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public static int v(RecyclerView.x xVar, uk ukVar, View view, View view2, RecyclerView.m mVar, boolean z) {
        if (mVar.K() == 0 || xVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return xVar.b();
        }
        return (int) ((((float) (ukVar.b(view2) - ukVar.e(view))) / ((float) (Math.abs(mVar.a0(view) - mVar.a0(view2)) + 1))) * ((float) xVar.b()));
    }

    public static void v0(TextView textView, p7 p7Var) {
        if (Build.VERSION.SDK_INT >= 29) {
            Objects.requireNonNull(p7Var);
            textView.setText((CharSequence) null);
            return;
        }
        p7.a X = X(textView);
        Objects.requireNonNull(p7Var);
        if (X.a(null)) {
            textView.setText(p7Var);
            return;
        }
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    public static float[] w(float[] fArr, int i2, int i3) {
        if (i2 <= i3) {
            int length = fArr.length;
            if (i2 < 0 || i2 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i4 = i3 - i2;
            int min = Math.min(i4, length - i2);
            float[] fArr2 = new float[i4];
            System.arraycopy(fArr, i2, fArr2, 0, min);
            return fArr2;
        }
        throw new IllegalArgumentException();
    }

    public static void w0(TextView textView, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            textView.setTextAppearance(i2);
        } else {
            textView.setTextAppearance(textView.getContext(), i2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0014 A[SYNTHETIC, Splitter:B:13:0x0014] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean x(java.io.File r0, android.content.res.Resources r1, int r2) {
        /*
            java.io.InputStream r1 = r1.openRawResource(r2)     // Catch:{ all -> 0x0010 }
            boolean r0 = y(r0, r1)     // Catch:{ all -> 0x000e }
            if (r1 == 0) goto L_0x000d
            r1.close()     // Catch:{ IOException -> 0x000d }
        L_0x000d:
            return r0
        L_0x000e:
            r0 = move-exception
            goto L_0x0012
        L_0x0010:
            r0 = move-exception
            r1 = 0
        L_0x0012:
            if (r1 == 0) goto L_0x0017
            r1.close()     // Catch:{ IOException -> 0x0017 }
        L_0x0017:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h.x(java.io.File, android.content.res.Resources, int):boolean");
    }

    public static void x0(Drawable drawable, int i2) {
        drawable.setTint(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0030 A[SYNTHETIC, Splitter:B:24:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0039 A[SYNTHETIC, Splitter:B:30:0x0039] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean y(java.io.File r5, java.io.InputStream r6) {
        /*
            android.os.StrictMode$ThreadPolicy r0 = android.os.StrictMode.allowThreadDiskWrites()
            r1 = 0
            r2 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002a }
            r3.<init>(r5, r1)     // Catch:{ IOException -> 0x002a }
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
        L_0x000f:
            int r2 = r6.read(r5)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            r4 = -1
            if (r2 == r4) goto L_0x001a
            r3.write(r5, r1, r2)     // Catch:{ IOException -> 0x0025, all -> 0x0022 }
            goto L_0x000f
        L_0x001a:
            r5 = 1
            r3.close()     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            android.os.StrictMode.setThreadPolicy(r0)
            return r5
        L_0x0022:
            r5 = move-exception
            r2 = r3
            goto L_0x0037
        L_0x0025:
            r5 = move-exception
            r2 = r3
            goto L_0x002b
        L_0x0028:
            r5 = move-exception
            goto L_0x0037
        L_0x002a:
            r5 = move-exception
        L_0x002b:
            r5.getMessage()     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x0033
            r2.close()     // Catch:{ IOException -> 0x0033 }
        L_0x0033:
            android.os.StrictMode.setThreadPolicy(r0)
            return r1
        L_0x0037:
            if (r2 == 0) goto L_0x003c
            r2.close()     // Catch:{ IOException -> 0x003c }
        L_0x003c:
            android.os.StrictMode.setThreadPolicy(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h.y(java.io.File, java.io.InputStream):boolean");
    }

    public static void y0(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008b, code lost:
        if (r13 == false) goto L_0x008d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0098 A[Catch:{ NumberFormatException -> 0x00ba }, LOOP:3: B:25:0x006d->B:45:0x0098, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d7 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0097 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.c6[] z(java.lang.String r16) {
        /*
        // Method dump skipped, instructions count: 272
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h.z(java.lang.String):c6[]");
    }

    public static void z0(Drawable drawable, PorterDuff.Mode mode) {
        drawable.setTintMode(mode);
    }
}
