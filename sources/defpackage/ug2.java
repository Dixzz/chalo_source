package defpackage;

import defpackage.ug2;
import defpackage.ug2.a;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/* renamed from: ug2  reason: default package */
public abstract class ug2<MessageType extends ug2<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends lf2<MessageType, BuilderType> {
    private static Map<Object, ug2<?, ?>> zzjr = new ConcurrentHashMap();
    public ej2 zzjp = ej2.f;
    private int zzjq = -1;

    /* renamed from: ug2$a */
    public static abstract class a<MessageType extends ug2<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends mf2<MessageType, BuilderType> {
        public final MessageType f;
        public MessageType g;
        public boolean h = false;

        public a(MessageType messagetype) {
            this.f = messagetype;
            this.g = (MessageType) ((ug2) messagetype.i(4, null, null));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: ug2$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Object
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            a aVar = (a) this.f.i(5, null, null);
            aVar.g((ug2) i());
            return aVar;
        }

        @Override // defpackage.bi2
        public final /* synthetic */ zh2 f() {
            return this.f;
        }

        public final BuilderType g(MessageType messagetype) {
            h();
            MessageType messagetype2 = this.g;
            ki2.c.b(messagetype2).f(messagetype2, messagetype);
            return this;
        }

        public void h() {
            if (this.h) {
                MessageType messagetype = (MessageType) ((ug2) this.g.i(4, null, null));
                ki2.c.b(messagetype).f(messagetype, this.g);
                this.g = messagetype;
                this.h = false;
            }
        }

        public zh2 i() {
            if (!this.h) {
                MessageType messagetype = this.g;
                ki2.c.b(messagetype).a(messagetype);
                this.h = true;
            }
            return this.g;
        }
    }

    /* renamed from: ug2$b */
    public static class b<T extends ug2<T, ?>> extends nf2<T> {
        public b(T t) {
        }
    }

    /* renamed from: ug2$c */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends ug2<MessageType, BuilderType> implements bi2 {
        public lg2<d> zzjv = lg2.d;
    }

    /* renamed from: ug2$d */
    public static final class d implements og2<d> {
        @Override // defpackage.og2
        public final boolean G() {
            return false;
        }

        @Override // defpackage.og2
        public final rj2 L() {
            return null;
        }

        @Override // defpackage.og2
        public final ei2 N(ei2 ei2, ei2 ei22) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            Objects.requireNonNull((d) obj);
            return 0;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: ug2$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.og2
        public final ai2 u(ai2 ai2, zh2 zh2) {
            return ((a) ai2).g((ug2) zh2);
        }

        @Override // defpackage.og2
        public final boolean v() {
            return false;
        }

        @Override // defpackage.og2
        public final wj2 z() {
            throw null;
        }

        @Override // defpackage.og2
        public final int zzc() {
            return 0;
        }
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    /* renamed from: ug2$e */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f3503a = {1, 2, 3, 4, 5, 6, 7};
    }

    public static Object j(Method method, Object obj, Object... objArr) {
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

    public static <T extends ug2<?, ?>> void k(Class<T> cls, T t) {
        zzjr.put(cls, t);
    }

    public static <T extends ug2<?, ?>> T l(Class<T> cls) {
        T t = (T) zzjr.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (T) zzjr.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (t != null) {
            return t;
        }
        String name = cls.getName();
        throw new IllegalStateException(name.length() != 0 ? "Unable to get default instance for: ".concat(name) : new String("Unable to get default instance for: "));
    }

    @Override // defpackage.zh2
    public final /* synthetic */ ai2 b() {
        a aVar = (a) i(5, null, null);
        aVar.g(this);
        return aVar;
    }

    @Override // defpackage.zh2
    public final void c(bg2 bg2) throws IOException {
        pi2 a2 = ki2.c.a(getClass());
        dg2 dg2 = bg2.f427a;
        if (dg2 == null) {
            dg2 = new dg2(bg2);
        }
        a2.h(this, dg2);
    }

    @Override // defpackage.zh2
    public final /* synthetic */ ai2 d() {
        return (a) i(5, null, null);
    }

    @Override // defpackage.zh2
    public final int e() {
        if (this.zzjq == -1) {
            this.zzjq = ki2.c.b(this).g(this);
        }
        return this.zzjq;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((ug2) i(6, null, null)).getClass().isInstance(obj)) {
            return false;
        }
        return ki2.c.b(this).b(this, (ug2) obj);
    }

    @Override // defpackage.bi2
    public final /* synthetic */ zh2 f() {
        return (ug2) i(6, null, null);
    }

    @Override // defpackage.lf2
    public final void g(int i) {
        this.zzjq = i;
    }

    @Override // defpackage.lf2
    public final int h() {
        return this.zzjq;
    }

    public int hashCode() {
        int i = this.zzex;
        if (i != 0) {
            return i;
        }
        int c2 = ki2.c.b(this).c(this);
        this.zzex = c2;
        return c2;
    }

    public abstract Object i(int i, Object obj, Object obj2);

    @Override // defpackage.bi2
    public final boolean isInitialized() {
        byte byteValue = ((Byte) i(1, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean j = ki2.c.b(this).j(this);
        i(2, j ? this : null, null);
        return j;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        gj1.Y0(this, sb, 0);
        return sb.toString();
    }
}
