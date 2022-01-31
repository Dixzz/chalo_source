package server.zophop.models;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import org.json.JSONObject;

public class Formatter extends java.util.logging.Formatter {
    public String format(LogRecord logRecord) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("class", logRecord.getSourceClassName());
        jSONObject.put("severity", logRecord.getLevel());
        jSONObject.put("message", formatMessage(logRecord));
        jSONObject.put("method", logRecord.getSourceMethodName());
        return jSONObject.toString() + "\n";
    }

    public String getHead(Handler handler) {
        return super.getHead(handler);
    }

    public String getTail(Handler handler) {
        return super.getTail(handler);
    }
}
