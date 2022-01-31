package defpackage;

import app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import defpackage.yj1;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: j60  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class j60 implements yj1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f1881a;
    public final /* synthetic */ List b;

    public /* synthetic */ j60(List list, List list2) {
        this.f1881a = list;
        this.b = list2;
    }

    @Override // defpackage.yj1.b
    public final void a(Object obj) {
        List<ProductActivationDetails> list = this.f1881a;
        List<ProductActivationDetails> list2 = this.b;
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            n86.j("syncActivationsAndFetchSuperPassTripReceipts 1: response = ", jSONObject);
            if (jSONObject.has("passSyncStatus")) {
                if (jSONObject.getBoolean("passSyncStatus")) {
                    xt.f3961a.q().deleteSelectActivationDetails(list);
                } else {
                    ed1 ed1 = new ed1("product activation sync failed", Long.MIN_VALUE);
                    ed1.a("productType", SuperPassConstants.PRODUCT_TYPE_SUPER_PASS);
                    ui1.m0(ed1);
                }
            }
            if (!jSONObject.has("ticketSyncStatus")) {
                return;
            }
            if (jSONObject.getBoolean("ticketSyncStatus")) {
                xt.f3961a.q().deleteSelectActivationDetails(list2);
                return;
            }
            ed1 ed12 = new ed1("product activation sync failed", Long.MIN_VALUE);
            ed12.a("productType", "mTicket");
            ui1.m0(ed12);
        } catch (JSONException e) {
            n86.j("syncActivationsAndFetchSuperPassTripReceipts 1: responseException = ", e);
            hj1.P0("product activation sync exception occurred", Long.MIN_VALUE, "reason", e.getMessage());
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
