package defpackage;

import app.zophop.ui.fragments.BasicUserDetailsFragment;

/* renamed from: fo0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class fo0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasicUserDetailsFragment f1150a;

    public /* synthetic */ fo0(BasicUserDetailsFragment basicUserDetailsFragment) {
        this.f1150a = basicUserDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        BasicUserDetailsFragment basicUserDetailsFragment = this.f1150a;
        String str = (String) obj;
        int i = BasicUserDetailsFragment.i;
        n86.e(basicUserDetailsFragment, "this$0");
        if (str != null) {
            T t = basicUserDetailsFragment.f;
            n86.c(t);
            ((gx) t).c.setText(ui1.w(str));
        }
    }
}
