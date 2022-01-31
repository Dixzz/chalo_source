package defpackage;

import butterknife.internal.ButterKnifeProcessor;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* renamed from: rz5  reason: default package */
/* compiled from: SubscriberMethodFinder */
public class rz5 {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, List<qz5>> f3155a = new HashMap();
    public static final Map<Class<?>, Class<?>> b = new ConcurrentHashMap();

    public List<qz5> a(Class<?> cls, String str) {
        List<qz5> list;
        tz5 tz5;
        String str2 = cls.getName() + '.' + str;
        Map<String, List<qz5>> map = f3155a;
        synchronized (map) {
            list = map.get(str2);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            String name = cls2.getName();
            if (name.startsWith(ButterKnifeProcessor.JAVA_PREFIX) || name.startsWith("javax.") || name.startsWith(ButterKnifeProcessor.ANDROID_PREFIX)) {
                break;
            }
            Method[] methods = cls2.getMethods();
            for (Method method : methods) {
                String name2 = method.getName();
                if (name2.startsWith(str)) {
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & 1032) == 0) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            String substring = name2.substring(str.length());
                            if (substring.length() == 0) {
                                tz5 = tz5.PostThread;
                            } else if (substring.equals("MainThread")) {
                                tz5 = tz5.MainThread;
                            } else if (substring.equals("BackgroundThread")) {
                                tz5 = tz5.BackgroundThread;
                            } else if (substring.equals("Async")) {
                                tz5 = tz5.Async;
                            } else if (!b.containsKey(cls2)) {
                                throw new kz5("Illegal onEvent method, check for typos: " + method);
                            }
                            Class<?> cls3 = parameterTypes[0];
                            sb.setLength(0);
                            sb.append(name2);
                            sb.append('>');
                            sb.append(cls3.getName());
                            if (hashSet.add(sb.toString())) {
                                arrayList.add(new qz5(method, tz5, cls3));
                            }
                        } else {
                            continue;
                        }
                    } else if (!b.containsKey(cls2)) {
                        String str3 = jz5.l;
                        String str4 = "Skipping method (not public, static or abstract): " + cls2 + "." + name2;
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Map<String, List<qz5>> map2 = f3155a;
            synchronized (map2) {
                map2.put(str2, arrayList);
            }
            return arrayList;
        }
        throw new kz5("Subscriber " + cls + " has no public methods called " + str);
    }
}
