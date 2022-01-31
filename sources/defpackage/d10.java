package defpackage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import app.zophop.R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: d10  reason: default package */
/* compiled from: ChaloConfigFeature */
public class d10 implements f20 {

    /* renamed from: a  reason: collision with root package name */
    public static d10 f777a;
    public static Context b;
    public static String c;
    public static Handler d;

    /* renamed from: d10$a */
    /* compiled from: ChaloConfigFeature */
    public class a implements Runnable {
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;

        public a(String str, String str2) {
            this.f = str;
            this.g = str2;
        }

        public void run() {
            ed1 ed1 = new ed1(this.f, Long.MIN_VALUE);
            String str = this.g;
            if (str != null) {
                ed1.a("event description", str);
            }
            jz5.b().g(ed1);
        }
    }

    /* renamed from: d10$b */
    /* compiled from: ChaloConfigFeature */
    public class b implements Runnable {
        public final /* synthetic */ String f;
        public final /* synthetic */ Map g;

        public b(String str, Map map) {
            this.f = str;
            this.g = map;
        }

        public void run() {
            ed1 ed1 = new ed1(this.f, Long.MIN_VALUE);
            Map map = this.g;
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    ed1.a((String) entry.getKey(), entry.getValue());
                }
            }
            jz5.b().g(ed1);
        }
    }

    public d10(Context context) {
        String b2 = xt.f3961a.z().b();
        c = b2;
        if (b2.equals("en")) {
            c = "";
        }
        b = context;
        d = new Handler();
        l("chalo config event etagVersion", "chaloConfig instantiated");
    }

    public static void h(d10 d10, String str, String str2) {
        String str3;
        String str4;
        Objects.requireNonNull(d10);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("forceFetchKeys");
            if (jSONObject2 != null) {
                JSONObject jSONObject3 = new JSONObject(jSONObject2.getString("v"));
                String str5 = null;
                String optString = jSONObject3.optString("keysToUpdate", null);
                if (optString == null) {
                    str5 = jSONObject3.optString("keysToExclude", null);
                }
                int i = 0;
                if (optString != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(optString);
                        int length = jSONArray.length();
                        while (i < length) {
                            String string = jSONArray.getString(i);
                            if (string.equals("all")) {
                                d10.i(jSONObject, str2);
                                return;
                            }
                            JSONObject jSONObject4 = jSONObject.getJSONObject(string);
                            Iterator<String> keys = jSONObject4.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                String string2 = jSONObject4.getString(next);
                                if (!next.equals("v")) {
                                    str4 = string + str2;
                                } else {
                                    str4 = string;
                                }
                                xt.f3961a.h().put(str4, string2);
                                length = length;
                                jSONArray = jSONArray;
                                string = string;
                            }
                            i++;
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("event description", "parsing and activation successful");
                        m("activate select keys etagVersion called", hashMap);
                    } catch (JSONException e) {
                        HashMap hashMap2 = new HashMap();
                        hashMap2.put("event description", "failed to parse keys");
                        m("activate select keys etagVersion called", hashMap2);
                        xt.f3961a.i().put("chaloConfigFetchCallSuccessful", "false");
                        e.printStackTrace();
                    }
                } else if (str5 != null) {
                    HashSet hashSet = new HashSet();
                    try {
                        JSONArray jSONArray2 = new JSONArray(str5);
                        int length2 = jSONArray2.length();
                        while (i < length2) {
                            hashSet.add(jSONArray2.getString(i));
                            i++;
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    Iterator<String> keys2 = jSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        if (!hashSet.contains(next2)) {
                            try {
                                JSONObject jSONObject5 = jSONObject.getJSONObject(next2);
                                Iterator<String> keys3 = jSONObject5.keys();
                                while (keys3.hasNext()) {
                                    String next3 = keys3.next();
                                    String string3 = jSONObject5.getString(next3);
                                    if (!next3.equals("v")) {
                                        str3 = next2 + str2;
                                    } else {
                                        str3 = next2;
                                    }
                                    xt.f3961a.h().put(str3, string3);
                                }
                                HashMap hashMap3 = new HashMap();
                                hashMap3.put("excluding select keys", "parsing and activation successful");
                                m("activate select keys etagVersion called", hashMap3);
                            } catch (JSONException e3) {
                                HashMap hashMap4 = new HashMap();
                                hashMap4.put("excluding select keys", "failed to parse keys");
                                m("activate select keys etagVersion called", hashMap4);
                                xt.f3961a.i().put("chaloConfigFetchCallSuccessful", "true");
                                e3.printStackTrace();
                            }
                        }
                    }
                }
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
            xt.f3961a.i().put("chaloConfigFetchCallSuccessful", "false");
            HashMap hashMap5 = new HashMap();
            hashMap5.put("event description", "failed to parse keys");
            m("activate select keys etagVersion called", hashMap5);
        }
    }

    public static void l(String str, String str2) {
        if (d != null) {
            xt.t1 t1Var = xt.f3961a;
            t1Var.v();
            if (t1Var.v().f) {
                d.postDelayed(new a(str, str2), 2000);
            }
        }
    }

    public static void m(String str, Map<String, String> map) {
        if (d != null) {
            xt.t1 t1Var = xt.f3961a;
            t1Var.v();
            if (t1Var.v().f) {
                d.postDelayed(new b(str, map), 2000);
            }
        }
    }

    @Override // defpackage.f20
    public void a(long j) {
        xt.t1 t1Var = xt.f3961a;
        String optString = t1Var.h().h.optString("chaloConfigLastUpdatedDate", null);
        if (optString == null) {
            j(true);
            return;
        }
        l("chalo config event etagVersion", "chaloConfig activate called");
        String optString2 = t1Var.i().h.optString("activateActivateFetchedInThisSession", null);
        if (optString2 == null || !optString2.equals("true")) {
            String optString3 = t1Var.i().h.optString("updateTime", null);
            if (optString3 != null) {
                try {
                    if (Long.parseLong(optString3) + j > ui1.Q()) {
                        k(optString);
                        return;
                    }
                    l("chalo config event etagVersion", "chalo config cache expired at: " + optString3);
                } catch (Exception unused) {
                    l("chalo config event etagVersion", "time exception occurred");
                }
            }
            k(optString);
            return;
        }
        j(false);
    }

    @Override // defpackage.f20
    public boolean b(String str) {
        StringBuilder i0 = hj1.i0(str);
        i0.append(c);
        String sb = i0.toString();
        xt.t1 t1Var = xt.f3961a;
        String str2 = null;
        if (t1Var.h().containsKey(sb)) {
            str2 = t1Var.h().a(sb);
        } else if (t1Var.h().h.has(str)) {
            str2 = t1Var.h().h.optString(str, null);
        }
        if (str2 == null) {
            return false;
        }
        if (!str2.equalsIgnoreCase("1") && !str2.equalsIgnoreCase("t") && !str2.equalsIgnoreCase("true") && !str2.equalsIgnoreCase("yes") && !str2.equalsIgnoreCase("y") && !str2.equalsIgnoreCase("on")) {
            return false;
        }
        return true;
    }

    @Override // defpackage.f20
    public long c(String str) {
        String optString;
        StringBuilder i0 = hj1.i0(str);
        i0.append(c);
        String sb = i0.toString();
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.h().containsKey(sb)) {
            String a2 = t1Var.h().a(sb);
            if (a2 == null) {
                return 0;
            }
            try {
                return Long.parseLong(a2);
            } catch (NumberFormatException unused) {
                return p(a2);
            }
        } else if (!t1Var.h().h.has(str) || (optString = t1Var.h().h.optString(str, null)) == null) {
            return 0;
        } else {
            try {
                return Long.parseLong(optString);
            } catch (NumberFormatException unused2) {
                return p(optString);
            }
        }
    }

    @Override // defpackage.f20
    public void d(String str) {
        if (c.equals("en")) {
            c = "";
        } else if (!c.equals(str)) {
            c = str;
            HashMap m0 = hj1.m0("event description", "chaloconfig change locale");
            m0.put("network type", vn.Y(b));
            m0.put("time of event", String.valueOf(ui1.Q()));
            m("chalo config fetch and activate event etagVersion", m0);
            xt.t1 t1Var = xt.f3961a;
            t1Var.i().put("chaloConfigLatestVersionCode", null);
            t1Var.i().put("etagChaloConfigCachedEtag", null);
            t1Var.i().put("activateActivateFetchedInThisSession", "true");
        }
    }

    @Override // defpackage.f20
    public double e(String str) {
        String optString;
        StringBuilder i0 = hj1.i0(str);
        i0.append(c);
        String sb = i0.toString();
        xt.t1 t1Var = xt.f3961a;
        if (t1Var.h().containsKey(sb)) {
            String a2 = t1Var.h().a(sb);
            if (a2 == null) {
                return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
            }
            try {
                return Double.parseDouble(a2);
            } catch (NumberFormatException unused) {
                return o(a2);
            }
        } else if (!t1Var.h().h.has(str) || (optString = t1Var.h().h.optString(str, null)) == null) {
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        } else {
            try {
                return Double.parseDouble(optString);
            } catch (NumberFormatException unused2) {
                return o(optString);
            }
        }
    }

    @Override // defpackage.f20
    public String f(String str) {
        StringBuilder i0 = hj1.i0(str);
        i0.append(c);
        String sb = i0.toString();
        xt.t1 t1Var = xt.f3961a;
        String str2 = null;
        if (t1Var.h().containsKey(sb)) {
            str2 = t1Var.h().a(sb);
        } else if (t1Var.h().h.has(str)) {
            str2 = t1Var.h().h.optString(str, null);
        }
        return str2 == null ? "" : str2;
    }

    @Override // defpackage.f20
    public void g() {
        String str;
        xt.t1 t1Var = xt.f3961a;
        HashMap hashMap = null;
        String optString = t1Var.i().h.optString("etagChaloConfigCachedEtag", null);
        HashMap m0 = hj1.m0("event description", "chalo config normal fetch called");
        m0.put("network type", vn.Y(b));
        m0.put("time of event", String.valueOf(ui1.Q()));
        if (optString == null) {
            m0.put("etag", "chaloConfig fetch call made without etag");
        } else {
            m0.put("etag", optString);
        }
        m("chalo config normal fetch event etagVersion", m0);
        xj1 S = t1Var.S();
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.l);
        builder.appendEncodedPath("rc/v2");
        String str2 = c;
        if (str2 != null && !str2.equals("en") && !TextUtils.isEmpty(c)) {
            builder.appendQueryParameter(AnalyticsConstants.LOCALE, c);
        }
        String uri = builder.build().toString();
        String str3 = c;
        if (str3 == null || !str3.equals("en")) {
            str = c;
        } else {
            str = "";
        }
        String optString2 = t1Var.i().h.optString("etagChaloConfigCachedEtag", null);
        z00 z00 = new z00(this);
        a10 a10 = new a10(this, str);
        if (optString2 != null) {
            hashMap = hj1.m0("If-None-Match", optString2);
        }
        b70 b70 = new b70(uri, null, a10, z00, hashMap);
        b70.n = false;
        b70.q = new nj1(180000, 5, 1.0f);
        S.a(b70);
    }

    public final void i(JSONObject jSONObject, String str) {
        String str2;
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    String string = jSONObject2.getString(next2);
                    if (!next2.equals("v")) {
                        str2 = next + str;
                    } else {
                        str2 = next;
                    }
                    xt.f3961a.h().put(str2, string);
                }
                HashMap hashMap = new HashMap();
                hashMap.put("event description", "Activated all keys");
                m("activate select keys etagVersion called", hashMap);
            } catch (JSONException e) {
                xt.f3961a.i().put("chaloConfigFetchCallSuccessful", "true");
                e.printStackTrace();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("event description", "tried to activate all keys, failed to parse");
                m("activate select keys etagVersion called", hashMap2);
            }
        }
    }

    public final void j(boolean z) {
        l("chalo config event etagVersion", "chaloConfig fetch call made without etag");
        if (z) {
            HashMap m0 = hj1.m0("event description", "fresh install");
            m0.put("network type", vn.Y(b));
            m0.put("time of event", String.valueOf(ui1.Q()));
            m("chalo config fetch and activate event etagVersion", m0);
        } else {
            HashMap m02 = hj1.m0("event description", "locale changed");
            m02.put("network type", vn.Y(b));
            m02.put("time of event", String.valueOf(ui1.Q()));
            m("chalo config fetch and activate event etagVersion", m02);
        }
        Uri.Builder builder = new Uri.Builder();
        builder.encodedPath(ut.l);
        builder.appendEncodedPath("rc/v2");
        String str = c;
        if (str != null && !str.equals("en") && !TextUtils.isEmpty(c)) {
            builder.appendQueryParameter(AnalyticsConstants.LOCALE, c);
        }
        String uri = builder.build().toString();
        xj1 S = xt.f3961a.S();
        b70 b70 = new b70(uri, null, new c10(this, str), new b10(this), null);
        b70.n = false;
        b70.q = new nj1(180000, 5, 1.0f);
        S.a(b70);
    }

    public final void k(String str) {
        String str2;
        l("chalo config event etagVersion", "cahloConfig parsing last update");
        if (str != null) {
            xt.t1 t1Var = xt.f3961a;
            String optString = t1Var.i().h.optString("chaloConfigLastUpdatedLocale", null);
            if (optString == null || optString.equals("en")) {
                optString = "";
            }
            try {
                t1Var.h().clear();
                n();
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        String string = jSONObject2.getString(next2);
                        if (!next2.equals("v")) {
                            str2 = next + optString;
                        } else {
                            str2 = next;
                        }
                        xt.f3961a.h().put(str2, string);
                    }
                }
                xt.f3961a.h().put("chaloConfigLastUpdatedDate", str);
            } catch (JSONException e) {
                l("chalo config event etagVersion", "chaloconfig parse last update failed");
                xt.f3961a.i().put("chaloConfigFetchCallSuccessful", "false");
                e.printStackTrace();
            }
        }
    }

    public void n() {
        Scanner useDelimiter = new Scanner(b.getResources().openRawResource(R.raw.chalo_config_default)).useDelimiter("\\A");
        String next = useDelimiter.hasNext() ? useDelimiter.next() : "";
        l("chalo config event etagVersion", "chaloConfig set defaults called");
        try {
            JSONObject jSONObject = new JSONObject(next);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next2 = keys.next();
                String string = jSONObject.getString(next2);
                xt.t1 t1Var = xt.f3961a;
                if (!t1Var.h().containsKey(next2)) {
                    t1Var.h().put(next2, string);
                }
            }
        } catch (JSONException unused) {
            l("chalo config event etagVersion", "setdefaults parsing exception");
        }
    }

    public final double o(String str) {
        try {
            return DecimalFormat.getNumberInstance().parse(str).doubleValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }
    }

    public final long p(String str) {
        try {
            return DecimalFormat.getNumberInstance().parse(str).longValue();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
