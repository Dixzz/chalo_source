package defpackage;

import defpackage.ru3;
import defpackage.ru3.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: ru3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
public abstract class ru3<MessageType extends ru3<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends it3<MessageType, BuilderType> {
    private static Map<Object, ru3<?, ?>> zzd = new ConcurrentHashMap();
    public dx3 zzb = dx3.f;
    private int zzc = -1;

    /* renamed from: ru3$a */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class a<T extends ru3<T, ?>> extends mt3<T> {
        public a(T t) {
        }
    }

    /* renamed from: ru3$b */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class b<MessageType extends ru3<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends kt3<MessageType, BuilderType> {
        public final MessageType f;
        public MessageType g;
        public boolean h = false;

        public b(MessageType messagetype) {
            this.f = messagetype;
            this.g = (MessageType) ((ru3) messagetype.n(4, null, null));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: ru3$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) this.f.n(5, null, null);
            bVar.f((ru3) j());
            return bVar;
        }

        @Override // defpackage.dw3
        public final /* synthetic */ cw3 d() {
            return this.f;
        }

        public final BuilderType f(MessageType messagetype) {
            if (this.h) {
                i();
                this.h = false;
            }
            MessageType messagetype2 = this.g;
            nw3.c.b(messagetype2).b(messagetype2, messagetype);
            return this;
        }

        /* JADX WARN: Incorrect args count in method signature: ([BIILeu3;)TBuilderType; */
        public final b h(byte[] bArr, int i, eu3 eu3) throws cv3 {
            if (this.h) {
                i();
                this.h = false;
            }
            try {
                nw3.c.b(this.g).f(this.g, bArr, 0, i, new pt3(eu3));
                return this;
            } catch (cv3 e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw cv3.a();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        public void i() {
            MessageType messagetype = (MessageType) ((ru3) this.g.n(4, null, null));
            nw3.c.b(messagetype).b(messagetype, this.g);
            this.g = messagetype;
        }

        public cw3 j() {
            if (this.h) {
                return this.g;
            }
            MessageType messagetype = this.g;
            nw3.c.b(messagetype).a(messagetype);
            this.h = true;
            return this.g;
        }

        public cw3 k() {
            ru3 ru3 = (ru3) j();
            if (ru3.c()) {
                return ru3;
            }
            throw new cx3();
        }
    }

    /* renamed from: ru3$c */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class c implements mu3<c> {
        @Override // defpackage.mu3
        public final bw3 I(bw3 bw3, cw3 cw3) {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.mu3
        public final fw3 Q(fw3 fw3, fw3 fw32) {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.mu3
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.mu3
        public final qx3 zzb() {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.mu3
        public final xx3 zzc() {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.mu3
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.mu3
        public final boolean zze() {
            throw new NoSuchMethodError();
        }
    }

    /* renamed from: ru3$d */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends ru3<MessageType, BuilderType> implements dw3 {
        public ku3<c> zzc = ku3.d;

        public final ku3<c> t() {
            ku3<c> ku3 = this.zzc;
            if (ku3.b) {
                this.zzc = (ku3) ku3.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* renamed from: ru3$e */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3134a = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) f3134a.clone();
        }
    }

    /* renamed from: ru3$f */
    /* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
    public static class f<ContainingType extends cw3, Type> extends fu3<ContainingType, Type> {
    }

    public static <T extends ru3<?, ?>> T k(Class<T> cls) {
        ru3<?, ?> ru3 = zzd.get(cls);
        if (ru3 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                ru3 = (T) zzd.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (ru3 == null) {
            ru3 = (T) ((ru3) ((ru3) kx3.c(cls)).n(6, null, null));
            if (ru3 != null) {
                zzd.put(cls, ru3);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) ru3;
    }

    public static <E> zu3<E> l(zu3<E> zu3) {
        int size = zu3.size();
        return zu3.j(size == 0 ? 10 : size << 1);
    }

    public static av3 m(av3 av3) {
        int i = ((qv3) av3).h;
        return ((qv3) av3).j(i == 0 ? 10 : i << 1);
    }

    public static Object o(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    public static <T extends ru3<?, ?>> void p(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    @Override // defpackage.cw3
    public final int a() {
        if (this.zzc == -1) {
            this.zzc = nw3.c.b(this).c(this);
        }
        return this.zzc;
    }

    @Override // defpackage.cw3
    public final void b(bu3 bu3) throws IOException {
        qw3 b2 = nw3.c.b(this);
        du3 du3 = bu3.f475a;
        if (du3 == null) {
            du3 = new du3(bu3);
        }
        b2.e(this, du3);
    }

    @Override // defpackage.dw3
    public final boolean c() {
        byte byteValue = ((Byte) n(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean g = nw3.c.b(this).g(this);
        n(2, g ? this : null, null);
        return g;
    }

    @Override // defpackage.dw3
    public final /* synthetic */ cw3 d() {
        return (ru3) n(6, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return nw3.c.b(this).h(this, (ru3) obj);
        }
        return false;
    }

    @Override // defpackage.cw3
    public final /* synthetic */ bw3 g() {
        b bVar = (b) n(5, null, null);
        bVar.f(this);
        return bVar;
    }

    public int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int d2 = nw3.c.b(this).d(this);
        this.zza = d2;
        return d2;
    }

    @Override // defpackage.it3
    public final int i() {
        return this.zzc;
    }

    @Override // defpackage.it3
    public final void j(int i) {
        this.zzc = i;
    }

    public abstract Object n(int i, Object obj, Object obj2);

    public final <MessageType extends ru3<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType q() {
        return (BuilderType) ((b) n(5, null, null));
    }

    @Override // defpackage.cw3
    public final /* synthetic */ bw3 r() {
        return (b) n(5, null, null);
    }

    public final BuilderType s() {
        BuilderType buildertype = (BuilderType) ((b) n(5, null, null));
        buildertype.f(this);
        return buildertype;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        hd3.N3(this, sb, 0);
        return sb.toString();
    }
}
