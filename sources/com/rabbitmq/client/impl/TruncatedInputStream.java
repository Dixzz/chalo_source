package com.rabbitmq.client.impl;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TruncatedInputStream extends FilterInputStream {
    private long counter = 0;
    private final long limit;
    private long mark = 0;

    public TruncatedInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.limit = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return (int) Math.min(this.limit - this.counter, (long) super.available());
    }

    public void mark(int i) {
        super.mark(i);
        this.mark = this.counter;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.counter >= this.limit) {
            return -1;
        }
        int read = super.read();
        if (read >= 0) {
            this.counter++;
        }
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        super.reset();
        this.counter = this.mark;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = super.skip(Math.min(j, this.limit - this.counter));
        this.counter += skip;
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.limit;
        long j2 = this.counter;
        if (j <= j2) {
            return -1;
        }
        int read = super.read(bArr, i, (int) Math.min((long) i2, j - j2));
        if (read > 0) {
            this.counter += (long) read;
        }
        return read;
    }
}
