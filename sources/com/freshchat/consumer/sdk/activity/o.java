package com.freshchat.consumer.sdk.activity;

import android.content.DialogInterface;
import android.widget.Button;

public class o implements DialogInterface.OnShowListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ boolean bm;

    public o(ConversationDetailActivity conversationDetailActivity, boolean z) {
        this.be = conversationDetailActivity;
        this.bm = z;
    }

    public void onShow(DialogInterface dialogInterface) {
        Button d = ((e0) dialogInterface).d(-1);
        if (d != null && this.bm) {
            d.setEnabled(false);
        }
    }
}
