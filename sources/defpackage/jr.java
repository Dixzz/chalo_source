package defpackage;

import android.content.Context;

/* renamed from: jr  reason: default package */
/* compiled from: BatteryNotLowController */
public class jr extends kr<Boolean> {
    public jr(Context context, pt ptVar) {
        super(wr.a(context, ptVar).b);
    }

    @Override // defpackage.kr
    public boolean b(rs rsVar) {
        return rsVar.j.d;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.kr
    public boolean c(Boolean bool) {
        return !bool.booleanValue();
    }
}
