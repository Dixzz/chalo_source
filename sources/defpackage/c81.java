package defpackage;

import android.os.Bundle;
import com.razorpay.AnalyticsConstants;
import server.zophop.queue.TaskKeys;

/* renamed from: c81  reason: default package */
/* compiled from: ConfirmMPassPurchaseFragmentViewModel.kt */
public final class c81 extends zh {
    public final wh c;
    public final j56 d = hd3.a2(new b(this));
    public final j56 e = hd3.a2(new c(this));
    public boolean f;
    public final j56 g = hd3.a2(new d(this));

    /* renamed from: c81$a */
    /* compiled from: ConfirmMPassPurchaseFragmentViewModel.kt */
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
            return new c81(whVar);
        }
    }

    /* renamed from: c81$b */
    /* compiled from: ConfirmMPassPurchaseFragmentViewModel.kt */
    public static final class b extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ c81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(c81 c81) {
            super(0);
            this.f = c81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.c.a("keyIsFareLayoutExpanded", Boolean.FALSE);
        }
    }

    /* renamed from: c81$c */
    /* compiled from: ConfirmMPassPurchaseFragmentViewModel.kt */
    public static final class c extends o86 implements h76<oh<Long>> {
        public final /* synthetic */ c81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(c81 c81) {
            super(0);
            this.f = c81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Long> invoke() {
            return this.f.c.a("keyPassStartTime", Long.valueOf(ui1.Q()));
        }
    }

    /* renamed from: c81$d */
    /* compiled from: ConfirmMPassPurchaseFragmentViewModel.kt */
    public static final class d extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ c81 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(c81 c81) {
            super(0);
            this.f = c81;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.c.a("keyShouldShowLoader", Boolean.FALSE);
        }
    }

    public c81(wh whVar) {
        n86.e(whVar, "savedStateHandle");
        this.c = whVar;
    }

    public final void d(boolean z) {
        this.c.b("keyShouldShowLoader", Boolean.valueOf(z));
    }
}
