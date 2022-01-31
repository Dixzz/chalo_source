package defpackage;

import android.app.Application;
import android.content.Context;
import app.zophop.models.City;
import app.zophop.models.mTicketing.BookingItem;
import app.zophop.models.mTicketing.MagicPassesProperties;
import app.zophop.room.ProductRepository;
import defpackage.d81;
import defpackage.xt;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: c91  reason: default package */
/* compiled from: ProductHistoryScreenViewModel.kt */
public final class c91 extends lg {
    public boolean d = true;
    public boolean e = true;
    public final Context f;
    public final j56 g;
    public final j56 h;

    /* renamed from: c91$a */
    /* compiled from: ProductHistoryScreenViewModel.kt */
    public static final class a extends o86 implements h76<mh<EnumMap<d81.b, List<? extends BookingItem>>>> {
        public final /* synthetic */ c91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(c91 c91) {
            super(0);
            this.f = c91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public mh<EnumMap<d81.b, List<? extends BookingItem>>> invoke() {
            mh mhVar = new mh();
            c91 c91 = this.f;
            mhVar.m(c91.e(c91).getAllTickets(), new r71(c91, mhVar));
            mhVar.m(c91.e(c91).getAllScanPayTickets(), new v71(c91, mhVar));
            mhVar.m(c91.e(c91).getAllPasses(), new w71(c91, mhVar));
            mhVar.m(c91.e(c91).getAllPassApplications(), new x71(c91, mhVar));
            xt.t1 t1Var = xt.f3961a;
            mhVar.m(t1Var.e0().getAllSuperPassApplications(), new t71(c91, mhVar));
            mhVar.m(t1Var.e0().getAllMagicSuperPasses(), new s71(c91, mhVar));
            mhVar.m(t1Var.e0().getAllRideBasedSuperPasses(), new u71(c91, mhVar));
            mhVar.m(t1Var.e0().getAllPendingSuperPasses(), new q71(c91, mhVar));
            return mhVar;
        }
    }

    @y66(c = "app.zophop.ui.viewmodels.ProductHistoryScreenViewModel$makeFetchPassesAndTicketsCall$1", f = "ProductHistoryScreenViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: c91$b */
    /* compiled from: ProductHistoryScreenViewModel.kt */
    public static final class b extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public b(k66<? super b> k66) {
            super(2, k66);
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new b(k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            b bVar = new b(k66);
            s56 s56 = s56.f3190a;
            bVar.invokeSuspend(s56);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            xt.t1 t1Var = xt.f3961a;
            if (t1Var.L().m()) {
                t1Var.c().d(t1Var.L().getUserId(), t1Var.L().j());
            }
            return s56.f3190a;
        }
    }

    /* renamed from: c91$c */
    /* compiled from: ProductHistoryScreenViewModel.kt */
    public static final class c extends o86 implements h76<ProductRepository> {
        public final /* synthetic */ c91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(c91 c91) {
            super(0);
            this.f = c91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ProductRepository invoke() {
            return new ProductRepository(this.f.f);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        boolean z = true;
        if (whVar.f3779a.containsKey("screenPosition")) {
            Integer num = (Integer) whVar.f3779a.get("screenPosition");
            this.d = (num == null || num.intValue() != 0) ? false : z;
        }
        this.f = application.getApplicationContext();
        this.g = hd3.a2(new c(this));
        this.h = hd3.a2(new a(this));
    }

    public static final EnumMap d(c91 c91) {
        EnumMap enumMap = (EnumMap) ((mh) c91.h.getValue()).d();
        return enumMap == null ? new EnumMap(d81.b.class) : enumMap;
    }

    public static final ProductRepository e(c91 c91) {
        return (ProductRepository) c91.g.getValue();
    }

    public final boolean f() {
        EnumMap<d81.b, List<BookingItem>> enumMap = (EnumMap) ((mh) this.h.getValue()).d();
        List<BookingItem> g2 = enumMap == null ? null : g(enumMap);
        if (!(g2 == null || g2.isEmpty()) || j()) {
            return false;
        }
        return true;
    }

    public final List<BookingItem> g(EnumMap<d81.b, List<BookingItem>> enumMap) {
        n86.e(enumMap, "bookingItemsMap");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, List<BookingItem>> entry : enumMap.entrySet()) {
            List<BookingItem> value = entry.getValue();
            n86.d(value, "iValue");
            arrayList.addAll(value);
        }
        hd3.T2(arrayList);
        return arrayList;
    }

    public final MagicPassesProperties h() {
        xt.t1 t1Var = xt.f3961a;
        d20 c2 = t1Var.c();
        City d2 = t1Var.k().d();
        n86.c(d2);
        return c2.a0(d2.getName());
    }

    public final void i() {
        mb6 Z = h.Z(this);
        kb6 kb6 = xb6.c;
        int i = CoroutineExceptionHandler.d;
        hd3.Y1(Z, kb6.plus(new lh1(CoroutineExceptionHandler.a.f)), null, new b(null), 2, null);
    }

    public final boolean j() {
        boolean z;
        if (h() != null) {
            MagicPassesProperties h2 = h();
            n86.c(h2);
            if (h2.hasPassesOnMultipleDevices()) {
                z = true;
                if (z || !this.d) {
                    return false;
                }
                return true;
            }
        }
        z = false;
        if (z) {
        }
        return false;
    }
}
