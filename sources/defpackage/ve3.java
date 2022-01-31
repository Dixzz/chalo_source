package defpackage;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;

/* renamed from: ve3  reason: default package */
public final class ve3 extends iz1<ve3> {

    /* renamed from: a  reason: collision with root package name */
    public String f3641a;
    public String b;
    public String c;
    public long d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(ve3 ve3) {
        ve3 ve32 = ve3;
        if (!TextUtils.isEmpty(this.f3641a)) {
            ve32.f3641a = this.f3641a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            ve32.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            ve32.c = this.c;
        }
        long j = this.d;
        if (j != 0) {
            ve32.d = j;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("category", this.f3641a);
        hashMap.put("action", this.b);
        hashMap.put(Constants.ScionAnalytics.PARAM_LABEL, this.c);
        hashMap.put(FirebaseAnalytics.Param.VALUE, Long.valueOf(this.d));
        return iz1.a(hashMap);
    }
}
