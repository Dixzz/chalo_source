package defpackage;

import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.models.mTicketing.cardRecharge.CardRechargeJsonKeys;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import com.google.gson.Gson;
import java.util.List;

/* renamed from: gi1  reason: default package */
/* compiled from: MixpanelUtil.kt */
public final class gi1 {

    /* renamed from: a  reason: collision with root package name */
    public static final gi1 f1265a = new gi1();

    public static final void c(ed1 ed1, MTicketTripReceipt mTicketTripReceipt) {
        n86.e(ed1, "lEvent");
        boolean z = true;
        if (mTicketTripReceipt == null || !mTicketTripReceipt.isReceiptAvailable()) {
            z = false;
        }
        if (z) {
            ed1.a("isTripReceiptAvailable", Boolean.TRUE);
        } else {
            ed1.a("isTripReceiptAvailable", Boolean.FALSE);
        }
        if (mTicketTripReceipt != null) {
            ed1.a("mticketId", mTicketTripReceipt.getTicketId());
            ed1.a("productSubType", "singleJourneyTicket");
            ed1.a("productType", "singleJourneyTicket");
            ed1.a(DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID, mTicketTripReceipt.getConductorId());
            ed1.a(DigitalTripReceiptJsonKeys.KEY_ACTIVATION_TIME, jh1.g(mTicketTripReceipt.getActivationTimeStamp()));
            ed1.a(DigitalTripReceiptJsonKeys.KEY_PUNCH_TIME, jh1.g(mTicketTripReceipt.getPunchTimeStamp()));
            ed1.a(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, mTicketTripReceipt.getVehicleNo());
        }
    }

    public static void h(gi1 gi1, String str, SuperPass superPass, String str2, long j, int i) {
        if ((i & 8) != 0) {
            j = Long.MIN_VALUE;
        }
        n86.e(str, "lEventName");
        n86.e(superPass, "lSuperPass");
        n86.e(str2, "lSourceName");
        ed1 ed1 = new ed1(str, j);
        ed1.a("source", str2);
        gi1.d(ed1, superPass);
        ui1.m0(ed1);
    }

    public static void i(gi1 gi1, String str, SuperPassSubType superPassSubType, String str2, String str3, long j, int i) {
        if ((i & 16) != 0) {
            j = Long.MIN_VALUE;
        }
        n86.e(str, "lName");
        n86.e(superPassSubType, "lSuperPassSubType");
        n86.e(str2, "lSuperPassId");
        n86.e(str3, "lSource");
        ed1 ed1 = new ed1(str, j);
        ed1.a("source", str3);
        gi1.e(ed1, superPassSubType, str2);
        ui1.m0(ed1);
    }

    public final void a(ed1 ed1, OnlineCardRecharge onlineCardRecharge) {
        n86.e(ed1, "lEvent");
        n86.e(onlineCardRecharge, "lOnlineCardRecharge");
        ed1.a(CardRechargeJsonKeys.CARD_NO, onlineCardRecharge.getCardProperties().getCardNo());
        ed1.a("cardCity", onlineCardRecharge.getCardProperties().getCity());
        ed1.a("cardAgency", onlineCardRecharge.getCardProperties().getAgency());
        ed1.a("cardTransactionId", onlineCardRecharge.getCardRechargePaymentProperties().getTransactionId());
        ed1.a("paymentTime", Long.valueOf(onlineCardRecharge.getCardRechargePaymentProperties().getPaymentTime()));
        ed1.a(CardRechargeJsonKeys.PAYMENT_STATUS, onlineCardRecharge.getCardRechargePaymentProperties().getCardRechargeInfo().getPaymentStatus().toString());
        ed1.a(CardRechargeJsonKeys.RECHARGE_STATUS, onlineCardRecharge.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeStatus().toString());
        ed1.a("rechargeAmount", Long.valueOf(onlineCardRecharge.getCardRechargePaymentProperties().getCardRechargeInfo().getRechargeAmount()));
    }

    public final void b(ed1 ed1, MTicket mTicket) {
        n86.e(ed1, "lEvent");
        if (mTicket != null) {
            ed1.a("bookingId", mTicket.getMTicketId());
            ed1.a("passengerTypes", vn.e0(mTicket.getPassengerDetails()));
            ed1.a(SuperPassJsonKeys.FARE, String.valueOf(mTicket.getTotalFare()));
            ed1.a("startDate", jh1.c(mTicket.getBookingTime()));
            ed1.a("expiryDate", jh1.c(mTicket.getExpirationTime()));
            ed1.a("city", mTicket.getCityName());
            ed1.a("agency", mTicket.getAgency());
            RouteStopsInfo upTripRouteStopsInfo = mTicket.getUpTripRouteStopsInfo();
            String str = null;
            ed1.a("upTripRouteId", upTripRouteStopsInfo == null ? null : upTripRouteStopsInfo.getRouteId());
            RouteStopsInfo upTripRouteStopsInfo2 = mTicket.getUpTripRouteStopsInfo();
            ed1.a("upTripStartStopId", upTripRouteStopsInfo2 == null ? null : upTripRouteStopsInfo2.getStartStopId());
            RouteStopsInfo upTripRouteStopsInfo3 = mTicket.getUpTripRouteStopsInfo();
            if (upTripRouteStopsInfo3 != null) {
                str = upTripRouteStopsInfo3.getEndStopId();
            }
            ed1.a("upTripEndStopId", str);
            ed1.a("isFreeRide", String.valueOf(mTicket.isFreeRide()));
        }
    }

    public final void d(ed1 ed1, SuperPass superPass) {
        n86.e(ed1, "lEvent");
        n86.e(superPass, "lSuperPass");
        ed1.a("fullName", superPass.getSuperPassUIProperties().getSuperPassUserDetails().getFullName());
        ed1.a(SuperPassJsonKeys.MOBILE_NUMBER, superPass.getSuperPassUIProperties().getSuperPassUserDetails().getMobileNumber());
        ed1.a("time", jh1.g(ui1.Q()));
        ed1.a("date", jh1.c(ui1.Q()));
        ed1.a("startDate", jh1.c(superPass.getSuperPassValidationProperties().getStartTime()));
        ed1.a("num Days", superPass.getSuperPassUIProperties().getNumOfDays() + "");
        ed1.a("productType", superPass.getSuperPassProperties().getProductType());
        ed1.a("productSubType", superPass.getSuperPassProperties().getProductSubType().name());
        ed1.a("passId", superPass.getSuperPassProperties().getPassId());
        ed1.a("transaction id", superPass.getSuperPassTransactionDetails().getTransactionId());
        ed1.a("last activation time stamp", Long.valueOf(superPass.getLastActivationTimeStamp()));
        if (superPass instanceof RideBasedSuperPass) {
            RideBasedSuperPass rideBasedSuperPass = (RideBasedSuperPass) superPass;
            ed1.a("ss total trip count", Integer.valueOf(rideBasedSuperPass.getSuperPassValidationProperties().getNumOfTrips()));
            ed1.a("total trip count available", Integer.valueOf(rideBasedSuperPass.getRemainingTotalTrips()));
            ed1.a("ss daily trip count", Integer.valueOf(rideBasedSuperPass.getSuperPassValidationProperties().getMaxTripsPerDay()));
            ed1.a("ss daily trip count available", Integer.valueOf(rideBasedSuperPass.getRemainingTripsForToday()));
            ed1.a("ss max trip price", Double.valueOf(rideBasedSuperPass.getSuperPassUIProperties().getMaxPricePerTrip()));
            List<Long> previousRideTimeStamps = rideBasedSuperPass.getSuperPassValidationProperties().getSuperPassRideDetails().getPreviousRideTimeStamps();
            ed1.a("previous ride activation time stamps size", Integer.valueOf(previousRideTimeStamps.size()));
            int i = 0;
            int q1 = hd3.q1(0, previousRideTimeStamps.size() - 1, 10);
            if (q1 >= 0) {
                while (true) {
                    int i2 = i + 10;
                    if (i2 < previousRideTimeStamps.size()) {
                        ed1.a(n86.j("previous ride activation time stamps_", Integer.valueOf(i)), new Gson().toJson(previousRideTimeStamps.subList(i, i2)));
                    } else {
                        ed1.a(n86.j("previous ride activation time stamps_", Integer.valueOf(i)), new Gson().toJson(previousRideTimeStamps.subList(i, previousRideTimeStamps.size())));
                    }
                    if (i == q1) {
                        break;
                    }
                    i = i2;
                }
            }
        }
        ed1.a("isSuperPass", Boolean.TRUE);
    }

    public final void e(ed1 ed1, SuperPassSubType superPassSubType, String str) {
        n86.e(ed1, "lEvent");
        n86.e(superPassSubType, "superPassSubType");
        n86.e(str, "superPassId");
        ed1.a("isSuperPass", Boolean.TRUE);
        ed1.a("productSubType", superPassSubType.name());
        ed1.a("passId", str);
    }

    public final void f(ed1 ed1, SuperPass superPass) {
        n86.e(ed1, "lEvent");
        if (superPass != null) {
            ed1.a("product user name", superPass.getSuperPassUIProperties().getSuperPassUserDetails().getFullName());
            ed1.a("product user phone", superPass.getSuperPassUIProperties().getSuperPassUserDetails().getMobileNumber());
            ed1.a("time", jh1.g(ui1.Q()));
            ed1.a("date", jh1.c(ui1.Q()));
            ed1.a("startDate", jh1.c(superPass.getSuperPassValidationProperties().getStartTime()));
            ed1.a("num Days", superPass.getSuperPassUIProperties().getNumOfDays() + "");
            ed1.a("productType", superPass.getSuperPassProperties().getProductType());
            ed1.a("productSubType", superPass.getSuperPassProperties().getProductSubType().name());
            ed1.a("passId", superPass.getSuperPassProperties().getPassId());
            ed1.a("transaction id", superPass.getSuperPassTransactionDetails().getTransactionId());
            ed1.a("last activation time stamp", Long.valueOf(superPass.getLastActivationTimeStamp()));
            if (superPass instanceof RideBasedSuperPass) {
                RideBasedSuperPass rideBasedSuperPass = (RideBasedSuperPass) superPass;
                ed1.a("ss total trip count", Integer.valueOf(rideBasedSuperPass.getSuperPassValidationProperties().getNumOfTrips()));
                ed1.a("total trip count available", Integer.valueOf(rideBasedSuperPass.getRemainingTotalTrips()));
                ed1.a("ss daily trip count", Integer.valueOf(rideBasedSuperPass.getSuperPassValidationProperties().getMaxTripsPerDay()));
                ed1.a("ss daily trip count available", Integer.valueOf(rideBasedSuperPass.getRemainingTripsForToday()));
                ed1.a("ss max trip price", Double.valueOf(rideBasedSuperPass.getSuperPassUIProperties().getMaxPricePerTrip()));
                List<Long> previousRideTimeStamps = rideBasedSuperPass.getSuperPassValidationProperties().getSuperPassRideDetails().getPreviousRideTimeStamps();
                ed1.a("previous ride activation time stamps size", Integer.valueOf(previousRideTimeStamps.size()));
                int i = 0;
                int q1 = hd3.q1(0, previousRideTimeStamps.size() - 1, 10);
                if (q1 >= 0) {
                    while (true) {
                        int i2 = i + 10;
                        if (i2 < previousRideTimeStamps.size()) {
                            ed1.a(n86.j("previous ride activation time stamps_", Integer.valueOf(i)), new Gson().toJson(previousRideTimeStamps.subList(i, i2)));
                        } else {
                            ed1.a(n86.j("previous ride activation time stamps_", Integer.valueOf(i)), new Gson().toJson(previousRideTimeStamps.subList(i, previousRideTimeStamps.size())));
                        }
                        if (i == q1) {
                            break;
                        }
                        i = i2;
                    }
                }
            }
            ed1.a("isSuperPass", Boolean.TRUE);
        }
    }

    public final void g(ed1 ed1, SuperPassTripReceipt superPassTripReceipt) {
        n86.e(ed1, "lEvent");
        boolean z = true;
        if (superPassTripReceipt == null || !superPassTripReceipt.isTripReceiptInfoAvailable()) {
            z = false;
        }
        if (z) {
            ed1.a("isTripReceiptAvailable", Boolean.TRUE);
        } else {
            ed1.a("isTripReceiptAvailable", Boolean.FALSE);
        }
        if (superPassTripReceipt != null) {
            ed1.a("passId", superPassTripReceipt.getPassId());
            ed1.a("productSubType", superPassTripReceipt.getProductSubType());
            ed1.a("productType", superPassTripReceipt.getProductType());
            ed1.a("route name", superPassTripReceipt.getRouteName());
            ed1.a(DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID, superPassTripReceipt.getStartStopName());
            ed1.a(DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID, superPassTripReceipt.getEndStopName());
            ed1.a(DigitalTripReceiptJsonKeys.KEY_CONDUCTOR_ID, superPassTripReceipt.getConductorId());
            ed1.a(DigitalTripReceiptJsonKeys.KEY_ACTIVATION_TIME, jh1.g(superPassTripReceipt.getActivationTimeStamp()));
            ed1.a(DigitalTripReceiptJsonKeys.KEY_PUNCH_TIME, jh1.g(superPassTripReceipt.getPunchTimeStamp()));
            ed1.a(DigitalTripReceiptJsonKeys.KEY_VEHICLE_NO, superPassTripReceipt.getVehicleNo());
        }
    }
}
