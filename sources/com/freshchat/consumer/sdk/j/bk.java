package com.freshchat.consumer.sdk.j;

import android.content.Context;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.j.bg;
import java.util.Arrays;

public final class bk implements bg.b {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String lM;
    public final /* synthetic */ String lN;
    public final /* synthetic */ String lP;
    public final /* synthetic */ String lQ;
    public final /* synthetic */ String[] lS;

    public bk(String str, String str2, Context context, String str3, String str4, String[] strArr) {
        this.lN = str;
        this.lM = str2;
        this.iI = context;
        this.lP = str3;
        this.lQ = str4;
        this.lS = strArr;
    }

    @Override // com.freshchat.consumer.sdk.j.bg.b
    public Event gy() {
        bg.a aVar = bg.a(Event.EventName.FCEventFAQOpen).a(Event.Property.FCPropertyFAQTitle, this.lN).a(Event.Property.FCPropertyFAQCategoryName, this.lM);
        Category category = bg.A(this.iI, this.lP);
        if (category != null) {
            bg.a unused = aVar.a(Event.Property.FCPropertyFAQCategoryID, category.getCategoryAlias());
        }
        Article article = bg.z(this.iI, this.lQ);
        if (article != null) {
            bg.a unused2 = aVar.a(Event.Property.FCPropertyFAQID, article.getArticleAlias());
        }
        if (as.f(this.lS)) {
            bg.a unused3 = aVar.a(Event.Property.FCPropertyInputTags, Arrays.toString(this.lS));
        }
        return aVar.gz();
    }
}
