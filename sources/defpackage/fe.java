package defpackage;

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
/* renamed from: fe  reason: default package */
/* compiled from: WireFormat */
public enum fe {
    DOUBLE(ge.DOUBLE, 1),
    FLOAT(ge.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(ge.BOOLEAN, 0),
    STRING(ge.STRING, 2) {
        @Override // defpackage.fe
        public boolean isPackable() {
            return false;
        }
    },
    GROUP(r13, 3) {
        @Override // defpackage.fe
        public boolean isPackable() {
            return false;
        }
    },
    MESSAGE(r13, 2) {
        @Override // defpackage.fe
        public boolean isPackable() {
            return false;
        }
    },
    BYTES(ge.BYTE_STRING, 2) {
        @Override // defpackage.fe
        public boolean isPackable() {
            return false;
        }
    },
    UINT32(r11, 0),
    ENUM(ge.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final ge javaType;
    private final int wireType;

    /* access modifiers changed from: public */
    static {
        ge geVar = ge.LONG;
        ge geVar2 = ge.INT;
        ge geVar3 = ge.MESSAGE;
    }

    public ge getJavaType() {
        return this.javaType;
    }

    public int getWireType() {
        return this.wireType;
    }

    public boolean isPackable() {
        return true;
    }

    private fe(ge geVar, int i) {
        this.javaType = geVar;
        this.wireType = i;
    }
}
