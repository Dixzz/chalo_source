package server.zophop;

import com.google.common.eventbus.EventBus;
import java.util.concurrent.CountDownLatch;
import server.zophop.logicLayer.CsLogic;
import server.zophop.models.SimpleLogger;
import server.zophop.queue.RabbitMQ;
import server.zophop.queue.RabbitMQQueueConsumer;

public class CrowdSourceKolkataGpsMain {
    public static void main(String[] strArr) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        startRabbitMQConsumer();
        try {
            countDownLatch.await();
        } catch (Exception e) {
            SimpleLogger.logException(e);
        }
    }

    private static void startRabbitMQConsumer() {
        try {
            Thread.sleep(1000);
            RabbitMQQueueConsumer rabbitMQQueueConsumer = new RabbitMQQueueConsumer(10);
            rabbitMQQueueConsumer.queue = "kolkata_gps";
            System.out.println("kolkata_gps".toString());
            RabbitMQ rabbitMQ = new RabbitMQ(4, Constants.getExchange(), TaskCategory.APPLICATION);
            if (rabbitMQQueueConsumer.init() && rabbitMQ.init()) {
                rabbitMQQueueConsumer.startListening(new EventBus(), new ApplicationFeature(rabbitMQ, new CsLogic()));
            }
        } catch (InterruptedException e) {
            SimpleLogger.logException(e);
        }
    }
}
