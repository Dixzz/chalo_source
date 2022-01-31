package com.freshchat.consumer.sdk.m;

import android.view.View;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.m.a;

public class m implements View.OnClickListener {
    public final /* synthetic */ j pf;

    public m(j jVar) {
        this.pf = jVar;
    }

    public void onClick(View view) {
        if (as.a(this.pf.dS.getText())) {
            this.pf.pc.bq(this.pf.dS.getText().toString());
            this.pf.a(a.EnumC0014a.CALENDAR_LIMITED_TIMESLOTS_VIEW_FRAGMENT);
        }
    }
}
