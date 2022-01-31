package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.beans.reqres.ChannelsResponseTimeResponse;
import com.freshchat.consumer.sdk.e.a;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.r;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.c;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;

public class e extends a<c, k> {
    public boolean a(c cVar) {
        if (!w.ay(getContext()) || !w.aA(getContext())) {
            return false;
        }
        return System.currentTimeMillis() - r.ey() > getRefreshIntervals().getResponseTimeExpectationsFetchInterval();
    }

    public k b(c cVar) {
        boolean z = true;
        if (!a(cVar)) {
            return new h(true);
        }
        ChannelsResponseTimeResponse channelsResponseTimeResponse = null;
        try {
            channelsResponseTimeResponse = new a(getContext()).cZ();
        } catch (DeletedException | Exception e) {
            q.a(e);
            z = false;
        }
        if (z && channelsResponseTimeResponse != null) {
            r.a(getContext(), channelsResponseTimeResponse);
            com.freshchat.consumer.sdk.b.a.X(getContext());
        }
        return new h(z);
    }
}
