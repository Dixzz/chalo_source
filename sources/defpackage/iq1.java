package defpackage;

import com.google.firebase.perf.util.Constants;
import com.rabbitmq.client.StringRpcServer;
import defpackage.cm1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Objects;

/* renamed from: iq1  reason: default package */
/* compiled from: DefaultImageHeaderParser */
public final class iq1 implements cm1 {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f1555a = "Exif\u0000\u0000".getBytes(Charset.forName(StringRpcServer.STRING_ENCODING));
    public static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* renamed from: iq1$a */
    /* compiled from: DefaultImageHeaderParser */
    public static final class a implements c {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f1556a;

        public a(ByteBuffer byteBuffer) {
            this.f1556a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // defpackage.iq1.c
        public long d(long j) throws IOException {
            int min = (int) Math.min((long) this.f1556a.remaining(), j);
            ByteBuffer byteBuffer = this.f1556a;
            byteBuffer.position(byteBuffer.position() + min);
            return (long) min;
        }

        @Override // defpackage.iq1.c
        public int e() throws IOException {
            return ((g() << 8) & 65280) | (g() & Constants.MAX_HOST_LENGTH);
        }

        @Override // defpackage.iq1.c
        public int f(byte[] bArr, int i) throws IOException {
            int min = Math.min(i, this.f1556a.remaining());
            if (min == 0) {
                return -1;
            }
            this.f1556a.get(bArr, 0, min);
            return min;
        }

        @Override // defpackage.iq1.c
        public int g() throws IOException {
            if (this.f1556a.remaining() < 1) {
                return -1;
            }
            return this.f1556a.get();
        }
    }

    /* renamed from: iq1$b */
    /* compiled from: DefaultImageHeaderParser */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final ByteBuffer f1557a;

        public b(byte[] bArr, int i) {
            this.f1557a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public short a(int i) {
            if (this.f1557a.remaining() - i >= 2) {
                return this.f1557a.getShort(i);
            }
            return -1;
        }

        public int b(int i) {
            if (this.f1557a.remaining() - i >= 4) {
                return this.f1557a.getInt(i);
            }
            return -1;
        }
    }

    /* renamed from: iq1$c */
    /* compiled from: DefaultImageHeaderParser */
    public interface c {
        long d(long j) throws IOException;

        int e() throws IOException;

        int f(byte[] bArr, int i) throws IOException;

        int g() throws IOException;
    }

    /* renamed from: iq1$d */
    /* compiled from: DefaultImageHeaderParser */
    public static final class d implements c {

        /* renamed from: a  reason: collision with root package name */
        public final InputStream f1558a;

        public d(InputStream inputStream) {
            this.f1558a = inputStream;
        }

        public short a() throws IOException {
            return (short) (this.f1558a.read() & Constants.MAX_HOST_LENGTH);
        }

        @Override // defpackage.iq1.c
        public long d(long j) throws IOException {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f1558a.skip(j2);
                if (skip <= 0) {
                    if (this.f1558a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }

        @Override // defpackage.iq1.c
        public int e() throws IOException {
            return ((this.f1558a.read() << 8) & 65280) | (this.f1558a.read() & Constants.MAX_HOST_LENGTH);
        }

        @Override // defpackage.iq1.c
        public int f(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int read = this.f1558a.read(bArr, i - i2, i2);
                if (read == -1) {
                    break;
                }
                i2 -= read;
            }
            return i - i2;
        }

        @Override // defpackage.iq1.c
        public int g() throws IOException {
            return this.f1558a.read();
        }
    }

    @Override // defpackage.cm1
    public cm1.a a(ByteBuffer byteBuffer) throws IOException {
        return d(new a(byteBuffer));
    }

    @Override // defpackage.cm1
    public cm1.a b(InputStream inputStream) throws IOException {
        return d(new d(inputStream));
    }

    @Override // defpackage.cm1
    public int c(InputStream inputStream, xn1 xn1) throws IOException {
        int i;
        short a2;
        d dVar = new d(inputStream);
        Objects.requireNonNull(xn1, "Argument must not be null");
        int e = dVar.e();
        int i2 = -1;
        if ((e & 65496) == 65496 || e == 19789 || e == 18761) {
            while (true) {
                if (dVar.a() == 255 && (a2 = dVar.a()) != 218 && a2 != 217) {
                    i = dVar.e() - 2;
                    if (a2 == 225) {
                        break;
                    }
                    long j = (long) i;
                    if (dVar.d(j) != j) {
                        break;
                    }
                }
            }
            i = -1;
            if (i != -1) {
                byte[] bArr = (byte[]) xn1.d(i, byte[].class);
                try {
                    i2 = e(dVar, bArr, i);
                } finally {
                    xn1.c(bArr, byte[].class);
                }
            }
        }
        return i2;
    }

    public final cm1.a d(c cVar) throws IOException {
        int e = cVar.e();
        if (e == 65496) {
            return cm1.a.JPEG;
        }
        int e2 = ((e << 16) & -65536) | (cVar.e() & 65535);
        if (e2 == -1991225785) {
            cVar.d(21);
            return cVar.g() >= 3 ? cm1.a.PNG_A : cm1.a.PNG;
        } else if ((e2 >> 8) == 4671814) {
            return cm1.a.GIF;
        } else {
            if (e2 != 1380533830) {
                return cm1.a.UNKNOWN;
            }
            cVar.d(4);
            if ((((cVar.e() << 16) & -65536) | (cVar.e() & 65535)) != 1464156752) {
                return cm1.a.UNKNOWN;
            }
            int e3 = ((cVar.e() << 16) & -65536) | (cVar.e() & 65535);
            if ((e3 & -256) != 1448097792) {
                return cm1.a.UNKNOWN;
            }
            int i = e3 & Constants.MAX_HOST_LENGTH;
            if (i == 88) {
                cVar.d(4);
                return (cVar.g() & 16) != 0 ? cm1.a.WEBP_A : cm1.a.WEBP;
            } else if (i != 76) {
                return cm1.a.WEBP;
            } else {
                cVar.d(4);
                return (cVar.g() & 8) != 0 ? cm1.a.WEBP_A : cm1.a.WEBP;
            }
        }
    }

    public final int e(c cVar, byte[] bArr, int i) throws IOException {
        ByteOrder byteOrder;
        short a2;
        int b2;
        int i2;
        int i3;
        if (cVar.f(bArr, i) != i) {
            return -1;
        }
        boolean z = bArr != null && i > f1555a.length;
        if (z) {
            int i4 = 0;
            while (true) {
                byte[] bArr2 = f1555a;
                if (i4 >= bArr2.length) {
                    break;
                } else if (bArr[i4] != bArr2[i4]) {
                    z = false;
                    break;
                } else {
                    i4++;
                }
            }
        }
        if (!z) {
            return -1;
        }
        b bVar = new b(bArr, i);
        short a3 = bVar.a(6);
        if (a3 == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (a3 == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        bVar.f1557a.order(byteOrder);
        int b3 = bVar.b(10) + 6;
        short a4 = bVar.a(b3);
        for (int i5 = 0; i5 < a4; i5++) {
            int i6 = (i5 * 12) + b3 + 2;
            if (bVar.a(i6) == 274 && (a2 = bVar.a(i6 + 2)) >= 1 && a2 <= 12 && (b2 = bVar.b(i6 + 4)) >= 0 && (i2 = b2 + b[a2]) <= 4 && (i3 = i6 + 8) >= 0 && i3 <= bVar.f1557a.remaining() && i2 >= 0 && i2 + i3 <= bVar.f1557a.remaining()) {
                return bVar.a(i3);
            }
        }
        return -1;
    }
}
