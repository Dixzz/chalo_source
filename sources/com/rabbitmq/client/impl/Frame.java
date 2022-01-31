package com.rabbitmq.client.impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.LongString;
import com.rabbitmq.client.MalformedFrameException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.SocketTimeoutException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Frame {
    private final ByteArrayOutputStream accumulator;
    public final int channel;
    private final byte[] payload;
    public final int type;

    public Frame(int i, int i2) {
        this.type = i;
        this.channel = i2;
        this.payload = null;
        this.accumulator = new ByteArrayOutputStream();
    }

    public static long arraySize(List<?> list) throws UnsupportedEncodingException {
        Iterator<?> it = list.iterator();
        long j = 0;
        while (it.hasNext()) {
            j += fieldValueSize(it.next());
        }
        return j;
    }

    private static long fieldValueSize(Object obj) throws UnsupportedEncodingException {
        long arraySize;
        int length;
        long j;
        if (obj instanceof String) {
            length = longStrSize((String) obj);
        } else {
            if (obj instanceof LongString) {
                arraySize = ((LongString) obj).length();
            } else {
                if (!(obj instanceof Integer)) {
                    if (obj instanceof BigDecimal) {
                        return 6;
                    }
                    if (!(obj instanceof Date) && !(obj instanceof Timestamp)) {
                        if (obj instanceof Map) {
                            arraySize = tableSize((Map) obj);
                        } else if (obj instanceof Byte) {
                            return 2;
                        } else {
                            if (!(obj instanceof Double)) {
                                if (!(obj instanceof Float)) {
                                    if (!(obj instanceof Long)) {
                                        if (obj instanceof Short) {
                                            return 3;
                                        }
                                        if (obj instanceof Boolean) {
                                            return 2;
                                        }
                                        if (obj instanceof byte[]) {
                                            length = ((byte[]) obj).length + 4;
                                        } else if (obj instanceof List) {
                                            arraySize = arraySize((List) obj);
                                        } else if (obj instanceof Object[]) {
                                            arraySize = arraySize((Object[]) obj);
                                        } else if (obj == null) {
                                            return 1;
                                        } else {
                                            throw new IllegalArgumentException("invalid value in table");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    return 9;
                }
                return 5;
            }
            j = arraySize + 4;
            return j + 1;
        }
        j = (long) length;
        return j + 1;
    }

    public static Frame fromBodyFragment(int i, byte[] bArr, int i2, int i3) throws IOException {
        Frame frame = new Frame(3, i);
        frame.getOutputStream().write(bArr, i2, i3);
        return frame;
    }

    private static int longStrSize(String str) throws UnsupportedEncodingException {
        return str.getBytes("utf-8").length + 4;
    }

    public static void protocolVersionMismatch(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = {77, 81, 80};
        for (int i = 0; i < 3; i++) {
            byte b = bArr[i];
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            if (readUnsignedByte != b) {
                throw new MalformedFrameException(hj1.L("Invalid AMQP protocol header from server: expected character ", b, ", got ", readUnsignedByte));
            }
        }
        try {
            int[] iArr = new int[4];
            for (int i2 = 0; i2 < 4; i2++) {
                iArr[i2] = dataInputStream.readUnsignedByte();
            }
            if (iArr[0] == 1 && iArr[1] == 1 && iArr[2] == 8) {
                if (iArr[3] == 0) {
                    throw new MalformedFrameException("AMQP protocol version mismatch; we are version 0-9-1, server is 0-8");
                }
            }
            String str = "";
            for (int i3 = 0; i3 < 4; i3++) {
                if (i3 != 0) {
                    str = str + ",";
                }
                str = str + iArr[i3];
            }
            throw new MalformedFrameException("AMQP protocol version mismatch; we are version 0-9-1, server sent signature " + str);
        } catch (IOException unused) {
            throw new MalformedFrameException("Invalid AMQP protocol header from server");
        }
    }

    public static Frame readFrom(DataInputStream dataInputStream) throws IOException {
        try {
            int readUnsignedByte = dataInputStream.readUnsignedByte();
            if (readUnsignedByte == 65) {
                protocolVersionMismatch(dataInputStream);
            }
            int readUnsignedShort = dataInputStream.readUnsignedShort();
            byte[] bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            int readUnsignedByte2 = dataInputStream.readUnsignedByte();
            if (readUnsignedByte2 == 206) {
                return new Frame(readUnsignedByte, readUnsignedShort, bArr);
            }
            throw new MalformedFrameException(hj1.I("Bad frame end marker: ", readUnsignedByte2));
        } catch (SocketTimeoutException unused) {
            return null;
        }
    }

    private static int shortStrSize(String str) throws UnsupportedEncodingException {
        return str.getBytes("utf-8").length + 1;
    }

    public static long tableSize(Map<String, Object> map) throws UnsupportedEncodingException {
        long j = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            j = j + ((long) shortStrSize(entry.getKey())) + fieldValueSize(entry.getValue());
        }
        return j;
    }

    public DataInputStream getInputStream() {
        return new DataInputStream(new ByteArrayInputStream(getPayload()));
    }

    public DataOutputStream getOutputStream() {
        return new DataOutputStream(this.accumulator);
    }

    public byte[] getPayload() {
        byte[] bArr = this.payload;
        if (bArr != null) {
            return bArr;
        }
        return this.accumulator.toByteArray();
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Frame(type=");
        i0.append(this.type);
        i0.append(", channel=");
        i0.append(this.channel);
        i0.append(", ");
        ByteArrayOutputStream byteArrayOutputStream = this.accumulator;
        if (byteArrayOutputStream == null) {
            i0.append(this.payload.length);
            i0.append(" bytes of payload)");
        } else {
            i0.append(byteArrayOutputStream.size());
            i0.append(" bytes of accumulator)");
        }
        return i0.toString();
    }

    public void writeTo(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeByte(this.type);
        dataOutputStream.writeShort(this.channel);
        ByteArrayOutputStream byteArrayOutputStream = this.accumulator;
        if (byteArrayOutputStream != null) {
            dataOutputStream.writeInt(byteArrayOutputStream.size());
            this.accumulator.writeTo(dataOutputStream);
        } else {
            dataOutputStream.writeInt(this.payload.length);
            dataOutputStream.write(this.payload);
        }
        dataOutputStream.write(AMQP.FRAME_END);
    }

    public static long arraySize(Object[] objArr) throws UnsupportedEncodingException {
        long j = 0;
        for (Object obj : objArr) {
            j += fieldValueSize(obj);
        }
        return j;
    }

    public Frame(int i, int i2, byte[] bArr) {
        this.type = i;
        this.channel = i2;
        this.payload = bArr;
        this.accumulator = null;
    }
}
