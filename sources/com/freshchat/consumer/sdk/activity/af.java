package com.freshchat.consumer.sdk.activity;

import android.view.View;
import com.freshchat.consumer.sdk.service.d.b;

public class af implements View.OnClickListener {
    public final /* synthetic */ ArticleListActivity ae;

    public af(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    public void onClick(View view) {
        ArticleListActivity.o(this.ae).aE();
        new b(this.ae.getApplicationContext(), b.a.channels_launch).g("source", "contact_us").dB();
    }
}
