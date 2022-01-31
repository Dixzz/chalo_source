package defpackage;

import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.Provider;

/* renamed from: cx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class cx2 implements ex2<KeyPairGenerator> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ex2
    public final /* bridge */ /* synthetic */ KeyPairGenerator a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyPairGenerator.getInstance(str) : KeyPairGenerator.getInstance(str, provider);
    }
}
