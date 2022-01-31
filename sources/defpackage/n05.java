package defpackage;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;

/* JADX WARN: Init of enum DOUBLE can be incorrect */
/* JADX WARN: Init of enum FLOAT can be incorrect */
/* JADX WARN: Init of enum INT64 can be incorrect */
/* JADX WARN: Init of enum UINT64 can be incorrect */
/* JADX WARN: Init of enum INT32 can be incorrect */
/* JADX WARN: Init of enum FIXED64 can be incorrect */
/* JADX WARN: Init of enum FIXED32 can be incorrect */
/* JADX WARN: Init of enum BOOL can be incorrect */
/* JADX WARN: Init of enum STRING can be incorrect */
/* JADX WARN: Init of enum MESSAGE can be incorrect */
/* JADX WARN: Init of enum BYTES can be incorrect */
/* JADX WARN: Init of enum UINT32 can be incorrect */
/* JADX WARN: Init of enum ENUM can be incorrect */
/* JADX WARN: Init of enum SFIXED32 can be incorrect */
/* JADX WARN: Init of enum SFIXED64 can be incorrect */
/* JADX WARN: Init of enum SINT32 can be incorrect */
/* JADX WARN: Init of enum SINT64 can be incorrect */
/* JADX WARN: Init of enum GROUP can be incorrect */
/* JADX WARN: Init of enum DOUBLE_LIST can be incorrect */
/* JADX WARN: Init of enum FLOAT_LIST can be incorrect */
/* JADX WARN: Init of enum INT64_LIST can be incorrect */
/* JADX WARN: Init of enum UINT64_LIST can be incorrect */
/* JADX WARN: Init of enum INT32_LIST can be incorrect */
/* JADX WARN: Init of enum FIXED64_LIST can be incorrect */
/* JADX WARN: Init of enum FIXED32_LIST can be incorrect */
/* JADX WARN: Init of enum BOOL_LIST can be incorrect */
/* JADX WARN: Init of enum STRING_LIST can be incorrect */
/* JADX WARN: Init of enum MESSAGE_LIST can be incorrect */
/* JADX WARN: Init of enum BYTES_LIST can be incorrect */
/* JADX WARN: Init of enum UINT32_LIST can be incorrect */
/* JADX WARN: Init of enum ENUM_LIST can be incorrect */
/* JADX WARN: Init of enum SFIXED32_LIST can be incorrect */
/* JADX WARN: Init of enum SFIXED64_LIST can be incorrect */
/* JADX WARN: Init of enum SINT32_LIST can be incorrect */
/* JADX WARN: Init of enum SINT64_LIST can be incorrect */
/* JADX WARN: Init of enum DOUBLE_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum FLOAT_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum INT64_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum UINT64_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum INT32_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum FIXED64_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum FIXED32_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum BOOL_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum UINT32_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum ENUM_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum SFIXED32_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum SFIXED64_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum SINT32_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum SINT64_LIST_PACKED can be incorrect */
/* JADX WARN: Init of enum GROUP_LIST can be incorrect */
/* renamed from: n05  reason: default package */
/* compiled from: FieldType */
public enum n05 {
    DOUBLE(0, r7, r8),
    FLOAT(1, r7, r9),
    INT64(2, r7, r10),
    UINT64(3, r7, r10),
    INT32(4, r7, r11),
    FIXED64(5, r7, r10),
    FIXED32(6, r7, r11),
    BOOL(7, r7, r12),
    STRING(8, r7, r13),
    MESSAGE(9, r7, r14),
    BYTES(10, r7, r15),
    UINT32(11, r7, r11),
    ENUM(12, r7, r16),
    SFIXED32(13, r7, r11),
    SFIXED64(14, r7, r10),
    SINT32(15, r7, r11),
    SINT64(16, r7, r10),
    GROUP(17, r7, r14),
    DOUBLE_LIST(18, r7, r8),
    FLOAT_LIST(19, r7, r9),
    INT64_LIST(20, r7, r10),
    UINT64_LIST(21, r7, r10),
    INT32_LIST(22, r7, r11),
    FIXED64_LIST(23, r7, r10),
    FIXED32_LIST(24, r7, r11),
    BOOL_LIST(25, r7, r12),
    STRING_LIST(26, r7, r13),
    MESSAGE_LIST(27, r7, r14),
    BYTES_LIST(28, r7, r15),
    UINT32_LIST(29, r7, r11),
    ENUM_LIST(30, r7, r16),
    SFIXED32_LIST(31, r7, r11),
    SFIXED64_LIST(32, r7, r10),
    SINT32_LIST(33, r7, r11),
    SINT64_LIST(34, r7, r10),
    DOUBLE_LIST_PACKED(35, r13, r8),
    FLOAT_LIST_PACKED(36, r13, r9),
    INT64_LIST_PACKED(37, r13, r10),
    UINT64_LIST_PACKED(38, r13, r10),
    INT32_LIST_PACKED(39, r13, r11),
    FIXED64_LIST_PACKED(40, r13, r10),
    FIXED32_LIST_PACKED(41, r13, r11),
    BOOL_LIST_PACKED(42, r13, r12),
    UINT32_LIST_PACKED(43, r13, r11),
    ENUM_LIST_PACKED(44, r13, r16),
    SFIXED32_LIST_PACKED(45, r13, r11),
    SFIXED64_LIST_PACKED(46, r13, r8),
    SINT32_LIST_PACKED(47, r13, u05.INT),
    SINT64_LIST_PACKED(48, r13, r8),
    GROUP_LIST(49, r7, r14),
    MAP(50, a.MAP, u05.VOID);
    
    private static final Type[] EMPTY_TYPES = new Type[0];
    private static final n05[] VALUES = new n05[51];
    private final a collection;
    private final Class<?> elementType;
    private final int id;
    private final u05 javaType;
    private final boolean primitiveScalar;

    /* renamed from: n05$a */
    /* compiled from: FieldType */
    public enum a {
        SCALAR(false),
        VECTOR(true),
        PACKED_VECTOR(true),
        MAP(false);
        
        private final boolean isList;

        private a(boolean z) {
            this.isList = z;
        }

        public boolean isList() {
            return this.isList;
        }
    }

    /* access modifiers changed from: public */
    static {
        a aVar = a.SCALAR;
        u05 u05 = u05.DOUBLE;
        u05 u052 = u05.FLOAT;
        u05 u053 = u05.LONG;
        u05 u054 = u05.INT;
        u05 u055 = u05.BOOLEAN;
        u05 u056 = u05.STRING;
        u05 u057 = u05.MESSAGE;
        u05 u058 = u05.BYTE_STRING;
        u05 u059 = u05.ENUM;
        a aVar2 = a.VECTOR;
        a aVar3 = a.PACKED_VECTOR;
        u05 u0510 = u05.LONG;
        n05[] values = values();
        for (n05 n05 : values) {
            VALUES[n05.id] = n05;
        }
    }

    private n05(int i, a aVar, u05 u05) {
        int ordinal;
        this.id = i;
        this.collection = aVar;
        this.javaType = u05;
        int ordinal2 = aVar.ordinal();
        boolean z = true;
        if (ordinal2 == 1) {
            this.elementType = u05.getBoxedType();
        } else if (ordinal2 != 3) {
            this.elementType = null;
        } else {
            this.elementType = u05.getBoxedType();
        }
        this.primitiveScalar = (aVar != a.SCALAR || (ordinal = u05.ordinal()) == 6 || ordinal == 7 || ordinal == 9) ? false : z;
    }

    public static n05 forId(int i) {
        if (i < 0) {
            return null;
        }
        n05[] n05Arr = VALUES;
        if (i >= n05Arr.length) {
            return null;
        }
        return n05Arr[i];
    }

    private static Type getGenericSuperList(Class<?> cls) {
        Type[] genericInterfaces = cls.getGenericInterfaces();
        for (Type type : genericInterfaces) {
            if ((type instanceof ParameterizedType) && List.class.isAssignableFrom((Class) ((ParameterizedType) type).getRawType())) {
                return type;
            }
        }
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType) || !List.class.isAssignableFrom((Class) ((ParameterizedType) genericSuperclass).getRawType())) {
            return null;
        }
        return genericSuperclass;
    }

    private static Type getListParameter(Class<?> cls, Type[] typeArr) {
        boolean z;
        while (true) {
            int i = 0;
            if (cls != List.class) {
                Type genericSuperList = getGenericSuperList(cls);
                if (!(genericSuperList instanceof ParameterizedType)) {
                    typeArr = EMPTY_TYPES;
                    Class<?>[] interfaces = cls.getInterfaces();
                    int length = interfaces.length;
                    while (true) {
                        if (i >= length) {
                            cls = cls.getSuperclass();
                            break;
                        }
                        Class<?> cls2 = interfaces[i];
                        if (List.class.isAssignableFrom(cls2)) {
                            cls = cls2;
                            break;
                        }
                        i++;
                    }
                } else {
                    ParameterizedType parameterizedType = (ParameterizedType) genericSuperList;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    for (int i2 = 0; i2 < actualTypeArguments.length; i2++) {
                        Type type = actualTypeArguments[i2];
                        if (type instanceof TypeVariable) {
                            TypeVariable<Class<?>>[] typeParameters = cls.getTypeParameters();
                            if (typeArr.length == typeParameters.length) {
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= typeParameters.length) {
                                        z = false;
                                        break;
                                    } else if (type == typeParameters[i3]) {
                                        actualTypeArguments[i2] = typeArr[i3];
                                        z = true;
                                        break;
                                    } else {
                                        i3++;
                                    }
                                }
                                if (!z) {
                                    throw new RuntimeException("Unable to find replacement for " + type);
                                }
                            } else {
                                throw new RuntimeException("Type array mismatch");
                            }
                        }
                    }
                    cls = (Class) parameterizedType.getRawType();
                    typeArr = actualTypeArguments;
                }
            } else if (typeArr.length == 1) {
                return typeArr[0];
            } else {
                throw new RuntimeException("Unable to identify parameter type for List<T>");
            }
        }
    }

    private boolean isValidForList(Field field) {
        Class<?> type = field.getType();
        if (!this.javaType.getType().isAssignableFrom(type)) {
            return false;
        }
        Type[] typeArr = EMPTY_TYPES;
        if (field.getGenericType() instanceof ParameterizedType) {
            typeArr = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
        }
        Type listParameter = getListParameter(type, typeArr);
        if (!(listParameter instanceof Class)) {
            return true;
        }
        return this.elementType.isAssignableFrom((Class) listParameter);
    }

    public u05 getJavaType() {
        return this.javaType;
    }

    public int id() {
        return this.id;
    }

    public boolean isList() {
        return this.collection.isList();
    }

    public boolean isMap() {
        return this.collection == a.MAP;
    }

    public boolean isPacked() {
        return a.PACKED_VECTOR.equals(this.collection);
    }

    public boolean isPrimitiveScalar() {
        return this.primitiveScalar;
    }

    public boolean isScalar() {
        return this.collection == a.SCALAR;
    }

    public boolean isValidForField(Field field) {
        if (a.VECTOR.equals(this.collection)) {
            return isValidForList(field);
        }
        return this.javaType.getType().isAssignableFrom(field.getType());
    }
}
