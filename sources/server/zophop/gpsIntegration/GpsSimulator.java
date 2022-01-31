package server.zophop.gpsIntegration;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.List;
import server.zophop.Constants;
import server.zophop.GpsAnalytics.ConfigSettings;
import server.zophop.GpsAnalytics.ElasticGpsFetcher;
import server.zophop.TaskCategory;
import server.zophop.logging.LoggingConstants;
import server.zophop.logicLayer.CsLogic;
import server.zophop.models.Point;
import server.zophop.queue.RabbitMQ;

public class GpsSimulator {
    public static void main(String[] strArr) throws UnirestException {
        RabbitMQ rabbitMQ = new RabbitMQ(4, Constants.getExchange(), TaskCategory.APPLICATION);
        rabbitMQ.init();
        LiveDataHandler liveDataHandler = new LiveDataHandler(rabbitMQ, new CsLogic().getContainer());
        ConfigSettings configSettings = new ConfigSettings();
        ElasticGpsFetcher elasticGpsFetcher = new ElasticGpsFetcher();
        for (Point point : (List) elasticGpsFetcher.parse((Object) elasticGpsFetcher.fetch("bhopal", "bcll", "bus", "MP 04 PA 3864", configSettings))) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            liveDataHandler.receivedPoint("bhopal", "bus", "bcll", "MP 04 PA 3864", "1234", point, LoggingConstants.OPERATOR, System.currentTimeMillis());
        }
    }
}
