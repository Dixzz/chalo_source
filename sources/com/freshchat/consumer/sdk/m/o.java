package com.freshchat.consumer.sdk.m;

import android.os.Bundle;
import android.view.View;
import com.freshchat.consumer.sdk.a.l;
import com.freshchat.consumer.sdk.m.a;
import java.util.ArrayList;

public class o implements View.OnClickListener {

    /* renamed from: pl  reason: collision with root package name */
    public final /* synthetic */ n f595pl;

    public o(n nVar) {
        this.f595pl = nVar;
    }

    public void onClick(View view) {
        ArrayList<l.b> jp = this.f595pl.qZ.jp();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("EXTRA_CALENDAR_ALL_TIMESLOTS", jp);
        bundle.putInt("EXTRA_CALENDAR_TYPE", this.f595pl.getCalendarType());
        this.f595pl.a(a.EnumC0014a.CALENDAR_ALL_TIMESLOTS_VIEW_FRAGMENT, bundle);
    }
}
