package com.freshchat.consumer.sdk.service.c;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.e;
import com.freshchat.consumer.sdk.j.n;
import com.freshchat.consumer.sdk.service.a.c;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.s;
import com.google.firebase.appindexing.Indexable;
import java.util.Random;

public class q extends b<s, k> {
    private long dx() {
        return (long) ((new Random().nextInt(9) + 1) * 60 * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL);
    }

    /* renamed from: a */
    public k b(s sVar) {
        ai.d("FRESHCHAT", "StartBackgroundAlarmRequestHandler::handleRequest() called");
        Context context = getContext();
        if (!c.s(context)) {
            return new h(false);
        }
        PendingIntent Z = e.Z(context);
        long currentTimeMillis = System.currentTimeMillis() + dx();
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(0, currentTimeMillis, 3600000, Z);
        StringBuilder i0 = hj1.i0("StartBackgroundAlarmRequestHandler::Starting alarm from ");
        i0.append(n.i(context, currentTimeMillis));
        i0.append(", with an interval of ");
        i0.append(3600000L);
        i0.append(" ms");
        ai.d("FRESHCHAT", i0.toString());
        return new h(true);
    }
}
