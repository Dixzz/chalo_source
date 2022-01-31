package com.rabbitmq.client.impl;

import com.rabbitmq.client.ContentHeader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class AMQContentHeader implements ContentHeader {
    private long bodySize;

    public AMQContentHeader() {
        this.bodySize = 0;
    }

    private void writeTo(DataOutputStream dataOutputStream, long j) throws IOException {
        dataOutputStream.writeShort(0);
        dataOutputStream.writeLong(j);
        writePropertiesTo(new ContentHeaderPropertyWriter(dataOutputStream));
    }

    @Override // com.rabbitmq.client.ContentHeader
    public void appendPropertyDebugStringTo(StringBuilder sb) {
        sb.append("(?)");
    }

    @Override // java.lang.Object
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public long getBodySize() {
        return this.bodySize;
    }

    public Frame toFrame(int i, long j) throws IOException {
        Frame frame = new Frame(2, i);
        DataOutputStream outputStream = frame.getOutputStream();
        outputStream.writeShort(getClassId());
        writeTo(outputStream, j);
        return frame;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("#contentHeader<");
        i0.append(getClassName());
        i0.append(">");
        appendPropertyDebugStringTo(i0);
        return i0.toString();
    }

    public abstract void writePropertiesTo(ContentHeaderPropertyWriter contentHeaderPropertyWriter) throws IOException;

    public AMQContentHeader(DataInputStream dataInputStream) throws IOException {
        dataInputStream.readShort();
        this.bodySize = dataInputStream.readLong();
    }
}
