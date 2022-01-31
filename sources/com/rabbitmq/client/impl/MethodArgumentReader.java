package com.rabbitmq.client.impl;

import com.rabbitmq.client.LongString;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class MethodArgumentReader {
    private int bits;
    private final ValueReader in;
    private int nextBitMask;

    public MethodArgumentReader(ValueReader valueReader) {
        this.in = valueReader;
        clearBits();
    }

    private void clearBits() {
        this.bits = 0;
        this.nextBitMask = 256;
    }

    public final boolean readBit() throws IOException {
        if (this.nextBitMask > 128) {
            this.bits = this.in.readOctet();
            this.nextBitMask = 1;
        }
        int i = this.bits;
        int i2 = this.nextBitMask;
        boolean z = (i & i2) != 0;
        this.nextBitMask = i2 << 1;
        return z;
    }

    public final int readLong() throws IOException {
        clearBits();
        return this.in.readLong();
    }

    public final long readLonglong() throws IOException {
        clearBits();
        return this.in.readLonglong();
    }

    public final LongString readLongstr() throws IOException {
        clearBits();
        return this.in.readLongstr();
    }

    public final int readOctet() throws IOException {
        clearBits();
        return this.in.readOctet();
    }

    public final int readShort() throws IOException {
        clearBits();
        return this.in.readShort();
    }

    public final String readShortstr() throws IOException {
        clearBits();
        return this.in.readShortstr();
    }

    public final Map<String, Object> readTable() throws IOException {
        clearBits();
        return this.in.readTable();
    }

    public final Date readTimestamp() throws IOException {
        clearBits();
        return this.in.readTimestamp();
    }
}
