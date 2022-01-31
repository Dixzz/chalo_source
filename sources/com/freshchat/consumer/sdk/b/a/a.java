package com.freshchat.consumer.sdk.b.a;

import com.freshchat.consumer.sdk.b.b;
import com.freshchat.consumer.sdk.j.ad;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aw;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static String dY = "JsonResponse";
    private JSONObject dW;
    private JSONArray dX;

    public a() {
    }

    public a(InputStream inputStream) {
        a(inputStream);
    }

    public a(String str) {
        Q(str);
    }

    private void Q(String str) {
        reset();
        if (str != null) {
            StringBuilder i0 = hj1.i0("{ \"");
            hj1.V0(i0, dY, "\":\t ", str, "}");
            try {
                Object obj = new JSONObject(i0.toString()).get(dY);
                if (obj instanceof JSONObject) {
                    this.dW = (JSONObject) obj;
                } else if (obj instanceof JSONArray) {
                    this.dX = (JSONArray) obj;
                } else {
                    String str2 = "Not an Valid one" + obj.getClass();
                }
            } catch (JSONException e) {
                ai.e("FRESHCHAT", "Exception occured", e);
            }
        }
    }

    private void a(InputStream inputStream) {
        reset();
        if (aw.eS()) {
            Object co = new b(inputStream).co();
            if (co instanceof JSONObject) {
                this.dW = (JSONObject) co;
            } else if (co instanceof JSONArray) {
                this.dX = (JSONArray) co;
            } else {
                String str = "Not an Valid one" + co;
            }
        } else {
            try {
                Q(ad.a(inputStream, b.da));
            } catch (IOException e) {
                ai.e("FRESHCHAT", "Exception occured", e);
            }
        }
    }

    private void reset() {
        this.dW = null;
        this.dX = null;
    }

    public JSONObject cm() {
        if (cn()) {
            return this.dW;
        }
        return null;
    }

    public boolean cn() {
        return this.dW != null;
    }

    public boolean db() {
        return cn() && !this.dW.optBoolean("success") && this.dW.optInt("errorCode") == 19;
    }

    public boolean fJ() {
        return cn() && !this.dW.optBoolean("success") && this.dW.optInt("errorCode") == 20;
    }

    public boolean isArray() {
        return this.dX != null;
    }

    public boolean isValid() {
        return (this.dW == null && this.dX == null) ? false : true;
    }

    public String toString() {
        String str;
        StringBuilder sb;
        if (cn()) {
            sb = hj1.i0("Object : ");
            str = this.dW.toString();
        } else if (!isArray()) {
            return null;
        } else {
            sb = hj1.i0("Array : ");
            str = this.dX.toString();
        }
        sb.append(str);
        return sb.toString();
    }
}
