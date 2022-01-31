package com.rabbitmq.client.impl;

import com.rabbitmq.client.LongString;
import com.rabbitmq.client.MalformedFrameException;
import java.io.DataInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValueReader {
    private static final long INT_MASK = 4294967295L;
    private final DataInputStream in;

    public ValueReader(DataInputStream dataInputStream) {
        this.in = dataInputStream;
    }

    private static List<Object> readArray(DataInputStream dataInputStream) throws IOException {
        DataInputStream dataInputStream2 = new DataInputStream(new TruncatedInputStream(dataInputStream, unsignedExtend(dataInputStream.readInt())));
        ArrayList arrayList = new ArrayList();
        while (dataInputStream2.available() > 0) {
            arrayList.add(readFieldValue(dataInputStream2));
        }
        return arrayList;
    }

    private static byte[] readBytes(DataInputStream dataInputStream) throws IOException {
        long unsignedExtend = unsignedExtend(dataInputStream.readInt());
        if (unsignedExtend < 2147483647L) {
            byte[] bArr = new byte[((int) unsignedExtend)];
            dataInputStream.readFully(bArr);
            return bArr;
        }
        throw new UnsupportedOperationException("Very long byte vectors and strings not currently supported");
    }

    private static Object readFieldValue(DataInputStream dataInputStream) throws IOException {
        int readUnsignedByte = dataInputStream.readUnsignedByte();
        if (readUnsignedByte == 65) {
            return readArray(dataInputStream);
        }
        if (readUnsignedByte == 68) {
            int readUnsignedByte2 = dataInputStream.readUnsignedByte();
            byte[] bArr = new byte[4];
            dataInputStream.readFully(bArr);
            return new BigDecimal(new BigInteger(bArr), readUnsignedByte2);
        } else if (readUnsignedByte == 70) {
            return readTable(dataInputStream);
        } else {
            if (readUnsignedByte == 73) {
                return Integer.valueOf(dataInputStream.readInt());
            }
            if (readUnsignedByte == 86) {
                return null;
            }
            if (readUnsignedByte == 98) {
                return Byte.valueOf(dataInputStream.readByte());
            }
            if (readUnsignedByte == 100) {
                return Double.valueOf(dataInputStream.readDouble());
            }
            if (readUnsignedByte == 102) {
                return Float.valueOf(dataInputStream.readFloat());
            }
            if (readUnsignedByte == 108) {
                return Long.valueOf(dataInputStream.readLong());
            }
            if (readUnsignedByte == 120) {
                return readBytes(dataInputStream);
            }
            if (readUnsignedByte == 83) {
                return readLongstr(dataInputStream);
            }
            if (readUnsignedByte == 84) {
                return readTimestamp(dataInputStream);
            }
            if (readUnsignedByte == 115) {
                return Short.valueOf(dataInputStream.readShort());
            }
            if (readUnsignedByte == 116) {
                return Boolean.valueOf(dataInputStream.readBoolean());
            }
            throw new MalformedFrameException("Unrecognised type in table");
        }
    }

    private static LongString readLongstr(DataInputStream dataInputStream) throws IOException {
        return LongStringHelper.asLongString(readBytes(dataInputStream));
    }

    private static String readShortstr(DataInputStream dataInputStream) throws IOException {
        byte[] bArr = new byte[dataInputStream.readUnsignedByte()];
        dataInputStream.readFully(bArr);
        return new String(bArr, "utf-8");
    }

    private static Map<String, Object> readTable(DataInputStream dataInputStream) throws IOException {
        long unsignedExtend = unsignedExtend(dataInputStream.readInt());
        if (unsignedExtend == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        DataInputStream dataInputStream2 = new DataInputStream(new TruncatedInputStream(dataInputStream, unsignedExtend));
        while (dataInputStream2.available() > 0) {
            String readShortstr = readShortstr(dataInputStream2);
            Object readFieldValue = readFieldValue(dataInputStream2);
            if (!hashMap.containsKey(readShortstr)) {
                hashMap.put(readShortstr, readFieldValue);
            }
        }
        return hashMap;
    }

    private static Date readTimestamp(DataInputStream dataInputStream) throws IOException {
        return new Date(dataInputStream.readLong() * 1000);
    }

    private static long unsignedExtend(int i) {
        return ((long) i) & 4294967295L;
    }

    public final int readLong() throws IOException {
        return this.in.readInt();
    }

    public final long readLonglong() throws IOException {
        return this.in.readLong();
    }

    public final int readOctet() throws IOException {
        return this.in.readUnsignedByte();
    }

    public final int readShort() throws IOException {
        return this.in.readUnsignedShort();
    }

    public final LongString readLongstr() throws IOException {
        return readLongstr(this.in);
    }

    public final Date readTimestamp() throws IOException {
        return readTimestamp(this.in);
    }

    public final String readShortstr() throws IOException {
        return readShortstr(this.in);
    }

    public final Map<String, Object> readTable() throws IOException {
        return readTable(this.in);
    }
}
