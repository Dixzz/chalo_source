package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.ConversationReadStatus;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.c.g;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a.a;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.x;
import java.util.HashMap;

public class u extends a<x, k> {
    private void b(x xVar) {
        HashMap m0 = hj1.m0("fc_conv_read_status", new ab().toJson(xVar));
        StringBuilder i0 = hj1.i0("7_");
        i0.append(xVar.getChannelId());
        aa.c(getContext(), new a(7, i0.toString()).b(m0));
    }

    /* renamed from: a */
    public k b(x xVar) {
        DeletedException e;
        Exception e2;
        Context applicationContext = getContext().getApplicationContext();
        boolean z = true;
        try {
            ConversationReadStatus conversationReadStatus = new ConversationReadStatus(xVar.getChannelId(), xVar.getConversationId(), xVar.getReadUpto());
            if (conversationReadStatus.getReadUpto() <= 0) {
                Message l = new g(applicationContext).l(xVar.getChannelId());
                if (l != null) {
                    conversationReadStatus.setReadUpto(l.getCreatedMillis());
                }
                if (conversationReadStatus.getReadUpto() <= 0) {
                    return new h(true);
                }
            }
            new com.freshchat.consumer.sdk.e.a(applicationContext).a(conversationReadStatus);
            try {
                com.freshchat.consumer.sdk.b.a.f(applicationContext);
                com.freshchat.consumer.sdk.b.a.aJ(applicationContext);
            } catch (DeletedException e3) {
                e = e3;
            } catch (Exception e4) {
                e2 = e4;
                b(xVar);
                q.a(e2);
                return new h(z);
            }
        } catch (DeletedException e5) {
            e = e5;
            z = false;
            q.a(e);
            return new h(z);
        } catch (Exception e6) {
            e2 = e6;
            z = false;
            b(xVar);
            q.a(e2);
            return new h(z);
        }
        return new h(z);
    }
}
