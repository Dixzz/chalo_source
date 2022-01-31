package defpackage;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.appcompat.widget.RtlSpacingHelper;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/* renamed from: dr1  reason: default package */
/* compiled from: GifFrameLoader */
public class dr1 {

    /* renamed from: a  reason: collision with root package name */
    public final sl1 f881a;
    public final Handler b;
    public final List<b> c = new ArrayList();
    public final nl1 d;
    public final zn1 e;
    public boolean f = false;
    public boolean g = false;
    public ml1<Bitmap> h;
    public a i;
    public boolean j;
    public a k;
    public Bitmap l;
    public im1<Bitmap> m;

    /* renamed from: dr1$a */
    /* compiled from: GifFrameLoader */
    public static class a extends at1<Bitmap> {
        public final Handler i;
        public final int j;
        public final long k;
        public Bitmap l;

        public a(Handler handler, int i2, long j2) {
            super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
            this.i = handler;
            this.j = i2;
            this.k = j2;
        }

        @Override // defpackage.ct1
        public void b(Object obj, ft1 ft1) {
            this.l = (Bitmap) obj;
            this.i.sendMessageAtTime(this.i.obtainMessage(1, this), this.k);
        }
    }

    /* renamed from: dr1$b */
    /* compiled from: GifFrameLoader */
    public interface b {
        void a();
    }

    /* renamed from: dr1$c */
    /* compiled from: GifFrameLoader */
    public class c implements Handler.Callback {
        public c() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                a aVar = (a) message.obj;
                dr1 dr1 = dr1.this;
                if (dr1.j) {
                    dr1.b.obtainMessage(2, aVar).sendToTarget();
                } else {
                    if (aVar.l != null) {
                        Bitmap bitmap = dr1.l;
                        if (bitmap != null) {
                            dr1.e.d(bitmap);
                            dr1.l = null;
                        }
                        a aVar2 = dr1.i;
                        dr1.i = aVar;
                        int size = dr1.c.size();
                        while (true) {
                            size--;
                            if (size < 0) {
                                break;
                            }
                            dr1.c.get(size).a();
                        }
                        if (aVar2 != null) {
                            dr1.b.obtainMessage(2, aVar2).sendToTarget();
                        }
                    }
                    dr1.g = false;
                    dr1.b();
                }
                return true;
            }
            if (i == 2) {
                dr1.this.d.o((a) message.obj);
            }
            return false;
        }
    }

    /* renamed from: dr1$d */
    /* compiled from: GifFrameLoader */
    public static class d implements dm1 {
        public final UUID b = UUID.randomUUID();

        @Override // defpackage.dm1
        public void a(MessageDigest messageDigest) {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // defpackage.dm1
        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return ((d) obj).b.equals(this.b);
            }
            return false;
        }

        @Override // defpackage.dm1
        public int hashCode() {
            return this.b.hashCode();
        }
    }

    public dr1(gl1 gl1, sl1 sl1, int i2, int i3, im1<Bitmap> im1, Bitmap bitmap) {
        zn1 zn1 = gl1.f;
        nl1 f2 = gl1.f(gl1.h.getBaseContext());
        ml1<Bitmap> j2 = gl1.f(gl1.h.getBaseContext()).j();
        j2.a(new rs1().d(gn1.f1286a).p(true).i(i2, i3));
        this.d = f2;
        Handler handler = new Handler(Looper.getMainLooper(), new c());
        this.e = zn1;
        this.b = handler;
        this.h = j2;
        this.f881a = sl1;
        c(im1, bitmap);
    }

    public Bitmap a() {
        a aVar = this.i;
        if (aVar != null) {
            return aVar.l;
        }
        return this.l;
    }

    public final void b() {
        if (this.f && !this.g) {
            this.g = true;
            long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.f881a.d());
            this.f881a.b();
            this.k = new a(this.b, this.f881a.f(), uptimeMillis);
            ml1<Bitmap> c2 = this.h.clone();
            c2.a(new rs1().o(new d()));
            c2.m = this.f881a;
            c2.p = true;
            c2.f(this.k);
        }
    }

    public void c(im1<Bitmap> im1, Bitmap bitmap) {
        Objects.requireNonNull(im1, "Argument must not be null");
        this.m = im1;
        Objects.requireNonNull(bitmap, "Argument must not be null");
        this.l = bitmap;
        ml1<Bitmap> ml1 = this.h;
        ml1.a(new rs1().r(im1));
        this.h = ml1;
    }
}
