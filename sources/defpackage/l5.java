package defpackage;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.google.firebase.appindexing.Indexable;
import defpackage.g;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: l5  reason: default package */
/* compiled from: NotificationManagerCompat */
public final class l5 {
    public static final Object c = new Object();
    public static String d;
    public static Set<String> e = new HashSet();
    public static final Object f = new Object();
    public static c g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2170a;
    public final NotificationManager b;

    /* renamed from: l5$a */
    /* compiled from: NotificationManagerCompat */
    public static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final String f2171a;
        public final int b;
        public final String c;
        public final Notification d;

        public a(String str, int i, String str2, Notification notification) {
            this.f2171a = str;
            this.b = i;
            this.c = str2;
            this.d = notification;
        }

        @Override // defpackage.l5.d
        public void a(g gVar) throws RemoteException {
            gVar.s3(this.f2171a, this.b, this.c, this.d);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:");
            sb.append(this.f2171a);
            sb.append(", id:");
            sb.append(this.b);
            sb.append(", tag:");
            return hj1.a0(sb, this.c, "]");
        }
    }

    /* renamed from: l5$b */
    /* compiled from: NotificationManagerCompat */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f2172a;
        public final IBinder b;

        public b(ComponentName componentName, IBinder iBinder) {
            this.f2172a = componentName;
            this.b = iBinder;
        }
    }

    /* renamed from: l5$c */
    /* compiled from: NotificationManagerCompat */
    public static class c implements Handler.Callback, ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        public final Context f2173a;
        public final HandlerThread b;
        public final Handler c;
        public final Map<ComponentName, a> d = new HashMap();
        public Set<String> e = new HashSet();

        /* renamed from: l5$c$a */
        /* compiled from: NotificationManagerCompat */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ComponentName f2174a;
            public boolean b = false;
            public g c;
            public ArrayDeque<d> d = new ArrayDeque<>();
            public int e = 0;

            public a(ComponentName componentName) {
                this.f2174a = componentName;
            }
        }

        public c(Context context) {
            this.f2173a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.b = handlerThread;
            handlerThread.start();
            this.c = new Handler(handlerThread.getLooper(), this);
        }

        public final void a(a aVar) {
            boolean z;
            if (Log.isLoggable("NotifManCompat", 3)) {
                StringBuilder i0 = hj1.i0("Processing component ");
                i0.append(aVar.f2174a);
                i0.append(", ");
                i0.append(aVar.d.size());
                i0.append(" queued tasks");
                i0.toString();
            }
            if (!aVar.d.isEmpty()) {
                if (aVar.b) {
                    z = true;
                } else {
                    boolean bindService = this.f2173a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f2174a), this, 33);
                    aVar.b = bindService;
                    if (bindService) {
                        aVar.e = 0;
                    } else {
                        StringBuilder i02 = hj1.i0("Unable to bind to listener ");
                        i02.append(aVar.f2174a);
                        i02.toString();
                        this.f2173a.unbindService(this);
                    }
                    z = aVar.b;
                }
                if (!z || aVar.c == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    d peek = aVar.d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            String str = "Sending task " + peek;
                        }
                        peek.a(aVar.c);
                        aVar.d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            StringBuilder i03 = hj1.i0("Remote service has died: ");
                            i03.append(aVar.f2174a);
                            i03.toString();
                        }
                    } catch (RemoteException unused2) {
                        StringBuilder i04 = hj1.i0("RemoteException communicating with ");
                        i04.append(aVar.f2174a);
                        i04.toString();
                    }
                }
                if (!aVar.d.isEmpty()) {
                    b(aVar);
                }
            }
        }

        public final void b(a aVar) {
            if (!this.c.hasMessages(3, aVar.f2174a)) {
                int i = aVar.e + 1;
                aVar.e = i;
                if (i > 6) {
                    StringBuilder i0 = hj1.i0("Giving up on delivering ");
                    i0.append(aVar.d.size());
                    i0.append(" tasks to ");
                    i0.append(aVar.f2174a);
                    i0.append(" after ");
                    i0.append(aVar.e);
                    i0.append(" retries");
                    i0.toString();
                    aVar.d.clear();
                    return;
                }
                int i2 = (1 << (i - 1)) * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL;
                this.c.sendMessageDelayed(this.c.obtainMessage(3, aVar.f2174a), (long) i2);
            }
        }

        public boolean handleMessage(Message message) {
            Set<String> set;
            int i = message.what;
            g gVar = null;
            if (i == 0) {
                d dVar = (d) message.obj;
                String string = Settings.Secure.getString(this.f2173a.getContentResolver(), "enabled_notification_listeners");
                synchronized (l5.c) {
                    if (string != null) {
                        if (!string.equals(l5.d)) {
                            String[] split = string.split(ProductDiscountsObject.KEY_DELIMITER, -1);
                            HashSet hashSet = new HashSet(split.length);
                            for (String str : split) {
                                ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                                if (unflattenFromString != null) {
                                    hashSet.add(unflattenFromString.getPackageName());
                                }
                            }
                            l5.e = hashSet;
                            l5.d = string;
                        }
                    }
                    set = l5.e;
                }
                if (!set.equals(this.e)) {
                    this.e = set;
                    List<ResolveInfo> queryIntentServices = this.f2173a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                    HashSet hashSet2 = new HashSet();
                    for (ResolveInfo resolveInfo : queryIntentServices) {
                        if (set.contains(resolveInfo.serviceInfo.packageName)) {
                            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                            ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                            if (resolveInfo.serviceInfo.permission != null) {
                                String str2 = "Permission present on component " + componentName + ", not adding listener record.";
                            } else {
                                hashSet2.add(componentName);
                            }
                        }
                    }
                    Iterator it = hashSet2.iterator();
                    while (it.hasNext()) {
                        ComponentName componentName2 = (ComponentName) it.next();
                        if (!this.d.containsKey(componentName2)) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                String str3 = "Adding listener record for " + componentName2;
                            }
                            this.d.put(componentName2, new a(componentName2));
                        }
                    }
                    Iterator<Map.Entry<ComponentName, a>> it2 = this.d.entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry<ComponentName, a> next = it2.next();
                        if (!hashSet2.contains(next.getKey())) {
                            if (Log.isLoggable("NotifManCompat", 3)) {
                                StringBuilder i0 = hj1.i0("Removing listener record for ");
                                i0.append(next.getKey());
                                i0.toString();
                            }
                            a value = next.getValue();
                            if (value.b) {
                                this.f2173a.unbindService(this);
                                value.b = false;
                            }
                            value.c = null;
                            it2.remove();
                        }
                    }
                }
                for (a aVar : this.d.values()) {
                    aVar.d.add(dVar);
                    a(aVar);
                }
                return true;
            } else if (i == 1) {
                b bVar = (b) message.obj;
                ComponentName componentName3 = bVar.f2172a;
                IBinder iBinder = bVar.b;
                a aVar2 = this.d.get(componentName3);
                if (aVar2 != null) {
                    int i2 = g.a.f;
                    if (iBinder != null) {
                        IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
                        if (queryLocalInterface == null || !(queryLocalInterface instanceof g)) {
                            gVar = new g.a.C0023a(iBinder);
                        } else {
                            gVar = (g) queryLocalInterface;
                        }
                    }
                    aVar2.c = gVar;
                    aVar2.e = 0;
                    a(aVar2);
                }
                return true;
            } else if (i == 2) {
                a aVar3 = this.d.get((ComponentName) message.obj);
                if (aVar3 != null) {
                    if (aVar3.b) {
                        this.f2173a.unbindService(this);
                        aVar3.b = false;
                    }
                    aVar3.c = null;
                }
                return true;
            } else if (i != 3) {
                return false;
            } else {
                a aVar4 = this.d.get((ComponentName) message.obj);
                if (aVar4 != null) {
                    a(aVar4);
                }
                return true;
            }
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Connected to service " + componentName;
            }
            this.c.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                String str = "Disconnected from service " + componentName;
            }
            this.c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* renamed from: l5$d */
    /* compiled from: NotificationManagerCompat */
    public interface d {
        void a(g gVar) throws RemoteException;
    }

    public l5(Context context) {
        this.f2170a = context;
        this.b = (NotificationManager) context.getSystemService("notification");
    }

    public boolean a() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.b.areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f2170a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f2170a.getApplicationInfo();
        String packageName = this.f2170a.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            if (((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public final void b(d dVar) {
        synchronized (f) {
            if (g == null) {
                g = new c(this.f2170a.getApplicationContext());
            }
            g.c.obtainMessage(0, dVar).sendToTarget();
        }
    }
}
