package defpackage;

import defpackage.j15;
import defpackage.m05;
import defpackage.q05;
import defpackage.q05.a;
import defpackage.rz4;
import defpackage.s05;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* renamed from: q05  reason: default package */
/* compiled from: GeneratedMessageLite */
public abstract class q05<MessageType extends q05<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends rz4<MessageType, BuilderType> {
    private static Map<Object, q05<?, ?>> defaultInstanceMap = new ConcurrentHashMap();
    public int memoizedSerializedSize = -1;
    public f25 unknownFields = f25.f;

    /* renamed from: q05$a */
    /* compiled from: GeneratedMessageLite */
    public static abstract class a<MessageType extends q05<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> extends rz4.a<MessageType, BuilderType> {
        private final MessageType defaultInstance;
        public MessageType instance;
        public boolean isBuilt = false;

        public a(MessageType messagetype) {
            this.defaultInstance = messagetype;
            this.instance = (MessageType) ((q05) messagetype.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
        }

        private void mergeFromInstance(MessageType messagetype, MessageType messagetype2) {
            t15.c.b(messagetype).a(messagetype, messagetype2);
        }

        public final void copyOnWrite() {
            if (this.isBuilt) {
                copyOnWriteInternal();
                this.isBuilt = false;
            }
        }

        public void copyOnWriteInternal() {
            MessageType messagetype = (MessageType) ((q05) this.instance.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
            mergeFromInstance(messagetype, this.instance);
            this.instance = messagetype;
        }

        @Override // defpackage.k15
        public final boolean isInitialized() {
            return q05.isInitialized(this.instance, false);
        }

        @Override // defpackage.j15.a
        public final MessageType build() {
            MessageType buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw rz4.a.newUninitializedMessageException(buildPartial);
        }

        @Override // defpackage.j15.a
        public MessageType buildPartial() {
            if (this.isBuilt) {
                return this.instance;
            }
            this.instance.makeImmutable();
            this.isBuilt = true;
            return this.instance;
        }

        public final BuilderType clear() {
            this.instance = (MessageType) ((q05) this.instance.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
            return this;
        }

        @Override // defpackage.k15
        public MessageType getDefaultInstanceForType() {
            return this.defaultInstance;
        }

        public BuilderType internalMergeFrom(MessageType messagetype) {
            return mergeFrom((q05) messagetype);
        }

        @Override // defpackage.rz4.a, defpackage.rz4.a, defpackage.rz4.a, java.lang.Object
        public BuilderType clone() {
            BuilderType buildertype = (BuilderType) getDefaultInstanceForType().newBuilderForType();
            buildertype.mergeFrom(buildPartial());
            return buildertype;
        }

        public BuilderType mergeFrom(MessageType messagetype) {
            copyOnWrite();
            mergeFromInstance(this.instance, messagetype);
            return this;
        }

        @Override // defpackage.rz4.a, defpackage.rz4.a
        public BuilderType mergeFrom(byte[] bArr, int i, int i2, i05 i05) throws t05 {
            copyOnWrite();
            try {
                t15.c.b(this.instance).j(this.instance, bArr, i, i + i2, new vz4(i05));
                return this;
            } catch (t05 e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw t05.h();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        @Override // defpackage.rz4.a, defpackage.rz4.a
        public BuilderType mergeFrom(byte[] bArr, int i, int i2) throws t05 {
            return mergeFrom(bArr, i, i2, i05.a());
        }

        @Override // defpackage.rz4.a, defpackage.rz4.a
        public BuilderType mergeFrom(b05 b05, i05 i05) throws IOException {
            copyOnWrite();
            try {
                x15 b = t15.c.b(this.instance);
                MessageType messagetype = this.instance;
                c05 c05 = b05.d;
                if (c05 == null) {
                    c05 = new c05(b05);
                }
                b.i(messagetype, c05, i05);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }
    }

    /* renamed from: q05$b */
    /* compiled from: GeneratedMessageLite */
    public static class b<T extends q05<T, ?>> extends sz4<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f2880a;

        public b(T t) {
            this.f2880a = t;
        }
    }

    /* renamed from: q05$c */
    /* compiled from: GeneratedMessageLite */
    public static abstract class c<MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>> extends q05<MessageType, BuilderType> implements Object<MessageType, BuilderType> {
        public m05<d> extensions = m05.d;

        public m05<d> a() {
            m05<d> m05 = this.extensions;
            if (m05.b) {
                this.extensions = m05.clone();
            }
            return this.extensions;
        }

        @Override // defpackage.q05, defpackage.q05, defpackage.k15
        public /* bridge */ /* synthetic */ j15 getDefaultInstanceForType() {
            return q05.super.getDefaultInstanceForType();
        }

        @Override // defpackage.q05, defpackage.q05, defpackage.j15
        public /* bridge */ /* synthetic */ j15.a newBuilderForType() {
            return q05.super.newBuilderForType();
        }

        @Override // defpackage.q05, defpackage.q05, defpackage.j15
        public /* bridge */ /* synthetic */ j15.a toBuilder() {
            return q05.super.toBuilder();
        }
    }

    /* renamed from: q05$d */
    /* compiled from: GeneratedMessageLite */
    public static final class d implements m05.a<d> {
        public final s05.d<?> f;
        public final int g;
        public final l25 h;
        public final boolean i;
        public final boolean j;

        public d(s05.d<?> dVar, int i2, l25 l25, boolean z, boolean z2) {
            this.f = dVar;
            this.g = i2;
            this.h = l25;
            this.i = z;
            this.j = z2;
        }

        @Override // defpackage.m05.a
        public boolean b() {
            return this.i;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            return this.g - ((d) obj).g;
        }

        @Override // defpackage.m05.a
        public l25 d() {
            return this.h;
        }

        @Override // defpackage.m05.a
        public int getNumber() {
            return this.g;
        }

        @Override // defpackage.m05.a
        public boolean isPacked() {
            return this.j;
        }

        @Override // defpackage.m05.a
        public m25 s() {
            return this.h.getJavaType();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: q05$a */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.m05.a
        public j15.a y(j15.a aVar, j15 j15) {
            return ((a) aVar).mergeFrom((q05) j15);
        }
    }

    /* renamed from: q05$e */
    /* compiled from: GeneratedMessageLite */
    public static class e<ContainingType extends j15, Type> extends g05<ContainingType, Type> {

        /* renamed from: a  reason: collision with root package name */
        public final ContainingType f2881a;
        public final Type b;
        public final j15 c;
        public final d d;

        /* JADX WARN: Incorrect args count in method signature: (TContainingType;TType;Lj15;Lq05$d;Ljava/lang/Class;)V */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: j15 */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        public e(j15 j15, Object obj, j15 j152, d dVar) {
            if (j15 == 0) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (dVar.h == l25.MESSAGE && j152 == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.f2881a = j15;
                this.b = obj;
                this.c = j152;
                this.d = dVar;
            }
        }
    }

    /* renamed from: q05$f */
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

    /* access modifiers changed from: private */
    public static <MessageType extends c<MessageType, BuilderType>, BuilderType extends Object<MessageType, BuilderType>, T> e<MessageType, T> checkIsLite(g05<MessageType, T> g05) {
        Objects.requireNonNull(g05);
        return (e) g05;
    }

    private static <T extends q05<T, ?>> T checkMessageInitialized(T t) throws t05 {
        if (t == null || t.isInitialized()) {
            return t;
        }
        d25 newUninitializedMessageException = t.newUninitializedMessageException();
        Objects.requireNonNull(newUninitializedMessageException);
        throw new t05(newUninitializedMessageException.getMessage());
    }

    public static s05.a emptyBooleanList() {
        return xz4.i;
    }

    public static s05.b emptyDoubleList() {
        return f05.i;
    }

    public static s05.f emptyFloatList() {
        return o05.i;
    }

    public static s05.g emptyIntList() {
        return r05.i;
    }

    public static s05.i emptyLongList() {
        return a15.i;
    }

    public static <E> s05.j<E> emptyProtobufList() {
        return u15.i;
    }

    private final void ensureUnknownFieldsInitialized() {
        if (this.unknownFields == f25.f) {
            this.unknownFields = f25.e();
        }
    }

    public static <T extends q05<?, ?>> T getDefaultInstance(Class<T> cls) {
        q05<?, ?> q05 = defaultInstanceMap.get(cls);
        if (q05 == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                q05 = (T) defaultInstanceMap.get(cls);
            } catch (ClassNotFoundException e2) {
                throw new IllegalStateException("Class initialization cannot fail.", e2);
            }
        }
        if (q05 == null) {
            q05 = (T) ((q05) i25.b(cls)).getDefaultInstanceForType();
            if (q05 != null) {
                defaultInstanceMap.put(cls, q05);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) q05;
    }

    public static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            StringBuilder i0 = hj1.i0("Generated message class \"");
            i0.append(cls.getName());
            i0.append("\" missing method \"");
            i0.append(str);
            i0.append("\".");
            throw new RuntimeException(i0.toString(), e2);
        }
    }

    public static Object invokeOrDie(Method method, Object obj, Object... objArr) {
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

    public static s05.g mutableCopy(s05.g gVar) {
        int i = ((r05) gVar).h;
        return ((r05) gVar).f(i == 0 ? 10 : i * 2);
    }

    public static Object newMessageInfo(j15 j15, String str, Object[] objArr) {
        return new v15(j15, str, objArr);
    }

    public static <ContainingType extends j15, Type> e<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, j15 j15, s05.d<?> dVar, int i, l25 l25, boolean z, Class cls) {
        return new e<>(containingtype, Collections.emptyList(), j15, new d(dVar, i, l25, true, z));
    }

    public static <ContainingType extends j15, Type> e<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, j15 j15, s05.d<?> dVar, int i, l25 l25, Class cls) {
        return new e<>(containingtype, type, j15, new d(dVar, i, l25, false, false));
    }

    public static <T extends q05<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream) throws t05 {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, i05.a()));
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer, i05 i05) throws t05 {
        return (T) checkMessageInitialized(parseFrom(t, b05.g(byteBuffer, false), i05));
    }

    private static <T extends q05<T, ?>> T parsePartialDelimitedFrom(T t, InputStream inputStream, i05 i05) throws t05 {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            b05 f2 = b05.f(new rz4.a.C0051a(inputStream, b05.t(read, inputStream)));
            T t2 = (T) parsePartialFrom(t, f2, i05);
            try {
                f2.a(0);
                return t2;
            } catch (t05 e2) {
                throw e2;
            }
        } catch (IOException e3) {
            throw new t05(e3.getMessage());
        }
    }

    public static <T extends q05<T, ?>> T parsePartialFrom(T t, b05 b05, i05 i05) throws t05 {
        T t2 = (T) ((q05) t.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
        try {
            x15 b2 = t15.c.b(t2);
            c05 c05 = b05.d;
            if (c05 == null) {
                c05 = new c05(b05);
            }
            b2.i(t2, c05, i05);
            b2.e(t2);
            return t2;
        } catch (IOException e2) {
            if (e2.getCause() instanceof t05) {
                throw ((t05) e2.getCause());
            }
            throw new t05(e2.getMessage());
        } catch (RuntimeException e3) {
            if (e3.getCause() instanceof t05) {
                throw ((t05) e3.getCause());
            }
            throw e3;
        }
    }

    public static <T extends q05<?, ?>> void registerDefaultInstance(Class<T> cls, T t) {
        defaultInstanceMap.put(cls, t);
    }

    public Object buildMessageInfo() throws Exception {
        return dynamicMethod(f.BUILD_MESSAGE_INFO);
    }

    public final <MessageType extends q05<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder() {
        return (BuilderType) ((a) dynamicMethod(f.NEW_BUILDER));
    }

    public Object dynamicMethod(f fVar, Object obj) {
        return dynamicMethod(fVar, obj, null);
    }

    public abstract Object dynamicMethod(f fVar, Object obj, Object obj2);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getDefaultInstanceForType().getClass().isInstance(obj)) {
            return false;
        }
        return t15.c.b(this).b(this, (q05) obj);
    }

    @Override // defpackage.rz4
    public int getMemoizedSerializedSize() {
        return this.memoizedSerializedSize;
    }

    public final q15<MessageType> getParserForType() {
        return (q15) dynamicMethod(f.GET_PARSER);
    }

    @Override // defpackage.j15
    public int getSerializedSize() {
        if (this.memoizedSerializedSize == -1) {
            this.memoizedSerializedSize = t15.c.b(this).g(this);
        }
        return this.memoizedSerializedSize;
    }

    public int hashCode() {
        int i = this.memoizedHashCode;
        if (i != 0) {
            return i;
        }
        int c2 = t15.c.b(this).c(this);
        this.memoizedHashCode = c2;
        return c2;
    }

    @Override // defpackage.k15
    public final boolean isInitialized() {
        return isInitialized(this, true);
    }

    public void makeImmutable() {
        t15.c.b(this).e(this);
    }

    public void mergeLengthDelimitedField(int i, a05 a05) {
        ensureUnknownFieldsInitialized();
        f25 f25 = this.unknownFields;
        f25.a();
        if (i != 0) {
            f25.f((i << 3) | 2, a05);
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public final void mergeUnknownFields(f25 f25) {
        this.unknownFields = f25.d(this.unknownFields, f25);
    }

    public void mergeVarintField(int i, int i2) {
        ensureUnknownFieldsInitialized();
        f25 f25 = this.unknownFields;
        f25.a();
        if (i != 0) {
            f25.f((i << 3) | 0, Long.valueOf((long) i2));
            return;
        }
        throw new IllegalArgumentException("Zero is not a valid field number.");
    }

    public boolean parseUnknownField(int i, b05 b05) throws IOException {
        if ((i & 7) == 4) {
            return false;
        }
        ensureUnknownFieldsInitialized();
        return this.unknownFields.c(i, b05);
    }

    @Override // defpackage.rz4
    public void setMemoizedSerializedSize(int i) {
        this.memoizedSerializedSize = i;
    }

    public String toString() {
        String obj = super.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(obj);
        hd3.C2(this, sb, 0);
        return sb.toString();
    }

    @Override // defpackage.j15
    public void writeTo(d05 d05) throws IOException {
        x15 b2 = t15.c.b(this);
        e05 e05 = d05.f774a;
        if (e05 == null) {
            e05 = new e05(d05);
        }
        b2.h(this, e05);
    }

    public static final <T extends q05<T, ?>> boolean isInitialized(T t, boolean z) {
        byte byteValue = ((Byte) t.dynamicMethod(f.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean f2 = t15.c.b(t).f(t);
        if (z) {
            t.dynamicMethod(f.SET_MEMOIZED_IS_INITIALIZED, f2 ? t : null);
        }
        return f2;
    }

    public final <MessageType extends q05<MessageType, BuilderType>, BuilderType extends a<MessageType, BuilderType>> BuilderType createBuilder(MessageType messagetype) {
        return (BuilderType) createBuilder().mergeFrom(messagetype);
    }

    public Object dynamicMethod(f fVar) {
        return dynamicMethod(fVar, null, null);
    }

    @Override // defpackage.k15
    public final MessageType getDefaultInstanceForType() {
        return (MessageType) ((q05) dynamicMethod(f.GET_DEFAULT_INSTANCE));
    }

    @Override // defpackage.j15
    public final BuilderType newBuilderForType() {
        return (BuilderType) ((a) dynamicMethod(f.NEW_BUILDER));
    }

    @Override // defpackage.j15
    public final BuilderType toBuilder() {
        BuilderType buildertype = (BuilderType) ((a) dynamicMethod(f.NEW_BUILDER));
        buildertype.mergeFrom(this);
        return buildertype;
    }

    public static s05.i mutableCopy(s05.i iVar) {
        int i = ((a15) iVar).h;
        return ((a15) iVar).f(i == 0 ? 10 : i * 2);
    }

    public static <T extends q05<T, ?>> T parseDelimitedFrom(T t, InputStream inputStream, i05 i05) throws t05 {
        return (T) checkMessageInitialized(parsePartialDelimitedFrom(t, inputStream, i05));
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, ByteBuffer byteBuffer) throws t05 {
        return (T) parseFrom(t, byteBuffer, i05.a());
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, a05 a05) throws t05 {
        return (T) checkMessageInitialized(parseFrom(t, a05, i05.a()));
    }

    public static s05.f mutableCopy(s05.f fVar) {
        int i = ((o05) fVar).h;
        return ((o05) fVar).f(i == 0 ? 10 : i * 2);
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, a05 a05, i05 i05) throws t05 {
        return (T) checkMessageInitialized(parsePartialFrom(t, a05, i05));
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, byte[] bArr) throws t05 {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, i05.a()));
    }

    public static s05.b mutableCopy(s05.b bVar) {
        int i = ((f05) bVar).h;
        return ((f05) bVar).f(i == 0 ? 10 : i * 2);
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, byte[] bArr, i05 i05) throws t05 {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, i05));
    }

    public static s05.a mutableCopy(s05.a aVar) {
        int i = ((xz4) aVar).h;
        return ((xz4) aVar).f(i == 0 ? 10 : i * 2);
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, InputStream inputStream) throws t05 {
        return (T) checkMessageInitialized(parsePartialFrom(t, b05.f(inputStream), i05.a()));
    }

    public static <T extends q05<T, ?>> T parsePartialFrom(T t, byte[] bArr, int i, int i2, i05 i05) throws t05 {
        T t2 = (T) ((q05) t.dynamicMethod(f.NEW_MUTABLE_INSTANCE));
        try {
            x15 b2 = t15.c.b(t2);
            b2.j(t2, bArr, i, i + i2, new vz4(i05));
            b2.e(t2);
            if (t2.memoizedHashCode == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e2) {
            if (e2.getCause() instanceof t05) {
                throw ((t05) e2.getCause());
            }
            throw new t05(e2.getMessage());
        } catch (IndexOutOfBoundsException unused) {
            throw t05.h();
        }
    }

    public static <E> s05.j<E> mutableCopy(s05.j<E> jVar) {
        int size = jVar.size();
        return jVar.f(size == 0 ? 10 : size * 2);
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, InputStream inputStream, i05 i05) throws t05 {
        return (T) checkMessageInitialized(parsePartialFrom(t, b05.f(inputStream), i05));
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, b05 b05) throws t05 {
        return (T) parseFrom(t, b05, i05.a());
    }

    public static <T extends q05<T, ?>> T parseFrom(T t, b05 b05, i05 i05) throws t05 {
        return (T) checkMessageInitialized(parsePartialFrom(t, b05, i05));
    }

    public static <T extends q05<T, ?>> T parsePartialFrom(T t, b05 b05) throws t05 {
        return (T) parsePartialFrom(t, b05, i05.a());
    }

    private static <T extends q05<T, ?>> T parsePartialFrom(T t, a05 a05, i05 i05) throws t05 {
        try {
            b05 v = a05.v();
            T t2 = (T) parsePartialFrom(t, v, i05);
            try {
                v.a(0);
                return t2;
            } catch (t05 e2) {
                throw e2;
            }
        } catch (t05 e3) {
            throw e3;
        }
    }

    private static <T extends q05<T, ?>> T parsePartialFrom(T t, byte[] bArr, i05 i05) throws t05 {
        return (T) checkMessageInitialized(parsePartialFrom(t, bArr, 0, bArr.length, i05));
    }
}
