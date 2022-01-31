package com.rabbitmq.client.impl;

import com.rabbitmq.client.LongString;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class ContentHeaderPropertyWriter {
    public int bitCount = 0;
    public int flagWord = 0;
    private final ValueWriter out;

    public ContentHeaderPropertyWriter(DataOutputStream dataOutputStream) {
        this.out = new ValueWriter(dataOutputStream);
    }

    private void emitFlagWord(boolean z) throws IOException {
        this.out.writeShort(z ? this.flagWord | 1 : this.flagWord);
        this.flagWord = 0;
        this.bitCount = 0;
    }

    public void finishPresence() throws IOException {
        emitFlagWord(false);
    }

    public void writeLong(Integer num) throws IOException {
        this.out.writeLong(num.intValue());
    }

    public void writeLonglong(Long l) throws IOException {
        this.out.writeLonglong(l.longValue());
    }

    public void writeLongstr(String str) throws IOException {
        this.out.writeLongstr(str);
    }

    public void writeOctet(Integer num) throws IOException {
        this.out.writeOctet(num.intValue());
    }

    public void writePresence(boolean z) throws IOException {
        if (this.bitCount == 15) {
            emitFlagWord(true);
        }
        if (z) {
            this.flagWord |= 1 << (15 - this.bitCount);
        }
        this.bitCount++;
    }

    public void writeShort(Integer num) throws IOException {
        this.out.writeShort(num.intValue());
    }

    public void writeShortstr(String str) throws IOException {
        this.out.writeShortstr(str);
    }

    public void writeTable(Map<String, Object> map) throws IOException {
        this.out.writeTable(map);
    }

    public void writeTimestamp(Date date) throws IOException {
        this.out.writeTimestamp(date);
    }

    public void writeLongstr(LongString longString) throws IOException {
        this.out.writeLongstr(longString);
    }

    public void writeOctet(int i) throws IOException {
        this.out.writeOctet(i);
    }
}
