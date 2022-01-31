package defpackage;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* renamed from: jw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class jw2 extends ThreadLocal<Cipher> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.lang.ThreadLocal
    public final Cipher initialValue() {
        try {
            return yw2.e.a("AES/CTR/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }
}
