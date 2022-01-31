package defpackage;

import java.security.SecureRandom;

/* renamed from: lx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class lx2 {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<SecureRandom> f2289a = new kx2();

    public static byte[] a(int i) {
        byte[] bArr = new byte[i];
        f2289a.get().nextBytes(bArr);
        return bArr;
    }
}
