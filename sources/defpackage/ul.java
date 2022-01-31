package defpackage;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.lifecycle.LiveData;
import com.google.firebase.perf.FirebasePerformance;
import defpackage.g2;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* renamed from: ul  reason: default package */
/* compiled from: InvalidationTracker */
public class ul {
    public static final String[] m = {"UPDATE", FirebasePerformance.HttpMethod.DELETE, "INSERT"};

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, Integer> f3518a;
    public final String[] b;
    public Map<String, Set<String>> c;
    public final wl d;
    public AtomicBoolean e = new AtomicBoolean(false);
    public volatile boolean f = false;
    public volatile sm g;
    public b h;
    public final tl i;
    @SuppressLint({"RestrictedApi"})
    public final g2<c, d> j = new g2<>();
    public vl k;
    public Runnable l = new a();

    /* renamed from: ul$a */
    /* compiled from: InvalidationTracker */
    public class a implements Runnable {
        public a() {
        }

        /* JADX INFO: finally extract failed */
        public final Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor query = ul.this.d.query(new nm("SELECT * FROM room_table_modification_log WHERE invalidated = 1;"));
            while (query.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(query.getInt(0)));
                } catch (Throwable th) {
                    query.close();
                    throw th;
                }
            }
            query.close();
            if (!hashSet.isEmpty()) {
                ul.this.g.F();
            }
            return hashSet;
        }

        public void run() {
            Set<Integer> set;
            Throwable th;
            Lock closeLock = ul.this.d.getCloseLock();
            closeLock.lock();
            try {
                if (ul.this.c()) {
                    try {
                        if (!ul.this.e.compareAndSet(true, false)) {
                            closeLock.unlock();
                            Objects.requireNonNull(ul.this);
                        } else if (ul.this.d.inTransaction()) {
                            closeLock.unlock();
                            Objects.requireNonNull(ul.this);
                        } else {
                            om l0 = ul.this.d.getOpenHelper().l0();
                            l0.f0();
                            try {
                                set = a();
                                try {
                                    l0.setTransactionSuccessful();
                                    l0.endTransaction();
                                    closeLock.unlock();
                                    Objects.requireNonNull(ul.this);
                                    if (!(set == null || set.isEmpty())) {
                                        synchronized (ul.this.j) {
                                            Iterator<Map.Entry<c, d>> it = ul.this.j.iterator();
                                            while (true) {
                                                g2.e eVar = (g2.e) it;
                                                if (eVar.hasNext()) {
                                                    d dVar = (d) ((Map.Entry) eVar.next()).getValue();
                                                    int length = dVar.f3521a.length;
                                                    Set<String> set2 = null;
                                                    for (int i = 0; i < length; i++) {
                                                        if (set.contains(Integer.valueOf(dVar.f3521a[i]))) {
                                                            if (length == 1) {
                                                                set2 = dVar.d;
                                                            } else {
                                                                if (set2 == null) {
                                                                    set2 = new HashSet<>(length);
                                                                }
                                                                set2.add(dVar.b[i]);
                                                            }
                                                        }
                                                    }
                                                    if (set2 != null) {
                                                        dVar.c.a(set2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        l0.endTransaction();
                                        throw th;
                                    } catch (SQLiteException | IllegalStateException unused) {
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                set = null;
                                l0.endTransaction();
                                throw th;
                            }
                        }
                    } catch (SQLiteException | IllegalStateException unused2) {
                        set = null;
                    }
                }
            } finally {
                closeLock.unlock();
                Objects.requireNonNull(ul.this);
            }
        }
    }

    /* renamed from: ul$b */
    /* compiled from: InvalidationTracker */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final long[] f3519a;
        public final boolean[] b;
        public final int[] c;
        public boolean d;
        public boolean e;

        public b(int i) {
            long[] jArr = new long[i];
            this.f3519a = jArr;
            boolean[] zArr = new boolean[i];
            this.b = zArr;
            this.c = new int[i];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        public int[] a() {
            synchronized (this) {
                if (this.d) {
                    if (!this.e) {
                        int length = this.f3519a.length;
                        int i = 0;
                        while (true) {
                            int i2 = 1;
                            if (i < length) {
                                boolean z = this.f3519a[i] > 0;
                                boolean[] zArr = this.b;
                                if (z != zArr[i]) {
                                    int[] iArr = this.c;
                                    if (!z) {
                                        i2 = 2;
                                    }
                                    iArr[i] = i2;
                                } else {
                                    this.c[i] = 0;
                                }
                                zArr[i] = z;
                                i++;
                            } else {
                                this.e = true;
                                this.d = false;
                                return this.c;
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    /* renamed from: ul$c */
    /* compiled from: InvalidationTracker */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final String[] f3520a;

        public c(String[] strArr) {
            this.f3520a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }

        public abstract void a(Set<String> set);
    }

    /* renamed from: ul$d */
    /* compiled from: InvalidationTracker */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f3521a;
        public final String[] b;
        public final c c;
        public final Set<String> d;

        public d(c cVar, int[] iArr, String[] strArr) {
            this.c = cVar;
            this.f3521a = iArr;
            this.b = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.d = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.d = null;
        }
    }

    /* renamed from: ul$e */
    /* compiled from: InvalidationTracker */
    public static class e extends c {
        public final ul b;
        public final WeakReference<c> c;

        public e(ul ulVar, c cVar) {
            super(cVar.f3520a);
            this.b = ulVar;
            this.c = new WeakReference<>(cVar);
        }

        @Override // defpackage.ul.c
        public void a(Set<String> set) {
            c cVar = this.c.get();
            if (cVar == null) {
                this.b.d(this);
            } else {
                cVar.a(set);
            }
        }
    }

    public ul(wl wlVar, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.d = wlVar;
        this.h = new b(strArr.length);
        this.f3518a = new HashMap<>();
        this.c = map2;
        this.i = new tl(wlVar);
        int length = strArr.length;
        this.b = new String[length];
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr[i2];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f3518a.put(lowerCase, Integer.valueOf(i2));
            String str2 = map.get(strArr[i2]);
            if (str2 != null) {
                this.b[i2] = str2.toLowerCase(locale);
            } else {
                this.b[i2] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Locale locale2 = Locale.US;
            String lowerCase2 = entry.getValue().toLowerCase(locale2);
            if (this.f3518a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.f3518a;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @SuppressLint({"RestrictedApi"})
    public void a(c cVar) {
        d k2;
        boolean z;
        String[] e2 = e(cVar.f3520a);
        int length = e2.length;
        int[] iArr = new int[length];
        int length2 = e2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            Integer num = this.f3518a.get(e2[i2].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i2] = num.intValue();
            } else {
                StringBuilder i0 = hj1.i0("There is no table with name ");
                i0.append(e2[i2]);
                throw new IllegalArgumentException(i0.toString());
            }
        }
        d dVar = new d(cVar, iArr, e2);
        synchronized (this.j) {
            k2 = this.j.k(cVar, dVar);
        }
        if (k2 == null) {
            b bVar = this.h;
            synchronized (bVar) {
                z = false;
                for (int i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i3];
                    long[] jArr = bVar.f3519a;
                    long j2 = jArr[i4];
                    jArr[i4] = 1 + j2;
                    if (j2 == 0) {
                        bVar.d = true;
                        z = true;
                    }
                }
            }
            if (z) {
                h();
            }
        }
    }

    public <T> LiveData<T> b(String[] strArr, boolean z, Callable<T> callable) {
        tl tlVar = this.i;
        String[] e2 = e(strArr);
        for (String str : e2) {
            if (!this.f3518a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException(hj1.S("There is no table with name ", str));
            }
        }
        Objects.requireNonNull(tlVar);
        return new zl(tlVar.b, tlVar, z, callable, e2);
    }

    public boolean c() {
        if (!this.d.isOpen()) {
            return false;
        }
        if (!this.f) {
            this.d.getOpenHelper().l0();
        }
        if (!this.f) {
            return false;
        }
        return true;
    }

    @SuppressLint({"RestrictedApi"})
    public void d(c cVar) {
        d n;
        boolean z;
        synchronized (this.j) {
            n = this.j.n(cVar);
        }
        if (n != null) {
            b bVar = this.h;
            int[] iArr = n.f3521a;
            synchronized (bVar) {
                z = false;
                for (int i2 : iArr) {
                    long[] jArr = bVar.f3519a;
                    long j2 = jArr[i2];
                    jArr[i2] = j2 - 1;
                    if (j2 == 1) {
                        bVar.d = true;
                        z = true;
                    }
                }
            }
            if (z) {
                h();
            }
        }
    }

    public final String[] e(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.c.containsKey(lowerCase)) {
                hashSet.addAll(this.c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public final void f(om omVar, int i2) {
        omVar.y("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i2 + ", 0)");
        String str = this.b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = m;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            hj1.V0(sb, str, "_", str2, "`");
            hj1.V0(sb, " AFTER ", str2, " ON `", str);
            hj1.V0(sb, "` BEGIN UPDATE ", "room_table_modification_log", " SET ", "invalidated");
            hj1.V0(sb, " = 1", " WHERE ", "table_id", " = ");
            sb.append(i2);
            sb.append(" AND ");
            sb.append("invalidated");
            sb.append(" = 0");
            sb.append("; END");
            omVar.y(sb.toString());
        }
    }

    public final void g(om omVar, int i2) {
        String str = this.b[i2];
        StringBuilder sb = new StringBuilder();
        String[] strArr = m;
        for (String str2 : strArr) {
            sb.setLength(0);
            sb.append("DROP TRIGGER IF EXISTS ");
            sb.append("`");
            sb.append("room_table_modification_trigger_");
            omVar.y(hj1.c0(sb, str, "_", str2, "`"));
        }
    }

    public void h() {
        if (this.d.isOpen()) {
            i(this.d.getOpenHelper().l0());
        }
    }

    public void i(om omVar) {
        if (!omVar.J0()) {
            while (true) {
                Lock closeLock = this.d.getCloseLock();
                closeLock.lock();
                try {
                    int[] a2 = this.h.a();
                    if (a2 == null) {
                        try {
                            return;
                        } catch (SQLiteException | IllegalStateException unused) {
                            return;
                        }
                    } else {
                        int length = a2.length;
                        if (omVar.V0()) {
                            omVar.f0();
                        } else {
                            omVar.beginTransaction();
                        }
                        for (int i2 = 0; i2 < length; i2++) {
                            try {
                                int i3 = a2[i2];
                                if (i3 == 1) {
                                    f(omVar, i2);
                                } else if (i3 == 2) {
                                    g(omVar, i2);
                                }
                            } catch (Throwable th) {
                                omVar.endTransaction();
                                throw th;
                            }
                        }
                        omVar.setTransactionSuccessful();
                        omVar.endTransaction();
                        b bVar = this.h;
                        synchronized (bVar) {
                            bVar.e = false;
                        }
                        closeLock.unlock();
                    }
                } finally {
                    closeLock.unlock();
                }
            }
        }
    }
}
