package com.freshchat.consumer.sdk.activity;

import android.view.View;
import com.freshchat.consumer.sdk.k.w;

public class bc implements View.OnFocusChangeListener {
    public final /* synthetic */ FAQSearchActivity qL;

    public bc(FAQSearchActivity fAQSearchActivity) {
        this.qL = fAQSearchActivity;
    }

    public void onFocusChange(View view, boolean z) {
        FAQSearchActivity.b(this.qL, z);
        if (((w) this.qL.pe).jK()) {
            FAQSearchActivity fAQSearchActivity = this.qL;
            fAQSearchActivity.bv(fAQSearchActivity.hV());
        }
    }
}
