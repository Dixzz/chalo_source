package com.rabbitmq.client.impl;

import com.rabbitmq.client.LongString;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class MethodArgumentWriter {
    private byte bitAccumulator;
    private int bitMask;
    private boolean needBitFlush;
    private final ValueWriter out;

    public MethodArgumentWriter(ValueWriter valueWriter) {
        this.out = valueWriter;
        resetBitAccumulator();
    }

    private final void bitflush() throws IOException {
        if (this.needBitFlush) {
            this.out.writeOctet(this.bitAccumulator);
            resetBitAccumulator();
        }
    }

    private void resetBitAccumulator() {
        this.needBitFlush = false;
        this.bitAccumulator = 0;
        this.bitMask = 1;
    }

    public void flush() throws IOException {
        bitflush();
        this.out.flush();
    }

    public final void writeBit(boolean z) throws IOException {
        if (this.bitMask > 128) {
            bitflush();
        }
        if (z) {
            this.bitAccumulator = (byte) (this.bitAccumulator | this.bitMask);
        }
        this.bitMask <<= 1;
        this.needBitFlush = true;
    }

    public final void writeLong(int i) throws IOException {
        bitflush();
        this.out.writeLong(i);
    }

    public final void writeLonglong(long j) throws IOException {
        bitflush();
        this.out.writeLonglong(j);
    }

    public final void writeLongstr(LongString longString) throws IOException {
        bitflush();
        this.out.writeLongstr(longString);
    }

    public final void writeOctet(int i) throws IOException {
        bitflush();
        this.out.writeOctet(i);
    }

    public final void writeShort(int i) throws IOException {
        bitflush();
        this.out.writeShort(i);
    }

    public final void writeShortstr(String str) throws IOException {
        bitflush();
        this.out.writeShortstr(str);
    }

    public final void writeTable(Map<String, Object> map) throws IOException {
        bitflush();
        this.out.writeTable(map);
    }

    public final void writeTimestamp(Date date) throws IOException {
        bitflush();
        this.out.writeTimestamp(date);
    }

    public final void writeLongstr(String str) throws IOException {
        bitflush();
        this.out.writeLongstr(str);
    }

    public final void writeOctet(byte b) throws IOException {
        bitflush();
        this.out.writeOctet(b);
    }
}
