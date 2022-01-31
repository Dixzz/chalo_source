package defpackage;

import android.graphics.Color;
import com.google.firebase.messaging.Constants;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: xq5  reason: default package */
/* compiled from: ButtonInfo */
public class xq5 implements cu5 {
    public final yr5 f;
    public final String g;
    public final String h;
    public final Float i;
    public final Integer j;
    public final Integer k;
    public final Map<String, JsonValue> l;

    /* renamed from: xq5$b */
    /* compiled from: ButtonInfo */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public yr5 f3956a;
        public String b;
        public String c = "dismiss";
        public float d = 0.0f;
        public Integer e;
        public Integer f;
        public final Map<String, JsonValue> g = new HashMap();

        public b(a aVar) {
        }

        public xq5 a() {
            boolean z = false;
            hd3.D(this.d >= 0.0f, "Border radius must be >= 0");
            hd3.D(!hd3.G1(this.b), "Missing ID.");
            hd3.D(this.b.length() <= 100, "Id exceeds max ID length: 100");
            if (this.f3956a != null) {
                z = true;
            }
            hd3.D(z, "Missing label.");
            return new xq5(this, null);
        }
    }

    public xq5(b bVar, a aVar) {
        this.f = bVar.f3956a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.i = Float.valueOf(bVar.d);
        this.j = bVar.e;
        this.k = bVar.f;
        this.l = bVar.g;
    }

    public static xq5 a(JsonValue jsonValue) throws xt5 {
        zt5 n = jsonValue.n();
        b bVar = new b(null);
        if (n.f.containsKey(Constants.ScionAnalytics.PARAM_LABEL)) {
            bVar.f3956a = yr5.a(n.u(Constants.ScionAnalytics.PARAM_LABEL));
        }
        if (n.u("id").f instanceof String) {
            bVar.b = n.u("id").o();
        }
        if (n.f.containsKey("behavior")) {
            String o = n.u("behavior").o();
            if (o.equals("cancel")) {
                bVar.c = "cancel";
            } else if (o.equals("dismiss")) {
                bVar.c = "dismiss";
            } else {
                throw new xt5(hj1.F(n, "behavior", hj1.i0("Unexpected behavior: ")));
            }
        }
        if (n.f.containsKey("border_radius")) {
            if (n.u("border_radius").f instanceof Number) {
                bVar.d = n.u("border_radius").d(0.0f);
            } else {
                throw new xt5(hj1.F(n, "border_radius", hj1.i0("Border radius must be a number: ")));
            }
        }
        if (n.f.containsKey("background_color")) {
            try {
                bVar.e = Integer.valueOf(Color.parseColor(n.u("background_color").o()));
            } catch (IllegalArgumentException e) {
                throw new xt5(hj1.F(n, "background_color", hj1.i0("Invalid background button color: ")), e);
            }
        }
        if (n.f.containsKey("border_color")) {
            try {
                bVar.f = Integer.valueOf(Color.parseColor(n.u("border_color").o()));
            } catch (IllegalArgumentException e2) {
                throw new xt5(hj1.F(n, "border_color", hj1.i0("Invalid border color: ")), e2);
            }
        }
        if (n.f.containsKey("actions")) {
            zt5 h2 = n.u("actions").h();
            if (h2 != null) {
                Map<String, JsonValue> n2 = h2.n();
                bVar.g.clear();
                bVar.g.putAll(n2);
            } else {
                throw new xt5(hj1.F(n, "actions", hj1.i0("Actions must be a JSON object: ")));
            }
        }
        try {
            return bVar.a();
        } catch (IllegalArgumentException e3) {
            throw new xt5(hj1.Q("Invalid button JSON: ", n), e3);
        }
    }

    public static List<xq5> c(yt5 yt5) throws xt5 {
        if (yt5.f.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<JsonValue> it = yt5.iterator();
        while (it.hasNext()) {
            arrayList.add(a(it.next()));
        }
        return arrayList;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        String str;
        zt5.b e = zt5.s().e(Constants.ScionAnalytics.PARAM_LABEL, this.f);
        e.f("id", this.g);
        e.f("behavior", this.h);
        e.i("border_radius", this.i);
        Integer num = this.j;
        String str2 = null;
        if (num == null) {
            str = null;
        } else {
            str = hd3.S(num.intValue());
        }
        e.i("background_color", str);
        Integer num2 = this.k;
        if (num2 != null) {
            str2 = hd3.S(num2.intValue());
        }
        e.i("border_color", str2);
        return JsonValue.x(e.e("actions", JsonValue.x(this.l)).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || xq5.class != obj.getClass()) {
            return false;
        }
        xq5 xq5 = (xq5) obj;
        yr5 yr5 = this.f;
        if (yr5 == null ? xq5.f != null : !yr5.equals(xq5.f)) {
            return false;
        }
        String str = this.g;
        if (str == null ? xq5.g != null : !str.equals(xq5.g)) {
            return false;
        }
        String str2 = this.h;
        if (str2 == null ? xq5.h != null : !str2.equals(xq5.h)) {
            return false;
        }
        if (!this.i.equals(xq5.i)) {
            return false;
        }
        Integer num = this.j;
        if (num == null ? xq5.j != null : !num.equals(xq5.j)) {
            return false;
        }
        Integer num2 = this.k;
        if (num2 == null ? xq5.k != null : !num2.equals(xq5.k)) {
            return false;
        }
        Map<String, JsonValue> map = this.l;
        Map<String, JsonValue> map2 = xq5.l;
        if (map != null) {
            return map.equals(map2);
        }
        if (map2 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        yr5 yr5 = this.f;
        int i2 = 0;
        int hashCode = (yr5 != null ? yr5.hashCode() : 0) * 31;
        String str = this.g;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.h;
        int hashCode3 = (this.i.hashCode() + ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31;
        Integer num = this.j;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.k;
        int hashCode5 = (hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Map<String, JsonValue> map = this.l;
        if (map != null) {
            i2 = map.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return b().toString();
    }
}
