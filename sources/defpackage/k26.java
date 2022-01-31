package defpackage;

import android.view.LayoutInflater;

/* renamed from: k26  reason: default package */
/* compiled from: ViewPumpContextWrapper.kt */
public final class k26 extends o86 implements h76<o26> {
    public final /* synthetic */ j26 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k26(j26 j26) {
        super(0);
        this.f = j26;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // defpackage.h76
    public o26 invoke() {
        LayoutInflater from = LayoutInflater.from(this.f.getBaseContext());
        n86.b(from, "LayoutInflater.from(baseContext)");
        return new o26(from, this.f, false);
    }
}
