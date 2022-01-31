package com.freshchat.consumer.sdk.activity;

import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.activity.ConversationDetailActivity;
import com.freshchat.consumer.sdk.j.cq;

public class r extends cq {
    public final /* synthetic */ ConversationDetailActivity.AnonymousClass6 cY;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(ConversationDetailActivity.AnonymousClass6 r1, RecyclerView.e eVar) {
        super(eVar);
        this.cY = r1;
    }

    @Override // com.freshchat.consumer.sdk.j.cq
    public void ht() {
        ConversationDetailActivity.w(ConversationDetailActivity.this).i0(ConversationDetailActivity.d(ConversationDetailActivity.this).size() - 1);
    }
}
