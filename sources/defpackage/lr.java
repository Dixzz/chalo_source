package defpackage;

import android.content.Context;
import android.os.Build;

/* renamed from: lr  reason: default package */
/* compiled from: NetworkConnectedController */
public class lr extends kr<fr> {
    public lr(Context context, pt ptVar) {
        super(wr.a(context, ptVar).c);
    }

    @Override // defpackage.kr
    public boolean b(rs rsVar) {
        return rsVar.j.f2251a == up.CONNECTED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.kr
    public boolean c(fr frVar) {
        fr frVar2 = frVar;
        if (Build.VERSION.SDK_INT < 26) {
            return true ^ frVar2.f1161a;
        }
        if (!frVar2.f1161a || !frVar2.b) {
            return true;
        }
        return false;
    }
}
