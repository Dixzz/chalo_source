package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.JwtTokenStatus;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.o;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.k;

public class ac extends a<com.freshchat.consumer.sdk.service.e.ac, k> {
    public boolean a(com.freshchat.consumer.sdk.service.e.ac acVar) {
        if (!w.ay(getContext())) {
            return false;
        }
        return (!o.bB(getContext()) || o.bz(getContext()) == JwtTokenStatus.TOKEN_VALID) && !com.freshchat.consumer.sdk.j.k.c(acVar.gM()) && !as.isEmpty(acVar.bj());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004d, code lost:
        if (r3 != false) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.freshchat.consumer.sdk.service.e.k b(com.freshchat.consumer.sdk.service.e.ac r8) {
        /*
        // Method dump skipped, instructions count: 139
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.service.c.ac.b(com.freshchat.consumer.sdk.service.e.ac):com.freshchat.consumer.sdk.service.e.k");
    }
}
