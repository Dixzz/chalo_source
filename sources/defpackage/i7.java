package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: i7  reason: default package */
/* compiled from: FontRequestWorker */
public class i7 {

    /* renamed from: a  reason: collision with root package name */
    public static final s2<String, Typeface> f1484a = new s2<>(16);
    public static final ExecutorService b;
    public static final Object c = new Object();
    public static final u2<String, ArrayList<t7<a>>> d = new u2<>();

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, (long) 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new m7("fonts-androidx", 10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.i7.a a(java.lang.String r7, android.content.Context r8, defpackage.d7 r9, int r10) {
        /*
        // Method dump skipped, instructions count: 104
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i7.a(java.lang.String, android.content.Context, d7, int):i7$a");
    }

    /* renamed from: i7$a */
    /* compiled from: FontRequestWorker */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Typeface f1485a;
        public final int b;

        public a(int i) {
            this.f1485a = null;
            this.b = i;
        }

        @SuppressLint({"WrongConstant"})
        public a(Typeface typeface) {
            this.f1485a = typeface;
            this.b = 0;
        }
    }
}
