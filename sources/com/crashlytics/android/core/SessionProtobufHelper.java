package com.crashlytics.android.core;

import android.app.ActivityManager;
import android.os.Build;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import defpackage.o06;
import java.util.List;
import java.util.Map;

public class SessionProtobufHelper {
    private static final String SIGNAL_DEFAULT = "0";
    private static final ByteString SIGNAL_DEFAULT_BYTE_STRING = ByteString.copyFromUtf8(SIGNAL_DEFAULT);
    private static final ByteString UNITY_PLATFORM_BYTE_STRING = ByteString.copyFromUtf8(CrashlyticsReport.DEVELOPMENT_PLATFORM_UNITY);

    private SessionProtobufHelper() {
    }

    private static int getBinaryImageSize(ByteString byteString, ByteString byteString2) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(3, byteString) + CodedOutputStream.computeUInt64Size(2, 0) + CodedOutputStream.computeUInt64Size(1, 0) + 0;
        return byteString2 != null ? computeBytesSize + CodedOutputStream.computeBytesSize(4, byteString2) : computeBytesSize;
    }

    private static int getDeviceIdentifierSize(o06.a aVar, String str) {
        return CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(str)) + CodedOutputStream.computeEnumSize(1, aVar.protobufIndex);
    }

    private static int getEventAppCustomAttributeSize(String str, String str2) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(str));
        if (str2 == null) {
            str2 = "";
        }
        return CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(str2)) + computeBytesSize;
    }

    private static int getEventAppExecutionExceptionSize(TrimmedThrowableData trimmedThrowableData, int i, int i2) {
        int i3 = 0;
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(trimmedThrowableData.className)) + 0;
        String str = trimmedThrowableData.localizedMessage;
        if (str != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(str));
        }
        for (StackTraceElement stackTraceElement : trimmedThrowableData.stacktrace) {
            int frameSize = getFrameSize(stackTraceElement, true);
            computeBytesSize += CodedOutputStream.computeRawVarint32Size(frameSize) + CodedOutputStream.computeTagSize(4) + frameSize;
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (trimmedThrowableData2 == null) {
            return computeBytesSize;
        }
        if (i < i2) {
            int eventAppExecutionExceptionSize = getEventAppExecutionExceptionSize(trimmedThrowableData2, i + 1, i2);
            return computeBytesSize + CodedOutputStream.computeRawVarint32Size(eventAppExecutionExceptionSize) + CodedOutputStream.computeTagSize(6) + eventAppExecutionExceptionSize;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.cause;
            i3++;
        }
        return computeBytesSize + CodedOutputStream.computeUInt32Size(7, i3);
    }

    private static int getEventAppExecutionSignalSize() {
        ByteString byteString = SIGNAL_DEFAULT_BYTE_STRING;
        return CodedOutputStream.computeUInt64Size(3, 0) + CodedOutputStream.computeBytesSize(2, byteString) + CodedOutputStream.computeBytesSize(1, byteString) + 0;
    }

    private static int getEventAppExecutionSize(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2) {
        int threadSize = getThreadSize(thread, stackTraceElementArr, 4, true);
        int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(threadSize) + CodedOutputStream.computeTagSize(1) + threadSize + 0;
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            int threadSize2 = getThreadSize(threadArr[i2], list.get(i2), 0, false);
            computeRawVarint32Size += CodedOutputStream.computeRawVarint32Size(threadSize2) + CodedOutputStream.computeTagSize(1) + threadSize2;
        }
        int eventAppExecutionExceptionSize = getEventAppExecutionExceptionSize(trimmedThrowableData, 1, i);
        int computeTagSize = CodedOutputStream.computeTagSize(2);
        int eventAppExecutionSignalSize = getEventAppExecutionSignalSize();
        int computeRawVarint32Size2 = CodedOutputStream.computeRawVarint32Size(eventAppExecutionSignalSize) + CodedOutputStream.computeTagSize(3) + eventAppExecutionSignalSize + CodedOutputStream.computeRawVarint32Size(eventAppExecutionExceptionSize) + computeTagSize + eventAppExecutionExceptionSize + computeRawVarint32Size;
        int binaryImageSize = getBinaryImageSize(byteString, byteString2);
        return CodedOutputStream.computeRawVarint32Size(binaryImageSize) + CodedOutputStream.computeTagSize(3) + binaryImageSize + computeRawVarint32Size2;
    }

    private static int getEventAppSize(TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) {
        int eventAppExecutionSize = getEventAppExecutionSize(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2);
        boolean z = true;
        int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(eventAppExecutionSize) + CodedOutputStream.computeTagSize(1) + eventAppExecutionSize + 0;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                int eventAppCustomAttributeSize = getEventAppCustomAttributeSize(entry.getKey(), entry.getValue());
                computeRawVarint32Size += CodedOutputStream.computeRawVarint32Size(eventAppCustomAttributeSize) + CodedOutputStream.computeTagSize(2) + eventAppCustomAttributeSize;
            }
        }
        if (runningAppProcessInfo != null) {
            if (runningAppProcessInfo.importance == 100) {
                z = false;
            }
            computeRawVarint32Size += CodedOutputStream.computeBoolSize(3, z);
        }
        return CodedOutputStream.computeUInt32Size(4, i2) + computeRawVarint32Size;
    }

    private static int getEventDeviceSize(Float f, int i, boolean z, int i2, long j, long j2) {
        int i3 = 0;
        if (f != null) {
            i3 = 0 + CodedOutputStream.computeFloatSize(1, f.floatValue());
        }
        return CodedOutputStream.computeUInt64Size(6, j2) + CodedOutputStream.computeUInt64Size(5, j) + CodedOutputStream.computeUInt32Size(4, i2) + CodedOutputStream.computeBoolSize(3, z) + CodedOutputStream.computeSInt32Size(2, i) + i3;
    }

    private static int getEventLogSize(ByteString byteString) {
        return CodedOutputStream.computeBytesSize(1, byteString);
    }

    private static int getFrameSize(StackTraceElement stackTraceElement, boolean z) {
        int i;
        int i2 = 0;
        if (stackTraceElement.isNativeMethod()) {
            i = CodedOutputStream.computeUInt64Size(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            i = CodedOutputStream.computeUInt64Size(1, 0);
        }
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName())) + i + 0;
        if (stackTraceElement.getFileName() != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            computeBytesSize += CodedOutputStream.computeUInt64Size(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i2 = 2;
        }
        return CodedOutputStream.computeUInt32Size(5, i2) + computeBytesSize;
    }

    private static int getSessionAppOrgSize(ByteString byteString) {
        return CodedOutputStream.computeBytesSize(1, byteString) + 0;
    }

    private static int getSessionAppSize(ByteString byteString, ByteString byteString2, ByteString byteString3, ByteString byteString4, ByteString byteString5, int i, ByteString byteString6) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(3, byteString4) + CodedOutputStream.computeBytesSize(2, byteString3) + CodedOutputStream.computeBytesSize(1, byteString) + 0;
        int sessionAppOrgSize = getSessionAppOrgSize(byteString2);
        int computeBytesSize2 = CodedOutputStream.computeBytesSize(6, byteString5) + CodedOutputStream.computeRawVarint32Size(sessionAppOrgSize) + CodedOutputStream.computeTagSize(5) + sessionAppOrgSize + computeBytesSize;
        if (byteString6 != null) {
            computeBytesSize2 = CodedOutputStream.computeBytesSize(9, byteString6) + CodedOutputStream.computeBytesSize(8, UNITY_PLATFORM_BYTE_STRING) + computeBytesSize2;
        }
        return CodedOutputStream.computeEnumSize(10, i) + computeBytesSize2;
    }

    private static int getSessionDeviceSize(int i, ByteString byteString, ByteString byteString2, int i2, long j, long j2, boolean z, Map<o06.a, String> map, int i3, ByteString byteString3, ByteString byteString4) {
        int i4;
        int i5;
        int i6 = 0;
        int computeEnumSize = CodedOutputStream.computeEnumSize(3, i) + CodedOutputStream.computeBytesSize(1, byteString) + 0;
        if (byteString2 == null) {
            i4 = 0;
        } else {
            i4 = CodedOutputStream.computeBytesSize(4, byteString2);
        }
        int computeBoolSize = CodedOutputStream.computeBoolSize(10, z) + CodedOutputStream.computeUInt64Size(7, j2) + CodedOutputStream.computeUInt64Size(6, j) + CodedOutputStream.computeUInt32Size(5, i2) + computeEnumSize + i4;
        if (map != null) {
            for (Map.Entry<o06.a, String> entry : map.entrySet()) {
                int deviceIdentifierSize = getDeviceIdentifierSize(entry.getKey(), entry.getValue());
                computeBoolSize += CodedOutputStream.computeRawVarint32Size(deviceIdentifierSize) + CodedOutputStream.computeTagSize(11) + deviceIdentifierSize;
            }
        }
        int computeUInt32Size = CodedOutputStream.computeUInt32Size(12, i3) + computeBoolSize;
        if (byteString3 == null) {
            i5 = 0;
        } else {
            i5 = CodedOutputStream.computeBytesSize(13, byteString3);
        }
        int i7 = computeUInt32Size + i5;
        if (byteString4 != null) {
            i6 = CodedOutputStream.computeBytesSize(14, byteString4);
        }
        return i7 + i6;
    }

    private static int getSessionEventSize(long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2, ByteString byteString, ByteString byteString2, Float f, int i3, boolean z, long j2, long j3, ByteString byteString3) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(str)) + CodedOutputStream.computeUInt64Size(1, j) + 0;
        int eventAppSize = getEventAppSize(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2, map, runningAppProcessInfo, i2);
        int computeRawVarint32Size = CodedOutputStream.computeRawVarint32Size(eventAppSize) + CodedOutputStream.computeTagSize(3) + eventAppSize + computeBytesSize;
        int eventDeviceSize = getEventDeviceSize(f, i3, z, i2, j2, j3);
        int computeRawVarint32Size2 = CodedOutputStream.computeRawVarint32Size(eventDeviceSize) + CodedOutputStream.computeTagSize(5) + eventDeviceSize + computeRawVarint32Size;
        if (byteString3 == null) {
            return computeRawVarint32Size2;
        }
        int eventLogSize = getEventLogSize(byteString3);
        return computeRawVarint32Size2 + CodedOutputStream.computeRawVarint32Size(eventLogSize) + CodedOutputStream.computeTagSize(6) + eventLogSize;
    }

    private static int getSessionOSSize(ByteString byteString, ByteString byteString2, boolean z) {
        int computeBytesSize = CodedOutputStream.computeBytesSize(2, byteString);
        return CodedOutputStream.computeBoolSize(4, z) + CodedOutputStream.computeBytesSize(3, byteString2) + computeBytesSize + CodedOutputStream.computeEnumSize(1, 3) + 0;
    }

    private static int getThreadSize(Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) {
        int computeUInt32Size = CodedOutputStream.computeUInt32Size(2, i) + CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(thread.getName()));
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            int frameSize = getFrameSize(stackTraceElement, z);
            computeUInt32Size += CodedOutputStream.computeRawVarint32Size(frameSize) + CodedOutputStream.computeTagSize(3) + frameSize;
        }
        return computeUInt32Size;
    }

    private static ByteString stringToByteString(String str) {
        if (str == null) {
            return null;
        }
        return ByteString.copyFromUtf8(str);
    }

    public static void writeBeginSession(CodedOutputStream codedOutputStream, String str, String str2, long j) throws Exception {
        codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(str2));
        codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(str));
        codedOutputStream.writeUInt64(3, j);
    }

    private static void writeFrame(CodedOutputStream codedOutputStream, int i, StackTraceElement stackTraceElement, boolean z) throws Exception {
        codedOutputStream.writeTag(i, 2);
        codedOutputStream.writeRawVarint32(getFrameSize(stackTraceElement, z));
        int i2 = 0;
        if (stackTraceElement.isNativeMethod()) {
            codedOutputStream.writeUInt64(1, (long) Math.max(stackTraceElement.getLineNumber(), 0));
        } else {
            codedOutputStream.writeUInt64(1, 0);
        }
        codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName()));
        if (stackTraceElement.getFileName() != null) {
            codedOutputStream.writeBytes(3, ByteString.copyFromUtf8(stackTraceElement.getFileName()));
        }
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            codedOutputStream.writeUInt64(4, (long) stackTraceElement.getLineNumber());
        }
        if (z) {
            i2 = 4;
        }
        codedOutputStream.writeUInt32(5, i2);
    }

    public static void writeSessionApp(CodedOutputStream codedOutputStream, String str, String str2, String str3, String str4, String str5, int i, String str6) throws Exception {
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str);
        ByteString copyFromUtf82 = ByteString.copyFromUtf8(str2);
        ByteString copyFromUtf83 = ByteString.copyFromUtf8(str3);
        ByteString copyFromUtf84 = ByteString.copyFromUtf8(str4);
        ByteString copyFromUtf85 = ByteString.copyFromUtf8(str5);
        ByteString copyFromUtf86 = str6 != null ? ByteString.copyFromUtf8(str6) : null;
        codedOutputStream.writeTag(7, 2);
        codedOutputStream.writeRawVarint32(getSessionAppSize(copyFromUtf8, copyFromUtf82, copyFromUtf83, copyFromUtf84, copyFromUtf85, i, copyFromUtf86));
        codedOutputStream.writeBytes(1, copyFromUtf8);
        codedOutputStream.writeBytes(2, copyFromUtf83);
        codedOutputStream.writeBytes(3, copyFromUtf84);
        codedOutputStream.writeTag(5, 2);
        codedOutputStream.writeRawVarint32(getSessionAppOrgSize(copyFromUtf82));
        codedOutputStream.writeBytes(1, copyFromUtf82);
        codedOutputStream.writeBytes(6, copyFromUtf85);
        if (copyFromUtf86 != null) {
            codedOutputStream.writeBytes(8, UNITY_PLATFORM_BYTE_STRING);
            codedOutputStream.writeBytes(9, copyFromUtf86);
        }
        codedOutputStream.writeEnum(10, i);
    }

    public static void writeSessionDevice(CodedOutputStream codedOutputStream, String str, int i, String str2, int i2, long j, long j2, boolean z, Map<o06.a, String> map, int i3, String str3, String str4) throws Exception {
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str);
        ByteString stringToByteString = stringToByteString(str2);
        ByteString stringToByteString2 = stringToByteString(str4);
        ByteString stringToByteString3 = stringToByteString(str3);
        codedOutputStream.writeTag(9, 2);
        codedOutputStream.writeRawVarint32(getSessionDeviceSize(i, copyFromUtf8, stringToByteString, i2, j, j2, z, map, i3, stringToByteString3, stringToByteString2));
        codedOutputStream.writeBytes(1, copyFromUtf8);
        codedOutputStream.writeEnum(3, i);
        codedOutputStream.writeBytes(4, stringToByteString);
        codedOutputStream.writeUInt32(5, i2);
        codedOutputStream.writeUInt64(6, j);
        codedOutputStream.writeUInt64(7, j2);
        codedOutputStream.writeBool(10, z);
        for (Map.Entry<o06.a, String> entry : map.entrySet()) {
            codedOutputStream.writeTag(11, 2);
            codedOutputStream.writeRawVarint32(getDeviceIdentifierSize(entry.getKey(), entry.getValue()));
            codedOutputStream.writeEnum(1, entry.getKey().protobufIndex);
            codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(entry.getValue()));
        }
        codedOutputStream.writeUInt32(12, i3);
        if (stringToByteString3 != null) {
            codedOutputStream.writeBytes(13, stringToByteString3);
        }
        if (stringToByteString2 != null) {
            codedOutputStream.writeBytes(14, stringToByteString2);
        }
    }

    public static void writeSessionEvent(CodedOutputStream codedOutputStream, long j, String str, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, Map<String, String> map, LogFileManager logFileManager, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i, String str2, String str3, Float f, int i2, boolean z, long j2, long j3) throws Exception {
        ByteString byteString;
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str2);
        if (str3 == null) {
            byteString = null;
        } else {
            byteString = ByteString.copyFromUtf8(str3.replace("-", ""));
        }
        ByteString byteStringForLog = logFileManager.getByteStringForLog();
        logFileManager.clearLog();
        codedOutputStream.writeTag(10, 2);
        codedOutputStream.writeRawVarint32(getSessionEventSize(j, str, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, 8, map, runningAppProcessInfo, i, copyFromUtf8, byteString, f, i2, z, j2, j3, byteStringForLog));
        codedOutputStream.writeUInt64(1, j);
        codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(str));
        writeSessionEventApp(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, 8, copyFromUtf8, byteString, map, runningAppProcessInfo, i);
        writeSessionEventDevice(codedOutputStream, f, i2, z, i, j2, j3);
        writeSessionEventLog(codedOutputStream, byteStringForLog);
    }

    private static void writeSessionEventApp(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2, Map<String, String> map, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i2) throws Exception {
        codedOutputStream.writeTag(3, 2);
        codedOutputStream.writeRawVarint32(getEventAppSize(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2, map, runningAppProcessInfo, i2));
        writeSessionEventAppExecution(codedOutputStream, trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2);
        if (map != null && !map.isEmpty()) {
            writeSessionEventAppCustomAttributes(codedOutputStream, map);
        }
        if (runningAppProcessInfo != null) {
            codedOutputStream.writeBool(3, runningAppProcessInfo.importance != 100);
        }
        codedOutputStream.writeUInt32(4, i2);
    }

    private static void writeSessionEventAppCustomAttributes(CodedOutputStream codedOutputStream, Map<String, String> map) throws Exception {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            codedOutputStream.writeTag(2, 2);
            codedOutputStream.writeRawVarint32(getEventAppCustomAttributeSize(entry.getKey(), entry.getValue()));
            codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(entry.getKey()));
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(value));
        }
    }

    private static void writeSessionEventAppExecution(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, Thread thread, StackTraceElement[] stackTraceElementArr, Thread[] threadArr, List<StackTraceElement[]> list, int i, ByteString byteString, ByteString byteString2) throws Exception {
        codedOutputStream.writeTag(1, 2);
        codedOutputStream.writeRawVarint32(getEventAppExecutionSize(trimmedThrowableData, thread, stackTraceElementArr, threadArr, list, i, byteString, byteString2));
        writeThread(codedOutputStream, thread, stackTraceElementArr, 4, true);
        int length = threadArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            writeThread(codedOutputStream, threadArr[i2], list.get(i2), 0, false);
        }
        writeSessionEventAppExecutionException(codedOutputStream, trimmedThrowableData, 1, i, 2);
        codedOutputStream.writeTag(3, 2);
        codedOutputStream.writeRawVarint32(getEventAppExecutionSignalSize());
        ByteString byteString3 = SIGNAL_DEFAULT_BYTE_STRING;
        codedOutputStream.writeBytes(1, byteString3);
        codedOutputStream.writeBytes(2, byteString3);
        codedOutputStream.writeUInt64(3, 0);
        codedOutputStream.writeTag(4, 2);
        codedOutputStream.writeRawVarint32(getBinaryImageSize(byteString, byteString2));
        codedOutputStream.writeUInt64(1, 0);
        codedOutputStream.writeUInt64(2, 0);
        codedOutputStream.writeBytes(3, byteString);
        if (byteString2 != null) {
            codedOutputStream.writeBytes(4, byteString2);
        }
    }

    private static void writeSessionEventAppExecutionException(CodedOutputStream codedOutputStream, TrimmedThrowableData trimmedThrowableData, int i, int i2, int i3) throws Exception {
        codedOutputStream.writeTag(i3, 2);
        codedOutputStream.writeRawVarint32(getEventAppExecutionExceptionSize(trimmedThrowableData, 1, i2));
        codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(trimmedThrowableData.className));
        String str = trimmedThrowableData.localizedMessage;
        if (str != null) {
            codedOutputStream.writeBytes(3, ByteString.copyFromUtf8(str));
        }
        int i4 = 0;
        for (StackTraceElement stackTraceElement : trimmedThrowableData.stacktrace) {
            writeFrame(codedOutputStream, 4, stackTraceElement, true);
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.cause;
        if (trimmedThrowableData2 == null) {
            return;
        }
        if (i < i2) {
            writeSessionEventAppExecutionException(codedOutputStream, trimmedThrowableData2, i + 1, i2, 6);
            return;
        }
        while (trimmedThrowableData2 != null) {
            trimmedThrowableData2 = trimmedThrowableData2.cause;
            i4++;
        }
        codedOutputStream.writeUInt32(7, i4);
    }

    private static void writeSessionEventDevice(CodedOutputStream codedOutputStream, Float f, int i, boolean z, int i2, long j, long j2) throws Exception {
        codedOutputStream.writeTag(5, 2);
        codedOutputStream.writeRawVarint32(getEventDeviceSize(f, i, z, i2, j, j2));
        if (f != null) {
            codedOutputStream.writeFloat(1, f.floatValue());
        }
        codedOutputStream.writeSInt32(2, i);
        codedOutputStream.writeBool(3, z);
        codedOutputStream.writeUInt32(4, i2);
        codedOutputStream.writeUInt64(5, j);
        codedOutputStream.writeUInt64(6, j2);
    }

    private static void writeSessionEventLog(CodedOutputStream codedOutputStream, ByteString byteString) throws Exception {
        if (byteString != null) {
            codedOutputStream.writeTag(6, 2);
            codedOutputStream.writeRawVarint32(getEventLogSize(byteString));
            codedOutputStream.writeBytes(1, byteString);
        }
    }

    public static void writeSessionOS(CodedOutputStream codedOutputStream, boolean z) throws Exception {
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(Build.VERSION.RELEASE);
        ByteString copyFromUtf82 = ByteString.copyFromUtf8(Build.VERSION.CODENAME);
        codedOutputStream.writeTag(8, 2);
        codedOutputStream.writeRawVarint32(getSessionOSSize(copyFromUtf8, copyFromUtf82, z));
        codedOutputStream.writeEnum(1, 3);
        codedOutputStream.writeBytes(2, copyFromUtf8);
        codedOutputStream.writeBytes(3, copyFromUtf82);
        codedOutputStream.writeBool(4, z);
    }

    public static void writeSessionUser(CodedOutputStream codedOutputStream, String str, String str2, String str3) throws Exception {
        if (str == null) {
            str = "";
        }
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str);
        ByteString stringToByteString = stringToByteString(str2);
        ByteString stringToByteString2 = stringToByteString(str3);
        int computeBytesSize = CodedOutputStream.computeBytesSize(1, copyFromUtf8) + 0;
        if (str2 != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(2, stringToByteString);
        }
        if (str3 != null) {
            computeBytesSize += CodedOutputStream.computeBytesSize(3, stringToByteString2);
        }
        codedOutputStream.writeTag(6, 2);
        codedOutputStream.writeRawVarint32(computeBytesSize);
        codedOutputStream.writeBytes(1, copyFromUtf8);
        if (str2 != null) {
            codedOutputStream.writeBytes(2, stringToByteString);
        }
        if (str3 != null) {
            codedOutputStream.writeBytes(3, stringToByteString2);
        }
    }

    private static void writeThread(CodedOutputStream codedOutputStream, Thread thread, StackTraceElement[] stackTraceElementArr, int i, boolean z) throws Exception {
        codedOutputStream.writeTag(1, 2);
        codedOutputStream.writeRawVarint32(getThreadSize(thread, stackTraceElementArr, i, z));
        codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(thread.getName()));
        codedOutputStream.writeUInt32(2, i);
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            writeFrame(codedOutputStream, 3, stackTraceElement, z);
        }
    }
}
