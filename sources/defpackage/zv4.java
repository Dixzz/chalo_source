package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.Build;
import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* renamed from: zv4  reason: default package */
public final class zv4 {

    /* renamed from: a  reason: collision with root package name */
    public static final nv4 f4219a = new nv4("PhoneskyVerificationUtils");

    public static boolean a(Context context) {
        String str;
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo("com.android.vending", 64).signatures;
            if (signatureArr == null || (r1 = signatureArr.length) == 0) {
                f4219a.b(5, "Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
                return false;
            }
            for (Signature signature : signatureArr) {
                byte[] byteArray = signature.toByteArray();
                try {
                    MessageDigest instance = MessageDigest.getInstance("SHA-256");
                    instance.update(byteArray);
                    str = Base64.encodeToString(instance.digest(), 11);
                } catch (NoSuchAlgorithmException unused) {
                    str = "";
                }
                if ("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(str)) {
                    return true;
                }
                if ((Build.TAGS.contains("dev-keys") || Build.TAGS.contains("test-keys")) && "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }

    public static boolean b(Context context) {
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        return packagesForUid != null && Arrays.asList(packagesForUid).contains("com.android.vending");
    }
}
