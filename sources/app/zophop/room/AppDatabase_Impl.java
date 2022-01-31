package app.zophop.room;

import android.content.Context;
import app.zophop.models.mTicketing.superPass.SuperPassJsonKeys;
import defpackage.jm;
import defpackage.pm;
import defpackage.wl;
import defpackage.xl;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class AppDatabase_Impl extends AppDatabase {
    private volatile CityDataDao _cityDataDao;
    private volatile DigitalTripReceiptDao _digitalTripReceiptDao;
    private volatile OnlineCardRechargeDao _onlineCardRechargeDao;
    private volatile ProductDao _productDao;
    private volatile SuperPassDao _superPassDao;
    private volatile VisualValidationDao _visualValidationDao;

    @Override // defpackage.wl
    public void clearAllTables() {
        super.assertNotMainThread();
        om l0 = super.getOpenHelper().l0();
        try {
            super.beginTransaction();
            l0.y("DELETE FROM `Ticket`");
            l0.y("DELETE FROM `Pass`");
            l0.y("DELETE FROM `PassApplications`");
            l0.y("DELETE FROM `ScanPay`");
            l0.y("DELETE FROM `CityData`");
            l0.y("DELETE FROM `RideDetails`");
            l0.y("DELETE FROM `super_pass_application_table`");
            l0.y("DELETE FROM `magic_super_pass_table`");
            l0.y("DELETE FROM `ride_based_super_pass_table`");
            l0.y("DELETE FROM `ride_based_super_pass_ride_details_table`");
            l0.y("DELETE FROM `pending_super_pass_table`");
            l0.y("DELETE FROM `visual_validation_table`");
            l0.y("DELETE FROM `online_card_recharge_table`");
            l0.y("DELETE FROM `product_activation_details_table`");
            l0.y("DELETE FROM `super_pass_trip_receipt_table`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            l0.n0("PRAGMA wal_checkpoint(FULL)").close();
            if (!l0.J0()) {
                l0.y("VACUUM");
            }
        }
    }

    @Override // defpackage.wl
    public ul createInvalidationTracker() {
        return new ul(this, new HashMap(0), new HashMap(0), "Ticket", "Pass", "PassApplications", "ScanPay", "CityData", "RideDetails", "super_pass_application_table", "magic_super_pass_table", "ride_based_super_pass_table", "ride_based_super_pass_ride_details_table", "pending_super_pass_table", "visual_validation_table", "online_card_recharge_table", "product_activation_details_table", "super_pass_trip_receipt_table");
    }

    @Override // defpackage.wl
    public pm createOpenHelper(nl nlVar) {
        xl xlVar = new xl(nlVar, new xl.a(12) {
            /* class app.zophop.room.AppDatabase_Impl.AnonymousClass1 */

            @Override // defpackage.xl.a
            public void createAllTables(om omVar) {
                hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `Ticket` (`ticketId` TEXT NOT NULL, `mticket__mTicketId` TEXT, `mticket__userId` TEXT, `mticket__deviceId` TEXT, `mticket__cityName` TEXT, `mticket__agency` TEXT, `mticket__upTripRouteStopsInfo` TEXT, `mticket__upTripRouteStopsStageInfo` TEXT, `mticket__passengerDetails` TEXT, `mticket__bookingTime` INTEGER, `mticket__expirationTime` INTEGER, `mticket__isExpired` INTEGER, `mticket__upTripActivationTime` INTEGER, `mticket__isUpTripActivated` INTEGER, `mticket__upTripPunchingTime` INTEGER, `mticket__userProfile` TEXT, `mticket__qrCode` TEXT, `mticket__tone` TEXT, `mticket__mTicketConfiguration` TEXT, `mticket__isFreeRide` INTEGER, `mticket__isPaymentRequired` INTEGER, `mticket__recentPaymentMethod` TEXT, `mticket__cardDetails` TEXT, `mticket__customerId` TEXT, `mticket__orderId` TEXT, `mticket__status` TEXT, `mticket__paymentMode` TEXT, `mticket__mticketTripReceipt` TEXT, PRIMARY KEY(`ticketId`))", "CREATE TABLE IF NOT EXISTS `Pass` (`passId` TEXT NOT NULL, `pass__bookingPassId` TEXT, `pass__referenceId` TEXT, `pass__bookingPassType` TEXT, `pass__userProfile` TEXT, `pass__bookingTime` INTEGER, `pass__expiryTime` INTEGER, `pass__startingTime` INTEGER, `pass__passengerType` TEXT, `pass__ticketStatus` TEXT, `pass__agency` TEXT, `pass__fare` REAL, `pass__noOfDays` INTEGER, `pass__displayProps` TEXT, `pass__punches` TEXT, `pass__qrCode` TEXT, `pass__status` TEXT, `pass__paymentMode` TEXT, `pass__validity` INTEGER, `pass__verificationExpiryTime` INTEGER, `pass__cityName` TEXT, `pass__passRejectionReason` TEXT, `pass__isVerificationRequired` INTEGER, `pass__hasPassExpired` INTEGER, `pass__deviceId` TEXT, `pass__customerId` TEXT, `pass__recentPaymentMethod` TEXT, `pass__cardDetails` TEXT, `pass__configId` TEXT, `pass_orderId` TEXT, `pass__isPaymentRequired` INTEGER, `pass__specialFeatures` TEXT, `pass__routeStopsInfo` TEXT, `pass__productName` TEXT, `pass__grouping` TEXT, `pass__productType` TEXT, `pass__productCategory` TEXT, `pass__remainingTrips` INTEGER, `pass__maxTrips` INTEGER, `pass__maxTripsPerDay` INTEGER, `pass__catDisName` TEXT, `pass__maxTripsPrice` INTEGER, `pass__tone` TEXT, `pass__passApplicationRejectionReasons` TEXT, `pass__passApplicationActionRequired` TEXT, PRIMARY KEY(`passId`))", "CREATE TABLE IF NOT EXISTS `PassApplications` (`cityName` TEXT NOT NULL, `agencyName` TEXT NOT NULL, `passengerType` TEXT NOT NULL, `pass_app__bookingPassId` TEXT, `pass_app__referenceId` TEXT, `pass_app__bookingPassType` TEXT, `pass_app__userProfile` TEXT, `pass_app__bookingTime` INTEGER, `pass_app__expiryTime` INTEGER, `pass_app__startingTime` INTEGER, `pass_app__passengerType` TEXT, `pass_app__ticketStatus` TEXT, `pass_app__agency` TEXT, `pass_app__fare` REAL, `pass_app__noOfDays` INTEGER, `pass_app__displayProps` TEXT, `pass_app__punches` TEXT, `pass_app__qrCode` TEXT, `pass_app__status` TEXT, `pass_app__paymentMode` TEXT, `pass_app__validity` INTEGER, `pass_app__verificationExpiryTime` INTEGER, `pass_app__cityName` TEXT, `pass_app__passRejectionReason` TEXT, `pass_app__isVerificationRequired` INTEGER, `pass_app__hasPassExpired` INTEGER, `pass_app__deviceId` TEXT, `pass_app__customerId` TEXT, `pass_app__recentPaymentMethod` TEXT, `pass_app__cardDetails` TEXT, `pass_app__configId` TEXT, `pass_app_orderId` TEXT, `pass_app__isPaymentRequired` INTEGER, `pass_app__specialFeatures` TEXT, `pass_app__routeStopsInfo` TEXT, `pass_app__productName` TEXT, `pass_app__grouping` TEXT, `pass_app__productType` TEXT, `pass_app__productCategory` TEXT, `pass_app__remainingTrips` INTEGER, `pass_app__maxTrips` INTEGER, `pass_app__maxTripsPerDay` INTEGER, `pass_app__catDisName` TEXT, `pass_app__maxTripsPrice` INTEGER, `pass_app__tone` TEXT, `pass_app__passApplicationRejectionReasons` TEXT, `pass_app__passApplicationActionRequired` TEXT, PRIMARY KEY(`cityName`, `agencyName`, `passengerType`))", "CREATE TABLE IF NOT EXISTS `ScanPay` (`bookingId` TEXT NOT NULL, `scan_pay__uuid` TEXT, `scan_pay__fare` REAL, `scan_pay__discountedFare` REAL, `scan_pay__userId` TEXT, `scan_pay__deviceId` TEXT, `scan_pay__agencyName` TEXT, `scan_pay__bookingDetails` TEXT, `scan_pay__transactionId` TEXT, `scan_pay__bookingTime` INTEGER, `scan_pay__expirationTime` INTEGER, `scan_pay__recentPaymentMethod` TEXT, `scan_pay__cardDetails` TEXT, `scan_pay__customerId` TEXT, `scan_pay__orderId` TEXT, `scan_pay__status` TEXT, `scan_pay__qrCode` TEXT, `scan_pay__isExpired` INTEGER, `scan_pay__cityName` TEXT, `scan_pay__tone` TEXT, PRIMARY KEY(`bookingId`))");
                hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `CityData` (`type` TEXT NOT NULL, `cityName` TEXT NOT NULL, `mode` TEXT NOT NULL, `dataId` TEXT NOT NULL, `data` TEXT, `etag` TEXT, `version` INTEGER NOT NULL, PRIMARY KEY(`type`, `cityName`, `mode`, `dataId`))", "CREATE TABLE IF NOT EXISTS `RideDetails` (`_passId` TEXT NOT NULL, `_rideInfoList` TEXT, `_dailyRidesCount` TEXT, `_totalRideCount` TEXT, PRIMARY KEY(`_passId`))", "CREATE TABLE IF NOT EXISTS `super_pass_application_table` (`city_name` TEXT NOT NULL, `agency_name` TEXT NOT NULL, `config_id` TEXT NOT NULL, `category_id` TEXT NOT NULL, `fare_mapping_id` INTEGER NOT NULL, `fare_mapping_display_name` TEXT NOT NULL, `pass_name` TEXT NOT NULL, `pass_start_date` INTEGER NOT NULL, `verification_expiry_time` INTEGER NOT NULL, `super_pass_application_status` TEXT NOT NULL, `proofs` TEXT NOT NULL, `pass_application_action_required` TEXT, `super_pass_user_details_user_id` TEXT NOT NULL, `super_pass_user_details_mobile_number` TEXT NOT NULL, `super_pass_user_details_full_name` TEXT NOT NULL, `super_pass_user_details_gender` TEXT NOT NULL, `super_pass_user_details_date_of_birth` TEXT NOT NULL, `super_pass_user_details_email_id` TEXT NOT NULL, `super_pass_user_details_profile_photo` TEXT NOT NULL, `cash_payment_pending_transaction_details_pending_fare` REAL, `cash_payment_pending_transaction_details_reference_id` TEXT, `pass_application_rejection_reasons_proofRejectionReasonsList` TEXT, `pass_application_rejection_reasons_profileRejectionReasonsList` TEXT, `pass_application_rejection_reasons_generalRejectionReasonsList` TEXT, PRIMARY KEY(`city_name`, `agency_name`, `config_id`, `category_id`))", "CREATE TABLE IF NOT EXISTS `magic_super_pass_table` (`super_pass_properties_qr_code` TEXT NOT NULL, `super_pass_properties_tone` TEXT, `super_pass_properties_pass_id` TEXT NOT NULL, `super_pass_properties_product_type` TEXT NOT NULL, `super_pass_properties_product_sub_type` TEXT NOT NULL, `super_pass_properties_city_name` TEXT NOT NULL, `super_pass_properties_agency_name` TEXT NOT NULL, `super_pass_validation_properties_super_pass_status` TEXT NOT NULL, `super_pass_validation_properties_start_time` INTEGER NOT NULL, `super_pass_validation_properties_expiry_time` INTEGER NOT NULL, `super_pass_validation_properties_active_duration` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_last_activation_time_stamp` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_last_punch_time_stamp` INTEGER NOT NULL, `super_pass_ui_properties_num_of_days` INTEGER NOT NULL, `super_pass_ui_properties_special_features` TEXT NOT NULL, `super_pass_ui_properties_proofs` TEXT NOT NULL, `super_pass_ui_properties_booking_time` INTEGER NOT NULL, `super_pass_ui_properties_pass_name` TEXT NOT NULL, `super_pass_ui_properties_category_name` TEXT NOT NULL, `super_pass_ui_properties_fare_mapping_display_name` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_user_id` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_mobile_number` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_full_name` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_gender` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_date_of_birth` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_email_id` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_profile_photo` TEXT NOT NULL, `super_pass_ui_properties_fare_infopayableAmount` REAL NOT NULL, `super_pass_ui_properties_fare_infoactualFare` REAL NOT NULL, `super_pass_ui_properties_fare_infoisDiscountApplicable` INTEGER NOT NULL, `super_pass_ui_properties_fare_infodiscountedFare` REAL NOT NULL, `super_pass_ui_properties_fare_infofareBreakupComponentList` TEXT NOT NULL, `super_pass_ui_properties_product_brandingis_visible` INTEGER NOT NULL, `super_pass_repurchase_properties_config_id` TEXT NOT NULL, `super_pass_repurchase_properties_category_id` TEXT NOT NULL, `super_pass_repurchase_properties_fare_mapping_id` INTEGER NOT NULL, `super_pass_repurchase_properties_verification_expiry_time` INTEGER NOT NULL, `super_pass_repurchase_properties_verification_flag` INTEGER NOT NULL, `super_pass_repurchase_properties_is_renewable` INTEGER NOT NULL, `super_pass_transaction_details_transaction_id` TEXT NOT NULL, `super_pass_transaction_details_payment_mode` TEXT NOT NULL, PRIMARY KEY(`super_pass_properties_pass_id`))");
                hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `ride_based_super_pass_table` (`super_pass_validation_properties_max_trips_per_day` INTEGER NOT NULL, `super_pass_validation_properties_num_of_trips` INTEGER NOT NULL, `super_pass_validation_properties_super_pass_status` TEXT NOT NULL, `super_pass_validation_properties_start_time` INTEGER NOT NULL, `super_pass_validation_properties_expiry_time` INTEGER NOT NULL, `super_pass_validation_properties_active_duration` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_previous_ride_time_stamps` TEXT NOT NULL, `super_pass_validation_properties_ride_details_is_activation_allowed_in_current_session` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_oldest_history_call_time_stamp` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_last_activation_time_stamp` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_last_punch_time_stamp` INTEGER NOT NULL, `super_pass_ui_properties_max_price_per_trip` REAL NOT NULL, `super_pass_ui_properties_fare_mapping_description` TEXT NOT NULL, `super_pass_ui_properties_num_of_days` INTEGER NOT NULL, `super_pass_ui_properties_special_features` TEXT NOT NULL, `super_pass_ui_properties_proofs` TEXT NOT NULL, `super_pass_ui_properties_booking_time` INTEGER NOT NULL, `super_pass_ui_properties_pass_name` TEXT NOT NULL, `super_pass_ui_properties_category_name` TEXT NOT NULL, `super_pass_ui_properties_fare_mapping_display_name` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_user_id` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_mobile_number` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_full_name` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_gender` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_date_of_birth` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_email_id` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_profile_photo` TEXT NOT NULL, `super_pass_ui_properties_fare_infopayableAmount` REAL NOT NULL, `super_pass_ui_properties_fare_infoactualFare` REAL NOT NULL, `super_pass_ui_properties_fare_infoisDiscountApplicable` INTEGER NOT NULL, `super_pass_ui_properties_fare_infodiscountedFare` REAL NOT NULL, `super_pass_ui_properties_fare_infofareBreakupComponentList` TEXT NOT NULL, `super_pass_ui_properties_product_brandingis_visible` INTEGER NOT NULL, `super_pass_properties_qr_code` TEXT NOT NULL, `super_pass_properties_tone` TEXT, `super_pass_properties_pass_id` TEXT NOT NULL, `super_pass_properties_product_type` TEXT NOT NULL, `super_pass_properties_product_sub_type` TEXT NOT NULL, `super_pass_properties_city_name` TEXT NOT NULL, `super_pass_properties_agency_name` TEXT NOT NULL, `super_pass_repurchase_properties_config_id` TEXT NOT NULL, `super_pass_repurchase_properties_category_id` TEXT NOT NULL, `super_pass_repurchase_properties_fare_mapping_id` INTEGER NOT NULL, `super_pass_repurchase_properties_verification_expiry_time` INTEGER NOT NULL, `super_pass_repurchase_properties_verification_flag` INTEGER NOT NULL, `super_pass_repurchase_properties_is_renewable` INTEGER NOT NULL, `super_pass_transaction_details_transaction_id` TEXT NOT NULL, `super_pass_transaction_details_payment_mode` TEXT NOT NULL, PRIMARY KEY(`super_pass_properties_pass_id`))", "CREATE TABLE IF NOT EXISTS `ride_based_super_pass_ride_details_table` (`pass_id` TEXT NOT NULL, `previous_ride_time_stamps` TEXT NOT NULL, `is_activation_allowed_in_current_session` INTEGER NOT NULL, `oldest_history_call_time_stamp` INTEGER NOT NULL, `last_activation_time_stamp` INTEGER NOT NULL, `last_punch_time_stamp` INTEGER NOT NULL, PRIMARY KEY(`pass_id`))", "CREATE TABLE IF NOT EXISTS `pending_super_pass_table` (`pending_super_pass_properties_super_pass_status` TEXT NOT NULL, `pending_super_pass_properties_pass_id` TEXT NOT NULL, `pending_super_pass_properties_product_type` TEXT NOT NULL, `pending_super_pass_properties_product_sub_type` TEXT NOT NULL, `pending_super_pass_properties_city_name` TEXT NOT NULL, `pending_super_pass_properties_agency_name` TEXT NOT NULL, `pending_super_pass_ui_properties_max_price_per_trip` REAL NOT NULL, `pending_super_pass_ui_properties_fare_mapping_description` TEXT, `pending_super_pass_ui_properties_num_of_days` INTEGER NOT NULL, `pending_super_pass_ui_properties_special_features` TEXT NOT NULL, `pending_super_pass_ui_properties_proofs` TEXT NOT NULL, `pending_super_pass_ui_properties_booking_time` INTEGER NOT NULL, `pending_super_pass_ui_properties_pass_name` TEXT NOT NULL, `pending_super_pass_ui_properties_category_name` TEXT NOT NULL, `pending_super_pass_ui_properties_fare_mapping_display_name` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_user_id` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_mobile_number` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_full_name` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_gender` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_date_of_birth` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_email_id` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_profile_photo` TEXT NOT NULL, `pending_super_pass_ui_properties_fare_infopayableAmount` REAL NOT NULL, `pending_super_pass_ui_properties_fare_infoactualFare` REAL NOT NULL, `pending_super_pass_ui_properties_fare_infoisDiscountApplicable` INTEGER NOT NULL, `pending_super_pass_ui_properties_fare_infodiscountedFare` REAL NOT NULL, `pending_super_pass_ui_properties_fare_infofareBreakupComponentList` TEXT NOT NULL, `pending_super_pass_ui_properties_product_brandingis_visible` INTEGER NOT NULL, `pending_super_pass_repurchase_properties_config_id` TEXT NOT NULL, `pending_super_pass_repurchase_properties_category_id` TEXT NOT NULL, `pending_super_pass_repurchase_properties_fare_mapping_id` INTEGER NOT NULL, `pending_super_pass_repurchase_properties_start_time` INTEGER NOT NULL, `pending_super_pass_repurchase_properties_verification_expiry_time` INTEGER NOT NULL, `pending_super_pass_repurchase_properties_verification_flag` INTEGER NOT NULL, `pending_super_pass_transaction_details_payment_mode` TEXT NOT NULL, `pending_super_pass_transaction_details_transaction_id` TEXT NOT NULL, `pending_super_pass_transaction_details_order_id` TEXT, PRIMARY KEY(`pending_super_pass_properties_pass_id`))", "CREATE TABLE IF NOT EXISTS `visual_validation_table` (`activation_time_stamp` INTEGER NOT NULL, `booking_id` TEXT NOT NULL, `expiry_time` INTEGER NOT NULL, `product_type` TEXT NOT NULL, `city_name` TEXT NOT NULL, `agency_name` TEXT NOT NULL, PRIMARY KEY(`activation_time_stamp`))");
                hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `online_card_recharge_table` (`payment_properties_card_recharge_transaction_id` TEXT NOT NULL, `payment_properties_card_recharge_payment_mode` TEXT NOT NULL, `payment_properties_card_recharge_payment_time` INTEGER NOT NULL, `payment_properties_card_recharge_card_recharge_info_payment_status` TEXT NOT NULL, `payment_properties_card_recharge_card_recharge_info_recharge_status` TEXT NOT NULL, `payment_properties_card_recharge_card_recharge_info_recharge_amount` INTEGER NOT NULL, `ui_properties_card_recharge_product_name` TEXT NOT NULL, `ui_properties_card_recharge_recharge_delay_copy` TEXT NOT NULL, `ui_properties_card_recharge_branding_is_visible` INTEGER NOT NULL, `card_properties_card_recharge_card_no` TEXT NOT NULL, `card_properties_card_recharge_city` TEXT NOT NULL, `card_properties_card_recharge_agency` TEXT NOT NULL, PRIMARY KEY(`payment_properties_card_recharge_transaction_id`))", "CREATE TABLE IF NOT EXISTS `product_activation_details_table` (`activation_time_stamp` INTEGER NOT NULL, `booking_id` TEXT NOT NULL, `expiry_time` INTEGER NOT NULL, `product_type` TEXT NOT NULL, `product_sub_type` TEXT NOT NULL, `city_name` TEXT NOT NULL, `agency_name` TEXT NOT NULL, PRIMARY KEY(`activation_time_stamp`, `booking_id`, `product_type`))", "CREATE TABLE IF NOT EXISTS `super_pass_trip_receipt_table` (`pass_id` TEXT NOT NULL, `product_type` TEXT NOT NULL, `product_sub_type` TEXT NOT NULL, `activation_time_stamp` INTEGER NOT NULL, `punch_time_stamp` INTEGER NOT NULL, `vehicle_no` TEXT NOT NULL, `conductor_id` TEXT NOT NULL, `start_stop_name` TEXT NOT NULL, `end_stop_name` TEXT NOT NULL, `route_name` TEXT NOT NULL, `special_features_list` TEXT NOT NULL, PRIMARY KEY(`pass_id`, `activation_time_stamp`, `punch_time_stamp`))", "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                omVar.y("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '9fa0f0b8929cc22a68dd187513c82a65')");
            }

            @Override // defpackage.xl.a
            public void dropAllTables(om omVar) {
                hj1.B0(omVar, "DROP TABLE IF EXISTS `Ticket`", "DROP TABLE IF EXISTS `Pass`", "DROP TABLE IF EXISTS `PassApplications`", "DROP TABLE IF EXISTS `ScanPay`");
                hj1.B0(omVar, "DROP TABLE IF EXISTS `CityData`", "DROP TABLE IF EXISTS `RideDetails`", "DROP TABLE IF EXISTS `super_pass_application_table`", "DROP TABLE IF EXISTS `magic_super_pass_table`");
                hj1.B0(omVar, "DROP TABLE IF EXISTS `ride_based_super_pass_table`", "DROP TABLE IF EXISTS `ride_based_super_pass_ride_details_table`", "DROP TABLE IF EXISTS `pending_super_pass_table`", "DROP TABLE IF EXISTS `visual_validation_table`");
                omVar.y("DROP TABLE IF EXISTS `online_card_recharge_table`");
                omVar.y("DROP TABLE IF EXISTS `product_activation_details_table`");
                omVar.y("DROP TABLE IF EXISTS `super_pass_trip_receipt_table`");
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((wl.b) AppDatabase_Impl.this.mCallbacks.get(i)).onDestructiveMigration(omVar);
                    }
                }
            }

            @Override // defpackage.xl.a
            public void onCreate(om omVar) {
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((wl.b) AppDatabase_Impl.this.mCallbacks.get(i)).onCreate(omVar);
                    }
                }
            }

            @Override // defpackage.xl.a
            public void onOpen(om omVar) {
                AppDatabase_Impl.this.mDatabase = omVar;
                AppDatabase_Impl.this.internalInitInvalidationTracker(omVar);
                if (AppDatabase_Impl.this.mCallbacks != null) {
                    int size = AppDatabase_Impl.this.mCallbacks.size();
                    for (int i = 0; i < size; i++) {
                        ((wl.b) AppDatabase_Impl.this.mCallbacks.get(i)).onOpen(omVar);
                    }
                }
            }

            @Override // defpackage.xl.a
            public void onPostMigrate(om omVar) {
            }

            @Override // defpackage.xl.a
            public void onPreMigrate(om omVar) {
                hm.a(omVar);
            }

            @Override // defpackage.xl.a
            public xl.b onValidateSchema(om omVar) {
                HashMap hashMap = new HashMap(28);
                hashMap.put("ticketId", new jm.a("ticketId", "TEXT", true, 1, null, 1));
                hashMap.put("mticket__mTicketId", new jm.a("mticket__mTicketId", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__userId", new jm.a("mticket__userId", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__deviceId", new jm.a("mticket__deviceId", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__cityName", new jm.a("mticket__cityName", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__agency", new jm.a("mticket__agency", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__upTripRouteStopsInfo", new jm.a("mticket__upTripRouteStopsInfo", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__upTripRouteStopsStageInfo", new jm.a("mticket__upTripRouteStopsStageInfo", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__passengerDetails", new jm.a("mticket__passengerDetails", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__bookingTime", new jm.a("mticket__bookingTime", "INTEGER", false, 0, null, 1));
                hashMap.put("mticket__expirationTime", new jm.a("mticket__expirationTime", "INTEGER", false, 0, null, 1));
                hashMap.put("mticket__isExpired", new jm.a("mticket__isExpired", "INTEGER", false, 0, null, 1));
                hashMap.put("mticket__upTripActivationTime", new jm.a("mticket__upTripActivationTime", "INTEGER", false, 0, null, 1));
                hashMap.put("mticket__isUpTripActivated", new jm.a("mticket__isUpTripActivated", "INTEGER", false, 0, null, 1));
                hashMap.put("mticket__upTripPunchingTime", new jm.a("mticket__upTripPunchingTime", "INTEGER", false, 0, null, 1));
                hashMap.put("mticket__userProfile", new jm.a("mticket__userProfile", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__qrCode", new jm.a("mticket__qrCode", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__tone", new jm.a("mticket__tone", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__mTicketConfiguration", new jm.a("mticket__mTicketConfiguration", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__isFreeRide", new jm.a("mticket__isFreeRide", "INTEGER", false, 0, null, 1));
                hashMap.put("mticket__isPaymentRequired", new jm.a("mticket__isPaymentRequired", "INTEGER", false, 0, null, 1));
                hashMap.put("mticket__recentPaymentMethod", new jm.a("mticket__recentPaymentMethod", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__cardDetails", new jm.a("mticket__cardDetails", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__customerId", new jm.a("mticket__customerId", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__orderId", new jm.a("mticket__orderId", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__status", new jm.a("mticket__status", "TEXT", false, 0, null, 1));
                hashMap.put("mticket__paymentMode", new jm.a("mticket__paymentMode", "TEXT", false, 0, null, 1));
                jm jmVar = new jm("Ticket", hashMap, hj1.o0(hashMap, "mticket__mticketTripReceipt", new jm.a("mticket__mticketTripReceipt", "TEXT", false, 0, null, 1), 0), new HashSet(0));
                jm a2 = jm.a(omVar, "Ticket");
                if (!jmVar.equals(a2)) {
                    return new xl.b(false, hj1.P("Ticket(app.zophop.room.Ticket).\n Expected:\n", jmVar, "\n Found:\n", a2));
                }
                HashMap hashMap2 = new HashMap(45);
                hashMap2.put("passId", new jm.a("passId", "TEXT", true, 1, null, 1));
                hashMap2.put("pass__bookingPassId", new jm.a("pass__bookingPassId", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__referenceId", new jm.a("pass__referenceId", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__bookingPassType", new jm.a("pass__bookingPassType", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__userProfile", new jm.a("pass__userProfile", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__bookingTime", new jm.a("pass__bookingTime", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__expiryTime", new jm.a("pass__expiryTime", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__startingTime", new jm.a("pass__startingTime", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__passengerType", new jm.a("pass__passengerType", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__ticketStatus", new jm.a("pass__ticketStatus", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__agency", new jm.a("pass__agency", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__fare", new jm.a("pass__fare", "REAL", false, 0, null, 1));
                hashMap2.put("pass__noOfDays", new jm.a("pass__noOfDays", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__displayProps", new jm.a("pass__displayProps", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__punches", new jm.a("pass__punches", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__qrCode", new jm.a("pass__qrCode", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__status", new jm.a("pass__status", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__paymentMode", new jm.a("pass__paymentMode", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__validity", new jm.a("pass__validity", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__verificationExpiryTime", new jm.a("pass__verificationExpiryTime", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__cityName", new jm.a("pass__cityName", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__passRejectionReason", new jm.a("pass__passRejectionReason", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__isVerificationRequired", new jm.a("pass__isVerificationRequired", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__hasPassExpired", new jm.a("pass__hasPassExpired", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__deviceId", new jm.a("pass__deviceId", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__customerId", new jm.a("pass__customerId", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__recentPaymentMethod", new jm.a("pass__recentPaymentMethod", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__cardDetails", new jm.a("pass__cardDetails", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__configId", new jm.a("pass__configId", "TEXT", false, 0, null, 1));
                hashMap2.put("pass_orderId", new jm.a("pass_orderId", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__isPaymentRequired", new jm.a("pass__isPaymentRequired", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__specialFeatures", new jm.a("pass__specialFeatures", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__routeStopsInfo", new jm.a("pass__routeStopsInfo", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__productName", new jm.a("pass__productName", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__grouping", new jm.a("pass__grouping", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__productType", new jm.a("pass__productType", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__productCategory", new jm.a("pass__productCategory", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__remainingTrips", new jm.a("pass__remainingTrips", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__maxTrips", new jm.a("pass__maxTrips", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__maxTripsPerDay", new jm.a("pass__maxTripsPerDay", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__catDisName", new jm.a("pass__catDisName", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__maxTripsPrice", new jm.a("pass__maxTripsPrice", "INTEGER", false, 0, null, 1));
                hashMap2.put("pass__tone", new jm.a("pass__tone", "TEXT", false, 0, null, 1));
                hashMap2.put("pass__passApplicationRejectionReasons", new jm.a("pass__passApplicationRejectionReasons", "TEXT", false, 0, null, 1));
                jm jmVar2 = new jm("Pass", hashMap2, hj1.o0(hashMap2, "pass__passApplicationActionRequired", new jm.a("pass__passApplicationActionRequired", "TEXT", false, 0, null, 1), 0), new HashSet(0));
                jm a3 = jm.a(omVar, "Pass");
                if (!jmVar2.equals(a3)) {
                    return new xl.b(false, hj1.P("Pass(app.zophop.room.Pass).\n Expected:\n", jmVar2, "\n Found:\n", a3));
                }
                HashMap hashMap3 = new HashMap(47);
                hashMap3.put("cityName", new jm.a("cityName", "TEXT", true, 1, null, 1));
                hashMap3.put("agencyName", new jm.a("agencyName", "TEXT", true, 2, null, 1));
                hashMap3.put("passengerType", new jm.a("passengerType", "TEXT", true, 3, null, 1));
                hashMap3.put("pass_app__bookingPassId", new jm.a("pass_app__bookingPassId", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__referenceId", new jm.a("pass_app__referenceId", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__bookingPassType", new jm.a("pass_app__bookingPassType", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__userProfile", new jm.a("pass_app__userProfile", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__bookingTime", new jm.a("pass_app__bookingTime", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__expiryTime", new jm.a("pass_app__expiryTime", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__startingTime", new jm.a("pass_app__startingTime", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__passengerType", new jm.a("pass_app__passengerType", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__ticketStatus", new jm.a("pass_app__ticketStatus", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__agency", new jm.a("pass_app__agency", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__fare", new jm.a("pass_app__fare", "REAL", false, 0, null, 1));
                hashMap3.put("pass_app__noOfDays", new jm.a("pass_app__noOfDays", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__displayProps", new jm.a("pass_app__displayProps", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__punches", new jm.a("pass_app__punches", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__qrCode", new jm.a("pass_app__qrCode", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__status", new jm.a("pass_app__status", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__paymentMode", new jm.a("pass_app__paymentMode", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__validity", new jm.a("pass_app__validity", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__verificationExpiryTime", new jm.a("pass_app__verificationExpiryTime", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__cityName", new jm.a("pass_app__cityName", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__passRejectionReason", new jm.a("pass_app__passRejectionReason", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__isVerificationRequired", new jm.a("pass_app__isVerificationRequired", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__hasPassExpired", new jm.a("pass_app__hasPassExpired", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__deviceId", new jm.a("pass_app__deviceId", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__customerId", new jm.a("pass_app__customerId", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__recentPaymentMethod", new jm.a("pass_app__recentPaymentMethod", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__cardDetails", new jm.a("pass_app__cardDetails", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__configId", new jm.a("pass_app__configId", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app_orderId", new jm.a("pass_app_orderId", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__isPaymentRequired", new jm.a("pass_app__isPaymentRequired", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__specialFeatures", new jm.a("pass_app__specialFeatures", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__routeStopsInfo", new jm.a("pass_app__routeStopsInfo", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__productName", new jm.a("pass_app__productName", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__grouping", new jm.a("pass_app__grouping", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__productType", new jm.a("pass_app__productType", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__productCategory", new jm.a("pass_app__productCategory", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__remainingTrips", new jm.a("pass_app__remainingTrips", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__maxTrips", new jm.a("pass_app__maxTrips", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__maxTripsPerDay", new jm.a("pass_app__maxTripsPerDay", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__catDisName", new jm.a("pass_app__catDisName", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__maxTripsPrice", new jm.a("pass_app__maxTripsPrice", "INTEGER", false, 0, null, 1));
                hashMap3.put("pass_app__tone", new jm.a("pass_app__tone", "TEXT", false, 0, null, 1));
                hashMap3.put("pass_app__passApplicationRejectionReasons", new jm.a("pass_app__passApplicationRejectionReasons", "TEXT", false, 0, null, 1));
                jm jmVar3 = new jm("PassApplications", hashMap3, hj1.o0(hashMap3, "pass_app__passApplicationActionRequired", new jm.a("pass_app__passApplicationActionRequired", "TEXT", false, 0, null, 1), 0), new HashSet(0));
                jm a4 = jm.a(omVar, "PassApplications");
                if (!jmVar3.equals(a4)) {
                    return new xl.b(false, hj1.P("PassApplications(app.zophop.room.PassApplications).\n Expected:\n", jmVar3, "\n Found:\n", a4));
                }
                HashMap hashMap4 = new HashMap(20);
                hashMap4.put("bookingId", new jm.a("bookingId", "TEXT", true, 1, null, 1));
                hashMap4.put("scan_pay__uuid", new jm.a("scan_pay__uuid", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__fare", new jm.a("scan_pay__fare", "REAL", false, 0, null, 1));
                hashMap4.put("scan_pay__discountedFare", new jm.a("scan_pay__discountedFare", "REAL", false, 0, null, 1));
                hashMap4.put("scan_pay__userId", new jm.a("scan_pay__userId", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__deviceId", new jm.a("scan_pay__deviceId", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__agencyName", new jm.a("scan_pay__agencyName", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__bookingDetails", new jm.a("scan_pay__bookingDetails", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__transactionId", new jm.a("scan_pay__transactionId", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__bookingTime", new jm.a("scan_pay__bookingTime", "INTEGER", false, 0, null, 1));
                hashMap4.put("scan_pay__expirationTime", new jm.a("scan_pay__expirationTime", "INTEGER", false, 0, null, 1));
                hashMap4.put("scan_pay__recentPaymentMethod", new jm.a("scan_pay__recentPaymentMethod", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__cardDetails", new jm.a("scan_pay__cardDetails", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__customerId", new jm.a("scan_pay__customerId", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__orderId", new jm.a("scan_pay__orderId", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__status", new jm.a("scan_pay__status", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__qrCode", new jm.a("scan_pay__qrCode", "TEXT", false, 0, null, 1));
                hashMap4.put("scan_pay__isExpired", new jm.a("scan_pay__isExpired", "INTEGER", false, 0, null, 1));
                hashMap4.put("scan_pay__cityName", new jm.a("scan_pay__cityName", "TEXT", false, 0, null, 1));
                jm jmVar4 = new jm("ScanPay", hashMap4, hj1.o0(hashMap4, "scan_pay__tone", new jm.a("scan_pay__tone", "TEXT", false, 0, null, 1), 0), new HashSet(0));
                jm a5 = jm.a(omVar, "ScanPay");
                if (!jmVar4.equals(a5)) {
                    return new xl.b(false, hj1.P("ScanPay(app.zophop.room.ScanPay).\n Expected:\n", jmVar4, "\n Found:\n", a5));
                }
                HashMap hashMap5 = new HashMap(7);
                hashMap5.put("type", new jm.a("type", "TEXT", true, 1, null, 1));
                hashMap5.put("cityName", new jm.a("cityName", "TEXT", true, 2, null, 1));
                hashMap5.put("mode", new jm.a("mode", "TEXT", true, 3, null, 1));
                hashMap5.put("dataId", new jm.a("dataId", "TEXT", true, 4, null, 1));
                hashMap5.put("data", new jm.a("data", "TEXT", false, 0, null, 1));
                hashMap5.put("etag", new jm.a("etag", "TEXT", false, 0, null, 1));
                jm jmVar5 = new jm("CityData", hashMap5, hj1.o0(hashMap5, "version", new jm.a("version", "INTEGER", true, 0, null, 1), 0), new HashSet(0));
                jm a6 = jm.a(omVar, "CityData");
                if (!jmVar5.equals(a6)) {
                    return new xl.b(false, hj1.P("CityData(app.zophop.room.CityData).\n Expected:\n", jmVar5, "\n Found:\n", a6));
                }
                HashMap hashMap6 = new HashMap(4);
                hashMap6.put("_passId", new jm.a("_passId", "TEXT", true, 1, null, 1));
                hashMap6.put("_rideInfoList", new jm.a("_rideInfoList", "TEXT", false, 0, null, 1));
                hashMap6.put("_dailyRidesCount", new jm.a("_dailyRidesCount", "TEXT", false, 0, null, 1));
                jm jmVar6 = new jm("RideDetails", hashMap6, hj1.o0(hashMap6, "_totalRideCount", new jm.a("_totalRideCount", "TEXT", false, 0, null, 1), 0), new HashSet(0));
                jm a7 = jm.a(omVar, "RideDetails");
                if (!jmVar6.equals(a7)) {
                    return new xl.b(false, hj1.P("RideDetails(app.zophop.models.mTicketing.RideDetails).\n Expected:\n", jmVar6, "\n Found:\n", a7));
                }
                HashMap hashMap7 = new HashMap(24);
                hashMap7.put("city_name", new jm.a("city_name", "TEXT", true, 1, null, 1));
                hashMap7.put("agency_name", new jm.a("agency_name", "TEXT", true, 2, null, 1));
                hashMap7.put("config_id", new jm.a("config_id", "TEXT", true, 3, null, 1));
                hashMap7.put("category_id", new jm.a("category_id", "TEXT", true, 4, null, 1));
                hashMap7.put("fare_mapping_id", new jm.a("fare_mapping_id", "INTEGER", true, 0, null, 1));
                hashMap7.put("fare_mapping_display_name", new jm.a("fare_mapping_display_name", "TEXT", true, 0, null, 1));
                hashMap7.put("pass_name", new jm.a("pass_name", "TEXT", true, 0, null, 1));
                hashMap7.put("pass_start_date", new jm.a("pass_start_date", "INTEGER", true, 0, null, 1));
                hashMap7.put("verification_expiry_time", new jm.a("verification_expiry_time", "INTEGER", true, 0, null, 1));
                hashMap7.put("super_pass_application_status", new jm.a("super_pass_application_status", "TEXT", true, 0, null, 1));
                hashMap7.put(SuperPassJsonKeys.PROOFS, new jm.a(SuperPassJsonKeys.PROOFS, "TEXT", true, 0, null, 1));
                hashMap7.put("pass_application_action_required", new jm.a("pass_application_action_required", "TEXT", false, 0, null, 1));
                hashMap7.put("super_pass_user_details_user_id", new jm.a("super_pass_user_details_user_id", "TEXT", true, 0, null, 1));
                hashMap7.put("super_pass_user_details_mobile_number", new jm.a("super_pass_user_details_mobile_number", "TEXT", true, 0, null, 1));
                hashMap7.put("super_pass_user_details_full_name", new jm.a("super_pass_user_details_full_name", "TEXT", true, 0, null, 1));
                hashMap7.put("super_pass_user_details_gender", new jm.a("super_pass_user_details_gender", "TEXT", true, 0, null, 1));
                hashMap7.put("super_pass_user_details_date_of_birth", new jm.a("super_pass_user_details_date_of_birth", "TEXT", true, 0, null, 1));
                hashMap7.put("super_pass_user_details_email_id", new jm.a("super_pass_user_details_email_id", "TEXT", true, 0, null, 1));
                hashMap7.put("super_pass_user_details_profile_photo", new jm.a("super_pass_user_details_profile_photo", "TEXT", true, 0, null, 1));
                hashMap7.put("cash_payment_pending_transaction_details_pending_fare", new jm.a("cash_payment_pending_transaction_details_pending_fare", "REAL", false, 0, null, 1));
                hashMap7.put("cash_payment_pending_transaction_details_reference_id", new jm.a("cash_payment_pending_transaction_details_reference_id", "TEXT", false, 0, null, 1));
                hashMap7.put("pass_application_rejection_reasons_proofRejectionReasonsList", new jm.a("pass_application_rejection_reasons_proofRejectionReasonsList", "TEXT", false, 0, null, 1));
                hashMap7.put("pass_application_rejection_reasons_profileRejectionReasonsList", new jm.a("pass_application_rejection_reasons_profileRejectionReasonsList", "TEXT", false, 0, null, 1));
                jm jmVar7 = new jm("super_pass_application_table", hashMap7, hj1.o0(hashMap7, "pass_application_rejection_reasons_generalRejectionReasonsList", new jm.a("pass_application_rejection_reasons_generalRejectionReasonsList", "TEXT", false, 0, null, 1), 0), new HashSet(0));
                jm a8 = jm.a(omVar, "super_pass_application_table");
                if (!jmVar7.equals(a8)) {
                    return new xl.b(false, hj1.P("super_pass_application_table(app.zophop.models.mTicketing.superPass.SuperPassApplication).\n Expected:\n", jmVar7, "\n Found:\n", a8));
                }
                HashMap hashMap8 = new HashMap(41);
                hashMap8.put("super_pass_properties_qr_code", new jm.a("super_pass_properties_qr_code", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_properties_tone", new jm.a("super_pass_properties_tone", "TEXT", false, 0, null, 1));
                hashMap8.put("super_pass_properties_pass_id", new jm.a("super_pass_properties_pass_id", "TEXT", true, 1, null, 1));
                hashMap8.put("super_pass_properties_product_type", new jm.a("super_pass_properties_product_type", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_properties_product_sub_type", new jm.a("super_pass_properties_product_sub_type", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_properties_city_name", new jm.a("super_pass_properties_city_name", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_properties_agency_name", new jm.a("super_pass_properties_agency_name", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_validation_properties_super_pass_status", new jm.a("super_pass_validation_properties_super_pass_status", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_validation_properties_start_time", new jm.a("super_pass_validation_properties_start_time", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_validation_properties_expiry_time", new jm.a("super_pass_validation_properties_expiry_time", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_validation_properties_active_duration", new jm.a("super_pass_validation_properties_active_duration", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_validation_properties_ride_details_last_activation_time_stamp", new jm.a("super_pass_validation_properties_ride_details_last_activation_time_stamp", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_validation_properties_ride_details_last_punch_time_stamp", new jm.a("super_pass_validation_properties_ride_details_last_punch_time_stamp", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_num_of_days", new jm.a("super_pass_ui_properties_num_of_days", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_special_features", new jm.a("super_pass_ui_properties_special_features", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_proofs", new jm.a("super_pass_ui_properties_proofs", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_booking_time", new jm.a("super_pass_ui_properties_booking_time", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_pass_name", new jm.a("super_pass_ui_properties_pass_name", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_category_name", new jm.a("super_pass_ui_properties_category_name", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_fare_mapping_display_name", new jm.a("super_pass_ui_properties_fare_mapping_display_name", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_super_pass_user_details_user_id", new jm.a("super_pass_ui_properties_super_pass_user_details_user_id", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_super_pass_user_details_mobile_number", new jm.a("super_pass_ui_properties_super_pass_user_details_mobile_number", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_super_pass_user_details_full_name", new jm.a("super_pass_ui_properties_super_pass_user_details_full_name", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_super_pass_user_details_gender", new jm.a("super_pass_ui_properties_super_pass_user_details_gender", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_super_pass_user_details_date_of_birth", new jm.a("super_pass_ui_properties_super_pass_user_details_date_of_birth", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_super_pass_user_details_email_id", new jm.a("super_pass_ui_properties_super_pass_user_details_email_id", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_super_pass_user_details_profile_photo", new jm.a("super_pass_ui_properties_super_pass_user_details_profile_photo", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_fare_infopayableAmount", new jm.a("super_pass_ui_properties_fare_infopayableAmount", "REAL", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_fare_infoactualFare", new jm.a("super_pass_ui_properties_fare_infoactualFare", "REAL", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_fare_infoisDiscountApplicable", new jm.a("super_pass_ui_properties_fare_infoisDiscountApplicable", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_fare_infodiscountedFare", new jm.a("super_pass_ui_properties_fare_infodiscountedFare", "REAL", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_fare_infofareBreakupComponentList", new jm.a("super_pass_ui_properties_fare_infofareBreakupComponentList", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_ui_properties_product_brandingis_visible", new jm.a("super_pass_ui_properties_product_brandingis_visible", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_repurchase_properties_config_id", new jm.a("super_pass_repurchase_properties_config_id", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_repurchase_properties_category_id", new jm.a("super_pass_repurchase_properties_category_id", "TEXT", true, 0, null, 1));
                hashMap8.put("super_pass_repurchase_properties_fare_mapping_id", new jm.a("super_pass_repurchase_properties_fare_mapping_id", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_repurchase_properties_verification_expiry_time", new jm.a("super_pass_repurchase_properties_verification_expiry_time", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_repurchase_properties_verification_flag", new jm.a("super_pass_repurchase_properties_verification_flag", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_repurchase_properties_is_renewable", new jm.a("super_pass_repurchase_properties_is_renewable", "INTEGER", true, 0, null, 1));
                hashMap8.put("super_pass_transaction_details_transaction_id", new jm.a("super_pass_transaction_details_transaction_id", "TEXT", true, 0, null, 1));
                jm jmVar8 = new jm("magic_super_pass_table", hashMap8, hj1.o0(hashMap8, "super_pass_transaction_details_payment_mode", new jm.a("super_pass_transaction_details_payment_mode", "TEXT", true, 0, null, 1), 0), new HashSet(0));
                jm a9 = jm.a(omVar, "magic_super_pass_table");
                if (!jmVar8.equals(a9)) {
                    return new xl.b(false, hj1.P("magic_super_pass_table(app.zophop.models.mTicketing.superPass.MagicSuperPass).\n Expected:\n", jmVar8, "\n Found:\n", a9));
                }
                HashMap hashMap9 = new HashMap(48);
                hashMap9.put("super_pass_validation_properties_max_trips_per_day", new jm.a("super_pass_validation_properties_max_trips_per_day", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_num_of_trips", new jm.a("super_pass_validation_properties_num_of_trips", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_super_pass_status", new jm.a("super_pass_validation_properties_super_pass_status", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_start_time", new jm.a("super_pass_validation_properties_start_time", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_expiry_time", new jm.a("super_pass_validation_properties_expiry_time", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_active_duration", new jm.a("super_pass_validation_properties_active_duration", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_ride_details_previous_ride_time_stamps", new jm.a("super_pass_validation_properties_ride_details_previous_ride_time_stamps", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_ride_details_is_activation_allowed_in_current_session", new jm.a("super_pass_validation_properties_ride_details_is_activation_allowed_in_current_session", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_ride_details_oldest_history_call_time_stamp", new jm.a("super_pass_validation_properties_ride_details_oldest_history_call_time_stamp", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_ride_details_last_activation_time_stamp", new jm.a("super_pass_validation_properties_ride_details_last_activation_time_stamp", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_validation_properties_ride_details_last_punch_time_stamp", new jm.a("super_pass_validation_properties_ride_details_last_punch_time_stamp", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_max_price_per_trip", new jm.a("super_pass_ui_properties_max_price_per_trip", "REAL", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_fare_mapping_description", new jm.a("super_pass_ui_properties_fare_mapping_description", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_num_of_days", new jm.a("super_pass_ui_properties_num_of_days", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_special_features", new jm.a("super_pass_ui_properties_special_features", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_proofs", new jm.a("super_pass_ui_properties_proofs", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_booking_time", new jm.a("super_pass_ui_properties_booking_time", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_pass_name", new jm.a("super_pass_ui_properties_pass_name", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_category_name", new jm.a("super_pass_ui_properties_category_name", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_fare_mapping_display_name", new jm.a("super_pass_ui_properties_fare_mapping_display_name", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_super_pass_user_details_user_id", new jm.a("super_pass_ui_properties_super_pass_user_details_user_id", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_super_pass_user_details_mobile_number", new jm.a("super_pass_ui_properties_super_pass_user_details_mobile_number", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_super_pass_user_details_full_name", new jm.a("super_pass_ui_properties_super_pass_user_details_full_name", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_super_pass_user_details_gender", new jm.a("super_pass_ui_properties_super_pass_user_details_gender", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_super_pass_user_details_date_of_birth", new jm.a("super_pass_ui_properties_super_pass_user_details_date_of_birth", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_super_pass_user_details_email_id", new jm.a("super_pass_ui_properties_super_pass_user_details_email_id", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_super_pass_user_details_profile_photo", new jm.a("super_pass_ui_properties_super_pass_user_details_profile_photo", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_fare_infopayableAmount", new jm.a("super_pass_ui_properties_fare_infopayableAmount", "REAL", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_fare_infoactualFare", new jm.a("super_pass_ui_properties_fare_infoactualFare", "REAL", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_fare_infoisDiscountApplicable", new jm.a("super_pass_ui_properties_fare_infoisDiscountApplicable", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_fare_infodiscountedFare", new jm.a("super_pass_ui_properties_fare_infodiscountedFare", "REAL", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_fare_infofareBreakupComponentList", new jm.a("super_pass_ui_properties_fare_infofareBreakupComponentList", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_ui_properties_product_brandingis_visible", new jm.a("super_pass_ui_properties_product_brandingis_visible", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_properties_qr_code", new jm.a("super_pass_properties_qr_code", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_properties_tone", new jm.a("super_pass_properties_tone", "TEXT", false, 0, null, 1));
                hashMap9.put("super_pass_properties_pass_id", new jm.a("super_pass_properties_pass_id", "TEXT", true, 1, null, 1));
                hashMap9.put("super_pass_properties_product_type", new jm.a("super_pass_properties_product_type", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_properties_product_sub_type", new jm.a("super_pass_properties_product_sub_type", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_properties_city_name", new jm.a("super_pass_properties_city_name", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_properties_agency_name", new jm.a("super_pass_properties_agency_name", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_repurchase_properties_config_id", new jm.a("super_pass_repurchase_properties_config_id", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_repurchase_properties_category_id", new jm.a("super_pass_repurchase_properties_category_id", "TEXT", true, 0, null, 1));
                hashMap9.put("super_pass_repurchase_properties_fare_mapping_id", new jm.a("super_pass_repurchase_properties_fare_mapping_id", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_repurchase_properties_verification_expiry_time", new jm.a("super_pass_repurchase_properties_verification_expiry_time", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_repurchase_properties_verification_flag", new jm.a("super_pass_repurchase_properties_verification_flag", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_repurchase_properties_is_renewable", new jm.a("super_pass_repurchase_properties_is_renewable", "INTEGER", true, 0, null, 1));
                hashMap9.put("super_pass_transaction_details_transaction_id", new jm.a("super_pass_transaction_details_transaction_id", "TEXT", true, 0, null, 1));
                jm jmVar9 = new jm("ride_based_super_pass_table", hashMap9, hj1.o0(hashMap9, "super_pass_transaction_details_payment_mode", new jm.a("super_pass_transaction_details_payment_mode", "TEXT", true, 0, null, 1), 0), new HashSet(0));
                jm a10 = jm.a(omVar, "ride_based_super_pass_table");
                if (!jmVar9.equals(a10)) {
                    return new xl.b(false, hj1.P("ride_based_super_pass_table(app.zophop.models.mTicketing.superPass.RideBasedSuperPass).\n Expected:\n", jmVar9, "\n Found:\n", a10));
                }
                HashMap hashMap10 = new HashMap(6);
                hashMap10.put("pass_id", new jm.a("pass_id", "TEXT", true, 1, null, 1));
                hashMap10.put("previous_ride_time_stamps", new jm.a("previous_ride_time_stamps", "TEXT", true, 0, null, 1));
                hashMap10.put("is_activation_allowed_in_current_session", new jm.a("is_activation_allowed_in_current_session", "INTEGER", true, 0, null, 1));
                hashMap10.put("oldest_history_call_time_stamp", new jm.a("oldest_history_call_time_stamp", "INTEGER", true, 0, null, 1));
                hashMap10.put("last_activation_time_stamp", new jm.a("last_activation_time_stamp", "INTEGER", true, 0, null, 1));
                jm jmVar10 = new jm("ride_based_super_pass_ride_details_table", hashMap10, hj1.o0(hashMap10, "last_punch_time_stamp", new jm.a("last_punch_time_stamp", "INTEGER", true, 0, null, 1), 0), new HashSet(0));
                jm a11 = jm.a(omVar, "ride_based_super_pass_ride_details_table");
                if (!jmVar10.equals(a11)) {
                    return new xl.b(false, hj1.P("ride_based_super_pass_ride_details_table(app.zophop.models.mTicketing.superPass.RideBasedSuperPassRideDetailsRoom).\n Expected:\n", jmVar10, "\n Found:\n", a11));
                }
                HashMap hashMap11 = new HashMap(37);
                hashMap11.put("pending_super_pass_properties_super_pass_status", new jm.a("pending_super_pass_properties_super_pass_status", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_properties_pass_id", new jm.a("pending_super_pass_properties_pass_id", "TEXT", true, 1, null, 1));
                hashMap11.put("pending_super_pass_properties_product_type", new jm.a("pending_super_pass_properties_product_type", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_properties_product_sub_type", new jm.a("pending_super_pass_properties_product_sub_type", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_properties_city_name", new jm.a("pending_super_pass_properties_city_name", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_properties_agency_name", new jm.a("pending_super_pass_properties_agency_name", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_max_price_per_trip", new jm.a("pending_super_pass_ui_properties_max_price_per_trip", "REAL", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_fare_mapping_description", new jm.a("pending_super_pass_ui_properties_fare_mapping_description", "TEXT", false, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_num_of_days", new jm.a("pending_super_pass_ui_properties_num_of_days", "INTEGER", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_special_features", new jm.a("pending_super_pass_ui_properties_special_features", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_proofs", new jm.a("pending_super_pass_ui_properties_proofs", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_booking_time", new jm.a("pending_super_pass_ui_properties_booking_time", "INTEGER", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_pass_name", new jm.a("pending_super_pass_ui_properties_pass_name", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_category_name", new jm.a("pending_super_pass_ui_properties_category_name", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_fare_mapping_display_name", new jm.a("pending_super_pass_ui_properties_fare_mapping_display_name", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_super_pass_user_details_user_id", new jm.a("pending_super_pass_ui_properties_super_pass_user_details_user_id", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_super_pass_user_details_mobile_number", new jm.a("pending_super_pass_ui_properties_super_pass_user_details_mobile_number", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_super_pass_user_details_full_name", new jm.a("pending_super_pass_ui_properties_super_pass_user_details_full_name", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_super_pass_user_details_gender", new jm.a("pending_super_pass_ui_properties_super_pass_user_details_gender", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_super_pass_user_details_date_of_birth", new jm.a("pending_super_pass_ui_properties_super_pass_user_details_date_of_birth", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_super_pass_user_details_email_id", new jm.a("pending_super_pass_ui_properties_super_pass_user_details_email_id", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_super_pass_user_details_profile_photo", new jm.a("pending_super_pass_ui_properties_super_pass_user_details_profile_photo", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_fare_infopayableAmount", new jm.a("pending_super_pass_ui_properties_fare_infopayableAmount", "REAL", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_fare_infoactualFare", new jm.a("pending_super_pass_ui_properties_fare_infoactualFare", "REAL", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_fare_infoisDiscountApplicable", new jm.a("pending_super_pass_ui_properties_fare_infoisDiscountApplicable", "INTEGER", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_fare_infodiscountedFare", new jm.a("pending_super_pass_ui_properties_fare_infodiscountedFare", "REAL", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_fare_infofareBreakupComponentList", new jm.a("pending_super_pass_ui_properties_fare_infofareBreakupComponentList", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_ui_properties_product_brandingis_visible", new jm.a("pending_super_pass_ui_properties_product_brandingis_visible", "INTEGER", true, 0, null, 1));
                hashMap11.put("pending_super_pass_repurchase_properties_config_id", new jm.a("pending_super_pass_repurchase_properties_config_id", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_repurchase_properties_category_id", new jm.a("pending_super_pass_repurchase_properties_category_id", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_repurchase_properties_fare_mapping_id", new jm.a("pending_super_pass_repurchase_properties_fare_mapping_id", "INTEGER", true, 0, null, 1));
                hashMap11.put("pending_super_pass_repurchase_properties_start_time", new jm.a("pending_super_pass_repurchase_properties_start_time", "INTEGER", true, 0, null, 1));
                hashMap11.put("pending_super_pass_repurchase_properties_verification_expiry_time", new jm.a("pending_super_pass_repurchase_properties_verification_expiry_time", "INTEGER", true, 0, null, 1));
                hashMap11.put("pending_super_pass_repurchase_properties_verification_flag", new jm.a("pending_super_pass_repurchase_properties_verification_flag", "INTEGER", true, 0, null, 1));
                hashMap11.put("pending_super_pass_transaction_details_payment_mode", new jm.a("pending_super_pass_transaction_details_payment_mode", "TEXT", true, 0, null, 1));
                hashMap11.put("pending_super_pass_transaction_details_transaction_id", new jm.a("pending_super_pass_transaction_details_transaction_id", "TEXT", true, 0, null, 1));
                jm jmVar11 = new jm("pending_super_pass_table", hashMap11, hj1.o0(hashMap11, "pending_super_pass_transaction_details_order_id", new jm.a("pending_super_pass_transaction_details_order_id", "TEXT", false, 0, null, 1), 0), new HashSet(0));
                jm a12 = jm.a(omVar, "pending_super_pass_table");
                if (!jmVar11.equals(a12)) {
                    return new xl.b(false, hj1.P("pending_super_pass_table(app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass).\n Expected:\n", jmVar11, "\n Found:\n", a12));
                }
                HashMap hashMap12 = new HashMap(6);
                hashMap12.put("activation_time_stamp", new jm.a("activation_time_stamp", "INTEGER", true, 1, null, 1));
                hashMap12.put("booking_id", new jm.a("booking_id", "TEXT", true, 0, null, 1));
                hashMap12.put("expiry_time", new jm.a("expiry_time", "INTEGER", true, 0, null, 1));
                hashMap12.put("product_type", new jm.a("product_type", "TEXT", true, 0, null, 1));
                hashMap12.put("city_name", new jm.a("city_name", "TEXT", true, 0, null, 1));
                jm jmVar12 = new jm("visual_validation_table", hashMap12, hj1.o0(hashMap12, "agency_name", new jm.a("agency_name", "TEXT", true, 0, null, 1), 0), new HashSet(0));
                jm a13 = jm.a(omVar, "visual_validation_table");
                if (!jmVar12.equals(a13)) {
                    return new xl.b(false, hj1.P("visual_validation_table(app.zophop.models.mTicketing.VisualValidationActivationDetails).\n Expected:\n", jmVar12, "\n Found:\n", a13));
                }
                HashMap hashMap13 = new HashMap(12);
                hashMap13.put("payment_properties_card_recharge_transaction_id", new jm.a("payment_properties_card_recharge_transaction_id", "TEXT", true, 1, null, 1));
                hashMap13.put("payment_properties_card_recharge_payment_mode", new jm.a("payment_properties_card_recharge_payment_mode", "TEXT", true, 0, null, 1));
                hashMap13.put("payment_properties_card_recharge_payment_time", new jm.a("payment_properties_card_recharge_payment_time", "INTEGER", true, 0, null, 1));
                hashMap13.put("payment_properties_card_recharge_card_recharge_info_payment_status", new jm.a("payment_properties_card_recharge_card_recharge_info_payment_status", "TEXT", true, 0, null, 1));
                hashMap13.put("payment_properties_card_recharge_card_recharge_info_recharge_status", new jm.a("payment_properties_card_recharge_card_recharge_info_recharge_status", "TEXT", true, 0, null, 1));
                hashMap13.put("payment_properties_card_recharge_card_recharge_info_recharge_amount", new jm.a("payment_properties_card_recharge_card_recharge_info_recharge_amount", "INTEGER", true, 0, null, 1));
                hashMap13.put("ui_properties_card_recharge_product_name", new jm.a("ui_properties_card_recharge_product_name", "TEXT", true, 0, null, 1));
                hashMap13.put("ui_properties_card_recharge_recharge_delay_copy", new jm.a("ui_properties_card_recharge_recharge_delay_copy", "TEXT", true, 0, null, 1));
                hashMap13.put("ui_properties_card_recharge_branding_is_visible", new jm.a("ui_properties_card_recharge_branding_is_visible", "INTEGER", true, 0, null, 1));
                hashMap13.put("card_properties_card_recharge_card_no", new jm.a("card_properties_card_recharge_card_no", "TEXT", true, 0, null, 1));
                hashMap13.put("card_properties_card_recharge_city", new jm.a("card_properties_card_recharge_city", "TEXT", true, 0, null, 1));
                jm jmVar13 = new jm("online_card_recharge_table", hashMap13, hj1.o0(hashMap13, "card_properties_card_recharge_agency", new jm.a("card_properties_card_recharge_agency", "TEXT", true, 0, null, 1), 0), new HashSet(0));
                jm a14 = jm.a(omVar, "online_card_recharge_table");
                if (!jmVar13.equals(a14)) {
                    return new xl.b(false, hj1.P("online_card_recharge_table(app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge).\n Expected:\n", jmVar13, "\n Found:\n", a14));
                }
                HashMap hashMap14 = new HashMap(7);
                hashMap14.put("activation_time_stamp", new jm.a("activation_time_stamp", "INTEGER", true, 1, null, 1));
                hashMap14.put("booking_id", new jm.a("booking_id", "TEXT", true, 2, null, 1));
                hashMap14.put("expiry_time", new jm.a("expiry_time", "INTEGER", true, 0, null, 1));
                hashMap14.put("product_type", new jm.a("product_type", "TEXT", true, 3, null, 1));
                hashMap14.put("product_sub_type", new jm.a("product_sub_type", "TEXT", true, 0, null, 1));
                hashMap14.put("city_name", new jm.a("city_name", "TEXT", true, 0, null, 1));
                jm jmVar14 = new jm("product_activation_details_table", hashMap14, hj1.o0(hashMap14, "agency_name", new jm.a("agency_name", "TEXT", true, 0, null, 1), 0), new HashSet(0));
                jm a15 = jm.a(omVar, "product_activation_details_table");
                if (!jmVar14.equals(a15)) {
                    return new xl.b(false, hj1.P("product_activation_details_table(app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails).\n Expected:\n", jmVar14, "\n Found:\n", a15));
                }
                HashMap hashMap15 = new HashMap(11);
                hashMap15.put("pass_id", new jm.a("pass_id", "TEXT", true, 1, null, 1));
                hashMap15.put("product_type", new jm.a("product_type", "TEXT", true, 0, null, 1));
                hashMap15.put("product_sub_type", new jm.a("product_sub_type", "TEXT", true, 0, null, 1));
                hashMap15.put("activation_time_stamp", new jm.a("activation_time_stamp", "INTEGER", true, 2, null, 1));
                hashMap15.put("punch_time_stamp", new jm.a("punch_time_stamp", "INTEGER", true, 3, null, 1));
                hashMap15.put("vehicle_no", new jm.a("vehicle_no", "TEXT", true, 0, null, 1));
                hashMap15.put("conductor_id", new jm.a("conductor_id", "TEXT", true, 0, null, 1));
                hashMap15.put("start_stop_name", new jm.a("start_stop_name", "TEXT", true, 0, null, 1));
                hashMap15.put("end_stop_name", new jm.a("end_stop_name", "TEXT", true, 0, null, 1));
                hashMap15.put("route_name", new jm.a("route_name", "TEXT", true, 0, null, 1));
                jm jmVar15 = new jm("super_pass_trip_receipt_table", hashMap15, hj1.o0(hashMap15, "special_features_list", new jm.a("special_features_list", "TEXT", true, 0, null, 1), 0), new HashSet(0));
                jm a16 = jm.a(omVar, "super_pass_trip_receipt_table");
                if (!jmVar15.equals(a16)) {
                    return new xl.b(false, hj1.P("super_pass_trip_receipt_table(app.zophop.models.mTicketing.digitalTripReceipt.SuperPassTripReceipt).\n Expected:\n", jmVar15, "\n Found:\n", a16));
                }
                return new xl.b(true, null);
            }
        }, "9fa0f0b8929cc22a68dd187513c82a65", "1ffc13e5bcc52efe4b99fc692d953f97");
        Context context = nlVar.b;
        String str = nlVar.c;
        if (context != null) {
            return nlVar.f2572a.a(new pm.b(context, str, xlVar, false));
        }
        throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
    }

    @Override // defpackage.wl
    public List<fm> getAutoMigrations(Map<Class<? extends em>, em> map) {
        return Arrays.asList(new fm[0]);
    }

    @Override // app.zophop.room.AppDatabase
    public CityDataDao getCityDataDao() {
        CityDataDao cityDataDao;
        if (this._cityDataDao != null) {
            return this._cityDataDao;
        }
        synchronized (this) {
            if (this._cityDataDao == null) {
                this._cityDataDao = new CityDataDao_Impl(this);
            }
            cityDataDao = this._cityDataDao;
        }
        return cityDataDao;
    }

    @Override // app.zophop.room.AppDatabase
    public DigitalTripReceiptDao getDigitalTripReceiptDao() {
        DigitalTripReceiptDao digitalTripReceiptDao;
        if (this._digitalTripReceiptDao != null) {
            return this._digitalTripReceiptDao;
        }
        synchronized (this) {
            if (this._digitalTripReceiptDao == null) {
                this._digitalTripReceiptDao = new DigitalTripReceiptDao_Impl(this);
            }
            digitalTripReceiptDao = this._digitalTripReceiptDao;
        }
        return digitalTripReceiptDao;
    }

    @Override // app.zophop.room.AppDatabase
    public OnlineCardRechargeDao getOnlineCardRechargeDao() {
        OnlineCardRechargeDao onlineCardRechargeDao;
        if (this._onlineCardRechargeDao != null) {
            return this._onlineCardRechargeDao;
        }
        synchronized (this) {
            if (this._onlineCardRechargeDao == null) {
                this._onlineCardRechargeDao = new OnlineCardRechargeDao_Impl(this);
            }
            onlineCardRechargeDao = this._onlineCardRechargeDao;
        }
        return onlineCardRechargeDao;
    }

    @Override // defpackage.wl
    public Set<Class<? extends em>> getRequiredAutoMigrationSpecs() {
        return new HashSet();
    }

    @Override // defpackage.wl
    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        HashMap hashMap = new HashMap();
        hashMap.put(ProductDao.class, ProductDao_Impl.getRequiredConverters());
        hashMap.put(CityDataDao.class, CityDataDao_Impl.getRequiredConverters());
        hashMap.put(SuperPassDao.class, SuperPassDao_Impl.getRequiredConverters());
        hashMap.put(VisualValidationDao.class, VisualValidationDao_Impl.getRequiredConverters());
        hashMap.put(OnlineCardRechargeDao.class, OnlineCardRechargeDao_Impl.getRequiredConverters());
        hashMap.put(DigitalTripReceiptDao.class, DigitalTripReceiptDao_Impl.getRequiredConverters());
        return hashMap;
    }

    @Override // app.zophop.room.AppDatabase
    public SuperPassDao getSuperPassDao() {
        SuperPassDao superPassDao;
        if (this._superPassDao != null) {
            return this._superPassDao;
        }
        synchronized (this) {
            if (this._superPassDao == null) {
                this._superPassDao = new SuperPassDao_Impl(this);
            }
            superPassDao = this._superPassDao;
        }
        return superPassDao;
    }

    @Override // app.zophop.room.AppDatabase
    public ProductDao getTicketDao() {
        ProductDao productDao;
        if (this._productDao != null) {
            return this._productDao;
        }
        synchronized (this) {
            if (this._productDao == null) {
                this._productDao = new ProductDao_Impl(this);
            }
            productDao = this._productDao;
        }
        return productDao;
    }

    @Override // app.zophop.room.AppDatabase
    public VisualValidationDao getVisualValidationDao() {
        VisualValidationDao visualValidationDao;
        if (this._visualValidationDao != null) {
            return this._visualValidationDao;
        }
        synchronized (this) {
            if (this._visualValidationDao == null) {
                this._visualValidationDao = new VisualValidationDao_Impl(this);
            }
            visualValidationDao = this._visualValidationDao;
        }
        return visualValidationDao;
    }
}
