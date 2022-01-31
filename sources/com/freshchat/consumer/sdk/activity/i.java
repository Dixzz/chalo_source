package com.freshchat.consumer.sdk.activity;

public class i implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ String om;

    public i(ConversationDetailActivity conversationDetailActivity, String str) {
        this.be = conversationDetailActivity;
        this.om = str;
    }

    public void run() {
        if (ConversationDetailActivity.H(this.be) != null && ConversationDetailActivity.H(this.be).getVisibility() == 0) {
            ConversationDetailActivity.H(this.be).setText(this.om);
        }
    }
}
