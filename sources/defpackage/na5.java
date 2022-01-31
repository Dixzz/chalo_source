package defpackage;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

/* renamed from: na5  reason: default package */
/* compiled from: CameraSurface */
public class na5 {

    /* renamed from: a  reason: collision with root package name */
    public SurfaceHolder f2530a;
    public SurfaceTexture b;

    public na5(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            this.f2530a = surfaceHolder;
            return;
        }
        throw new IllegalArgumentException("surfaceHolder may not be null");
    }

    public na5(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.b = surfaceTexture;
            return;
        }
        throw new IllegalArgumentException("surfaceTexture may not be null");
    }
}
