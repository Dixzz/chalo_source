package defpackage;

import android.net.Uri;
import com.google.firebase.perf.FirebasePerformance;
import com.rabbitmq.client.ConnectionFactory;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: tu5  reason: default package */
/* compiled from: InboxApiClient */
public class tu5 {

    /* renamed from: a  reason: collision with root package name */
    public final kq5 f3409a;

    /* renamed from: tu5$a */
    /* compiled from: InboxApiClient */
    public class a implements uq5<yt5> {
        public a(tu5 tu5) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.uq5
        public yt5 a(int i, Map map, String str) throws Exception {
            if (!hd3.A1(i)) {
                return null;
            }
            yt5 f = JsonValue.p(str).n().u("messages").f();
            if (f != null) {
                return f;
            }
            throw new xt5("Invalid response, missing messages.");
        }
    }

    /* renamed from: tu5$b */
    /* compiled from: InboxApiClient */
    public class b implements uq5<lv5> {
        public b(tu5 tu5) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.uq5
        public lv5 a(int i, Map map, String str) throws Exception {
            if (!hd3.A1(i)) {
                return null;
            }
            zt5 h = JsonValue.p(str).h();
            if (h != null) {
                String i2 = h.u("user_id").i();
                String i3 = h.u("password").i();
                if (!hd3.G1(i2) && !hd3.G1(i3)) {
                    return new lv5(i2, i3);
                }
                throw new xt5("InboxApiClient - Invalid response, missing credentials.");
            }
            throw new xt5("InboxApiClient - Invalid response, missing credentials.");
        }
    }

    public tu5(kq5 kq5) {
        this.f3409a = kq5;
    }

    public tq5<lv5> a(String str) throws rq5 {
        Uri d = d(this.f3409a.b(), new String[0]);
        HashMap hashMap = new HashMap();
        hashMap.put(c(), Collections.singletonList(str));
        String jsonValue = JsonValue.x(hashMap).toString();
        yj5.h("Creating Rich Push user with payload: %s", jsonValue);
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = d;
        AirshipConfigOptions airshipConfigOptions = this.f3409a.b;
        String str2 = airshipConfigOptions.f711a;
        String str3 = airshipConfigOptions.b;
        qq5.b = str2;
        qq5.c = str3;
        qq5.e = jsonValue;
        qq5.f = "application/json";
        qq5.d();
        qq5.e(this.f3409a);
        return qq5.b(new b(this));
    }

    public tq5<yt5> b(kv5 kv5, String str, long j) throws rq5 {
        Uri d = d(this.f3409a.b(), kv5.b(), "messages/");
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.GET;
        qq5.f2981a = d;
        String b2 = kv5.b();
        String c = kv5.c();
        qq5.b = b2;
        qq5.c = c;
        qq5.d();
        qq5.e(this.f3409a);
        if (str == null) {
            qq5.j.remove("X-UA-Channel-ID");
        } else {
            qq5.j.put("X-UA-Channel-ID", str);
        }
        qq5.g = j;
        return qq5.b(new a(this));
    }

    public final String c() throws rq5 {
        int a2 = this.f3409a.a();
        if (a2 == 1) {
            return "amazon_channels";
        }
        if (a2 == 2) {
            return "android_channels";
        }
        throw new rq5("Invalid platform");
    }

    public final Uri d(lq5 lq5, String... strArr) {
        oq5 a2 = lq5.a();
        Uri.Builder builder = a2.f2724a;
        if (builder != null) {
            builder.appendEncodedPath("api/user/");
        }
        for (String str : strArr) {
            if (!str.endsWith(ConnectionFactory.DEFAULT_VHOST)) {
                str = hj1.S(str, ConnectionFactory.DEFAULT_VHOST);
            }
            a2.a(str);
        }
        return a2.b();
    }

    public tq5<Void> e(kv5 kv5, String str, List<JsonValue> list) throws rq5 {
        Uri d = d(this.f3409a.b(), kv5.b(), "messages/delete/");
        zt5.b s = zt5.s();
        s.e("messages", JsonValue.x(list));
        zt5 a2 = s.a();
        yj5.h("Deleting inbox messages with payload: %s", a2);
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = d;
        String b2 = kv5.b();
        String c = kv5.c();
        qq5.b = b2;
        qq5.c = c;
        qq5.e = a2.toString();
        qq5.f = "application/json";
        if (str == null) {
            qq5.j.remove("X-UA-Channel-ID");
        } else {
            qq5.j.put("X-UA-Channel-ID", str);
        }
        qq5.d();
        qq5.e(this.f3409a);
        return qq5.a();
    }

    public tq5<Void> f(kv5 kv5, String str, List<JsonValue> list) throws rq5 {
        Uri d = d(this.f3409a.b(), kv5.b(), "messages/unread/");
        zt5.b s = zt5.s();
        s.e("messages", JsonValue.x(list));
        zt5 a2 = s.a();
        yj5.h("Marking inbox messages read request with payload: %s", a2);
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = d;
        String b2 = kv5.b();
        String c = kv5.c();
        qq5.b = b2;
        qq5.c = c;
        qq5.e = a2.toString();
        qq5.f = "application/json";
        if (str == null) {
            qq5.j.remove("X-UA-Channel-ID");
        } else {
            qq5.j.put("X-UA-Channel-ID", str);
        }
        qq5.j.put("Accept", "application/vnd.urbanairship+json; version=3;");
        return qq5.a();
    }

    public tq5<Void> g(kv5 kv5, String str) throws rq5 {
        Uri d = d(this.f3409a.b(), kv5.b());
        HashMap hashMap = new HashMap();
        hashMap.put("add", Collections.singletonList(str));
        HashMap hashMap2 = new HashMap();
        hashMap2.put(c(), hashMap);
        String jsonValue = JsonValue.x(hashMap2).toString();
        yj5.h("Updating user with payload: %s", jsonValue);
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = d;
        String b2 = kv5.b();
        String c = kv5.c();
        qq5.b = b2;
        qq5.c = c;
        qq5.e = jsonValue;
        qq5.f = "application/json";
        qq5.d();
        qq5.e(this.f3409a);
        return qq5.a();
    }
}
