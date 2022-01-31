package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.service.FreshchatService;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.e.j;
import com.freshchat.consumer.sdk.service.e.k;

public class d {
    public static void b(Context context, final j jVar) {
        FreshchatService.a(context.getApplicationContext(), jVar, new a() {
            /* class com.freshchat.consumer.sdk.service.d.d.AnonymousClass1 */

            @Override // com.freshchat.consumer.sdk.service.a
            public void a(k kVar) {
                if (kVar == null || !kVar.isSuccess()) {
                    StringBuilder i0 = hj1.i0("Unhandled failed response for ");
                    i0.append(j.this);
                    ai.d("Response", i0.toString());
                }
            }
        });
    }

    public static void bl(Context context) {
        FreshchatService.bk(context);
    }

    public static void c(Context context, j jVar, a aVar) {
        FreshchatService.a(context.getApplicationContext(), jVar, aVar);
    }
}
