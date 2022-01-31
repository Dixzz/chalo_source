package defpackage;

import defpackage.fi6;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.regex.Pattern;

/* renamed from: mi6  reason: default package */
/* compiled from: RequestBody.kt */
public abstract class mi6 {
    public static final a Companion = new a(null);

    /* renamed from: mi6$a */
    /* compiled from: RequestBody.kt */
    public static final class a {

        /* renamed from: mi6$a$a  reason: collision with other inner class name */
        /* compiled from: RequestBody.kt */
        public static final class C0045a extends mi6 {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ byte[] f2385a;
            public final /* synthetic */ fi6 b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;

            public C0045a(byte[] bArr, fi6 fi6, int i, int i2) {
                this.f2385a = bArr;
                this.b = fi6;
                this.c = i;
                this.d = i2;
            }

            @Override // defpackage.mi6
            public long contentLength() {
                return (long) this.c;
            }

            @Override // defpackage.mi6
            public fi6 contentType() {
                return this.b;
            }

            @Override // defpackage.mi6
            public void writeTo(xm6 xm6) {
                n86.f(xm6, "sink");
                xm6.r0(this.f2385a, this.d, this.c);
            }
        }

        public a(j86 j86) {
        }

        public static mi6 c(a aVar, fi6 fi6, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            Objects.requireNonNull(aVar);
            n86.f(bArr, "content");
            return aVar.b(bArr, fi6, i, i2);
        }

        public static /* synthetic */ mi6 d(a aVar, byte[] bArr, fi6 fi6, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                fi6 = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return aVar.b(bArr, fi6, i, i2);
        }

        public final mi6 a(String str, fi6 fi6) {
            n86.f(str, "$this$toRequestBody");
            Charset charset = aa6.f144a;
            if (fi6 != null) {
                Pattern pattern = fi6.d;
                Charset a2 = fi6.a(null);
                if (a2 == null) {
                    fi6.a aVar = fi6.f;
                    fi6 = fi6.a.b(fi6 + "; charset=utf-8");
                } else {
                    charset = a2;
                }
            }
            byte[] bytes = str.getBytes(charset);
            n86.b(bytes, "(this as java.lang.String).getBytes(charset)");
            return b(bytes, fi6, 0, bytes.length);
        }

        public final mi6 b(byte[] bArr, fi6 fi6, int i, int i2) {
            n86.f(bArr, "$this$toRequestBody");
            vi6.b((long) bArr.length, (long) i, (long) i2);
            return new C0045a(bArr, fi6, i2, i);
        }
    }

    public static final mi6 create(fi6 fi6, byte[] bArr) {
        return a.c(Companion, fi6, bArr, 0, 0, 12);
    }

    public static final mi6 create(fi6 fi6, byte[] bArr, int i) {
        return a.c(Companion, fi6, bArr, i, 0, 8);
    }

    public static final mi6 create(File file, fi6 fi6) {
        Objects.requireNonNull(Companion);
        n86.f(file, "$this$asRequestBody");
        return new ki6(file, fi6);
    }

    public static final mi6 create(String str, fi6 fi6) {
        return Companion.a(str, fi6);
    }

    public static final mi6 create(byte[] bArr) {
        return a.d(Companion, bArr, null, 0, 0, 7);
    }

    public static final mi6 create(byte[] bArr, fi6 fi6) {
        return a.d(Companion, bArr, fi6, 0, 0, 6);
    }

    public static final mi6 create(byte[] bArr, fi6 fi6, int i) {
        return a.d(Companion, bArr, fi6, i, 0, 4);
    }

    public static final mi6 create(byte[] bArr, fi6 fi6, int i, int i2) {
        return Companion.b(bArr, fi6, i, i2);
    }

    public long contentLength() throws IOException {
        return -1;
    }

    public abstract fi6 contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(xm6 xm6) throws IOException;

    public static final mi6 create(fi6 fi6, File file) {
        Objects.requireNonNull(Companion);
        n86.f(file, "file");
        n86.f(file, "$this$asRequestBody");
        return new ki6(file, fi6);
    }

    public static final mi6 create(fi6 fi6, String str) {
        a aVar = Companion;
        Objects.requireNonNull(aVar);
        n86.f(str, "content");
        return aVar.a(str, fi6);
    }

    public static final mi6 create(fi6 fi6, zm6 zm6) {
        Objects.requireNonNull(Companion);
        n86.f(zm6, "content");
        n86.f(zm6, "$this$toRequestBody");
        return new li6(zm6, fi6);
    }

    public static final mi6 create(fi6 fi6, byte[] bArr, int i, int i2) {
        a aVar = Companion;
        Objects.requireNonNull(aVar);
        n86.f(bArr, "content");
        return aVar.b(bArr, fi6, i, i2);
    }

    public static final mi6 create(zm6 zm6, fi6 fi6) {
        Objects.requireNonNull(Companion);
        n86.f(zm6, "$this$toRequestBody");
        return new li6(zm6, fi6);
    }
}
