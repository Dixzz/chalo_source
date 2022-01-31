package app.zophop.ui.viewmodels.superpassPurchase;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import app.zophop.models.Agency;
import app.zophop.models.City;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.Gender;
import app.zophop.models.mTicketing.PassApplicationActionRequired;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.ProductBranding;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.models.mTicketing.ProofRejectionReason;
import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.models.mTicketing.ProofUploadStatus;
import app.zophop.models.mTicketing.RejectionStatus;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.models.mTicketing.superPass.MagicSuperPass;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassRideDetails;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassUIProperties;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPassValidationProperties;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.models.mTicketing.superPass.SuperPassOrderDetails;
import app.zophop.models.mTicketing.superPass.SuperPassProofProperties;
import app.zophop.models.mTicketing.superPass.SuperPassProperties;
import app.zophop.models.mTicketing.superPass.SuperPassRepurchaseProperties;
import app.zophop.models.mTicketing.superPass.SuperPassRideDetails;
import app.zophop.models.mTicketing.superPass.SuperPassStatus;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.SuperPassTransactionDetails;
import app.zophop.models.mTicketing.superPass.SuperPassUIProperties;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.models.mTicketing.superPass.SuperPassValidationProperties;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.CoroutineExceptionHandler;
import server.zophop.queue.TaskKeys;

/* compiled from: SuperPassPurchaseSharedViewModel.kt */
public final class SuperPassPurchaseSharedViewModel extends zh {
    public final wh c;
    public final m66 d;
    public final String e;
    public final String f;
    public final boolean g;
    public final PassApplicationActionRequired h;
    public final PassApplicationRejectionReasons i;
    public final String j;
    public SuperPassUserDetails k;
    public final BookableSuperPassConfiguration l;
    public long m;
    public final long n;
    public String o;
    public String p;
    public SuperPassOrderDetails q;
    public String r;
    public boolean s;
    public Agency t;
    public final List<ProofDocumentProps> u;
    public final j56 v;

    /* compiled from: SuperPassPurchaseSharedViewModel.kt */
    public static final class a extends kg {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(mm mmVar, Bundle bundle) {
            super(mmVar, bundle);
            n86.e(mmVar, TaskKeys.OWNER);
        }

        @Override // defpackage.kg
        public <T extends zh> T d(String str, Class<T> cls, wh whVar) {
            n86.e(str, AnalyticsConstants.KEY);
            n86.e(cls, "modelClass");
            n86.e(whVar, "handle");
            return new SuperPassPurchaseSharedViewModel(whVar);
        }
    }

    /* compiled from: SuperPassPurchaseSharedViewModel.kt */
    public static final class b extends o86 implements h76<oh<Map<String, ProofUploadDetails>>> {
        public final /* synthetic */ SuperPassPurchaseSharedViewModel f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel) {
            super(0);
            this.f = superPassPurchaseSharedViewModel;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Map<String, ProofUploadDetails>> invoke() {
            List<ProofRejectionReason> proofRejectionReasonsList;
            SuperPassPurchaseSharedViewModel superPassPurchaseSharedViewModel = this.f;
            wh whVar = superPassPurchaseSharedViewModel.c;
            HashMap hashMap = new HashMap();
            for (ProofDocumentProps proofDocumentProps : superPassPurchaseSharedViewModel.u) {
                hashMap.put(proofDocumentProps.getProofId(), new ProofUploadDetails(null, null, null, null, false, 31, null));
            }
            PassApplicationRejectionReasons passApplicationRejectionReasons = superPassPurchaseSharedViewModel.i;
            if (!(passApplicationRejectionReasons == null || (proofRejectionReasonsList = passApplicationRejectionReasons.getProofRejectionReasonsList()) == null)) {
                for (ProofRejectionReason proofRejectionReason : proofRejectionReasonsList) {
                    if (proofRejectionReason.getStatus() == RejectionStatus.VALID) {
                        hashMap.put(proofRejectionReason.getProofId(), new ProofUploadDetails(proofRejectionReason.getLProofUrl(), "", "", ProofUploadStatus.UPLOAD_SUCCESSFUL, false));
                    }
                }
            }
            return whVar.a("keyProofUploadDetailsMap", hashMap);
        }
    }

    public SuperPassPurchaseSharedViewModel(wh whVar) {
        String name;
        Map<TransitMode, List<Agency>> modeAgencyMap;
        List<Agency> list;
        n86.e(whVar, "savedStateHandle");
        this.c = whVar;
        kb6 kb6 = xb6.b;
        int i2 = CoroutineExceptionHandler.d;
        this.d = kb6.plus(new lh1(CoroutineExceptionHandler.a.f));
        Object obj = whVar.f3779a.get("keySource");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<String>(KEY_SOURCE)!!");
        this.e = (String) obj;
        Object obj2 = whVar.f3779a.get("keyPurchaseFlowType");
        n86.c(obj2);
        n86.d(obj2, "savedStateHandle.get<Str…KEY_PURCHASE_FLOW_TYPE)!!");
        this.f = (String) obj2;
        Object obj3 = whVar.f3779a.get("keyIsVerificationRequired");
        n86.c(obj3);
        n86.d(obj3, "savedStateHandle.get<Boo…_VERIFICATION_REQUIRED)!!");
        this.g = ((Boolean) obj3).booleanValue();
        PassApplicationActionRequired passApplicationActionRequired = (PassApplicationActionRequired) whVar.f3779a.get("keyPassApplicationActionRequired");
        this.h = passApplicationActionRequired == null ? PassApplicationActionRequired.FRESH : passApplicationActionRequired;
        this.i = (PassApplicationRejectionReasons) whVar.f3779a.get("keySuperPassApplicationRejectionReasons");
        this.j = (String) whVar.f3779a.get("keySuperPassIdForRenew");
        SuperPassUserDetails superPassUserDetails = (SuperPassUserDetails) whVar.f3779a.get("keySuperPassUserDetails");
        this.k = superPassUserDetails == null ? new SuperPassUserDetails(null, null, null, Gender.MALE, null, null, null, 119, null) : superPassUserDetails;
        Object obj4 = whVar.f3779a.get("keyBookablePassConfig");
        n86.c(obj4);
        n86.d(obj4, "savedStateHandle.get<Boo…ABLE_SUPER_PASS_CONFIG)!!");
        BookableSuperPassConfiguration bookableSuperPassConfiguration = (BookableSuperPassConfiguration) obj4;
        this.l = bookableSuperPassConfiguration;
        Long l2 = (Long) whVar.f3779a.get("keyStartTime");
        this.m = l2 == null ? ui1.Q() : l2.longValue();
        Long l3 = (Long) whVar.f3779a.get("keyPassVerificationExpiryTime");
        this.n = l3 == null ? -1 : l3.longValue();
        String str = (String) whVar.f3779a.get("keyQrCode");
        this.o = str == null ? new String() : str;
        String str2 = (String) whVar.f3779a.get("keyTone");
        this.p = str2 == null ? new String() : str2;
        this.q = (SuperPassOrderDetails) whVar.f3779a.get("keySuperPassOrderDetails");
        String str3 = (String) whVar.f3779a.get("keyReferenceIdForCashPayment");
        this.r = str3 == null ? new String() : str3;
        Boolean bool = (Boolean) whVar.f3779a.get("keyIsAgencyAvailable");
        boolean z = true;
        this.s = bool == null ? true : bool.booleanValue();
        String productAgency = bookableSuperPassConfiguration.getSuperPassProductConfigurationProperties().getProductAgency();
        City d2 = xt.f3961a.k().d();
        if (!(d2 == null || (modeAgencyMap = d2.getModeAgencyMap()) == null || (list = modeAgencyMap.get(TransitMode.bus)) == null)) {
            for (Agency agency : list) {
                if (ea6.f(productAgency, agency.getAgencyName(), true)) {
                    this.t = agency;
                }
            }
        }
        boolean z2 = this.t != null;
        this.s = z2;
        if (!z2) {
            this.c.b("keyIsAgencyAvailable", Boolean.FALSE);
            this.u = new ArrayList();
        } else {
            List<String> requiredProofsList = this.l.getRequiredProofsList();
            Agency agency2 = this.t;
            n86.c(agency2);
            String agencyName = agency2.getAgencyName();
            n86.d(agencyName, "agency!!.agencyName");
            ArrayList arrayList = new ArrayList();
            if (requiredProofsList != null && !requiredProofsList.isEmpty()) {
                z = false;
            }
            if (!z) {
                City d3 = xt.f3961a.k().d();
                String str4 = null;
                if (!(d3 == null || (name = d3.getName()) == null)) {
                    str4 = name.toLowerCase();
                    n86.d(str4, "(this as java.lang.String).toLowerCase()");
                }
                for (String str5 : requiredProofsList) {
                    ProofDocumentProps J = xt.f3961a.c().J(str4, agencyName, str5);
                    if (J != null) {
                        arrayList.add(J);
                    }
                }
            }
            this.u = arrayList;
            this.c.b("keyIsAgencyAvailable", Boolean.TRUE);
        }
        this.v = hd3.a2(new b(this));
    }

    public final LiveData<Map<String, ProofUploadDetails>> d() {
        Object value = this.v.getValue();
        n86.d(value, "<get-proofUploadDetailsMap>(...)");
        return (LiveData) value;
    }

    public final Map<String, SuperPassProofProperties> e() {
        String str;
        HashMap hashMap = new HashMap();
        for (Map.Entry entry : ((HashMap) g()).entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            Iterator<ProofDocumentProps> it = this.u.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = new String();
                    break;
                }
                ProofDocumentProps next = it.next();
                if (n86.a(str2, next.getProofId())) {
                    str = next.getProofName();
                    break;
                }
            }
            hashMap.put(str2, new SuperPassProofProperties(str, str3));
        }
        return hashMap;
    }

    public final SuperPassProperties f(SuperPassSubType superPassSubType) {
        SuperPassOrderDetails superPassOrderDetails = this.q;
        n86.c(superPassOrderDetails);
        String transactionId = superPassOrderDetails.getTransactionId();
        String productCity = this.l.getSuperPassProductConfigurationProperties().getProductCity();
        Agency agency = this.t;
        n86.c(agency);
        String agencyName = agency.getAgencyName();
        n86.d(agencyName, "agency!!.agencyName");
        return new SuperPassProperties(transactionId, SuperPassConstants.PRODUCT_TYPE_SUPER_PASS, superPassSubType, productCity, agencyName, this.o, this.p);
    }

    public final Map<String, String> g() {
        Map<String, ProofUploadDetails> d2 = d().d();
        HashMap hashMap = new HashMap();
        if (d2 != null) {
            for (Map.Entry<String, ProofUploadDetails> entry : d2.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().getUploadedProofUrl());
            }
        }
        return hashMap;
    }

    public final void h(Context context) {
        n86.e(context, "lContext");
        if (n86.a(this.f, "flowPaymentPostVerification")) {
            y60.f(this.k, this.l, this.m, context);
        } else if (n86.a(this.f, "flowRenewPass")) {
            SuperPassUserDetails superPassUserDetails = this.k;
            BookableSuperPassConfiguration bookableSuperPassConfiguration = this.l;
            String str = this.j;
            n86.c(str);
            y60.e(superPassUserDetails, bookableSuperPassConfiguration, str, this.m, context);
        } else if ((!n86.a(this.f, "flowFreshPurchase") || !this.g) && !n86.a(this.f, "flowReapplication")) {
            hd3.Y1(h.Z(this), this.d, null, new ea1(this, context, null), 2, null);
        } else {
            y60.l(this.k, this.l, this.m, g(), context);
        }
    }

    public final void i(String str, String str2, String str3, String str4, ProofUploadStatus proofUploadStatus) {
        ProofUploadDetails proofUploadDetails;
        n86.e(str, "lProofId");
        n86.e(str2, "lProofImageLocalUri");
        n86.e(str3, "lUploadedProofUri");
        n86.e(str4, "lUploadRequestId");
        n86.e(proofUploadStatus, "lUploadStatus");
        Map<String, ProofUploadDetails> d2 = d().d();
        if (d2 != null && (proofUploadDetails = d2.get(str)) != null && n86.a(proofUploadDetails.getUploadRequestId(), str4)) {
            d2.put(str, new ProofUploadDetails(str3, str2, str4, proofUploadStatus, false, 16, null));
            this.c.b("keyProofUploadDetailsMap", d2);
        }
    }

    public final void j(String str, String str2, String str3, String str4, Bitmap bitmap) {
        n86.e(str, "lProofId");
        n86.e(str2, "lProofImageLocalUri");
        n86.e(str3, "lUploadedProofUri");
        n86.e(str4, "lUploadRequestId");
        n86.e(bitmap, "lBitmap");
        xt.f3961a.c().H(bitmap, str2, str4, str);
        Map<String, ProofUploadDetails> d2 = d().d();
        if (d2 != null) {
            d2.put(str, new ProofUploadDetails(str3, str2, str4, ProofUploadStatus.UPLOADING, false, 16, null));
            this.c.b("keyProofUploadDetailsMap", d2);
        }
    }

    public final void k() {
        UserProfile e2 = xt.f3961a.L().e();
        SuperPassUserDetails.Companion companion = SuperPassUserDetails.Companion;
        n86.d(e2, "lUserProfile");
        SuperPassUserDetails superPassUserDetailsFromUserProfile = companion.getSuperPassUserDetailsFromUserProfile(e2, this.k);
        this.k = superPassUserDetailsFromUserProfile;
        this.c.b("keySuperPassUserDetails", superPassUserDetailsFromUserProfile);
    }

    public final void onPaymentCompleted(String str, String str2, String str3, Context context) {
        n86.e(str, "lQrCode");
        n86.e(str2, "lTone");
        n86.e(str3, "lPaymentMode");
        n86.e(context, "lContext");
        this.o = str;
        this.p = str2;
        this.c.b("keyQrCode", str);
        this.c.b("keyTone", str2);
        BookableSuperPassConfiguration bookableSuperPassConfiguration = this.l;
        String configId = bookableSuperPassConfiguration.getConfigId();
        String categoryId = bookableSuperPassConfiguration.getSelectedProductCategory().getCategoryId();
        n86.d(categoryId, "selectedProductCategory.categoryId");
        SuperPassRepurchaseProperties superPassRepurchaseProperties = new SuperPassRepurchaseProperties(configId, categoryId, bookableSuperPassConfiguration.getSelectedProductFareMapping().getFareMappingId(), this.n, bookableSuperPassConfiguration.isVerificationRequired(), bookableSuperPassConfiguration.isRenewable());
        SuperPassOrderDetails superPassOrderDetails = this.q;
        n86.c(superPassOrderDetails);
        SuperPassTransactionDetails superPassTransactionDetails = new SuperPassTransactionDetails(superPassOrderDetails.getTransactionId(), str3);
        if (n86.a(this.l.getSuperPassProductConfigurationProperties().getProductSubType(), "magicPass")) {
            SuperPassProperties f2 = f(SuperPassSubType.MAGIC_SUPER_PASS);
            SuperPassStatus superPassStatus = SuperPassStatus.UNUSED;
            long j2 = this.m;
            SuperPassOrderDetails superPassOrderDetails2 = this.q;
            n86.c(superPassOrderDetails2);
            SuperPassValidationProperties superPassValidationProperties = new SuperPassValidationProperties(superPassStatus, j2, superPassOrderDetails2.getExpiryTime(), this.l.getSuperPassProductConfigurationProperties().getProductActivationDuration(), new SuperPassRideDetails(0, 0, 3, null));
            Map<String, SuperPassProofProperties> e2 = e();
            SuperPassProofProperties superPassProofProperties = (SuperPassProofProperties) ((HashMap) e2).get("PHOTOGRAPH");
            String proofUrl = superPassProofProperties == null ? null : superPassProofProperties.getProofUrl();
            if (proofUrl == null) {
                proofUrl = this.k.getProfilePhoto();
            }
            this.k.setProfilePhoto(proofUrl);
            int noOfDays = this.l.getSelectedProductFareMapping().getNoOfDays();
            List<String> specialFeatures = this.l.getSelectedProductFareMapping().getSpecialFeatures();
            n86.d(specialFeatures, "bookablePassConfig.selec…reMapping.specialFeatures");
            SuperPassUserDetails superPassUserDetails = this.k;
            SuperPassOrderDetails superPassOrderDetails3 = this.q;
            n86.c(superPassOrderDetails3);
            long bookingTime = superPassOrderDetails3.getBookingTime();
            FareInfo fareInfo = this.l.getSelectedProductFareMapping().getFareInfo();
            n86.d(fareInfo, "bookablePassConfig.selec…oductFareMapping.fareInfo");
            String productName = this.l.getSuperPassProductConfigurationProperties().getProductName();
            String str4 = this.l.getSelectedProductCategory().get_categoryName();
            n86.d(str4, "bookablePassConfig.selec…uctCategory._categoryName");
            ProductBranding branding = this.l.getSuperPassProductConfigurationProperties().getBranding();
            String durationDisplayName = this.l.getSelectedProductFareMapping().getDurationDisplayName();
            n86.d(durationDisplayName, "bookablePassConfig.selec…pping.durationDisplayName");
            xt.f3961a.e0().insertMagicSuperPass(new MagicSuperPass(f2, superPassValidationProperties, new SuperPassUIProperties(noOfDays, specialFeatures, superPassUserDetails, e2, bookingTime, fareInfo, productName, str4, branding, durationDisplayName), superPassRepurchaseProperties, superPassTransactionDetails));
        } else if (n86.a(this.l.getSuperPassProductConfigurationProperties().getProductSubType(), SuperPassConstants.SUBTYPE_RIDE_PASS)) {
            SuperPassProperties f3 = f(SuperPassSubType.RIDE_BASED_SUPER_PASS);
            RideBasedSuperPassRideDetails rideBasedSuperPassRideDetailsForFreshPurchase = RideBasedSuperPassRideDetails.Companion.getRideBasedSuperPassRideDetailsForFreshPurchase();
            SuperPassStatus superPassStatus2 = SuperPassStatus.UNUSED;
            long j3 = this.m;
            SuperPassOrderDetails superPassOrderDetails4 = this.q;
            n86.c(superPassOrderDetails4);
            RideBasedSuperPassValidationProperties rideBasedSuperPassValidationProperties = new RideBasedSuperPassValidationProperties(superPassStatus2, j3, superPassOrderDetails4.getExpiryTime(), this.l.getSuperPassProductConfigurationProperties().getProductActivationDuration(), this.l.getSelectedProductFareMapping().getMaxRidesPerDay(), this.l.getSelectedProductFareMapping().getMaxRides(), rideBasedSuperPassRideDetailsForFreshPurchase);
            BookableSuperPassConfiguration bookableSuperPassConfiguration2 = this.l;
            int noOfDays2 = bookableSuperPassConfiguration2.getSelectedProductFareMapping().getNoOfDays();
            List<String> specialFeatures2 = bookableSuperPassConfiguration2.getSelectedProductFareMapping().getSpecialFeatures();
            n86.d(specialFeatures2, "selectedProductFareMapping.specialFeatures");
            SuperPassUserDetails superPassUserDetails2 = this.k;
            Map<String, SuperPassProofProperties> e3 = e();
            SuperPassOrderDetails superPassOrderDetails5 = this.q;
            n86.c(superPassOrderDetails5);
            long bookingTime2 = superPassOrderDetails5.getBookingTime();
            FareInfo fareInfo2 = bookableSuperPassConfiguration2.getSelectedProductFareMapping().getFareInfo();
            n86.d(fareInfo2, "selectedProductFareMapping.fareInfo");
            double maxPricePerRide = bookableSuperPassConfiguration2.getSelectedProductFareMapping().getMaxPricePerRide();
            String productName2 = bookableSuperPassConfiguration2.getSuperPassProductConfigurationProperties().getProductName();
            String str5 = bookableSuperPassConfiguration2.getSelectedProductCategory().get_categoryName();
            n86.d(str5, "selectedProductCategory._categoryName");
            ProductBranding branding2 = bookableSuperPassConfiguration2.getSuperPassProductConfigurationProperties().getBranding();
            String durationDisplayName2 = bookableSuperPassConfiguration2.getSelectedProductFareMapping().getDurationDisplayName();
            n86.d(durationDisplayName2, "selectedProductFareMapping.durationDisplayName");
            String desc = bookableSuperPassConfiguration2.getSelectedProductFareMapping().getDesc();
            n86.d(desc, "selectedProductFareMapping.desc");
            xt.f3961a.e0().insertRideBasedSuperPass(new RideBasedSuperPass(f3, rideBasedSuperPassValidationProperties, new RideBasedSuperPassUIProperties(noOfDays2, specialFeatures2, superPassUserDetails2, e3, bookingTime2, fareInfo2, maxPricePerRide, productName2, str5, branding2, durationDisplayName2, desc), superPassRepurchaseProperties, superPassTransactionDetails));
        }
    }
}
