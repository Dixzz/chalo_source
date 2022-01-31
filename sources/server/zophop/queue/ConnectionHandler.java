package server.zophop.queue;

import com.google.firebase.appindexing.Indexable;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;
import server.zophop.TaskCategory;
import server.zophop.models.SimpleLogger;

public class ConnectionHandler {
    public static String getUrl(TaskCategory taskCategory) {
        if (TaskCategory.LOGGING.equals(taskCategory)) {
            SimpleLogger.config("its production queue");
            return "";
        }
        if (taskCategory.equals(TaskCategory.ANALYTICS)) {
            SimpleLogger.config("its production queue");
        }
        return "";
    }

    public Connection connect(TaskCategory taskCategory) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Connection connection = null;
        try {
            connectionFactory.setUri(getUrl(taskCategory));
            connectionFactory.setConnectionTimeout(Indexable.MAX_BYTE_SIZE);
            connection = connectionFactory.newConnection();
            connectionFactory.setNetworkRecoveryInterval(10000);
            return connection;
        } catch (URISyntaxException e) {
            SimpleLogger.logException(e);
            return connection;
        } catch (NoSuchAlgorithmException e2) {
            SimpleLogger.logException(e2);
            return connection;
        } catch (KeyManagementException e3) {
            SimpleLogger.logException(e3);
            return connection;
        } catch (IOException e4) {
            SimpleLogger.logException(e4);
            return connection;
        } catch (TimeoutException e5) {
            e5.printStackTrace();
            return connection;
        }
    }
}
