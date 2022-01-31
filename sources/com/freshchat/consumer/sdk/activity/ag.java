package com.freshchat.consumer.sdk.activity;

import androidx.appcompat.widget.SearchView;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.k;

public class ag implements SearchView.OnQueryTextListener {
    public final /* synthetic */ ArticleListActivity ae;

    public ag(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        if (as.a(ArticleListActivity.p(this.ae)) && ArticleListActivity.p(this.ae).length() != 1 && as.isEmpty(str)) {
            bg.a(this.ae.getContext(), ArticleListActivity.p(this.ae), k.b(ArticleListActivity.e(this.ae)), false);
        }
        if (this.ae.dH()) {
            this.ae.onUserInteraction();
        }
        ArticleListActivity.c(this.ae, str);
        ArticleListActivity articleListActivity = this.ae;
        ArticleListActivity.b(articleListActivity, ArticleListActivity.p(articleListActivity));
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        ArticleListActivity.b(this.ae, str);
        return true;
    }
}
