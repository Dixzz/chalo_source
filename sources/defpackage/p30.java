package defpackage;

import android.content.Context;
import android.text.TextUtils;
import app.zophop.models.City;
import app.zophop.pubsub.eventbus.events.InAppCardDismissed;
import app.zophop.utilities.models.InAppMessageDetails;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: p30  reason: default package */
/* compiled from: NotificationStore */
public class p30 {

    /* renamed from: a  reason: collision with root package name */
    public final rf1 f2763a;
    public final rf1 b;
    public final rf1 c;
    public final rf1 d;
    public final Context e;
    public InAppMessageDetails f;

    public p30(Context context) {
        this.e = context;
        rf1 rf1 = new rf1(context, "in_app_card_store");
        this.f2763a = rf1;
        this.b = new rf1(context, "alert_store");
        this.c = new rf1(context, "silent_alert_store_key");
        this.d = new rf1(context, "in_app_message_store_key");
        Iterator it = new HashSet(rf1.b().keySet()).iterator();
        while (true) {
            boolean z = true;
            if (it.hasNext()) {
                try {
                    ze1 Q = vn.Q(this.f2763a.f((String) it.next(), null));
                    if (Q.l >= System.currentTimeMillis()) {
                        z = false;
                    }
                    if (z) {
                        this.f2763a.k(Q.n);
                    }
                } catch (JSONException e2) {
                    h(e2, "json exception found while trying to read in app card info");
                }
            } else {
                jz5 b2 = jz5.b();
                b2.k(this, b2.e, true, 0);
                return;
            }
        }
    }

    public void a(re1 re1) {
        if (re1.o.equalsIgnoreCase("ALERT")) {
            List<String> list = re1.m;
            if (list == null || list.size() == 0) {
                List<City> e2 = xt.f3961a.k().e();
                if (e2 != null) {
                    for (City city : e2) {
                        b(this.b, city.getName(), re1);
                    }
                    return;
                }
                return;
            }
            for (String str : list) {
                b(this.b, str, re1);
            }
        } else if (re1.o.equalsIgnoreCase("SILENT_ALERT")) {
            b(this.c, hj1.C(xt.f3961a), re1);
        }
    }

    public final void b(rf1 rf1, String str, re1 re1) {
        if (str != null) {
            String lowerCase = str.toLowerCase();
            JSONObject jSONObject = null;
            String f2 = rf1.f(lowerCase, null);
            if (f2 == null) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(f2);
                } catch (JSONException e2) {
                    StringBuilder i0 = hj1.i0("error while writing alert with id = ");
                    i0.append(re1.f);
                    h(e2, i0.toString());
                }
            }
            if (jSONObject != null) {
                try {
                    boolean z = false;
                    if (jSONObject.has(re1.f)) {
                        z = new JSONObject(jSONObject.getString(re1.f)).optBoolean("alert_seen", false);
                    }
                    if (z) {
                        re1.k = true;
                    }
                    jSONObject.put(re1.f, vn.e1(re1));
                } catch (JSONException e3) {
                    StringBuilder i02 = hj1.i0("error while writing alert with id = ");
                    i02.append(re1.f);
                    h(e3, i02.toString());
                }
                rf1.j(lowerCase, jSONObject.toString());
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (defpackage.ui1.m(r4, r7) > r8) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(org.json.JSONArray r13) {
        /*
        // Method dump skipped, instructions count: 159
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p30.c(org.json.JSONArray):void");
    }

    public final void d(List<re1> list, Set<String> set) {
        long Q = ui1.Q();
        for (re1 re1 : list) {
            if (re1.q < Q) {
                set.add(re1.f);
            }
        }
        if (list.size() >= 10) {
            int size = (list.size() - set.size()) - 10;
            int size2 = list.size();
            while (true) {
                size2--;
                if (size2 < 0 || size <= 0) {
                    return;
                }
                if (!set.contains(list.get(size2).f)) {
                    set.add(list.get(size2).f);
                    size--;
                }
            }
        }
    }

    public List<re1> e() {
        List<re1> arrayList = new ArrayList<>();
        xt.t1 t1Var = xt.f3961a;
        String C = (t1Var.k() == null || t1Var.k().d() == null || hj1.B(t1Var) == null) ? null : hj1.C(t1Var);
        if (C == null) {
            return arrayList;
        }
        String string = this.b.b.getString(C, null);
        String string2 = this.c.b.getString(C, null);
        if (string != null) {
            try {
                arrayList = vn.C(string);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        if (string2 != null) {
            try {
                arrayList.addAll(vn.C(string2));
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public final Set<String> f(String str) {
        HashSet hashSet = new HashSet();
        if (str == null) {
            return hashSet;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (ui1.Q() > new JSONObject(jSONObject.getString(next)).optLong("expiry_time", 2604658865908L)) {
                    hashSet.add(next);
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return hashSet;
    }

    public final String g(String str) {
        String name;
        if (str != null) {
            return hj1.S(str, "keySilentAlertStoreVersionCode");
        }
        City d2 = xt.f3961a.k().d();
        if (d2 == null || (name = d2.getName()) == null) {
            return "keySilentAlertStoreVersionCode";
        }
        return name.toLowerCase() + "keySilentAlertStoreVersionCode";
    }

    public final void h(JSONException jSONException, String str) {
        b00 b00 = b00.f358a;
        if (b00.a() != null) {
            hj1.W0(jSONException);
        }
    }

    public final boolean i(re1 re1) {
        se1 se1 = re1.l;
        if (!(se1 != null)) {
            return false;
        }
        if (se1.f3205a != null) {
            return true;
        }
        return false;
    }

    public final void j(re1 re1, boolean z, boolean z2) {
        ed1 ed1 = new ed1("alert notification received", Long.MIN_VALUE);
        ed1.a("alertId", re1.f);
        ed1.a("alertTitle", re1.g);
        ed1.a("alertType", re1.a());
        ed1.a("isLocationFiltered", String.valueOf(i(re1)));
        ed1.a("receivedTime", String.valueOf(System.currentTimeMillis()));
        ed1.a("userLocationAvailable", String.valueOf(z));
        ed1.a("userLocationMatched", String.valueOf(z2));
        jz5.b().g(ed1);
    }

    public final void k(rf1 rf1) {
        if (rf1 != null) {
            for (String str : rf1.b().keySet()) {
                try {
                    String f2 = rf1.f(str, null);
                    Set<String> f3 = f(f2);
                    List<re1> C = vn.C(f2);
                    Collections.sort(C);
                    d(C, f3);
                    JSONObject jSONObject = new JSONObject(f2);
                    JSONObject jSONObject2 = new JSONObject();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!((HashSet) f3).contains(next)) {
                            jSONObject2.put(next, jSONObject.getString(next));
                        }
                    }
                    rf1.j(str, jSONObject2.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public final boolean l(re1 re1) {
        if (TextUtils.isEmpty(re1.f)) {
            b00 b00 = b00.f358a;
            b00.a().b(new d00(lf1.ALERT, "alert received with no id"));
            return false;
        } else if (!TextUtils.isEmpty(re1.h) || !TextUtils.isEmpty(re1.g)) {
            return true;
        } else {
            b00 b002 = b00.f358a;
            b00.a().b(new d00(lf1.ALERT, hj1.a0(hj1.i0("alert with id = "), re1.f, " has no title and no message - redundant alert")));
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEvent(defpackage.te1 r19) {
        /*
        // Method dump skipped, instructions count: 422
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p30.onEvent(te1):void");
    }

    public void onEvent(ye1 ye1) {
        ze1 ze1 = ye1.f4038a;
        boolean z = false;
        if (TextUtils.isEmpty(ze1.n)) {
            b00 b00 = b00.f358a;
            b00.a().b(new d00(lf1.IN_APP_CARD, "card info recieved with no id"));
        } else if (TextUtils.isEmpty(ze1.g)) {
            b00 b002 = b00.f358a;
            b00.a().b(new d00(lf1.IN_APP_CARD, hj1.a0(hj1.i0("card info with id = "), ze1.n, " has no image url")));
        } else if (ze1.l == -1) {
            b00 b003 = b00.f358a;
            b00.a().b(new d00(lf1.IN_APP_CARD, hj1.a0(hj1.i0("card info with id = "), ze1.n, " has invalid expiry time")));
        } else {
            z = true;
        }
        if (z) {
            try {
                this.f2763a.j(ze1.n, vn.f1(ze1));
            } catch (JSONException e2) {
                h(e2, "error while trying to add card in store");
            }
            ed1 ed1 = new ed1("in app card received", Long.MIN_VALUE);
            hj1.K0(ed1, "name", ze1.n, ed1);
        }
        jz5.b().m(ye1);
    }

    public void onEvent(af1 af1) {
        InAppMessageDetails inAppMessageDetails = new InAppMessageDetails(af1.f157a);
        this.f = inAppMessageDetails;
        rf1 rf1 = this.d;
        rf1.f3075a.putString("IN_APP_PROMPT", inAppMessageDetails.f);
        rf1.f3075a.commit();
        jz5.b().m(af1);
    }

    public void onEvent(InAppCardDismissed inAppCardDismissed) {
        this.f2763a.k(inAppCardDismissed.getCardInfo().n);
    }

    public void onEvent(ue1 ue1) {
        new f30(this.e, ue1).execute(new String[0]);
        jz5.b().m(ue1);
    }
}
