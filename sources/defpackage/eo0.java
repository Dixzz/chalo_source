package defpackage;

import app.zophop.ui.fragments.BasicUserDetailsFragment;

/* renamed from: eo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class eo0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasicUserDetailsFragment f1011a;

    public /* synthetic */ eo0(BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f1011a = basicUserDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        BasicUserDetailsFragment basicUserDetailsFragment = this.f1011a;
        Boolean bool = (Boolean) obj;
        int i = BasicUserDetailsFragment.i;
        n86.e(basicUserDetailsFragment, "this$0");
        n86.d(bool, "lAreAllRequiredFieldsSelected");
        if (bool.booleanValue()) {
            T t = basicUserDetailsFragment.f;
            n86.c(t);
            ((gx) t).b.setAlpha(1.0f);
        } else {
            T t2 = basicUserDetailsFragment.f;
            n86.c(t2);
            ((gx) t2).b.setAlpha(0.4f);
        }
        T t3 = basicUserDetailsFragment.f;
        n86.c(t3);
        ((gx) t3).b.setEnabled(bool.booleanValue());
    }
}
