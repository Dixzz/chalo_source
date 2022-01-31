package server.zophop.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Envelope;

public class RabbitMqTaskMeta extends TaskMeta {
    private Channel _channel;
    private String _consumerTag;
    private Envelope _envelope;

    public RabbitMqTaskMeta(Channel channel, Envelope envelope, String str) {
        this._channel = channel;
        this._envelope = envelope;
        this._consumerTag = str;
    }

    public Channel getChannel() {
        return this._channel;
    }

    public String getConsumerTag() {
        return this._consumerTag;
    }

    public Envelope getEnvelope() {
        return this._envelope;
    }
}
