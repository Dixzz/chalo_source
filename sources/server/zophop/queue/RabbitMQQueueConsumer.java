package server.zophop.queue;

import com.google.common.eventbus.EventBus;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.StringRpcServer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import server.zophop.Constants;
import server.zophop.TaskCategory;
import server.zophop.models.SimpleLogger;

public class RabbitMQQueueConsumer implements IQueueConsumer<RabbitMqTaskMeta> {
    private List<Channel> _channels;
    private int _concurrency;
    private Connection _connection;
    private final TaskCategory _defaultCategory;
    private ConnectionHandler _handler = new ConnectionHandler();
    private ITaskHandler _taskHandler;
    public ExecutorService _threadPool;
    public String queue = Constants.PRODUCTION_APPLICATION;

    public RabbitMQQueueConsumer(int i) {
        this._concurrency = i;
        this._channels = new ArrayList();
        this._threadPool = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this._defaultCategory = TaskCategory.APPLICATION;
    }

    private void initChannel() throws IOException {
        this._channels.add(this._connection.createChannel());
    }

    private void start(final Channel channel) {
        final ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        AnonymousClass1 r1 = new DefaultConsumer(channel) {
            /* class server.zophop.queue.RabbitMQQueueConsumer.AnonymousClass1 */

            @Override // com.rabbitmq.client.DefaultConsumer, com.rabbitmq.client.Consumer
            public void handleDelivery(String str, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bArr) throws IOException {
                String str2 = new String(bArr, StringRpcServer.STRING_ENCODING);
                StringBuilder i0 = hj1.i0(" [x] Received '");
                i0.append(envelope.getDeliveryTag());
                i0.append(";");
                i0.append(str);
                i0.append(";");
                i0.append(str2);
                i0.append("'");
                SimpleLogger.info(i0.toString());
                try {
                    final BasicTask task = RabbitMqTaskConvertor.getTask(str2);
                    final RabbitMqTaskMeta rabbitMqTaskMeta = new RabbitMqTaskMeta(channel, envelope, str);
                    newFixedThreadPool.submit(new Runnable() {
                        /* class server.zophop.queue.RabbitMQQueueConsumer.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            RabbitMQQueueConsumer.this._taskHandler.taskReceived(RabbitMQQueueConsumer.this, task, rabbitMqTaskMeta);
                        }
                    });
                } catch (Exception e) {
                    RabbitMQQueueConsumer.this.rejectTask(channel, envelope.getDeliveryTag());
                    SimpleLogger.logException(e);
                }
            }
        };
        try {
            channel.basicQos(1);
            channel.basicConsume(this.queue, false, r1);
        } catch (IOException e) {
            SimpleLogger.logException(e);
        }
    }

    public boolean init() {
        Connection connect = this._handler.connect(this._defaultCategory);
        this._connection = connect;
        if (connect == null) {
            return true;
        }
        for (int i = 0; i < this._concurrency; i++) {
            try {
                initChannel();
            } catch (IOException unused) {
                return false;
            }
        }
        return true;
    }

    public void rejectTask(Channel channel, long j) {
        try {
            channel.basicReject(j, false);
        } catch (IOException e) {
            SimpleLogger.logException(e);
        }
    }

    public void removeTaskLocal(RabbitMqTaskMeta rabbitMqTaskMeta) {
    }

    @Override // server.zophop.queue.IQueueConsumer
    public void startListening(EventBus eventBus, ITaskHandler iTaskHandler) {
        this._taskHandler = iTaskHandler;
        for (Channel channel : this._channels) {
            start(channel);
        }
    }

    public void removeTask(RabbitMqTaskMeta rabbitMqTaskMeta) {
        try {
            rabbitMqTaskMeta.getChannel().basicReject(rabbitMqTaskMeta.getEnvelope().getDeliveryTag(), false);
        } catch (IOException e) {
            SimpleLogger.logException(e);
        }
    }

    public void taskFailure(RabbitMqTaskMeta rabbitMqTaskMeta, BasicTask basicTask) {
        try {
            rabbitMqTaskMeta.getChannel().basicNack(rabbitMqTaskMeta.getEnvelope().getDeliveryTag(), false, false);
            SimpleLogger.severe("task nacked " + rabbitMqTaskMeta.getEnvelope().getDeliveryTag() + ";" + rabbitMqTaskMeta.getConsumerTag());
        } catch (IOException e) {
            StringBuilder i0 = hj1.i0("task nacked failed ");
            i0.append(rabbitMqTaskMeta.getEnvelope().getDeliveryTag());
            i0.append(";");
            i0.append(rabbitMqTaskMeta.getConsumerTag());
            SimpleLogger.severe(i0.toString());
            SimpleLogger.logException(e);
        }
    }

    public void taskSuccess(RabbitMqTaskMeta rabbitMqTaskMeta, BasicTask basicTask) {
        try {
            rabbitMqTaskMeta.getChannel().basicAck(rabbitMqTaskMeta.getEnvelope().getDeliveryTag(), false);
            SimpleLogger.info("task acked " + rabbitMqTaskMeta.getEnvelope().getDeliveryTag() + ";" + rabbitMqTaskMeta.getConsumerTag());
        } catch (IOException e) {
            StringBuilder i0 = hj1.i0("task acked failed ");
            i0.append(rabbitMqTaskMeta.getEnvelope().getDeliveryTag());
            i0.append(";");
            i0.append(rabbitMqTaskMeta.getConsumerTag());
            SimpleLogger.severe(i0.toString());
            SimpleLogger.logException(e);
        }
    }

    public RabbitMQQueueConsumer(int i, TaskCategory taskCategory) {
        this._concurrency = i;
        this._channels = new ArrayList();
        this._threadPool = new ThreadPoolExecutor(10, 20, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        this._defaultCategory = taskCategory;
    }
}
