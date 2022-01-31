package com.freshchat.consumer.sdk.activity;

import androidx.appcompat.widget.SearchView;
import com.freshchat.consumer.sdk.k.w;

public class bd implements SearchView.OnQueryTextListener {
    public final /* synthetic */ FAQSearchActivity qL;

    public bd(FAQSearchActivity fAQSearchActivity) {
        this.qL = fAQSearchActivity;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        if (this.qL.dH()) {
            this.qL.onUserInteraction();
        }
        ((w) this.qL.pe).bC(str);
        FAQSearchActivity.a(this.qL, str);
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }
}
