package defpackage;

import android.content.Context;
import app.zophop.models.RouteInfo;
import app.zophop.models.TransitMode;
import defpackage.k90;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: ek0  reason: default package */
/* compiled from: RouteAgencySpecificAdapter */
public class ek0 extends fk0 {
    public final String n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;

    public ek0(Context context, k90 k90, String str, boolean z, boolean z2, boolean z3, String str2, boolean z4) {
        super(context, k90, z3);
        this.n = str;
        this.o = z;
        this.p = z2;
        this.q = z3;
        this.r = z4;
    }

    @Override // defpackage.yf1
    public List<RouteInfo> a(String str) {
        List<RouteInfo> list;
        new ArrayList();
        HashMap hashMap = new HashMap();
        String str2 = this.n;
        if (str2 != null) {
            hashMap.put("agency", str2);
        }
        if (this.p) {
            hashMap.put("mticket_enabled", String.valueOf(true));
        }
        if (this.q) {
            hashMap.put("routepass_enabled", String.valueOf(true));
        }
        if (this.q) {
            l00 b = xt.f3961a.b();
            TransitMode transitMode = TransitMode.bus;
            list = b.a(str, hashMap, true);
        } else {
            l00 b2 = xt.f3961a.b();
            TransitMode transitMode2 = TransitMode.bus;
            list = b2.a(str, hashMap, true);
        }
        ArrayList arrayList = new ArrayList();
        for (RouteInfo routeInfo : list) {
            if (routeInfo != null) {
                if (this.o) {
                    if (routeInfo.isMobileTicketing()) {
                        arrayList.add(routeInfo);
                    }
                } else if (this.p) {
                    if (routeInfo.isMTicketEnabled()) {
                        if (!this.r) {
                            arrayList.add(routeInfo);
                        } else if (routeInfo.isFreeRide()) {
                            arrayList.add(routeInfo);
                        }
                    }
                } else if (!this.q) {
                    arrayList.add(routeInfo);
                } else if (routeInfo.isRoutePassEnabled()) {
                    arrayList.add(routeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            this.k = k90.a.NO_MATCH_FOUND;
        }
        return arrayList;
    }
}
