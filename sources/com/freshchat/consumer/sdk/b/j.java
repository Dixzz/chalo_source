package com.freshchat.consumer.sdk.b;

import android.content.Context;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.service.e.n;
import org.json.JSONException;
import org.json.JSONObject;

public class j {
    private final e cL;

    public j(Context context) {
        this.cL = e.i(context.getApplicationContext());
    }

    public boolean P(String str) {
        return this.cL.iK().has(str);
    }

    public void a(String str, n.a aVar) {
        JSONObject iK = this.cL.iK();
        try {
            iK.put(str, aVar.toString());
        } catch (JSONException e) {
            ai.e("FRESHCHAT", "Exception occured", e);
        }
        this.cL.a(iK);
    }

    public boolean bj(String str) {
        if (as.isEmpty(str)) {
            return false;
        }
        try {
            return as.o(n.a.Downvote.toString(), this.cL.iK().getString(str));
        } catch (JSONException e) {
            ai.e("FRESHCHAT", "Exception occured", e);
        }
    }
}
