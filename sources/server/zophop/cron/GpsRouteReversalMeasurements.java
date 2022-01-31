package server.zophop.cron;

import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.List;
import server.zophop.Constants;
import server.zophop.GpsAnalytics.ConfigSettings;
import server.zophop.GpsAnalytics.ElasticGpsFetcher;
import server.zophop.TaskCategory;
import server.zophop.gpsIntegration.LiveDataHandler;
import server.zophop.logicLayer.CsLogic;
import server.zophop.models.Point;
import server.zophop.queue.RabbitMQ;

public class GpsRouteReversalMeasurements {
    public static void main(String[] strArr) throws UnirestException {
        ConfigSettings configSettings = new ConfigSettings();
        ElasticGpsFetcher elasticGpsFetcher = new ElasticGpsFetcher();
        RabbitMQ rabbitMQ = new RabbitMQ(4, Constants.getExchange(), TaskCategory.APPLICATION);
        rabbitMQ.init();
        LiveDataHandler liveDataHandler = new LiveDataHandler(rabbitMQ, new CsLogic().getContainer());
        for (Point point : (List) elasticGpsFetcher.parse((Object) elasticGpsFetcher.fetch("nagpur", "nmpl", "bus", "MH31CA6055", configSettings))) {
            System.out.println(point.getTime());
            liveDataHandler.receivedPoint("nagpur", "bus", "nmpl", "MH31CA6055", "1234", point, "as", point.getTime());
        }
    }
}
