package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.BookingItemType;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import app.zophop.ui.activities.ActivateMTicketScreen;
import app.zophop.ui.activities.ActivatePassScreen;
import app.zophop.ui.activities.ActiveMTicketScreen;
import app.zophop.ui.activities.ActivePassScreen;
import app.zophop.ui.activities.ActiveScanPayScreen;
import app.zophop.ui.activities.CashWebViewActivity;
import app.zophop.ui.activities.HomeActivity;
import app.zophop.ui.activities.MPassPurchaseActivity;
import app.zophop.ui.activities.MPassVerificationStatusActivity;
import app.zophop.ui.activities.MTicketBookingSummary;
import app.zophop.ui.activities.ScanPayBookingSummary;
import app.zophop.ui.activities.SuperPassBookingSummaryActivity;
import app.zophop.ui.activities.SuperPassCashPaymentWebViewActivity;
import app.zophop.ui.activities.SuperPassPurchaseActivity;
import app.zophop.ui.activities.SuperPassValidationActivity;
import app.zophop.ui.activities.SuperPassVerificationStatusActivity;
import app.zophop.ui.activities.ValidationScreen;
import app.zophop.ui.views.MagicPassInfoView;
import defpackage.dl0;
import defpackage.xt;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* renamed from: qi0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class qi0 implements View.OnClickListener {
    public final /* synthetic */ dl0.c f;
    public final /* synthetic */ dl0 g;

    public /* synthetic */ qi0(dl0.c cVar, dl0 dl0) {
        this.f = cVar;
        this.g = dl0;
    }

    public final void onClick(View view) {
        dl0.c cVar = this.f;
        dl0 dl0 = this.g;
        n86.e(cVar, "this$0");
        n86.e(dl0, "this$1");
        if (cVar.getBindingAdapterPosition() != -1) {
            T t = dl0.f2701a.f.get(cVar.getBindingAdapterPosition());
            BookingItemType bookingItemType = t.getBookingItemType();
            int bindingAdapterPosition = cVar.getBindingAdapterPosition();
            ed1 ed1 = new ed1(dl0.c instanceof HomeActivity ? "home screen your plans clicked" : "product history screen your plans clicked", Long.MIN_VALUE);
            ed1.a("card position", Integer.valueOf(bindingAdapterPosition));
            ed1.a("booking item type", bookingItemType.name());
            ui1.m0(ed1);
            int ordinal = t.getBookingItemType().ordinal();
            if (ordinal == 0) {
                MPass magicPass = t.getMagicPass();
                n86.c(magicPass);
                ed1 ed12 = new ed1("itemClicked", Long.MIN_VALUE);
                ed12.a("source", dl0.f);
                vn.b(ed12, magicPass);
                jz5.b().g(ed12);
                if (magicPass.getStartingTime() < ui1.Q() && magicPass.getBookingPassId() == null) {
                    magicPass.setStartingTime(ui1.Q());
                }
                if (n86.a(vn.r0(dl0.c, magicPass, t.getRideDetails()), MagicPassInfoView.b.APP_RECLAIM.name()) || n86.a(vn.r0(dl0.c, magicPass, null), MagicPassInfoView.b.BACKEND_RECLIAM.name())) {
                    FragmentManager supportFragmentManager = ((f0) cVar.c.c).getSupportFragmentManager();
                    n86.d(supportFragmentManager, "context as AppCompatActi…y).supportFragmentManager");
                    du0 f2 = du0.f(supportFragmentManager, cVar.c.c.getString(R.string.renew_super_saver, jh1.k(xt.f3961a.t().c("reclaimTime"))), null, cVar.c.c.getString(R.string.okay), null, 1, R.drawable.super_saver_reclaim_unsuccess, cVar.c.f);
                    f2.setCancelable(false);
                    f2.e(new ri0(f2));
                    int bindingAdapterPosition2 = cVar.getBindingAdapterPosition();
                    ed1 ed13 = new ed1(cVar.c.c instanceof HomeActivity ? "home screen super saver reclaim prompt rendered" : "product history screen super saver reclaim prompt rendered", Long.MIN_VALUE);
                    hj1.u0(bindingAdapterPosition2, ed13, "card position", ed13);
                } else if (!cVar.c.e) {
                    String bookingPassId = magicPass.getBookingPassId();
                    String str = cVar.c.f;
                    String passengerType = magicPass.getPassengerType();
                    ed1 ed14 = new ed1("pass card clicked", Long.MIN_VALUE);
                    if (bookingPassId != null) {
                        ed14.a("bookingId", bookingPassId);
                    }
                    ed14.a("source", str);
                    ed14.a("hourOfEvent", n86.j("", hj1.q(ed14, "status", "expired pass", "passengerType", passengerType)));
                    jz5.b().g(ed14);
                    cVar.c(magicPass);
                } else if (magicPass.getBookingPassId() == null) {
                    String status = magicPass.getStatus();
                    if (status != null) {
                        int hashCode = status.hashCode();
                        if (hashCode != -1211756856) {
                            if (hashCode != 16937057) {
                                if (hashCode == 1862415390 && status.equals("PAYMENT_PENDING")) {
                                    if (!cVar.d(magicPass)) {
                                        Context context = cVar.c.c;
                                        String string = cVar.c.c.getString(R.string.cash_center);
                                        City d = xt.f3961a.k().d();
                                        n86.c(d);
                                        d.getName();
                                        magicPass.getFare();
                                        magicPass.getReferenceId();
                                        context.startActivity(CashWebViewActivity.l0(context, ut.D + "?referenceId=" + ((Object) magicPass.getReferenceId()) + "&mobile_number=" + ((Object) magicPass.getUserProfile().getPhone()) + "&amount=" + magicPass.getFare() + "&city=" + ((Object) magicPass.getCity()) + "&agency=" + ((Object) magicPass.getAgency()), string, magicPass, false, false, cVar.c.f));
                                        return;
                                    }
                                    return;
                                }
                            } else if (status.equals("UNVERIFIED")) {
                                MPassVerificationStatusActivity.v0(cVar.c.c, magicPass, "sourceYourPlansCard");
                                return;
                            }
                        } else if (status.equals("VERIFIED")) {
                            if (!cVar.d(magicPass)) {
                                String str2 = cVar.c.f;
                                String passengerType2 = magicPass.getPassengerType();
                                ed1 l = hj1.l("pass card clicked", Long.MIN_VALUE, "source", str2);
                                l.a("hourOfEvent", n86.j("", hj1.q(l, "status", "VERIFIED", "passengerType", passengerType2)));
                                jz5.b().g(l);
                                MPassPurchaseActivity.s0(cVar.c.c, "sourceYourPlansCard", "flowPaymentPostVerification", magicPass, null);
                                return;
                            }
                            return;
                        }
                    }
                    String status2 = magicPass.getStatus();
                    String str3 = cVar.c.f;
                    String passengerType3 = magicPass.getPassengerType();
                    ed1 l2 = hj1.l("pass card clicked", Long.MIN_VALUE, "source", str3);
                    l2.a("hourOfEvent", n86.j("", hj1.q(l2, "status", status2, "passengerType", passengerType3)));
                    jz5.b().g(l2);
                    cVar.c(magicPass);
                } else if (magicPass.getOrderId() == null || (!n86.a(magicPass.getStatus(), "FAILED") && !n86.a(magicPass.getStatus(), "PENDING"))) {
                    xt.t1 t1Var = xt.f3961a;
                    if (!t1Var.c().E(magicPass.getStartingTime())) {
                        cVar.c(magicPass);
                    } else if (t1Var.c().W(vn.y(magicPass.getConfigId()), magicPass.getBookingPassId())) {
                        dl0 dl02 = cVar.c;
                        ActivatePassScreen.i0(dl02.c, magicPass, dl02.f, false);
                        String bookingPassId2 = magicPass.getBookingPassId();
                        String str4 = cVar.c.f;
                        String passengerType4 = magicPass.getPassengerType();
                        ed1 ed15 = new ed1("pass card clicked", Long.MIN_VALUE);
                        if (bookingPassId2 != null) {
                            ed15.a("bookingId", bookingPassId2);
                        }
                        ed15.a("source", str4);
                        ed15.a("hourOfEvent", n86.j("", hj1.q(ed15, "status", "booked", "passengerType", passengerType4)));
                        jz5.b().g(ed15);
                    } else {
                        if (!ui1.B0() || magicPass.getTone() == null) {
                            dl0 dl03 = cVar.c;
                            Context context2 = dl03.c;
                            String str5 = dl03.f;
                            ActivePassScreen.F = magicPass;
                            Intent N0 = hj1.N0(context2, ActivePassScreen.class, "src", str5);
                            N0.putExtra("shouldLaunchNew", false);
                            context2.startActivity(N0);
                        } else {
                            dl0 dl04 = cVar.c;
                            ValidationScreen.k0(dl04.c, magicPass, dl04.f, false);
                        }
                        String bookingPassId3 = magicPass.getBookingPassId();
                        String str6 = cVar.c.f;
                        String passengerType5 = magicPass.getPassengerType();
                        ed1 ed16 = new ed1("pass card clicked", Long.MIN_VALUE);
                        if (bookingPassId3 != null) {
                            ed16.a("bookingId", bookingPassId3);
                        }
                        ed16.a("source", str6);
                        ed16.a("hourOfEvent", n86.j("", hj1.q(ed16, "status", "booked", "passengerType", passengerType5)));
                        jz5.b().g(ed16);
                    }
                } else {
                    cVar.c(magicPass);
                }
            } else if (ordinal == 1) {
                MTicket mTicket = t.getMTicket();
                n86.c(mTicket);
                if (!dl0.e) {
                    MTicketBookingSummary.i0(dl0.c, mTicket, dl0.f);
                } else if (n86.a("PENDING", mTicket.getStatus())) {
                    MTicketBookingSummary.i0(dl0.c, mTicket, dl0.f);
                } else if (!mTicket.isMTicketActive()) {
                    ActivateMTicketScreen.h0(dl0.c, mTicket, dl0.f, false);
                } else if (!mTicket.isMTicketActive()) {
                    MTicketBookingSummary.i0(dl0.c, mTicket, dl0.f);
                } else if (!ui1.B0() || mTicket.getTone() == null) {
                    ActiveMTicketScreen.i0(dl0.c, mTicket, dl0.f, false);
                } else {
                    ValidationScreen.l0(dl0.c, mTicket, dl0.f, false);
                }
            } else if (ordinal == 3) {
                ScanPayTicket scanPayTicket = t.getScanPayTicket();
                n86.c(scanPayTicket);
                if (!dl0.e) {
                    ScanPayBookingSummary.h0(dl0.c, scanPayTicket, dl0.f);
                } else if (n86.a("PENDING", scanPayTicket.get_status())) {
                    ScanPayBookingSummary.h0(dl0.c, scanPayTicket, dl0.f);
                } else if (scanPayTicket.isScanPayTicketExpired()) {
                    ScanPayBookingSummary.h0(dl0.c, scanPayTicket, dl0.f);
                } else if (scanPayTicket.get_status() != null && (n86.a(scanPayTicket.get_status(), "PENDING") || n86.a(scanPayTicket.get_status(), "FAILED"))) {
                    ScanPayBookingSummary.h0(dl0.c, scanPayTicket, dl0.f);
                } else if (scanPayTicket.isScanPayTicketExpired()) {
                    ScanPayBookingSummary.h0(dl0.c, scanPayTicket, dl0.f);
                } else if (!ui1.B0() || scanPayTicket.get_tone() == null) {
                    ActiveScanPayScreen.h0(dl0.c, scanPayTicket, dl0.f, false);
                } else {
                    ValidationScreen.j0(dl0.c, scanPayTicket, dl0.f, false);
                }
            } else if (ordinal == 4) {
                SuperPassApplication superPassApplication = t.getSuperPassApplication();
                n86.c(superPassApplication);
                int ordinal2 = superPassApplication.getSuperPassApplicationStatus().ordinal();
                if (ordinal2 == 0) {
                    SuperPassVerificationStatusActivity.v0(cVar.c.c, superPassApplication, cVar.b());
                } else if (ordinal2 == 1) {
                    BookableSuperPassConfiguration a2 = t60.a(superPassApplication);
                    if (a2 == null) {
                        s76<String, s56> a3 = cVar.a();
                        String string2 = cVar.c.c.getResources().getString(R.string.recent_products_disabled_dialog_copy);
                        n86.d(string2, "context.resources.getStr…cts_disabled_dialog_copy)");
                        a3.invoke(string2);
                    } else if (superPassApplication.getVerificationExpiryTime() == -1 || superPassApplication.getVerificationExpiryTime() - (((long) a2.getSelectedProductFareMapping().getNoOfDays()) * 86400000) >= 1) {
                        SuperPassPurchaseActivity.s0(cVar.c.c, cVar.b(), a2, superPassApplication);
                    } else {
                        s76<String, s56> a4 = cVar.a();
                        String string3 = cVar.c.c.getResources().getString(R.string.validity_expired_desc_recent_products);
                        n86.d(string3, "context.resources.getStr…red_desc_recent_products)");
                        a4.invoke(string3);
                    }
                } else if (ordinal2 == 2) {
                    BookableSuperPassConfiguration a5 = t60.a(superPassApplication);
                    if (a5 == null || !a5.isBookablePassConfigActive()) {
                        s76<String, s56> a6 = cVar.a();
                        String string4 = cVar.c.c.getResources().getString(R.string.recent_products_disabled_dialog_copy);
                        n86.d(string4, "context.resources.getStr…cts_disabled_dialog_copy)");
                        a6.invoke(string4);
                        return;
                    }
                    SuperPassPurchaseActivity.t0(cVar.c.c, cVar.b(), a5, superPassApplication);
                } else if (ordinal2 == 3) {
                    BookableSuperPassConfiguration a7 = t60.a(superPassApplication);
                    if (a7 == null || !a7.isBookablePassConfigActive()) {
                        s76<String, s56> a8 = cVar.a();
                        String string5 = cVar.c.c.getResources().getString(R.string.recent_products_disabled_dialog_copy);
                        n86.d(string5, "context.resources.getStr…cts_disabled_dialog_copy)");
                        a8.invoke(string5);
                        return;
                    }
                    SuperPassCashPaymentWebViewActivity.l0(cVar.b(), superPassApplication, a7, cVar.c.c);
                }
            } else if (ordinal == 5 || ordinal == 6) {
                SuperPass applicableSuperPass = t.getApplicableSuperPass();
                ed1 ed17 = new ed1(dl0.c instanceof HomeActivity ? "home screen super pass your plans clicked" : "product history screen super pass your plans clicked", Long.MIN_VALUE);
                gi1.f1265a.d(ed17, applicableSuperPass);
                ui1.m0(ed17);
                if (dl0.e) {
                    if (applicableSuperPass.getSuperPassProperties().getProductSubType() == SuperPassSubType.RIDE_BASED_SUPER_PASS) {
                        RideBasedSuperPass rideBasedSuperPass = (RideBasedSuperPass) applicableSuperPass;
                        if (rideBasedSuperPass.getSuperPassValidationProperties().shouldReclaim(applicableSuperPass.getSuperPassProperties().getCityName())) {
                            long timeAtWhichRideWillGetReclaimed = rideBasedSuperPass.getSuperPassValidationProperties().getTimeAtWhichRideWillGetReclaimed(applicableSuperPass.getSuperPassProperties().getCityName());
                            String passId = applicableSuperPass.getSuperPassProperties().getPassId();
                            FragmentManager supportFragmentManager2 = ((f0) cVar.c.c).getSupportFragmentManager();
                            n86.d(supportFragmentManager2, "context as AppCompatActi…y).supportFragmentManager");
                            Context context3 = cVar.c.c;
                            TimeZone.setDefault(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
                            String format = new SimpleDateFormat("hh:mm a, dd MMM yyyy").format(new Date(timeAtWhichRideWillGetReclaimed));
                            n86.d(format, "text");
                            String x = ea6.x(ea6.x(format, "am", "AM", false, 4), "pm", "PM", false, 4);
                            n86.d(x, "text");
                            du0 f3 = du0.f(supportFragmentManager2, context3.getString(R.string.reclaim_super_pass_rides_bottomsheet_copy, x), null, cVar.c.c.getString(R.string.okay), null, 1, R.drawable.super_saver_reclaim_unsuccess, cVar.c.f);
                            f3.setCancelable(false);
                            f3.e(new pi0(f3));
                            int bindingAdapterPosition3 = cVar.getBindingAdapterPosition();
                            ed1 ed18 = new ed1(cVar.c.c instanceof HomeActivity ? "home screen super saver reclaim prompt rendered" : "product history screen super saver reclaim prompt rendered", Long.MIN_VALUE);
                            ed18.a("card position", Integer.valueOf(bindingAdapterPosition3));
                            ed18.a("passId", passId);
                            ed18.a("isSuperPass", Boolean.TRUE);
                            ed18.a("available at timeStamp", String.valueOf(timeAtWhichRideWillGetReclaimed));
                            TimeZone.setDefault(DesugarTimeZone.getTimeZone("Asia/Calcutta"));
                            String format2 = new SimpleDateFormat("hh:mm a, dd MMM yyyy").format(new Date(timeAtWhichRideWillGetReclaimed));
                            n86.d(format2, "text");
                            String x2 = ea6.x(ea6.x(format2, "am", "AM", false, 4), "pm", "PM", false, 4);
                            n86.d(x2, "text");
                            ed18.a("available at time", x2);
                            ui1.m0(ed18);
                            return;
                        }
                    }
                    if (!applicableSuperPass.isNotYetActive()) {
                        SuperPassValidationActivity.p0(dl0.c, applicableSuperPass.getSuperPassProperties().getProductSubType(), applicableSuperPass.getSuperPassProperties().getPassId(), dl0.f);
                    } else {
                        SuperPassBookingSummaryActivity.s0(applicableSuperPass.getSuperPassProperties().getPassId(), applicableSuperPass.getSuperPassProperties().getProductSubType(), cVar.b(), dl0.c);
                    }
                } else {
                    SuperPassBookingSummaryActivity.s0(applicableSuperPass.getSuperPassProperties().getPassId(), applicableSuperPass.getSuperPassProperties().getProductSubType(), cVar.b(), dl0.c);
                }
            } else if (ordinal == 7) {
                PendingSuperPass pendingSuperPass = t.getPendingSuperPass();
                n86.c(pendingSuperPass);
                String passId2 = pendingSuperPass.getPendingSuperPassProperties().getPassId();
                SuperPassSubType productSubType = pendingSuperPass.getPendingSuperPassProperties().getProductSubType();
                String b = cVar.b();
                Context context4 = cVar.c.c;
                n86.e(passId2, "lPendingSuperPassId");
                n86.e(productSubType, "lPendingSuperPassSubType");
                n86.e(b, "lSource");
                n86.e(context4, "lContext");
                Intent intent = new Intent(context4, SuperPassBookingSummaryActivity.class);
                intent.putExtra("arg_superPassId", passId2);
                intent.putExtra("arg_superPassSubType", (Parcelable) productSubType);
                intent.putExtra("arg_source", b);
                intent.putExtra("arg_startDestination", "pendingSuperPassSummaryScreen");
                context4.startActivity(intent);
            }
        }
    }
}
