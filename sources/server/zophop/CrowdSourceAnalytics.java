package server.zophop;

import com.google.common.eventbus.EventBus;
import server.zophop.analytics.PostgresHandler;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.RabbitMQ;
import server.zophop.queue.RabbitMQQueueConsumer;

public class CrowdSourceAnalytics {
    public static void main(String[] strArr) {
        startAnalyticsConsumer();
    }

    public static void startAnalyticsConsumer() {
        try {
            RabbitMQQueueConsumer rabbitMQQueueConsumer = new RabbitMQQueueConsumer(40);
            rabbitMQQueueConsumer.queue = "measure";
            RabbitMQ rabbitMQ = new RabbitMQ(1, Constants.getAnalyticsQueue());
            if (rabbitMQQueueConsumer.init() && rabbitMQ.init()) {
                rabbitMQQueueConsumer.startListening(new EventBus(), new AnalyticsFeature(new PostgresHandler()));
            }
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
    }
}
