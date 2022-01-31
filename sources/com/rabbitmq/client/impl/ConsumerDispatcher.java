package com.rabbitmq.client.impl;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import com.rabbitmq.utility.Utility;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public final class ConsumerDispatcher {
    private final Channel channel;
    private final AMQConnection connection;
    private volatile CountDownLatch shutdownConsumersComplete;
    private volatile boolean shutdownConsumersDriven = false;
    private volatile ShutdownSignalException shutdownSignal = null;
    private volatile boolean shuttingDown = false;
    private final ConsumerWorkService workService;

    public ConsumerDispatcher(AMQConnection aMQConnection, Channel channel2, ConsumerWorkService consumerWorkService) {
        this.connection = aMQConnection;
        this.channel = channel2;
        consumerWorkService.registerKey(channel2);
        this.workService = consumerWorkService;
    }

    private void checkShutdown() {
        if (this.shutdownSignal != null) {
            throw ((ShutdownSignalException) Utility.fixStackTrace(this.shutdownSignal));
        }
    }

    private void execute(Runnable runnable) {
        checkShutdown();
        this.workService.addWork(this.channel, runnable);
    }

    private void executeUnlessShuttingDown(Runnable runnable) {
        if (!this.shuttingDown) {
            execute(runnable);
        }
    }

    private void notifyConsumerOfShutdown(String str, Consumer consumer, ShutdownSignalException shutdownSignalException) {
        try {
            consumer.handleShutdownSignal(str, shutdownSignalException);
        } catch (Throwable th) {
            this.connection.getExceptionHandler().handleConsumerException(this.channel, th, consumer, str, "handleShutdownSignal");
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void notifyConsumersOfShutdown(Map<String, Consumer> map, ShutdownSignalException shutdownSignalException) {
        for (Map.Entry<String, Consumer> entry : map.entrySet()) {
            notifyConsumerOfShutdown(entry.getKey(), entry.getValue(), shutdownSignalException);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void shutdown(ShutdownSignalException shutdownSignalException) {
        this.shutdownSignal = shutdownSignalException;
    }

    public void handleCancel(final Consumer consumer, final String str) {
        executeUnlessShuttingDown(new Runnable() {
            /* class com.rabbitmq.client.impl.ConsumerDispatcher.AnonymousClass3 */

            public void run() {
                try {
                    consumer.handleCancel(str);
                } catch (Throwable th) {
                    ConsumerDispatcher.this.connection.getExceptionHandler().handleConsumerException(ConsumerDispatcher.this.channel, th, consumer, str, "handleCancel");
                }
            }
        });
    }

    public void handleCancelOk(final Consumer consumer, final String str) {
        executeUnlessShuttingDown(new Runnable() {
            /* class com.rabbitmq.client.impl.ConsumerDispatcher.AnonymousClass2 */

            public void run() {
                try {
                    consumer.handleCancelOk(str);
                } catch (Throwable th) {
                    ConsumerDispatcher.this.connection.getExceptionHandler().handleConsumerException(ConsumerDispatcher.this.channel, th, consumer, str, "handleCancelOk");
                }
            }
        });
    }

    public void handleConsumeOk(final Consumer consumer, final String str) {
        executeUnlessShuttingDown(new Runnable() {
            /* class com.rabbitmq.client.impl.ConsumerDispatcher.AnonymousClass1 */

            public void run() {
                try {
                    consumer.handleConsumeOk(str);
                } catch (Throwable th) {
                    ConsumerDispatcher.this.connection.getExceptionHandler().handleConsumerException(ConsumerDispatcher.this.channel, th, consumer, str, "handleConsumeOk");
                }
            }
        });
    }

    public void handleDelivery(final Consumer consumer, final String str, final Envelope envelope, final AMQP.BasicProperties basicProperties, final byte[] bArr) throws IOException {
        executeUnlessShuttingDown(new Runnable() {
            /* class com.rabbitmq.client.impl.ConsumerDispatcher.AnonymousClass5 */

            public void run() {
                try {
                    consumer.handleDelivery(str, envelope, basicProperties, bArr);
                } catch (Throwable th) {
                    ConsumerDispatcher.this.connection.getExceptionHandler().handleConsumerException(ConsumerDispatcher.this.channel, th, consumer, str, "handleDelivery");
                }
            }
        });
    }

    public void handleRecoverOk(final Consumer consumer, final String str) {
        executeUnlessShuttingDown(new Runnable() {
            /* class com.rabbitmq.client.impl.ConsumerDispatcher.AnonymousClass4 */

            public void run() {
                consumer.handleRecoverOk(str);
            }
        });
    }

    public CountDownLatch handleShutdownSignal(final Map<String, Consumer> map, final ShutdownSignalException shutdownSignalException) {
        if (!this.shutdownConsumersDriven) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            this.shutdownConsumersComplete = countDownLatch;
            this.shutdownConsumersDriven = true;
            execute(new Runnable() {
                /* class com.rabbitmq.client.impl.ConsumerDispatcher.AnonymousClass6 */

                public void run() {
                    ConsumerDispatcher.this.notifyConsumersOfShutdown(map, shutdownSignalException);
                    ConsumerDispatcher.this.shutdown(shutdownSignalException);
                    ConsumerDispatcher.this.workService.stopWork(ConsumerDispatcher.this.channel);
                    countDownLatch.countDown();
                }
            });
        }
        return this.shutdownConsumersComplete;
    }

    public void quiesce() {
        this.shuttingDown = true;
    }

    public void setUnlimited(boolean z) {
        this.workService.setUnlimited(this.channel, z);
    }
}
