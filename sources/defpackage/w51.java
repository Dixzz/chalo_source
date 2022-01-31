package defpackage;

import app.zophop.ui.fragments.superpassPurchase.SuperPassUserProofsOverviewFragment;

/* renamed from: w51  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class w51 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassUserProofsOverviewFragment f3733a;

    public /* synthetic */ w51(SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment) {
        this.f3733a = superPassUserProofsOverviewFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassUserProofsOverviewFragment superPassUserProofsOverviewFragment = this.f3733a;
        Boolean bool = (Boolean) obj;
        int i = SuperPassUserProofsOverviewFragment.m;
        n86.e(superPassUserProofsOverviewFragment, "this$0");
        n86.d(bool, "lAreAllUploadsCompleted");
        if (bool.booleanValue()) {
            T t = superPassUserProofsOverviewFragment.f;
            n86.c(t);
            ((sx) t).b.setAlpha(1.0f);
        } else {
            T t2 = superPassUserProofsOverviewFragment.f;
            n86.c(t2);
            ((sx) t2).b.setAlpha(0.4f);
        }
        T t3 = superPassUserProofsOverviewFragment.f;
        n86.c(t3);
        ((sx) t3).b.setEnabled(bool.booleanValue());
    }
}
