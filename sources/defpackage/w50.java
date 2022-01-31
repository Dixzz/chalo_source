package defpackage;

import defpackage.n00;
import defpackage.yj1;
import org.json.JSONObject;

/* renamed from: w50  reason: default package */
/* compiled from: UrlPollFeature */
public class w50 implements Runnable {
    public final /* synthetic */ ji1 f;
    public final /* synthetic */ String g;
    public final /* synthetic */ x50 h;

    /* renamed from: w50$a */
    /* compiled from: UrlPollFeature */
    public class a implements n00.z0 {
        public a() {
        }

        @Override // defpackage.n00.z0
        public void a(dk1 dk1) {
            w50.this.f.a(dk1.toString());
        }
    }

    /* renamed from: w50$b */
    /* compiled from: UrlPollFeature */
    public class b implements yj1.b<JSONObject> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.yj1.b
        public void a(JSONObject jSONObject) {
            w50.this.f.onSuccess(jSONObject);
        }
    }

    public w50(x50 x50, ji1 ji1, String str) {
        this.h = x50;
        this.f = ji1;
        this.g = str;
    }

    public void run() {
        a aVar = new a();
        d70 d70 = new d70(this.g, null, new b(), aVar);
        d70.n = false;
        this.h.c.a(d70);
    }
}
