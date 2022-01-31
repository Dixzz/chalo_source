package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.MarketingMessageStatus;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.aa;

public class k extends d {
    public static final String TAG = "com.freshchat.consumer.sdk.service.a.k";

    public k(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // com.freshchat.consumer.sdk.service.a.b
    public void ds() {
        try {
            ai.d(TAG, "Processing backlog - marketing message status");
            final a dt = dt();
            final MarketingMessageStatus marketingMessageStatus = (MarketingMessageStatus) ch().fromJson(dt.getMeta().get("fc_marketing_metrics"), MarketingMessageStatus.class);
            aa aaVar = new aa();
            aaVar.a(marketingMessageStatus);
            d.c(getContext(), aaVar, new a() {
                /* class com.freshchat.consumer.sdk.service.a.k.AnonymousClass1 */

                @Override // com.freshchat.consumer.sdk.service.a
                public void a(com.freshchat.consumer.sdk.service.e.k kVar) {
                    if (kVar != null && kVar.isSuccess()) {
                        String str = k.TAG;
                        StringBuilder i0 = hj1.i0("Marketing message status update from backlog successful ");
                        i0.append(marketingMessageStatus);
                        ai.d(str, i0.toString());
                        com.freshchat.consumer.sdk.j.aa.l(k.this.getContext(), dt.dr());
                    }
                }
            });
        } catch (Exception e) {
            q.a(e);
        }
    }
}
