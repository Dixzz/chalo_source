package defpackage;

import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d40  reason: default package */
/* compiled from: RealTimeFeature */
public class d40 implements yj1.b<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ji1 f782a;

    public d40(z30 z30, ji1 ji1) {
        this.f782a = ji1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(String str) {
        try {
            j10 i = ii1.i(new JSONObject(str));
            if (i.b().size() != 0) {
                this.f782a.onSuccess(i);
            } else if (i.a() == Integer.MAX_VALUE) {
                this.f782a.a("no_etas");
            } else if (i.a() >= 7200) {
                this.f782a.a("all_max_etas");
            } else {
                this.f782a.onSuccess(i);
            }
        } catch (JSONException e) {
            this.f782a.a(e.toString());
        }
    }
}
