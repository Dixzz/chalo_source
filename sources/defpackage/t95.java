package defpackage;

import android.graphics.SurfaceTexture;
import android.view.TextureView;

/* renamed from: t95  reason: default package */
/* compiled from: CameraPreview */
public class t95 implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u95 f3323a;

    public t95(u95 u95) {
        this.f3323a = u95;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        u95 u95 = this.f3323a;
        u95.u = new fa5(i, i2);
        u95.h();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        u95 u95 = this.f3323a;
        u95.u = new fa5(i, i2);
        u95.h();
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
