package defpackage;

import android.os.Build;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

/* renamed from: yq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class yq2 {

    /* renamed from: a  reason: collision with root package name */
    public KeyStore f4081a = null;

    public yq2() {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                KeyStore instance = KeyStore.getInstance("AndroidKeyStore");
                this.f4081a = instance;
                instance.load(null);
            } catch (IOException | GeneralSecurityException e) {
                throw new IllegalStateException(e);
            }
        } else {
            throw new IllegalStateException("need Android Keystore on Android M or newer");
        }
    }
}
