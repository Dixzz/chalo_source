package app.zophop.ui.activities;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.appcompat.widget.RtlSpacingHelper;
import app.zophop.R;
import app.zophop.models.RouteInfo;
import app.zophop.models.mTicketing.BookingTransaction;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.ProfileRequestInfo;
import app.zophop.models.mTicketing.UserAgencyInfo;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassPaymentConstants;
import app.zophop.pubsub.eventbus.events.BookingTransactionEvent;
import app.zophop.pubsub.eventbus.events.CashPaymentEvent;
import app.zophop.pubsub.eventbus.events.RazorPayOrderData;
import app.zophop.pubsub.eventbus.events.RazorPayVerificationStatus;
import app.zophop.pubsub.eventbus.events.UserProfileEvent;
import com.razorpay.AnalyticsConstants;
import defpackage.i61;
import defpackage.mn0;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConfirmMagicPassActivity extends wt implements mn0.c, i61 {
    public static MPass v;
    public static ProfileRequestInfo w;
    public static String x;
    public DialogFragment l;
    public boolean m;
    public String n;
    public Bundle o;
    public RouteInfo p;
    public String q;
    public List<String> r;
    public int s = 0;
    public RelativeLayout t;
    public boolean u;

    public class a extends at1<Bitmap> {
        public final /* synthetic */ ProgressBar i;
        public final /* synthetic */ ImageView j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ConfirmMagicPassActivity confirmMagicPassActivity, ProgressBar progressBar, ImageView imageView) {
            super(RtlSpacingHelper.UNDEFINED, RtlSpacingHelper.UNDEFINED);
            this.i = progressBar;
            this.j = imageView;
        }

        @Override // defpackage.ct1
        public void b(Object obj, ft1 ft1) {
            this.i.setVisibility(8);
            this.j.setImageBitmap((Bitmap) obj);
        }
    }

    @Override // defpackage.mn0.c
    public void a0() {
        this.m = true;
        if (v.is_isVerificationRequired()) {
            o0();
            xt.f3961a.L().g(w);
            return;
        }
        o0();
        String str = null;
        RouteInfo routeInfo = this.p;
        if (routeInfo != null) {
            str = routeInfo.getRouteId();
        }
        xt.t1 t1Var = xt.f3961a;
        d20 c = t1Var.c();
        MPass mPass = v;
        c.A(mPass, str, jh1.c(mPass.getStartingTime()), t1Var.L().j(), "online", w);
    }

    @Override // defpackage.i61
    public void c(i61.a aVar, int i) {
        if (i == 0) {
            xt.f3961a.c().d0(v.getPassengerType(), "online");
            UserAgencyInfo userAgencyInfo = v.getUserProfile().getAgencyInfo().get(v.getAgency());
            String str = x;
            if (str != null && str.equalsIgnoreCase("renew_pass")) {
                j0();
            } else if (v.getStatus() != null && (v.getStatus().equals("VERIFIED") || v.getStatus().equals("PAYMENT_PENDING"))) {
                j0();
            } else if (userAgencyInfo == null || !userAgencyInfo.getPassengerType().equals(v.getPassengerType()) || userAgencyInfo.getStatus() == null || !userAgencyInfo.getStatus().equals("VERIFIED")) {
                n0();
                mn0.a(getFragmentManager(), v.getConfigId());
            } else {
                j0();
            }
        } else if (i == 1) {
            xt.t1 t1Var = xt.f3961a;
            t1Var.c().d0(v.getPassengerType(), SuperPassPaymentConstants.PAYMENT_MODE_CASH);
            o0();
            l0(v, SuperPassPaymentConstants.PAYMENT_MODE_CASH);
            t1Var.c().c0(v, SuperPassPaymentConstants.PAYMENT_MODE_CASH);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x047b  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x04d8  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x04dd  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x04f2  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0500  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x05ae  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x05e2  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x064b  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0798  */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x09c7  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x09e6  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0a22  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0a49  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0aaa  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0aef  */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x0c07  */
    /* JADX WARNING: Removed duplicated region for block: B:243:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0245 A[LOOP:2: B:64:0x023f->B:66:0x0245, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x026a  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x02df  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x03a1  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x03d9  */
    @Override // defpackage.tf1
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void e(android.os.Bundle r21) {
        /*
        // Method dump skipped, instructions count: 3098
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.ui.activities.ConfirmMagicPassActivity.e(android.os.Bundle):void");
    }

    public final void h0() {
        if (vn.K0(this)) {
            e0();
            this.u = false;
        } else if (!this.u) {
            this.u = f0(this.t);
        }
    }

    public final void i0() {
        DialogFragment dialogFragment = this.l;
        if (dialogFragment != null) {
            dialogFragment.dismiss();
        }
    }

    public final void j0() {
        o0();
        l0(v, "online");
        xt.t1 t1Var = xt.f3961a;
        d20 c = t1Var.c();
        MPass mPass = v;
        c.w(mPass, jh1.c(mPass.getStartingTime()), t1Var.L().j(), "online");
    }

    public final void k0(String str, ImageView imageView, ProgressBar progressBar) {
        ml1<Bitmap> j = gl1.g(this).j();
        j.a(new rs1().q(50000));
        j.m = str;
        j.p = true;
        j.f(new a(this, progressBar, imageView));
    }

    public final void l0(MPass mPass, String str) {
        ed1 ed1 = new ed1("pass payment initiated", Long.MIN_VALUE);
        ed1.a("passengerType", mPass.getPassengerType());
        ed1.a(SuperPassJsonKeys.FARE, mPass.getFare() + "");
        ed1.a("noDays", mPass.getNoOfDays() + "");
        ed1.a("startDate", jh1.c(v.getStartingTime()));
        ed1.a("bookingId", mPass.getBookingPassId());
        ed1.a("paymentMode", str);
        if (getIntent() != null) {
            ed1.a("source", getIntent().getStringExtra("src"));
        }
        jz5.b().g(ed1);
    }

    public final void m0(boolean z, String str) {
        if (z) {
            v.setQrCode(str);
            xt.f3961a.c().S(v, false);
        }
        xt.f3961a.j().a();
        ActivatePassScreen.i0(this, v, null, true);
    }

    public final void n0() {
        ed1 ed1 = new ed1("application submitted for verification", Long.MIN_VALUE);
        ed1.a("passengerType", v.getPassengerType());
        ed1.a(SuperPassJsonKeys.FARE, v.getFare() + "");
        ed1.a("numDays", v.getNoOfDays() + "");
        ed1.a("productType", v.get_productType());
        jz5.b().g(ed1);
    }

    public final void o0() {
        if (!this.l.isVisible()) {
            this.l.show(getFragmentManager(), "loader_tag");
        }
    }

    @Override // androidx.activity.ComponentActivity, defpackage.ve
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 12345 && i2 == -1) {
            if (intent == null || TextUtils.isEmpty(intent.getStringExtra("paymentMode")) || !intent.getStringExtra("paymentMode").equalsIgnoreCase(SuperPassPaymentConstants.PAYMENT_MODE_CASH)) {
                o0();
            } else {
                xt.t1 t1Var = xt.f3961a;
                t1Var.c().d0(v.getPassengerType(), SuperPassPaymentConstants.PAYMENT_MODE_CASH);
                o0();
                l0(v, SuperPassPaymentConstants.PAYMENT_MODE_CASH);
                t1Var.c().c0(v, SuperPassPaymentConstants.PAYMENT_MODE_CASH);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.wt
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onDestroy() {
        super.onDestroy();
    }

    public void onEvent(UserProfileEvent userProfileEvent) {
        if (userProfileEvent.getResponseType().equals(ad1.FAILED) && this.m) {
            jz5.b().m(userProfileEvent);
            if (this.l.isVisible()) {
                String message = userProfileEvent.getMessage();
                if (TextUtils.isEmpty(message)) {
                    message = getResources().getString(R.string.something_bad_happened);
                }
                ed1 ed1 = new ed1("application submit failure", Long.MIN_VALUE);
                ed1.a("passengerType", v.getPassengerType());
                ed1.a("noOfDays", String.valueOf(v.getNoOfDays()));
                ed1.a(SuperPassJsonKeys.PASS_FARE, String.valueOf(v.getFare()));
                jz5.b().g(ed1);
                Toast.makeText(this, message, 0).show();
            }
            i0();
        }
        if (this.m && userProfileEvent.getResponseType().equals(ad1.SUCCESS)) {
            jz5.b().m(userProfileEvent);
            i0();
            this.m = false;
            if (!userProfileEvent.getUserProfileEventType().equals(UserProfileEvent.TYPE.LOGOUT)) {
                startActivity(new Intent(this, PassStatusActivity.class));
                xt.t1 t1Var = xt.f3961a;
                t1Var.c().s();
                HashMap hashMap = new HashMap();
                ProfileRequestInfo profileRequestInfo = w;
                if (profileRequestInfo != null) {
                    hashMap.putAll(profileRequestInfo.getAgencyInfo().getProofs());
                }
                v.setDisplayProps(hashMap);
                v.setStatus("UNVERIFIED");
                v.setUserProfile(t1Var.L().e());
                t1Var.c().L(v);
                ed1 ed12 = new ed1("application submit success", Long.MIN_VALUE);
                ed12.a("passengerType", v.getPassengerType());
                ed12.a("noOfDays", String.valueOf(v.getNoOfDays()));
                ed12.a(SuperPassJsonKeys.PASS_FARE, String.valueOf(v.getFare()));
                jz5.b().g(ed12);
            }
        }
    }

    @Override // defpackage.wt
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return false;
        }
        finish();
        return true;
    }

    @Override // defpackage.ve, defpackage.au, defpackage.tf1
    public void onResume() {
        super.onResume();
        ui1.U(this);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStart() {
        super.onStart();
        jz5 b = jz5.b();
        b.k(this, b.e, true, 0);
    }

    @Override // defpackage.f0, defpackage.ve, defpackage.au
    public void onStop() {
        super.onStop();
        FragmentManager fragmentManager = getFragmentManager();
        if (((ei1) fragmentManager.findFragmentByTag("data")) == null) {
            fragmentManager.beginTransaction().add(new ei1(), "data").commitAllowingStateLoss();
        }
        if (this.o == null) {
            this.o = new Bundle();
        }
        MPass mPass = v;
        if (mPass != null) {
            this.o.putString("magic_pass_info", ov.f(mPass));
        }
        jz5.b().o(this);
    }

    public void onEvent(RazorPayVerificationStatus razorPayVerificationStatus) {
        jz5.b().m(razorPayVerificationStatus);
        if (razorPayVerificationStatus.get_responseType().equals(ad1.SUCCESS)) {
            m0(false, razorPayVerificationStatus.getQrCode());
            return;
        }
        i0();
        Toast.makeText(this, "payment failed", 1).show();
    }

    public void onEvent(CashPaymentEvent cashPaymentEvent) {
        jz5.b().m(cashPaymentEvent);
        i0();
        if (cashPaymentEvent.getResponseType().equals(ad1.SUCCESS)) {
            MPass magicPass = cashPaymentEvent.getBookingTransaction().getMagicPass();
            v = magicPass;
            magicPass.setReferenceId(cashPaymentEvent.getReferenceId());
            v.setFare(cashPaymentEvent.getAmount());
            List<BookingTransaction> e = xt.f3961a.c().e();
            ArrayList arrayList = e;
            if (e == null) {
                ArrayList arrayList2 = new ArrayList();
                BookingTransaction bookingTransaction = new BookingTransaction();
                bookingTransaction.setMagicPass(v);
                arrayList2.add(bookingTransaction);
                arrayList = arrayList2;
            }
            for (int i = 0; i < arrayList.size(); i++) {
                MPass magicPass2 = arrayList.get(i).getMagicPass();
                xt.t1 t1Var = xt.f3961a;
                if (t1Var.c().o(magicPass2.getPassengerType()).equalsIgnoreCase(SuperPassPaymentConstants.PAYMENT_MODE_CASH)) {
                    magicPass2.setReferenceId(v.getReferenceId());
                    BookingTransaction bookingTransaction2 = arrayList.get(i);
                    bookingTransaction2.setMagicPass(magicPass2);
                    arrayList.set(i, bookingTransaction2);
                    t1Var.c().y(v.getCity(), v.getPassengerType(), bookingTransaction2, v.getStatus());
                }
            }
            MPass mPass = v;
            String string = getString(R.string.cash_center);
            MPass mPass2 = v;
            xt.f3961a.k().d().getName();
            v.getFare();
            v.getReferenceId();
            startActivity(CashWebViewActivity.l0(this, ut.D + "?referenceId=" + mPass.getReferenceId() + "&mobile_number=" + mPass.getUserProfile().getPhone() + "&amount=" + mPass.getFare() + "&city=" + mPass.getCity() + "&agency=" + mPass.getAgency(), string, mPass2, false, false, "confirmMagicPass"));
            return;
        }
        if (TextUtils.isEmpty(cashPaymentEvent.getFailureReason())) {
            Toast.makeText(this, "something went wrong", 1).show();
        } else {
            Toast.makeText(this, cashPaymentEvent.getFailureReason(), 1).show();
        }
        DialogFragment dialogFragment = this.l;
        if (dialogFragment != null && dialogFragment.isVisible()) {
            this.l.dismiss();
        }
    }

    public void onEvent(BookingTransactionEvent bookingTransactionEvent) {
        jz5.b().m(bookingTransactionEvent);
        i0();
        ad1 responseType = bookingTransactionEvent.getResponseType();
        ad1 ad1 = ad1.SUCCESS;
        if (responseType.equals(ad1)) {
            MPass magicPass = bookingTransactionEvent.getBookingTransaction().getMagicPass();
            v = magicPass;
            ed1 ed1 = new ed1("pass booking response received", Long.MIN_VALUE);
            ed1.a("passBookingId", magicPass.getBookingPassId());
            ed1.a("productType", v.get_productType());
            ed1.a(SuperPassJsonKeys.FARE, v.getFare() + "");
            ed1.a("passengerType", v.getPassengerType());
            ed1.a("startDate", jh1.c(v.getStartingTime()));
            ed1.a("numDays", v.getNoOfDays() + "");
            ed1.a("response", String.valueOf(bookingTransactionEvent.getResponseType() == ad1));
            ed1.a(SuperPassJsonKeys.ORDER_ID, bookingTransactionEvent.getRazorPayOrderData().get_orderId());
            ed1.a("productType", v.get_productType());
            if (bookingTransactionEvent.getBookingTransaction().getMagicPass().getReferenceId() != null) {
                ed1.a("mode", SuperPassPaymentConstants.PAYMENT_MODE_CASH);
            } else {
                ed1.a("mode", "online");
            }
            jz5.b().g(ed1);
            if (v.getReferenceId() == null) {
                if (!v.isPaymentRequired()) {
                    m0(true, null);
                    return;
                }
                RazorPayOrderData razorPayOrderData = bookingTransactionEvent.getRazorPayOrderData();
                Bundle bundle = new Bundle();
                bundle.putString("currency", "INR");
                bundle.putString(AnalyticsConstants.ORDER_ID, razorPayOrderData.get_orderId());
                bundle.putString(AnalyticsConstants.AMOUNT, ((int) razorPayOrderData.get_amount()) + "");
                bundle.putParcelable("magic_pass_info", v);
                bundle.putBoolean("lpEligible", bookingTransactionEvent.getBookingTransaction().isLpEligible());
                bundle.putString("eligibilityResponseId", bookingTransactionEvent.getBookingTransaction().getLpId());
                bundle.putString(AnalyticsConstants.MERCHANT_KEY, razorPayOrderData.getMerchantKey());
                bundle.putParcelableArrayList("card_details", (ArrayList) v.getCardDetails());
                Intent intent = new Intent(this, CheckoutActivity.class);
                intent.addFlags(67108864);
                intent.putExtra("src", "Confirm Pass Screen");
                intent.putExtras(bundle);
                startActivityForResult(intent, 12345);
                return;
            }
            return;
        }
        i0();
        if (!TextUtils.isEmpty(bookingTransactionEvent.getErrorMessage())) {
            Toast.makeText(this, bookingTransactionEvent.getErrorMessage(), 1).show();
        } else {
            Toast.makeText(this, "something went wrong", 1).show();
        }
        DialogFragment dialogFragment = this.l;
        if (dialogFragment != null && dialogFragment.isVisible()) {
            this.l.dismiss();
        }
    }

    public void onEvent(qd1 qd1) {
        h0();
    }
}
