package com.freshchat.consumer.sdk.activity;

import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.cj;

public class t implements cj.a {
    public final /* synthetic */ ConversationDetailActivity be;

    public t(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    @Override // com.freshchat.consumer.sdk.j.cj.a
    public void p(Message message) {
        ConversationDetailActivity.e(this.be).A(message);
        ConversationDetailActivity.b(this.be, message);
    }

    @Override // com.freshchat.consumer.sdk.j.cj.a
    public void q(Message message) {
        this.be.a(ConversationDetailActivity.e(this.be).x(message));
    }
}
