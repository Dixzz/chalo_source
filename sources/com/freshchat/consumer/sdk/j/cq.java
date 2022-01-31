package com.freshchat.consumer.sdk.j;

import androidx.recyclerview.widget.RecyclerView;

public abstract class cq implements pk {
    private final RecyclerView.e lo;

    public cq(RecyclerView.e eVar) {
        this.lo = eVar;
    }

    public abstract void ht();

    @Override // defpackage.pk
    public void onChanged(int i, int i2, Object obj) {
        this.lo.notifyItemRangeChanged(i, i2, obj);
        ht();
    }

    @Override // defpackage.pk
    public void onInserted(int i, int i2) {
        this.lo.notifyItemRangeInserted(i, i2);
        ht();
    }

    @Override // defpackage.pk
    public void onMoved(int i, int i2) {
        this.lo.notifyItemMoved(i, i2);
        ht();
    }

    @Override // defpackage.pk
    public void onRemoved(int i, int i2) {
        this.lo.notifyItemRangeRemoved(i, i2);
        ht();
    }
}
