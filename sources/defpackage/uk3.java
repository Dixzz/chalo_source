package defpackage;

/* JADX WARN: Init of enum zzpk can be incorrect */
/* JADX WARN: Init of enum zzpl can be incorrect */
/* JADX WARN: Init of enum zzpm can be incorrect */
/* JADX WARN: Init of enum zzpn can be incorrect */
/* JADX WARN: Init of enum zzpo can be incorrect */
/* JADX WARN: Init of enum zzpr can be incorrect */
/* JADX WARN: Init of enum zzps can be incorrect */
/* JADX WARN: Init of enum zzpu can be incorrect */
/* JADX WARN: Init of enum zzpw can be incorrect */
/* JADX WARN: Init of enum zzpx can be incorrect */
/* JADX WARN: Init of enum zzpy can be incorrect */
/* JADX WARN: Init of enum zzpz can be incorrect */
/* renamed from: uk3  reason: default package */
/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public enum uk3 {
    DOUBLE(bl3.DOUBLE, 1),
    FLOAT(bl3.FLOAT, 5),
    INT64(r5, 0),
    UINT64(r5, 0),
    INT32(r11, 0),
    FIXED64(r5, 1),
    FIXED32(r11, 5),
    BOOL(bl3.BOOLEAN, 0),
    STRING(bl3.STRING, 2) {
    },
    GROUP(r13, 3) {
    },
    MESSAGE(r13, 2) {
    },
    BYTES(bl3.BYTE_STRING, 2) {
    },
    UINT32(r11, 0),
    ENUM(bl3.ENUM, 0),
    SFIXED32(r11, 5),
    SFIXED64(r5, 1),
    SINT32(r11, 0),
    SINT64(r5, 0);
    
    private final bl3 zzqa;
    private final int zzqb;

    /* access modifiers changed from: public */
    static {
        bl3 bl3 = bl3.LONG;
        bl3 bl32 = bl3.INT;
        bl3 bl33 = bl3.MESSAGE;
    }

    private uk3(bl3 bl3, int i) {
        this.zzqa = bl3;
        this.zzqb = i;
    }

    public final bl3 zzdt() {
        return this.zzqa;
    }

    public final int zzdu() {
        return this.zzqb;
    }
}
