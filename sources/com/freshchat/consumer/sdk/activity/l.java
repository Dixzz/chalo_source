package com.freshchat.consumer.sdk.activity;

import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.Csat;
import com.freshchat.consumer.sdk.j.bg;

public class l implements DialogInterface.OnClickListener {
    public final /* synthetic */ ConversationDetailActivity be;
    public final /* synthetic */ boolean bm;
    public final /* synthetic */ Csat hF;
    public final /* synthetic */ boolean kJ;
    public final /* synthetic */ RatingBar on;
    public final /* synthetic */ EditText oo;

    public l(ConversationDetailActivity conversationDetailActivity, boolean z, RatingBar ratingBar, EditText editText, Csat csat, boolean z2) {
        this.be = conversationDetailActivity;
        this.bm = z;
        this.on = ratingBar;
        this.oo = editText;
        this.hF = csat;
        this.kJ = z2;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        int progress = (!this.bm || !i.f(this.on)) ? 0 : this.on.getProgress();
        String str = null;
        if (i.f(this.oo)) {
            str = this.oo.getText().toString();
            i.a(this.be.getContext(), (View) this.oo);
        }
        ConversationDetailActivity.a(this.be, this.hF, this.kJ, progress, str);
        bg.a(this.be.getContext(), ConversationDetailActivity.c(this.be), this.kJ, progress, str);
        ConversationDetailActivity.I(this.be);
    }
}
