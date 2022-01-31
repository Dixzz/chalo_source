package defpackage;

import android.widget.Toast;
import app.zophop.ui.activities.CheckoutActivity;
import com.razorpay.ValidationListener;
import java.util.ArrayList;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: sd0  reason: default package */
/* compiled from: CheckoutActivity */
public class sd0 implements ValidationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ JSONObject f3204a;
    public final /* synthetic */ CheckoutActivity b;

    public sd0(CheckoutActivity checkoutActivity, JSONObject jSONObject) {
        this.b = checkoutActivity;
        this.f3204a = jSONObject;
    }

    @Override // com.razorpay.ValidationListener
    public void onValidationError(Map<String, String> map) {
        CheckoutActivity checkoutActivity = this.b;
        StringBuilder i0 = hj1.i0("Validation Error: ");
        i0.append(map.get("field"));
        i0.append(" ");
        i0.append(map.get("description"));
        Toast.makeText(checkoutActivity, i0.toString(), 1).show();
    }

    @Override // com.razorpay.ValidationListener
    public void onValidationSuccess() {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.b.S);
            CheckoutActivity checkoutActivity = this.b;
            if (checkoutActivity.B != null) {
                checkoutActivity.z0(this.f3204a);
                return;
            }
            checkoutActivity.x0();
            xt.f3961a.c().r(arrayList);
        } catch (Exception unused) {
        }
    }
}
