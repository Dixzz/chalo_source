package com.freshchat.consumer.sdk.service.c;

import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.e.a;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.j.w;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.u;

public class s extends a<u, k> {
    public boolean a(u uVar) {
        if (!w.ay(getContext())) {
            return false;
        }
        boolean bl = dw().bl();
        long currentTimeMillis = System.currentTimeMillis();
        if (bl) {
            String cc = dw().cc();
            if (as.isEmpty(cc)) {
                return true;
            }
            long parseLong = Long.parseLong(cc);
            return currentTimeMillis > parseLong && n.c(parseLong, currentTimeMillis);
        }
        String gP = dw().gP();
        if (as.isEmpty(gP)) {
            return true;
        }
        long parseLong2 = Long.parseLong(gP);
        return currentTimeMillis > parseLong2 && n.e(parseLong2, currentTimeMillis);
    }

    public k b(u uVar) {
        boolean z;
        if (a(uVar)) {
            try {
                if (new a(getContext()).cX()) {
                    e dw = dw();
                    if (dw.bl()) {
                        dw.cd();
                    } else {
                        dw.gQ();
                    }
                }
            } catch (DeletedException | Exception e) {
                q.a(e);
            }
            z = true;
        } else {
            z = false;
        }
        return new h(z);
    }
}
