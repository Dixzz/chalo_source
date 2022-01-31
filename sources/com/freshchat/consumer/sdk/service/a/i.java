package com.freshchat.consumer.sdk.service.a;

import android.content.Context;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ab;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.d.d;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.x;

public class i extends d {
    public i(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // com.freshchat.consumer.sdk.service.a.b
    public void ds() {
        try {
            final a dt = dt();
            ab ch = ch();
            d.c(getContext(), (x) ch.fromJson(dt.getMeta().get("fc_conv_read_status"), x.class), new a() {
                /* class com.freshchat.consumer.sdk.service.a.i.AnonymousClass1 */

                @Override // com.freshchat.consumer.sdk.service.a
                public void a(k kVar) {
                    if (kVar != null && kVar.isSuccess()) {
                        aa.l(i.this.getContext(), dt.dr());
                    }
                }
            });
        } catch (Exception e) {
            q.a(e);
        }
    }
}
