package defpackage;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import app.zophop.models.CtaAction;
import app.zophop.models.NpsSurvey;
import app.zophop.models.NpsSurveyQuestion;
import app.zophop.ui.activities.WebViewActivity;
import defpackage.nc5;
import defpackage.qm0;
import defpackage.xt;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: q30  reason: default package */
/* compiled from: NpsSurveyFeature */
public class q30 {
    public static Context h;
    public static Handler i;
    public static String j;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, String> f2889a;
    public Map<String, NpsSurvey> b;
    public boolean c;
    public pv d = new pv();
    public String e;
    public long f;
    public FragmentManager g;

    /* renamed from: q30$a */
    /* compiled from: NpsSurveyFeature */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            q30.this.c(false);
        }
    }

    /* renamed from: q30$b */
    /* compiled from: NpsSurveyFeature */
    public class b implements om0 {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NpsSurveyQuestion f2890a;
        public final /* synthetic */ Map b;
        public final /* synthetic */ boolean c;

        public b(NpsSurveyQuestion npsSurveyQuestion, Map map, boolean z) {
            this.f2890a = npsSurveyQuestion;
            this.b = map;
            this.c = z;
        }

        @Override // defpackage.om0
        public void a() {
            q30.this.l(this.f2890a, false, this.b, true, this.c);
        }
    }

    /* renamed from: q30$c */
    /* compiled from: NpsSurveyFeature */
    public class c implements qm0.g {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f2891a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ Map c;

        public c(boolean z, boolean z2, Map map) {
            this.f2891a = z;
            this.b = z2;
            this.c = map;
        }

        public void a(CtaAction ctaAction, String str) {
            HashMap hashMap = new HashMap();
            hashMap.put("NPS question id", str);
            q30.a("NPS survey dismissed", hashMap);
            if (this.f2891a && q30.j != null) {
                xt.f3961a.o().a(q30.j, true);
            }
            q30.b(q30.this, ctaAction, this.c, this.b);
        }
    }

    public q30(Context context) {
        h = context;
        i = new Handler();
        this.f2889a = new sf1(context.getSharedPreferences("npsSurveyFeature", 0), "npsSurvey_properties");
        o();
        try {
            String str = this.f2889a.get("keyNpsSurvey");
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                boolean optBoolean = jSONObject.optBoolean("shouldSurvey", false);
                this.c = optBoolean;
                if (optBoolean) {
                    this.b = this.d.a(jSONObject.optJSONObject("npsSurveyMap"));
                }
            }
        } catch (JSONException unused) {
            i();
            j();
            g("NPS feature event", "NPS survey store parsing error");
        }
    }

    public static void a(String str, Map map) {
        o();
        ed1 ed1 = new ed1(str, Long.MIN_VALUE);
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                ed1.a((String) entry.getKey(), entry.getValue());
            }
        }
        jz5.b().g(ed1);
    }

    public static void b(q30 q30, CtaAction ctaAction, Map map, boolean z) {
        Objects.requireNonNull(q30);
        if (ctaAction == null || "DISMISS".equalsIgnoreCase(ctaAction.getCtaType())) {
            return;
        }
        if (ctaAction.getCtaType().equals("NEXT_QUESTION")) {
            NpsSurveyQuestion e2 = e(ctaAction.getCtaAction(), map);
            if (e2 != null) {
                q30.l(e2, false, map, false, z);
            }
        } else if ("PLAYSTORE_REVIEW".equalsIgnoreCase(ctaAction.getCtaType())) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + h.getPackageName()));
                intent.setPackage("com.android.vending");
                intent.addFlags(268435456);
                h.startActivity(intent);
            } catch (Exception e3) {
                e3.getMessage();
                b00 b00 = b00.f358a;
                b00.a().b(e3);
            }
        } else if ("WEB_LINK".equalsIgnoreCase(ctaAction.getCtaType())) {
            Intent i0 = WebViewActivity.i0(h, ctaAction.getCtaAction(), "NPS", false, false);
            i0.addFlags(268435456);
            h.startActivity(i0);
        } else {
            "DEEP_LINK".equalsIgnoreCase(ctaAction.getCtaType());
        }
    }

    public static NpsSurveyQuestion e(String str, Map<String, NpsSurveyQuestion> map) {
        if (str == null || map == null || !map.containsKey(str)) {
            return null;
        }
        return map.get(str);
    }

    public static void g(String str, String str2) {
        xt.t1 t1Var = xt.f3961a;
        t1Var.v();
        if (t1Var.v().f) {
            ed1 ed1 = new ed1(str, Long.MIN_VALUE);
            if (str2 != null) {
                ed1.a("NPS event description: ", str2);
            }
            jz5.b().g(ed1);
        }
    }

    public static void o() {
        xt.t1 t1Var = xt.f3961a;
        String optString = t1Var.l().h.optString("keyLastNpsRenderedTime", null);
        String optString2 = t1Var.l().h.optString("keyLastNpsSubmittedTime", null);
        String optString3 = t1Var.l().h.optString("keyLastNpsScoreSubmitted", null);
        HashMap hashMap = new HashMap();
        if (optString != null) {
            hashMap.put("NPS Last rendered", String.valueOf(Long.parseLong(optString)));
        }
        if (optString2 != null) {
            hashMap.put("NPS Last submitted", String.valueOf(Long.parseLong(optString2)));
        }
        if (optString3 != null) {
            hashMap.put("NPS Last Score submitted", optString3);
        }
        if (hashMap.size() > 0) {
            t1Var.C().e.a(t1Var.D());
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                String str2 = (String) entry.getValue();
                nc5.e eVar = t1Var.C().e;
                if (!nc5.this.m()) {
                    try {
                        eVar.g(new JSONObject().put(str, str2));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
    }

    public final boolean c(boolean z) {
        String str;
        NpsSurvey f2;
        Map<String, NpsSurveyQuestion> npsSurveyQuestionMap;
        NpsSurveyQuestion e2;
        if (this.g == null || (str = this.e) == null || j == null || this.f2889a == null || (f2 = f(str)) == null || (e2 = e(f2.getStartingQuestionId(), (npsSurveyQuestionMap = f2.getNpsSurveyQuestionMap()))) == null) {
            return false;
        }
        xt.f3961a.o().b(j, new rn0(10000, new b(e2, npsSurveyQuestionMap, z)));
        return true;
    }

    public boolean d(FragmentManager fragmentManager, String str, String str2) {
        if (!m(str)) {
            return false;
        }
        this.g = fragmentManager;
        this.e = str;
        j = str2;
        return c(true);
    }

    public final NpsSurvey f(String str) {
        Map<String, NpsSurvey> map = this.b;
        if (map == null || str == null || !map.containsKey(str)) {
            return null;
        }
        return this.b.get(str);
    }

    public void h(String str, FragmentManager fragmentManager, String str2) {
        this.e = str;
        this.g = fragmentManager;
        j = str2;
        NpsSurvey f2 = f(str);
        if (f2 != null) {
            this.f = f2.getIdleTimeout();
        } else {
            this.f = 100000000;
        }
        i.removeCallbacksAndMessages(null);
        if (m(str)) {
            k();
        }
    }

    public void i() {
        this.f2889a.remove("keyNpsCacheTTL");
    }

    public void j() {
        this.f2889a.remove("keyLastNpsCacheUpdateTime");
    }

    public void k() {
        i.removeCallbacksAndMessages(null);
        if (m(this.e)) {
            i.postDelayed(new a(), this.f);
        }
    }

    public final void l(NpsSurveyQuestion npsSurveyQuestion, boolean z, Map<String, NpsSurveyQuestion> map, boolean z2, boolean z3) {
        if (this.g != null && this.e != null && j != null) {
            if (!this.f2889a.containsKey("keyNpsSurveyRendered") || !z2 || !Boolean.parseBoolean(this.f2889a.get("keyNpsSurveyRendered"))) {
                FragmentManager fragmentManager = this.g;
                qm0 qm0 = new qm0(h, npsSurveyQuestion, new c(z2, z3, map), j);
                qm0.setCancelable(z);
                qm0.show(fragmentManager, qm0.H);
            }
        }
    }

    public final boolean m(String str) {
        Map<String, NpsSurvey> map;
        Map<String, String> map2 = this.f2889a;
        if (map2 == null || str == null || ((map2.containsKey("keyNpsSurveyRendered") && Boolean.parseBoolean(this.f2889a.get("keyNpsSurveyRendered"))) || !this.c || (map = this.b) == null || !map.containsKey(str))) {
            return false;
        }
        NpsSurvey npsSurvey = this.b.get(str);
        if (npsSurvey == null) {
            this.f = 100000000;
            return true;
        }
        this.f = npsSurvey.getIdleTimeout();
        return true;
    }

    public void n() {
        i.removeCallbacksAndMessages(null);
        this.e = null;
        this.f = 100000000;
        j = null;
    }
}
