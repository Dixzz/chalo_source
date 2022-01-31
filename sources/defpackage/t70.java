package defpackage;

import android.view.View;
import app.zophop.R;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.BookingItemType;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.products.ProductSelectionActivity;
import app.zophop.ui.activities.RenewMagicPassActivity;
import defpackage.xt;
import java.util.HashMap;
import java.util.Objects;

/* renamed from: t70  reason: default package */
/* compiled from: ProductSelectionActivity */
public class t70 implements View.OnClickListener {
    public final /* synthetic */ BookingItem f;
    public final /* synthetic */ ProductSelectionActivity g;

    public t70(ProductSelectionActivity productSelectionActivity, BookingItem bookingItem) {
        this.g = productSelectionActivity;
        this.f = bookingItem;
    }

    public void onClick(View view) {
        long j;
        ProductSelectionActivity productSelectionActivity = this.g;
        BookingItem bookingItem = this.f;
        int i = ProductSelectionActivity.D;
        Objects.requireNonNull(productSelectionActivity);
        if (BookingItemType.MAGIC_PASS.equals(bookingItem.getBookingItemType())) {
            MPass magicPass = bookingItem.getMagicPass();
            ProductConfiguration h0 = xt.f3961a.c().h0(magicPass.getConfigId());
            if (h0 == null) {
                productSelectionActivity.q0(productSelectionActivity.getString(R.string.recent_products_not_available_dialog_title), productSelectionActivity.getString(R.string.recent_products_not_available_dialog_copy), magicPass, "product permanently disabled", false, null);
            } else if (!vn.N0(magicPass, h0)) {
                if (!h0.getIsActive()) {
                    productSelectionActivity.q0(productSelectionActivity.getString(R.string.recent_products_disabled_dialog_title), h0.getInactiveReason(), magicPass, "product temporarily disabled", false, null);
                } else {
                    productSelectionActivity.t0(productSelectionActivity.o0(magicPass.getConfigId()));
                }
            } else if (magicPass.getVerificationExpiryTime() != -1) {
                if (magicPass.getExpiryTime() > ui1.Q()) {
                    j = magicPass.getExpiryTime() + 86400000;
                } else {
                    j = ui1.Q();
                }
                if ((((long) magicPass.getNoOfDays()) * 86400000) + j >= magicPass.getVerificationExpiryTime()) {
                    HashMap hashMap = new HashMap();
                    StringBuilder i0 = hj1.i0("recent product id ");
                    i0.append(magicPass.getBookingPassId());
                    hashMap.put("recent product mpass clicked", i0.toString());
                    hashMap.put("mpass verification expired at", String.valueOf(magicPass.getVerificationExpiryTime()));
                    ProductSelectionActivity.s0("recent product event in product selection activity", hashMap);
                    productSelectionActivity.q0(productSelectionActivity.getString(R.string.validity_expired_title_recent_products), productSelectionActivity.getString(R.string.validity_expired_desc_recent_products), magicPass, "document validity expired", false, null);
                } else if (magicPass.getRouteStopsInfo() != null) {
                    HashMap hashMap2 = new HashMap();
                    StringBuilder i02 = hj1.i0("recent product id ");
                    i02.append(magicPass.getBookingPassId());
                    hashMap2.put("recent product route pass clicked", i02.toString());
                    hashMap2.put("mpass verification expiry time ", String.valueOf(magicPass.getVerificationExpiryTime()));
                    ProductSelectionActivity.s0("recent product event in product selection activity", hashMap2);
                    productSelectionActivity.m0(magicPass);
                } else {
                    HashMap hashMap3 = new HashMap();
                    StringBuilder i03 = hj1.i0("recent product id ");
                    i03.append(magicPass.getBookingPassId());
                    hashMap3.put("recent product mpass clicked", i03.toString());
                    hashMap3.put("mpass verification expiry time ", String.valueOf(magicPass.getVerificationExpiryTime()));
                    ProductSelectionActivity.s0("recent product event in product selection activity", hashMap3);
                    RenewMagicPassActivity.m0(productSelectionActivity, magicPass, "product_selection_recent_products", null);
                }
            } else if (magicPass.getRouteStopsInfo() != null) {
                HashMap hashMap4 = new HashMap();
                StringBuilder i04 = hj1.i0("recent product id ");
                i04.append(magicPass.getBookingPassId());
                hashMap4.put("recent product route pass clicked", i04.toString());
                hashMap4.put("mpass verification expiry time ", String.valueOf(magicPass.getVerificationExpiryTime()));
                ProductSelectionActivity.s0("recent product event in product selection activity", hashMap4);
                productSelectionActivity.m0(magicPass);
            } else {
                HashMap hashMap5 = new HashMap();
                StringBuilder i05 = hj1.i0("recent product id ");
                i05.append(magicPass.getBookingPassId());
                hashMap5.put("recent product mpass clicked", i05.toString());
                hashMap5.put("mpass verification expiry time ", String.valueOf(magicPass.getVerificationExpiryTime()));
                ProductSelectionActivity.s0("recent product event in product selection activity", hashMap5);
                if (!productSelectionActivity.l0(magicPass, h0, null)) {
                    RenewMagicPassActivity.m0(productSelectionActivity, magicPass, "product_selection_recent_products", null);
                }
            }
        } else if (BookingItemType.MTICKET.equals(bookingItem.getBookingItemType())) {
            productSelectionActivity.t = bookingItem.getMTicket();
            HashMap hashMap6 = new HashMap();
            StringBuilder i06 = hj1.i0("recent product id ");
            i06.append(productSelectionActivity.t.getMTicketId());
            hashMap6.put("recent product mticket clicked", i06.toString());
            ProductSelectionActivity.s0("recent product event in product selection activity", hashMap6);
            xt.t1 t1Var = xt.f3961a;
            String B = hj1.B(t1Var);
            v40 U = t1Var.U();
            String routeId = productSelectionActivity.t.getUpTripRouteStopsInfo().getRouteId();
            TransitMode transitMode = TransitMode.bus;
            U.d(routeId, B);
        }
    }
}
