package server.zophop;

import com.firebase.client.Firebase;
import com.google.common.eventbus.EventBus;
import java.util.concurrent.CountDownLatch;
import server.zophop.logicLayer.CsLogic;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.Queue;
import server.zophop.queue.QueueConsumer;
import server.zophop.queue.RabbitMQ;
import server.zophop.queue.RabbitMQQueueConsumer;

public class CrowdSourceStreamMain {
    public static void main(String[] strArr) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        startRabbitMQConsumer();
        try {
            countDownLatch.await();
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
    }

    private static void startConsumer(Firebase firebase2) {
        try {
            Thread.sleep(500);
            EventBus eventBus = new EventBus();
            QueueConsumer queueConsumer = new QueueConsumer(firebase2, 5);
            ApplicationFeature applicationFeature = new ApplicationFeature(new Queue(firebase2), new CsLogic());
            eventBus.register(applicationFeature);
            queueConsumer.startListening(eventBus, applicationFeature);
        } catch (InterruptedException e) {
            SimpleLogger.logException(e);
        }
    }

    private static void startRabbitMQConsumer() {
        try {
            Thread.sleep(1000);
            RabbitMQQueueConsumer rabbitMQQueueConsumer = new RabbitMQQueueConsumer(50);
            rabbitMQQueueConsumer.queue = "appengine_stream";
            System.out.println("appengine_stream".toString());
            RabbitMQ rabbitMQ = new RabbitMQ(4, Constants.getExchange(), TaskCategory.APPLICATION);
            if (rabbitMQQueueConsumer.init() && rabbitMQ.init()) {
                rabbitMQQueueConsumer.startListening(new EventBus(), new ApplicationFeature(rabbitMQ, new CsLogic()));
            }
        } catch (InterruptedException e) {
            SimpleLogger.logException(e);
        }
    }
}
