package app.zophop.room;

import android.content.Context;
import defpackage.wl;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AppDatabase extends wl {
    private static volatile AppDatabase INSTANCE = null;
    public static final fm MIGRATION_10_11 = new fm(10, 11) {
        /* class app.zophop.room.AppDatabase.AnonymousClass10 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("ALTER TABLE Ticket ADD COLUMN mticket__mticketTripReceipt TEXT;");
        }
    };
    public static final fm MIGRATION_11_12 = new fm(11, 12) {
        /* class app.zophop.room.AppDatabase.AnonymousClass11 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("ALTER TABLE super_pass_trip_receipt_table ADD COLUMN special_features_list TEXT NOT NULL DEFAULT '[]';");
        }
    };
    public static final fm MIGRATION_1_2 = new fm(1, 2) {
        /* class app.zophop.room.AppDatabase.AnonymousClass1 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("CREATE TABLE IF NOT EXISTS `CityData` (`type` TEXT NOT NULL, `cityName` TEXT NOT NULL, `data` TEXT, `etag` TEXT, `version` INTEGER NOT NULL, PRIMARY KEY(`type`, `cityName`))");
        }
    };
    public static final fm MIGRATION_2_3 = new fm(2, 3) {
        /* class app.zophop.room.AppDatabase.AnonymousClass2 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            hj1.B0(omVar, "ALTER TABLE Pass ADD COLUMN pass__grouping TEXT;", "ALTER TABLE Pass ADD COLUMN pass__productType TEXT;", "ALTER TABLE Pass ADD COLUMN pass__productCategory TEXT;", "ALTER TABLE Pass ADD COLUMN pass__remainingTrips INTEGER;");
            hj1.B0(omVar, "ALTER TABLE Pass ADD COLUMN pass__maxTrips INTEGER;", "ALTER TABLE Pass ADD COLUMN pass__maxTripsPerDay INTEGER;", "ALTER TABLE Pass ADD COLUMN pass__catDisName TEXT;", "ALTER TABLE Pass ADD COLUMN pass__maxTripsPrice INTEGER;");
            hj1.B0(omVar, "ALTER TABLE PassApplications ADD COLUMN pass_app__grouping TEXT;", "ALTER TABLE PassApplications ADD COLUMN pass_app__productType TEXT;", "ALTER TABLE PassApplications ADD COLUMN pass_app__productCategory TEXT;", "ALTER TABLE PassApplications ADD COLUMN pass_app__remainingTrips INTEGER;");
            hj1.B0(omVar, "ALTER TABLE PassApplications ADD COLUMN pass_app__maxTrips INTEGER;", "ALTER TABLE PassApplications ADD COLUMN pass_app__maxTripsPerDay INTEGER;", "ALTER TABLE PassApplications ADD COLUMN pass_app__catDisName TEXT;", "ALTER TABLE PassApplications ADD COLUMN pass_app__maxTripsPrice INTEGER;");
            omVar.y("CREATE TABLE IF NOT EXISTS `RideDetails` (`_passId` TEXT NOT NULL, `_rideInfoList` TEXT, `_dailyRidesCount` TEXT, `_totalRideCount` TEXT, PRIMARY KEY(`_passId`))");
        }
    };
    public static final fm MIGRATION_3_4 = new fm(3, 4) {
        /* class app.zophop.room.AppDatabase.AnonymousClass3 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            hj1.B0(omVar, "ALTER TABLE Pass ADD COLUMN pass__tone TEXT;", "ALTER TABLE PassApplications ADD COLUMN pass_app__tone TEXT;", "ALTER TABLE ScanPay ADD COLUMN scan_pay__tone TEXT;", "ALTER TABLE Ticket ADD COLUMN mticket__tone TEXT;");
        }
    };
    public static final fm MIGRATION_4_5 = new fm(4, 5) {
        /* class app.zophop.room.AppDatabase.AnonymousClass4 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("DROP TABLE IF EXISTS CityData;");
            omVar.y("CREATE TABLE IF NOT EXISTS `CityData` (`type` TEXT NOT NULL, `cityName` TEXT NOT NULL,`mode` TEXT NOT NULL, `dataId` TEXT NOT NULL, `data` TEXT, `etag` TEXT, `version` INTEGER NOT NULL, PRIMARY KEY(`type`, `cityName`,`mode`,`dataId`))");
        }
    };
    public static final fm MIGRATION_5_6 = new fm(5, 6) {
        /* class app.zophop.room.AppDatabase.AnonymousClass5 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            hj1.B0(omVar, "ALTER TABLE Pass ADD COLUMN pass__passApplicationRejectionReasons TEXT;", "ALTER TABLE Pass ADD COLUMN pass__passApplicationActionRequired TEXT;", "ALTER TABLE PassApplications ADD COLUMN pass_app__passApplicationRejectionReasons TEXT;", "ALTER TABLE PassApplications ADD COLUMN pass_app__passApplicationActionRequired TEXT;");
        }
    };
    public static final fm MIGRATION_6_7 = new fm(6, 7) {
        /* class app.zophop.room.AppDatabase.AnonymousClass6 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            hj1.B0(omVar, "CREATE TABLE IF NOT EXISTS `super_pass_application_table` (`city_name` TEXT NOT NULL, `agency_name` TEXT NOT NULL, `config_id` TEXT NOT NULL, `category_id` TEXT NOT NULL, `fare_mapping_id` INTEGER NOT NULL, `fare_mapping_display_name` TEXT NOT NULL, `pass_name` TEXT NOT NULL, `pass_start_date` INTEGER NOT NULL, `verification_expiry_time` INTEGER NOT NULL, `super_pass_application_status` TEXT NOT NULL, `proofs` TEXT NOT NULL, `pass_application_action_required` TEXT, `super_pass_user_details_user_id` TEXT NOT NULL, `super_pass_user_details_mobile_number` TEXT NOT NULL, `super_pass_user_details_full_name` TEXT NOT NULL, `super_pass_user_details_gender` TEXT NOT NULL, `super_pass_user_details_date_of_birth` TEXT NOT NULL, `super_pass_user_details_email_id` TEXT NOT NULL, `super_pass_user_details_profile_photo` TEXT NOT NULL, `cash_payment_pending_transaction_details_pending_fare` REAL, `cash_payment_pending_transaction_details_reference_id` TEXT, `pass_application_rejection_reasons_proofRejectionReasonsList` TEXT, `pass_application_rejection_reasons_profileRejectionReasonsList` TEXT, `pass_application_rejection_reasons_generalRejectionReasonsList` TEXT, PRIMARY KEY(`city_name`, `agency_name`, `config_id`, `category_id`))", "CREATE TABLE IF NOT EXISTS `magic_super_pass_table` (`super_pass_properties_qr_code` TEXT NOT NULL, `super_pass_properties_tone` TEXT, `super_pass_properties_pass_id` TEXT NOT NULL, `super_pass_properties_product_type` TEXT NOT NULL, `super_pass_properties_product_sub_type` TEXT NOT NULL, `super_pass_properties_city_name` TEXT NOT NULL, `super_pass_properties_agency_name` TEXT NOT NULL, `super_pass_validation_properties_super_pass_status` TEXT NOT NULL, `super_pass_validation_properties_start_time` INTEGER NOT NULL, `super_pass_validation_properties_expiry_time` INTEGER NOT NULL, `super_pass_validation_properties_active_duration` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_last_activation_time_stamp` INTEGER NOT NULL, `super_pass_ui_properties_num_of_days` INTEGER NOT NULL, `super_pass_ui_properties_special_features` TEXT NOT NULL, `super_pass_ui_properties_proofs` TEXT NOT NULL, `super_pass_ui_properties_booking_time` INTEGER NOT NULL, `super_pass_ui_properties_pass_name` TEXT NOT NULL, `super_pass_ui_properties_category_name` TEXT NOT NULL, `super_pass_ui_properties_fare_mapping_display_name` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_user_id` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_mobile_number` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_full_name` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_gender` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_date_of_birth` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_email_id` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_profile_photo` TEXT NOT NULL, `super_pass_ui_properties_fare_infopayableAmount` REAL NOT NULL, `super_pass_ui_properties_fare_infoactualFare` REAL NOT NULL, `super_pass_ui_properties_fare_infoisDiscountApplicable` INTEGER NOT NULL, `super_pass_ui_properties_fare_infodiscountedFare` REAL NOT NULL, `super_pass_ui_properties_fare_infofareBreakupComponentList` TEXT NOT NULL, `super_pass_ui_properties_product_brandingis_visible` INTEGER NOT NULL, `super_pass_repurchase_properties_config_id` TEXT NOT NULL, `super_pass_repurchase_properties_category_id` TEXT NOT NULL, `super_pass_repurchase_properties_fare_mapping_id` INTEGER NOT NULL, `super_pass_repurchase_properties_verification_expiry_time` INTEGER NOT NULL, `super_pass_repurchase_properties_verification_flag` INTEGER NOT NULL, `super_pass_repurchase_properties_is_renewable` INTEGER NOT NULL, `super_pass_transaction_details_transaction_id` TEXT NOT NULL, `super_pass_transaction_details_payment_mode` TEXT NOT NULL, PRIMARY KEY(`super_pass_properties_pass_id`))", "CREATE TABLE IF NOT EXISTS `ride_based_super_pass_table` (`super_pass_validation_properties_max_trips_per_day` INTEGER NOT NULL, `super_pass_validation_properties_num_of_trips` INTEGER NOT NULL, `super_pass_validation_properties_super_pass_status` TEXT NOT NULL, `super_pass_validation_properties_start_time` INTEGER NOT NULL, `super_pass_validation_properties_expiry_time` INTEGER NOT NULL, `super_pass_validation_properties_active_duration` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_previous_ride_time_stamps` TEXT NOT NULL, `super_pass_validation_properties_ride_details_is_activation_allowed_in_current_session` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_oldest_history_call_time_stamp` INTEGER NOT NULL, `super_pass_validation_properties_ride_details_last_activation_time_stamp` INTEGER NOT NULL, `super_pass_ui_properties_max_price_per_trip` REAL NOT NULL, `super_pass_ui_properties_fare_mapping_description` TEXT NOT NULL, `super_pass_ui_properties_num_of_days` INTEGER NOT NULL, `super_pass_ui_properties_special_features` TEXT NOT NULL, `super_pass_ui_properties_proofs` TEXT NOT NULL, `super_pass_ui_properties_booking_time` INTEGER NOT NULL, `super_pass_ui_properties_pass_name` TEXT NOT NULL, `super_pass_ui_properties_category_name` TEXT NOT NULL, `super_pass_ui_properties_fare_mapping_display_name` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_user_id` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_mobile_number` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_full_name` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_gender` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_date_of_birth` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_email_id` TEXT NOT NULL, `super_pass_ui_properties_super_pass_user_details_profile_photo` TEXT NOT NULL, `super_pass_ui_properties_fare_infopayableAmount` REAL NOT NULL, `super_pass_ui_properties_fare_infoactualFare` REAL NOT NULL, `super_pass_ui_properties_fare_infoisDiscountApplicable` INTEGER NOT NULL, `super_pass_ui_properties_fare_infodiscountedFare` REAL NOT NULL, `super_pass_ui_properties_fare_infofareBreakupComponentList` TEXT NOT NULL, `super_pass_ui_properties_product_brandingis_visible` INTEGER NOT NULL, `super_pass_properties_qr_code` TEXT NOT NULL, `super_pass_properties_tone` TEXT, `super_pass_properties_pass_id` TEXT NOT NULL, `super_pass_properties_product_type` TEXT NOT NULL, `super_pass_properties_product_sub_type` TEXT NOT NULL, `super_pass_properties_city_name` TEXT NOT NULL, `super_pass_properties_agency_name` TEXT NOT NULL, `super_pass_repurchase_properties_config_id` TEXT NOT NULL, `super_pass_repurchase_properties_category_id` TEXT NOT NULL, `super_pass_repurchase_properties_fare_mapping_id` INTEGER NOT NULL, `super_pass_repurchase_properties_verification_expiry_time` INTEGER NOT NULL, `super_pass_repurchase_properties_verification_flag` INTEGER NOT NULL, `super_pass_repurchase_properties_is_renewable` INTEGER NOT NULL, `super_pass_transaction_details_transaction_id` TEXT NOT NULL, `super_pass_transaction_details_payment_mode` TEXT NOT NULL, PRIMARY KEY(`super_pass_properties_pass_id`))", "CREATE TABLE IF NOT EXISTS `ride_based_super_pass_ride_details_table` (`pass_id` TEXT NOT NULL, `previous_ride_time_stamps` TEXT NOT NULL, `is_activation_allowed_in_current_session` INTEGER NOT NULL, `oldest_history_call_time_stamp` INTEGER NOT NULL, PRIMARY KEY(`pass_id`))");
            omVar.y("CREATE TABLE IF NOT EXISTS `pending_super_pass_table` (`pending_super_pass_properties_super_pass_status` TEXT NOT NULL, `pending_super_pass_properties_pass_id` TEXT NOT NULL, `pending_super_pass_properties_product_type` TEXT NOT NULL, `pending_super_pass_properties_product_sub_type` TEXT NOT NULL, `pending_super_pass_properties_city_name` TEXT NOT NULL, `pending_super_pass_properties_agency_name` TEXT NOT NULL, `pending_super_pass_ui_properties_max_price_per_trip` REAL NOT NULL, `pending_super_pass_ui_properties_fare_mapping_description` TEXT, `pending_super_pass_ui_properties_num_of_days` INTEGER NOT NULL, `pending_super_pass_ui_properties_special_features` TEXT NOT NULL, `pending_super_pass_ui_properties_proofs` TEXT NOT NULL, `pending_super_pass_ui_properties_booking_time` INTEGER NOT NULL, `pending_super_pass_ui_properties_pass_name` TEXT NOT NULL, `pending_super_pass_ui_properties_category_name` TEXT NOT NULL, `pending_super_pass_ui_properties_fare_mapping_display_name` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_user_id` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_mobile_number` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_full_name` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_gender` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_date_of_birth` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_email_id` TEXT NOT NULL, `pending_super_pass_ui_properties_super_pass_user_details_profile_photo` TEXT NOT NULL, `pending_super_pass_ui_properties_fare_infopayableAmount` REAL NOT NULL, `pending_super_pass_ui_properties_fare_infoactualFare` REAL NOT NULL, `pending_super_pass_ui_properties_fare_infoisDiscountApplicable` INTEGER NOT NULL, `pending_super_pass_ui_properties_fare_infodiscountedFare` REAL NOT NULL, `pending_super_pass_ui_properties_fare_infofareBreakupComponentList` TEXT NOT NULL, `pending_super_pass_ui_properties_product_brandingis_visible` INTEGER NOT NULL, `pending_super_pass_repurchase_properties_config_id` TEXT NOT NULL, `pending_super_pass_repurchase_properties_category_id` TEXT NOT NULL, `pending_super_pass_repurchase_properties_fare_mapping_id` INTEGER NOT NULL, `pending_super_pass_repurchase_properties_start_time` INTEGER NOT NULL, `pending_super_pass_repurchase_properties_verification_expiry_time` INTEGER NOT NULL, `pending_super_pass_repurchase_properties_verification_flag` INTEGER NOT NULL, `pending_super_pass_transaction_details_payment_mode` TEXT NOT NULL, `pending_super_pass_transaction_details_transaction_id` TEXT NOT NULL, `pending_super_pass_transaction_details_order_id` TEXT, PRIMARY KEY(`pending_super_pass_properties_pass_id`))");
        }
    };
    public static final fm MIGRATION_7_8 = new fm(7, 8) {
        /* class app.zophop.room.AppDatabase.AnonymousClass7 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("CREATE TABLE IF NOT EXISTS `visual_validation_table` (`activation_time_stamp` INTEGER NOT NULL, `booking_id` TEXT NOT NULL, `expiry_time` INTEGER NOT NULL, `product_type` TEXT NOT NULL, `city_name` TEXT NOT NULL, `agency_name` TEXT NOT NULL, PRIMARY KEY(`activation_time_stamp`))");
        }
    };
    public static final fm MIGRATION_8_9 = new fm(8, 9) {
        /* class app.zophop.room.AppDatabase.AnonymousClass8 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            omVar.y("CREATE TABLE IF NOT EXISTS `online_card_recharge_table` (`payment_properties_card_recharge_transaction_id` TEXT NOT NULL, `payment_properties_card_recharge_payment_mode` TEXT NOT NULL, `payment_properties_card_recharge_payment_time` INTEGER NOT NULL, `payment_properties_card_recharge_card_recharge_info_payment_status` TEXT NOT NULL, `payment_properties_card_recharge_card_recharge_info_recharge_status` TEXT NOT NULL, `payment_properties_card_recharge_card_recharge_info_recharge_amount` INTEGER NOT NULL, `ui_properties_card_recharge_product_name` TEXT NOT NULL, `ui_properties_card_recharge_branding_is_visible` INTEGER NOT NULL, `ui_properties_card_recharge_recharge_delay_copy` TEXT NOT NULL, `card_properties_card_recharge_card_no` TEXT NOT NULL, `card_properties_card_recharge_city` TEXT NOT NULL, `card_properties_card_recharge_agency` TEXT NOT NULL, PRIMARY KEY(`payment_properties_card_recharge_transaction_id`))");
        }
    };
    public static final fm MIGRATION_9_10 = new fm(9, 10) {
        /* class app.zophop.room.AppDatabase.AnonymousClass9 */

        @Override // defpackage.fm
        public void migrate(om omVar) {
            hj1.B0(omVar, "ALTER TABLE `ride_based_super_pass_ride_details_table` ADD COLUMN last_activation_time_stamp INTEGER NOT NULL DEFAULT -1;", "ALTER TABLE `ride_based_super_pass_ride_details_table` ADD COLUMN last_punch_time_stamp INTEGER NOT NULL DEFAULT -1;", "ALTER TABLE `magic_super_pass_table` ADD COLUMN super_pass_validation_properties_ride_details_last_punch_time_stamp INTEGER NOT NULL DEFAULT -1;", "ALTER TABLE `ride_based_super_pass_table` ADD COLUMN super_pass_validation_properties_ride_details_last_punch_time_stamp INTEGER  NOT NULL DEFAULT -1;");
            omVar.y("CREATE TABLE IF NOT EXISTS `product_activation_details_table` (`activation_time_stamp` INTEGER NOT NULL, `booking_id` TEXT NOT NULL, `expiry_time` INTEGER NOT NULL, `product_type` TEXT NOT NULL, `product_sub_type` TEXT NOT NULL, `city_name` TEXT NOT NULL, `agency_name` TEXT NOT NULL, PRIMARY KEY(`activation_time_stamp`, `booking_id`, `product_type`))");
            omVar.y("CREATE TABLE IF NOT EXISTS `super_pass_trip_receipt_table` (`pass_id` TEXT NOT NULL, `product_type` TEXT NOT NULL, `product_sub_type` TEXT NOT NULL, `activation_time_stamp` INTEGER NOT NULL, `punch_time_stamp` INTEGER NOT NULL, `vehicle_no` TEXT NOT NULL,`conductor_id` TEXT NOT NULL, `start_stop_name` TEXT NOT NULL, `end_stop_name` TEXT NOT NULL, `route_name` TEXT NOT NULL, PRIMARY KEY(`pass_id`, `activation_time_stamp`, `punch_time_stamp`))");
        }
    };
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(4);
    private static wl.b sRoomDatabaseCallback = new wl.b() {
        /* class app.zophop.room.AppDatabase.AnonymousClass12 */

        @Override // defpackage.wl.b
        public void onOpen(om omVar) {
            super.onOpen(omVar);
            AppDatabase.databaseWriteExecutor.execute(new Runnable() {
                /* class app.zophop.room.AppDatabase.AnonymousClass12.AnonymousClass1 */

                public void run() {
                    AppDatabase.INSTANCE.getTicketDao().deleteAllTicketData();
                }
            });
        }
    };

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    wl.a C = h.C(context.getApplicationContext(), AppDatabase.class, "app_db");
                    C.h = true;
                    C.a(MIGRATION_1_2, MIGRATION_2_3, MIGRATION_3_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7, MIGRATION_7_8, MIGRATION_8_9, MIGRATION_9_10, MIGRATION_10_11, MIGRATION_11_12);
                    INSTANCE = (AppDatabase) C.b();
                }
            }
        }
        return INSTANCE;
    }

    public abstract CityDataDao getCityDataDao();

    public abstract DigitalTripReceiptDao getDigitalTripReceiptDao();

    public abstract OnlineCardRechargeDao getOnlineCardRechargeDao();

    public abstract SuperPassDao getSuperPassDao();

    public abstract ProductDao getTicketDao();

    public abstract VisualValidationDao getVisualValidationDao();
}
