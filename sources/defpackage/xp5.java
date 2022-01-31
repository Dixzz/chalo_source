package defpackage;

import android.net.Uri;
import com.google.firebase.perf.FirebasePerformance;
import com.urbanairship.AirshipConfigOptions;
import defpackage.zt5;

/* renamed from: xp5  reason: default package */
/* compiled from: NamedUserApiClient */
public class xp5 {

    /* renamed from: a  reason: collision with root package name */
    public final kq5 f3951a;

    public xp5(kq5 kq5) {
        this.f3951a = kq5;
    }

    public tq5<Void> a(String str, String str2) throws rq5 {
        oq5 a2 = this.f3951a.b().a();
        Uri.Builder builder = a2.f2724a;
        if (builder != null) {
            builder.appendEncodedPath("api/named_users/associate/");
        }
        Uri b = a2.b();
        zt5.b s = zt5.s();
        s.f("channel_id", str2);
        s.f("device_type", c());
        s.f("named_user_id", str);
        zt5 a3 = s.a();
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = b;
        AirshipConfigOptions airshipConfigOptions = this.f3951a.b;
        String str3 = airshipConfigOptions.f711a;
        String str4 = airshipConfigOptions.b;
        qq5.b = str3;
        qq5.c = str4;
        qq5.f(a3);
        qq5.d();
        qq5.e(this.f3951a);
        return qq5.a();
    }

    public tq5<Void> b(String str) throws rq5 {
        oq5 a2 = this.f3951a.b().a();
        Uri.Builder builder = a2.f2724a;
        if (builder != null) {
            builder.appendEncodedPath("api/named_users/disassociate/");
        }
        Uri b = a2.b();
        zt5.b s = zt5.s();
        s.f("channel_id", str);
        s.f("device_type", c());
        zt5 a3 = s.a();
        qq5 qq5 = new qq5();
        qq5.d = FirebasePerformance.HttpMethod.POST;
        qq5.f2981a = b;
        AirshipConfigOptions airshipConfigOptions = this.f3951a.b;
        String str2 = airshipConfigOptions.f711a;
        String str3 = airshipConfigOptions.b;
        qq5.b = str2;
        qq5.c = str3;
        qq5.f(a3);
        qq5.d();
        qq5.e(this.f3951a);
        return qq5.a();
    }

    public String c() throws rq5 {
        int a2 = this.f3951a.a();
        if (a2 == 1) {
            return "amazon";
        }
        if (a2 == 2) {
            return "android";
        }
        throw new rq5("Invalid platform");
    }
}
