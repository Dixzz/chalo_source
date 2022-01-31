package defpackage;

import java.security.SecureRandom;

/* renamed from: kx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class kx2 extends ThreadLocal<SecureRandom> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.lang.ThreadLocal
    public final /* bridge */ /* synthetic */ SecureRandom initialValue() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }
}
