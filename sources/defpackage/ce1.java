package defpackage;

import android.content.Context;
import com.rabbitmq.client.AlreadyClosedException;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;
import java.util.Timer;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: ce1  reason: default package */
/* compiled from: RabbitQueue */
public class ce1 implements yd1 {

    /* renamed from: a  reason: collision with root package name */
    public Context f556a;
    public de1 b;
    public String c;
    public ConnectionFactory d;
    public BlockingDeque<zd1> e = new LinkedBlockingDeque();
    public ExecutorService f;
    public Connection g;
    public Channel h;
    public String i;
    public String j;
    public String k = ce1.class.getName();
    public long l;
    public boolean m;
    public boolean n;

    public ce1(Context context, String str, String str2, String str3) {
        this.f556a = context;
        this.b = new de1(context);
        this.m = false;
        this.n = false;
        this.c = str;
        this.i = str2;
        this.j = str3;
        this.f = Executors.newSingleThreadExecutor();
        BlockingDeque<zd1> blockingDeque = this.e;
        de1 de1 = this.b;
        ArrayList arrayList = new ArrayList(de1.f826a.b().keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zd1 zd1 = null;
            try {
                JSONObject jSONObject = new JSONObject(de1.f826a.f((String) it.next(), null));
                String string = jSONObject.getString("type");
                Iterator<String> keys = jSONObject.keys();
                HashMap hashMap = new HashMap();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (!next.equals("type")) {
                        hashMap.put(next, jSONObject.get(next));
                    }
                }
                zd1 = new zd1(string, hashMap);
            } catch (Exception unused) {
            }
            arrayList2.add(zd1);
        }
        blockingDeque.addAll(arrayList2);
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            this.d = connectionFactory;
            connectionFactory.setUri(this.i);
            this.d.setAutomaticRecoveryEnabled(false);
        } catch (URISyntaxException | KeyManagementException | NoSuchAlgorithmException unused2) {
        }
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, false, 0);
        new Timer().scheduleAtFixedRate(new ae1(this), 0, 120000);
        e();
    }

    public static void a(ce1 ce1) throws TimeoutException, IOException {
        if (!ce1.m) {
            ce1.m = true;
            Connection newConnection = ce1.d.newConnection();
            ce1.m = false;
            ce1.g = newConnection;
            ce1.h = newConnection.createChannel();
        }
    }

    public static void b(ce1 ce1) throws Exception {
        zd1 takeFirst = ce1.e.takeFirst();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event", takeFirst.f4159a);
            jSONObject.put("userId", ce1.c);
            jSONObject.put("data", new JSONObject(takeFirst.b));
            ce1.h.basicPublish(ce1.j, "application." + takeFirst.f4159a.toLowerCase(), null, jSONObject.toString().getBytes());
            ce1.l = System.currentTimeMillis();
            de1 de1 = ce1.b;
            ArrayList arrayList = new ArrayList(de1.f826a.b().keySet());
            Collections.sort(arrayList);
            de1.f826a.k((String) arrayList.get(0));
        } catch (Exception e2) {
            ce1.e.addFirst(takeFirst);
            throw e2;
        }
    }

    public boolean c(zd1 zd1) {
        String str;
        de1 de1 = this.b;
        Objects.requireNonNull(de1);
        try {
            JSONObject jSONObject = new JSONObject(zd1.b);
            jSONObject.put("type", zd1.f4159a);
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = null;
        }
        rf1 rf1 = de1.f826a;
        rf1.j(System.currentTimeMillis() + "", str);
        this.e.addLast(zd1);
        e();
        return true;
    }

    public final void d() {
        this.m = false;
        this.h = null;
        this.g = null;
    }

    public final void e() {
        if (vn.K0(this.f556a) && this.g == null && !this.m && !this.e.isEmpty() && !this.n) {
            this.f.shutdown();
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            this.f = newSingleThreadExecutor;
            newSingleThreadExecutor.submit(new be1(this));
        }
    }

    public void onEvent(qd1 qd1) {
        if (!qd1.f2931a) {
            this.n = false;
            this.f.shutdown();
            Connection connection = this.g;
            if (connection != null) {
                try {
                    connection.close();
                    d();
                } catch (AlreadyClosedException unused) {
                    d();
                } catch (Exception unused2) {
                    d();
                }
            }
        } else {
            e();
        }
    }
}
