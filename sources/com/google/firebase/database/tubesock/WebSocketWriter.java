package com.google.firebase.database.tubesock;

import com.google.firebase.perf.util.Constants;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WebSocketWriter {
    private WritableByteChannel channel;
    private boolean closeSent = false;
    private final Thread innerThread = WebSocket.getThreadFactory().newThread(new Runnable() {
        /* class com.google.firebase.database.tubesock.WebSocketWriter.AnonymousClass1 */

        public void run() {
            WebSocketWriter.this.runWriter();
        }
    });
    private BlockingQueue<ByteBuffer> pendingBuffers;
    private final Random random = new Random();
    private volatile boolean stop = false;
    private WebSocket websocket;

    public WebSocketWriter(WebSocket webSocket, String str, int i) {
        ThreadInitializer intializer = WebSocket.getIntializer();
        Thread innerThread2 = getInnerThread();
        intializer.setName(innerThread2, str + "Writer-" + i);
        this.websocket = webSocket;
        this.pendingBuffers = new LinkedBlockingQueue();
    }

    private ByteBuffer frameInBuffer(byte b, boolean z, byte[] bArr) throws IOException {
        int i = z ? 6 : 2;
        int length = bArr.length;
        int i2 = 126;
        if (length >= 126) {
            i = length <= 65535 ? i + 2 : i + 8;
        }
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + i);
        allocate.put((byte) (b | Byte.MIN_VALUE));
        if (length < 126) {
            if (z) {
                length |= 128;
            }
            allocate.put((byte) length);
        } else if (length <= 65535) {
            if (z) {
                i2 = 254;
            }
            allocate.put((byte) i2);
            allocate.putShort((short) length);
        } else {
            int i3 = 127;
            if (z) {
                i3 = Constants.MAX_HOST_LENGTH;
            }
            allocate.put((byte) i3);
            allocate.putInt(0);
            allocate.putInt(length);
        }
        if (z) {
            byte[] generateMask = generateMask();
            allocate.put(generateMask);
            for (int i4 = 0; i4 < bArr.length; i4++) {
                allocate.put((byte) (bArr[i4] ^ generateMask[i4 % 4]));
            }
        }
        allocate.flip();
        return allocate;
    }

    private byte[] generateMask() {
        byte[] bArr = new byte[4];
        this.random.nextBytes(bArr);
        return bArr;
    }

    private void handleError(WebSocketException webSocketException) {
        this.websocket.handleReceiverError(webSocketException);
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void runWriter() {
        while (!this.stop && !Thread.interrupted()) {
            try {
                writeMessage();
            } catch (IOException e) {
                handleError(new WebSocketException("IO Exception", e));
                return;
            } catch (InterruptedException unused) {
                return;
            }
        }
        for (int i = 0; i < this.pendingBuffers.size(); i++) {
            writeMessage();
        }
    }

    private void writeMessage() throws InterruptedException, IOException {
        this.channel.write(this.pendingBuffers.take());
    }

    public Thread getInnerThread() {
        return this.innerThread;
    }

    public synchronized void send(byte b, boolean z, byte[] bArr) throws IOException {
        ByteBuffer frameInBuffer = frameInBuffer(b, z, bArr);
        if (this.stop) {
            if (this.closeSent || b != 8) {
                throw new WebSocketException("Shouldn't be sending");
            }
        }
        if (b == 8) {
            this.closeSent = true;
        }
        this.pendingBuffers.add(frameInBuffer);
    }

    public void setOutput(OutputStream outputStream) {
        this.channel = Channels.newChannel(outputStream);
    }

    public void stopIt() {
        this.stop = true;
    }
}
