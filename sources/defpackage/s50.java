package defpackage;

import android.content.Context;
import org.json.JSONObject;

/* renamed from: s50  reason: default package */
/* compiled from: UniversalSearchFeature */
public class s50 implements Runnable {
    public final /* synthetic */ JSONObject f;
    public final /* synthetic */ t50 g;

    public s50(t50 t50, JSONObject jSONObject) {
        this.g = t50;
        this.f = jSONObject;
    }

    public void run() {
        try {
            t50 t50 = this.g;
            q50.b(t50.e, this.f, t50.f3309a, t50.b, t50.c);
            t50 t502 = this.g;
            Context context = t502.e.f2897a;
            String str = t502.d;
            long j = t502.b;
        } catch (Exception e) {
            t50 t503 = this.g;
            Context context2 = t503.e.f2897a;
            String str2 = t503.d;
            long j2 = t503.b;
            vn.e("universal call json", true);
            b00 b00 = b00.f358a;
            b00.a().b(e);
            e.printStackTrace();
            t50 t504 = this.g;
            q50.a(t504.e, t504.f3309a, t504.b, e.getMessage(), this.g.c);
        }
    }
}
