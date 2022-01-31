package defpackage;

import android.content.Context;
import defpackage.xt;
import java.util.HashMap;
import java.util.Map;

/* renamed from: o30  reason: default package */
/* compiled from: NearbyStopTripsFeature */
public class o30 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f2643a;
    public final Map<String, m30> b;
    public boolean c = false;

    public o30(Context context) {
        this.f2643a = context;
        this.b = new HashMap();
    }

    public boolean a(String str, boolean z) {
        if (!this.b.containsKey(str)) {
            return false;
        }
        m30 m30 = this.b.get(str);
        m30.m = z;
        xt.t1 t1Var = xt.f3961a;
        if (!xt.p) {
            return true;
        }
        if (z) {
            m30.n = false;
            m30.d.clear();
            m30.e();
            return true;
        }
        m30.b();
        return true;
    }

    public boolean b(String str) {
        if (!this.b.containsKey(str)) {
            return false;
        }
        this.b.get(str).d();
        this.b.remove(str);
        return true;
    }
}
