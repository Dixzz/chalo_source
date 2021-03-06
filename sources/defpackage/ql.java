package defpackage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: ql  reason: default package */
/* compiled from: EntityInsertionAdapter */
public abstract class ql<T> extends bm {
    public ql(wl wlVar) {
        super(wlVar);
    }

    public abstract void bind(sm smVar, T t);

    public final void insert(T t) {
        sm acquire = acquire();
        try {
            bind(acquire, t);
            acquire.g1();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t) {
        sm acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.g1();
        } finally {
            release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: ql<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        sm acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                jArr[i] = acquire.g1();
                i++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: ql<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        sm acquire = acquire();
        try {
            Long[] lArr = new Long[collection.size()];
            int i = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                lArr[i] = Long.valueOf(acquire.g1());
                i++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        sm acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(tArr.length);
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                arrayList.add(i, Long.valueOf(acquire.g1()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    public final void insert(T[] tArr) {
        sm acquire = acquire();
        try {
            for (T t : tArr) {
                bind(acquire, t);
                acquire.g1();
            }
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        sm acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                jArr[i] = acquire.g1();
                i++;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        sm acquire = acquire();
        try {
            Long[] lArr = new Long[tArr.length];
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                lArr[i] = Long.valueOf(acquire.g1());
                i++;
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: ql<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        sm acquire = acquire();
        try {
            ArrayList arrayList = new ArrayList(collection.size());
            int i = 0;
            Iterator<? extends T> it = collection.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                arrayList.add(i, Long.valueOf(acquire.g1()));
                i++;
            }
            return arrayList;
        } finally {
            release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: ql<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final void insert(Iterable<? extends T> iterable) {
        sm acquire = acquire();
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                acquire.g1();
            }
        } finally {
            release(acquire);
        }
    }
}
