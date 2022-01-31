package defpackage;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* renamed from: vl1  reason: default package */
/* compiled from: GifHeaderParser */
public class vl1 {

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f3662a = new byte[256];
    public ByteBuffer b;
    public ul1 c;
    public int d = 0;

    public final boolean a() {
        return this.c.b != 0;
    }

    public final int b() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    public final int c() {
        int b2 = b();
        this.d = b2;
        int i = 0;
        if (b2 > 0) {
            while (true) {
                try {
                    int i2 = this.d;
                    if (i >= i2) {
                        break;
                    }
                    int i3 = i2 - i;
                    this.b.get(this.f3662a, i, i3);
                    i += i3;
                } catch (Exception unused) {
                    Log.isLoggable("GifHeaderParser", 3);
                    this.c.b = 1;
                }
            }
        }
        return i;
    }

    public final int[] d(int i) {
        byte[] bArr = new byte[(i * 3)];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | -16777216 | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException unused) {
            Log.isLoggable("GifHeaderParser", 3);
            this.c.b = 1;
        }
        return iArr;
    }

    public final int e() {
        return this.b.getShort();
    }

    public final void f() {
        int b2;
        do {
            b2 = b();
            this.b.position(Math.min(this.b.position() + b2, this.b.limit()));
        } while (b2 > 0);
    }
}
