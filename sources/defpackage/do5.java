package defpackage;

import android.content.pm.PackageInfo;
import android.net.Uri;
import com.google.firebase.perf.FirebasePerformance;
import com.urbanairship.UAirship;
import com.urbanairship.automation.Trigger;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* renamed from: do5  reason: default package */
/* compiled from: DeferredScheduleClient */
public class do5 {

    /* renamed from: a  reason: collision with root package name */
    public final kq5 f869a;
    public final ao5 b;
    public final jp5<eo5> c;

    /* renamed from: do5$a */
    /* compiled from: DeferredScheduleClient */
    public class a implements jp5<eo5> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.jp5
        public eo5 get() {
            vv5 vv5 = UAirship.l().i;
            Locale a2 = UAirship.l().r.a();
            PackageInfo e = UAirship.e();
            String str = e != null ? e.versionName : "";
            Object obj = UAirship.t;
            return new eo5(str, "14.6.0", vv5.n(), a2);
        }
    }

    /* renamed from: do5$b */
    /* compiled from: DeferredScheduleClient */
    public class b implements uq5<c> {
        public b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.uq5
        public c a(int i, Map map, String str) throws Exception {
            InAppMessage inAppMessage = null;
            if (!hd3.A1(i)) {
                return null;
            }
            Objects.requireNonNull(do5.this);
            zt5 n = JsonValue.p(str).n();
            boolean a2 = n.u("audience_match").a(false);
            if (a2 && n.u("type").o().equals("in_app_message")) {
                inAppMessage = InAppMessage.a(n.u("message"), "remote-data");
            }
            return new c(a2, inAppMessage);
        }
    }

    /* renamed from: do5$c */
    /* compiled from: DeferredScheduleClient */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f871a;
        public final InAppMessage b;

        public c(boolean z, InAppMessage inAppMessage) {
            this.f871a = z;
            this.b = inAppMessage;
        }
    }

    public do5(kq5 kq5, ao5 ao5) {
        a aVar = new a();
        this.f869a = kq5;
        this.b = ao5;
        this.c = aVar;
    }

    public tq5<c> a(Uri uri, String str, pn5 pn5, List<jq5> list, List<qp5> list2) throws rq5, zn5 {
        String a2 = this.b.a();
        zt5.b s = zt5.s();
        s.f("platform", this.f869a.a() == 1 ? "amazon" : "android");
        s.f("channel_id", str);
        if (pn5 != null) {
            zt5.b s2 = zt5.s();
            s2.f("type", Trigger.a(pn5.f.f));
            zt5.b b2 = s2.b("goal", pn5.f.g);
            b2.e("event", pn5.g);
            s.e("trigger", b2.a());
        }
        if (!list.isEmpty()) {
            s.e("tag_overrides", JsonValue.x(list));
        }
        if (!list2.isEmpty()) {
            s.e("attribute_overrides", JsonValue.x(list2));
        }
        s.e("state_overrides", this.c.get());
        zt5 a3 = s.a();
        tq5<c> b3 = b(uri, a2, a3);
        if (b3.c != 401) {
            return b3;
        }
        ao5 ao5 = this.b;
        synchronized (ao5.f271a) {
            if (a2.equals(ao5.d.b)) {
                ao5.d = null;
            }
        }
        return b(uri, this.b.a(), a3);
    }

    public final tq5<c> b(Uri uri, String str, zt5 zt5) throws rq5 {
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = uri;
        qq5.e(this.f869a);
        String str2 = "Bearer " + str;
        if (str2 == null) {
            qq5.j.remove("Authorization");
        } else {
            qq5.j.put("Authorization", str2);
        }
        qq5.d();
        qq5.f(zt5);
        return qq5.b(new b());
    }
}
