package defpackage;

import android.hardware.Camera;
import defpackage.la5;

/* renamed from: ja5  reason: default package */
/* compiled from: CameraInstance */
public class ja5 implements Runnable {
    public final /* synthetic */ ta5 f;
    public final /* synthetic */ ka5 g;

    public ja5(ka5 ka5, ta5 ta5) {
        this.g = ka5;
        this.f = ta5;
    }

    public void run() {
        la5 la5 = this.g.c;
        ta5 ta5 = this.f;
        Camera camera = la5.f2194a;
        if (camera != null && la5.e) {
            la5.a aVar = la5.m;
            aVar.f2195a = ta5;
            camera.setOneShotPreviewCallback(aVar);
        }
    }
}
