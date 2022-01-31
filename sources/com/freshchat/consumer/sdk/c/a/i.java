package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;

public class i extends c {
    @Override // com.freshchat.consumer.sdk.c.a.h
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("_id", "TEXT", false, 1));
        arrayList.add(new ColDef("frag_type", "INTEGER", false, 1));
        arrayList.add(new ColDef("content", "TEXT", false, 1));
        arrayList.add(new ColDef(FirebaseAnalytics.Param.CONTENT_TYPE, "TEXT", false, 1));
        arrayList.add(new ColDef("position", "INTEGER", false, 1));
        arrayList.add(new ColDef("extras_json", "TEXT", false, 1));
        arrayList.add(new ColDef("uploaded", "INTEGER", true, 1, " DEFAULT 0"));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public String cP() {
        return "fragments";
    }

    @Override // com.freshchat.consumer.sdk.c.a.c
    public String cU() {
        return " PRIMARY KEY (_id,position)";
    }
}
