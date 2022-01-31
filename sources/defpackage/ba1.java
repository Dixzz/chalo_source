package defpackage;

import android.os.Bundle;
import com.razorpay.AnalyticsConstants;
import server.zophop.queue.TaskKeys;

/* renamed from: ba1  reason: default package */
/* compiled from: ConfirmSuperPassPurchaseFragmentViewModel.kt */
public final class ba1 extends zh {
    public final wh c;
    public final j56 d = hd3.a2(new b(this));
    public final j56 e = hd3.a2(new c(this));
    public boolean f;
    public final j56 g = hd3.a2(new d(this));

    /* renamed from: ba1$a */
    /* compiled from: ConfirmSuperPassPurchaseFragmentViewModel.kt */
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
            return new ba1(whVar);
        }
    }

    /* renamed from: ba1$b */
    /* compiled from: ConfirmSuperPassPurchaseFragmentViewModel.kt */
    public static final class b extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ ba1 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ba1 ba1) {
            super(0);
            this.f = ba1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.c.a("keyIsFareLayoutExpanded", Boolean.FALSE);
        }
    }

    /* renamed from: ba1$c */
    /* compiled from: ConfirmSuperPassPurchaseFragmentViewModel.kt */
    public static final class c extends o86 implements h76<oh<Long>> {
        public final /* synthetic */ ba1 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ba1 ba1) {
            super(0);
            this.f = ba1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Long> invoke() {
            return this.f.c.a("keyPassStartTime", Long.valueOf(ui1.Q()));
        }
    }

    /* renamed from: ba1$d */
    /* compiled from: ConfirmSuperPassPurchaseFragmentViewModel.kt */
    public static final class d extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ ba1 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ba1 ba1) {
            super(0);
            this.f = ba1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.c.a("keyShouldShowLoader", Boolean.FALSE);
        }
    }

    public ba1(wh whVar) {
        n86.e(whVar, "savedStateHandle");
        this.c = whVar;
    }

    public final void d(boolean z) {
        this.c.b("keyShouldShowLoader", Boolean.valueOf(z));
    }
}
