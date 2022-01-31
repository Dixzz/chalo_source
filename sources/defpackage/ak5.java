package defpackage;

import android.util.Log;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: ak5  reason: default package */
/* compiled from: LoggingCore */
public class ak5 {
    public static final List<String> d = Arrays.asList(ak5.class.getName(), yj5.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public String f175a;
    public int b;
    public final List<zj5> c = new CopyOnWriteArrayList();

    public ak5(int i, String str) {
        this.b = i;
        this.f175a = str;
    }

    public void a(int i, Throwable th, String str, Object... objArr) {
        String str2;
        if (this.b <= i) {
            if (str != null || th != null) {
                String str3 = "";
                if (i == 3 || i == 2) {
                    if (str == null) {
                        str = str3;
                    } else {
                        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                        int i2 = 1;
                        while (true) {
                            if (i2 >= stackTrace.length) {
                                str2 = null;
                                break;
                            }
                            String className = stackTrace[i2].getClassName();
                            if (!d.contains(className)) {
                                String[] split = className.split("\\.");
                                str2 = split[split.length - 1].replaceAll("(\\$.+)+$", str3);
                                break;
                            }
                            i2++;
                        }
                        if (str2 != null && !str.startsWith(str2)) {
                            str = hj1.T(str2, " - ", str);
                        }
                    }
                }
                if (!hd3.G1(str)) {
                    if (objArr != null) {
                        try {
                            if (objArr.length != 0) {
                                str = String.format(Locale.ROOT, str, objArr);
                            }
                        } catch (Exception e) {
                            th = e;
                            str3 = hj1.S("Unable to format log message: ", str);
                            i = 6;
                        }
                    }
                    str3 = str;
                }
                for (zj5 zj5 : this.c) {
                    zj5.a(i, th, str3);
                }
                if (th == null) {
                    if (i == 7) {
                        Log.wtf(this.f175a, str3);
                    } else {
                        Log.println(i, this.f175a, str3);
                    }
                } else if (i == 7) {
                    Log.wtf(this.f175a, str3, th);
                }
            }
        }
    }
}
