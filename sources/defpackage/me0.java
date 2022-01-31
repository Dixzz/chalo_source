package defpackage;

import app.zophop.models.mTicketing.MTicket;
import app.zophop.ui.activities.MTicketSelectionActivity;
import defpackage.xm0;
import java.util.HashMap;
import java.util.Map;

/* renamed from: me0  reason: default package */
/* compiled from: MTicketSelectionActivity */
public class me0 implements xm0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2362a;

    public me0(MTicketSelectionActivity mTicketSelectionActivity, String str) {
        this.f2362a = str;
    }

    @Override // defpackage.xm0.a
    public void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("reason for disabled product dialog popup", this.f2362a);
        MTicket mTicket = MTicketSelectionActivity.I;
        ed1 ed1 = new ed1("recent product error dialog rendered mTicket", Long.MIN_VALUE);
        for (Map.Entry entry : hashMap.entrySet()) {
            ed1.a((String) entry.getKey(), entry.getValue());
        }
        jz5.b().g(ed1);
    }

    @Override // defpackage.xm0.a
    public void b() {
    }
}
