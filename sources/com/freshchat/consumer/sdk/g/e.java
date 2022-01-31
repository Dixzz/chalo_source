package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.c.i;
import java.util.List;

public class e extends c<String> {
    private final i eL;
    private List<String> eM;

    public e(Context context, List<String> list) {
        super(context);
        this.eL = new i(context);
        this.eM = list;
    }

    @Override // com.freshchat.consumer.sdk.g.c
    public List<String> dd() {
        return this.eL.k(this.eM);
    }
}
