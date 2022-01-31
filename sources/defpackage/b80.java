package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import app.zophop.models.City;
import com.razorpay.AnalyticsConstants;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* renamed from: b80  reason: default package */
/* compiled from: CityProvider.kt */
public final class b80 implements e80 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f394a;
    public final SharedPreferences b;
    public boolean c;
    public City d;

    public b80(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        this.f394a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("city_store", 0);
        n86.d(sharedPreferences, "context.getSharedPrefere…RE, Context.MODE_PRIVATE)");
        this.b = sharedPreferences;
        d();
    }

    @Override // defpackage.e80
    public boolean a() {
        return this.c;
    }

    @Override // defpackage.e80
    public void b() {
        this.c = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        if (defpackage.n86.a(r0.getName(), r4.getName()) == false) goto L_0x0018;
     */
    @Override // defpackage.e80
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(app.zophop.models.City r4) {
        /*
        // Method dump skipped, instructions count: 158
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b80.c(app.zophop.models.City):void");
    }

    @Override // defpackage.e80
    public City d() {
        if (this.d == null) {
            String string = this.b.getString("key_current_city", "");
            List<City> e = e();
            if (e != null) {
                Iterator<City> it = e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    City next = it.next();
                    if (n86.a(next.getName(), string)) {
                        this.d = next;
                        break;
                    }
                }
            }
        }
        return this.d;
    }

    @Override // defpackage.e80
    public List<City> e() {
        try {
            List<City> a2 = new lv().a(new JSONArray(this.b.getString("key_available_cities", null)));
            Collections.sort(a2, z70.f);
            return a2;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // defpackage.e80
    public String f() {
        return this.b.getString("key_meta_updated", null);
    }

    @Override // defpackage.e80
    public void g() {
        long currentTimeMillis = System.currentTimeMillis();
        xt.f3961a.S().a(new lk1(new Uri.Builder().encodedPath(ut.b).appendQueryParameter("appVer", "764").appendQueryParameter("meta", ui1.K0().toString()).build().toString(), null, new x70(this, currentTimeMillis), new y70(this, currentTimeMillis)));
    }
}
