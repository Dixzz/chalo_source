package defpackage;

import android.text.TextUtils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;

/* renamed from: xe3  reason: default package */
public final class xe3 extends iz1<xe3> {

    /* renamed from: a  reason: collision with root package name */
    public String f3922a;
    public String b;
    public String c;
    public String d;
    public boolean e;
    public String f;
    public boolean g;
    public double h;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(xe3 xe3) {
        xe3 xe32 = xe3;
        if (!TextUtils.isEmpty(this.f3922a)) {
            xe32.f3922a = this.f3922a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            xe32.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            xe32.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            xe32.d = this.d;
        }
        boolean z = true;
        if (this.e) {
            xe32.e = true;
        }
        if (!TextUtils.isEmpty(this.f)) {
            xe32.f = this.f;
        }
        boolean z2 = this.g;
        if (z2) {
            xe32.g = z2;
        }
        double d2 = this.h;
        if (d2 != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            if (d2 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || d2 > 100.0d) {
                z = false;
            }
            gj1.c(z, "Sample rate must be between 0% and 100%");
            xe32.h = d2;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.f3922a);
        hashMap.put("clientId", this.b);
        hashMap.put("userId", this.c);
        hashMap.put("androidAdId", this.d);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.e));
        hashMap.put("sessionControl", this.f);
        hashMap.put("nonInteraction", Boolean.valueOf(this.g));
        hashMap.put("sampleRate", Double.valueOf(this.h));
        return iz1.a(hashMap);
    }
}
