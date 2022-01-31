package defpackage;

import android.net.Uri;
import com.google.firebase.perf.FirebasePerformance;
import com.urbanairship.json.JsonValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

/* renamed from: pl5  reason: default package */
/* compiled from: EventApiClient */
public class pl5 {

    /* renamed from: a  reason: collision with root package name */
    public final kq5 f2827a;

    /* renamed from: pl5$a */
    /* compiled from: EventApiClient */
    public class a implements uq5<sl5> {
        public a(pl5 pl5) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.uq5
        public sl5 a(int i, Map map, String str) throws Exception {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return new sl5(map);
        }
    }

    public pl5(kq5 kq5) {
        this.f2827a = kq5;
    }

    public tq5<sl5> a(Collection<String> collection, Map<String, String> map) throws rq5 {
        String str = this.f2827a.b().b;
        Uri uri = null;
        Uri.Builder buildUpon = str != null ? Uri.parse(str).buildUpon() : null;
        if (buildUpon != null) {
            buildUpon.appendEncodedPath("warp9/");
        }
        if (buildUpon != null) {
            uri = buildUpon.build();
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : collection) {
            try {
                arrayList.add(JsonValue.p(str2));
            } catch (xt5 e) {
                yj5.e(e, "EventApiClient - Invalid eventPayload.", new Object[0]);
            }
        }
        String yt5 = new yt5(arrayList).toString();
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = uri;
        qq5.e = yt5;
        qq5.f = "application/json";
        qq5.h = true;
        String format = String.format(Locale.US, "%.3f", Double.valueOf(((double) System.currentTimeMillis()) / 1000.0d));
        if (format == null) {
            qq5.j.remove("X-UA-Sent-At");
        } else {
            qq5.j.put("X-UA-Sent-At", format);
        }
        qq5.e(this.f2827a);
        qq5.j.putAll(map);
        yj5.a("Sending analytics events. Request: %s Events: %s", qq5, collection);
        tq5<sl5> b = qq5.b(new a(this));
        yj5.a("Analytics event response: %s", b);
        return b;
    }
}
