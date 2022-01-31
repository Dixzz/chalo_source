package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* renamed from: ni  reason: default package */
/* compiled from: LocalBroadcastManager */
public final class ni {
    public static final Object f = new Object();
    public static ni g;

    /* renamed from: a  reason: collision with root package name */
    public final Context f2555a;
    public final HashMap<BroadcastReceiver, ArrayList<c>> b = new HashMap<>();
    public final HashMap<String, ArrayList<c>> c = new HashMap<>();
    public final ArrayList<b> d = new ArrayList<>();
    public final Handler e;

    /* renamed from: ni$a */
    /* compiled from: LocalBroadcastManager */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
            r3 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r3 >= r1) goto L_0x000b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            r4 = r2[r3];
            r5 = r4.b.size();
            r6 = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
            if (r6 >= r5) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
            r7 = r4.b.get(r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            if (r7.d != false) goto L_0x0049;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
            r7.b.onReceive(r11.f2555a, r4.f2557a);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0049, code lost:
            r6 = r6 + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
            r3 = r3 + 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r11) {
            /*
                r10 = this;
                int r0 = r11.what
                r1 = 1
                if (r0 == r1) goto L_0x0009
                super.handleMessage(r11)
                goto L_0x0017
            L_0x0009:
                ni r11 = defpackage.ni.this
            L_0x000b:
                java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<ni$c>> r0 = r11.b
                monitor-enter(r0)
                java.util.ArrayList<ni$b> r1 = r11.d     // Catch:{ all -> 0x004f }
                int r1 = r1.size()     // Catch:{ all -> 0x004f }
                if (r1 > 0) goto L_0x0018
                monitor-exit(r0)     // Catch:{ all -> 0x004f }
            L_0x0017:
                return
            L_0x0018:
                ni$b[] r2 = new defpackage.ni.b[r1]     // Catch:{ all -> 0x004f }
                java.util.ArrayList<ni$b> r3 = r11.d     // Catch:{ all -> 0x004f }
                r3.toArray(r2)     // Catch:{ all -> 0x004f }
                java.util.ArrayList<ni$b> r3 = r11.d     // Catch:{ all -> 0x004f }
                r3.clear()     // Catch:{ all -> 0x004f }
                monitor-exit(r0)     // Catch:{ all -> 0x004f }
                r0 = 0
                r3 = 0
            L_0x0027:
                if (r3 >= r1) goto L_0x000b
                r4 = r2[r3]
                java.util.ArrayList<ni$c> r5 = r4.b
                int r5 = r5.size()
                r6 = 0
            L_0x0032:
                if (r6 >= r5) goto L_0x004c
                java.util.ArrayList<ni$c> r7 = r4.b
                java.lang.Object r7 = r7.get(r6)
                ni$c r7 = (defpackage.ni.c) r7
                boolean r8 = r7.d
                if (r8 != 0) goto L_0x0049
                android.content.BroadcastReceiver r7 = r7.b
                android.content.Context r8 = r11.f2555a
                android.content.Intent r9 = r4.f2557a
                r7.onReceive(r8, r9)
            L_0x0049:
                int r6 = r6 + 1
                goto L_0x0032
            L_0x004c:
                int r3 = r3 + 1
                goto L_0x0027
            L_0x004f:
                r11 = move-exception
                monitor-exit(r0)
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ni.a.handleMessage(android.os.Message):void");
        }
    }

    /* renamed from: ni$b */
    /* compiled from: LocalBroadcastManager */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f2557a;
        public final ArrayList<c> b;

        public b(Intent intent, ArrayList<c> arrayList) {
            this.f2557a = intent;
            this.b = arrayList;
        }
    }

    /* renamed from: ni$c */
    /* compiled from: LocalBroadcastManager */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final IntentFilter f2558a;
        public final BroadcastReceiver b;
        public boolean c;
        public boolean d;

        public c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f2558a = intentFilter;
            this.b = broadcastReceiver;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(128);
            sb.append("Receiver{");
            sb.append(this.b);
            sb.append(" filter=");
            sb.append(this.f2558a);
            if (this.d) {
                sb.append(" DEAD");
            }
            sb.append("}");
            return sb.toString();
        }
    }

    public ni(Context context) {
        this.f2555a = context;
        this.e = new a(context.getMainLooper());
    }

    public static ni a(Context context) {
        ni niVar;
        synchronized (f) {
            if (g == null) {
                g = new ni(context.getApplicationContext());
            }
            niVar = g;
        }
        return niVar;
    }

    public void b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.b) {
            c cVar = new c(intentFilter, broadcastReceiver);
            ArrayList<c> arrayList = this.b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(cVar);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<c> arrayList2 = this.c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    public boolean c(Intent intent) {
        boolean z;
        String str;
        ArrayList<c> arrayList;
        String str2;
        int i;
        ArrayList arrayList2;
        synchronized (this.b) {
            String action = intent.getAction();
            String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f2555a.getContentResolver());
            Uri data = intent.getData();
            String scheme = intent.getScheme();
            Set<String> categories = intent.getCategories();
            boolean z2 = (intent.getFlags() & 8) != 0;
            if (z2) {
                String str3 = "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent;
            }
            ArrayList<c> arrayList3 = this.c.get(intent.getAction());
            if (arrayList3 != null) {
                if (z2) {
                    String str4 = "Action list: " + arrayList3;
                }
                ArrayList arrayList4 = null;
                int i2 = 0;
                while (i2 < arrayList3.size()) {
                    c cVar = arrayList3.get(i2);
                    if (z2) {
                        String str5 = "Matching against filter " + cVar.f2558a;
                    }
                    if (cVar.c) {
                        i = i2;
                        arrayList = arrayList3;
                        str2 = action;
                        str = resolveTypeIfNeeded;
                        arrayList2 = arrayList4;
                    } else {
                        i = i2;
                        str2 = action;
                        arrayList2 = arrayList4;
                        arrayList = arrayList3;
                        str = resolveTypeIfNeeded;
                        int match = cVar.f2558a.match(action, resolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                        if (match >= 0) {
                            if (z2) {
                                Integer.toHexString(match);
                            }
                            arrayList4 = arrayList2 == null ? new ArrayList() : arrayList2;
                            arrayList4.add(cVar);
                            cVar.c = true;
                            i2 = i + 1;
                            action = str2;
                            arrayList3 = arrayList;
                            resolveTypeIfNeeded = str;
                        }
                    }
                    arrayList4 = arrayList2;
                    i2 = i + 1;
                    action = str2;
                    arrayList3 = arrayList;
                    resolveTypeIfNeeded = str;
                }
                z = false;
                if (arrayList4 != null) {
                    for (int i3 = 0; i3 < arrayList4.size(); i3++) {
                        ((c) arrayList4.get(i3)).c = false;
                    }
                    this.d.add(new b(intent, arrayList4));
                    if (!this.e.hasMessages(1)) {
                        this.e.sendEmptyMessage(1);
                    }
                    return true;
                }
            } else {
                z = false;
            }
            return z;
        }
    }

    public void d(BroadcastReceiver broadcastReceiver) {
        synchronized (this.b) {
            ArrayList<c> remove = this.b.remove(broadcastReceiver);
            if (remove != null) {
                for (int size = remove.size() - 1; size >= 0; size--) {
                    c cVar = remove.get(size);
                    cVar.d = true;
                    for (int i = 0; i < cVar.f2558a.countActions(); i++) {
                        String action = cVar.f2558a.getAction(i);
                        ArrayList<c> arrayList = this.c.get(action);
                        if (arrayList != null) {
                            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                                c cVar2 = arrayList.get(size2);
                                if (cVar2.b == broadcastReceiver) {
                                    cVar2.d = true;
                                    arrayList.remove(size2);
                                }
                            }
                            if (arrayList.size() <= 0) {
                                this.c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }
}
