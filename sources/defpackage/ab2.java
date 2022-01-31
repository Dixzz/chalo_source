package defpackage;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: ab2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class ab2 {
    @RecentlyNullable
    @Deprecated
    public static byte[] a(@RecentlyNonNull Context context, @RecentlyNonNull String str) throws PackageManager.NameNotFoundException {
        MessageDigest b;
        PackageInfo packageInfo = ob2.a(context).f2531a.getPackageManager().getPackageInfo(str, 64);
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (b = b("SHA1")) == null) {
            return null;
        }
        return b.digest(packageInfo.signatures[0].toByteArray());
    }

    @RecentlyNullable
    public static MessageDigest b(@RecentlyNonNull String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }
}
