package defpackage;

import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: oq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class oq2 {
    static {
        new mq2();
        new kq2();
        dw2.s();
        dw2.s();
        dw2.s();
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() throws GeneralSecurityException {
        Class<?> zze;
        zo2.a();
        kq2 kq2 = new kq2();
        mq2 mq2 = new mq2();
        synchronized (xo2.class) {
            xo2.h("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", kq2.getClass(), true);
            xo2.h("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", mq2.getClass(), false);
            ConcurrentMap<String, wo2> concurrentMap = xo2.b;
            if (concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") && (zze = concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zze()) != null) {
                if (!zze.equals(mq2.getClass())) {
                    Logger logger = xo2.f3947a;
                    Level level = Level.WARNING;
                    StringBuilder sb = new StringBuilder(219);
                    sb.append("Attempted overwrite of a registered key manager for key type ");
                    sb.append("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
                    sb.append(" with inconsistent public key type ");
                    sb.append("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
                    logger.logp(level, "com.google.crypto.tink.Registry", "registerAsymmetricKeyManagers", sb.toString());
                    throw new GeneralSecurityException(String.format("public key manager corresponding to %s is already registered with %s, cannot be re-registered with %s", kq2.getClass().getName(), zze.getName(), mq2.getClass().getName()));
                }
            }
            if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey") || concurrentMap.get("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey").zze() == null) {
                concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new uo2(kq2, mq2));
                xo2.c.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", new vo2(kq2));
            }
            ConcurrentMap<String, Boolean> concurrentMap2 = xo2.d;
            concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", Boolean.TRUE);
            if (!concurrentMap.containsKey("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey")) {
                concurrentMap.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", new to2(mq2));
            }
            concurrentMap2.put("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", Boolean.FALSE);
        }
        xo2.b(new qq2());
        xo2.b(new sq2());
    }
}
