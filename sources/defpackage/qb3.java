package defpackage;

import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import java.util.HashMap;

/* renamed from: qb3  reason: default package */
public final class qb3 extends iz1<qb3> {

    /* renamed from: a  reason: collision with root package name */
    public String f2924a;
    public long b;
    public String c;
    public String d;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(qb3 qb3) {
        qb3 qb32 = qb3;
        if (!TextUtils.isEmpty(this.f2924a)) {
            qb32.f2924a = this.f2924a;
        }
        long j = this.b;
        if (j != 0) {
            qb32.b = j;
        }
        if (!TextUtils.isEmpty(this.c)) {
            qb32.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            qb32.d = this.d;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("variableName", this.f2924a);
        hashMap.put("timeInMillis", Long.valueOf(this.b));
        hashMap.put("category", this.c);
        hashMap.put(Constants.ScionAnalytics.PARAM_LABEL, this.d);
        return iz1.a(hashMap);
    }
}
