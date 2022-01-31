package com.freshchat.consumer.sdk.activity;

import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import com.freshchat.consumer.sdk.service.d.b;

public class ad implements g8 {
    public final /* synthetic */ ArticleListActivity ae;

    public ad(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    @Override // defpackage.g8
    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        ArticleListActivity.a(this.ae, false);
        ArticleListActivity.b(this.ae, true);
        if (ArticleListActivity.m(this.ae)) {
            this.ae.e(" ");
            this.ae.finish();
        }
        ArticleListActivity.n(this.ae);
        ArticleListActivity.k(this.ae);
        ArticleListActivity.l(this.ae);
        return true;
    }

    @Override // defpackage.g8
    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        ArticleListActivity.a(this.ae, true);
        if (ArticleListActivity.i(this.ae) && (menuItem.getActionView() instanceof SearchView)) {
            ArticleListActivity.a(this.ae, (SearchView) menuItem.getActionView());
            ArticleListActivity.j(this.ae).setQuery(" ", true);
            ArticleListActivity.j(this.ae).performClick();
        }
        ArticleListActivity.g(this.ae);
        ArticleListActivity.k(this.ae);
        ArticleListActivity.l(this.ae);
        new b(this.ae.getApplicationContext(), b.a.faq_search_launch).g("source", "article_list").dB();
        return true;
    }
}
