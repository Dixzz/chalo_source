package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

/* renamed from: rl6  reason: default package */
/* compiled from: AndroidLog.kt */
public final class rl6 {

    /* renamed from: a  reason: collision with root package name */
    public static final CopyOnWriteArraySet<Logger> f3096a = new CopyOnWriteArraySet<>();
    public static final Map<String, String> b;
    public static final rl6 c = null;

    static {
        Map<String, String> map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = hi6.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = hi6.class.getName();
        n86.b(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = ok6.class.getName();
        n86.b(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = ij6.class.getName();
        n86.b(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        n86.e(linkedHashMap, "$this$toMap");
        int size = linkedHashMap.size();
        if (size == 0) {
            map = c66.f;
        } else if (size != 1) {
            map = y56.C(linkedHashMap);
        } else {
            map = hd3.c3(linkedHashMap);
        }
        b = map;
    }
}
