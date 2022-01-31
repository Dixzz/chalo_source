package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import defpackage.cm1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/* renamed from: xq1  reason: default package */
/* compiled from: ByteBufferGifDecoder */
public class xq1 implements gm1<ByteBuffer, zq1> {
    public static final a g = new a();
    public static final em1<Boolean> h = em1.a("com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder.DisableAnimation", Boolean.FALSE);
    public static final b i = new b();

    /* renamed from: a  reason: collision with root package name */
    public final Context f3953a;
    public final List<cm1> b;
    public final b c;
    public final zn1 d;
    public final a e;
    public final yq1 f;

    /* renamed from: xq1$a */
    /* compiled from: ByteBufferGifDecoder */
    public static class a {
    }

    /* renamed from: xq1$b */
    /* compiled from: ByteBufferGifDecoder */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Queue<vl1> f3954a = new ArrayDeque(0);

        public b() {
            char[] cArr = rt1.f3126a;
        }

        public synchronized void a(vl1 vl1) {
            vl1.b = null;
            vl1.c = null;
            this.f3954a.offer(vl1);
        }
    }

    public xq1(Context context, List<cm1> list, zn1 zn1, xn1 xn1) {
        b bVar = i;
        a aVar = g;
        this.f3953a = context.getApplicationContext();
        this.b = list;
        this.d = zn1;
        this.e = aVar;
        this.f = new yq1(zn1, xn1);
        this.c = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, fm1] */
    @Override // defpackage.gm1
    public boolean a(ByteBuffer byteBuffer, fm1 fm1) throws IOException {
        cm1.a aVar;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (!((Boolean) fm1.c(h)).booleanValue()) {
            List<cm1> list = this.b;
            if (byteBuffer2 != null) {
                Iterator<cm1> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        aVar = cm1.a.UNKNOWN;
                        break;
                    }
                    cm1.a a2 = it.next().a(byteBuffer2);
                    if (a2 != cm1.a.UNKNOWN) {
                        aVar = a2;
                        break;
                    }
                }
            } else {
                aVar = cm1.a.UNKNOWN;
            }
            if (aVar == cm1.a.GIF) {
                return true;
            }
        }
        return false;
    }

    /* Return type fixed from 'rn1' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int, int, fm1] */
    @Override // defpackage.gm1
    public rn1<zq1> b(ByteBuffer byteBuffer, int i2, int i3, fm1 fm1) throws IOException {
        vl1 poll;
        ByteBuffer byteBuffer2 = byteBuffer;
        b bVar = this.c;
        synchronized (bVar) {
            poll = bVar.f3954a.poll();
            if (poll == null) {
                poll = new vl1();
            }
            poll.b = null;
            Arrays.fill(poll.f3662a, (byte) 0);
            poll.c = new ul1();
            poll.d = 0;
            ByteBuffer asReadOnlyBuffer = byteBuffer2.asReadOnlyBuffer();
            poll.b = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            poll.b.order(ByteOrder.LITTLE_ENDIAN);
        }
        try {
            return c(byteBuffer2, i2, i3, poll);
        } finally {
            this.c.a(poll);
        }
    }

    public final br1 c(ByteBuffer byteBuffer, int i2, int i3, vl1 vl1) {
        ul1 ul1;
        int i4 = nt1.b;
        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        if (vl1.b != null) {
            int i5 = 0;
            if (vl1.a()) {
                ul1 = vl1.c;
            } else {
                String str = "";
                for (int i6 = 0; i6 < 6; i6++) {
                    StringBuilder i0 = hj1.i0(str);
                    i0.append((char) vl1.b());
                    str = i0.toString();
                }
                if (!str.startsWith("GIF")) {
                    vl1.c.b = 1;
                } else {
                    vl1.c.f = vl1.e();
                    vl1.c.g = vl1.e();
                    int b2 = vl1.b();
                    ul1 ul12 = vl1.c;
                    ul12.h = (b2 & 128) != 0;
                    ul12.i = (int) Math.pow(2.0d, (double) ((b2 & 7) + 1));
                    vl1.c.j = vl1.b();
                    ul1 ul13 = vl1.c;
                    vl1.b();
                    Objects.requireNonNull(ul13);
                    if (vl1.c.h && !vl1.a()) {
                        ul1 ul14 = vl1.c;
                        ul14.f3522a = vl1.d(ul14.i);
                        ul1 ul15 = vl1.c;
                        ul15.k = ul15.f3522a[ul15.j];
                    }
                }
                if (!vl1.a()) {
                    boolean z = false;
                    while (!z && !vl1.a() && vl1.c.c <= Integer.MAX_VALUE) {
                        int b3 = vl1.b();
                        if (b3 == 33) {
                            int b4 = vl1.b();
                            if (b4 == 1) {
                                vl1.f();
                            } else if (b4 == 249) {
                                vl1.c.d = new tl1();
                                vl1.b();
                                int b5 = vl1.b();
                                tl1 tl1 = vl1.c.d;
                                int i7 = (b5 & 28) >> 2;
                                tl1.g = i7;
                                if (i7 == 0) {
                                    tl1.g = 1;
                                }
                                tl1.f = (b5 & 1) != 0;
                                int e2 = vl1.e();
                                if (e2 < 2) {
                                    e2 = 10;
                                }
                                tl1 tl12 = vl1.c.d;
                                tl12.i = e2 * 10;
                                tl12.h = vl1.b();
                                vl1.b();
                            } else if (b4 == 254) {
                                vl1.f();
                            } else if (b4 != 255) {
                                vl1.f();
                            } else {
                                vl1.c();
                                String str2 = "";
                                for (int i8 = 0; i8 < 11; i8++) {
                                    StringBuilder i02 = hj1.i0(str2);
                                    i02.append((char) vl1.f3662a[i8]);
                                    str2 = i02.toString();
                                }
                                if (str2.equals("NETSCAPE2.0")) {
                                    do {
                                        vl1.c();
                                        byte[] bArr = vl1.f3662a;
                                        if (bArr[0] == 1) {
                                            byte b6 = bArr[1];
                                            byte b7 = bArr[2];
                                            Objects.requireNonNull(vl1.c);
                                        }
                                        if (vl1.d <= 0) {
                                            break;
                                        }
                                    } while (!vl1.a());
                                } else {
                                    vl1.f();
                                }
                            }
                        } else if (b3 == 44) {
                            ul1 ul16 = vl1.c;
                            if (ul16.d == null) {
                                ul16.d = new tl1();
                            }
                            ul16.d.f3373a = vl1.e();
                            vl1.c.d.b = vl1.e();
                            vl1.c.d.c = vl1.e();
                            vl1.c.d.d = vl1.e();
                            int b8 = vl1.b();
                            boolean z2 = (b8 & 128) != 0;
                            int pow = (int) Math.pow(2.0d, (double) ((b8 & 7) + 1));
                            tl1 tl13 = vl1.c.d;
                            tl13.e = (b8 & 64) != 0;
                            if (z2) {
                                tl13.k = vl1.d(pow);
                            } else {
                                tl13.k = null;
                            }
                            vl1.c.d.j = vl1.b.position();
                            vl1.b();
                            vl1.f();
                            if (!vl1.a()) {
                                ul1 ul17 = vl1.c;
                                ul17.c++;
                                ul17.e.add(ul17.d);
                            }
                        } else if (b3 != 59) {
                            vl1.c.b = 1;
                        } else {
                            z = true;
                        }
                    }
                    ul1 ul18 = vl1.c;
                    if (ul18.c < 0) {
                        ul18.b = 1;
                    }
                }
                ul1 = vl1.c;
            }
            if (ul1.c <= 0 || ul1.b != 0) {
                return null;
            }
            int min = Math.min(ul1.g / i3, ul1.f / i2);
            if (min != 0) {
                i5 = Integer.highestOneBit(min);
            }
            int max = Math.max(1, i5);
            a aVar = this.e;
            yq1 yq1 = this.f;
            Objects.requireNonNull(aVar);
            wl1 wl1 = new wl1(yq1, ul1, byteBuffer, max);
            wl1.m = (wl1.m + 1) % wl1.n.c;
            Bitmap a2 = wl1.a();
            if (a2 == null) {
                return null;
            }
            zq1 zq1 = new zq1(this.f3953a, wl1, this.d, (yp1) yp1.b, i2, i3, a2);
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                nt1.a(elapsedRealtimeNanos);
            }
            return new br1(zq1);
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }
}
