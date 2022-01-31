package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.j.bg;

public final class bh implements bg.b {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String lM;
    public final /* synthetic */ String lN;
    public final /* synthetic */ String lP;
    public final /* synthetic */ String lQ;
    public final /* synthetic */ boolean ro;

    public bh(String str, String str2, boolean z, Context context, String str3, String str4) {
        this.lM = str;
        this.lN = str2;
        this.ro = z;
        this.iI = context;
        this.lP = str3;
        this.lQ = str4;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        bg.a aVar = bg.a(Event.EventName.FCEventFAQVote).a(Event.Property.FCPropertyFAQCategoryName, this.lM).a(Event.Property.FCPropertyFAQTitle, this.lN).a(Event.Property.FCPropertyIsHelpful, Boolean.valueOf(this.ro));
        Category category = bg.A(this.iI, this.lP);
        if (category != null) {
            bg.a unused = aVar.a(Event.Property.FCPropertyFAQCategoryID, category.getCategoryAlias());
        }
        Article article = bg.z(this.iI, this.lQ);
        if (article != null) {
            bg.a unused2 = aVar.a(Event.Property.FCPropertyFAQID, article.getArticleAlias());
        }
        return aVar.gz();
    }
}
