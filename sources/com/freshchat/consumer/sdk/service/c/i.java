package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.FreshchatCallbackStatus;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.e.g;
import com.freshchat.consumer.sdk.service.e.w;
import java.util.List;
import java.util.Map;

public class i extends b<g, w> {
    /* renamed from: a */
    public w b(g gVar) {
        FreshchatCallbackStatus freshchatCallbackStatus;
        int i;
        w wVar = new w();
        int i2 = 0;
        try {
            com.freshchat.consumer.sdk.c.g gVar2 = new com.freshchat.consumer.sdk.c.g(getContext());
            List<Channel> d = new c(getContext()).d(gVar.dG());
            if (k.a(d)) {
                Map<Long, Integer> cF = gVar2.cF();
                if (k.d(cF)) {
                    i = 0;
                    for (Channel channel : d) {
                        if (cF.containsKey(Long.valueOf(channel.getId()))) {
                            i += cF.get(Long.valueOf(channel.getId())).intValue();
                        }
                    }
                    freshchatCallbackStatus = FreshchatCallbackStatus.STATUS_SUCCESS;
                    wVar.setSuccess(true);
                    i2 = i;
                    wVar.setCount(i2);
                    wVar.a(freshchatCallbackStatus);
                    return wVar;
                }
            }
            i = 0;
            freshchatCallbackStatus = FreshchatCallbackStatus.STATUS_SUCCESS;
            wVar.setSuccess(true);
            i2 = i;
        } catch (Exception e) {
            FreshchatCallbackStatus freshchatCallbackStatus2 = FreshchatCallbackStatus.STATUS_ERROR;
            q.a(e);
            freshchatCallbackStatus = freshchatCallbackStatus2;
        }
        wVar.setCount(i2);
        wVar.a(freshchatCallbackStatus);
        return wVar;
    }
}
