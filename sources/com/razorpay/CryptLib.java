package com.razorpay;

import android.util.Base64;
import com.rabbitmq.client.StringRpcServer;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class CryptLib {

    /* renamed from: a  reason: collision with root package name */
    private Cipher f669a = Cipher.getInstance("AES/CBC/PKCS5Padding");
    private byte[] b = new byte[32];
    private byte[] c = new byte[16];

    public enum EncryptMode {
        ENCRYPT,
        DECRYPT
    }

    private String a(String str, String str2, EncryptMode encryptMode, String str3) {
        String str4;
        int length = str2.getBytes(StringRpcServer.STRING_ENCODING).length;
        int length2 = str2.getBytes(StringRpcServer.STRING_ENCODING).length;
        byte[] bArr = this.b;
        if (length2 > bArr.length) {
            length = bArr.length;
        }
        int length3 = str3.getBytes(StringRpcServer.STRING_ENCODING).length;
        int length4 = str3.getBytes(StringRpcServer.STRING_ENCODING).length;
        byte[] bArr2 = this.c;
        if (length4 > bArr2.length) {
            length3 = bArr2.length;
        }
        System.arraycopy(str2.getBytes(StringRpcServer.STRING_ENCODING), 0, this.b, 0, length);
        System.arraycopy(str3.getBytes(StringRpcServer.STRING_ENCODING), 0, this.c, 0, length3);
        SecretKeySpec secretKeySpec = new SecretKeySpec(this.b, "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(this.c);
        if (encryptMode.equals(EncryptMode.ENCRYPT)) {
            this.f669a.init(1, secretKeySpec, ivParameterSpec);
            str4 = Base64.encodeToString(this.f669a.doFinal(str.getBytes(StringRpcServer.STRING_ENCODING)), 2);
        } else {
            str4 = "";
        }
        if (!encryptMode.equals(EncryptMode.DECRYPT)) {
            return str4;
        }
        this.f669a.init(2, secretKeySpec, ivParameterSpec);
        return new String(this.f669a.doFinal(Base64.decode(str.getBytes(), 2)));
    }

    public final String b(String str, String str2, String str3) {
        return a(str, str2, EncryptMode.DECRYPT, str3);
    }

    public final String a(String str, String str2, String str3) {
        return a(str, str2, EncryptMode.ENCRYPT, str3);
    }
}
