package defpackage;

import com.freshchat.consumer.sdk.beans.User;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.ArrayList;
import java.util.List;

/* renamed from: fm5  reason: default package */
/* compiled from: Audience */
public class fm5 implements cu5 {
    public final Boolean f;
    public final Boolean g;
    public final Boolean h;
    public final List<String> i;
    public final List<String> j;
    public final ip5 k;
    public final bu5 l;
    public final String m;

    /* renamed from: fm5$b */
    /* compiled from: Audience */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Boolean f1141a;
        public Boolean b;
        public Boolean c;
        public final List<String> d = new ArrayList();
        public final List<String> e = new ArrayList();
        public String f = "penalize";
        public ip5 g;
        public bu5 h;

        public b(a aVar) {
        }
    }

    public fm5(b bVar, a aVar) {
        this.f = bVar.f1141a;
        this.g = bVar.b;
        this.h = bVar.c;
        this.i = bVar.d;
        this.k = bVar.g;
        this.l = bVar.h;
        this.j = bVar.e;
        this.m = bVar.f;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01f3, code lost:
        if (r2.equals("cancel") == false) goto L_0x01f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static defpackage.fm5 a(com.urbanairship.json.JsonValue r9) throws defpackage.xt5 {
        /*
        // Method dump skipped, instructions count: 588
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fm5.a(com.urbanairship.json.JsonValue):fm5");
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.i("new_user", this.f);
        s.i("notification_opt_in", this.g);
        s.i("location_opt_in", this.h);
        JsonValue jsonValue = null;
        zt5.b e = s.e(AnalyticsConstants.LOCALE, this.i.isEmpty() ? null : JsonValue.x(this.i));
        if (!this.j.isEmpty()) {
            jsonValue = JsonValue.x(this.j);
        }
        zt5.b e2 = e.e("test_devices", jsonValue).e("tags", this.k).e(User.DEVICE_META_APP_VERSION_NAME, this.l);
        e2.f("miss_behavior", this.m);
        return JsonValue.x(e2.a());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || fm5.class != obj.getClass()) {
            return false;
        }
        fm5 fm5 = (fm5) obj;
        Boolean bool = this.f;
        if (bool == null ? fm5.f != null : !bool.equals(fm5.f)) {
            return false;
        }
        Boolean bool2 = this.g;
        if (bool2 == null ? fm5.g != null : !bool2.equals(fm5.g)) {
            return false;
        }
        Boolean bool3 = this.h;
        if (bool3 == null ? fm5.h != null : !bool3.equals(fm5.h)) {
            return false;
        }
        List<String> list = this.i;
        if (list == null ? fm5.i != null : !list.equals(fm5.i)) {
            return false;
        }
        ip5 ip5 = this.k;
        if (ip5 == null ? fm5.k != null : !ip5.equals(fm5.k)) {
            return false;
        }
        String str = this.m;
        if (str == null ? fm5.m != null : !str.equals(fm5.m)) {
            return false;
        }
        bu5 bu5 = this.l;
        bu5 bu52 = fm5.l;
        if (bu5 != null) {
            return bu5.equals(bu52);
        }
        if (bu52 == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        Boolean bool = this.f;
        int i2 = 0;
        int hashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.g;
        int hashCode2 = (hashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.h;
        int hashCode3 = (hashCode2 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        List<String> list = this.i;
        int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        ip5 ip5 = this.k;
        int hashCode5 = (hashCode4 + (ip5 != null ? ip5.hashCode() : 0)) * 31;
        bu5 bu5 = this.l;
        int hashCode6 = (hashCode5 + (bu5 != null ? bu5.hashCode() : 0)) * 31;
        String str = this.m;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode6 + i2;
    }
}
