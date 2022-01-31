package defpackage;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.os.RemoteException;
import defpackage.pm;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: wl  reason: default package */
/* compiled from: RoomDatabase */
public abstract class wl {
    private static final String DB_IMPL_SUFFIX = "_Impl";
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;
    private gl mAutoCloser;
    public Map<Class<? extends em>, em> mAutoMigrationSpecs = new HashMap();
    private final Map<String, Object> mBackingFieldMap = DesugarCollections.synchronizedMap(new HashMap());
    @Deprecated
    public List<b> mCallbacks;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    @Deprecated
    public volatile om mDatabase;
    private final ul mInvalidationTracker = createInvalidationTracker();
    private pm mOpenHelper;
    private Executor mQueryExecutor;
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    private Executor mTransactionExecutor;
    private final Map<Class<?>, Object> mTypeConverters = new HashMap();
    public boolean mWriteAheadLoggingEnabled;

    /* renamed from: wl$a */
    /* compiled from: RoomDatabase */
    public static class a<T extends wl> {

        /* renamed from: a  reason: collision with root package name */
        public final Class<T> f3797a;
        public final String b;
        public final Context c;
        public ArrayList<b> d;
        public Executor e;
        public Executor f;
        public pm.c g;
        public boolean h;
        public c i = c.AUTOMATIC;
        public boolean j = true;
        public boolean k;
        public final d l = new d();
        public Set<Integer> m;

        public a(Context context, Class<T> cls, String str) {
            this.c = context;
            this.f3797a = cls;
            this.b = str;
        }

        public a<T> a(fm... fmVarArr) {
            if (this.m == null) {
                this.m = new HashSet();
            }
            for (fm fmVar : fmVarArr) {
                this.m.add(Integer.valueOf(fmVar.startVersion));
                this.m.add(Integer.valueOf(fmVar.endVersion));
            }
            this.l.a(fmVarArr);
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        public T b() {
            String str;
            Executor executor;
            Context context = this.c;
            if (context == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            } else if (this.f3797a != null) {
                Executor executor2 = this.e;
                if (executor2 == null && this.f == null) {
                    Executor executor3 = c2.d;
                    this.f = executor3;
                    this.e = executor3;
                } else if (executor2 != null && this.f == null) {
                    this.f = executor2;
                } else if (executor2 == null && (executor = this.f) != null) {
                    this.e = executor;
                }
                pm.c cVar = this.g;
                if (cVar == null) {
                    cVar = new vm();
                }
                nl nlVar = new nl(context, this.b, cVar, this.l, this.d, this.h, this.i.resolve(context), this.e, this.f, false, this.j, this.k, null, null, null, null, null, null);
                Class<T> cls = this.f3797a;
                String name = cls.getPackage().getName();
                String canonicalName = cls.getCanonicalName();
                if (!name.isEmpty()) {
                    canonicalName = canonicalName.substring(name.length() + 1);
                }
                String str2 = canonicalName.replace('.', '_') + wl.DB_IMPL_SUFFIX;
                try {
                    if (name.isEmpty()) {
                        str = str2;
                    } else {
                        str = name + "." + str2;
                    }
                    T t = (T) ((wl) Class.forName(str, true, cls.getClassLoader()).newInstance());
                    t.init(nlVar);
                    return t;
                } catch (ClassNotFoundException unused) {
                    StringBuilder i0 = hj1.i0("cannot find implementation for ");
                    i0.append(cls.getCanonicalName());
                    i0.append(". ");
                    i0.append(str2);
                    i0.append(" does not exist");
                    throw new RuntimeException(i0.toString());
                } catch (IllegalAccessException unused2) {
                    StringBuilder i02 = hj1.i0("Cannot access the constructor");
                    i02.append(cls.getCanonicalName());
                    throw new RuntimeException(i02.toString());
                } catch (InstantiationException unused3) {
                    StringBuilder i03 = hj1.i0("Failed to create an instance of ");
                    i03.append(cls.getCanonicalName());
                    throw new RuntimeException(i03.toString());
                }
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        }

        public a<T> c() {
            this.j = true;
            this.k = true;
            return this;
        }
    }

    /* renamed from: wl$b */
    /* compiled from: RoomDatabase */
    public static abstract class b {
        public void onCreate(om omVar) {
        }

        public void onDestructiveMigration(om omVar) {
        }

        public void onOpen(om omVar) {
        }
    }

    /* renamed from: wl$c */
    /* compiled from: RoomDatabase */
    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean isLowRamDevice(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }

        public c resolve(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || isLowRamDevice(activityManager)) {
                return TRUNCATE;
            }
            return WRITE_AHEAD_LOGGING;
        }
    }

    /* renamed from: wl$d */
    /* compiled from: RoomDatabase */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public HashMap<Integer, TreeMap<Integer, fm>> f3798a = new HashMap<>();

        public void a(fm... fmVarArr) {
            for (fm fmVar : fmVarArr) {
                int i = fmVar.startVersion;
                int i2 = fmVar.endVersion;
                TreeMap<Integer, fm> treeMap = this.f3798a.get(Integer.valueOf(i));
                if (treeMap == null) {
                    treeMap = new TreeMap<>();
                    this.f3798a.put(Integer.valueOf(i), treeMap);
                }
                fm fmVar2 = treeMap.get(Integer.valueOf(i2));
                if (fmVar2 != null) {
                    String str = "Overriding migration " + fmVar2 + " with " + fmVar;
                }
                treeMap.put(Integer.valueOf(i2), fmVar);
            }
        }
    }

    private void internalBeginTransaction() {
        assertNotMainThread();
        om l0 = this.mOpenHelper.l0();
        this.mInvalidationTracker.i(l0);
        if (l0.V0()) {
            l0.f0();
        } else {
            l0.beginTransaction();
        }
    }

    private void internalEndTransaction() {
        this.mOpenHelper.l0().endTransaction();
        if (!inTransaction()) {
            ul ulVar = this.mInvalidationTracker;
            if (ulVar.e.compareAndSet(false, true)) {
                ulVar.d.getQueryExecutor().execute(ulVar.l);
            }
        }
    }

    private static boolean isMainThread() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: pm */
    /* JADX WARN: Multi-variable type inference failed */
    private <T> T unwrapOpenHelper(Class<T> cls, pm pmVar) {
        if (cls.isInstance(pmVar)) {
            return pmVar;
        }
        if (pmVar instanceof ol) {
            return (T) unwrapOpenHelper(cls, ((ol) pmVar).a());
        }
        return null;
    }

    public void assertNotMainThread() {
        if (!this.mAllowMainThreadQueries && isMainThread()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        if (this.mAutoCloser == null) {
            internalBeginTransaction();
            return;
        }
        throw null;
    }

    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            writeLock.lock();
            try {
                ul ulVar = this.mInvalidationTracker;
                vl vlVar = ulVar.k;
                if (vlVar != null) {
                    if (vlVar.g.compareAndSet(false, true)) {
                        vlVar.c.d(vlVar.d);
                        try {
                            sl slVar = vlVar.e;
                            if (slVar != null) {
                                slVar.B3(vlVar.f, vlVar.b);
                            }
                        } catch (RemoteException unused) {
                        }
                        vlVar.f3660a.unbindService(vlVar.h);
                    }
                    ulVar.k = null;
                }
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public sm compileStatement(String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.l0().G(str);
    }

    public abstract ul createInvalidationTracker();

    public abstract pm createOpenHelper(nl nlVar);

    @Deprecated
    public void endTransaction() {
        if (this.mAutoCloser == null) {
            internalEndTransaction();
            return;
        }
        throw null;
    }

    public List<fm> getAutoMigrations(Map<Class<? extends em>, em> map) {
        return Collections.emptyList();
    }

    public Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    public ul getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    public pm getOpenHelper() {
        return this.mOpenHelper;
    }

    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    public Set<Class<? extends em>> getRequiredAutoMigrationSpecs() {
        return Collections.emptySet();
    }

    public Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return Collections.emptyMap();
    }

    public ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    public <T> T getTypeConverter(Class<T> cls) {
        return (T) this.mTypeConverters.get(cls);
    }

    public boolean inTransaction() {
        return this.mOpenHelper.l0().J0();
    }

    public void init(nl nlVar) {
        boolean z;
        this.mOpenHelper = createOpenHelper(nlVar);
        Set<Class<? extends em>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends em>> it = requiredAutoMigrationSpecs.iterator();
        while (true) {
            int i = -1;
            if (it.hasNext()) {
                Class<? extends em> next = it.next();
                int size = nlVar.g.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    } else if (next.isAssignableFrom(nlVar.g.get(size).getClass())) {
                        bitSet.set(size);
                        i = size;
                        break;
                    } else {
                        size--;
                    }
                }
                if (i >= 0) {
                    this.mAutoMigrationSpecs.put(next, nlVar.g.get(i));
                } else {
                    StringBuilder i0 = hj1.i0("A required auto migration spec (");
                    i0.append(next.getCanonicalName());
                    i0.append(") is missing in the database configuration.");
                    throw new IllegalArgumentException(i0.toString());
                }
            } else {
                for (int size2 = nlVar.g.size() - 1; size2 >= 0; size2--) {
                    if (!bitSet.get(size2)) {
                        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                    }
                }
                Iterator<fm> it2 = getAutoMigrations(this.mAutoMigrationSpecs).iterator();
                while (true) {
                    z = false;
                    if (!it2.hasNext()) {
                        break;
                    }
                    fm next2 = it2.next();
                    if (!Collections.unmodifiableMap(nlVar.d.f3798a).containsKey(Integer.valueOf(next2.startVersion))) {
                        nlVar.d.a(next2);
                    }
                }
                am amVar = (am) unwrapOpenHelper(am.class, this.mOpenHelper);
                if (amVar != null) {
                    amVar.l = nlVar;
                }
                if (((hl) unwrapOpenHelper(hl.class, this.mOpenHelper)) == null) {
                    if (nlVar.i == c.WRITE_AHEAD_LOGGING) {
                        z = true;
                    }
                    this.mOpenHelper.setWriteAheadLoggingEnabled(z);
                    this.mCallbacks = nlVar.e;
                    this.mQueryExecutor = nlVar.j;
                    this.mTransactionExecutor = new dm(nlVar.k);
                    this.mAllowMainThreadQueries = nlVar.h;
                    this.mWriteAheadLoggingEnabled = z;
                    Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
                    BitSet bitSet2 = new BitSet();
                    for (Map.Entry<Class<?>, List<Class<?>>> entry : requiredTypeConverters.entrySet()) {
                        Class<?> key = entry.getKey();
                        Iterator<Class<?>> it3 = entry.getValue().iterator();
                        while (true) {
                            if (it3.hasNext()) {
                                Class<?> next3 = it3.next();
                                int size3 = nlVar.f.size() - 1;
                                while (true) {
                                    if (size3 < 0) {
                                        size3 = -1;
                                        break;
                                    } else if (next3.isAssignableFrom(nlVar.f.get(size3).getClass())) {
                                        bitSet2.set(size3);
                                        break;
                                    } else {
                                        size3--;
                                    }
                                }
                                if (size3 >= 0) {
                                    this.mTypeConverters.put(next3, nlVar.f.get(size3));
                                } else {
                                    throw new IllegalArgumentException("A required type converter (" + next3 + ") for " + key.getCanonicalName() + " is missing in the database configuration.");
                                }
                            }
                        }
                    }
                    for (int size4 = nlVar.f.size() - 1; size4 >= 0; size4--) {
                        if (!bitSet2.get(size4)) {
                            throw new IllegalArgumentException("Unexpected type converter " + nlVar.f.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                        }
                    }
                    return;
                }
                Objects.requireNonNull(this.mInvalidationTracker);
                throw null;
            }
        }
    }

    public void internalInitInvalidationTracker(om omVar) {
        ul ulVar = this.mInvalidationTracker;
        synchronized (ulVar) {
            if (!ulVar.f) {
                omVar.y("PRAGMA temp_store = MEMORY;");
                omVar.y("PRAGMA recursive_triggers='ON';");
                omVar.y("CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)");
                ulVar.i(omVar);
                ulVar.g = omVar.G("UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ");
                ulVar.f = true;
            }
        }
    }

    public boolean isOpen() {
        gl glVar = this.mAutoCloser;
        if (glVar != null) {
            return !glVar.f1276a;
        }
        om omVar = this.mDatabase;
        if (omVar == null || !omVar.isOpen()) {
            return false;
        }
        return true;
    }

    public Cursor query(String str, Object[] objArr) {
        return this.mOpenHelper.l0().D0(new nm(str, objArr));
    }

    public void runInTransaction(Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.l0().setTransactionSuccessful();
    }

    public Cursor query(rm rmVar) {
        return query(rmVar, (CancellationSignal) null);
    }

    public Cursor query(rm rmVar, CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return this.mOpenHelper.l0().U(rmVar, cancellationSignal);
        }
        return this.mOpenHelper.l0().D0(rmVar);
    }

    public <V> V runInTransaction(Callable<V> callable) {
        beginTransaction();
        try {
            V call = callable.call();
            setTransactionSuccessful();
            endTransaction();
            return call;
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw e2;
        } catch (Throwable th) {
            endTransaction();
            throw th;
        }
    }
}
