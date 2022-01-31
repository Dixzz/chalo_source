package defpackage;

import java.util.Queue;

/* renamed from: bb3  reason: default package */
/* compiled from: com.google.firebase:firebase-messaging@@22.0.0 */
public final class bb3 {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f404a = 0;

    static {
        new za3();
    }

    public static byte[] a(Queue<byte[]> queue, int i) {
        byte[] bArr = new byte[i];
        int i2 = i;
        while (i2 > 0) {
            byte[] remove = queue.remove();
            int min = Math.min(i2, remove.length);
            System.arraycopy(remove, 0, bArr, i - i2, min);
            i2 -= min;
        }
        return bArr;
    }
}
