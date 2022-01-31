package defpackage;

import android.hardware.Camera;

/* renamed from: vk1  reason: default package */
/* compiled from: DecoderWrapper */
public final class vk1 {

    /* renamed from: a  reason: collision with root package name */
    public final Camera f3658a;
    public final uk1 b;
    public final xk1 c;
    public final xk1 d;
    public final xk1 e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final boolean i;

    public vk1(Camera camera, Camera.CameraInfo cameraInfo, uk1 uk1, xk1 xk1, xk1 xk12, xk1 xk13, int i2, boolean z, boolean z2) {
        this.f3658a = camera;
        this.b = uk1;
        this.c = xk1;
        this.d = xk12;
        this.e = xk13;
        this.f = i2;
        this.g = cameraInfo.facing != 1 ? false : true;
        this.h = z;
        this.i = z2;
    }
}
