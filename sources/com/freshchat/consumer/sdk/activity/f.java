package com.freshchat.consumer.sdk.activity;

public class f implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ int nU;

    public f(ConversationDetailActivity conversationDetailActivity, int i) {
        this.be = conversationDetailActivity;
        this.nU = i;
    }

    public void run() {
        if (ConversationDetailActivity.G(this.be) != null && ConversationDetailActivity.G(this.be).getVisibility() == 0) {
            ConversationDetailActivity.G(this.be).setMax(this.nU);
        }
    }
}
