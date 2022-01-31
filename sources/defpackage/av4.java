package defpackage;

import android.os.Bundle;
import android.os.Process;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: av4  reason: default package */
public class av4 {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, Map<String, Integer>> f336a = new HashMap();

    static {
        new HashSet(Arrays.asList("app_update", "review"));
        new HashSet(Arrays.asList("native", "unity"));
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String valueOf = String.valueOf(sb.toString());
        if ("PlayCoreVersion".length() != 0) {
            valueOf.concat("PlayCoreVersion");
        } else {
            new String(valueOf);
        }
    }

    public static Bundle a(String str) {
        Map<String, Integer> map;
        Bundle bundle = new Bundle();
        synchronized (av4.class) {
            Map<String, Map<String, Integer>> map2 = f336a;
            if (!map2.containsKey(str)) {
                HashMap hashMap = new HashMap();
                hashMap.put("java", 10901);
                map2.put(str, hashMap);
            }
            map = map2.get(str);
        }
        bundle.putInt("playcore_version_code", map.get("java").intValue());
        if (map.containsKey("native")) {
            bundle.putInt("playcore_native_version", map.get("native").intValue());
        }
        if (map.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", map.get("unity").intValue());
        }
        return bundle;
    }
}
