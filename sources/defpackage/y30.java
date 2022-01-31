package defpackage;

import android.app.Activity;
import android.content.Context;
import com.razorpay.Razorpay;

/* renamed from: y30  reason: default package */
/* compiled from: RazorpayFeature */
public class y30 implements u20 {

    /* renamed from: a  reason: collision with root package name */
    public Razorpay f3994a;

    public y30(Context context) {
    }

    @Override // defpackage.u20
    public void a(Activity activity) {
        this.f3994a = new Razorpay(activity);
    }

    @Override // defpackage.u20
    public Razorpay b() {
        return this.f3994a;
    }
}
