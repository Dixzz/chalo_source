package defpackage;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.freshchat.consumer.sdk.beans.config.DefaultUserEventsConfig;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* renamed from: hs5  reason: default package */
/* compiled from: BannerDisplayContent */
public class hs5 implements zq5 {
    public final yr5 f;
    public final yr5 g;
    public final vr5 h;
    public final List<xq5> i;
    public final String j;
    public final String k;
    public final String l;
    public final long m;
    public final int n;
    public final int o;
    public final float p;
    public final Map<String, JsonValue> q;

    /* renamed from: hs5$b */
    /* compiled from: BannerDisplayContent */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public yr5 f1422a;
        public yr5 b;
        public vr5 c;
        public List<xq5> d = new ArrayList();
        public String e = "separate";
        public String f = "bottom";
        public String g = "media_left";
        public long h = DefaultUserEventsConfig.MAX_DELAY_IN_MILLIS_UNTIL_UPLOAD;
        public int i = -1;
        public int j = -16777216;
        public float k = 0.0f;
        public final Map<String, JsonValue> l = new HashMap();

        public b(a aVar) {
        }

        public hs5 a() {
            boolean z = true;
            hd3.D(this.k >= 0.0f, "Border radius must be >= 0");
            hd3.D((this.f1422a == null && this.b == null) ? false : true, "Either the body or heading must be defined.");
            hd3.D(this.d.size() <= 2, "Banner allows a max of 2 buttons");
            vr5 vr5 = this.c;
            if (vr5 != null && !vr5.h.equals(ProductPromotionsObject.KEY_IMAGE)) {
                z = false;
            }
            hd3.D(z, "Banner only supports image media");
            return new hs5(this, null);
        }
    }

    public hs5(b bVar, a aVar) {
        this.f = bVar.f1422a;
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
        this.q = bVar.l;
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b e = zt5.s().e("heading", this.f).e(ProductPromotionsObject.KEY_BODY, this.g).e("media", this.h).e("buttons", JsonValue.x(this.i));
        e.f("button_layout", this.j);
        e.f("placement", this.k);
        e.f("template", this.l);
        zt5.b d = e.d("duration", TimeUnit.MILLISECONDS.toSeconds(this.m));
        d.f("background_color", hd3.S(this.n));
        d.f("dismiss_button_color", hd3.S(this.o));
        return JsonValue.x(d.b("border_radius", (double) this.p).e("actions", JsonValue.x(this.q)).a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || hs5.class != obj.getClass()) {
            return false;
        }
        hs5 hs5 = (hs5) obj;
        if (this.m != hs5.m || this.n != hs5.n || this.o != hs5.o || Float.compare(hs5.p, this.p) != 0) {
            return false;
        }
        yr5 yr5 = this.f;
        if (yr5 == null ? hs5.f != null : !yr5.equals(hs5.f)) {
            return false;
        }
        yr5 yr52 = this.g;
        if (yr52 == null ? hs5.g != null : !yr52.equals(hs5.g)) {
            return false;
        }
        vr5 vr5 = this.h;
        if (vr5 == null ? hs5.h != null : !vr5.equals(hs5.h)) {
            return false;
        }
        List<xq5> list = this.i;
        if (list == null ? hs5.i != null : !list.equals(hs5.i)) {
            return false;
        }
        String str = this.j;
        if (str == null ? hs5.j != null : !str.equals(hs5.j)) {
            return false;
        }
        String str2 = this.k;
        if (str2 == null ? hs5.k != null : !str2.equals(hs5.k)) {
            return false;
        }
        String str3 = this.l;
        if (str3 == null ? hs5.l != null : !str3.equals(hs5.l)) {
            return false;
        }
        Map<String, JsonValue> map = this.q;
        Map<String, JsonValue> map2 = hs5.q;
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
        yr5 yr52 = this.g;
        int hashCode2 = (hashCode + (yr52 != null ? yr52.hashCode() : 0)) * 31;
        vr5 vr5 = this.h;
        int hashCode3 = (hashCode2 + (vr5 != null ? vr5.hashCode() : 0)) * 31;
        List<xq5> list = this.i;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str = this.j;
        int hashCode5 = (hashCode4 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.k;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.l;
        int hashCode7 = str3 != null ? str3.hashCode() : 0;
        long j2 = this.m;
        int i3 = (((((((hashCode6 + hashCode7) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.n) * 31) + this.o) * 31;
        float f2 = this.p;
        int floatToIntBits = (i3 + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0)) * 31;
        Map<String, JsonValue> map = this.q;
        if (map != null) {
            i2 = map.hashCode();
        }
        return floatToIntBits + i2;
    }

    public String toString() {
        return b().toString();
    }
}
