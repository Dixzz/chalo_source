package com.freshchat.consumer.sdk.activity;

public class ab implements Runnable {
    public final /* synthetic */ ArticleDetailActivity F;

    public ab(ArticleDetailActivity articleDetailActivity) {
        this.F = articleDetailActivity;
    }

    public void run() {
        ArticleDetailActivity.c(this.F).scrollBy(0, 1);
    }
}
