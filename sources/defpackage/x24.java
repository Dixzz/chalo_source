package defpackage;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Objects;

/* renamed from: x24  reason: default package */
public final class x24 extends w24 {
    public final /* synthetic */ byte[] r;
    public final /* synthetic */ String s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public x24(a32 a32, byte[] bArr, String str) {
        super(a32);
        this.r = bArr;
        this.s = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [x22$b] */
    @Override // defpackage.l32
    public final void l(z24 z24) throws RemoteException {
        z24 z242 = z24;
        r24 r24 = this.q;
        byte[] bArr = this.r;
        String str = this.s;
        if (TextUtils.isEmpty(str)) {
            Objects.requireNonNull(z242);
            try {
                PackageManager packageManager = z242.f4111a.getPackageManager();
                if (packageManager != null) {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(z242.f4111a.getPackageName(), 128);
                    if (applicationInfo != null) {
                        Bundle bundle = applicationInfo.metaData;
                        if (bundle != null) {
                            str = (String) bundle.get("com.google.android.safetynet.ATTEST_API_KEY");
                        }
                    }
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            str = null;
        }
        ((t24) z242.getService()).C0(r24, bArr, str);
    }
}
