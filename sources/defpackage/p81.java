package defpackage;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import app.zophop.models.Agency;
import app.zophop.models.City;
import app.zophop.models.RouteInfo;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.PassApplicationRejectionReasons;
import app.zophop.models.mTicketing.ProductCategory;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.models.mTicketing.ProductFareMapping;
import app.zophop.models.mTicketing.ProofDocumentProps;
import app.zophop.models.mTicketing.ProofRejectionReason;
import app.zophop.models.mTicketing.ProofUploadDetails;
import app.zophop.models.mTicketing.ProofUploadStatus;
import app.zophop.models.mTicketing.RejectionStatus;
import app.zophop.models.mTicketing.UserProfile;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlinx.coroutines.CoroutineExceptionHandler;
import server.zophop.queue.TaskKeys;

/* renamed from: p81  reason: default package */
/* compiled from: MPassPurchaseSharedViewModel.kt */
public final class p81 extends zh {
    public final wh c;
    public final m66 d;
    public final String e;
    public final String f;
    public MPass g;
    public final j56 h = hd3.a2(new c(this));
    public boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final ProductConfiguration n;
    public final ProductCategory o;
    public final ProductFareMapping p;
    public Agency q;
    public final List<ProofDocumentProps> r;
    public final j56 s;

    /* renamed from: p81$a */
    /* compiled from: MPassPurchaseSharedViewModel.kt */
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
            return new p81(whVar);
        }
    }

    /* renamed from: p81$b */
    /* compiled from: MPassPurchaseSharedViewModel.kt */
    public static final class b extends o86 implements h76<oh<Map<String, ProofUploadDetails>>> {
        public final /* synthetic */ p81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(p81 p81) {
            super(0);
            this.f = p81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Map<String, ProofUploadDetails>> invoke() {
            List<ProofRejectionReason> proofRejectionReasonsList;
            p81 p81 = this.f;
            wh whVar = p81.c;
            HashMap hashMap = new HashMap();
            List<ProofDocumentProps> list = p81.r;
            if (list != null) {
                for (ProofDocumentProps proofDocumentProps : list) {
                    hashMap.put(proofDocumentProps.getProofId(), new ProofUploadDetails(null, null, null, null, false, 31, null));
                }
            }
            PassApplicationRejectionReasons passApplicationRejectionReasons = p81.g.get_passApplicationRejectionReasons();
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

    /* renamed from: p81$c */
    /* compiled from: MPassPurchaseSharedViewModel.kt */
    public static final class c extends o86 implements h76<oh<UserProfile>> {
        public final /* synthetic */ p81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(p81 p81) {
            super(0);
            this.f = p81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<UserProfile> invoke() {
            return this.f.c.a("keyUserProfile", null);
        }
    }

    public p81(wh whVar) {
        List<ProductFareMapping> list;
        String name;
        String str;
        String name2;
        Map<TransitMode, List<Agency>> modeAgencyMap;
        List<Agency> list2;
        Map<String, List<ProductFareMapping>> productFareMapping;
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
        Object obj3 = whVar.f3779a.get("keyMPass");
        n86.c(obj3);
        n86.d(obj3, "savedStateHandle.get<MPass>(KEY_MPASS)!!");
        this.g = (MPass) obj3;
        RouteInfo routeInfo = (RouteInfo) whVar.f3779a.get("keyRouteInfo");
        Boolean bool = (Boolean) whVar.f3779a.get("keyIsCompleteProductConfigurationAvailable");
        boolean z = true;
        this.i = bool == null ? true : bool.booleanValue();
        ProductConfiguration m0 = vn.m0(this.g.getConfigId());
        this.n = m0;
        String str2 = null;
        ProductCategory k0 = vn.k0(m0 == null ? null : m0.getProductCategoryList(), this.g.getPassengerType());
        this.o = k0;
        if (m0 == null || (productFareMapping = m0.getProductFareMapping()) == null) {
            list = null;
        } else {
            list = productFareMapping.get(k0 == null ? null : k0.getCategoryId());
        }
        this.p = vn.o0(this.g.getSpecialFeatures(), list, ui1.i(this.g.getNoOfDays()));
        String agency = this.g.getAgency();
        agency = agency == null ? "" : agency;
        City d2 = xt.f3961a.k().d();
        if (!(d2 == null || (modeAgencyMap = d2.getModeAgencyMap()) == null || (list2 = modeAgencyMap.get(TransitMode.bus)) == null)) {
            for (Agency agency2 : list2) {
                if (ea6.f(agency, agency2.getAgencyName(), true)) {
                    this.q = agency2;
                }
            }
        }
        boolean z2 = this.n != null;
        this.j = z2;
        ProductCategory productCategory = this.o;
        boolean z3 = productCategory != null;
        this.k = z3;
        boolean z4 = this.p != null;
        this.l = z4;
        boolean z5 = this.q != null;
        this.m = z5;
        if (!z2 || !z3 || !z4 || !z5) {
            this.i = false;
            this.r = new ArrayList();
            this.c.b("keyIsCompleteProductConfigurationAvailable", Boolean.FALSE);
        } else {
            this.i = true;
            List<String> categoryProofsList = productCategory.getCategoryProofsList();
            Agency agency3 = this.q;
            n86.c(agency3);
            String agencyName = agency3.getAgencyName();
            n86.d(agencyName, "agency!!.agencyName");
            ArrayList arrayList = new ArrayList();
            if (categoryProofsList != null && !categoryProofsList.isEmpty()) {
                z = false;
            }
            if (!z) {
                City d3 = xt.f3961a.k().d();
                if (d3 == null || (name2 = d3.getName()) == null) {
                    str = null;
                } else {
                    str = name2.toLowerCase();
                    n86.d(str, "(this as java.lang.String).toLowerCase()");
                }
                for (String str3 : categoryProofsList) {
                    ProofDocumentProps J = xt.f3961a.c().J(str, agencyName, str3);
                    if (J != null) {
                        arrayList.add(J);
                    }
                }
            }
            this.r = arrayList;
            MPass mPass = this.g;
            City d4 = xt.f3961a.k().d();
            if (!(d4 == null || (name = d4.getName()) == null)) {
                str2 = name.toLowerCase();
                n86.d(str2, "(this as java.lang.String).toLowerCase()");
            }
            mPass.setCity(str2);
            this.c.b("keyIsCompleteProductConfigurationAvailable", Boolean.TRUE);
        }
        this.s = hd3.a2(new b(this));
    }

    public static final Object d(p81 p81, k66 k66) {
        Objects.requireNonNull(p81);
        return ((sb6) hd3.t(h.Z(p81), p81.d, null, new q81(p81, null), 2, null)).v(k66);
    }

    public final LiveData<Map<String, ProofUploadDetails>> e() {
        Object value = this.s.getValue();
        n86.d(value, "<get-proofUploadDetailsMap>(...)");
        return (LiveData) value;
    }

    public final Map<String, String> f() {
        Map<String, ProofUploadDetails> d2 = e().d();
        HashMap hashMap = new HashMap();
        if (d2 != null) {
            for (Map.Entry<String, ProofUploadDetails> entry : d2.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue().getUploadedProofUrl());
            }
        }
        return hashMap;
    }

    public final LiveData<UserProfile> g() {
        Object value = this.h.getValue();
        n86.d(value, "<get-userProfile>(...)");
        return (LiveData) value;
    }

    public final void h() {
        MPass mPass = this.g;
        xt.t1 t1Var = xt.f3961a;
        mPass.setDeviceId(t1Var.n().a());
        if (n86.a(this.f, "flowPaymentPostVerification") || n86.a(this.f, "flowRenewPass")) {
            d20 c2 = t1Var.c();
            MPass mPass2 = this.g;
            c2.w(mPass2, jh1.c(mPass2.getStartingTime()), t1Var.L().j(), "online");
        } else if ((!n86.a(this.f, "flowFreshPurchase") || !this.g.is_isVerificationRequired()) && !n86.a(this.f, "flowReapplication")) {
            hd3.Y1(h.Z(this), this.d, null, new r81(this, null), 2, null);
        } else {
            hd3.Y1(h.Z(this), this.d, null, new s81(this, null), 2, null);
        }
    }

    public final void i(String str, String str2, String str3, String str4, ProofUploadStatus proofUploadStatus) {
        ProofUploadDetails proofUploadDetails;
        n86.e(str, "lProofId");
        n86.e(str2, "lProofImageLocalUri");
        n86.e(str3, "lUploadedProofUri");
        n86.e(str4, "lUploadRequestId");
        n86.e(proofUploadStatus, "lUploadStatus");
        Map<String, ProofUploadDetails> d2 = e().d();
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
        Map<String, ProofUploadDetails> d2 = e().d();
        if (d2 != null) {
            d2.put(str, new ProofUploadDetails(str3, str2, str4, ProofUploadStatus.UPLOADING, false, 16, null));
            this.c.b("keyProofUploadDetailsMap", d2);
        }
    }

    public final void k() {
        if (this.g.getUserProfile() == null) {
            this.g.setUserProfile(xt.f3961a.L().e());
        }
        this.c.b("keyUserProfile", this.g.getUserProfile());
    }
}
