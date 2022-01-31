package defpackage;

import android.text.TextUtils;
import com.razorpay.AnalyticsConstants;
import java.util.HashMap;

/* renamed from: pb3  reason: default package */
public final class pb3 extends iz1<pb3> {

    /* renamed from: a  reason: collision with root package name */
    public String f2791a;
    public String b;
    public String c;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(pb3 pb3) {
        pb3 pb32 = pb3;
        if (!TextUtils.isEmpty(this.f2791a)) {
            pb32.f2791a = this.f2791a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            pb32.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            pb32.c = this.c;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put(AnalyticsConstants.NETWORK, this.f2791a);
        hashMap.put("action", this.b);
        hashMap.put("target", this.c);
        return iz1.a(hashMap);
    }
}
