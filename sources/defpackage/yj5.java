package defpackage;

import app.zophop.pubsub.eventbus.events.CardValidityCheckEvent;
import java.util.Locale;

/* renamed from: yj5  reason: default package */
/* compiled from: Logger */
public class yj5 {

    /* renamed from: a  reason: collision with root package name */
    public static ak5 f4059a = new ak5(6, "UALib");

    public static void a(String str, Object... objArr) {
        f4059a.a(3, null, str, objArr);
    }

    public static void b(Throwable th, String str, Object... objArr) {
        f4059a.a(3, th, str, objArr);
    }

    public static void c(String str, Object... objArr) {
        f4059a.a(6, null, str, objArr);
    }

    public static void d(Throwable th) {
        f4059a.a(6, th, null, null);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        f4059a.a(6, th, str, objArr);
    }

    public static void f(String str, Object... objArr) {
        f4059a.a(4, null, str, objArr);
    }

    public static int g(String str, int i) throws IllegalArgumentException {
        if (hd3.G1(str)) {
            return i;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        upperCase.hashCode();
        char c = 65535;
        switch (upperCase.hashCode()) {
            case 2251950:
                if (upperCase.equals("INFO")) {
                    c = 0;
                    break;
                }
                break;
            case 2402104:
                if (upperCase.equals("NONE")) {
                    c = 1;
                    break;
                }
                break;
            case 2656902:
                if (upperCase.equals("WARN")) {
                    c = 2;
                    break;
                }
                break;
            case 64921139:
                if (upperCase.equals("DEBUG")) {
                    c = 3;
                    break;
                }
                break;
            case 66247144:
                if (upperCase.equals(CardValidityCheckEvent.VALIDITY_CHECK_ERROR)) {
                    c = 4;
                    break;
                }
                break;
            case 1069090146:
                if (upperCase.equals("VERBOSE")) {
                    c = 5;
                    break;
                }
                break;
            case 1940088646:
                if (upperCase.equals("ASSERT")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 4;
            case 1:
            case 6:
                return 7;
            case 2:
                return 5;
            case 3:
                return 3;
            case 4:
                return 6;
            case 5:
                return 2;
            default:
                try {
                    int parseInt = Integer.parseInt(str);
                    if (parseInt <= 7 && parseInt >= 2) {
                        return parseInt;
                    }
                    i("%s is not a valid log level. Falling back to %s.", Integer.valueOf(parseInt), Integer.valueOf(i));
                    return i;
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException(hj1.S("Invalid log level: ", str));
                }
        }
    }

    public static void h(String str, Object... objArr) {
        f4059a.a(2, null, str, objArr);
    }

    public static void i(String str, Object... objArr) {
        f4059a.a(5, null, str, objArr);
    }

    public static void j(Throwable th, String str, Object... objArr) {
        f4059a.a(5, th, str, objArr);
    }
}
