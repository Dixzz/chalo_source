package defpackage;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import java.util.Objects;

/* renamed from: ra4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class ra4 extends sc4 {
    public char c = 0;
    public long d = -1;
    public String e;
    public final ta4 f = new ta4(this, 6, false, false);
    public final ta4 g = new ta4(this, 6, true, false);
    public final ta4 h = new ta4(this, 6, false, true);
    public final ta4 i = new ta4(this, 5, false, false);
    public final ta4 j = new ta4(this, 5, true, false);
    public final ta4 k = new ta4(this, 5, false, true);
    public final ta4 l = new ta4(this, 4, false, false);
    public final ta4 m = new ta4(this, 3, false, false);
    public final ta4 n = new ta4(this, 2, false, false);

    public ra4(vb4 vb4) {
        super(vb4);
    }

    public static Object q(String str) {
        if (str == null) {
            return null;
        }
        return new wa4(str);
    }

    public static String s(boolean z, Object obj) {
        String className;
        String str = "";
        if (obj == null) {
            return str;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf((long) ((Integer) obj).intValue());
        }
        int i2 = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l2 = (Long) obj;
            if (Math.abs(l2.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str = "-";
            }
            String valueOf = String.valueOf(Math.abs(l2.longValue()));
            long round = Math.round(Math.pow(10.0d, (double) (valueOf.length() - 1)));
            long round2 = Math.round(Math.pow(10.0d, (double) valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(str.length() + str.length() + 43);
            sb.append(str);
            sb.append(round);
            sb.append("...");
            sb.append(str);
            sb.append(round2);
            return sb.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th = (Throwable) obj;
                StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
                String x = x(vb4.class.getCanonicalName());
                StackTraceElement[] stackTrace = th.getStackTrace();
                int length = stackTrace.length;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    StackTraceElement stackTraceElement = stackTrace[i2];
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && x(className).equals(x)) {
                        sb2.append(": ");
                        sb2.append(stackTraceElement);
                        break;
                    }
                    i2++;
                }
                return sb2.toString();
            } else if (obj instanceof wa4) {
                return ((wa4) obj).f3753a;
            } else {
                if (z) {
                    return "-";
                }
                return String.valueOf(obj);
            }
        }
    }

    public static String t(boolean z, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String s = s(z, obj);
        String s2 = s(z, obj2);
        String s3 = s(z, obj3);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(s)) {
            sb.append(str2);
            sb.append(s);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(s2)) {
            sb.append(str2);
            sb.append(s2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(s3)) {
            sb.append(str3);
            sb.append(s3);
        }
        return sb.toString();
    }

    public static String x(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return str;
        }
        return str.substring(0, lastIndexOf);
    }

    public final ta4 A() {
        return this.k;
    }

    public final ta4 B() {
        return this.m;
    }

    public final ta4 C() {
        return this.n;
    }

    public final String D() {
        long j2;
        Pair<String, Long> pair;
        lb4 lb4 = i().d;
        lb4.e.b();
        lb4.e.b();
        long j3 = lb4.e.v().getLong(lb4.f2197a, 0);
        if (j3 == 0) {
            lb4.a();
            j2 = 0;
        } else {
            Objects.requireNonNull((db2) lb4.e.f3331a.n);
            j2 = Math.abs(j3 - System.currentTimeMillis());
        }
        long j4 = lb4.d;
        if (j2 >= j4) {
            if (j2 > (j4 << 1)) {
                lb4.a();
            } else {
                String string = lb4.e.v().getString(lb4.c, null);
                long j5 = lb4.e.v().getLong(lb4.b, 0);
                lb4.a();
                if (string == null || j5 <= 0) {
                    pair = eb4.D;
                } else {
                    pair = new Pair<>(string, Long.valueOf(j5));
                }
                if (pair != null || pair == eb4.D) {
                    return null;
                }
                String valueOf = String.valueOf(pair.second);
                String str = (String) pair.first;
                return hj1.y(hj1.g0(str, valueOf.length() + 1), valueOf, ProductDiscountsObject.KEY_DELIMITER, str);
            }
        }
        pair = null;
        if (pair != null) {
        }
        return null;
    }

    public final String E() {
        String str;
        synchronized (this) {
            if (this.e == null) {
                String str2 = this.f3331a.d;
                if (str2 == null) {
                    str2 = "FA";
                }
                this.e = str2;
            }
            str = this.e;
        }
        return str;
    }

    @Override // defpackage.sc4
    public final boolean p() {
        return false;
    }

    public final void u(int i2, String str) {
        Log.println(i2, E(), str);
    }

    public final void v(int i2, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && Log.isLoggable(E(), i2)) {
            Log.println(i2, E(), t(false, str, obj, obj2, obj3));
        }
        if (!z2 && i2 >= 5) {
            Objects.requireNonNull(str, "null reference");
            sb4 sb4 = this.f3331a.j;
            if (sb4 == null) {
                u(6, "Scheduler not set. Not logging error/warn");
            } else if (!sb4.k()) {
                u(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i2 < 0) {
                    i2 = 0;
                }
                sb4.u(new ua4(this, i2 >= 9 ? 8 : i2, str, obj, obj2, obj3));
            }
        }
    }

    public final boolean w(int i2) {
        return Log.isLoggable(E(), i2);
    }

    public final ta4 y() {
        return this.f;
    }

    public final ta4 z() {
        return this.i;
    }
}
