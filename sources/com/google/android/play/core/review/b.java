package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

public final class b extends ResultReceiver {
    public final /* synthetic */ ay4 f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Handler handler, ay4 ay4) {
        super(handler);
        this.f = ay4;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        this.f.b(null);
    }
}
