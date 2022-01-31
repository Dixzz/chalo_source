package defpackage;

import android.content.Context;
import defpackage.n00;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: b50  reason: default package */
/* compiled from: ScheduleFeature */
public class b50 implements yj1.b<JSONObject> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f380a;
    public final /* synthetic */ long b;
    public final /* synthetic */ n00.z0 c;
    public final /* synthetic */ w40 d;

    public b50(w40 w40, String str, long j, n00.z0 z0Var) {
        this.d = w40;
        this.f380a = str;
        this.b = j;
        this.c = z0Var;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(JSONObject jSONObject) {
        try {
            jz5.b().i(new wv().a(jSONObject));
            Context context = this.d.c;
        } catch (JSONException e) {
            Context context2 = this.d.c;
            this.c.a(new dk1(e.getMessage()));
        }
    }
}
