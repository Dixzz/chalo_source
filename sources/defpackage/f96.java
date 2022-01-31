package defpackage;

import java.util.Random;

/* renamed from: f96  reason: default package */
/* compiled from: PlatformRandom.kt */
public final class f96 extends e96 {
    public final a h = new a();

    /* renamed from: f96$a */
    /* compiled from: PlatformRandom.kt */
    public static final class a extends ThreadLocal<Random> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.lang.ThreadLocal
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // defpackage.e96
    public Random b() {
        Object obj = this.h.get();
        n86.d(obj, "implStorage.get()");
        return (Random) obj;
    }
}
