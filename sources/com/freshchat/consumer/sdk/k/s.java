package com.freshchat.consumer.sdk.k;

import com.freshchat.consumer.sdk.beans.reqres.AgentAvailabilityResponse;
import com.freshchat.consumer.sdk.l.c;

public class s implements c.a {
    public final /* synthetic */ com.freshchat.consumer.sdk.service.c rw;
    public final /* synthetic */ r rx;

    public s(r rVar, com.freshchat.consumer.sdk.service.c cVar) {
        this.rx = rVar;
        this.rw = cVar;
    }

    @Override // com.freshchat.consumer.sdk.l.c.a
    public void a(AgentAvailabilityResponse agentAvailabilityResponse) {
        r.a(this.rx, agentAvailabilityResponse);
        r rVar = this.rx;
        r.a(rVar, r.a(rVar));
        r.a(this.rx, this.rw);
    }

    @Override // com.freshchat.consumer.sdk.l.c.a
    public void hU() {
        r.b(this.rx, this.rw);
    }
}
