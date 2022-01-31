package com.rabbitmq.client.impl;

import com.rabbitmq.client.impl.AMQImpl;
import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Method implements com.rabbitmq.client.Method {
    public void appendArgumentDebugStringTo(StringBuilder sb) {
        sb.append("(?)");
    }

    public abstract boolean hasContent();

    @Override // com.rabbitmq.client.Method
    public abstract int protocolClassId();

    @Override // com.rabbitmq.client.Method
    public abstract int protocolMethodId();

    @Override // com.rabbitmq.client.Method
    public abstract String protocolMethodName();

    public Frame toFrame(int i) throws IOException {
        Frame frame = new Frame(1, i);
        DataOutputStream outputStream = frame.getOutputStream();
        outputStream.writeShort(protocolClassId());
        outputStream.writeShort(protocolMethodId());
        MethodArgumentWriter methodArgumentWriter = new MethodArgumentWriter(new ValueWriter(outputStream));
        writeArgumentsTo(methodArgumentWriter);
        methodArgumentWriter.flush();
        return frame;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("#method<");
        i0.append(protocolMethodName());
        i0.append(">");
        appendArgumentDebugStringTo(i0);
        return i0.toString();
    }

    public abstract Object visit(AMQImpl.MethodVisitor methodVisitor) throws IOException;

    public abstract void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException;
}
