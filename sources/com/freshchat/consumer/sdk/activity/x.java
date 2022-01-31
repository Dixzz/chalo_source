package com.freshchat.consumer.sdk.activity;

import android.view.View;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.n;

public class x implements View.OnClickListener {
    public final /* synthetic */ ArticleDetailActivity F;

    public x(ArticleDetailActivity articleDetailActivity) {
        this.F = articleDetailActivity;
    }

    public void onClick(View view) {
        n.a aVar = view.getId() == R.id.freshchat_upvote ? n.a.Upvote : n.a.Downvote;
        ArticleDetailActivity.a(ArticleDetailActivity.d(this.F));
        d.c(this.F.getContext(), new n(ArticleDetailActivity.e(this.F), ArticleDetailActivity.d(this.F), aVar), new y(this));
        if (view.getId() != R.id.freshchat_downvote || !this.F.g.shouldShowContactUsOnFaqNotHelpful()) {
            ArticleDetailActivity.h(this.F);
        } else {
            ArticleDetailActivity.f(this.F).bringToFront();
            ArticleDetailActivity.f(this.F).setVisibility(0);
            ArticleDetailActivity.g(this.F).setVisibility(8);
        }
        ArticleDetailActivity.a(this.F, aVar);
    }
}
