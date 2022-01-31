package defpackage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassApplication;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import app.zophop.room.SuperPassRepository;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: u91  reason: default package */
/* compiled from: SuperPassBookingSummarySharedViewModel.kt */
public final class u91 extends lg {
    public boolean d = true;
    public final m66 e = xb6.b.plus(new lh1(CoroutineExceptionHandler.a.f));
    public final String f;
    public final SuperPassSubType g;
    public final String h;
    public final String i;
    public final SuperPassApplication j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public BookableSuperPassConfiguration o;
    public rc6 p;
    public final LiveData<SuperPass> q;
    public final LiveData<PendingSuperPass> r;

    @y66(c = "app.zophop.ui.viewmodels.superPassHistory.SuperPassBookingSummarySharedViewModel$startTripReceiptAutoPolling$1", f = "SuperPassBookingSummarySharedViewModel.kt", l = {98}, m = "invokeSuspend")
    /* renamed from: u91$a */
    /* compiled from: SuperPassBookingSummarySharedViewModel.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ SuperPass h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SuperPass superPass, k66<? super a> k66) {
            super(2, k66);
            this.h = superPass;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            a aVar = new a(this.h, k66);
            aVar.g = obj;
            return aVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            a aVar = new a(this.h, k66);
            aVar.g = mb6;
            return aVar.invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            mb6 mb6;
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                mb6 = (mb6) this.g;
            } else if (i == 1) {
                mb6 = (mb6) this.g;
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (hd3.C1(mb6)) {
                xt.f3961a.p().d(this.h);
                this.g = mb6;
                this.f = 1;
                if (hd3.C0(30000, this) == p66) {
                    return p66;
                }
            }
            return s56.f3190a;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u91(Application application, wh whVar) {
        super(application);
        LiveData<SuperPass> liveData;
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        String str = (String) whVar.f3779a.get("keySuperPassId");
        this.f = str;
        SuperPassSubType superPassSubType = (SuperPassSubType) whVar.f3779a.get("keySuperPassSubType");
        this.g = superPassSubType;
        Object obj = whVar.f3779a.get("keySource");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<String>(KEY_SOURCE)!!");
        this.h = (String) obj;
        Object obj2 = whVar.f3779a.get("keyStartDestination");
        n86.c(obj2);
        n86.d(obj2, "savedStateHandle.get<Str…(KEY_START_DESTINATION)!!");
        String str2 = (String) obj2;
        this.i = str2;
        SuperPassApplication superPassApplication = (SuperPassApplication) whVar.f3779a.get("keySuperPassApplication");
        this.j = superPassApplication;
        boolean a2 = n86.a(str2, "pendingSuperPassSummaryScreen");
        this.k = a2;
        boolean a3 = n86.a(str2, "startDestinationSuperPassApplicationScreen");
        this.l = a3;
        this.m = n86.a(str2, "startDestinationSuperPassTripReceiptHistoryScreen");
        this.n = n86.a(str2, "startDestinationSuperPassTripReceiptScreen");
        LiveData<PendingSuperPass> liveData2 = null;
        if (a3 || a2) {
            liveData = null;
        } else if (superPassSubType == SuperPassSubType.MAGIC_SUPER_PASS) {
            SuperPassRepository e0 = xt.f3961a.e0();
            n86.c(str);
            liveData = wg.a(e0.getMagicSuperPass(str), null, 0, 3);
        } else {
            SuperPassRepository e02 = xt.f3961a.e0();
            n86.c(str);
            liveData = wg.a(e02.getRideBasedSuperPass(str), null, 0, 3);
        }
        this.q = liveData;
        if (!a3 && a2) {
            SuperPassRepository e03 = xt.f3961a.e0();
            n86.c(str);
            liveData2 = wg.a(e03.getPendingSuperPass(str), null, 0, 3);
        }
        this.r = liveData2;
        if (a3) {
            n86.c(superPassApplication);
            this.o = t60.a(superPassApplication);
        }
    }

    public final void d(SuperPass superPass) {
        n86.e(superPass, "lSuperPass");
        rc6 rc6 = this.p;
        boolean z = true;
        if (rc6 == null || !rc6.a()) {
            z = false;
        }
        if (!z) {
            this.p = hd3.Y1(h.Z(this), this.e, null, new a(superPass, null), 2, null);
        }
    }
}
