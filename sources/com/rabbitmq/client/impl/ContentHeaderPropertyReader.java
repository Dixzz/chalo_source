package com.rabbitmq.client.impl;

import com.rabbitmq.client.LongString;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

public class ContentHeaderPropertyReader {
    public int bitCount = 15;
    public int flagWord = 1;
    private final ValueReader in;

    public ContentHeaderPropertyReader(DataInputStream dataInputStream) throws IOException {
        this.in = new ValueReader(dataInputStream);
    }

    private boolean isContinuationBitSet() {
        return (this.flagWord & 1) != 0;
    }

    public void finishPresence() throws IOException {
        if (isContinuationBitSet()) {
            throw new IOException("Unexpected continuation flag word");
        }
    }

    public void readFlagWord() throws IOException {
        if (isContinuationBitSet()) {
            this.flagWord = this.in.readShort();
            this.bitCount = 0;
            return;
        }
        throw new IOException("Attempted to read flag word when none advertised");
    }

    public Integer readLong() throws IOException {
        return Integer.valueOf(this.in.readLong());
    }

    public Long readLonglong() throws IOException {
        return Long.valueOf(this.in.readLonglong());
    }

    public LongString readLongstr() throws IOException {
        return this.in.readLongstr();
    }

    public int readOctet() throws IOException {
        return this.in.readOctet();
    }

    public boolean readPresence() throws IOException {
        if (this.bitCount == 15) {
            readFlagWord();
        }
        int i = this.bitCount;
        int i2 = 15 - i;
        this.bitCount = i + 1;
        if ((this.flagWord & (1 << i2)) != 0) {
            return true;
        }
        return false;
    }

    public Integer readShort() throws IOException {
        return Integer.valueOf(this.in.readShort());
    }

    public String readShortstr() throws IOException {
        return this.in.readShortstr();
    }

    public Map<String, Object> readTable() throws IOException {
        return this.in.readTable();
    }

    public Date readTimestamp() throws IOException {
        return this.in.readTimestamp();
    }
}
