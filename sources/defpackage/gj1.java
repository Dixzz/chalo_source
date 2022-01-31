package defpackage;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Property;
import androidx.annotation.RecentlyNonNull;
import app.zophop.pubsub.eventbus.events.CardValidityCheckEvent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.appindexing.Indexable;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.LongString;
import com.rabbitmq.client.StringRpcServer;
import com.razorpay.AnalyticsConstants;
import defpackage.cm1;
import defpackage.jj1;
import j$.util.DesugarTimeZone;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECField;
import java.security.spec.ECFieldFp;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: gj1  reason: default package */
/* compiled from: ZophopMarkerAnimator */
public class gj1 {

    /* renamed from: a  reason: collision with root package name */
    public static xa2 f1270a;
    public static Boolean b;
    public static Boolean c;
    public static Boolean d;
    public static Boolean e;

    /* renamed from: gj1$a */
    /* compiled from: ZophopMarkerAnimator */
    public enum a {
        LINEAR,
        ACCELERATE,
        DECELARATE,
        SPHERICAL
    }

    @RecentlyNonNull
    public static <T> T[] A(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        T[] tArr = (T[]) parcel.createTypedArray(creator);
        parcel.setDataPosition(dataPosition + j0);
        return tArr;
    }

    public static void A0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int o1 = o1(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static int A1(du2 du2) throws GeneralSecurityException {
        jt2 jt2 = jt2.UNKNOWN_FORMAT;
        du2 du22 = du2.UNKNOWN_CURVE;
        ju2 ju2 = ju2.UNKNOWN_HASH;
        int ordinal = du2.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(du2);
                throw new GeneralSecurityException(hj1.a0(new StringBuilder(valueOf.length() + 20), "unknown curve type: ", valueOf));
            }
        }
        return i;
    }

    @RecentlyNonNull
    public static <T> ArrayList<T> B(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        ArrayList<T> createTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(dataPosition + j0);
        return createTypedArrayList;
    }

    public static void B0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String str, boolean z) {
        if (str != null) {
            int o1 = o1(parcel, i);
            parcel.writeString(str);
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static int B1(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static void C(String str, String str2, Object obj) {
        L(str);
        String.format(str2, obj);
    }

    public static void C0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull String[] strArr, boolean z) {
        if (strArr != null) {
            int o1 = o1(parcel, i);
            parcel.writeStringArray(strArr);
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static int C1(byte[] bArr, int i, qf2 qf2) {
        int L0 = L0(bArr, i, qf2);
        int i2 = qf2.f2938a;
        if (i2 == 0) {
            qf2.c = "";
            return L0;
        }
        qf2.c = new String(bArr, L0, i2, wg2.f3775a);
        return L0 + i2;
    }

    @RecentlyNonNull
    public static <T extends SafeParcelable> T D(@RecentlyNonNull byte[] bArr, @RecentlyNonNull Parcelable.Creator<T> creator) {
        Objects.requireNonNull(creator, "null reference");
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T createFromParcel = creator.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    public static void D0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull List<String> list, boolean z) {
        if (list != null) {
            int o1 = o1(parcel, i);
            parcel.writeStringList(list);
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static int D1(byte[] bArr, int i, v83 v83) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j < 0) {
            int i3 = i2 + 1;
            byte b2 = bArr[i2];
            long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
            int i4 = 7;
            while (b2 < 0) {
                int i5 = i3 + 1;
                byte b3 = bArr[i3];
                i4 += 7;
                j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i4;
                b2 = b3;
                i3 = i5;
            }
            v83.b = j2;
            return i3;
        }
        v83.b = j;
        return i2;
    }

    @RecentlyNonNull
    public static String E(@RecentlyNonNull byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }

    public static <T extends Parcelable> void E0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int o1 = o1(parcel, i);
            int length = tArr.length;
            parcel.writeInt(length);
            for (T t : tArr) {
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    Q1(parcel, t, i2);
                }
            }
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static String E1(uf2 uf2) {
        String str;
        bj2 bj2 = new bj2(uf2);
        StringBuilder sb = new StringBuilder(uf2.size());
        for (int i = 0; i < bj2.f440a.size(); i++) {
            int s = bj2.f440a.s(i);
            if (s == 34) {
                str = "\\\"";
            } else if (s == 39) {
                str = "\\'";
            } else if (s != 92) {
                switch (s) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (s < 32 || s > 126) {
                            sb.append('\\');
                            sb.append((char) (((s >>> 6) & 3) + 48));
                            sb.append((char) (((s >>> 3) & 7) + 48));
                            s = (s & 7) + 48;
                        }
                        sb.append((char) s);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static void F(@RecentlyNonNull Parcel parcel, int i) {
        if (parcel.dataPosition() != i) {
            throw new l82(hj1.v(37, "Overread allowed size end=", i), parcel);
        }
    }

    public static <T extends Parcelable> void F0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull List<T> list, boolean z) {
        if (list != null) {
            int o1 = o1(parcel, i);
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                T t = list.get(i2);
                if (t == null) {
                    parcel.writeInt(0);
                } else {
                    Q1(parcel, t, 0);
                }
            }
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static String F1(@NullableDecl String str, @NullableDecl Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        String str3;
        int i = 0;
        int i2 = 0;
        while (true) {
            length = objArr.length;
            if (i2 >= length) {
                break;
            }
            Object obj = objArr[i2];
            if (obj == null) {
                str2 = AnalyticsConstants.NULL;
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e2) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String sb2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(sb2);
                    if (valueOf.length() != 0) {
                        str3 = "Exception during lenientFormat for ".concat(valueOf);
                    } else {
                        str3 = new String("Exception during lenientFormat for ");
                    }
                    logger.logp(level, "com.google.common.base.Strings", "lenientToString", str3, (Throwable) e2);
                    String name2 = e2.getClass().getName();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 9 + name2.length());
                    hj1.V0(sb3, "<", sb2, " threw ", name2);
                    sb3.append(">");
                    str2 = sb3.toString();
                }
            }
            objArr[i2] = str2;
            i2++;
        }
        StringBuilder sb4 = new StringBuilder((length * 16) + str.length());
        int i3 = 0;
        while (true) {
            length2 = objArr.length;
            if (i >= length2 || (indexOf = str.indexOf("%s", i3)) == -1) {
                sb4.append((CharSequence) str, i3, str.length());
            } else {
                sb4.append((CharSequence) str, i3, indexOf);
                sb4.append(objArr[i]);
                i3 = indexOf + 2;
                i++;
            }
        }
        sb4.append((CharSequence) str, i3, str.length());
        if (i < length2) {
            sb4.append(" [");
            sb4.append(objArr[i]);
            for (int i4 = i + 1; i4 < objArr.length; i4++) {
                sb4.append(", ");
                sb4.append(objArr[i4]);
            }
            sb4.append(']');
        }
        return sb4.toString();
    }

    public static boolean G(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int G0(int i, byte[] bArr, int i2, int i3, qf2 qf2) throws ah2 {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return p1(bArr, i2, qf2);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return L0(bArr, i2, qf2) + qf2.f2938a;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = L0(bArr, i2, qf2);
                    i6 = qf2.f2938a;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = G0(i6, bArr, i2, i3, qf2);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw ah2.c();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw ah2.b();
            }
        } else {
            throw ah2.b();
        }
    }

    public static /* synthetic */ void G1(byte b2, byte b3, char[] cArr, int i) throws ma3 {
        if (b2 < -62 || c2(b3)) {
            throw ma3.g();
        }
        cArr[i] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    @RecentlyNonNull
    public static String H(@RecentlyNonNull PowerManager.WakeLock wakeLock, @RecentlyNonNull String str) {
        String valueOf = String.valueOf(String.valueOf(((long) System.identityHashCode(wakeLock)) | (((long) Process.myPid()) << 32)));
        String str2 = null;
        if (true == TextUtils.isEmpty(null)) {
            str2 = "";
        }
        String valueOf2 = String.valueOf(str2);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public static int H0(int i, byte[] bArr, int i2, int i3, zg2<?> zg2, qf2 qf2) {
        vg2 vg2 = (vg2) zg2;
        int L0 = L0(bArr, i2, qf2);
        while (true) {
            vg2.n(vg2.h, qf2.f2938a);
            if (L0 >= i3) {
                break;
            }
            int L02 = L0(bArr, L0, qf2);
            if (i != qf2.f2938a) {
                break;
            }
            L0 = L0(bArr, L02, qf2);
        }
        return L0;
    }

    public static void H1(Parcel parcel, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(dataPosition - i);
        parcel.setDataPosition(dataPosition);
    }

    public static yk1 I(int i, int i2, yk1 yk1, xk1 xk1, xk1 xk12) {
        int i3 = xk1.f3936a;
        int i4 = xk1.b;
        int i5 = (i3 - xk12.f3936a) / 2;
        int i6 = (i4 - xk12.b) / 2;
        float f = ((float) i) / ((float) i3);
        float f2 = ((float) i2) / ((float) i4);
        return new yk1(Math.max(Math.round(((float) (yk1.f4062a + i5)) * f), 0), Math.max(Math.round(((float) (yk1.b + i6)) * f2), 0), Math.min(Math.round(((float) (yk1.c + i5)) * f), i), Math.min(Math.round(((float) (yk1.d + i6)) * f2), i2));
    }

    public static int I0(int i, byte[] bArr, int i2, int i3, ej2 ej2, qf2 qf2) throws IOException {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int p1 = p1(bArr, i2, qf2);
                ej2.b(i, Long.valueOf(qf2.b));
                return p1;
            } else if (i4 == 1) {
                ej2.b(i, Long.valueOf(N1(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int L0 = L0(bArr, i2, qf2);
                int i5 = qf2.f2938a;
                ej2.b(i, i5 == 0 ? uf2.g : uf2.n(bArr, L0, i5));
                return L0 + i5;
            } else if (i4 == 3) {
                ej2 e2 = ej2.e();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int L02 = L0(bArr, i2, qf2);
                    int i8 = qf2.f2938a;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = L02;
                        break;
                    }
                    int I0 = I0(i7, bArr, L02, i3, e2, qf2);
                    i7 = i8;
                    i2 = I0;
                }
                if (i2 > i3 || i7 != i6) {
                    throw ah2.c();
                }
                ej2.b(i, e2);
                return i2;
            } else if (i4 == 5) {
                ej2.b(i, Integer.valueOf(B1(bArr, i2)));
                return i2 + 4;
            } else {
                throw ah2.b();
            }
        } else {
            throw ah2.b();
        }
    }

    public static void I1(bm2 bm2, StringBuilder sb, int i) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z;
        String str5;
        String str6;
        String str7;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet treeSet = new TreeSet();
        Method[] declaredMethods = bm2.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str8 = (String) it.next();
            String substring = str8.startsWith("get") ? str8.substring(3) : str8;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                if (valueOf2.length() != 0) {
                    str7 = valueOf.concat(valueOf2);
                } else {
                    str7 = new String(valueOf);
                }
                Method method2 = (Method) hashMap.get(str8);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    v1(sb, i, O1(str7), ea3.e(method2, bm2, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                if (valueOf4.length() != 0) {
                    str6 = valueOf3.concat(valueOf4);
                } else {
                    str6 = new String(valueOf3);
                }
                Method method3 = (Method) hashMap.get(str8);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    v1(sb, i, O1(str6), ea3.e(method3, bm2, new Object[0]));
                }
            }
            if (substring.length() != 0) {
                str = "set".concat(substring);
            } else {
                str = new String("set");
            }
            if (((Method) hashMap2.get(str)) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (valueOf5.length() != 0) {
                        str5 = "get".concat(valueOf5);
                    } else {
                        str5 = new String("get");
                    }
                    if (hashMap.containsKey(str5)) {
                    }
                }
                String valueOf6 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(substring.substring(1));
                if (valueOf7.length() != 0) {
                    str2 = valueOf6.concat(valueOf7);
                } else {
                    str2 = new String(valueOf6);
                }
                if (substring.length() != 0) {
                    str3 = "get".concat(substring);
                } else {
                    str3 = new String("get");
                }
                Method method4 = (Method) hashMap.get(str3);
                if (substring.length() != 0) {
                    str4 = "has".concat(substring);
                } else {
                    str4 = new String("has");
                }
                Method method5 = (Method) hashMap.get(str4);
                if (method4 != null) {
                    Object e2 = ea3.e(method4, bm2, new Object[0]);
                    if (method5 == null) {
                        if (e2 instanceof Boolean) {
                            if (!((Boolean) e2).booleanValue()) {
                            }
                        } else if (e2 instanceof Integer) {
                            if (((Integer) e2).intValue() == 0) {
                            }
                        } else if (e2 instanceof Float) {
                            if (((Float) e2).floatValue() == 0.0f) {
                            }
                        } else if (!(e2 instanceof Double)) {
                            if (e2 instanceof String) {
                                z = e2.equals("");
                            } else if (e2 instanceof g93) {
                                z = e2.equals(g93.g);
                            } else if (e2 instanceof bm2) {
                                if (e2 == ((bm2) e2).d()) {
                                }
                            } else if ((e2 instanceof Enum) && ((Enum) e2).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (((Double) e2).doubleValue() == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        }
                    } else if (!((Boolean) ea3.e(method5, bm2, new Object[0])).booleanValue()) {
                    }
                    v1(sb, i, O1(str2), e2);
                }
            }
        }
        if (!(bm2 instanceof ca3)) {
            an2 an2 = ((ea3) bm2).zzc;
            if (an2 != null) {
                for (int i2 = 0; i2 < an2.f182a; i2++) {
                    v1(sb, i, String.valueOf(an2.b[i2] >>> 3), an2.c[i2]);
                }
                return;
            }
            return;
        }
        ca3 ca3 = (ca3) bm2;
        throw null;
    }

    public static int J(List<cm1> list, InputStream inputStream, xn1 xn1) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new oq1(inputStream, xn1);
        }
        inputStream.mark(5242880);
        for (cm1 cm1 : list) {
            try {
                int c2 = cm1.c(inputStream, xn1);
                if (c2 != -1) {
                    inputStream.reset();
                    return c2;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static int J0(int i, byte[] bArr, int i2, qf2 qf2) {
        int i3;
        int i4;
        int i5 = i & 127;
        int i6 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            i3 = b2 << 7;
        } else {
            int i7 = i5 | ((b2 & Byte.MAX_VALUE) << 7);
            int i8 = i6 + 1;
            byte b3 = bArr[i6];
            if (b3 >= 0) {
                i4 = b3 << 14;
            } else {
                i5 = i7 | ((b3 & Byte.MAX_VALUE) << 14);
                i6 = i8 + 1;
                byte b4 = bArr[i8];
                if (b4 >= 0) {
                    i3 = b4 << 21;
                } else {
                    i7 = i5 | ((b4 & Byte.MAX_VALUE) << 21);
                    i8 = i6 + 1;
                    byte b5 = bArr[i6];
                    if (b5 >= 0) {
                        i4 = b5 << 28;
                    } else {
                        int i9 = i7 | ((b5 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] >= 0) {
                                qf2.f2938a = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            qf2.f2938a = i7 | i4;
            return i8;
        }
        qf2.f2938a = i5 | i3;
        return i6;
    }

    public static final byte[] J1(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        if (bArr.length - i3 < i || bArr2.length - i3 < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr3[i4] = (byte) (bArr[i4 + i] ^ bArr2[i4 + i2]);
        }
        return bArr3;
    }

    public static String K(int i) {
        switch (i) {
            case -1:
                return "SUCCESS_CACHE";
            case 0:
                return "SUCCESS";
            case 1:
            case 9:
            case 11:
            case 12:
            default:
                return hj1.v(32, "unknown status code: ", i);
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 10:
                return "DEVELOPER_ERROR";
            case 13:
                return CardValidityCheckEvent.VALIDITY_CHECK_ERROR;
            case 14:
                return "INTERRUPTED";
            case 15:
                return "TIMEOUT";
            case 16:
                return "CANCELED";
            case 17:
                return "API_NOT_CONNECTED";
            case 18:
                return "DEAD_CLIENT";
            case 19:
                return "REMOTE_EXCEPTION";
            case 20:
                return "CONNECTION_SUSPENDED_DURING_CALL";
            case 21:
                return "RECONNECTION_TIMED_OUT_DURING_UPDATE";
            case 22:
                return "RECONNECTION_TIMED_OUT";
        }
    }

    public static int K0(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static int K1(jt2 jt2) throws GeneralSecurityException {
        jt2 jt22 = jt2.UNKNOWN_FORMAT;
        du2 du2 = du2.UNKNOWN_CURVE;
        ju2 ju2 = ju2.UNKNOWN_HASH;
        int ordinal = jt2.ordinal();
        int i = 1;
        if (ordinal != 1) {
            i = 2;
            if (ordinal != 2) {
                if (ordinal == 3) {
                    return 3;
                }
                String valueOf = String.valueOf(jt2);
                throw new GeneralSecurityException(hj1.a0(new StringBuilder(valueOf.length() + 22), "unknown point format: ", valueOf));
            }
        }
        return i;
    }

    public static String L(String str) {
        return hj1.S("TransportRuntime.", str);
    }

    public static int L0(byte[] bArr, int i, qf2 qf2) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return J0(b2, bArr, i2, qf2);
        }
        qf2.f2938a = b2;
        return i2;
    }

    public static int L1(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public static cm1.a M(List<cm1> list, InputStream inputStream, xn1 xn1) throws IOException {
        if (inputStream == null) {
            return cm1.a.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new oq1(inputStream, xn1);
        }
        inputStream.mark(5242880);
        for (cm1 cm1 : list) {
            try {
                cm1.a b2 = cm1.b(inputStream);
                if (b2 != cm1.a.UNKNOWN) {
                    inputStream.reset();
                    return b2;
                }
            } finally {
                inputStream.reset();
            }
        }
        return cm1.a.UNKNOWN;
    }

    public static int M0(byte[] bArr, int i, zg2<?> zg2, qf2 qf2) throws IOException {
        vg2 vg2 = (vg2) zg2;
        int L0 = L0(bArr, i, qf2);
        int i2 = qf2.f2938a + L0;
        while (L0 < i2) {
            L0 = L0(bArr, L0, qf2);
            vg2.n(vg2.h, qf2.f2938a);
        }
        if (L0 == i2) {
            return L0;
        }
        throw ah2.a();
    }

    public static int M1(byte[] bArr, int i, qf2 qf2) throws IOException {
        int L0 = L0(bArr, i, qf2);
        int i2 = qf2.f2938a;
        if (i2 == 0) {
            qf2.c = "";
            return L0;
        }
        int i3 = L0 + i2;
        if (lj2.e(bArr, L0, i3)) {
            qf2.c = new String(bArr, L0, i2, wg2.f3775a);
            return i3;
        }
        throw ah2.d();
    }

    public static boolean N() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public static int N0(byte[] bArr, int i, v83 v83) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return n1(b2, bArr, i2, v83);
        }
        v83.f3616a = b2;
        return i2;
    }

    public static long N1(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static boolean O(@RecentlyNonNull Context context, int i) {
        if (!q0(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
            v22 a2 = v22.a(context);
            Objects.requireNonNull(a2);
            if (packageInfo == null) {
                return false;
            }
            if (!v22.d(packageInfo, false) && (!v22.d(packageInfo, true) || !u22.honorsDebugCertificates(a2.f3585a))) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.isLoggable("UidVerifier", 3);
            return false;
        }
    }

    public static long O0(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static final String O1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static boolean P(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static long P0(String str) {
        byte[] bArr;
        String str2;
        j(str);
        List<String> b2 = new un2(new q93(new ky2())).b(str);
        if (b2.size() < 2) {
            if (str.length() != 0) {
                str2 = "Invalid idToken ".concat(str);
            } else {
                str2 = new String("Invalid idToken ");
            }
            throw new RuntimeException(str2);
        }
        String str3 = b2.get(1);
        try {
            if (str3 == null) {
                bArr = null;
            } else {
                bArr = Base64.decode(str3, 11);
            }
            p73 a2 = p73.a(new String(bArr, StringRpcServer.STRING_ENCODING));
            return a2.b.longValue() - a2.f2776a.longValue();
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("Unable to decode token", e2);
        }
    }

    public static BigInteger P1(BigInteger bigInteger, boolean z, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger t1 = t1(ellipticCurve);
        BigInteger mod = bigInteger.multiply(bigInteger).add(ellipticCurve.getA()).multiply(bigInteger).add(ellipticCurve.getB()).mod(t1);
        if (t1.signum() == 1) {
            BigInteger mod2 = mod.mod(t1);
            BigInteger bigInteger2 = BigInteger.ZERO;
            if (!mod2.equals(bigInteger2)) {
                if (t1.testBit(0) && t1.testBit(1)) {
                    bigInteger2 = mod2.modPow(t1.add(BigInteger.ONE).shiftRight(2), t1);
                } else if (t1.testBit(0) && !t1.testBit(1)) {
                    bigInteger2 = BigInteger.ONE;
                    BigInteger shiftRight = t1.subtract(bigInteger2).shiftRight(1);
                    int i = 0;
                    while (true) {
                        BigInteger mod3 = bigInteger2.multiply(bigInteger2).subtract(mod2).mod(t1);
                        if (mod3.equals(BigInteger.ZERO)) {
                            break;
                        }
                        BigInteger modPow = mod3.modPow(shiftRight, t1);
                        BigInteger bigInteger3 = BigInteger.ONE;
                        if (modPow.add(bigInteger3).equals(t1)) {
                            BigInteger shiftRight2 = t1.add(bigInteger3).shiftRight(1);
                            BigInteger bigInteger4 = bigInteger2;
                            for (int bitLength = shiftRight2.bitLength() - 2; bitLength >= 0; bitLength--) {
                                BigInteger multiply = bigInteger4.multiply(bigInteger3);
                                bigInteger4 = bigInteger4.multiply(bigInteger4).add(bigInteger3.multiply(bigInteger3).mod(t1).multiply(mod3)).mod(t1);
                                BigInteger mod4 = multiply.add(multiply).mod(t1);
                                if (shiftRight2.testBit(bitLength)) {
                                    BigInteger mod5 = bigInteger4.multiply(bigInteger2).add(mod4.multiply(mod3)).mod(t1);
                                    bigInteger3 = bigInteger2.multiply(mod4).add(bigInteger4).mod(t1);
                                    bigInteger4 = mod5;
                                } else {
                                    bigInteger3 = mod4;
                                }
                            }
                            bigInteger2 = bigInteger4;
                        } else if (modPow.equals(bigInteger3)) {
                            bigInteger2 = bigInteger2.add(bigInteger3);
                            i++;
                            if (i == 128 && !t1.isProbablePrime(80)) {
                                throw new InvalidAlgorithmParameterException("p is not prime");
                            }
                        } else {
                            throw new InvalidAlgorithmParameterException("p is not prime");
                        }
                    }
                } else {
                    bigInteger2 = null;
                }
                if (!(bigInteger2 == null || bigInteger2.multiply(bigInteger2).mod(t1).compareTo(mod2) == 0)) {
                    throw new GeneralSecurityException("Could not find a modular square root");
                }
            }
            return z != bigInteger2.testBit(0) ? t1.subtract(bigInteger2).mod(t1) : bigInteger2;
        }
        throw new InvalidAlgorithmParameterException("p must be positive");
    }

    @TargetApi(20)
    public static boolean Q(@RecentlyNonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (b == null) {
            b = Boolean.valueOf(packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return b.booleanValue();
    }

    public static long Q0(byte[] bArr) {
        int length = bArr.length;
        if (length < 0 || length > bArr.length) {
            throw new IndexOutOfBoundsException(hj1.v(67, "Out of bound index with offput: 0 and length: ", length));
        }
        int i = 37;
        long j = -5435081209227447693L;
        if (length <= 32) {
            if (length > 16) {
                long j2 = ((long) (length << 1)) - 7286425919675154353L;
                long q1 = q1(bArr, 0) * -5435081209227447693L;
                long q12 = q1(bArr, 8);
                int i2 = length + 0;
                long q13 = q1(bArr, i2 - 8) * j2;
                return O0((q1(bArr, i2 - 16) * -7286425919675154353L) + Long.rotateRight(q13, 30) + Long.rotateRight(q1 + q12, 43), Long.rotateRight(q12 - 7286425919675154353L, 18) + q1 + q13, j2);
            } else if (length >= 8) {
                long j3 = ((long) (length << 1)) - 7286425919675154353L;
                long q14 = q1(bArr, 0) - 7286425919675154353L;
                long q15 = q1(bArr, (length + 0) - 8);
                return O0((Long.rotateRight(q15, 37) * j3) + q14, (Long.rotateRight(q14, 25) + q15) * j3, j3);
            } else if (length >= 4) {
                return O0(((long) length) + ((((long) K0(bArr, 0)) & LongString.MAX_LENGTH) << 3), ((long) K0(bArr, (length + 0) - 4)) & LongString.MAX_LENGTH, ((long) (length << 1)) - 7286425919675154353L);
            } else if (length <= 0) {
                return -7286425919675154353L;
            } else {
                long j4 = (((long) ((bArr[0] & 255) + ((bArr[(length >> 1) + 0] & 255) << 8))) * -7286425919675154353L) ^ (((long) (length + ((bArr[(length - 1) + 0] & 255) << 2))) * -4348849565147123417L);
                return (j4 ^ (j4 >>> 47)) * -7286425919675154353L;
            }
        } else if (length <= 64) {
            long j5 = ((long) (length << 1)) - 7286425919675154353L;
            long q16 = q1(bArr, 0) * -7286425919675154353L;
            long q17 = q1(bArr, 8);
            int i3 = length + 0;
            long q18 = q1(bArr, i3 - 8) * j5;
            long rotateRight = Long.rotateRight(q18, 30) + Long.rotateRight(q16 + q17, 43) + (q1(bArr, i3 - 16) * -7286425919675154353L);
            long O0 = O0(rotateRight, Long.rotateRight(q17 - 7286425919675154353L, 18) + q16 + q18, j5);
            long q19 = q1(bArr, 16) * j5;
            long q110 = q1(bArr, 24);
            long q111 = (q1(bArr, i3 - 32) + rotateRight) * j5;
            return O0(Long.rotateRight(q111, 30) + Long.rotateRight(q19 + q110, 43) + ((q1(bArr, i3 - 24) + O0) * j5), Long.rotateRight(q110 + q16, 18) + q19 + q111, j5);
        } else {
            long j6 = 2480279821605975764L;
            long[] jArr = new long[2];
            long[] jArr2 = new long[2];
            int i4 = length - 1;
            int i5 = ((i4 / 64) << 6) + 0;
            int i6 = i4 & 63;
            int i7 = (i5 + i6) - 63;
            long q112 = q1(bArr, 0) + 95310865018149119L;
            char c2 = 0;
            long j7 = 1390051526045402406L;
            int i8 = 0;
            while (true) {
                long j8 = q112 + j6 + jArr[c2];
                long j9 = j6 + jArr[1];
                long rotateRight2 = (Long.rotateRight(q1(bArr, i8 + 8) + j8, i) * j) ^ jArr2[1];
                long q113 = q1(bArr, i8 + 40) + jArr[0] + (Long.rotateRight(q1(bArr, i8 + 48) + j9, 42) * j);
                long rotateRight3 = Long.rotateRight(j7 + jArr2[0], 33) * j;
                e1(bArr, i8, jArr[1] * j, rotateRight2 + jArr2[0], jArr);
                e1(bArr, i8 + 32, jArr2[1] + rotateRight3, q1(bArr, i8 + 16) + q113, jArr2);
                i8 += 64;
                if (i8 == i5) {
                    long j10 = ((rotateRight2 & 255) << 1) - 5435081209227447693L;
                    jArr2[0] = jArr2[0] + ((long) i6);
                    jArr[0] = jArr[0] + jArr2[0];
                    jArr2[0] = jArr2[0] + jArr[0];
                    long j11 = rotateRight3 + q113 + jArr[0];
                    long j12 = q113 + jArr[1];
                    long rotateRight4 = (Long.rotateRight(q1(bArr, i7 + 8) + j11, 37) * j10) ^ (jArr2[1] * 9);
                    long q114 = q1(bArr, i7 + 40) + (jArr[0] * 9) + (Long.rotateRight(q1(bArr, i7 + 48) + j12, 42) * j10);
                    long rotateRight5 = Long.rotateRight(rotateRight2 + jArr2[0], 33) * j10;
                    e1(bArr, i7, jArr[1] * j10, rotateRight4 + jArr2[0], jArr);
                    e1(bArr, i7 + 32, jArr2[1] + rotateRight5, q1(bArr, i7 + 16) + q114, jArr2);
                    return O0((((q114 >>> 47) ^ q114) * -4348849565147123417L) + O0(jArr[0], jArr2[0], j10) + rotateRight4, O0(jArr[1], jArr2[1], j10) + rotateRight5, j10);
                }
                i = 37;
                c2 = 0;
                i5 = i5;
                i6 = i6;
                j = -5435081209227447693L;
                j6 = q113;
                j7 = rotateRight2;
                q112 = rotateRight3;
            }
        }
    }

    public static <T extends Parcelable> void Q1(Parcel parcel, T t, int i) {
        int dataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int dataPosition2 = parcel.dataPosition();
        t.writeToParcel(parcel, i);
        int dataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(dataPosition);
        parcel.writeInt(dataPosition3 - dataPosition2);
        parcel.setDataPosition(dataPosition3);
    }

    @TargetApi(26)
    public static boolean R(@RecentlyNonNull Context context) {
        if (!Q(context)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return g1(context) && !N();
        }
        return true;
    }

    public static n83 R0(PhoneAuthCredential phoneAuthCredential) {
        if (!TextUtils.isEmpty(phoneAuthCredential.zzh())) {
            String zze = phoneAuthCredential.zze();
            String zzh = phoneAuthCredential.zzh();
            boolean zzg = phoneAuthCredential.zzg();
            n83 n83 = new n83();
            j(zze);
            n83.f = zze;
            j(zzh);
            n83.i = zzh;
            n83.k = zzg;
            return n83;
        }
        String zzd = phoneAuthCredential.zzd();
        String smsCode = phoneAuthCredential.getSmsCode();
        boolean zzg2 = phoneAuthCredential.zzg();
        n83 n832 = new n83();
        j(zzd);
        n832.g = zzd;
        j(smsCode);
        n832.h = smsCode;
        n832.k = zzg2;
        return n832;
    }

    public static final void R1(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i) {
        if (i < 0 || byteBuffer2.remaining() < i || byteBuffer3.remaining() < i || byteBuffer.remaining() < i) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static int S(int i, int i2) {
        return ((i * Constants.MAX_URL_LENGTH) / i2) - 1000;
    }

    public static String S0() {
        Locale locale = Locale.getDefault();
        StringBuilder sb = new StringBuilder();
        w1(sb, locale);
        Locale locale2 = Locale.US;
        if (!locale.equals(locale2)) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            w1(sb, locale2);
        }
        return sb.toString();
    }

    public static void S1(byte[] bArr, long j, int i) {
        int i2 = 0;
        while (i2 < 4) {
            bArr[i + i2] = (byte) ((int) (255 & j));
            i2++;
            j >>= 8;
        }
    }

    public static String T(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (str2.length() > i) {
                sb.append(str2.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String T0(g93 g93) {
        StringBuilder sb = new StringBuilder(g93.e());
        for (int i = 0; i < g93.e(); i++) {
            byte b2 = g93.b(i);
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

    public static int T1(byte[] bArr, int i, qf2 qf2) {
        int L0 = L0(bArr, i, qf2);
        int i2 = qf2.f2938a;
        if (i2 == 0) {
            qf2.c = uf2.g;
            return L0;
        }
        qf2.c = uf2.n(bArr, L0, i2);
        return L0 + i2;
    }

    public static xj1 U(Context context) {
        return V(context, null);
    }

    public static String U0(String str, int i) {
        if (i > 0) {
            return hj1.v(str.length() + 11, str, i);
        }
        rd3.d("index out of range for prefix", str);
        return "";
    }

    public static long U1(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public static xj1 V(Context context, fk1 fk1) {
        gk1 gk1;
        if (fk1 == null) {
            gk1 = new gk1(new kk1());
        } else {
            gk1 = new gk1(fk1);
        }
        xj1 xj1 = new xj1(new ik1(new File(context.getCacheDir(), "volley")), gk1);
        lj1 lj1 = xj1.i;
        if (lj1 != null) {
            lj1.j = true;
            lj1.interrupt();
        }
        rj1[] rj1Arr = xj1.h;
        for (rj1 rj1 : rj1Arr) {
            if (rj1 != null) {
                rj1.j = true;
                rj1.interrupt();
            }
        }
        lj1 lj12 = new lj1(xj1.c, xj1.d, xj1.e, xj1.g);
        xj1.i = lj12;
        lj12.start();
        for (int i = 0; i < xj1.h.length; i++) {
            rj1 rj12 = new rj1(xj1.d, xj1.f, xj1.e, xj1.g);
            xj1.h[i] = rj12;
            rj12.start();
        }
        return xj1;
    }

    public static String V0(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder(length + length);
        for (byte b2 : bArr) {
            int i = b2 & 255;
            sb.append("0123456789abcdef".charAt(i >> 4));
            sb.append("0123456789abcdef".charAt(i & 15));
        }
        return sb.toString();
    }

    public static ECParameterSpec V1(int i) throws NoSuchAlgorithmException {
        int i2 = i - 1;
        if (i2 == 0) {
            return b2("115792089210356248762697446949407573530086143415290314195533631308867097853951", "115792089210356248762697446949407573529996955224135760342422259061068512044369", "5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b", "6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296", "4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5");
        }
        if (i2 != 1) {
            return b2("6864797660130609714981900799081393217269435300143305409394463459185543183397656052122559640661454554977296311391480858037121987999716643812574028291115057151", "6864797660130609714981900799081393217269435300143305409394463459185543183397655394245057746333217197532963996371363321113864768612440380340372808892707005449", "051953eb9618e1c9a1f929a21a0b68540eea2da725b99b315f3b8b489918ef109e156193951ec7e937b1652c0bd3bb1bf073573df883d2c34f1ef451fd46b503f00", "c6858e06b70404e9cd9e3ecb662395b4429c648139053fb521f828af606b4d3dbaa14b5e77efe75928fe1dc127a2ffa8de3348b3c1856a429bf97e7e31c2e5bd66", "11839296a789a3bc0045c8a5fb42c7d1bd998f54449579b446817afbd17273e662c97ee72995ef42640c550b9013fad0761353c7086a272c24088be94769fd16650");
        }
        return b2("39402006196394479212279040100143613805079739270465446667948293404245721771496870329047266088258938001861606973112319", "39402006196394479212279040100143613805079739270465446667946905279627659399113263569398956308152294913554433653942643", "b3312fa7e23ee7e4988e056be3f82d19181d9c6efe8141120314088f5013875ac656398d8a2ed19d2a85c8edd3ec2aef", "aa87ca22be8b05378eb1c71ef320ad746e1d3b628ba79b9859f741e082542a385502f25dbf55296c3a545e3872760ab7", "3617de4a96262c6f5d9e98bf9292dc29f8f41dbd289a147ce9da3113b5f0b8c00a60b1ce1d7e819d7a431d7c90ea0e5f");
    }

    public static jj1.a W(tj1 tj1) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = tj1.c;
        String str = map.get("Date");
        long Y = str != null ? Y(str) : 0;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            int i2 = 0;
            j2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            z = false;
            j2 = 0;
            j = 0;
        }
        String str3 = map.get("Expires");
        long Y2 = str3 != null ? Y(str3) : 0;
        String str4 = map.get("Last-Modified");
        long Y3 = str4 != null ? Y(str4) : 0;
        String str5 = map.get("ETag");
        if (z) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (i != 0) {
                j5 = j4;
            } else {
                Long.signum(j);
                j5 = (j * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (Y <= 0 || Y2 < Y) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (Y2 - Y);
                j3 = j4;
            }
        }
        jj1.a aVar = new jj1.a();
        aVar.f1933a = tj1.b;
        aVar.b = str5;
        aVar.f = j4;
        aVar.e = j3;
        aVar.c = Y;
        aVar.d = Y3;
        aVar.g = map;
        aVar.h = tj1.d;
        return aVar;
    }

    public static List<String> W0(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i = 0; i < jSONArray.length(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
        }
        return arrayList;
    }

    public static /* synthetic */ void W1(byte b2, byte b3, byte b4, char[] cArr, int i) throws ma3 {
        if (!c2(b3)) {
            if (b2 == -32) {
                if (b3 >= -96) {
                    b2 = -32;
                }
            }
            if (b2 == -19) {
                if (b3 < -96) {
                    b2 = -19;
                }
            }
            if (!c2(b4)) {
                cArr[i] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
                return;
            }
        }
        throw ma3.g();
    }

    public static String X(Map<String, String> map, String str) {
        String str2 = map.get("Content-Type");
        if (str2 != null) {
            String[] split = str2.split(";", 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    public static void X0(Parcel parcel, int i, int i2) {
        int j0 = j0(parcel, i);
        if (j0 != i2) {
            String hexString = Integer.toHexString(j0);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i2);
            sb.append(" got ");
            sb.append(j0);
            throw new l82(hj1.b0(sb, " (0x", hexString, ")"), parcel);
        }
    }

    public static final byte[] X1(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length == bArr2.length) {
            return J1(bArr, 0, bArr2, 0, length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static long Y(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
            simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("GMT"));
            return simpleDateFormat.parse(str).getTime();
        } catch (ParseException unused) {
            ek1.a("Unable to parse dateStr: %s, falling back to 0", str);
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01e6, code lost:
        if (((java.lang.Boolean) r11).booleanValue() == false) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01f4, code lost:
        if (((java.lang.Integer) r11).intValue() == 0) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0205, code lost:
        if (((java.lang.Float) r11).floatValue() == 0.0f) goto L_0x0245;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0217, code lost:
        if (((java.lang.Double) r11).doubleValue() == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) goto L_0x0245;
     */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x024b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void Y0(defpackage.zh2 r18, java.lang.StringBuilder r19, int r20) {
        /*
        // Method dump skipped, instructions count: 687
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gj1.Y0(zh2, java.lang.StringBuilder, int):void");
    }

    public static int Y1(byte[] bArr, int i, v83 v83) throws ma3 {
        int N0 = N0(bArr, i, v83);
        int i2 = v83.f3616a;
        if (i2 < 0) {
            throw ma3.b();
        } else if (i2 == 0) {
            v83.c = "";
            return N0;
        } else {
            v83.c = new String(bArr, N0, i2, ka3.f2038a);
            return N0 + i2;
        }
    }

    public static boolean Z(@RecentlyNonNull Parcel parcel, int i) {
        X0(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static void Z0(st2 st2) throws GeneralSecurityException {
        V1(A1(st2.s().s()));
        s1(st2.s().t());
        if (st2.u() != jt2.UNKNOWN_FORMAT) {
            xo2.c(st2.t().s());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static /* synthetic */ void Z1(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i) throws ma3 {
        if (!c2(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !c2(b4) && !c2(b5)) {
                int i2 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i] = (char) ((i2 >>> 10) + 55232);
                cArr[i + 1] = (char) ((i2 & 1023) + 56320);
                return;
            }
        }
        throw ma3.g();
    }

    public static void a(Marker marker, LatLng latLng, a aVar, float f) {
        TypeEvaluator typeEvaluator;
        double abs = Math.abs(ui1.m(marker.getPosition(), latLng));
        if (abs <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || abs >= 1000.0d) {
            marker.setPosition(latLng);
            return;
        }
        int i = (int) ((abs / ((double) f)) * 1000.0d);
        if (i > 5000) {
            i = 5000;
        }
        if (aVar.equals(a.LINEAR)) {
            typeEvaluator = new cj1();
        } else if (aVar.equals(a.ACCELERATE)) {
            typeEvaluator = new dj1();
        } else if (aVar.equals(a.DECELARATE)) {
            typeEvaluator = new ej1();
        } else {
            typeEvaluator = new fj1();
        }
        ObjectAnimator ofObject = ObjectAnimator.ofObject(marker, Property.of(Marker.class, LatLng.class, "position"), typeEvaluator, latLng);
        ofObject.setDuration((long) i);
        ofObject.setAutoCancel(true);
        ofObject.start();
    }

    @RecentlyNonNull
    public static Boolean a0(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        if (j0 == 0) {
            return null;
        }
        u1(parcel, i, j0, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static void a1(String str, o53 o53, e63 e63, Type type, t53 t53) {
        InputStream inputStream;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            boolean z = true;
            httpURLConnection.setDoOutput(true);
            byte[] bytes = o53.zza().getBytes(Charset.defaultCharset());
            int length = bytes.length;
            httpURLConnection.setFixedLengthStreamingMode(length);
            httpURLConnection.setRequestProperty("Content-Type", "application/json");
            t53.a(httpURLConnection);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(httpURLConnection.getOutputStream(), length);
            try {
                bufferedOutputStream.write(bytes, 0, length);
                bufferedOutputStream.close();
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode >= 200 && responseCode < 300) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StringRpcServer.STRING_ENCODING));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Throwable th) {
                        wx2.f3852a.a(th, th);
                    }
                }
                bufferedReader.close();
                String sb2 = sb.toString();
                if (responseCode < 200 || responseCode >= 300) {
                    z = false;
                }
                if (!z) {
                    e63.zza((String) n53.a(sb2, String.class));
                    return;
                } else {
                    e63.c((p53) n53.a(sb2, type));
                    return;
                }
                throw th;
                throw th;
            } catch (Throwable th2) {
                wx2.f3852a.a(th, th2);
            }
        } catch (e13 | IOException | JSONException e2) {
            e63.zza(e2.getMessage());
        }
    }

    public static int a2(byte[] bArr, int i, v83 v83) throws ma3 {
        int N0 = N0(bArr, i, v83);
        int i2 = v83.f3616a;
        if (i2 < 0) {
            throw ma3.b();
        } else if (i2 == 0) {
            v83.c = "";
            return N0;
        } else {
            v83.c = qn2.f2965a.b(bArr, N0, i2);
            return N0 + i2;
        }
    }

    public static void b(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static byte b0(@RecentlyNonNull Parcel parcel, int i) {
        X0(parcel, i, 4);
        return (byte) parcel.readInt();
    }

    public static void b1(String str, Object obj, StringBuffer stringBuffer, StringBuffer stringBuffer2) throws IllegalAccessException, InvocationTargetException {
        byte[] bArr;
        if (obj == null) {
            return;
        }
        if (obj instanceof ek2) {
            int length = stringBuffer.length();
            if (str != null) {
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(j2(str));
                stringBuffer2.append(" <\n");
                stringBuffer.append("  ");
            }
            Class<?> cls = obj.getClass();
            Field[] fields = cls.getFields();
            for (Field field : fields) {
                int modifiers = field.getModifiers();
                String name = field.getName();
                if (!"cachedSize".equals(name) && (modifiers & 1) == 1 && (modifiers & 8) != 8 && !name.startsWith("_") && !name.endsWith("_")) {
                    Class<?> type = field.getType();
                    Object obj2 = field.get(obj);
                    if (!type.isArray() || type.getComponentType() == Byte.TYPE) {
                        b1(name, obj2, stringBuffer, stringBuffer2);
                    } else {
                        int length2 = obj2 == null ? 0 : Array.getLength(obj2);
                        for (int i = 0; i < length2; i++) {
                            b1(name, Array.get(obj2, i), stringBuffer, stringBuffer2);
                        }
                    }
                }
            }
            for (Method method : cls.getMethods()) {
                String name2 = method.getName();
                if (name2.startsWith("set")) {
                    String substring = name2.substring(3);
                    try {
                        String valueOf = String.valueOf(substring);
                        if (((Boolean) cls.getMethod(valueOf.length() != 0 ? "has".concat(valueOf) : new String("has"), new Class[0]).invoke(obj, new Object[0])).booleanValue()) {
                            String valueOf2 = String.valueOf(substring);
                            b1(substring, cls.getMethod(valueOf2.length() != 0 ? "get".concat(valueOf2) : new String("get"), new Class[0]).invoke(obj, new Object[0]), stringBuffer, stringBuffer2);
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                }
            }
            if (str != null) {
                stringBuffer.setLength(length);
                stringBuffer2.append(stringBuffer);
                stringBuffer2.append(">\n");
                return;
            }
            return;
        }
        String j2 = j2(str);
        stringBuffer2.append(stringBuffer);
        stringBuffer2.append(j2);
        stringBuffer2.append(": ");
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (!str2.startsWith("http") && str2.length() > 200) {
                str2 = String.valueOf(str2.substring(0, AMQP.REPLY_SUCCESS)).concat("[...]");
            }
            int length3 = str2.length();
            StringBuilder sb = new StringBuilder(length3);
            for (int i2 = 0; i2 < length3; i2++) {
                char charAt = str2.charAt(i2);
                if (charAt < ' ' || charAt > '~' || charAt == '\"' || charAt == '\'') {
                    sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                } else {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            stringBuffer2.append("\"");
            stringBuffer2.append(sb2);
            stringBuffer2.append("\"");
        } else if (obj instanceof byte[]) {
            stringBuffer2.append('\"');
            for (byte b2 : (byte[]) obj) {
                int i3 = b2 & 255;
                if (i3 == 92 || i3 == 34) {
                    stringBuffer2.append('\\');
                } else if (i3 < 32 || i3 >= 127) {
                    stringBuffer2.append(String.format("\\%03o", Integer.valueOf(i3)));
                }
                stringBuffer2.append((char) i3);
            }
            stringBuffer2.append('\"');
        } else {
            stringBuffer2.append(obj);
        }
        stringBuffer2.append("\n");
    }

    public static ECParameterSpec b2(String str, String str2, String str3, String str4, String str5) {
        BigInteger bigInteger = new BigInteger(str);
        return new ECParameterSpec(new EllipticCurve(new ECFieldFp(bigInteger), bigInteger.subtract(new BigInteger("3")), new BigInteger(str3, 16)), new ECPoint(new BigInteger(str4, 16), new BigInteger(str5, 16)), new BigInteger(str2), 1);
    }

    public static void c(boolean z, @RecentlyNonNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static double c0(@RecentlyNonNull Parcel parcel, int i) {
        X0(parcel, i, 8);
        return parcel.readDouble();
    }

    public static final void c1(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                c1(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                c1(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                uf2 uf2 = uf2.g;
                sb.append(E1(new yf2(((String) obj).getBytes(wg2.f3775a))));
                sb.append('\"');
            } else if (obj instanceof uf2) {
                sb.append(": \"");
                sb.append(E1((uf2) obj));
                sb.append('\"');
            } else if (obj instanceof ug2) {
                sb.append(" {");
                Y0((ug2) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                c1(sb, i4, AnalyticsConstants.KEY, entry2.getKey());
                c1(sb, i4, FirebaseAnalytics.Param.VALUE, entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    public static boolean c2(byte b2) {
        return b2 > -65;
    }

    public static void d(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static float d0(@RecentlyNonNull Parcel parcel, int i) {
        X0(parcel, i, 4);
        return parcel.readFloat();
    }

    public static void d1(ECPoint eCPoint, EllipticCurve ellipticCurve) throws GeneralSecurityException {
        BigInteger t1 = t1(ellipticCurve);
        BigInteger affineX = eCPoint.getAffineX();
        BigInteger affineY = eCPoint.getAffineY();
        if (affineX == null || affineY == null) {
            throw new GeneralSecurityException("point is at infinity");
        } else if (affineX.signum() == -1 || affineX.compareTo(t1) >= 0) {
            throw new GeneralSecurityException("x is out of range");
        } else if (affineY.signum() == -1 || affineY.compareTo(t1) >= 0) {
            throw new GeneralSecurityException("y is out of range");
        } else if (!affineY.multiply(affineY).mod(t1).equals(affineX.multiply(affineX).add(ellipticCurve.getA()).multiply(affineX).add(ellipticCurve.getB()).mod(t1))) {
            throw new GeneralSecurityException("Point is not on curve");
        }
    }

    public static int d2(byte[] bArr, int i, v83 v83) throws ma3 {
        int N0 = N0(bArr, i, v83);
        int i2 = v83.f3616a;
        if (i2 < 0) {
            throw ma3.b();
        } else if (i2 > bArr.length - N0) {
            throw ma3.a();
        } else if (i2 == 0) {
            v83.c = g93.g;
            return N0;
        } else {
            v83.c = g93.A(bArr, N0, i2);
            return N0 + i2;
        }
    }

    public static void e(boolean z, @RecentlyNonNull String str, @RecentlyNonNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @RecentlyNonNull
    public static Float e0(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        if (j0 == 0) {
            return null;
        }
        u1(parcel, i, j0, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static void e1(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long q1 = q1(bArr, i);
        long q12 = q1(bArr, i + 8);
        long q13 = q1(bArr, i + 16);
        long q14 = q1(bArr, i + 24);
        long j3 = j + q1;
        long rotateRight = Long.rotateRight(j2 + j3 + q14, 21);
        long j4 = q12 + j3 + q13;
        jArr[0] = j4 + q14;
        jArr[1] = Long.rotateRight(j4, 44) + rotateRight + j3;
    }

    public static int e2(mm2 mm2, byte[] bArr, int i, int i2, v83 v83) throws IOException {
        int i3 = i + 1;
        byte b2 = bArr[i];
        byte b3 = b2;
        if (b2 < 0) {
            i3 = n1(b2, bArr, i3, v83);
            b3 = v83.f3616a;
        }
        if (b3 < 0 || b3 > i2 - i3) {
            throw ma3.a();
        }
        Object zza = mm2.zza();
        int i4 = (b3 == 1 ? 1 : 0) + i3;
        mm2.g(zza, bArr, i3, i4, v83);
        mm2.d(zza);
        v83.c = zza;
        return i4;
    }

    public static void f(@RecentlyNonNull Handler handler) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != handler.getLooper()) {
            String name = myLooper != null ? myLooper.getThread().getName() : "null current looper";
            String name2 = handler.getLooper().getThread().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name2).length() + 36 + String.valueOf(name).length());
            hj1.V0(sb, "Must be called on ", name2, " thread, but got ", name);
            sb.append(".");
            throw new IllegalStateException(sb.toString());
        }
    }

    @RecentlyNonNull
    public static IBinder f0(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        IBinder readStrongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + j0);
        return readStrongBinder;
    }

    public static /* synthetic */ boolean f1(byte b2) {
        return b2 >= 0;
    }

    public static int f2(mm2 mm2, byte[] bArr, int i, int i2, int i3, v83 v83) throws IOException {
        dm2 dm2 = (dm2) mm2;
        Object zza = dm2.zza();
        int E = dm2.E(zza, bArr, i, i2, i3, v83);
        dm2.d(zza);
        v83.c = zza;
        return E;
    }

    public static void g(@RecentlyNonNull Handler handler, @RecentlyNonNull String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static int g0(@RecentlyNonNull Parcel parcel, int i) {
        X0(parcel, i, 4);
        return parcel.readInt();
    }

    @TargetApi(21)
    public static boolean g1(@RecentlyNonNull Context context) {
        if (c == null) {
            c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return c.booleanValue();
    }

    public static final String g2(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    public static void h(@RecentlyNonNull String str) {
        if (!(Looper.getMainLooper() == Looper.myLooper())) {
            throw new IllegalStateException(str);
        }
    }

    public static long h0(@RecentlyNonNull Parcel parcel, int i) {
        X0(parcel, i, 8);
        return parcel.readLong();
    }

    public static final boolean h1(byte[] bArr, byte[] bArr2) {
        if (!(bArr == null || bArr2 == null || bArr.length != bArr2.length)) {
            int i = 0;
            for (int i2 = 0; i2 < bArr.length; i2++) {
                i |= bArr[i2] ^ bArr2[i2];
            }
            if (i == 0) {
                return true;
            }
        }
        return false;
    }

    public static int h2(int i, byte[] bArr, int i2, int i3, ja3<?> ja3, v83 v83) {
        fa3 fa3 = (fa3) ja3;
        int N0 = N0(bArr, i2, v83);
        fa3.e(v83.f3616a);
        while (N0 < i3) {
            int N02 = N0(bArr, N0, v83);
            if (i != v83.f3616a) {
                break;
            }
            N0 = N0(bArr, N02, v83);
            fa3.e(v83.f3616a);
        }
        return N0;
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    public static String i(String str, @RecentlyNonNull Object obj) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @RecentlyNonNull
    public static Long i0(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        if (j0 == 0) {
            return null;
        }
        u1(parcel, i, j0, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static byte[] i1(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            for (int i = 0; i < 16; i++) {
                byte b2 = bArr[i];
                byte b3 = (byte) ((b2 + b2) & 254);
                bArr2[i] = b3;
                if (i < 15) {
                    bArr2[i] = (byte) (((bArr[i + 1] >> 7) & 1) | b3);
                }
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }

    public static int i2(byte[] bArr, int i, ja3<?> ja3, v83 v83) throws IOException {
        fa3 fa3 = (fa3) ja3;
        int N0 = N0(bArr, i, v83);
        int i2 = v83.f3616a + N0;
        while (N0 < i2) {
            N0 = N0(bArr, N0, v83);
            fa3.e(v83.f3616a);
        }
        if (N0 == i2) {
            return N0;
        }
        throw ma3.a();
    }

    @RecentlyNonNull
    @EnsuresNonNull({"#1"})
    public static String j(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static int j0(@RecentlyNonNull Parcel parcel, int i) {
        return (i & -65536) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static byte[] j1(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 32) {
            byte b2 = 0;
            long z1 = (z1(bArr, 0) >> 0) & 67108863;
            long z12 = (z1(bArr, 3) >> 2) & 67108863 & 67108611;
            long z13 = (z1(bArr, 6) >> 4) & 67108863 & 67092735;
            long z14 = (z1(bArr, 9) >> 6) & 67108863 & 66076671;
            long z15 = (z1(bArr, 12) >> 8) & 67108863 & 1048575;
            long j = z12 * 5;
            long j2 = z13 * 5;
            long j3 = z14 * 5;
            long j4 = z15 * 5;
            int i = 17;
            byte[] bArr3 = new byte[17];
            long j5 = 0;
            long j6 = 0;
            long j7 = 0;
            long j8 = 0;
            long j9 = 0;
            int i2 = 0;
            while (true) {
                int length = bArr2.length;
                if (i2 < length) {
                    int min = Math.min(16, length - i2);
                    System.arraycopy(bArr2, i2, bArr3, b2, min);
                    bArr3[min] = 1;
                    if (min != 16) {
                        Arrays.fill(bArr3, min + 1, i, b2);
                    }
                    long z16 = j9 + ((z1(bArr3, b2) >> b2) & 67108863);
                    long z17 = j5 + ((z1(bArr3, 3) >> 2) & 67108863);
                    long z18 = j6 + ((z1(bArr3, 6) >> 4) & 67108863);
                    long z19 = j7 + ((z1(bArr3, 9) >> 6) & 67108863);
                    long z110 = j8 + (((z1(bArr3, 12) >> 8) & 67108863) | ((long) (bArr3[16] << 24)));
                    long j10 = (z110 * j) + (z19 * j2) + (z18 * j3) + (z17 * j4) + (z16 * z1);
                    long j11 = (z110 * j2) + (z19 * j3) + (z18 * j4) + (z17 * z1) + (z16 * z12) + (j10 >> 26);
                    long j12 = (z110 * j3) + (z19 * j4) + (z18 * z1) + (z17 * z12) + (z16 * z13) + (j11 >> 26);
                    long j13 = (z110 * j4) + (z19 * z1) + (z18 * z12) + (z17 * z13) + (z16 * z14) + (j12 >> 26);
                    long j14 = z19 * z12;
                    long j15 = z110 * z1;
                    long j16 = j15 + j14 + (z18 * z13) + (z17 * z14) + (z16 * z15) + (j13 >> 26);
                    long j17 = ((j16 >> 26) * 5) + (j10 & 67108863);
                    j9 = j17 & 67108863;
                    long j18 = (j11 & 67108863) + (j17 >> 26);
                    i2 += 16;
                    j8 = j16 & 67108863;
                    j7 = j13 & 67108863;
                    j6 = j12 & 67108863;
                    j5 = j18;
                    b2 = 0;
                    i = 17;
                } else {
                    long j19 = j6 + (j5 >> 26);
                    long j20 = j19 & 67108863;
                    long j21 = j7 + (j19 >> 26);
                    long j22 = j21 & 67108863;
                    long j23 = j8 + (j21 >> 26);
                    long j24 = j23 & 67108863;
                    long j25 = ((j23 >> 26) * 5) + j9;
                    long j26 = j25 & 67108863;
                    long j27 = (j5 & 67108863) + (j25 >> 26);
                    long j28 = j26 + 5;
                    long j29 = j27 + (j28 >> 26);
                    long j30 = j20 + (j29 >> 26);
                    long j31 = j22 + (j30 >> 26);
                    long j32 = (j24 + (j31 >> 26)) - 67108864;
                    long j33 = j32 >> 63;
                    long j34 = ~j33;
                    long j35 = (j27 & j33) | (j29 & 67108863 & j34);
                    long j36 = (j20 & j33) | (j30 & 67108863 & j34);
                    long j37 = (j22 & j33) | (j31 & 67108863 & j34);
                    long z111 = z1(bArr, 16) + (((j26 & j33) | (j28 & 67108863 & j34) | (j35 << 26)) & LongString.MAX_LENGTH);
                    long z112 = z1(bArr, 20) + (((j35 >> 6) | (j36 << 20)) & LongString.MAX_LENGTH) + (z111 >> 32);
                    long z113 = z1(bArr, 24) + (((j36 >> 12) | (j37 << 14)) & LongString.MAX_LENGTH) + (z112 >> 32);
                    long z114 = z1(bArr, 28);
                    byte[] bArr4 = new byte[16];
                    S1(bArr4, z111 & LongString.MAX_LENGTH, 0);
                    S1(bArr4, z112 & LongString.MAX_LENGTH, 4);
                    S1(bArr4, z113 & LongString.MAX_LENGTH, 8);
                    S1(bArr4, ((((j37 >> 18) | (((j24 & j33) | (j32 & j34)) << 8)) & LongString.MAX_LENGTH) + z114 + (z113 >> 32)) & LongString.MAX_LENGTH, 12);
                    return bArr4;
                }
            }
        } else {
            throw new IllegalArgumentException("The key length in bytes must be 32.");
        }
    }

    public static String j2(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (i != 0) {
                if (Character.isUpperCase(charAt)) {
                    stringBuffer.append('_');
                }
                stringBuffer.append(charAt);
            }
            charAt = Character.toLowerCase(charAt);
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    public static void k(@RecentlyNonNull String str) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [ju1$a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <TInput, TResult, TException extends java.lang.Throwable> TResult k0(int r5, TInput r6, defpackage.hu1<TInput, TResult, TException> r7, defpackage.fw1<TInput, TResult> r8) throws java.lang.Throwable {
        /*
            r8 = 1
            if (r5 >= r8) goto L_0x0008
            java.lang.Object r5 = r7.a(r6)
            return r5
        L_0x0008:
            java.lang.Object r0 = r7.a(r6)
            ju1$a r6 = (defpackage.ju1.a) r6
            r1 = r0
            ju1$b r1 = (defpackage.ju1.b) r1
            java.net.URL r2 = r1.b
            if (r2 == 0) goto L_0x0029
            java.lang.String r3 = "CctTransportBackend"
            java.lang.String r4 = "Following redirect to: %s"
            C(r3, r4, r2)
            java.net.URL r1 = r1.b
            ju1$a r2 = new ju1$a
            tu1 r3 = r6.b
            java.lang.String r6 = r6.c
            r2.<init>(r1, r3, r6)
            r6 = r2
            goto L_0x002a
        L_0x0029:
            r6 = 0
        L_0x002a:
            if (r6 == 0) goto L_0x0030
            int r5 = r5 + -1
            if (r5 >= r8) goto L_0x0008
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gj1.k0(int, java.lang.Object, hu1, fw1):java.lang.Object");
    }

    public static int k1(int i) {
        int[] iArr = {1, 2, 3, 4, 5};
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            } else if (i4 == i) {
                return i3;
            }
        }
        return 1;
    }

    public static int k2(mm2<?> mm2, int i, byte[] bArr, int i2, int i3, ja3<?> ja3, v83 v83) throws IOException {
        int e2 = e2(mm2, bArr, i2, i3, v83);
        ja3.add(v83.c);
        while (e2 < i3) {
            int N0 = N0(bArr, e2, v83);
            if (i != v83.f3616a) {
                break;
            }
            e2 = e2(mm2, bArr, N0, i3, v83);
            ja3.add(v83.c);
        }
        return e2;
    }

    @EnsuresNonNull({"#1"})
    public static <T> T l(@RecentlyNonNull T t, @RecentlyNonNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static <T extends SafeParcelable> void l0(@RecentlyNonNull T t, @RecentlyNonNull Intent intent, @RecentlyNonNull String str) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        intent.putExtra(str, marshall);
    }

    public static String l1(String str) {
        try {
            Object invoke = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
            if (invoke != null && String.class.isAssignableFrom(invoke.getClass())) {
                return (String) invoke;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static int l2(int i, byte[] bArr, int i2, int i3, an2 an2, v83 v83) throws ma3 {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int D1 = D1(bArr, i2, v83);
                an2.c(i, Long.valueOf(v83.b));
                return D1;
            } else if (i4 == 1) {
                an2.c(i, Long.valueOf(U1(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int N0 = N0(bArr, i2, v83);
                int i5 = v83.f3616a;
                if (i5 < 0) {
                    throw ma3.b();
                } else if (i5 <= bArr.length - N0) {
                    if (i5 == 0) {
                        an2.c(i, g93.g);
                    } else {
                        an2.c(i, g93.A(bArr, N0, i5));
                    }
                    return N0 + i5;
                } else {
                    throw ma3.a();
                }
            } else if (i4 == 3) {
                int i6 = (i & -8) | 4;
                an2 a2 = an2.a();
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int N02 = N0(bArr, i2, v83);
                    int i8 = v83.f3616a;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = N02;
                        break;
                    }
                    i7 = i8;
                    i2 = l2(i8, bArr, N02, i3, a2, v83);
                }
                if (i2 > i3 || i7 != i6) {
                    throw ma3.f();
                }
                an2.c(i, a2);
                return i2;
            } else if (i4 == 5) {
                an2.c(i, Integer.valueOf(L1(bArr, i2)));
                return i2 + 4;
            } else {
                throw ma3.d();
            }
        } else {
            throw ma3.d();
        }
    }

    @EnsuresNonNull({"#1"})
    public static <T> T m(T t) {
        Objects.requireNonNull(t, "null reference");
        return t;
    }

    public static void m0(Camera.Parameters parameters, pk1 pk1) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes != null && !supportedFocusModes.isEmpty()) {
            if (pk1 == pk1.CONTINUOUS) {
                if (!"continuous-picture".equals(parameters.getFocusMode())) {
                    if (supportedFocusModes.contains("continuous-picture")) {
                        parameters.setFocusMode("continuous-picture");
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!"auto".equals(parameters.getFocusMode()) && supportedFocusModes.contains("auto")) {
                parameters.setFocusMode("auto");
            }
        }
    }

    public static boolean m1() {
        try {
            Class.forName("android.app.Application", false, null);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void n(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void n0(Camera.Parameters parameters, String str) {
        List<String> supportedFlashModes;
        if (!str.equals(parameters.getFlashMode()) && (supportedFlashModes = parameters.getSupportedFlashModes()) != null && supportedFlashModes.contains(str)) {
            parameters.setFlashMode(str);
        }
    }

    public static int n1(int i, byte[] bArr, int i2, v83 v83) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            v83.f3616a = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & Byte.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            v83.f3616a = i5 | (b3 << 14);
            return i6;
        }
        int i7 = i5 | ((b3 & Byte.MAX_VALUE) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            v83.f3616a = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & Byte.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            v83.f3616a = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] < 0) {
                i10 = i12;
            } else {
                v83.f3616a = i11;
                return i12;
            }
        }
    }

    public static void o(boolean z, @RecentlyNonNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void o0(@RecentlyNonNull Status status, @RecentlyNonNull zi4<Void> zi4) {
        if (status.m1()) {
            zi4.f4178a.t(null);
            return;
        }
        zi4.f4178a.u(new y22(status));
    }

    public static int o1(Parcel parcel, int i) {
        parcel.writeInt(i | -65536);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void p(Camera.Parameters parameters, yk1 yk1, xk1 xk1, xk1 xk12, int i, int i2, int i3) {
        boolean z = i3 == 90 || i3 == 270;
        int i4 = z ? i2 : i;
        if (!z) {
            i = i2;
        }
        q(parameters, I(i4, i, yk1, xk1, xk12), i4, i, i3);
    }

    public static void p0(@RecentlyNonNull Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + j0(parcel, i));
    }

    public static int p1(byte[] bArr, int i, qf2 qf2) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            qf2.b = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & Byte.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & Byte.MAX_VALUE)) << i4;
            b2 = b3;
            i3 = i5;
        }
        qf2.b = j2;
        return i3;
    }

    public static void q(Camera.Parameters parameters, yk1 yk1, int i, int i2, int i3) {
        ArrayList arrayList = new ArrayList(1);
        Matrix matrix = new Matrix();
        float[] fArr = {(float) yk1.f4062a, (float) yk1.b, (float) yk1.c, (float) yk1.d};
        matrix.postRotate((float) (-i3), ((float) i) / 2.0f, ((float) i2) / 2.0f);
        matrix.mapPoints(fArr);
        int i4 = (int) fArr[0];
        int i5 = (int) fArr[1];
        int i6 = (int) fArr[2];
        int i7 = (int) fArr[3];
        if (i4 <= i6) {
            i6 = i4;
            i4 = i6;
        }
        if (i5 > i7) {
            i7 = i5;
            i5 = i7;
        }
        yk1 yk12 = new yk1(i6, i5, i4, i7);
        if (i6 < 0 || i5 < 0 || i4 > i || i7 > i2) {
            yk12 = new yk1(Math.max(i6, 0), Math.max(i5, 0), Math.min(i4, i), Math.min(i7, i2));
        }
        arrayList.add(new Camera.Area(new Rect(S(yk12.f4062a, i), S(yk12.b, i2), S(yk12.c, i), S(yk12.d, i2)), Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
        if (parameters.getMaxNumFocusAreas() > 0) {
            parameters.setFocusAreas(arrayList);
        }
        if (parameters.getMaxNumMeteringAreas() > 0) {
            parameters.setMeteringAreas(arrayList);
        }
    }

    @TargetApi(19)
    public static boolean q0(@RecentlyNonNull Context context, int i, @RecentlyNonNull String str) {
        nb2 a2 = ob2.a(context);
        Objects.requireNonNull(a2);
        try {
            AppOpsManager appOpsManager = (AppOpsManager) a2.f2531a.getSystemService("appops");
            if (appOpsManager != null) {
                appOpsManager.checkPackage(i, str);
                return true;
            }
            throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
        } catch (SecurityException unused) {
            return false;
        }
    }

    public static long q1(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }

    public static boolean r(@RecentlyNonNull int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static int r0(@RecentlyNonNull Parcel parcel) {
        String str;
        int readInt = parcel.readInt();
        int j0 = j0(parcel, readInt);
        int dataPosition = parcel.dataPosition();
        if (((char) readInt) != 20293) {
            String valueOf = String.valueOf(Integer.toHexString(readInt));
            if (valueOf.length() != 0) {
                str = "Expected object header. Got 0x".concat(valueOf);
            } else {
                str = new String("Expected object header. Got 0x");
            }
            throw new l82(str, parcel);
        }
        int i = j0 + dataPosition;
        if (i >= dataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new l82(hj1.w(54, "Size read is invalid start=", dataPosition, " end=", i), parcel);
    }

    public static e13 r1(Exception exc, String str, String str2) {
        String message = exc.getMessage();
        String.valueOf(str).length();
        String.valueOf(str2).length();
        String.valueOf(message).length();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30 + String.valueOf(str2).length());
        hj1.V0(sb, "Failed to parse ", str, " for string [", str2);
        sb.append("]");
        return new e13(sb.toString(), exc);
    }

    @RecentlyNonNull
    public static Bundle s(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        Bundle readBundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + j0);
        return readBundle;
    }

    public static void s0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Boolean bool, boolean z) {
        if (bool != null) {
            parcel.writeInt(i | 262144);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static String s1(ju2 ju2) throws NoSuchAlgorithmException {
        jt2 jt2 = jt2.UNKNOWN_FORMAT;
        du2 du2 = du2.UNKNOWN_CURVE;
        ju2 ju22 = ju2.UNKNOWN_HASH;
        int ordinal = ju2.ordinal();
        if (ordinal == 1) {
            return "HmacSha1";
        }
        if (ordinal == 3) {
            return "HmacSha256";
        }
        if (ordinal == 4) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(ju2);
        throw new NoSuchAlgorithmException(hj1.a0(new StringBuilder(valueOf.length() + 27), "hash unsupported for HMAC: ", valueOf));
    }

    @RecentlyNonNull
    public static byte[] t(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        byte[] createByteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + j0);
        return createByteArray;
    }

    public static void t0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Bundle bundle, boolean z) {
        if (bundle != null) {
            int o1 = o1(parcel, i);
            parcel.writeBundle(bundle);
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static BigInteger t1(EllipticCurve ellipticCurve) throws GeneralSecurityException {
        ECField field = ellipticCurve.getField();
        if (field instanceof ECFieldFp) {
            return ((ECFieldFp) field).getP();
        }
        throw new GeneralSecurityException("Only curves over prime order fields are supported");
    }

    @RecentlyNonNull
    public static byte[][] u(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        int readInt = parcel.readInt();
        byte[][] bArr = new byte[readInt][];
        for (int i2 = 0; i2 < readInt; i2++) {
            bArr[i2] = parcel.createByteArray();
        }
        parcel.setDataPosition(dataPosition + j0);
        return bArr;
    }

    public static void u0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull byte[] bArr, boolean z) {
        if (bArr != null) {
            int o1 = o1(parcel, i);
            parcel.writeByteArray(bArr);
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static void u1(Parcel parcel, int i, int i2, int i3) {
        if (i2 != i3) {
            String hexString = Integer.toHexString(i2);
            StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + 46);
            sb.append("Expected size ");
            sb.append(i3);
            sb.append(" got ");
            sb.append(i2);
            throw new l82(hj1.b0(sb, " (0x", hexString, ")"), parcel);
        }
    }

    @RecentlyNonNull
    public static int[] v(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        int[] createIntArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + j0);
        return createIntArray;
    }

    public static void v0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull byte[][] bArr, boolean z) {
        if (bArr != null) {
            int o1 = o1(parcel, i);
            int length = bArr.length;
            parcel.writeInt(length);
            for (byte[] bArr2 : bArr) {
                parcel.writeByteArray(bArr2);
            }
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static final void v1(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                v1(sb, i, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                v1(sb, i, str, entry);
            }
        } else {
            sb.append('\n');
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                g93 g93 = g93.g;
                sb.append(T0(new e93(((String) obj).getBytes(ka3.f2038a))));
                sb.append('\"');
            } else if (obj instanceof g93) {
                sb.append(": \"");
                sb.append(T0((g93) obj));
                sb.append('\"');
            } else if (obj instanceof ea3) {
                sb.append(" {");
                I1((ea3) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i4 = i + 2;
                v1(sb, i4, AnalyticsConstants.KEY, entry2.getKey());
                v1(sb, i4, FirebaseAnalytics.Param.VALUE, entry2.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    @RecentlyNonNull
    public static <T extends Parcelable> T w(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Parcelable.Creator<T> creator) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        T createFromParcel = creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + j0);
        return createFromParcel;
    }

    public static void w0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Float f, boolean z) {
        if (f != null) {
            parcel.writeInt(i | 262144);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static void w1(StringBuilder sb, Locale locale) {
        String language = locale.getLanguage();
        if (language != null) {
            sb.append(language);
            String country = locale.getCountry();
            if (country != null) {
                sb.append("-");
                sb.append(country);
            }
        }
    }

    @RecentlyNonNull
    public static String x(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        String readString = parcel.readString();
        parcel.setDataPosition(dataPosition + j0);
        return readString;
    }

    public static void x0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int o1 = o1(parcel, i);
            parcel.writeStrongBinder(iBinder);
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static boolean x1(@NullableDecl String str) {
        int i = b83.f396a;
        return str == null || str.isEmpty();
    }

    @RecentlyNonNull
    public static String[] y(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        String[] createStringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + j0);
        return createStringArray;
    }

    public static void y0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull int[] iArr, boolean z) {
        if (iArr != null) {
            int o1 = o1(parcel, i);
            parcel.writeIntArray(iArr);
            H1(parcel, o1);
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static byte[] y1(byte[]... bArr) throws GeneralSecurityException {
        int i = 0;
        for (byte[] bArr2 : bArr) {
            int length = bArr2.length;
            if (i <= Integer.MAX_VALUE - length) {
                i += length;
            } else {
                throw new GeneralSecurityException("exceeded size limit");
            }
        }
        byte[] bArr3 = new byte[i];
        int i2 = 0;
        for (byte[] bArr4 : bArr) {
            int length2 = bArr4.length;
            System.arraycopy(bArr4, 0, bArr3, i2, length2);
            i2 += length2;
        }
        return bArr3;
    }

    @RecentlyNonNull
    public static ArrayList<String> z(@RecentlyNonNull Parcel parcel, int i) {
        int j0 = j0(parcel, i);
        int dataPosition = parcel.dataPosition();
        if (j0 == 0) {
            return null;
        }
        ArrayList<String> createStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + j0);
        return createStringArrayList;
    }

    public static void z0(@RecentlyNonNull Parcel parcel, int i, @RecentlyNonNull Long l, boolean z) {
        if (l != null) {
            parcel.writeInt(i | 524288);
            parcel.writeLong(l.longValue());
        } else if (z) {
            parcel.writeInt(i | 0);
        }
    }

    public static long z1(byte[] bArr, int i) {
        return ((long) (((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16))) & LongString.MAX_LENGTH;
    }
}
