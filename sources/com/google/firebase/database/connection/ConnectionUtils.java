package com.google.firebase.database.connection;

import com.rabbitmq.client.ConnectionFactory;
import java.util.ArrayList;
import java.util.List;

public class ConnectionUtils {
    public static void hardAssert(boolean z) {
        hardAssert(z, "", new Object[0]);
    }

    public static Long longFromObject(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static String pathToString(List<String> list) {
        if (list.isEmpty()) {
            return ConnectionFactory.DEFAULT_VHOST;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : list) {
            if (!z) {
                sb.append(ConnectionFactory.DEFAULT_VHOST);
            }
            z = false;
            sb.append(str);
        }
        return sb.toString();
    }

    public static List<String> stringToPath(String str) {
        ArrayList arrayList = new ArrayList();
        String[] split = str.split(ConnectionFactory.DEFAULT_VHOST, -1);
        for (int i = 0; i < split.length; i++) {
            if (!split[i].isEmpty()) {
                arrayList.add(split[i]);
            }
        }
        return arrayList;
    }

    public static void hardAssert(boolean z, String str, Object... objArr) {
        if (!z) {
            StringBuilder i0 = hj1.i0("hardAssert failed: ");
            i0.append(String.format(str, objArr));
            throw new AssertionError(i0.toString());
        }
    }
}
