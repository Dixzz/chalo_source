package defpackage;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.google.firebase.messaging.Constants;
import com.urbanairship.json.JsonValue;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: wu5  reason: default package */
/* compiled from: Message */
public class wu5 implements Comparable<wu5> {
    public boolean f;
    public Map<String, String> g;
    public long h;
    public Long i;
    public String j;
    public String k;
    public String l;
    public String m;
    public JsonValue n;
    public String o;
    public JsonValue p;
    public boolean q = false;
    public boolean r;

    public static wu5 a(JsonValue jsonValue, boolean z, boolean z2) {
        String i2;
        String i3;
        String i4;
        String i5;
        zt5 h2 = jsonValue.h();
        if (h2 == null || (i2 = h2.u(Constants.MessagePayloadKeys.MSGID_SERVER).i()) == null || (i3 = h2.u("message_url").i()) == null || (i4 = h2.u("message_body_url").i()) == null || (i5 = h2.u("message_read_url").i()) == null) {
            return null;
        }
        wu5 wu5 = new wu5();
        wu5.j = i2;
        wu5.k = i3;
        wu5.l = i4;
        wu5.m = i5;
        wu5.n = h2.f.get("message_reporting");
        wu5.o = h2.u(ProductPromotionsObject.KEY_TITLE).o();
        wu5.f = h2.u("unread").a(true);
        wu5.p = jsonValue;
        String i6 = h2.u("message_sent").i();
        if (hd3.G1(i6)) {
            wu5.h = System.currentTimeMillis();
        } else {
            wu5.h = ly5.c(i6, System.currentTimeMillis());
        }
        String i7 = h2.u("message_expiry").i();
        if (!hd3.G1(i7)) {
            wu5.i = Long.valueOf(ly5.c(i7, Long.MAX_VALUE));
        }
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<String, JsonValue>> it = h2.u("extra").n().iterator();
        while (it.hasNext()) {
            Map.Entry<String, JsonValue> next = it.next();
            if (next.getValue().f instanceof String) {
                hashMap.put(next.getKey(), next.getValue().i());
            } else {
                hashMap.put(next.getKey(), next.getValue().toString());
            }
        }
        wu5.g = hashMap;
        wu5.q = z2;
        wu5.r = z;
        return wu5;
    }

    public boolean c() {
        return this.i != null && System.currentTimeMillis() >= this.i.longValue();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(wu5 wu5) {
        return this.j.compareTo(wu5.j);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof wu5)) {
            return false;
        }
        wu5 wu5 = (wu5) obj;
        if (this == wu5) {
            return true;
        }
        String str = this.j;
        if (str == null) {
            if (wu5.j != null) {
                return false;
            }
        } else if (!str.equals(wu5.j)) {
            return false;
        }
        String str2 = this.l;
        if (str2 == null) {
            if (wu5.l != null) {
                return false;
            }
        } else if (!str2.equals(wu5.l)) {
            return false;
        }
        String str3 = this.m;
        if (str3 == null) {
            if (wu5.m != null) {
                return false;
            }
        } else if (!str3.equals(wu5.m)) {
            return false;
        }
        String str4 = this.k;
        if (str4 == null) {
            if (wu5.k != null) {
                return false;
            }
        } else if (!str4.equals(wu5.k)) {
            return false;
        }
        Map<String, String> map = this.g;
        if (map == null) {
            if (wu5.g != null) {
                return false;
            }
        } else if (!map.equals(wu5.g)) {
            return false;
        }
        if (this.r == wu5.r && this.f == wu5.f && this.q == wu5.q && this.h == wu5.h) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        String str = this.j;
        int i2 = 0;
        int hashCode = (629 + (str == null ? 0 : str.hashCode())) * 37;
        String str2 = this.l;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 37;
        String str3 = this.m;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 37;
        String str4 = this.k;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 37;
        Map<String, String> map = this.g;
        if (map != null) {
            i2 = map.hashCode();
        }
        return Long.valueOf(this.h).hashCode() + ((((((((hashCode4 + i2) * 37) + (!this.r ? 1 : 0)) * 37) + (!this.f ? 1 : 0)) * 37) + (!this.q ? 1 : 0)) * 37);
    }
}
