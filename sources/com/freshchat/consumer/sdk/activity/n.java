package com.freshchat.consumer.sdk.activity;

import android.widget.Button;
import android.widget.RatingBar;

public class n implements RatingBar.OnRatingBarChangeListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ boolean bm;

    public n(ConversationDetailActivity conversationDetailActivity, boolean z) {
        this.be = conversationDetailActivity;
        this.bm = z;
    }

    public void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        Button d = ConversationDetailActivity.J(this.be).d(-1);
        boolean z2 = f > 0.0f;
        if (d != null && this.bm) {
            d.setEnabled(z2);
        }
    }
}
