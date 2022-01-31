package defpackage;

import java.util.Iterator;

/* renamed from: pl  reason: default package */
/* compiled from: EntityDeletionOrUpdateAdapter */
public abstract class pl<T> extends bm {
    public pl(wl wlVar) {
        super(wlVar);
    }

    public abstract void bind(sm smVar, T t);

    @Override // defpackage.bm
    public abstract String createQuery();

    public final int handle(T t) {
        sm acquire = acquire();
        try {
            bind(acquire, t);
            return acquire.F();
        } finally {
            release(acquire);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: pl<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public final int handleMultiple(Iterable<? extends T> iterable) {
        sm acquire = acquire();
        int i = 0;
        try {
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                bind(acquire, it.next());
                i += acquire.F();
            }
            return i;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        sm acquire = acquire();
        try {
            int i = 0;
            for (T t : tArr) {
                bind(acquire, t);
                i += acquire.F();
            }
            return i;
        } finally {
            release(acquire);
        }
    }
}
