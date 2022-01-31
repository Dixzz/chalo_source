package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class f extends c {
    @Override // com.freshchat.consumer.sdk.c.a.h
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("_id", "TEXT", false, 1, " PRIMARY KEY "));
        arrayList.add(new ColDef("channel_id", "TEXT", false, 1));
        arrayList.add(new ColDef("has_pending_csat", "INTEGER", false, 1, " DEFAULT 0"));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public String cP() {
        return "conversations";
    }
}
