package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.config.RefreshIntervals;
import com.freshchat.consumer.sdk.beans.config.RemoteConfig;
import com.freshchat.consumer.sdk.beans.reqres.ConversationsResponse;
import com.freshchat.consumer.sdk.c.e;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.e.a;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.j.ap;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.au;
import com.freshchat.consumer.sdk.j.b;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.d;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import java.util.List;

public class f extends a<d, k> {
    private long a(d.a aVar) {
        RefreshIntervals refreshIntervals = ap.bD(getContext()).getRefreshIntervals();
        if (aVar == d.a.IMMEDIATE) {
            return 0;
        }
        if (aVar == d.a.NORMAL) {
            return refreshIntervals.getMsgFetchIntervalNormal();
        }
        if (aVar == d.a.LAID_BACK) {
            return refreshIntervals.getMsgFetchIntervalLaidback();
        }
        return 0;
    }

    private List<Message> s(List<Message> list) {
        for (Message message : list) {
            message.setUploadState(1);
        }
        return list;
    }

    private List<Message> y(List<Message> list) {
        for (Message message : list) {
            if (message.isUserMessage()) {
                message.setRead(true);
            }
        }
        return list;
    }

    /* renamed from: a */
    public k b(d dVar) {
        Context context;
        h hVar = new h(true);
        try {
            Context applicationContext = getContext().getApplicationContext();
            if (b(dVar)) {
                if (al.aS(applicationContext)) {
                    g gVar = new g(applicationContext);
                    int gr = gVar.gr();
                    e eVar = new e(applicationContext);
                    com.freshchat.consumer.sdk.b.e dw = dw();
                    String valueOf = String.valueOf(gVar.cD());
                    boolean isEmpty = as.isEmpty(dw.bJ());
                    ai.d("FRESHCHAT", "Messages firstTimeFetch:" + isEmpty);
                    ConversationsResponse a2 = new a(applicationContext).a(valueOf, dVar.dE());
                    List<Conversation> conversations = a2.getConversations();
                    if (conversations != null) {
                        if (conversations.size() != 0) {
                            eVar.f(conversations);
                            boolean z = false;
                            for (Conversation conversation : conversations) {
                                long conversationId = conversation.getConversationId();
                                if (conversation.hasPendingCsat()) {
                                    boolean z2 = eVar.g(conversationId) == null;
                                    Csat csat = conversation.getCsat();
                                    if (z2 && csat != null) {
                                        RemoteConfig bD = ap.bD(getContext());
                                        if (!(au.a(bD) && au.a(bD, csat))) {
                                            eVar.a(conversationId, csat);
                                        } else {
                                            context = applicationContext;
                                            bg.c(getContext(), conversation.getChannelId(), conversationId);
                                        }
                                    }
                                    context = applicationContext;
                                } else {
                                    context = applicationContext;
                                    eVar.t(conversationId);
                                }
                                if (conversation.isRequireDebugLog()) {
                                    dw.d(conversation.getLogId());
                                    b.R(getContext());
                                }
                                List<Message> messages = conversation.getMessages();
                                if (com.freshchat.consumer.sdk.j.k.isEmpty(messages)) {
                                    applicationContext = context;
                                } else {
                                    cm.a(getContext(), messages, conversation.getChannelId());
                                    gVar.a(y(s(messages)), conversation.getChannelId());
                                    applicationContext = context;
                                    z = true;
                                }
                            }
                            if (z) {
                                com.freshchat.consumer.sdk.b.a.g(applicationContext);
                                com.freshchat.consumer.sdk.b.a.f(applicationContext);
                                com.freshchat.consumer.sdk.b.a.aJ(applicationContext);
                            }
                            if (gVar.gr() > gr) {
                                bg.bK(getContext());
                            }
                            dw.bK();
                            return hVar;
                        }
                    }
                    hVar.setSuccess(false);
                    if (!(a2.getStatusCode() == 412 || a2.getStatusCode() == 428)) {
                        dw.bK();
                    }
                }
            }
            return hVar;
        } catch (DeletedException | Exception e) {
            q.a(e);
            hVar.setSuccess(false);
            return hVar;
        }
    }

    public boolean b(d dVar) {
        if (!w.ay(getContext()) || !w.aA(getContext()) || !dw().bl()) {
            return false;
        }
        String bJ = dw().bJ();
        if (as.isEmpty(bJ)) {
            return true;
        }
        return System.currentTimeMillis() - Long.parseLong(bJ) > a(dVar.dD());
    }
}
