package defpackage;

import android.content.Context;
import app.zophop.models.Stop;
import app.zophop.models.TransitMode;
import defpackage.k90;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: lk0  reason: default package */
/* compiled from: StopAgencySpecificAdapter */
public class lk0 extends mk0 {
    public final String n;

    public lk0(Context context, TransitMode transitMode, List<Stop> list, String str, k90 k90) {
        super(context, transitMode, list, k90);
        this.n = str;
    }

    @Override // defpackage.mk0, defpackage.yf1
    public List<Stop> a(String str) {
        List<Stop> list;
        if (this.n == null) {
            return super.a(str);
        }
        l00 b = xt.f3961a.b();
        TransitMode transitMode = this.j;
        String str2 = this.n;
        Objects.requireNonNull(b);
        mi1 mi1 = new mi1(transitMode);
        try {
            list = mi1.b(mi1.a(mi1.d(str, str2)));
        } catch (Exception unused) {
            list = new ArrayList<>();
        }
        if (list.isEmpty()) {
            this.m = k90.a.NO_MATCH_FOUND;
        }
        return list;
    }
}
