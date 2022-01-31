package defpackage;

import android.view.View;
import app.zophop.models.universalPass.UniversalPassInfo;
import app.zophop.ui.activities.WebViewActivity;
import defpackage.bv;
import java.util.Map;

/* renamed from: av  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class av implements View.OnClickListener {
    public final /* synthetic */ bv.c f;
    public final /* synthetic */ UniversalPassInfo g;
    public final /* synthetic */ bv h;

    public /* synthetic */ av(bv.c cVar, UniversalPassInfo universalPassInfo, bv bvVar) {
        this.f = cVar;
        this.g = universalPassInfo;
        this.h = bvVar;
    }

    public final void onClick(View view) {
        bv.c cVar = this.f;
        UniversalPassInfo universalPassInfo = this.g;
        bv bvVar = this.h;
        n86.e(cVar, "this$0");
        n86.e(universalPassInfo, "$lUniversalPassInfo");
        n86.e(bvVar, "this$1");
        Map o = y56.o(new m56("card position", Integer.valueOf(cVar.getBindingAdapterPosition())), new m56("universal pass user name", universalPassInfo.getName()), new m56("universal pass user id", universalPassInfo.getBeneficiaryId()));
        n86.e("universal pass item clicked", "lEventName");
        n86.e("universal pass info adapter", "lSource");
        ed1 ed1 = new ed1("universal pass item clicked", Long.MIN_VALUE);
        ed1.a("source", "universal pass info adapter");
        for (Map.Entry entry : o.entrySet()) {
            ed1.a((String) entry.getKey(), entry.getValue());
        }
        ui1.m0(ed1);
        WebViewActivity.h0(bvVar.c, universalPassInfo.getUrl(), universalPassInfo.getName(), false, false);
    }
}
