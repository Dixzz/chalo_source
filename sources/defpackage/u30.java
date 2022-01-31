package defpackage;

import app.zophop.models.RouteInfo;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: u30  reason: default package */
/* compiled from: PopularRouteRemoteConfigStore */
public class u30 implements s20 {
    @Override // defpackage.s20
    public List<RouteInfo> a() {
        StringBuilder sb = new StringBuilder();
        xt.t1 t1Var = xt.f3961a;
        sb.append(t1Var.k().d().getName().toLowerCase());
        sb.append("popularRoutes");
        String f = t1Var.t().f(sb.toString());
        ArrayList arrayList = new ArrayList();
        if (f != null) {
            try {
                JSONArray jSONArray = new JSONArray(f);
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(new rv().e(jSONArray.getJSONObject(i)));
                }
            } catch (JSONException unused) {
            }
        }
        return arrayList;
    }

    @Override // defpackage.s20
    public boolean b() {
        String f;
        xt.t1 t1Var = xt.f3961a;
        String B = hj1.B(t1Var);
        if (!(B == null || (f = t1Var.t().f("cityListForPopularRoutesInSearch")) == null)) {
            try {
                JSONArray jSONArray = new JSONArray(f);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    if (string != null && string.equalsIgnoreCase(B)) {
                        return true;
                    }
                }
            } catch (JSONException e) {
                e.getMessage();
            }
        }
        return false;
    }
}
