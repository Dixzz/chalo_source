package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import defpackage.sl1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* renamed from: wl1  reason: default package */
/* compiled from: StandardGifDecoder */
public class wl1 implements sl1 {
    public static final String w = "wl1";

    /* renamed from: a  reason: collision with root package name */
    public int[] f3799a;
    public final int[] b = new int[256];
    public ByteBuffer c;
    public byte[] d;
    public byte[] e;
    public int f = 0;
    public int g = 0;
    public short[] h;
    public byte[] i;
    public byte[] j;
    public byte[] k;
    public int[] l;
    public int m;
    public ul1 n;
    public sl1.a o;
    public Bitmap p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public boolean v;

    public wl1(sl1.a aVar, ul1 ul1, ByteBuffer byteBuffer, int i2) {
        int[] iArr;
        this.o = aVar;
        this.n = new ul1();
        synchronized (this) {
            if (i2 > 0) {
                int highestOneBit = Integer.highestOneBit(i2);
                this.r = 0;
                this.n = ul1;
                this.v = false;
                this.m = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.c = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.c.order(ByteOrder.LITTLE_ENDIAN);
                this.q = false;
                Iterator<tl1> it = ul1.e.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().g == 3) {
                            this.q = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                this.s = highestOneBit;
                int i3 = ul1.f;
                this.u = i3 / highestOneBit;
                int i4 = ul1.g;
                this.t = i4 / highestOneBit;
                this.k = ((yq1) this.o).a(i3 * i4);
                sl1.a aVar2 = this.o;
                int i5 = this.u * this.t;
                xn1 xn1 = ((yq1) aVar2).b;
                if (xn1 == null) {
                    iArr = new int[i5];
                } else {
                    iArr = (int[]) xn1.d(i5, int[].class);
                }
                this.l = iArr;
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
            }
        }
    }

    @Override // defpackage.sl1
    public synchronized Bitmap a() {
        if (this.n.c <= 0 || this.m < 0) {
            if (Log.isLoggable(w, 3)) {
                int i2 = this.n.c;
            }
            this.r = 1;
        }
        int i3 = this.r;
        if (i3 != 1) {
            if (i3 != 2) {
                this.r = 0;
                tl1 tl1 = this.n.e.get(this.m);
                int i4 = this.m - 1;
                tl1 tl12 = i4 >= 0 ? this.n.e.get(i4) : null;
                int[] iArr = tl1.k;
                if (iArr == null) {
                    iArr = this.n.f3522a;
                }
                this.f3799a = iArr;
                if (iArr == null) {
                    Log.isLoggable(w, 3);
                    this.r = 1;
                    return null;
                }
                if (tl1.f) {
                    System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                    int[] iArr2 = this.b;
                    this.f3799a = iArr2;
                    iArr2[tl1.h] = 0;
                }
                return k(tl1, tl12);
            }
        }
        Log.isLoggable(w, 3);
        return null;
    }

    @Override // defpackage.sl1
    public void b() {
        this.m = (this.m + 1) % this.n.c;
    }

    @Override // defpackage.sl1
    public int c() {
        return this.n.c;
    }

    @Override // defpackage.sl1
    public void clear() {
        xn1 xn1;
        this.n = null;
        byte[] bArr = this.k;
        if (bArr != null) {
            ((yq1) this.o).b(bArr);
        }
        int[] iArr = this.l;
        if (!(iArr == null || (xn1 = ((yq1) this.o).b) == null)) {
            xn1.c(iArr, int[].class);
        }
        Bitmap bitmap = this.p;
        if (bitmap != null) {
            ((yq1) this.o).f4080a.d(bitmap);
        }
        this.p = null;
        this.c = null;
        this.v = false;
        byte[] bArr2 = this.d;
        if (bArr2 != null) {
            ((yq1) this.o).b(bArr2);
        }
        byte[] bArr3 = this.e;
        if (bArr3 != null) {
            ((yq1) this.o).b(bArr3);
        }
    }

    @Override // defpackage.sl1
    public int d() {
        int i2;
        ul1 ul1 = this.n;
        int i3 = ul1.c;
        if (i3 <= 0 || (i2 = this.m) < 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= i3) {
            return -1;
        }
        return ul1.e.get(i2).i;
    }

    @Override // defpackage.sl1
    public ByteBuffer e() {
        return this.c;
    }

    @Override // defpackage.sl1
    public int f() {
        return this.m;
    }

    @Override // defpackage.sl1
    public int g() {
        return (this.l.length * 4) + this.c.limit() + this.k.length;
    }

    public final Bitmap h() {
        Bitmap.Config config = this.v ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        Bitmap c2 = ((yq1) this.o).f4080a.c(this.u, this.t, config);
        c2.setHasAlpha(true);
        return c2;
    }

    public final int i() {
        try {
            j();
            byte[] bArr = this.e;
            int i2 = this.g;
            this.g = i2 + 1;
            return bArr[i2] & 255;
        } catch (Exception unused) {
            this.r = 1;
            return 0;
        }
    }

    public final void j() {
        if (this.f <= this.g) {
            if (this.e == null) {
                this.e = ((yq1) this.o).a(16384);
            }
            this.g = 0;
            int min = Math.min(this.c.remaining(), 16384);
            this.f = min;
            this.c.get(this.e, 0, min);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:198:0x01b9 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v32, resolved type: short[] */
    /* JADX DEBUG: Multi-variable search result rejected for r7v38, resolved type: short */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r3.j == r30.h) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0202 A[LOOP:6: B:99:0x0200->B:100:0x0202, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x013e A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Bitmap k(defpackage.tl1 r30, defpackage.tl1 r31) {
        /*
        // Method dump skipped, instructions count: 963
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wl1.k(tl1, tl1):android.graphics.Bitmap");
    }
}
