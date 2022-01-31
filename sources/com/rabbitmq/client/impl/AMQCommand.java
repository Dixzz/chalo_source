package com.rabbitmq.client.impl;

import com.rabbitmq.client.Command;
import com.rabbitmq.client.Method;
import com.rabbitmq.client.StringRpcServer;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class AMQCommand implements Command {
    public static final int EMPTY_FRAME_SIZE = 8;
    private final CommandAssembler assembler;

    public AMQCommand() {
        this(null, null, null);
    }

    private static void checkEmptyFrameSize() {
        Frame frame = new Frame(3, 0, new byte[0]);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            frame.writeTo(new DataOutputStream(byteArrayOutputStream));
            int length = byteArrayOutputStream.toByteArray().length;
            if (8 != length) {
                throw new AssertionError(hj1.I("Internal error: expected EMPTY_FRAME_SIZE(8) is not equal to computed value: ", length));
            }
        } catch (IOException unused) {
            throw new AssertionError("IOException while checking EMPTY_FRAME_SIZE");
        }
    }

    public static void checkPreconditions() {
        checkEmptyFrameSize();
    }

    private static StringBuilder contentBodyStringBuilder(byte[] bArr, boolean z) {
        if (z) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(bArr.length);
                sb.append(" bytes of payload");
                return sb;
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append('|');
                sb2.append(bArr.length);
                sb2.append('|');
                return sb2;
            }
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append('\"');
            sb3.append(new String(bArr, StringRpcServer.STRING_ENCODING));
            sb3.append('\"');
            return sb3;
        }
    }

    @Override // com.rabbitmq.client.Command
    public byte[] getContentBody() {
        return this.assembler.getContentBody();
    }

    public boolean handleFrame(Frame frame) throws IOException {
        return this.assembler.handleFrame(frame);
    }

    public String toString() {
        return toString(false);
    }

    public void transmit(AMQChannel aMQChannel) throws IOException {
        int channelNumber = aMQChannel.getChannelNumber();
        AMQConnection connection = aMQChannel.getConnection();
        synchronized (this.assembler) {
            Method method = this.assembler.getMethod();
            connection.writeFrame(method.toFrame(channelNumber));
            if (method.hasContent()) {
                byte[] contentBody = this.assembler.getContentBody();
                connection.writeFrame(this.assembler.getContentHeader().toFrame(channelNumber, (long) contentBody.length));
                int frameMax = connection.getFrameMax();
                int length = frameMax == 0 ? contentBody.length : frameMax - 8;
                for (int i = 0; i < contentBody.length; i += length) {
                    int length2 = contentBody.length - i;
                    if (length2 >= length) {
                        length2 = length;
                    }
                    connection.writeFrame(Frame.fromBodyFragment(channelNumber, contentBody, i, length2));
                }
            }
        }
        connection.flush();
    }

    public AMQCommand(Method method) {
        this(method, null, null);
    }

    @Override // com.rabbitmq.client.Command
    public AMQContentHeader getContentHeader() {
        return this.assembler.getContentHeader();
    }

    @Override // com.rabbitmq.client.Command
    public Method getMethod() {
        return this.assembler.getMethod();
    }

    public String toString(boolean z) {
        String str;
        synchronized (this.assembler) {
            str = '{' + this.assembler.getMethod() + ", " + this.assembler.getContentHeader() + ", " + ((CharSequence) contentBodyStringBuilder(this.assembler.getContentBody(), z)) + '}';
        }
        return str;
    }

    public AMQCommand(Method method, AMQContentHeader aMQContentHeader, byte[] bArr) {
        this.assembler = new CommandAssembler((Method) method, aMQContentHeader, bArr);
    }
}
