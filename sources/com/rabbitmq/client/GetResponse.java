package com.rabbitmq.client;

import com.rabbitmq.client.AMQP;

public class GetResponse {
    private final byte[] body;
    private final Envelope envelope;
    private final int messageCount;
    private final AMQP.BasicProperties props;

    public GetResponse(Envelope envelope2, AMQP.BasicProperties basicProperties, byte[] bArr, int i) {
        this.envelope = envelope2;
        this.props = basicProperties;
        this.body = bArr;
        this.messageCount = i;
    }

    public byte[] getBody() {
        return this.body;
    }

    public Envelope getEnvelope() {
        return this.envelope;
    }

    public int getMessageCount() {
        return this.messageCount;
    }

    public AMQP.BasicProperties getProps() {
        return this.props;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("GetResponse(envelope=");
        i0.append(this.envelope);
        i0.append(", props=");
        i0.append(this.props);
        i0.append(", messageCount=");
        i0.append(this.messageCount);
        i0.append(", body=(elided, ");
        i0.append(this.body.length);
        i0.append(" bytes long)");
        i0.append(")");
        return i0.toString();
    }
}
