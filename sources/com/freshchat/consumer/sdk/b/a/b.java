package com.freshchat.consumer.sdk.b.a;

import android.annotation.TargetApi;
import android.util.JsonReader;
import android.util.JsonToken;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import com.rabbitmq.client.StringRpcServer;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(11)
public class b {
    private JsonReader dZ;
    private Object ea;

    public b(InputStream inputStream) {
        try {
            this.dZ = new JsonReader(new InputStreamReader(inputStream, StringRpcServer.STRING_ENCODING));
        } catch (UnsupportedEncodingException e) {
            ai.e("FRESHCHAT", "Exception occured", e);
        }
    }

    private JSONArray a(JsonReader jsonReader) {
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                jSONArray.put(b(jsonReader));
            }
            jsonReader.endArray();
        } catch (IOException e) {
            ai.e("FRESHCHAT", "Exception occured", e);
        }
        return jSONArray;
    }

    private Object b(JsonReader jsonReader) {
        try {
            JsonToken peek = jsonReader.peek();
            if (JsonToken.BEGIN_ARRAY.equals(peek)) {
                return a(jsonReader);
            }
            if (JsonToken.BEGIN_OBJECT.equals(peek)) {
                return c(jsonReader);
            }
            if (JsonToken.BOOLEAN.equals(peek)) {
                return Boolean.valueOf(jsonReader.nextBoolean());
            }
            if (JsonToken.NUMBER.equals(peek)) {
                return Long.valueOf(jsonReader.nextLong());
            }
            if (JsonToken.STRING.equals(peek)) {
                return jsonReader.nextString();
            }
            if (JsonToken.NULL.equals(peek)) {
                jsonReader.nextNull();
                return null;
            }
            return null;
        } catch (IOException e) {
            ai.e("FRESHCHAT", "Exception occured", e);
        }
    }

    private JSONObject c(JsonReader jsonReader) {
        JSONObject jSONObject = new JSONObject();
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                jSONObject.put(jsonReader.nextName(), b(jsonReader));
            }
            jsonReader.endObject();
        } catch (IOException | JSONException e) {
            ai.e("FRESHCHAT", "Exception occured", e);
        }
        return jSONObject;
    }

    public Object co() {
        JsonReader jsonReader;
        if (this.ea == null && (jsonReader = this.dZ) != null) {
            this.ea = b(jsonReader);
            try {
                this.dZ.close();
            } catch (IOException e) {
                q.a(e);
            }
        }
        return this.ea;
    }
}
