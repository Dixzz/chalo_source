package defpackage;

import android.app.Application;
import androidx.lifecycle.LiveData;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;

/* renamed from: q91  reason: default package */
/* compiled from: OnlineCardRechargeSummaryViewModel.kt */
public final class q91 extends lg {
    public final wh d;
    public final String e;
    public final String f;
    public final LiveData<OnlineCardRecharge> g;
    public final j56 h = hd3.a2(new a(this));

    /* renamed from: q91$a */
    /* compiled from: OnlineCardRechargeSummaryViewModel.kt */
    public static final class a extends o86 implements h76<oh<Boolean>> {
        public final /* synthetic */ q91 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(q91 q91) {
            super(0);
            this.f = q91;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public oh<Boolean> invoke() {
            return this.f.d.a("keyFareLayoutExpansionState", Boolean.FALSE);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q91(Application application, wh whVar) {
        super(application);
        n86.e(application, "application");
        n86.e(whVar, "savedStateHandle");
        this.d = whVar;
        Object obj = whVar.f3779a.get("keySuperPassId");
        n86.c(obj);
        n86.d(obj, "savedStateHandle.get<String>(KEY_TRANSACTION_ID)!!");
        String str = (String) obj;
        this.e = str;
        Object obj2 = whVar.f3779a.get("keySource");
        n86.c(obj2);
        n86.d(obj2, "savedStateHandle.get<String>(KEY_SOURCE)!!");
        this.f = (String) obj2;
        this.g = wg.a(xt.f3961a.K().getOnlineCardRecharge(str), null, 0, 3);
    }
}
