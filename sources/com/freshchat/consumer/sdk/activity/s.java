package com.freshchat.consumer.sdk.activity;

import android.net.Uri;
import android.view.View;
import com.freshchat.consumer.sdk.activity.ConversationDetailActivity;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;

public class s implements View.OnClickListener {
    public final /* synthetic */ Uri cZ;
    public final /* synthetic */ ConversationDetailActivity.AnonymousClass7 hl;

    public s(ConversationDetailActivity.AnonymousClass7 r1, Uri uri) {
        this.hl = r1;
        this.cZ = uri;
    }

    public void onClick(View view) {
        DeepLinkUtils.b(ConversationDetailActivity.this.getContext(), this.cZ);
    }
}
