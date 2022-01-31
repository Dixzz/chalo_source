package defpackage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* renamed from: ek2  reason: default package */
public class ek2 {
    public volatile int f = -1;

    public static final void b(ek2 ek2, byte[] bArr, int i) {
        try {
            yj2 yj2 = new yj2(bArr, 0, i);
            ek2.a(yj2);
            if (yj2.f4057a.remaining() != 0) {
                throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(yj2.f4057a.remaining())));
            }
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public void a(yj2 yj2) throws IOException {
    }

    public final int c() {
        int d = d();
        this.f = d;
        return d;
    }

    public int d() {
        return 0;
    }

    /* renamed from: e */
    public ek2 clone() throws CloneNotSupportedException {
        return (ek2) super.clone();
    }

    public String toString() {
        String str;
        String str2;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            gj1.b1(null, this, new StringBuffer(), stringBuffer);
            return stringBuffer.toString();
        } catch (IllegalAccessException e) {
            str2 = String.valueOf(e.getMessage());
            if (str2.length() == 0) {
                str = new String("Error printing proto: ");
                return str;
            }
            return "Error printing proto: ".concat(str2);
        } catch (InvocationTargetException e2) {
            str2 = String.valueOf(e2.getMessage());
            if (str2.length() == 0) {
                str = new String("Error printing proto: ");
                return str;
            }
            return "Error printing proto: ".concat(str2);
        }
    }
}
