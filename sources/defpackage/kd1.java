package defpackage;

import defpackage.nc5;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: kd1  reason: default package */
/* compiled from: UserSession */
public class kd1 extends jd1 implements hd1 {
    public dd1 d = new dd1();

    public kd1(nc5 nc5, zc1 zc1, String str) {
        super(nc5, zc1, str);
    }

    @Override // defpackage.hd1, defpackage.jd1
    public void g(ed1 ed1) {
        String str = ed1.f961a;
        if (this.d.f822a.containsKey(str)) {
            int intValue = this.d.f822a.get(str).intValue();
            nc5.e eVar = this.f1905a.e;
            double d2 = (double) intValue;
            JSONObject jSONObject = new JSONObject(ed1.b);
            if (!nc5.this.m()) {
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                simpleDateFormat.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("$amount", d2);
                    jSONObject2.put("$time", simpleDateFormat.format(date));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        jSONObject2.put(next, jSONObject.get(next));
                    }
                    eVar.b("$transactions", jSONObject2);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
