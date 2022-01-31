package com.freshchat.consumer.sdk.a;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.a.b;
import com.freshchat.consumer.sdk.beans.ICategory;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.service.Status;
import java.util.List;

public class q<T extends ICategory> extends b<T> {
    private final v qO;

    public q(Context context, List<T> list, boolean z, b.a aVar, e eVar) {
        super(context, list, z, aVar);
        this.qO = new r(this, this, eVar);
    }

    @Override // com.freshchat.consumer.sdk.a.b, androidx.recyclerview.widget.RecyclerView.e
    public int getItemCount() {
        return this.qO.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.e
    public int getItemViewType(int i) {
        return this.qO.getItemViewType(i);
    }

    @Override // com.freshchat.consumer.sdk.a.b, androidx.recyclerview.widget.RecyclerView.e
    public void onBindViewHolder(RecyclerView.a0 a0Var, int i) {
        if (a0Var instanceof b.C0008b) {
            super.onBindViewHolder(a0Var, i);
        } else {
            this.qO.onBindViewHolder(a0Var, i);
        }
    }

    @Override // com.freshchat.consumer.sdk.a.b, androidx.recyclerview.widget.RecyclerView.e
    public RecyclerView.a0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        return i == 0 ? super.onCreateViewHolder(viewGroup, i) : this.qO.onCreateViewHolder(viewGroup, i);
    }

    public void setStatus(Status status) {
        this.qO.setStatus(status);
    }
}
