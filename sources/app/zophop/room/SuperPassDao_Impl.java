package app.zophop.room;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.lifecycle.LiveData;
import app.zophop.models.CustomTypeConverters;
import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.ProductBranding;
import app.zophop.models.mTicketing.superPass.CashPaymentPendingTransactionDetails;
import app.zophop.models.mTicketing.superPass.MagicSuperPass;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassRideDetails;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassRideDetailsRoom;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassUIProperties;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassValidationProperties;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassApplicationStatus;
import app.zophop.models.mTicketing.superPass.SuperPassProperties;
import app.zophop.models.mTicketing.superPass.SuperPassRepurchaseProperties;
import app.zophop.models.mTicketing.superPass.SuperPassRideDetails;
import app.zophop.models.mTicketing.superPass.SuperPassStatus;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.SuperPassTransactionDetails;
import app.zophop.models.mTicketing.superPass.SuperPassUIProperties;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.models.mTicketing.superPass.SuperPassValidationProperties;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPassProperties;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPassRepurchaseProperties;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPassTransactionDetails;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPassUIProperties;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public final class SuperPassDao_Impl implements SuperPassDao {
    private final CustomTypeConverters __customTypeConverters = new CustomTypeConverters();
    private final wl __db;
    private final ql<MagicSuperPass> __insertionAdapterOfMagicSuperPass;
    private final ql<PendingSuperPass> __insertionAdapterOfPendingSuperPass;
    private final ql<RideBasedSuperPass> __insertionAdapterOfRideBasedSuperPass;
    private final ql<RideBasedSuperPassRideDetailsRoom> __insertionAdapterOfRideBasedSuperPassRideDetailsRoom;
    private final ql<SuperPassApplication> __insertionAdapterOfSuperPassApplication;
    private final bm __preparedStmtOfDeleteAllMagicSuperPasses;
    private final bm __preparedStmtOfDeleteAllMagicSuperPassesForCity;
    private final bm __preparedStmtOfDeleteAllPendingSuperPasses;
    private final bm __preparedStmtOfDeleteAllRideBasedSuperPasses;
    private final bm __preparedStmtOfDeleteAllRideBasedSuperPassesForCity;
    private final bm __preparedStmtOfDeleteAllSuperPassApplications;
    private final bm __preparedStmtOfDeleteAllSuperPassApplicationsForCity;
    private final bm __preparedStmtOfUpdateMagicSuperPassLastActivationTimeStamp;
    private final bm __preparedStmtOfUpdateRideBasedSuperPass;
    private final bm __preparedStmtOfUpdateRideBasedSuperPassRideDetails;

    /* renamed from: app.zophop.room.SuperPassDao_Impl$49  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass49 {
        public static final /* synthetic */ int[] $SwitchMap$app$zophop$models$mTicketing$Gender;
        public static final /* synthetic */ int[] $SwitchMap$app$zophop$models$mTicketing$superPass$SuperPassApplicationStatus;
        public static final /* synthetic */ int[] $SwitchMap$app$zophop$models$mTicketing$superPass$SuperPassStatus;
        public static final /* synthetic */ int[] $SwitchMap$app$zophop$models$mTicketing$superPass$SuperPassSubType;

        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|20|21|23|24|25|26|27|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|23|24|25|26|27|29|30|31|32|33|34|(2:35|36)|37|39|40|41|42|43|44|(3:45|46|48)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(41:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|20|21|23|24|25|26|27|29|30|31|32|33|34|35|36|37|39|40|41|42|43|44|45|46|48) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x004c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0058 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x006f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0075 */
        static {
            /*
            // Method dump skipped, instructions count: 124
            */
            throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass49.<clinit>():void");
        }
    }

    public SuperPassDao_Impl(wl wlVar) {
        this.__db = wlVar;
        this.__insertionAdapterOfSuperPassApplication = new ql<SuperPassApplication>(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass1 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `super_pass_application_table` (`city_name`,`agency_name`,`config_id`,`category_id`,`fare_mapping_id`,`fare_mapping_display_name`,`pass_name`,`pass_start_date`,`verification_expiry_time`,`super_pass_application_status`,`proofs`,`pass_application_action_required`,`super_pass_user_details_user_id`,`super_pass_user_details_mobile_number`,`super_pass_user_details_full_name`,`super_pass_user_details_gender`,`super_pass_user_details_date_of_birth`,`super_pass_user_details_email_id`,`super_pass_user_details_profile_photo`,`cash_payment_pending_transaction_details_pending_fare`,`cash_payment_pending_transaction_details_reference_id`,`pass_application_rejection_reasons_proofRejectionReasonsList`,`pass_application_rejection_reasons_profileRejectionReasonsList`,`pass_application_rejection_reasons_generalRejectionReasonsList`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, SuperPassApplication superPassApplication) {
                if (superPassApplication.getCityName() == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, superPassApplication.getCityName());
                }
                if (superPassApplication.getAgencyName() == null) {
                    smVar.E0(2);
                } else {
                    smVar.z(2, superPassApplication.getAgencyName());
                }
                if (superPassApplication.getConfigId() == null) {
                    smVar.E0(3);
                } else {
                    smVar.z(3, superPassApplication.getConfigId());
                }
                if (superPassApplication.getCategoryId() == null) {
                    smVar.E0(4);
                } else {
                    smVar.z(4, superPassApplication.getCategoryId());
                }
                smVar.d0(5, (long) superPassApplication.getFareMappingId());
                if (superPassApplication.getFareMappingDisplayName() == null) {
                    smVar.E0(6);
                } else {
                    smVar.z(6, superPassApplication.getFareMappingDisplayName());
                }
                if (superPassApplication.getPassName() == null) {
                    smVar.E0(7);
                } else {
                    smVar.z(7, superPassApplication.getPassName());
                }
                smVar.d0(8, superPassApplication.getPassStartDate());
                smVar.d0(9, superPassApplication.getVerificationExpiryTime());
                if (superPassApplication.getSuperPassApplicationStatus() == null) {
                    smVar.E0(10);
                } else {
                    smVar.z(10, SuperPassDao_Impl.this.__SuperPassApplicationStatus_enumToString(superPassApplication.getSuperPassApplicationStatus()));
                }
                String fromProofsToString = SuperPassDao_Impl.this.__customTypeConverters.fromProofsToString(superPassApplication.getProofs());
                if (fromProofsToString == null) {
                    smVar.E0(11);
                } else {
                    smVar.z(11, fromProofsToString);
                }
                String converterString = SuperPassDao_Impl.this.__customTypeConverters.toConverterString(superPassApplication.getPassApplicationActionRequired());
                if (converterString == null) {
                    smVar.E0(12);
                } else {
                    smVar.z(12, converterString);
                }
                SuperPassUserDetails superPassUserDetails = superPassApplication.getSuperPassUserDetails();
                if (superPassUserDetails != null) {
                    if (superPassUserDetails.getUserId() == null) {
                        smVar.E0(13);
                    } else {
                        smVar.z(13, superPassUserDetails.getUserId());
                    }
                    if (superPassUserDetails.getMobileNumber() == null) {
                        smVar.E0(14);
                    } else {
                        smVar.z(14, superPassUserDetails.getMobileNumber());
                    }
                    if (superPassUserDetails.getFullName() == null) {
                        smVar.E0(15);
                    } else {
                        smVar.z(15, superPassUserDetails.getFullName());
                    }
                    if (superPassUserDetails.getGender() == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, SuperPassDao_Impl.this.__Gender_enumToString(superPassUserDetails.getGender()));
                    }
                    if (superPassUserDetails.getDateOfBirth() == null) {
                        smVar.E0(17);
                    } else {
                        smVar.z(17, superPassUserDetails.getDateOfBirth());
                    }
                    if (superPassUserDetails.getEmailId() == null) {
                        smVar.E0(18);
                    } else {
                        smVar.z(18, superPassUserDetails.getEmailId());
                    }
                    if (superPassUserDetails.getProfilePhoto() == null) {
                        smVar.E0(19);
                    } else {
                        smVar.z(19, superPassUserDetails.getProfilePhoto());
                    }
                } else {
                    hj1.D0(smVar, 13, 14, 15, 16);
                    smVar.E0(17);
                    smVar.E0(18);
                    smVar.E0(19);
                }
                CashPaymentPendingTransactionDetails cashPaymentPendingTransactionDetails = superPassApplication.getCashPaymentPendingTransactionDetails();
                if (cashPaymentPendingTransactionDetails != null) {
                    smVar.N(20, cashPaymentPendingTransactionDetails.getPendingFare());
                    if (cashPaymentPendingTransactionDetails.getReferenceId() == null) {
                        smVar.E0(21);
                    } else {
                        smVar.z(21, cashPaymentPendingTransactionDetails.getReferenceId());
                    }
                } else {
                    smVar.E0(20);
                    smVar.E0(21);
                }
                PassApplicationRejectionReasons passApplicationRejectionReasons = superPassApplication.getPassApplicationRejectionReasons();
                if (passApplicationRejectionReasons != null) {
                    String proofRejectionReasonString = SuperPassDao_Impl.this.__customTypeConverters.toProofRejectionReasonString(passApplicationRejectionReasons.getProofRejectionReasonsList());
                    if (proofRejectionReasonString == null) {
                        smVar.E0(22);
                    } else {
                        smVar.z(22, proofRejectionReasonString);
                    }
                    String profileRejectionReasonString = SuperPassDao_Impl.this.__customTypeConverters.toProfileRejectionReasonString(passApplicationRejectionReasons.getProfileRejectionReasonsList());
                    if (profileRejectionReasonString == null) {
                        smVar.E0(23);
                    } else {
                        smVar.z(23, profileRejectionReasonString);
                    }
                    String customTypeConverters = SuperPassDao_Impl.this.__customTypeConverters.toString(passApplicationRejectionReasons.getGeneralRejectionReasonsList());
                    if (customTypeConverters == null) {
                        smVar.E0(24);
                    } else {
                        smVar.z(24, customTypeConverters);
                    }
                } else {
                    smVar.E0(22);
                    smVar.E0(23);
                    smVar.E0(24);
                }
            }
        };
        this.__insertionAdapterOfMagicSuperPass = new ql<MagicSuperPass>(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass2 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `magic_super_pass_table` (`super_pass_properties_qr_code`,`super_pass_properties_tone`,`super_pass_properties_pass_id`,`super_pass_properties_product_type`,`super_pass_properties_product_sub_type`,`super_pass_properties_city_name`,`super_pass_properties_agency_name`,`super_pass_validation_properties_super_pass_status`,`super_pass_validation_properties_start_time`,`super_pass_validation_properties_expiry_time`,`super_pass_validation_properties_active_duration`,`super_pass_validation_properties_ride_details_last_activation_time_stamp`,`super_pass_validation_properties_ride_details_last_punch_time_stamp`,`super_pass_ui_properties_num_of_days`,`super_pass_ui_properties_special_features`,`super_pass_ui_properties_proofs`,`super_pass_ui_properties_booking_time`,`super_pass_ui_properties_pass_name`,`super_pass_ui_properties_category_name`,`super_pass_ui_properties_fare_mapping_display_name`,`super_pass_ui_properties_super_pass_user_details_user_id`,`super_pass_ui_properties_super_pass_user_details_mobile_number`,`super_pass_ui_properties_super_pass_user_details_full_name`,`super_pass_ui_properties_super_pass_user_details_gender`,`super_pass_ui_properties_super_pass_user_details_date_of_birth`,`super_pass_ui_properties_super_pass_user_details_email_id`,`super_pass_ui_properties_super_pass_user_details_profile_photo`,`super_pass_ui_properties_fare_infopayableAmount`,`super_pass_ui_properties_fare_infoactualFare`,`super_pass_ui_properties_fare_infoisDiscountApplicable`,`super_pass_ui_properties_fare_infodiscountedFare`,`super_pass_ui_properties_fare_infofareBreakupComponentList`,`super_pass_ui_properties_product_brandingis_visible`,`super_pass_repurchase_properties_config_id`,`super_pass_repurchase_properties_category_id`,`super_pass_repurchase_properties_fare_mapping_id`,`super_pass_repurchase_properties_verification_expiry_time`,`super_pass_repurchase_properties_verification_flag`,`super_pass_repurchase_properties_is_renewable`,`super_pass_transaction_details_transaction_id`,`super_pass_transaction_details_payment_mode`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, MagicSuperPass magicSuperPass) {
                SuperPassProperties superPassProperties = magicSuperPass.getSuperPassProperties();
                if (superPassProperties != null) {
                    if (superPassProperties.getQrCode() == null) {
                        smVar.E0(1);
                    } else {
                        smVar.z(1, superPassProperties.getQrCode());
                    }
                    if (superPassProperties.getTone() == null) {
                        smVar.E0(2);
                    } else {
                        smVar.z(2, superPassProperties.getTone());
                    }
                    if (superPassProperties.getPassId() == null) {
                        smVar.E0(3);
                    } else {
                        smVar.z(3, superPassProperties.getPassId());
                    }
                    if (superPassProperties.getProductType() == null) {
                        smVar.E0(4);
                    } else {
                        smVar.z(4, superPassProperties.getProductType());
                    }
                    if (superPassProperties.getProductSubType() == null) {
                        smVar.E0(5);
                    } else {
                        smVar.z(5, SuperPassDao_Impl.this.__SuperPassSubType_enumToString(superPassProperties.getProductSubType()));
                    }
                    if (superPassProperties.getCityName() == null) {
                        smVar.E0(6);
                    } else {
                        smVar.z(6, superPassProperties.getCityName());
                    }
                    if (superPassProperties.getAgencyName() == null) {
                        smVar.E0(7);
                    } else {
                        smVar.z(7, superPassProperties.getAgencyName());
                    }
                } else {
                    hj1.D0(smVar, 1, 2, 3, 4);
                    smVar.E0(5);
                    smVar.E0(6);
                    smVar.E0(7);
                }
                SuperPassValidationProperties superPassValidationProperties = magicSuperPass.getSuperPassValidationProperties();
                if (superPassValidationProperties != null) {
                    if (superPassValidationProperties.getStatus() == null) {
                        smVar.E0(8);
                    } else {
                        smVar.z(8, SuperPassDao_Impl.this.__SuperPassStatus_enumToString(superPassValidationProperties.getStatus()));
                    }
                    smVar.d0(9, superPassValidationProperties.getStartTime());
                    smVar.d0(10, superPassValidationProperties.getExpiryTime());
                    smVar.d0(11, superPassValidationProperties.getActiveDuration());
                    SuperPassRideDetails superPassRideDetails = superPassValidationProperties.getSuperPassRideDetails();
                    if (superPassRideDetails != null) {
                        smVar.d0(12, superPassRideDetails.getLastActivationTimeStamp());
                        smVar.d0(13, superPassRideDetails.getLastPunchTimeStamp());
                    } else {
                        smVar.E0(12);
                        smVar.E0(13);
                    }
                } else {
                    hj1.D0(smVar, 8, 9, 10, 11);
                    smVar.E0(12);
                    smVar.E0(13);
                }
                SuperPassUIProperties superPassUIProperties = magicSuperPass.getSuperPassUIProperties();
                if (superPassUIProperties != null) {
                    smVar.d0(14, (long) superPassUIProperties.getNumOfDays());
                    String customTypeConverters = SuperPassDao_Impl.this.__customTypeConverters.toString(superPassUIProperties.getSpecialFeatures());
                    if (customTypeConverters == null) {
                        smVar.E0(15);
                    } else {
                        smVar.z(15, customTypeConverters);
                    }
                    String fromProofsToString = SuperPassDao_Impl.this.__customTypeConverters.fromProofsToString(superPassUIProperties.getProofs());
                    if (fromProofsToString == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, fromProofsToString);
                    }
                    smVar.d0(17, superPassUIProperties.getBookingTime());
                    if (superPassUIProperties.getPassName() == null) {
                        smVar.E0(18);
                    } else {
                        smVar.z(18, superPassUIProperties.getPassName());
                    }
                    if (superPassUIProperties.getCategoryName() == null) {
                        smVar.E0(19);
                    } else {
                        smVar.z(19, superPassUIProperties.getCategoryName());
                    }
                    if (superPassUIProperties.getFareMappingDisplayName() == null) {
                        smVar.E0(20);
                    } else {
                        smVar.z(20, superPassUIProperties.getFareMappingDisplayName());
                    }
                    SuperPassUserDetails superPassUserDetails = superPassUIProperties.getSuperPassUserDetails();
                    if (superPassUserDetails != null) {
                        if (superPassUserDetails.getUserId() == null) {
                            smVar.E0(21);
                        } else {
                            smVar.z(21, superPassUserDetails.getUserId());
                        }
                        if (superPassUserDetails.getMobileNumber() == null) {
                            smVar.E0(22);
                        } else {
                            smVar.z(22, superPassUserDetails.getMobileNumber());
                        }
                        if (superPassUserDetails.getFullName() == null) {
                            smVar.E0(23);
                        } else {
                            smVar.z(23, superPassUserDetails.getFullName());
                        }
                        if (superPassUserDetails.getGender() == null) {
                            smVar.E0(24);
                        } else {
                            smVar.z(24, SuperPassDao_Impl.this.__Gender_enumToString(superPassUserDetails.getGender()));
                        }
                        if (superPassUserDetails.getDateOfBirth() == null) {
                            smVar.E0(25);
                        } else {
                            smVar.z(25, superPassUserDetails.getDateOfBirth());
                        }
                        if (superPassUserDetails.getEmailId() == null) {
                            smVar.E0(26);
                        } else {
                            smVar.z(26, superPassUserDetails.getEmailId());
                        }
                        if (superPassUserDetails.getProfilePhoto() == null) {
                            smVar.E0(27);
                        } else {
                            smVar.z(27, superPassUserDetails.getProfilePhoto());
                        }
                    } else {
                        hj1.D0(smVar, 21, 22, 23, 24);
                        smVar.E0(25);
                        smVar.E0(26);
                        smVar.E0(27);
                    }
                    FareInfo fareInfo = superPassUIProperties.getFareInfo();
                    if (fareInfo != null) {
                        smVar.N(28, fareInfo.getPayableAmount());
                        smVar.N(29, fareInfo.getActualFare());
                        smVar.d0(30, fareInfo.isDiscountApplicable() ? 1 : 0);
                        smVar.N(31, fareInfo.getDiscountedFare());
                        String fareBreakupComponentString = SuperPassDao_Impl.this.__customTypeConverters.toFareBreakupComponentString(fareInfo.getFareBreakupComponentList());
                        if (fareBreakupComponentString == null) {
                            smVar.E0(32);
                        } else {
                            smVar.z(32, fareBreakupComponentString);
                        }
                    } else {
                        hj1.D0(smVar, 28, 29, 30, 31);
                        smVar.E0(32);
                    }
                    ProductBranding productBranding = superPassUIProperties.getProductBranding();
                    if (productBranding != null) {
                        smVar.d0(33, productBranding.isVisible() ? 1 : 0);
                    } else {
                        smVar.E0(33);
                    }
                } else {
                    hj1.D0(smVar, 14, 15, 16, 17);
                    hj1.D0(smVar, 18, 19, 20, 21);
                    hj1.D0(smVar, 22, 23, 24, 25);
                    hj1.D0(smVar, 26, 27, 28, 29);
                    hj1.D0(smVar, 30, 31, 32, 33);
                }
                SuperPassRepurchaseProperties superPassRepurchaseProperties = magicSuperPass.getSuperPassRepurchaseProperties();
                if (superPassRepurchaseProperties != null) {
                    if (superPassRepurchaseProperties.getConfigId() == null) {
                        smVar.E0(34);
                    } else {
                        smVar.z(34, superPassRepurchaseProperties.getConfigId());
                    }
                    if (superPassRepurchaseProperties.getCategoryId() == null) {
                        smVar.E0(35);
                    } else {
                        smVar.z(35, superPassRepurchaseProperties.getCategoryId());
                    }
                    smVar.d0(36, (long) superPassRepurchaseProperties.getFareMappingId());
                    smVar.d0(37, superPassRepurchaseProperties.getVerificationExpiryTime());
                    smVar.d0(38, superPassRepurchaseProperties.getVerificationFlag() ? 1 : 0);
                    smVar.d0(39, superPassRepurchaseProperties.isRenewable() ? 1 : 0);
                } else {
                    hj1.D0(smVar, 34, 35, 36, 37);
                    smVar.E0(38);
                    smVar.E0(39);
                }
                SuperPassTransactionDetails superPassTransactionDetails = magicSuperPass.getSuperPassTransactionDetails();
                if (superPassTransactionDetails != null) {
                    if (superPassTransactionDetails.getTransactionId() == null) {
                        smVar.E0(40);
                    } else {
                        smVar.z(40, superPassTransactionDetails.getTransactionId());
                    }
                    if (superPassTransactionDetails.getPaymentMode() == null) {
                        smVar.E0(41);
                    } else {
                        smVar.z(41, superPassTransactionDetails.getPaymentMode());
                    }
                } else {
                    smVar.E0(40);
                    smVar.E0(41);
                }
            }
        };
        this.__insertionAdapterOfPendingSuperPass = new ql<PendingSuperPass>(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass3 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `pending_super_pass_table` (`pending_super_pass_properties_super_pass_status`,`pending_super_pass_properties_pass_id`,`pending_super_pass_properties_product_type`,`pending_super_pass_properties_product_sub_type`,`pending_super_pass_properties_city_name`,`pending_super_pass_properties_agency_name`,`pending_super_pass_ui_properties_max_price_per_trip`,`pending_super_pass_ui_properties_fare_mapping_description`,`pending_super_pass_ui_properties_num_of_days`,`pending_super_pass_ui_properties_special_features`,`pending_super_pass_ui_properties_proofs`,`pending_super_pass_ui_properties_booking_time`,`pending_super_pass_ui_properties_pass_name`,`pending_super_pass_ui_properties_category_name`,`pending_super_pass_ui_properties_fare_mapping_display_name`,`pending_super_pass_ui_properties_super_pass_user_details_user_id`,`pending_super_pass_ui_properties_super_pass_user_details_mobile_number`,`pending_super_pass_ui_properties_super_pass_user_details_full_name`,`pending_super_pass_ui_properties_super_pass_user_details_gender`,`pending_super_pass_ui_properties_super_pass_user_details_date_of_birth`,`pending_super_pass_ui_properties_super_pass_user_details_email_id`,`pending_super_pass_ui_properties_super_pass_user_details_profile_photo`,`pending_super_pass_ui_properties_fare_infopayableAmount`,`pending_super_pass_ui_properties_fare_infoactualFare`,`pending_super_pass_ui_properties_fare_infoisDiscountApplicable`,`pending_super_pass_ui_properties_fare_infodiscountedFare`,`pending_super_pass_ui_properties_fare_infofareBreakupComponentList`,`pending_super_pass_ui_properties_product_brandingis_visible`,`pending_super_pass_repurchase_properties_config_id`,`pending_super_pass_repurchase_properties_category_id`,`pending_super_pass_repurchase_properties_fare_mapping_id`,`pending_super_pass_repurchase_properties_start_time`,`pending_super_pass_repurchase_properties_verification_expiry_time`,`pending_super_pass_repurchase_properties_verification_flag`,`pending_super_pass_transaction_details_payment_mode`,`pending_super_pass_transaction_details_transaction_id`,`pending_super_pass_transaction_details_order_id`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, PendingSuperPass pendingSuperPass) {
                PendingSuperPassProperties pendingSuperPassProperties = pendingSuperPass.getPendingSuperPassProperties();
                if (pendingSuperPassProperties != null) {
                    if (pendingSuperPassProperties.getStatus() == null) {
                        smVar.E0(1);
                    } else {
                        smVar.z(1, SuperPassDao_Impl.this.__SuperPassStatus_enumToString(pendingSuperPassProperties.getStatus()));
                    }
                    if (pendingSuperPassProperties.getPassId() == null) {
                        smVar.E0(2);
                    } else {
                        smVar.z(2, pendingSuperPassProperties.getPassId());
                    }
                    if (pendingSuperPassProperties.getProductType() == null) {
                        smVar.E0(3);
                    } else {
                        smVar.z(3, pendingSuperPassProperties.getProductType());
                    }
                    if (pendingSuperPassProperties.getProductSubType() == null) {
                        smVar.E0(4);
                    } else {
                        smVar.z(4, SuperPassDao_Impl.this.__SuperPassSubType_enumToString(pendingSuperPassProperties.getProductSubType()));
                    }
                    if (pendingSuperPassProperties.getCityName() == null) {
                        smVar.E0(5);
                    } else {
                        smVar.z(5, pendingSuperPassProperties.getCityName());
                    }
                    if (pendingSuperPassProperties.getAgencyName() == null) {
                        smVar.E0(6);
                    } else {
                        smVar.z(6, pendingSuperPassProperties.getAgencyName());
                    }
                } else {
                    hj1.D0(smVar, 1, 2, 3, 4);
                    smVar.E0(5);
                    smVar.E0(6);
                }
                PendingSuperPassUIProperties pendingSuperPassUIProperties = pendingSuperPass.getPendingSuperPassUIProperties();
                if (pendingSuperPassUIProperties != null) {
                    smVar.N(7, pendingSuperPassUIProperties.getMaxPricePerTrip());
                    if (pendingSuperPassUIProperties.getFareMappingDescription() == null) {
                        smVar.E0(8);
                    } else {
                        smVar.z(8, pendingSuperPassUIProperties.getFareMappingDescription());
                    }
                    smVar.d0(9, (long) pendingSuperPassUIProperties.getNumOfDays());
                    String customTypeConverters = SuperPassDao_Impl.this.__customTypeConverters.toString(pendingSuperPassUIProperties.getSpecialFeatures());
                    if (customTypeConverters == null) {
                        smVar.E0(10);
                    } else {
                        smVar.z(10, customTypeConverters);
                    }
                    String fromProofsToString = SuperPassDao_Impl.this.__customTypeConverters.fromProofsToString(pendingSuperPassUIProperties.getProofs());
                    if (fromProofsToString == null) {
                        smVar.E0(11);
                    } else {
                        smVar.z(11, fromProofsToString);
                    }
                    smVar.d0(12, pendingSuperPassUIProperties.getBookingTime());
                    if (pendingSuperPassUIProperties.getPassName() == null) {
                        smVar.E0(13);
                    } else {
                        smVar.z(13, pendingSuperPassUIProperties.getPassName());
                    }
                    if (pendingSuperPassUIProperties.getCategoryName() == null) {
                        smVar.E0(14);
                    } else {
                        smVar.z(14, pendingSuperPassUIProperties.getCategoryName());
                    }
                    if (pendingSuperPassUIProperties.getFareMappingDisplayName() == null) {
                        smVar.E0(15);
                    } else {
                        smVar.z(15, pendingSuperPassUIProperties.getFareMappingDisplayName());
                    }
                    SuperPassUserDetails superPassUserDetails = pendingSuperPassUIProperties.getSuperPassUserDetails();
                    if (superPassUserDetails != null) {
                        if (superPassUserDetails.getUserId() == null) {
                            smVar.E0(16);
                        } else {
                            smVar.z(16, superPassUserDetails.getUserId());
                        }
                        if (superPassUserDetails.getMobileNumber() == null) {
                            smVar.E0(17);
                        } else {
                            smVar.z(17, superPassUserDetails.getMobileNumber());
                        }
                        if (superPassUserDetails.getFullName() == null) {
                            smVar.E0(18);
                        } else {
                            smVar.z(18, superPassUserDetails.getFullName());
                        }
                        if (superPassUserDetails.getGender() == null) {
                            smVar.E0(19);
                        } else {
                            smVar.z(19, SuperPassDao_Impl.this.__Gender_enumToString(superPassUserDetails.getGender()));
                        }
                        if (superPassUserDetails.getDateOfBirth() == null) {
                            smVar.E0(20);
                        } else {
                            smVar.z(20, superPassUserDetails.getDateOfBirth());
                        }
                        if (superPassUserDetails.getEmailId() == null) {
                            smVar.E0(21);
                        } else {
                            smVar.z(21, superPassUserDetails.getEmailId());
                        }
                        if (superPassUserDetails.getProfilePhoto() == null) {
                            smVar.E0(22);
                        } else {
                            smVar.z(22, superPassUserDetails.getProfilePhoto());
                        }
                    } else {
                        hj1.D0(smVar, 16, 17, 18, 19);
                        smVar.E0(20);
                        smVar.E0(21);
                        smVar.E0(22);
                    }
                    FareInfo fareInfo = pendingSuperPassUIProperties.getFareInfo();
                    if (fareInfo != null) {
                        smVar.N(23, fareInfo.getPayableAmount());
                        smVar.N(24, fareInfo.getActualFare());
                        smVar.d0(25, fareInfo.isDiscountApplicable() ? 1 : 0);
                        smVar.N(26, fareInfo.getDiscountedFare());
                        String fareBreakupComponentString = SuperPassDao_Impl.this.__customTypeConverters.toFareBreakupComponentString(fareInfo.getFareBreakupComponentList());
                        if (fareBreakupComponentString == null) {
                            smVar.E0(27);
                        } else {
                            smVar.z(27, fareBreakupComponentString);
                        }
                    } else {
                        hj1.D0(smVar, 23, 24, 25, 26);
                        smVar.E0(27);
                    }
                    ProductBranding productBranding = pendingSuperPassUIProperties.getProductBranding();
                    if (productBranding != null) {
                        smVar.d0(28, productBranding.isVisible() ? 1 : 0);
                    } else {
                        smVar.E0(28);
                    }
                } else {
                    hj1.D0(smVar, 7, 8, 9, 10);
                    hj1.D0(smVar, 11, 12, 13, 14);
                    hj1.D0(smVar, 15, 16, 17, 18);
                    hj1.D0(smVar, 19, 20, 21, 22);
                    hj1.D0(smVar, 23, 24, 25, 26);
                    smVar.E0(27);
                    smVar.E0(28);
                }
                PendingSuperPassRepurchaseProperties pendingSuperPassRepurchaseProperties = pendingSuperPass.getPendingSuperPassRepurchaseProperties();
                if (pendingSuperPassRepurchaseProperties != null) {
                    if (pendingSuperPassRepurchaseProperties.getConfigId() == null) {
                        smVar.E0(29);
                    } else {
                        smVar.z(29, pendingSuperPassRepurchaseProperties.getConfigId());
                    }
                    if (pendingSuperPassRepurchaseProperties.getCategoryId() == null) {
                        smVar.E0(30);
                    } else {
                        smVar.z(30, pendingSuperPassRepurchaseProperties.getCategoryId());
                    }
                    smVar.d0(31, (long) pendingSuperPassRepurchaseProperties.getFareMappingId());
                    smVar.d0(32, pendingSuperPassRepurchaseProperties.getStartTime());
                    smVar.d0(33, pendingSuperPassRepurchaseProperties.getVerificationExpiryTime());
                    smVar.d0(34, pendingSuperPassRepurchaseProperties.getVerificationFlag() ? 1 : 0);
                } else {
                    hj1.D0(smVar, 29, 30, 31, 32);
                    smVar.E0(33);
                    smVar.E0(34);
                }
                PendingSuperPassTransactionDetails pendingSuperPassTransactionDetails = pendingSuperPass.getPendingSuperPassTransactionDetails();
                if (pendingSuperPassTransactionDetails != null) {
                    if (pendingSuperPassTransactionDetails.getPaymentMode() == null) {
                        smVar.E0(35);
                    } else {
                        smVar.z(35, pendingSuperPassTransactionDetails.getPaymentMode());
                    }
                    if (pendingSuperPassTransactionDetails.getTransactionId() == null) {
                        smVar.E0(36);
                    } else {
                        smVar.z(36, pendingSuperPassTransactionDetails.getTransactionId());
                    }
                    if (pendingSuperPassTransactionDetails.getOrderId() == null) {
                        smVar.E0(37);
                    } else {
                        smVar.z(37, pendingSuperPassTransactionDetails.getOrderId());
                    }
                } else {
                    smVar.E0(35);
                    smVar.E0(36);
                    smVar.E0(37);
                }
            }
        };
        this.__insertionAdapterOfRideBasedSuperPass = new ql<RideBasedSuperPass>(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass4 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ride_based_super_pass_table` (`super_pass_validation_properties_max_trips_per_day`,`super_pass_validation_properties_num_of_trips`,`super_pass_validation_properties_super_pass_status`,`super_pass_validation_properties_start_time`,`super_pass_validation_properties_expiry_time`,`super_pass_validation_properties_active_duration`,`super_pass_validation_properties_ride_details_previous_ride_time_stamps`,`super_pass_validation_properties_ride_details_is_activation_allowed_in_current_session`,`super_pass_validation_properties_ride_details_oldest_history_call_time_stamp`,`super_pass_validation_properties_ride_details_last_activation_time_stamp`,`super_pass_validation_properties_ride_details_last_punch_time_stamp`,`super_pass_ui_properties_max_price_per_trip`,`super_pass_ui_properties_fare_mapping_description`,`super_pass_ui_properties_num_of_days`,`super_pass_ui_properties_special_features`,`super_pass_ui_properties_proofs`,`super_pass_ui_properties_booking_time`,`super_pass_ui_properties_pass_name`,`super_pass_ui_properties_category_name`,`super_pass_ui_properties_fare_mapping_display_name`,`super_pass_ui_properties_super_pass_user_details_user_id`,`super_pass_ui_properties_super_pass_user_details_mobile_number`,`super_pass_ui_properties_super_pass_user_details_full_name`,`super_pass_ui_properties_super_pass_user_details_gender`,`super_pass_ui_properties_super_pass_user_details_date_of_birth`,`super_pass_ui_properties_super_pass_user_details_email_id`,`super_pass_ui_properties_super_pass_user_details_profile_photo`,`super_pass_ui_properties_fare_infopayableAmount`,`super_pass_ui_properties_fare_infoactualFare`,`super_pass_ui_properties_fare_infoisDiscountApplicable`,`super_pass_ui_properties_fare_infodiscountedFare`,`super_pass_ui_properties_fare_infofareBreakupComponentList`,`super_pass_ui_properties_product_brandingis_visible`,`super_pass_properties_qr_code`,`super_pass_properties_tone`,`super_pass_properties_pass_id`,`super_pass_properties_product_type`,`super_pass_properties_product_sub_type`,`super_pass_properties_city_name`,`super_pass_properties_agency_name`,`super_pass_repurchase_properties_config_id`,`super_pass_repurchase_properties_category_id`,`super_pass_repurchase_properties_fare_mapping_id`,`super_pass_repurchase_properties_verification_expiry_time`,`super_pass_repurchase_properties_verification_flag`,`super_pass_repurchase_properties_is_renewable`,`super_pass_transaction_details_transaction_id`,`super_pass_transaction_details_payment_mode`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            public void bind(sm smVar, RideBasedSuperPass rideBasedSuperPass) {
                RideBasedSuperPassValidationProperties superPassValidationProperties = rideBasedSuperPass.getSuperPassValidationProperties();
                if (superPassValidationProperties != null) {
                    smVar.d0(1, (long) superPassValidationProperties.getMaxTripsPerDay());
                    smVar.d0(2, (long) superPassValidationProperties.getNumOfTrips());
                    if (superPassValidationProperties.getStatus() == null) {
                        smVar.E0(3);
                    } else {
                        smVar.z(3, SuperPassDao_Impl.this.__SuperPassStatus_enumToString(superPassValidationProperties.getStatus()));
                    }
                    smVar.d0(4, superPassValidationProperties.getStartTime());
                    smVar.d0(5, superPassValidationProperties.getExpiryTime());
                    smVar.d0(6, superPassValidationProperties.getActiveDuration());
                    RideBasedSuperPassRideDetails superPassRideDetails = superPassValidationProperties.getSuperPassRideDetails();
                    if (superPassRideDetails != null) {
                        String str = SuperPassDao_Impl.this.__customTypeConverters.toLong(superPassRideDetails.getPreviousRideTimeStamps());
                        if (str == null) {
                            smVar.E0(7);
                        } else {
                            smVar.z(7, str);
                        }
                        smVar.d0(8, superPassRideDetails.isActivationAllowedInCurrentSession() ? 1 : 0);
                        smVar.d0(9, superPassRideDetails.getOldestHistoryCallTimeStamp());
                        smVar.d0(10, superPassRideDetails.getLastActivationTimeStamp());
                        smVar.d0(11, superPassRideDetails.getLastPunchTimeStamp());
                    } else {
                        hj1.D0(smVar, 7, 8, 9, 10);
                        smVar.E0(11);
                    }
                } else {
                    hj1.D0(smVar, 1, 2, 3, 4);
                    hj1.D0(smVar, 5, 6, 7, 8);
                    smVar.E0(9);
                    smVar.E0(10);
                    smVar.E0(11);
                }
                RideBasedSuperPassUIProperties superPassUIProperties = rideBasedSuperPass.getSuperPassUIProperties();
                if (superPassUIProperties != null) {
                    smVar.N(12, superPassUIProperties.getMaxPricePerTrip());
                    if (superPassUIProperties.getFareMappingDescription() == null) {
                        smVar.E0(13);
                    } else {
                        smVar.z(13, superPassUIProperties.getFareMappingDescription());
                    }
                    smVar.d0(14, (long) superPassUIProperties.getNumOfDays());
                    String customTypeConverters = SuperPassDao_Impl.this.__customTypeConverters.toString(superPassUIProperties.getSpecialFeatures());
                    if (customTypeConverters == null) {
                        smVar.E0(15);
                    } else {
                        smVar.z(15, customTypeConverters);
                    }
                    String fromProofsToString = SuperPassDao_Impl.this.__customTypeConverters.fromProofsToString(superPassUIProperties.getProofs());
                    if (fromProofsToString == null) {
                        smVar.E0(16);
                    } else {
                        smVar.z(16, fromProofsToString);
                    }
                    smVar.d0(17, superPassUIProperties.getBookingTime());
                    if (superPassUIProperties.getPassName() == null) {
                        smVar.E0(18);
                    } else {
                        smVar.z(18, superPassUIProperties.getPassName());
                    }
                    if (superPassUIProperties.getCategoryName() == null) {
                        smVar.E0(19);
                    } else {
                        smVar.z(19, superPassUIProperties.getCategoryName());
                    }
                    if (superPassUIProperties.getFareMappingDisplayName() == null) {
                        smVar.E0(20);
                    } else {
                        smVar.z(20, superPassUIProperties.getFareMappingDisplayName());
                    }
                    SuperPassUserDetails superPassUserDetails = superPassUIProperties.getSuperPassUserDetails();
                    if (superPassUserDetails != null) {
                        if (superPassUserDetails.getUserId() == null) {
                            smVar.E0(21);
                        } else {
                            smVar.z(21, superPassUserDetails.getUserId());
                        }
                        if (superPassUserDetails.getMobileNumber() == null) {
                            smVar.E0(22);
                        } else {
                            smVar.z(22, superPassUserDetails.getMobileNumber());
                        }
                        if (superPassUserDetails.getFullName() == null) {
                            smVar.E0(23);
                        } else {
                            smVar.z(23, superPassUserDetails.getFullName());
                        }
                        if (superPassUserDetails.getGender() == null) {
                            smVar.E0(24);
                        } else {
                            smVar.z(24, SuperPassDao_Impl.this.__Gender_enumToString(superPassUserDetails.getGender()));
                        }
                        if (superPassUserDetails.getDateOfBirth() == null) {
                            smVar.E0(25);
                        } else {
                            smVar.z(25, superPassUserDetails.getDateOfBirth());
                        }
                        if (superPassUserDetails.getEmailId() == null) {
                            smVar.E0(26);
                        } else {
                            smVar.z(26, superPassUserDetails.getEmailId());
                        }
                        if (superPassUserDetails.getProfilePhoto() == null) {
                            smVar.E0(27);
                        } else {
                            smVar.z(27, superPassUserDetails.getProfilePhoto());
                        }
                    } else {
                        hj1.D0(smVar, 21, 22, 23, 24);
                        smVar.E0(25);
                        smVar.E0(26);
                        smVar.E0(27);
                    }
                    FareInfo fareInfo = superPassUIProperties.getFareInfo();
                    if (fareInfo != null) {
                        smVar.N(28, fareInfo.getPayableAmount());
                        smVar.N(29, fareInfo.getActualFare());
                        smVar.d0(30, fareInfo.isDiscountApplicable() ? 1 : 0);
                        smVar.N(31, fareInfo.getDiscountedFare());
                        String fareBreakupComponentString = SuperPassDao_Impl.this.__customTypeConverters.toFareBreakupComponentString(fareInfo.getFareBreakupComponentList());
                        if (fareBreakupComponentString == null) {
                            smVar.E0(32);
                        } else {
                            smVar.z(32, fareBreakupComponentString);
                        }
                    } else {
                        hj1.D0(smVar, 28, 29, 30, 31);
                        smVar.E0(32);
                    }
                    ProductBranding productBranding = superPassUIProperties.getProductBranding();
                    if (productBranding != null) {
                        smVar.d0(33, productBranding.isVisible() ? 1 : 0);
                    } else {
                        smVar.E0(33);
                    }
                } else {
                    hj1.D0(smVar, 12, 13, 14, 15);
                    hj1.D0(smVar, 16, 17, 18, 19);
                    hj1.D0(smVar, 20, 21, 22, 23);
                    hj1.D0(smVar, 24, 25, 26, 27);
                    hj1.D0(smVar, 28, 29, 30, 31);
                    smVar.E0(32);
                    smVar.E0(33);
                }
                SuperPassProperties superPassProperties = rideBasedSuperPass.getSuperPassProperties();
                if (superPassProperties != null) {
                    if (superPassProperties.getQrCode() == null) {
                        smVar.E0(34);
                    } else {
                        smVar.z(34, superPassProperties.getQrCode());
                    }
                    if (superPassProperties.getTone() == null) {
                        smVar.E0(35);
                    } else {
                        smVar.z(35, superPassProperties.getTone());
                    }
                    if (superPassProperties.getPassId() == null) {
                        smVar.E0(36);
                    } else {
                        smVar.z(36, superPassProperties.getPassId());
                    }
                    if (superPassProperties.getProductType() == null) {
                        smVar.E0(37);
                    } else {
                        smVar.z(37, superPassProperties.getProductType());
                    }
                    if (superPassProperties.getProductSubType() == null) {
                        smVar.E0(38);
                    } else {
                        smVar.z(38, SuperPassDao_Impl.this.__SuperPassSubType_enumToString(superPassProperties.getProductSubType()));
                    }
                    if (superPassProperties.getCityName() == null) {
                        smVar.E0(39);
                    } else {
                        smVar.z(39, superPassProperties.getCityName());
                    }
                    if (superPassProperties.getAgencyName() == null) {
                        smVar.E0(40);
                    } else {
                        smVar.z(40, superPassProperties.getAgencyName());
                    }
                } else {
                    hj1.D0(smVar, 34, 35, 36, 37);
                    smVar.E0(38);
                    smVar.E0(39);
                    smVar.E0(40);
                }
                SuperPassRepurchaseProperties superPassRepurchaseProperties = rideBasedSuperPass.getSuperPassRepurchaseProperties();
                if (superPassRepurchaseProperties != null) {
                    if (superPassRepurchaseProperties.getConfigId() == null) {
                        smVar.E0(41);
                    } else {
                        smVar.z(41, superPassRepurchaseProperties.getConfigId());
                    }
                    if (superPassRepurchaseProperties.getCategoryId() == null) {
                        smVar.E0(42);
                    } else {
                        smVar.z(42, superPassRepurchaseProperties.getCategoryId());
                    }
                    smVar.d0(43, (long) superPassRepurchaseProperties.getFareMappingId());
                    smVar.d0(44, superPassRepurchaseProperties.getVerificationExpiryTime());
                    smVar.d0(45, superPassRepurchaseProperties.getVerificationFlag() ? 1 : 0);
                    smVar.d0(46, superPassRepurchaseProperties.isRenewable() ? 1 : 0);
                } else {
                    hj1.D0(smVar, 41, 42, 43, 44);
                    smVar.E0(45);
                    smVar.E0(46);
                }
                SuperPassTransactionDetails superPassTransactionDetails = rideBasedSuperPass.getSuperPassTransactionDetails();
                if (superPassTransactionDetails != null) {
                    if (superPassTransactionDetails.getTransactionId() == null) {
                        smVar.E0(47);
                    } else {
                        smVar.z(47, superPassTransactionDetails.getTransactionId());
                    }
                    if (superPassTransactionDetails.getPaymentMode() == null) {
                        smVar.E0(48);
                    } else {
                        smVar.z(48, superPassTransactionDetails.getPaymentMode());
                    }
                } else {
                    smVar.E0(47);
                    smVar.E0(48);
                }
            }
        };
        this.__insertionAdapterOfRideBasedSuperPassRideDetailsRoom = new ql<RideBasedSuperPassRideDetailsRoom>(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass5 */

            @Override // defpackage.bm
            public String createQuery() {
                return "INSERT OR REPLACE INTO `ride_based_super_pass_ride_details_table` (`pass_id`,`previous_ride_time_stamps`,`is_activation_allowed_in_current_session`,`oldest_history_call_time_stamp`,`last_activation_time_stamp`,`last_punch_time_stamp`) VALUES (?,?,?,?,?,?)";
            }

            public void bind(sm smVar, RideBasedSuperPassRideDetailsRoom rideBasedSuperPassRideDetailsRoom) {
                if (rideBasedSuperPassRideDetailsRoom.getPassId() == null) {
                    smVar.E0(1);
                } else {
                    smVar.z(1, rideBasedSuperPassRideDetailsRoom.getPassId());
                }
                String str = SuperPassDao_Impl.this.__customTypeConverters.toLong(rideBasedSuperPassRideDetailsRoom.getPreviousRideTimeStamps());
                if (str == null) {
                    smVar.E0(2);
                } else {
                    smVar.z(2, str);
                }
                smVar.d0(3, rideBasedSuperPassRideDetailsRoom.isActivationAllowedInCurrentSession() ? 1 : 0);
                smVar.d0(4, rideBasedSuperPassRideDetailsRoom.getOldestHistoryCallTimeStamp());
                smVar.d0(5, rideBasedSuperPassRideDetailsRoom.getLastActivationTimeStamp());
                smVar.d0(6, rideBasedSuperPassRideDetailsRoom.getLastPunchTimeStamp());
            }
        };
        this.__preparedStmtOfDeleteAllSuperPassApplicationsForCity = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass6 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM super_pass_application_table where city_name = ?";
            }
        };
        this.__preparedStmtOfDeleteAllSuperPassApplications = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass7 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM super_pass_application_table";
            }
        };
        this.__preparedStmtOfDeleteAllPendingSuperPasses = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass8 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM pending_super_pass_table where pending_super_pass_properties_city_name = ?";
            }
        };
        this.__preparedStmtOfDeleteAllMagicSuperPassesForCity = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass9 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM magic_super_pass_table where super_pass_properties_city_name = ?";
            }
        };
        this.__preparedStmtOfDeleteAllMagicSuperPasses = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass10 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM magic_super_pass_table";
            }
        };
        this.__preparedStmtOfUpdateRideBasedSuperPass = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass11 */

            @Override // defpackage.bm
            public String createQuery() {
                return "UPDATE ride_based_super_pass_table SET super_pass_validation_properties_ride_details_previous_ride_time_stamps = ?,super_pass_validation_properties_ride_details_last_activation_time_stamp = ? WHERE super_pass_properties_pass_id = ?";
            }
        };
        this.__preparedStmtOfDeleteAllRideBasedSuperPassesForCity = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass12 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM ride_based_super_pass_table where super_pass_properties_city_name = ?";
            }
        };
        this.__preparedStmtOfDeleteAllRideBasedSuperPasses = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass13 */

            @Override // defpackage.bm
            public String createQuery() {
                return "DELETE FROM ride_based_super_pass_table";
            }
        };
        this.__preparedStmtOfUpdateMagicSuperPassLastActivationTimeStamp = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass14 */

            @Override // defpackage.bm
            public String createQuery() {
                return "UPDATE magic_super_pass_table SET super_pass_validation_properties_ride_details_last_activation_time_stamp = ? WHERE super_pass_properties_pass_id = ?";
            }
        };
        this.__preparedStmtOfUpdateRideBasedSuperPassRideDetails = new bm(wlVar) {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass15 */

            @Override // defpackage.bm
            public String createQuery() {
                return "UPDATE ride_based_super_pass_ride_details_table SET previous_ride_time_stamps = ? ,is_activation_allowed_in_current_session = ?, last_activation_time_stamp = ?, last_punch_time_stamp = ? WHERE pass_id = ?";
            }
        };
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String __Gender_enumToString(Gender gender) {
        if (gender == null) {
            return null;
        }
        int ordinal = gender.ordinal();
        if (ordinal == 0) {
            return "MALE";
        }
        if (ordinal == 1) {
            return "FEMALE";
        }
        if (ordinal == 2) {
            return "OTHER";
        }
        if (ordinal == 3) {
            return "NULL";
        }
        throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + gender);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private Gender __Gender_stringToEnum(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 2358797:
                if (str.equals("MALE")) {
                    c = 0;
                    break;
                }
                break;
            case 2407815:
                if (str.equals("NULL")) {
                    c = 1;
                    break;
                }
                break;
            case 75532016:
                if (str.equals("OTHER")) {
                    c = 2;
                    break;
                }
                break;
            case 2070122316:
                if (str.equals("FEMALE")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return Gender.MALE;
            case 1:
                return Gender.NULL;
            case 2:
                return Gender.OTHER;
            case 3:
                return Gender.FEMALE;
            default:
                throw new IllegalArgumentException(hj1.S("Can't convert value to enum, unknown value: ", str));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String __SuperPassApplicationStatus_enumToString(SuperPassApplicationStatus superPassApplicationStatus) {
        if (superPassApplicationStatus == null) {
            return null;
        }
        int ordinal = superPassApplicationStatus.ordinal();
        if (ordinal == 0) {
            return "UNVERIFIED";
        }
        if (ordinal == 1) {
            return "VERIFIED";
        }
        if (ordinal == 2) {
            return "REJECTED";
        }
        if (ordinal == 3) {
            return "PAYMENT_PENDING";
        }
        throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + superPassApplicationStatus);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private SuperPassApplicationStatus __SuperPassApplicationStatus_stringToEnum(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1211756856:
                if (str.equals("VERIFIED")) {
                    c = 0;
                    break;
                }
                break;
            case 16937057:
                if (str.equals("UNVERIFIED")) {
                    c = 1;
                    break;
                }
                break;
            case 174130302:
                if (str.equals("REJECTED")) {
                    c = 2;
                    break;
                }
                break;
            case 1862415390:
                if (str.equals("PAYMENT_PENDING")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return SuperPassApplicationStatus.VERIFIED;
            case 1:
                return SuperPassApplicationStatus.UNVERIFIED;
            case 2:
                return SuperPassApplicationStatus.REJECTED;
            case 3:
                return SuperPassApplicationStatus.PAYMENT_PENDING;
            default:
                throw new IllegalArgumentException(hj1.S("Can't convert value to enum, unknown value: ", str));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String __SuperPassStatus_enumToString(SuperPassStatus superPassStatus) {
        if (superPassStatus == null) {
            return null;
        }
        int ordinal = superPassStatus.ordinal();
        if (ordinal == 0) {
            return "PAYMENT_FAILED";
        }
        if (ordinal == 1) {
            return "PAYMENT_PROCESSING";
        }
        if (ordinal == 2) {
            return "UNUSED";
        }
        if (ordinal == 3) {
            return "USED";
        }
        if (ordinal == 4) {
            return "INACTIVE";
        }
        if (ordinal == 5) {
            return "EXPIRED";
        }
        throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + superPassStatus);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private SuperPassStatus __SuperPassStatus_stringToEnum(String str) {
        if (str == null) {
            return null;
        }
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1786840618:
                if (str.equals("UNUSED")) {
                    c = 0;
                    break;
                }
                break;
            case -784238410:
                if (str.equals("PAYMENT_FAILED")) {
                    c = 1;
                    break;
                }
                break;
            case -591252731:
                if (str.equals("EXPIRED")) {
                    c = 2;
                    break;
                }
                break;
            case -446879988:
                if (str.equals("PAYMENT_PROCESSING")) {
                    c = 3;
                    break;
                }
                break;
            case 2614205:
                if (str.equals("USED")) {
                    c = 4;
                    break;
                }
                break;
            case 807292011:
                if (str.equals("INACTIVE")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return SuperPassStatus.UNUSED;
            case 1:
                return SuperPassStatus.PAYMENT_FAILED;
            case 2:
                return SuperPassStatus.EXPIRED;
            case 3:
                return SuperPassStatus.PAYMENT_PROCESSING;
            case 4:
                return SuperPassStatus.USED;
            case 5:
                return SuperPassStatus.INACTIVE;
            default:
                throw new IllegalArgumentException(hj1.S("Can't convert value to enum, unknown value: ", str));
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private String __SuperPassSubType_enumToString(SuperPassSubType superPassSubType) {
        if (superPassSubType == null) {
            return null;
        }
        int ordinal = superPassSubType.ordinal();
        if (ordinal == 0) {
            return "MAGIC_SUPER_PASS";
        }
        if (ordinal == 1) {
            return "RIDE_BASED_SUPER_PASS";
        }
        throw new IllegalArgumentException("Can't convert enum to string, unknown enum value: " + superPassSubType);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private SuperPassSubType __SuperPassSubType_stringToEnum(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("RIDE_BASED_SUPER_PASS")) {
            return SuperPassSubType.RIDE_BASED_SUPER_PASS;
        }
        if (str.equals("MAGIC_SUPER_PASS")) {
            return SuperPassSubType.MAGIC_SUPER_PASS;
        }
        throw new IllegalArgumentException(hj1.S("Can't convert value to enum, unknown value: ", str));
    }

    public static List<Class<?>> getRequiredConverters() {
        return Collections.emptyList();
    }

    @Override // app.zophop.room.SuperPassDao
    public Object deleteAllMagicSuperPasses(k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass28 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfDeleteAllMagicSuperPasses.acquire();
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfDeleteAllMagicSuperPasses.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object deleteAllMagicSuperPassesForCity(final String str, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass27 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfDeleteAllMagicSuperPassesForCity.acquire();
                String str = str;
                if (str == null) {
                    acquire.E0(1);
                } else {
                    acquire.z(1, str);
                }
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfDeleteAllMagicSuperPassesForCity.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object deleteAllPendingSuperPasses(final String str, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass26 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfDeleteAllPendingSuperPasses.acquire();
                String str = str;
                if (str == null) {
                    acquire.E0(1);
                } else {
                    acquire.z(1, str);
                }
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfDeleteAllPendingSuperPasses.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object deleteAllRideBasedSuperPasses(k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass31 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfDeleteAllRideBasedSuperPasses.acquire();
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfDeleteAllRideBasedSuperPasses.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object deleteAllRideBasedSuperPassesForCity(final String str, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass30 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfDeleteAllRideBasedSuperPassesForCity.acquire();
                String str = str;
                if (str == null) {
                    acquire.E0(1);
                } else {
                    acquire.z(1, str);
                }
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfDeleteAllRideBasedSuperPassesForCity.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object deleteAllSuperPassApplications(k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass25 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfDeleteAllSuperPassApplications.acquire();
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfDeleteAllSuperPassApplications.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object deleteAllSuperPassApplicationsForCity(final String str, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass24 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfDeleteAllSuperPassApplicationsForCity.acquire();
                String str = str;
                if (str == null) {
                    acquire.E0(1);
                } else {
                    acquire.z(1, str);
                }
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfDeleteAllSuperPassApplicationsForCity.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object doesMagicSuperPassExist(String str, k66<? super Boolean> k66) {
        final yl e = yl.e("SELECT EXISTS(SELECT * FROM magic_super_pass_table WHERE super_pass_properties_pass_id = ?)", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.b(this.__db, false, new CancellationSignal(), new Callable<Boolean>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass41 */

            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                Integer num;
                boolean z = false;
                Boolean bool = null;
                Cursor b = hm.b(SuperPassDao_Impl.this.__db, e, false, null);
                try {
                    if (b.moveToFirst()) {
                        if (b.isNull(0)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(b.getInt(0));
                        }
                        if (num != null) {
                            if (num.intValue() != 0) {
                                z = true;
                            }
                            bool = Boolean.valueOf(z);
                        }
                    }
                    return bool;
                } finally {
                    b.close();
                    e.f();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object doesRideBasedSuperPassRideDetailsExist(String str, k66<? super Boolean> k66) {
        final yl e = yl.e("SELECT EXISTS(SELECT * FROM ride_based_super_pass_ride_details_table WHERE pass_id = ?)", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.b(this.__db, false, new CancellationSignal(), new Callable<Boolean>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass47 */

            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                Integer num;
                boolean z = false;
                Boolean bool = null;
                Cursor b = hm.b(SuperPassDao_Impl.this.__db, e, false, null);
                try {
                    if (b.moveToFirst()) {
                        if (b.isNull(0)) {
                            num = null;
                        } else {
                            num = Integer.valueOf(b.getInt(0));
                        }
                        if (num != null) {
                            if (num.intValue() != 0) {
                                z = true;
                            }
                            bool = Boolean.valueOf(z);
                        }
                    }
                    return bool;
                } finally {
                    b.close();
                    e.f();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public LiveData<List<MagicSuperPass>> getAllMagicSuperPasses(String str) {
        final yl e = yl.e("SELECT * FROM magic_super_pass_table where super_pass_properties_city_name = ? ORDER BY super_pass_ui_properties_booking_time DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"magic_super_pass_table"}, false, new Callable<List<MagicSuperPass>>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass34 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:128:0x03d7 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:135:0x040d A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:136:0x0413 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:139:0x042d A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x042f A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:143:0x0447 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:144:0x044a A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:147:0x0456 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x0459 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:151:0x0465 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x0468 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:155:0x0474 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:172:0x04ab A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x04ae A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:176:0x04ba A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x04bd A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:180:0x04c9 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x04cc A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:184:0x04e4 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x04e7 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:188:0x04f3 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x04f6 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:192:0x0502 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x0505 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x051c A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:210:0x055b A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:215:0x0577 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x057a A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:219:0x0586 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:220:0x058c A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:224:0x05af A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:229:0x05c0 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:233:0x05d3 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:249:0x0620 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x0636 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:257:0x0639 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x0645 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:261:0x0648 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x065c A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:265:0x065f A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x0667 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:269:0x066a A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:273:0x067f A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:277:0x0693 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:280:0x069d A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:281:0x06a1 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:284:0x06af A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:285:0x06b5 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x0244 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x027c A[Catch:{ all -> 0x0722 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.models.mTicketing.superPass.MagicSuperPass> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1831
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass34.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.SuperPassDao
    public LiveData<List<PendingSuperPass>> getAllPendingSuperPass(String str) {
        final yl e = yl.e("SELECT * FROM pending_super_pass_table where pending_super_pass_properties_city_name = ? ORDER BY pending_super_pass_ui_properties_booking_time DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"pending_super_pass_table"}, false, new Callable<List<PendingSuperPass>>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass46 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:101:0x02de A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:102:0x02e1 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:105:0x02f1 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x02f7 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x0311 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x0313 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x032b A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:114:0x032e A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:117:0x033a A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x033d A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x0349 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:122:0x034c A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:125:0x0358 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x03a2 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:146:0x03a5 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x03b1 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x03b4 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x03c0 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:154:0x03c5 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x03df A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:158:0x03e2 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x03ee A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:162:0x03f1 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x03fd A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:166:0x0400 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:170:0x0417 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:182:0x0450 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:187:0x046c A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:188:0x046f A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:191:0x047b A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:192:0x0481 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:196:0x04a4 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:201:0x04b5 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:205:0x04c6 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:219:0x050f A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:225:0x0527 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:226:0x052a A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:229:0x0536 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:230:0x0539 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:233:0x0551 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:234:0x0554 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:238:0x056b A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:244:0x058a A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x0598 A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:249:0x059c A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x05aa A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:253:0x05ae A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x05bc A[Catch:{ all -> 0x062b }] */
            /* JADX WARNING: Removed duplicated region for block: B:257:0x05c2 A[Catch:{ all -> 0x062b }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1584
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass46.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.SuperPassDao
    public LiveData<List<RideBasedSuperPass>> getAllRideBasedSuperPasses(String str) {
        final yl e = yl.e("SELECT * FROM ride_based_super_pass_table where super_pass_properties_city_name = ? ORDER BY super_pass_ui_properties_booking_time DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"ride_based_super_pass_table"}, false, new Callable<List<RideBasedSuperPass>>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass38 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:106:0x0364 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x039e A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:122:0x03a1 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:125:0x03b1 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x03b7 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x03d1 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:130:0x03d3 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x03eb A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x03ee A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x03fa A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:138:0x03fd A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x0409 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x040c A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x0418 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0462 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:166:0x0465 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x0471 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:170:0x0474 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x0480 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:174:0x0485 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x049f A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:178:0x04a2 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x04ae A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:182:0x04b1 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x04bd A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:186:0x04c0 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:190:0x04d7 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:202:0x0510 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:207:0x052c A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:208:0x052f A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:211:0x053b A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:212:0x0541 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x0564 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x0575 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:225:0x0588 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:242:0x05de A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x05fa A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:249:0x05fd A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x0609 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:253:0x060c A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x0618 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:257:0x061b A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x0627 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:261:0x062c A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x0644 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:265:0x0647 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x0653 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:269:0x0656 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:273:0x066d A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:288:0x06be A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:294:0x06d6 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:295:0x06d9 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:298:0x06e5 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:299:0x06e8 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:302:0x06fc A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:303:0x06ff A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:306:0x0707 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:307:0x070a A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:311:0x071f A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:315:0x0733 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:318:0x073d A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:319:0x0741 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:322:0x074f A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:323:0x0755 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0259 A[Catch:{ all -> 0x07d6 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.models.mTicketing.superPass.RideBasedSuperPass> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 2011
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass38.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.SuperPassDao
    public LiveData<List<SuperPassApplication>> getAllSuperPassApplications(String str) {
        final yl e = yl.e("SELECT * FROM super_pass_application_table where city_name = ? ORDER BY pass_start_date DESC", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return this.__db.getInvalidationTracker().b(new String[]{"super_pass_application_table"}, false, new Callable<List<SuperPassApplication>>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass45 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:104:0x02a2 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:108:0x02ac A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:109:0x02b0 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:112:0x02c6 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:113:0x02ca A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:116:0x02e0 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:117:0x02e4 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:61:0x01ce A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:62:0x01d1 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:65:0x01dd A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x01e0 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x01ec A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:70:0x01f1 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:73:0x020b A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:74:0x020e A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:77:0x021a A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:78:0x021d A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:81:0x0229 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x022c A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:86:0x0243 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:90:0x0259 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:93:0x0269 A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:94:0x026f A[Catch:{ all -> 0x0327 }] */
            /* JADX WARNING: Removed duplicated region for block: B:98:0x0288 A[Catch:{ all -> 0x0327 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.models.mTicketing.superPass.SuperPassApplication> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 812
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass45.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.SuperPassDao
    public qe6<MagicSuperPass> getMagicSuperPass(String str) {
        final yl e = yl.e("SELECT * FROM magic_super_pass_table where super_pass_properties_pass_id = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.a(this.__db, false, new String[]{"magic_super_pass_table"}, new Callable<MagicSuperPass>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass35 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:132:0x0388 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:139:0x03b2 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x03b4 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:143:0x03c8 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:144:0x03ca A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:147:0x03e2 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x03e5 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:151:0x03f1 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x03f4 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:155:0x0400 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:156:0x0403 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:159:0x040f A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:176:0x0444 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x0447 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:180:0x0453 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x0456 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:184:0x0462 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x0465 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:188:0x047b A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x047e A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:192:0x048a A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x048d A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:196:0x0499 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x049c A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:201:0x04b3 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:211:0x04d7 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:217:0x04ed A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:218:0x04f0 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x04fc A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:222:0x04fe A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:226:0x051b A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:231:0x052c A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:235:0x053e A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:247:0x056b A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:254:0x057b A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x057e A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:258:0x058a A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:259:0x058d A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:262:0x05a1 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:263:0x05a4 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:266:0x05ac A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:267:0x05af A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:271:0x05c1 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:275:0x05cc A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:278:0x05d4 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:279:0x05d6 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:282:0x05e0 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:283:0x05e2 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:57:0x0200 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:58:0x0201 A[Catch:{ all -> 0x05fc }] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x024a A[Catch:{ all -> 0x05fc }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public app.zophop.models.mTicketing.superPass.MagicSuperPass call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1537
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass35.call():app.zophop.models.mTicketing.superPass.MagicSuperPass");
            }
        });
    }

    @Override // app.zophop.room.SuperPassDao
    public Object getMagicSuperPassCount(String str, k66<? super Integer> k66) {
        final yl e = yl.e("SELECT COUNT (DISTINCT super_pass_properties_pass_id) FROM magic_super_pass_table where super_pass_properties_city_name = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.b(this.__db, false, new CancellationSignal(), new Callable<Integer>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass36 */

            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer num = null;
                Cursor b = hm.b(SuperPassDao_Impl.this.__db, e, false, null);
                try {
                    if (b.moveToFirst()) {
                        if (!b.isNull(0)) {
                            num = Integer.valueOf(b.getInt(0));
                        }
                    }
                    return num;
                } finally {
                    b.close();
                    e.f();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object getMagicSuperPassLastActivationTimeStamp(String str, k66<? super Long> k66) {
        final yl e = yl.e("SELECT super_pass_validation_properties_ride_details_last_activation_time_stamp FROM magic_super_pass_table WHERE super_pass_properties_pass_id = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.b(this.__db, false, new CancellationSignal(), new Callable<Long>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass42 */

            @Override // java.util.concurrent.Callable
            public Long call() throws Exception {
                Long l = null;
                Cursor b = hm.b(SuperPassDao_Impl.this.__db, e, false, null);
                try {
                    if (b.moveToFirst()) {
                        if (!b.isNull(0)) {
                            l = Long.valueOf(b.getLong(0));
                        }
                    }
                    return l;
                } finally {
                    b.close();
                    e.f();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public qe6<PendingSuperPass> getPendingSuperPass(String str) {
        final yl e = yl.e("SELECT * FROM pending_super_pass_table where pending_super_pass_properties_pass_id = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.a(this.__db, false, new String[]{"pending_super_pass_table"}, new Callable<PendingSuperPass>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass37 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:102:0x02a4 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:103:0x02a7 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:106:0x02b7 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:107:0x02b9 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:110:0x02cd A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:111:0x02cf A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:114:0x02e7 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:115:0x02ea A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:118:0x02f6 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:119:0x02f9 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:122:0x0305 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:123:0x0308 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x0314 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x0351 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:146:0x0354 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:149:0x0360 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:150:0x0363 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:153:0x036f A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:154:0x0372 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:157:0x0388 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:158:0x038b A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:161:0x0397 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:162:0x039a A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x03a6 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:166:0x03a9 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:170:0x03c0 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:180:0x03e4 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:186:0x03fa A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:187:0x03fd A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:190:0x0409 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:191:0x040b A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:195:0x0428 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:200:0x0439 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:204:0x044a A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x0477 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:223:0x0487 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:224:0x048a A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:227:0x0496 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:228:0x0499 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:231:0x04b1 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:232:0x04b4 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:236:0x04c5 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:242:0x04d8 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:246:0x04e2 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:247:0x04e4 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:250:0x04ee A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:251:0x04f0 A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:254:0x04fa A[Catch:{ all -> 0x0514 }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x04fc A[Catch:{ all -> 0x0514 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1305
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass37.call():app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass");
            }
        });
    }

    @Override // app.zophop.room.SuperPassDao
    public LiveData<List<MagicSuperPass>> getRecentActiveMagicSuperPasses(String str, long j) {
        final yl e = yl.e("SELECT * FROM magic_super_pass_table where super_pass_properties_city_name = ? and super_pass_validation_properties_start_time < ? and super_pass_validation_properties_expiry_time > ? and (super_pass_validation_properties_super_pass_status = 'UNUSED' OR super_pass_validation_properties_super_pass_status = 'USED') ORDER BY super_pass_ui_properties_booking_time DESC limit 5", 3);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        e.d0(2, j);
        e.d0(3, j);
        return this.__db.getInvalidationTracker().b(new String[]{"magic_super_pass_table"}, false, new Callable<List<MagicSuperPass>>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass43 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:128:0x03d7 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:135:0x040d A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:136:0x0413 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:139:0x042d A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x042f A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:143:0x0447 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:144:0x044a A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:147:0x0456 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x0459 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:151:0x0465 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:152:0x0468 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:155:0x0474 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:172:0x04ab A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x04ae A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:176:0x04ba A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x04bd A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:180:0x04c9 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x04cc A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:184:0x04e4 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x04e7 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:188:0x04f3 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:189:0x04f6 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:192:0x0502 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:193:0x0505 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:197:0x051c A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:210:0x055b A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:215:0x0577 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x057a A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:219:0x0586 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:220:0x058c A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:224:0x05af A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:229:0x05c0 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:233:0x05d3 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:249:0x0620 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x0636 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:257:0x0639 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x0645 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:261:0x0648 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x065c A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:265:0x065f A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x0667 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:269:0x066a A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:273:0x067f A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:277:0x0693 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:280:0x069d A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:281:0x06a1 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:284:0x06af A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:285:0x06b5 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x0244 A[Catch:{ all -> 0x0722 }] */
            /* JADX WARNING: Removed duplicated region for block: B:71:0x027c A[Catch:{ all -> 0x0722 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.models.mTicketing.superPass.MagicSuperPass> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1831
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass43.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.SuperPassDao
    public LiveData<List<RideBasedSuperPass>> getRecentActiveRideBasedSuperPasses(String str, long j) {
        final yl e = yl.e("SELECT * FROM ride_based_super_pass_table where super_pass_properties_city_name = ? and super_pass_validation_properties_start_time < ? and super_pass_validation_properties_expiry_time > ? and (super_pass_validation_properties_super_pass_status = 'UNUSED' OR super_pass_validation_properties_super_pass_status = 'USED') ORDER BY super_pass_ui_properties_booking_time DESC limit 5", 3);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        e.d0(2, j);
        e.d0(3, j);
        return this.__db.getInvalidationTracker().b(new String[]{"ride_based_super_pass_table"}, false, new Callable<List<RideBasedSuperPass>>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass44 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:106:0x0364 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x039e A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:122:0x03a1 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:125:0x03b1 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:126:0x03b7 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:129:0x03d1 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:130:0x03d3 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:133:0x03eb A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:134:0x03ee A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:137:0x03fa A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:138:0x03fd A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:141:0x0409 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:142:0x040c A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:145:0x0418 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:165:0x0462 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:166:0x0465 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x0471 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:170:0x0474 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x0480 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:174:0x0485 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:177:0x049f A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:178:0x04a2 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:181:0x04ae A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:182:0x04b1 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:185:0x04bd A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:186:0x04c0 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:190:0x04d7 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:202:0x0510 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:207:0x052c A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:208:0x052f A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:211:0x053b A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:212:0x0541 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x0564 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:221:0x0575 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:225:0x0588 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:242:0x05de A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:248:0x05fa A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:249:0x05fd A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x0609 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:253:0x060c A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x0618 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:257:0x061b A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x0627 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:261:0x062c A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x0644 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:265:0x0647 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x0653 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:269:0x0656 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:273:0x066d A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:288:0x06be A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:294:0x06d6 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:295:0x06d9 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:298:0x06e5 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:299:0x06e8 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:302:0x06fc A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:303:0x06ff A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:306:0x0707 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:307:0x070a A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:311:0x071f A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:315:0x0733 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:318:0x073d A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:319:0x0741 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:322:0x074f A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:323:0x0755 A[Catch:{ all -> 0x07d6 }] */
            /* JADX WARNING: Removed duplicated region for block: B:53:0x0259 A[Catch:{ all -> 0x07d6 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.util.List<app.zophop.models.mTicketing.superPass.RideBasedSuperPass> call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 2011
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass44.call():java.util.List");
            }
        });
    }

    @Override // app.zophop.room.SuperPassDao
    public qe6<RideBasedSuperPass> getRideBasedSuperPass(String str) {
        final yl e = yl.e("SELECT * FROM ride_based_super_pass_table where super_pass_properties_pass_id = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.a(this.__db, false, new String[]{"ride_based_super_pass_table"}, new Callable<RideBasedSuperPass>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass40 */

            @Override // java.lang.Object
            public void finalize() {
                e.f();
            }

            /* JADX WARNING: Removed duplicated region for block: B:127:0x039e A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:128:0x03a1 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:131:0x03b1 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:132:0x03b3 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:135:0x03c7 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:136:0x03c9 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:139:0x03e1 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:140:0x03e4 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:143:0x03f0 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:144:0x03f3 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:147:0x03ff A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:148:0x0402 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:151:0x040e A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:170:0x044b A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:171:0x044e A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:174:0x045a A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:175:0x045d A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:178:0x0469 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:179:0x046c A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:182:0x0482 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:183:0x0485 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:186:0x0491 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:187:0x0494 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:190:0x04a0 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:191:0x04a3 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:195:0x04ba A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:205:0x04de A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:211:0x04f4 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:212:0x04f7 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:215:0x0503 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:216:0x0505 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:220:0x0522 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:225:0x0533 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:229:0x0545 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:243:0x057b A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:251:0x058d A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:252:0x0590 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:255:0x059c A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:256:0x059f A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:259:0x05ab A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:260:0x05ae A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:263:0x05ba A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:264:0x05bd A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:267:0x05d3 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:268:0x05d6 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:271:0x05e2 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:272:0x05e5 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:276:0x05fb A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:288:0x0628 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:295:0x0638 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:296:0x063b A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:299:0x0647 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:300:0x064a A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:303:0x065e A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:304:0x0661 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:307:0x0669 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:308:0x066c A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:312:0x067e A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:316:0x0689 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:319:0x0691 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:320:0x0693 A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:323:0x069d A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:324:0x069f A[Catch:{ all -> 0x06b7 }] */
            /* JADX WARNING: Removed duplicated region for block: B:52:0x0246 A[Catch:{ all -> 0x06b7 }] */
            @Override // java.util.concurrent.Callable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public app.zophop.models.mTicketing.superPass.RideBasedSuperPass call() throws java.lang.Exception {
                /*
                // Method dump skipped, instructions count: 1724
                */
                throw new UnsupportedOperationException("Method not decompiled: app.zophop.room.SuperPassDao_Impl.AnonymousClass40.call():app.zophop.models.mTicketing.superPass.RideBasedSuperPass");
            }
        });
    }

    @Override // app.zophop.room.SuperPassDao
    public Object getRideBasedSuperPassCount(String str, k66<? super Integer> k66) {
        final yl e = yl.e("SELECT COUNT (DISTINCT super_pass_properties_pass_id) FROM ride_based_super_pass_table where super_pass_properties_city_name = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.b(this.__db, false, new CancellationSignal(), new Callable<Integer>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass39 */

            @Override // java.util.concurrent.Callable
            public Integer call() throws Exception {
                Integer num = null;
                Cursor b = hm.b(SuperPassDao_Impl.this.__db, e, false, null);
                try {
                    if (b.moveToFirst()) {
                        if (!b.isNull(0)) {
                            num = Integer.valueOf(b.getInt(0));
                        }
                    }
                    return num;
                } finally {
                    b.close();
                    e.f();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object getRideBasedSuperPassRideDetails(String str, k66<? super RideBasedSuperPassRideDetailsRoom> k66) {
        final yl e = yl.e("SELECT * FROM ride_based_super_pass_ride_details_table WHERE pass_id = ?", 1);
        if (str == null) {
            e.E0(1);
        } else {
            e.z(1, str);
        }
        return ml.b(this.__db, false, new CancellationSignal(), new Callable<RideBasedSuperPassRideDetailsRoom>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass48 */

            @Override // java.util.concurrent.Callable
            public RideBasedSuperPassRideDetailsRoom call() throws Exception {
                String str;
                RideBasedSuperPassRideDetailsRoom rideBasedSuperPassRideDetailsRoom = null;
                String str2 = null;
                Cursor b = hm.b(SuperPassDao_Impl.this.__db, e, false, null);
                try {
                    int L = h.L(b, "pass_id");
                    int L2 = h.L(b, "previous_ride_time_stamps");
                    int L3 = h.L(b, "is_activation_allowed_in_current_session");
                    int L4 = h.L(b, "oldest_history_call_time_stamp");
                    int L5 = h.L(b, "last_activation_time_stamp");
                    int L6 = h.L(b, "last_punch_time_stamp");
                    if (b.moveToFirst()) {
                        if (b.isNull(L)) {
                            str = null;
                        } else {
                            str = b.getString(L);
                        }
                        if (!b.isNull(L2)) {
                            str2 = b.getString(L2);
                        }
                        rideBasedSuperPassRideDetailsRoom = new RideBasedSuperPassRideDetailsRoom(str, SuperPassDao_Impl.this.__customTypeConverters.fromLong(str2), b.getInt(L3) != 0, b.getLong(L4), b.getLong(L5), b.getLong(L6));
                    }
                    return rideBasedSuperPassRideDetailsRoom;
                } finally {
                    b.close();
                    e.f();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object insertMagicSuperPass(final MagicSuperPass magicSuperPass, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass17 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    SuperPassDao_Impl.this.__insertionAdapterOfMagicSuperPass.insert(magicSuperPass);
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object insertMagicSuperPassList(final List<MagicSuperPass> list, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass20 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    SuperPassDao_Impl.this.__insertionAdapterOfMagicSuperPass.insert((Iterable) list);
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object insertPendingSuperPassList(final List<PendingSuperPass> list, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass18 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    SuperPassDao_Impl.this.__insertionAdapterOfPendingSuperPass.insert((Iterable) list);
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object insertRideBasedSuperPass(final RideBasedSuperPass rideBasedSuperPass, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass22 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    SuperPassDao_Impl.this.__insertionAdapterOfRideBasedSuperPass.insert(rideBasedSuperPass);
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object insertRideBasedSuperPassList(final List<RideBasedSuperPass> list, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass21 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    SuperPassDao_Impl.this.__insertionAdapterOfRideBasedSuperPass.insert((Iterable) list);
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object insertRideBasedSuperPassRideDetails(final RideBasedSuperPassRideDetailsRoom rideBasedSuperPassRideDetailsRoom, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass23 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    SuperPassDao_Impl.this.__insertionAdapterOfRideBasedSuperPassRideDetailsRoom.insert(rideBasedSuperPassRideDetailsRoom);
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object insertSuperPassApplication(final SuperPassApplication superPassApplication, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass16 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    SuperPassDao_Impl.this.__insertionAdapterOfSuperPassApplication.insert(superPassApplication);
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object insertSuperPassApplicationsList(final List<SuperPassApplication> list, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass19 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    SuperPassDao_Impl.this.__insertionAdapterOfSuperPassApplication.insert((Iterable) list);
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object updateMagicSuperPassLastActivationTimeStamp(final String str, final long j, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass32 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfUpdateMagicSuperPassLastActivationTimeStamp.acquire();
                acquire.d0(1, j);
                String str = str;
                if (str == null) {
                    acquire.E0(2);
                } else {
                    acquire.z(2, str);
                }
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfUpdateMagicSuperPassLastActivationTimeStamp.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object updateRideBasedSuperPass(final List<Long> list, final long j, final String str, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass29 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfUpdateRideBasedSuperPass.acquire();
                String str = SuperPassDao_Impl.this.__customTypeConverters.toLong(list);
                if (str == null) {
                    acquire.E0(1);
                } else {
                    acquire.z(1, str);
                }
                acquire.d0(2, j);
                String str2 = str;
                if (str2 == null) {
                    acquire.E0(3);
                } else {
                    acquire.z(3, str2);
                }
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfUpdateRideBasedSuperPass.release(acquire);
                }
            }
        }, k66);
    }

    @Override // app.zophop.room.SuperPassDao
    public Object updateRideBasedSuperPassRideDetails(final List<Long> list, final boolean z, final String str, final long j, final long j2, k66<? super s56> k66) {
        return ml.c(this.__db, true, new Callable<s56>() {
            /* class app.zophop.room.SuperPassDao_Impl.AnonymousClass33 */

            @Override // java.util.concurrent.Callable
            public s56 call() throws Exception {
                sm acquire = SuperPassDao_Impl.this.__preparedStmtOfUpdateRideBasedSuperPassRideDetails.acquire();
                String str = SuperPassDao_Impl.this.__customTypeConverters.toLong(list);
                if (str == null) {
                    acquire.E0(1);
                } else {
                    acquire.z(1, str);
                }
                acquire.d0(2, z ? 1 : 0);
                acquire.d0(3, j);
                acquire.d0(4, j2);
                String str2 = str;
                if (str2 == null) {
                    acquire.E0(5);
                } else {
                    acquire.z(5, str2);
                }
                SuperPassDao_Impl.this.__db.beginTransaction();
                try {
                    acquire.F();
                    SuperPassDao_Impl.this.__db.setTransactionSuccessful();
                    return s56.f3190a;
                } finally {
                    SuperPassDao_Impl.this.__db.endTransaction();
                    SuperPassDao_Impl.this.__preparedStmtOfUpdateRideBasedSuperPassRideDetails.release(acquire);
                }
            }
        }, k66);
    }
}
