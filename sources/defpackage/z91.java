package defpackage;

import androidx.lifecycle.LiveData;

/* renamed from: z91  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class z91 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ga1 f4147a;

    public /* synthetic */ z91(ga1 ga1) {
        this.f4147a = ga1;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ga1 ga1 = this.f4147a;
        Boolean bool = (Boolean) obj;
        n86.e(ga1, "this$0");
        Object value = ga1.f.getValue();
        n86.d(value, "<get-areAllProofsUploaded>(...)");
        Boolean bool2 = (Boolean) ((LiveData) value).d();
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                n86.d(bool, "lIsNameChangeCompleted");
                if (bool.booleanValue()) {
                    ga1.h.j(Boolean.TRUE);
                    return;
                }
            }
            ga1.h.j(Boolean.FALSE);
        }
    }
}
