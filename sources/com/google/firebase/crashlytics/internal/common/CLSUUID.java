package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

public class CLSUUID {
    private static String _clsId;
    private static final AtomicLong _sequenceNumber = new AtomicLong(0);

    public CLSUUID(IdManager idManager) {
        byte[] bArr = new byte[10];
        populateTime(bArr);
        populateSequenceNumber(bArr);
        populatePID(bArr);
        String sha1 = CommonUtils.sha1(idManager.getCrashlyticsInstallId());
        String hexify = CommonUtils.hexify(bArr);
        Locale locale = Locale.US;
        _clsId = String.format(locale, "%s-%s-%s-%s", hexify.substring(0, 12), hexify.substring(12, 16), hexify.subSequence(16, 20), sha1.substring(0, 12)).toUpperCase(locale);
    }

    private static byte[] convertLongToFourByteBuffer(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] convertLongToTwoByteBuffer(long j) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void populatePID(byte[] bArr) {
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = convertLongToTwoByteBuffer[0];
        bArr[9] = convertLongToTwoByteBuffer[1];
    }

    private void populateSequenceNumber(byte[] bArr) {
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer(_sequenceNumber.incrementAndGet());
        bArr[6] = convertLongToTwoByteBuffer[0];
        bArr[7] = convertLongToTwoByteBuffer[1];
    }

    private void populateTime(byte[] bArr) {
        long time = new Date().getTime();
        byte[] convertLongToFourByteBuffer = convertLongToFourByteBuffer(time / 1000);
        bArr[0] = convertLongToFourByteBuffer[0];
        bArr[1] = convertLongToFourByteBuffer[1];
        bArr[2] = convertLongToFourByteBuffer[2];
        bArr[3] = convertLongToFourByteBuffer[3];
        byte[] convertLongToTwoByteBuffer = convertLongToTwoByteBuffer(time % 1000);
        bArr[4] = convertLongToTwoByteBuffer[0];
        bArr[5] = convertLongToTwoByteBuffer[1];
    }

    public String toString() {
        return _clsId;
    }
}
