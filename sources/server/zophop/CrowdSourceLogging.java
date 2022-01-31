package server.zophop;

import com.google.common.eventbus.EventBus;
import server.zophop.logging.ElasticHandler;
import server.zophop.logging.LoggingLogic;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.RabbitMQ;
import server.zophop.queue.RabbitMQQueueConsumer;

public class CrowdSourceLogging {
    public static void main(String[] strArr) {
        startLoggingConsumer();
    }

    public static void startLoggingConsumer() {
        try {
            Thread.sleep(1000);
            RabbitMQQueueConsumer rabbitMQQueueConsumer = new RabbitMQQueueConsumer(4, TaskCategory.LOGGING);
            rabbitMQQueueConsumer.queue = Constants.getLoggingRabbitUrl();
            RabbitMQ rabbitMQ = new RabbitMQ(1, Constants.getLoggingRabbitUrl());
            if (rabbitMQQueueConsumer.init() && rabbitMQ.init()) {
                rabbitMQQueueConsumer.startListening(new EventBus(), new LoggingFeature(new ElasticHandler(), new LoggingLogic()));
            }
        } catch (InterruptedException e) {
            SimpleLogger.logException(e);
        }
    }
}
