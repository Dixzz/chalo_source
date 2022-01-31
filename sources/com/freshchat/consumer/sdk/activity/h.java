package com.freshchat.consumer.sdk.activity;

public class h implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ int ol;

    public h(ConversationDetailActivity conversationDetailActivity, int i) {
        this.be = conversationDetailActivity;
        this.ol = i;
    }

    public void run() {
        if (ConversationDetailActivity.G(this.be) != null && ConversationDetailActivity.G(this.be).getVisibility() == 0) {
            ConversationDetailActivity.G(this.be).setProgress(this.ol);
        }
    }
}
