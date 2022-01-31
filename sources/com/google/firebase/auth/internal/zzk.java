package com.google.firebase.auth.internal;

import android.content.Context;
import android.util.Base64;
import com.rabbitmq.client.StringRpcServer;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class zzk {
    private static zzk zzc;
    private final String zza;
    private wq2 zzb;

    private zzk(Context context, String str, boolean z) {
        this.zza = str;
        try {
            oq2.a();
            vq2 vq2 = new vq2();
            vq2.a(context, "GenericIdpKeyset", String.format("com.google.firebase.auth.api.crypto.%s", str));
            vq2.b(tq2.b);
            String format = String.format("android-keystore://firebear_master_key_id.%s", str);
            if (format.startsWith("android-keystore://")) {
                vq2.b = format;
                this.zzb = vq2.c();
                return;
            }
            throw new IllegalArgumentException("key URI must start with android-keystore://");
        } catch (IOException | GeneralSecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                "Exception encountered during crypto setup:\n".concat(valueOf);
            } else {
                new String("Exception encountered during crypto setup:\n");
            }
        }
    }

    public static zzk zza(Context context, String str) {
        String str2;
        zzk zzk = zzc;
        if (zzk == null || ((str2 = zzk.zza) != str && (str2 == null || !str2.equals(str)))) {
            zzc = new zzk(context, str, true);
        }
        return zzc;
    }

    public final String zzb() {
        go2 b;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        wn2 wn2 = new wn2(byteArrayOutputStream);
        try {
            wq2 wq2 = this.zzb;
            synchronized (wq2) {
                b = wq2.b.b();
            }
            b.d().c(wn2);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 8);
        } catch (IOException | GeneralSecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                "Exception encountered when attempting to get Public Key:\n".concat(valueOf);
                return null;
            }
            new String("Exception encountered when attempting to get Public Key:\n");
            return null;
        }
    }

    public final String zzc(String str) {
        go2 b;
        try {
            wq2 wq2 = this.zzb;
            synchronized (wq2) {
                b = wq2.b.b();
            }
            return new String(((yn2) b.e(yn2.class)).a(Base64.decode(str, 8), null), StringRpcServer.STRING_ENCODING);
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            String valueOf = String.valueOf(e.getMessage());
            if (valueOf.length() != 0) {
                "Exception encountered while decrypting bytes:\n".concat(valueOf);
            } else {
                new String("Exception encountered while decrypting bytes:\n");
            }
            return null;
        }
    }
}
