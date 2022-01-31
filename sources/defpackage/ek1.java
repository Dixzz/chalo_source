package defpackage;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* renamed from: ek1  reason: default package */
/* compiled from: VolleyLog */
public class ek1 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f981a = Log.isLoggable("Volley", 2);
    public static final String b = ek1.class.getName();

    /* renamed from: ek1$a */
    /* compiled from: VolleyLog */
    public static class a {
        public static final boolean c = ek1.f981a;

        /* renamed from: a  reason: collision with root package name */
        public final List<C0021a> f982a = new ArrayList();
        public boolean b = false;

        /* renamed from: ek1$a$a  reason: collision with other inner class name */
        /* compiled from: VolleyLog */
        public static class C0021a {

            /* renamed from: a  reason: collision with root package name */
            public final String f983a;
            public final long b;
            public final long c;

            public C0021a(String str, long j, long j2) {
                this.f983a = str;
                this.b = j;
                this.c = j2;
            }
        }

        public synchronized void a(String str, long j) {
            if (!this.b) {
                this.f982a.add(new C0021a(str, j, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public synchronized void b(String str) {
            long j;
            this.b = true;
            if (this.f982a.size() == 0) {
                j = 0;
            } else {
                long j2 = this.f982a.get(0).c;
                List<C0021a> list = this.f982a;
                j = list.get(list.size() - 1).c - j2;
            }
            if (j > 0) {
                long j3 = this.f982a.get(0).c;
                ek1.a("(%-4d ms) %s", Long.valueOf(j), str);
                for (C0021a aVar : this.f982a) {
                    long j4 = aVar.c;
                    ek1.a("(+%-4d) [%2d] %s", Long.valueOf(j4 - j3), Long.valueOf(aVar.b), aVar.f983a);
                    j3 = j4;
                }
            }
        }

        public void finalize() throws Throwable {
            if (!this.b) {
                b("Request on the loose");
                ek1.a("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i].getClassName().equals(b)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                StringBuilder k0 = hj1.k0(substring.substring(substring.lastIndexOf(36) + 1), ".");
                k0.append(stackTrace[i].getMethodName());
                str2 = k0.toString();
                break;
            } else {
                i++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        if (f981a) {
            a(str, objArr);
        }
    }
}
