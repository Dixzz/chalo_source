package defpackage;

import android.hardware.Camera;

/* renamed from: d45  reason: default package */
/* compiled from: OpenCameraInterface */
public final class d45 {
    public static int a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            return -1;
        }
        boolean z = i >= 0;
        if (!z) {
            i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        if (i < numberOfCameras) {
            return i;
        }
        return z ? -1 : 0;
    }
}
