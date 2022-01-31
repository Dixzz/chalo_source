package server.zophop.queue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import server.zophop.TaskCategory;
import server.zophop.TaskType;
import server.zophop.models.SimpleLogger;

public class RabbitMQ implements IQueue<RabbitMqTaskMeta> {
    public static final String DEFAULT_EXCHANGE = "";
    private List<Channel> _channels;
    private int _concurrency;
    private Connection _connection;
    private final TaskCategory _defaultCategory;
    private final String _exchange;
    private ConnectionHandler _handler = new ConnectionHandler();
    private final String _queueName;
    private final boolean _useQueue;

    public RabbitMQ(int i, String str) {
        this._concurrency = i;
        this._channels = new ArrayList();
        this._useQueue = true;
        this._queueName = str;
        this._exchange = "";
        this._defaultCategory = TaskCategory.APPLICATION;
    }

    private void addTaskWithRoutingKey(BasicTask basicTask, String str) {
        try {
            String taskJson = RabbitMqTaskConvertor.getTaskJson(basicTask);
            SimpleLogger.debug("pushed to queue " + taskJson);
            this._channels.get(0).basicPublish(this._exchange, str, null, taskJson.getBytes());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            SimpleLogger.severe("task add failed " + e.getMessage());
            SimpleLogger.logException(e);
        }
    }

    private void initChannel() throws IOException {
        this._channels.add(this._connection.createChannel());
    }

    private String makeRoutingKey(TaskCategory taskCategory, TaskType taskType) {
        if (this._useQueue) {
            return this._queueName;
        }
        return taskCategory.name().toLowerCase() + "." + taskType.name().toLowerCase();
    }

    @Override // server.zophop.queue.IQueue
    public String addTask(BasicTask basicTask) {
        addTaskWithRoutingKey(basicTask, makeRoutingKey(this._defaultCategory, basicTask.getType()));
        return null;
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
            } catch (IOException e) {
                SimpleLogger.logException(e);
                return false;
            }
        }
        return true;
    }

    public void resetTask(RabbitMqTaskMeta rabbitMqTaskMeta) {
    }

    public void updateTask(RabbitMqTaskMeta rabbitMqTaskMeta, BasicTask basicTask) {
    }

    public void removeTask(RabbitMqTaskMeta rabbitMqTaskMeta) {
        try {
            this._channels.get(0).basicReject(rabbitMqTaskMeta.getEnvelope().getDeliveryTag(), false);
        } catch (IOException e) {
            SimpleLogger.logException(e);
        }
    }

    @Override // server.zophop.queue.IQueue
    public String addTask(TaskCategory taskCategory, BasicTask basicTask) {
        addTaskWithRoutingKey(basicTask, makeRoutingKey(taskCategory, basicTask.getType()));
        return null;
    }

    public RabbitMQ(int i, String str, TaskCategory taskCategory) {
        this._concurrency = i;
        this._channels = new ArrayList();
        this._useQueue = false;
        this._exchange = str;
        this._defaultCategory = taskCategory;
        this._queueName = "";
    }
}
