package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.ProductFareMapping;
import defpackage.lu;

/* renamed from: du  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class du implements View.OnClickListener {
    public final /* synthetic */ lu f;
    public final /* synthetic */ ProductFareMapping g;
    public final /* synthetic */ lu.b h;

    public /* synthetic */ du(lu luVar, ProductFareMapping productFareMapping, lu.b bVar) {
        this.f = luVar;
        this.g = productFareMapping;
        this.h = bVar;
    }

    public final void onClick(View view) {
        lu luVar = this.f;
        ProductFareMapping productFareMapping = this.g;
        lu.b bVar = this.h;
        n86.e(luVar, "this$0");
        n86.e(productFareMapping, "$fareMapping");
        n86.e(bVar, "this$1");
        luVar.e = Integer.valueOf(productFareMapping.getFareMappingId());
        bVar.b.a(productFareMapping.getFareMappingId());
        bVar.f2271a.e.setChecked(true);
        luVar.notifyDataSetChanged();
    }
}
