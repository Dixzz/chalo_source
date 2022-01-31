package com.freshchat.consumer.sdk.activity;

public class p implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;

    public p(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void run() {
        ConversationDetailActivity.q(this.be).notifyDataSetChanged();
    }
}
