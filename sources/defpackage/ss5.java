package defpackage;

import com.urbanairship.json.JsonValue;
import defpackage.zt5;

/* renamed from: ss5  reason: default package */
/* compiled from: HtmlDisplayContent */
public class ss5 implements zq5 {
    public final String f;
    public final int g;
    public final int h;
    public final float i;
    public final boolean j;
    public final int k;
    public final int l;
    public final boolean m;
    public final boolean n;

    /* renamed from: ss5$b */
    /* compiled from: HtmlDisplayContent */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f3251a;
        public int b = -16777216;
        public int c = -1;
        public float d;
        public boolean e;
        public int f;
        public int g;
        public boolean h;
        public boolean i = true;

        public b(a aVar) {
        }

        public ss5 a() {
            boolean z = true;
            hd3.D(this.d >= 0.0f, "Border radius must be >= 0");
            if (this.f3251a == null) {
                z = false;
            }
            hd3.D(z, "Missing URL");
            return new ss5(this, null);
        }
    }

    public ss5(b bVar, a aVar) {
        this.f = bVar.f3251a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.i = bVar.d;
        this.j = bVar.e;
        this.k = bVar.f;
        this.l = bVar.g;
        this.m = bVar.h;
        this.n = bVar.i;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.f("dismiss_button_color", hd3.S(this.g));
        s.f("url", this.f);
        s.f("background_color", hd3.S(this.h));
        return JsonValue.x(s.b("border_radius", (double) this.i).g("allow_fullscreen_display", this.j).c("width", this.k).c("height", this.l).g("aspect_lock", this.m).g("require_connectivity", this.n).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ss5.class != obj.getClass()) {
            return false;
        }
        ss5 ss5 = (ss5) obj;
        if (this.g == ss5.g && this.h == ss5.h && Float.compare(ss5.i, this.i) == 0 && this.j == ss5.j && this.k == ss5.k && this.l == ss5.l && this.m == ss5.m && this.n == ss5.n) {
            return this.f.equals(ss5.f);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f.hashCode() * 31) + this.g) * 31) + this.h) * 31;
        float f2 = this.i;
        return ((((((((((hashCode + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31) + (this.j ? 1 : 0)) * 31) + this.k) * 31) + this.l) * 31) + (this.m ? 1 : 0)) * 31) + (this.n ? 1 : 0);
    }

    public String toString() {
        return b().toString();
    }
}
