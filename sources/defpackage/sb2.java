package defpackage;

import java.security.MessageDigest;
import java.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: sb2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final /* synthetic */ class sb2 implements Callable {
    public final boolean f;
    public final String g;
    public final xb2 h;

    public sb2(boolean z, String str, xb2 xb2) {
        this.f = z;
        this.g = str;
        this.h = xb2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        boolean z = this.f;
        String str = this.g;
        xb2 xb2 = this.h;
        Object[] objArr = new Object[5];
        objArr[0] = true != (!z && bc2.b(str, xb2, true, false).f1238a) ? "not allowed" : "debug cert rejected";
        objArr[1] = str;
        MessageDigest b = ab2.b("SHA-1");
        Objects.requireNonNull(b, "null reference");
        byte[] digest = b.digest(xb2.F());
        int length = digest.length;
        char[] cArr = new char[(length + length)];
        int i = 0;
        for (byte b2 : digest) {
            int i2 = b2 & 255;
            int i3 = i + 1;
            char[] cArr2 = eb2.b;
            cArr[i] = cArr2[i2 >>> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        objArr[2] = new String(cArr);
        objArr[3] = Boolean.valueOf(z);
        objArr[4] = "12451000.false";
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", objArr);
    }
}
