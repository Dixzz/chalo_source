package com.freshchat.consumer.sdk.activity;

import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.e.k;

public class y implements a {
    public final /* synthetic */ x H;

    public y(x xVar) {
        this.H = xVar;
    }

    @Override // com.freshchat.consumer.sdk.service.a
    public void a(k kVar) {
        this.H.F.w = true;
        String unused = ArticleDetailActivity.z = null;
        this.H.F.runOnUiThread(new z(this));
    }
}
