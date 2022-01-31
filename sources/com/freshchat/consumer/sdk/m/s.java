package com.freshchat.consumer.sdk.m;

import com.freshchat.consumer.sdk.R;

public class s implements Runnable {
    public final /* synthetic */ r pm;

    public s(r rVar) {
        this.pm = rVar;
    }

    public void run() {
        f hB = this.pm.f598pl.hB();
        if (hB != null) {
            hB.R(this.pm.f598pl.getResources().getDimensionPixelSize(R.dimen.freshchat_calendar_limited_timeslot_height));
        }
    }
}
