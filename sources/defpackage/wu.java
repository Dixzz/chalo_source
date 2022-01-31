package defpackage;

import android.view.View;
import app.zophop.models.mTicketing.cardRecharge.OnlineCardRecharge;

/* renamed from: wu  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class wu implements View.OnClickListener {
    public final /* synthetic */ yu f;
    public final /* synthetic */ OnlineCardRecharge g;

    public /* synthetic */ wu(yu yuVar, OnlineCardRecharge onlineCardRecharge) {
        this.f = yuVar;
        this.g = onlineCardRecharge;
    }

    public final void onClick(View view) {
        yu yuVar = this.f;
        OnlineCardRecharge onlineCardRecharge = this.g;
        n86.e(yuVar, "this$0");
        n86.e(onlineCardRecharge, "$lCardRecharge");
        yuVar.e.invoke(onlineCardRecharge);
    }
}
