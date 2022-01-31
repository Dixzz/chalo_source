package defpackage;

import android.os.SystemClock;
import defpackage.yj1;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: f10  reason: default package */
/* compiled from: ChaloTimeFeature.kt */
public final class f10 implements yj1.b<String> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ e10 f1057a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;

    public f10(e10 e10, long j, int i) {
        this.f1057a = e10;
        this.b = j;
        this.c = i;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.yj1.b
    public void a(String str) {
        String str2 = str;
        try {
            this.f1057a.k = false;
            if (str2 == null) {
                HashMap hashMap = new HashMap();
                Objects.requireNonNull(this.f1057a);
                hashMap.put("system time", String.valueOf(System.currentTimeMillis()));
                ed1 ed1 = new ed1("chaloTime null response", Long.MIN_VALUE);
                for (Map.Entry entry : hashMap.entrySet()) {
                    ed1.a((String) entry.getKey(), (String) entry.getValue());
                }
                ed1.a("is foreground", Boolean.valueOf(xt.f3961a.v().f));
                jz5.b().g(ed1);
                new String();
                return;
            }
            long j = new JSONObject(str2).getJSONObject("chaloTime").getLong("timeStamp");
            HashMap hashMap2 = new HashMap();
            hashMap2.put("chaloTime received", String.valueOf(j));
            Objects.requireNonNull(this.f1057a);
            hashMap2.put("difference", String.valueOf(j - System.currentTimeMillis()));
            Objects.requireNonNull(this.f1057a);
            hashMap2.put("reponse time", String.valueOf(SystemClock.elapsedRealtime() - this.b));
            ed1 ed12 = new ed1("chaloTime success response", Long.MIN_VALUE);
            for (Map.Entry entry2 : hashMap2.entrySet()) {
                ed12.a((String) entry2.getKey(), (String) entry2.getValue());
            }
            ed12.a("is foreground", Boolean.valueOf(xt.f3961a.v().f));
            jz5.b().g(ed12);
            new String();
            if (!e10.d(this.f1057a, j, this.b)) {
                this.f1057a.h(this.c + 1);
            } else {
                e10.e(this.f1057a, j, this.b);
            }
        } catch (JSONException e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
