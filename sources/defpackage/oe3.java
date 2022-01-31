package defpackage;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashMap;

/* renamed from: oe3  reason: default package */
public final class oe3 extends iz1<oe3> {

    /* renamed from: a  reason: collision with root package name */
    public String f2681a;
    public String b;
    public String c;
    public String d;

    /* renamed from: d */
    public final void c(oe3 oe3) {
        if (!TextUtils.isEmpty(this.f2681a)) {
            oe3.f2681a = this.f2681a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            oe3.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            oe3.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            oe3.d = this.d;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("appName", this.f2681a);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_VERSION, this.b);
        hashMap.put(RemoteConfigConstants.RequestFieldKey.APP_ID, this.c);
        hashMap.put("appInstallerId", this.d);
        return iz1.a(hashMap);
    }
}
