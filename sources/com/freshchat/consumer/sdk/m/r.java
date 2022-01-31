package com.freshchat.consumer.sdk.m;

import com.freshchat.consumer.sdk.a.l;
import com.freshchat.consumer.sdk.service.b;
import com.freshchat.consumer.sdk.service.c;
import java.util.List;

public class r implements c<List<l.b>> {

    /* renamed from: pl  reason: collision with root package name */
    public final /* synthetic */ n f598pl;

    public r(n nVar) {
        this.f598pl = nVar;
    }

    @Override // com.freshchat.consumer.sdk.service.c
    public void b(b<List<l.b>> bVar) {
        this.f598pl.a((n) bVar);
        this.f598pl.ra.post(new s(this));
    }
}
