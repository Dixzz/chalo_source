package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.razorpay.AnalyticsConstants;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: uy1  reason: default package */
public class uy1 implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f3571a;
    public final zy1 b;
    public final Context c;
    public yy1 d;
    public vy1 e;

    public uy1(zy1 zy1, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        String str;
        Objects.requireNonNull(context, "context cannot be null");
        this.f3571a = uncaughtExceptionHandler;
        this.b = zy1;
        this.d = new yy1(context, new ArrayList());
        this.c = context.getApplicationContext();
        if (uncaughtExceptionHandler == null) {
            str = AnalyticsConstants.NULL;
        } else {
            str = uncaughtExceptionHandler.getClass().getName();
        }
        rd3.b(str.length() != 0 ? "ExceptionReporter created, original handler is ".concat(str) : new String("ExceptionReporter created, original handler is "));
    }

    public void uncaughtException(Thread thread, Throwable th) {
        String str;
        if (this.d != null) {
            StackTraceElement stackTraceElement = null;
            String name = thread != null ? thread.getName() : null;
            yy1 yy1 = this.d;
            Objects.requireNonNull(yy1);
            Throwable th2 = th;
            while (th2.getCause() != null) {
                th2 = th2.getCause();
            }
            Throwable th3 = th;
            while (th3.getCause() != null) {
                th3 = th3.getCause();
            }
            StackTraceElement[] stackTrace = th3.getStackTrace();
            if (stackTrace != null && stackTrace.length != 0) {
                int length = stackTrace.length;
                int i = 0;
                loop2:
                while (true) {
                    if (i >= length) {
                        stackTraceElement = stackTrace[0];
                        break;
                    }
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    String className = stackTraceElement2.getClassName();
                    Iterator<String> it = yy1.f4099a.iterator();
                    while (it.hasNext()) {
                        if (className.startsWith(it.next())) {
                            stackTraceElement = stackTraceElement2;
                            break loop2;
                        }
                    }
                    i++;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append(th2.getClass().getSimpleName());
            if (stackTraceElement != null) {
                String[] split = stackTraceElement.getClassName().split("\\.");
                sb.append(String.format(" (@%s:%s:%s)", (split == null || split.length <= 0) ? "unknown" : split[split.length - 1], stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())));
            }
            if (name != null) {
                sb.append(String.format(" {%s}", name));
            }
            str = sb.toString();
        } else {
            str = "UncaughtException";
        }
        String valueOf = String.valueOf(str);
        rd3.b(valueOf.length() != 0 ? "Reporting uncaught exception: ".concat(valueOf) : new String("Reporting uncaught exception: "));
        zy1 zy1 = this.b;
        wy1 wy1 = new wy1();
        wy1.a("&exd", str);
        wy1.a("&exf", "1");
        HashMap hashMap = new HashMap(wy1.f3979a);
        int i2 = 1;
        for (bz1 bz1 : wy1.c) {
            hashMap.putAll(bz1.a(gj1.U0("&promo", i2)));
            i2++;
        }
        int i3 = 1;
        for (az1 az1 : wy1.d) {
            hashMap.putAll(az1.a(gj1.U0("&pr", i3)));
            i3++;
        }
        int i4 = 1;
        for (Map.Entry<String, List<az1>> entry : wy1.b.entrySet()) {
            String U0 = gj1.U0("&il", i4);
            int i5 = 1;
            for (az1 az12 : entry.getValue()) {
                String valueOf2 = String.valueOf(U0);
                String valueOf3 = String.valueOf(gj1.U0("pi", i5));
                hashMap.putAll(az12.a(valueOf3.length() != 0 ? valueOf2.concat(valueOf3) : new String(valueOf2)));
                i5++;
            }
            if (!TextUtils.isEmpty(entry.getKey())) {
                hashMap.put(String.valueOf(U0).concat("nm"), entry.getKey());
            }
            i4++;
        }
        zy1.i0(hashMap);
        if (this.e == null) {
            this.e = vy1.a(this.c);
        }
        vy1 vy1 = this.e;
        vy1.d.e().m0();
        sb3 e2 = vy1.d.e();
        e2.g0();
        try {
            e2.w().a(new wb3(e2)).get(4, TimeUnit.SECONDS);
        } catch (InterruptedException e3) {
            e2.J("syncDispatchLocalHits interrupted", e3);
        } catch (ExecutionException e4) {
            e2.L("syncDispatchLocalHits failed", e4);
        } catch (TimeoutException e5) {
            e2.J("syncDispatchLocalHits timed out", e5);
        }
        if (this.f3571a != null) {
            rd3.b("Passing exception to the original handler");
            this.f3571a.uncaughtException(thread, th);
        }
    }
}
