package defpackage;

import androidx.lifecycle.LiveData;

/* renamed from: y71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class y71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g91 f4013a;

    public /* synthetic */ y71(g91 g91) {
        this.f4013a = g91;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        g91 g91 = this.f4013a;
        Boolean bool = (Boolean) obj;
        n86.e(g91, "this$0");
        Object value = g91.g.getValue();
        n86.d(value, "<get-isNameChangeCompleted>(...)");
        Boolean bool2 = (Boolean) ((LiveData) value).d();
        if (bool2 != null) {
            n86.d(bool, "lAreAllProofsUploaded");
            if (!bool.booleanValue() || !bool2.booleanValue()) {
                g91.h.j(Boolean.FALSE);
            } else {
                g91.h.j(Boolean.TRUE);
            }
        }
    }
}
