package com.freshchat.consumer.sdk.m;

import android.content.DialogInterface;

public class i implements DialogInterface.OnClickListener {
    public final /* synthetic */ f pb;

    public i(f fVar) {
        this.pb = fVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
