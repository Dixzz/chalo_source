package defpackage;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.freshchat.consumer.sdk.beans.User;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: tp5  reason: default package */
/* compiled from: ChannelRegistrationPayload */
public class tp5 implements cu5 {
    public final boolean f;
    public final boolean g;
    public final String h;
    public final String i;
    public final boolean j;
    public final Set<String> k;
    public final zt5 l;
    public final String m;
    public final String n;
    public final String o;
    public final String p;
    public final Boolean q;
    public final String r;
    public final String s;
    public final String t;
    public final Integer u;
    public final String v;
    public final String w;
    public final String x;
    public final String y;

    /* renamed from: tp5$b */
    /* compiled from: ChannelRegistrationPayload */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f3391a;
        public boolean b;
        public String c;
        public String d;
        public boolean e;
        public Set<String> f;
        public zt5 g;
        public String h;
        public String i;
        public String j;
        public String k;
        public Boolean l;
        public String m;
        public String n;
        public String o;
        public Integer p;
        public String q;
        public String r;
        public String s;
        public String t;

        public b() {
        }

        public tp5 a() {
            return new tp5(this, null);
        }

        public b b(String str) {
            if (hd3.G1(str)) {
                str = null;
            }
            this.h = str;
            return this;
        }

        public b(tp5 tp5) {
            this.f3391a = tp5.f;
            this.b = tp5.g;
            this.c = tp5.h;
            this.d = tp5.i;
            this.e = tp5.j;
            this.f = tp5.k;
            this.g = tp5.l;
            this.h = tp5.m;
            this.i = tp5.n;
            this.j = tp5.o;
            this.k = tp5.p;
            this.l = tp5.q;
            this.m = tp5.r;
            this.n = tp5.s;
            this.o = tp5.t;
            this.p = tp5.u;
            this.q = tp5.v;
            this.r = tp5.w;
            this.s = tp5.x;
            this.t = tp5.y;
        }
    }

    public tp5(b bVar, a aVar) {
        this.f = bVar.f3391a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.i = bVar.d;
        boolean z = bVar.e;
        this.j = z;
        this.k = z ? bVar.f : null;
        this.l = bVar.g;
        this.m = bVar.h;
        this.n = bVar.i;
        this.o = bVar.j;
        this.p = bVar.k;
        this.q = bVar.l;
        this.r = bVar.m;
        this.s = bVar.n;
        this.t = bVar.o;
        this.u = bVar.p;
        this.v = bVar.q;
        this.w = bVar.r;
        this.x = bVar.s;
        this.y = bVar.t;
    }

    public static tp5 a(JsonValue jsonValue) throws xt5 {
        zt5 n2 = jsonValue.n();
        zt5 n3 = n2.u("channel").n();
        zt5 n4 = n2.u("identity_hints").n();
        if (!n3.isEmpty() || !n4.isEmpty()) {
            HashSet hashSet = new HashSet();
            Iterator<JsonValue> it = n3.u("tags").m().iterator();
            while (it.hasNext()) {
                JsonValue next = it.next();
                if (next.f instanceof String) {
                    hashSet.add(next.i());
                } else {
                    throw new xt5(hj1.R("Invalid tag: ", next));
                }
            }
            zt5 n5 = n3.u("tag_changes").n();
            Boolean valueOf = n3.f.containsKey("location_settings") ? Boolean.valueOf(n3.u("location_settings").a(false)) : null;
            Integer valueOf2 = n3.f.containsKey("android_api_version") ? Integer.valueOf(n3.u("android_api_version").e(-1)) : null;
            String i2 = n3.u("android").n().u("delivery_type").i();
            b bVar = new b();
            bVar.f3391a = n3.u("opt_in").a(false);
            bVar.b = n3.u(ProductPromotionsObject.KEY_BACKGROUND).a(false);
            bVar.c = n3.u("device_type").i();
            bVar.d = n3.u("push_address").i();
            bVar.j = n3.u("locale_language").i();
            bVar.k = n3.u("locale_country").i();
            bVar.i = n3.u(AnalyticsConstants.TIMEZONE).i();
            bVar.e = n3.u("set_tags").a(false);
            bVar.f = hashSet;
            if (n5.isEmpty()) {
                n5 = null;
            }
            bVar.g = n5;
            bVar.b(n4.u("user_id").i());
            bVar.r = n4.u("accengage_device_id").i();
            bVar.l = valueOf;
            bVar.m = n3.u(User.DEVICE_META_APP_VERSION_NAME).i();
            bVar.n = n3.u("sdk_version").i();
            bVar.o = n3.u(AnalyticsConstants.DEVICE_MODEL).i();
            bVar.p = valueOf2;
            bVar.q = n3.u(AnalyticsConstants.CARRIER).i();
            bVar.s = i2;
            bVar.t = n3.u("named_user_id").i();
            return bVar.a();
        }
        throw new xt5(hj1.R("Invalid channel payload: ", jsonValue));
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5 zt5;
        Set<String> set;
        zt5.b s2 = zt5.s();
        s2.f("device_type", this.h);
        zt5.b g2 = s2.g("set_tags", this.j).g("opt_in", this.f);
        g2.f("push_address", this.i);
        zt5.b g3 = g2.g(ProductPromotionsObject.KEY_BACKGROUND, this.g);
        g3.f(AnalyticsConstants.TIMEZONE, this.n);
        g3.f("locale_language", this.o);
        g3.f("locale_country", this.p);
        g3.f(User.DEVICE_META_APP_VERSION_NAME, this.r);
        g3.f("sdk_version", this.s);
        g3.f(AnalyticsConstants.DEVICE_MODEL, this.t);
        g3.f(AnalyticsConstants.CARRIER, this.v);
        g3.f("named_user_id", this.y);
        if ("android".equals(this.h) && this.x != null) {
            zt5.b s3 = zt5.s();
            s3.f("delivery_type", this.x);
            g3.e("android", s3.a());
        }
        Boolean bool = this.q;
        if (bool != null) {
            g3.g("location_settings", bool.booleanValue());
        }
        Integer num = this.u;
        if (num != null) {
            g3.c("android_api_version", num.intValue());
        }
        if (this.j && (set = this.k) != null) {
            g3.e("tags", JsonValue.x(set).f());
        }
        if (this.j && (zt5 = this.l) != null) {
            g3.e("tag_changes", JsonValue.x(zt5).h());
        }
        zt5.b s4 = zt5.s();
        s4.f("user_id", this.m);
        s4.f("accengage_device_id", this.w);
        zt5.b e = zt5.s().e("channel", g3.a());
        zt5 a2 = s4.a();
        if (!a2.isEmpty()) {
            e.e("identity_hints", a2);
        }
        return JsonValue.x(e.a());
    }

    public final zt5 c(Set<String> set) throws xt5 {
        HashSet hashSet = new HashSet();
        for (String str : this.k) {
            if (!set.contains(str)) {
                hashSet.add(str);
            }
        }
        HashSet hashSet2 = new HashSet();
        for (String str2 : set) {
            if (!this.k.contains(str2)) {
                hashSet2.add(str2);
            }
        }
        zt5.b s2 = zt5.s();
        if (!hashSet.isEmpty()) {
            s2.e("add", JsonValue.r(hashSet));
        }
        if (!hashSet2.isEmpty()) {
            s2.e("remove", JsonValue.r(hashSet2));
        }
        return s2.a();
    }

    public tp5 d(tp5 tp5) {
        Set<String> set;
        if (tp5 == null) {
            return this;
        }
        b bVar = new b(this);
        bVar.b(null);
        bVar.r = null;
        if (tp5.j && this.j && (set = tp5.k) != null) {
            if (set.equals(this.k)) {
                bVar.e = false;
                bVar.f = null;
            } else {
                try {
                    bVar.g = c(tp5.k);
                } catch (xt5 e) {
                    yj5.b(e, "ChannelRegistrationPayload - Failed to wrap tag changes to JsonMap", new Object[0]);
                }
            }
        }
        String str = this.y;
        if (str == null || hd3.R0(tp5.y, str)) {
            if (hd3.R0(tp5.p, this.p)) {
                bVar.k = null;
            }
            if (hd3.R0(tp5.o, this.o)) {
                bVar.j = null;
            }
            if (hd3.R0(tp5.n, this.n)) {
                bVar.i = null;
            }
            Boolean bool = tp5.q;
            if (bool != null && bool.equals(this.q)) {
                bVar.l = null;
            }
            if (hd3.R0(tp5.r, this.r)) {
                bVar.m = null;
            }
            if (hd3.R0(tp5.s, this.s)) {
                bVar.n = null;
            }
            if (hd3.R0(tp5.t, this.t)) {
                bVar.o = null;
            }
            if (hd3.R0(tp5.v, this.v)) {
                bVar.q = null;
            }
            Integer num = tp5.u;
            if (num != null && num.equals(this.u)) {
                bVar.p = null;
            }
        }
        return bVar.a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || tp5.class != obj.getClass()) {
            return false;
        }
        tp5 tp5 = (tp5) obj;
        if (this.f != tp5.f || this.g != tp5.g || this.j != tp5.j) {
            return false;
        }
        String str = this.h;
        if (str == null ? tp5.h != null : !str.equals(tp5.h)) {
            return false;
        }
        String str2 = this.i;
        if (str2 == null ? tp5.i != null : !str2.equals(tp5.i)) {
            return false;
        }
        Set<String> set = this.k;
        if (set == null ? tp5.k != null : !set.equals(tp5.k)) {
            return false;
        }
        zt5 zt5 = this.l;
        if (zt5 == null ? tp5.l != null : !zt5.equals(tp5.l)) {
            return false;
        }
        String str3 = this.m;
        if (str3 == null ? tp5.m != null : !str3.equals(tp5.m)) {
            return false;
        }
        String str4 = this.n;
        if (str4 == null ? tp5.n != null : !str4.equals(tp5.n)) {
            return false;
        }
        String str5 = this.o;
        if (str5 == null ? tp5.o != null : !str5.equals(tp5.o)) {
            return false;
        }
        String str6 = this.p;
        if (str6 == null ? tp5.p != null : !str6.equals(tp5.p)) {
            return false;
        }
        Boolean bool = this.q;
        if (bool == null ? tp5.q != null : !bool.equals(tp5.q)) {
            return false;
        }
        String str7 = this.r;
        if (str7 == null ? tp5.r != null : !str7.equals(tp5.r)) {
            return false;
        }
        String str8 = this.s;
        if (str8 == null ? tp5.s != null : !str8.equals(tp5.s)) {
            return false;
        }
        String str9 = this.t;
        if (str9 == null ? tp5.t != null : !str9.equals(tp5.t)) {
            return false;
        }
        Integer num = this.u;
        if (num == null ? tp5.u != null : !num.equals(tp5.u)) {
            return false;
        }
        String str10 = this.v;
        if (str10 == null ? tp5.v != null : !str10.equals(tp5.v)) {
            return false;
        }
        String str11 = this.w;
        if (str11 == null ? tp5.w != null : !str11.equals(tp5.w)) {
            return false;
        }
        String str12 = this.y;
        if (str12 == null ? tp5.y != null : !str12.equals(tp5.y)) {
            return false;
        }
        String str13 = this.x;
        String str14 = tp5.x;
        if (str13 != null) {
            return str13.equals(str14);
        }
        if (str14 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i2 = (((this.f ? 1 : 0) * 31) + (this.g ? 1 : 0)) * 31;
        String str = this.h;
        int i3 = 0;
        int hashCode = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.i;
        int hashCode2 = (((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.j ? 1 : 0)) * 31;
        Set<String> set = this.k;
        int hashCode3 = (hashCode2 + (set != null ? set.hashCode() : 0)) * 31;
        zt5 zt5 = this.l;
        int hashCode4 = (hashCode3 + (zt5 != null ? zt5.hashCode() : 0)) * 31;
        String str3 = this.m;
        int hashCode5 = (hashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.n;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.o;
        int hashCode7 = (hashCode6 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.p;
        int hashCode8 = (hashCode7 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Boolean bool = this.q;
        int hashCode9 = (hashCode8 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str7 = this.r;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.s;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.t;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Integer num = this.u;
        int hashCode13 = (hashCode12 + (num != null ? num.hashCode() : 0)) * 31;
        String str10 = this.v;
        int hashCode14 = (hashCode13 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.w;
        int hashCode15 = (hashCode14 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.y;
        int hashCode16 = (hashCode15 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.x;
        if (str13 != null) {
            i3 = str13.hashCode();
        }
        return hashCode16 + i3;
    }

    public String toString() {
        return b().toString();
    }
}
