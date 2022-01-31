package com.freshchat.consumer.sdk.service.d;

import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class f {
    public static List<Tag> a(String str, JSONArray jSONArray, Tag.TaggedType taggedType) {
        Exception e;
        ArrayList arrayList = null;
        if (jSONArray == null) {
            return null;
        }
        try {
            ArrayList arrayList2 = new ArrayList();
            try {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    try {
                        arrayList2.add(new Tag(jSONArray.get(i).toString(), str, taggedType));
                    } catch (JSONException e2) {
                        ai.e("FRESHCHAT", "Exception occured", e2);
                    }
                }
                return arrayList2;
            } catch (Exception e3) {
                e = e3;
                arrayList = arrayList2;
                q.a(e);
                return arrayList;
            }
        } catch (Exception e4) {
            e = e4;
            q.a(e);
            return arrayList;
        }
    }
}
