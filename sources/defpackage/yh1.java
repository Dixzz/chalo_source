package defpackage;

import defpackage.n00;
import java.util.concurrent.CountDownLatch;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: yh1  reason: default package */
/* compiled from: FirebaseCallManager */
public class yh1 implements n00.z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f4046a;
    public final /* synthetic */ JSONObject[] b;
    public final /* synthetic */ CountDownLatch c;

    public yh1(String str, JSONObject[] jSONObjectArr, CountDownLatch countDownLatch) {
        this.f4046a = str;
        this.b = jSONObjectArr;
        this.c = countDownLatch;
    }

    @Override // defpackage.n00.z0
    public void a(dk1 dk1) {
        try {
            if (this.f4046a != null) {
                this.b[0] = new JSONObject(this.f4046a);
            }
        } catch (JSONException e) {
            ai1.d("volley error");
            b00 b00 = b00.f358a;
            hj1.X0(e, b00.a());
        }
        CountDownLatch countDownLatch = this.c;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }
}
