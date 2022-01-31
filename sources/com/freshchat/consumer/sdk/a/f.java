package com.freshchat.consumer.sdk.a;

import android.view.View;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;

public class f implements View.OnClickListener {
    public final /* synthetic */ MessageFragment mZ;
    public final /* synthetic */ e na;

    public f(e eVar, MessageFragment messageFragment) {
        this.na = eVar;
        this.mZ = messageFragment;
    }

    public void onClick(View view) {
        e.b(this.na).a((QuickReplyButtonFragment) this.mZ, e.a(this.na));
    }
}
