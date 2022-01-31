package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.j.bg;
import java.util.Arrays;

public final class bq implements bg.b {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String lM;
    public final /* synthetic */ String lP;
    public final /* synthetic */ String[] lS;

    public bq(String str, Context context, String str2, String[] strArr) {
        this.lM = str;
        this.iI = context;
        this.lP = str2;
        this.lS = strArr;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        bg.a aVar = bg.a(Event.EventName.FCEventFAQListOpen).a(Event.Property.FCPropertyFAQCategoryName, this.lM);
        Category category = bg.A(this.iI, this.lP);
        if (category != null) {
            bg.a unused = aVar.a(Event.Property.FCPropertyFAQCategoryID, category.getCategoryAlias());
        }
        if (as.f(this.lS)) {
            bg.a unused2 = aVar.a(Event.Property.FCPropertyInputTags, Arrays.toString(this.lS));
        }
        return aVar.gz();
    }
}
