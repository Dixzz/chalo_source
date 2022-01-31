package defpackage;

import defpackage.ex2;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* renamed from: yw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class yw2<T_WRAPPER extends ex2<T_ENGINE>, T_ENGINE> {
    public static final Logger c = Logger.getLogger(yw2.class.getName());
    public static final List<Provider> d;
    public static final yw2<zw2, Cipher> e = new yw2<>(new zw2());
    public static final yw2<dx2, Mac> f = new yw2<>(new dx2());
    public static final yw2<ax2, KeyAgreement> g = new yw2<>(new ax2());
    public static final yw2<cx2, KeyPairGenerator> h = new yw2<>(new cx2());
    public static final yw2<bx2, KeyFactory> i = new yw2<>(new bx2());

    /* renamed from: a  reason: collision with root package name */
    public final T_WRAPPER f4092a;
    public final List<Provider> b = d;

    static {
        if (gj1.m1()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                String str = strArr[i2];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    c.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            d = arrayList;
        } else {
            d = new ArrayList();
        }
    }

    public yw2(T_WRAPPER t_wrapper) {
        this.f4092a = t_wrapper;
    }

    public final T_ENGINE a(String str) throws GeneralSecurityException {
        for (Provider provider : this.b) {
            try {
                return (T_ENGINE) this.f4092a.a(str, provider);
            } catch (Exception unused) {
            }
        }
        return (T_ENGINE) this.f4092a.a(str, null);
    }
}
