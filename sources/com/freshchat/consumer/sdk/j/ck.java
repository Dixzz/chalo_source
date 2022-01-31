package com.freshchat.consumer.sdk.j;

import android.view.View;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.j.cj;

public final class ck implements View.OnClickListener {
    public final /* synthetic */ Message os;
    public final /* synthetic */ cj.a pQ;

    public ck(cj.a aVar, Message message) {
        this.pQ = aVar;
        this.os = message;
    }

    public void onClick(View view) {
        cj.a aVar = this.pQ;
        if (aVar != null) {
            aVar.p(this.os);
        }
    }
}
