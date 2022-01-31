package defpackage;

import org.json.JSONArray;

/* renamed from: h36  reason: default package */
/* compiled from: Socket */
public class h36 implements Runnable {
    public final /* synthetic */ String f;
    public final /* synthetic */ Object[] g;
    public final /* synthetic */ q26 h;
    public final /* synthetic */ e36 i;

    public h36(e36 e36, String str, Object[] objArr, q26 q26) {
        this.i = e36;
        this.f = str;
        this.g = objArr;
        this.h = q26;
    }

    public void run() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(this.f);
        Object[] objArr = this.g;
        if (objArr != null) {
            for (Object obj : objArr) {
                jSONArray.put(obj);
            }
        }
        a56<JSONArray> a56 = new a56<>(2, jSONArray);
        if (this.h != null) {
            e36.k.fine(String.format("emitting packet with ack id %d", Integer.valueOf(this.i.c)));
            e36 e36 = this.i;
            e36.g.put(Integer.valueOf(e36.c), this.h);
            e36 e362 = this.i;
            int i2 = e362.c;
            e362.c = i2 + 1;
            a56.b = i2;
        }
        if (this.i.b) {
            e36.g(this.i, a56);
        } else {
            this.i.j.add(a56);
        }
    }
}
