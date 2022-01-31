package com.freshchat.consumer.sdk.a;

import android.view.View;
import android.widget.LinearLayout;
import com.freshchat.consumer.sdk.a.d;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.bg;

public class p implements View.OnClickListener {
    public final /* synthetic */ Message os;
    public final /* synthetic */ d ot;
    public final /* synthetic */ View pW;
    public final /* synthetic */ d.e pX;
    public final /* synthetic */ boolean qA;

    public p(d dVar, d.e eVar, Message message, boolean z, View view) {
        this.ot = dVar;
        this.pX = eVar;
        this.os = message;
        this.qA = z;
        this.pW = view;
    }

    public void onClick(View view) {
        View ir2 = this.pX.ir();
        boolean z = ir2.getVisibility() == 0;
        if (z) {
            bg.f(d.a(this.ot), false);
            d.d(this.ot).remove(Long.valueOf(this.os.getId()));
            i.c(ir2);
        } else {
            bg.f(d.a(this.ot), true);
            d.d(this.ot).add(Long.valueOf(this.os.getId()));
            d.a(this.ot, this.pX, this.os.getMessageFragments(), this.qA);
            LinearLayout ip = this.pX.ip();
            d dVar = this.ot;
            ip.setOnLongClickListener(new d.h(this.os, d.e(dVar), false));
        }
        d.a(this.ot, this.pW, !z);
    }
}
