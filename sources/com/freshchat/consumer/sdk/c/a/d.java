package com.freshchat.consumer.sdk.c.a;

import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.freshchat.consumer.sdk.beans.ColDef;
import java.util.ArrayList;

public class d extends c {
    @Override // com.freshchat.consumer.sdk.c.a.h
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("_id", "INTEGER", false, 1, " PRIMARY KEY "));
        arrayList.add(new ColDef(ProductPromotionsObject.KEY_TITLE, "TEXT", false, 1));
        arrayList.add(new ColDef("description", "TEXT", false, 1));
        arrayList.add(new ColDef("icon_url", "TEXT", true, 1));
        arrayList.add(new ColDef("position", "INTEGER", false, 1));
        arrayList.add(new ColDef("updated_at", "INTEGER", false, 1));
        arrayList.add(new ColDef("category_alias", "TEXT", true, 3));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public String cP() {
        return "categories";
    }
}
