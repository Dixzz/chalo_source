package com.freshchat.consumer.sdk.k;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.fragment.CarouselFragment;
import com.freshchat.consumer.sdk.beans.fragment.CollectionFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyDropDownFragment;
import com.freshchat.consumer.sdk.j.k;
import java.util.List;

public class h extends a {
    public h(Context context) {
        super(context);
    }

    private MessageFragment D(List<Message> list) {
        Message F = F(list);
        if (F == null) {
            return null;
        }
        return F.getReplyFragments().get(0);
    }

    private Message F(List<Message> list) {
        if (k.isEmpty(list)) {
            return null;
        }
        Message message = list.get(k.b(list) - 1);
        if (k.isEmpty(message.getReplyFragments())) {
            return null;
        }
        return message;
    }

    private com.freshchat.consumer.sdk.b.k c(MessageFragment messageFragment) {
        return messageFragment == null ? com.freshchat.consumer.sdk.b.k.NONE : messageFragment instanceof QuickReplyDropDownFragment ? com.freshchat.consumer.sdk.b.k.DROP_DOWN : messageFragment instanceof CollectionFragment ? com.freshchat.consumer.sdk.b.k.NORMAL : messageFragment instanceof CarouselFragment ? com.freshchat.consumer.sdk.b.k.CAROUSEL : com.freshchat.consumer.sdk.b.k.NONE;
    }

    public QuickReplyDropDownFragment A(List<Message> list) {
        MessageFragment D = D(list);
        if (D == null || com.freshchat.consumer.sdk.b.k.DROP_DOWN != c(D)) {
            return null;
        }
        return (QuickReplyDropDownFragment) D;
    }

    public CollectionFragment B(List<Message> list) {
        MessageFragment D = D(list);
        if (D == null || com.freshchat.consumer.sdk.b.k.NORMAL != c(D)) {
            return null;
        }
        return (CollectionFragment) D;
    }

    public com.freshchat.consumer.sdk.b.k C(List<Message> list) {
        return c(D(list));
    }

    public long E(List<Message> list) {
        Message F = F(list);
        if (F == null) {
            return -1;
        }
        return F.getId();
    }
}
