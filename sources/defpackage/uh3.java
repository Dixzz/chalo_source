package defpackage;

import defpackage.uh3;
import defpackage.uh3.b;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: uh3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public abstract class uh3<MessageType extends uh3<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends qg3<MessageType, BuilderType> {
    private static Map<Object, uh3<?, ?>> zzke = new ConcurrentHashMap();
    public jk3 zzkc = jk3.e;
    private int zzkd = -1;

    /* renamed from: uh3$a */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static class a<T extends uh3<T, ?>> extends ug3<T> {
        public a(T t) {
        }
    }

    /* renamed from: uh3$b */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static abstract class b<MessageType extends uh3<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> extends sg3<MessageType, BuilderType> {
        public final MessageType f;
        public MessageType g;
        public boolean h = false;

        public b(MessageType messagetype) {
            this.f = messagetype;
            this.g = (MessageType) ((uh3) messagetype.f(4, null, null));
        }

        public static void c(MessageType messagetype, MessageType messagetype2) {
            rj3.c.b(messagetype).f(messagetype, messagetype2);
        }

        @Override // defpackage.hj3
        public final /* synthetic */ gj3 a() {
            return this.f;
        }

        public final BuilderType b(MessageType messagetype) {
            if (this.h) {
                d();
                this.h = false;
            }
            c(this.g, messagetype);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: uh3$b */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            b bVar = (b) this.f.f(5, null, null);
            bVar.b((uh3) e());
            return bVar;
        }

        public void d() {
            MessageType messagetype = (MessageType) ((uh3) this.g.f(4, null, null));
            rj3.c.b(messagetype).f(messagetype, this.g);
            this.g = messagetype;
        }

        public gj3 e() {
            if (this.h) {
                return this.g;
            }
            MessageType messagetype = this.g;
            rj3.c.b(messagetype).e(messagetype);
            this.h = true;
            return this.g;
        }

        public gj3 f() {
            uh3 uh3 = (uh3) e();
            if (uh3.isInitialized()) {
                return uh3;
            }
            throw new hk3();
        }
    }

    /* renamed from: uh3$c */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static final class c implements rh3<c> {
        @Override // defpackage.rh3
        public final bl3 B() {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.rh3
        public final lj3 C(lj3 lj3, lj3 lj32) {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.rh3
        public final fj3 F(fj3 fj3, gj3 gj3) {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.rh3
        public final boolean H() {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.rh3
        public final uk3 O() {
            throw new NoSuchMethodError();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.rh3
        public final boolean e() {
            throw new NoSuchMethodError();
        }

        @Override // defpackage.rh3
        public final int n() {
            throw new NoSuchMethodError();
        }
    }

    /* renamed from: uh3$d */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static abstract class d<MessageType extends d<MessageType, BuilderType>, BuilderType> extends uh3<MessageType, BuilderType> implements hj3 {
        public ph3<c> zzkj = ph3.d;
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* renamed from: uh3$e */
    /* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3505a = {1, 2, 3, 4, 5, 6, 7};

        public static int[] a() {
            return (int[]) f3505a.clone();
        }
    }

    public static <T extends uh3<?, ?>> T e(Class<T> cls) {
        uh3<?, ?> uh3 = zzke.get(cls);
        if (uh3 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                uh3 = (T) zzke.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (uh3 == null) {
            uh3 = (T) ((uh3) ((uh3) mk3.i(cls)).f(6, null, null));
            if (uh3 != null) {
                zzke.put(cls, uh3);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) uh3;
    }

    public static Object g(Method method, Object obj, Object... objArr) {
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

    public static <T extends uh3<?, ?>> void h(Class<T> cls, T t) {
        zzke.put(cls, t);
    }

    @Override // defpackage.hj3
    public final /* synthetic */ gj3 a() {
        return (uh3) f(6, null, null);
    }

    @Override // defpackage.qg3
    public final int c() {
        return this.zzkd;
    }

    @Override // defpackage.qg3
    public final void d(int i) {
        this.zzkd = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return rj3.c.b(this).b(this, (uh3) obj);
        }
        return false;
    }

    public abstract Object f(int i, Object obj, Object obj2);

    public int hashCode() {
        int i = this.zzga;
        if (i != 0) {
            return i;
        }
        int c2 = rj3.c.b(this).c(this);
        this.zzga = c2;
        return c2;
    }

    public final <MessageType extends uh3<MessageType, BuilderType>, BuilderType extends b<MessageType, BuilderType>> BuilderType i() {
        return (BuilderType) ((b) f(5, null, null));
    }

    @Override // defpackage.hj3
    public final boolean isInitialized() {
        byte byteValue = ((Byte) f(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean g = rj3.c.b(this).g(this);
        f(2, g ? this : null, null);
        return g;
    }

    @Override // defpackage.gj3
    public final int r() {
        if (this.zzkd == -1) {
            this.zzkd = rj3.c.b(this).h(this);
        }
        return this.zzkd;
    }

    @Override // defpackage.gj3
    public final /* synthetic */ fj3 s() {
        b bVar = (b) f(5, null, null);
        bVar.b(this);
        return bVar;
    }

    @Override // defpackage.gj3
    public final void t(hh3 hh3) throws IOException {
        sj3 b2 = rj3.c.b(this);
        jh3 jh3 = hh3.f1372a;
        if (jh3 == null) {
            jh3 = new jh3(hh3);
        }
        b2.i(this, jh3);
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        hd3.M3(this, sb, 0);
        return sb.toString();
    }
}
