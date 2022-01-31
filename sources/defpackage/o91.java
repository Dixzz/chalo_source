package defpackage;

import android.app.Application;
import app.zophop.models.mTicketing.CardRechargeConfiguration;

/* renamed from: o91  reason: default package */
/* compiled from: CardRechargeConfirmPaymentFragmentViewModel.kt */
public final class o91 extends lg {
    public final wh d;
    public final j56 e = hd3.a2(new a(this));
    public final CardRechargeConfiguration f;
    public final String g;
    public final long h;
    public final j56 i;

    /* renamed from: o91$a */
    /* compiled from: CardRechargeConfirmPaymentFragmentViewModel.kt */
    public static final class a extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ o91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(o91 o91) {
            super(0);
            this.f = o91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.d.a("keyIsFareLayoutExpanded", Boolean.FALSE);
        }
    }

    /* renamed from: o91$b */
    /* compiled from: CardRechargeConfirmPaymentFragmentViewModel.kt */
    public static final class b extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ o91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(o91 o91) {
            super(0);
            this.f = o91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.d.a("keyShouldShowLoader", Boolean.FALSE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public o91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        Object obj = whVar.f3779a.get("keyCardRechargeConfiguration");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<Car…RECHARGE_CONFIGURATION)!!");
        this.f = (CardRechargeConfiguration) obj;
        Object obj2 = whVar.f3779a.get("keyCardNo");
        n86.c(obj2);
        n86.d(obj2, "savedStateHandle.get(KEY_CARD_NO)!!");
        this.g = (String) obj2;
        Object obj3 = whVar.f3779a.get("keyRechargeAmount");
        n86.c(obj3);
        n86.d(obj3, "savedStateHandle.get(KEY_RECHARGE_AMOUNT)!!");
        this.h = ((Number) obj3).longValue();
        this.i = hd3.a2(new b(this));
    }

    public final void d(boolean z) {
        this.d.b("keyShouldShowLoader", Boolean.valueOf(z));
    }
}
