package com.freshchat.consumer.sdk.j.b;

import android.os.SystemClock;
import com.freshchat.consumer.sdk.j.ai;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class a {
    private long km;
    private long kn;
    private long ko;
    private long offset = -2147483648L;

    private void a(byte[] bArr, int i, long j) {
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        long j4 = j2 + 2208988800L;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) (j4 >> 24));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) (j4 >> 16));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) (j4 >> 8));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) (j4 >> 0));
        long j5 = (j3 * 4294967296L) / 1000;
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) (j5 >> 24));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) (j5 >> 16));
        bArr[i7] = (byte) ((int) (j5 >> 8));
        bArr[i7 + 1] = (byte) ((int) (Math.random() * 255.0d));
    }

    private long b(byte[] bArr, int i) {
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        byte b4 = bArr[i + 3];
        int i2 = b & 128;
        byte b5 = b;
        if (i2 == 128) {
            b5 = (b & Byte.MAX_VALUE) + 128;
        }
        int i3 = b2 & 128;
        byte b6 = b2;
        if (i3 == 128) {
            b6 = (b2 & Byte.MAX_VALUE) + 128;
        }
        int i4 = b3 & 128;
        byte b7 = b3;
        if (i4 == 128) {
            b7 = (b3 & Byte.MAX_VALUE) + 128;
        }
        int i5 = b4 & 128;
        byte b8 = b4;
        if (i5 == 128) {
            b8 = (b4 & Byte.MAX_VALUE) + 128;
        }
        return ((b5 == 1 ? 1 : 0) << 24) + ((b6 == 1 ? 1 : 0) << 16) + ((b7 == 1 ? 1 : 0) << 8) + (b8 == 1 ? 1 : 0);
    }

    private long c(byte[] bArr, int i) {
        long b = b(bArr, i);
        return ((b(bArr, i + 4) * 1000) / 4294967296L) + ((b - 2208988800L) * 1000);
    }

    public boolean c(String str, int i) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.setSoTimeout(i);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, InetAddress.getByName(str), 123);
            bArr[0] = 27;
            long currentTimeMillis = System.currentTimeMillis();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            a(bArr, 40, currentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            long j = elapsedRealtime2 - elapsedRealtime;
            long j2 = currentTimeMillis + j;
            datagramSocket.close();
            long c = c(bArr, 24);
            long c2 = c(bArr, 32);
            long c3 = c(bArr, 40);
            long j3 = ((c3 - j2) + (c2 - c)) / 2;
            this.offset = j3;
            this.km = j2 + j3;
            this.kn = elapsedRealtime2;
            this.ko = j - (c3 - c2);
            return true;
        } catch (Exception e) {
            ai.e("SntpClient", "request time failed: " + e);
            return false;
        }
    }

    public long fB() {
        return this.offset;
    }
}
