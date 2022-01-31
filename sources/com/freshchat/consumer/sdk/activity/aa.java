package com.freshchat.consumer.sdk.activity;

import android.view.View;

public class aa implements View.OnClickListener {
    public final /* synthetic */ ArticleDetailActivity F;

    public aa(ArticleDetailActivity articleDetailActivity) {
        this.F = articleDetailActivity;
    }

    public void onClick(View view) {
        if (ArticleDetailActivity.i(this.F)) {
            this.F.finish();
        } else {
            ArticleDetailActivity.j(this.F).aE();
        }
        ArticleDetailActivity.k(this.F);
    }
}
