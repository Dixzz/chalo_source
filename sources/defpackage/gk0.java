package defpackage;

import android.content.Context;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import defpackage.k90;
import java.util.ArrayList;
import java.util.List;

/* renamed from: gk0  reason: default package */
/* compiled from: RouteSpecificStopPicker */
public class gk0 extends mk0 {
    public gk0(Context context, TransitMode transitMode, List<Stop> list, k90 k90) {
        super(context, transitMode, list, k90);
        if (list != null) {
            this.k = list;
        } else {
            this.k = new ArrayList();
        }
    }

    @Override // defpackage.mk0, defpackage.yf1
    public List<Stop> a(String str) {
        List<Stop> arrayList = new ArrayList<>();
        List<Stop> list = this.k;
        if (!(list == null || list.size() == 0)) {
            arrayList = xt.f3961a.b().b(str, this.k);
        }
        if (arrayList.size() == 0) {
            this.m = k90.a.NO_MATCH_FOUND;
        }
        return arrayList;
    }
}
