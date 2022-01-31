package defpackage;

/* renamed from: df5  reason: default package */
/* compiled from: MemoryPolicy */
public enum df5 {
    NO_CACHE(1),
    NO_STORE(2);
    
    public final int index;

    private df5(int i) {
        this.index = i;
    }

    public static boolean shouldReadFromMemoryCache(int i) {
        return (i & NO_CACHE.index) == 0;
    }

    public static boolean shouldWriteToMemoryCache(int i) {
        return (i & NO_STORE.index) == 0;
    }
}
