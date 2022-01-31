package defpackage;

import androidx.lifecycle.LiveData;

/* renamed from: z71  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class z71 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g91 f4143a;

    public /* synthetic */ z71(g91 g91) {
        this.f4143a = g91;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        g91 g91 = this.f4143a;
        Boolean bool = (Boolean) obj;
        n86.e(g91, "this$0");
        Object value = g91.f.getValue();
        n86.d(value, "<get-areAllProofsUploaded>(...)");
        Boolean bool2 = (Boolean) ((LiveData) value).d();
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                n86.d(bool, "lIsNameChangeCompleted");
                if (bool.booleanValue()) {
                    g91.h.j(Boolean.TRUE);
                    return;
                }
            }
            g91.h.j(Boolean.FALSE);
        }
    }
}
