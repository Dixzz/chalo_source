package com.freshchat.consumer.sdk.g;

import android.content.Context;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.c.i;
import com.freshchat.consumer.sdk.j.k;
import java.util.List;

public class f extends c<Category> {
    private final Context context;
    private i eL;
    private List<String> tags;

    public f(Context context2) {
        super(context2);
        this.context = context2;
        this.eL = new i(context2);
    }

    public f(Context context2, List<String> list) {
        this(context2);
        if (k.a(list)) {
            this.tags = list;
        }
    }

    @Override // com.freshchat.consumer.sdk.g.c
    public List<Category> dd() {
        return k.a(this.tags) ? this.eL.l(this.tags) : this.eL.cJ();
    }

    @Override // defpackage.li, defpackage.ki
    public void onForceLoad() {
        super.onForceLoad();
    }

    @Override // com.freshchat.consumer.sdk.g.c, defpackage.li
    public void onReset() {
        super.onReset();
    }

    @Override // com.freshchat.consumer.sdk.g.c, defpackage.li
    public void onStartLoading() {
        super.onStartLoading();
    }
}
