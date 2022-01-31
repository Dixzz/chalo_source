package com.freshchat.consumer.sdk.activity;

public class au implements Runnable {
    public final /* synthetic */ FAQDetailsActivity pI;

    public au(FAQDetailsActivity fAQDetailsActivity) {
        this.pI = fAQDetailsActivity;
    }

    public void run() {
        FAQDetailsActivity.c(this.pI).scrollBy(0, 1);
    }
}
