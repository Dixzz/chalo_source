package com.freshchat.consumer.sdk.activity;

import android.net.ConnectivityManager;
import android.net.Network;
import com.freshchat.consumer.sdk.j.aa;

public class q extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ ConversationDetailActivity be;

    public q(ConversationDetailActivity conversationDetailActivity) {
        this.be = conversationDetailActivity;
    }

    public void onAvailable(Network network) {
        aa.c(this.be.getContext(), true);
    }

    public void onLost(Network network) {
        aa.c(this.be.getContext(), false);
    }
}
