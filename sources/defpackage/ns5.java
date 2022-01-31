package defpackage;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ns5  reason: default package */
/* compiled from: FullScreenDisplayContent */
public class ns5 implements zq5 {
    public final yr5 f;
    public final yr5 g;
    public final vr5 h;
    public final List<xq5> i;
    public final String j;
    public final String k;
    public final int l;
    public final int m;
    public final xq5 n;

    /* renamed from: ns5$b */
    /* compiled from: FullScreenDisplayContent */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public yr5 f2601a;
        public yr5 b;
        public vr5 c;
        public List<xq5> d = new ArrayList();
        public String e = "separate";
        public String f = "header_media_body";
        public int g = -1;
        public int h = -16777216;
        public xq5 i;

        public b(a aVar) {
        }
    }

    public ns5(b bVar, a aVar) {
        this.f = bVar.f2601a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.j = bVar.e;
        this.i = bVar.d;
        this.k = bVar.f;
        this.l = bVar.g;
        this.m = bVar.h;
        this.n = bVar.i;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b e = zt5.s().e("heading", this.f).e(ProductPromotionsObject.KEY_BODY, this.g).e("media", this.h).e("buttons", JsonValue.x(this.i));
        e.f("button_layout", this.j);
        e.f("template", this.k);
        e.f("background_color", hd3.S(this.l));
        e.f("dismiss_button_color", hd3.S(this.m));
        return JsonValue.x(e.e("footer", this.n).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || ns5.class != obj.getClass()) {
            return false;
        }
        ns5 ns5 = (ns5) obj;
        if (this.l != ns5.l || this.m != ns5.m) {
            return false;
        }
        yr5 yr5 = this.f;
        if (yr5 == null ? ns5.f != null : !yr5.equals(ns5.f)) {
            return false;
        }
        yr5 yr52 = this.g;
        if (yr52 == null ? ns5.g != null : !yr52.equals(ns5.g)) {
            return false;
        }
        vr5 vr5 = this.h;
        if (vr5 == null ? ns5.h != null : !vr5.equals(ns5.h)) {
            return false;
        }
        List<xq5> list = this.i;
        if (list == null ? ns5.i != null : !list.equals(ns5.i)) {
            return false;
        }
        String str = this.j;
        if (str == null ? ns5.j != null : !str.equals(ns5.j)) {
            return false;
        }
        String str2 = this.k;
        if (str2 == null ? ns5.k != null : !str2.equals(ns5.k)) {
            return false;
        }
        xq5 xq5 = this.n;
        xq5 xq52 = ns5.n;
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
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.j;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.k;
        int hashCode6 = (((((hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.l) * 31) + this.m) * 31;
        xq5 xq5 = this.n;
        if (xq5 != null) {
            i2 = xq5.hashCode();
        }
        return hashCode6 + i2;
    }

    public String toString() {
        return b().toString();
    }
}
