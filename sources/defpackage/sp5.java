package defpackage;

import android.net.Uri;
import com.google.firebase.perf.FirebasePerformance;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.json.JsonValue;
import java.util.Map;

/* renamed from: sp5  reason: default package */
/* compiled from: ChannelApiClient */
public class sp5 {

    /* renamed from: a  reason: collision with root package name */
    public final kq5 f3241a;

    /* renamed from: sp5$a */
    /* compiled from: ChannelApiClient */
    public class a implements uq5<String> {
        public a(sp5 sp5) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.uq5
        public String a(int i, Map map, String str) throws Exception {
            if (hd3.A1(i)) {
                return JsonValue.p(str).n().u("channel_id").i();
            }
            return null;
        }
    }

    public sp5(kq5 kq5) {
        this.f3241a = kq5;
    }

    public tq5<String> a(tp5 tp5) throws rq5 {
        yj5.h("Creating channel with payload: %s", tp5);
        qq5 qq5 = new qq5();
        Uri b = b(null);
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = b;
        AirshipConfigOptions airshipConfigOptions = this.f3241a.b;
        String str = airshipConfigOptions.f711a;
        String str2 = airshipConfigOptions.b;
        qq5.b = str;
        qq5.c = str2;
        qq5.f(tp5);
        qq5.d();
        qq5.e(this.f3241a);
        return qq5.b(new a(this));
    }

    public final Uri b(String str) {
        Uri.Builder builder;
        oq5 a2 = this.f3241a.b().a();
        Uri.Builder builder2 = a2.f2724a;
        if (builder2 != null) {
            builder2.appendEncodedPath("api/channels/");
        }
        if (!(str == null || (builder = a2.f2724a) == null)) {
            builder.appendPath(str);
        }
        return a2.b();
    }

    public tq5<Void> c(String str, tp5 tp5) throws rq5 {
        yj5.h("Updating channel with payload: %s", tp5);
        qq5 qq5 = new qq5();
        Uri b = b(str);
        qq5.d = FirebasePerformance.HttpMethod.PUT;
        qq5.f2981a = b;
        AirshipConfigOptions airshipConfigOptions = this.f3241a.b;
        String str2 = airshipConfigOptions.f711a;
        String str3 = airshipConfigOptions.b;
        qq5.b = str2;
        qq5.c = str3;
        qq5.f(tp5);
        qq5.d();
        qq5.e(this.f3241a);
        return qq5.a();
    }
}
