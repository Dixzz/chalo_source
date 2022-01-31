package defpackage;

import app.zophop.models.mTicketing.VisualValidationActivationDetails;
import defpackage.yj1;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: g00  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class g00 implements yj1.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ y50 f1195a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;

    public /* synthetic */ g00(y50 y50, List list, List list2) {
        this.f1195a = y50;
        this.b = list;
        this.c = list2;
    }

    @Override // defpackage.yj1.b
    public final void a(Object obj) {
        y50 y50 = this.f1195a;
        List<VisualValidationActivationDetails> list = this.b;
        List<VisualValidationActivationDetails> list2 = this.c;
        String str = (String) obj;
        n86.e(y50, "this$0");
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("passSyncStatus")) {
                if (jSONObject.getBoolean("passSyncStatus")) {
                    y50.b.deleteSelectActivationDetails(list);
                } else {
                    ui1.m0(new ed1("visual validation pass punch sync failed", Long.MIN_VALUE));
                }
            }
            if (!jSONObject.has("ticketSyncStatus")) {
                return;
            }
            if (jSONObject.getBoolean("ticketSyncStatus")) {
                y50.b.deleteSelectActivationDetails(list2);
            } else {
                ui1.m0(new ed1("visual validation mTicket sync failed", Long.MIN_VALUE));
            }
        } catch (JSONException e) {
            hj1.P0("visual validation sync exception occurred", Long.MIN_VALUE, "reason", e.getMessage());
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
