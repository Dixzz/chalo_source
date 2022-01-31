package defpackage;

import android.graphics.Bitmap;
import defpackage.kq1;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Queue;

/* renamed from: pq1  reason: default package */
/* compiled from: StreamBitmapDecoder */
public class pq1 implements gm1<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public final kq1 f2839a;
    public final xn1 b;

    /* renamed from: pq1$a */
    /* compiled from: StreamBitmapDecoder */
    public static class a implements kq1.b {

        /* renamed from: a  reason: collision with root package name */
        public final oq1 f2840a;
        public final mt1 b;

        public a(oq1 oq1, mt1 mt1) {
            this.f2840a = oq1;
            this.b = mt1;
        }

        @Override // defpackage.kq1.b
        public void a(zn1 zn1, Bitmap bitmap) throws IOException {
            IOException iOException = this.b.g;
            if (iOException != null) {
                if (bitmap != null) {
                    zn1.d(bitmap);
                }
                throw iOException;
            }
        }

        @Override // defpackage.kq1.b
        public void b() {
            oq1 oq1 = this.f2840a;
            synchronized (oq1) {
                oq1.h = oq1.f.length;
            }
        }
    }

    public pq1(kq1 kq1, xn1 xn1) {
        this.f2839a = kq1;
        this.b = xn1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, fm1] */
    @Override // defpackage.gm1
    public boolean a(InputStream inputStream, fm1 fm1) throws IOException {
        Objects.requireNonNull(this.f2839a);
        return true;
    }

    /* Return type fixed from 'rn1' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.gm1
    public rn1<Bitmap> b(InputStream inputStream, int i, int i2, fm1 fm1) throws IOException {
        oq1 oq1;
        boolean z;
        mt1 poll;
        InputStream inputStream2 = inputStream;
        if (inputStream2 instanceof oq1) {
            oq1 = (oq1) inputStream2;
            z = false;
        } else {
            oq1 = new oq1(inputStream2, this.b);
            z = true;
        }
        Queue<mt1> queue = mt1.h;
        synchronized (queue) {
            poll = queue.poll();
        }
        if (poll == null) {
            poll = new mt1();
        }
        poll.f = oq1;
        try {
            return this.f2839a.a(new pt1(poll), i, i2, fm1, new a(oq1, poll));
        } finally {
            poll.a();
            if (z) {
                oq1.c();
            }
        }
    }
}
