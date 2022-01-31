package com.freshchat.consumer.sdk.activity;

import android.view.MenuItem;

public class be implements MenuItem.OnActionExpandListener {
    public final /* synthetic */ FAQSearchActivity qL;

    public be(FAQSearchActivity fAQSearchActivity) {
        this.qL = fAQSearchActivity;
    }

    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
        this.qL.finish();
        return true;
    }

    public boolean onMenuItemActionExpand(MenuItem menuItem) {
        return true;
    }
}
