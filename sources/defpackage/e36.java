package defpackage;

import com.rabbitmq.client.ConnectionFactory;
import defpackage.t26;
import j$.util.Map;
import j$.util.function.BiConsumer;
import j$.util.function.BiFunction;
import j$.util.function.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: e36  reason: default package */
/* compiled from: Socket */
public class e36 extends m36 {
    public static final Logger k = Logger.getLogger(e36.class.getName());
    public static Map<String, Integer> l = new a();
    public volatile boolean b;
    public int c;
    public String d;
    public t26 e;
    public String f;
    public Map<Integer, q26> g = new HashMap();
    public Queue<d36> h;
    public final Queue<List<Object>> i = new LinkedList();
    public final Queue<a56<JSONArray>> j = new LinkedList();

    /* renamed from: e36$a */
    /* compiled from: Socket */
    public static class a extends HashMap<String, Integer> implements j$.util.Map {
        public a() {
            put("connect", 1);
            put("connect_error", 1);
            put("connect_timeout", 1);
            put("connecting", 1);
            put("disconnect", 1);
            put("error", 1);
            put("reconnect", 1);
            put("reconnect_attempt", 1);
            put("reconnect_failed", 1);
            put("reconnect_error", 1);
            put("reconnecting", 1);
            put("ping", 1);
            put("pong", 1);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
            return Map.CC.$default$compute(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
            return Map.CC.$default$computeIfAbsent(this, obj, function);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
            return Map.CC.$default$computeIfPresent(this, obj, biFunction);
        }

        @Override // j$.util.Map
        public /* synthetic */ void forEach(BiConsumer biConsumer) {
            Map.CC.$default$forEach(this, biConsumer);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Map, j$.util.Map, java.util.HashMap
        public /* synthetic */ Integer getOrDefault(Object obj, Integer num) {
            return Map.CC.$default$getOrDefault(this, obj, num);
        }

        @Override // j$.util.Map
        public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
            return Map.CC.$default$merge(this, obj, obj2, biFunction);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Map, j$.util.Map, java.util.HashMap
        public /* synthetic */ Integer putIfAbsent(String str, Integer num) {
            return Map.CC.$default$putIfAbsent(this, str, num);
        }

        @Override // j$.util.Map
        public /* synthetic */ boolean remove(Object obj, Object obj2) {
            return Map.CC.$default$remove(this, obj, obj2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Map, j$.util.Map, java.util.HashMap
        public /* synthetic */ Integer replace(String str, Integer num) {
            return Map.CC.$default$replace(this, str, num);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // java.util.Map, j$.util.Map, java.util.HashMap
        public /* synthetic */ boolean replace(String str, Integer num, Integer num2) {
            return Map.CC.$default$replace(this, str, num, num2);
        }

        @Override // j$.util.Map
        public /* synthetic */ void replaceAll(BiFunction biFunction) {
            Map.CC.$default$replaceAll(this, biFunction);
        }
    }

    /* renamed from: e36$b */
    /* compiled from: Socket */
    public class b implements Runnable {
        public final /* synthetic */ String f;
        public final /* synthetic */ Object[] g;

        public b(String str, Object[] objArr) {
            this.f = str;
            this.g = objArr;
        }

        public void run() {
            q26 q26;
            if (e36.l.containsKey(this.f)) {
                e36.super.a(this.f, this.g);
                return;
            }
            Object[] objArr = this.g;
            int length = objArr.length - 1;
            if (objArr.length <= 0 || !(objArr[length] instanceof q26)) {
                q26 = null;
            } else {
                objArr = new Object[length];
                for (int i = 0; i < length; i++) {
                    objArr[i] = this.g[i];
                }
                q26 = (q26) this.g[length];
            }
            e36 e36 = e36.this;
            String str = this.f;
            Objects.requireNonNull(e36);
            c56.a(new h36(e36, str, objArr, q26));
        }
    }

    public e36(t26 t26, String str, t26.f fVar) {
        this.e = t26;
        this.d = str;
        if (fVar != null) {
            this.f = fVar.n;
        }
    }

    public static void e(e36 e36) {
        Objects.requireNonNull(e36);
        k.fine("transport is open - connecting");
        if (!ConnectionFactory.DEFAULT_VHOST.equals(e36.d)) {
            String str = e36.f;
            if (str == null || str.isEmpty()) {
                a56 a56 = new a56(0);
                a56.c = e36.d;
                e36.e.h(a56);
                return;
            }
            a56 a562 = new a56(0);
            a562.f = e36.f;
            a562.c = e36.d;
            e36.e.h(a562);
        }
    }

    public static void f(e36 e36, a56 a56) {
        if (e36.d.equals(a56.c)) {
            switch (a56.f123a) {
                case 0:
                    e36.b = true;
                    e36.a("connect", new Object[0]);
                    while (true) {
                        List<Object> poll = e36.i.poll();
                        if (poll != null) {
                            super.a((String) poll.get(0), poll.toArray());
                        } else {
                            e36.i.clear();
                            while (true) {
                                a56<JSONArray> poll2 = e36.j.poll();
                                if (poll2 != null) {
                                    poll2.c = e36.d;
                                    e36.e.h(poll2);
                                } else {
                                    e36.j.clear();
                                    return;
                                }
                            }
                        }
                    }
                case 1:
                    Logger logger = k;
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine(String.format("server disconnect (%s)", e36.d));
                    }
                    e36.i();
                    e36.k("io server disconnect");
                    return;
                case 2:
                    e36.l(a56);
                    return;
                case 3:
                    e36.j(a56);
                    return;
                case 4:
                    e36.a("error", a56.d);
                    return;
                case 5:
                    e36.l(a56);
                    return;
                case 6:
                    e36.j(a56);
                    return;
                default:
                    return;
            }
        }
    }

    public static void g(e36 e36, a56 a56) {
        a56.c = e36.d;
        e36.e.h(a56);
    }

    public static Object[] m(JSONArray jSONArray) {
        Object obj;
        int length = jSONArray.length();
        Object[] objArr = new Object[length];
        for (int i2 = 0; i2 < length; i2++) {
            Object obj2 = null;
            try {
                obj = jSONArray.get(i2);
            } catch (JSONException e2) {
                k.log(Level.WARNING, "An error occured while retrieving data from JSONArray", (Throwable) e2);
                obj = null;
            }
            if (!JSONObject.NULL.equals(obj)) {
                obj2 = obj;
            }
            objArr[i2] = obj2;
        }
        return objArr;
    }

    @Override // defpackage.m36
    public m36 a(String str, Object... objArr) {
        c56.a(new b(str, objArr));
        return this;
    }

    public final void i() {
        Queue<d36> queue = this.h;
        if (queue != null) {
            for (d36 d36 : queue) {
                d36.a();
            }
            this.h = null;
        }
        t26 t26 = this.e;
        t26.m.remove(this);
        if (t26.m.isEmpty()) {
            t26.w.fine("disconnect");
            t26.d = true;
            t26.e = false;
            if (t26.b != t26.g.OPEN) {
                t26.e();
            }
            t26.k.d = 0;
            t26.b = t26.g.CLOSED;
            u36 u36 = t26.s;
            if (u36 != null) {
                c56.a(new z36(u36));
            }
        }
    }

    public final void j(a56<JSONArray> a56) {
        q26 remove = this.g.remove(Integer.valueOf(a56.b));
        if (remove != null) {
            Logger logger = k;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(String.format("calling ack %s with %s", Integer.valueOf(a56.b), a56.d));
            }
            remove.a(m(a56.d));
            return;
        }
        Logger logger2 = k;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(String.format("bad ack %s", Integer.valueOf(a56.b)));
        }
    }

    public final void k(String str) {
        Logger logger = k;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("close (%s)", str));
        }
        this.b = false;
        a("disconnect", str);
    }

    public final void l(a56<JSONArray> a56) {
        ArrayList arrayList = new ArrayList(Arrays.asList(m(a56.d)));
        Logger logger = k;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(String.format("emitting event %s", arrayList));
        }
        if (a56.b >= 0) {
            logger.fine("attaching ack callback to event");
            boolean[] zArr = {false};
            arrayList.add(new i36(this, zArr, a56.b, this));
        }
        if (!this.b) {
            this.i.add(arrayList);
        } else if (!arrayList.isEmpty()) {
            super.a(arrayList.remove(0).toString(), arrayList.toArray());
        }
    }
}
