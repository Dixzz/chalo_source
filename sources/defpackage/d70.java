package defpackage;

import android.text.TextUtils;
import app.zophop.ui.activities.HomeActivity;
import defpackage.n00;
import defpackage.xt;
import defpackage.yj1;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d70  reason: default package */
/* compiled from: UserProfileGZipJsonObjectRequest */
public class d70 extends ge1<JSONObject> {

    /* renamed from: d70$a */
    /* compiled from: UserProfileGZipJsonObjectRequest */
    public class a implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f800a;
        public final /* synthetic */ n00.z0 b;

        public a(String str, n00.z0 z0Var) {
            this.f800a = str;
            this.b = z0Var;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (!TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f800a, ed1);
            }
            this.b.a(dk1);
        }
    }

    /* renamed from: d70$b */
    /* compiled from: UserProfileGZipJsonObjectRequest */
    public class b implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f801a;
        public final /* synthetic */ n00.z0 b;

        public b(String str, n00.z0 z0Var) {
            this.f801a = str;
            this.b = z0Var;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (!TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f801a, ed1);
            }
            n00.z0 z0Var = this.b;
            if (z0Var != null) {
                z0Var.a(dk1);
            }
        }
    }

    /* renamed from: d70$c */
    /* compiled from: UserProfileGZipJsonObjectRequest */
    public class c implements yj1.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f802a;
        public final /* synthetic */ n00.y0 b;

        public c(String str, n00.y0 y0Var) {
            this.f802a = str;
            this.b = y0Var;
        }

        @Override // defpackage.yj1.a
        public void a(dk1 dk1) {
            if (!TextUtils.isEmpty(dk1.getMessage()) && dk1.getMessage().contains("ssl")) {
                ed1 ed1 = new ed1("ssl error with url", Long.MIN_VALUE);
                hj1.K0(ed1, "uri", this.f802a, ed1);
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
            t1Var2.c().v(this.f802a);
            xt.z0 = 0;
            String str2 = HomeActivity.l;
            dk1.getLocalizedMessage();
            this.b.a(str);
        }
    }

    public d70(String str, String str2, yj1.b<JSONObject> bVar, n00.z0 z0Var) {
        super(0, str, str2, bVar, new a(str, z0Var));
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.ge1
    public JSONObject D(String str) throws Exception {
        return new JSONObject(str);
    }

    public d70(String str, String str2, yj1.b<JSONObject> bVar, n00.z0 z0Var, boolean z) {
        super(1, str, str2, bVar, new b(str, z0Var));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public d70(android.content.Context r8, java.lang.String r9, java.lang.String r10, defpackage.yj1.b<org.json.JSONObject> r11, defpackage.n00.y0 r12) {
        /*
            r7 = this;
            d70$c r5 = new d70$c
            r5.<init>(r9, r12)
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.lang.String r10 = "accessToken"
            r12 = 0
            android.content.SharedPreferences r8 = r8.getSharedPreferences(r10, r12)
            r8.edit()
            xt$t1 r12 = defpackage.xt.f3961a
            t20 r0 = r12.L()
            java.lang.String r0 = r0.getUserId()
            java.lang.String r1 = "userId"
            r6.put(r1, r0)
            java.lang.String r0 = "authType"
            java.lang.String r1 = "ACCESS_TOKEN"
            r6.put(r0, r1)
            zc1 r12 = r12.n()
            java.lang.String r12 = r12.a()
            java.lang.String r0 = "deviceId"
            r6.put(r0, r12)
            r12 = 0
            java.lang.String r8 = r8.getString(r10, r12)
            r6.put(r10, r8)
            r1 = 0
            r3 = 0
            r0 = r7
            r2 = r9
            r4 = r11
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d70.<init>(android.content.Context, java.lang.String, java.lang.String, yj1$b, n00$y0):void");
    }
}
