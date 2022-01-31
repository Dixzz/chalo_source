package defpackage;

import android.app.Application;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.BookableSuperPassConfiguration;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: v91  reason: default package */
/* compiled from: SuperPassBookingSummaryViewModel.kt */
public final class v91 extends lg {
    public final wh d;
    public final m66 e;
    public final oh<Boolean> f;
    public final LiveData<Boolean> g;
    public final oh<Boolean> h;
    public final LiveData<Boolean> i;
    public final oh<Boolean> j;
    public final oh<Boolean> k;
    public String l = new String();

    @y66(c = "app.zophop.ui.viewmodels.superPassHistory.SuperPassBookingSummaryViewModel", f = "SuperPassBookingSummaryViewModel.kt", l = {63}, m = "getBookablePassConfigFromProductConfigDataFetchEvent")
    /* renamed from: v91$a */
    /* compiled from: SuperPassBookingSummaryViewModel.kt */
    public static final class a extends w66 {
        public Object f;
        public /* synthetic */ Object g;
        public final /* synthetic */ v91 h;
        public int i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(v91 v91, k66<? super a> k66) {
            super(k66);
            this.h = v91;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= RtlSpacingHelper.UNDEFINED;
            return this.h.d(null, null, this);
        }
    }

    @y66(c = "app.zophop.ui.viewmodels.superPassHistory.SuperPassBookingSummaryViewModel$getBookablePassConfigFromProductConfigDataFetchEvent$lResult$1", f = "SuperPassBookingSummaryViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: v91$b */
    /* compiled from: SuperPassBookingSummaryViewModel.kt */
    public static final class b extends b76 implements w76<mb6, k66<? super BookableSuperPassConfiguration>, Object> {
        public final /* synthetic */ ProductConfigurationFetchedEvent f;
        public final /* synthetic */ SuperPass g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ProductConfigurationFetchedEvent productConfigurationFetchedEvent, SuperPass superPass, k66<? super b> k66) {
            super(2, k66);
            this.f = productConfigurationFetchedEvent;
            this.g = superPass;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new b(this.f, this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super BookableSuperPassConfiguration> k66) {
            return new b(this.f, this.g, k66).invokeSuspend(s56.f3190a);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0067, code lost:
            if (r5.isProductConfigSupportedOnCurrentAppVersion() != false) goto L_0x006b;
         */
        @Override // defpackage.u66
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
            // Method dump skipped, instructions count: 161
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.v91.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        kb6 kb6 = xb6.b;
        int i2 = CoroutineExceptionHandler.d;
        this.e = kb6.plus(new lh1(CoroutineExceptionHandler.a.f));
        Boolean bool = Boolean.FALSE;
        oh<Boolean> a2 = whVar.a("keyProofDocumentsExpansionState", bool);
        n86.d(a2, "savedStateHandle.getLive…S_EXPANSION_STATE, false)");
        this.f = a2;
        this.g = a2;
        oh<Boolean> a3 = whVar.a("keyFareLayoutExpansionState", bool);
        n86.d(a3, "savedStateHandle.getLive…T_EXPANSION_STATE, false)");
        this.h = a3;
        this.i = a3;
        oh<Boolean> a4 = whVar.a("keyShouldShowLoader", bool);
        n86.d(a4, "savedStateHandle.getLive…HOULD_SHOW_LOADER, false)");
        this.j = a4;
        this.k = a4;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object d(app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent r11, app.zophop.models.mTicketing.superPass.SuperPass r12, defpackage.k66<? super app.zophop.models.mTicketing.BookableSuperPassConfiguration> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof defpackage.v91.a
            if (r0 == 0) goto L_0x0013
            r0 = r13
            v91$a r0 = (defpackage.v91.a) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.i = r1
            goto L_0x0018
        L_0x0013:
            v91$a r0 = new v91$a
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.g
            p66 r1 = defpackage.p66.COROUTINE_SUSPENDED
            int r2 = r0.i
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            java.lang.Object r11 = r0.f
            v91 r11 = (defpackage.v91) r11
            defpackage.hd3.Y2(r13)
            goto L_0x0057
        L_0x002b:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0033:
            defpackage.hd3.Y2(r13)
            mb6 r4 = defpackage.h.Z(r10)
            m66 r5 = r10.e
            r6 = 0
            v91$b r7 = new v91$b
            r13 = 0
            r7.<init>(r11, r12, r13)
            r8 = 2
            r9 = 0
            rb6 r11 = defpackage.hd3.t(r4, r5, r6, r7, r8, r9)
            r0.f = r10
            r0.i = r3
            sb6 r11 = (defpackage.sb6) r11
            java.lang.Object r13 = r11.v(r0)
            if (r13 != r1) goto L_0x0056
            return r1
        L_0x0056:
            r11 = r10
        L_0x0057:
            app.zophop.models.mTicketing.BookableSuperPassConfiguration r13 = (app.zophop.models.mTicketing.BookableSuperPassConfiguration) r13
            oh<java.lang.Boolean> r11 = r11.j
            java.lang.Boolean r12 = java.lang.Boolean.FALSE
            r11.j(r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v91.d(app.zophop.pubsub.eventbus.events.ProductConfigurationFetchedEvent, app.zophop.models.mTicketing.superPass.SuperPass, k66):java.lang.Object");
    }
}
