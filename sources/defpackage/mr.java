package defpackage;

import android.content.Context;
import android.os.Build;

/* renamed from: mr  reason: default package */
/* compiled from: NetworkMeteredController */
public class mr extends kr<fr> {
    public static final String e = tp.e("NetworkMeteredCtrlr");

    public mr(Context context, pt ptVar) {
        super(wr.a(context, ptVar).c);
    }

    @Override // defpackage.kr
    public boolean b(rs rsVar) {
        return rsVar.j.f2251a == up.METERED;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.kr
    public boolean c(fr frVar) {
        fr frVar2 = frVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 26) {
            tp.c().a(e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
            return !frVar2.f1161a;
        }
        if (frVar2.f1161a && frVar2.c) {
            z = false;
        }
        return z;
    }
}
