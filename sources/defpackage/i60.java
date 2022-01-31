package defpackage;

import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.pubsub.eventbus.events.DigitalTripReceiptHistoryFetchedEvent;
import app.zophop.room.DigitalTripReceiptRepository;
import defpackage.yj1;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: i60  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class i60 implements yj1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1481a;
    public final /* synthetic */ SuperPass b;
    public final /* synthetic */ List c;

    public /* synthetic */ i60(List list, SuperPass superPass, List list2) {
        this.f1481a = list;
        this.b = superPass;
        this.c = list2;
    }

    @Override // defpackage.yj1.b
    public final void a(Object obj) {
        List<ProductActivationDetails> list = this.f1481a;
        SuperPass superPass = this.b;
        List<ProductActivationDetails> list2 = this.c;
        String str = (String) obj;
        gi1 gi1 = gi1.f1265a;
        n86.e(superPass, "$lSuperPass");
        try {
            JSONObject jSONObject = new JSONObject(str);
            n86.j("syncActivationsAndFetchSuperPassTripReceipts: response 2 = ", jSONObject);
            if (jSONObject.has("passSyncStatus")) {
                if (jSONObject.getBoolean("passSyncStatus")) {
                    xt.f3961a.q().deleteSelectActivationDetails(list);
                } else {
                    ed1 ed1 = new ed1("product activation sync failed", Long.MIN_VALUE);
                    ed1.a("productType", SuperPassConstants.PRODUCT_TYPE_SUPER_PASS);
                    ui1.m0(ed1);
                }
            }
            if (jSONObject.has(DigitalTripReceiptJsonKeys.KEY_PASS_TRIP_HISTORY)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(DigitalTripReceiptJsonKeys.KEY_PASS_TRIP_HISTORY);
                DigitalTripReceiptRepository q = xt.f3961a.q();
                n86.d(jSONObject2, "lHistory");
                q.updateSuperPassTripReceiptTable(jSONObject2);
                ed1 ed12 = new ed1("superPass trip receipt history fetched", Long.MIN_VALUE);
                gi1.f(ed12, superPass);
                ui1.m0(ed12);
            } else {
                jz5.b().i(new DigitalTripReceiptHistoryFetchedEvent(ad1.SUCCESS, null, 2, null));
                ed1 ed13 = new ed1("superPass trip receipt history fetch failed", Long.MIN_VALUE);
                ed13.a("error message", "no history sent");
                gi1.f(ed13, superPass);
                ui1.m0(ed13);
            }
            if (!jSONObject.has("ticketSyncStatus")) {
                return;
            }
            if (jSONObject.getBoolean("ticketSyncStatus")) {
                xt.f3961a.q().deleteSelectActivationDetails(list2);
                return;
            }
            ed1 ed14 = new ed1("product activation sync failed", Long.MIN_VALUE);
            ed14.a("productType", "mTicket");
            ui1.m0(ed14);
        } catch (JSONException e) {
            n86.j("syncActivationsAndFetchSuperPassTripReceipts: responseException 2 = ", e);
            jz5 b2 = jz5.b();
            ad1 ad1 = ad1.FAILED;
            String message = e.getMessage();
            if (message == null) {
                message = "";
            }
            b2.i(new DigitalTripReceiptHistoryFetchedEvent(ad1, message));
            hj1.P0("product activation sync exception occurred", Long.MIN_VALUE, "reason", e.getMessage());
            String message2 = e.getMessage();
            ed1 ed15 = new ed1("superPass trip receipt history fetch failed", Long.MIN_VALUE);
            if (message2 == null) {
                message2 = new String();
            }
            ed15.a("error message", message2);
            gi1.f(ed15, superPass);
            ui1.m0(ed15);
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
