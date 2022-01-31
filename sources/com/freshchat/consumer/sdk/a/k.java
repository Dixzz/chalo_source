package com.freshchat.consumer.sdk.a;

import android.view.View;
import com.freshchat.consumer.sdk.a.i;
import com.freshchat.consumer.sdk.k.q;

public class k implements View.OnClickListener {
    public final /* synthetic */ q oA;
    public final /* synthetic */ i.b oB;

    public k(i.b bVar, q qVar) {
        this.oB = bVar;
        this.oA = qVar;
    }

    public void onClick(View view) {
        if (i.a(i.this) != null && this.oA.il() != null) {
            i.a(i.this).a(this.oA.il());
        }
    }
}
