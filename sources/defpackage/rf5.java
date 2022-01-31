package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Looper;
import android.os.Process;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadFactory;

/* renamed from: rf5  reason: default package */
/* compiled from: Utils */
public final class rf5 {

    /* renamed from: a  reason: collision with root package name */
    public static final StringBuilder f3076a = new StringBuilder();
    public static final zm6 b = zm6.f("RIFF");
    public static final zm6 c = zm6.f("WEBP");

    /* renamed from: rf5$a */
    /* compiled from: Utils */
    public static class a extends Thread {
        public a(Runnable runnable) {
            super(runnable);
        }

        public void run() {
            Process.setThreadPriority(10);
            super.run();
        }
    }

    /* renamed from: rf5$b */
    /* compiled from: Utils */
    public static class b implements ThreadFactory {
        public Thread newThread(Runnable runnable) {
            return new a(runnable);
        }
    }

    public static String a(jf5 jf5, StringBuilder sb) {
        Objects.requireNonNull(jf5);
        Uri uri = jf5.c;
        if (uri != null) {
            String uri2 = uri.toString();
            sb.ensureCapacity(uri2.length() + 50);
            sb.append(uri2);
        } else {
            sb.ensureCapacity(50);
            sb.append(jf5.d);
        }
        sb.append('\n');
        if (jf5.l != 0.0f) {
            sb.append("rotation:");
            sb.append(jf5.l);
            if (jf5.o) {
                sb.append('@');
                sb.append(jf5.m);
                sb.append('x');
                sb.append(jf5.n);
            }
            sb.append('\n');
        }
        if (jf5.a()) {
            sb.append("resize:");
            sb.append(jf5.f);
            sb.append('x');
            sb.append(jf5.g);
            sb.append('\n');
        }
        if (jf5.h) {
            sb.append("centerCrop:");
            sb.append(jf5.i);
            sb.append('\n');
        } else if (jf5.j) {
            sb.append("centerInside");
            sb.append('\n');
        }
        List<pf5> list = jf5.e;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                sb.append(jf5.e.get(i).key());
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static int b(Bitmap bitmap) {
        int allocationByteCount = bitmap.getAllocationByteCount();
        if (allocationByteCount >= 0) {
            return allocationByteCount;
        }
        throw new IllegalStateException("Negative size: " + bitmap);
    }

    public static String c(ne5 ne5) {
        return d(ne5, "");
    }

    public static String d(ne5 ne5, String str) {
        StringBuilder sb = new StringBuilder(str);
        le5 le5 = ne5.p;
        if (le5 != null) {
            sb.append(le5.b.b());
        }
        List<le5> list = ne5.q;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0 || le5 != null) {
                    sb.append(", ");
                }
                sb.append(list.get(i).b.b());
            }
        }
        return sb.toString();
    }

    public static boolean e() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static void f(String str, String str2, String str3, String str4) {
        String.format("%1$-11s %2$-12s %3$s %4$s", str, str2, str3, str4);
    }
}
