package defpackage;

import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobServiceEngine;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import java.util.ArrayList;
import java.util.HashMap;

@Deprecated
/* renamed from: a5  reason: default package */
/* compiled from: JobIntentService */
public abstract class a5 extends Service {
    public static final Object k = new Object();
    public static final HashMap<ComponentName, h> l = new HashMap<>();
    public b f;
    public h g;
    public a h;
    public boolean i = false;
    public final ArrayList<d> j;

    /* renamed from: a5$a */
    /* compiled from: JobIntentService */
    public final class a extends AsyncTask<Void, Void, Void> {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x004c A[LOOP:0: B:1:0x0002->B:28:0x004c, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0059 A[SYNTHETIC] */
        @Override // android.os.AsyncTask
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Void[] r5) {
            /*
                r4 = this;
                java.lang.Void[] r5 = (java.lang.Void[]) r5
            L_0x0002:
                a5 r5 = defpackage.a5.this
                a5$b r0 = r5.f
                r1 = 0
                if (r0 == 0) goto L_0x0031
                a5$f r0 = (defpackage.a5.f) r0
                java.lang.Object r2 = r0.b
                monitor-enter(r2)
                android.app.job.JobParameters r5 = r0.c     // Catch:{ all -> 0x002e }
                if (r5 != 0) goto L_0x0014
                monitor-exit(r2)     // Catch:{ all -> 0x002e }
                goto L_0x0049
            L_0x0014:
                android.app.job.JobWorkItem r5 = r5.dequeueWork()     // Catch:{ all -> 0x002e }
                monitor-exit(r2)     // Catch:{ all -> 0x002e }
                if (r5 == 0) goto L_0x0049
                android.content.Intent r2 = r5.getIntent()
                a5 r3 = r0.f114a
                java.lang.ClassLoader r3 = r3.getClassLoader()
                r2.setExtrasClassLoader(r3)
                a5$f$a r2 = new a5$f$a
                r2.<init>(r5)
                goto L_0x004a
            L_0x002e:
                r5 = move-exception
                monitor-exit(r2)
                throw r5
            L_0x0031:
                java.util.ArrayList<a5$d> r0 = r5.j
                monitor-enter(r0)
                java.util.ArrayList<a5$d> r2 = r5.j     // Catch:{ all -> 0x005a }
                int r2 = r2.size()     // Catch:{ all -> 0x005a }
                if (r2 <= 0) goto L_0x0048
                java.util.ArrayList<a5$d> r5 = r5.j     // Catch:{ all -> 0x005a }
                r2 = 0
                java.lang.Object r5 = r5.remove(r2)     // Catch:{ all -> 0x005a }
                r2 = r5
                a5$e r2 = (defpackage.a5.e) r2     // Catch:{ all -> 0x005a }
                monitor-exit(r0)     // Catch:{ all -> 0x005a }
                goto L_0x004a
            L_0x0048:
                monitor-exit(r0)     // Catch:{ all -> 0x005a }
            L_0x0049:
                r2 = r1
            L_0x004a:
                if (r2 == 0) goto L_0x0059
                a5 r5 = defpackage.a5.this
                android.content.Intent r0 = r2.getIntent()
                r5.d(r0)
                r2.a()
                goto L_0x0002
            L_0x0059:
                return r1
            L_0x005a:
                r5 = move-exception
                monitor-exit(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.a5.a.doInBackground(java.lang.Object[]):java.lang.Object");
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onCancelled(Void r1) {
            a5.this.e();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r1) {
            a5.this.e();
        }
    }

    /* renamed from: a5$b */
    /* compiled from: JobIntentService */
    public interface b {
    }

    /* renamed from: a5$c */
    /* compiled from: JobIntentService */
    public static final class c extends h {
        public final Context d;
        public final PowerManager.WakeLock e;
        public final PowerManager.WakeLock f;
        public boolean g;
        public boolean h;

        public c(Context context, ComponentName componentName) {
            super(componentName);
            this.d = context.getApplicationContext();
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, componentName.getClassName() + ":launch");
            this.e = newWakeLock;
            newWakeLock.setReferenceCounted(false);
            PowerManager.WakeLock newWakeLock2 = powerManager.newWakeLock(1, componentName.getClassName() + ":run");
            this.f = newWakeLock2;
            newWakeLock2.setReferenceCounted(false);
        }

        @Override // defpackage.a5.h
        public void a(Intent intent) {
            Intent intent2 = new Intent(intent);
            intent2.setComponent(this.f116a);
            if (this.d.startService(intent2) != null) {
                synchronized (this) {
                    if (!this.g) {
                        this.g = true;
                        if (!this.h) {
                            this.e.acquire(DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
                        }
                    }
                }
            }
        }

        @Override // defpackage.a5.h
        public void c() {
            synchronized (this) {
                if (this.h) {
                    if (this.g) {
                        this.e.acquire(DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL);
                    }
                    this.h = false;
                    this.f.release();
                }
            }
        }

        @Override // defpackage.a5.h
        public void d() {
            synchronized (this) {
                if (!this.h) {
                    this.h = true;
                    this.f.acquire(600000);
                    this.e.release();
                }
            }
        }

        @Override // defpackage.a5.h
        public void e() {
            synchronized (this) {
                this.g = false;
            }
        }
    }

    /* renamed from: a5$d */
    /* compiled from: JobIntentService */
    public final class d implements e {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f113a;
        public final int b;

        public d(Intent intent, int i) {
            this.f113a = intent;
            this.b = i;
        }

        @Override // defpackage.a5.e
        public void a() {
            a5.this.stopSelf(this.b);
        }

        @Override // defpackage.a5.e
        public Intent getIntent() {
            return this.f113a;
        }
    }

    /* renamed from: a5$e */
    /* compiled from: JobIntentService */
    public interface e {
        void a();

        Intent getIntent();
    }

    /* renamed from: a5$f */
    /* compiled from: JobIntentService */
    public static final class f extends JobServiceEngine implements b {

        /* renamed from: a  reason: collision with root package name */
        public final a5 f114a;
        public final Object b = new Object();
        public JobParameters c;

        /* renamed from: a5$f$a */
        /* compiled from: JobIntentService */
        public final class a implements e {

            /* renamed from: a  reason: collision with root package name */
            public final JobWorkItem f115a;

            public a(JobWorkItem jobWorkItem) {
                this.f115a = jobWorkItem;
            }

            @Override // defpackage.a5.e
            public void a() {
                synchronized (f.this.b) {
                    JobParameters jobParameters = f.this.c;
                    if (jobParameters != null) {
                        jobParameters.completeWork(this.f115a);
                    }
                }
            }

            @Override // defpackage.a5.e
            public Intent getIntent() {
                return this.f115a.getIntent();
            }
        }

        public f(a5 a5Var) {
            super(a5Var);
            this.f114a = a5Var;
        }

        public boolean onStartJob(JobParameters jobParameters) {
            this.c = jobParameters;
            this.f114a.b(false);
            return true;
        }

        public boolean onStopJob(JobParameters jobParameters) {
            a aVar = this.f114a.h;
            if (aVar != null) {
                aVar.cancel(false);
            }
            synchronized (this.b) {
                this.c = null;
            }
            return true;
        }
    }

    /* renamed from: a5$g */
    /* compiled from: JobIntentService */
    public static final class g extends h {
        public final JobInfo d;
        public final JobScheduler e;

        public g(Context context, ComponentName componentName, int i) {
            super(componentName);
            b(i);
            this.d = new JobInfo.Builder(i, this.f116a).setOverrideDeadline(0).build();
            this.e = (JobScheduler) context.getApplicationContext().getSystemService("jobscheduler");
        }

        @Override // defpackage.a5.h
        public void a(Intent intent) {
            this.e.enqueue(this.d, new JobWorkItem(intent));
        }
    }

    /* renamed from: a5$h */
    /* compiled from: JobIntentService */
    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f116a;
        public boolean b;
        public int c;

        public h(ComponentName componentName) {
            this.f116a = componentName;
        }

        public abstract void a(Intent intent);

        public void b(int i) {
            if (!this.b) {
                this.b = true;
                this.c = i;
            } else if (this.c != i) {
                StringBuilder j0 = hj1.j0("Given job ID ", i, " is different than previous ");
                j0.append(this.c);
                throw new IllegalArgumentException(j0.toString());
            }
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }
    }

    public a5() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.j = null;
        } else {
            this.j = new ArrayList<>();
        }
    }

    public static void a(Context context, Class<?> cls, int i2, Intent intent) {
        ComponentName componentName = new ComponentName(context, cls);
        if (intent != null) {
            synchronized (k) {
                h c2 = c(context, componentName, true, i2);
                c2.b(i2);
                c2.a(intent);
            }
            return;
        }
        throw new IllegalArgumentException("work must not be null");
    }

    public static h c(Context context, ComponentName componentName, boolean z, int i2) {
        h hVar;
        HashMap<ComponentName, h> hashMap = l;
        h hVar2 = hashMap.get(componentName);
        if (hVar2 != null) {
            return hVar2;
        }
        if (Build.VERSION.SDK_INT < 26) {
            hVar = new c(context, componentName);
        } else if (z) {
            hVar = new g(context, componentName, i2);
        } else {
            throw new IllegalArgumentException("Can't be here without a job id");
        }
        hashMap.put(componentName, hVar);
        return hVar;
    }

    public void b(boolean z) {
        if (this.h == null) {
            this.h = new a();
            h hVar = this.g;
            if (hVar != null && z) {
                hVar.d();
            }
            this.h.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public abstract void d(Intent intent);

    public void e() {
        ArrayList<d> arrayList = this.j;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.h = null;
                ArrayList<d> arrayList2 = this.j;
                if (arrayList2 != null && arrayList2.size() > 0) {
                    b(false);
                } else if (!this.i) {
                    this.g.c();
                }
            }
        }
    }

    public IBinder onBind(Intent intent) {
        b bVar = this.f;
        if (bVar != null) {
            return ((f) bVar).getBinder();
        }
        return null;
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            this.f = new f(this);
            this.g = null;
            return;
        }
        this.f = null;
        this.g = c(this, new ComponentName(this, getClass()), false, 0);
    }

    public void onDestroy() {
        super.onDestroy();
        ArrayList<d> arrayList = this.j;
        if (arrayList != null) {
            synchronized (arrayList) {
                this.i = true;
                this.g.c();
            }
        }
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        if (this.j == null) {
            return 2;
        }
        this.g.e();
        synchronized (this.j) {
            ArrayList<d> arrayList = this.j;
            if (intent == null) {
                intent = new Intent();
            }
            arrayList.add(new d(intent, i3));
            b(true);
        }
        return 3;
    }
}
