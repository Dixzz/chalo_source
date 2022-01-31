package com.freshchat.consumer.sdk.c.a;

import com.freshchat.consumer.sdk.beans.ColDef;
import com.freshchat.consumer.sdk.beans.Message;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;

public class j extends c {
    public static final String TAG = "com.freshchat.consumer.sdk.c.a.j";

    @Override // com.freshchat.consumer.sdk.c.a.h
    public ColDef[] cO() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ColDef("_id", "TEXT", false, 1, " PRIMARY KEY "));
        arrayList.add(new ColDef("channel_id", "TEXT", true, 1));
        arrayList.add(new ColDef("conv_id", "TEXT", true, 1));
        arrayList.add(new ColDef("marketing_id", "INTEGER", true, 1));
        arrayList.add(new ColDef("user_id", "TEXT", true, 1));
        arrayList.add(new ColDef("user_type", "INTEGER", false, 1, " DEFAULT 0"));
        arrayList.add(new ColDef("read", "INTEGER", true, 1));
        arrayList.add(new ColDef("created_at", "INTEGER", true, 1));
        arrayList.add(new ColDef("uploaded", "INTEGER", true, 1, " DEFAULT 0"));
        arrayList.add(new ColDef(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION, "INTEGER", true, 1, " DEFAULT 0"));
        arrayList.add(new ColDef("reply_fragments", "TEXT", true, 4));
        arrayList.add(new ColDef("extras_json", "TEXT", true, 5));
        StringBuilder i0 = hj1.i0(" DEFAULT ");
        i0.append(Message.MessageType.MESSAGE_TYPE_NORMAL.getIntValue());
        arrayList.add(new ColDef(Constants.MessagePayloadKeys.MESSAGE_TYPE, "INTEGER", true, 6, i0.toString()));
        arrayList.add(new ColDef("internal_meta", "TEXT", true, 6));
        arrayList.add(new ColDef("responded", "INTEGER", true, 6, " DEFAULT 0"));
        arrayList.add(new ColDef("should_translate", "INTEGER", true, 7, " DEFAULT 0"));
        return (ColDef[]) arrayList.toArray(new ColDef[0]);
    }

    @Override // com.freshchat.consumer.sdk.c.a.h
    public String cP() {
        return "message";
    }
}
