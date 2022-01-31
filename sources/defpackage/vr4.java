package defpackage;

import com.google.android.play.core.assetpacks.AssetPackState;

/* renamed from: vr4  reason: default package */
public final /* synthetic */ class vr4 implements Runnable {
    public final yr4 f;
    public final AssetPackState g;

    public vr4(yr4 yr4, AssetPackState assetPackState) {
        this.f = yr4;
        this.g = assetPackState;
    }

    public final void run() {
        this.f.c(this.g);
    }
}
