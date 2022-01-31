package defpackage;

import android.net.Uri;
import android.os.SystemClock;
import defpackage.wj1;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: e00  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class e00 implements Runnable {
    public final /* synthetic */ e10 f;
    public final /* synthetic */ int g;

    public /* synthetic */ e00(e10 e10, int i) {
        this.f = e10;
        this.g = i;
    }

    public final void run() {
        e10 e10 = this.f;
        int i = this.g;
        n86.e(e10, "this$0");
        e10.k = true;
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.m).appendEncodedPath(e10.i);
        String builder2 = builder.toString();
        n86.d(builder2, "builder.toString()");
        xj1 S = xt.f3961a.S();
        JSONObject jSONObject = new JSONObject();
        HashMap hashMap = new HashMap();
        hashMap.put("retry count ", String.valueOf(i));
        ed1 ed1 = new ed1("chaloTime request sent", Long.MIN_VALUE);
        for (Map.Entry entry : hashMap.entrySet()) {
            ed1.a((String) entry.getKey(), (String) entry.getValue());
        }
        ed1.a("is foreground", Boolean.valueOf(xt.f3961a.v().f));
        jz5.b().g(ed1);
        new String();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        e70 e70 = new e70(0, builder2, new f10(e10, elapsedRealtime, i), new f00(e10, i), jSONObject.toString());
        e70.q = new nj1(e10.f, 0, 0.0f);
        e70.n = false;
        e70.z = wj1.c.IMMEDIATE;
        S.a(e70);
    }
}
