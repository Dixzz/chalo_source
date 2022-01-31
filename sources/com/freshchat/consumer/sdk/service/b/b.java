package com.freshchat.consumer.sdk.service.b;

import android.content.Context;
import app.zophop.pubsub.eventbus.events.CardValidityCheckEvent;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.c.j;
import com.freshchat.consumer.sdk.service.e.k;

public class b {
    private j a(Context context, com.freshchat.consumer.sdk.service.e.j jVar) {
        j a2 = a.a(jVar);
        if (a2 != null) {
            a2.a(e.i(context));
            a2.setContext(context);
        } else {
            jVar.getClass().getSimpleName();
        }
        return a2;
    }

    public void b(Context context, com.freshchat.consumer.sdk.service.e.j jVar, a aVar) {
        j a2;
        if (jVar != null && (a2 = a(context, jVar)) != null) {
            k kVar = null;
            long currentTimeMillis = System.currentTimeMillis();
            StringBuilder i0 = hj1.i0("Now Processing ");
            i0.append(jVar.getClass().getSimpleName());
            ai.i("FRESHCHAT_SERVICE", i0.toString());
            try {
                kVar = a2.b(jVar);
            } catch (Exception e) {
                ai.e(CardValidityCheckEvent.VALIDITY_CHECK_ERROR, "Exception occured", e);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            StringBuilder i02 = hj1.i0("Time taken to process ");
            i02.append(jVar.getClass().getSimpleName());
            i02.append(" = ");
            i02.append(currentTimeMillis2 - currentTimeMillis);
            ai.d("FRESHCHAT_SERVICE", i02.toString());
            if (aVar != null) {
                aVar.a(kVar);
            }
        }
    }
}
