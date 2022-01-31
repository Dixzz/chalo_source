package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: zg  reason: default package */
/* compiled from: Lifecycle */
public abstract class zg {

    /* renamed from: a  reason: collision with root package name */
    public AtomicReference<Object> f4167a = new AtomicReference<>();

    /* renamed from: zg$a */
    /* compiled from: Lifecycle */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static a downFrom(b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal == 2) {
                return ON_DESTROY;
            }
            if (ordinal == 3) {
                return ON_STOP;
            }
            if (ordinal != 4) {
                return null;
            }
            return ON_PAUSE;
        }

        public static a downTo(b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal == 0) {
                return ON_DESTROY;
            }
            if (ordinal == 2) {
                return ON_STOP;
            }
            if (ordinal != 3) {
                return null;
            }
            return ON_PAUSE;
        }

        public static a upFrom(b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal == 1) {
                return ON_CREATE;
            }
            if (ordinal == 2) {
                return ON_START;
            }
            if (ordinal != 3) {
                return null;
            }
            return ON_RESUME;
        }

        public static a upTo(b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal == 2) {
                return ON_CREATE;
            }
            if (ordinal == 3) {
                return ON_START;
            }
            if (ordinal != 4) {
                return null;
            }
            return ON_RESUME;
        }

        public b getTargetState() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        return b.RESUMED;
                    }
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                return b.DESTROYED;
                            }
                            throw new IllegalArgumentException(this + " has no target state");
                        }
                    }
                }
                return b.STARTED;
            }
            return b.CREATED;
        }
    }

    /* renamed from: zg$b */
    /* compiled from: Lifecycle */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean isAtLeast(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    public abstract void a(eh ehVar);

    public abstract void b(eh ehVar);
}
