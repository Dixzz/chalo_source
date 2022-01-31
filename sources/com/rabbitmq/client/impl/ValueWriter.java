package com.rabbitmq.client.impl;

import com.rabbitmq.client.LongString;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ValueWriter {
    private static final int COPY_BUFFER_SIZE = 4096;
    private final DataOutputStream out;

    public ValueWriter(DataOutputStream dataOutputStream) {
        this.out = dataOutputStream;
    }

    private static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        int read = inputStream.read(bArr);
        while (-1 != read) {
            outputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public final void writeArray(List<?> list) throws IOException {
        if (list == null) {
            this.out.write(0);
            return;
        }
        this.out.writeInt((int) Frame.arraySize(list));
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            writeFieldValue(it.next());
        }
    }

    public final void writeFieldValue(Object obj) throws IOException {
        if (obj instanceof String) {
            writeOctet(83);
            writeLongstr((String) obj);
        } else if (obj instanceof LongString) {
            writeOctet(83);
            writeLongstr((LongString) obj);
        } else if (obj instanceof Integer) {
            writeOctet(73);
            writeLong(((Integer) obj).intValue());
        } else if (obj instanceof BigDecimal) {
            writeOctet(68);
            BigDecimal bigDecimal = (BigDecimal) obj;
            writeOctet(bigDecimal.scale());
            if (bigDecimal.unscaledValue().bitLength() <= 32) {
                writeLong(bigDecimal.unscaledValue().intValue());
                return;
            }
            throw new IllegalArgumentException("BigDecimal too large to be encoded");
        } else if (obj instanceof Date) {
            writeOctet(84);
            writeTimestamp((Date) obj);
        } else if (obj instanceof Map) {
            writeOctet(70);
            writeTable((Map) obj);
        } else if (obj instanceof Byte) {
            writeOctet(98);
            this.out.writeByte(((Byte) obj).byteValue());
        } else if (obj instanceof Double) {
            writeOctet(100);
            this.out.writeDouble(((Double) obj).doubleValue());
        } else if (obj instanceof Float) {
            writeOctet(102);
            this.out.writeFloat(((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            writeOctet(108);
            this.out.writeLong(((Long) obj).longValue());
        } else if (obj instanceof Short) {
            writeOctet(115);
            this.out.writeShort(((Short) obj).shortValue());
        } else if (obj instanceof Boolean) {
            writeOctet(116);
            this.out.writeBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof byte[]) {
            writeOctet(120);
            byte[] bArr = (byte[]) obj;
            writeLong(bArr.length);
            this.out.write(bArr);
        } else if (obj == null) {
            writeOctet(86);
        } else if (obj instanceof List) {
            writeOctet(65);
            writeArray((List) obj);
        } else if (obj instanceof Object[]) {
            writeOctet(65);
            writeArray((Object[]) obj);
        } else {
            StringBuilder i0 = hj1.i0("Invalid value type: ");
            i0.append(obj.getClass().getName());
            throw new IllegalArgumentException(i0.toString());
        }
    }

    public final void writeLong(int i) throws IOException {
        this.out.writeInt(i);
    }

    public final void writeLonglong(long j) throws IOException {
        this.out.writeLong(j);
    }

    public final void writeLongstr(LongString longString) throws IOException {
        writeLong((int) longString.length());
        copy(longString.getStream(), this.out);
    }

    public final void writeOctet(int i) throws IOException {
        this.out.writeByte(i);
    }

    public final void writeShort(int i) throws IOException {
        this.out.writeShort(i);
    }

    public final void writeShortstr(String str) throws IOException {
        byte[] bytes = str.getBytes("utf-8");
        int length = bytes.length;
        if (length <= 255) {
            this.out.writeByte(bytes.length);
            this.out.write(bytes);
            return;
        }
        throw new IllegalArgumentException(hj1.J("Short string too long; utf-8 encoded length = ", length, ", max = 255."));
    }

    public final void writeTable(Map<String, Object> map) throws IOException {
        if (map == null) {
            this.out.writeInt(0);
            return;
        }
        this.out.writeInt((int) Frame.tableSize(map));
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            writeShortstr(entry.getKey());
            writeFieldValue(entry.getValue());
        }
    }

    public final void writeTimestamp(Date date) throws IOException {
        writeLonglong(date.getTime() / 1000);
    }

    public final void writeOctet(byte b) throws IOException {
        this.out.writeByte(b);
    }

    public final void writeLongstr(String str) throws IOException {
        byte[] bytes = str.getBytes("utf-8");
        writeLong(bytes.length);
        this.out.write(bytes);
    }

    public final void writeArray(Object[] objArr) throws IOException {
        if (objArr == null) {
            this.out.write(0);
            return;
        }
        this.out.writeInt((int) Frame.arraySize(objArr));
        for (Object obj : objArr) {
            writeFieldValue(obj);
        }
    }
}
