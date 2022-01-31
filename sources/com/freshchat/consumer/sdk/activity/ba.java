package com.freshchat.consumer.sdk.activity;

import android.view.View;
import com.freshchat.consumer.sdk.a.s;
import com.freshchat.consumer.sdk.k.w;

public class ba implements s.b {
    public final /* synthetic */ FAQSearchActivity qL;

    public ba(FAQSearchActivity fAQSearchActivity) {
        this.qL = fAQSearchActivity;
    }

    @Override // com.freshchat.consumer.sdk.a.s.b
    public void d(View view, int i) {
        ((w) this.qL.pe).C(true);
        this.qL.V(i);
    }
}
