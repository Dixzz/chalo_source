package defpackage;

import android.content.Context;
import android.os.Build;

/* renamed from: nr  reason: default package */
/* compiled from: NetworkNotRoamingController */
public class nr extends kr<fr> {
    public static final String e = tp.e("NetworkNotRoamingCtrlr");

    public nr(Context context, pt ptVar) {
        super(wr.a(context, ptVar).c);
    }

    @Override // defpackage.kr
    public boolean b(rs rsVar) {
        return rsVar.j.f2251a == up.NOT_ROAMING;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // defpackage.kr
    public boolean c(fr frVar) {
        fr frVar2 = frVar;
        boolean z = true;
        if (Build.VERSION.SDK_INT < 24) {
            tp.c().a(e, "Not-roaming network constraint is not supported before API 24, only checking for connected state.", new Throwable[0]);
            return !frVar2.f1161a;
        }
        if (frVar2.f1161a && frVar2.d) {
            z = false;
        }
        return z;
    }
}
