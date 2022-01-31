package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class g extends c {
    @Override // com.freshchat.consumer.sdk.c.a.h
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("conv_id", "INTEGER", false, 1, " PRIMARY KEY "));
        arrayList.add(new ColDef("csat_id", "INTEGER", false, 1));
        arrayList.add(new ColDef("question", "TEXT", false, 1));
        arrayList.add(new ColDef("comments_allowed", "INTEGER", false, 1));
        arrayList.add(new ColDef("mandatory", "INTEGER", false, 1));
        arrayList.add(new ColDef("_status", "INTEGER", false, 1));
        arrayList.add(new ColDef("initiated_time", "INTEGER", false, 2, " DEFAULT 0"));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public String cP() {
        return "custsat";
    }
}
