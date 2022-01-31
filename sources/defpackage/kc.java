package defpackage;

import defpackage.dd;
import defpackage.gc;
import defpackage.kc;
import defpackage.kc.a;
import defpackage.nb;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/* renamed from: kc  reason: default package */
/* compiled from: GeneratedMessageLite */
public abstract class kc<MessageType extends kc<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends nb<MessageType, BuilderType> {
    private static Map<Object, kc<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    public int memoizedSerializedSize = -1;
    public zd unknownFields = zd.f;

    /* renamed from: kc$a */
    /* compiled from: GeneratedMessageLite */
    public static abstract class a<MessageType extends kc<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends nb.a<MessageType, BuilderType> {
        public final MessageType f;
        public MessageType g;
        public boolean h = false;

        public a(MessageType messagetype) {
            this.f = messagetype;
            this.g = (MessageType) ((kc) messagetype.f(f.NEW_MUTABLE_INSTANCE));
        }

        public final MessageType b() {
            MessageType c = c();
            if (c.isInitialized()) {
                return c;
            }
            throw new xd();
        }

        public MessageType c() {
            if (this.h) {
                return this.g;
            }
            MessageType messagetype = this.g;
            Objects.requireNonNull(messagetype);
            nd.c.b(messagetype).e(messagetype);
            this.h = true;
            return this.g;
        }

        @Override // java.lang.Object
        public Object clone() throws CloneNotSupportedException {
            a k = this.f.newBuilderForType();
            k.e(c());
            return k;
        }

        public void d() {
            if (this.h) {
                MessageType messagetype = (MessageType) ((kc) this.g.f(f.NEW_MUTABLE_INSTANCE));
                nd.c.b(messagetype).a(messagetype, this.g);
                this.g = messagetype;
                this.h = false;
            }
        }

        public BuilderType e(MessageType messagetype) {
            d();
            f(this.g, messagetype);
            return this;
        }

        public final void f(MessageType messagetype, MessageType messagetype2) {
            nd.c.b(messagetype).a(messagetype, messagetype2);
        }

        @Override // defpackage.ed
        public dd getDefaultInstanceForType() {
            return this.f;
        }
    }

    /* renamed from: kc$b */
    /* compiled from: GeneratedMessageLite */
    public static class b<T extends kc<T, ?>> extends ob<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f2046a;

        public b(T t) {
            this.f2046a = t;
        }
    }

    /* renamed from: kc$c */
    /* compiled from: GeneratedMessageLite */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends kc<MessageType, BuilderType> implements Object<MessageType, BuilderType> {
        public gc<d> extensions = gc.d;

        @Override // defpackage.kc, defpackage.ed
        public /* bridge */ /* synthetic */ dd getDefaultInstanceForType() {
            return getDefaultInstanceForType();
        }

        @Override // defpackage.dd, defpackage.kc
        public /* bridge */ /* synthetic */ dd.a newBuilderForType() {
            return newBuilderForType();
        }

        @Override // defpackage.dd, defpackage.kc
        public dd.a toBuilder() {
            a aVar = (a) f(f.NEW_BUILDER);
            aVar.d();
            aVar.f(aVar.g, this);
            return aVar;
        }
    }

    /* renamed from: kc$d */
    /* compiled from: GeneratedMessageLite */
    public static final class d implements gc.a<d> {
        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: kc$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.gc.a
        public dd.a R(dd.a aVar, dd ddVar) {
            a aVar2 = (a) aVar;
            aVar2.e((kc) ddVar);
            return aVar2;
        }

        @Override // defpackage.gc.a
        public boolean b() {
            return false;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            Objects.requireNonNull((d) obj);
            return 0;
        }

        @Override // defpackage.gc.a
        public fe d() {
            return null;
        }

        @Override // defpackage.gc.a
        public int getNumber() {
            return 0;
        }

        @Override // defpackage.gc.a
        public boolean isPacked() {
            return false;
        }

        @Override // defpackage.gc.a
        public ge s() {
            throw null;
        }
    }

    /* renamed from: kc$e */
    /* compiled from: GeneratedMessageLite */
    public static class e<ContainingType extends dd, Type> extends ac<ContainingType, Type> {
    }

    /* renamed from: kc$f */
    /* compiled from: GeneratedMessageLite */
    public enum f {
        GET_MEMOIZED_IS_INITIALIZED,
        SET_MEMOIZED_IS_INITIALIZED,
        BUILD_MESSAGE_INFO,
        NEW_MUTABLE_INSTANCE,
        NEW_BUILDER,
        GET_DEFAULT_INSTANCE,
        GET_PARSER
    }

    public static <T extends kc<?, ?>> T h(Class<T> cls) {
        kc<?, ?> kcVar = defaultInstanceMap.get(cls);
        if (kcVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                kcVar = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (kcVar == null) {
            kcVar = (T) ((kc) ce.a(cls)).getDefaultInstanceForType();
            if (kcVar != null) {
                defaultInstanceMap.put(cls, kcVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) kcVar;
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

    public static <T extends kc<T, ?>> T l(T t, vb vbVar, cc ccVar) throws nc {
        T t2 = (T) ((kc) t.f(f.NEW_MUTABLE_INSTANCE));
        try {
            rd b2 = nd.c.b(t2);
            wb wbVar = vbVar.d;
            if (wbVar == null) {
                wbVar = new wb(vbVar);
            }
            b2.h(t2, wbVar, ccVar);
            b2.e(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof nc) {
                throw ((nc) e2.getCause());
            }
            throw new nc(e2.getMessage());
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof nc) {
                throw ((nc) e3.getCause());
            }
            throw e3;
        }
    }

    public static <T extends kc<?, ?>> void m(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    @Override // defpackage.dd
    public void a(xb xbVar) throws IOException {
        rd b2 = nd.c.b(this);
        yb ybVar = xbVar.f3910a;
        if (ybVar == null) {
            ybVar = new yb(xbVar);
        }
        b2.i(this, ybVar);
    }

    @Override // defpackage.nb
    public int b() {
        return this.memoizedSerializedSize;
    }

    @Override // defpackage.nb
    public void d(int i) {
        this.memoizedSerializedSize = i;
    }

    public final <MessageType extends kc<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType e() {
        return (BuilderType) ((a) f(f.NEW_BUILDER));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return nd.c.b(this).b(this, (kc) obj);
    }

    public Object f(f fVar) {
        return g(fVar, null, null);
    }

    public abstract Object g(f fVar, Object obj, Object obj2);

    @Override // defpackage.dd
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = nd.c.b(this).g(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int c2 = nd.c.b(this).c(this);
        this.memoizedHashCode = c2;
        return c2;
    }

    /* renamed from: i */
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) ((kc) f(f.GET_DEFAULT_INSTANCE));
    }

    @Override // defpackage.ed
    public final boolean isInitialized() {
        byte byteValue = ((Byte) f(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean f2 = nd.c.b(this).f(this);
        g(f.SET_MEMOIZED_IS_INITIALIZED, f2 ? this : null, null);
        return f2;
    }

    /* renamed from: k */
    public final BuilderType newBuilderForType() {
        return (BuilderType) ((a) f(f.NEW_BUILDER));
    }

    @Override // defpackage.dd
    public dd.a toBuilder() {
        a aVar = (a) f(f.NEW_BUILDER);
        aVar.d();
        aVar.f(aVar.g, this);
        return aVar;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        h.p0(this, sb, 0);
        return sb.toString();
    }
}
