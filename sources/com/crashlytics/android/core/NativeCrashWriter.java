package com.crashlytics.android.core;

import com.crashlytics.android.core.internal.models.BinaryImageData;
import com.crashlytics.android.core.internal.models.CustomAttributeData;
import com.crashlytics.android.core.internal.models.DeviceData;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.crashlytics.android.core.internal.models.SignalData;
import com.crashlytics.android.core.internal.models.ThreadData;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class NativeCrashWriter {
    private static final SignalData DEFAULT_SIGNAL = new SignalData("", "", 0);
    private static final BinaryImageMessage[] EMPTY_BINARY_IMAGE_MESSAGES = new BinaryImageMessage[0];
    private static final ProtobufMessage[] EMPTY_CHILDREN = new ProtobufMessage[0];
    private static final CustomAttributeMessage[] EMPTY_CUSTOM_ATTRIBUTE_MESSAGES = new CustomAttributeMessage[0];
    private static final FrameMessage[] EMPTY_FRAME_MESSAGES = new FrameMessage[0];
    private static final ThreadMessage[] EMPTY_THREAD_MESSAGES = new ThreadMessage[0];
    public static final String NDK_CRASH_TYPE = "ndk-crash";

    public static final class ApplicationMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 3;

        public ApplicationMessage(ExecutionMessage executionMessage, RepeatedMessage repeatedMessage) {
            super(3, executionMessage, repeatedMessage);
        }
    }

    public static final class BinaryImageMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 4;
        private final long baseAddr;
        private final String filePath;
        private final long imageSize;
        private final String uuid;

        public BinaryImageMessage(BinaryImageData binaryImageData) {
            super(4, new ProtobufMessage[0]);
            this.baseAddr = binaryImageData.baseAddress;
            this.imageSize = binaryImageData.size;
            this.filePath = binaryImageData.path;
            this.uuid = binaryImageData.id;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            int computeUInt64Size = CodedOutputStream.computeUInt64Size(1, this.baseAddr);
            return CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(this.filePath)) + computeUInt64Size + CodedOutputStream.computeUInt64Size(2, this.imageSize) + CodedOutputStream.computeBytesSize(4, ByteString.copyFromUtf8(this.uuid));
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.writeUInt64(1, this.baseAddr);
            codedOutputStream.writeUInt64(2, this.imageSize);
            codedOutputStream.writeBytes(3, ByteString.copyFromUtf8(this.filePath));
            codedOutputStream.writeBytes(4, ByteString.copyFromUtf8(this.uuid));
        }
    }

    public static final class CustomAttributeMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 2;
        private final String key;
        private final String value;

        public CustomAttributeMessage(CustomAttributeData customAttributeData) {
            super(2, new ProtobufMessage[0]);
            this.key = customAttributeData.key;
            this.value = customAttributeData.value;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            int computeBytesSize = CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(this.key));
            String str = this.value;
            if (str == null) {
                str = "";
            }
            return CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(str)) + computeBytesSize;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(this.key));
            String str = this.value;
            if (str == null) {
                str = "";
            }
            codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(str));
        }
    }

    public static final class DeviceMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 5;
        private final float batteryLevel;
        private final int batteryVelocity;
        private final long diskUsed;
        private final int orientation;
        private final boolean proximityOn;
        private final long ramUsed;

        public DeviceMessage(float f, int i, boolean z, int i2, long j, long j2) {
            super(5, new ProtobufMessage[0]);
            this.batteryLevel = f;
            this.batteryVelocity = i;
            this.proximityOn = z;
            this.orientation = i2;
            this.ramUsed = j;
            this.diskUsed = j2;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            return CodedOutputStream.computeUInt64Size(6, this.diskUsed) + CodedOutputStream.computeUInt64Size(5, this.ramUsed) + CodedOutputStream.computeUInt32Size(4, this.orientation) + CodedOutputStream.computeBoolSize(3, this.proximityOn) + CodedOutputStream.computeSInt32Size(2, this.batteryVelocity) + CodedOutputStream.computeFloatSize(1, this.batteryLevel) + 0;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.writeFloat(1, this.batteryLevel);
            codedOutputStream.writeSInt32(2, this.batteryVelocity);
            codedOutputStream.writeBool(3, this.proximityOn);
            codedOutputStream.writeUInt32(4, this.orientation);
            codedOutputStream.writeUInt64(5, this.ramUsed);
            codedOutputStream.writeUInt64(6, this.diskUsed);
        }
    }

    public static final class EventMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 10;
        private final String crashType;
        private final long time;

        public EventMessage(long j, String str, ProtobufMessage... protobufMessageArr) {
            super(10, protobufMessageArr);
            this.time = j;
            this.crashType = str;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            return CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.crashType)) + CodedOutputStream.computeUInt64Size(1, this.time);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.writeUInt64(1, this.time);
            codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(this.crashType));
        }
    }

    public static final class ExecutionMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 1;

        public ExecutionMessage(SignalMessage signalMessage, RepeatedMessage repeatedMessage, RepeatedMessage repeatedMessage2) {
            super(1, repeatedMessage, signalMessage, repeatedMessage2);
        }
    }

    public static final class FrameMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 3;
        private final long address;
        private final String file;
        private final int importance;
        private final long offset;
        private final String symbol;

        public FrameMessage(ThreadData.FrameData frameData) {
            super(3, new ProtobufMessage[0]);
            this.address = frameData.address;
            this.symbol = frameData.symbol;
            this.file = frameData.file;
            this.offset = frameData.offset;
            this.importance = frameData.importance;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            return CodedOutputStream.computeUInt32Size(5, this.importance) + CodedOutputStream.computeUInt64Size(4, this.offset) + CodedOutputStream.computeBytesSize(3, ByteString.copyFromUtf8(this.file)) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.symbol)) + CodedOutputStream.computeUInt64Size(1, this.address);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.writeUInt64(1, this.address);
            codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(this.symbol));
            codedOutputStream.writeBytes(3, ByteString.copyFromUtf8(this.file));
            codedOutputStream.writeUInt64(4, this.offset);
            codedOutputStream.writeUInt32(5, this.importance);
        }
    }

    public static final class LogMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 6;
        public ByteString logBytes;

        public LogMessage(ByteString byteString) {
            super(6, new ProtobufMessage[0]);
            this.logBytes = byteString;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            return CodedOutputStream.computeBytesSize(1, this.logBytes);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.writeBytes(1, this.logBytes);
        }
    }

    public static final class NullMessage extends ProtobufMessage {
        public NullMessage() {
            super(0, new ProtobufMessage[0]);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getSize() {
            return 0;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void write(CodedOutputStream codedOutputStream) throws IOException {
        }
    }

    public static abstract class ProtobufMessage {
        private final ProtobufMessage[] children;
        private final int tag;

        public ProtobufMessage(int i, ProtobufMessage... protobufMessageArr) {
            this.tag = i;
            this.children = protobufMessageArr == null ? NativeCrashWriter.EMPTY_CHILDREN : protobufMessageArr;
        }

        public int getPropertiesSize() {
            return 0;
        }

        public int getSize() {
            int sizeNoTag = getSizeNoTag();
            return CodedOutputStream.computeTagSize(this.tag) + CodedOutputStream.computeRawVarint32Size(sizeNoTag) + sizeNoTag;
        }

        public int getSizeNoTag() {
            int propertiesSize = getPropertiesSize();
            for (ProtobufMessage protobufMessage : this.children) {
                propertiesSize += protobufMessage.getSize();
            }
            return propertiesSize;
        }

        public void write(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.writeTag(this.tag, 2);
            codedOutputStream.writeRawVarint32(getSizeNoTag());
            writeProperties(codedOutputStream);
            for (ProtobufMessage protobufMessage : this.children) {
                protobufMessage.write(codedOutputStream);
            }
        }

        public void writeProperties(CodedOutputStream codedOutputStream) throws IOException {
        }
    }

    public static final class RepeatedMessage extends ProtobufMessage {
        private final ProtobufMessage[] messages;

        public RepeatedMessage(ProtobufMessage... protobufMessageArr) {
            super(0, new ProtobufMessage[0]);
            this.messages = protobufMessageArr;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getSize() {
            int i = 0;
            for (ProtobufMessage protobufMessage : this.messages) {
                i += protobufMessage.getSize();
            }
            return i;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void write(CodedOutputStream codedOutputStream) throws IOException {
            for (ProtobufMessage protobufMessage : this.messages) {
                protobufMessage.write(codedOutputStream);
            }
        }
    }

    public static final class SignalMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 3;
        private final long sigAddr;
        private final String sigCode;
        private final String sigName;

        public SignalMessage(SignalData signalData) {
            super(3, new ProtobufMessage[0]);
            this.sigName = signalData.name;
            this.sigCode = signalData.code;
            this.sigAddr = signalData.faultAddress;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            return CodedOutputStream.computeUInt64Size(3, this.sigAddr) + CodedOutputStream.computeBytesSize(2, ByteString.copyFromUtf8(this.sigCode)) + CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(this.sigName));
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream codedOutputStream) throws IOException {
            codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(this.sigName));
            codedOutputStream.writeBytes(2, ByteString.copyFromUtf8(this.sigCode));
            codedOutputStream.writeUInt64(3, this.sigAddr);
        }
    }

    public static final class ThreadMessage extends ProtobufMessage {
        private static final int PROTOBUF_TAG = 1;
        private final int importance;
        private final String name;

        public ThreadMessage(ThreadData threadData, RepeatedMessage repeatedMessage) {
            super(1, repeatedMessage);
            this.name = threadData.name;
            this.importance = threadData.importance;
        }

        private boolean hasName() {
            String str = this.name;
            return str != null && str.length() > 0;
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public int getPropertiesSize() {
            return CodedOutputStream.computeUInt32Size(2, this.importance) + (hasName() ? CodedOutputStream.computeBytesSize(1, ByteString.copyFromUtf8(this.name)) : 0);
        }

        @Override // com.crashlytics.android.core.NativeCrashWriter.ProtobufMessage
        public void writeProperties(CodedOutputStream codedOutputStream) throws IOException {
            if (hasName()) {
                codedOutputStream.writeBytes(1, ByteString.copyFromUtf8(this.name));
            }
            codedOutputStream.writeUInt32(2, this.importance);
        }
    }

    private static RepeatedMessage createBinaryImagesMessage(BinaryImageData[] binaryImageDataArr) {
        BinaryImageMessage[] binaryImageMessageArr = binaryImageDataArr != null ? new BinaryImageMessage[binaryImageDataArr.length] : EMPTY_BINARY_IMAGE_MESSAGES;
        for (int i = 0; i < binaryImageMessageArr.length; i++) {
            binaryImageMessageArr[i] = new BinaryImageMessage(binaryImageDataArr[i]);
        }
        return new RepeatedMessage(binaryImageMessageArr);
    }

    private static RepeatedMessage createCustomAttributesMessage(CustomAttributeData[] customAttributeDataArr) {
        CustomAttributeMessage[] customAttributeMessageArr = customAttributeDataArr != null ? new CustomAttributeMessage[customAttributeDataArr.length] : EMPTY_CUSTOM_ATTRIBUTE_MESSAGES;
        for (int i = 0; i < customAttributeMessageArr.length; i++) {
            customAttributeMessageArr[i] = new CustomAttributeMessage(customAttributeDataArr[i]);
        }
        return new RepeatedMessage(customAttributeMessageArr);
    }

    private static ProtobufMessage createDeviceMessage(DeviceData deviceData) {
        if (deviceData == null) {
            return new NullMessage();
        }
        return new DeviceMessage(((float) deviceData.batteryCapacity) / 100.0f, deviceData.batteryVelocity, deviceData.proximity, deviceData.orientation, deviceData.totalPhysicalMemory - deviceData.availablePhysicalMemory, deviceData.totalInternalStorage - deviceData.availableInternalStorage);
    }

    private static EventMessage createEventMessage(SessionEventData sessionEventData, LogFileManager logFileManager, Map<String, String> map) throws IOException {
        SignalData signalData = sessionEventData.signal;
        if (signalData == null) {
            signalData = DEFAULT_SIGNAL;
        }
        ApplicationMessage applicationMessage = new ApplicationMessage(new ExecutionMessage(new SignalMessage(signalData), createThreadsMessage(sessionEventData.threads), createBinaryImagesMessage(sessionEventData.binaryImages)), createCustomAttributesMessage(mergeCustomAttributes(sessionEventData.customAttributes, map)));
        ProtobufMessage createDeviceMessage = createDeviceMessage(sessionEventData.deviceData);
        ByteString byteStringForLog = logFileManager.getByteStringForLog();
        logFileManager.clearLog();
        return new EventMessage(sessionEventData.timestamp, NDK_CRASH_TYPE, applicationMessage, createDeviceMessage, byteStringForLog != null ? new LogMessage(byteStringForLog) : new NullMessage());
    }

    private static RepeatedMessage createFramesMessage(ThreadData.FrameData[] frameDataArr) {
        FrameMessage[] frameMessageArr = frameDataArr != null ? new FrameMessage[frameDataArr.length] : EMPTY_FRAME_MESSAGES;
        for (int i = 0; i < frameMessageArr.length; i++) {
            frameMessageArr[i] = new FrameMessage(frameDataArr[i]);
        }
        return new RepeatedMessage(frameMessageArr);
    }

    private static RepeatedMessage createThreadsMessage(ThreadData[] threadDataArr) {
        ThreadMessage[] threadMessageArr = threadDataArr != null ? new ThreadMessage[threadDataArr.length] : EMPTY_THREAD_MESSAGES;
        for (int i = 0; i < threadMessageArr.length; i++) {
            ThreadData threadData = threadDataArr[i];
            threadMessageArr[i] = new ThreadMessage(threadData, createFramesMessage(threadData.frames));
        }
        return new RepeatedMessage(threadMessageArr);
    }

    private static CustomAttributeData[] mergeCustomAttributes(CustomAttributeData[] customAttributeDataArr, Map<String, String> map) {
        TreeMap treeMap = new TreeMap(map);
        if (customAttributeDataArr != null) {
            for (CustomAttributeData customAttributeData : customAttributeDataArr) {
                treeMap.put(customAttributeData.key, customAttributeData.value);
            }
        }
        Map.Entry[] entryArr = (Map.Entry[]) treeMap.entrySet().toArray(new Map.Entry[treeMap.size()]);
        int length = entryArr.length;
        CustomAttributeData[] customAttributeDataArr2 = new CustomAttributeData[length];
        for (int i = 0; i < length; i++) {
            customAttributeDataArr2[i] = new CustomAttributeData((String) entryArr[i].getKey(), (String) entryArr[i].getValue());
        }
        return customAttributeDataArr2;
    }

    public static void writeNativeCrash(SessionEventData sessionEventData, LogFileManager logFileManager, Map<String, String> map, CodedOutputStream codedOutputStream) throws IOException {
        createEventMessage(sessionEventData, logFileManager, map).write(codedOutputStream);
    }
}