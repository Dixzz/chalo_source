package defpackage;

import android.app.Application;
import app.zophop.models.mTicketing.CardRechargeConfiguration;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: m91  reason: default package */
/* compiled from: CardRechargeAmountFragmentViewModel.kt */
public final class m91 extends lg {
    public final wh d;
    public final m66 e;
    public final CardRechargeConfiguration f;
    public final String g;
    public final long h;
    public long i;
    public final j56 j;

    /* renamed from: m91$a */
    /* compiled from: CardRechargeAmountFragmentViewModel.kt */
    public static final class a extends o86 implements h76<oh<String>> {
        public final /* synthetic */ m91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(m91 m91) {
            super(0);
            this.f = m91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<String> invoke() {
            return this.f.d.a("keyErrorMessage", "noError");
        }
    }

    @y66(c = "app.zophop.ui.viewmodels.cardRecharge.CardRechargeAmountFragmentViewModel$onAmountEntered$1", f = "CardRechargeAmountFragmentViewModel.kt", l = {39}, m = "invokeSuspend")
    /* renamed from: m91$b */
    /* compiled from: CardRechargeAmountFragmentViewModel.kt */
    public static final class b extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ m91 g;
        public final /* synthetic */ String h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(m91 m91, String str, k66<? super b> k66) {
            super(2, k66);
            this.g = m91;
            this.h = str;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new b(this.g, this.h, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new b(this.g, this.h, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                m91 m91 = this.g;
                String str = this.h;
                this.f = 1;
                if (m91.d(m91, str, this) == p66) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        kb6 kb6 = xb6.b;
        int i2 = CoroutineExceptionHandler.d;
        this.e = kb6.plus(new lh1(CoroutineExceptionHandler.a.f));
        Object obj = whVar.f3779a.get("keyCardRechargeConfiguration");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<Car…RECHARGE_CONFIGURATION)!!");
        this.f = (CardRechargeConfiguration) obj;
        Object obj2 = whVar.f3779a.get("keyCardNo");
        n86.c(obj2);
        n86.d(obj2, "savedStateHandle.get<String>(KEY_CARD_NO)!!");
        this.g = (String) obj2;
        Object obj3 = whVar.f3779a.get("keyRechargeLimit");
        n86.c(obj3);
        n86.d(obj3, "savedStateHandle.get<Long>(KEY_RECHARGE_LIMIT)!!");
        this.h = ((Number) obj3).longValue();
        Long l = (Long) whVar.f3779a.get("keyEnteredAmount");
        this.i = l == null ? 0 : l.longValue();
        this.j = hd3.a2(new a(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (r14 == r3) goto L_0x01ab;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00b4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(defpackage.m91 r12, java.lang.String r13, defpackage.k66 r14) {
        /*
        // Method dump skipped, instructions count: 448
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.m91.d(m91, java.lang.String, k66):java.lang.Object");
    }

    public final void e(String str) {
        n86.e(str, "lAmountString");
        hd3.Y1(h.Z(this), this.e, null, new b(this, str, null), 2, null);
    }
}
