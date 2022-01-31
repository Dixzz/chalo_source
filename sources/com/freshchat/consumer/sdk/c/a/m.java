package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class m extends c {
    @Override // com.freshchat.consumer.sdk.c.a.h
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("meta_key", "TEXT", false, 1, " UNIQUE "));
        arrayList.add(new ColDef("meta_value", "TEXT", false, 1));
        arrayList.add(new ColDef("is_uploaded", "INTEGER", false, 1, " DEFAULT 0"));
        arrayList.add(new ColDef("meta_type", "INTEGER", false, 1, " DEFAULT 2"));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public String cP() {
        return "user_meta";
    }
}
