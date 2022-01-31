package defpackage;

import android.content.Context;
import app.zophop.ZophopApplication;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.digitalTripReceipt.ProductActivationDetails;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassConstants;
import app.zophop.models.mTicketing.superPass.SuperPassProperties;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.room.DigitalTripReceiptRepository;
import com.razorpay.AnalyticsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: h10  reason: default package */
/* compiled from: DigitalTripReceiptFeature.kt */
public final class h10 implements j20 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1329a;
    public final DigitalTripReceiptRepository b;
    public final ZophopApplication c;

    @y66(c = "app.zophop.features.DigitalTripReceiptFeature$fetchSuperPassTripReceipts$1", f = "DigitalTripReceiptFeature.kt", l = {}, m = "invokeSuspend")
    /* renamed from: h10$a */
    /* compiled from: DigitalTripReceiptFeature.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public final /* synthetic */ h10 f;
        public final /* synthetic */ SuperPass g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(h10 h10, SuperPass superPass, k66<? super a> k66) {
            super(2, k66);
            this.f = h10;
            this.g = superPass;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new a(this.f, this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            a aVar = new a(this.f, this.g, k66);
            s56 s56 = s56.f3190a;
            aVar.invokeSuspend(s56);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            List<ProductActivationDetails> productActivationDetailsListMap = this.f.b.getProductActivationDetailsListMap();
            ArrayList arrayList2 = null;
            if (productActivationDetailsListMap == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (T t : productActivationDetailsListMap) {
                    if (n86.a(t.getProductType(), SuperPassConstants.PRODUCT_TYPE_SUPER_PASS)) {
                        arrayList.add(t);
                    }
                }
            }
            if (productActivationDetailsListMap != null) {
                arrayList2 = new ArrayList();
                for (T t2 : productActivationDetailsListMap) {
                    if (n86.a(t2.getProductType(), "singleJourneyTicket")) {
                        arrayList2.add(t2);
                    }
                }
            }
            u60.f3458a.f(this.g, arrayList, arrayList2, this.f.f1329a);
            return s56.f3190a;
        }
    }

    @y66(c = "app.zophop.features.DigitalTripReceiptFeature$sendMTicketActivationTimeStampToBackend$1", f = "DigitalTripReceiptFeature.kt", l = {68}, m = "invokeSuspend")
    /* renamed from: h10$b */
    /* compiled from: DigitalTripReceiptFeature.kt */
    public static final class b extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ h10 g;
        public final /* synthetic */ MTicket h;
        public final /* synthetic */ long i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h10 h10, MTicket mTicket, long j, k66<? super b> k66) {
            super(2, k66);
            this.g = h10;
            this.h = mTicket;
            this.i = j;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new b(this.g, this.h, this.i, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new b(this.g, this.h, this.i, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i2 = this.f;
            if (i2 == 0) {
                hd3.Y2(obj);
                h10 h10 = this.g;
                MTicket mTicket = this.h;
                long j = this.i;
                Objects.requireNonNull(h10);
                String mTicketId = mTicket.getMTicketId();
                n86.d(mTicketId, "lMTicket.mTicketId");
                long expirationTime = mTicket.getExpirationTime();
                String cityName = mTicket.getCityName();
                n86.d(cityName, "lMTicket.cityName");
                String agency = mTicket.getAgency();
                n86.d(agency, "lMTicket.agency");
                ProductActivationDetails productActivationDetails = new ProductActivationDetails(j, mTicketId, expirationTime, "singleJourneyTicket", "singleJourneyTicket", cityName, agency);
                DigitalTripReceiptRepository digitalTripReceiptRepository = this.g.b;
                this.f = 1;
                if (digitalTripReceiptRepository.insertProductActivationDetails(productActivationDetails, this) == p66) {
                    return p66;
                }
            } else if (i2 == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.g.a();
            return s56.f3190a;
        }
    }

    @y66(c = "app.zophop.features.DigitalTripReceiptFeature$sendSuperPassActivationTimeStampToBackend$1", f = "DigitalTripReceiptFeature.kt", l = {56}, m = "invokeSuspend")
    /* renamed from: h10$c */
    /* compiled from: DigitalTripReceiptFeature.kt */
    public static final class c extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ h10 g;
        public final /* synthetic */ SuperPass h;
        public final /* synthetic */ long i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(h10 h10, SuperPass superPass, long j, k66<? super c> k66) {
            super(2, k66);
            this.g = h10;
            this.h = superPass;
            this.i = j;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new c(this.g, this.h, this.i, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new c(this.g, this.h, this.i, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i2 = this.f;
            if (i2 == 0) {
                hd3.Y2(obj);
                h10 h10 = this.g;
                SuperPass superPass = this.h;
                long j = this.i;
                Objects.requireNonNull(h10);
                SuperPassProperties superPassProperties = superPass.getSuperPassProperties();
                ProductActivationDetails productActivationDetails = new ProductActivationDetails(j, superPassProperties.getPassId(), superPass.getSuperPassValidationProperties().getExpiryTime(), superPass.getSuperPassProperties().getProductType(), SuperPassSubType.Companion.toString(superPass.getSuperPassProperties().getProductSubType()), superPassProperties.getCityName(), superPassProperties.getAgencyName());
                DigitalTripReceiptRepository digitalTripReceiptRepository = this.g.b;
                this.f = 1;
                if (digitalTripReceiptRepository.insertProductActivationDetails(productActivationDetails, this) == p66) {
                    return p66;
                }
            } else if (i2 == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.g.a();
            return s56.f3190a;
        }
    }

    @y66(c = "app.zophop.features.DigitalTripReceiptFeature$sendUnSyncedActivationTimeStampsToBackend$1", f = "DigitalTripReceiptFeature.kt", l = {}, m = "invokeSuspend")
    /* renamed from: h10$d */
    /* compiled from: DigitalTripReceiptFeature.kt */
    public static final class d extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public final /* synthetic */ h10 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(h10 h10, k66<? super d> k66) {
            super(2, k66);
            this.f = h10;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new d(this.f, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            d dVar = new d(this.f, k66);
            s56 s56 = s56.f3190a;
            dVar.invokeSuspend(s56);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            ArrayList arrayList;
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            List<ProductActivationDetails> productActivationDetailsListMap = this.f.b.getProductActivationDetailsListMap();
            ArrayList arrayList2 = null;
            if (productActivationDetailsListMap == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (T t : productActivationDetailsListMap) {
                    if (n86.a(t.getProductType(), SuperPassConstants.PRODUCT_TYPE_SUPER_PASS)) {
                        arrayList.add(t);
                    }
                }
            }
            if (productActivationDetailsListMap != null) {
                arrayList2 = new ArrayList();
                for (T t2 : productActivationDetailsListMap) {
                    if (n86.a(t2.getProductType(), "singleJourneyTicket")) {
                        arrayList2.add(t2);
                    }
                }
            }
            u60.f3458a.e(arrayList, arrayList2, this.f.f1329a);
            return s56.f3190a;
        }
    }

    public h10(Context context) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        this.f1329a = context;
        this.b = new DigitalTripReceiptRepository(context);
        this.c = (ZophopApplication) context;
    }

    @Override // defpackage.j20
    public void a() {
        if (xt.f3961a.L().m()) {
            hd3.Y1(this.c, null, null, new d(this, null), 3, null);
        }
    }

    @Override // defpackage.j20
    public void b(MTicket mTicket, long j) {
        n86.e(mTicket, "lMTicket");
        ed1 ed1 = new ed1("sync mTicket activation timeStamp with backend", Long.MIN_VALUE);
        ed1.a("type", "mTicket");
        gi1.f1265a.b(ed1, mTicket);
        ui1.m0(ed1);
        hd3.Y1(this.c, null, null, new b(this, mTicket, j, null), 3, null);
    }

    @Override // defpackage.j20
    public void c(SuperPass superPass, long j) {
        n86.e(superPass, "lSuperPass");
        ed1 ed1 = new ed1("sync superPass activation timeStamp with backend", Long.MIN_VALUE);
        ed1.a("type", SuperPassConstants.PRODUCT_TYPE_SUPER_PASS);
        gi1.f1265a.f(ed1, superPass);
        ui1.m0(ed1);
        hd3.Y1(this.c, null, null, new c(this, superPass, j, null), 3, null);
    }

    @Override // defpackage.j20
    public void d(SuperPass superPass) {
        n86.e(superPass, "lSuperPass");
        hd3.Y1(this.c, null, null, new a(this, superPass, null), 3, null);
    }
}
