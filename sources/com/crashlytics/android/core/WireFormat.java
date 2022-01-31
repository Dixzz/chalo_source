package com.crashlytics.android.core;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

public final class WireFormat {
    public static final int MESSAGE_SET_ITEM = 1;
    public static final int MESSAGE_SET_ITEM_END_TAG = makeTag(1, 4);
    public static final int MESSAGE_SET_ITEM_TAG = makeTag(1, 3);
    public static final int MESSAGE_SET_MESSAGE = 3;
    public static final int MESSAGE_SET_MESSAGE_TAG = makeTag(3, 2);
    public static final int MESSAGE_SET_TYPE_ID = 2;
    public static final int MESSAGE_SET_TYPE_ID_TAG = makeTag(2, 0);
    public static final int TAG_TYPE_BITS = 3;
    public static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;

    /* JADX WARN: Init of enum INT64 can be incorrect */
    /* JADX WARN: Init of enum UINT64 can be incorrect */
    /* JADX WARN: Init of enum INT32 can be incorrect */
    /* JADX WARN: Init of enum FIXED64 can be incorrect */
    /* JADX WARN: Init of enum FIXED32 can be incorrect */
    /* JADX WARN: Init of enum GROUP can be incorrect */
    /* JADX WARN: Init of enum MESSAGE can be incorrect */
    /* JADX WARN: Init of enum UINT32 can be incorrect */
    /* JADX WARN: Init of enum SFIXED32 can be incorrect */
    /* JADX WARN: Init of enum SFIXED64 can be incorrect */
    /* JADX WARN: Init of enum SINT32 can be incorrect */
    /* JADX WARN: Init of enum SINT64 can be incorrect */
    public enum FieldType {
        DOUBLE(JavaType.DOUBLE, 1),
        FLOAT(JavaType.FLOAT, 5),
        INT64(r5, 0),
        UINT64(r5, 0),
        INT32(r11, 0),
        FIXED64(r5, 1),
        FIXED32(r11, 5),
        BOOL(JavaType.BOOLEAN, 0),
        STRING(JavaType.STRING, 2) {
            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        GROUP(r13, 3) {
            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        MESSAGE(r13, 2) {
            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        BYTES(JavaType.BYTE_STRING, 2) {
            @Override // com.crashlytics.android.core.WireFormat.FieldType
            public boolean isPackable() {
                return false;
            }
        },
        UINT32(r11, 0),
        ENUM(JavaType.ENUM, 0),
        SFIXED32(r11, 5),
        SFIXED64(r5, 1),
        SINT32(r11, 0),
        SINT64(r5, 0);
        
        private final JavaType javaType;
        private final int wireType;

        /* access modifiers changed from: public */
        static {
            JavaType javaType2 = JavaType.LONG;
            JavaType javaType3 = JavaType.INT;
            JavaType javaType4 = JavaType.MESSAGE;
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        private FieldType(JavaType javaType2, int i) {
            this.javaType = javaType2;
            this.wireType = i;
        }
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf((double) FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE)),
        BOOLEAN(Boolean.FALSE),
        STRING(""),
        BYTE_STRING(ByteString.EMPTY),
        ENUM(null),
        MESSAGE(null);
        
        private final Object defaultDefault;

        private JavaType(Object obj) {
            this.defaultDefault = obj;
        }

        public Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    private WireFormat() {
    }

    public static int getTagFieldNumber(int i) {
        return i >>> 3;
    }

    public static int getTagWireType(int i) {
        return i & 7;
    }

    public static int makeTag(int i, int i2) {
        return (i << 3) | i2;
    }
}
