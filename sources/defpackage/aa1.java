package defpackage;

import androidx.lifecycle.LiveData;

/* renamed from: aa1  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class aa1 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ga1 f137a;

    public /* synthetic */ aa1(ga1 ga1) {
        this.f137a = ga1;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ga1 ga1 = this.f137a;
        Boolean bool = (Boolean) obj;
        n86.e(ga1, "this$0");
        Object value = ga1.g.getValue();
        n86.d(value, "<get-isNameChangeCompleted>(...)");
        Boolean bool2 = (Boolean) ((LiveData) value).d();
        if (bool2 != null) {
            n86.d(bool, "lAreAllProofsUploaded");
            if (!bool.booleanValue() || !bool2.booleanValue()) {
                ga1.h.j(Boolean.FALSE);
            } else {
                ga1.h.j(Boolean.TRUE);
            }
        }
    }
}
