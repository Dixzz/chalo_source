package defpackage;

import java.util.Arrays;

/* renamed from: n86  reason: default package */
/* compiled from: Intrinsics */
public class n86 {
    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void b(Object obj, String str) {
        if (obj == null) {
            IllegalStateException illegalStateException = new IllegalStateException(hj1.S(str, " must not be null"));
            i(illegalStateException, n86.class.getName());
            throw illegalStateException;
        }
    }

    public static void c(Object obj) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException();
            i(nullPointerException, n86.class.getName());
            throw nullPointerException;
        }
    }

    public static void d(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(hj1.S(str, " must not be null"));
            i(nullPointerException, n86.class.getName());
            throw nullPointerException;
        }
    }

    public static void e(Object obj, String str) {
        if (obj == null) {
            NullPointerException nullPointerException = new NullPointerException(h(str));
            i(nullPointerException, n86.class.getName());
            throw nullPointerException;
        }
    }

    public static void f(Object obj, String str) {
        if (obj == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(h(str));
            i(illegalArgumentException, n86.class.getName());
            throw illegalArgumentException;
        }
    }

    public static int g(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static String h(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static <T extends Throwable> T i(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static String j(String str, Object obj) {
        return str + obj;
    }

    public static void k() {
        h56 h56 = new h56();
        i(h56, n86.class.getName());
        throw h56;
    }

    public static void l(String str) {
        r56 r56 = new r56(hj1.T("lateinit property ", str, " has not been initialized"));
        i(r56, n86.class.getName());
        throw r56;
    }
}
