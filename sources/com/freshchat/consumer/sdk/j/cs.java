package com.freshchat.consumer.sdk.j;

import android.net.Uri;
import android.view.View;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;

public class cs implements View.OnClickListener {
    public final /* synthetic */ ak iC;
    public final /* synthetic */ Uri iD;

    public cs(ak akVar, Uri uri) {
        this.iC = akVar;
        this.iD = uri;
    }

    public void onClick(View view) {
        DeepLinkUtils.b(this.iC.context, this.iD);
    }
}
