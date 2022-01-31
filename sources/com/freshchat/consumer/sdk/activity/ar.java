package com.freshchat.consumer.sdk.activity;

import android.view.View;
import android.widget.Toast;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.j.al;
import com.freshchat.consumer.sdk.k.u;
import com.freshchat.consumer.sdk.service.e.am;

public class ar implements View.OnClickListener {
    public final /* synthetic */ FAQDetailsActivity pI;

    public ar(FAQDetailsActivity fAQDetailsActivity) {
        this.pI = fAQDetailsActivity;
    }

    public void onClick(View view) {
        if (!al.aS(this.pI.getContext())) {
            Toast.makeText(this.pI.getContext(), R.string.freshchat_error_message_not_connected_to_internet, 1).show();
            return;
        }
        am.a aVar = view.getId() == R.id.freshchat_upvote ? am.a.THUMBS_UP : am.a.THUMBS_DOWN;
        ((u) this.pI.pe).a(aVar);
        if (aVar == am.a.THUMBS_UP) {
            FAQDetailsActivity.a(this.pI);
        } else {
            FAQDetailsActivity.b(this.pI);
        }
    }
}
