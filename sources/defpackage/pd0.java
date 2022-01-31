package defpackage;

import app.zophop.models.mTicketing.MPass;
import app.zophop.ui.activities.CashWebViewActivity;
import defpackage.xm0;
import java.util.HashMap;
import java.util.Map;

/* renamed from: pd0  reason: default package */
/* compiled from: CashWebViewActivity */
public class pd0 implements xm0.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f2793a;

    public pd0(CashWebViewActivity cashWebViewActivity, String str) {
        this.f2793a = str;
    }

    @Override // defpackage.xm0.a
    public void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("reason for disabled product dialog popup", this.f2793a);
        hashMap.put("renew disabled product source", CashWebViewActivity.class.getSimpleName());
        MPass mPass = CashWebViewActivity.r;
        ed1 ed1 = new ed1("renew disabled product error dialog rendered", Long.MIN_VALUE);
        for (Map.Entry entry : hashMap.entrySet()) {
            ed1.a((String) entry.getKey(), entry.getValue());
        }
        jz5.b().g(ed1);
    }

    @Override // defpackage.xm0.a
    public void b() {
    }
}
