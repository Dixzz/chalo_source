package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class l extends c {
    @Override // com.freshchat.consumer.sdk.c.a.h
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("name", "TEXT", false, 1));
        arrayList.add(new ColDef("tagged_id", "TEXT", false, 1));
        arrayList.add(new ColDef("tagged_type", "TEXT", true, 1));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public String cP() {
        return "tags";
    }
}
