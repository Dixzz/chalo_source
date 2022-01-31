package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import com.freshchat.consumer.sdk.j.as;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class c implements h {
    private Set<Integer> fN() {
        HashSet hashSet = new HashSet();
        for (ColDef colDef : cO()) {
            hashSet.add(Integer.valueOf(colDef.getVersionNumber()));
        }
        return hashSet;
    }

    public static List<String> m(int i) {
        ArrayList arrayList = new ArrayList();
        h[] hVarArr = n.eq;
        for (h hVar : hVarArr) {
            if (hVar.fL() <= i) {
                arrayList.add(hVar.cT());
                arrayList.add(hVar.n(i));
            }
        }
        return arrayList;
    }

    public static List<String> q(int i) {
        ArrayList arrayList = new ArrayList();
        h[] hVarArr = n.eq;
        for (h hVar : hVarArr) {
            int fL = hVar.fL();
            int fM = hVar.fM();
            if (fL <= i && fM >= i) {
                if (fL == i) {
                    arrayList.add(hVar.cT());
                    arrayList.add(hVar.n(i));
                } else if (fL < fM) {
                    ColDef[] cO = hVar.cO();
                    for (ColDef colDef : cO) {
                        if (colDef.getVersionNumber() == i) {
                            StringBuilder i0 = hj1.i0("ALTER TABLE ");
                            i0.append(hVar.cP());
                            i0.append(" ADD COLUMN ");
                            i0.append(colDef.getColumnDefForQuery());
                            arrayList.add(i0.toString());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public final String[] cR() {
        ColDef[] cO = cO();
        String[] strArr = new String[cO.length];
        int length = cO.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            strArr[i2] = cO[i].getColumnName();
            i++;
            i2++;
        }
        return strArr;
    }

    public final String cS() {
        return k(true);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public final String cT() {
        StringBuilder i0 = hj1.i0("DROP TABLE IF EXISTS ");
        i0.append(cP());
        i0.append(";");
        return i0.toString();
    }

    public String cU() {
        return "";
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public final int fL() {
        return ((Integer) Collections.min(fN())).intValue();
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public final int fM() {
        return ((Integer) Collections.max(fN())).intValue();
    }

    public final String k(boolean z) {
        StringBuilder sb = new StringBuilder();
        String[] cR = cR();
        sb.append("INSERT");
        sb.append(z ? " OR REPLACE " : " ");
        sb.append(" INTO ");
        sb.append(cP());
        sb.append("(");
        hj1.V0(sb, as.a(cR, ","), ")", " VALUES ", "(");
        sb.append(as.a("?", ",", cR.length));
        sb.append(");");
        return sb.toString();
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public final String n(int i) {
        StringBuilder i0 = hj1.i0("CREATE TABLE IF NOT EXISTS ");
        i0.append(cP());
        i0.append("(");
        ColDef[] cO = cO();
        String str = "";
        for (ColDef colDef : cO) {
            if (colDef.getVersionNumber() <= i) {
                i0.append(str);
                i0.append(colDef.getColumnDefForQuery());
                str = ",";
            }
        }
        if (as.a(cU())) {
            i0.append(",");
            i0.append(cU());
        }
        i0.append(")");
        return i0.toString();
    }
}
