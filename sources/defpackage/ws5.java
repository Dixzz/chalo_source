package defpackage;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ws5  reason: default package */
/* compiled from: ModalDisplayContent */
public class ws5 implements zq5 {
    public final yr5 f;
    public final yr5 g;
    public final vr5 h;
    public final List<xq5> i;
    public final String j;
    public final String k;
    public final int l;
    public final int m;
    public final xq5 n;
    public final float o;
    public final boolean p;

    /* renamed from: ws5$b */
    /* compiled from: ModalDisplayContent */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public yr5 f3834a;
        public yr5 b;
        public vr5 c;
        public List<xq5> d = new ArrayList();
        public String e = "separate";
        public String f = "header_media_body";
        public int g = -1;
        public int h = -16777216;
        public xq5 i;
        public float j;
        public boolean k;

        public b(a aVar) {
        }
    }

    public ws5(b bVar, a aVar) {
        this.f = bVar.f3834a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.j = bVar.e;
        this.i = bVar.d;
        this.k = bVar.f;
        this.l = bVar.g;
        this.m = bVar.h;
        this.n = bVar.i;
        this.o = bVar.j;
        this.p = bVar.k;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b e = zt5.s().e("heading", this.f).e(ProductPromotionsObject.KEY_BODY, this.g).e("media", this.h).e("buttons", JsonValue.x(this.i));
        e.f("button_layout", this.j);
        e.f("template", this.k);
        e.f("background_color", hd3.S(this.l));
        e.f("dismiss_button_color", hd3.S(this.m));
        return JsonValue.x(e.e("footer", this.n).b("border_radius", (double) this.o).g("allow_fullscreen_display", this.p).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ws5.class != obj.getClass()) {
            return false;
        }
        ws5 ws5 = (ws5) obj;
        if (this.l != ws5.l || this.m != ws5.m || Float.compare(ws5.o, this.o) != 0 || this.p != ws5.p) {
            return false;
        }
        yr5 yr5 = this.f;
        if (yr5 == null ? ws5.f != null : !yr5.equals(ws5.f)) {
            return false;
        }
        yr5 yr52 = this.g;
        if (yr52 == null ? ws5.g != null : !yr52.equals(ws5.g)) {
            return false;
        }
        vr5 vr5 = this.h;
        if (vr5 == null ? ws5.h != null : !vr5.equals(ws5.h)) {
            return false;
        }
        List<xq5> list = this.i;
        if (list == null ? ws5.i != null : !list.equals(ws5.i)) {
            return false;
        }
        if (!this.j.equals(ws5.j) || !this.k.equals(ws5.k)) {
            return false;
        }
        xq5 xq5 = this.n;
        xq5 xq52 = ws5.n;
        if (xq5 != null) {
            return xq5.equals(xq52);
        }
        if (xq52 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        yr5 yr5 = this.f;
        int i2 = 0;
        int hashCode = (yr5 != null ? yr5.hashCode() : 0) * 31;
        yr5 yr52 = this.g;
        int hashCode2 = (hashCode + (yr52 != null ? yr52.hashCode() : 0)) * 31;
        vr5 vr5 = this.h;
        int hashCode3 = (hashCode2 + (vr5 != null ? vr5.hashCode() : 0)) * 31;
        List<xq5> list = this.i;
        int r0 = (((hj1.r0(this.k, hj1.r0(this.j, (hashCode3 + (list != null ? list.hashCode() : 0)) * 31, 31), 31) + this.l) * 31) + this.m) * 31;
        xq5 xq5 = this.n;
        int hashCode4 = (r0 + (xq5 != null ? xq5.hashCode() : 0)) * 31;
        float f2 = this.o;
        if (f2 != 0.0f) {
            i2 = Float.floatToIntBits(f2);
        }
        return ((hashCode4 + i2) * 31) + (this.p ? 1 : 0);
    }

    public String toString() {
        return b().toString();
    }
}
