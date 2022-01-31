package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class e extends c {
    @Override // com.freshchat.consumer.sdk.c.a.h
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("_id", "INTEGER", false, 1, " PRIMARY KEY "));
        arrayList.add(new ColDef("name", "TEXT", false, 1));
        arrayList.add(new ColDef("position", "TEXT", false, 1));
        arrayList.add(new ColDef("icon", "TEXT", false, 1));
        arrayList.add(new ColDef("hidden", "INTEGER", true, 1));
        arrayList.add(new ColDef("type", "TEXT", false, 1));
        arrayList.add(new ColDef("is_default", "INTEGER", true, 1, " DEFAULT 0"));
        arrayList.add(new ColDef("restricted", "INTEGER", true, 1, " DEFAULT 0"));
        arrayList.add(new ColDef("updated_at", "INTEGER", true, 1, " DEFAULT 0"));
        arrayList.add(new ColDef("channel_alias", "TEXT", true, 3));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public String cP() {
        return "channels";
    }
}
