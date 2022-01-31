package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.beans.MarketingMessageStatus;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.a.a;
import com.freshchat.consumer.sdk.service.e.aa;
import com.freshchat.consumer.sdk.service.e.k;
import java.util.HashMap;

public class x extends a<aa, k> {
    private void c(aa aaVar) {
        try {
            ai.d("FRESHCHAT", "Failed to update marketing message status. Backlogging");
            MarketingMessageStatus dS = aaVar.dS();
            String json = new ab().toJson(dS);
            HashMap hashMap = new HashMap();
            hashMap.put("fc_marketing_metrics", json);
            com.freshchat.consumer.sdk.j.aa.c(getContext(), new a(6, String.valueOf(dS.getMarketingId())).b(hashMap));
        } catch (Exception e) {
            q.a(e);
        }
    }

    public boolean a(aa aaVar) {
        return w.ay(getContext());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.aa r9) {
        /*
        // Method dump skipped, instructions count: 115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.x.b(com.freshchat.consumer.sdk.service.e.aa):com.freshchat.consumer.sdk.service.e.k");
    }
}
