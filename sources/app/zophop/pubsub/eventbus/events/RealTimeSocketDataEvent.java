package app.zophop.pubsub.eventbus.events;

import org.json.JSONException;
import org.json.JSONObject;

public class RealTimeSocketDataEvent {
    private static final String KEY_REFERENCE = "ref";
    private static final String KEY_REQUEST_ID = "requestId";
    private static final String KEY_RESULT = "res";
    public String data;
    public String referenceType;
    public int requestId;

    public RealTimeSocketDataEvent(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.referenceType = jSONObject.getString(KEY_REFERENCE);
            this.data = jSONObject.getString(KEY_RESULT);
            this.requestId = jSONObject.optInt(KEY_REQUEST_ID, -1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getData() {
        return this.data;
    }

    public String getReferenceType() {
        return this.referenceType;
    }

    public int getRequestId() {
        return this.requestId;
    }
}
