package defpackage;

import android.content.Context;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.ProviderException;
import javax.annotation.concurrent.GuardedBy;
import javax.crypto.KeyGenerator;

/* renamed from: vq2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class vq2 {

    /* renamed from: a  reason: collision with root package name */
    public io2 f3674a = null;
    public String b = null;
    public vn2 c = null;
    public co2 d = null;
    @GuardedBy("this")
    public ho2 e;
    public ar2 f = null;

    public final vq2 a(Context context, String str, String str2) throws IOException {
        if (context != null) {
            this.f = new ar2(context, str2);
            this.f3674a = new br2(context, str2);
            return this;
        }
        throw new IllegalArgumentException("need an Android context");
    }

    @Deprecated
    public final vq2 b(cv2 cv2) {
        bw2 bw2;
        String s = cv2.s();
        byte[] C = cv2.t().C();
        bw2 u = cv2.u();
        String str = wq2.c;
        bw2 bw22 = bw2.UNKNOWN_PREFIX;
        int ordinal = u.ordinal();
        int i = 4;
        if (ordinal == 1) {
            i = 1;
        } else if (ordinal == 2) {
            i = 2;
        } else if (ordinal == 3) {
            i = 3;
        } else if (ordinal != 4) {
            throw new IllegalArgumentException("Unknown output prefix type");
        }
        bv2 v = cv2.v();
        v.f(s);
        v.g(g93.A(C, 0, C.length));
        int i2 = i - 1;
        if (i2 != 0) {
            bw2 = i2 != 1 ? i2 != 2 ? bw2.CRUNCHY : bw2.RAW : bw2.LEGACY;
        } else {
            bw2 = bw2.TINK;
        }
        v.h(bw2);
        this.d = new co2((cv2) v.c());
        return this;
    }

    public final synchronized wq2 c() throws GeneralSecurityException, IOException {
        ho2 ho2;
        if (this.b != null) {
            this.c = d();
        }
        try {
            ho2 = e();
        } catch (FileNotFoundException unused) {
            String str = wq2.c;
            if (this.d != null) {
                ho2 = new ho2(kv2.x());
                ho2.c(this.d);
                ho2.d(yo2.a(ho2.b().f1289a).s().s());
                if (this.c != null) {
                    ho2.b().b(this.f3674a, this.c);
                } else {
                    this.f3674a.a(ho2.b().f1289a);
                }
            } else {
                throw new GeneralSecurityException("cannot read or generate keyset");
            }
        }
        this.e = ho2;
        return new wq2(this);
    }

    public final vn2 d() throws GeneralSecurityException {
        if (Build.VERSION.SDK_INT >= 23) {
            zq2 zq2 = new zq2();
            boolean a2 = zq2.a(this.b);
            if (!a2) {
                try {
                    String str = this.b;
                    if (!new zq2().a(str)) {
                        String c2 = mx2.c("android-keystore://", str);
                        KeyGenerator instance = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                        instance.init(new KeyGenParameterSpec.Builder(c2, 3).setKeySize(256).setBlockModes("GCM").setEncryptionPaddings("NoPadding").build());
                        instance.generateKey();
                    } else {
                        throw new IllegalArgumentException(String.format("cannot generate a new key %s because it already exists; please delete it with deleteKey() and try again", str));
                    }
                } catch (GeneralSecurityException | ProviderException unused) {
                    String str2 = wq2.c;
                    return null;
                }
            }
            try {
                return zq2.zzb(this.b);
            } catch (GeneralSecurityException | ProviderException e2) {
                if (!a2) {
                    String str3 = wq2.c;
                    return null;
                }
                throw new KeyStoreException(String.format("the master key %s exists but is unusable", this.b), e2);
            }
        } else {
            String str4 = wq2.c;
            return null;
        }
    }

    public final ho2 e() throws GeneralSecurityException, IOException {
        vn2 vn2 = this.c;
        if (vn2 != null) {
            try {
                return ho2.a(go2.f(this.f, vn2));
            } catch (GeneralSecurityException | ma3 unused) {
                String str = wq2.c;
            }
        }
        return ho2.a(go2.a(kv2.w(this.f.a(), s93.a())));
    }
}
