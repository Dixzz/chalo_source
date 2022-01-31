package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import com.squareup.picasso.Picasso;
import defpackage.ff5;
import defpackage.kn6;
import defpackage.lf5;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: ne5  reason: default package */
/* compiled from: BitmapHunter */
public class ne5 implements Runnable {
    public static final AtomicInteger A = new AtomicInteger();
    public static final lf5 B = new b();
    public static final Object y = new Object();
    public static final ThreadLocal<StringBuilder> z = new a();
    public final int f = A.incrementAndGet();
    public final Picasso g;
    public final te5 h;
    public final oe5 i;
    public final nf5 j;
    public final String k;
    public final jf5 l;
    public final int m;
    public int n;
    public final lf5 o;
    public le5 p;
    public List<le5> q;
    public Bitmap r;
    public Future<?> s;
    public Picasso.d t;
    public Exception u;
    public int v;
    public int w;
    public Picasso.e x;

    /* renamed from: ne5$a */
    /* compiled from: BitmapHunter */
    public static class a extends ThreadLocal<StringBuilder> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    }

    /* renamed from: ne5$b */
    /* compiled from: BitmapHunter */
    public static class b extends lf5 {
        @Override // defpackage.lf5
        public boolean c(jf5 jf5) {
            return true;
        }

        @Override // defpackage.lf5
        public lf5.a f(jf5 jf5, int i) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + jf5);
        }
    }

    /* renamed from: ne5$c */
    /* compiled from: BitmapHunter */
    public static class c implements Runnable {
        public final /* synthetic */ pf5 f;
        public final /* synthetic */ RuntimeException g;

        public c(pf5 pf5, RuntimeException runtimeException) {
            this.f = pf5;
            this.g = runtimeException;
        }

        public void run() {
            StringBuilder i0 = hj1.i0("Transformation ");
            i0.append(this.f.key());
            i0.append(" crashed with exception.");
            throw new RuntimeException(i0.toString(), this.g);
        }
    }

    /* renamed from: ne5$d */
    /* compiled from: BitmapHunter */
    public static class d implements Runnable {
        public final /* synthetic */ StringBuilder f;

        public d(StringBuilder sb) {
            this.f = sb;
        }

        public void run() {
            throw new NullPointerException(this.f.toString());
        }
    }

    /* renamed from: ne5$e */
    /* compiled from: BitmapHunter */
    public static class e implements Runnable {
        public final /* synthetic */ pf5 f;

        public e(pf5 pf5) {
            this.f = pf5;
        }

        public void run() {
            StringBuilder i0 = hj1.i0("Transformation ");
            i0.append(this.f.key());
            i0.append(" returned input Bitmap but recycled it.");
            throw new IllegalStateException(i0.toString());
        }
    }

    /* renamed from: ne5$f */
    /* compiled from: BitmapHunter */
    public static class f implements Runnable {
        public final /* synthetic */ pf5 f;

        public f(pf5 pf5) {
            this.f = pf5;
        }

        public void run() {
            StringBuilder i0 = hj1.i0("Transformation ");
            i0.append(this.f.key());
            i0.append(" mutated input Bitmap but failed to recycle the original.");
            throw new IllegalStateException(i0.toString());
        }
    }

    public ne5(Picasso picasso, te5 te5, oe5 oe5, nf5 nf5, le5 le5, lf5 lf5) {
        this.g = picasso;
        this.h = te5;
        this.i = oe5;
        this.j = nf5;
        this.p = le5;
        this.k = le5.i;
        jf5 jf5 = le5.b;
        this.l = jf5;
        this.x = jf5.r;
        this.m = le5.e;
        this.n = le5.f;
        this.o = lf5;
        this.w = lf5.e();
    }

    public static Bitmap a(List<pf5> list, Bitmap bitmap) {
        int size = list.size();
        int i2 = 0;
        while (i2 < size) {
            pf5 pf5 = list.get(i2);
            try {
                Bitmap transform = pf5.transform(bitmap);
                if (transform == null) {
                    StringBuilder i0 = hj1.i0("Transformation ");
                    i0.append(pf5.key());
                    i0.append(" returned null after ");
                    i0.append(i2);
                    i0.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (pf5 pf52 : list) {
                        i0.append(pf52.key());
                        i0.append('\n');
                    }
                    Picasso.o.post(new d(i0));
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    Picasso.o.post(new e(pf5));
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled()) {
                    i2++;
                    bitmap = transform;
                } else {
                    Picasso.o.post(new f(pf5));
                    return null;
                }
            } catch (RuntimeException e2) {
                Picasso.o.post(new c(pf5, e2));
                return null;
            }
        }
        return bitmap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v1, resolved type: bf5 */
    /* JADX WARN: Multi-variable type inference failed */
    public static Bitmap c(qn6 qn6, jf5 jf5) throws IOException {
        n86.f(qn6, "$this$buffer");
        kn6 kn6 = new kn6(qn6);
        boolean z2 = kn6.c(0, rf5.b) && kn6.c(8, rf5.c);
        boolean z3 = jf5.p;
        BitmapFactory.Options d2 = lf5.d(jf5);
        boolean z4 = d2 != null && d2.inJustDecodeBounds;
        if (!z2) {
            kn6.a aVar = new kn6.a(kn6);
            if (z4) {
                bf5 bf5 = new bf5(aVar);
                bf5.k = false;
                long j2 = bf5.g + ((long) 1024);
                if (bf5.i < j2) {
                    bf5.c(j2);
                }
                long j3 = bf5.g;
                BitmapFactory.decodeStream(bf5, null, d2);
                lf5.b(jf5.f, jf5.g, d2, jf5);
                bf5.a(j3);
                bf5.k = true;
                aVar = bf5;
            }
            Bitmap decodeStream = BitmapFactory.decodeStream(aVar, null, d2);
            if (decodeStream != null) {
                return decodeStream;
            }
            throw new IOException("Failed to decode stream.");
        }
        kn6.f.t0(kn6.h);
        byte[] O = kn6.f.O();
        if (z4) {
            BitmapFactory.decodeByteArray(O, 0, O.length, d2);
            lf5.b(jf5.f, jf5.g, d2, jf5);
        }
        return BitmapFactory.decodeByteArray(O, 0, O.length, d2);
    }

    public static ne5 e(Picasso picasso, te5 te5, oe5 oe5, nf5 nf5, le5 le5) {
        jf5 jf5 = le5.b;
        List<lf5> list = picasso.d;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            lf5 lf5 = list.get(i2);
            if (lf5.c(jf5)) {
                return new ne5(picasso, te5, oe5, nf5, le5, lf5);
            }
        }
        return new ne5(picasso, te5, oe5, nf5, le5, B);
    }

    public static boolean g(boolean z2, int i2, int i3, int i4, int i5) {
        return !z2 || (i4 != 0 && i2 > i4) || (i5 != 0 && i3 > i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0272  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0276  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x020f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap h(defpackage.jf5 r27, android.graphics.Bitmap r28, int r29) {
        /*
        // Method dump skipped, instructions count: 648
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ne5.h(jf5, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static void i(jf5 jf5) {
        String str;
        Uri uri = jf5.c;
        if (uri != null) {
            str = String.valueOf(uri.getPath());
        } else {
            str = Integer.toHexString(jf5.d);
        }
        StringBuilder sb = z.get();
        sb.ensureCapacity(str.length() + 8);
        sb.replace(8, sb.length(), str);
        Thread.currentThread().setName(sb.toString());
    }

    public boolean b() {
        Future<?> future;
        if (this.p != null) {
            return false;
        }
        List<le5> list = this.q;
        if ((list == null || list.isEmpty()) && (future = this.s) != null && future.cancel(false)) {
            return true;
        }
        return false;
    }

    public void d(le5 le5) {
        boolean z2;
        boolean z3 = true;
        if (this.p == le5) {
            this.p = null;
            z2 = true;
        } else {
            List<le5> list = this.q;
            z2 = list != null ? list.remove(le5) : false;
        }
        if (z2 && le5.b.r == this.x) {
            Picasso.e eVar = Picasso.e.LOW;
            List<le5> list2 = this.q;
            boolean z4 = list2 != null && !list2.isEmpty();
            le5 le52 = this.p;
            if (le52 == null && !z4) {
                z3 = false;
            }
            if (z3) {
                if (le52 != null) {
                    eVar = le52.b.r;
                }
                if (z4) {
                    int size = this.q.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        Picasso.e eVar2 = this.q.get(i2).b.r;
                        if (eVar2.ordinal() > eVar.ordinal()) {
                            eVar = eVar2;
                        }
                    }
                }
            }
            this.x = eVar;
        }
        if (this.g.n) {
            rf5.f("Hunter", "removed", le5.b.b(), rf5.d(this, "from "));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00b3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap f() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 282
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ne5.f():android.graphics.Bitmap");
    }

    public void run() {
        try {
            i(this.l);
            if (this.g.n) {
                rf5.f("Hunter", "executing", rf5.c(this), "");
            }
            Bitmap f2 = f();
            this.r = f2;
            if (f2 == null) {
                this.h.c(this);
            } else {
                this.h.b(this);
            }
        } catch (ff5.b e2) {
            if (!ef5.isOfflineOnly(e2.g) || e2.f != 504) {
                this.u = e2;
            }
            Handler handler = this.h.i;
            handler.sendMessage(handler.obtainMessage(6, this));
        } catch (IOException e3) {
            this.u = e3;
            Handler handler2 = this.h.i;
            handler2.sendMessageDelayed(handler2.obtainMessage(5, this), 500);
        } catch (OutOfMemoryError e4) {
            StringWriter stringWriter = new StringWriter();
            this.j.a().a(new PrintWriter(stringWriter));
            this.u = new RuntimeException(stringWriter.toString(), e4);
            Handler handler3 = this.h.i;
            handler3.sendMessage(handler3.obtainMessage(6, this));
        } catch (Exception e5) {
            this.u = e5;
            Handler handler4 = this.h.i;
            handler4.sendMessage(handler4.obtainMessage(6, this));
        } catch (Throwable th) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }
}
