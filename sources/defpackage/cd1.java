package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.List;
import java.util.Map;
import server.zophop.Constants;

/* renamed from: cd1  reason: default package */
/* compiled from: Analytics */
public class cd1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f549a;
    public final List<hd1> b;
    public SharedPreferences c;

    public cd1(Context context, List<hd1> list) {
        this.f549a = context;
        this.b = list;
        this.c = context.getSharedPreferences(Constants.PRODUCTION_ANALYTICS, 0);
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    public void a(Map<String, String> map) {
        for (hd1 hd1 : this.b) {
            hd1.e(map);
        }
    }

    public void b(Map<String, String> map) {
        for (hd1 hd1 : this.b) {
            hd1.f(map);
        }
    }

    public void onEvent(ed1 ed1) {
        long j = this.c.getLong(ed1.f961a, 0);
        boolean z = true;
        if (j != 0 && System.currentTimeMillis() - j <= ed1.c) {
            z = false;
        }
        if (z) {
            ed1.a("dayOfEvent", vn.I());
            ed1.a("time", String.valueOf(System.currentTimeMillis()));
            for (hd1 hd1 : this.b) {
                hd1.g(ed1);
            }
            SharedPreferences.Editor edit = this.c.edit();
            edit.putLong(ed1.f961a, System.currentTimeMillis());
            edit.commit();
        }
    }
}
