package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.lifecycle.LiveData;
import app.zophop.models.City;
import app.zophop.models.Favourites.Favourite;
import app.zophop.models.Favourites.RouteStoreType;
import app.zophop.models.Favourites.StopBasedTripFavourite;
import app.zophop.models.Favourites.TripFavourite;
import app.zophop.models.InAppUpdateRules;
import app.zophop.models.ProductGroup;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.room.ProductRepository;
import app.zophop.ui.views.summary_card.CardItem;
import com.google.android.gms.maps.model.LatLng;
import defpackage.xt;
import j$.util.Comparator;
import j$.util.function.Function;
import j$.util.function.ToDoubleFunction;
import j$.util.function.ToIntFunction;
import j$.util.function.ToLongFunction;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: d81  reason: default package */
/* compiled from: HomeScreenMainFragmentViewModel.kt */
public final class d81 extends lg {
    public final Context d;
    public final j56 e = hd3.a2(new n(this));
    public final j56 f = hd3.a2(new d(this));
    public final j56 g = hd3.a2(q.f);
    public final j56 h = hd3.a2(new l(this));
    public final j56 i = hd3.a2(new m(this));
    public a j = a.NOT_QUERIED;
    public String k;
    public Map<String, ? extends CardItem> l;
    public boolean m;
    public final j56 n = hd3.a2(p.f);
    public boolean o = true;
    public final j56 p = hd3.a2(g.f);
    public boolean q;
    public final j56 r = hd3.a2(new o(this));
    public final j56 s = hd3.a2(new e(this));
    public final j56 t = hd3.a2(new c(this));
    public final j56 u = hd3.a2(new f(this));

    /* renamed from: d81$a */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public enum a {
        NOT_QUERIED,
        IN_PROGRESS,
        SUCCESS,
        FAILURE
    }

    /* renamed from: d81$b */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public enum b {
        TICKET,
        SCAN_PAY_TICKET,
        MAGIC_PASS,
        PASS_APPLICATION,
        SUPER_PASS_APPLICATION,
        SUPER_PASS,
        RIDE_BASED_SUPER_PASS,
        PENDING_SUPER_PASS
    }

    /* renamed from: d81$c */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class c extends o86 implements h76<oh<List<? extends ProductGroup>>> {
        public final /* synthetic */ d81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d81 d81) {
            super(0);
            this.f = d81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<List<? extends ProductGroup>> invoke() {
            return new oh(this.f.i());
        }
    }

    /* renamed from: d81$d */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class d extends o86 implements h76<mh<EnumMap<b, List<? extends BookingItem>>>> {
        public final /* synthetic */ d81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(d81 d81) {
            super(0);
            this.f = d81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public mh<EnumMap<b, List<? extends BookingItem>>> invoke() {
            mh mhVar = new mh();
            d81 d81 = this.f;
            mhVar.m(d81.j().getAllActiveTickets(), new o71(d81, mhVar));
            mhVar.m(d81.j().getAllActiveScanPayTickets(), new n71(d81, mhVar));
            mhVar.m(d81.j().getRecentActivePasses(), new l71(d81, mhVar));
            mhVar.m(d81.j().getAllPassApplications(), new p71(d81, mhVar));
            xt.t1 t1Var = xt.f3961a;
            mhVar.m(t1Var.e0().getAllSuperPassApplications(), new m71(d81, mhVar));
            mhVar.m(t1Var.e0().getRecentActiveMagicSuperPasses(), new i71(d81, mhVar));
            mhVar.m(t1Var.e0().getRecentActiveRideBasedSuperPasses(), new j71(d81, mhVar));
            mhVar.m(t1Var.e0().getAllPendingSuperPasses(), new k71(d81, mhVar));
            return mhVar;
        }
    }

    /* renamed from: d81$e */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class e extends o86 implements h76<oh<List<? extends Favourite>>> {
        public final /* synthetic */ d81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d81 d81) {
            super(0);
            this.f = d81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<List<? extends Favourite>> invoke() {
            return new oh(this.f.k());
        }
    }

    /* renamed from: d81$f */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class f extends o86 implements h76<oh<List<? extends ProductGroup>>> {
        public final /* synthetic */ d81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d81 d81) {
            super(0);
            this.f = d81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<List<? extends ProductGroup>> invoke() {
            return this.f.m();
        }
    }

    /* renamed from: d81$g */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class g extends o86 implements h76<oh<LatLng>> {
        public static final g f = new g();

        public g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<LatLng> invoke() {
            return new oh(xt.f3961a.B().h());
        }
    }

    @y66(c = "app.zophop.ui.viewmodels.HomeScreenMainFragmentViewModel", f = "HomeScreenMainFragmentViewModel.kt", l = {807}, m = "getProductCount")
    /* renamed from: d81$h */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class h extends w66 {
        public int f;
        public int g;
        public int h;
        public /* synthetic */ Object i;
        public final /* synthetic */ d81 j;
        public int k;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d81 d81, k66<? super h> k66) {
            super(k66);
            this.j = d81;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= RtlSpacingHelper.UNDEFINED;
            return this.j.g(this);
        }
    }

    /* renamed from: d81$i */
    /* compiled from: Comparisons.kt */
    public static final class i<T> implements Comparator, j$.util.Comparator {
        @Override // j$.util.Comparator, java.util.Comparator
        public final int compare(T t, T t2) {
            return hd3.K(Long.valueOf(t2.getTime()), Long.valueOf(t.getTime()));
        }

        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ Comparator reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    /* renamed from: d81$j */
    /* compiled from: Comparisons.kt */
    public static final class j<T> implements java.util.Comparator, j$.util.Comparator {
        @Override // j$.util.Comparator, java.util.Comparator
        public final int compare(T t, T t2) {
            return hd3.K(Long.valueOf(t2.getTime()), Long.valueOf(t.getTime()));
        }

        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator reversed() {
            return Comparator.CC.$default$reversed(this);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function) {
            return Comparator.CC.$default$thenComparing(this, function);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, function, comparator);
        }

        @Override // j$.util.Comparator, java.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparing(java.util.Comparator comparator) {
            return Comparator.CC.$default$thenComparing(this, comparator);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
            return Comparator.CC.$default$thenComparingDouble(this, toDoubleFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
            return Comparator.CC.$default$thenComparingInt(this, toIntFunction);
        }

        @Override // j$.util.Comparator
        public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
            return Comparator.CC.$default$thenComparingLong(this, toLongFunction);
        }
    }

    @y66(c = "app.zophop.ui.viewmodels.HomeScreenMainFragmentViewModel$makeHomeScreenCalls$1", f = "HomeScreenMainFragmentViewModel.kt", l = {332}, m = "invokeSuspend")
    /* renamed from: d81$k */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class k extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ d81 g;

        @y66(c = "app.zophop.ui.viewmodels.HomeScreenMainFragmentViewModel$makeHomeScreenCalls$1$1", f = "HomeScreenMainFragmentViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: d81$k$a */
        /* compiled from: HomeScreenMainFragmentViewModel.kt */
        public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
            public /* synthetic */ Object f;
            public final /* synthetic */ d81 g;

            @y66(c = "app.zophop.ui.viewmodels.HomeScreenMainFragmentViewModel$makeHomeScreenCalls$1$1$1", f = "HomeScreenMainFragmentViewModel.kt", l = {}, m = "invokeSuspend")
            /* renamed from: d81$k$a$a  reason: collision with other inner class name */
            /* compiled from: HomeScreenMainFragmentViewModel.kt */
            public static final class C0017a extends b76 implements w76<mb6, k66<? super s56>, Object> {
                public final /* synthetic */ d81 f;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0017a(d81 d81, k66<? super C0017a> k66) {
                    super(2, k66);
                    this.f = d81;
                }

                @Override // defpackage.u66
                public final k66<s56> create(Object obj, k66<?> k66) {
                    return new C0017a(this.f, k66);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // defpackage.w76
                public Object invoke(mb6 mb6, k66<? super s56> k66) {
                    C0017a aVar = new C0017a(this.f, k66);
                    s56 s56 = s56.f3190a;
                    aVar.invokeSuspend(s56);
                    return s56;
                }

                @Override // defpackage.u66
                public final Object invokeSuspend(Object obj) {
                    p66 p66 = p66.COROUTINE_SUSPENDED;
                    hd3.Y2(obj);
                    Objects.requireNonNull(this.f);
                    TransitMode transitMode = TransitMode.bus;
                    xt.t1 t1Var = xt.f3961a;
                    if (ui1.b0(transitMode, t1Var.k().d())) {
                        t1Var.c().b(hj1.D(t1Var), new String());
                    }
                    return s56.f3190a;
                }
            }

            @y66(c = "app.zophop.ui.viewmodels.HomeScreenMainFragmentViewModel$makeHomeScreenCalls$1$1$2", f = "HomeScreenMainFragmentViewModel.kt", l = {}, m = "invokeSuspend")
            /* renamed from: d81$k$a$b */
            /* compiled from: HomeScreenMainFragmentViewModel.kt */
            public static final class b extends b76 implements w76<mb6, k66<? super s56>, Object> {
                public final /* synthetic */ d81 f;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public b(d81 d81, k66<? super b> k66) {
                    super(2, k66);
                    this.f = d81;
                }

                @Override // defpackage.u66
                public final k66<s56> create(Object obj, k66<?> k66) {
                    return new b(this.f, k66);
                }

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // defpackage.w76
                public Object invoke(mb6 mb6, k66<? super s56> k66) {
                    b bVar = new b(this.f, k66);
                    s56 s56 = s56.f3190a;
                    bVar.invokeSuspend(s56);
                    return s56;
                }

                @Override // defpackage.u66
                public final Object invokeSuspend(Object obj) {
                    p66 p66 = p66.COROUTINE_SUSPENDED;
                    hd3.Y2(obj);
                    d81 d81 = this.f;
                    Objects.requireNonNull(d81);
                    xt.t1 t1Var = xt.f3961a;
                    if (t1Var.L().m() && d81.n()) {
                        t1Var.c().d(t1Var.L().getUserId(), t1Var.L().j());
                    }
                    return s56.f3190a;
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(d81 d81, k66<? super a> k66) {
                super(2, k66);
                this.g = d81;
            }

            @Override // defpackage.u66
            public final k66<s56> create(Object obj, k66<?> k66) {
                a aVar = new a(this.g, k66);
                aVar.f = obj;
                return aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // defpackage.w76
            public Object invoke(mb6 mb6, k66<? super s56> k66) {
                a aVar = new a(this.g, k66);
                aVar.f = mb6;
                s56 s56 = s56.f3190a;
                aVar.invokeSuspend(s56);
                return s56;
            }

            @Override // defpackage.u66
            public final Object invokeSuspend(Object obj) {
                p66 p66 = p66.COROUTINE_SUSPENDED;
                hd3.Y2(obj);
                mb6 mb6 = (mb6) this.f;
                hd3.Y1(mb6, null, null, new C0017a(this.g, null), 3, null);
                hd3.Y1(mb6, null, null, new b(this.g, null), 3, null);
                return s56.f3190a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(d81 d81, k66<? super k> k66) {
            super(2, k66);
            this.g = d81;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new k(this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new k(this.g, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                a aVar = new a(this.g, null);
                this.f = 1;
                jd6 jd6 = new jd6(getContext(), this);
                Object C = ec6.C(jd6, jd6, aVar);
                if (C == p66) {
                    n86.e(this, "frame");
                }
                if (C == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return s56.f3190a;
        }
    }

    /* renamed from: d81$l */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class l extends o86 implements h76<rf1> {
        public final /* synthetic */ d81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(d81 d81) {
            super(0);
            this.f = d81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public rf1 invoke() {
            return new rf1(this.f.d, "pass_status_store");
        }
    }

    /* renamed from: d81$m */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class m extends o86 implements h76<rf1> {
        public final /* synthetic */ d81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(d81 d81) {
            super(0);
            this.f = d81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public rf1 invoke() {
            Context context = this.f.d;
            City d = xt.f3961a.k().d();
            n86.c(d);
            return new rf1(context, n86.j("product_group_store:", d.getName()));
        }
    }

    /* renamed from: d81$n */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class n extends o86 implements h76<ProductRepository> {
        public final /* synthetic */ d81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(d81 d81) {
            super(0);
            this.f = d81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ProductRepository invoke() {
            return new ProductRepository(this.f.d);
        }
    }

    /* renamed from: d81$o */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class o extends o86 implements h76<oh<List<? extends Favourite>>> {
        public final /* synthetic */ d81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(d81 d81) {
            super(0);
            this.f = d81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<List<? extends Favourite>> invoke() {
            return (oh) this.f.s.getValue();
        }
    }

    /* renamed from: d81$p */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class p extends o86 implements h76<Handler> {
        public static final p f = new p();

        public p() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Handler invoke() {
            return new Handler();
        }
    }

    /* renamed from: d81$q */
    /* compiled from: HomeScreenMainFragmentViewModel.kt */
    public static final class q extends o86 implements h76<LiveData<List<? extends SuperPassApplication>>> {
        public static final q f = new q();

        public q() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public LiveData<List<? extends SuperPassApplication>> invoke() {
            return xt.f3961a.e0().getAllSuperPassApplications();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d81(Application application) {
        super(application);
        n86.e(application, "application");
        this.d = application.getApplicationContext();
    }

    public static final EnumMap d(d81 d81) {
        EnumMap enumMap = (EnumMap) ((mh) d81.f.getValue()).d();
        return enumMap == null ? new EnumMap(b.class) : enumMap;
    }

    public static final void e(d81 d81, String str, String str2, String str3) {
        Objects.requireNonNull(d81);
        xt.t1 t1Var = xt.f3961a;
        t1Var.l().put(str3, "false");
        t1Var.l().put(str, "0");
        t1Var.l().put(str2, "0");
    }

    public final rf1 f() {
        return (rf1) this.h.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(defpackage.k66<? super java.lang.Integer> r8) {
        /*
        // Method dump skipped, instructions count: 120
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d81.g(k66):java.lang.Object");
    }

    public final rf1 h() {
        return (rf1) this.i.getValue();
    }

    public final List<ProductGroup> i() {
        ArrayList arrayList = new ArrayList();
        rf1 h2 = h();
        ProductGroup productGroup = ProductGroup.TICKET;
        if (h2.a(productGroup.toString())) {
            arrayList.add(productGroup);
        }
        rf1 h3 = h();
        ProductGroup productGroup2 = ProductGroup.LONGTERM;
        if (h3.a(productGroup2.toString())) {
            arrayList.add(productGroup2);
        }
        rf1 h4 = h();
        ProductGroup productGroup3 = ProductGroup.CARDRECHARGE;
        if (h4.a(productGroup3.toString())) {
            arrayList.add(productGroup3);
        }
        s(arrayList);
        return arrayList;
    }

    public final ProductRepository j() {
        return (ProductRepository) this.e.getValue();
    }

    public final List<Favourite> k() {
        if (ui1.e0()) {
            xt.t1 t1Var = xt.f3961a;
            c80 r2 = t1Var.r();
            List<Favourite> f2 = t1Var.r().f(RouteStoreType.RECENT);
            r2.m(f2);
            n86.d(f2, "favoriteStore.getSortedB…l(RouteStoreType.RECENT))");
            List<StopBasedTripFavourite> d2 = t1Var.i0().d();
            n86.d(d2, "tripStore.allStopBasedRecentTrips");
            return y56.v(y56.r(f2, d2), new i());
        }
        xt.t1 t1Var2 = xt.f3961a;
        c80 r3 = t1Var2.r();
        List<Favourite> f3 = t1Var2.r().f(RouteStoreType.RECENT);
        r3.m(f3);
        n86.d(f3, "favoriteStore.getSortedB…l(RouteStoreType.RECENT))");
        List<TripFavourite> c2 = t1Var2.i0().c();
        n86.d(c2, "tripStore.allRecentTrips");
        return y56.v(y56.r(f3, c2), new j());
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.Map<java.lang.String, ? extends app.zophop.ui.views.summary_card.CardItem>, java.util.Map<java.lang.String, app.zophop.ui.views.summary_card.CardItem> */
    public final Map<String, CardItem> l() {
        Map map = this.l;
        if (map != null) {
            return map;
        }
        n86.l("vehicleNoCardItemMapping");
        throw null;
    }

    public final oh<List<ProductGroup>> m() {
        return (oh) this.t.getValue();
    }

    public final boolean n() {
        TransitMode transitMode = TransitMode.bus;
        xt.t1 t1Var = xt.f3961a;
        return ui1.b0(transitMode, t1Var.k().d()) || ui1.c0(t1Var.k().d()) || ui1.a0(t1Var.k().d());
    }

    public final boolean o(LatLng latLng) {
        if (latLng != null) {
            City d2 = xt.f3961a.k().d();
            n86.c(d2);
            return !d2.containsLocation(latLng);
        }
    }

    public final void p() {
        mb6 Z = h.Z(this);
        kb6 kb6 = xb6.c;
        int i2 = CoroutineExceptionHandler.d;
        hd3.Y1(Z, kb6.plus(new lh1(CoroutineExceptionHandler.a.f)), null, new k(this, null), 2, null);
    }

    public final void q(LatLng latLng) {
        a aVar;
        a aVar2 = this.j;
        if (!(aVar2 == a.IN_PROGRESS || aVar2 == (aVar = a.FAILURE))) {
            LatLng latLng2 = rc1.s;
            boolean z = false;
            if (latLng != null && (rc1.s == null || aVar.equals(aVar2) || a.NOT_QUERIED.equals(aVar2) || vn.L(rc1.s, latLng) > 1.0d)) {
                z = true;
            }
            if (z) {
                if (this.k != null) {
                    xt.f3961a.E().b(this.k);
                }
                o30 E = xt.f3961a.E();
                Map<String, m30> map = E.b;
                if (map != null && map.size() > 0) {
                    for (Map.Entry<String, m30> entry : E.b.entrySet()) {
                        E.b.get(entry.getKey()).d();
                    }
                }
                m30 m30 = new m30();
                xt.t1 t1Var = xt.f3961a;
                m30.b = t1Var.c0().e(latLng, TransitMode.bus, 1, t1Var.t().f("nearbyStopsRadius"));
                m30.l = System.currentTimeMillis();
                m30.f2315a = UUID.randomUUID().toString();
                if (m30.d == null) {
                    m30.d = new HashMap();
                }
                if (m30.o == null) {
                    m30.o = new HashMap();
                }
                m30.f = latLng;
                HandlerThread handlerThread = new HandlerThread("HomeScreenHandler");
                m30.i = handlerThread;
                handlerThread.start();
                m30.h = new Handler(m30.i.getLooper());
                m30.j = new l30(m30);
                String str = m30.f2315a;
                E.b.put(str, m30);
                this.k = str;
                n86.j("query made for req id = ", str);
                this.j = a.IN_PROGRESS;
            }
        }
    }

    public final void r() {
        xt.t1 t1Var = xt.f3961a;
        LatLng h2 = t1Var.B().h();
        if (!o(h2)) {
            n86.c(h2);
            q(h2);
        } else if (!vn.J0(this.d)) {
            City d2 = t1Var.k().d();
            n86.c(d2);
            LatLng center = d2.getCenter();
            n86.d(center, "lLatLng");
            q(center);
        } else {
            if (h2 != null) {
                City d3 = t1Var.k().d();
                n86.c(d3);
                if (!d3.containsLocation(h2)) {
                    City d4 = t1Var.k().d();
                    n86.c(d4);
                    LatLng center2 = d4.getCenter();
                    n86.d(center2, "cityProvider.currentCity!!.center");
                    q(center2);
                    return;
                }
            }
            a aVar = a.NOT_QUERIED;
            a aVar2 = this.j;
            if (aVar == aVar2 || a.FAILURE == aVar2) {
                new Handler().postDelayed(new h71(this), 2000);
            }
        }
    }

    public final void s(List<ProductGroup> list) {
        if (ui1.c0(xt.f3961a.k().d())) {
            list.add(ProductGroup.SCANANDPAY);
        }
    }

    public final int t() {
        int size;
        int i2;
        List<InAppUpdateRules> c2 = xt.f3961a.k0().c();
        if (c2 == null || c2.size() - 1 < 0) {
            return -1;
        }
        int i3 = 0;
        int i4 = -1;
        while (true) {
            int i5 = i3 + 1;
            InAppUpdateRules inAppUpdateRules = c2.get(i3);
            n86.d(inAppUpdateRules, "lInAppUpdateRules.get(i)");
            InAppUpdateRules inAppUpdateRules2 = inAppUpdateRules;
            int startVersionCode = inAppUpdateRules2.getStartVersionCode();
            int endVersionCode = inAppUpdateRules2.getEndVersionCode();
            xt.t1 t1Var = xt.f3961a;
            String D = hj1.D(t1Var);
            try {
                i2 = (int) h.O(t1Var.m().getPackageManager().getPackageInfo(t1Var.m().getPackageName(), 0));
            } catch (PackageManager.NameNotFoundException e2) {
                e2.printStackTrace();
                i2 = -1;
            }
            if ((ea6.f(inAppUpdateRules2.getCity(), "all", true) || ea6.f(inAppUpdateRules2.getCity(), D, true)) && startVersionCode <= i2 && i2 <= endVersionCode && (i4 == -1 || i4 == 0)) {
                i4 = inAppUpdateRules2.getUpdateType();
            }
            if (i5 > size) {
                return i4;
            }
            i3 = i5;
        }
    }
}
