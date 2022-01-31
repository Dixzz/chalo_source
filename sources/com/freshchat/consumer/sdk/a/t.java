package com.freshchat.consumer.sdk.a;

import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.f.e;
import com.freshchat.consumer.sdk.j.k;
import java.util.List;

public class t extends v {
    public final /* synthetic */ List qS;
    public final /* synthetic */ s qT;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(s sVar, RecyclerView.e eVar, e eVar2, List list) {
        super(eVar, eVar2);
        this.qT = sVar;
        this.qS = list;
    }

    @Override // com.freshchat.consumer.sdk.a.v
    public int iH() {
        return k.b(this.qS);
    }
}
