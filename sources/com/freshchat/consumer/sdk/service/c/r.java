package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.beans.CsatResponse;
import com.freshchat.consumer.sdk.beans.reqres.CsatResponseRequest;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.a.a;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.t;
import java.util.HashMap;

public class r extends a<t, k> {
    private void b(CsatResponseRequest csatResponseRequest) {
        try {
            CsatResponse csatResponse = csatResponseRequest.getCsatResponse();
            if (csatResponse == null) {
                return;
            }
            if (csatResponse.getConversationId() != 0) {
                String json = new ab().toJson(csatResponseRequest);
                HashMap hashMap = new HashMap();
                hashMap.put("fc_csat_response", json);
                aa.c(getContext(), new a(9, "csat_" + Long.toString(csatResponse.getConversationId())).b(hashMap));
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    public boolean a(t tVar) {
        return w.ay(getContext());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r1 != false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.t r9) {
        /*
        // Method dump skipped, instructions count: 125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.r.b(com.freshchat.consumer.sdk.service.e.t):com.freshchat.consumer.sdk.service.e.k");
    }
}
