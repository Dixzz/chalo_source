package com.rabbitmq.client;

public class Envelope {
    private final long _deliveryTag;
    private final String _exchange;
    private final boolean _redeliver;
    private final String _routingKey;

    public Envelope(long j, boolean z, String str, String str2) {
        this._deliveryTag = j;
        this._redeliver = z;
        this._exchange = str;
        this._routingKey = str2;
    }

    public long getDeliveryTag() {
        return this._deliveryTag;
    }

    public String getExchange() {
        return this._exchange;
    }

    public String getRoutingKey() {
        return this._routingKey;
    }

    public boolean isRedeliver() {
        return this._redeliver;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Envelope(deliveryTag=");
        i0.append(this._deliveryTag);
        i0.append(", redeliver=");
        i0.append(this._redeliver);
        i0.append(", exchange=");
        i0.append(this._exchange);
        i0.append(", routingKey=");
        return hj1.a0(i0, this._routingKey, ")");
    }
}
