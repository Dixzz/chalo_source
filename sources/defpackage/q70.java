package defpackage;

import app.zophop.R;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.products.PassSelectionActivity;
import defpackage.lu;
import java.util.Map;
import java.util.Objects;

/* renamed from: q70  reason: default package */
/* compiled from: PassSelectionActivity.kt */
public final class q70 implements lu.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PassSelectionActivity f2908a;

    public q70(PassSelectionActivity passSelectionActivity) {
        this.f2908a = passSelectionActivity;
    }

    @Override // defpackage.lu.a
    public void a(int i) {
        BookableSuperPassConfiguration bookableSuperPassConfiguration;
        ca1 ca1 = this.f2908a.l;
        ProductFareMapping productFareMapping = null;
        if (ca1 != null) {
            ca1.o = Integer.valueOf(i);
            ca1 ca12 = this.f2908a.l;
            if (ca12 != null) {
                BookableSuperPassConfiguration f = ca12.f();
                boolean z = true;
                if (f == null || !f.isBookablePassConfigActive()) {
                    z = false;
                }
                if (z) {
                    ((fw) this.f2908a.f0()).l.setText(this.f2908a.getString(R.string.next));
                    ((fw) this.f2908a.f0()).l.setVisibility(0);
                    PassSelectionActivity passSelectionActivity = this.f2908a;
                    Integer valueOf = Integer.valueOf(i);
                    Objects.requireNonNull(passSelectionActivity);
                    ed1 ed1 = new ed1("duration selection", Long.MIN_VALUE);
                    Boolean bool = Boolean.TRUE;
                    ed1.a("isSuperPass", bool);
                    ed1.a("fareMappingId", valueOf);
                    ca1 ca13 = passSelectionActivity.l;
                    if (ca13 != null) {
                        Map<String, Map<Integer, BookableSuperPassConfiguration>> e = ca13.e();
                        ca1 ca14 = passSelectionActivity.l;
                        if (ca14 != null) {
                            Map<Integer, BookableSuperPassConfiguration> map = e.get(ca14.m);
                            if (!(map == null || (bookableSuperPassConfiguration = map.get(valueOf)) == null)) {
                                productFareMapping = bookableSuperPassConfiguration.getSelectedProductFareMapping();
                            }
                            if (productFareMapping == null) {
                                hj1.J0(ed1, "selected duration fare mapping empty", bool, ed1);
                                return;
                            }
                            ed1.a("durationName", productFareMapping.getProductDisplayName());
                            ed1.a("durationId", Integer.valueOf((int) (productFareMapping.getDurationId() / ((long) 86400000))));
                            ed1.a(SuperPassJsonKeys.FARE, Double.valueOf(productFareMapping.getFareInfo().getActualFare()));
                            jz5.b().g(ed1);
                            return;
                        }
                        n86.l("viewModel");
                        throw null;
                    }
                    n86.l("viewModel");
                    throw null;
                }
                return;
            }
            n86.l("viewModel");
            throw null;
        }
        n86.l("viewModel");
        throw null;
    }
}
