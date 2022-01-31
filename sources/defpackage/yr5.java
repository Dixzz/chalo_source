package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: yr5  reason: default package */
/* compiled from: TextInfo */
public class yr5 implements cu5 {
    public final String f;
    public final Integer g;
    public final Float h;
    public final String i;
    public final List<String> j;
    public final List<String> k;
    public final String l;

    /* renamed from: yr5$b */
    /* compiled from: TextInfo */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f4082a;
        public Integer b;
        public Float c;
        public String d;
        public String e;
        public List<String> f = new ArrayList();
        public List<String> g = new ArrayList();

        public b(a aVar) {
        }

        public yr5 a() {
            hd3.D((this.d == null && this.f4082a == null) ? false : true, "Missing text.");
            return new yr5(this, null);
        }

        public b b(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }
    }

    public yr5(b bVar, a aVar) {
        this.f = bVar.f4082a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.i = bVar.e;
        this.j = new ArrayList(bVar.f);
        this.l = bVar.d;
        this.k = new ArrayList(bVar.g);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x017e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.yr5 a(com.urbanairship.json.JsonValue r12) throws defpackage.xt5 {
        /*
        // Method dump skipped, instructions count: 531
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yr5.a(com.urbanairship.json.JsonValue):yr5");
    }

    public static b c() {
        return new b(null);
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        String str;
        zt5.b s = zt5.s();
        s.f("text", this.f);
        Integer num = this.g;
        if (num == null) {
            str = null;
        } else {
            str = hd3.S(num.intValue());
        }
        s.i("color", str);
        s.i("size", this.h);
        s.f("alignment", this.i);
        zt5.b e = s.e("style", JsonValue.x(this.j)).e("font_family", JsonValue.x(this.k));
        e.i("android_drawable_res_name", this.l);
        return JsonValue.x(e.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || yr5.class != obj.getClass()) {
            return false;
        }
        yr5 yr5 = (yr5) obj;
        String str = this.l;
        if (str == null ? yr5.l != null : !str.equals(yr5.l)) {
            return false;
        }
        String str2 = this.f;
        if (str2 == null ? yr5.f != null : !str2.equals(yr5.f)) {
            return false;
        }
        Integer num = this.g;
        if (num == null ? yr5.g != null : !num.equals(yr5.g)) {
            return false;
        }
        Float f2 = this.h;
        if (f2 == null ? yr5.h != null : !f2.equals(yr5.h)) {
            return false;
        }
        String str3 = this.i;
        if (str3 == null ? yr5.i != null : !str3.equals(yr5.i)) {
            return false;
        }
        if (!this.j.equals(yr5.j)) {
            return false;
        }
        return this.k.equals(yr5.k);
    }

    public int hashCode() {
        String str = this.f;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.g;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        Float f2 = this.h;
        int hashCode3 = (hashCode2 + (f2 != null ? f2.hashCode() : 0)) * 31;
        String str2 = this.i;
        int hashCode4 = (this.k.hashCode() + ((this.j.hashCode() + ((hashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31)) * 31;
        String str3 = this.l;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return b().toString();
    }
}
