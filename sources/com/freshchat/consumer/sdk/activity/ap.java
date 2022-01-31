package com.freshchat.consumer.sdk.activity;

import androidx.recyclerview.widget.GridLayoutManager;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.k.t;

public class ap extends GridLayoutManager.c {
    public final /* synthetic */ int pG;
    public final /* synthetic */ FAQCategoriesActivity pv;

    public ap(FAQCategoriesActivity fAQCategoriesActivity, int i) {
        this.pv = fAQCategoriesActivity;
        this.pG = i;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager.c
    public int getSpanSize(int i) {
        if (i < k.b(((t) this.pv.pe).jt())) {
            return 1;
        }
        return this.pG;
    }
}
