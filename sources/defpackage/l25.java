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
/* renamed from: l25  reason: default package */
/* compiled from: WireFormat */
public enum l25 {
    DOUBLE(m25.DOUBLE, 1),
    FLOAT(m25.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(m25.BOOLEAN, 0),
    STRING(m25.STRING, 2) {
        @Override // defpackage.l25
        public boolean isPackable() {
            return false;
        }
    },
    GROUP(r13, 3) {
        @Override // defpackage.l25
        public boolean isPackable() {
            return false;
        }
    },
    MESSAGE(r13, 2) {
        @Override // defpackage.l25
        public boolean isPackable() {
            return false;
        }
    },
    BYTES(m25.BYTE_STRING, 2) {
        @Override // defpackage.l25
        public boolean isPackable() {
            return false;
        }
    },
    UINT32(r11, 0),
    ENUM(m25.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final m25 javaType;
    private final int wireType;

    /* access modifiers changed from: public */
    static {
        m25 m25 = m25.LONG;
        m25 m252 = m25.INT;
        m25 m253 = m25.MESSAGE;
    }

    public m25 getJavaType() {
        return this.javaType;
    }

    public int getWireType() {
        return this.wireType;
    }

    public boolean isPackable() {
        return true;
    }

    private l25(m25 m25, int i) {
        this.javaType = m25;
        this.wireType = i;
    }
}
