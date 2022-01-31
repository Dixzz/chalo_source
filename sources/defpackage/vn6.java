package defpackage;

import pl.droidsonroids.gif.GifInfoHandle;

/* renamed from: vn6  reason: default package */
/* compiled from: GifDrawable */
public class vn6 extends co6 {
    public final /* synthetic */ wn6 g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public vn6(wn6 wn6, wn6 wn62) {
        super(wn62);
        this.g = wn6;
    }

    @Override // defpackage.co6
    public void a() {
        boolean reset;
        GifInfoHandle gifInfoHandle = this.g.l;
        synchronized (gifInfoHandle) {
            reset = GifInfoHandle.reset(gifInfoHandle.f2819a);
        }
        if (reset) {
            this.g.start();
        }
    }
}
