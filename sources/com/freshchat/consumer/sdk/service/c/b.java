package com.freshchat.consumer.sdk.service.c;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.service.e.j;
import com.freshchat.consumer.sdk.service.e.k;

public abstract class b<T1 extends j, T2 extends k> implements j<T1, T2> {
    private Context context;
    private e fK;

    @Override // com.freshchat.consumer.sdk.service.c.j
    public void a(e eVar) {
        this.fK = eVar;
    }

    public e dw() {
        return this.fK;
    }

    public Context getContext() {
        return this.context;
    }

    @Override // com.freshchat.consumer.sdk.service.c.j
    public void setContext(Context context2) {
        this.context = context2;
    }
}
