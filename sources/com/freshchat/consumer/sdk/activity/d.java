package com.freshchat.consumer.sdk.activity;

import android.view.View;

public class d implements Runnable {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ View cV;

    public d(ConversationDetailActivity conversationDetailActivity, View view) {
        this.be = conversationDetailActivity;
        this.cV = view;
    }

    public void run() {
        View view = this.cV;
        if (view != null && view.getVisibility() == 0) {
            this.cV.setVisibility(8);
        }
    }
}
