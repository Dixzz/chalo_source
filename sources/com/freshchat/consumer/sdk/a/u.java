package com.freshchat.consumer.sdk.a;

import android.view.View;

public class u implements View.OnClickListener {
    public final /* synthetic */ int ck;
    public final /* synthetic */ s qT;

    public u(s sVar, int i) {
        this.qT = sVar;
        this.ck = i;
    }

    public void onClick(View view) {
        s.a(this.qT).d(view, this.ck);
    }
}
