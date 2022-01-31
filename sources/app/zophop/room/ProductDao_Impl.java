package app.zophop.room;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import app.zophop.models.CustomTypeConverters;
import app.zophop.models.ScanPayBookingDetails;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.BookingPassType;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.MTicketConfiguration;
import app.zophop.models.mTicketing.MTicketTripReceipt;
import app.zophop.models.mTicketing.MagicPassPunchInfo;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.RideDetails;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.models.mTicketing.TicketStatus;
import app.zophop.models.mTicketing.UserProfile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class ProductDao_Impl implements ProductDao {
    private final CustomTypeConverters __customTypeConverters = new CustomTypeConverters();
    private final wl __db;
    private final ql<Pass> __insertionAdapterOfPass;
    private final ql<PassApplications> __insertionAdapterOfPassApplications;
    private final ql<Pass> __insertionAdapterOfPass_1;
    private final ql<RideDetails> __insertionAdapterOfRideDetails;
    private final ql<ScanPay> __insertionAdapterOfScanPay;
    private final ql<Ticket> __insertionAdapterOfTicket;
    private final bm __preparedStmtOfAddTripReceiptToMTicket;
    private final bm __preparedStmtOfDeleteAllPassData;
    private final bm __preparedStmtOfDeleteAllScanPayData;
    private final bm __preparedStmtOfDeleteAllTicketData;
    private final bm __preparedStmtOfDeletePassApplicationData;
    private final bm __preparedStmtOfUpdateActivationData;
    private final bm __preparedStmtOfUpdateExpiryState;
    private final bm __preparedStmtOfUpdateExpiryStatus;
    private final bm __preparedStmtOfUpdatePunchStatus;
    private final bm __preparedStmtOfUpdateQrCode;
    private final pl<Pass> __updateAdapterOfPass;
    private final pl<Ticket> __updateAdapterOfTicket;

    public ProductDao_Impl(wl wlVar) {
        this.__db = wlVar;
        this.__insertionAdapterOfTicket = new ql<Ticket>(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass1 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Ticket` (`ticketId`,`mticket__mTicketId`,`mticket__userId`,`mticket__deviceId`,`mticket__cityName`,`mticket__agency`,`mticket__upTripRouteStopsInfo`,`mticket__upTripRouteStopsStageInfo`,`mticket__passengerDetails`,`mticket__bookingTime`,`mticket__expirationTime`,`mticket__isExpired`,`mticket__upTripActivationTime`,`mticket__isUpTripActivated`,`mticket__upTripPunchingTime`,`mticket__userProfile`,`mticket__qrCode`,`mticket__tone`,`mticket__mTicketConfiguration`,`mticket__isFreeRide`,`mticket__isPaymentRequired`,`mticket__recentPaymentMethod`,`mticket__cardDetails`,`mticket__customerId`,`mticket__orderId`,`mticket__status`,`mticket__paymentMode`,`mticket__mticketTripReceipt`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, Ticket ticket) {
                String str = ticket.ticketId;
                if (str == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, str);
                }
                MTicket mTicket = ticket.mTicket;
                if (mTicket != null) {
                    if (mTicket.getMTicketId() == null) {
                        smVar.E0(2);
                    } else {
                        smVar.z(2, mTicket.getMTicketId());
                    }
                    if (mTicket.getUserId() == null) {
                        smVar.E0(3);
                    } else {
                        smVar.z(3, mTicket.getUserId());
                    }
                    if (mTicket.getDeviceId() == null) {
                        smVar.E0(4);
                    } else {
                        smVar.z(4, mTicket.getDeviceId());
                    }
                    if (mTicket.getCityName() == null) {
                        smVar.E0(5);
                    } else {
                        smVar.z(5, mTicket.getCityName());
                    }
                    if (mTicket.getAgency() == null) {
                        smVar.E0(6);
                    } else {
                        smVar.z(6, mTicket.getAgency());
                    }
                    String routeStopsInfo = RouteStopsInfo.toString(mTicket.getUpTripRouteStopsInfo());
                    if (routeStopsInfo == null) {
                        smVar.E0(7);
                    } else {
                        smVar.z(7, routeStopsInfo);
                    }
                    String routeStopsInfo2 = RouteStopsInfo.toString(mTicket.getUpTripRouteStopsStageInfo());
                    if (routeStopsInfo2 == null) {
                        smVar.E0(8);
                    } else {
                        smVar.z(8, routeStopsInfo2);
                    }
                    String fromStringMap = MTicket.fromStringMap(mTicket.getPassengerDetails());
                    if (fromStringMap == null) {
                        smVar.E0(9);
                    } else {
                        smVar.z(9, fromStringMap);
                    }
                    smVar.d0(10, mTicket.getBookingTime());
                    smVar.d0(11, mTicket.getExpirationTime());
                    smVar.d0(12, mTicket.isExpired() ? 1 : 0);
                    smVar.d0(13, mTicket.getUpTripActivationTime());
                    smVar.d0(14, mTicket.isUpTripActivated() ? 1 : 0);
                    smVar.d0(15, mTicket.getUpTripPunchingTime());
                    String userProfile = UserProfile.toString(mTicket.get_userProfile());
                    if (userProfile == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, userProfile);
                    }
                    if (mTicket.getQrCode() == null) {
                        smVar.E0(17);
                    } else {
                        smVar.z(17, mTicket.getQrCode());
                    }
                    if (mTicket.getTone() == null) {
                        smVar.E0(18);
                    } else {
                        smVar.z(18, mTicket.getTone());
                    }
                    String mTicketConfiguration = MTicketConfiguration.toString(mTicket.getMTicketConfiguration());
                    if (mTicketConfiguration == null) {
                        smVar.E0(19);
                    } else {
                        smVar.z(19, mTicketConfiguration);
                    }
                    smVar.d0(20, mTicket.isFreeRide() ? 1 : 0);
                    smVar.d0(21, mTicket.isPaymentRequired() ? 1 : 0);
                    String mTicket2 = MTicket.toString(mTicket.getRecentPaymentMethod());
                    if (mTicket2 == null) {
                        smVar.E0(22);
                    } else {
                        smVar.z(22, mTicket2);
                    }
                    String cardString = MTicket.toCardString(mTicket.getCardDetails());
                    if (cardString == null) {
                        smVar.E0(23);
                    } else {
                        smVar.z(23, cardString);
                    }
                    if (mTicket.getCustomerId() == null) {
                        smVar.E0(24);
                    } else {
                        smVar.z(24, mTicket.getCustomerId());
                    }
                    if (mTicket.getOrderId() == null) {
                        smVar.E0(25);
                    } else {
                        smVar.z(25, mTicket.getOrderId());
                    }
                    if (mTicket.getStatus() == null) {
                        smVar.E0(26);
                    } else {
                        smVar.z(26, mTicket.getStatus());
                    }
                    if (mTicket.getPaymentMode() == null) {
                        smVar.E0(27);
                    } else {
                        smVar.z(27, mTicket.getPaymentMode());
                    }
                    String mTicketTripReceiptString = ProductDao_Impl.this.__customTypeConverters.toMTicketTripReceiptString(mTicket.getMticketTripReceipt());
                    if (mTicketTripReceiptString == null) {
                        smVar.E0(28);
                    } else {
                        smVar.z(28, mTicketTripReceiptString);
                    }
                } else {
                    hj1.D0(smVar, 2, 3, 4, 5);
                    hj1.D0(smVar, 6, 7, 8, 9);
                    hj1.D0(smVar, 10, 11, 12, 13);
                    hj1.D0(smVar, 14, 15, 16, 17);
                    hj1.D0(smVar, 18, 19, 20, 21);
                    hj1.D0(smVar, 22, 23, 24, 25);
                    smVar.E0(26);
                    smVar.E0(27);
                    smVar.E0(28);
                }
            }
        };
        this.__insertionAdapterOfPass = new ql<Pass>(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass2 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Pass` (`passId`,`pass__bookingPassId`,`pass__referenceId`,`pass__bookingPassType`,`pass__userProfile`,`pass__bookingTime`,`pass__expiryTime`,`pass__startingTime`,`pass__passengerType`,`pass__ticketStatus`,`pass__agency`,`pass__fare`,`pass__noOfDays`,`pass__displayProps`,`pass__punches`,`pass__qrCode`,`pass__status`,`pass__paymentMode`,`pass__validity`,`pass__verificationExpiryTime`,`pass__cityName`,`pass__passRejectionReason`,`pass__isVerificationRequired`,`pass__hasPassExpired`,`pass__deviceId`,`pass__customerId`,`pass__recentPaymentMethod`,`pass__cardDetails`,`pass__configId`,`pass_orderId`,`pass__isPaymentRequired`,`pass__specialFeatures`,`pass__routeStopsInfo`,`pass__productName`,`pass__grouping`,`pass__productType`,`pass__productCategory`,`pass__remainingTrips`,`pass__maxTrips`,`pass__maxTripsPerDay`,`pass__catDisName`,`pass__maxTripsPrice`,`pass__tone`,`pass__passApplicationRejectionReasons`,`pass__passApplicationActionRequired`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, Pass pass) {
                String str = pass.passId;
                if (str == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, str);
                }
                MPass mPass = pass.pass;
                if (mPass != null) {
                    if (mPass.getBookingPassId() == null) {
                        smVar.E0(2);
                    } else {
                        smVar.z(2, mPass.getBookingPassId());
                    }
                    if (mPass.getReferenceId() == null) {
                        smVar.E0(3);
                    } else {
                        smVar.z(3, mPass.getReferenceId());
                    }
                    String bookingPassType = BookingPassType.toString(mPass.get_bookingPassType());
                    if (bookingPassType == null) {
                        smVar.E0(4);
                    } else {
                        smVar.z(4, bookingPassType);
                    }
                    String userProfile = UserProfile.toString(mPass.getUserProfile());
                    if (userProfile == null) {
                        smVar.E0(5);
                    } else {
                        smVar.z(5, userProfile);
                    }
                    smVar.d0(6, mPass.getBookingTime());
                    smVar.d0(7, mPass.getExpiryTime());
                    smVar.d0(8, mPass.getStartingTime());
                    if (mPass.getPassengerType() == null) {
                        smVar.E0(9);
                    } else {
                        smVar.z(9, mPass.getPassengerType());
                    }
                    String converterString = TicketStatus.toConverterString(mPass.getTicketStatus());
                    if (converterString == null) {
                        smVar.E0(10);
                    } else {
                        smVar.z(10, converterString);
                    }
                    if (mPass.getAgency() == null) {
                        smVar.E0(11);
                    } else {
                        smVar.z(11, mPass.getAgency());
                    }
                    smVar.N(12, mPass.getFare());
                    smVar.d0(13, (long) mPass.getNoOfDays());
                    String fromStringMap = MPass.fromStringMap(mPass.getDisplayProps());
                    if (fromStringMap == null) {
                        smVar.E0(14);
                    } else {
                        smVar.z(14, fromStringMap);
                    }
                    String punchString = MPass.toPunchString(mPass.getPunches());
                    if (punchString == null) {
                        smVar.E0(15);
                    } else {
                        smVar.z(15, punchString);
                    }
                    if (mPass.getQrCode() == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, mPass.getQrCode());
                    }
                    if (mPass.getStatus() == null) {
                        smVar.E0(17);
                    } else {
                        smVar.z(17, mPass.getStatus());
                    }
                    if (mPass.getPaymentMode() == null) {
                        smVar.E0(18);
                    } else {
                        smVar.z(18, mPass.getPaymentMode());
                    }
                    smVar.d0(19, (long) mPass.getValidity());
                    smVar.d0(20, mPass.getVerificationExpiryTime());
                    if (mPass.get_cityName() == null) {
                        smVar.E0(21);
                    } else {
                        smVar.z(21, mPass.get_cityName());
                    }
                    if (mPass.getPassRejectionReason() == null) {
                        smVar.E0(22);
                    } else {
                        smVar.z(22, mPass.getPassRejectionReason());
                    }
                    smVar.d0(23, mPass.is_isVerificationRequired() ? 1 : 0);
                    smVar.d0(24, mPass.is_hasPassExpired() ? 1 : 0);
                    if (mPass.getDeviceId() == null) {
                        smVar.E0(25);
                    } else {
                        smVar.z(25, mPass.getDeviceId());
                    }
                    if (mPass.getCustomerId() == null) {
                        smVar.E0(26);
                    } else {
                        smVar.z(26, mPass.getCustomerId());
                    }
                    String mTicket = MTicket.toString(mPass.getRecentPaymentMethod());
                    if (mTicket == null) {
                        smVar.E0(27);
                    } else {
                        smVar.z(27, mTicket);
                    }
                    String cardString = MTicket.toCardString(mPass.getCardDetails());
                    if (cardString == null) {
                        smVar.E0(28);
                    } else {
                        smVar.z(28, cardString);
                    }
                    if (mPass.getConfigId() == null) {
                        smVar.E0(29);
                    } else {
                        smVar.z(29, mPass.getConfigId());
                    }
                    if (mPass.getOrderId() == null) {
                        smVar.E0(30);
                    } else {
                        smVar.z(30, mPass.getOrderId());
                    }
                    smVar.d0(31, mPass.isPaymentRequired() ? 1 : 0);
                    String customTypeConverters = ProductDao_Impl.this.__customTypeConverters.toString(mPass.getSpecialFeatures());
                    if (customTypeConverters == null) {
                        smVar.E0(32);
                    } else {
                        smVar.z(32, customTypeConverters);
                    }
                    String routeStopsInfo = RouteStopsInfo.toString(mPass.getRouteStopsInfo());
                    if (routeStopsInfo == null) {
                        smVar.E0(33);
                    } else {
                        smVar.z(33, routeStopsInfo);
                    }
                    if (mPass.get_productName() == null) {
                        smVar.E0(34);
                    } else {
                        smVar.z(34, mPass.get_productName());
                    }
                    String productCategory = ProductCategory.toString(mPass.get_grouping());
                    if (productCategory == null) {
                        smVar.E0(35);
                    } else {
                        smVar.z(35, productCategory);
                    }
                    if (mPass.get_productType() == null) {
                        smVar.E0(36);
                    } else {
                        smVar.z(36, mPass.get_productType());
                    }
                    if (mPass.get_productCategory() == null) {
                        smVar.E0(37);
                    } else {
                        smVar.z(37, mPass.get_productCategory());
                    }
                    smVar.d0(38, (long) mPass.get_remainingTrips());
                    smVar.d0(39, (long) mPass.get_maxTrips());
                    smVar.d0(40, (long) mPass.get_maxTripsPerDay());
                    if (mPass.get_catDisName() == null) {
                        smVar.E0(41);
                    } else {
                        smVar.z(41, mPass.get_catDisName());
                    }
                    smVar.d0(42, (long) mPass.get_maxTripsPrice());
                    if (mPass.getTone() == null) {
                        smVar.E0(43);
                    } else {
                        smVar.z(43, mPass.getTone());
                    }
                    String passApplicationRejectionReasonsString = ProductDao_Impl.this.__customTypeConverters.toPassApplicationRejectionReasonsString(mPass.get_passApplicationRejectionReasons());
                    if (passApplicationRejectionReasonsString == null) {
                        smVar.E0(44);
                    } else {
                        smVar.z(44, passApplicationRejectionReasonsString);
                    }
                    String converterString2 = ProductDao_Impl.this.__customTypeConverters.toConverterString(mPass.get_passApplicationActionRequired());
                    if (converterString2 == null) {
                        smVar.E0(45);
                    } else {
                        smVar.z(45, converterString2);
                    }
                } else {
                    hj1.D0(smVar, 2, 3, 4, 5);
                    hj1.D0(smVar, 6, 7, 8, 9);
                    hj1.D0(smVar, 10, 11, 12, 13);
                    hj1.D0(smVar, 14, 15, 16, 17);
                    hj1.D0(smVar, 18, 19, 20, 21);
                    hj1.D0(smVar, 22, 23, 24, 25);
                    hj1.D0(smVar, 26, 27, 28, 29);
                    hj1.D0(smVar, 30, 31, 32, 33);
                    hj1.D0(smVar, 34, 35, 36, 37);
                    hj1.D0(smVar, 38, 39, 40, 41);
                    hj1.D0(smVar, 42, 43, 44, 45);
                }
            }
        };
        this.__insertionAdapterOfPass_1 = new ql<Pass>(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass3 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR IGNORE INTO `Pass` (`passId`,`pass__bookingPassId`,`pass__referenceId`,`pass__bookingPassType`,`pass__userProfile`,`pass__bookingTime`,`pass__expiryTime`,`pass__startingTime`,`pass__passengerType`,`pass__ticketStatus`,`pass__agency`,`pass__fare`,`pass__noOfDays`,`pass__displayProps`,`pass__punches`,`pass__qrCode`,`pass__status`,`pass__paymentMode`,`pass__validity`,`pass__verificationExpiryTime`,`pass__cityName`,`pass__passRejectionReason`,`pass__isVerificationRequired`,`pass__hasPassExpired`,`pass__deviceId`,`pass__customerId`,`pass__recentPaymentMethod`,`pass__cardDetails`,`pass__configId`,`pass_orderId`,`pass__isPaymentRequired`,`pass__specialFeatures`,`pass__routeStopsInfo`,`pass__productName`,`pass__grouping`,`pass__productType`,`pass__productCategory`,`pass__remainingTrips`,`pass__maxTrips`,`pass__maxTripsPerDay`,`pass__catDisName`,`pass__maxTripsPrice`,`pass__tone`,`pass__passApplicationRejectionReasons`,`pass__passApplicationActionRequired`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, Pass pass) {
                String str = pass.passId;
                if (str == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, str);
                }
                MPass mPass = pass.pass;
                if (mPass != null) {
                    if (mPass.getBookingPassId() == null) {
                        smVar.E0(2);
                    } else {
                        smVar.z(2, mPass.getBookingPassId());
                    }
                    if (mPass.getReferenceId() == null) {
                        smVar.E0(3);
                    } else {
                        smVar.z(3, mPass.getReferenceId());
                    }
                    String bookingPassType = BookingPassType.toString(mPass.get_bookingPassType());
                    if (bookingPassType == null) {
                        smVar.E0(4);
                    } else {
                        smVar.z(4, bookingPassType);
                    }
                    String userProfile = UserProfile.toString(mPass.getUserProfile());
                    if (userProfile == null) {
                        smVar.E0(5);
                    } else {
                        smVar.z(5, userProfile);
                    }
                    smVar.d0(6, mPass.getBookingTime());
                    smVar.d0(7, mPass.getExpiryTime());
                    smVar.d0(8, mPass.getStartingTime());
                    if (mPass.getPassengerType() == null) {
                        smVar.E0(9);
                    } else {
                        smVar.z(9, mPass.getPassengerType());
                    }
                    String converterString = TicketStatus.toConverterString(mPass.getTicketStatus());
                    if (converterString == null) {
                        smVar.E0(10);
                    } else {
                        smVar.z(10, converterString);
                    }
                    if (mPass.getAgency() == null) {
                        smVar.E0(11);
                    } else {
                        smVar.z(11, mPass.getAgency());
                    }
                    smVar.N(12, mPass.getFare());
                    smVar.d0(13, (long) mPass.getNoOfDays());
                    String fromStringMap = MPass.fromStringMap(mPass.getDisplayProps());
                    if (fromStringMap == null) {
                        smVar.E0(14);
                    } else {
                        smVar.z(14, fromStringMap);
                    }
                    String punchString = MPass.toPunchString(mPass.getPunches());
                    if (punchString == null) {
                        smVar.E0(15);
                    } else {
                        smVar.z(15, punchString);
                    }
                    if (mPass.getQrCode() == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, mPass.getQrCode());
                    }
                    if (mPass.getStatus() == null) {
                        smVar.E0(17);
                    } else {
                        smVar.z(17, mPass.getStatus());
                    }
                    if (mPass.getPaymentMode() == null) {
                        smVar.E0(18);
                    } else {
                        smVar.z(18, mPass.getPaymentMode());
                    }
                    smVar.d0(19, (long) mPass.getValidity());
                    smVar.d0(20, mPass.getVerificationExpiryTime());
                    if (mPass.get_cityName() == null) {
                        smVar.E0(21);
                    } else {
                        smVar.z(21, mPass.get_cityName());
                    }
                    if (mPass.getPassRejectionReason() == null) {
                        smVar.E0(22);
                    } else {
                        smVar.z(22, mPass.getPassRejectionReason());
                    }
                    smVar.d0(23, mPass.is_isVerificationRequired() ? 1 : 0);
                    smVar.d0(24, mPass.is_hasPassExpired() ? 1 : 0);
                    if (mPass.getDeviceId() == null) {
                        smVar.E0(25);
                    } else {
                        smVar.z(25, mPass.getDeviceId());
                    }
                    if (mPass.getCustomerId() == null) {
                        smVar.E0(26);
                    } else {
                        smVar.z(26, mPass.getCustomerId());
                    }
                    String mTicket = MTicket.toString(mPass.getRecentPaymentMethod());
                    if (mTicket == null) {
                        smVar.E0(27);
                    } else {
                        smVar.z(27, mTicket);
                    }
                    String cardString = MTicket.toCardString(mPass.getCardDetails());
                    if (cardString == null) {
                        smVar.E0(28);
                    } else {
                        smVar.z(28, cardString);
                    }
                    if (mPass.getConfigId() == null) {
                        smVar.E0(29);
                    } else {
                        smVar.z(29, mPass.getConfigId());
                    }
                    if (mPass.getOrderId() == null) {
                        smVar.E0(30);
                    } else {
                        smVar.z(30, mPass.getOrderId());
                    }
                    smVar.d0(31, mPass.isPaymentRequired() ? 1 : 0);
                    String customTypeConverters = ProductDao_Impl.this.__customTypeConverters.toString(mPass.getSpecialFeatures());
                    if (customTypeConverters == null) {
                        smVar.E0(32);
                    } else {
                        smVar.z(32, customTypeConverters);
                    }
                    String routeStopsInfo = RouteStopsInfo.toString(mPass.getRouteStopsInfo());
                    if (routeStopsInfo == null) {
                        smVar.E0(33);
                    } else {
                        smVar.z(33, routeStopsInfo);
                    }
                    if (mPass.get_productName() == null) {
                        smVar.E0(34);
                    } else {
                        smVar.z(34, mPass.get_productName());
                    }
                    String productCategory = ProductCategory.toString(mPass.get_grouping());
                    if (productCategory == null) {
                        smVar.E0(35);
                    } else {
                        smVar.z(35, productCategory);
                    }
                    if (mPass.get_productType() == null) {
                        smVar.E0(36);
                    } else {
                        smVar.z(36, mPass.get_productType());
                    }
                    if (mPass.get_productCategory() == null) {
                        smVar.E0(37);
                    } else {
                        smVar.z(37, mPass.get_productCategory());
                    }
                    smVar.d0(38, (long) mPass.get_remainingTrips());
                    smVar.d0(39, (long) mPass.get_maxTrips());
                    smVar.d0(40, (long) mPass.get_maxTripsPerDay());
                    if (mPass.get_catDisName() == null) {
                        smVar.E0(41);
                    } else {
                        smVar.z(41, mPass.get_catDisName());
                    }
                    smVar.d0(42, (long) mPass.get_maxTripsPrice());
                    if (mPass.getTone() == null) {
                        smVar.E0(43);
                    } else {
                        smVar.z(43, mPass.getTone());
                    }
                    String passApplicationRejectionReasonsString = ProductDao_Impl.this.__customTypeConverters.toPassApplicationRejectionReasonsString(mPass.get_passApplicationRejectionReasons());
                    if (passApplicationRejectionReasonsString == null) {
                        smVar.E0(44);
                    } else {
                        smVar.z(44, passApplicationRejectionReasonsString);
                    }
                    String converterString2 = ProductDao_Impl.this.__customTypeConverters.toConverterString(mPass.get_passApplicationActionRequired());
                    if (converterString2 == null) {
                        smVar.E0(45);
                    } else {
                        smVar.z(45, converterString2);
                    }
                } else {
                    hj1.D0(smVar, 2, 3, 4, 5);
                    hj1.D0(smVar, 6, 7, 8, 9);
                    hj1.D0(smVar, 10, 11, 12, 13);
                    hj1.D0(smVar, 14, 15, 16, 17);
                    hj1.D0(smVar, 18, 19, 20, 21);
                    hj1.D0(smVar, 22, 23, 24, 25);
                    hj1.D0(smVar, 26, 27, 28, 29);
                    hj1.D0(smVar, 30, 31, 32, 33);
                    hj1.D0(smVar, 34, 35, 36, 37);
                    hj1.D0(smVar, 38, 39, 40, 41);
                    hj1.D0(smVar, 42, 43, 44, 45);
                }
            }
        };
        this.__insertionAdapterOfPassApplications = new ql<PassApplications>(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass4 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `PassApplications` (`cityName`,`agencyName`,`passengerType`,`pass_app__bookingPassId`,`pass_app__referenceId`,`pass_app__bookingPassType`,`pass_app__userProfile`,`pass_app__bookingTime`,`pass_app__expiryTime`,`pass_app__startingTime`,`pass_app__passengerType`,`pass_app__ticketStatus`,`pass_app__agency`,`pass_app__fare`,`pass_app__noOfDays`,`pass_app__displayProps`,`pass_app__punches`,`pass_app__qrCode`,`pass_app__status`,`pass_app__paymentMode`,`pass_app__validity`,`pass_app__verificationExpiryTime`,`pass_app__cityName`,`pass_app__passRejectionReason`,`pass_app__isVerificationRequired`,`pass_app__hasPassExpired`,`pass_app__deviceId`,`pass_app__customerId`,`pass_app__recentPaymentMethod`,`pass_app__cardDetails`,`pass_app__configId`,`pass_app_orderId`,`pass_app__isPaymentRequired`,`pass_app__specialFeatures`,`pass_app__routeStopsInfo`,`pass_app__productName`,`pass_app__grouping`,`pass_app__productType`,`pass_app__productCategory`,`pass_app__remainingTrips`,`pass_app__maxTrips`,`pass_app__maxTripsPerDay`,`pass_app__catDisName`,`pass_app__maxTripsPrice`,`pass_app__tone`,`pass_app__passApplicationRejectionReasons`,`pass_app__passApplicationActionRequired`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, PassApplications passApplications) {
                if (passApplications.getCityName() == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, passApplications.getCityName());
                }
                if (passApplications.getAgencyName() == null) {
                    smVar.E0(2);
                } else {
                    smVar.z(2, passApplications.getAgencyName());
                }
                if (passApplications.getPassengerType() == null) {
                    smVar.E0(3);
                } else {
                    smVar.z(3, passApplications.getPassengerType());
                }
                MPass mPass = passApplications.pass;
                if (mPass != null) {
                    if (mPass.getBookingPassId() == null) {
                        smVar.E0(4);
                    } else {
                        smVar.z(4, mPass.getBookingPassId());
                    }
                    if (mPass.getReferenceId() == null) {
                        smVar.E0(5);
                    } else {
                        smVar.z(5, mPass.getReferenceId());
                    }
                    String bookingPassType = BookingPassType.toString(mPass.get_bookingPassType());
                    if (bookingPassType == null) {
                        smVar.E0(6);
                    } else {
                        smVar.z(6, bookingPassType);
                    }
                    String userProfile = UserProfile.toString(mPass.getUserProfile());
                    if (userProfile == null) {
                        smVar.E0(7);
                    } else {
                        smVar.z(7, userProfile);
                    }
                    smVar.d0(8, mPass.getBookingTime());
                    smVar.d0(9, mPass.getExpiryTime());
                    smVar.d0(10, mPass.getStartingTime());
                    if (mPass.getPassengerType() == null) {
                        smVar.E0(11);
                    } else {
                        smVar.z(11, mPass.getPassengerType());
                    }
                    String converterString = TicketStatus.toConverterString(mPass.getTicketStatus());
                    if (converterString == null) {
                        smVar.E0(12);
                    } else {
                        smVar.z(12, converterString);
                    }
                    if (mPass.getAgency() == null) {
                        smVar.E0(13);
                    } else {
                        smVar.z(13, mPass.getAgency());
                    }
                    smVar.N(14, mPass.getFare());
                    smVar.d0(15, (long) mPass.getNoOfDays());
                    String fromStringMap = MPass.fromStringMap(mPass.getDisplayProps());
                    if (fromStringMap == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, fromStringMap);
                    }
                    String punchString = MPass.toPunchString(mPass.getPunches());
                    if (punchString == null) {
                        smVar.E0(17);
                    } else {
                        smVar.z(17, punchString);
                    }
                    if (mPass.getQrCode() == null) {
                        smVar.E0(18);
                    } else {
                        smVar.z(18, mPass.getQrCode());
                    }
                    if (mPass.getStatus() == null) {
                        smVar.E0(19);
                    } else {
                        smVar.z(19, mPass.getStatus());
                    }
                    if (mPass.getPaymentMode() == null) {
                        smVar.E0(20);
                    } else {
                        smVar.z(20, mPass.getPaymentMode());
                    }
                    smVar.d0(21, (long) mPass.getValidity());
                    smVar.d0(22, mPass.getVerificationExpiryTime());
                    if (mPass.get_cityName() == null) {
                        smVar.E0(23);
                    } else {
                        smVar.z(23, mPass.get_cityName());
                    }
                    if (mPass.getPassRejectionReason() == null) {
                        smVar.E0(24);
                    } else {
                        smVar.z(24, mPass.getPassRejectionReason());
                    }
                    smVar.d0(25, mPass.is_isVerificationRequired() ? 1 : 0);
                    smVar.d0(26, mPass.is_hasPassExpired() ? 1 : 0);
                    if (mPass.getDeviceId() == null) {
                        smVar.E0(27);
                    } else {
                        smVar.z(27, mPass.getDeviceId());
                    }
                    if (mPass.getCustomerId() == null) {
                        smVar.E0(28);
                    } else {
                        smVar.z(28, mPass.getCustomerId());
                    }
                    String mTicket = MTicket.toString(mPass.getRecentPaymentMethod());
                    if (mTicket == null) {
                        smVar.E0(29);
                    } else {
                        smVar.z(29, mTicket);
                    }
                    String cardString = MTicket.toCardString(mPass.getCardDetails());
                    if (cardString == null) {
                        smVar.E0(30);
                    } else {
                        smVar.z(30, cardString);
                    }
                    if (mPass.getConfigId() == null) {
                        smVar.E0(31);
                    } else {
                        smVar.z(31, mPass.getConfigId());
                    }
                    if (mPass.getOrderId() == null) {
                        smVar.E0(32);
                    } else {
                        smVar.z(32, mPass.getOrderId());
                    }
                    smVar.d0(33, mPass.isPaymentRequired() ? 1 : 0);
                    String customTypeConverters = ProductDao_Impl.this.__customTypeConverters.toString(mPass.getSpecialFeatures());
                    if (customTypeConverters == null) {
                        smVar.E0(34);
                    } else {
                        smVar.z(34, customTypeConverters);
                    }
                    String routeStopsInfo = RouteStopsInfo.toString(mPass.getRouteStopsInfo());
                    if (routeStopsInfo == null) {
                        smVar.E0(35);
                    } else {
                        smVar.z(35, routeStopsInfo);
                    }
                    if (mPass.get_productName() == null) {
                        smVar.E0(36);
                    } else {
                        smVar.z(36, mPass.get_productName());
                    }
                    String productCategory = ProductCategory.toString(mPass.get_grouping());
                    if (productCategory == null) {
                        smVar.E0(37);
                    } else {
                        smVar.z(37, productCategory);
                    }
                    if (mPass.get_productType() == null) {
                        smVar.E0(38);
                    } else {
                        smVar.z(38, mPass.get_productType());
                    }
                    if (mPass.get_productCategory() == null) {
                        smVar.E0(39);
                    } else {
                        smVar.z(39, mPass.get_productCategory());
                    }
                    smVar.d0(40, (long) mPass.get_remainingTrips());
                    smVar.d0(41, (long) mPass.get_maxTrips());
                    smVar.d0(42, (long) mPass.get_maxTripsPerDay());
                    if (mPass.get_catDisName() == null) {
                        smVar.E0(43);
                    } else {
                        smVar.z(43, mPass.get_catDisName());
                    }
                    smVar.d0(44, (long) mPass.get_maxTripsPrice());
                    if (mPass.getTone() == null) {
                        smVar.E0(45);
                    } else {
                        smVar.z(45, mPass.getTone());
                    }
                    String passApplicationRejectionReasonsString = ProductDao_Impl.this.__customTypeConverters.toPassApplicationRejectionReasonsString(mPass.get_passApplicationRejectionReasons());
                    if (passApplicationRejectionReasonsString == null) {
                        smVar.E0(46);
                    } else {
                        smVar.z(46, passApplicationRejectionReasonsString);
                    }
                    String converterString2 = ProductDao_Impl.this.__customTypeConverters.toConverterString(mPass.get_passApplicationActionRequired());
                    if (converterString2 == null) {
                        smVar.E0(47);
                    } else {
                        smVar.z(47, converterString2);
                    }
                } else {
                    hj1.D0(smVar, 4, 5, 6, 7);
                    hj1.D0(smVar, 8, 9, 10, 11);
                    hj1.D0(smVar, 12, 13, 14, 15);
                    hj1.D0(smVar, 16, 17, 18, 19);
                    hj1.D0(smVar, 20, 21, 22, 23);
                    hj1.D0(smVar, 24, 25, 26, 27);
                    hj1.D0(smVar, 28, 29, 30, 31);
                    hj1.D0(smVar, 32, 33, 34, 35);
                    hj1.D0(smVar, 36, 37, 38, 39);
                    hj1.D0(smVar, 40, 41, 42, 43);
                    hj1.D0(smVar, 44, 45, 46, 47);
                }
            }
        };
        this.__insertionAdapterOfScanPay = new ql<ScanPay>(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass5 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ScanPay` (`bookingId`,`scan_pay__uuid`,`scan_pay__fare`,`scan_pay__discountedFare`,`scan_pay__userId`,`scan_pay__deviceId`,`scan_pay__agencyName`,`scan_pay__bookingDetails`,`scan_pay__transactionId`,`scan_pay__bookingTime`,`scan_pay__expirationTime`,`scan_pay__recentPaymentMethod`,`scan_pay__cardDetails`,`scan_pay__customerId`,`scan_pay__orderId`,`scan_pay__status`,`scan_pay__qrCode`,`scan_pay__isExpired`,`scan_pay__cityName`,`scan_pay__tone`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, ScanPay scanPay) {
                String str = scanPay.bookingId;
                if (str == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, str);
                }
                ScanPayTicket scanPayTicket = scanPay.scanPayTicket;
                if (scanPayTicket != null) {
                    if (scanPayTicket.get_uuid() == null) {
                        smVar.E0(2);
                    } else {
                        smVar.z(2, scanPayTicket.get_uuid());
                    }
                    smVar.N(3, scanPayTicket.get_fare());
                    smVar.N(4, scanPayTicket.get_discountedFare());
                    if (scanPayTicket.get_userId() == null) {
                        smVar.E0(5);
                    } else {
                        smVar.z(5, scanPayTicket.get_userId());
                    }
                    if (scanPayTicket.get_deviceId() == null) {
                        smVar.E0(6);
                    } else {
                        smVar.z(6, scanPayTicket.get_deviceId());
                    }
                    if (scanPayTicket.get_agencyName() == null) {
                        smVar.E0(7);
                    } else {
                        smVar.z(7, scanPayTicket.get_agencyName());
                    }
                    String scanPayBookingDetails = ScanPayBookingDetails.toString(scanPayTicket.get_bookingDetails());
                    if (scanPayBookingDetails == null) {
                        smVar.E0(8);
                    } else {
                        smVar.z(8, scanPayBookingDetails);
                    }
                    if (scanPayTicket.get_transactionId() == null) {
                        smVar.E0(9);
                    } else {
                        smVar.z(9, scanPayTicket.get_transactionId());
                    }
                    smVar.d0(10, scanPayTicket.get_bookingTime());
                    smVar.d0(11, scanPayTicket.get_expirationTime());
                    String mTicket = MTicket.toString(scanPayTicket.get_recentPaymentMethod());
                    if (mTicket == null) {
                        smVar.E0(12);
                    } else {
                        smVar.z(12, mTicket);
                    }
                    String cardString = MTicket.toCardString(scanPayTicket.get_cardDetails());
                    if (cardString == null) {
                        smVar.E0(13);
                    } else {
                        smVar.z(13, cardString);
                    }
                    if (scanPayTicket.get_customerId() == null) {
                        smVar.E0(14);
                    } else {
                        smVar.z(14, scanPayTicket.get_customerId());
                    }
                    if (scanPayTicket.get_orderId() == null) {
                        smVar.E0(15);
                    } else {
                        smVar.z(15, scanPayTicket.get_orderId());
                    }
                    if (scanPayTicket.get_status() == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, scanPayTicket.get_status());
                    }
                    if (scanPayTicket.get_qrCode() == null) {
                        smVar.E0(17);
                    } else {
                        smVar.z(17, scanPayTicket.get_qrCode());
                    }
                    smVar.d0(18, scanPayTicket.is_isExpired() ? 1 : 0);
                    if (scanPayTicket.get_cityName() == null) {
                        smVar.E0(19);
                    } else {
                        smVar.z(19, scanPayTicket.get_cityName());
                    }
                    if (scanPayTicket.get_tone() == null) {
                        smVar.E0(20);
                    } else {
                        smVar.z(20, scanPayTicket.get_tone());
                    }
                } else {
                    hj1.D0(smVar, 2, 3, 4, 5);
                    hj1.D0(smVar, 6, 7, 8, 9);
                    hj1.D0(smVar, 10, 11, 12, 13);
                    hj1.D0(smVar, 14, 15, 16, 17);
                    smVar.E0(18);
                    smVar.E0(19);
                    smVar.E0(20);
                }
            }
        };
        this.__insertionAdapterOfRideDetails = new ql<RideDetails>(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass6 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `RideDetails` (`_passId`,`_rideInfoList`,`_dailyRidesCount`,`_totalRideCount`) VALUES (?,?,?,?)";
            }

            public void bind(sm smVar, RideDetails rideDetails) {
                if (rideDetails.get_passId() == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, rideDetails.get_passId());
                }
                String rideDetails2 = RideDetails.toString(rideDetails.get_rideInfoList());
                if (rideDetails2 == null) {
                    smVar.E0(2);
                } else {
                    smVar.z(2, rideDetails2);
                }
                if (rideDetails.get_dailyRidesCount() == null) {
                    smVar.E0(3);
                } else {
                    smVar.z(3, rideDetails.get_dailyRidesCount());
                }
                if (rideDetails.get_totalRideCount() == null) {
                    smVar.E0(4);
                } else {
                    smVar.z(4, rideDetails.get_totalRideCount());
                }
            }
        };
        this.__updateAdapterOfTicket = new pl<Ticket>(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass7 */

            @Override // defpackage.bm, defpackage.pl
            public String createQuery() {
                return "UPDATE OR REPLACE `Ticket` SET `ticketId` = ?,`mticket__mTicketId` = ?,`mticket__userId` = ?,`mticket__deviceId` = ?,`mticket__cityName` = ?,`mticket__agency` = ?,`mticket__upTripRouteStopsInfo` = ?,`mticket__upTripRouteStopsStageInfo` = ?,`mticket__passengerDetails` = ?,`mticket__bookingTime` = ?,`mticket__expirationTime` = ?,`mticket__isExpired` = ?,`mticket__upTripActivationTime` = ?,`mticket__isUpTripActivated` = ?,`mticket__upTripPunchingTime` = ?,`mticket__userProfile` = ?,`mticket__qrCode` = ?,`mticket__tone` = ?,`mticket__mTicketConfiguration` = ?,`mticket__isFreeRide` = ?,`mticket__isPaymentRequired` = ?,`mticket__recentPaymentMethod` = ?,`mticket__cardDetails` = ?,`mticket__customerId` = ?,`mticket__orderId` = ?,`mticket__status` = ?,`mticket__paymentMode` = ?,`mticket__mticketTripReceipt` = ? WHERE `ticketId` = ?";
            }

            public void bind(sm smVar, Ticket ticket) {
                String str = ticket.ticketId;
                if (str == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, str);
                }
                MTicket mTicket = ticket.mTicket;
                if (mTicket != null) {
                    if (mTicket.getMTicketId() == null) {
                        smVar.E0(2);
                    } else {
                        smVar.z(2, mTicket.getMTicketId());
                    }
                    if (mTicket.getUserId() == null) {
                        smVar.E0(3);
                    } else {
                        smVar.z(3, mTicket.getUserId());
                    }
                    if (mTicket.getDeviceId() == null) {
                        smVar.E0(4);
                    } else {
                        smVar.z(4, mTicket.getDeviceId());
                    }
                    if (mTicket.getCityName() == null) {
                        smVar.E0(5);
                    } else {
                        smVar.z(5, mTicket.getCityName());
                    }
                    if (mTicket.getAgency() == null) {
                        smVar.E0(6);
                    } else {
                        smVar.z(6, mTicket.getAgency());
                    }
                    String routeStopsInfo = RouteStopsInfo.toString(mTicket.getUpTripRouteStopsInfo());
                    if (routeStopsInfo == null) {
                        smVar.E0(7);
                    } else {
                        smVar.z(7, routeStopsInfo);
                    }
                    String routeStopsInfo2 = RouteStopsInfo.toString(mTicket.getUpTripRouteStopsStageInfo());
                    if (routeStopsInfo2 == null) {
                        smVar.E0(8);
                    } else {
                        smVar.z(8, routeStopsInfo2);
                    }
                    String fromStringMap = MTicket.fromStringMap(mTicket.getPassengerDetails());
                    if (fromStringMap == null) {
                        smVar.E0(9);
                    } else {
                        smVar.z(9, fromStringMap);
                    }
                    smVar.d0(10, mTicket.getBookingTime());
                    smVar.d0(11, mTicket.getExpirationTime());
                    smVar.d0(12, mTicket.isExpired() ? 1 : 0);
                    smVar.d0(13, mTicket.getUpTripActivationTime());
                    smVar.d0(14, mTicket.isUpTripActivated() ? 1 : 0);
                    smVar.d0(15, mTicket.getUpTripPunchingTime());
                    String userProfile = UserProfile.toString(mTicket.get_userProfile());
                    if (userProfile == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, userProfile);
                    }
                    if (mTicket.getQrCode() == null) {
                        smVar.E0(17);
                    } else {
                        smVar.z(17, mTicket.getQrCode());
                    }
                    if (mTicket.getTone() == null) {
                        smVar.E0(18);
                    } else {
                        smVar.z(18, mTicket.getTone());
                    }
                    String mTicketConfiguration = MTicketConfiguration.toString(mTicket.getMTicketConfiguration());
                    if (mTicketConfiguration == null) {
                        smVar.E0(19);
                    } else {
                        smVar.z(19, mTicketConfiguration);
                    }
                    smVar.d0(20, mTicket.isFreeRide() ? 1 : 0);
                    smVar.d0(21, mTicket.isPaymentRequired() ? 1 : 0);
                    String mTicket2 = MTicket.toString(mTicket.getRecentPaymentMethod());
                    if (mTicket2 == null) {
                        smVar.E0(22);
                    } else {
                        smVar.z(22, mTicket2);
                    }
                    String cardString = MTicket.toCardString(mTicket.getCardDetails());
                    if (cardString == null) {
                        smVar.E0(23);
                    } else {
                        smVar.z(23, cardString);
                    }
                    if (mTicket.getCustomerId() == null) {
                        smVar.E0(24);
                    } else {
                        smVar.z(24, mTicket.getCustomerId());
                    }
                    if (mTicket.getOrderId() == null) {
                        smVar.E0(25);
                    } else {
                        smVar.z(25, mTicket.getOrderId());
                    }
                    if (mTicket.getStatus() == null) {
                        smVar.E0(26);
                    } else {
                        smVar.z(26, mTicket.getStatus());
                    }
                    if (mTicket.getPaymentMode() == null) {
                        smVar.E0(27);
                    } else {
                        smVar.z(27, mTicket.getPaymentMode());
                    }
                    String mTicketTripReceiptString = ProductDao_Impl.this.__customTypeConverters.toMTicketTripReceiptString(mTicket.getMticketTripReceipt());
                    if (mTicketTripReceiptString == null) {
                        smVar.E0(28);
                    } else {
                        smVar.z(28, mTicketTripReceiptString);
                    }
                } else {
                    hj1.D0(smVar, 2, 3, 4, 5);
                    hj1.D0(smVar, 6, 7, 8, 9);
                    hj1.D0(smVar, 10, 11, 12, 13);
                    hj1.D0(smVar, 14, 15, 16, 17);
                    hj1.D0(smVar, 18, 19, 20, 21);
                    hj1.D0(smVar, 22, 23, 24, 25);
                    smVar.E0(26);
                    smVar.E0(27);
                    smVar.E0(28);
                }
                String str2 = ticket.ticketId;
                if (str2 == null) {
                    smVar.E0(29);
                } else {
                    smVar.z(29, str2);
                }
            }
        };
        this.__updateAdapterOfPass = new pl<Pass>(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass8 */

            @Override // defpackage.bm, defpackage.pl
            public String createQuery() {
                return "UPDATE OR REPLACE `Pass` SET `passId` = ?,`pass__bookingPassId` = ?,`pass__referenceId` = ?,`pass__bookingPassType` = ?,`pass__userProfile` = ?,`pass__bookingTime` = ?,`pass__expiryTime` = ?,`pass__startingTime` = ?,`pass__passengerType` = ?,`pass__ticketStatus` = ?,`pass__agency` = ?,`pass__fare` = ?,`pass__noOfDays` = ?,`pass__displayProps` = ?,`pass__punches` = ?,`pass__qrCode` = ?,`pass__status` = ?,`pass__paymentMode` = ?,`pass__validity` = ?,`pass__verificationExpiryTime` = ?,`pass__cityName` = ?,`pass__passRejectionReason` = ?,`pass__isVerificationRequired` = ?,`pass__hasPassExpired` = ?,`pass__deviceId` = ?,`pass__customerId` = ?,`pass__recentPaymentMethod` = ?,`pass__cardDetails` = ?,`pass__configId` = ?,`pass_orderId` = ?,`pass__isPaymentRequired` = ?,`pass__specialFeatures` = ?,`pass__routeStopsInfo` = ?,`pass__productName` = ?,`pass__grouping` = ?,`pass__productType` = ?,`pass__productCategory` = ?,`pass__remainingTrips` = ?,`pass__maxTrips` = ?,`pass__maxTripsPerDay` = ?,`pass__catDisName` = ?,`pass__maxTripsPrice` = ?,`pass__tone` = ?,`pass__passApplicationRejectionReasons` = ?,`pass__passApplicationActionRequired` = ? WHERE `passId` = ?";
            }

            public void bind(sm smVar, Pass pass) {
                String str = pass.passId;
                if (str == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, str);
                }
                MPass mPass = pass.pass;
                if (mPass != null) {
                    if (mPass.getBookingPassId() == null) {
                        smVar.E0(2);
                    } else {
                        smVar.z(2, mPass.getBookingPassId());
                    }
                    if (mPass.getReferenceId() == null) {
                        smVar.E0(3);
                    } else {
                        smVar.z(3, mPass.getReferenceId());
                    }
                    String bookingPassType = BookingPassType.toString(mPass.get_bookingPassType());
                    if (bookingPassType == null) {
                        smVar.E0(4);
                    } else {
                        smVar.z(4, bookingPassType);
                    }
                    String userProfile = UserProfile.toString(mPass.getUserProfile());
                    if (userProfile == null) {
                        smVar.E0(5);
                    } else {
                        smVar.z(5, userProfile);
                    }
                    smVar.d0(6, mPass.getBookingTime());
                    smVar.d0(7, mPass.getExpiryTime());
                    smVar.d0(8, mPass.getStartingTime());
                    if (mPass.getPassengerType() == null) {
                        smVar.E0(9);
                    } else {
                        smVar.z(9, mPass.getPassengerType());
                    }
                    String converterString = TicketStatus.toConverterString(mPass.getTicketStatus());
                    if (converterString == null) {
                        smVar.E0(10);
                    } else {
                        smVar.z(10, converterString);
                    }
                    if (mPass.getAgency() == null) {
                        smVar.E0(11);
                    } else {
                        smVar.z(11, mPass.getAgency());
                    }
                    smVar.N(12, mPass.getFare());
                    smVar.d0(13, (long) mPass.getNoOfDays());
                    String fromStringMap = MPass.fromStringMap(mPass.getDisplayProps());
                    if (fromStringMap == null) {
                        smVar.E0(14);
                    } else {
                        smVar.z(14, fromStringMap);
                    }
                    String punchString = MPass.toPunchString(mPass.getPunches());
                    if (punchString == null) {
                        smVar.E0(15);
                    } else {
                        smVar.z(15, punchString);
                    }
                    if (mPass.getQrCode() == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, mPass.getQrCode());
                    }
                    if (mPass.getStatus() == null) {
                        smVar.E0(17);
                    } else {
                        smVar.z(17, mPass.getStatus());
                    }
                    if (mPass.getPaymentMode() == null) {
                        smVar.E0(18);
                    } else {
                        smVar.z(18, mPass.getPaymentMode());
                    }
                    smVar.d0(19, (long) mPass.getValidity());
                    smVar.d0(20, mPass.getVerificationExpiryTime());
                    if (mPass.get_cityName() == null) {
                        smVar.E0(21);
                    } else {
                        smVar.z(21, mPass.get_cityName());
                    }
                    if (mPass.getPassRejectionReason() == null) {
                        smVar.E0(22);
                    } else {
                        smVar.z(22, mPass.getPassRejectionReason());
                    }
                    smVar.d0(23, mPass.is_isVerificationRequired() ? 1 : 0);
                    smVar.d0(24, mPass.is_hasPassExpired() ? 1 : 0);
                    if (mPass.getDeviceId() == null) {
                        smVar.E0(25);
                    } else {
                        smVar.z(25, mPass.getDeviceId());
                    }
                    if (mPass.getCustomerId() == null) {
                        smVar.E0(26);
                    } else {
                        smVar.z(26, mPass.getCustomerId());
                    }
                    String mTicket = MTicket.toString(mPass.getRecentPaymentMethod());
                    if (mTicket == null) {
                        smVar.E0(27);
                    } else {
                        smVar.z(27, mTicket);
                    }
                    String cardString = MTicket.toCardString(mPass.getCardDetails());
                    if (cardString == null) {
                        smVar.E0(28);
                    } else {
                        smVar.z(28, cardString);
                    }
                    if (mPass.getConfigId() == null) {
                        smVar.E0(29);
                    } else {
                        smVar.z(29, mPass.getConfigId());
                    }
                    if (mPass.getOrderId() == null) {
                        smVar.E0(30);
                    } else {
                        smVar.z(30, mPass.getOrderId());
                    }
                    smVar.d0(31, mPass.isPaymentRequired() ? 1 : 0);
                    String customTypeConverters = ProductDao_Impl.this.__customTypeConverters.toString(mPass.getSpecialFeatures());
                    if (customTypeConverters == null) {
                        smVar.E0(32);
                    } else {
                        smVar.z(32, customTypeConverters);
                    }
                    String routeStopsInfo = RouteStopsInfo.toString(mPass.getRouteStopsInfo());
                    if (routeStopsInfo == null) {
                        smVar.E0(33);
                    } else {
                        smVar.z(33, routeStopsInfo);
                    }
                    if (mPass.get_productName() == null) {
                        smVar.E0(34);
                    } else {
                        smVar.z(34, mPass.get_productName());
                    }
                    String productCategory = ProductCategory.toString(mPass.get_grouping());
                    if (productCategory == null) {
                        smVar.E0(35);
                    } else {
                        smVar.z(35, productCategory);
                    }
                    if (mPass.get_productType() == null) {
                        smVar.E0(36);
                    } else {
                        smVar.z(36, mPass.get_productType());
                    }
                    if (mPass.get_productCategory() == null) {
                        smVar.E0(37);
                    } else {
                        smVar.z(37, mPass.get_productCategory());
                    }
                    smVar.d0(38, (long) mPass.get_remainingTrips());
                    smVar.d0(39, (long) mPass.get_maxTrips());
                    smVar.d0(40, (long) mPass.get_maxTripsPerDay());
                    if (mPass.get_catDisName() == null) {
                        smVar.E0(41);
                    } else {
                        smVar.z(41, mPass.get_catDisName());
                    }
                    smVar.d0(42, (long) mPass.get_maxTripsPrice());
                    if (mPass.getTone() == null) {
                        smVar.E0(43);
                    } else {
                        smVar.z(43, mPass.getTone());
                    }
                    String passApplicationRejectionReasonsString = ProductDao_Impl.this.__customTypeConverters.toPassApplicationRejectionReasonsString(mPass.get_passApplicationRejectionReasons());
                    if (passApplicationRejectionReasonsString == null) {
                        smVar.E0(44);
                    } else {
                        smVar.z(44, passApplicationRejectionReasonsString);
                    }
                    String converterString2 = ProductDao_Impl.this.__customTypeConverters.toConverterString(mPass.get_passApplicationActionRequired());
                    if (converterString2 == null) {
                        smVar.E0(45);
                    } else {
                        smVar.z(45, converterString2);
                    }
                } else {
                    hj1.D0(smVar, 2, 3, 4, 5);
                    hj1.D0(smVar, 6, 7, 8, 9);
                    hj1.D0(smVar, 10, 11, 12, 13);
                    hj1.D0(smVar, 14, 15, 16, 17);
                    hj1.D0(smVar, 18, 19, 20, 21);
                    hj1.D0(smVar, 22, 23, 24, 25);
                    hj1.D0(smVar, 26, 27, 28, 29);
                    hj1.D0(smVar, 30, 31, 32, 33);
                    hj1.D0(smVar, 34, 35, 36, 37);
                    hj1.D0(smVar, 38, 39, 40, 41);
                    hj1.D0(smVar, 42, 43, 44, 45);
                }
                String str2 = pass.passId;
                if (str2 == null) {
                    smVar.E0(46);
                } else {
                    smVar.z(46, str2);
                }
            }
        };
        this.__preparedStmtOfDeletePassApplicationData = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass9 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM PassApplications where pass_app__cityName = ?";
            }
        };
        this.__preparedStmtOfDeleteAllPassData = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass10 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM Pass";
            }
        };
        this.__preparedStmtOfDeleteAllScanPayData = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass11 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM ScanPay";
            }
        };
        this.__preparedStmtOfUpdatePunchStatus = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass12 */

            @Override // defpackage.bm
            public String createQuery() {
                return "UPDATE Pass SET pass__punches = ? WHERE  pass__bookingPassId = ?";
            }
        };
        this.__preparedStmtOfUpdateExpiryState = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass13 */

            @Override // defpackage.bm
            public String createQuery() {
                return "UPDATE Ticket SET mticket__isExpired = 1 WHERE mticket__mTicketId = ?";
            }
        };
        this.__preparedStmtOfUpdateQrCode = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass14 */

            @Override // defpackage.bm
            public String createQuery() {
                return "UPDATE Ticket SET mticket__qrCode = ? WHERE mticket__mTicketId = ?";
            }
        };
        this.__preparedStmtOfAddTripReceiptToMTicket = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass15 */

            @Override // defpackage.bm
            public String createQuery() {
                return "UPDATE Ticket SET mticket__mticketTripReceipt = ? WHERE mticket__mTicketId = ?";
            }
        };
        this.__preparedStmtOfDeleteAllTicketData = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass16 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM Ticket";
            }
        };
        this.__preparedStmtOfUpdateActivationData = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass17 */

            @Override // defpackage.bm
            public String createQuery() {
                return "UPDATE Ticket SET mticket__isUpTripActivated = ?, mticket__upTripActivationTime = ? WHERE mticket__mTicketId = ?";
            }
        };
        this.__preparedStmtOfUpdateExpiryStatus = new bm(wlVar) {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass18 */

            @Override // defpackage.bm
            public String createQuery() {
                return "UPDATE Ticket SET mticket__isExpired = ? WHERE mticket__mTicketId = ?";
            }
        };
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // app.zophop.room.ProductDao
    public void addTripReceiptToMTicket(String str, MTicketTripReceipt mTicketTripReceipt) {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfAddTripReceiptToMTicket.acquire();
        String mTicketTripReceiptString = this.__customTypeConverters.toMTicketTripReceiptString(mTicketTripReceipt);
        if (mTicketTripReceiptString == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, mTicketTripReceiptString);
        }
        if (str == null) {
            acquire.E0(2);
        } else {
            acquire.z(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfAddTripReceiptToMTicket.release(acquire);
        }
    }

    @Override // app.zophop.room.ProductDao
    public void deleteAllPassData() {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfDeleteAllPassData.acquire();
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllPassData.release(acquire);
        }
    }

    @Override // app.zophop.room.ProductDao
    public void deleteAllScanPayData() {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfDeleteAllScanPayData.acquire();
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllScanPayData.release(acquire);
        }
    }

    @Override // app.zophop.room.ProductDao
    public void deleteAllTicketData() {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfDeleteAllTicketData.acquire();
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeleteAllTicketData.release(acquire);
        }
    }

    @Override // app.zophop.room.ProductDao
    public void deletePassApplicationData(String str) {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfDeletePassApplicationData.acquire();
        if (str == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfDeletePassApplicationData.release(acquire);
        }
    }

    @Override // app.zophop.room.ProductDao
    public int getActivePassCount(String str, long j) {
        yl e = yl.e("SELECT COUNT(pass__bookingPassId) FROM PASS WHERE  pass__cityName = ? and pass__startingTime < ? and pass__expiryTime > ? and (pass__status = 'UNUSED' OR pass__status = 'PAYMENT_PENDING' OR pass__status = 'PENDING')", 3);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        e.d0(2, j);
        e.d0(3, j);
        this.__db.assertNotSuspendingTransaction();
        int i = 0;
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            return i;
        } finally {
            b.close();
            e.f();
        }
    }

    @Override // app.zophop.room.ProductDao
    public int getActiveScanPayCount(String str) {
        yl e = yl.e("SELECT COUNT(scan_pay__transactionId) FROM ScanPay WHERE  scan_pay__cityName = ? and scan_pay__isExpired = 0 and scan_pay__status != 'FAILED'", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        int i = 0;
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            return i;
        } finally {
            b.close();
            e.f();
        }
    }

    @Override // app.zophop.room.ProductDao
    public int getActiveSuperSaverCount(String str, long j) {
        yl e = yl.e("SELECT COUNT(pass__bookingPassId) FROM PASS WHERE  pass__cityName = ? and pass__startingTime < ? and pass__expiryTime > ? and (pass__status = 'UNUSED' OR pass__status = 'PAYMENT_PENDING' OR pass__status = 'PENDING') and pass__productType = 'superSaver'", 3);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        e.d0(2, j);
        e.d0(3, j);
        this.__db.assertNotSuspendingTransaction();
        int i = 0;
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            return i;
        } finally {
            b.close();
            e.f();
        }
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<List<ScanPay>> getAllActiveScanPayTickets(String str) {
        final yl e = yl.e("SELECT * FROM ScanPay WHERE  scan_pay__cityName = ? and scan_pay__isExpired = 0 and scan_pay__status != 'FAILED'", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"ScanPay"}, false, new Callable<List<ScanPay>>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass21 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:102:0x0246 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:103:0x024c A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x025a A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:107:0x025e A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x026f A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x0271 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:115:0x0287 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x028d A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0155 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x0158 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x016c A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x016f A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x017b A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x017e A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x018a A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x018d A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0199 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x019c A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x01b3 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x01d8 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:79:0x01da A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x01eb A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:83:0x01ed A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x01fe A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:87:0x0200 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x020d A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:91:0x020f A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x021e A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:95:0x0220 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x022f A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x0233 A[Catch:{ all -> 0x02b8 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.room.ScanPay> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 701
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass21.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<List<Ticket>> getAllActiveTickets(String str) {
        final yl e = yl.e("SELECT * FROM Ticket where mticket__isExpired = 0 and mticket__cityName = ?  and mticket__status != 'FAILED'ORDER BY mticket__expirationTime DESC ", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"Ticket"}, false, new Callable<List<Ticket>>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass31 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:173:0x0413 A[Catch:{ all -> 0x0442 }] */
            /* JADX WARNING: Removed duplicated region for block: B:174:0x0417 A[Catch:{ all -> 0x0442 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.room.Ticket> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1095
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass31.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<List<PassApplications>> getAllApplications(String str) {
        final yl e = yl.e("SELECT * FROM PassApplications where pass_app__cityName = ? ORDER BY pass_app__bookingTime DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"PassApplications"}, false, new Callable<List<PassApplications>>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass27 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:132:0x03a0 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x03a3 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:136:0x03b1 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x03b4 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x03c0 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x03c3 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:144:0x03e0 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x03e4 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x03f5 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x03f7 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x0404 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x0406 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:156:0x042f A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x0431 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:160:0x0442 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x0444 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:164:0x0455 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0457 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:168:0x046a A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x046c A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:172:0x047b A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x047f A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:176:0x0492 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x0496 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:180:0x04c1 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x04c3 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:184:0x04d2 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x04d6 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:188:0x04eb A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x04ef A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:192:0x04fd A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x0501 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:196:0x050f A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x0513 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:200:0x0526 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:201:0x052a A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:204:0x053d A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:205:0x0542 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:208:0x0557 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:209:0x055c A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:212:0x0571 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:213:0x0575 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x0588 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:217:0x058c A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:220:0x05a1 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x05a3 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:224:0x05af A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:226:0x05b9 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:231:0x05db A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:232:0x05dd A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:235:0x05f0 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:236:0x05f4 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:239:0x0607 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:240:0x060c A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:243:0x0621 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:244:0x0625 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:247:0x0638 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x063c A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:251:0x0670 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x0674 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x0692 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x0696 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:259:0x06a9 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x06af A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:263:0x06cc A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x06ce A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x06ec A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:269:0x06f0 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:272:0x0703 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:273:0x0707 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:276:0x071a A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:277:0x071e A[Catch:{ all -> 0x0768 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.room.PassApplications> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1914
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass27.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<List<Pass>> getAllPasses(String str) {
        final yl e = yl.e("SELECT * FROM Pass where pass__cityName = ? ORDER BY pass__bookingTime DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"Pass"}, false, new Callable<List<Pass>>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass28 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:132:0x038e A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x0391 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:136:0x039f A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x03a2 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x03ae A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x03b1 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:144:0x03ce A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x03d2 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x03e3 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x03e5 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x03f2 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x03f4 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:156:0x041c A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x041e A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:160:0x042f A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x0431 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:164:0x0442 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0444 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:168:0x0457 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x0459 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:172:0x0468 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x046c A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:176:0x047f A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x0483 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:180:0x04ae A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x04b0 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:184:0x04bf A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x04c3 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:188:0x04d8 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x04dc A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:192:0x04ea A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x04ee A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:196:0x04fc A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x0500 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:200:0x0513 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:201:0x0517 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:204:0x052a A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:205:0x052f A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:208:0x0544 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:209:0x0549 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:212:0x055e A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:213:0x0562 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x0575 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:217:0x0579 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:220:0x058e A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x0590 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:224:0x059c A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:226:0x05a6 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:231:0x05c8 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:232:0x05ca A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:235:0x05dd A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:236:0x05e1 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:239:0x05f4 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:240:0x05f9 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:243:0x060e A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:244:0x0612 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:247:0x0625 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x0629 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:251:0x065d A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x0661 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x067f A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x0683 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:259:0x0696 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x069c A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:263:0x06b9 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x06bb A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x06d9 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:269:0x06df A[Catch:{ all -> 0x0720 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.room.Pass> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1842
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass28.call():java.util.List");
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:139:0x039d A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x03a0 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x03ae A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03b1 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x03bd A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x03c0 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x03dd A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03e1 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03f2 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03f4 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0401 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0403 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x042b A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x042d A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x043e A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0440 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0451 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0453 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0466 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x0468 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0477 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x047b A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x048e A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0492 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x04bd A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04bf A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x04ce A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x04d2 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x04e7 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x04e9 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x04f7 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x04f9 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0505 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0509 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x051c A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0520 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0533 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x0538 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x054d A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x0552 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0567 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x056b A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x057e A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x0582 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0597 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x0599 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x05a5 A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x05af A[Catch:{ all -> 0x0724 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x05cd A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x05cf A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x05e2 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x05e6 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x05f9 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x05fe A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0613 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0617 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x062a A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x062e A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x0662 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x0666 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x0684 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0688 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x069b A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x06a1 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:270:0x06ba A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x06bc A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:275:0x06d6 A[Catch:{ all -> 0x0719 }] */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x06dc A[Catch:{ all -> 0x0719 }] */
    @Override // app.zophop.room.ProductDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<app.zophop.room.Pass> getAllPassesSync(java.lang.String r60) {
        /*
        // Method dump skipped, instructions count: 1845
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.getAllPassesSync(java.lang.String):java.util.List");
    }

    @Override // app.zophop.room.ProductDao
    public List<RideDetails> getAllRideDetails() {
        String str;
        String str2;
        String str3;
        String str4;
        yl e = yl.e("SELECT * FROM RideDetails", 0);
        this.__db.assertNotSuspendingTransaction();
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            int L = h.L(b, "_passId");
            int L2 = h.L(b, "_rideInfoList");
            int L3 = h.L(b, "_dailyRidesCount");
            int L4 = h.L(b, "_totalRideCount");
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                if (b.isNull(L)) {
                    str = null;
                } else {
                    str = b.getString(L);
                }
                if (b.isNull(L2)) {
                    str2 = null;
                } else {
                    str2 = b.getString(L2);
                }
                RideDetails rideDetails = new RideDetails(str, RideDetails.fromString(str2));
                if (b.isNull(L3)) {
                    str3 = null;
                } else {
                    str3 = b.getString(L3);
                }
                rideDetails.set_dailyRidesCount(str3);
                if (b.isNull(L4)) {
                    str4 = null;
                } else {
                    str4 = b.getString(L4);
                }
                rideDetails.set_totalRideCount(str4);
                arrayList.add(rideDetails);
            }
            return arrayList;
        } finally {
            b.close();
            e.f();
        }
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<List<ScanPay>> getAllScanPayTickets(String str) {
        final yl e = yl.e("SELECT * FROM SCANPAY where scan_pay__cityName = ? ORDER BY scan_pay__bookingTime DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"SCANPAY"}, false, new Callable<List<ScanPay>>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass29 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:102:0x0246 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:103:0x024c A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x025a A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:107:0x025e A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x026f A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x0271 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:115:0x0287 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x028d A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:54:0x0155 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x0158 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x016c A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x016f A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x017b A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x017e A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x018a A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x018d A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x0199 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x019c A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x01b3 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x01b7 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x01d8 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:79:0x01da A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x01eb A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:83:0x01ed A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x01fe A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:87:0x0200 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x020d A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:91:0x020f A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x021e A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:95:0x0220 A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x022f A[Catch:{ all -> 0x02b8 }] */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x0233 A[Catch:{ all -> 0x02b8 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.room.ScanPay> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 701
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass29.call():java.util.List");
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0231 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0233 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0242 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0246 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x025b A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x025d A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0269 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x026d A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x027e A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0280 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0296 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x029c A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0168 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x016b A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x017f A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0182 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x018e A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0191 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x019d A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a0 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ac A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01af A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01c6 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01ca A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01eb A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01ed A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01fe A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0200 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0211 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0213 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0220 A[Catch:{ all -> 0x02c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0222 A[Catch:{ all -> 0x02c8 }] */
    @Override // app.zophop.room.ProductDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<app.zophop.room.ScanPay> getAllScanPayTicketsSync(java.lang.String r35) {
        /*
        // Method dump skipped, instructions count: 724
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.getAllScanPayTicketsSync(java.lang.String):java.util.List");
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<List<Ticket>> getAllTickets(String str) {
        final yl e = yl.e("SELECT * FROM Ticket where mticket__cityName = ? ORDER BY mticket__bookingTime DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"Ticket"}, false, new Callable<List<Ticket>>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass19 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:173:0x0413 A[Catch:{ all -> 0x0442 }] */
            /* JADX WARNING: Removed duplicated region for block: B:174:0x0417 A[Catch:{ all -> 0x0442 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.room.Ticket> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1095
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass19.call():java.util.List");
            }
        });
    }

    /* JADX WARNING: Removed duplicated region for block: B:180:0x0420 A[Catch:{ all -> 0x0452 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0424 A[Catch:{ all -> 0x0452 }] */
    @Override // app.zophop.room.ProductDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<app.zophop.room.Ticket> getAllTicketsSync(java.lang.String r38) {
        /*
        // Method dump skipped, instructions count: 1118
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.getAllTicketsSync(java.lang.String):java.util.List");
    }

    @Override // app.zophop.room.ProductDao
    public int getCitySpecificPassCount(String str) {
        yl e = yl.e("SELECT COUNT (DISTINCT passId) FROM Pass where pass__cityName = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        int i = 0;
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            return i;
        } finally {
            b.close();
            e.f();
        }
    }

    @Override // app.zophop.room.ProductDao
    public int getCitySpecificScanPayCount(String str) {
        yl e = yl.e("SELECT COUNT (DISTINCT bookingId) FROM ScanPay where scan_pay__cityName = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        int i = 0;
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            return i;
        } finally {
            b.close();
            e.f();
        }
    }

    @Override // app.zophop.room.ProductDao
    public int getCitySpecificTicketCount(String str) {
        yl e = yl.e("SELECT COUNT (DISTINCT ticketId) FROM Ticket where mticket__cityName = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        int i = 0;
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            return i;
        } finally {
            b.close();
            e.f();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x021f A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0221 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0236 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0238 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0245 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0247 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0254 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0256 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0267 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0269 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x027a A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x027c A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x029b A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x029d A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02b0 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02b2 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02c7 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02c9 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02dc A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02de A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02ed A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02ef A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02fe A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0300 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x030c A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x030e A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x031a A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x031c A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x032f A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0331 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0344 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0346 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0355 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0357 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0366 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0368 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0375 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0377 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0386 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x038a A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03a5 A[Catch:{ all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03a9 A[Catch:{ all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01fb A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01fd A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0207 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0209 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0213 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0215 A[Catch:{ all -> 0x03bf }] */
    @Override // app.zophop.room.ProductDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public app.zophop.room.Ticket getCurrentTicket(java.lang.String r32, java.lang.String r33) {
        /*
        // Method dump skipped, instructions count: 977
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.getCurrentTicket(java.lang.String, java.lang.String):app.zophop.room.Ticket");
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<Ticket> getLatestActive(String str) {
        final yl e = yl.e("SELECT * FROM Ticket where mticket__isExpired = 0 and mticket__cityName = ?  and mticket__status != 'FAILED' and mticket__status != 'PENDING'ORDER BY mticket__expirationTime DESC limit 1", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"Ticket"}, false, new Callable<Ticket>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass30 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:100:0x0228 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:103:0x0235 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:104:0x0237 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:107:0x0248 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:108:0x024a A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x025b A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x025d A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:115:0x027d A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x027f A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:119:0x0292 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:120:0x0294 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:123:0x02a9 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:124:0x02ab A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:127:0x02be A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:128:0x02c0 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x02cf A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:132:0x02d1 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:135:0x02e0 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:136:0x02e2 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:139:0x02ee A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x02f0 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:143:0x02fc A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:144:0x02fe A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:147:0x0311 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x0313 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:151:0x0326 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x0328 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:155:0x0337 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:156:0x0339 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:159:0x0348 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:160:0x034a A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:163:0x0357 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:164:0x0359 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:167:0x0368 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x036c A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:174:0x038b A[Catch:{ all -> 0x0399 }] */
            /* JADX WARNING: Removed duplicated region for block: B:175:0x038f A[Catch:{ all -> 0x0399 }] */
            /* JADX WARNING: Removed duplicated region for block: B:79:0x01dc A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x01de A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:83:0x01e8 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:84:0x01ea A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:87:0x01f4 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x01f6 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:91:0x0200 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x0202 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:95:0x0217 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:96:0x0219 A[Catch:{ all -> 0x03a3 }] */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x0226 A[Catch:{ all -> 0x03a3 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public app.zophop.room.Ticket call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 941
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass30.call():app.zophop.room.Ticket");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public int getPassApplicationCount(String str) {
        yl e = yl.e("SELECT COUNT(pass_app__passengerType) FROM PassApplications where pass_app__cityName = ? and pass_app__status != 'REJECTED' and pass_app__status != 'FAILED'", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        int i = 0;
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            if (b.moveToFirst()) {
                i = b.getInt(0);
            }
            return i;
        } finally {
            b.close();
            e.f();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:136:0x035b A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x035d A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x036b A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x036e A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x037a A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x037d A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0398 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x039a A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x03a7 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03a9 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x03b6 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x03b8 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03de A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03e0 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03f1 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03f3 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0406 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0408 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x041b A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x041d A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x042c A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x042e A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x043d A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x043f A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x0460 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0462 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0471 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0473 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x0482 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x0484 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0490 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:197:0x0492 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:200:0x049e A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x04a0 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x04af A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x04b1 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04c0 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04c2 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x04d5 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x04d7 A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x04ea A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:217:0x04ec A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x04fb A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x04fd A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:224:0x050c A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x050e A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x051a A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x051e A[Catch:{ all -> 0x0621 }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0534 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x0536 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:238:0x0549 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:239:0x054b A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:242:0x055a A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x055c A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:246:0x056f A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:247:0x0571 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0580 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0582 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x05ac A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x05ae A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:258:0x05c6 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:259:0x05c8 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:262:0x05d5 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x05d7 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x05ea A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:0x05ec A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:271:0x0606 A[Catch:{ all -> 0x0614 }] */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x060a A[Catch:{ all -> 0x0614 }] */
    @Override // app.zophop.room.ProductDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public app.zophop.room.Pass getPassFromBookingId(java.lang.String r56) {
        /*
        // Method dump skipped, instructions count: 1587
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.getPassFromBookingId(java.lang.String):app.zophop.room.Pass");
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<Pass> getPassFromBookingIdAsync(String str) {
        final yl e = yl.e("Select * FROM Pass where passId = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"Pass"}, false, new Callable<Pass>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass22 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:129:0x0348 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:130:0x034a A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x0358 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x035b A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0367 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:138:0x036a A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x0385 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0387 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x0394 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:146:0x0396 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x03a3 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x03a5 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x03cb A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:154:0x03cd A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x03de A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:158:0x03e0 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x03f3 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:162:0x03f5 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0408 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:166:0x040a A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x0419 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:170:0x041b A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x042a A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:174:0x042c A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x044d A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:178:0x044f A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x045e A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:182:0x0460 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x0470 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:186:0x0472 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x047e A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:190:0x0480 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x048c A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:194:0x048e A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x049d A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:198:0x049f A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:201:0x04ae A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:202:0x04b0 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:205:0x04c3 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:206:0x04c5 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:209:0x04d8 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:210:0x04da A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:213:0x04e9 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:214:0x04eb A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:217:0x04fa A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:218:0x04fb A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x0507 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:223:0x050b A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:227:0x0525 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:228:0x0527 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:231:0x053a A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:232:0x053c A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:235:0x054b A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:236:0x054d A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:239:0x0560 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:240:0x0562 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:243:0x0571 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:244:0x0573 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:247:0x059d A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x059f A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:251:0x05b7 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x05b9 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x05c6 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x05c8 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:259:0x05df A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x05e1 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x05ff A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:265:0x0603 A[Catch:{ all -> 0x060d }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public app.zophop.room.Pass call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1568
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass22.call():app.zophop.room.Pass");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<PassApplications> getRecentAppliedPass(String str) {
        final yl e = yl.e("SELECT * FROM PassApplications where pass_app__cityName = ? and pass_app__status != 'REJECTED' and pass_app__status != 'FAILED' ORDER BY pass_app__bookingTime DESC limit 1", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"PassApplications"}, false, new Callable<PassApplications>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass25 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:129:0x0358 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:130:0x035a A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x0368 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x036b A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0377 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:138:0x037a A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x0395 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0397 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x03a4 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:146:0x03a6 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x03b3 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x03b5 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x03db A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:154:0x03dd A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x03ee A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:158:0x03f0 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x0403 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:162:0x0405 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0418 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:166:0x041a A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x0429 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:170:0x042b A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x043a A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:174:0x043c A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x045d A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:178:0x045f A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x046e A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:182:0x0470 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x0480 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:186:0x0482 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x048e A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:190:0x0490 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x049c A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:194:0x049e A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x04ad A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:198:0x04af A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:201:0x04be A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:202:0x04c0 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:205:0x04d3 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:206:0x04d5 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:209:0x04e8 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:210:0x04ea A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:213:0x04f9 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:214:0x04fb A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:217:0x050a A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:218:0x050b A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x0517 A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:223:0x051b A[Catch:{ all -> 0x0647 }] */
            /* JADX WARNING: Removed duplicated region for block: B:227:0x0535 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:228:0x0537 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:231:0x054a A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:232:0x054c A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:235:0x055b A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:236:0x055d A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:239:0x0570 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:240:0x0572 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:243:0x0581 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:244:0x0583 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:247:0x05ad A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x05af A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:251:0x05c7 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x05c9 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x05d6 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x05d8 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:259:0x05ef A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x05f1 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x060f A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:265:0x0611 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x0620 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:269:0x0622 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:272:0x0631 A[Catch:{ all -> 0x063e }] */
            /* JADX WARNING: Removed duplicated region for block: B:273:0x0633 A[Catch:{ all -> 0x063e }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public app.zophop.room.PassApplications call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1617
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass25.call():app.zophop.room.PassApplications");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<List<PassApplications>> getRecentAppliedPassesList(String str) {
        final yl e = yl.e("SELECT * FROM PassApplications where pass_app__cityName = ? ORDER BY pass_app__bookingTime DESC limit 2", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"PassApplications"}, false, new Callable<List<PassApplications>>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass26 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:132:0x03a0 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x03a3 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:136:0x03b1 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x03b4 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x03c0 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x03c3 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:144:0x03e0 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x03e4 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x03f5 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x03f7 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x0404 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x0406 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:156:0x042f A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x0431 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:160:0x0442 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x0444 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:164:0x0455 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0457 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:168:0x046a A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x046c A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:172:0x047b A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x047f A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:176:0x0492 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x0496 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:180:0x04c1 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x04c3 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:184:0x04d2 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x04d6 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:188:0x04eb A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x04ef A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:192:0x04fd A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x0501 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:196:0x050f A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x0513 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:200:0x0526 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:201:0x052a A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:204:0x053d A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:205:0x0542 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:208:0x0557 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:209:0x055c A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:212:0x0571 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:213:0x0575 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x0588 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:217:0x058c A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:220:0x05a1 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x05a3 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:224:0x05af A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:226:0x05b9 A[Catch:{ all -> 0x0770 }] */
            /* JADX WARNING: Removed duplicated region for block: B:231:0x05db A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:232:0x05dd A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:235:0x05f0 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:236:0x05f4 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:239:0x0607 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:240:0x060c A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:243:0x0621 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:244:0x0625 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:247:0x0638 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x063c A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:251:0x0670 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x0674 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x0692 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x0696 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:259:0x06a9 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x06af A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:263:0x06cc A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x06ce A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x06ec A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:269:0x06f0 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:272:0x0703 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:273:0x0707 A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:276:0x071a A[Catch:{ all -> 0x0768 }] */
            /* JADX WARNING: Removed duplicated region for block: B:277:0x071e A[Catch:{ all -> 0x0768 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.room.PassApplications> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1914
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass26.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<Pass> getRecentPass(String str, long j) {
        final yl e = yl.e("SELECT * FROM Pass where pass__cityName = ? and pass__startingTime < ? and pass__expiryTime > ? and (pass__status = 'UNUSED' OR pass__status = 'PAYMENT_PENDING' OR pass__status = 'PENDING' OR pass__status = 'USED') ORDER BY pass__bookingTime DESC limit 1", 3);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        e.d0(2, j);
        e.d0(3, j);
        return this.__db.getInvalidationTracker().b(new String[]{"Pass"}, false, new Callable<Pass>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass23 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:129:0x0348 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:130:0x034a A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x0358 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x035b A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x0367 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:138:0x036a A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x0385 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x0387 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x0394 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:146:0x0396 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x03a3 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x03a5 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x03cb A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:154:0x03cd A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x03de A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:158:0x03e0 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x03f3 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:162:0x03f5 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0408 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:166:0x040a A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x0419 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:170:0x041b A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x042a A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:174:0x042c A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x044d A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:178:0x044f A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x045e A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:182:0x0460 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x0470 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:186:0x0472 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x047e A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:190:0x0480 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x048c A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:194:0x048e A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x049d A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:198:0x049f A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:201:0x04ae A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:202:0x04b0 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:205:0x04c3 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:206:0x04c5 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:209:0x04d8 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:210:0x04da A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:213:0x04e9 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:214:0x04eb A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:217:0x04fa A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:218:0x04fb A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x0507 A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:223:0x050b A[Catch:{ all -> 0x0616 }] */
            /* JADX WARNING: Removed duplicated region for block: B:227:0x0525 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:228:0x0527 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:231:0x053a A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:232:0x053c A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:235:0x054b A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:236:0x054d A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:239:0x0560 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:240:0x0562 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:243:0x0571 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:244:0x0573 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:247:0x059d A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x059f A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:251:0x05b7 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x05b9 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x05c6 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x05c8 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:259:0x05df A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x05e1 A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x05ff A[Catch:{ all -> 0x060d }] */
            /* JADX WARNING: Removed duplicated region for block: B:265:0x0603 A[Catch:{ all -> 0x060d }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public app.zophop.room.Pass call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1568
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass23.call():app.zophop.room.Pass");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<List<Pass>> getRecentPassList(String str, long j) {
        final yl e = yl.e("SELECT * FROM Pass where pass__cityName = ? and pass__startingTime < ? and pass__expiryTime > ? and (pass__status = 'UNUSED' OR pass__status = 'PAYMENT_PENDING' OR pass__status = 'PENDING' OR pass__status = 'USED') ORDER BY pass__bookingTime DESC limit 5", 3);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        e.d0(2, j);
        e.d0(3, j);
        return this.__db.getInvalidationTracker().b(new String[]{"Pass"}, false, new Callable<List<Pass>>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass24 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:132:0x038e A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x0391 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:136:0x039f A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x03a2 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x03ae A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x03b1 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:144:0x03ce A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x03d2 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x03e3 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x03e5 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x03f2 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x03f4 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:156:0x041c A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x041e A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:160:0x042f A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x0431 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:164:0x0442 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0444 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:168:0x0457 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x0459 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:172:0x0468 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x046c A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:176:0x047f A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x0483 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:180:0x04ae A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x04b0 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:184:0x04bf A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x04c3 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:188:0x04d8 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x04dc A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:192:0x04ea A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x04ee A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:196:0x04fc A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x0500 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:200:0x0513 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:201:0x0517 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:204:0x052a A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:205:0x052f A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:208:0x0544 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:209:0x0549 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:212:0x055e A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:213:0x0562 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x0575 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:217:0x0579 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:220:0x058e A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x0590 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:224:0x059c A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:226:0x05a6 A[Catch:{ all -> 0x0728 }] */
            /* JADX WARNING: Removed duplicated region for block: B:231:0x05c8 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:232:0x05ca A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:235:0x05dd A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:236:0x05e1 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:239:0x05f4 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:240:0x05f9 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:243:0x060e A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:244:0x0612 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:247:0x0625 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x0629 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:251:0x065d A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x0661 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x067f A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x0683 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:259:0x0696 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x069c A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:263:0x06b9 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x06bb A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x06d9 A[Catch:{ all -> 0x0720 }] */
            /* JADX WARNING: Removed duplicated region for block: B:269:0x06df A[Catch:{ all -> 0x0720 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.room.Pass> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1842
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass24.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public LiveData<ScanPay> getRecentScanPayTicket(String str) {
        final yl e = yl.e("SELECT * FROM ScanPay WHERE  scan_pay__cityName = ? and scan_pay__isExpired = 0 and scan_pay__status != 'FAILED'", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"ScanPay"}, false, new Callable<ScanPay>() {
            /* class app.zophop.room.ProductDao_Impl.AnonymousClass20 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:100:0x0215 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:103:0x021f A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:104:0x0221 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:107:0x022e A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:108:0x0230 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x0244 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x0248 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0131 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x0134 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x0148 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:56:0x014b A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:59:0x0157 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:60:0x015a A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x0166 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:64:0x0169 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:67:0x0175 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:68:0x0177 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x018c A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:72:0x018e A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:75:0x01a9 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:76:0x01ab A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:79:0x01bc A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:80:0x01be A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:83:0x01cf A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:84:0x01d1 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:87:0x01e0 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:88:0x01e2 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:91:0x01f1 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:92:0x01f3 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:95:0x0202 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:96:0x0204 A[Catch:{ all -> 0x0258 }] */
            /* JADX WARNING: Removed duplicated region for block: B:99:0x0213 A[Catch:{ all -> 0x0258 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public app.zophop.room.ScanPay call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 605
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.AnonymousClass20.call():app.zophop.room.ScanPay");
            }
        });
    }

    @Override // app.zophop.room.ProductDao
    public RideDetails getRideDetails(String str) {
        String str2;
        String str3;
        String str4;
        yl e = yl.e("SELECT * FROM RideDetails where _passId = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        this.__db.assertNotSuspendingTransaction();
        RideDetails rideDetails = null;
        String str5 = null;
        Cursor b = hm.b(this.__db, e, false, null);
        try {
            int L = h.L(b, "_passId");
            int L2 = h.L(b, "_rideInfoList");
            int L3 = h.L(b, "_dailyRidesCount");
            int L4 = h.L(b, "_totalRideCount");
            if (b.moveToFirst()) {
                if (b.isNull(L)) {
                    str2 = null;
                } else {
                    str2 = b.getString(L);
                }
                if (b.isNull(L2)) {
                    str3 = null;
                } else {
                    str3 = b.getString(L2);
                }
                RideDetails rideDetails2 = new RideDetails(str2, RideDetails.fromString(str3));
                if (b.isNull(L3)) {
                    str4 = null;
                } else {
                    str4 = b.getString(L3);
                }
                rideDetails2.set_dailyRidesCount(str4);
                if (!b.isNull(L4)) {
                    str5 = b.getString(L4);
                }
                rideDetails2.set_totalRideCount(str5);
                rideDetails = rideDetails2;
            }
            return rideDetails;
        } finally {
            b.close();
            e.f();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0215 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0217 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0226 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0228 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0232 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0234 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0241 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x0243 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0257 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x025b A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0144 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0147 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x015b A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015e A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016a A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x016d A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0179 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017c A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0188 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x018a A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x019f A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a1 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01bc A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x01be A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01cf A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01d1 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e2 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01e4 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01f3 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01f5 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0204 A[Catch:{ all -> 0x026e }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0206 A[Catch:{ all -> 0x026e }] */
    @Override // app.zophop.room.ProductDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public app.zophop.room.ScanPay getScanPayTicketFromBookingId(java.lang.String r34) {
        /*
        // Method dump skipped, instructions count: 634
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.getScanPayTicketFromBookingId(java.lang.String):app.zophop.room.ScanPay");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x022a A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x022c A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0239 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x023b A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0248 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x024a A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x025b A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x025d A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x026e A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0270 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x028f A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0291 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x02a4 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02a6 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02bb A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x02bd A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02d0 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02d2 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02e1 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x02e3 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02f2 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02f4 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0300 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x0302 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x030e A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0310 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0323 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0325 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0338 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x033a A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0349 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x034b A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x035a A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x035c A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0369 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x036b A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x037a A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x037e A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0399 A[Catch:{ all -> 0x03a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x039d A[Catch:{ all -> 0x03a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01ef A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01f1 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01fb A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01fd A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0207 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0209 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0213 A[Catch:{ all -> 0x03b4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0215 A[Catch:{ all -> 0x03b4 }] */
    @Override // app.zophop.room.ProductDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public app.zophop.room.Ticket getTicketFromBookingId(java.lang.String r32) {
        /*
        // Method dump skipped, instructions count: 965
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.getTicketFromBookingId(java.lang.String):app.zophop.room.Ticket");
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x021f A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0221 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0236 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0238 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0245 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0247 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0254 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0256 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0267 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0269 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x027a A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x027c A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x029b A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x029d A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x02b0 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x02b2 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02c7 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x02c9 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x02dc A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02de A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x02ed A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02ef A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02fe A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x0300 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x030c A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x030e A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x031a A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x031c A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x032f A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0331 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0344 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0346 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0355 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x0357 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x0366 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x0368 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x0375 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0377 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0386 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x038a A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x03a5 A[Catch:{ all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x03a9 A[Catch:{ all -> 0x03b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01fb A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01fd A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0207 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0209 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0213 A[Catch:{ all -> 0x03bf }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0215 A[Catch:{ all -> 0x03bf }] */
    @Override // app.zophop.room.ProductDao
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public app.zophop.room.Ticket getTicketId(java.lang.String r32, java.lang.String r33) {
        /*
        // Method dump skipped, instructions count: 977
        */
        throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.ProductDao_Impl.getTicketId(java.lang.String, java.lang.String):app.zophop.room.Ticket");
    }

    @Override // app.zophop.room.ProductDao
    public void insert(Ticket ticket) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfTicket.insert(ticket);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.ProductDao
    public void insertAndReplacePass(Pass pass) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPass.insert(pass);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.ProductDao
    public void insertPass(Pass pass) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPass_1.insert(pass);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.ProductDao
    public void insertPendingPass(PassApplications passApplications) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfPassApplications.insert(passApplications);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.ProductDao
    public void insertRideDetails(RideDetails rideDetails) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfRideDetails.insert(rideDetails);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.ProductDao
    public void insertScanPayTicket(ScanPay scanPay) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfScanPay.insert(scanPay);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.ProductDao
    public void update(Ticket ticket) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfTicket.handle(ticket);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.ProductDao
    public void updateActivationData(String str, boolean z, String str2) {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfUpdateActivationData.acquire();
        acquire.d0(1, z ? 1 : 0);
        if (str2 == null) {
            acquire.E0(2);
        } else {
            acquire.z(2, str2);
        }
        if (str == null) {
            acquire.E0(3);
        } else {
            acquire.z(3, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateActivationData.release(acquire);
        }
    }

    @Override // app.zophop.room.ProductDao
    public void updateExpiryState(String str) {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfUpdateExpiryState.acquire();
        if (str == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateExpiryState.release(acquire);
        }
    }

    @Override // app.zophop.room.ProductDao
    public void updateExpiryStatus(String str, boolean z) {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfUpdateExpiryStatus.acquire();
        acquire.d0(1, z ? 1 : 0);
        if (str == null) {
            acquire.E0(2);
        } else {
            acquire.z(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateExpiryStatus.release(acquire);
        }
    }

    @Override // app.zophop.room.ProductDao
    public void updatePass(Pass pass) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfPass.handle(pass);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // app.zophop.room.ProductDao
    public void updatePunchStatus(List<MagicPassPunchInfo> list, String str) {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfUpdatePunchStatus.acquire();
        String punchString = MPass.toPunchString(list);
        if (punchString == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, punchString);
        }
        if (str == null) {
            acquire.E0(2);
        } else {
            acquire.z(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdatePunchStatus.release(acquire);
        }
    }

    @Override // app.zophop.room.ProductDao
    public void updateQrCode(String str, String str2) {
        this.__db.assertNotSuspendingTransaction();
        sm acquire = this.__preparedStmtOfUpdateQrCode.acquire();
        if (str2 == null) {
            acquire.E0(1);
        } else {
            acquire.z(1, str2);
        }
        if (str == null) {
            acquire.E0(2);
        } else {
            acquire.z(2, str);
        }
        this.__db.beginTransaction();
        try {
            acquire.F();
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
            this.__preparedStmtOfUpdateQrCode.release(acquire);
        }
    }
}
