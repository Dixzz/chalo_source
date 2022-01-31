package com.rabbitmq.client.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class SocketFrameHandler implements FrameHandler {
    public static final int SOCKET_CLOSING_TIMEOUT = 1;
    private final DataInputStream _inputStream;
    private final DataOutputStream _outputStream;
    private final Socket _socket;

    public SocketFrameHandler(Socket socket) throws IOException {
        this._socket = socket;
        this._inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        this._outputStream = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|3|4|5|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0006 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0009 */
    @Override // com.rabbitmq.client.impl.FrameHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r2 = this;
            java.net.Socket r0 = r2._socket     // Catch:{ Exception -> 0x0006 }
            r1 = 1
            r0.setSoLinger(r1, r1)     // Catch:{ Exception -> 0x0006 }
        L_0x0006:
            r2.flush()     // Catch:{ Exception -> 0x0009 }
        L_0x0009:
            java.net.Socket r0 = r2._socket     // Catch:{ Exception -> 0x000e }
            r0.close()     // Catch:{ Exception -> 0x000e }
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rabbitmq.client.impl.SocketFrameHandler.close():void");
    }

    @Override // com.rabbitmq.client.impl.FrameHandler
    public void flush() throws IOException {
        this._outputStream.flush();
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection
    public InetAddress getAddress() {
        return this._socket.getInetAddress();
    }

    public DataInputStream getInputStream() {
        return this._inputStream;
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection
    public InetAddress getLocalAddress() {
        return this._socket.getLocalAddress();
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection
    public int getLocalPort() {
        return this._socket.getLocalPort();
    }

    @Override // com.rabbitmq.client.impl.NetworkConnection
    public int getPort() {
        return this._socket.getPort();
    }

    @Override // com.rabbitmq.client.impl.FrameHandler
    public int getTimeout() throws SocketException {
        return this._socket.getSoTimeout();
    }

    @Override // com.rabbitmq.client.impl.FrameHandler
    public Frame readFrame() throws IOException {
        Frame readFrom;
        synchronized (this._inputStream) {
            readFrom = Frame.readFrom(this._inputStream);
        }
        return readFrom;
    }

    public void sendHeader(int i, int i2) throws IOException {
        synchronized (this._outputStream) {
            this._outputStream.write("AMQP".getBytes("US-ASCII"));
            this._outputStream.write(1);
            this._outputStream.write(1);
            this._outputStream.write(i);
            this._outputStream.write(i2);
            this._outputStream.flush();
        }
    }

    @Override // com.rabbitmq.client.impl.FrameHandler
    public void setTimeout(int i) throws SocketException {
        this._socket.setSoTimeout(i);
    }

    @Override // com.rabbitmq.client.impl.FrameHandler
    public void writeFrame(Frame frame) throws IOException {
        synchronized (this._outputStream) {
            frame.writeTo(this._outputStream);
        }
    }

    public void sendHeader(int i, int i2, int i3) throws IOException {
        synchronized (this._outputStream) {
            this._outputStream.write("AMQP".getBytes("US-ASCII"));
            this._outputStream.write(0);
            this._outputStream.write(i);
            this._outputStream.write(i2);
            this._outputStream.write(i3);
            this._outputStream.flush();
        }
    }

    @Override // com.rabbitmq.client.impl.FrameHandler
    public void sendHeader() throws IOException {
        sendHeader(0, 9, 1);
    }
}
