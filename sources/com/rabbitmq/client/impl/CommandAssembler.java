package com.rabbitmq.client.impl;

import com.rabbitmq.client.UnexpectedFrameError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CommandAssembler {
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private int bodyLength = 0;
    private final List<byte[]> bodyN = new ArrayList(2);
    private AMQContentHeader contentHeader;
    private Method method;
    private long remainingBodyBytes = 0;
    private CAState state;

    /* renamed from: com.rabbitmq.client.impl.CommandAssembler$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$rabbitmq$client$impl$CommandAssembler$CAState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0015 */
        static {
            /*
                com.rabbitmq.client.impl.CommandAssembler.CAState.values()
                r0 = 4
                int[] r0 = new int[r0]
                com.rabbitmq.client.impl.CommandAssembler.AnonymousClass1.$SwitchMap$com$rabbitmq$client$impl$CommandAssembler$CAState = r0
                r1 = 1
                com.rabbitmq.client.impl.CommandAssembler$CAState r2 = com.rabbitmq.client.impl.CommandAssembler.CAState.EXPECTING_METHOD     // Catch:{ NoSuchFieldError -> 0x000e }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                r0 = 2
                int[] r2 = com.rabbitmq.client.impl.CommandAssembler.AnonymousClass1.$SwitchMap$com$rabbitmq$client$impl$CommandAssembler$CAState     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.rabbitmq.client.impl.CommandAssembler$CAState r3 = com.rabbitmq.client.impl.CommandAssembler.CAState.EXPECTING_CONTENT_HEADER     // Catch:{ NoSuchFieldError -> 0x0015 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                int[] r1 = com.rabbitmq.client.impl.CommandAssembler.AnonymousClass1.$SwitchMap$com$rabbitmq$client$impl$CommandAssembler$CAState     // Catch:{ NoSuchFieldError -> 0x001c }
                com.rabbitmq.client.impl.CommandAssembler$CAState r2 = com.rabbitmq.client.impl.CommandAssembler.CAState.EXPECTING_CONTENT_BODY     // Catch:{ NoSuchFieldError -> 0x001c }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001c }
            L_0x001c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rabbitmq.client.impl.CommandAssembler.AnonymousClass1.<clinit>():void");
        }
    }

    public enum CAState {
        EXPECTING_METHOD,
        EXPECTING_CONTENT_HEADER,
        EXPECTING_CONTENT_BODY,
        COMPLETE
    }

    public CommandAssembler(Method method2, AMQContentHeader aMQContentHeader, byte[] bArr) {
        this.method = method2;
        this.contentHeader = aMQContentHeader;
        appendBodyFragment(bArr);
        if (method2 == null) {
            this.state = CAState.EXPECTING_METHOD;
        } else if (aMQContentHeader == null) {
            this.state = method2.hasContent() ? CAState.EXPECTING_CONTENT_HEADER : CAState.COMPLETE;
        } else {
            this.remainingBodyBytes = aMQContentHeader.getBodySize() - ((long) this.bodyLength);
            updateContentBodyState();
        }
    }

    private void appendBodyFragment(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            this.bodyN.add(bArr);
            this.bodyLength += bArr.length;
        }
    }

    private byte[] coalesceContentBody() {
        if (this.bodyLength == 0) {
            return EMPTY_BYTE_ARRAY;
        }
        if (this.bodyN.size() == 1) {
            return this.bodyN.get(0);
        }
        byte[] bArr = new byte[this.bodyLength];
        int i = 0;
        for (byte[] bArr2 : this.bodyN) {
            System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
            i += bArr2.length;
        }
        this.bodyN.clear();
        this.bodyN.add(bArr);
        return bArr;
    }

    private void consumeBodyFrame(Frame frame) {
        if (frame.type == 3) {
            byte[] payload = frame.getPayload();
            this.remainingBodyBytes -= (long) payload.length;
            updateContentBodyState();
            if (this.remainingBodyBytes >= 0) {
                appendBodyFragment(payload);
                return;
            }
            throw new UnsupportedOperationException("%%%%%% FIXME unimplemented");
        }
        throw new UnexpectedFrameError(frame, 3);
    }

    private void consumeHeaderFrame(Frame frame) throws IOException {
        if (frame.type == 2) {
            AMQContentHeader readContentHeaderFrom = AMQImpl.readContentHeaderFrom(frame.getInputStream());
            this.contentHeader = readContentHeaderFrom;
            this.remainingBodyBytes = readContentHeaderFrom.getBodySize();
            updateContentBodyState();
            return;
        }
        throw new UnexpectedFrameError(frame, 2);
    }

    private void consumeMethodFrame(Frame frame) throws IOException {
        if (frame.type == 1) {
            Method readMethodFrom = AMQImpl.readMethodFrom(frame.getInputStream());
            this.method = readMethodFrom;
            this.state = readMethodFrom.hasContent() ? CAState.EXPECTING_CONTENT_HEADER : CAState.COMPLETE;
            return;
        }
        throw new UnexpectedFrameError(frame, 1);
    }

    private void updateContentBodyState() {
        this.state = this.remainingBodyBytes > 0 ? CAState.EXPECTING_CONTENT_BODY : CAState.COMPLETE;
    }

    public synchronized byte[] getContentBody() {
        return coalesceContentBody();
    }

    public synchronized AMQContentHeader getContentHeader() {
        return this.contentHeader;
    }

    public synchronized Method getMethod() {
        return this.method;
    }

    public synchronized boolean handleFrame(Frame frame) throws IOException {
        int ordinal = this.state.ordinal();
        if (ordinal == 0) {
            consumeMethodFrame(frame);
        } else if (ordinal == 1) {
            consumeHeaderFrame(frame);
        } else if (ordinal == 2) {
            consumeBodyFrame(frame);
        } else {
            throw new AssertionError("Bad Command State " + this.state);
        }
        return isComplete();
    }

    public synchronized boolean isComplete() {
        return this.state == CAState.COMPLETE;
    }
}
