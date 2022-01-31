package com.freshchat.consumer.sdk.m;

import android.content.DialogInterface;

public class h implements DialogInterface.OnClickListener {
    public final /* synthetic */ f pb;

    public h(f fVar) {
        this.pb = fVar;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        this.pb.hM();
    }
}
