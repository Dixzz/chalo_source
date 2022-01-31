package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.widget.AdapterView;

public class ae implements AdapterView.OnItemClickListener {
    public final /* synthetic */ ArticleListActivity ae;

    public ae(ArticleListActivity articleListActivity) {
        this.ae = articleListActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.ae.a(j);
    }
}
