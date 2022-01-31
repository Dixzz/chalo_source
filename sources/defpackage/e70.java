package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import defpackage.n00;
import defpackage.wj1;
import defpackage.xt;
import defpackage.yj1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: e70  reason: default package */
/* compiled from: VolleyJsonRequest */
public class e70 extends ok1 {
    public final String w;
    public final String x;
    public JSONObject y;
    public wj1.c z;

    /* renamed from: e70$a */
    /* compiled from: VolleyJsonRequest */
    public class a implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f932a;
        public final /* synthetic */ yj1.a b;

        public a(String str, yj1.a aVar) {
            this.f932a = str;
            this.b = aVar;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (!TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f932a, ed1);
            }
            this.b.a(dk1);
        }
    }

    /* renamed from: e70$b */
    /* compiled from: VolleyJsonRequest */
    public class b implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f933a;
        public final /* synthetic */ yj1.a b;

        public b(String str, yj1.a aVar) {
            this.f933a = str;
            this.b = aVar;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (!TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f933a, ed1);
            }
            this.b.a(dk1);
        }
    }

    /* renamed from: e70$c */
    /* compiled from: VolleyJsonRequest */
    public class c implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f934a;
        public final /* synthetic */ yj1.a b;

        public c(String str, yj1.a aVar) {
            this.f934a = str;
            this.b = aVar;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (!TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f934a, ed1);
            }
            this.b.a(dk1);
        }
    }

    /* renamed from: e70$d */
    /* compiled from: VolleyJsonRequest */
    public class d implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f935a;
        public final /* synthetic */ yj1.a b;

        public d(String str, yj1.a aVar) {
            this.f935a = str;
            this.b = aVar;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (!TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f935a, ed1);
            }
            this.b.a(dk1);
        }
    }

    /* renamed from: e70$e */
    /* compiled from: VolleyJsonRequest */
    public class e implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f936a;
        public final /* synthetic */ n00.y0 b;

        public e(String str, n00.y0 y0Var) {
            this.f936a = str;
            this.b = y0Var;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (dk1 != null && !TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f936a, ed1);
            }
            tj1 tj1 = dk1.f;
            String str = "something went wrong";
            if (!(tj1 == null || tj1.b == null)) {
                try {
                    JSONObject jSONObject = new JSONObject(new dk1(new String(dk1.f.b)).getLocalizedMessage());
                    if (jSONObject.has("errorType") && !jSONObject.getString("errorType").equals("UNKNOWN")) {
                        str = jSONObject.optString("errorMessage", str);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            tj1 tj12 = dk1.f;
            if (tj12 == null || tj12.f3365a != 401) {
                xt.t1 t1Var = xt.f3961a;
                xt.z0 = 0;
                this.b.a(str);
                return;
            }
            xt.t1 t1Var2 = xt.f3961a;
            if (xt.z0 < 4) {
                this.b.execute();
                t1Var2.o0();
                return;
            }
            xt.z0 = 0;
            t1Var2.c().v(this.f936a);
            this.b.a(str);
        }
    }

    public e70(int i, String str, yj1.b<String> bVar, yj1.a aVar, String str2) {
        super(i, str, bVar, new a(str, aVar));
        this.w = str2;
        this.x = "application/json";
    }

    @Override // defpackage.wj1
    public byte[] j() {
        return this.w.getBytes();
    }

    @Override // defpackage.wj1
    public Map<String, String> m() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", this.x);
        JSONObject jSONObject = this.y;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String str = null;
                try {
                    str = this.y.getString(next);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                hashMap.put(next, str);
            }
        }
        return hashMap;
    }

    @Override // defpackage.wj1
    public wj1.c q() {
        wj1.c cVar = this.z;
        if (cVar != null) {
            return cVar;
        }
        return wj1.c.NORMAL;
    }

    public e70(int i, String str, yj1.b<String> bVar, yj1.a aVar, String str2, int i2) {
        super(i, str, bVar, new b(str, aVar));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mode", i2);
            jSONObject.put("deviceId", xt.f3961a.n().a());
        } catch (JSONException e2) {
            b00 b00 = b00.f358a;
            b00.a().b(e2);
        }
        this.y = jSONObject;
        this.w = str2;
        this.x = "application/json";
    }

    public e70(String str, yj1.b<String> bVar, yj1.a aVar, String str2) {
        super(1, str, bVar, new c(str, aVar));
        this.w = str2;
        this.x = "application/json";
    }

    public e70(int i, String str, JSONObject jSONObject, yj1.b<String> bVar, yj1.a aVar, String str2) {
        super(i, str, bVar, new d(str, aVar));
        this.w = str2;
        this.y = jSONObject;
        this.x = "application/json";
    }

    public e70(Context context, boolean z2, int i, String str, yj1.b<String> bVar, n00.y0 y0Var, String str2) {
        super(i, str, bVar, new e(str, y0Var));
        this.w = str2;
        if (z2) {
            this.y = ui1.a(context);
        } else {
            JSONObject jSONObject = new JSONObject();
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("accessToken", 0);
                sharedPreferences.edit();
                xt.t1 t1Var = xt.f3961a;
                jSONObject.put("userId", t1Var.L().getUserId());
                jSONObject.put("authType", "ACCESS_TOKEN");
                jSONObject.put("deviceId", t1Var.n().a());
                jSONObject.put("accessToken", sharedPreferences.getString("accessToken", null));
                jSONObject.put("source", 0);
            } catch (JSONException e2) {
                b00 b00 = b00.f358a;
                b00.a().b(e2);
            }
            this.y = jSONObject;
        }
        this.x = "application/json";
    }
}
