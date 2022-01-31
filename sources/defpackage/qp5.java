package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: qp5  reason: default package */
/* compiled from: AttributeMutation */
public class qp5 implements cu5 {
    public final String f;
    public final String g;
    public final JsonValue h;
    public final String i;

    public qp5(String str, String str2, JsonValue jsonValue, String str3) {
        this.f = str;
        this.g = str2;
        this.h = jsonValue;
        this.i = str3;
    }

    public static List<qp5> a(List<qp5> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList(list);
        Collections.reverse(arrayList2);
        HashSet hashSet = new HashSet();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            qp5 qp5 = (qp5) it.next();
            if (!hashSet.contains(qp5.g)) {
                arrayList.add(0, qp5);
                hashSet.add(qp5.g);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0049, code lost:
        if (r4 == false) goto L_0x0051;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.qp5 c(com.urbanairship.json.JsonValue r6) throws defpackage.xt5 {
        /*
            zt5 r6 = r6.n()
            java.lang.String r0 = "action"
            com.urbanairship.json.JsonValue r0 = r6.u(r0)
            java.lang.String r0 = r0.i()
            java.lang.String r1 = "key"
            com.urbanairship.json.JsonValue r1 = r6.u(r1)
            java.lang.String r1 = r1.i()
            java.util.Map<java.lang.String, com.urbanairship.json.JsonValue> r2 = r6.f
            java.lang.String r3 = "value"
            java.lang.Object r2 = r2.get(r3)
            com.urbanairship.json.JsonValue r2 = (com.urbanairship.json.JsonValue) r2
            java.lang.String r3 = "timestamp"
            com.urbanairship.json.JsonValue r3 = r6.u(r3)
            java.lang.String r3 = r3.i()
            if (r0 == 0) goto L_0x0051
            if (r1 == 0) goto L_0x0051
            if (r2 == 0) goto L_0x004b
            boolean r4 = r2.l()
            if (r4 != 0) goto L_0x0048
            java.lang.Object r4 = r2.f
            boolean r5 = r4 instanceof defpackage.yt5
            if (r5 != 0) goto L_0x0048
            boolean r5 = r4 instanceof defpackage.zt5
            if (r5 != 0) goto L_0x0048
            boolean r4 = r4 instanceof java.lang.Boolean
            if (r4 != 0) goto L_0x0048
            r4 = 1
            goto L_0x0049
        L_0x0048:
            r4 = 0
        L_0x0049:
            if (r4 == 0) goto L_0x0051
        L_0x004b:
            qp5 r6 = new qp5
            r6.<init>(r0, r1, r2, r3)
            return r6
        L_0x0051:
            xt5 r0 = new xt5
            java.lang.String r1 = "Invalid attribute mutation: "
            java.lang.String r6 = defpackage.hj1.Q(r1, r6)
            r0.<init>(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qp5.c(com.urbanairship.json.JsonValue):qp5");
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.f("action", this.f);
        s.f(AnalyticsConstants.KEY, this.g);
        zt5.b e = s.e(FirebaseAnalytics.Param.VALUE, this.h);
        e.f("timestamp", this.i);
        return JsonValue.x(e.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || qp5.class != obj.getClass()) {
            return false;
        }
        qp5 qp5 = (qp5) obj;
        if (!this.f.equals(qp5.f) || !this.g.equals(qp5.g)) {
            return false;
        }
        JsonValue jsonValue = this.h;
        if (jsonValue == null ? qp5.h == null : jsonValue.equals(qp5.h)) {
            return this.i.equals(qp5.i);
        }
        return false;
    }

    public int hashCode() {
        int r0 = hj1.r0(this.g, this.f.hashCode() * 31, 31);
        JsonValue jsonValue = this.h;
        return this.i.hashCode() + ((r0 + (jsonValue != null ? jsonValue.hashCode() : 0)) * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("AttributeMutation{action='");
        hj1.U0(i0, this.f, '\'', ", name='");
        hj1.U0(i0, this.g, '\'', ", value=");
        i0.append(this.h);
        i0.append(", timestamp='");
        i0.append(this.i);
        i0.append('\'');
        i0.append('}');
        return i0.toString();
    }
}
