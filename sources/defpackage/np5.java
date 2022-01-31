package defpackage;

import android.net.Uri;
import com.google.firebase.perf.FirebasePerformance;
import com.urbanairship.AirshipConfigOptions;
import defpackage.zt5;
import java.util.List;

/* renamed from: np5  reason: default package */
/* compiled from: AttributeApiClient */
public class np5 {
    public static final c c = new a();
    public static final c d = new b();

    /* renamed from: a  reason: collision with root package name */
    public final kq5 f2591a;
    public final c b;

    /* renamed from: np5$a */
    /* compiled from: AttributeApiClient */
    public static class a implements c {
        @Override // defpackage.np5.c
        public Uri a(kq5 kq5, String str) {
            oq5 a2 = kq5.b().a();
            Uri.Builder builder = a2.f2724a;
            if (builder != null) {
                builder.appendEncodedPath("api/named_users/");
            }
            Uri.Builder builder2 = a2.f2724a;
            if (builder2 != null) {
                builder2.appendPath(str);
            }
            Uri.Builder builder3 = a2.f2724a;
            if (builder3 != null) {
                builder3.appendPath("attributes");
            }
            return a2.b();
        }
    }

    /* renamed from: np5$b */
    /* compiled from: AttributeApiClient */
    public static class b implements c {
        @Override // defpackage.np5.c
        public Uri a(kq5 kq5, String str) {
            String str2 = kq5.a() == 1 ? "amazon" : "android";
            oq5 a2 = kq5.b().a();
            Uri.Builder builder = a2.f2724a;
            if (builder != null) {
                builder.appendEncodedPath("api/channels/");
            }
            Uri.Builder builder2 = a2.f2724a;
            if (builder2 != null) {
                builder2.appendPath(str);
            }
            Uri.Builder builder3 = a2.f2724a;
            if (builder3 != null) {
                builder3.appendPath("attributes");
            }
            Uri.Builder builder4 = a2.f2724a;
            if (builder4 != null) {
                builder4.appendQueryParameter("platform", str2);
            }
            return a2.b();
        }
    }

    /* renamed from: np5$c */
    /* compiled from: AttributeApiClient */
    public interface c {
        Uri a(kq5 kq5, String str);
    }

    public np5(kq5 kq5, sq5 sq5, c cVar) {
        this.f2591a = kq5;
        this.b = cVar;
    }

    public tq5<Void> a(String str, List<qp5> list) throws rq5 {
        Uri a2 = this.b.a(this.f2591a, str);
        zt5.b s = zt5.s();
        s.i("attributes", list);
        zt5 a3 = s.a();
        yj5.h("Updating attributes for Id:%s with payload: %s", str, a3);
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = a2;
        qq5.e(this.f2591a);
        AirshipConfigOptions airshipConfigOptions = this.f2591a.b;
        String str2 = airshipConfigOptions.f711a;
        String str3 = airshipConfigOptions.b;
        qq5.b = str2;
        qq5.c = str3;
        qq5.f(a3);
        qq5.d();
        return qq5.a();
    }
}
