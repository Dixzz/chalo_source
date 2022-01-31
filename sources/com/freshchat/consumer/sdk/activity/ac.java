package com.freshchat.consumer.sdk.activity;

import android.os.Bundle;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.g.b;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import defpackage.ii;
import java.util.List;

public class ac implements ii.a<List<Article>> {
    public final /* synthetic */ ArticleListActivity ae;

    public ac(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    /* renamed from: a */
    public void onLoadFinished(li<List<Article>> liVar, List<Article> list) {
        if (ArticleListActivity.b(this.ae) && !((b) liVar).gE()) {
            int b = k.b(list);
            if (b == 0) {
                this.ae.finish();
                i.a(this.ae.getContext(), R.string.freshchat_faqs_reload_and_redirect);
                Freshchat.showFAQs(this.ae.getContext(), this.ae.g);
                return;
            } else if (b == 1 && list.get(0) != null) {
                this.ae.finish();
                this.ae.a(Long.parseLong(list.get(0).getId()));
                return;
            }
        }
        ArticleListActivity.e(this.ae).clear();
        ArticleListActivity.e(this.ae).addAll(list);
        ArticleListActivity.f(this.ae);
        ArticleListActivity.g(this.ae);
    }

    @Override // defpackage.ii.a
    public li<List<Article>> onCreateLoader(int i, Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("search_key") && as.a(bundle.getString("search_key"))) {
                String string = bundle.getString("search_key");
                ArticleListActivity.a(this.ae, "article_search");
                if (bundle.containsKey("category_ids")) {
                    return new b(this.ae.getApplicationContext(), ArticleListActivity.a(this.ae), null, bundle.getStringArrayList("category_ids"), string, true);
                } else if (!ArticleListActivity.b(this.ae) || !bundle.containsKey("FAQ_TAGS")) {
                    return new b(this.ae.getApplicationContext(), string, true, ArticleListActivity.a(this.ae), true);
                } else {
                    return new b(this.ae.getApplicationContext(), ArticleListActivity.a(this.ae), bundle.getStringArrayList("FAQ_TAGS"), null, string, true);
                }
            } else if (bundle.containsKey("category_ids")) {
                return new b(this.ae.getApplicationContext(), ArticleListActivity.a(this.ae), null, bundle.getStringArrayList("category_ids"), "", false);
            } else if (bundle.containsKey("FAQ_TAGS")) {
                ArticleListActivity.c(this.ae);
                ArticleListActivity.a(this.ae, bundle.getStringArrayList("FAQ_TAGS"));
                return new b(this.ae.getApplicationContext(), ArticleListActivity.a(this.ae), ArticleListActivity.d(this.ae), null, "", false);
            }
        }
        return new b(this.ae.getApplicationContext(), ArticleListActivity.a(this.ae));
    }

    @Override // defpackage.ii.a
    public void onLoaderReset(li<List<Article>> liVar) {
        ArticleListActivity.e(this.ae).clear();
        ArticleListActivity.h(this.ae).notifyDataSetChanged();
    }
}
