package com.freshchat.consumer.sdk.l;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.reqres.AgentAvailabilityResponse;
import com.freshchat.consumer.sdk.e.a;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.ch;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.l.c;
import java.util.TimeZone;

public class d implements Runnable {
    public final /* synthetic */ Context iI;
    public final /* synthetic */ String px;
    public final /* synthetic */ c.a py;
    public final /* synthetic */ c pz;

    public d(c cVar, Context context, String str, c.a aVar) {
        this.pz = cVar;
        this.iI = context;
        this.px = str;
        this.py = aVar;
    }

    public void run() {
        try {
            AgentAvailabilityResponse bp = new a(this.iI).bp(this.px);
            bp.setProcessedCalendarDataMap(ch.a(TimeZone.getDefault(), bp));
            this.pz.a(new e(this, bp));
        } catch (DeletedException | Exception e) {
            q.a(e);
            this.pz.a(new f(this));
        }
    }
}
