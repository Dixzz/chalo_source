package defpackage;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.KeyAgreement;

/* renamed from: ax2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class ax2 implements ex2<KeyAgreement> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ex2
    public final /* bridge */ /* synthetic */ KeyAgreement a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? KeyAgreement.getInstance(str) : KeyAgreement.getInstance(str, provider);
    }
}
