package defpackage;

import defpackage.yj1;
import org.json.JSONObject;

/* renamed from: t50  reason: default package */
/* compiled from: UniversalSearchFeature */
public class t50 implements yj1.b<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f3309a;
    public final /* synthetic */ long b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ q50 e;

    public t50(q50 q50, String str, long j, String str2, String str3) {
        this.e = q50;
        this.f3309a = str;
        this.b = j;
        this.c = str2;
        this.d = str3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(JSONObject jSONObject) {
        this.e.e.post(new s50(this, jSONObject));
    }
}
