package defpackage;

import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.Provider;

/* renamed from: bx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class bx2 implements ex2<KeyFactory> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ex2
    public final /* bridge */ /* synthetic */ KeyFactory a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
    }
}
