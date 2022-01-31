package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.scanPay.ScanPayBaseActivity;
import app.zophop.ui.activities.MTicketTripInfoActivity;
import defpackage.ak0;

/* renamed from: ni0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class ni0 implements View.OnClickListener {
    public final /* synthetic */ ak0.d f;
    public final /* synthetic */ ak0 g;

    public /* synthetic */ ni0(ak0.d dVar, ak0 ak0) {
        this.f = dVar;
        this.g = ak0;
    }

    public final void onClick(View view) {
        Intent intent;
        ak0.d dVar = this.f;
        ak0 ak0 = this.g;
        n86.e(dVar, "this$0");
        n86.e(ak0, "this$1");
        int i = -1;
        if (dVar.getBindingAdapterPosition() != -1) {
            T t = ak0.f2701a.f.get(dVar.getBindingAdapterPosition());
            n86.d(t, "getItem(bindingAdapterPosition)");
            int bindingAdapterPosition = dVar.getBindingAdapterPosition();
            ed1 ed1 = new ed1("home screen product card clicked", Long.MIN_VALUE);
            ed1.a("card position", Integer.valueOf(bindingAdapterPosition));
            ed1.a("product group", t.name());
            ui1.m0(ed1);
            zz zzVar = new zz("product hook homescreen clicked", null, 2);
            zzVar.a("product type", t.name());
            ui1.l0(zzVar);
            T t2 = ak0.f2701a.f.get(dVar.getBindingAdapterPosition());
            if (t2 != null) {
                i = ak0.d.a.f172a[t2.ordinal()];
            }
            if (i == 1) {
                intent = new Intent(ak0.c, MTicketTripInfoActivity.class);
                intent.putExtra("src", "singleJourneyTicket");
            } else if (i == 2) {
                intent = new Intent(ak0.c, ScanPayBaseActivity.class);
                intent.putExtra("src", "scanPay");
            } else if (i == 3) {
                intent = new Intent(ak0.c, ProductSelectionActivity.class);
                intent.putExtra("src", "magicPass");
                intent.putExtra("isFromProductGroupHook", true);
            } else if (i == 4) {
                ak0.d.a();
                return;
            } else {
                return;
            }
            intent.putExtra("source", "Home Screen");
            ak0.c.startActivity(intent);
        }
    }
}
