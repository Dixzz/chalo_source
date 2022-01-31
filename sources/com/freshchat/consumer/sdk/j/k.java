package com.freshchat.consumer.sdk.j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class k {
    public static boolean a(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static int b(Collection<?> collection) {
        if (collection != null) {
            return collection.size();
        }
        return 0;
    }

    public static Collection<String> c(Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        if (a(collection)) {
            for (String str : collection) {
                arrayList.add(str.toString().trim().toLowerCase());
            }
        }
        return arrayList;
    }

    public static boolean c(Map<?, ?> map) {
        return map == null || map.size() == 0;
    }

    public static boolean c(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static Collection<String> d(Collection<String> collection) {
        ArrayList arrayList = new ArrayList();
        if (a(collection)) {
            for (String str : collection) {
                arrayList.add(str.toString().trim());
            }
        }
        return arrayList;
    }

    public static boolean d(Map<?, ?> map) {
        return !c(map);
    }

    public static int f(Map<?, ?> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.size() == 0;
    }
}
