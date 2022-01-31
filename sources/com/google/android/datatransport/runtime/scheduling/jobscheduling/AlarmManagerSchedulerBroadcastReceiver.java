package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import defpackage.cv1;
import defpackage.jv1;

public class AlarmManagerSchedulerBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f599a = 0;

    public void onReceive(Context context, Intent intent) {
        String queryParameter = intent.getData().getQueryParameter("backendName");
        String queryParameter2 = intent.getData().getQueryParameter("extras");
        int intValue = Integer.valueOf(intent.getData().getQueryParameter("priority")).intValue();
        int i = intent.getExtras().getInt("attemptNumber");
        nv1.b(context);
        jv1.a a2 = jv1.a();
        a2.b(queryParameter);
        a2.c(oy1.b(intValue));
        if (queryParameter2 != null) {
            ((cv1.b) a2).b = Base64.decode(queryParameter2, 0);
        }
        ax1 ax1 = nv1.a().d;
        ax1.e.execute(new rw1(ax1, a2.a(), i, nw1.f));
    }
}
