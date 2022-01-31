package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class k extends c {
    @Override // com.freshchat.consumer.sdk.c.a.h
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("alias", "TEXT", true, 1, " PRIMARY KEY "));
        arrayList.add(new ColDef("first_name", "TEXT", true, 1));
        arrayList.add(new ColDef("last_name", "TEXT", true, 1));
        arrayList.add(new ColDef("profile_pic_url", "TEXT", true, 1));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public String cP() {
        return "participants";
    }
}
