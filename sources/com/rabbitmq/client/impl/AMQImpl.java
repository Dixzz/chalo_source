package com.rabbitmq.client.impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.LongString;
import com.rabbitmq.client.UnexpectedMethodError;
import com.rabbitmq.client.UnknownClassOrMethodId;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AMQImpl implements AMQP {

    public static class Access {
        public static final int INDEX = 30;

        public static class RequestOk extends Method implements AMQP.Access.RequestOk {
            public static final int INDEX = 11;
            private final int ticket;

            public RequestOk(int i) {
                this.ticket = i;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Access.RequestOk
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 30;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 11;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "access.request-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
            }

            public RequestOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort());
            }
        }

        public static class Request extends Method implements AMQP.Access.Request {
            public static final int INDEX = 10;
            private final boolean active;
            private final boolean exclusive;
            private final boolean passive;
            private final boolean read;
            private final String realm;
            private final boolean write;

            public Request(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
                if (str != null) {
                    this.realm = str;
                    this.exclusive = z;
                    this.passive = z2;
                    this.active = z3;
                    this.write = z4;
                    this.read = z5;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'realm' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(realm=");
                sb.append(this.realm);
                sb.append(", exclusive=");
                sb.append(this.exclusive);
                sb.append(", passive=");
                sb.append(this.passive);
                sb.append(", active=");
                sb.append(this.active);
                sb.append(", write=");
                sb.append(this.write);
                sb.append(", read=");
                sb.append(this.read);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Access.Request
            public boolean getActive() {
                return this.active;
            }

            @Override // com.rabbitmq.client.AMQP.Access.Request
            public boolean getExclusive() {
                return this.exclusive;
            }

            @Override // com.rabbitmq.client.AMQP.Access.Request
            public boolean getPassive() {
                return this.passive;
            }

            @Override // com.rabbitmq.client.AMQP.Access.Request
            public boolean getRead() {
                return this.read;
            }

            @Override // com.rabbitmq.client.AMQP.Access.Request
            public String getRealm() {
                return this.realm;
            }

            @Override // com.rabbitmq.client.AMQP.Access.Request
            public boolean getWrite() {
                return this.write;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 30;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "access.request";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.realm);
                methodArgumentWriter.writeBit(this.exclusive);
                methodArgumentWriter.writeBit(this.passive);
                methodArgumentWriter.writeBit(this.active);
                methodArgumentWriter.writeBit(this.write);
                methodArgumentWriter.writeBit(this.read);
            }

            public Request(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit());
            }
        }
    }

    public static class Basic {
        public static final int INDEX = 60;

        public static class QosOk extends Method implements AMQP.Basic.QosOk {
            public static final int INDEX = 11;

            public QosOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 11;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.qos-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public QosOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class RecoverOk extends Method implements AMQP.Basic.RecoverOk {
            public static final int INDEX = 111;

            public RecoverOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 111;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.recover-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public RecoverOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class Recover extends Method implements AMQP.Basic.Recover {
            public static final int INDEX = 110;
            private final boolean requeue;

            public Recover(boolean z) {
                this.requeue = z;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(requeue=");
                sb.append(this.requeue);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Recover
            public boolean getRequeue() {
                return this.requeue;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 110;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.recover";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeBit(this.requeue);
            }

            public Recover(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readBit());
            }
        }

        public static class RecoverAsync extends Method implements AMQP.Basic.RecoverAsync {
            public static final int INDEX = 100;
            private final boolean requeue;

            public RecoverAsync(boolean z) {
                this.requeue = z;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(requeue=");
                sb.append(this.requeue);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.RecoverAsync
            public boolean getRequeue() {
                return this.requeue;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 100;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.recover-async";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeBit(this.requeue);
            }

            public RecoverAsync(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readBit());
            }
        }

        public static class Ack extends Method implements AMQP.Basic.Ack {
            public static final int INDEX = 80;
            private final long deliveryTag;
            private final boolean multiple;

            public Ack(long j, boolean z) {
                this.deliveryTag = j;
                this.multiple = z;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(delivery-tag=");
                sb.append(this.deliveryTag);
                sb.append(", multiple=");
                sb.append(this.multiple);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Ack
            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Ack
            public boolean getMultiple() {
                return this.multiple;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 80;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.ack";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLonglong(this.deliveryTag);
                methodArgumentWriter.writeBit(this.multiple);
            }

            public Ack(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLonglong(), methodArgumentReader.readBit());
            }
        }

        public static class CancelOk extends Method implements AMQP.Basic.CancelOk {
            public static final int INDEX = 31;
            private final String consumerTag;

            public CancelOk(String str) {
                if (str != null) {
                    this.consumerTag = str;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(consumer-tag=");
                sb.append(this.consumerTag);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.CancelOk
            public String getConsumerTag() {
                return this.consumerTag;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 31;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.cancel-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.consumerTag);
            }

            public CancelOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr());
            }
        }

        public static class ConsumeOk extends Method implements AMQP.Basic.ConsumeOk {
            public static final int INDEX = 21;
            private final String consumerTag;

            public ConsumeOk(String str) {
                if (str != null) {
                    this.consumerTag = str;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(consumer-tag=");
                sb.append(this.consumerTag);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.ConsumeOk
            public String getConsumerTag() {
                return this.consumerTag;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 21;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.consume-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.consumerTag);
            }

            public ConsumeOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr());
            }
        }

        public static class GetEmpty extends Method implements AMQP.Basic.GetEmpty {
            public static final int INDEX = 72;
            private final String clusterId;

            public GetEmpty(String str) {
                if (str != null) {
                    this.clusterId = str;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'clusterId' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(cluster-id=");
                sb.append(this.clusterId);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.GetEmpty
            public String getClusterId() {
                return this.clusterId;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 72;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.get-empty";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.clusterId);
            }

            public GetEmpty(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr());
            }
        }

        public static class Reject extends Method implements AMQP.Basic.Reject {
            public static final int INDEX = 90;
            private final long deliveryTag;
            private final boolean requeue;

            public Reject(long j, boolean z) {
                this.deliveryTag = j;
                this.requeue = z;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(delivery-tag=");
                sb.append(this.deliveryTag);
                sb.append(", requeue=");
                sb.append(this.requeue);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Reject
            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Reject
            public boolean getRequeue() {
                return this.requeue;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 90;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.reject";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLonglong(this.deliveryTag);
                methodArgumentWriter.writeBit(this.requeue);
            }

            public Reject(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLonglong(), methodArgumentReader.readBit());
            }
        }

        public static class Cancel extends Method implements AMQP.Basic.Cancel {
            public static final int INDEX = 30;
            private final String consumerTag;
            private final boolean nowait;

            public Cancel(String str, boolean z) {
                if (str != null) {
                    this.consumerTag = str;
                    this.nowait = z;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(consumer-tag=");
                sb.append(this.consumerTag);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Cancel
            public String getConsumerTag() {
                return this.consumerTag;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Cancel
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 30;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.cancel";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.consumerTag);
                methodArgumentWriter.writeBit(this.nowait);
            }

            public Cancel(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr(), methodArgumentReader.readBit());
            }
        }

        public static class Nack extends Method implements AMQP.Basic.Nack {
            public static final int INDEX = 120;
            private final long deliveryTag;
            private final boolean multiple;
            private final boolean requeue;

            public Nack(long j, boolean z, boolean z2) {
                this.deliveryTag = j;
                this.multiple = z;
                this.requeue = z2;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(delivery-tag=");
                sb.append(this.deliveryTag);
                sb.append(", multiple=");
                sb.append(this.multiple);
                sb.append(", requeue=");
                sb.append(this.requeue);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Nack
            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Nack
            public boolean getMultiple() {
                return this.multiple;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Nack
            public boolean getRequeue() {
                return this.requeue;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 120;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.nack";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLonglong(this.deliveryTag);
                methodArgumentWriter.writeBit(this.multiple);
                methodArgumentWriter.writeBit(this.requeue);
            }

            public Nack(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLonglong(), methodArgumentReader.readBit(), methodArgumentReader.readBit());
            }
        }

        public static class Qos extends Method implements AMQP.Basic.Qos {
            public static final int INDEX = 10;
            private final boolean global;
            private final int prefetchCount;
            private final int prefetchSize;

            public Qos(int i, int i2, boolean z) {
                this.prefetchSize = i;
                this.prefetchCount = i2;
                this.global = z;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(prefetch-size=");
                sb.append(this.prefetchSize);
                sb.append(", prefetch-count=");
                sb.append(this.prefetchCount);
                sb.append(", global=");
                sb.append(this.global);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Qos
            public boolean getGlobal() {
                return this.global;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Qos
            public int getPrefetchCount() {
                return this.prefetchCount;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Qos
            public int getPrefetchSize() {
                return this.prefetchSize;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.qos";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLong(this.prefetchSize);
                methodArgumentWriter.writeShort(this.prefetchCount);
                methodArgumentWriter.writeBit(this.global);
            }

            public Qos(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLong(), methodArgumentReader.readShort(), methodArgumentReader.readBit());
            }
        }

        public static class Get extends Method implements AMQP.Basic.Get {
            public static final int INDEX = 70;
            private final boolean noAck;
            private final String queue;
            private final int ticket;

            public Get(int i, String str, boolean z) {
                if (str != null) {
                    this.ticket = i;
                    this.queue = str;
                    this.noAck = z;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", queue=");
                sb.append(this.queue);
                sb.append(", no-ack=");
                sb.append(this.noAck);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Get
            public boolean getNoAck() {
                return this.noAck;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Get
            public String getQueue() {
                return this.queue;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Get
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 70;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.get";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.queue);
                methodArgumentWriter.writeBit(this.noAck);
            }

            public Get(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit());
            }
        }

        public static class GetOk extends Method implements AMQP.Basic.GetOk {
            public static final int INDEX = 71;
            private final long deliveryTag;
            private final String exchange;
            private final int messageCount;
            private final boolean redelivered;
            private final String routingKey;

            public GetOk(long j, boolean z, String str, String str2, int i) {
                if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (str2 != null) {
                    this.deliveryTag = j;
                    this.redelivered = z;
                    this.exchange = str;
                    this.routingKey = str2;
                    this.messageCount = i;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(delivery-tag=");
                sb.append(this.deliveryTag);
                sb.append(", redelivered=");
                sb.append(this.redelivered);
                sb.append(", exchange=");
                sb.append(this.exchange);
                sb.append(", routing-key=");
                sb.append(this.routingKey);
                sb.append(", message-count=");
                sb.append(this.messageCount);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.GetOk
            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.GetOk
            public String getExchange() {
                return this.exchange;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.GetOk
            public int getMessageCount() {
                return this.messageCount;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.GetOk
            public boolean getRedelivered() {
                return this.redelivered;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.GetOk
            public String getRoutingKey() {
                return this.routingKey;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return true;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 71;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.get-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLonglong(this.deliveryTag);
                methodArgumentWriter.writeBit(this.redelivered);
                methodArgumentWriter.writeShortstr(this.exchange);
                methodArgumentWriter.writeShortstr(this.routingKey);
                methodArgumentWriter.writeLong(this.messageCount);
            }

            public GetOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLonglong(), methodArgumentReader.readBit(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readLong());
            }
        }

        public static class Publish extends Method implements AMQP.Basic.Publish {
            public static final int INDEX = 40;
            private final String exchange;
            private final boolean immediate;
            private final boolean mandatory;
            private final String routingKey;
            private final int ticket;

            public Publish(int i, String str, String str2, boolean z, boolean z2) {
                if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (str2 != null) {
                    this.ticket = i;
                    this.exchange = str;
                    this.routingKey = str2;
                    this.mandatory = z;
                    this.immediate = z2;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", exchange=");
                sb.append(this.exchange);
                sb.append(", routing-key=");
                sb.append(this.routingKey);
                sb.append(", mandatory=");
                sb.append(this.mandatory);
                sb.append(", immediate=");
                sb.append(this.immediate);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Publish
            public String getExchange() {
                return this.exchange;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Publish
            public boolean getImmediate() {
                return this.immediate;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Publish
            public boolean getMandatory() {
                return this.mandatory;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Publish
            public String getRoutingKey() {
                return this.routingKey;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Publish
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return true;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.publish";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.exchange);
                methodArgumentWriter.writeShortstr(this.routingKey);
                methodArgumentWriter.writeBit(this.mandatory);
                methodArgumentWriter.writeBit(this.immediate);
            }

            public Publish(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readBit());
            }
        }

        public static class Return extends Method implements AMQP.Basic.Return {
            public static final int INDEX = 50;
            private final String exchange;
            private final int replyCode;
            private final String replyText;
            private final String routingKey;

            public Return(int i, String str, String str2, String str3) {
                if (str2 == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'replyText' must be non-null.");
                } else if (str3 != null) {
                    this.replyCode = i;
                    this.replyText = str;
                    this.exchange = str2;
                    this.routingKey = str3;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(reply-code=");
                sb.append(this.replyCode);
                sb.append(", reply-text=");
                sb.append(this.replyText);
                sb.append(", exchange=");
                sb.append(this.exchange);
                sb.append(", routing-key=");
                sb.append(this.routingKey);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Return
            public String getExchange() {
                return this.exchange;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Return
            public int getReplyCode() {
                return this.replyCode;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Return
            public String getReplyText() {
                return this.replyText;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Return
            public String getRoutingKey() {
                return this.routingKey;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return true;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.return";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.replyCode);
                methodArgumentWriter.writeShortstr(this.replyText);
                methodArgumentWriter.writeShortstr(this.exchange);
                methodArgumentWriter.writeShortstr(this.routingKey);
            }

            public Return(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr());
            }
        }

        public static class Deliver extends Method implements AMQP.Basic.Deliver {
            public static final int INDEX = 60;
            private final String consumerTag;
            private final long deliveryTag;
            private final String exchange;
            private final boolean redelivered;
            private final String routingKey;

            public Deliver(String str, long j, boolean z, String str2, String str3) {
                if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
                } else if (str2 == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (str3 != null) {
                    this.consumerTag = str;
                    this.deliveryTag = j;
                    this.redelivered = z;
                    this.exchange = str2;
                    this.routingKey = str3;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(consumer-tag=");
                sb.append(this.consumerTag);
                sb.append(", delivery-tag=");
                sb.append(this.deliveryTag);
                sb.append(", redelivered=");
                sb.append(this.redelivered);
                sb.append(", exchange=");
                sb.append(this.exchange);
                sb.append(", routing-key=");
                sb.append(this.routingKey);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Deliver
            public String getConsumerTag() {
                return this.consumerTag;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Deliver
            public long getDeliveryTag() {
                return this.deliveryTag;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Deliver
            public String getExchange() {
                return this.exchange;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Deliver
            public boolean getRedelivered() {
                return this.redelivered;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Deliver
            public String getRoutingKey() {
                return this.routingKey;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return true;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.deliver";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.consumerTag);
                methodArgumentWriter.writeLonglong(this.deliveryTag);
                methodArgumentWriter.writeBit(this.redelivered);
                methodArgumentWriter.writeShortstr(this.exchange);
                methodArgumentWriter.writeShortstr(this.routingKey);
            }

            public Deliver(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr(), methodArgumentReader.readLonglong(), methodArgumentReader.readBit(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr());
            }
        }

        public static class Consume extends Method implements AMQP.Basic.Consume {
            public static final int INDEX = 20;
            private final Map<String, Object> arguments;
            private final String consumerTag;
            private final boolean exclusive;
            private final boolean noAck;
            private final boolean noLocal;
            private final boolean nowait;
            private final String queue;
            private final int ticket;

            public Consume(int i, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, Map<String, Object> map) {
                Map<String, Object> map2;
                if (str2 == null) {
                    throw new IllegalStateException("Invalid configuration: 'consumerTag' must be non-null.");
                } else if (str != null) {
                    this.ticket = i;
                    this.queue = str;
                    this.consumerTag = str2;
                    this.noLocal = z;
                    this.noAck = z2;
                    this.exclusive = z3;
                    this.nowait = z4;
                    if (map == null) {
                        map2 = null;
                    } else {
                        map2 = Collections.unmodifiableMap(new HashMap(map));
                    }
                    this.arguments = map2;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", queue=");
                sb.append(this.queue);
                sb.append(", consumer-tag=");
                sb.append(this.consumerTag);
                sb.append(", no-local=");
                sb.append(this.noLocal);
                sb.append(", no-ack=");
                sb.append(this.noAck);
                sb.append(", exclusive=");
                sb.append(this.exclusive);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(", arguments=");
                sb.append(this.arguments);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Consume
            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Consume
            public String getConsumerTag() {
                return this.consumerTag;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Consume
            public boolean getExclusive() {
                return this.exclusive;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Consume
            public boolean getNoAck() {
                return this.noAck;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Consume
            public boolean getNoLocal() {
                return this.noLocal;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Consume
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Consume
            public String getQueue() {
                return this.queue;
            }

            @Override // com.rabbitmq.client.AMQP.Basic.Consume
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "basic.consume";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.queue);
                methodArgumentWriter.writeShortstr(this.consumerTag);
                methodArgumentWriter.writeBit(this.noLocal);
                methodArgumentWriter.writeBit(this.noAck);
                methodArgumentWriter.writeBit(this.exclusive);
                methodArgumentWriter.writeBit(this.nowait);
                methodArgumentWriter.writeTable(this.arguments);
            }

            public Consume(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readTable());
            }
        }
    }

    public static class Channel {
        public static final int INDEX = 20;

        public static class CloseOk extends Method implements AMQP.Channel.CloseOk {
            public static final int INDEX = 41;

            public CloseOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 41;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "channel.close-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public CloseOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class Flow extends Method implements AMQP.Channel.Flow {
            public static final int INDEX = 20;
            private final boolean active;

            public Flow(boolean z) {
                this.active = z;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(active=");
                sb.append(this.active);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Channel.Flow
            public boolean getActive() {
                return this.active;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "channel.flow";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeBit(this.active);
            }

            public Flow(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readBit());
            }
        }

        public static class FlowOk extends Method implements AMQP.Channel.FlowOk {
            public static final int INDEX = 21;
            private final boolean active;

            public FlowOk(boolean z) {
                this.active = z;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(active=");
                sb.append(this.active);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Channel.FlowOk
            public boolean getActive() {
                return this.active;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 21;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "channel.flow-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeBit(this.active);
            }

            public FlowOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readBit());
            }
        }

        public static class Open extends Method implements AMQP.Channel.Open {
            public static final int INDEX = 10;
            private final String outOfBand;

            public Open(String str) {
                if (str != null) {
                    this.outOfBand = str;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'outOfBand' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(out-of-band=");
                sb.append(this.outOfBand);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Channel.Open
            public String getOutOfBand() {
                return this.outOfBand;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "channel.open";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.outOfBand);
            }

            public Open(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr());
            }
        }

        public static class OpenOk extends Method implements AMQP.Channel.OpenOk {
            public static final int INDEX = 11;
            private final LongString channelId;

            public OpenOk(LongString longString) {
                if (longString != null) {
                    this.channelId = longString;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'channelId' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(channel-id=");
                sb.append(this.channelId);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Channel.OpenOk
            public LongString getChannelId() {
                return this.channelId;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 11;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "channel.open-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLongstr(this.channelId);
            }

            public OpenOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLongstr());
            }
        }

        public static class Close extends Method implements AMQP.Channel.Close {
            public static final int INDEX = 40;
            private final int classId;
            private final int methodId;
            private final int replyCode;
            private final String replyText;

            public Close(int i, String str, int i2, int i3) {
                if (str != null) {
                    this.replyCode = i;
                    this.replyText = str;
                    this.classId = i2;
                    this.methodId = i3;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'replyText' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(reply-code=");
                sb.append(this.replyCode);
                sb.append(", reply-text=");
                sb.append(this.replyText);
                sb.append(", class-id=");
                sb.append(this.classId);
                sb.append(", method-id=");
                sb.append(this.methodId);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Channel.Close
            public int getClassId() {
                return this.classId;
            }

            @Override // com.rabbitmq.client.AMQP.Channel.Close
            public int getMethodId() {
                return this.methodId;
            }

            @Override // com.rabbitmq.client.AMQP.Channel.Close
            public int getReplyCode() {
                return this.replyCode;
            }

            @Override // com.rabbitmq.client.AMQP.Channel.Close
            public String getReplyText() {
                return this.replyText;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "channel.close";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.replyCode);
                methodArgumentWriter.writeShortstr(this.replyText);
                methodArgumentWriter.writeShort(this.classId);
                methodArgumentWriter.writeShort(this.methodId);
            }

            public Close(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShort(), methodArgumentReader.readShort());
            }
        }
    }

    public static class Confirm {
        public static final int INDEX = 85;

        public static class SelectOk extends Method implements AMQP.Confirm.SelectOk {
            public static final int INDEX = 11;

            public SelectOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 85;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 11;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "confirm.select-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public SelectOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class Select extends Method implements AMQP.Confirm.Select {
            public static final int INDEX = 10;
            private final boolean nowait;

            public Select(boolean z) {
                this.nowait = z;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(nowait=");
                sb.append(this.nowait);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Confirm.Select
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 85;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "confirm.select";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeBit(this.nowait);
            }

            public Select(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readBit());
            }
        }
    }

    public static class DefaultMethodVisitor implements MethodVisitor {
        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.Start start) throws IOException {
            throw new UnexpectedMethodError(start);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.StartOk startOk) throws IOException {
            throw new UnexpectedMethodError(startOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.Secure secure) throws IOException {
            throw new UnexpectedMethodError(secure);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.SecureOk secureOk) throws IOException {
            throw new UnexpectedMethodError(secureOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.Tune tune) throws IOException {
            throw new UnexpectedMethodError(tune);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.TuneOk tuneOk) throws IOException {
            throw new UnexpectedMethodError(tuneOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.Open open) throws IOException {
            throw new UnexpectedMethodError(open);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.OpenOk openOk) throws IOException {
            throw new UnexpectedMethodError(openOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.Close close) throws IOException {
            throw new UnexpectedMethodError(close);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.CloseOk closeOk) throws IOException {
            throw new UnexpectedMethodError(closeOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.Blocked blocked) throws IOException {
            throw new UnexpectedMethodError(blocked);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Connection.Unblocked unblocked) throws IOException {
            throw new UnexpectedMethodError(unblocked);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Channel.Open open) throws IOException {
            throw new UnexpectedMethodError(open);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Channel.OpenOk openOk) throws IOException {
            throw new UnexpectedMethodError(openOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Channel.Flow flow) throws IOException {
            throw new UnexpectedMethodError(flow);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Channel.FlowOk flowOk) throws IOException {
            throw new UnexpectedMethodError(flowOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Channel.Close close) throws IOException {
            throw new UnexpectedMethodError(close);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Channel.CloseOk closeOk) throws IOException {
            throw new UnexpectedMethodError(closeOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Access.Request request) throws IOException {
            throw new UnexpectedMethodError(request);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Access.RequestOk requestOk) throws IOException {
            throw new UnexpectedMethodError(requestOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Exchange.Declare declare) throws IOException {
            throw new UnexpectedMethodError(declare);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Exchange.DeclareOk declareOk) throws IOException {
            throw new UnexpectedMethodError(declareOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Exchange.Delete delete) throws IOException {
            throw new UnexpectedMethodError(delete);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Exchange.DeleteOk deleteOk) throws IOException {
            throw new UnexpectedMethodError(deleteOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Exchange.Bind bind) throws IOException {
            throw new UnexpectedMethodError(bind);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Exchange.BindOk bindOk) throws IOException {
            throw new UnexpectedMethodError(bindOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Exchange.Unbind unbind) throws IOException {
            throw new UnexpectedMethodError(unbind);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Exchange.UnbindOk unbindOk) throws IOException {
            throw new UnexpectedMethodError(unbindOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.Declare declare) throws IOException {
            throw new UnexpectedMethodError(declare);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.DeclareOk declareOk) throws IOException {
            throw new UnexpectedMethodError(declareOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.Bind bind) throws IOException {
            throw new UnexpectedMethodError(bind);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.BindOk bindOk) throws IOException {
            throw new UnexpectedMethodError(bindOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.Purge purge) throws IOException {
            throw new UnexpectedMethodError(purge);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.PurgeOk purgeOk) throws IOException {
            throw new UnexpectedMethodError(purgeOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.Delete delete) throws IOException {
            throw new UnexpectedMethodError(delete);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.DeleteOk deleteOk) throws IOException {
            throw new UnexpectedMethodError(deleteOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.Unbind unbind) throws IOException {
            throw new UnexpectedMethodError(unbind);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Queue.UnbindOk unbindOk) throws IOException {
            throw new UnexpectedMethodError(unbindOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Qos qos) throws IOException {
            throw new UnexpectedMethodError(qos);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.QosOk qosOk) throws IOException {
            throw new UnexpectedMethodError(qosOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Consume consume) throws IOException {
            throw new UnexpectedMethodError(consume);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.ConsumeOk consumeOk) throws IOException {
            throw new UnexpectedMethodError(consumeOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Cancel cancel) throws IOException {
            throw new UnexpectedMethodError(cancel);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.CancelOk cancelOk) throws IOException {
            throw new UnexpectedMethodError(cancelOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Publish publish) throws IOException {
            throw new UnexpectedMethodError(publish);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Return r2) throws IOException {
            throw new UnexpectedMethodError(r2);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Deliver deliver) throws IOException {
            throw new UnexpectedMethodError(deliver);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Get get) throws IOException {
            throw new UnexpectedMethodError(get);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.GetOk getOk) throws IOException {
            throw new UnexpectedMethodError(getOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.GetEmpty getEmpty) throws IOException {
            throw new UnexpectedMethodError(getEmpty);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Ack ack) throws IOException {
            throw new UnexpectedMethodError(ack);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Reject reject) throws IOException {
            throw new UnexpectedMethodError(reject);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.RecoverAsync recoverAsync) throws IOException {
            throw new UnexpectedMethodError(recoverAsync);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Recover recover) throws IOException {
            throw new UnexpectedMethodError(recover);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.RecoverOk recoverOk) throws IOException {
            throw new UnexpectedMethodError(recoverOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Basic.Nack nack) throws IOException {
            throw new UnexpectedMethodError(nack);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Tx.Select select) throws IOException {
            throw new UnexpectedMethodError(select);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Tx.SelectOk selectOk) throws IOException {
            throw new UnexpectedMethodError(selectOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Tx.Commit commit) throws IOException {
            throw new UnexpectedMethodError(commit);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Tx.CommitOk commitOk) throws IOException {
            throw new UnexpectedMethodError(commitOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Tx.Rollback rollback) throws IOException {
            throw new UnexpectedMethodError(rollback);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Tx.RollbackOk rollbackOk) throws IOException {
            throw new UnexpectedMethodError(rollbackOk);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Confirm.Select select) throws IOException {
            throw new UnexpectedMethodError(select);
        }

        @Override // com.rabbitmq.client.impl.AMQImpl.MethodVisitor
        public Object visit(Confirm.SelectOk selectOk) throws IOException {
            throw new UnexpectedMethodError(selectOk);
        }
    }

    public interface MethodVisitor {
        Object visit(Access.Request request) throws IOException;

        Object visit(Access.RequestOk requestOk) throws IOException;

        Object visit(Basic.Ack ack) throws IOException;

        Object visit(Basic.Cancel cancel) throws IOException;

        Object visit(Basic.CancelOk cancelOk) throws IOException;

        Object visit(Basic.Consume consume) throws IOException;

        Object visit(Basic.ConsumeOk consumeOk) throws IOException;

        Object visit(Basic.Deliver deliver) throws IOException;

        Object visit(Basic.Get get) throws IOException;

        Object visit(Basic.GetEmpty getEmpty) throws IOException;

        Object visit(Basic.GetOk getOk) throws IOException;

        Object visit(Basic.Nack nack) throws IOException;

        Object visit(Basic.Publish publish) throws IOException;

        Object visit(Basic.Qos qos) throws IOException;

        Object visit(Basic.QosOk qosOk) throws IOException;

        Object visit(Basic.Recover recover) throws IOException;

        Object visit(Basic.RecoverAsync recoverAsync) throws IOException;

        Object visit(Basic.RecoverOk recoverOk) throws IOException;

        Object visit(Basic.Reject reject) throws IOException;

        Object visit(Basic.Return v) throws IOException;

        Object visit(Channel.Close close) throws IOException;

        Object visit(Channel.CloseOk closeOk) throws IOException;

        Object visit(Channel.Flow flow) throws IOException;

        Object visit(Channel.FlowOk flowOk) throws IOException;

        Object visit(Channel.Open open) throws IOException;

        Object visit(Channel.OpenOk openOk) throws IOException;

        Object visit(Confirm.Select select) throws IOException;

        Object visit(Confirm.SelectOk selectOk) throws IOException;

        Object visit(Connection.Blocked blocked) throws IOException;

        Object visit(Connection.Close close) throws IOException;

        Object visit(Connection.CloseOk closeOk) throws IOException;

        Object visit(Connection.Open open) throws IOException;

        Object visit(Connection.OpenOk openOk) throws IOException;

        Object visit(Connection.Secure secure) throws IOException;

        Object visit(Connection.SecureOk secureOk) throws IOException;

        Object visit(Connection.Start start) throws IOException;

        Object visit(Connection.StartOk startOk) throws IOException;

        Object visit(Connection.Tune tune) throws IOException;

        Object visit(Connection.TuneOk tuneOk) throws IOException;

        Object visit(Connection.Unblocked unblocked) throws IOException;

        Object visit(Exchange.Bind bind) throws IOException;

        Object visit(Exchange.BindOk bindOk) throws IOException;

        Object visit(Exchange.Declare declare) throws IOException;

        Object visit(Exchange.DeclareOk declareOk) throws IOException;

        Object visit(Exchange.Delete delete) throws IOException;

        Object visit(Exchange.DeleteOk deleteOk) throws IOException;

        Object visit(Exchange.Unbind unbind) throws IOException;

        Object visit(Exchange.UnbindOk unbindOk) throws IOException;

        Object visit(Queue.Bind bind) throws IOException;

        Object visit(Queue.BindOk bindOk) throws IOException;

        Object visit(Queue.Declare declare) throws IOException;

        Object visit(Queue.DeclareOk declareOk) throws IOException;

        Object visit(Queue.Delete delete) throws IOException;

        Object visit(Queue.DeleteOk deleteOk) throws IOException;

        Object visit(Queue.Purge purge) throws IOException;

        Object visit(Queue.PurgeOk purgeOk) throws IOException;

        Object visit(Queue.Unbind unbind) throws IOException;

        Object visit(Queue.UnbindOk unbindOk) throws IOException;

        Object visit(Tx.Commit commit) throws IOException;

        Object visit(Tx.CommitOk commitOk) throws IOException;

        Object visit(Tx.Rollback rollback) throws IOException;

        Object visit(Tx.RollbackOk rollbackOk) throws IOException;

        Object visit(Tx.Select select) throws IOException;

        Object visit(Tx.SelectOk selectOk) throws IOException;
    }

    public static class Queue {
        public static final int INDEX = 50;

        public static class BindOk extends Method implements AMQP.Queue.BindOk {
            public static final int INDEX = 21;

            public BindOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 21;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.bind-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public BindOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class UnbindOk extends Method implements AMQP.Queue.UnbindOk {
            public static final int INDEX = 51;

            public UnbindOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 51;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.unbind-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public UnbindOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class DeleteOk extends Method implements AMQP.Queue.DeleteOk {
            public static final int INDEX = 41;
            private final int messageCount;

            public DeleteOk(int i) {
                this.messageCount = i;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(message-count=");
                sb.append(this.messageCount);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Queue.DeleteOk
            public int getMessageCount() {
                return this.messageCount;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 41;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.delete-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLong(this.messageCount);
            }

            public DeleteOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLong());
            }
        }

        public static class PurgeOk extends Method implements AMQP.Queue.PurgeOk {
            public static final int INDEX = 31;
            private final int messageCount;

            public PurgeOk(int i) {
                this.messageCount = i;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(message-count=");
                sb.append(this.messageCount);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Queue.PurgeOk
            public int getMessageCount() {
                return this.messageCount;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 31;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.purge-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLong(this.messageCount);
            }

            public PurgeOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLong());
            }
        }

        public static class DeclareOk extends Method implements AMQP.Queue.DeclareOk {
            public static final int INDEX = 11;
            private final int consumerCount;
            private final int messageCount;
            private final String queue;

            public DeclareOk(String str, int i, int i2) {
                if (str != null) {
                    this.queue = str;
                    this.messageCount = i;
                    this.consumerCount = i2;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(queue=");
                sb.append(this.queue);
                sb.append(", message-count=");
                sb.append(this.messageCount);
                sb.append(", consumer-count=");
                sb.append(this.consumerCount);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Queue.DeclareOk
            public int getConsumerCount() {
                return this.consumerCount;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.DeclareOk
            public int getMessageCount() {
                return this.messageCount;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.DeclareOk
            public String getQueue() {
                return this.queue;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 11;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.declare-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.queue);
                methodArgumentWriter.writeLong(this.messageCount);
                methodArgumentWriter.writeLong(this.consumerCount);
            }

            public DeclareOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr(), methodArgumentReader.readLong(), methodArgumentReader.readLong());
            }
        }

        public static class Purge extends Method implements AMQP.Queue.Purge {
            public static final int INDEX = 30;
            private final boolean nowait;
            private final String queue;
            private final int ticket;

            public Purge(int i, String str, boolean z) {
                if (str != null) {
                    this.ticket = i;
                    this.queue = str;
                    this.nowait = z;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", queue=");
                sb.append(this.queue);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Purge
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Purge
            public String getQueue() {
                return this.queue;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Purge
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 30;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.purge";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.queue);
                methodArgumentWriter.writeBit(this.nowait);
            }

            public Purge(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit());
            }
        }

        public static class Delete extends Method implements AMQP.Queue.Delete {
            public static final int INDEX = 40;
            private final boolean ifEmpty;
            private final boolean ifUnused;
            private final boolean nowait;
            private final String queue;
            private final int ticket;

            public Delete(int i, String str, boolean z, boolean z2, boolean z3) {
                if (str != null) {
                    this.ticket = i;
                    this.queue = str;
                    this.ifUnused = z;
                    this.ifEmpty = z2;
                    this.nowait = z3;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", queue=");
                sb.append(this.queue);
                sb.append(", if-unused=");
                sb.append(this.ifUnused);
                sb.append(", if-empty=");
                sb.append(this.ifEmpty);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Delete
            public boolean getIfEmpty() {
                return this.ifEmpty;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Delete
            public boolean getIfUnused() {
                return this.ifUnused;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Delete
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Delete
            public String getQueue() {
                return this.queue;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Delete
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.delete";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.queue);
                methodArgumentWriter.writeBit(this.ifUnused);
                methodArgumentWriter.writeBit(this.ifEmpty);
                methodArgumentWriter.writeBit(this.nowait);
            }

            public Delete(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit());
            }
        }

        public static class Unbind extends Method implements AMQP.Queue.Unbind {
            public static final int INDEX = 50;
            private final Map<String, Object> arguments;
            private final String exchange;
            private final String queue;
            private final String routingKey;
            private final int ticket;

            public Unbind(int i, String str, String str2, String str3, Map<String, Object> map) {
                Map<String, Object> map2;
                if (str2 == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else if (str3 != null) {
                    this.ticket = i;
                    this.queue = str;
                    this.exchange = str2;
                    this.routingKey = str3;
                    if (map == null) {
                        map2 = null;
                    } else {
                        map2 = Collections.unmodifiableMap(new HashMap(map));
                    }
                    this.arguments = map2;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", queue=");
                sb.append(this.queue);
                sb.append(", exchange=");
                sb.append(this.exchange);
                sb.append(", routing-key=");
                sb.append(this.routingKey);
                sb.append(", arguments=");
                sb.append(this.arguments);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Unbind
            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Unbind
            public String getExchange() {
                return this.exchange;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Unbind
            public String getQueue() {
                return this.queue;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Unbind
            public String getRoutingKey() {
                return this.routingKey;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Unbind
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.unbind";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.queue);
                methodArgumentWriter.writeShortstr(this.exchange);
                methodArgumentWriter.writeShortstr(this.routingKey);
                methodArgumentWriter.writeTable(this.arguments);
            }

            public Unbind(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readTable());
            }
        }

        public static class Bind extends Method implements AMQP.Queue.Bind {
            public static final int INDEX = 20;
            private final Map<String, Object> arguments;
            private final String exchange;
            private final boolean nowait;
            private final String queue;
            private final String routingKey;
            private final int ticket;

            public Bind(int i, String str, String str2, String str3, boolean z, Map<String, Object> map) {
                Map<String, Object> map2;
                if (str2 == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
                } else if (str3 != null) {
                    this.ticket = i;
                    this.queue = str;
                    this.exchange = str2;
                    this.routingKey = str3;
                    this.nowait = z;
                    if (map == null) {
                        map2 = null;
                    } else {
                        map2 = Collections.unmodifiableMap(new HashMap(map));
                    }
                    this.arguments = map2;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", queue=");
                sb.append(this.queue);
                sb.append(", exchange=");
                sb.append(this.exchange);
                sb.append(", routing-key=");
                sb.append(this.routingKey);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(", arguments=");
                sb.append(this.arguments);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Bind
            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Bind
            public String getExchange() {
                return this.exchange;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Bind
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Bind
            public String getQueue() {
                return this.queue;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Bind
            public String getRoutingKey() {
                return this.routingKey;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Bind
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.bind";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.queue);
                methodArgumentWriter.writeShortstr(this.exchange);
                methodArgumentWriter.writeShortstr(this.routingKey);
                methodArgumentWriter.writeBit(this.nowait);
                methodArgumentWriter.writeTable(this.arguments);
            }

            public Bind(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readTable());
            }
        }

        public static class Declare extends Method implements AMQP.Queue.Declare {
            public static final int INDEX = 10;
            private final Map<String, Object> arguments;
            private final boolean autoDelete;
            private final boolean durable;
            private final boolean exclusive;
            private final boolean nowait;
            private final boolean passive;
            private final String queue;
            private final int ticket;

            public Declare(int i, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Map<String, Object> map) {
                Map<String, Object> map2;
                if (str != null) {
                    this.ticket = i;
                    this.queue = str;
                    this.passive = z;
                    this.durable = z2;
                    this.exclusive = z3;
                    this.autoDelete = z4;
                    this.nowait = z5;
                    if (map == null) {
                        map2 = null;
                    } else {
                        map2 = Collections.unmodifiableMap(new HashMap(map));
                    }
                    this.arguments = map2;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'queue' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", queue=");
                sb.append(this.queue);
                sb.append(", passive=");
                sb.append(this.passive);
                sb.append(", durable=");
                sb.append(this.durable);
                sb.append(", exclusive=");
                sb.append(this.exclusive);
                sb.append(", auto-delete=");
                sb.append(this.autoDelete);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(", arguments=");
                sb.append(this.arguments);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Declare
            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Declare
            public boolean getAutoDelete() {
                return this.autoDelete;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Declare
            public boolean getDurable() {
                return this.durable;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Declare
            public boolean getExclusive() {
                return this.exclusive;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Declare
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Declare
            public boolean getPassive() {
                return this.passive;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Declare
            public String getQueue() {
                return this.queue;
            }

            @Override // com.rabbitmq.client.AMQP.Queue.Declare
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "queue.declare";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.queue);
                methodArgumentWriter.writeBit(this.passive);
                methodArgumentWriter.writeBit(this.durable);
                methodArgumentWriter.writeBit(this.exclusive);
                methodArgumentWriter.writeBit(this.autoDelete);
                methodArgumentWriter.writeBit(this.nowait);
                methodArgumentWriter.writeTable(this.arguments);
            }

            public Declare(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readTable());
            }
        }
    }

    public static class Tx {
        public static final int INDEX = 90;

        public static class Commit extends Method implements AMQP.Tx.Commit {
            public static final int INDEX = 20;

            public Commit() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 90;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "tx.commit";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public Commit(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class CommitOk extends Method implements AMQP.Tx.CommitOk {
            public static final int INDEX = 21;

            public CommitOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 90;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 21;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "tx.commit-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public CommitOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class Rollback extends Method implements AMQP.Tx.Rollback {
            public static final int INDEX = 30;

            public Rollback() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 90;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 30;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "tx.rollback";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public Rollback(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class RollbackOk extends Method implements AMQP.Tx.RollbackOk {
            public static final int INDEX = 31;

            public RollbackOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 90;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 31;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "tx.rollback-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public RollbackOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class Select extends Method implements AMQP.Tx.Select {
            public static final int INDEX = 10;

            public Select() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 90;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "tx.select";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public Select(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class SelectOk extends Method implements AMQP.Tx.SelectOk {
            public static final int INDEX = 11;

            public SelectOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 90;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 11;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "tx.select-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public SelectOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }
    }

    public static AMQContentHeader readContentHeaderFrom(DataInputStream dataInputStream) throws IOException {
        short readShort = dataInputStream.readShort();
        if (readShort == 60) {
            return new AMQP.BasicProperties(dataInputStream);
        }
        throw new UnknownClassOrMethodId(readShort);
    }

    public static Method readMethodFrom(DataInputStream dataInputStream) throws IOException {
        short readShort = dataInputStream.readShort();
        short readShort2 = dataInputStream.readShort();
        if (readShort != 10) {
            if (readShort != 20) {
                if (readShort != 30) {
                    if (readShort != 40) {
                        if (readShort != 50) {
                            if (readShort != 60) {
                                if (readShort != 85) {
                                    if (readShort == 90) {
                                        if (readShort2 == 10) {
                                            return new Tx.Select(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                        }
                                        if (readShort2 == 11) {
                                            return new Tx.SelectOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                        }
                                        if (readShort2 == 20) {
                                            return new Tx.Commit(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                        }
                                        if (readShort2 == 21) {
                                            return new Tx.CommitOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                        }
                                        if (readShort2 == 30) {
                                            return new Tx.Rollback(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                        }
                                        if (readShort2 == 31) {
                                            return new Tx.RollbackOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                        }
                                    }
                                } else if (readShort2 == 10) {
                                    return new Confirm.Select(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                } else {
                                    if (readShort2 == 11) {
                                        return new Confirm.SelectOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                    }
                                }
                            } else if (readShort2 == 10) {
                                return new Basic.Qos(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            } else {
                                if (readShort2 == 11) {
                                    return new Basic.QosOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 20) {
                                    return new Basic.Consume(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 21) {
                                    return new Basic.ConsumeOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 30) {
                                    return new Basic.Cancel(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 31) {
                                    return new Basic.CancelOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 40) {
                                    return new Basic.Publish(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 50) {
                                    return new Basic.Return(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 60) {
                                    return new Basic.Deliver(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 80) {
                                    return new Basic.Ack(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 90) {
                                    return new Basic.Reject(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 100) {
                                    return new Basic.RecoverAsync(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 120) {
                                    return new Basic.Nack(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 110) {
                                    return new Basic.Recover(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                if (readShort2 == 111) {
                                    return new Basic.RecoverOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                                switch (readShort2) {
                                    case 70:
                                        return new Basic.Get(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                    case 71:
                                        return new Basic.GetOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                    case 72:
                                        return new Basic.GetEmpty(new MethodArgumentReader(new ValueReader(dataInputStream)));
                                }
                            }
                        } else if (readShort2 == 10) {
                            return new Queue.Declare(new MethodArgumentReader(new ValueReader(dataInputStream)));
                        } else {
                            if (readShort2 == 11) {
                                return new Queue.DeclareOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            }
                            if (readShort2 == 20) {
                                return new Queue.Bind(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            }
                            if (readShort2 == 21) {
                                return new Queue.BindOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            }
                            if (readShort2 == 30) {
                                return new Queue.Purge(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            }
                            if (readShort2 == 31) {
                                return new Queue.PurgeOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            }
                            if (readShort2 == 40) {
                                return new Queue.Delete(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            }
                            if (readShort2 == 41) {
                                return new Queue.DeleteOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            }
                            if (readShort2 == 50) {
                                return new Queue.Unbind(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            }
                            if (readShort2 == 51) {
                                return new Queue.UnbindOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                            }
                        }
                    } else if (readShort2 == 10) {
                        return new Exchange.Declare(new MethodArgumentReader(new ValueReader(dataInputStream)));
                    } else {
                        if (readShort2 == 11) {
                            return new Exchange.DeclareOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                        }
                        if (readShort2 == 20) {
                            return new Exchange.Delete(new MethodArgumentReader(new ValueReader(dataInputStream)));
                        }
                        if (readShort2 == 21) {
                            return new Exchange.DeleteOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                        }
                        if (readShort2 == 30) {
                            return new Exchange.Bind(new MethodArgumentReader(new ValueReader(dataInputStream)));
                        }
                        if (readShort2 == 31) {
                            return new Exchange.BindOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                        }
                        if (readShort2 == 40) {
                            return new Exchange.Unbind(new MethodArgumentReader(new ValueReader(dataInputStream)));
                        }
                        if (readShort2 == 51) {
                            return new Exchange.UnbindOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                        }
                    }
                } else if (readShort2 == 10) {
                    return new Access.Request(new MethodArgumentReader(new ValueReader(dataInputStream)));
                } else {
                    if (readShort2 == 11) {
                        return new Access.RequestOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                    }
                }
            } else if (readShort2 == 10) {
                return new Channel.Open(new MethodArgumentReader(new ValueReader(dataInputStream)));
            } else {
                if (readShort2 == 11) {
                    return new Channel.OpenOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                }
                if (readShort2 == 20) {
                    return new Channel.Flow(new MethodArgumentReader(new ValueReader(dataInputStream)));
                }
                if (readShort2 == 21) {
                    return new Channel.FlowOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                }
                if (readShort2 == 40) {
                    return new Channel.Close(new MethodArgumentReader(new ValueReader(dataInputStream)));
                }
                if (readShort2 == 41) {
                    return new Channel.CloseOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
                }
            }
        } else if (readShort2 == 10) {
            return new Connection.Start(new MethodArgumentReader(new ValueReader(dataInputStream)));
        } else {
            if (readShort2 == 11) {
                return new Connection.StartOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 20) {
                return new Connection.Secure(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 21) {
                return new Connection.SecureOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 30) {
                return new Connection.Tune(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 31) {
                return new Connection.TuneOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 40) {
                return new Connection.Open(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 41) {
                return new Connection.OpenOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 50) {
                return new Connection.Close(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 51) {
                return new Connection.CloseOk(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 60) {
                return new Connection.Blocked(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
            if (readShort2 == 61) {
                return new Connection.Unblocked(new MethodArgumentReader(new ValueReader(dataInputStream)));
            }
        }
        throw new UnknownClassOrMethodId(readShort, readShort2);
    }

    public static class Connection {
        public static final int INDEX = 10;

        public static class CloseOk extends Method implements AMQP.Connection.CloseOk {
            public static final int INDEX = 51;

            public CloseOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 51;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.close-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public CloseOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class Unblocked extends Method implements AMQP.Connection.Unblocked {
            public static final int INDEX = 61;

            public Unblocked() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 61;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.unblocked";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public Unblocked(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class Blocked extends Method implements AMQP.Connection.Blocked {
            public static final int INDEX = 60;
            private final String reason;

            public Blocked(String str) {
                if (str != null) {
                    this.reason = str;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'reason' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(reason=");
                sb.append(this.reason);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Blocked
            public String getReason() {
                return this.reason;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 60;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.blocked";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.reason);
            }

            public Blocked(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr());
            }
        }

        public static class OpenOk extends Method implements AMQP.Connection.OpenOk {
            public static final int INDEX = 41;
            private final String knownHosts;

            public OpenOk(String str) {
                if (str != null) {
                    this.knownHosts = str;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'knownHosts' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(known-hosts=");
                sb.append(this.knownHosts);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.OpenOk
            public String getKnownHosts() {
                return this.knownHosts;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 41;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.open-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.knownHosts);
            }

            public OpenOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr());
            }
        }

        public static class Secure extends Method implements AMQP.Connection.Secure {
            public static final int INDEX = 20;
            private final LongString challenge;

            public Secure(LongString longString) {
                if (longString != null) {
                    this.challenge = longString;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'challenge' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(challenge=");
                sb.append(this.challenge);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Secure
            public LongString getChallenge() {
                return this.challenge;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.secure";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLongstr(this.challenge);
            }

            public Secure(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLongstr());
            }
        }

        public static class SecureOk extends Method implements AMQP.Connection.SecureOk {
            public static final int INDEX = 21;
            private final LongString response;

            public SecureOk(LongString longString) {
                if (longString != null) {
                    this.response = longString;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'response' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(response=");
                sb.append(this.response);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.SecureOk
            public LongString getResponse() {
                return this.response;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 21;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.secure-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeLongstr(this.response);
            }

            public SecureOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readLongstr());
            }
        }

        public static class Tune extends Method implements AMQP.Connection.Tune {
            public static final int INDEX = 30;
            private final int channelMax;
            private final int frameMax;
            private final int heartbeat;

            public Tune(int i, int i2, int i3) {
                this.channelMax = i;
                this.frameMax = i2;
                this.heartbeat = i3;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(channel-max=");
                sb.append(this.channelMax);
                sb.append(", frame-max=");
                sb.append(this.frameMax);
                sb.append(", heartbeat=");
                sb.append(this.heartbeat);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Tune
            public int getChannelMax() {
                return this.channelMax;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Tune
            public int getFrameMax() {
                return this.frameMax;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Tune
            public int getHeartbeat() {
                return this.heartbeat;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 30;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.tune";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.channelMax);
                methodArgumentWriter.writeLong(this.frameMax);
                methodArgumentWriter.writeShort(this.heartbeat);
            }

            public Tune(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readLong(), methodArgumentReader.readShort());
            }
        }

        public static class TuneOk extends Method implements AMQP.Connection.TuneOk {
            public static final int INDEX = 31;
            private final int channelMax;
            private final int frameMax;
            private final int heartbeat;

            public TuneOk(int i, int i2, int i3) {
                this.channelMax = i;
                this.frameMax = i2;
                this.heartbeat = i3;
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(channel-max=");
                sb.append(this.channelMax);
                sb.append(", frame-max=");
                sb.append(this.frameMax);
                sb.append(", heartbeat=");
                sb.append(this.heartbeat);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.TuneOk
            public int getChannelMax() {
                return this.channelMax;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.TuneOk
            public int getFrameMax() {
                return this.frameMax;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.TuneOk
            public int getHeartbeat() {
                return this.heartbeat;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 31;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.tune-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.channelMax);
                methodArgumentWriter.writeLong(this.frameMax);
                methodArgumentWriter.writeShort(this.heartbeat);
            }

            public TuneOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readLong(), methodArgumentReader.readShort());
            }
        }

        public static class Close extends Method implements AMQP.Connection.Close {
            public static final int INDEX = 50;
            private final int classId;
            private final int methodId;
            private final int replyCode;
            private final String replyText;

            public Close(int i, String str, int i2, int i3) {
                if (str != null) {
                    this.replyCode = i;
                    this.replyText = str;
                    this.classId = i2;
                    this.methodId = i3;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'replyText' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(reply-code=");
                sb.append(this.replyCode);
                sb.append(", reply-text=");
                sb.append(this.replyText);
                sb.append(", class-id=");
                sb.append(this.classId);
                sb.append(", method-id=");
                sb.append(this.methodId);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Close
            public int getClassId() {
                return this.classId;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Close
            public int getMethodId() {
                return this.methodId;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Close
            public int getReplyCode() {
                return this.replyCode;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Close
            public String getReplyText() {
                return this.replyText;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 50;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.close";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.replyCode);
                methodArgumentWriter.writeShortstr(this.replyText);
                methodArgumentWriter.writeShort(this.classId);
                methodArgumentWriter.writeShort(this.methodId);
            }

            public Close(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShort(), methodArgumentReader.readShort());
            }
        }

        public static class Open extends Method implements AMQP.Connection.Open {
            public static final int INDEX = 40;
            private final String capabilities;
            private final boolean insist;
            private final String virtualHost;

            public Open(String str, String str2, boolean z) {
                if (str2 == null) {
                    throw new IllegalStateException("Invalid configuration: 'capabilities' must be non-null.");
                } else if (str != null) {
                    this.virtualHost = str;
                    this.capabilities = str2;
                    this.insist = z;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'virtualHost' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(virtual-host=");
                sb.append(this.virtualHost);
                sb.append(", capabilities=");
                sb.append(this.capabilities);
                sb.append(", insist=");
                sb.append(this.insist);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Open
            public String getCapabilities() {
                return this.capabilities;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Open
            public boolean getInsist() {
                return this.insist;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Open
            public String getVirtualHost() {
                return this.virtualHost;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.open";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShortstr(this.virtualHost);
                methodArgumentWriter.writeShortstr(this.capabilities);
                methodArgumentWriter.writeBit(this.insist);
            }

            public Open(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit());
            }
        }

        public static class Start extends Method implements AMQP.Connection.Start {
            public static final int INDEX = 10;
            private final LongString locales;
            private final LongString mechanisms;
            private final Map<String, Object> serverProperties;
            private final int versionMajor;
            private final int versionMinor;

            public Start(int i, int i2, Map<String, Object> map, LongString longString, LongString longString2) {
                Map<String, Object> map2;
                if (longString2 == null) {
                    throw new IllegalStateException("Invalid configuration: 'locales' must be non-null.");
                } else if (longString != null) {
                    this.versionMajor = i;
                    this.versionMinor = i2;
                    if (map == null) {
                        map2 = null;
                    } else {
                        map2 = Collections.unmodifiableMap(new HashMap(map));
                    }
                    this.serverProperties = map2;
                    this.mechanisms = longString;
                    this.locales = longString2;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'mechanisms' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(version-major=");
                sb.append(this.versionMajor);
                sb.append(", version-minor=");
                sb.append(this.versionMinor);
                sb.append(", server-properties=");
                sb.append(this.serverProperties);
                sb.append(", mechanisms=");
                sb.append(this.mechanisms);
                sb.append(", locales=");
                sb.append(this.locales);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Start
            public LongString getLocales() {
                return this.locales;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Start
            public LongString getMechanisms() {
                return this.mechanisms;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Start
            public Map<String, Object> getServerProperties() {
                return this.serverProperties;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Start
            public int getVersionMajor() {
                return this.versionMajor;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.Start
            public int getVersionMinor() {
                return this.versionMinor;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.start";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeOctet(this.versionMajor);
                methodArgumentWriter.writeOctet(this.versionMinor);
                methodArgumentWriter.writeTable(this.serverProperties);
                methodArgumentWriter.writeLongstr(this.mechanisms);
                methodArgumentWriter.writeLongstr(this.locales);
            }

            public Start(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readOctet(), methodArgumentReader.readOctet(), methodArgumentReader.readTable(), methodArgumentReader.readLongstr(), methodArgumentReader.readLongstr());
            }
        }

        public static class StartOk extends Method implements AMQP.Connection.StartOk {
            public static final int INDEX = 11;
            private final Map<String, Object> clientProperties;
            private final String locale;
            private final String mechanism;
            private final LongString response;

            public StartOk(Map<String, Object> map, String str, LongString longString, String str2) {
                Map<String, Object> map2;
                if (str2 == null) {
                    throw new IllegalStateException("Invalid configuration: 'locale' must be non-null.");
                } else if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'mechanism' must be non-null.");
                } else if (longString != null) {
                    if (map == null) {
                        map2 = null;
                    } else {
                        map2 = Collections.unmodifiableMap(new HashMap(map));
                    }
                    this.clientProperties = map2;
                    this.mechanism = str;
                    this.response = longString;
                    this.locale = str2;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'response' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(client-properties=");
                sb.append(this.clientProperties);
                sb.append(", mechanism=");
                sb.append(this.mechanism);
                sb.append(", response=");
                sb.append(this.response);
                sb.append(", locale=");
                sb.append(this.locale);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Connection.StartOk
            public Map<String, Object> getClientProperties() {
                return this.clientProperties;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.StartOk
            public String getLocale() {
                return this.locale;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.StartOk
            public String getMechanism() {
                return this.mechanism;
            }

            @Override // com.rabbitmq.client.AMQP.Connection.StartOk
            public LongString getResponse() {
                return this.response;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 11;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "connection.start-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeTable(this.clientProperties);
                methodArgumentWriter.writeShortstr(this.mechanism);
                methodArgumentWriter.writeLongstr(this.response);
                methodArgumentWriter.writeShortstr(this.locale);
            }

            public StartOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readTable(), methodArgumentReader.readShortstr(), methodArgumentReader.readLongstr(), methodArgumentReader.readShortstr());
            }
        }
    }

    public static class Exchange {
        public static final int INDEX = 40;

        public static class BindOk extends Method implements AMQP.Exchange.BindOk {
            public static final int INDEX = 31;

            public BindOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 31;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "exchange.bind-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public BindOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class DeclareOk extends Method implements AMQP.Exchange.DeclareOk {
            public static final int INDEX = 11;

            public DeclareOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 11;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "exchange.declare-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public DeclareOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class DeleteOk extends Method implements AMQP.Exchange.DeleteOk {
            public static final int INDEX = 21;

            public DeleteOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 21;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "exchange.delete-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public DeleteOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class UnbindOk extends Method implements AMQP.Exchange.UnbindOk {
            public static final int INDEX = 51;

            public UnbindOk() {
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("()");
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 51;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "exchange.unbind-ok";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
            }

            public UnbindOk(MethodArgumentReader methodArgumentReader) throws IOException {
                this();
            }
        }

        public static class Delete extends Method implements AMQP.Exchange.Delete {
            public static final int INDEX = 20;
            private final String exchange;
            private final boolean ifUnused;
            private final boolean nowait;
            private final int ticket;

            public Delete(int i, String str, boolean z, boolean z2) {
                if (str != null) {
                    this.ticket = i;
                    this.exchange = str;
                    this.ifUnused = z;
                    this.nowait = z2;
                    return;
                }
                throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", exchange=");
                sb.append(this.exchange);
                sb.append(", if-unused=");
                sb.append(this.ifUnused);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Delete
            public String getExchange() {
                return this.exchange;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Delete
            public boolean getIfUnused() {
                return this.ifUnused;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Delete
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Delete
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 20;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "exchange.delete";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.exchange);
                methodArgumentWriter.writeBit(this.ifUnused);
                methodArgumentWriter.writeBit(this.nowait);
            }

            public Delete(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readBit());
            }
        }

        public static class Bind extends Method implements AMQP.Exchange.Bind {
            public static final int INDEX = 30;
            private final Map<String, Object> arguments;
            private final String destination;
            private final boolean nowait;
            private final String routingKey;
            private final String source;
            private final int ticket;

            public Bind(int i, String str, String str2, String str3, boolean z, Map<String, Object> map) {
                Map<String, Object> map2;
                if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'destination' must be non-null.");
                } else if (str3 == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else if (str2 != null) {
                    this.ticket = i;
                    this.destination = str;
                    this.source = str2;
                    this.routingKey = str3;
                    this.nowait = z;
                    if (map == null) {
                        map2 = null;
                    } else {
                        map2 = Collections.unmodifiableMap(new HashMap(map));
                    }
                    this.arguments = map2;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'source' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", destination=");
                sb.append(this.destination);
                sb.append(", source=");
                sb.append(this.source);
                sb.append(", routing-key=");
                sb.append(this.routingKey);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(", arguments=");
                sb.append(this.arguments);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Bind
            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Bind
            public String getDestination() {
                return this.destination;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Bind
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Bind
            public String getRoutingKey() {
                return this.routingKey;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Bind
            public String getSource() {
                return this.source;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Bind
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 30;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "exchange.bind";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.destination);
                methodArgumentWriter.writeShortstr(this.source);
                methodArgumentWriter.writeShortstr(this.routingKey);
                methodArgumentWriter.writeBit(this.nowait);
                methodArgumentWriter.writeTable(this.arguments);
            }

            public Bind(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readTable());
            }
        }

        public static class Unbind extends Method implements AMQP.Exchange.Unbind {
            public static final int INDEX = 40;
            private final Map<String, Object> arguments;
            private final String destination;
            private final boolean nowait;
            private final String routingKey;
            private final String source;
            private final int ticket;

            public Unbind(int i, String str, String str2, String str3, boolean z, Map<String, Object> map) {
                Map<String, Object> map2;
                if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'destination' must be non-null.");
                } else if (str3 == null) {
                    throw new IllegalStateException("Invalid configuration: 'routingKey' must be non-null.");
                } else if (str2 != null) {
                    this.ticket = i;
                    this.destination = str;
                    this.source = str2;
                    this.routingKey = str3;
                    this.nowait = z;
                    if (map == null) {
                        map2 = null;
                    } else {
                        map2 = Collections.unmodifiableMap(new HashMap(map));
                    }
                    this.arguments = map2;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'source' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", destination=");
                sb.append(this.destination);
                sb.append(", source=");
                sb.append(this.source);
                sb.append(", routing-key=");
                sb.append(this.routingKey);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(", arguments=");
                sb.append(this.arguments);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Unbind
            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Unbind
            public String getDestination() {
                return this.destination;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Unbind
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Unbind
            public String getRoutingKey() {
                return this.routingKey;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Unbind
            public String getSource() {
                return this.source;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Unbind
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "exchange.unbind";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.destination);
                methodArgumentWriter.writeShortstr(this.source);
                methodArgumentWriter.writeShortstr(this.routingKey);
                methodArgumentWriter.writeBit(this.nowait);
                methodArgumentWriter.writeTable(this.arguments);
            }

            public Unbind(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readTable());
            }
        }

        public static class Declare extends Method implements AMQP.Exchange.Declare {
            public static final int INDEX = 10;
            private final Map<String, Object> arguments;
            private final boolean autoDelete;
            private final boolean durable;
            private final String exchange;
            private final boolean internal;
            private final boolean nowait;
            private final boolean passive;
            private final int ticket;
            private final String type;

            public Declare(int i, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Map<String, Object> map) {
                Map<String, Object> map2;
                if (str == null) {
                    throw new IllegalStateException("Invalid configuration: 'exchange' must be non-null.");
                } else if (str2 != null) {
                    this.ticket = i;
                    this.exchange = str;
                    this.type = str2;
                    this.passive = z;
                    this.durable = z2;
                    this.autoDelete = z3;
                    this.internal = z4;
                    this.nowait = z5;
                    if (map == null) {
                        map2 = null;
                    } else {
                        map2 = Collections.unmodifiableMap(new HashMap(map));
                    }
                    this.arguments = map2;
                } else {
                    throw new IllegalStateException("Invalid configuration: 'type' must be non-null.");
                }
            }

            @Override // com.rabbitmq.client.impl.Method
            public void appendArgumentDebugStringTo(StringBuilder sb) {
                sb.append("(ticket=");
                sb.append(this.ticket);
                sb.append(", exchange=");
                sb.append(this.exchange);
                sb.append(", type=");
                sb.append(this.type);
                sb.append(", passive=");
                sb.append(this.passive);
                sb.append(", durable=");
                sb.append(this.durable);
                sb.append(", auto-delete=");
                sb.append(this.autoDelete);
                sb.append(", internal=");
                sb.append(this.internal);
                sb.append(", nowait=");
                sb.append(this.nowait);
                sb.append(", arguments=");
                sb.append(this.arguments);
                sb.append(")");
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Declare
            public Map<String, Object> getArguments() {
                return this.arguments;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Declare
            public boolean getAutoDelete() {
                return this.autoDelete;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Declare
            public boolean getDurable() {
                return this.durable;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Declare
            public String getExchange() {
                return this.exchange;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Declare
            public boolean getInternal() {
                return this.internal;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Declare
            public boolean getNowait() {
                return this.nowait;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Declare
            public boolean getPassive() {
                return this.passive;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Declare
            public int getTicket() {
                return this.ticket;
            }

            @Override // com.rabbitmq.client.AMQP.Exchange.Declare
            public String getType() {
                return this.type;
            }

            @Override // com.rabbitmq.client.impl.Method
            public boolean hasContent() {
                return false;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolClassId() {
                return 40;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public int protocolMethodId() {
                return 10;
            }

            @Override // com.rabbitmq.client.impl.Method, com.rabbitmq.client.Method
            public String protocolMethodName() {
                return "exchange.declare";
            }

            @Override // com.rabbitmq.client.impl.Method
            public Object visit(MethodVisitor methodVisitor) throws IOException {
                return methodVisitor.visit(this);
            }

            @Override // com.rabbitmq.client.impl.Method
            public void writeArgumentsTo(MethodArgumentWriter methodArgumentWriter) throws IOException {
                methodArgumentWriter.writeShort(this.ticket);
                methodArgumentWriter.writeShortstr(this.exchange);
                methodArgumentWriter.writeShortstr(this.type);
                methodArgumentWriter.writeBit(this.passive);
                methodArgumentWriter.writeBit(this.durable);
                methodArgumentWriter.writeBit(this.autoDelete);
                methodArgumentWriter.writeBit(this.internal);
                methodArgumentWriter.writeBit(this.nowait);
                methodArgumentWriter.writeTable(this.arguments);
            }

            public Declare(MethodArgumentReader methodArgumentReader) throws IOException {
                this(methodArgumentReader.readShort(), methodArgumentReader.readShortstr(), methodArgumentReader.readShortstr(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readBit(), methodArgumentReader.readTable());
            }
        }
    }
}
