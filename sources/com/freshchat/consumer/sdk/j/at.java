package com.freshchat.consumer.sdk.j;

import android.content.Context;
import java.text.NumberFormat;

public class at {
    public static String n(Context context, int i) {
        String str;
        try {
            str = NumberFormat.getInstance(ah.bb(context)).format((long) i);
        } catch (Exception e) {
            q.a(e);
            str = null;
        }
        return str == null ? String.valueOf(i) : str;
    }
}
