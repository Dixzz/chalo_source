package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.ScanPayBookingDetails;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.scanPay.ScanPayPaymentActivity;
import app.zophop.ui.activities.UserProfileActivity;
import defpackage.ut;
import defpackage.xt;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: r80  reason: default package */
/* compiled from: ScanPayPaymentActivity */
public class r80 implements View.OnClickListener {
    public final /* synthetic */ ScanPayPaymentActivity f;

    public r80(ScanPayPaymentActivity scanPayPaymentActivity) {
        this.f = scanPayPaymentActivity;
    }

    public void onClick(View view) {
        JSONObject jSONObject;
        String obj = this.f._amountValEditText.getText().toString();
        this.f.k0();
        double parseDouble = Double.parseDouble(obj);
        String uuid = UUID.randomUUID().toString();
        ScanPayPaymentActivity scanPayPaymentActivity = this.f;
        double parseDouble2 = Double.parseDouble(this.f._amountValEditText.getText().toString());
        xt.t1 t1Var = xt.f3961a;
        scanPayPaymentActivity.n = new ScanPayTicket(uuid, parseDouble2, parseDouble - ((double) this.f.i0(obj)), t1Var.L().getUserId(), t1Var.n().a(), new ScanPayBookingDetails(this.f.o), this.f.p);
        if (!t1Var.L().m()) {
            Intent intent = new Intent(this.f, UserProfileActivity.class);
            ScanPayPaymentActivity scanPayPaymentActivity2 = this.f;
            ScanPayTicket scanPayTicket = scanPayPaymentActivity2.n;
            String str = scanPayPaymentActivity2.r;
            String str2 = null;
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lpVer", "v1");
                ut.a aVar = ut.f3552a;
                jSONObject2.put("appVer", 764);
                jSONObject2.put("ticketId", scanPayTicket.get_uuid());
                jSONObject2.put(SuperPassJsonKeys.FARE, scanPayTicket.get_fare());
                jSONObject2.put("userId", scanPayTicket.get_userId());
                jSONObject2.put("discountedFare", scanPayTicket.get_discountedFare());
                jSONObject2.put("deviceId", scanPayTicket.get_deviceId());
                jSONObject2.put(SuperPassJsonKeys.ORDER_ID, scanPayTicket.get_orderId());
                ScanPayBookingDetails scanPayBookingDetails = scanPayTicket.get_bookingDetails();
                try {
                    jSONObject = new JSONObject();
                    jSONObject.put("busInfo", scanPayBookingDetails.getBusInfo());
                } catch (JSONException unused) {
                    jSONObject = null;
                }
                jSONObject2.put("bookingDetails", jSONObject);
                jSONObject2.put("version", str);
                str2 = jSONObject2.toString();
            } catch (JSONException unused2) {
            }
            intent.putExtra("scanPayInfo", str2);
            intent.putExtra("src", "scanPay");
            this.f.startActivityForResult(intent, 123);
            return;
        }
        d20 c = t1Var.c();
        ScanPayPaymentActivity scanPayPaymentActivity3 = this.f;
        c.p0(scanPayPaymentActivity3.n, scanPayPaymentActivity3.r);
    }
}
