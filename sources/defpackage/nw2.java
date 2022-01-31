package defpackage;

import com.google.firebase.perf.util.Constants;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: nw2  reason: default package */
/* compiled from: com.google.firebase:firebase-auth@@20.0.1 */
public final class nw2 implements vn2 {
    public static final ThreadLocal<Cipher> e = new lw2();
    public static final ThreadLocal<Cipher> f = new mw2();

    /* renamed from: a  reason: collision with root package name */
    public final byte[] f2612a;
    public final byte[] b;
    public final SecretKeySpec c;
    public final int d;

    public nw2(byte[] bArr, int i) throws GeneralSecurityException {
        if (i == 12 || i == 16) {
            this.d = i;
            mx2.a(bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            this.c = secretKeySpec;
            Cipher cipher = e.get();
            cipher.init(1, secretKeySpec);
            byte[] d2 = d(cipher.doFinal(new byte[16]));
            this.f2612a = d2;
            this.b = d(d2);
            return;
        }
        throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
    }

    public static byte[] c(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
        return bArr3;
    }

    public static byte[] d(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i = 0;
        int i2 = 0;
        while (i2 < 15) {
            byte b2 = bArr[i2];
            int i3 = i2 + 1;
            bArr2[i2] = (byte) (((b2 + b2) ^ ((bArr[i3] & 255) >>> 7)) & Constants.MAX_HOST_LENGTH);
            i2 = i3;
        }
        byte b3 = bArr[15];
        int i4 = b3 + b3;
        if ((bArr[0] & 128) != 0) {
            i = 135;
        }
        bArr2[15] = (byte) (i4 ^ i);
        return bArr2;
    }

    @Override // defpackage.vn2
    public final byte[] a(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        throw null;
    }

    @Override // defpackage.vn2
    public final byte[] b(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i = (length - this.d) - 16;
        if (i >= 0) {
            Cipher cipher = e.get();
            cipher.init(1, this.c);
            byte[] e2 = e(cipher, 0, bArr, 0, this.d);
            byte[] e3 = e(cipher, 1, bArr2, 0, bArr2.length);
            byte[] e4 = e(cipher, 2, bArr, this.d, i);
            int i2 = length - 16;
            byte b2 = 0;
            for (int i3 = 0; i3 < 16; i3++) {
                b2 = (byte) (b2 | (((bArr[i2 + i3] ^ e3[i3]) ^ e2[i3]) ^ e4[i3]));
            }
            if (b2 == 0) {
                Cipher cipher2 = f.get();
                cipher2.init(1, this.c, new IvParameterSpec(e2));
                return cipher2.doFinal(bArr, this.d, i);
            }
            throw new AEADBadTagException("tag mismatch");
        }
        throw new GeneralSecurityException("ciphertext too short");
    }

    public final byte[] e(Cipher cipher, int i, byte[] bArr, int i2, int i3) throws IllegalBlockSizeException, BadPaddingException {
        byte[] bArr2;
        int length;
        byte[] bArr3 = new byte[16];
        bArr3[15] = (byte) i;
        if (i3 == 0) {
            return cipher.doFinal(c(bArr3, this.f2612a));
        }
        byte[] doFinal = cipher.doFinal(bArr3);
        int i4 = 0;
        int i5 = 0;
        while (i3 - i5 > 16) {
            for (int i6 = 0; i6 < 16; i6++) {
                doFinal[i6] = (byte) (doFinal[i6] ^ bArr[(i2 + i5) + i6]);
            }
            doFinal = cipher.doFinal(doFinal);
            i5 += 16;
        }
        byte[] copyOfRange = Arrays.copyOfRange(bArr, i5 + i2, i2 + i3);
        if (copyOfRange.length == 16) {
            bArr2 = c(copyOfRange, this.f2612a);
        } else {
            byte[] copyOf = Arrays.copyOf(this.b, 16);
            while (true) {
                length = copyOfRange.length;
                if (i4 >= length) {
                    break;
                }
                copyOf[i4] = (byte) (copyOf[i4] ^ copyOfRange[i4]);
                i4++;
            }
            copyOf[length] = (byte) (copyOf[length] ^ 128);
            bArr2 = copyOf;
        }
        return cipher.doFinal(c(doFinal, bArr2));
    }
}
