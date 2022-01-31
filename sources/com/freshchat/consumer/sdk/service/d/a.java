package com.freshchat.consumer.sdk.service.d;

import android.content.Context;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.Tag;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.j;
import com.freshchat.consumer.sdk.e.d;
import com.freshchat.consumer.sdk.e.f;
import com.freshchat.consumer.sdk.exception.DeletedException;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.ah;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static boolean a(Context context, com.freshchat.consumer.sdk.b.a.a aVar) {
        JSONObject cm;
        boolean z = false;
        if (aVar.isValid() && aVar.cn() && (cm = aVar.cm()) != null) {
            try {
                c cVar = new c(context);
                JSONArray jSONArray = cm.getJSONArray("channels");
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i = 0; i < length; i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            long j = jSONObject.getLong("channelId");
                            Channel updatedAt = new Channel().setId(j).setName(jSONObject.getString("name")).setPosition(jSONObject.getInt("position")).setChannelType(jSONObject.getString("type")).setIconUrl(jSONObject.optString("iconUrl")).setDefault(jSONObject.getBoolean("defaultChannel")).setRestricted(jSONObject.optBoolean("restricted")).setHidden(jSONObject.optBoolean("hidden")).setUpdatedAt(jSONObject.getLong("updated"));
                            if (jSONObject.has("channelAlias")) {
                                updatedAt.setChannelAlias(jSONObject.getString("channelAlias"));
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("welcomeMessage");
                            if (optJSONObject != null) {
                                Message b = c.b(optJSONObject);
                                b.setChannelId(j);
                                b.setRead(true);
                                b.setAlias(j + "_welcome_message");
                                b.setMessageUserAlias("agent");
                                b.setMessageUserType(2);
                                updatedAt.setLatestOrWelcomeMessage(b);
                            }
                            arrayList.add(updatedAt);
                            List<Tag> a2 = f.a(jSONObject.getString("channelId"), jSONObject.optJSONArray("tags"), Tag.TaggedType.CHANNEL);
                            if (k.a(a2)) {
                                arrayList2.addAll(a2);
                            }
                        } catch (JSONException e) {
                            ai.e("FRESHCHAT", "Exception occurred", e);
                        }
                    }
                    new j(context).a(Tag.TaggedType.CHANNEL);
                    cVar.a(arrayList, arrayList2);
                    b(context, aVar);
                    z = k.a(arrayList);
                }
            } catch (JSONException unused) {
                ai.e("FRESHCHAT_WARNING", "Error processing channels");
            }
        }
        com.freshchat.consumer.sdk.b.a.g(context);
        return z;
    }

    private static Map<String, String> b(e eVar) {
        String bB = eVar.bB();
        HashMap hashMap = new HashMap();
        if (as.a(bB)) {
            hashMap.put("If-Modified-Since", bB);
        }
        return hashMap;
    }

    private static void b(Context context, com.freshchat.consumer.sdk.b.a.a aVar) {
        e w = w(context);
        w.bH();
        w.bD();
        JSONObject cm = aVar.cm();
        if (cm.has("contentLocale")) {
            try {
                String string = cm.getString("contentLocale");
                if (as.a(string)) {
                    w.C(string);
                }
            } catch (JSONException e) {
                StringBuilder i0 = hj1.i0("Channels content locale exception - ");
                i0.append(e.toString());
                ai.e("FRESHCHAT_WARNING", i0.toString());
            }
        }
        if (aVar.cm().has("lastModifiedAt")) {
            try {
                w.B(cm.getString("lastModifiedAt"));
            } catch (JSONException e2) {
                ai.e("FRESHCHAT_WARNING", e2.toString());
            }
        }
        w.D(ah.bc(context));
    }

    public static boolean v(Context context) {
        aa.fF();
        try {
            d a2 = new com.freshchat.consumer.sdk.e.c(context).a(com.freshchat.consumer.sdk.j.a.A(context), b(e.i(context)));
            if (a2.getStatusCode() == 410) {
                f.o(context, com.freshchat.consumer.sdk.e.c.a(a2));
                return false;
            } else if (a2.getStatusCode() == 200) {
                return a(context, new com.freshchat.consumer.sdk.b.a.a(a2.getInputStream()));
            } else {
                if (a2.getStatusCode() != 304) {
                    return false;
                }
                e.i(context).bH();
                e.i(context).D(ah.bc(context));
                return false;
            }
        } catch (DeletedException | Exception e) {
            q.a(e);
            return false;
        }
    }

    private static e w(Context context) {
        return e.i(context);
    }
}
