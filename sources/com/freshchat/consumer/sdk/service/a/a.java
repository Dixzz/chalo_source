package com.freshchat.consumer.sdk.service.a;

import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.appindexing.Indexable;
import java.util.HashMap;
import java.util.Map;

public class a {
    private static final Map<Integer, Integer> fs;
    private String fr;
    private Map<String, String> meta;
    private int priority;
    private int type;

    static {
        HashMap hashMap = new HashMap();
        fs = hashMap;
        hashMap.put(1, 1024);
        hashMap.put(2, 2048);
        hashMap.put(3, Integer.valueOf((int) RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST));
        hashMap.put(4, 1536);
        hashMap.put(6, 16384);
        hashMap.put(7, 4096);
        hashMap.put(10, 32000);
        hashMap.put(9, 2560);
        hashMap.put(11, Integer.valueOf((int) Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL));
    }

    public a(int i) {
        this(i, String.valueOf("type_" + i));
    }

    public a(int i, String str) {
        this.priority = Integer.MAX_VALUE;
        this.type = i;
        this.fr = str;
        this.priority = fs.get(Integer.valueOf(i)).intValue();
    }

    public a b(Map<String, String> map) {
        this.meta = map;
        return this;
    }

    public String dr() {
        return this.fr;
    }

    public Map<String, String> getMeta() {
        return this.meta;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("BacklogHolder [backlogId=");
        i0.append(this.fr);
        i0.append(", priority=");
        i0.append(this.priority);
        i0.append(", type=");
        i0.append(this.type);
        i0.append(", meta=");
        i0.append(this.meta);
        i0.append("]");
        return i0.toString();
    }
}
