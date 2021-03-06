package com.freshchat.consumer.sdk.j;

import android.os.Bundle;
import com.freshchat.consumer.sdk.ConversationOptions;
import com.freshchat.consumer.sdk.activity.ChannelListActivity;
import com.freshchat.consumer.sdk.activity.ConversationDetailActivity;
import com.freshchat.consumer.sdk.activity.InterstitialActivity;
import com.freshchat.consumer.sdk.beans.Channel;
import java.util.List;

public class m extends c<ConversationOptions> {
    public void c(Channel channel) {
        if (channel != null) {
            a(ConversationDetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putLong("CHANNEL_ID", channel.getId());
            bundle.putString("CHANNEL_NAME", channel.getName());
            bundle.putString("CHANNEL_TYPE", channel.getChannelType());
            b(bundle);
        }
    }

    @Override // com.freshchat.consumer.sdk.j.c
    public void ea() {
        ev();
    }

    @Override // com.freshchat.consumer.sdk.j.c
    public Bundle eb() {
        Bundle bundle = new Bundle();
        bundle.putAll(l.a((ConversationOptions) ec()));
        bundle.putString("OPTIONS_TYPE", ConversationOptions.class.getSimpleName());
        return bundle;
    }

    public void eu() {
        a(ChannelListActivity.class);
        b(null);
    }

    public void ev() {
        a(InterstitialActivity.class);
        b(null);
    }

    public void u(List<Channel> list) {
        if (k.b(list) != 1 || list.get(0) == null) {
            eu();
        } else {
            c(list.get(0));
        }
    }
}
