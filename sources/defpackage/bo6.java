package defpackage;

import android.graphics.Bitmap;
import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import pl.droidsonroids.gif.GifInfoHandle;

/* renamed from: bo6  reason: default package */
/* compiled from: RenderTask */
public class bo6 extends co6 {
    public bo6(wn6 wn6) {
        super(wn6);
    }

    @Override // defpackage.co6
    public void a() {
        long renderFrame;
        int currentFrameIndex;
        int currentLoop;
        int loopCount;
        wn6 wn6 = this.f;
        GifInfoHandle gifInfoHandle = wn6.l;
        Bitmap bitmap = wn6.k;
        synchronized (gifInfoHandle) {
            renderFrame = GifInfoHandle.renderFrame(gifInfoHandle.f2819a, bitmap);
        }
        if (renderFrame >= 0) {
            this.f.h = SystemClock.uptimeMillis() + renderFrame;
            if (this.f.isVisible() && this.f.g) {
                wn6 wn62 = this.f;
                if (!wn62.q) {
                    wn62.f.remove(this);
                    wn6 wn63 = this.f;
                    wn63.u = wn63.f.schedule(this, renderFrame, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f.m.isEmpty()) {
                GifInfoHandle gifInfoHandle2 = this.f.l;
                synchronized (gifInfoHandle2) {
                    currentFrameIndex = GifInfoHandle.getCurrentFrameIndex(gifInfoHandle2.f2819a);
                }
                if (currentFrameIndex == this.f.l.b() - 1) {
                    wn6 wn64 = this.f;
                    ao6 ao6 = wn64.r;
                    GifInfoHandle gifInfoHandle3 = wn64.l;
                    synchronized (gifInfoHandle3) {
                        currentLoop = GifInfoHandle.getCurrentLoop(gifInfoHandle3.f2819a);
                    }
                    if (currentLoop != 0) {
                        GifInfoHandle gifInfoHandle4 = wn64.l;
                        synchronized (gifInfoHandle4) {
                            loopCount = GifInfoHandle.getLoopCount(gifInfoHandle4.f2819a);
                        }
                        if (currentLoop >= loopCount) {
                            currentLoop--;
                        }
                    }
                    ao6.sendEmptyMessageAtTime(currentLoop, this.f.h);
                }
            }
        } else {
            wn6 wn65 = this.f;
            wn65.h = Long.MIN_VALUE;
            wn65.g = false;
        }
        if (this.f.isVisible() && !this.f.r.hasMessages(-1)) {
            this.f.r.sendEmptyMessageAtTime(-1, 0);
        }
    }
}
