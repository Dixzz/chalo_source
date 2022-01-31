package defpackage;

import android.content.Context;
import com.google.android.gms.maps.model.LatLng;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;

/* renamed from: ee1  reason: default package */
/* compiled from: SavedDestinationsFeature */
public abstract class ee1 {
    public static String c;
    public static String d;

    /* renamed from: a  reason: collision with root package name */
    public Context f964a;
    public je1 b;

    public boolean a(mf1 mf1, long j) {
        if (mf1.b != null && !j(mf1)) {
            if (!((g().b.contains("home") && h("home").equals(mf1)) || (g().b.contains("work") && h("work").equals(mf1)))) {
                mf1.c = mf1.b;
                rf1 i = i();
                String str = mf1.b;
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("timestamp", Long.valueOf(j));
                jsonObject.addProperty("desc_loc", mf1.b());
                i.j(str, jsonObject.toString());
                rf1 i2 = i();
                HashMap hashMap = new HashMap(i2.b());
                TreeMap treeMap = new TreeMap();
                hashMap.size();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        pf1 n = vn.n((String) entry.getValue());
                        if (n.f2797a != null) {
                            treeMap.put(Long.valueOf(n.b), n);
                        } else {
                            i2.k(str2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (pf1 pf1 : treeMap.descendingMap().values()) {
                    arrayList.add(pf1.f2797a);
                }
                if (arrayList.size() > 5) {
                    i().k(((mf1) arrayList.get(arrayList.size() - 1)).b);
                }
                return true;
            }
        }
        return false;
    }

    public boolean b(String str) {
        if (!g().b.contains(str)) {
            return false;
        }
        rf1 g = g();
        g.f3075a.remove(str);
        g.f3075a.commit();
        return true;
    }

    public boolean c(mf1 mf1) {
        boolean z = false;
        if (mf1.b == null || mf1.f2368a == null) {
            return false;
        }
        if (g().b.contains("home") && mf1.b.equals(h("home").b)) {
            z = false | b("home");
        }
        if (g().b.contains("work") && mf1.b.equals(h("work").b)) {
            z |= b("work");
        }
        return k(mf1) | z;
    }

    public ArrayList<mf1> d() {
        rf1 rf1 = ((b60) this).e;
        HashMap hashMap = new HashMap(rf1.b());
        ArrayList<mf1> arrayList = new ArrayList<>();
        hashMap.size();
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            mf1 a2 = mf1.a((String) entry.getValue());
            if (a2 != null) {
                arrayList.add(a2);
            } else {
                rf1.k(str);
            }
        }
        return arrayList;
    }

    public ArrayList<pf1> e() {
        ArrayList<pf1> arrayList = new ArrayList<>();
        for (Map.Entry entry : new HashMap(i().b()).entrySet()) {
            String str = (String) entry.getKey();
            try {
                arrayList.add(vn.n((String) entry.getValue()));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public abstract rf1 f();

    public abstract rf1 g();

    public mf1 h(String str) {
        if (!g().b.contains(str)) {
            return null;
        }
        mf1 a2 = mf1.a(g().b.getString(str, null));
        if (a2 != null) {
            return a2;
        }
        rf1 g = g();
        g.f3075a.remove(str);
        g.f3075a.commit();
        return null;
    }

    public abstract rf1 i();

    public boolean j(mf1 mf1) {
        if (mf1 == null) {
            return false;
        }
        return f().a(mf1.b);
    }

    public boolean k(mf1 mf1) {
        if (!j(mf1)) {
            return false;
        }
        f().k(mf1.b);
        return true;
    }

    public boolean l(mf1 mf1) {
        boolean z;
        if (mf1 == null) {
            z = false;
        } else {
            z = i().a(mf1.b);
        }
        if (!z) {
            return false;
        }
        i().k(mf1.b);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m(defpackage.mf1 r6, java.lang.String r7, java.lang.String r8) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r5.c(r6)
            com.google.android.gms.maps.model.LatLng r1 = r6.f2368a
            r2 = 1
            if (r1 == 0) goto L_0x001a
            java.lang.String r3 = r6.b
            if (r3 != 0) goto L_0x001a
            je1 r0 = r5.b
            java.lang.String r0 = r0.f(r1)
            r5.n(r8, r0)
            goto L_0x0032
        L_0x001a:
            java.lang.String r3 = r6.b
            if (r3 == 0) goto L_0x0033
            if (r1 != 0) goto L_0x0033
            je1 r0 = r5.b
            md1 r1 = new md1
            java.lang.String r3 = r6.c
            java.lang.String r4 = r6.d
            r1.<init>(r3, r4)
            java.lang.String r0 = r0.e(r1)
            r5.n(r8, r0)
        L_0x0032:
            r0 = 1
        L_0x0033:
            if (r0 != 0) goto L_0x0039
            r0 = 0
            r5.n(r8, r0)
        L_0x0039:
            r6.c = r7
            rf1 r7 = r5.g()
            java.lang.String r0 = r6.b()
            android.content.SharedPreferences$Editor r1 = r7.f3075a
            r1.putString(r8, r0)
            android.content.SharedPreferences$Editor r7 = r7.f3075a
            r7.commit()
            r5.l(r6)
            r6 = -9223372036854775808
            java.lang.String r0 = "home work set"
            java.lang.String r1 = "type"
            ed1 r6 = defpackage.hj1.l(r0, r6, r1, r8)
            jz5 r7 = defpackage.jz5.b()
            r7.g(r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ee1.m(mf1, java.lang.String, java.lang.String):boolean");
    }

    public void n(String str, String str2) {
        if ("home".equals(str)) {
            c = str2;
        }
        if ("work".equals(str)) {
            d = str2;
        }
    }

    public boolean o(String str, ad1 ad1, String str2, LatLng latLng) {
        if (str.equals(c)) {
            ad1 ad12 = ad1.SUCCESS;
            if (ad1.equals(ad12)) {
                m(new mf1(str2, latLng), "Home", "home");
                jz5.b().i(new nd1("home", ad12));
            } else {
                b("home");
                jz5.b().i(new nd1("home", ad1.FAILED));
            }
            c = null;
            return true;
        } else if (!str.equals(d)) {
            return false;
        } else {
            ad1 ad13 = ad1.SUCCESS;
            if (ad1.equals(ad13)) {
                m(new mf1(str2, latLng), "Work", "work");
                jz5.b().i(new nd1("work", ad13));
            } else {
                b("work");
                jz5.b().i(new nd1("work", ad1.FAILED));
            }
            return true;
        }
    }

    public void onEvent(ie1 ie1) {
        if (o(ie1.d, ie1.c, ie1.f1509a, ie1.b)) {
            jz5.b().m(ie1);
        }
    }

    public void onEvent(qe1 qe1) {
        if (o(qe1.d, qe1.c, qe1.f2934a, qe1.b)) {
            jz5.b().m(qe1);
        }
    }
}
