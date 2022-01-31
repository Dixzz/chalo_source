package defpackage;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Cipher;

/* renamed from: zw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zw2 implements ex2<Cipher> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ex2
    public final /* bridge */ /* synthetic */ Cipher a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Cipher.getInstance(str) : Cipher.getInstance(str, provider);
    }
}
