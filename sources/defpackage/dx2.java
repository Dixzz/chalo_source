package defpackage;

import java.security.GeneralSecurityException;
import java.security.Provider;
import javax.crypto.Mac;

/* renamed from: dx2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class dx2 implements ex2<Mac> {
    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ex2
    public final /* bridge */ /* synthetic */ Mac a(String str, Provider provider) throws GeneralSecurityException {
        return provider == null ? Mac.getInstance(str) : Mac.getInstance(str, provider);
    }
}
