package defpackage;

import app.zophop.ui.fragments.UserProofsOverviewFragment;

/* renamed from: us0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class us0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserProofsOverviewFragment f3550a;

    public /* synthetic */ us0(UserProofsOverviewFragment userProofsOverviewFragment) {
        this.f3550a = userProofsOverviewFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        UserProofsOverviewFragment userProofsOverviewFragment = this.f3550a;
        Boolean bool = (Boolean) obj;
        int i = UserProofsOverviewFragment.m;
        n86.e(userProofsOverviewFragment, "this$0");
        n86.d(bool, "lAreAllUploadsCompleted");
        if (bool.booleanValue()) {
            T t = userProofsOverviewFragment.f;
            n86.c(t);
            ((ux) t).b.setAlpha(1.0f);
        } else {
            T t2 = userProofsOverviewFragment.f;
            n86.c(t2);
            ((ux) t2).b.setAlpha(0.4f);
        }
        T t3 = userProofsOverviewFragment.f;
        n86.c(t3);
        ((ux) t3).b.setEnabled(bool.booleanValue());
    }
}
