package defpackage;

import androidx.appcompat.widget.RtlSpacingHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.util.Constants;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.UAirship;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: kl5  reason: default package */
/* compiled from: CustomEvent */
public class kl5 extends ll5 implements cu5 {
    public static final BigDecimal o = new BigDecimal(Integer.MAX_VALUE);
    public static final BigDecimal p = new BigDecimal((int) RtlSpacingHelper.UNDEFINED);
    public final String h;
    public final BigDecimal i;
    public final String j;
    public final String k;
    public final String l;
    public final String m;
    public final zt5 n;

    /* renamed from: kl5$b */
    /* compiled from: CustomEvent */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final String f2075a;
        public BigDecimal b;
        public String c;
        public String d;
        public String e;
        public String f;
        public Map<String, JsonValue> g = new HashMap();

        public b(String str) {
            this.f2075a = str;
        }
    }

    public kl5(b bVar, a aVar) {
        String str;
        String str2;
        this.h = bVar.f2075a;
        this.i = bVar.b;
        String str3 = null;
        if (hd3.G1(bVar.c)) {
            str = null;
        } else {
            str = bVar.c;
        }
        this.j = str;
        if (hd3.G1(bVar.d)) {
            str2 = null;
        } else {
            str2 = bVar.d;
        }
        this.k = str2;
        this.l = !hd3.G1(bVar.e) ? bVar.e : str3;
        this.m = bVar.f;
        this.n = new zt5(bVar.g);
    }

    @Override // defpackage.cu5
    public JsonValue b() {
        zt5.b s = zt5.s();
        s.f("event_name", this.h);
        s.f("interaction_id", this.l);
        s.f("interaction_type", this.k);
        s.f(FirebaseAnalytics.Param.TRANSACTION_ID, this.j);
        s.e(AnalyticsConstants.PROPERTIES, JsonValue.x(this.n));
        BigDecimal bigDecimal = this.i;
        if (bigDecimal != null) {
            s.i("event_value", Double.valueOf(bigDecimal.doubleValue()));
        }
        return JsonValue.x(s.a());
    }

    @Override // defpackage.ll5
    public final zt5 d() {
        zt5.b s = zt5.s();
        String str = UAirship.l().f.r;
        String str2 = UAirship.l().f.s;
        s.f("event_name", this.h);
        s.f("interaction_id", this.l);
        s.f("interaction_type", this.k);
        s.f(FirebaseAnalytics.Param.TRANSACTION_ID, this.j);
        s.f("template_type", null);
        BigDecimal bigDecimal = this.i;
        if (bigDecimal != null) {
            s.d("event_value", bigDecimal.movePointRight(6).longValue());
        }
        if (!hd3.G1(this.m)) {
            s.f("conversion_send_id", this.m);
        } else {
            s.f("conversion_send_id", str);
        }
        if (str2 != null) {
            s.f("conversion_metadata", str2);
        } else {
            s.f("last_received_metadata", UAirship.l().i.k.g("com.urbanairship.push.LAST_RECEIVED_METADATA", null));
        }
        if (((HashMap) this.n.n()).size() > 0) {
            s.e(AnalyticsConstants.PROPERTIES, this.n);
        }
        return s.a();
    }

    @Override // defpackage.ll5
    public final String f() {
        return "enhanced_custom_event";
    }

    @Override // defpackage.ll5
    public boolean g() {
        boolean z;
        boolean G1 = hd3.G1(this.h);
        Integer valueOf = Integer.valueOf((int) Constants.MAX_HOST_LENGTH);
        if (G1 || this.h.length() > 255) {
            yj5.c("Event name must not be null, empty, or larger than %s characters.", valueOf);
            z = false;
        } else {
            z = true;
        }
        BigDecimal bigDecimal = this.i;
        if (bigDecimal != null) {
            BigDecimal bigDecimal2 = o;
            if (bigDecimal.compareTo(bigDecimal2) > 0) {
                yj5.c("Event value is bigger than %s", bigDecimal2);
            } else {
                BigDecimal bigDecimal3 = this.i;
                BigDecimal bigDecimal4 = p;
                if (bigDecimal3.compareTo(bigDecimal4) < 0) {
                    yj5.c("Event value is smaller than %s", bigDecimal4);
                }
            }
            z = false;
        }
        String str = this.j;
        if (str != null && str.length() > 255) {
            yj5.c("Transaction ID is larger than %s characters.", valueOf);
            z = false;
        }
        String str2 = this.l;
        if (str2 != null && str2.length() > 255) {
            yj5.c("Interaction ID is larger than %s characters.", valueOf);
            z = false;
        }
        String str3 = this.k;
        if (str3 != null && str3.length() > 255) {
            yj5.c("Interaction type is larger than %s characters.", valueOf);
            z = false;
        }
        zt5 zt5 = this.n;
        Objects.requireNonNull(zt5);
        int length = JsonValue.x(zt5).toString().getBytes().length;
        if (length <= 65536) {
            return z;
        }
        yj5.c("Total custom properties size (%s bytes) exceeds maximum size of %s bytes.", Integer.valueOf(length), 65536);
        return false;
    }
}
