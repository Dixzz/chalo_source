package com.trillbit.datasdk.core;

public class CWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final bg5 f710a;
    public final int b;

    static {
        System.loadLibrary("native-lib");
    }

    public CWrapper(int i, bg5 bg5, boolean z, float f) {
        this.b = i;
        this.f710a = bg5;
        setUpCoreSDK(19, z, f);
    }

    public static native void addBuffer(short[] sArr, int i, int i2);

    public static native float[] getAudioSamplesFromBytes(byte[] bArr, int i, int i2);

    public static native byte[] getDecodedString(int i);

    public static native String getLogsFromNative();

    public static native String getPeakHeightLog();

    public static native int processBuffer(int i);

    public static native void setExpectedString(byte[] bArr, int i);

    public static native void setUpCoreSDK(int i, boolean z, float f);
}
