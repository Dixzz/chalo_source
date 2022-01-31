package server.zophop.gpsIntegration;

import server.zophop.Constants;
import server.zophop.TaskCategory;
import server.zophop.logicLayer.CsLogic;
import server.zophop.queue.RabbitMQ;

public class DispatchSimulator {
    public static void main(String[] strArr) {
        RabbitMQ rabbitMQ = new RabbitMQ(4, Constants.getExchange(), TaskCategory.APPLICATION);
        rabbitMQ.init();
        LiveDataHandler liveDataHandler = new LiveDataHandler(rabbitMQ, new CsLogic().getContainer());
        CsLogic csLogic = new CsLogic();
        long currentTimeMillis = System.currentTimeMillis();
        csLogic.getRoute("bhopal", "bus", "KDJoNrao");
        liveDataHandler.processCheckInwithRouteId("bhopal", "bus", "bcll", "MP 04 PA 3864", "KDJoNrao", currentTimeMillis, "simulated", "unkown", "");
    }
}
