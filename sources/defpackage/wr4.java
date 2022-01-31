package defpackage;

import android.os.Bundle;
import com.google.android.play.core.assetpacks.AssetPackState;

/* renamed from: wr4  reason: default package */
public final /* synthetic */ class wr4 implements Runnable {
    public final yr4 f;
    public final Bundle g;
    public final AssetPackState h;

    public wr4(yr4 yr4, Bundle bundle, AssetPackState assetPackState) {
        this.f = yr4;
        this.g = bundle;
        this.h = assetPackState;
    }

    public final void run() {
        yr4 yr4 = this.f;
        Bundle bundle = this.g;
        AssetPackState assetPackState = this.h;
        dt4 dt4 = yr4.g;
        if (((Boolean) dt4.b(new us4(dt4, bundle))).booleanValue()) {
            yr4.n.post(new vr4(yr4, assetPackState));
            yr4.i.a().j();
        }
    }
}
