package defpackage;

import app.zophop.models.mTicketing.Gender;
import app.zophop.ui.fragments.BasicUserDetailsFragment;

/* renamed from: go0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class go0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasicUserDetailsFragment f1288a;

    public /* synthetic */ go0(BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f1288a = basicUserDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        BasicUserDetailsFragment basicUserDetailsFragment = this.f1288a;
        Gender gender = (Gender) obj;
        int i = BasicUserDetailsFragment.i;
        n86.e(basicUserDetailsFragment, "this$0");
        T t = basicUserDetailsFragment.f;
        n86.c(t);
        ((gx) t).e.setText(gender == null ? null : gender.name());
    }
}
