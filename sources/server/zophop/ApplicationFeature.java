package server.zophop;

import com.google.common.eventbus.Subscribe;
import java.util.Map;
import server.zophop.gpsIntegration.LiveDataHandler;
import server.zophop.logicLayer.CsLogic;
import server.zophop.queue.IQueue;
import server.zophop.queue.ITaskHandler;
import server.zophop.queue.RabbitMQ;
import server.zophop.queue.TaskEvent;

public class ApplicationFeature implements ITaskHandler {
    private CsLogic _csLogic;
    private LiveDataHandler _handler = new LiveDataHandler(this._queue, this._csLogic.getContainer());
    private MobileTicketing _mobileTicketing = new MobileTicketing();
    private IQueue _queue;
    private RabbitMQ _rabbitMQLogger;

    public ApplicationFeature(IQueue iQueue, CsLogic csLogic) {
        this._queue = iQueue;
        this._csLogic = csLogic;
        RabbitMQ rabbitMQ = new RabbitMQ(1, Constants.getExchange(), TaskCategory.LOGGING);
        this._rabbitMQLogger = rabbitMQ;
        rabbitMQ.init();
    }

    private String getString(Map map, String str, String str2) {
        return map.containsKey(str2) ? (String) map.get(str2) : str;
    }

    @Subscribe
    public void taskReceived(TaskEvent taskEvent) {
        taskReceived(taskEvent.getQueueConsumer(), taskEvent.getTask(), taskEvent.getTaskMeta());
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x03c9  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0438 A[Catch:{ Exception -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x044d A[Catch:{ Exception -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0457 A[Catch:{ Exception -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0460 A[Catch:{ Exception -> 0x0472 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0485 A[SYNTHETIC, Splitter:B:122:0x0485] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x04b8  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x04e4 A[Catch:{ Exception -> 0x064b }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x04f2 A[Catch:{ Exception -> 0x064b }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x04fd A[Catch:{ Exception -> 0x064b }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0549 A[Catch:{ Exception -> 0x0646 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0572 A[SYNTHETIC, Splitter:B:153:0x0572] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x05f6 A[Catch:{ Exception -> 0x063a }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b0 A[SYNTHETIC, Splitter:B:23:0x00b0] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0298 A[SYNTHETIC, Splitter:B:67:0x0298] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x02fe A[SYNTHETIC, Splitter:B:73:0x02fe] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0339 A[SYNTHETIC, Splitter:B:82:0x0339] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x037e A[SYNTHETIC, Splitter:B:91:0x037e] */
    @Override // server.zophop.queue.ITaskHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void taskReceived(server.zophop.queue.IQueueConsumer r39, server.zophop.queue.BasicTask r40, server.zophop.queue.TaskMeta r41) {
        /*
        // Method dump skipped, instructions count: 1624
        */
        throw new UnsupportedOperationException("Method not decompiled: server.zophop.ApplicationFeature.taskReceived(server.zophop.queue.IQueueConsumer, server.zophop.queue.BasicTask, server.zophop.queue.TaskMeta):void");
    }
}
