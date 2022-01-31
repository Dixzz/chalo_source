package defpackage;

import app.zophop.ui.fragments.ProductHistoryFragment;
import com.google.android.material.tabs.TabLayout;
import defpackage.ip4;

/* renamed from: qr0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qr0 implements ip4.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProductHistoryFragment f2982a;

    public /* synthetic */ qr0(ProductHistoryFragment productHistoryFragment) {
        this.f2982a = productHistoryFragment;
    }

    @Override // defpackage.ip4.b
    public final void a(TabLayout.g gVar, int i) {
        ProductHistoryFragment productHistoryFragment = this.f2982a;
        int i2 = ProductHistoryFragment.g;
        n86.e(productHistoryFragment, "this$0");
        n86.e(gVar, "tab");
        if (i == 0) {
            gVar.a("ACTIVE");
        } else if (i == 1) {
            gVar.a("EXPIRED");
        }
        ed1 ed1 = new ed1("page selected", Long.MIN_VALUE);
        ed1.a("position", Integer.valueOf(i));
        ed1.a("source", "History screen");
        ui1.m0(ed1);
    }
}
