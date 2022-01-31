package defpackage;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import defpackage.cq3;
import defpackage.dq3;
import defpackage.eq3;
import defpackage.gq3;
import defpackage.nq3;
import defpackage.oq3;
import defpackage.ru3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* renamed from: qb4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
public final class qb4 extends jg4 implements f64 {
    public final Map<String, Map<String, String>> d = new n2();
    public final Map<String, Map<String, Boolean>> e = new n2();
    public final Map<String, Map<String, Boolean>> f = new n2();
    public final Map<String, oq3> g = new n2();
    public final Map<String, Map<String, Integer>> h = new n2();
    public final Map<String, String> i = new n2();

    public qb4(lg4 lg4) {
        super(lg4);
    }

    public static Map<String, String> t(oq3 oq3) {
        n2 n2Var = new n2();
        for (pq3 pq3 : oq3.A()) {
            n2Var.put(pq3.t(), pq3.u());
        }
        return n2Var;
    }

    public final long A(String str) {
        String zza = zza(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(zza)) {
            return 0;
        }
        try {
            return Long.parseLong(zza);
        } catch (NumberFormatException e2) {
            g().i.c("Unable to parse timezone offset. appId", ra4.q(str), e2);
            return 0;
        }
    }

    public final boolean B(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean C(String str) {
        return "1".equals(zza(str, "measurement.upload.blacklist_public"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00d6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void D(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qb4.D(java.lang.String):void");
    }

    @Override // defpackage.jg4
    public final boolean n() {
        return false;
    }

    public final oq3 q(String str) {
        k();
        b();
        gj1.j(str);
        D(str);
        return this.g.get(str);
    }

    public final oq3 s(String str, byte[] bArr) {
        if (bArr == null) {
            return oq3.F();
        }
        try {
            oq3 oq3 = (oq3) ((ru3) ((oq3.a) rg4.w(oq3.E(), bArr)).k());
            ta4 ta4 = g().n;
            String str2 = null;
            Long valueOf = oq3.w() ? Long.valueOf(oq3.x()) : null;
            if (oq3.y()) {
                str2 = oq3.z();
            }
            ta4.c("Parsed config. version, gmp_app_id", valueOf, str2);
            return oq3;
        } catch (cv3 e2) {
            g().i.c("Unable to merge remote config. appId", ra4.q(str), e2);
            return oq3.F();
        } catch (RuntimeException e3) {
            g().i.c("Unable to merge remote config. appId", ra4.q(str), e3);
            return oq3.F();
        }
    }

    public final void u(String str, oq3.a aVar) {
        n2 n2Var = new n2();
        n2 n2Var2 = new n2();
        n2 n2Var3 = new n2();
        for (int i2 = 0; i2 < ((oq3) aVar.g).B(); i2++) {
            nq3.a aVar2 = (nq3.a) ((oq3) aVar.g).t(i2).s();
            if (TextUtils.isEmpty(aVar2.l())) {
                g().i.a("EventConfig contained null event name");
            } else {
                String l = aVar2.l();
                String b = wc4.b(aVar2.l());
                if (!TextUtils.isEmpty(b)) {
                    if (aVar2.h) {
                        aVar2.i();
                        aVar2.h = false;
                    }
                    nq3.u((nq3) aVar2.g, b);
                    if (aVar.h) {
                        aVar.i();
                        aVar.h = false;
                    }
                    oq3.v((oq3) aVar.g, i2, (nq3) ((ru3) aVar2.k()));
                }
                if (!yx3.a() || !this.f3331a.g.l(q64.N0)) {
                    n2Var.put(aVar2.l(), Boolean.valueOf(((nq3) aVar2.g).v()));
                } else {
                    n2Var.put(l, Boolean.valueOf(((nq3) aVar2.g).v()));
                }
                n2Var2.put(aVar2.l(), Boolean.valueOf(((nq3) aVar2.g).w()));
                if (((nq3) aVar2.g).x()) {
                    if (aVar2.m() < 2 || aVar2.m() > 65535) {
                        g().i.c("Invalid sampling rate. Event name, sample rate", aVar2.l(), Integer.valueOf(aVar2.m()));
                    } else {
                        n2Var3.put(aVar2.l(), Integer.valueOf(aVar2.m()));
                    }
                }
            }
        }
        this.e.put(str, n2Var);
        this.f.put(str, n2Var2);
        this.h.put(str, n2Var3);
    }

    public final boolean v(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        boolean z;
        String str3;
        boolean z2;
        boolean z3;
        k();
        b();
        gj1.j(str);
        oq3.a aVar = (oq3.a) s(str, bArr).s();
        u(str, aVar);
        this.g.put(str, (oq3) ((ru3) aVar.k()));
        this.i.put(str, str2);
        this.d.put(str, t((oq3) ((ru3) aVar.k())));
        h64 o = o();
        ArrayList arrayList = new ArrayList(Collections.unmodifiableList(((oq3) aVar.g).C()));
        Objects.requireNonNull(o);
        String str4 = "app_id=? and audience_id=?";
        String str5 = "null reference";
        int i2 = 0;
        while (i2 < arrayList.size()) {
            cq3.a aVar2 = (cq3.a) ((cq3) arrayList.get(i2)).s();
            if (((cq3) aVar2.g).C() != 0) {
                int i3 = 0;
                while (i3 < ((cq3) aVar2.g).C()) {
                    dq3.a aVar3 = (dq3.a) ((cq3) aVar2.g).y(i3).s();
                    dq3.a aVar4 = (dq3.a) ((ru3.b) aVar3.clone());
                    String b = wc4.b(((dq3) aVar3.g).y());
                    if (b != null) {
                        if (aVar4.h) {
                            aVar4.i();
                            aVar4.h = false;
                        }
                        dq3.v((dq3) aVar4.g, b);
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    int i4 = 0;
                    while (i4 < ((dq3) aVar3.g).A()) {
                        eq3 t = ((dq3) aVar3.g).t(i4);
                        String G3 = hd3.G3(t.B(), vc4.f3631a, vc4.b);
                        if (G3 != null) {
                            eq3.a aVar5 = (eq3.a) t.s();
                            if (aVar5.h) {
                                aVar5.i();
                                aVar5.h = false;
                            }
                            eq3.t((eq3) aVar5.g, G3);
                            eq3 eq3 = (eq3) ((ru3) aVar5.k());
                            if (aVar4.h) {
                                aVar4.i();
                                aVar4.h = false;
                            }
                            dq3.u((dq3) aVar4.g, i4, eq3);
                            z3 = true;
                        }
                        i4++;
                        aVar3 = aVar3;
                        str4 = str4;
                        str5 = str5;
                    }
                    if (z3) {
                        if (aVar2.h) {
                            aVar2.i();
                            aVar2.h = false;
                        }
                        cq3.u((cq3) aVar2.g, i3, (dq3) ((ru3) aVar4.k()));
                        arrayList.set(i2, (cq3) ((ru3) aVar2.k()));
                    }
                    i3++;
                    aVar = aVar;
                    str4 = str4;
                    str5 = str5;
                }
            }
            if (((cq3) aVar2.g).A() != 0) {
                for (int i5 = 0; i5 < ((cq3) aVar2.g).A(); i5++) {
                    gq3 t2 = ((cq3) aVar2.g).t(i5);
                    String G32 = hd3.G3(t2.w(), yc4.f4031a, yc4.b);
                    if (G32 != null) {
                        gq3.a aVar6 = (gq3.a) t2.s();
                        if (aVar6.h) {
                            aVar6.i();
                            z2 = false;
                            aVar6.h = false;
                        } else {
                            z2 = false;
                        }
                        gq3.t((gq3) aVar6.g, G32);
                        if (aVar2.h) {
                            aVar2.i();
                            aVar2.h = z2;
                        }
                        cq3.v((cq3) aVar2.g, i5, (gq3) ((ru3) aVar6.k()));
                        arrayList.set(i2, (cq3) ((ru3) aVar2.k()));
                    }
                }
            }
            i2++;
            aVar = aVar;
            str4 = str4;
            str5 = str5;
        }
        String str6 = str4;
        String str7 = str5;
        o.k();
        o.b();
        gj1.j(str);
        SQLiteDatabase s = o.s();
        s.beginTransaction();
        try {
            o.k();
            o.b();
            gj1.j(str);
            SQLiteDatabase s2 = o.s();
            s2.delete("property_filters", "app_id=?", new String[]{str});
            s2.delete("event_filters", "app_id=?", new String[]{str});
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                cq3 cq3 = (cq3) it.next();
                o.k();
                o.b();
                gj1.j(str);
                Objects.requireNonNull(cq3, str7);
                if (!cq3.w()) {
                    o.g().i.b("Audience with no ID. appId", ra4.q(str));
                } else {
                    int x = cq3.x();
                    Iterator<dq3> it2 = cq3.B().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (!it2.next().w()) {
                                o.g().i.c("Event filter with no ID. Audience definition ignored. appId, audienceId", ra4.q(str), Integer.valueOf(x));
                                break;
                            }
                        } else {
                            for (gq3 gq3 : cq3.z()) {
                                if (!gq3.u()) {
                                    o.g().i.c("Property filter with no ID. Audience definition ignored. appId, audienceId", ra4.q(str), Integer.valueOf(x));
                                }
                            }
                            Iterator<dq3> it3 = cq3.B().iterator();
                            while (true) {
                                if (it3.hasNext()) {
                                    if (!o.N(str, x, it3.next())) {
                                        z = false;
                                        break;
                                    }
                                } else {
                                    z = true;
                                    break;
                                }
                            }
                            if (z) {
                                Iterator<gq3> it4 = cq3.z().iterator();
                                while (true) {
                                    if (it4.hasNext()) {
                                        if (!o.O(str, x, it4.next())) {
                                            z = false;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            }
                            if (!z) {
                                o.k();
                                o.b();
                                gj1.j(str);
                                SQLiteDatabase s3 = o.s();
                                str3 = str6;
                                s3.delete("property_filters", str3, new String[]{str, String.valueOf(x)});
                                s3.delete("event_filters", str3, new String[]{str, String.valueOf(x)});
                            } else {
                                str3 = str6;
                            }
                            str7 = str7;
                            str6 = str3;
                        }
                    }
                }
                str7 = str7;
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                cq3 cq32 = (cq3) it5.next();
                arrayList2.add(cq32.w() ? Integer.valueOf(cq32.x()) : null);
            }
            o.V(str, arrayList2);
            s.setTransactionSuccessful();
            try {
                if (aVar.h) {
                    aVar.i();
                    aVar.h = false;
                }
                oq3.u((oq3) aVar.g);
                bArr2 = ((oq3) ((ru3) aVar.k())).h();
            } catch (RuntimeException e2) {
                g().i.c("Unable to serialize reduced-size config. Storing full config instead. appId", ra4.q(str), e2);
                bArr2 = bArr;
            }
            h64 o2 = o();
            gj1.j(str);
            o2.b();
            o2.k();
            ContentValues contentValues = new ContentValues();
            contentValues.put("remote_config", bArr2);
            try {
                if (((long) o2.s().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                    o2.g().f.b("Failed to update remote config (got 0). appId", ra4.q(str));
                }
            } catch (SQLiteException e3) {
                o2.g().f.c("Error storing remote config. appId", ra4.q(str), e3);
            }
            this.g.put(str, (oq3) ((ru3) aVar.k()));
            return true;
        } finally {
            s.endTransaction();
        }
    }

    public final boolean w(String str, String str2) {
        Boolean bool;
        b();
        D(str);
        if ("1".equals(zza(str, "measurement.upload.blacklist_internal")) && ug4.q0(str2)) {
            return true;
        }
        if ("1".equals(zza(str, "measurement.upload.blacklist_public")) && ug4.W(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.e.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean x(String str, String str2) {
        Boolean bool;
        b();
        D(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2) || "purchase".equals(str2) || FirebaseAnalytics.Event.REFUND.equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final int y(String str, String str2) {
        Integer num;
        b();
        D(str);
        Map<String, Integer> map = this.h.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final boolean z(String str) {
        b();
        oq3 q = q(str);
        if (q == null) {
            return false;
        }
        return q.D();
    }

    @Override // defpackage.f64
    public final String zza(String str, String str2) {
        b();
        D(str);
        Map<String, String> map = this.d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }
}
