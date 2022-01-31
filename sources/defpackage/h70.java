package defpackage;

import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.SuperPassProductConfigurationProperties;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.products.PassSelectionActivity;

/* renamed from: h70  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class h70 implements View.OnClickListener {
    public final /* synthetic */ PassSelectionActivity f;

    public /* synthetic */ h70(PassSelectionActivity passSelectionActivity) {
        this.f = passSelectionActivity;
    }

    public final void onClick(View view) {
        SuperPassProductConfigurationProperties superPassProductConfigurationProperties;
        SuperPassProductConfigurationProperties superPassProductConfigurationProperties2;
        SuperPassProductConfigurationProperties superPassProductConfigurationProperties3;
        ProductFareMapping selectedProductFareMapping;
        ProductFareMapping selectedProductFareMapping2;
        FareInfo fareInfo;
        ProductCategory selectedProductCategory;
        ProductCategory selectedProductCategory2;
        PassSelectionActivity passSelectionActivity = this.f;
        int i = PassSelectionActivity.n;
        n86.e(passSelectionActivity, "this$0");
        ca1 ca1 = passSelectionActivity.l;
        String str = null;
        if (ca1 != null) {
            BookableSuperPassConfiguration f2 = ca1.f();
            boolean z = false;
            if (f2 != null && !f2.isBookablePassConfigActive()) {
                z = true;
            }
            if (!z) {
                ed1 ed1 = new ed1("pass details selected", Long.MIN_VALUE);
                Boolean bool = Boolean.TRUE;
                ed1.a("isSuperPass", bool);
                ca1 ca12 = passSelectionActivity.l;
                if (ca12 != null) {
                    BookableSuperPassConfiguration f3 = ca12.f();
                    ed1.a("passengerType", (f3 == null || (selectedProductCategory2 = f3.getSelectedProductCategory()) == null) ? null : selectedProductCategory2.getCategoryId());
                    ca1 ca13 = passSelectionActivity.l;
                    if (ca13 != null) {
                        BookableSuperPassConfiguration f4 = ca13.f();
                        ed1.a(SuperPassJsonKeys.CATEGORY_ID, (f4 == null || (selectedProductCategory = f4.getSelectedProductCategory()) == null) ? null : selectedProductCategory.getCategoryId());
                        ed1.a("bookingDate", jh1.c(ui1.Q()));
                        ca1 ca14 = passSelectionActivity.l;
                        if (ca14 != null) {
                            BookableSuperPassConfiguration f5 = ca14.f();
                            ed1.a(SuperPassJsonKeys.FARE, (f5 == null || (selectedProductFareMapping2 = f5.getSelectedProductFareMapping()) == null || (fareInfo = selectedProductFareMapping2.getFareInfo()) == null) ? null : Double.valueOf(fareInfo.getActualFare()).toString());
                            ca1 ca15 = passSelectionActivity.l;
                            if (ca15 != null) {
                                BookableSuperPassConfiguration f6 = ca15.f();
                                ed1.a("numDays", (f6 == null || (selectedProductFareMapping = f6.getSelectedProductFareMapping()) == null) ? null : Integer.valueOf(selectedProductFareMapping.getNoOfDays()).toString());
                                ca1 ca16 = passSelectionActivity.l;
                                if (ca16 != null) {
                                    BookableSuperPassConfiguration f7 = ca16.f();
                                    ed1.a("productType", (f7 == null || (superPassProductConfigurationProperties3 = f7.getSuperPassProductConfigurationProperties()) == null) ? null : superPassProductConfigurationProperties3.getProductType());
                                    ca1 ca17 = passSelectionActivity.l;
                                    if (ca17 != null) {
                                        BookableSuperPassConfiguration f8 = ca17.f();
                                        hj1.K0(ed1, "productSubType", (f8 == null || (superPassProductConfigurationProperties2 = f8.getSuperPassProductConfigurationProperties()) == null) ? null : superPassProductConfigurationProperties2.getProductSubType(), ed1);
                                        ca1 ca18 = passSelectionActivity.l;
                                        if (ca18 != null) {
                                            BookableSuperPassConfiguration f9 = ca18.f();
                                            if (!(f9 == null || (superPassProductConfigurationProperties = f9.getSuperPassProductConfigurationProperties()) == null)) {
                                                str = superPassProductConfigurationProperties.getProductSubType();
                                            }
                                            if (n86.a(str, SuperPassConstants.SUBTYPE_RIDE_PASS)) {
                                                ed1 ed12 = new ed1("Pass Selection BottomSheet Displayed", Long.MIN_VALUE);
                                                ed12.a("isSuperPass", bool);
                                                jz5.b().g(ed12);
                                                FragmentManager supportFragmentManager = passSelectionActivity.getSupportFragmentManager();
                                                n86.d(supportFragmentManager, "supportFragmentManager");
                                                n86.e(supportFragmentManager, "lFragmentManager");
                                                new lt0().show(supportFragmentManager, "passSelectionConfirmationBottomSheetTag");
                                                return;
                                            }
                                            passSelectionActivity.z0();
                                            return;
                                        }
                                        n86.l("viewModel");
                                        throw null;
                                    }
                                    n86.l("viewModel");
                                    throw null;
                                }
                                n86.l("viewModel");
                                throw null;
                            }
                            n86.l("viewModel");
                            throw null;
                        }
                        n86.l("viewModel");
                        throw null;
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
}
