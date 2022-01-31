package com.rabbitmq.client;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.utility.Utility;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueingConsumer extends DefaultConsumer {
    private static final Delivery POISON = new Delivery(null, null, null);
    private volatile ConsumerCancelledException _cancelled;
    private final BlockingQueue<Delivery> _queue;
    private volatile ShutdownSignalException _shutdown;

    public static class Delivery {
        private final byte[] _body;
        private final Envelope _envelope;
        private final AMQP.BasicProperties _properties;

        public Delivery(Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bArr) {
            this._envelope = envelope;
            this._properties = basicProperties;
            this._body = bArr;
        }

        public byte[] getBody() {
            return this._body;
        }

        public Envelope getEnvelope() {
            return this._envelope;
        }

        public AMQP.BasicProperties getProperties() {
            return this._properties;
        }
    }

    public QueueingConsumer(Channel channel) {
        this(channel, new LinkedBlockingQueue());
    }

    private void checkShutdown() {
        if (this._shutdown != null) {
            throw ((ShutdownSignalException) Utility.fixStackTrace(this._shutdown));
        }
    }

    private Delivery handle(Delivery delivery) {
        Delivery delivery2 = POISON;
        if (delivery == delivery2 || (delivery == null && !(this._shutdown == null && this._cancelled == null))) {
            if (delivery == delivery2) {
                this._queue.add(delivery2);
                if (this._shutdown == null && this._cancelled == null) {
                    throw new IllegalStateException("POISON in queue, but null _shutdown and null _cancelled. This should never happen, please report as a BUG");
                }
            }
            if (this._shutdown != null) {
                throw ((ShutdownSignalException) Utility.fixStackTrace(this._shutdown));
            } else if (this._cancelled != null) {
                throw ((ConsumerCancelledException) Utility.fixStackTrace(this._cancelled));
            }
        }
        return delivery;
    }

    @Override // com.rabbitmq.client.DefaultConsumer, com.rabbitmq.client.Consumer
    public void handleCancel(String str) throws IOException {
        this._cancelled = new ConsumerCancelledException();
        this._queue.add(POISON);
    }

    @Override // com.rabbitmq.client.DefaultConsumer, com.rabbitmq.client.Consumer
    public void handleDelivery(String str, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
        checkShutdown();
        this._queue.add(new Delivery(envelope, basicProperties, bArr));
    }

    @Override // com.rabbitmq.client.DefaultConsumer, com.rabbitmq.client.Consumer
    public void handleShutdownSignal(String str, ShutdownSignalException shutdownSignalException) {
        this._shutdown = shutdownSignalException;
        this._queue.add(POISON);
    }

    public Delivery nextDelivery() throws InterruptedException, ShutdownSignalException, ConsumerCancelledException {
        return handle(this._queue.take());
    }

    public QueueingConsumer(Channel channel, BlockingQueue<Delivery> blockingQueue) {
        super(channel);
        this._queue = blockingQueue;
    }

    public Delivery nextDelivery(long j) throws InterruptedException, ShutdownSignalException, ConsumerCancelledException {
        return handle(this._queue.poll(j, TimeUnit.MILLISECONDS));
    }
}
