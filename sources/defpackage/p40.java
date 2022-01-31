package defpackage;

import org.json.JSONObject;

/* renamed from: p40  reason: default package */
/* compiled from: RouteFeature */
public class p40 implements ji1<JSONObject, String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2766a;
    public final /* synthetic */ v40 b;

    public p40(v40 v40, String str) {
        this.b = v40;
        this.f2766a = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void a(String str) {
        this.b.r(this.f2766a, null, ad1.FAILED);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.ji1
    public void onSuccess(JSONObject jSONObject) {
        v40.b(this.b, this.f2766a, jSONObject);
    }
}
