package com.freshchat.consumer.sdk.activity;

import android.content.DialogInterface;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.j.bg;

public class m implements DialogInterface.OnCancelListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ Csat hF;
    public final /* synthetic */ boolean kJ;

    public m(ConversationDetailActivity conversationDetailActivity, Csat csat, boolean z) {
        this.be = conversationDetailActivity;
        this.hF = csat;
        this.kJ = z;
    }

    public void onCancel(DialogInterface dialogInterface) {
        ConversationDetailActivity.a(this.be, this.hF, this.kJ);
        bg.a(this.be.getContext(), ConversationDetailActivity.c(this.be), this.kJ, 0, null);
        ConversationDetailActivity.I(this.be);
    }
}
