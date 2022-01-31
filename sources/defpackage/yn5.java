package defpackage;

import android.net.Uri;
import android.util.Base64;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.perf.FirebasePerformance;
import com.rabbitmq.client.StringRpcServer;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.json.JsonValue;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: yn5  reason: default package */
/* compiled from: AuthApiClient */
public class yn5 {

    /* renamed from: a  reason: collision with root package name */
    public final kq5 f4072a;

    /* renamed from: yn5$a */
    /* compiled from: AuthApiClient */
    public class a implements uq5<bo5> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f4073a;
        public final /* synthetic */ long b;

        public a(yn5 yn5, String str, long j) {
            this.f4073a = str;
            this.b = j;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.uq5
        public bo5 a(int i, Map map, String str) throws Exception {
            if (!hd3.A1(i)) {
                return null;
            }
            String str2 = this.f4073a;
            long j = this.b;
            zt5 n = JsonValue.p(str).n();
            String i2 = n.u(AnalyticsConstants.TOKEN).i();
            long g = n.u("expires_in").g(0);
            if (i2 != null && g > 0) {
                return new bo5(str2, i2, j + g);
            }
            throw new xt5(hj1.S("Invalid response: ", str));
        }
    }

    public yn5(kq5 kq5) {
        this.f4072a = kq5;
    }

    public final String a(String str) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        Mac instance = Mac.getInstance("HmacSHA256");
        instance.init(new SecretKeySpec(this.f4072a.b.b.getBytes(StringRpcServer.STRING_ENCODING), "HmacSHA256"));
        return Base64.encodeToString(instance.doFinal((this.f4072a.b.f711a + ProductDiscountsObject.KEY_DELIMITER + str).getBytes(StringRpcServer.STRING_ENCODING)), 0);
    }

    public tq5<bo5> b(String str) throws rq5 {
        oq5 a2 = this.f4072a.b().a();
        Uri.Builder builder = a2.f2724a;
        if (builder != null) {
            builder.appendEncodedPath("api/auth/device");
        }
        Uri b = a2.b();
        try {
            String a3 = a(str);
            long currentTimeMillis = System.currentTimeMillis();
            qq5 qq5 = new qq5();
            qq5.d = FirebasePerformance.HttpMethod.GET;
            qq5.f2981a = b;
            qq5.d();
            qq5.e(this.f4072a);
            qq5.j.put("X-UA-Channel-ID", str);
            String str2 = "Bearer " + a3;
            if (str2 == null) {
                qq5.j.remove("Authorization");
            } else {
                qq5.j.put("Authorization", str2);
            }
            return qq5.b(new a(this, str, currentTimeMillis));
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException e) {
            throw new rq5("Unable to create bearer token.", e);
        }
    }
}
